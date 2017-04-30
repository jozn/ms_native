package com.mardomsara.social.ui.cells.lists;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;

/**
 * Created by Hamid on 7/25/2016.
 */
public class CommentsWithAddFieldCell implements SimpleAddText.OnAddText {
    int postId = 0;
    X.Comments_WithFieldCell x;


	public CommentsListCell commentsListCell;

    public CommentsWithAddFieldCell(int postId, ViewGroup parent ) {
        this.postId = postId;
		commentsListCell = new CommentsListCell(postId);

		x = new X.Comments_WithFieldCell(parent);

		x.content.addView(commentsListCell.getViewRoot());

		x.simpleAddText.setOnAddListener(this);
		x.simpleAddText.x.input.setHint("نظر شما ...");
	}

	@Override
	public void onAddText(String text) {
		commentsListCell.addNewCommentByMe(text);
	}

	public View getViewRoot(){
		return x.root;
	}
}


