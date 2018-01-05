package com.mardomsara.social.ui.cells.rows;

import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.models_old.Comment;
import com.mardomsara.social.models_old.tables.Session;
import com.mardomsara.social.ui.X;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 8/26/2016.
 */
public class CommentRowCell {
	X.CommentRow x;
	public ViewGroup rootView;

    View loading;

    JV.CommentInlineInfoView comment;
    CommentsListCell.CommentsAdaptor adaptor;

    View.OnLongClickListener onLong = (v)->{
        openMoreOptionDialog(comment);
        return true;
    };

    View.OnClickListener gotoProfile = (v)->{
        Router.goToProfile(comment.UserId);
    };

    int i =0;

    public CommentRowCell(ViewGroup parent, CommentsListCell.CommentsAdaptor adaptor) {
		x = new X.CommentRow(parent);

		rootView = x.root;
        this.adaptor = adaptor;
        rootView.setOnLongClickListener(onLong);
        x.fullname.setOnClickListener(gotoProfile);
        x.avatar.setOnClickListener(gotoProfile);
    }

    public void bind(JV.CommentInlineInfoView comment){
        this.comment = comment;

        x.fullname.setText(comment.Sender.FullName);
        x.date.setText(FormaterUtil.timeAgo(comment.CreatedTime));
        i++;
        x.text.setText(comment.Text);
        Helper.SetAvatar(x.avatar, comment.Sender.AvatarUrl);

        if(comment._isNew){
            loading.setVisibility(View.VISIBLE);
        }else {
            loading.setVisibility(View.GONE);
        }
    }

    void openMoreOptionDialog(JV.CommentInlineInfoView comment){
        List<DialogHelper.MenuItem> items = new ArrayList<>();

        items.add(new DialogHelper.MenuItem("کپی متن",(v)->{
            AndroidUtil.copyTextToClipboard(comment.Text,true);
        }));

        if(Session.getUserId() == comment.UserId){
            items.add(new DialogHelper.MenuItem("حذف نظر",(v)->{
                Comment.serverRemoveComment(comment.Id,adaptor.postId);
                adaptor.list.remove(comment);
                adaptor.notifyDataSetChanged();
            }));
        }

        DialogHelper.simpleMenu(items);
    }

}
