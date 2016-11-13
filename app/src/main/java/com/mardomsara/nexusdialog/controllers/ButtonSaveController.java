package com.mardomsara.nexusdialog.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.nexusdialog.FormElementController;
import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.wigets.ButtonGrayView;

public class ButtonSaveController extends FormElementController {

    public ButtonSaveController(Context ctx, String name, String labelText) {
        super(ctx, name);
    }

	@Override
	protected View createView() {
		LayoutInflater layoutInflater = LayoutInflater.from(getContext());
		final ViewGroup view = (ViewGroup)layoutInflater.inflate(R.layout.form_save_button, null);
		ButtonGrayView btn = (ButtonGrayView)view.findViewById(R.id.button);
		btn.setIconAndClicker("{ion-checkmark 24dp} ذخیره" ,null);
//		btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//		btn.setLa
//		refresh(textView);

		return view;
	}

	@Override
	public void setError(String message) {

	}


    private TextView getTextView() {
        return (TextView)getView();
    }

    private void refresh(TextView textView) {
        Object value = getModel().getValue(getName());
        textView.setText(value != null ? value.toString() : "");
    }

    public void refresh() {
        refresh(getTextView());
    }
}