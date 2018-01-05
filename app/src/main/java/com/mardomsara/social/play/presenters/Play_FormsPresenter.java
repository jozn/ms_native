package com.mardomsara.social.play.presenters;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.nexusdialog.FormController;
import com.mardomsara.nexusdialog.controllers.EditTextController;
import com.mardomsara.nexusdialog.controllers.FormSectionController;
import com.mardomsara.nexusdialog.controllers.SelectionController;
import com.mardomsara.social.nav.FragmentPage;
import com.mardomsara.social.ui.cells.Cells;

import java.util.Arrays;

/**
 * Created by Hamid on 8/14/2016.
 */
public class Play_FormsPresenter extends FragmentPage {

//    @BindView(R.id.fullname) TextView fullname;

    ViewGroup viewRoot;

    @Override
    public View getView(Bundle savedInstanceState) {
		Cells.NavAndEmptyView page = new Cells.NavAndEmptyView();
		page.simpleTopNav.setTitle("فرم");
        viewRoot = page.rootView;
		Context ctx = getContext();
		FormController formController = new FormController(ctx);

		FormSectionController section = new FormSectionController(ctx, "اطلاعات شخصی");
		section.addElement(new EditTextController(ctx, "firstName", "First name"));
		section.addElement(new EditTextController(ctx, "lastName", "اسم من و تو"));
		section.addElement(new SelectionController(ctx, "gender", "Gender", true, "Select", Arrays.asList("Male", "Female"), true));

		formController.addSection(section);

		FormSectionController section2 = new FormSectionController(ctx, "Personal Info");
		section2.addElement(new EditTextController(ctx, "firstName", "First name"));
		section2.addElement(new EditTextController(ctx, "lastName", "Last name"));
		section2.addElement(new SelectionController(ctx, "gender", "Gender", true, "Select", Arrays.asList("Male", "Female"), true));

		formController.addSection(section2);
//		ViewGroup containerView = (ViewGroup)findViewById(R.id.form_elements_container);
		formController.recreateViews(viewRoot);
        return viewRoot;
    }


}
