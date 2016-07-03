package com.mardomsara.social.play;

import android.app.Activity;
import android.os.Bundle;

import com.mardomsara.social.R;

public class FragmentsPlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_play);

//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft= fm.beginTransaction();
//        Play1Fragment f1 =  new Play1Fragment();
//        ReactFragment f2 =  new ReactFragment();
//        ft.add(R.id.frag1,f1,"my frag1");
//        ft.add(R.id.frag3,f2,"my frag22");
//        ft.addToBackStack("sad");
//        ft.commit();
//
//        Button btn = (Button) findViewById(R.id.btn2);
//        btn.setOnClickListener((v) -> {
//            ((Button) v).setText("dyn");
//            FragmentManager fm2 = getFragmentManager();
//            FragmentTransaction ft2= fm.beginTransaction();
////            Play1Fragment f4 =  new Play1Fragment();
//            ReactFragment f4 =  new ReactFragment();
//            ft2.add(R.id.frag1, f4, null);
////            ft2.replace(R.id.frag1, f4, null);
////            ft2.addToBackStack(null);
//
//            ft2.commit();
//        });
    }

    @Override
    public void onBackPressed() {
        if(!getFragmentManager().popBackStackImmediate()){
            super.onBackPressed();

        }
//        getFragmentManager().popBackStack();
//        getFragmentManager().
    }
}
