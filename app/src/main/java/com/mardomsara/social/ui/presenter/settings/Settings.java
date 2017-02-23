package com.mardomsara.social.ui.presenter.settings;

import android.support.annotation.NonNull;
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

	public static class RowSwitch implements SettingRow{
		X.Settings_RowSimple x = new X.Settings_RowSimple();
		String title;

		@Deprecated
		public RowSwitch(String title) {
			this.title = title;
			x.switch_btn.setVisibility(View.VISIBLE);
		}

		public RowSwitch(String title, @NonNull SwitchListener listener) {
			this.title = title;
			x.switch_btn.setVisibility(View.VISIBLE);

			x.root.setOnClickListener((v)->{
				boolean oldVal = x.switch_btn.isChecked();
				boolean newBoolVal = !oldVal;
				x.switch_btn.setChecked(newBoolVal);
				listener.onChange((newBoolVal));
			});
		}

		public View getView(){
			x.title.setText(title);
			return x.root;
		}
	}

	public static class RowPage implements SettingRow{
		X.Settings_RowSimple x = new X.Settings_RowSimple();
		String title;

		@Deprecated
		public RowPage(String title) {
			this.title = title;
			x.has_page.setVisibility(View.VISIBLE);
		}

		public RowPage(String title, @NonNull Runnable runnable) {
			this.title = title;
			x.has_page.setVisibility(View.VISIBLE);

			x.root.setOnClickListener((v)->{
				runnable.run();
			});
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

	public interface SwitchListener {
		void onChange(boolean value);
	}

}
