package com.mardomsara.social.ui.presenter.settings;

import android.view.View;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;

/**
 * Created by Hamid on 2/20/2017.
 */

public class SettingsPresenter extends BasePresenter {
	@Override
	public View buildView() {
		X.LinearlayoutMatch x = new X.LinearlayoutMatch();
		Cells.Scroller scroller =new Cells.Scroller();

		Settings.Block bGeneralSettings = new Settings.Block("تنظیمات");
		Settings.Block bBandwidth = new Settings.Block("پهنای باند");
		Settings.Block bMardomsara = new Settings.Block("مردم سرا");

		Settings.Block b1 = new Settings.Block("تنظیمات");
		Settings.Block b2 = new Settings.Block("تنظیمات");
		Settings.Block b3 = new Settings.Block("تنظیمات");
		Settings.Block b4 = new Settings.Block("تنظیمات");

		///////////// General Settings ///////////
		bGeneralSettings.addRow(new Settings.RowPage("وایرایش پروفایل" , ()-> {
			Router.goToProfile(52);
		} ));

		bGeneralSettings.addRow(new Settings.RowPage("افزودن ایمیل" , ()-> {
			Router.goToProfile(53);
		} ));


		///////////// Mardomsara Settings ///////////
		bMardomsara.addRow(new Settings.RowPage("درباره" , ()-> {
			Router.goToProfile(55);
		} ));

		AppUtil.log("Year ==================");
		long t00 = TimeUtil.getTimeMs();
		t00 = t00 - 10*3600000;
		Settings.RowPage date = new Settings.RowPage(FormaterUtil.fullyDayMonthYear(TimeUtil.getTimeMs()) + "  -  " +t00/1000 );
//		Settings.RowPage date = new Settings.RowPage(Rooz.fromTime(t00).getFormatedWithMonthName(" ") );
//		Settings.RowPage date = new Settings.RowPage( FormaterUtil.play_FullyYeraMonthDayNow(t00) + t00/1000);
		bMardomsara.addRow(date);

		AppUtil.log("Year +++++==================");

		//////////////// Play ///////////////////////
		bMardomsara.addRow(new Settings.RowPage("درباره" , ()-> {
			Router.goToProfile(55);
		} ));


		for (long i = -100; i< 100 ; i++){
			long t = TimeUtil.getTimeMs() + (i * 86400000);
			t = t - 10*3600000;
			Settings.RowPage date2 = new Settings.RowPage(FormaterUtil.fullyDayMonthYear(t) + "  -  " + t/1000);
//			Settings.RowPage date2 = new Settings.RowPage(Rooz.fromTime(t).getFormatedWithMonthName(" "));
//			Settings.RowPage date2 = new Settings.RowPage(FormaterUtil.play_FullyYeraMonthDayNow(t) + " - " + t/1000);

			bMardomsara.addRow( date2  );
		}


		//del
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));



		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));

		b3.addRow(new Settings.RowPage("تغییر نام کاربری"));
		b3.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b3.addRow(new Settings.RowPage("تغییر نام کاربری"));
		b3.addRow(new Settings.RowSwitch("تغییر نام کاربری",(c)->{
			Helper.showDebugMessage(""+c);
		}));

		b4.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b4.addRow(new Settings.RowSwitch("تغییر نام کاربری",(c)->{}));


		x.root.addView(bGeneralSettings.getView());
		x.root.addView(bBandwidth.getView());
		x.root.addView(bMardomsara.getView());

		x.root.addView(b2.getView());
		x.root.addView(b3.getView());
		x.root.addView(b4.getView());

		scroller.layout.addView(x.root);
		return scroller.rootView;
	}


}
