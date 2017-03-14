package com.mardomsara.social.play;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mardomsara.social.R;

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


        }
        return super.onOptionsItemSelected(item);
    }
}
