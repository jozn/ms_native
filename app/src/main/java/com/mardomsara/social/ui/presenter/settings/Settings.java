package com.mardomsara.social.ui.presenter.settings;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.X;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 2/20/2017.
 */

public class Settings {

	public static class Block {
		private List<SettingRow> rowsList = new ArrayList<>();
		private String title;
		X.Settings_Block x = new X.Settings_Block();

		public Block(String title) {
			this.title = title;
		}

		public void addRow(SettingRow row){
			rowsList.add(row);
		}

		public ViewGroup getView(){
			x.title.setText(title);
			for (SettingRow row : rowsList){
				x.rows_container.addView(row.getView());
			}
			return x.root;
		}
	}

	public static class SimpleRow implements SettingRow{
		X.Settings_RowSimple x = new X.Settings_RowSimple();
		String title;

		public SimpleRow(String title) {
			this.title = title;
		}

		public View getView(){
			x.title.setText(title);
			return x.root;
		}
	}

	public static class CheckboxRowRow implements SettingRow{
		public View getView(){
			return null;
		}
	}

	interface SettingRow {
		public View getView();
	}
}
