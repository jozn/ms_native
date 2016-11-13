package com.mardomsara.social.ui.presenter.social;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.nexusdialog.FormController;
import com.mardomsara.nexusdialog.controllers.ButtonController;
import com.mardomsara.nexusdialog.controllers.ButtonSaveController;
import com.mardomsara.nexusdialog.controllers.EditTextController;
import com.mardomsara.nexusdialog.controllers.FormSectionController;
import com.mardomsara.nexusdialog.controllers.SelectionController;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.json.social.rows.UserTableJson;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.PageCells;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/14/2016.
 */
public class EditProfilePresenter extends BasePresenter {

//    @Bind(R.id.fullname) TextView fullname;

    ViewGroup viewRoot;

	@Bind(R.id.simpleTopNav)
	public SimpleTopNav simpleTopNav;

	@Bind(R.id.container)
	public ViewGroup container;

	@Bind(R.id.form_holder)
	public ViewGroup form_holder;

    @Override
    public View buildView() {
		viewRoot = (ViewGroup) AppUtil.inflate(R.layout.presenter_edit_profile);
		ButterKnife.bind(this,viewRoot);
//		PageCells.NavAndScrollContainer page = new PageCells.NavAndScrollContainer();
		simpleTopNav.setTitle("فرم");
		Context ctx = getContext();
		FormController formController = new FormController(ctx);

		UserTableJson userTableJson = Session.getUserInfo();

		FormSectionController section = new FormSectionController(ctx, "اطلاعات شخصی");

		section.addElement(new EditTextController(ctx, "firstName", "نام", true, userTableJson.FirstName ));
		section.addElement(new EditTextController(ctx, "lastName", "نام خانوادگی",false,userTableJson.LastName));

		EditTextController aboutCtrl = new EditTextController(ctx, "about", "درباره",false,userTableJson.About);
		aboutCtrl.setMultiLine(true);
		aboutCtrl.setLines(5);
		section.addElement(aboutCtrl);

		section.addElement(new SelectionController(ctx, "gender", "Gender", true, "Select", Arrays.asList("Male", "Female"), true));
		section.addElement(new ButtonController(ctx, "save1", "Button"));
		section.addElement(new ButtonSaveController(ctx, "save2", "saven"));

		formController.addSection(section);

		FormSectionController section2 = new FormSectionController(ctx, "Personal Info");
		section2.addElement(new EditTextController(ctx, "firstName", "First name"));
		section2.addElement(new EditTextController(ctx, "lastName", "Last name"));
		section2.addElement(new SelectionController(ctx, "gender", "Gender", true, "Select", Arrays.asList("Male", "Female"), true));

		formController.addSection(section2);
//		ViewGroup containerView = (ViewGroup)findViewById(R.id.form_elements_container);
		formController.recreateViews(form_holder);
        return viewRoot;
    }


}
