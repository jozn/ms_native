package com.mardomsara.social.ui.cells.lists;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommentsWithAddFieldCell implements SimpleAddText.OnAddText {
    int postId = 0;

    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

	@Bind(R.id.content)
	ViewGroup content;

	View view;

	public CommentsListCell commentsListCell;

    public CommentsWithAddFieldCell(int postId, ViewGroup parent ) {
        this.postId = postId;
		commentsListCell = new CommentsListCell(postId);

		view = AppUtil.inflate(R.layout.cell_commonts_with_field,parent);
		ButterKnife.bind(this,view);

		content.addView(commentsListCell.getViewRoot());

		simpleAddText.setOnAddListener(this);
		simpleAddText.x.input.setHint("نظر شما ...");
	}

	@Override
	public void onAddText(String text) {
		commentsListCell.addNewCommentByMe(text);
	}

	public View getViewRoot(){
		return view;
	}
}


