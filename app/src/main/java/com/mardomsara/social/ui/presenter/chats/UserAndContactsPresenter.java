package com.mardomsara.social.ui.presenter.chats;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.DialogHelper;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.IntentUtil;
import com.mardomsara.social.models.ContactsCopyModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.tables.ContactsCopy;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.views.wigets.FollowingButtonView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hamid on 5/2/2016.
 */
public class UserAndContactsPresenter extends BasePresenter {
    static int CONTACTS = 1;
    static int FOLLOWINGS = 1;

    @Bind(R.id.followings_btn) Button followings_btn;
    @Bind(R.id.contacts_btn) Button contacts_btn;
    @Bind(R.id.layout1) View layout1;//for contacts
    @Bind(R.id.layout2) View layout2;//for followings

    @Bind(R.id.contacts_list) RecyclerView rv_contacts_list;
    @Bind(R.id.followings_list) RecyclerView rv_followings_list;

    @Bind(R.id.empty_contacts_msg) View empty_contacts_msg;
    @Bind(R.id.empty_followings_msg) View empty_followings_msg;

    @Override
    public View buildView() {
        Log.d("presenter", "UserAndContactsPresenter has inited.");

        View view = AppUtil.inflate(R.layout.presenter_list_contacts_followings);
        List<User> registeredContactsList = UserModel.getAllRegisteredContacts();
//        List<UsersTable> followingsLists = PhoneContactsModel.getAllFollowings();
        List<User> followingsLists = UserModel.getAllFollowings();
        List<ContactsCopy> notRegisterd = ContactsCopyModel.getContactsNotRegisterd(registeredContactsList);
        UserFollowingSavedAdaptor adp_contacts = new UserFollowingSavedAdaptor(registeredContactsList ,CONTACTS);
        adp_contacts.mListUnregisteredContacts = notRegisterd;
        UserFollowingSavedAdaptor adp_followings = new UserFollowingSavedAdaptor(followingsLists, FOLLOWINGS);

        ButterKnife.bind(this,view);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(fragment.getActivity());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment.getActivity());
//        mLayoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(fragment.getActivity(), DividerItemDecoration.VERTICAL_LIST);
        RecyclerView.ItemDecoration dec__followings = new
                DividerItemDecoration(fragment.getActivity(), DividerItemDecoration.VERTICAL_LIST);

//        RecyclerView.ItemDecoration itemDecoration=
//                new DividerItemDecoration (getContext().getResources().getDrawable(R.drawable.general_border_bottom_1px));//R.drawable.abc_list_divider_mtrl_alpha));

        rv_contacts_list.addItemDecoration(itemDecoration);
        rv_contacts_list.setAdapter(adp_contacts);
        rv_contacts_list.setLayoutManager(layoutManager1);

        //followings
//        rv_followings.setVisibility(View.INVISIBLE);
        rv_followings_list.addItemDecoration(itemDecoration);
        rv_followings_list.setAdapter(adp_followings);
        rv_followings_list.setLayoutManager(layoutManager2);
        //layout2.setVisibility(View.GONE);

        if(registeredContactsList.size() <1){
            empty_contacts_msg.setVisibility(View.VISIBLE);
        }else {
            empty_contacts_msg.setVisibility(View.GONE);
        }

        if(followingsLists.size() <1){
            empty_followings_msg.setVisibility(View.VISIBLE);
        }else {
            empty_followings_msg.setVisibility(View.GONE);
        }

        followings_btn.setOnClickListener((v)->{
            followings_btn_pressed();
        });

        contacts_btn.setOnClickListener((v)->{
            contacts_btn_pressed();
        });
        contacts_btn_pressed();
        return view;
    }

    void followings_btn_pressed(){
        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
        followings_btn.setSelected(true);
        contacts_btn.setSelected(false);
    }

    void contacts_btn_pressed(){
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
        followings_btn.setSelected(false);
        contacts_btn.setSelected(true);
    }
    public static class UserFollowingSavedAdaptor extends RecyclerView.Adapter<UserFollowingSavedAdaptor.ViewHolderBase> {
        private static final String TAG = "UserFollowingSavedAdaptor";

        private List<User> mDataSet;
        private List<ContactsCopy> mListUnregisteredContacts = new ArrayList<>();
        int listType;


        // END_INCLUDE(recyclerViewSampleViewHolder)

        public UserFollowingSavedAdaptor(List<User> dataSet, int type) {
            mDataSet = dataSet;
            listType = type;
        }

        @Override
        public ViewHolderBase onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            if(viewType==0){//followings or registered users
                View v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.row_users_contacts, viewGroup, false);

                return new ViewHolder(v);
            }else{ //unregisterd
                View v = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.row_users_unregisterd_contact, viewGroup, false);

                return new ViewHolderForUnregisterd(v);
            }
        }

        @Override
        public void onBindViewHolder(ViewHolderBase viewHolder, final int position) {
//            Log.d(TAG, "Element " + position + " setOrReplace.");
//            AppUtil.log("user: "+ JsonUtil.toJson(user));
//            AppUtil.log("user: "+ user.getPhoneDisplayName());
            ViewHolderBase vh0 = viewHolder;
            if(vh0 instanceof ViewHolder && mDataSet.size()> position){
                User user = mDataSet.get(position);
                ViewHolder vh = (ViewHolder) vh0;
				vh.user = user;
                vh.primary_name.setText(user.FirstName +" "+ user.LastName);
                vh.second_name.setText(""+user.PhoneDisplayName);
                vh.self.setTag(user);
                vh.usersTable = user;
				vh.following_button.setUser(user.getTo_UserInfoJson());
                Uri imageUri = Helper.PathToUserAvatarUri(user.AvatarUrl);
                vh.avatar.setImageURI(imageUri);
            }else if(vh0 instanceof ViewHolderForUnregisterd){
                try {
                    ViewHolderForUnregisterd vh = (ViewHolderForUnregisterd) vh0;
                    ContactsCopy user = mListUnregisteredContacts.get(position - mDataSet.size());
                    vh.phoneContact = user;
                    vh.name_text.setText(user.PhoneDisplayName);
                }catch (Exception c){//out of index bug???
                    c.printStackTrace();
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
//            if(listType== FOLLOWINGS) return 0;
            if(position >=  mDataSet.size()){
                return 1;//not registered
            }
            return 0;
        }

        @Override
        public int getItemCount() {
            return mDataSet.size()+ mListUnregisteredContacts.size();
        }

        public static abstract class ViewHolderBase extends RecyclerView.ViewHolder{

            public ViewHolderBase(View itemView) {
                super(itemView);
            }
        }
        //view holders
        public static class ViewHolder extends ViewHolderBase {
            private final View self;
            User usersTable;

            @Bind(R.id.following_button)
            public FollowingButtonView following_button;

            @Bind(R.id.second_name)
            public TextView second_name;

            @Bind(R.id.primary_name)
            public TextView primary_name;

            @Bind(R.id.avatar)
            public SimpleDraweeView avatar;

			User user;

			//TODO: add approprate behaviuer in longPress
            public ViewHolder(View v) {
                super(v);
                self = v;
                v.setOnClickListener((vv)-> {
					if(user != null){
						Router.goToUserChatEntry(user.UserId);
					}
                });

                v.setOnLongClickListener((vv)-> {
//                    DialogHelper.simpleAlert(vv.getContext(), "ایران ما", "تتای عیشسعی یادشسیاسش یشسیشست ");
                    return true;
                });

                ButterKnife.bind(this,v);

                /*avatar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vv) {
                    }
                });*/
            }

        }

        //view holders
        public static class ViewHolderForUnregisterd extends ViewHolderBase {
            private final View self;
            ContactsCopy phoneContact;
            @Bind(R.id.name_text)
            public TextView name_text;

            public ViewHolderForUnregisterd(View v) {
                super(v);
                self = v;
                v.setOnClickListener((vv)-> {
                    IntentUtil.sendSmsTo(phoneContact.PhoneNumber,R.string.sms_join_inviation);
//
                });

                ButterKnife.bind(this,v);

            }

        }
    }
}
