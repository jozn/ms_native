package com.mardomsara.social.ui.presenter.settings;

import android.view.View;

import com.mardomsara.social.Nav;
import com.mardomsara.social.app.AppFiles;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.TimeUtil;
import com.mardomsara.social.models.stores.SharedStore;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.Cells;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 2/20/2017.
 */

public class SettingsPresenter extends BasePresenter {
	@Override
	public View buildView() {
		X.LinearlayoutMatch x = new X.LinearlayoutMatch();
		Cells.Scroller scroller =new Cells.Scroller();

		Settings.Block bGeneralSettings = new Settings.Block("تنظیمات");
		Settings.Block bBandwidth = new Settings.Block("دانلود خودکار فایل ها");
		Settings.Block bMardomsara = new Settings.Block("مردم سرا");
		Settings.Block bFooter = new Settings.BlockTransparent();

		///////////// General Settings ///////////
		bGeneralSettings.addRow(new Settings.RowPage("وایرایش پروفایل" , ()-> {
			Nav.push(new EditProfilePresenter());
		} ));

		bGeneralSettings.addRow(new Settings.RowPage("ایمیل" , ()-> {
			Nav.push(new EditEmailPresenter());
		} ));

		bGeneralSettings.addRow(new Settings.RowPage("شماره تلفن همراه" , ()-> {
			Nav.push(new EditPhonePresenter());
		} ));


		///////////// Network Bandwidth ////////////
		bBandwidth.addRow(new Settings.RowSimple("هنگام استفاده از Wi-Fi" , ()-> {
			showWifiDlMenu();
		} ));

		bBandwidth.addRow(new Settings.RowSimple("هنگام استفاده از دیتا موبایل (2G, 3G, 4G)" , ()-> {
			showCellularDlMenu();
		} ));

		boolean showGallery = SharedStore.getSetingStore().getShowMediasInGallery();
		bBandwidth.addRow(new Settings.RowSwitch("نمایش عکس ها و ویدیو ها در گالری دستگاه" , showGallery ,(boolVal)-> {
			SharedStore.getSetingStore().setShowMediasInGallery(boolVal);
			AppFiles.changedNomediaSetings();
		} ));


		///////////// Mardomsara Settings ///////////
		bMardomsara.addRow(new Settings.RowPage("درباره" , ()-> {
			Nav.push(new AboutMardomsaraPresenter());
		} ));


		//////////// Transparent Block //////////////
		String dateS = FormaterUtil.fullyDayMonthYear(TimeUtil.getTimeMs());
		dateS = "تاریخ امروز: " + dateS;
		Settings.RowTransparentCenter date = new Settings.RowTransparentCenter(dateS, null );
		bFooter.addRow(date);


		//============== Add blocks to view =============//
		x.root.addView(bGeneralSettings.getView());
		x.root.addView(bBandwidth.getView());
		x.root.addView(bMardomsara.getView());

		x.root.addView(bFooter.getView());

		scroller.layout.addView(x.root);
		return scroller.rootView;
	}

	static void showWifiDlMenu(){
		List<DialogHelper.CheckBoxItem> list = new ArrayList<>();

		SharedStore.SettingsStore store = SharedStore.getSetingStore();
		list.add(new DialogHelper.CheckBoxItem("عکس",store.getAutoDlWifiImage() ,(val)->{
			store.setAutoDlWifiImage(val);
		}));

		list.add(new DialogHelper.CheckBoxItem("ویدیو", store.getAutoDlWifiVideo(),(val)->{
			store.setAutoDlWifiVideo(val);
		}));

		list.add(new DialogHelper.CheckBoxItem("فایل", store.getAutoDlWifiFile(),(val)->{
			store.setAutoDlWifiFile(val);
		}));

		DialogHelper.showSimpleCheckBoxMenu(list);
	}

	static void showCellularDlMenu(){
		List<DialogHelper.CheckBoxItem> list = new ArrayList<>();

		SharedStore.SettingsStore store = SharedStore.getSetingStore();
		list.add(new DialogHelper.CheckBoxItem("عکس",store.getAutoDlCellularImage() ,(val)->{
			store.setAutoDlCellularImage(val);
		}));

		list.add(new DialogHelper.CheckBoxItem("ویدیو", store.getAutoDlCellularVideo(),(val)->{
			store.setAutoDlCellularVideo(val);
		}));

		list.add(new DialogHelper.CheckBoxItem("فایل", store.getAutoDlCellularFile(),(val)->{
			store.setAutoDlCellularFile(val);
		}));

		DialogHelper.showSimpleCheckBoxMenu(list);
	}


}
