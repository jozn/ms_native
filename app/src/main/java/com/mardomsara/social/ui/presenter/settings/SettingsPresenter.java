package com.mardomsara.social.ui.presenter.settings;

import android.view.View;
import android.widget.FrameLayout;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;
import com.mardomsara.social.ui.views.helpers.ViewHelper;

/**
 * Created by Hamid on 2/20/2017.
 */

public class SettingsPresenter extends BasePresenter {
	@Override
	public View buildView() {
		X.LinearlayoutMatch x = new X.LinearlayoutMatch();
		Cells.Scroller scroller =new Cells.Scroller();

		Settings.Block b1 = new Settings.Block("تنظیمات");
		Settings.Block b2 = new Settings.Block("تنظیمات");
		Settings.Block b3 = new Settings.Block("تنظیمات");
		Settings.Block b4 = new Settings.Block("تنظیمات");

		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b1.addRow(new Settings.SimpleRow("تغییر نام کاربری"));


		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b2.addRow(new Settings.SimpleRow("تغییر نام کاربری"));

		b3.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b3.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b3.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b3.addRow(new Settings.SimpleRow("تغییر نام کاربری"));

		b4.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b4.addRow(new Settings.SimpleRow("تغییر نام کاربری"));
		b4.addRow(new Settings.SimpleRow("تغییر نام کاربری"));

		x.root.addView(b1.getView());
		x.root.addView(b2.getView());
		x.root.addView(b3.getView());
		x.root.addView(b4.getView());

		scroller.layout.addView(x.root);
		return scroller.rootView;
	}
}
