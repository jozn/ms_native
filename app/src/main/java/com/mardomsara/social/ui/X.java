
package com.mardomsara.social.ui;

import android.widget.*;
import android.view.*;
import android.webkit.WebView;
import android.view.LayoutInflater;
import android.content.Context;


import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.percent.PercentFrameLayout;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.ui.views.XRawIcon;
import com.mardomsara.social.ui.views.buttons.ButtonPostMultiWayView;
import com.mardomsara.social.ui.views.wigets.BadgeCount;
import com.mardomsara.social.ui.views.wigets.ButtonGrayView;
import com.mardomsara.social.ui.views.wigets.ChatButtonView;
import com.mardomsara.social.ui.views.wigets.ChatListRowWhithBorderRelativeLayout;
import com.mardomsara.social.ui.views.wigets.ChatMediaNetworkLoader;
import com.mardomsara.social.ui.views.wigets.CountView;
import com.mardomsara.social.ui.views.wigets.CountView2;
import com.mardomsara.social.ui.views.wigets.FollowingButtonView;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;
import com.mardomsara.social.ui.views.wigets.UserListGeneralFollowRowWhithBorderLinearLayout;
import com.mardomsara.social.ui.views.x.VAvatarView;
import com.mardomsara.social.ui.views.x.VPostComactImageView;
import com.mardomsara.social.ui.views.x.VPostImageView;
import com.mardomsara.social.ui.views.x.XEditTextView;
import com.mardomsara.social.ui.views.x.XTextView;
import com.mardomsara.social.ui.views.x.XTopNav;
import com.mardomsara.social.ui.views.x.dep.XLinkerTextView;
import com.mardomsara.x.iconify.widget.XIcon;
import me.relex.photodraweeview.PhotoDraweeView;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.R;

public class X {
    
    public static class Actions_Row {
        public RelativeLayout root;
        public FrameLayout frame_layout;
        public ImageView image_extra;
        public FollowingButtonView following_button;
        public XTextView text_main;
        public XTextView date;
        public ImageView avatar_image;

        public Actions_Row(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.actions__row,parent ,false);
            frame_layout = (FrameLayout) root.findViewById( R.id.frame_layout);
            image_extra = (ImageView) root.findViewById( R.id.image_extra);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            text_main = (XTextView) root.findViewById( R.id.text_main);
            date = (XTextView) root.findViewById( R.id.date);
            avatar_image = (ImageView) root.findViewById( R.id.avatar_image);
        }
        public Actions_Row() {
            this(AppUtil.getContext(),null);
        }

        public Actions_Row(Context context) {
            this(context ,null);
        }

        public Actions_Row(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ActivityCrop {
        public LinearLayout root;
        public Button gallery;
        public Button take_picture;
        public ImageView image;

        public ActivityCrop(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.activity_crop,parent ,false);
            gallery = (Button) root.findViewById( R.id.gallery);
            take_picture = (Button) root.findViewById( R.id.take_picture);
            image = (ImageView) root.findViewById( R.id.image);
        }
        public ActivityCrop() {
            this(AppUtil.getContext(),null);
        }

        public ActivityCrop(Context context) {
            this(context ,null);
        }

        public ActivityCrop(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ActivityMainApp {
        public LinearLayout root;
        public LinearLayout global_window;
        public FrameLayout frag1;
        public FrameLayout footerbar_holder;
        public FrameLayout dialog;

        public ActivityMainApp(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.activity_main_app,parent ,false);
            global_window = (LinearLayout) root.findViewById( R.id.global_window);
            frag1 = (FrameLayout) root.findViewById( R.id.frag1);
            footerbar_holder = (FrameLayout) root.findViewById( R.id.footerbar_holder);
            dialog = (FrameLayout) root.findViewById( R.id.dialog);
        }
        public ActivityMainApp() {
            this(AppUtil.getContext(),null);
        }

        public ActivityMainApp(Context context) {
            this(context ,null);
        }

        public ActivityMainApp(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ActivityPlayAdvanced {
        public ScrollView root;
        public TextView output;

        public ActivityPlayAdvanced(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.activity_play_advanced,parent ,false);
            output = (TextView) root.findViewById( R.id.output);
        }
        public ActivityPlayAdvanced() {
            this(AppUtil.getContext(),null);
        }

        public ActivityPlayAdvanced(Context context) {
            this(context ,null);
        }

        public ActivityPlayAdvanced(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class AddPost_Container {
        public RelativeLayout root;
        public XTopNav top_nav;
        public RelativeLayout top_holder;
        public TextView emoji_opener_btn;
        public RelativeLayout left_side;
        public ImageView image;
        public XIcon cancel_image;
        public XEditTextView post_field;
        public LinearLayout bottom_holder;
        public LinearLayout share_media_buttons_holder;
        public XIcon gallery_btn;
        public XIcon camera_btn;
        public FrameLayout recent_images_holder;

        public AddPost_Container(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.add_post__container,parent ,false);
            top_nav = (XTopNav) root.findViewById( R.id.top_nav);
            top_holder = (RelativeLayout) root.findViewById( R.id.top_holder);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            left_side = (RelativeLayout) root.findViewById( R.id.left_side);
            image = (ImageView) root.findViewById( R.id.image);
            cancel_image = (XIcon) root.findViewById( R.id.cancel_image);
            post_field = (XEditTextView) root.findViewById( R.id.post_field);
            bottom_holder = (LinearLayout) root.findViewById( R.id.bottom_holder);
            share_media_buttons_holder = (LinearLayout) root.findViewById( R.id.share_media_buttons_holder);
            gallery_btn = (XIcon) root.findViewById( R.id.gallery_btn);
            camera_btn = (XIcon) root.findViewById( R.id.camera_btn);
            recent_images_holder = (FrameLayout) root.findViewById( R.id.recent_images_holder);
        }
        public AddPost_Container() {
            this(AppUtil.getContext(),null);
        }

        public AddPost_Container(Context context) {
            this(context ,null);
        }

        public AddPost_Container(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class AddPostGallery_Container {
        public LinearLayout root;
        public SimpleTopNav top_nav;
        public RecyclerView recycler_view;

        public AddPostGallery_Container(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.add_post_gallery__container,parent ,false);
            top_nav = (SimpleTopNav) root.findViewById( R.id.top_nav);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public AddPostGallery_Container() {
            this(AppUtil.getContext(),null);
        }

        public AddPostGallery_Container(Context context) {
            this(context ,null);
        }

        public AddPostGallery_Container(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class AddPostGallery_Image {
        public FrameLayout root;
        public ImageView image;

        public AddPostGallery_Image(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.add_post_gallery__image,parent ,false);
            image = (ImageView) root.findViewById( R.id.image);
        }
        public AddPostGallery_Image() {
            this(AppUtil.getContext(),null);
        }

        public AddPostGallery_Image(Context context) {
            this(context ,null);
        }

        public AddPostGallery_Image(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ButtonPostMultiway {
        public ButtonPostMultiWayView root;

        public ButtonPostMultiway(Context context,ViewGroup parent) {
            root = (ButtonPostMultiWayView) LayoutInflater.from(context).inflate(R.layout.button_post_multiway,parent ,false);
        }
        public ButtonPostMultiway() {
            this(AppUtil.getContext(),null);
        }

        public ButtonPostMultiway(Context context) {
            this(context ,null);
        }

        public ButtonPostMultiway(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class CellPageCellNavRecylcerViewBk {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public RecyclerView recycler_view;

        public CellPageCellNavRecylcerViewBk(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.cell_page_cell_nav_recylcer_view_bk,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public CellPageCellNavRecylcerViewBk() {
            this(AppUtil.getContext(),null);
        }

        public CellPageCellNavRecylcerViewBk(Context context) {
            this(context ,null);
        }

        public CellPageCellNavRecylcerViewBk(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class CellPageCommingSoon {
        public RelativeLayout root;

        public CellPageCommingSoon(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.cell_page_comming_soon,parent ,false);
        }
        public CellPageCommingSoon() {
            this(AppUtil.getContext(),null);
        }

        public CellPageCommingSoon(Context context) {
            this(context ,null);
        }

        public CellPageCommingSoon(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Chat_EntryRoom {
        public LinearLayout root;
        public XTextView room_name;
        public ImageView avatar;
        public XRawIcon back;
        public RecyclerView recycler_view;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public XEditTextView edit_field;
        public IconTextView attach_btn;
        public IconTextView attach2;
        public IconTextView send_msg_btn;

        public Chat_EntryRoom(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.chat__entry_room,parent ,false);
            room_name = (XTextView) root.findViewById( R.id.room_name);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            back = (XRawIcon) root.findViewById( R.id.back);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            edit_field = (XEditTextView) root.findViewById( R.id.edit_field);
            attach_btn = (IconTextView) root.findViewById( R.id.attach_btn);
            attach2 = (IconTextView) root.findViewById( R.id.attach2);
            send_msg_btn = (IconTextView) root.findViewById( R.id.send_msg_btn);
        }
        public Chat_EntryRoom() {
            this(AppUtil.getContext(),null);
        }

        public Chat_EntryRoom(Context context) {
            this(context ,null);
        }

        public Chat_EntryRoom(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Chat_ListRow {
        public ChatListRowWhithBorderRelativeLayout root;
        public VAvatarView avatar;
        public XTextView name_txt;
        public XTextView date_txt;
        public CountView2 unseen_count_txt;
        public XTextView last_msg_txt;

        public Chat_ListRow(Context context,ViewGroup parent) {
            root = (ChatListRowWhithBorderRelativeLayout) LayoutInflater.from(context).inflate(R.layout.chat__list_row,parent ,false);
            avatar = (VAvatarView) root.findViewById( R.id.avatar);
            name_txt = (XTextView) root.findViewById( R.id.name_txt);
            date_txt = (XTextView) root.findViewById( R.id.date_txt);
            unseen_count_txt = (CountView2) root.findViewById( R.id.unseen_count_txt);
            last_msg_txt = (XTextView) root.findViewById( R.id.last_msg_txt);
        }
        public Chat_ListRow() {
            this(AppUtil.getContext(),null);
        }

        public Chat_ListRow(Context context) {
            this(context ,null);
        }

        public Chat_ListRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class CommentRow {
        public RelativeLayout root;
        public SimpleDraweeView avatar;
        public XTextView fullname;
        public XTextView date;
        public CircularProgressView loadingView;
        public XTextView text;

        public CommentRow(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.comment_row,parent ,false);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            fullname = (XTextView) root.findViewById( R.id.fullname);
            date = (XTextView) root.findViewById( R.id.date);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
            text = (XTextView) root.findViewById( R.id.text);
        }
        public CommentRow() {
            this(AppUtil.getContext(),null);
        }

        public CommentRow(Context context) {
            this(context ,null);
        }

        public CommentRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Comments_WithFieldCell {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public LinearLayout content;
        public SimpleAddText simpleAddText;

        public Comments_WithFieldCell(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.comments__with_field_cell,parent ,false);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            content = (LinearLayout) root.findViewById( R.id.content);
            simpleAddText = (SimpleAddText) root.findViewById( R.id.simpleAddText);
        }
        public Comments_WithFieldCell() {
            this(AppUtil.getContext(),null);
        }

        public Comments_WithFieldCell(Context context) {
            this(context ,null);
        }

        public Comments_WithFieldCell(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Common_CellLoading {
        public RelativeLayout root;
        public CircularProgressView loadingView;

        public Common_CellLoading(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.common__cell_loading,parent ,false);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
        }
        public Common_CellLoading() {
            this(AppUtil.getContext(),null);
        }

        public Common_CellLoading(Context context) {
            this(context ,null);
        }

        public Common_CellLoading(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Common_ContainerLoading {
        public FrameLayout root;
        public LoadingView loading;

        public Common_ContainerLoading(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.common__container_loading,parent ,false);
            loading = (LoadingView) root.findViewById( R.id.loading);
        }
        public Common_ContainerLoading() {
            this(AppUtil.getContext(),null);
        }

        public Common_ContainerLoading(Context context) {
            this(context ,null);
        }

        public Common_ContainerLoading(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Common_LoadingRow {
        public FrameLayout root;

        public Common_LoadingRow(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.common__loading_row,parent ,false);
        }
        public Common_LoadingRow() {
            this(AppUtil.getContext(),null);
        }

        public Common_LoadingRow(Context context) {
            this(context ,null);
        }

        public Common_LoadingRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Common_OneThirdImage {
        public FrameLayout root;
        public VPostImageView img;

        public Common_OneThirdImage(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.common__one_third_image,parent ,false);
            img = (VPostImageView) root.findViewById( R.id.img);
        }
        public Common_OneThirdImage() {
            this(AppUtil.getContext(),null);
        }

        public Common_OneThirdImage(Context context) {
            this(context ,null);
        }

        public Common_OneThirdImage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Common_OneThirdImageCenter {
        public FrameLayout root;
        public ImageView img;

        public Common_OneThirdImageCenter(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.common__one_third_image_center,parent ,false);
            img = (ImageView) root.findViewById( R.id.img);
        }
        public Common_OneThirdImageCenter() {
            this(AppUtil.getContext(),null);
        }

        public Common_OneThirdImageCenter(Context context) {
            this(context ,null);
        }

        public Common_OneThirdImageCenter(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ContactsFollowingsList_Row {
        public LinearLayout root;
        public FollowingButtonView following_button;
        public XTextView second_name;
        public XTextView primary_name;
        public VAvatarView avatar;

        public ContactsFollowingsList_Row(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.contacts_followings_list__row,parent ,false);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            second_name = (XTextView) root.findViewById( R.id.second_name);
            primary_name = (XTextView) root.findViewById( R.id.primary_name);
            avatar = (VAvatarView) root.findViewById( R.id.avatar);
        }
        public ContactsFollowingsList_Row() {
            this(AppUtil.getContext(),null);
        }

        public ContactsFollowingsList_Row(Context context) {
            this(context ,null);
        }

        public ContactsFollowingsList_Row(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ContactsFollowingsList_RowUnregisteredContact {
        public XTextView root;
        public XTextView name_text;

        public ContactsFollowingsList_RowUnregisteredContact(Context context,ViewGroup parent) {
            root = (XTextView) LayoutInflater.from(context).inflate(R.layout.contacts_followings_list__row_unregistered_contact,parent ,false);
            name_text = (XTextView) root.findViewById( R.id.name_text);
        }
        public ContactsFollowingsList_RowUnregisteredContact() {
            this(AppUtil.getContext(),null);
        }

        public ContactsFollowingsList_RowUnregisteredContact(Context context) {
            this(context ,null);
        }

        public ContactsFollowingsList_RowUnregisteredContact(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ContactsFollowingsList_Screen {
        public LinearLayout root;
        public XTextView followings_tab_btn;
        public XTextView contacts_tab_btn;
        public SwipeRefreshLayout layout_contacts;
        public XTextView empty_contacts_msg;
        public RecyclerView contacts_list_rv;
        public SwipeRefreshLayout layout_followings;
        public XTextView empty_followings_msg;
        public RecyclerView followings_list_rv;

        public ContactsFollowingsList_Screen(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.contacts_followings_list__screen,parent ,false);
            followings_tab_btn = (XTextView) root.findViewById( R.id.followings_tab_btn);
            contacts_tab_btn = (XTextView) root.findViewById( R.id.contacts_tab_btn);
            layout_contacts = (SwipeRefreshLayout) root.findViewById( R.id.layout_contacts);
            empty_contacts_msg = (XTextView) root.findViewById( R.id.empty_contacts_msg);
            contacts_list_rv = (RecyclerView) root.findViewById( R.id.contacts_list_rv);
            layout_followings = (SwipeRefreshLayout) root.findViewById( R.id.layout_followings);
            empty_followings_msg = (XTextView) root.findViewById( R.id.empty_followings_msg);
            followings_list_rv = (RecyclerView) root.findViewById( R.id.followings_list_rv);
        }
        public ContactsFollowingsList_Screen() {
            this(AppUtil.getContext(),null);
        }

        public ContactsFollowingsList_Screen(Context context) {
            this(context ,null);
        }

        public ContactsFollowingsList_Screen(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Cropimage {
        public RelativeLayout root;
        public Button discard;
        public ImageButton rotateLeft;
        public ImageButton rotateRight;
        public Button save;

        public Cropimage(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.cropimage,parent ,false);
            discard = (Button) root.findViewById( R.id.discard);
            rotateLeft = (ImageButton) root.findViewById( R.id.rotateLeft);
            rotateRight = (ImageButton) root.findViewById( R.id.rotateRight);
            save = (Button) root.findViewById( R.id.save);
        }
        public Cropimage() {
            this(AppUtil.getContext(),null);
        }

        public Cropimage(Context context) {
            this(context ,null);
        }

        public Cropimage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_BaseContainer {
        public FrameLayout root;
        public FrameLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_content_container;

        public Dialog_BaseContainer(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.dialog__base_container,parent ,false);
            dialogplus_outmost_container = (FrameLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_content_container = (FrameLayout) root.findViewById( R.id.dialogplus_content_container);
        }
        public Dialog_BaseContainer() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_BaseContainer(Context context) {
            this(context ,null);
        }

        public Dialog_BaseContainer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_CheckboxContainer {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public LinearLayout container;
        public XTextView close;

        public Dialog_CheckboxContainer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__checkbox_container,parent ,false);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            container = (LinearLayout) root.findViewById( R.id.container);
            close = (XTextView) root.findViewById( R.id.close);
        }
        public Dialog_CheckboxContainer() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_CheckboxContainer(Context context) {
            this(context ,null);
        }

        public Dialog_CheckboxContainer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_CheckboxItem {
        public LinearLayout root;
        public XTextView name;
        public CheckBox checkbox;

        public Dialog_CheckboxItem(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__checkbox_item,parent ,false);
            name = (XTextView) root.findViewById( R.id.name);
            checkbox = (CheckBox) root.findViewById( R.id.checkbox);
        }
        public Dialog_CheckboxItem() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_CheckboxItem(Context context) {
            this(context ,null);
        }

        public Dialog_CheckboxItem(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_Grid {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_header_container;
        public GridView dialogplus_list;
        public FrameLayout dialogplus_footer_container;

        public Dialog_Grid(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__grid,parent ,false);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_header_container = (FrameLayout) root.findViewById( R.id.dialogplus_header_container);
            dialogplus_list = (GridView) root.findViewById( R.id.dialogplus_list);
            dialogplus_footer_container = (FrameLayout) root.findViewById( R.id.dialogplus_footer_container);
        }
        public Dialog_Grid() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_Grid(Context context) {
            this(context ,null);
        }

        public Dialog_Grid(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_List {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public ListView dialogplus_list;

        public Dialog_List(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__list,parent ,false);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_list = (ListView) root.findViewById( R.id.dialogplus_list);
        }
        public Dialog_List() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_List(Context context) {
            this(context ,null);
        }

        public Dialog_List(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_OptionsRoomRow {
        public LinearLayout root;
        public TextView text;
        public ListView list_view;

        public Dialog_OptionsRoomRow(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__options_room_row,parent ,false);
            text = (TextView) root.findViewById( R.id.text);
            list_view = (ListView) root.findViewById( R.id.list_view);
        }
        public Dialog_OptionsRoomRow() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_OptionsRoomRow(Context context) {
            this(context ,null);
        }

        public Dialog_OptionsRoomRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_SimpleAlert {
        public LinearLayout root;
        public XTextView title;
        public XTextView body;
        public XTextView close;

        public Dialog_SimpleAlert(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__simple_alert,parent ,false);
            title = (XTextView) root.findViewById( R.id.title);
            body = (XTextView) root.findViewById( R.id.body);
            close = (XTextView) root.findViewById( R.id.close);
        }
        public Dialog_SimpleAlert() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_SimpleAlert(Context context) {
            this(context ,null);
        }

        public Dialog_SimpleAlert(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_SimpleBody {
        public XTextView root;

        public Dialog_SimpleBody(Context context,ViewGroup parent) {
            root = (XTextView) LayoutInflater.from(context).inflate(R.layout.dialog__simple_body,parent ,false);
        }
        public Dialog_SimpleBody() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_SimpleBody(Context context) {
            this(context ,null);
        }

        public Dialog_SimpleBody(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_SimpleClose {
        public XTextView root;

        public Dialog_SimpleClose(Context context,ViewGroup parent) {
            root = (XTextView) LayoutInflater.from(context).inflate(R.layout.dialog__simple_close,parent ,false);
        }
        public Dialog_SimpleClose() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_SimpleClose(Context context) {
            this(context ,null);
        }

        public Dialog_SimpleClose(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_SimpleMenuString {
        public XTextView root;

        public Dialog_SimpleMenuString(Context context,ViewGroup parent) {
            root = (XTextView) LayoutInflater.from(context).inflate(R.layout.dialog__simple_menu_string,parent ,false);
        }
        public Dialog_SimpleMenuString() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_SimpleMenuString(Context context) {
            this(context ,null);
        }

        public Dialog_SimpleMenuString(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_SimpleTitle {
        public XTextView root;

        public Dialog_SimpleTitle(Context context,ViewGroup parent) {
            root = (XTextView) LayoutInflater.from(context).inflate(R.layout.dialog__simple_title,parent ,false);
        }
        public Dialog_SimpleTitle() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_SimpleTitle(Context context) {
            this(context ,null);
        }

        public Dialog_SimpleTitle(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Dialog_View {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_header_container;
        public FrameLayout dialogplus_view_container;
        public FrameLayout dialogplus_footer_container;

        public Dialog_View(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog__view,parent ,false);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_header_container = (FrameLayout) root.findViewById( R.id.dialogplus_header_container);
            dialogplus_view_container = (FrameLayout) root.findViewById( R.id.dialogplus_view_container);
            dialogplus_footer_container = (FrameLayout) root.findViewById( R.id.dialogplus_footer_container);
        }
        public Dialog_View() {
            this(AppUtil.getContext(),null);
        }

        public Dialog_View(Context context) {
            this(context ,null);
        }

        public Dialog_View(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class FragmentChatEnteryPage {
        public LinearLayout root;
        public XTextView room_name;
        public ImageView avatar;
        public XRawIcon back;
        public ImageView imageView;
        public RecyclerView recycler_view;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public EmojiconEditText edit_field;
        public Button attach_btn;
        public Button send_msg_btn;
        public FrameLayout emoji_window_holder;

        public FragmentChatEnteryPage(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.fragment_chat_entery_page,parent ,false);
            room_name = (XTextView) root.findViewById( R.id.room_name);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            back = (XRawIcon) root.findViewById( R.id.back);
            imageView = (ImageView) root.findViewById( R.id.imageView);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            edit_field = (EmojiconEditText) root.findViewById( R.id.edit_field);
            attach_btn = (Button) root.findViewById( R.id.attach_btn);
            send_msg_btn = (Button) root.findViewById( R.id.send_msg_btn);
            emoji_window_holder = (FrameLayout) root.findViewById( R.id.emoji_window_holder);
        }
        public FragmentChatEnteryPage() {
            this(AppUtil.getContext(),null);
        }

        public FragmentChatEnteryPage(Context context) {
            this(context ,null);
        }

        public FragmentChatEnteryPage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class FragmentFooterBar {
        public LinearLayout root;
        public XRawIcon profile;
        public XRawIcon activity;
        public XRawIcon search;
        public XRawIcon home;
        public XRawIcon chat;

        public FragmentFooterBar(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.fragment_footer_bar,parent ,false);
            profile = (XRawIcon) root.findViewById( R.id.profile);
            activity = (XRawIcon) root.findViewById( R.id.activity);
            search = (XRawIcon) root.findViewById( R.id.search);
            home = (XRawIcon) root.findViewById( R.id.home);
            chat = (XRawIcon) root.findViewById( R.id.chat);
        }
        public FragmentFooterBar() {
            this(AppUtil.getContext(),null);
        }

        public FragmentFooterBar(Context context) {
            this(context ,null);
        }

        public FragmentFooterBar(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class FramelayoutMatch {
        public FrameLayout root;

        public FramelayoutMatch(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.framelayout_match,parent ,false);
        }
        public FramelayoutMatch() {
            this(AppUtil.getContext(),null);
        }

        public FramelayoutMatch(Context context) {
            this(context ,null);
        }

        public FramelayoutMatch(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class FullScreenImage {
        public RelativeLayout root;
        public RelativeLayout window;
        public FrameLayout image_holder;
        public PhotoView image_view;
        public LinearLayout top_nav;
        public TextView back_btn;
        public XTextView text_view;

        public FullScreenImage(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.full_screen_image,parent ,false);
            window = (RelativeLayout) root.findViewById( R.id.window);
            image_holder = (FrameLayout) root.findViewById( R.id.image_holder);
            image_view = (PhotoView) root.findViewById( R.id.image_view);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            back_btn = (TextView) root.findViewById( R.id.back_btn);
            text_view = (XTextView) root.findViewById( R.id.text_view);
        }
        public FullScreenImage() {
            this(AppUtil.getContext(),null);
        }

        public FullScreenImage(Context context) {
            this(context ,null);
        }

        public FullScreenImage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class FullScreenImageFresco {
        public RelativeLayout root;
        public RelativeLayout window;
        public PhotoDraweeView image_view;
        public LinearLayout top_nav;
        public XTextView text_view;

        public FullScreenImageFresco(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.full_screen_image_fresco,parent ,false);
            window = (RelativeLayout) root.findViewById( R.id.window);
            image_view = (PhotoDraweeView) root.findViewById( R.id.image_view);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            text_view = (XTextView) root.findViewById( R.id.text_view);
        }
        public FullScreenImageFresco() {
            this(AppUtil.getContext(),null);
        }

        public FullScreenImageFresco(Context context) {
            this(context ,null);
        }

        public FullScreenImageFresco(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class GalleryChooserFoldersRecyiclerView {
        public LinearLayout root;
        public RecyclerView recycler_view;

        public GalleryChooserFoldersRecyiclerView(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.gallery_chooser_folders_recyicler_view,parent ,false);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public GalleryChooserFoldersRecyiclerView() {
            this(AppUtil.getContext(),null);
        }

        public GalleryChooserFoldersRecyiclerView(Context context) {
            this(context ,null);
        }

        public GalleryChooserFoldersRecyiclerView(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class HeaderChatEntary {
        public RelativeLayout root;
        public XTextView room_name;
        public ImageView avatar;
        public XRawIcon back;

        public HeaderChatEntary(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.header_chat_entary,parent ,false);
            room_name = (XTextView) root.findViewById( R.id.room_name);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            back = (XRawIcon) root.findViewById( R.id.back);
        }
        public HeaderChatEntary() {
            this(AppUtil.getContext(),null);
        }

        public HeaderChatEntary(Context context) {
            this(context ,null);
        }

        public HeaderChatEntary(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class HelloWorld {
        public LinearLayout root;
        public ProgressBar pppp;

        public HelloWorld(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.hello_world,parent ,false);
            pppp = (ProgressBar) root.findViewById( R.id.pppp);
        }
        public HelloWorld() {
            this(AppUtil.getContext(),null);
        }

        public HelloWorld(Context context) {
            this(context ,null);
        }

        public HelloWorld(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class HelloWorldMerge {
        public ViewGroup root;
        public Button follow_button;
        public Button followings_btn;

        public HelloWorldMerge(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.hello_world_merge,parent,true);//for Compound Views
            
            follow_button = (Button) root.findViewById( R.id.follow_button);
            followings_btn = (Button) root.findViewById( R.id.followings_btn);
        }//Compound Views Must have parent otherwise will panic

        public HelloWorldMerge(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class HelloWorldRow {
        public LinearLayout root;
        public CircularProgressView loadingView;
        public TextView txt;
        public Button btn;
        public Button btn2;
        public Button btn3;
        public LinearLayout anvil;
        public LinearLayout anvil2;

        public HelloWorldRow(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.hello_world_row,parent ,false);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
            txt = (TextView) root.findViewById( R.id.txt);
            btn = (Button) root.findViewById( R.id.btn);
            btn2 = (Button) root.findViewById( R.id.btn2);
            btn3 = (Button) root.findViewById( R.id.btn3);
            anvil = (LinearLayout) root.findViewById( R.id.anvil);
            anvil2 = (LinearLayout) root.findViewById( R.id.anvil2);
        }
        public HelloWorldRow() {
            this(AppUtil.getContext(),null);
        }

        public HelloWorldRow(Context context) {
            this(context ,null);
        }

        public HelloWorldRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Home_AddPostBox {
        public LinearLayout root;
        public LinearLayout top_holder;
        public ImageView avatar;
        public LinearLayout share_media_buttons_holder;
        public XIcon gallery_btn;
        public XIcon camera_btn;
        public FrameLayout recent_images_holder;

        public Home_AddPostBox(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.home__add_post_box,parent ,false);
            top_holder = (LinearLayout) root.findViewById( R.id.top_holder);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            share_media_buttons_holder = (LinearLayout) root.findViewById( R.id.share_media_buttons_holder);
            gallery_btn = (XIcon) root.findViewById( R.id.gallery_btn);
            camera_btn = (XIcon) root.findViewById( R.id.camera_btn);
            recent_images_holder = (FrameLayout) root.findViewById( R.id.recent_images_holder);
        }
        public Home_AddPostBox() {
            this(AppUtil.getContext(),null);
        }

        public Home_AddPostBox(Context context) {
            this(context ,null);
        }

        public Home_AddPostBox(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Home_Parent {
        public SwipeRefreshLayout root;
        public SwipeRefreshLayout refresh_layout;
        public RelativeLayout top_holder;
        public ButtonPostMultiWayView button_post_way;
        public RecyclerView recycler_view;

        public Home_Parent(Context context,ViewGroup parent) {
            root = (SwipeRefreshLayout) LayoutInflater.from(context).inflate(R.layout.home__parent,parent ,false);
            refresh_layout = (SwipeRefreshLayout) root.findViewById( R.id.refresh_layout);
            top_holder = (RelativeLayout) root.findViewById( R.id.top_holder);
            button_post_way = (ButtonPostMultiWayView) root.findViewById( R.id.button_post_way);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public Home_Parent() {
            this(AppUtil.getContext(),null);
        }

        public Home_Parent(Context context) {
            this(context ,null);
        }

        public Home_Parent(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class InputTextAddSimpleText {
        public LinearLayout root;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public XEditTextView input;
        public XIcon send_btn;

        public InputTextAddSimpleText(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.input_text_add_simple_text,parent ,false);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            input = (XEditTextView) root.findViewById( R.id.input);
            send_btn = (XIcon) root.findViewById( R.id.send_btn);
        }
        public InputTextAddSimpleText() {
            this(AppUtil.getContext(),null);
        }

        public InputTextAddSimpleText(Context context) {
            this(context ,null);
        }

        public InputTextAddSimpleText(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class KeywoardAttachment {
        public LinearLayout root;
        public LinearLayout attachment_top;
        public LinearLayout attachment_main;
        public RelativeLayout frame_layout;
        public LinearLayout attach_video;
        public LinearLayout attach_gallery;
        public LinearLayout attach_camera;
        public LinearLayout attach_audio;
        public LinearLayout attach_file;
        public LinearLayout close_send_btn;
        public XRawIcon close_icon;
        public XTextView close_text;

        public KeywoardAttachment(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.keywoard_attachment,parent ,false);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            attachment_main = (LinearLayout) root.findViewById( R.id.attachment_main);
            frame_layout = (RelativeLayout) root.findViewById( R.id.frame_layout);
            attach_video = (LinearLayout) root.findViewById( R.id.attach_video);
            attach_gallery = (LinearLayout) root.findViewById( R.id.attach_gallery);
            attach_camera = (LinearLayout) root.findViewById( R.id.attach_camera);
            attach_audio = (LinearLayout) root.findViewById( R.id.attach_audio);
            attach_file = (LinearLayout) root.findViewById( R.id.attach_file);
            close_send_btn = (LinearLayout) root.findViewById( R.id.close_send_btn);
            close_icon = (XRawIcon) root.findViewById( R.id.close_icon);
            close_text = (XTextView) root.findViewById( R.id.close_text);
        }
        public KeywoardAttachment() {
            this(AppUtil.getContext(),null);
        }

        public KeywoardAttachment(Context context) {
            this(context ,null);
        }

        public KeywoardAttachment(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class KeywoardAttachment2 {
        public LinearLayout root;
        public LinearLayout attachment_top;
        public LinearLayout attachment_main;
        public LinearLayout attach_camera;
        public LinearLayout attach_gallery;
        public LinearLayout attach_video;
        public LinearLayout attach_file;
        public LinearLayout close_send_btn;

        public KeywoardAttachment2(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.keywoard_attachment2,parent ,false);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            attachment_main = (LinearLayout) root.findViewById( R.id.attachment_main);
            attach_camera = (LinearLayout) root.findViewById( R.id.attach_camera);
            attach_gallery = (LinearLayout) root.findViewById( R.id.attach_gallery);
            attach_video = (LinearLayout) root.findViewById( R.id.attach_video);
            attach_file = (LinearLayout) root.findViewById( R.id.attach_file);
            close_send_btn = (LinearLayout) root.findViewById( R.id.close_send_btn);
        }
        public KeywoardAttachment2() {
            this(AppUtil.getContext(),null);
        }

        public KeywoardAttachment2(Context context) {
            this(context ,null);
        }

        public KeywoardAttachment2(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class KeywoardEmoji {
        public LinearLayout root;
        public LinearLayout attachment_top;
        public LinearLayout emoji_window_holder2;

        public KeywoardEmoji(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.keywoard_emoji,parent ,false);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            emoji_window_holder2 = (LinearLayout) root.findViewById( R.id.emoji_window_holder2);
        }
        public KeywoardEmoji() {
            this(AppUtil.getContext(),null);
        }

        public KeywoardEmoji(Context context) {
            this(context ,null);
        }

        public KeywoardEmoji(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class LastActivity_Row {
        public LinearLayout root;
        public FrameLayout frame_layout;
        public ImageView image_extra;
        public FollowingButtonView following_button;
        public EmojiconTextView text;
        public TextView date;
        public ImageView avatar;

        public LastActivity_Row(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.last_activity__row,parent ,false);
            frame_layout = (FrameLayout) root.findViewById( R.id.frame_layout);
            image_extra = (ImageView) root.findViewById( R.id.image_extra);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            text = (EmojiconTextView) root.findViewById( R.id.text);
            date = (TextView) root.findViewById( R.id.date);
            avatar = (ImageView) root.findViewById( R.id.avatar);
        }
        public LastActivity_Row() {
            this(AppUtil.getContext(),null);
        }

        public LastActivity_Row(Context context) {
            this(context ,null);
        }

        public LastActivity_Row(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class LinearlayoutMatch {
        public LinearLayout root;

        public LinearlayoutMatch(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.linearlayout_match,parent ,false);
        }
        public LinearlayoutMatch() {
            this(AppUtil.getContext(),null);
        }

        public LinearlayoutMatch(Context context) {
            this(context ,null);
        }

        public LinearlayoutMatch(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ListRoomsPresenter {
        public LinearLayout root;
        public FrameLayout layout1;
        public RecyclerView contacts_list_rv;

        public ListRoomsPresenter(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.list_rooms_presenter,parent ,false);
            layout1 = (FrameLayout) root.findViewById( R.id.layout1);
            contacts_list_rv = (RecyclerView) root.findViewById( R.id.contacts_list_rv);
        }
        public ListRoomsPresenter() {
            this(AppUtil.getContext(),null);
        }

        public ListRoomsPresenter(Context context) {
            this(context ,null);
        }

        public ListRoomsPresenter(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ListUserFollowRow {
        public LinearLayout root;
        public LinearLayout row;
        public TextView textView2;
        public TextView user;
        public SimpleDraweeView my_image_view;

        public ListUserFollowRow(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.list_user_follow_row,parent ,false);
            row = (LinearLayout) root.findViewById( R.id.row);
            textView2 = (TextView) root.findViewById( R.id.textView2);
            user = (TextView) root.findViewById( R.id.user);
            my_image_view = (SimpleDraweeView) root.findViewById( R.id.my_image_view);
        }
        public ListUserFollowRow() {
            this(AppUtil.getContext(),null);
        }

        public ListUserFollowRow(Context context) {
            this(context ,null);
        }

        public ListUserFollowRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ListviewPlanetTextview {
        public TextView root;
        public TextView listViewText;

        public ListviewPlanetTextview(Context context,ViewGroup parent) {
            root = (TextView) LayoutInflater.from(context).inflate(R.layout.listview_planet_textview,parent ,false);
            listViewText = (TextView) root.findViewById( R.id.listViewText);
        }
        public ListviewPlanetTextview() {
            this(AppUtil.getContext(),null);
        }

        public ListviewPlanetTextview(Context context) {
            this(context ,null);
        }

        public ListviewPlanetTextview(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Loading {
        public FrameLayout root;
        public CircularProgressView loading;

        public Loading(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.loading,parent ,false);
            loading = (CircularProgressView) root.findViewById( R.id.loading);
        }
        public Loading() {
            this(AppUtil.getContext(),null);
        }

        public Loading(Context context) {
            this(context ,null);
        }

        public Loading(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Main {
        public LinearLayout root;
        public TextView textView;

        public Main(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.main,parent ,false);
            textView = (TextView) root.findViewById( R.id.textView);
        }
        public Main() {
            this(AppUtil.getContext(),null);
        }

        public Main(Context context) {
            this(context ,null);
        }

        public Main(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class MainBranchChat {
        public LinearLayout root;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public MainBranchChat(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.main_branch_chat,parent ,false);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }
        public MainBranchChat() {
            this(AppUtil.getContext(),null);
        }

        public MainBranchChat(Context context) {
            this(context ,null);
        }

        public MainBranchChat(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class MainPageChatPresenter {
        public LinearLayout root;

        public MainPageChatPresenter(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.main_page_chat_presenter,parent ,false);
        }
        public MainPageChatPresenter() {
            this(AppUtil.getContext(),null);
        }

        public MainPageChatPresenter(Context context) {
            this(context ,null);
        }

        public MainPageChatPresenter(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class MediaChooserTopNav {
        public LinearLayout root;
        public LinearLayout left_side;
        public TextView send_btn;
        public TextView text_icon;
        public TextView back_btn;
        public TextView title;

        public MediaChooserTopNav(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.media_chooser_top_nav,parent ,false);
            left_side = (LinearLayout) root.findViewById( R.id.left_side);
            send_btn = (TextView) root.findViewById( R.id.send_btn);
            text_icon = (TextView) root.findViewById( R.id.text_icon);
            back_btn = (TextView) root.findViewById( R.id.back_btn);
            title = (TextView) root.findViewById( R.id.title);
        }
        public MediaChooserTopNav() {
            this(AppUtil.getContext(),null);
        }

        public MediaChooserTopNav(Context context) {
            this(context ,null);
        }

        public MediaChooserTopNav(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_Empty {
        public FrameLayout root;

        public Msg_Empty(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.msg__empty,parent ,false);
        }
        public Msg_Empty() {
            this(AppUtil.getContext(),null);
        }

        public Msg_Empty(Context context) {
            this(context ,null);
        }

        public Msg_Empty(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_FullPageEmptyNote {
        public RelativeLayout root;

        public Msg_FullPageEmptyNote(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.msg__full_page_empty_note,parent ,false);
        }
        public Msg_FullPageEmptyNote() {
            this(AppUtil.getContext(),null);
        }

        public Msg_FullPageEmptyNote(Context context) {
            this(context ,null);
        }

        public Msg_FullPageEmptyNote(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_MediaNetworkLoader {
        public ViewGroup root;
        public SimpleDraweeView msg_image;
        public FrameLayout loading_holder;
        public XRawIcon icon_action_btn;
        public CircularProgressView loading_progress;

        public Msg_MediaNetworkLoader(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.msg__media_network_loader,parent,true);//for Compound Views
            
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
            loading_holder = (FrameLayout) root.findViewById( R.id.loading_holder);
            icon_action_btn = (XRawIcon) root.findViewById( R.id.icon_action_btn);
            loading_progress = (CircularProgressView) root.findViewById( R.id.loading_progress);
        }//Compound Views Must have parent otherwise will panic

        public Msg_MediaNetworkLoader(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowAllMe {
        public LinearLayout root;
        public XTextView txt;

        public Msg_RowAllMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_all_me,parent ,false);
            txt = (XTextView) root.findViewById( R.id.txt);
        }
        public Msg_RowAllMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowAllMe(Context context) {
            this(context ,null);
        }

        public Msg_RowAllMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowAllPeer {
        public LinearLayout root;
        public TextView txt;

        public Msg_RowAllPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_all_peer,parent ,false);
            txt = (TextView) root.findViewById( R.id.txt);
        }
        public Msg_RowAllPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowAllPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowAllPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowAudioMe {
        public LinearLayout root;

        public Msg_RowAudioMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_audio_me,parent ,false);
        }
        public Msg_RowAudioMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowAudioMe(Context context) {
            this(context ,null);
        }

        public Msg_RowAudioMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowAudioPeer {
        public LinearLayout root;

        public Msg_RowAudioPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_audio_peer,parent ,false);
        }
        public Msg_RowAudioPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowAudioPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowAudioPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowContactMe {
        public LinearLayout root;

        public Msg_RowContactMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_contact_me,parent ,false);
        }
        public Msg_RowContactMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowContactMe(Context context) {
            this(context ,null);
        }

        public Msg_RowContactMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowContactPeer {
        public LinearLayout root;

        public Msg_RowContactPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_contact_peer,parent ,false);
        }
        public Msg_RowContactPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowContactPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowContactPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowFileMe {
        public LinearLayout root;

        public Msg_RowFileMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_file_me,parent ,false);
        }
        public Msg_RowFileMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowFileMe(Context context) {
            this(context ,null);
        }

        public Msg_RowFileMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowFilePeer {
        public LinearLayout root;

        public Msg_RowFilePeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_file_peer,parent ,false);
        }
        public Msg_RowFilePeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowFilePeer(Context context) {
            this(context ,null);
        }

        public Msg_RowFilePeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowImageMe {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public ChatMediaNetworkLoader image_holder;
        public XTextView msg_text;
        public XTextView msg_time;
        public XRawIcon msg_delivery_status;

        public Msg_RowImageMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_image_me,parent ,false);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            image_holder = (ChatMediaNetworkLoader) root.findViewById( R.id.image_holder);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
            msg_time = (XTextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (XRawIcon) root.findViewById( R.id.msg_delivery_status);
        }
        public Msg_RowImageMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowImageMe(Context context) {
            this(context ,null);
        }

        public Msg_RowImageMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowImagePeer {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public ChatMediaNetworkLoader image_holder;
        public XTextView msg_text;
        public TextView msg_time;

        public Msg_RowImagePeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_image_peer,parent ,false);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            image_holder = (ChatMediaNetworkLoader) root.findViewById( R.id.image_holder);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
            msg_time = (TextView) root.findViewById( R.id.msg_time);
        }
        public Msg_RowImagePeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowImagePeer(Context context) {
            this(context ,null);
        }

        public Msg_RowImagePeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowLocationMe {
        public LinearLayout root;

        public Msg_RowLocationMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_location_me,parent ,false);
        }
        public Msg_RowLocationMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowLocationMe(Context context) {
            this(context ,null);
        }

        public Msg_RowLocationMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowLocationPeer {
        public LinearLayout root;

        public Msg_RowLocationPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_location_peer,parent ,false);
        }
        public Msg_RowLocationPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowLocationPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowLocationPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowNotSupportedPeer {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public XTextView msg_text;

        public Msg_RowNotSupportedPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_not_supported_peer,parent ,false);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
        }
        public Msg_RowNotSupportedPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowNotSupportedPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowNotSupportedPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowPostMe {
        public LinearLayout root;

        public Msg_RowPostMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_post_me,parent ,false);
        }
        public Msg_RowPostMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowPostMe(Context context) {
            this(context ,null);
        }

        public Msg_RowPostMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowPostPeer {
        public LinearLayout root;

        public Msg_RowPostPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_post_peer,parent ,false);
        }
        public Msg_RowPostPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowPostPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowPostPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowStickerMe {
        public LinearLayout root;

        public Msg_RowStickerMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_sticker_me,parent ,false);
        }
        public Msg_RowStickerMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowStickerMe(Context context) {
            this(context ,null);
        }

        public Msg_RowStickerMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowStickerPeer {
        public LinearLayout root;

        public Msg_RowStickerPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_sticker_peer,parent ,false);
        }
        public Msg_RowStickerPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowStickerPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowStickerPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowSystem {
        public LinearLayout root;

        public Msg_RowSystem(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_system,parent ,false);
        }
        public Msg_RowSystem() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowSystem(Context context) {
            this(context ,null);
        }

        public Msg_RowSystem(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowTextMe {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public XTextView msg_text;
        public TextView msg_time;
        public TextView msg_delivery_status;

        public Msg_RowTextMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_text_me,parent ,false);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
            msg_time = (TextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (TextView) root.findViewById( R.id.msg_delivery_status);
        }
        public Msg_RowTextMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowTextMe(Context context) {
            this(context ,null);
        }

        public Msg_RowTextMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowTextPeer {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public XTextView msg_text;
        public TextView msg_time;

        public Msg_RowTextPeer(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_text_peer,parent ,false);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
            msg_time = (TextView) root.findViewById( R.id.msg_time);
        }
        public Msg_RowTextPeer() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowTextPeer(Context context) {
            this(context ,null);
        }

        public Msg_RowTextPeer(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_RowVideoMe {
        public LinearLayout root;
        public RelativeLayout msg_content_holder;
        public SimpleDraweeView msg_image;
        public XTextView msg_text;
        public XTextView msg_time;
        public XRawIcon msg_delivery_status;

        public Msg_RowVideoMe(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__row_video_me,parent ,false);
            msg_content_holder = (RelativeLayout) root.findViewById( R.id.msg_content_holder);
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
            msg_text = (XTextView) root.findViewById( R.id.msg_text);
            msg_time = (XTextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (XRawIcon) root.findViewById( R.id.msg_delivery_status);
        }
        public Msg_RowVideoMe() {
            this(AppUtil.getContext(),null);
        }

        public Msg_RowVideoMe(Context context) {
            this(context ,null);
        }

        public Msg_RowVideoMe(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_SharedTime {
        public ViewGroup root;
        public TextView msg_time;

        public Msg_SharedTime(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.msg__shared_time,parent,true);//for Compound Views
            
            msg_time = (TextView) root.findViewById( R.id.msg_time);
        }//Compound Views Must have parent otherwise will panic

        public Msg_SharedTime(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_SharedTimeAndDelivery {
        public ViewGroup root;
        public TextView msg_time;
        public TextView msg_delivery_status;

        public Msg_SharedTimeAndDelivery(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.msg__shared_time_and_delivery,parent,true);//for Compound Views
            
            msg_time = (TextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (TextView) root.findViewById( R.id.msg_delivery_status);
        }//Compound Views Must have parent otherwise will panic

        public Msg_SharedTimeAndDelivery(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Msg_SharedTimeStatus {
        public LinearLayout root;
        public XTextView msg_time;
        public XRawIcon msg_delivery_status;

        public Msg_SharedTimeStatus(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.msg__shared_time_status,parent ,false);
            msg_time = (XTextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (XRawIcon) root.findViewById( R.id.msg_delivery_status);
        }
        public Msg_SharedTimeStatus() {
            this(AppUtil.getContext(),null);
        }

        public Msg_SharedTimeStatus(Context context) {
            this(context ,null);
        }

        public Msg_SharedTimeStatus(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Nav_IconHolder {
        public FrameLayout root;
        public IconTextView icon_text;

        public Nav_IconHolder(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.nav__icon_holder,parent ,false);
            icon_text = (IconTextView) root.findViewById( R.id.icon_text);
        }
        public Nav_IconHolder() {
            this(AppUtil.getContext(),null);
        }

        public Nav_IconHolder(Context context) {
            this(context ,null);
        }

        public Nav_IconHolder(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Nav_RecylcerView {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public RecyclerView recycler_view;

        public Nav_RecylcerView(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.nav__recylcer_view,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public Nav_RecylcerView() {
            this(AppUtil.getContext(),null);
        }

        public Nav_RecylcerView(Context context) {
            this(context ,null);
        }

        public Nav_RecylcerView(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Nav_Simple {
        public ViewGroup root;
        public TextView left_text;
        public XTextView title_text;
        public XIcon back_btn;

        public Nav_Simple(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.nav__simple,parent,true);//for Compound Views
            
            left_text = (TextView) root.findViewById( R.id.left_text);
            title_text = (XTextView) root.findViewById( R.id.title_text);
            back_btn = (XIcon) root.findViewById( R.id.back_btn);
        }//Compound Views Must have parent otherwise will panic

        public Nav_Simple(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class NavHeaderPagerMenu {
        public LinearLayout root;
        public LinearLayout search;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public NavHeaderPagerMenu(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.nav_header_pager_menu,parent ,false);
            search = (LinearLayout) root.findViewById( R.id.search);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }
        public NavHeaderPagerMenu() {
            this(AppUtil.getContext(),null);
        }

        public NavHeaderPagerMenu(Context context) {
            this(context ,null);
        }

        public NavHeaderPagerMenu(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Notify_Row {
        public RelativeLayout root;
        public FrameLayout frame_layout;
        public ImageView image_extra;
        public FollowingButtonView following_button;
        public XTextView text_main;
        public XTextView date;
        public ImageView avatar_image;

        public Notify_Row(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.notify__row,parent ,false);
            frame_layout = (FrameLayout) root.findViewById( R.id.frame_layout);
            image_extra = (ImageView) root.findViewById( R.id.image_extra);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            text_main = (XTextView) root.findViewById( R.id.text_main);
            date = (XTextView) root.findViewById( R.id.date);
            avatar_image = (ImageView) root.findViewById( R.id.avatar_image);
        }
        public Notify_Row() {
            this(AppUtil.getContext(),null);
        }

        public Notify_Row(Context context) {
            this(context ,null);
        }

        public Notify_Row(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class NotifyNotSuportedCell {
        public LinearLayout root;

        public NotifyNotSuportedCell(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.notify_not_suported_cell,parent ,false);
        }
        public NotifyNotSuportedCell() {
            this(AppUtil.getContext(),null);
        }

        public NotifyNotSuportedCell(Context context) {
            this(context ,null);
        }

        public NotifyNotSuportedCell(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Page_EditProfile {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public ConstraintLayout container;
        public ImageView avatar;
        public TextView textView5;
        public Guideline guideline3;
        public TextView editText;
        public EditText editText2;
        public TextView textView6;
        public EditText editText3;
        public TextView textView7;
        public EditText editText4;

        public Page_EditProfile(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.page__edit_profile,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            container = (ConstraintLayout) root.findViewById( R.id.container);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            textView5 = (TextView) root.findViewById( R.id.textView5);
            guideline3 = (Guideline) root.findViewById( R.id.guideline3);
            editText = (TextView) root.findViewById( R.id.editText);
            editText2 = (EditText) root.findViewById( R.id.editText2);
            textView6 = (TextView) root.findViewById( R.id.textView6);
            editText3 = (EditText) root.findViewById( R.id.editText3);
            textView7 = (TextView) root.findViewById( R.id.textView7);
            editText4 = (EditText) root.findViewById( R.id.editText4);
        }
        public Page_EditProfile() {
            this(AppUtil.getContext(),null);
        }

        public Page_EditProfile(Context context) {
            this(context ,null);
        }

        public Page_EditProfile(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Page_EditProfileBk {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public LinearLayout container;
        public ImageView avatar;

        public Page_EditProfileBk(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.page__edit_profile_bk,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            container = (LinearLayout) root.findViewById( R.id.container);
            avatar = (ImageView) root.findViewById( R.id.avatar);
        }
        public Page_EditProfileBk() {
            this(AppUtil.getContext(),null);
        }

        public Page_EditProfileBk(Context context) {
            this(context ,null);
        }

        public Page_EditProfileBk(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Page_PostSingleEntry {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public FrameLayout post_row_holder;
        public FrameLayout comments_holder;

        public Page_PostSingleEntry(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.page__post_single_entry,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            post_row_holder = (FrameLayout) root.findViewById( R.id.post_row_holder);
            comments_holder = (FrameLayout) root.findViewById( R.id.comments_holder);
        }
        public Page_PostSingleEntry() {
            this(AppUtil.getContext(),null);
        }

        public Page_PostSingleEntry(Context context) {
            this(context ,null);
        }

        public Page_PostSingleEntry(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Page_ProfileEdit2 {
        public RelativeLayout root;
        public View cover;
        public ImageView profilePicture;
        public TextView removeAvatar;
        public XEditTextView inputName;
        public LinearLayout descriptionRoot;
        public XEditTextView inputDescription;
        public LinearLayout genderRoot;
        public RadioButton radioMale;
        public Button btnRegister;

        public Page_ProfileEdit2(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.page__profile_edit2,parent ,false);
            cover = (View) root.findViewById( R.id.cover);
            profilePicture = (ImageView) root.findViewById( R.id.profilePicture);
            removeAvatar = (TextView) root.findViewById( R.id.removeAvatar);
            inputName = (XEditTextView) root.findViewById( R.id.inputName);
            descriptionRoot = (LinearLayout) root.findViewById( R.id.descriptionRoot);
            inputDescription = (XEditTextView) root.findViewById( R.id.inputDescription);
            genderRoot = (LinearLayout) root.findViewById( R.id.genderRoot);
            radioMale = (RadioButton) root.findViewById( R.id.radioMale);
            btnRegister = (Button) root.findViewById( R.id.btnRegister);
        }
        public Page_ProfileEdit2() {
            this(AppUtil.getContext(),null);
        }

        public Page_ProfileEdit2(Context context) {
            this(context ,null);
        }

        public Page_ProfileEdit2(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Page_ProfileEdit3 {
        public ConstraintLayout root;
        public TextView textView3;
        public ProgressBar progressBar;
        public Guideline guideline;
        public Guideline guideline2;
        public TextView textView4;
        public FloatingActionButton floatingActionButton;

        public Page_ProfileEdit3(Context context,ViewGroup parent) {
            root = (ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.page__profile_edit3,parent ,false);
            textView3 = (TextView) root.findViewById( R.id.textView3);
            progressBar = (ProgressBar) root.findViewById( R.id.progressBar);
            guideline = (Guideline) root.findViewById( R.id.guideline);
            guideline2 = (Guideline) root.findViewById( R.id.guideline2);
            textView4 = (TextView) root.findViewById( R.id.textView4);
            floatingActionButton = (FloatingActionButton) root.findViewById( R.id.floatingActionButton);
        }
        public Page_ProfileEdit3() {
            this(AppUtil.getContext(),null);
        }

        public Page_ProfileEdit3(Context context) {
            this(context ,null);
        }

        public Page_ProfileEdit3(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PageRecentPosts_Parent {
        public LinearLayout root;
        public LinearLayout root_layout;
        public XTopNav top_nav;
        public FrameLayout container;

        public PageRecentPosts_Parent(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.page_recent_posts__parent,parent ,false);
            root_layout = (LinearLayout) root.findViewById( R.id.root_layout);
            top_nav = (XTopNav) root.findViewById( R.id.top_nav);
            container = (FrameLayout) root.findViewById( R.id.container);
        }
        public PageRecentPosts_Parent() {
            this(AppUtil.getContext(),null);
        }

        public PageRecentPosts_Parent(Context context) {
            this(context ,null);
        }

        public PageRecentPosts_Parent(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PageTag_Parent {
        public LinearLayout root;
        public LinearLayout root_layout;
        public XTopNav top_nav;
        public FrameLayout container;

        public PageTag_Parent(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.page_tag__parent,parent ,false);
            root_layout = (LinearLayout) root.findViewById( R.id.root_layout);
            top_nav = (XTopNav) root.findViewById( R.id.top_nav);
            container = (FrameLayout) root.findViewById( R.id.container);
        }
        public PageTag_Parent() {
            this(AppUtil.getContext(),null);
        }

        public PageTag_Parent(Context context) {
            this(context ,null);
        }

        public PageTag_Parent(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Pager_CellNavLinearView {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;

        public Pager_CellNavLinearView(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pager__cell_nav_linear_view,parent ,false);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
        }
        public Pager_CellNavLinearView() {
            this(AppUtil.getContext(),null);
        }

        public Pager_CellNavLinearView(Context context) {
            this(context ,null);
        }

        public Pager_CellNavLinearView(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Pager_NavRecyclerviewWithRefresher {
        public LinearLayout root;
        public SimpleTopNav nav;
        public SwipeRefreshLayout refresh_layout;
        public RecyclerView recycler_view;

        public Pager_NavRecyclerviewWithRefresher(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pager__nav_recyclerview_with_refresher,parent ,false);
            nav = (SimpleTopNav) root.findViewById( R.id.nav);
            refresh_layout = (SwipeRefreshLayout) root.findViewById( R.id.refresh_layout);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public Pager_NavRecyclerviewWithRefresher() {
            this(AppUtil.getContext(),null);
        }

        public Pager_NavRecyclerviewWithRefresher(Context context) {
            this(context ,null);
        }

        public Pager_NavRecyclerviewWithRefresher(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Pager_RecyclerviewWithRefresher {
        public SwipeRefreshLayout root;
        public SwipeRefreshLayout refresh_layout;
        public RecyclerView recycler_view;

        public Pager_RecyclerviewWithRefresher(Context context,ViewGroup parent) {
            root = (SwipeRefreshLayout) LayoutInflater.from(context).inflate(R.layout.pager__recyclerview_with_refresher,parent ,false);
            refresh_layout = (SwipeRefreshLayout) root.findViewById( R.id.refresh_layout);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public Pager_RecyclerviewWithRefresher() {
            this(AppUtil.getContext(),null);
        }

        public Pager_RecyclerviewWithRefresher(Context context) {
            this(context ,null);
        }

        public Pager_RecyclerviewWithRefresher(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayActivityFontsScrolling {
        public ScrollView root;
        public Button btn;

        public PlayActivityFontsScrolling(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.play_activity_fonts_scrolling,parent ,false);
            btn = (Button) root.findViewById( R.id.btn);
        }
        public PlayActivityFontsScrolling() {
            this(AppUtil.getContext(),null);
        }

        public PlayActivityFontsScrolling(Context context) {
            this(context ,null);
        }

        public PlayActivityFontsScrolling(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayMainPopup {
        public LinearLayout root;
        public TextView txt;
        public Button base64;
        public ImageView img;
        public ImageView img2;
        public Button dl;
        public Button openpopup;

        public PlayMainPopup(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.play_main_popup,parent ,false);
            txt = (TextView) root.findViewById( R.id.txt);
            base64 = (Button) root.findViewById( R.id.base64);
            img = (ImageView) root.findViewById( R.id.img);
            img2 = (ImageView) root.findViewById( R.id.img2);
            dl = (Button) root.findViewById( R.id.dl);
            openpopup = (Button) root.findViewById( R.id.openpopup);
        }
        public PlayMainPopup() {
            this(AppUtil.getContext(),null);
        }

        public PlayMainPopup(Context context) {
            this(context ,null);
        }

        public PlayMainPopup(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayRealm {
        public ScrollView root;
        public LinearLayout container;
        public TextView txt;

        public PlayRealm(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.play_realm,parent ,false);
            container = (LinearLayout) root.findViewById( R.id.container);
            txt = (TextView) root.findViewById( R.id.txt);
        }
        public PlayRealm() {
            this(AppUtil.getContext(),null);
        }

        public PlayRealm(Context context) {
            this(context ,null);
        }

        public PlayRealm(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayRecipies {
        public LinearLayout root;
        public Button _status_bar;
        public Button p_navigation;

        public PlayRecipies(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.play_recipies,parent ,false);
            _status_bar = (Button) root.findViewById( R.id._status_bar);
            p_navigation = (Button) root.findViewById( R.id.p_navigation);
        }
        public PlayRecipies() {
            this(AppUtil.getContext(),null);
        }

        public PlayRecipies(Context context) {
            this(context ,null);
        }

        public PlayRecipies(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayXicon {
        public ScrollView root;

        public PlayXicon(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.play_xicon,parent ,false);
        }
        public PlayXicon() {
            this(AppUtil.getContext(),null);
        }

        public PlayXicon(Context context) {
            this(context ,null);
        }

        public PlayXicon(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayXtextcoloersview {
        public ScrollView root;

        public PlayXtextcoloersview(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.play_xtextcoloersview,parent ,false);
        }
        public PlayXtextcoloersview() {
            this(AppUtil.getContext(),null);
        }

        public PlayXtextcoloersview(Context context) {
            this(context ,null);
        }

        public PlayXtextcoloersview(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PlayXtextview {
        public ScrollView root;

        public PlayXtextview(Context context,ViewGroup parent) {
            root = (ScrollView) LayoutInflater.from(context).inflate(R.layout.play_xtextview,parent ,false);
        }
        public PlayXtextview() {
            this(AppUtil.getContext(),null);
        }

        public PlayXtextview(Context context) {
            this(context ,null);
        }

        public PlayXtextview(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Post_SingleEntryHolder {
        public FrameLayout root;
        public LoadingView loading;

        public Post_SingleEntryHolder(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.post__single_entry_holder,parent ,false);
            loading = (LoadingView) root.findViewById( R.id.loading);
        }
        public Post_SingleEntryHolder() {
            this(AppUtil.getContext(),null);
        }

        public Post_SingleEntryHolder(Context context) {
            this(context ,null);
        }

        public Post_SingleEntryHolder(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PostList_Parent {
        public SwipeRefreshLayout root;
        public SwipeRefreshLayout refresh_layout;
        public RecyclerView recycler_view;

        public PostList_Parent(Context context,ViewGroup parent) {
            root = (SwipeRefreshLayout) LayoutInflater.from(context).inflate(R.layout.post_list__parent,parent ,false);
            refresh_layout = (SwipeRefreshLayout) root.findViewById( R.id.refresh_layout);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public PostList_Parent() {
            this(AppUtil.getContext(),null);
        }

        public PostList_Parent(Context context) {
            this(context ,null);
        }

        public PostList_Parent(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PostRow_Compact {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public XTextView date;
        public VAvatarView avatar;
        public XTextView fullname;
        public XTextView text;
        public PercentFrameLayout image_holder;
        public VPostComactImageView image;
        public LinearLayout counts_info;
        public XIcon comment_count;
        public XIcon likes_count;
        public XIcon like_btn;

        public PostRow_Compact(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.post_row__compact,parent ,false);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            date = (XTextView) root.findViewById( R.id.date);
            avatar = (VAvatarView) root.findViewById( R.id.avatar);
            fullname = (XTextView) root.findViewById( R.id.fullname);
            text = (XTextView) root.findViewById( R.id.text);
            image_holder = (PercentFrameLayout) root.findViewById( R.id.image_holder);
            image = (VPostComactImageView) root.findViewById( R.id.image);
            counts_info = (LinearLayout) root.findViewById( R.id.counts_info);
            comment_count = (XIcon) root.findViewById( R.id.comment_count);
            likes_count = (XIcon) root.findViewById( R.id.likes_count);
            like_btn = (XIcon) root.findViewById( R.id.like_btn);
        }
        public PostRow_Compact() {
            this(AppUtil.getContext(),null);
        }

        public PostRow_Compact(Context context) {
            this(context ,null);
        }

        public PostRow_Compact(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PostRow_Stream {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public XTextView date;
        public VAvatarView avatar;
        public XTextView fullname;
        public XTextView text;
        public VPostImageView image;
        public LinearLayout counts_info;
        public XIcon comment_count;
        public XIcon likes_count;
        public XIcon like_btn;

        public PostRow_Stream(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.post_row__stream,parent ,false);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            date = (XTextView) root.findViewById( R.id.date);
            avatar = (VAvatarView) root.findViewById( R.id.avatar);
            fullname = (XTextView) root.findViewById( R.id.fullname);
            text = (XTextView) root.findViewById( R.id.text);
            image = (VPostImageView) root.findViewById( R.id.image);
            counts_info = (LinearLayout) root.findViewById( R.id.counts_info);
            comment_count = (XIcon) root.findViewById( R.id.comment_count);
            likes_count = (XIcon) root.findViewById( R.id.likes_count);
            like_btn = (XIcon) root.findViewById( R.id.like_btn);
        }
        public PostRow_Stream() {
            this(AppUtil.getContext(),null);
        }

        public PostRow_Stream(Context context) {
            this(context ,null);
        }

        public PostRow_Stream(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class PresenterGalleryChooser {
        public LinearLayout root;
        public TabLayout tab_layout;
        public ViewPager view_pager;

        public PresenterGalleryChooser(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.presenter_gallery_chooser,parent ,false);
            tab_layout = (TabLayout) root.findViewById( R.id.tab_layout);
            view_pager = (ViewPager) root.findViewById( R.id.view_pager);
        }
        public PresenterGalleryChooser() {
            this(AppUtil.getContext(),null);
        }

        public PresenterGalleryChooser(Context context) {
            this(context ,null);
        }

        public PresenterGalleryChooser(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Profile_Parent {
        public LinearLayout root;
        public XTopNav top_nav;
        public FrameLayout container;

        public Profile_Parent(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.profile__parent,parent ,false);
            top_nav = (XTopNav) root.findViewById( R.id.top_nav);
            container = (FrameLayout) root.findViewById( R.id.container);
        }
        public Profile_Parent() {
            this(AppUtil.getContext(),null);
        }

        public Profile_Parent(Context context) {
            this(context ,null);
        }

        public Profile_Parent(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Profile_TopInfo {
        public LinearLayout root;
        public LinearLayout count_holder;
        public LinearLayout followings_holder;
        public XTextView followings_count;
        public LinearLayout followers_holder;
        public XTextView followers_count;
        public XTextView posts_count;
        public ButtonGrayView button_edit_profile;
        public ChatButtonView chat_button;
        public FollowingButtonView follow_button;
        public SimpleDraweeView avatar;
        public XTextView fullname;
        public XTextView about;

        public Profile_TopInfo(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.profile__top_info,parent ,false);
            count_holder = (LinearLayout) root.findViewById( R.id.count_holder);
            followings_holder = (LinearLayout) root.findViewById( R.id.followings_holder);
            followings_count = (XTextView) root.findViewById( R.id.followings_count);
            followers_holder = (LinearLayout) root.findViewById( R.id.followers_holder);
            followers_count = (XTextView) root.findViewById( R.id.followers_count);
            posts_count = (XTextView) root.findViewById( R.id.posts_count);
            button_edit_profile = (ButtonGrayView) root.findViewById( R.id.button_edit_profile);
            chat_button = (ChatButtonView) root.findViewById( R.id.chat_button);
            follow_button = (FollowingButtonView) root.findViewById( R.id.follow_button);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            fullname = (XTextView) root.findViewById( R.id.fullname);
            about = (XTextView) root.findViewById( R.id.about);
        }
        public Profile_TopInfo() {
            this(AppUtil.getContext(),null);
        }

        public Profile_TopInfo(Context context) {
            this(context ,null);
        }

        public Profile_TopInfo(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class RecentImages_ImageItem {
        public FrameLayout root;
        public SimpleDraweeView image;
        public FrameLayout text_holder;
        public XRawIcon text_icon;

        public RecentImages_ImageItem(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.recent_images__image_item,parent ,false);
            image = (SimpleDraweeView) root.findViewById( R.id.image);
            text_holder = (FrameLayout) root.findViewById( R.id.text_holder);
            text_icon = (XRawIcon) root.findViewById( R.id.text_icon);
        }
        public RecentImages_ImageItem() {
            this(AppUtil.getContext(),null);
        }

        public RecentImages_ImageItem(Context context) {
            this(context ,null);
        }

        public RecentImages_ImageItem(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class RecentImagesAddPost_ImageItem {
        public FrameLayout root;
        public SimpleDraweeView image_drawee;
        public FrameLayout text_holder;
        public XRawIcon text_icon;

        public RecentImagesAddPost_ImageItem(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.recent_images_add_post__image_item,parent ,false);
            image_drawee = (SimpleDraweeView) root.findViewById( R.id.image_drawee);
            text_holder = (FrameLayout) root.findViewById( R.id.text_holder);
            text_icon = (XRawIcon) root.findViewById( R.id.text_icon);
        }
        public RecentImagesAddPost_ImageItem() {
            this(AppUtil.getContext(),null);
        }

        public RecentImagesAddPost_ImageItem(Context context) {
            this(context ,null);
        }

        public RecentImagesAddPost_ImageItem(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class RecentImagesPostBox_RecyclerView {
        public RecyclerView root;
        public RecyclerView recycler_view;

        public RecentImagesPostBox_RecyclerView(Context context,ViewGroup parent) {
            root = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.recent_images_post_box__recycler_view,parent ,false);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }
        public RecentImagesPostBox_RecyclerView() {
            this(AppUtil.getContext(),null);
        }

        public RecentImagesPostBox_RecyclerView(Context context) {
            this(context ,null);
        }

        public RecentImagesPostBox_RecyclerView(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Recommend_TopTags {
        public RelativeLayout root;
        public XTextView text;
        public IconTextView see_more;
        public ImageView image1;
        public ImageView image3;
        public ImageView image2;

        public Recommend_TopTags(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.recommend__top_tags,parent ,false);
            text = (XTextView) root.findViewById( R.id.text);
            see_more = (IconTextView) root.findViewById( R.id.see_more);
            image1 = (ImageView) root.findViewById( R.id.image1);
            image3 = (ImageView) root.findViewById( R.id.image3);
            image2 = (ImageView) root.findViewById( R.id.image2);
        }
        public Recommend_TopTags() {
            this(AppUtil.getContext(),null);
        }

        public Recommend_TopTags(Context context) {
            this(context ,null);
        }

        public Recommend_TopTags(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Recommend_UserRow {
        public RelativeLayout root;
        public FollowingButtonView following_button;
        public IconTextView ignore;
        public ImageView avatar;
        public LinearLayout top;
        public XTextView primary_name;
        public XTextView second_name;
        public XTextView about;

        public Recommend_UserRow(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.recommend__user_row,parent ,false);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            ignore = (IconTextView) root.findViewById( R.id.ignore);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            top = (LinearLayout) root.findViewById( R.id.top);
            primary_name = (XTextView) root.findViewById( R.id.primary_name);
            second_name = (XTextView) root.findViewById( R.id.second_name);
            about = (XTextView) root.findViewById( R.id.about);
        }
        public Recommend_UserRow() {
            this(AppUtil.getContext(),null);
        }

        public Recommend_UserRow(Context context) {
            this(context ,null);
        }

        public Recommend_UserRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class RowTagSimple {
        public RelativeLayout root;
        public XRawIcon icon;
        public XTextView text;
        public XTextView count;

        public RowTagSimple(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.row_tag_simple,parent ,false);
            icon = (XRawIcon) root.findViewById( R.id.icon);
            text = (XTextView) root.findViewById( R.id.text);
            count = (XTextView) root.findViewById( R.id.count);
        }
        public RowTagSimple() {
            this(AppUtil.getContext(),null);
        }

        public RowTagSimple(Context context) {
            this(context ,null);
        }

        public RowTagSimple(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Rv_EmptyNote {
        public RelativeLayout root;
        public LinearLayout reload;
        public XTextView empty_note;

        public Rv_EmptyNote(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.rv__empty_note,parent ,false);
            reload = (LinearLayout) root.findViewById( R.id.reload);
            empty_note = (XTextView) root.findViewById( R.id.empty_note);
        }
        public Rv_EmptyNote() {
            this(AppUtil.getContext(),null);
        }

        public Rv_EmptyNote(Context context) {
            this(context ,null);
        }

        public Rv_EmptyNote(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Rv_FailedReload {
        public RelativeLayout root;
        public LinearLayout reload;
        public XTextView not_internet;

        public Rv_FailedReload(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.rv__failed_reload,parent ,false);
            reload = (LinearLayout) root.findViewById( R.id.reload);
            not_internet = (XTextView) root.findViewById( R.id.not_internet);
        }
        public Rv_FailedReload() {
            this(AppUtil.getContext(),null);
        }

        public Rv_FailedReload(Context context) {
            this(context ,null);
        }

        public Rv_FailedReload(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Settings_Block {
        public LinearLayout root;
        public XTextView title;
        public LinearLayout rows_container;

        public Settings_Block(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.settings__block,parent ,false);
            title = (XTextView) root.findViewById( R.id.title);
            rows_container = (LinearLayout) root.findViewById( R.id.rows_container);
        }
        public Settings_Block() {
            this(AppUtil.getContext(),null);
        }

        public Settings_Block(Context context) {
            this(context ,null);
        }

        public Settings_Block(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Settings_RowNoteCenter {
        public FrameLayout root;
        public XTextView title;

        public Settings_RowNoteCenter(Context context,ViewGroup parent) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.settings__row_note_center,parent ,false);
            title = (XTextView) root.findViewById( R.id.title);
        }
        public Settings_RowNoteCenter() {
            this(AppUtil.getContext(),null);
        }

        public Settings_RowNoteCenter(Context context) {
            this(context ,null);
        }

        public Settings_RowNoteCenter(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Settings_RowSimple {
        public RelativeLayout root;
        public XTextView title;
        public XTextView info;
        public RelativeLayout left_container;
        public XRawIcon has_page;
        public SwitchCompat switch_btn;

        public Settings_RowSimple(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.settings__row_simple,parent ,false);
            title = (XTextView) root.findViewById( R.id.title);
            info = (XTextView) root.findViewById( R.id.info);
            left_container = (RelativeLayout) root.findViewById( R.id.left_container);
            has_page = (XRawIcon) root.findViewById( R.id.has_page);
            switch_btn = (SwitchCompat) root.findViewById( R.id.switch_btn);
        }
        public Settings_RowSimple() {
            this(AppUtil.getContext(),null);
        }

        public Settings_RowSimple(Context context) {
            this(context ,null);
        }

        public Settings_RowSimple(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class TabCellGeneral {
        public LinearLayout root;
        public XTextView textView;
        public ImageView imgView;

        public TabCellGeneral(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.tab_cell_general,parent ,false);
            textView = (XTextView) root.findViewById( R.id.textView);
            imgView = (ImageView) root.findViewById( R.id.imgView);
        }
        public TabCellGeneral() {
            this(AppUtil.getContext(),null);
        }

        public TabCellGeneral(Context context) {
            this(context ,null);
        }

        public TabCellGeneral(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Title_ClickableNewPage {
        public RelativeLayout root;
        public XRawIcon icon;
        public XTextView text_view;

        public Title_ClickableNewPage(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.title__clickable_new_page,parent ,false);
            icon = (XRawIcon) root.findViewById( R.id.icon);
            text_view = (XTextView) root.findViewById( R.id.text_view);
        }
        public Title_ClickableNewPage() {
            this(AppUtil.getContext(),null);
        }

        public Title_ClickableNewPage(Context context) {
            this(context ,null);
        }

        public Title_ClickableNewPage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Title_Info {
        public RelativeLayout root;
        public XTextView text_view;

        public Title_Info(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.title__info,parent ,false);
            text_view = (XTextView) root.findViewById( R.id.text_view);
        }
        public Title_Info() {
            this(AppUtil.getContext(),null);
        }

        public Title_Info(Context context) {
            this(context ,null);
        }

        public Title_Info(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Title_InfoLight {
        public RelativeLayout root;
        public XTextView text_view;

        public Title_InfoLight(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.title__info_light,parent ,false);
            text_view = (XTextView) root.findViewById( R.id.text_view);
        }
        public Title_InfoLight() {
            this(AppUtil.getContext(),null);
        }

        public Title_InfoLight(Context context) {
            this(context ,null);
        }

        public Title_InfoLight(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class UserList_RowFollowAbout {
        public RelativeLayout root;
        public FollowingButtonView following_button;
        public SimpleDraweeView avatar;
        public LinearLayout top;
        public XTextView primary_name;
        public XTextView second_name;
        public XTextView about;

        public UserList_RowFollowAbout(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.user_list__row_follow_about,parent ,false);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            top = (LinearLayout) root.findViewById( R.id.top);
            primary_name = (XTextView) root.findViewById( R.id.primary_name);
            second_name = (XTextView) root.findViewById( R.id.second_name);
            about = (XTextView) root.findViewById( R.id.about);
        }
        public UserList_RowFollowAbout() {
            this(AppUtil.getContext(),null);
        }

        public UserList_RowFollowAbout(Context context) {
            this(context ,null);
        }

        public UserList_RowFollowAbout(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class UserList_TypeFollowRow {
        public UserListGeneralFollowRowWhithBorderLinearLayout root;
        public FollowingButtonView following_button;
        public XTextView primary_name;
        public XTextView second_name;
        public SimpleDraweeView avatar;

        public UserList_TypeFollowRow(Context context,ViewGroup parent) {
            root = (UserListGeneralFollowRowWhithBorderLinearLayout) LayoutInflater.from(context).inflate(R.layout.user_list__type_follow_row,parent ,false);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            primary_name = (XTextView) root.findViewById( R.id.primary_name);
            second_name = (XTextView) root.findViewById( R.id.second_name);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
        }
        public UserList_TypeFollowRow() {
            this(AppUtil.getContext(),null);
        }

        public UserList_TypeFollowRow(Context context) {
            this(context ,null);
        }

        public UserList_TypeFollowRow(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ViewPostCompactImage {
        public SimpleDraweeView root;
        public SimpleDraweeView post_row_holder;

        public ViewPostCompactImage(Context context,ViewGroup parent) {
            root = (SimpleDraweeView) LayoutInflater.from(context).inflate(R.layout.view_post_compact_image,parent ,false);
            post_row_holder = (SimpleDraweeView) root.findViewById( R.id.post_row_holder);
        }
        public ViewPostCompactImage() {
            this(AppUtil.getContext(),null);
        }

        public ViewPostCompactImage(Context context) {
            this(context ,null);
        }

        public ViewPostCompactImage(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class ViewRecyclerView {
        public RecyclerView root;

        public ViewRecyclerView(Context context,ViewGroup parent) {
            root = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.view_recycler_view,parent ,false);
        }
        public ViewRecyclerView() {
            this(AppUtil.getContext(),null);
        }

        public ViewRecyclerView(Context context) {
            this(context ,null);
        }

        public ViewRecyclerView(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class Widget_PlaySample {
        public RelativeLayout root;
        public RelativeLayout window;
        public PhotoDraweeView image_view;
        public LinearLayout top_nav;
        public EmojiconTextView text_view;

        public Widget_PlaySample(Context context,ViewGroup parent) {
            root = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.widget__play_sample,parent ,false);
            window = (RelativeLayout) root.findViewById( R.id.window);
            image_view = (PhotoDraweeView) root.findViewById( R.id.image_view);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            text_view = (EmojiconTextView) root.findViewById( R.id.text_view);
        }
        public Widget_PlaySample() {
            this(AppUtil.getContext(),null);
        }

        public Widget_PlaySample(Context context) {
            this(context ,null);
        }

        public Widget_PlaySample(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class WidgetAddSimpleText {
        public LinearLayout root;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public EmojiconEditText input;
        public Button send_btn;

        public WidgetAddSimpleText(Context context,ViewGroup parent) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.widget_add_simple_text,parent ,false);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            input = (EmojiconEditText) root.findViewById( R.id.input);
            send_btn = (Button) root.findViewById( R.id.send_btn);
        }
        public WidgetAddSimpleText() {
            this(AppUtil.getContext(),null);
        }

        public WidgetAddSimpleText(Context context) {
            this(context ,null);
        }

        public WidgetAddSimpleText(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class WidgetTextAndIcon {
        public ViewGroup root;
        public XTextView text;
        public TextView icon;

        public WidgetTextAndIcon(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.widget_text_and_icon,parent,true);//for Compound Views
            
            text = (XTextView) root.findViewById( R.id.text);
            icon = (TextView) root.findViewById( R.id.icon);
        }//Compound Views Must have parent otherwise will panic

        public WidgetTextAndIcon(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

    public static class X_TopNav {
        public ViewGroup root;
        public LinearLayout left_container;
        public XTextView left_text;
        public XTextView title_text;
        public XIcon back_btn;

        public X_TopNav(Context context,ViewGroup parent) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.x__top_nav_,parent,true);//for Compound Views
            
            left_container = (LinearLayout) root.findViewById( R.id.left_container);
            left_text = (XTextView) root.findViewById( R.id.left_text);
            title_text = (XTextView) root.findViewById( R.id.title_text);
            back_btn = (XIcon) root.findViewById( R.id.back_btn);
        }//Compound Views Must have parent otherwise will panic

        public X_TopNav(ViewGroup parent) {
            this(AppUtil.getContext() ,parent);
        }
    }

}

////////////////////////////////
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.FrameLayout;
//import android.widget.GridView;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.Space;
//import android.widget.TextView;
//import android.widget.View;
