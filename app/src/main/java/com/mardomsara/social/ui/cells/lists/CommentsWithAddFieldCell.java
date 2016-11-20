package com.mardomsara.social.ui.cells.lists;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommentsWithAddFieldCell extends BasePresenter implements SimpleAddText.OnAddText {
    int postId = 0;


    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

	@Bind(R.id.content)
	ViewGroup content;

	public CommentsListCell commentsListCell;

    public CommentsWithAddFieldCell(int postId ) {
        this.postId = postId;
    }

    @Override
    public View buildView() {
        View view = AppUtil.inflate(R.layout.cell_commonts_with_field);
        ButterKnife.bind(this,view);

        commentsListCell = new CommentsListCell(postId);

        content.addView(commentsListCell.getViewRoot());

        simpleAddText.setOnAddListener(this);
        return view;
    }


	@Override
	public void onAddText(String text) {
		commentsListCell.addNewCommentByMe(text);
	}
}


