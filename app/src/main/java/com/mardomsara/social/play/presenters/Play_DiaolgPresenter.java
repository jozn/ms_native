package com.mardomsara.social.play.presenters;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.cells.Cells;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

/**
 * Created by Hamid on 10/1/2016.
 */
public class Play_DiaolgPresenter extends FragmentPage {
	@Override
	public View getView(Bundle savedInstanceState) {
		Cells.Scroller cell =new Cells.Scroller();
		ViewGroup rootView =cell.rootView;
		ViewGroup layout =cell.layout;

		layout.addView(newTitle("play: alertViewWithListner22 ",()->{
			p1();
		}));

		layout.addView(newTitle("play: alertView ",()->{
			p2();
		}));

		layout.addView(newTitle("play: simpleAlert ",()->{
			p3();
		}));

		layout.addView(newTitle("play: simpleAlert2 (just in play code_) ",()->{
			simpleAlert2(AppUtil.getContext(),"Hi ttitle", "sample body");
		}));


		layout.addView(newTitle("(nothing)",()->{
//			PlayNewPipe.run1();
		}));


		return rootView;
	}

	private void p1() {
		alertViewWithListner22(AppUtil.getContext());
	}

	private void p2() {
		DialogHelper.alertView(AppUtil.inflate(R.layout.hello_world_row));
	}

	private void p3() {
		DialogHelper.simpleAlert("Hi ttitle", "sample body");
	}

	View newTitle(String title, Runnable runnable){
		ViewGroup view = new Cells.Title_BigClickAble(null,title).rootView;
		view.setOnClickListener((v)->{
			runnable.run();
		});
		int p = AndroidUtil.dpToPx(10);
		view.setPadding(0,p,p,p);
		return view;
	}

	public static DialogPlus alertViewWithListner22(Context ctx) {
//        UserRowViewHolder vh = new UserRowViewHolder(v);
		ArrayAdapter adapter = new ArrayAdapter(ctx, R.layout.contacts_followings_list__row_unregistered_contact);
		adapter.addAll(new String[]{"Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj","Ass", "dff", "Hjj",});

		DialogPlus dialog = DialogPlus.newDialog(ctx)
			.setAdapter(adapter)
			.setExpanded(true)

			.create();
		dialog.show();
		return dialog;
	}


	//TODO: remove
	//deprectaed
	public static void simpleAlert2(Context ctx, String title, String body){
		LayoutInflater inf = LayoutInflater.from(ctx);
		TextView vTitle = (TextView) inf.inflate(R.layout.dialog__simple_title, null);
		TextView vBody = (TextView) inf.inflate(R.layout.dialog__simple_body, null);
		TextView vClose = (TextView) inf.inflate(R.layout.dialog__simple_close, null);
		vTitle.setText(title);
		vBody.setText(body);
		vClose.setText("بستن");

		ViewHolder vh = new ViewHolder(vBody);
		final DialogPlus dialog = DialogPlus.newDialog(ctx)
			.setContentHolder(vh)
			.setHeader(vTitle)
			.setFooter(vClose)
			.setFooter(R.layout.fragment_footer_bar)
//                .setExpanded(false, 120)  // This will enable the expand feature, (similar to android L share dialog)
			.setGravity(Gravity.CENTER)
			.setMargin(10, 10, 10, 10)
			.setPadding(20, 20, 20, 20)
			.create();

		dialog.show();
//        new DialogPlusBuilder(ctx).setOrReplace
//        vClose.setOnClickListener(v-> dialog.dismiss());
		vClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}



}
