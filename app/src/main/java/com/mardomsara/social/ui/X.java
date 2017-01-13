
package com.mardomsara.social.ui;

import android.widget.*;
import android.view.*;
import android.webkit.WebView;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.joanzapata.iconify.widget.IconTextView;
import com.mardomsara.emojicon.EmojiconEditText;
import com.mardomsara.emojicon.EmojiconTextView;
import com.mardomsara.social.ui.views.EmojiLinkerTextView;
import com.mardomsara.social.ui.views.play.TextViewWithIcon;
import com.mardomsara.social.ui.views.wigets.BadgeCount;
import com.mardomsara.social.ui.views.wigets.ButtonGrayView;
import com.mardomsara.social.ui.views.wigets.ChatButtonView;
import com.mardomsara.social.ui.views.wigets.ChatListRowWhithBorderLinearLayout;
import com.mardomsara.social.ui.views.wigets.CountView;
import com.mardomsara.social.ui.views.wigets.FollowingButtonView;
import com.mardomsara.social.ui.views.wigets.LoadingView;
import com.mardomsara.social.ui.views.wigets.SimpleAddText;
import com.mardomsara.social.ui.views.wigets.SimpleText;
import com.mardomsara.social.ui.views.wigets.SimpleTopNav;
import com.mardomsara.social.ui.views.wigets.UserListGeneralFollowRowWhithBorderLinearLayout;
import me.relex.photodraweeview.PhotoDraweeView;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.R;

public class X {
    

    public static class ActivityCrop {
        public LinearLayout root;
        public Button gallery;
        public Button take_picture;
        public ImageView image;

        public ActivityCrop(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.activity_crop,parent);
            gallery = (Button) root.findViewById( R.id.gallery);
            take_picture = (Button) root.findViewById( R.id.take_picture);
            image = (ImageView) root.findViewById( R.id.image);
        }

        public ActivityCrop() {
            this(null);
        }
    }


    public static class ActivityMainApp {
        public LinearLayout root;
        public LinearLayout global_window;
        public FrameLayout frag1;
        public FrameLayout footerbar_holder;
        public FrameLayout dialog;

        public ActivityMainApp(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.activity_main_app,parent);
            global_window = (LinearLayout) root.findViewById( R.id.global_window);
            frag1 = (FrameLayout) root.findViewById( R.id.frag1);
            footerbar_holder = (FrameLayout) root.findViewById( R.id.footerbar_holder);
            dialog = (FrameLayout) root.findViewById( R.id.dialog);
        }

        public ActivityMainApp() {
            this(null);
        }
    }


    public static class ActivityPlayAdvanced {
        public ScrollView root;
        public TextView output;

        public ActivityPlayAdvanced(ViewGroup parent) {
            root = (ScrollView) AppUtil.inflate(R.layout.activity_play_advanced,parent);
            output = (TextView) root.findViewById( R.id.output);
        }

        public ActivityPlayAdvanced() {
            this(null);
        }
    }


    public static class CellCommontsWithField {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public LinearLayout content;
        public SimpleAddText simpleAddText;

        public CellCommontsWithField(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cell_commonts_with_field,parent);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            content = (LinearLayout) root.findViewById( R.id.content);
            simpleAddText = (SimpleAddText) root.findViewById( R.id.simpleAddText);
        }

        public CellCommontsWithField() {
            this(null);
        }
    }


    public static class CellListUserTypeFollowAboutRow {
        public RelativeLayout root;
        public FollowingButtonView following_button;
        public SimpleDraweeView avatar;
        public LinearLayout top;
        public EmojiconTextView primary_name;
        public EmojiconTextView second_name;
        public EmojiconTextView about;

        public CellListUserTypeFollowAboutRow(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cell_list_user_type_follow_about_row,parent);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            top = (LinearLayout) root.findViewById( R.id.top);
            primary_name = (EmojiconTextView) root.findViewById( R.id.primary_name);
            second_name = (EmojiconTextView) root.findViewById( R.id.second_name);
            about = (EmojiconTextView) root.findViewById( R.id.about);
        }

        public CellListUserTypeFollowAboutRow() {
            this(null);
        }
    }


    public static class CellLoading {
        public RelativeLayout root;
        public CircularProgressView loadingView;

        public CellLoading(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cell_loading,parent);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
        }

        public CellLoading() {
            this(null);
        }
    }


    public static class CellPageCellNavRecylcerView {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;
        public RecyclerView recycler_view;

        public CellPageCellNavRecylcerView(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.cell_page_cell_nav_recylcer_view,parent);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }

        public CellPageCellNavRecylcerView() {
            this(null);
        }
    }


    public static class CellPageCommingSoon {
        public RelativeLayout root;

        public CellPageCommingSoon(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cell_page_comming_soon,parent);
        }

        public CellPageCommingSoon() {
            this(null);
        }
    }


    public static class CellRowCommont {
        public RelativeLayout root;
        public SimpleDraweeView avatar;
        public TextView fullname;
        public TextView date;
        public CircularProgressView loadingView;
        public EmojiconTextView text;

        public CellRowCommont(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cell_row_commont,parent);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            fullname = (TextView) root.findViewById( R.id.fullname);
            date = (TextView) root.findViewById( R.id.date);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
            text = (EmojiconTextView) root.findViewById( R.id.text);
        }

        public CellRowCommont() {
            this(null);
        }
    }


    public static class CellsKeywoardAttachment {
        public LinearLayout root;
        public LinearLayout attachment_top;
        public LinearLayout attachment_main;
        public RelativeLayout frame_layout;
        public LinearLayout attach_video;
        public LinearLayout attach_gallery;
        public LinearLayout attach_camera;
        public LinearLayout attach_location;
        public LinearLayout attach_file;
        public LinearLayout close_send_btn;
        public TextView close_icon;
        public TextView close_text;

        public CellsKeywoardAttachment(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.cells_keywoard_attachment,parent);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            attachment_main = (LinearLayout) root.findViewById( R.id.attachment_main);
            frame_layout = (RelativeLayout) root.findViewById( R.id.frame_layout);
            attach_video = (LinearLayout) root.findViewById( R.id.attach_video);
            attach_gallery = (LinearLayout) root.findViewById( R.id.attach_gallery);
            attach_camera = (LinearLayout) root.findViewById( R.id.attach_camera);
            attach_location = (LinearLayout) root.findViewById( R.id.attach_location);
            attach_file = (LinearLayout) root.findViewById( R.id.attach_file);
            close_send_btn = (LinearLayout) root.findViewById( R.id.close_send_btn);
            close_icon = (TextView) root.findViewById( R.id.close_icon);
            close_text = (TextView) root.findViewById( R.id.close_text);
        }

        public CellsKeywoardAttachment() {
            this(null);
        }
    }


    public static class ChatListRow {
        public ChatListRowWhithBorderLinearLayout root;
        public TextView date_txt;
        public EmojiconTextView name_txt;
        public CountView unseen_count_txt;
        public EmojiconTextView last_msg_txt;
        public SimpleDraweeView avatar;

        public ChatListRow(ViewGroup parent) {
            root = (ChatListRowWhithBorderLinearLayout) AppUtil.inflate(R.layout.chat_list_row,parent);
            date_txt = (TextView) root.findViewById( R.id.date_txt);
            name_txt = (EmojiconTextView) root.findViewById( R.id.name_txt);
            unseen_count_txt = (CountView) root.findViewById( R.id.unseen_count_txt);
            last_msg_txt = (EmojiconTextView) root.findViewById( R.id.last_msg_txt);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
        }

        public ChatListRow() {
            this(null);
        }
    }


    public static class ChatListRow2 {
        public RelativeLayout root;
        public SimpleDraweeView avatar;
        public TextView top_txt;
        public TextView bottom_txt;

        public ChatListRow2(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.chat_list_row2,parent);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            top_txt = (TextView) root.findViewById( R.id.top_txt);
            bottom_txt = (TextView) root.findViewById( R.id.bottom_txt);
        }

        public ChatListRow2() {
            this(null);
        }
    }


    public static class ChatListRow_Realative {
        public ChatListRowWhithBorderLinearLayout root;
        public SimpleDraweeView avatar;
        public EmojiconTextView name_txt;
        public TextView date_txt;
        public CountView unseen_count_txt;
        public EmojiconTextView last_msg_txt;

        public ChatListRow_Realative(ViewGroup parent) {
            root = (ChatListRowWhithBorderLinearLayout) AppUtil.inflate(R.layout.chat_list_row___realative,parent);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            name_txt = (EmojiconTextView) root.findViewById( R.id.name_txt);
            date_txt = (TextView) root.findViewById( R.id.date_txt);
            unseen_count_txt = (CountView) root.findViewById( R.id.unseen_count_txt);
            last_msg_txt = (EmojiconTextView) root.findViewById( R.id.last_msg_txt);
        }

        public ChatListRow_Realative() {
            this(null);
        }
    }


    public static class Cropimage {
        public RelativeLayout root;
        public Button discard;
        public ImageButton rotateLeft;
        public ImageButton rotateRight;
        public Button save;

        public Cropimage(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.cropimage,parent);
            discard = (Button) root.findViewById( R.id.discard);
            rotateLeft = (ImageButton) root.findViewById( R.id.rotateLeft);
            rotateRight = (ImageButton) root.findViewById( R.id.rotateRight);
            save = (Button) root.findViewById( R.id.save);
        }

        public Cropimage() {
            this(null);
        }
    }


    public static class DialogBaseContainer {
        public FrameLayout root;
        public FrameLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_content_container;

        public DialogBaseContainer(ViewGroup parent) {
            root = (FrameLayout) AppUtil.inflate(R.layout.dialog_base_container,parent);
            dialogplus_outmost_container = (FrameLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_content_container = (FrameLayout) root.findViewById( R.id.dialogplus_content_container);
        }

        public DialogBaseContainer() {
            this(null);
        }
    }


    public static class DialogGrid {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_header_container;
        public GridView dialogplus_list;
        public FrameLayout dialogplus_footer_container;

        public DialogGrid(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_grid,parent);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_header_container = (FrameLayout) root.findViewById( R.id.dialogplus_header_container);
            dialogplus_list = (GridView) root.findViewById( R.id.dialogplus_list);
            dialogplus_footer_container = (FrameLayout) root.findViewById( R.id.dialogplus_footer_container);
        }

        public DialogGrid() {
            this(null);
        }
    }


    public static class DialogList {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public ListView dialogplus_list;

        public DialogList(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_list,parent);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_list = (ListView) root.findViewById( R.id.dialogplus_list);
        }

        public DialogList() {
            this(null);
        }
    }


    public static class DialogOptionsRoomRow {
        public LinearLayout root;
        public TextView text;
        public ListView list_view;

        public DialogOptionsRoomRow(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_options_room_row,parent);
            text = (TextView) root.findViewById( R.id.text);
            list_view = (ListView) root.findViewById( R.id.list_view);
        }

        public DialogOptionsRoomRow() {
            this(null);
        }
    }


    public static class DialogOptionsRoomRow2 {
        public LinearLayout root;
        public TextView profile;
        public TextView delete;
        public TextView clear;

        public DialogOptionsRoomRow2(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_options_room_row2,parent);
            profile = (TextView) root.findViewById( R.id.profile);
            delete = (TextView) root.findViewById( R.id.delete);
            clear = (TextView) root.findViewById( R.id.clear);
        }

        public DialogOptionsRoomRow2() {
            this(null);
        }
    }


    public static class DialogSimpleAlert {
        public LinearLayout root;
        public TextView title;
        public TextView body;
        public TextView close;

        public DialogSimpleAlert(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_simple_alert,parent);
            title = (TextView) root.findViewById( R.id.title);
            body = (TextView) root.findViewById( R.id.body);
            close = (TextView) root.findViewById( R.id.close);
        }

        public DialogSimpleAlert() {
            this(null);
        }
    }


    public static class DialogSimpleBody {
        public TextView root;

        public DialogSimpleBody(ViewGroup parent) {
            root = (TextView) AppUtil.inflate(R.layout.dialog_simple_body,parent);
        }

        public DialogSimpleBody() {
            this(null);
        }
    }


    public static class DialogSimpleClose {
        public TextView root;

        public DialogSimpleClose(ViewGroup parent) {
            root = (TextView) AppUtil.inflate(R.layout.dialog_simple_close,parent);
        }

        public DialogSimpleClose() {
            this(null);
        }
    }


    public static class DialogSimpleMenuString {
        public TextView root;

        public DialogSimpleMenuString(ViewGroup parent) {
            root = (TextView) AppUtil.inflate(R.layout.dialog_simple_menu_string,parent);
        }

        public DialogSimpleMenuString() {
            this(null);
        }
    }


    public static class DialogSimpleTitle {
        public TextView root;

        public DialogSimpleTitle(ViewGroup parent) {
            root = (TextView) AppUtil.inflate(R.layout.dialog_simple_title,parent);
        }

        public DialogSimpleTitle() {
            this(null);
        }
    }


    public static class DialogView {
        public LinearLayout root;
        public LinearLayout dialogplus_outmost_container;
        public FrameLayout dialogplus_header_container;
        public FrameLayout dialogplus_view_container;
        public FrameLayout dialogplus_footer_container;

        public DialogView(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.dialog_view,parent);
            dialogplus_outmost_container = (LinearLayout) root.findViewById( R.id.dialogplus_outmost_container);
            dialogplus_header_container = (FrameLayout) root.findViewById( R.id.dialogplus_header_container);
            dialogplus_view_container = (FrameLayout) root.findViewById( R.id.dialogplus_view_container);
            dialogplus_footer_container = (FrameLayout) root.findViewById( R.id.dialogplus_footer_container);
        }

        public DialogView() {
            this(null);
        }
    }


    public static class FragmentChatEnteryPage {
        public LinearLayout root;
        public ImageView imageView;
        public RecyclerView recycler_view;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public EmojiconEditText edit_filed;
        public Button attach;
        public Button send_msg;
        public FrameLayout emoji_window_holder;

        public FragmentChatEnteryPage(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.fragment_chat_entery_page,parent);
            imageView = (ImageView) root.findViewById( R.id.imageView);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            edit_filed = (EmojiconEditText) root.findViewById( R.id.edit_filed);
            attach = (Button) root.findViewById( R.id.attach);
            send_msg = (Button) root.findViewById( R.id.send_msg);
            emoji_window_holder = (FrameLayout) root.findViewById( R.id.emoji_window_holder);
        }

        public FragmentChatEnteryPage() {
            this(null);
        }
    }


    public static class FragmentFooterBar {
        public LinearLayout root;
        public TextView profile;
        public TextView activity;
        public TextView search;
        public TextView home;
        public TextView chat;

        public FragmentFooterBar(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.fragment_footer_bar,parent);
            profile = (TextView) root.findViewById( R.id.profile);
            activity = (TextView) root.findViewById( R.id.activity);
            search = (TextView) root.findViewById( R.id.search);
            home = (TextView) root.findViewById( R.id.home);
            chat = (TextView) root.findViewById( R.id.chat);
        }

        public FragmentFooterBar() {
            this(null);
        }
    }


    public static class FragmentHomePage {
        public LinearLayout root;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public FragmentHomePage(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.fragment_home_page,parent);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }

        public FragmentHomePage() {
            this(null);
        }
    }


    public static class FragmentMain {
        public RelativeLayout root;
        public TextView section_label;

        public FragmentMain(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.fragment_main,parent);
            section_label = (TextView) root.findViewById( R.id.section_label);
        }

        public FragmentMain() {
            this(null);
        }
    }


    public static class FragmentSinglePresenter {
        public FrameLayout root;

        public FragmentSinglePresenter(ViewGroup parent) {
            root = (FrameLayout) AppUtil.inflate(R.layout.fragment_single_presenter,parent);
        }

        public FragmentSinglePresenter() {
            this(null);
        }
    }


    public static class GalleryChooserFoldersRecyiclerView {
        public LinearLayout root;
        public RecyclerView recycler_view;

        public GalleryChooserFoldersRecyiclerView(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.gallery_chooser_folders_recyicler_view,parent);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }

        public GalleryChooserFoldersRecyiclerView() {
            this(null);
        }
    }


    public static class HeaderChatEntary {
        public RelativeLayout root;
        public TextView room_name;
        public ImageView avatar;
        public TextView back;

        public HeaderChatEntary(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.header_chat_entary,parent);
            room_name = (TextView) root.findViewById( R.id.room_name);
            avatar = (ImageView) root.findViewById( R.id.avatar);
            back = (TextView) root.findViewById( R.id.back);
        }

        public HeaderChatEntary() {
            this(null);
        }
    }


    public static class HelloWorld {
        public LinearLayout root;

        public HelloWorld(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.hello_world,parent);
        }

        public HelloWorld() {
            this(null);
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

        public HelloWorldRow(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.hello_world_row,parent);
            loadingView = (CircularProgressView) root.findViewById( R.id.loadingView);
            txt = (TextView) root.findViewById( R.id.txt);
            btn = (Button) root.findViewById( R.id.btn);
            btn2 = (Button) root.findViewById( R.id.btn2);
            btn3 = (Button) root.findViewById( R.id.btn3);
            anvil = (LinearLayout) root.findViewById( R.id.anvil);
            anvil2 = (LinearLayout) root.findViewById( R.id.anvil2);
        }

        public HelloWorldRow() {
            this(null);
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

        public KeywoardAttachment2(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.keywoard_attachment2,parent);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            attachment_main = (LinearLayout) root.findViewById( R.id.attachment_main);
            attach_camera = (LinearLayout) root.findViewById( R.id.attach_camera);
            attach_gallery = (LinearLayout) root.findViewById( R.id.attach_gallery);
            attach_video = (LinearLayout) root.findViewById( R.id.attach_video);
            attach_file = (LinearLayout) root.findViewById( R.id.attach_file);
            close_send_btn = (LinearLayout) root.findViewById( R.id.close_send_btn);
        }

        public KeywoardAttachment2() {
            this(null);
        }
    }


    public static class KeywoardEmoji {
        public LinearLayout root;
        public LinearLayout attachment_top;
        public LinearLayout emoji_window_holder2;

        public KeywoardEmoji(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.keywoard_emoji,parent);
            attachment_top = (LinearLayout) root.findViewById( R.id.attachment_top);
            emoji_window_holder2 = (LinearLayout) root.findViewById( R.id.emoji_window_holder2);
        }

        public KeywoardEmoji() {
            this(null);
        }
    }


    public static class ListRoomsPresenter {
        public LinearLayout root;
        public FrameLayout layout1;
        public RecyclerView contacts_list;

        public ListRoomsPresenter(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.list_rooms_presenter,parent);
            layout1 = (FrameLayout) root.findViewById( R.id.layout1);
            contacts_list = (RecyclerView) root.findViewById( R.id.contacts_list);
        }

        public ListRoomsPresenter() {
            this(null);
        }
    }


    public static class ListUserFollowRow {
        public LinearLayout root;
        public LinearLayout row;
        public TextView textView2;
        public TextView user;
        public SimpleDraweeView my_image_view;

        public ListUserFollowRow(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.list_user_follow_row,parent);
            row = (LinearLayout) root.findViewById( R.id.row);
            textView2 = (TextView) root.findViewById( R.id.textView2);
            user = (TextView) root.findViewById( R.id.user);
            my_image_view = (SimpleDraweeView) root.findViewById( R.id.my_image_view);
        }

        public ListUserFollowRow() {
            this(null);
        }
    }


    public static class ListviewPlanetTextview {
        public TextView root;
        public TextView listViewText;

        public ListviewPlanetTextview(ViewGroup parent) {
            root = (TextView) AppUtil.inflate(R.layout.listview_planet_textview,parent);
            listViewText = (TextView) root.findViewById( R.id.listViewText);
        }

        public ListviewPlanetTextview() {
            this(null);
        }
    }


    public static class Loading {
        public FrameLayout root;
        public CircularProgressView loading;

        public Loading(ViewGroup parent) {
            root = (FrameLayout) AppUtil.inflate(R.layout.loading,parent);
            loading = (CircularProgressView) root.findViewById( R.id.loading);
        }

        public Loading() {
            this(null);
        }
    }


    public static class Main {
        public LinearLayout root;
        public TextView textView;

        public Main(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.main,parent);
            textView = (TextView) root.findViewById( R.id.textView);
        }

        public Main() {
            this(null);
        }
    }


    public static class MainBranchChat {
        public LinearLayout root;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public MainBranchChat(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.main_branch_chat,parent);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }

        public MainBranchChat() {
            this(null);
        }
    }


    public static class MainPageChatPresenter {
        public LinearLayout root;

        public MainPageChatPresenter(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.main_page_chat_presenter,parent);
        }

        public MainPageChatPresenter() {
            this(null);
        }
    }


    public static class MediaChooserTopNav {
        public LinearLayout root;
        public LinearLayout left_side;
        public TextView send_btn;
        public TextView text_icon;
        public TextView back_btn;
        public TextView title;

        public MediaChooserTopNav(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.media_chooser_top_nav,parent);
            left_side = (LinearLayout) root.findViewById( R.id.left_side);
            send_btn = (TextView) root.findViewById( R.id.send_btn);
            text_icon = (TextView) root.findViewById( R.id.text_icon);
            back_btn = (TextView) root.findViewById( R.id.back_btn);
            title = (TextView) root.findViewById( R.id.title);
        }

        public MediaChooserTopNav() {
            this(null);
        }
    }


    public static class MsgEmpty {
        public FrameLayout root;

        public MsgEmpty(ViewGroup parent) {
            root = (FrameLayout) AppUtil.inflate(R.layout.msg_empty,parent);
        }

        public MsgEmpty() {
            this(null);
        }
    }


    public static class MsgRowAllMe {
        public LinearLayout root;
        public TextView txt;

        public MsgRowAllMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_all_me,parent);
            txt = (TextView) root.findViewById( R.id.txt);
        }

        public MsgRowAllMe() {
            this(null);
        }
    }


    public static class MsgRowAllPeer {
        public LinearLayout root;
        public TextView txt;

        public MsgRowAllPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_all_peer,parent);
            txt = (TextView) root.findViewById( R.id.txt);
        }

        public MsgRowAllPeer() {
            this(null);
        }
    }


    public static class MsgRowAudioMe {
        public LinearLayout root;

        public MsgRowAudioMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_audio_me,parent);
        }

        public MsgRowAudioMe() {
            this(null);
        }
    }


    public static class MsgRowAudioPeer {
        public LinearLayout root;

        public MsgRowAudioPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_audio_peer,parent);
        }

        public MsgRowAudioPeer() {
            this(null);
        }
    }


    public static class MsgRowContactMe {
        public LinearLayout root;

        public MsgRowContactMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_contact_me,parent);
        }

        public MsgRowContactMe() {
            this(null);
        }
    }


    public static class MsgRowContactPeer {
        public LinearLayout root;

        public MsgRowContactPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_contact_peer,parent);
        }

        public MsgRowContactPeer() {
            this(null);
        }
    }


    public static class MsgRowFileMe {
        public LinearLayout root;

        public MsgRowFileMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_file_me,parent);
        }

        public MsgRowFileMe() {
            this(null);
        }
    }


    public static class MsgRowFilePeer {
        public LinearLayout root;

        public MsgRowFilePeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_file_peer,parent);
        }

        public MsgRowFilePeer() {
            this(null);
        }
    }


    public static class MsgRowImageMe {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public SimpleDraweeView msg_image;
        public EmojiconTextView msg_text;

        public MsgRowImageMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_image_me,parent);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
            msg_text = (EmojiconTextView) root.findViewById( R.id.msg_text);
        }

        public MsgRowImageMe() {
            this(null);
        }
    }


    public static class MsgRowImagePeer {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public SimpleDraweeView msg_image;

        public MsgRowImagePeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_image_peer,parent);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
        }

        public MsgRowImagePeer() {
            this(null);
        }
    }


    public static class MsgRowLocationMe {
        public LinearLayout root;

        public MsgRowLocationMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_location_me,parent);
        }

        public MsgRowLocationMe() {
            this(null);
        }
    }


    public static class MsgRowLocationPeer {
        public LinearLayout root;

        public MsgRowLocationPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_location_peer,parent);
        }

        public MsgRowLocationPeer() {
            this(null);
        }
    }


    public static class MsgRowPostMe {
        public LinearLayout root;

        public MsgRowPostMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_post_me,parent);
        }

        public MsgRowPostMe() {
            this(null);
        }
    }


    public static class MsgRowPostPeer {
        public LinearLayout root;

        public MsgRowPostPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_post_peer,parent);
        }

        public MsgRowPostPeer() {
            this(null);
        }
    }


    public static class MsgRowStickerMe {
        public LinearLayout root;

        public MsgRowStickerMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_sticker_me,parent);
        }

        public MsgRowStickerMe() {
            this(null);
        }
    }


    public static class MsgRowStickerPeer {
        public LinearLayout root;

        public MsgRowStickerPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_sticker_peer,parent);
        }

        public MsgRowStickerPeer() {
            this(null);
        }
    }


    public static class MsgRowSystem {
        public LinearLayout root;

        public MsgRowSystem(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_system,parent);
        }

        public MsgRowSystem() {
            this(null);
        }
    }


    public static class MsgRowTextMe {
        public LinearLayout root;
        public LinearLayout msg_content_holder;

        public MsgRowTextMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_text_me,parent);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
        }

        public MsgRowTextMe() {
            this(null);
        }
    }


    public static class MsgRowTextPeer {
        public LinearLayout root;
        public LinearLayout msg_content_holder;
        public EmojiconTextView msg_text;

        public MsgRowTextPeer(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_text_peer,parent);
            msg_content_holder = (LinearLayout) root.findViewById( R.id.msg_content_holder);
            msg_text = (EmojiconTextView) root.findViewById( R.id.msg_text);
        }

        public MsgRowTextPeer() {
            this(null);
        }
    }


    public static class MsgRowVideoMe {
        public LinearLayout root;
        public RelativeLayout msg_content_holder;
        public SimpleDraweeView msg_image;
        public EmojiconTextView msg_text;

        public MsgRowVideoMe(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_row_video_me,parent);
            msg_content_holder = (RelativeLayout) root.findViewById( R.id.msg_content_holder);
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
            msg_text = (EmojiconTextView) root.findViewById( R.id.msg_text);
        }

        public MsgRowVideoMe() {
            this(null);
        }
    }


    public static class MsgSharedTimeStatus {
        public LinearLayout root;
        public TextView msg_time;
        public TextView msg_delivery_status;

        public MsgSharedTimeStatus(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.msg_shared_time_status,parent);
            msg_time = (TextView) root.findViewById( R.id.msg_time);
            msg_delivery_status = (TextView) root.findViewById( R.id.msg_delivery_status);
        }

        public MsgSharedTimeStatus() {
            this(null);
        }
    }


    public static class NavHeaderPagerMenu {
        public LinearLayout root;
        public LinearLayout search;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public NavHeaderPagerMenu(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.nav_header_pager_menu,parent);
            search = (LinearLayout) root.findViewById( R.id.search);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }

        public NavHeaderPagerMenu() {
            this(null);
        }
    }


    public static class NotifyCell {
        public LinearLayout root;
        public FrameLayout frame_layout;
        public ImageView image_extra;
        public FollowingButtonView following_button;
        public EmojiconTextView text;
        public TextView date;
        public ImageView avatar;

        public NotifyCell(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.notify_cell,parent);
            frame_layout = (FrameLayout) root.findViewById( R.id.frame_layout);
            image_extra = (ImageView) root.findViewById( R.id.image_extra);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            text = (EmojiconTextView) root.findViewById( R.id.text);
            date = (TextView) root.findViewById( R.id.date);
            avatar = (ImageView) root.findViewById( R.id.avatar);
        }

        public NotifyCell() {
            this(null);
        }
    }


    public static class PlayActivityFontsScrolling {
        public ScrollView root;
        public Button btn;

        public PlayActivityFontsScrolling(ViewGroup parent) {
            root = (ScrollView) AppUtil.inflate(R.layout.play_activity_fonts_scrolling,parent);
            btn = (Button) root.findViewById( R.id.btn);
        }

        public PlayActivityFontsScrolling() {
            this(null);
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

        public PlayMainPopup(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.play_main_popup,parent);
            txt = (TextView) root.findViewById( R.id.txt);
            base64 = (Button) root.findViewById( R.id.base64);
            img = (ImageView) root.findViewById( R.id.img);
            img2 = (ImageView) root.findViewById( R.id.img2);
            dl = (Button) root.findViewById( R.id.dl);
            openpopup = (Button) root.findViewById( R.id.openpopup);
        }

        public PlayMainPopup() {
            this(null);
        }
    }


    public static class PlayRecipies {
        public LinearLayout root;
        public Button _status_bar;
        public Button p_navigation;
        public WebView webview;

        public PlayRecipies(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.play_recipies,parent);
            _status_bar = (Button) root.findViewById( R.id._status_bar);
            p_navigation = (Button) root.findViewById( R.id.p_navigation);
            webview = (WebView) root.findViewById( R.id.webview);
        }

        public PlayRecipies() {
            this(null);
        }
    }


    public static class PresenterCommonts {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public SimpleTopNav simpleTopNav;
        public SimpleAddText simpleAddText;
        public LinearLayout content;

        public PresenterCommonts(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.presenter_commonts,parent);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            simpleAddText = (SimpleAddText) root.findViewById( R.id.simpleAddText);
            content = (LinearLayout) root.findViewById( R.id.content);
        }

        public PresenterCommonts() {
            this(null);
        }
    }


    public static class PresenterGalleryChooser {
        public LinearLayout root;
        public TabLayout tab_layout;
        public ViewPager view_pager;

        public PresenterGalleryChooser(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.presenter_gallery_chooser,parent);
            tab_layout = (TabLayout) root.findViewById( R.id.tab_layout);
            view_pager = (ViewPager) root.findViewById( R.id.view_pager);
        }

        public PresenterGalleryChooser() {
            this(null);
        }
    }


    public static class PresenterGeneralUserListTypeFollow {
        public LinearLayout root;
        public LinearLayout post_row_holder;
        public SimpleTopNav simpleTopNav;
        public LoadingView loadingView;

        public PresenterGeneralUserListTypeFollow(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.presenter_general_user_list_type_follow,parent);
            post_row_holder = (LinearLayout) root.findViewById( R.id.post_row_holder);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
            loadingView = (LoadingView) root.findViewById( R.id.loadingView);
        }

        public PresenterGeneralUserListTypeFollow() {
            this(null);
        }
    }


    public static class PresenterListContactsFollowings {
        public LinearLayout root;
        public Button followings_btn;
        public Button contacts_btn;
        public LinearLayout layout1;
        public TextView empty_contacts_msg;
        public RecyclerView contacts_list;
        public FrameLayout layout2;
        public TextView empty_followings_msg;
        public RecyclerView followings_list;

        public PresenterListContactsFollowings(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.presenter_list_contacts_followings,parent);
            followings_btn = (Button) root.findViewById( R.id.followings_btn);
            contacts_btn = (Button) root.findViewById( R.id.contacts_btn);
            layout1 = (LinearLayout) root.findViewById( R.id.layout1);
            empty_contacts_msg = (TextView) root.findViewById( R.id.empty_contacts_msg);
            contacts_list = (RecyclerView) root.findViewById( R.id.contacts_list);
            layout2 = (FrameLayout) root.findViewById( R.id.layout2);
            empty_followings_msg = (TextView) root.findViewById( R.id.empty_followings_msg);
            followings_list = (RecyclerView) root.findViewById( R.id.followings_list);
        }

        public PresenterListContactsFollowings() {
            this(null);
        }
    }


    public static class PresenterProfile {
        public LinearLayout root;
        public SimpleTopNav simpleTopNav;

        public PresenterProfile(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.presenter_profile,parent);
            simpleTopNav = (SimpleTopNav) root.findViewById( R.id.simpleTopNav);
        }

        public PresenterProfile() {
            this(null);
        }
    }


    public static class PresenterTopTags {
        public RelativeLayout root;
        public TextView text;
        public IconTextView see_more;
        public ImageView image3;
        public ImageView image2;
        public ImageView image1;

        public PresenterTopTags(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.presenter_top_tags,parent);
            text = (TextView) root.findViewById( R.id.text);
            see_more = (IconTextView) root.findViewById( R.id.see_more);
            image3 = (ImageView) root.findViewById( R.id.image3);
            image2 = (ImageView) root.findViewById( R.id.image2);
            image1 = (ImageView) root.findViewById( R.id.image1);
        }

        public PresenterTopTags() {
            this(null);
        }
    }


    public static class PreseterHomeStream {
        public RelativeLayout root;
        public LinearLayout top_nav;
        public FrameLayout loading;
        public LinearLayout content;

        public PreseterHomeStream(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.preseter_home_stream,parent);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            loading = (FrameLayout) root.findViewById( R.id.loading);
            content = (LinearLayout) root.findViewById( R.id.content);
        }

        public PreseterHomeStream() {
            this(null);
        }
    }


    public static class PreseterHomeStream_Bk {
        public RelativeLayout root;
        public LinearLayout top_nav;
        public FrameLayout loading;
        public LinearLayout content;
        public RecyclerView recycler_view;

        public PreseterHomeStream_Bk(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.preseter_home_stream__bk,parent);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            loading = (FrameLayout) root.findViewById( R.id.loading);
            content = (LinearLayout) root.findViewById( R.id.content);
            recycler_view = (RecyclerView) root.findViewById( R.id.recycler_view);
        }

        public PreseterHomeStream_Bk() {
            this(null);
        }
    }


    public static class ProfileTopInfo {
        public LinearLayout root;
        public LinearLayout count_holder;
        public LinearLayout followings_holder;
        public TextView followings_count;
        public LinearLayout followers_holder;
        public TextView followers_count;
        public TextView posts_count;
        public ButtonGrayView button_edit_profile;
        public ChatButtonView chat_button;
        public FollowingButtonView follow_button;
        public SimpleDraweeView avatar;
        public EmojiconTextView fullname;
        public EmojiconTextView about;

        public ProfileTopInfo(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.profile_top_info,parent);
            count_holder = (LinearLayout) root.findViewById( R.id.count_holder);
            followings_holder = (LinearLayout) root.findViewById( R.id.followings_holder);
            followings_count = (TextView) root.findViewById( R.id.followings_count);
            followers_holder = (LinearLayout) root.findViewById( R.id.followers_holder);
            followers_count = (TextView) root.findViewById( R.id.followers_count);
            posts_count = (TextView) root.findViewById( R.id.posts_count);
            button_edit_profile = (ButtonGrayView) root.findViewById( R.id.button_edit_profile);
            chat_button = (ChatButtonView) root.findViewById( R.id.chat_button);
            follow_button = (FollowingButtonView) root.findViewById( R.id.follow_button);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            fullname = (EmojiconTextView) root.findViewById( R.id.fullname);
            about = (EmojiconTextView) root.findViewById( R.id.about);
        }

        public ProfileTopInfo() {
            this(null);
        }
    }


    public static class RecentImagesImageItem {
        public FrameLayout root;
        public SimpleDraweeView image;
        public FrameLayout text_holder;
        public TextView text_icon;

        public RecentImagesImageItem(ViewGroup parent) {
            root = (FrameLayout) AppUtil.inflate(R.layout.recent_images_image_item,parent);
            image = (SimpleDraweeView) root.findViewById( R.id.image);
            text_holder = (FrameLayout) root.findViewById( R.id.text_holder);
            text_icon = (TextView) root.findViewById( R.id.text_icon);
        }

        public RecentImagesImageItem() {
            this(null);
        }
    }


    public static class RowPostStream {
        public RelativeLayout root;
        public RelativeLayout post_row_holder;
        public TextView date;
        public SimpleDraweeView avatar;
        public TextView fullname;
        public EmojiLinkerTextView text;
        public ImageView image;
        public LinearLayout counts_info;
        public TextViewWithIcon comment_count;
        public TextViewWithIcon likes_count;
        public TextView like_btn;

        public RowPostStream(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.row_post_stream,parent);
            post_row_holder = (RelativeLayout) root.findViewById( R.id.post_row_holder);
            date = (TextView) root.findViewById( R.id.date);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
            fullname = (TextView) root.findViewById( R.id.fullname);
            text = (EmojiLinkerTextView) root.findViewById( R.id.text);
            image = (ImageView) root.findViewById( R.id.image);
            counts_info = (LinearLayout) root.findViewById( R.id.counts_info);
            comment_count = (TextViewWithIcon) root.findViewById( R.id.comment_count);
            likes_count = (TextViewWithIcon) root.findViewById( R.id.likes_count);
            like_btn = (TextView) root.findViewById( R.id.like_btn);
        }

        public RowPostStream() {
            this(null);
        }
    }


    public static class RowTagSimple {
        public RelativeLayout root;
        public TextView icon;
        public TextView text;
        public TextView count;

        public RowTagSimple(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.row_tag_simple,parent);
            icon = (TextView) root.findViewById( R.id.icon);
            text = (TextView) root.findViewById( R.id.text);
            count = (TextView) root.findViewById( R.id.count);
        }

        public RowTagSimple() {
            this(null);
        }
    }


    public static class RowUsersContacts {
        public LinearLayout root;
        public FollowingButtonView following_button;
        public EmojiconTextView second_name;
        public EmojiconTextView primary_name;
        public SimpleDraweeView avatar;

        public RowUsersContacts(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.row_users_contacts,parent);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            second_name = (EmojiconTextView) root.findViewById( R.id.second_name);
            primary_name = (EmojiconTextView) root.findViewById( R.id.primary_name);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
        }

        public RowUsersContacts() {
            this(null);
        }
    }


    public static class Rv_EmptyNote {
        public RelativeLayout root;
        public LinearLayout reload;
        public TextView empty_note;

        public Rv_EmptyNote(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.rv__empty_note,parent);
            reload = (LinearLayout) root.findViewById( R.id.reload);
            empty_note = (TextView) root.findViewById( R.id.empty_note);
        }

        public Rv_EmptyNote() {
            this(null);
        }
    }


    public static class Rv_FailedReload {
        public RelativeLayout root;
        public LinearLayout reload;
        public IconTextView not_internet;

        public Rv_FailedReload(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.rv__failed_reload,parent);
            reload = (LinearLayout) root.findViewById( R.id.reload);
            not_internet = (IconTextView) root.findViewById( R.id.not_internet);
        }

        public Rv_FailedReload() {
            this(null);
        }
    }


    public static class TabCellGeneral {
        public LinearLayout root;
        public TextView textView;
        public ImageView imgView;

        public TabCellGeneral(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.tab_cell_general,parent);
            textView = (TextView) root.findViewById( R.id.textView);
            imgView = (ImageView) root.findViewById( R.id.imgView);
        }

        public TabCellGeneral() {
            this(null);
        }
    }


    public static class TitleInfo {
        public RelativeLayout root;
        public TextView text_view;

        public TitleInfo(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.title_info,parent);
            text_view = (TextView) root.findViewById( R.id.text_view);
        }

        public TitleInfo() {
            this(null);
        }
    }


    public static class TitleStringClickable {
        public RelativeLayout root;
        public TextView icon;
        public TextView text_view;

        public TitleStringClickable(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.title_string_clickable,parent);
            icon = (TextView) root.findViewById( R.id.icon);
            text_view = (TextView) root.findViewById( R.id.text_view);
        }

        public TitleStringClickable() {
            this(null);
        }
    }


    public static class ViewRecyclerView {
        public RecyclerView root;

        public ViewRecyclerView(ViewGroup parent) {
            root = (RecyclerView) AppUtil.inflate(R.layout.view_recycler_view,parent);
        }

        public ViewRecyclerView() {
            this(null);
        }
    }


    public static class Widget_PlaySample {
        public RelativeLayout root;
        public RelativeLayout window;
        public PhotoDraweeView image_view;
        public LinearLayout top_nav;
        public EmojiconTextView text_view;

        public Widget_PlaySample(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.widget__play_sample,parent);
            window = (RelativeLayout) root.findViewById( R.id.window);
            image_view = (PhotoDraweeView) root.findViewById( R.id.image_view);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            text_view = (EmojiconTextView) root.findViewById( R.id.text_view);
        }

        public Widget_PlaySample() {
            this(null);
        }
    }


    public static class WidgetAddSimpleText {
        public LinearLayout root;
        public LinearLayout bottom_container;
        public TextView emoji_opener_btn;
        public EmojiconEditText input;
        public Button send_btn;

        public WidgetAddSimpleText(ViewGroup parent) {
            root = (LinearLayout) AppUtil.inflate(R.layout.widget_add_simple_text,parent);
            bottom_container = (LinearLayout) root.findViewById( R.id.bottom_container);
            emoji_opener_btn = (TextView) root.findViewById( R.id.emoji_opener_btn);
            input = (EmojiconEditText) root.findViewById( R.id.input);
            send_btn = (Button) root.findViewById( R.id.send_btn);
        }

        public WidgetAddSimpleText() {
            this(null);
        }
    }


    public static class WidgetFullScreenImage {
        public RelativeLayout root;
        public RelativeLayout window;
        public PhotoDraweeView image_view;
        public LinearLayout top_nav;
        public EmojiconTextView text_view;

        public WidgetFullScreenImage(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.widget_full_screen_image,parent);
            window = (RelativeLayout) root.findViewById( R.id.window);
            image_view = (PhotoDraweeView) root.findViewById( R.id.image_view);
            top_nav = (LinearLayout) root.findViewById( R.id.top_nav);
            text_view = (EmojiconTextView) root.findViewById( R.id.text_view);
        }

        public WidgetFullScreenImage() {
            this(null);
        }
    }


    public static class WigetApp_HeadrFooterRecyclerEmptyMsg {
        public RelativeLayout root;

        public WigetApp_HeadrFooterRecyclerEmptyMsg(ViewGroup parent) {
            root = (RelativeLayout) AppUtil.inflate(R.layout.wiget_app__headr_footer_recycler_empty_msg,parent);
        }

        public WigetApp_HeadrFooterRecyclerEmptyMsg() {
            this(null);
        }
    }


    public static class WigetUserListTypeFollowRow {
        public UserListGeneralFollowRowWhithBorderLinearLayout root;
        public FollowingButtonView following_button;
        public EmojiconTextView primary_name;
        public EmojiconTextView second_name;
        public SimpleDraweeView avatar;

        public WigetUserListTypeFollowRow(ViewGroup parent) {
            root = (UserListGeneralFollowRowWhithBorderLinearLayout) AppUtil.inflate(R.layout.wiget_user_list_type_follow_row,parent);
            following_button = (FollowingButtonView) root.findViewById( R.id.following_button);
            primary_name = (EmojiconTextView) root.findViewById( R.id.primary_name);
            second_name = (EmojiconTextView) root.findViewById( R.id.second_name);
            avatar = (SimpleDraweeView) root.findViewById( R.id.avatar);
        }

        public WigetUserListTypeFollowRow() {
            this(null);
        }
    }

}

////////////////////////////////
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.FrameLayout;
//import android.widget.GridView;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.Space;
//import android.widget.TextView;
//import android.widget.View;
//import android.widget.WebView;
