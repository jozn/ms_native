package com.mardomsara.social.ui.cells.rows;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.FormaterUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.json.social.rows.CommentRowJson;
import com.mardomsara.social.models.Comment;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.ui.cells.lists.CommentsListCell;
import com.mardomsara.social.ui.presenter.social.ProfilePresenter;
import com.mardomsara.social.ui.views.EmojiKeyboard;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 8/26/2016.
 */
public class CommentRowCell {
    public ViewGroup rootView;

    @Bind(R.id.avatar)
    SimpleDraweeView avatar;
    @Bind(R.id.fullname)
    TextView fullname;
    @Bind(R.id.date) TextView date;
    @Bind(R.id.text) TextView text;
    @Bind(R.id.loadingView)
    View loading;

    CommentRowJson comment;
    CommentsListCell.CommentsAdaptor adaptor;

    View.OnLongClickListener onLong = (v)->{
        openMoreOptionDialog(comment);
        return true;
    };

    View.OnClickListener gotoProfile = (v)->{
        Nav.push(new ProfilePresenter(comment.UserId));
    };

    int i =0;

    public CommentRowCell(ViewGroup parent, CommentsListCell.CommentsAdaptor adaptor) {
        rootView = (ViewGroup) AppUtil.inflate(R.layout.cell_row_commont,parent);
        ButterKnife.bind(this,rootView);
        this.adaptor = adaptor;
        rootView.setOnLongClickListener(onLong);
        fullname.setOnClickListener(gotoProfile);
        avatar.setOnClickListener(gotoProfile);
    }

    public void bind(CommentRowJson comment){
        this.comment = comment;

        fullname.setText(comment.Sender.FullName);
        date.setText(FormaterUtil.timeAgo(comment.CreatedTime));
        i++;
        text.setText(comment.Text);
        Helper.SetAvatar(avatar, comment.Sender.AvatarUrl);

        if(comment._isNew){
            loading.setVisibility(View.VISIBLE);
        }else {
            loading.setVisibility(View.GONE);
        }

    }

    void openMoreOptionDialog(CommentRowJson comment){
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
