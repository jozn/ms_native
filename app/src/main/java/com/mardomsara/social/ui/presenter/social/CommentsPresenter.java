package com.mardomsara.social.ui.presenter.social;

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
public class CommentsPresenter extends BasePresenter implements SimpleAddText.OnAddText {
    int postId = 0;

    @Bind(R.id.simpleTopNav)
    SimpleTopNav simpleTopNav;

    /*@Bind(R.id.loadingView)
    LoadingView loadingView;*/

    @Bind(R.id.simpleAddText)
    SimpleAddText simpleAddText;

	@Bind(R.id.content)
	ViewGroup content;

	CommentsListCell commentsListCell;

    public CommentsPresenter(int postId ) {
        this.postId = postId;
    }

    @Override
    public View buildView() {
        View view = AppUtil.inflate(R.layout.presenter_commonts);
//        ViewGroup view = new PageCells.NavAndEmptyView().rootView;
        ButterKnife.bind(this,view);
		simpleTopNav.setTitle("نظرات");
        commentsListCell = new CommentsListCell(postId);

        content.addView(commentsListCell.getViewRoot());

        simpleAddText.setOnAddListener(this);
        return view;
    }


	@Override
	public void onAddText(String text) {
		commentsListCell.addNewCommentByMe(text);
//		Helper.showDebugMessage(text);
		/*CommentRowJson comment = new CommentRowJson();
		comment.Sender = Session.buildUserSender();
		comment.PostId = postId;
		comment.UserId = Session.getUserId();
		comment.CreatedTime = (int) TimeUtil.getTime();
		comment.Text = text;
		comment._isNew=true;

		commentsListCell.adaptor.list.add(0,comment);
		commentsListCell.adaptor.notifyDataSetChanged();

		AndroidUtil.runInBackgroundNoPanic(()->{
			HttpOld.Req req = new HttpOld.Req();
			req.absPath = API.COMMENTS_ADD.toString();
			req.form.put("post_id",""+postId);
			req.form.put("text",""+text);
			HttpOld.Result res = HttpOld.masterSendPost(req);
			boolean isError = false;
			if(res.ok){
				CommentSingleJson data = JsonUtil.fromJson(res.data,CommentSingleJson.class);
				if(data != null && data.Payload != null && data.Status.equalsIgnoreCase("OK")){
//                    Helper.showMessage(data.Load.toString());
					comment.Id = data.Payload.Id;
					comment.CreatedTime = data.Payload.CreatedTime;
					comment._isNew=false;
					AndroidUtil.runInUi(()->{
						commentsListCell.adaptor.notifyDataSetChanged();
					});
				}else {
					isError = true;
				}
			}else {
				isError = true;
			}

			if(isError){
				Helper.showMessage("خطا در ثبت نظر");
				comment._isNew=false;
				AndroidUtil.runInUi(()->{
					commentsListCell.adaptor.notifyDataSetChanged();
				});
			}

		});*/

	}
}


