package com.mardomsara.social.nav.del;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mardomsara.social.R;
import com.mardomsara.social.nav.Nav;

import java.util.Date;

public class NavNewActivity extends AppCompatActivity {
	static Date d = new Date();
	TextView textView;
	ViewGroup root;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*root = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_new, null);
		setContentView(R.layout.activity_new);
		textView = findViewById(R.id.button);
		Log.d("XXX", "sa");
		if (savedInstanceState != null) {
			textView.setText(savedInstanceState.getString("K"));
		}

		AppState.getInstance().mainActivity = this;
		AppState.getInstance().rootView = root;

		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//add(NavNewActivity.this);
//				Nav.goToBranch(BranchEnum.Home);
				Nav.push(new NewPage());
//				Nav.push(new HomeBranch());
			}
		});

		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				startActivity(new Intent(getBaseContext(), Nav4Activity.class));
				Nav.hideFooter();
			}
		});

		Nav.setUpDef();*/

	}

	@Override
	public void onBackPressed() {
		if(!Nav.onBackPressed()){
			finishAfterTransition();
//			super.onBackPressed();
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
//		Nav.goToBranch(BranchEnum.Search);
//		Nav.setUpDef(this, R.id.footerbar_holder, root);
//		Nav.setUpDef();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("K", "klkiop" + d);
	}
}
