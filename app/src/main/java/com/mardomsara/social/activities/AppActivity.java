package com.mardomsara.social.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mardomsara.social.App;

/**
 * Created by Hamid on 1/27/2016.
 */
public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        App.context = getApplicationContext();
        App.init(getApplicationContext());

    }
}
