package com.mardomsara.social.play;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.app.Singletons;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.base.Http;
import com.mardomsara.social.base.WSCall;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.JsonUtil;
import com.mardomsara.social.json.UserListFollowJson;
import com.mardomsara.social.models.PhoneContactsModel;
import com.mardomsara.social.service.WSService;
import com.mardomsara.social.tables.Task;
import com.mardomsara.social.tables.Task_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mardomsara.social.json.UserListFollowJson.UserListFollow;

//import com.mardomsara.social.json.UserListFollow;
//import com.squareup.okhttp.ws.WebSocket;

public class PlayJson1Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView textJs1;
    TextView btn1;
    TextView btn2;
    TextView btn3;
    TextView fileDl;
    TextView up1;
    TextView ws;
    TextView contacts;
    TextView followings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_json1);

//        HttpBase.setUpQueue(this);

        textJs1 = (TextView) findViewById(R.id.textJs1);
        btn1 = (TextView) findViewById(R.id.btn1);
        btn2 = (TextView) findViewById(R.id.btn2);
        btn3 = (TextView) findViewById(R.id.btn3);
        fileDl = (TextView) findViewById(R.id.fileDl);
        up1 = (TextView) findViewById(R.id.up1);
        ws = (TextView) findViewById(R.id.ws);
        contacts = (TextView) findViewById(R.id.contacts);
        followings = (TextView) findViewById(R.id.followings);

        btn1.setOnClickListener((v)->{
            loadJson1();
        });

        btn2.setOnClickListener((v)->{
            postJson1();
        });

        btn3.setOnClickListener((v)->{
//            postReq1();
            flowDb();
        });

        fileDl.setOnClickListener((v)->{
            downloadFile1();
        });

        up1.setOnClickListener((v)->{
            uploadFile1();
        });

        ws.setOnClickListener((v)->{
            ws1();
        });

        contacts.setOnClickListener((v)->{
            syncContacs();
        });

        followings.setOnClickListener((v)->{
            syncFollowings();
        });
    }

    private void flowDb() {
        for(int i=0;i<50;i++){
            Task t = new Task();
            if(i%2==0) {
                t.setTitle("tit"+i);
                t.setTitle2("tit222__"+i);
                t.setTime(i);
            }
            t.save();
        }
       List<Task> ts = SQLite.select().from(Task.class).where(Task_Table.tid.in(1,2)).queryList();
        AppUtil.log("tasks: "+JsonUtil.toJson(ts));
    }

    private void syncFollowings() {
        Runnable r = () -> {
            PhoneContactsModel.syncAllFollowingsFromServer();
        };
        AppUtil.runInBackgeound(r);
//        SQLite.select().from(Tags4Table.class).where().queryList();
//        SQLite.delete().from(Tags4Table.class).where(Tags4Table_Table.tag.between("1,2"));
        //new Tags4Table();
//        new StringQuery<>(Tags4Table.class);
    }

    private void syncContacs() {
        Runnable r = () -> {
            PhoneContactsModel.syncContactsFromServer();
        };
        AppUtil.runInBackgeound(r);
    }

    private void ws1() {
//        WSReq req = new WSReq();
        WSCall res = new WSCall();
        Command cmd = new Command();
        cmd.Name = "echo";
        cmd.Data = "data";
//        req.Command = "time";
//        req.Commands = new Arr "time";
//        req.RequestId = "" + Math.random();
//        String body = new Gson().toJson(req);
//        WSService.send(body);
        res.Commands = new Command[]{cmd};
        WSService.send( AppUtil.toJson(res) );
//        Intent i = new Intent(this,WSService.class);
//        startService(i);
    }

    private void uploadFile1() {
        new AsyncTask<String ,String, String>(){
            @Override
            protected String doInBackground(String... params) {
                try {
                    Http.Req rq = new Http.Req();
                    rq.file = new File(AppFiles.PUBLIC_ROOT_DIR_PATH+"ddmsrec.mp4");
//                    rq._finalUrl = AppUtil.toUrl("http://192.168.0.10:5000/upload3");
                    rq._finalUrl = AppUtil.toUrl("http://192.168.0.10:5000/upload3");
                    Http.uploadFile(rq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }

            @Override
            protected void onPostExecute(String ks) {
//                textJs1.setText( s.data);
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }

    private void downloadFile1() {
        new AsyncTask<String ,String, String>(){
            UserListFollowJson js;
            Http.Result s;
            @Override
            protected String doInBackground(String... params) {
                try {
                        Map<String,String> pa = new HashMap<String, String>();
                    pa.put("username","atash2174");
                    Http.Req rq = new Http.Req();
                    rq.absPath = "http://localhost:5000/public/avatars/11.jpg";
                    rq.urlParams = pa;
                    s =  Http.download(rq);
    //                String s = Http.simpleGet("http://localhost:5000/followings?username=atash2174");
    ////                js = JsonUtil.<UserListFollow[]>fromJson(s);
    //                Log.e("JSOn",s);
    //                js = JsonUtil.fromJson(s, UserListFollowJson.class);
                    String fn = AppFiles.PROFILE_DIR_PATH + AppFiles.getUserAvatarFileName(4,"ser.jpg");
                    File pf = new File(AppFiles.PROFILE_DIR_PATH);
                    File f = new File(fn);
                    FileOutputStream  fs = new FileOutputStream(fn);
                    pf.mkdirs();
    //                s.response.body().bytes();
                    FileUtils.writeByteArrayToFile(f,s.bytes);
//                    TextUtils.j
                    fs.write(s.bytes);
//                    FileChooserFileUtils.write(f,s.response.body().string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }

            @Override
            protected void onPostExecute(String ks) {
//                textJs1.setText( s.data);
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }

    private void postReq1() {
        new AsyncTask<String ,String, String>(){
            UserListFollowJson js;
            Http.Result s;
            @Override
            protected String doInBackground(String... params) {
                Map<String,String> pa = new HashMap<String, String>();
                pa.put("username","atash2174");
                Http.Req rq = new Http.Req();
                rq.absPath = "http://localhost:5000/followings";
                rq.urlParams = pa;
                s =  Http.get(rq);
//                String s = Http.simpleGet("http://localhost:5000/followings?username=atash2174");
////                js = JsonUtil.<UserListFollow[]>fromJson(s);
//                Log.e("JSOn",s);
//                js = JsonUtil.fromJson(s, UserListFollowJson.class);
                return "";
            }

            @Override
            protected void onPostExecute(String ks) {
                textJs1.setText( s.data);
            }
        }.executeOnExecutor(Singletons.getThreadPool());

    }

    void loadJson1() {

        new AsyncTask<String ,String, String>(){
            UserListFollowJson js;
            @Override
            protected String doInBackground(String... params) {
                String s = Http.simpleGet("http://localhost:5000/followings?username=atash2174");
//                js = JsonUtil.<UserListFollow[]>fromJson(s);
                Log.e("JSOn",s);
                js = JsonUtil.fromJson(s, UserListFollowJson.class);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {

                String ss ="";
                if (js == null){
                    Log.e("JSOn","json is null");
                    return;
                }
                for(UserListFollow u: js.Payload){
                    ss += u.FullName +"\n";
                }
                textJs1.setText(ss);
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }

    void postJson1() {

        new AsyncTask<String ,String, String>(){
            UserListFollowJson js;
            @Override
            protected String doInBackground(String... params) {
                Http.Result s = Http.post("http://localhost:5000/followings?username=atash2174");
                Log.e("JSOn",s.data);
                return "";
            }

            @Override
            protected void onPostExecute(String s) {
//                FileChooserFileUtils.writeLines();
//                com.squareup.okhttp.ws.WebSocket
//                com.squareup.okhttp.ws.WebSocketListener
            }
        }.executeOnExecutor(Singletons.getThreadPool());
    }


//        HttpBase.get("http://localhost:5000/followings?username=atash2174",
//                (js)->{
//
//                    textJs1.setText(js.toString());
//                });

//        HttpBase.get("http://localhost:5000/followings?username=atash2174"
//        HttpBase.get("http://localhost:5000/followings?username=atash2174",
//                new HttpBase.Listener() {
//                    @Override
//                    public void onResponse(Object js) {
//                        UserListFollowJson js2 = (UserListFollowJson)js;
//                        textJs1.setText(js2.Payload.toString());
//                    }
//                }, UserListFollowJson.class);


    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//
//        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play_json1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
