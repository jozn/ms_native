package com.mardomsara.social.play;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.activities.HttpActivity;
import com.mardomsara.social.activities.KybordActivity;
import com.mardomsara.social.activities.Main2Activity;
import com.mardomsara.social.activities.TestContactsActivity;
import com.mardomsara.social.activities.TestWebSocketActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlayAdvanced extends AppCompatActivity {
    @Bind(R.id.output) TextView output_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_advanced);
        ButterKnife.bind(this);
        showFileDires();

        openOptionsMenu();

    }

    void showFileDires(){
        String p ="";
        p += "Environment.DIRECTORY_MUSIC: " + Environment.DIRECTORY_MUSIC + "\n\n";
        p += "Environment.getExternalStorageState() : " + Environment.getExternalStorageState() + "\n\n";
        p += "Environment.getRootDirectory().getPath() : " + Environment.getRootDirectory().getAbsolutePath() + "\n\n";
        p += "Environment.getDataDirectory().getPath() : " + Environment.getDataDirectory().getAbsolutePath() + "\n\n";
        p += "Environment.getExternalStorageDirectory().getPath() : " + Environment.getExternalStorageDirectory().getAbsolutePath() + "\n\n";
        p += "Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() : " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "\n\n";

        output_text.setText(p);
    }

    @Override
    protected void onResume() {
        super.onResume();
        openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent its;
        switch (item.getItemId()){
            case R.id.websocket:
                Intent it = new Intent(this,TestWebSocketActivity.class);
                startActivity(it);
                break;
            case R.id.contacts:
                Intent it2 = new Intent(this,TestContactsActivity.class);
                startActivity(it2);
                break;
            case R.id.http:
                Intent it3 = new Intent(this,HttpActivity.class);
                startActivity(it3);
                break;
            case R.id.font:
                Intent it4 = new Intent(this,FontsScrollingActivity.class);
                startActivity(it4);
                break;
            case R.id.json1:
                its = new Intent(this,PlayJson1Activity.class);
                startActivity(its);
                break;
            /*case R.id.fact1:
                its = new Intent(this,FactActivity.class);
                startActivity(its);
                break;*/
//            case R.id.rooms:
//                its = new Intent(this,ChatListActivity.class);
//                startActivity(its);
//                break;
            case R.id.react1:
//                its = new Intent(this,React1Activity.class);
//                startActivity(its);
                break;
            case R.id.frag1:
                its = new Intent(this,FragmentsPlayActivity.class);
                startActivity(its);
                break;

            case R.id.binding:
                its = new Intent(this,DataBinding.class);
                startActivity(its);
                break;

            case R.id.ok2:
                its = new Intent(this,Okhttp2Activity.class);
                startActivity(its);
                break;

            case R.id.advanced:
                its = new Intent(this,PlayAdvanced.class);
                startActivity(its);
                break;
            case R.id.keybord1:
                its = new Intent(this,KybordActivity.class);
                startActivity(its);
                break;
            case R.id.emoji:
                its = new Intent(this,Main2Activity.class);
                startActivity(its);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
