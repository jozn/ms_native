package com.mardomsara.social.models;

import com.mardomsara.social.app.API;
import com.mardomsara.social.app.Config;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.helpers.LangUtil;
import com.mardomsara.social.json.SyncFollowings;
import com.mardomsara.social.json.UserListJson;
import com.mardomsara.social.json.UserRow;
import com.mardomsara.social.tables.UsersTable;
import com.mardomsara.social.tables.UsersTable_Table;
import com.orhanobut.hawk.Hawk;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneContactsModel {

    public static void syncContactsFromServer(){

        try {
            List<DevicePhoneContact.Row> cs = fetchAllContacts();
            Http.Req rq = new Http.Req();
            rq.form.put("contacts", AppUtil.toJson(cs));
            rq.absPath = API.CONTACTS_SYNC_ALL.toString();
            Http.Result res = Http.masterSendPost(rq);
            AppUtil.log("http result of syncContactsFromServer() :" +res.data);
            if(res.ok == false) {
                AppUtil.error("http result of syncContactsFromServer() is failed");
                return;
            }
            UserListJson r =JsonUtil.fromJson(res.data, UserListJson.class);
//        DialogHelper.simpleAlert(App.context,"hhhh",r.Payload.get(1).FullName );
            saveContacts(r.Payload);
        }catch (Exception e){
            AppUtil.log(e.toString());
        }

    }

    public static void syncAllFollowingsFromServer(){
        try {
            Http.Req rq = new Http.Req();
            rq.absPath = API.FOLLOWINGS_SYNC_ALL.toString();
            rq.urlParams.put("last", ""+Hawk.<Integer>get(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP,0));
            Http.Result res = Http.masterSendPost(rq);
            AppUtil.log("http result of syncAllFollowingsFromServer() :" +res.data);
            if(res.ok == false) {
                AppUtil.error("http result of syncAllFollowingsFromServer() is failed");
                return;
            }
            SyncFollowings r = JsonUtil.fromJson(res.data, SyncFollowings.class);
            removeFollowings(r.Payload.Remove);
            saveFollowings(r.Payload.Add);
            Hawk.put(Config.SYNC_DIFF_FOLLOWINGS_LAST_TIMESTAMP, r.ServerTime);

        }catch (Exception e){
            AppUtil.log(e.toString());
        }
    }

    public static void removeFollowings(List<Integer> ids){
//        AppDatabase appDb = DBSingletons.getAppDataBase();
//        String q = "delete from contacts where UserId in("+ DbUtil.ToSqlIn(ids) +") and IsPhoneContact = 0";
        AppUtil.log("deleteing Contacts: for refresh: ");
        Integer[] ins = new Integer[ids.size()] ;
        int[] in2 = new int[ids.size()] ;
        for (int i =0;i<ids.size();i++){
            in2[i] = (int)ids.get(i);
        }
        ins = ids.toArray(ins);

        SQLite.delete().from(UsersTable.class).where(UsersTable_Table.UserId.in( -1,in2  )).execute();
//        appDb.rawQuery(q, new Object[]{});
    }
    public static void saveFollowings(List<UserRow> users){

        for (UserRow user: users){
            UsersTable c = new UsersTable();
            c.setIsPhoneContact(0);//
            _setUserTableFieldsFromJson(user,c);
            AppUtil.log("persisting following" + c.toString());
            c.save();

        }
    }


    public static void saveContacts(List<UserRow> users){

//        AppDatabase appDb = DBSingletons.getAppDataBase();
        Map<String,DevicePhoneContact.Row> map = getMapOfContacts();
        AppUtil.log(map.toString());
        DevicePhoneContact.Row contact;
        //// TODO: 4/4/2016 do in transactions for maximim speed

//        appDb.delete(Delete.from(UsersTable.TABLE).)
        int[] ids_int = new int[users.size()];
        List<Integer> ids = new ArrayList<>();
        int i = 0;
        for (UserRow user: users) {
            ids.add(user.Id);
            ids_int[i] = user.Id;
            i++;
        }

//        int[] ids_int = ids.toArray();

        String q = "delete from contacts where UserId in("+ StringUtils.join(ids.iterator(),",") +")";
        AppUtil.log("deleting Contacts: for refresh: "+q);
//        appDb.rawQuery(q, new Object[]{});
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
            _setUserTableFieldsFromJson(user,c);

            AppUtil.log("presisiting Contacts" + c.toString());
//            appDb.persistWithOnConflict(c, TableStatement.ConflictAlgorithm.REPLACE);
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
        tableRaw.setAvatarUrl(user.AvatarSrc);
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
    public static List<DevicePhoneContact.Row> fetchAllContacts(){
        return DevicePhoneContact.fetchAllContacts();
/*//        StringBuffer sb = new StringBuffer();
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
        return al;*/
    }

    public static List<UsersTable> getAllFollowings() {
        String q = SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.FollowingType.eq(1)).toString();
        AppUtil.log("Queru getAllFollowings" + q);

        return SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.FollowingType.eq(1)).queryList();
    }

    public static List<UsersTable> getAllRegisteredContacts() {
        String q = SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.IsPhoneContact.eq(1)).toString();
        AppUtil.log("Queru getAllFollowings" + q);

        return SQLite.select().from(UsersTable.class).
                where(UsersTable_Table.IsPhoneContact.eq(1)).queryList();
    }

    public static List<DevicePhoneContact.Row> getAllContactssAndUsersOrNot(List<UsersTable> listOfRegisterd) {
        List<DevicePhoneContact.Row> contacts = fetchAllContacts();
        List<DevicePhoneContact.Row> res = new ArrayList<>();
        Map<String,UsersTable> map =LangUtil.listToHashMap(listOfRegisterd,(user)-> { return user.getPhoneNormalizedNumber(); });
        for(DevicePhoneContact.Row contact : contacts){
            if(!map.containsKey(contact.PhoneNormalizedNumber)){
                res.add(contact);
            }
        }
        return res;
    }
}

