package com.mardomsara.social.models;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.mardomsara.social.App;
import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.base.FNV;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.json.UserListJson;
import com.mardomsara.social.json.UserRow;
import com.mardomsara.social.tables.ContactsCopyTable;
import com.mardomsara.social.tables.UsersTable;
import com.mardomsara.social.tables.UsersTable_Table;
import com.orhanobut.hawk.Hawk;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

/**
 * Created by Hamid on 7/2/2016.
 */
public class DevicePhoneContact {

    private static int REFETCH_INTERVAL = 8;//86400

    //statics methods

    public static List<Row> fetchAllContacts(){
        //        StringBuffer sb = new StringBuffer();
        Context ctx = App.context;
        List<Row> al = new ArrayList<>();
        Cursor managedCursor = ctx.getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID,
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY,
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                                ContactsContract.CommonDataKinds.Phone.NUMBER,
                                ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER
                        },
                        null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY + " ASC");

        while (managedCursor.moveToNext()){
            String id =  managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID));
            Row pc = new Row();
            pc.PhoneDisplayName = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
            pc.PhoneFamilyName = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
            pc.PhoneNumber =managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            pc.PhoneNormalizedNumber= managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER));
            pc.PhoneContactRowId = Integer.decode(id);
            al.add(pc);
        }
        managedCursor.close();
        return al;
    }


    public static void checKforSync(){
        long lastSyncedTime = Hawk.<Long>get(Config.SYNC_CONTACTS_REFETCHED_FROM_DEVICE_LAST_TIME,0l);
        if(lastSyncedTime +REFETCH_INTERVAL < TimeUtil.getTime()){
            askPremisionsForDoResync();
        }

        //this is nessory in case of offline or server down
       Boolean toPush = Hawk.<Boolean>get(Config.SYNC_CONTACTS_TO_PUSH_SERVER,false);
        if(toPush){
            uploadContacs();
        }
    }

    private static void askPremisionsForDoResync() {
        PermissionCallback callback = new PermissionCallback(){

            @Override
            public void permissionGranted() {
                AppUtil.log("permissionGranted() callback");
                doActualResync();
            }

            @Override
            public void permissionRefused() {
                AppUtil.log("permissionRefused() callback");

            }
        };

        Nammu.askForPermission(App.getActivity(), Manifest.permission.READ_CONTACTS,callback);
    }

    private static void doActualResync() {
        List<Row> rows = fetchAllContacts();
        List<ContactsCopyTable> copyTableList= ContactsCopyTable.loadAll();
        if(rows == null) {
            ContactsCopyTable.empty();
            return;
        }

        for(Row row: rows){
            row.Hash = FNV.fnv1a_32(row.toStringForHash().getBytes()).toString();
        }
        if(copyTableList != null){
            Map<String, Row> mapNew = LangUtil.listToHashMap(rows,(row)-> row.Hash);
            Map<String, Row> mapStoredCopy = LangUtil.listToHashMap(copyTableList,(row)-> row.Hash);

            for(Row row: rows){
                if(!mapStoredCopy.containsKey(row.Hash)){
                    //data has changed -- perform a full insert
                    performFullInsertOfContacts(rows);
                    break;
                }
            }
        }
        else {
            performFullInsertOfContacts(rows);
        }
        Hawk.put(Config.SYNC_CONTACTS_REFETCHED_FROM_DEVICE_LAST_TIME,TimeUtil.getTime());
    }

    //todo: perform saving in transaction
    private static void performFullInsertOfContacts(List<Row> rows) {
        SQLite.delete().from(ContactsCopyTable.class).execute();
        for (Row row : rows){
            ContactsCopyTable copy = new ContactsCopyTable();
            copy.PhoneNumber = row.PhoneNumber;
            copy.PhoneContactRowId = row.PhoneContactRowId;
            copy.PhoneFamilyName = row.PhoneFamilyName;
            copy.PhoneNormalizedNumber = row.PhoneNormalizedNumber;
            copy.PhoneDisplayName = row.PhoneDisplayName;
            copy.Hash = row.Hash;

            copy.save();
        }
        uploadContacs();
    }

    public static void uploadContacs(){
        try {
            List<ContactsCopyTable> contacts = ContactsCopyTable.loadAll();
            Http.Req rq = new Http.Req();
            rq.form.put("contacts", AppUtil.toJson(contacts));
            rq.absPath = API.CONTACTS_SYNC_ALL.toString();
            Http.Result res = Http.masterSendPost(rq);
            AppUtil.log("http result of syncContactsFromServer() :" +res.data);
            if(res.ok == false) {
                AppUtil.error("http result of syncContactsFromServer() is failed");
                Hawk.put(Config.SYNC_CONTACTS_TO_PUSH_SERVER,true);
                return;
            }
            UserListJson r = JsonUtil.fromJson(res.data, UserListJson.class);
//        DialogHelper.simpleAlert(App.context,"hhhh",r.Payload.get(1).FullName );
            saveContacts(r.Payload);
        }catch (Exception e){
            AppUtil.log(e.toString());
            Hawk.put(Config.SYNC_CONTACTS_TO_PUSH_SERVER,true);
        }
        Hawk.put(Config.SYNC_CONTACTS_TO_PUSH_SERVER,false);
    }

    private static void saveContacts(List<UserRow> users){
        Map<String,DevicePhoneContact.Row> map = getMapOfContacts();
        AppUtil.log(map.toString());
        DevicePhoneContact.Row contact;
        //// TODO: 4/4/2016 do in transactions for maximim speed

        int[] ids_int = new int[users.size()];
        List<Integer> ids = new ArrayList<>();
        int i = 0;
        for (UserRow user: users) {
            ids.add(user.Id);
            ids_int[i] = user.Id;
            i++;
        }

        SQLite.delete().from(UsersTable.class).where(UsersTable_Table.UserId.in(ids_int[0],ids_int)).execute();

        for (UserRow user: users){
            contact = map.get(user.Phone);
            AppUtil.log("Building Contacts For "+contact.PhoneNormalizedNumber);
            UsersTable c = new UsersTable();
//            c.setIsPhoneContact(1);
            c.setPhoneNumber(contact.PhoneNumber);
            c.setPhoneNormalizedNumber(contact.PhoneNormalizedNumber);
            c.setPhoneDisplayName(contact.PhoneDisplayName);
            c.setPhoneFamilyName(contact.PhoneFamilyName);
            c.setPhoneContactRowId(contact.PhoneContactRowId);

            c.setIsPhoneContact(1);//true
//            _setUserTableFieldsFromJson(user,c);
            user.setUserTableParams(c);

            AppUtil.log("presisiting Contacts" + c.toString());
            c.save();
        }
    }

    private static void _setUserTableFieldsFromJson(UserRow user, UsersTable tableRaw){
        tableRaw.setUserId(user.Id);
//            c.setId(user.Id);// the same of setUserId() -- SquidDb limitions
        tableRaw.setIsFollowing(user.FollowingType);//
        tableRaw.setFirstName(user.FirstName);
        tableRaw.setLastName(user.LastName);
//        tableRaw.setFullName(user.FullName);
        tableRaw.setUserName(user.UserName);
        tableRaw.setAvatarUrl(user.AvatarUrl);
        tableRaw.setUpdateTimestamp(user.UpdatedTimestamp);
    }

    public static Map<String,DevicePhoneContact.Row> getMapOfContacts(){
        List<DevicePhoneContact.Row> cs = fetchAllContacts();
        Map<String,DevicePhoneContact.Row> map = new HashMap<>();
        for (DevicePhoneContact.Row row : cs){
            map.put(row.PhoneNormalizedNumber, row);
        }
        return map;
    }


    /**
     * Created by Hamid on 7/2/2016.
     */
    public static class Row {

        //fields
        public String PhoneNumber;//0935... +98910711..
        public String PhoneNormalizedNumber;
        public String PhoneDisplayName;
        public String PhoneFamilyName;
        public int PhoneContactRowId;

        public String Hash;

        public String toStringForHash(){
            return ""+PhoneNumber+ PhoneNormalizedNumber + PhoneDisplayName + PhoneFamilyName+ PhoneContactRowId;
        }
    }
}
