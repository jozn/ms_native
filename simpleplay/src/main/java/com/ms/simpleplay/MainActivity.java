package com.ms.simpleplay;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.angads25.filepicker.controller.DialogSelectionListener;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;

import java.io.File;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;

public class MainActivity extends AppCompatActivity {

	private TextView mTextMessage;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
		= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					mTextMessage.setText(R.string.title_home);
					return true;
				case R.id.navigation_dashboard:
					mTextMessage.setText(R.string.title_dashboard);
					return true;
				case R.id.navigation_notifications:
					mTextMessage.setText(R.string.title_notifications);
					return true;

				case R.id.navigation_new:
					mTextMessage.setText("akas;ldaskl; ");
					return true;
			}
			return false;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextMessage = (TextView) findViewById(R.id.message);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		ArrayList<String> filePaths = new ArrayList<>();
		findViewById(R.id.file).setOnClickListener((v) -> {
			FilePickerBuilder.getInstance().setMaxCount(10)
				.setSelectedFiles(filePaths)
				.setActivityTheme(R.style.AppTheme)
//				.pickFile(this);
				.pickPhoto(this);
		});

		findViewById(R.id.file2).setOnClickListener((v) -> {
			FilePickerBuilder.getInstance().setMaxCount(10)
				.setSelectedFiles(filePaths)
				.setActivityTheme(R.style.AppTheme)
				.pickFile(this);

		});

		findViewById(R.id.file3).setOnClickListener((v) -> {
			FilePickerBuilder.getInstance().setMaxCount(10)
				.setSelectedFiles(filePaths)
				.enableSelectAll(true)
				.enableVideoPicker(true)
				.setActivityTheme(R.style.AppTheme)
				.pickFile(this);

		});

		findViewById(R.id.file4).setOnClickListener((v)->{
			DialogProperties properties = new DialogProperties();
			properties.selection_mode = DialogConfigs.SINGLE_MODE;
			properties.selection_type = DialogConfigs.FILE_SELECT;
			properties.root = new File(DialogConfigs.DEFAULT_DIR);
			properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
			properties.offset = new File(DialogConfigs.DEFAULT_DIR);
			properties.extensions = null;

			FilePickerDialog dialog = new FilePickerDialog(MainActivity.this,properties);
			dialog.setTitle("Select a File");

			dialog.setDialogSelectionListener(new DialogSelectionListener() {
				@Override
				public void onSelectedFilePaths(String[] files) {
					//files is the array of the paths of files selected by the Application User.
				}
			});
			dialog.show();
		});

		findViewById(R.id.gallery1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Matisse.from(MainActivity.this)
					.choose(MimeType.ofAll())
					.countable(true)
					.maxSelectable(9)
					.spanCount(4)
//			.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//					.gridExpectedSize()
					.restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
					.thumbnailScale(0.85f)
					.imageEngine(new PicassoEngine())
					.forResult(25);
			}
		});

		findViewById(R.id.gallery2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Matisse.from(MainActivity.this)
					.choose(MimeType.ofAll())
					.countable(false)
					.maxSelectable(9)
					.spanCount(3)
//			.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//					.gridExpectedSize()
					.restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
					.thumbnailScale(0.85f)
					.imageEngine(new PicassoEngine())
					.forResult(25);
			}
		});

		findViewById(R.id.gallery3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Matisse.from(MainActivity.this)
					.choose(MimeType.ofImage())
					.countable(true)
					.maxSelectable(9)
					.spanCount(2)
//			.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//					.gridExpectedSize()
					.restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
					.thumbnailScale(0.85f)
					.imageEngine(new PicassoEngine())
					.forResult(25);
			}
		});

		findViewById(R.id.gallery4).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Matisse.from(MainActivity.this)
					.choose(MimeType.ofVideo())
					.countable(false)
					.maxSelectable(1)
					.spanCount(2)
//			.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//					.gridExpectedSize()
					.restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
					.thumbnailScale(0.85f)
					.imageEngine(new PicassoEngine())
					.forResult(25);
			}
		});





	}

}
