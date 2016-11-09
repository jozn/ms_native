package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.json.social.rows.UserInfoJson;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.ui.views.FontCache;

/**
 * Created by Hamid on 11/10/2016.
 */

public class ChatButtonView extends TextView {

	final static int coloer_isFollowing =AndroidUtil.getColor(R.color.white);
	final static int coloer_notFollowing =AndroidUtil.getColor(R.color.following_blue);
	final static int background_isWaiting = R.drawable.follow_btn_waiteing;

	public ChatButtonView(Context context) {
		super(context);
		init();
	}

	public ChatButtonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ChatButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	void init(){
		setMinimumWidth(AndroidUtil.dpToPx(40));
//        setMinimumWidth(AndroidUtil.dpToPx(80));
//		setLayoutParams(new ViewGroup.LayoutParams(AndroidUtil.dpToPx(150),AndroidUtil.dpToPx(20)));
		setTypeface(FontCache.getIonic());
		setGravity(Gravity.CENTER);

		setTextSize(AndroidUtil.dpToPx(12));
		setText("\uf2d4");
		setTextColor(coloer_notFollowing);
		setBackgroundColor(coloer_isFollowing);
		setBackgroundResource(R.drawable.follow_btn_following);
		setOnClickListener((v)->{
			openChat();
		});
	}

	UserInfoJson userAndMe = null;

	public void setUser(UserInfoJson user){
		userAndMe = user;
	}

	void openChat(){
		if(userAndMe == null)return;
		User u = UserModel.UserInfoJsonToUserTable(userAndMe);
		u.save();
		Room room = RoomModel.getRoomByForUserAndLoadUser(u.UserId);
		Nav.push(Router.getRoomEntery(room));
	}




}
