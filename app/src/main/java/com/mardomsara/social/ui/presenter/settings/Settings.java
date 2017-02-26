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

	///////////////////// Blocks //////////////////////
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

	public static class BlockTransparent extends Block{
		public BlockTransparent() {
			super("");
			x.title.setVisibility(View.GONE);
		}
	}

	//////////////////// Rows ////////////////////////

	public static class RowSimple implements SettingRow{
		X.Settings_RowSimple x = new X.Settings_RowSimple();
		String title = "";

		public RowSimple(String title) {
			this.title = title;
		}

		public RowSimple(String title, Runnable runnable) {
			this.title = title;
			x.root.setOnClickListener((v)->{
				if(runnable != null) runnable.run();
			});
		}

		public View getView(){
			x.title.setText(title);
			return x.root;
		}
	}

	public static class RowSwitch extends RowSimple{
		public RowSwitch(String title,boolean isChececkd, @NonNull SwitchListener listener) {
			super(title);
//			this.title = title;
			x.switch_btn.setVisibility(View.VISIBLE);
			x.switch_btn.setChecked(isChececkd);
			x.root.setOnClickListener((v)->{
				boolean oldVal = x.switch_btn.isChecked();
				boolean newBoolVal = !oldVal;
				x.switch_btn.setChecked(newBoolVal);
				if(listener != null) listener.onChange((newBoolVal));
			});
		}
	}

	public static class RowPage extends RowSimple{

		public RowPage(String title, @NonNull Runnable runnable) {
			super(title);
			x.has_page.setVisibility(View.VISIBLE);

			x.root.setOnClickListener((v)->{
				if(runnable != null) runnable.run();
			});
		}
	}

	public static class RowTransparentCenter implements SettingRow{
		X.Settings_RowNoteCenter x = new X.Settings_RowNoteCenter();
		public RowTransparentCenter(String title ,Runnable runnable) {
			x.title.setText(title);
			x.root.setOnClickListener((v)->{
				if(runnable != null) runnable.run();
			});
		}

		@Override
		public View getView() {
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
