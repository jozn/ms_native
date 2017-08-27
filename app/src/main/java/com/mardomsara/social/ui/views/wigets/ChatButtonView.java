package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;

import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.social.Nav;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.json.JV;
import com.mardomsara.social.models.RoomModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.Room;
import com.mardomsara.social.models.tables.User;

/**
 * Created by Hamid on 11/10/2016.
 */

public class ChatButtonView extends IconTextView {

	final static int coloer_isFollowing =AndroidUtil.getColor(R.color.white);
	final static int coloer_notFollowing =AndroidUtil.getColor(R.color.following_blue);
	final static int color_white = Color.WHITE;
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
		setMinimumWidth(AndroidUtil.dpToPx(60));
//        setMinimumWidth(AndroidUtil.dpToPx(80));
//		setLayoutParams(new ViewGroup.LayoutParams(AndroidUtil.dpToPx(150),AndroidUtil.dpToPx(20)));
//		setTypeface(FontCache.getIonic(), Typeface.BOLD);
		setTypeface(null, Typeface.BOLD);
		setGravity(Gravity.CENTER);

//		setTextSize(AndroidUtil.dpToPx(12));

//		setText("\uf2d4");
		setText("\uf422");
		setText("{icon-user-follow 18dp}");
		setText("{icon-envelope 26dp}");
		setTextColor(coloer_notFollowing);
		setBackgroundColor(Color.WHITE);
		setBackgroundResource(R.drawable.btn_default);
		setOnClickListener((v)->{
			openChat();
		});
	}

	JV.UserMeView userAndMe = null;

	public void setUser(JV.UserMeView user){
		userAndMe = user;
	}


	void openChat(){
		if(userAndMe == null)return;
		User u = UserModel.UserMeViewJsonToUserTable(userAndMe);
		u.save();
		Room room = RoomModel.getRoomByForUserAndLoadUser(u.UserId);
		Nav.push(Router.getRoomEntry(room));
	}




}
