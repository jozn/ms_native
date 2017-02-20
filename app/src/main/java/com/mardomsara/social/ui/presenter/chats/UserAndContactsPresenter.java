package com.mardomsara.social.ui.presenter.chats;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.app.Router;
import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.Helper;
import com.mardomsara.social.helpers.IntentUtil;
import com.mardomsara.social.models.ContactsCopyModel;
import com.mardomsara.social.models.UserModel;
import com.mardomsara.social.models.syncer.ContactsCopySyncer;
import com.mardomsara.social.models.syncer.UserSyncer;
import com.mardomsara.social.models.tables.ContactsCopy;
import com.mardomsara.social.models.tables.User;
import com.mardomsara.social.play.DividerItemDecoration;
import com.mardomsara.social.ui.BasePresenter;
import com.mardomsara.social.ui.X;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 5/2/2016.
 */
public class UserAndContactsPresenter extends BasePresenter {
	private enum TAB_TYPE {
		CONTACTS,
		FOLLOWINGS
	}

	// layout_contacts :for contacts
	//layout_followings: for followings
	X.ContactsFollowingsList_Screen x;
	UserFollowingSavedAdaptor adp_contacts;
	UserFollowingSavedAdaptor adp_followings;
	@Override
    public View buildView() {

		x = new X.ContactsFollowingsList_Screen();
//        List<User> registeredContactsList = UserModel.getAllRegisteredContacts();
//        List<User> followingsLists = UserModel.getAllFollowings();
//        List<ContactsCopy> notRegistered = ContactsCopyModel.getContactsNotRegisterd(registeredContactsList);
        adp_contacts = new UserFollowingSavedAdaptor(null ,TAB_TYPE.CONTACTS);
//        adp_contacts.mListUnregisteredContacts = notRegistered;
        adp_followings = new UserFollowingSavedAdaptor(null, TAB_TYPE.FOLLOWINGS);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(AppUtil.getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(AppUtil.getContext());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(AppUtil.getContext(), DividerItemDecoration.VERTICAL_LIST);
        RecyclerView.ItemDecoration dec__followings = new
                DividerItemDecoration(AppUtil.getContext(), DividerItemDecoration.VERTICAL_LIST);

        x.contacts_list_rv.addItemDecoration(itemDecoration);
        x.contacts_list_rv.setAdapter(adp_contacts);
        x.contacts_list_rv.setLayoutManager(layoutManager1);

        //followings
        x.followings_list_rv.addItemDecoration(itemDecoration);
        x.followings_list_rv.setAdapter(adp_followings);
        x.followings_list_rv.setLayoutManager(layoutManager2);

		ref();
        //layout_followings.setVisibility(View.GONE);

        /*if(registeredContactsList.size() <1){
            x.empty_contacts_msg.setVisibility(View.VISIBLE);
        }else {
            x.empty_contacts_msg.setVisibility(View.GONE);
        }

        if(followingsLists.size() <1){
            x.empty_followings_msg.setVisibility(View.VISIBLE);
        }else {
            x.empty_followings_msg.setVisibility(View.GONE);
        }*/

        x.followings_tab_btn.setOnClickListener((v)->{
            followings_btn_pressed();
        });

        x.contacts_tab_btn.setOnClickListener((v)->{
            contacts_btn_pressed();
        });
        contacts_btn_pressed();

		x.layout_contacts.setOnRefreshListener(()->{refreshContacts();});
		x.layout_followings.setOnRefreshListener(()->{refreshFollowings();});

        return x.root;
    }

    void followings_btn_pressed(){
        x.layout_contacts.setVisibility(View.GONE);
        x.layout_followings.setVisibility(View.VISIBLE);
        x.followings_tab_btn.setSelected(true);
        x.contacts_tab_btn.setSelected(false);
    }

    void contacts_btn_pressed(){
        x.layout_contacts.setVisibility(View.VISIBLE);
        x.layout_followings.setVisibility(View.GONE);
        x.followings_tab_btn.setSelected(false);
        x.contacts_tab_btn.setSelected(true);
    }

	void refreshContacts(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			ContactsCopySyncer.forceSyncToServer(()->{
				AndroidUtil.runInUiNoPanic(()->{
					ref();
					x.layout_contacts.setRefreshing(false);
				});
			});
		});

	}

	void refreshFollowings(){
		AndroidUtil.runInBackgroundNoPanic(()->{
			UserSyncer.forceSyncChangedUser(()->{
				AndroidUtil.runInUiNoPanic(()->{
					ref();
					x.layout_followings.setRefreshing(false);
				});
			});
		});
	}

	void ref(){
		List<User> registeredContactsList = UserModel.getAllRegisteredContacts();
		List<User> followingsLists = UserModel.getAllFollowings();
		List<ContactsCopy> notRegistered = ContactsCopyModel.getContactsNotRegisterd(registeredContactsList);

		adp_followings.mDataSet.clear();
		adp_followings.mDataSet.addAll(followingsLists);
		adp_followings.notifyDataSetChanged();

		adp_contacts.mDataSet.clear();
		adp_contacts.mDataSet.addAll(registeredContactsList);
		adp_contacts.mListUnregisteredContacts.clear();
		adp_contacts.mListUnregisteredContacts.addAll(notRegistered);
		adp_contacts.notifyDataSetChanged();

		if(registeredContactsList.size() <1){
			x.empty_contacts_msg.setVisibility(View.VISIBLE);
		}else {
			x.empty_contacts_msg.setVisibility(View.GONE);
		}

		if(followingsLists.size() <1){
			x.empty_followings_msg.setVisibility(View.VISIBLE);
		}else {
			x.empty_followings_msg.setVisibility(View.GONE);
		}
	}

    public static class UserFollowingSavedAdaptor extends RecyclerView.Adapter<UserFollowingSavedAdaptor.ViewHolderBase> {

        private  List<User> mDataSet = new ArrayList<>();
        private List<ContactsCopy> mListUnregisteredContacts = new ArrayList<>();
		TAB_TYPE listType;

        public UserFollowingSavedAdaptor(List<User> dataSet, TAB_TYPE type) {
			if(dataSet!=null){
				mDataSet.addAll(dataSet);
			}
			listType = type;
        }

        @Override
        public ViewHolderBase onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            if(viewType==0){//followings or registered users
                return new ViewHolder(new X.ContactsFollowingsList_Row(viewGroup));
            }else{ //unregisterd
                return new UnRegisteredVH(new X.ContactsFollowingsList_RowUnregisteredContact(viewGroup));
            }
        }

        @Override
        public void onBindViewHolder(ViewHolderBase viewHolder, final int position) {
            ViewHolderBase vh0 = viewHolder;
            if(vh0 instanceof ViewHolder && mDataSet.size()> position){
                User user = mDataSet.get(position);
				((ViewHolder) vh0).bind(user);
            }else if(vh0 instanceof UnRegisteredVH){
                try {
                    ContactsCopy user = mListUnregisteredContacts.get(position - mDataSet.size());
					((UnRegisteredVH) vh0).bind(user);
                }catch (Exception c){//out of index bug???
                    c.printStackTrace();
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
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
			User user;
			X.ContactsFollowingsList_Row x;

			//TODO: add approprate behaviuer in longPress
            public ViewHolder(X.ContactsFollowingsList_Row row) {
                super(row.root);
				x = row;

				//click listeners in here to not do a lot of object creation
				x.root.setOnClickListener((vv)-> {
					if(user != null){
						Router.goToUserChatEntry(user.UserId);
					}
				});

				x.root.setOnLongClickListener((vv)-> {
//                    DialogHelper.simpleAlert(vv.getContext(), "ایران ما", "تتای عیشسعی یادشسیاسش یشسیشست ");
					return true;
				});
            }

			void bind(User user){
				this.user = user;
				x.primary_name.setText(user.FirstName +" "+ user.LastName);
				x.second_name.setText(""+user.PhoneDisplayName);
				x.following_button.setUser(user.getTo_UserInfoJson());
				Uri imageUri = Helper.PathToUserAvatarUri(user.AvatarUrl);
				x.avatar.setImageURI(imageUri);
			}
        }

        //view holders
        static class UnRegisteredVH extends ViewHolderBase {

			X.ContactsFollowingsList_RowUnregisteredContact x;

			ContactsCopy user;
            public UnRegisteredVH(X.ContactsFollowingsList_RowUnregisteredContact row) {
                super(row.root);
                x = row;

				x.root.setOnClickListener((vv)-> {
					if (user ==null)return;
					IntentUtil.sendSmsTo(user.PhoneNumber,R.string.sms_join_inviation);
				});
            }

			void bind(ContactsCopy user){
				this.user = user;
				x.name_text.setText(user.PhoneDisplayName);

			}
        }
    }
}
