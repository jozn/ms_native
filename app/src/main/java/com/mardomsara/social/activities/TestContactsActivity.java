package com.mardomsara.social.activities;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.mardomsara.social.R;
import com.mardomsara.social.models.DevicePhoneContact;

import java.util.ArrayList;

public class TestContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView txt = (TextView) findViewById(R.id.txt);
        ArrayList<DevicePhoneContact.Row> al = getNumber2(getContentResolver());
//        txt.setText(getNumber2(getContentResolver()));
        GsonBuilder builder = new GsonBuilder();
       final String jss = builder.setPrettyPrinting().create().toJson(al);
        txt.setText(jss);


//        Request r = new   StringRequest(Request.Method.POST, "http://192.168.0.10:5000/upload1",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(TestContactsActivity.this, response, Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(TestContactsActivity.this,error.toString(),Toast.LENGTH_LONG).show();
//                    }
//                }){
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("data2",jss);
////                params.put(KEY_PASSWORD,password);
////                params.put(KEY_EMAIL, email);
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(r);
//
    }

    public ArrayList<DevicePhoneContact.Row> getNumber2(ContentResolver cr) {
        StringBuffer sb = new StringBuffer();
        ArrayList<DevicePhoneContact.Row> al = new ArrayList<>();
        Cursor managedCursor = cr
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{Phone.RAW_CONTACT_ID,
                                Phone.DISPLAY_NAME_PRIMARY,
                                Phone.DISPLAY_NAME_ALTERNATIVE,
                                Phone.NUMBER,
                                Phone.NORMALIZED_NUMBER
                        },
                        null, null, Phone.DISPLAY_NAME_PRIMARY + " ASC");

        while (managedCursor.moveToNext()){
            String id =  managedCursor.getString(managedCursor.getColumnIndex(Phone.RAW_CONTACT_ID));
            DevicePhoneContact.Row pc = new DevicePhoneContact.Row();
            pc.PhoneDisplayName = managedCursor.getString(managedCursor.getColumnIndex(Phone.DISPLAY_NAME_PRIMARY));
            pc.PhoneFamilyName = managedCursor.getString(managedCursor.getColumnIndex(Phone.DISPLAY_NAME_ALTERNATIVE));
            pc.PhoneNumber =managedCursor.getString(managedCursor.getColumnIndex(Phone.NUMBER));
            pc.PhoneNormalizedNumber= managedCursor.getString(managedCursor.getColumnIndex(Phone.NORMALIZED_NUMBER));
            pc.PhoneContactRowId = Integer.decode(id);
            al.add(pc);
        }
        managedCursor.close();
        return al;

    }

}
