package com.mardomsara.social.app;

/**
 * Created by Hamid on 5/14/2016.
 */
public class Constants {

    public static String MsgsAddNew = "MsgsAddNew";
    public static String MsgsReceivedToServer = "MsgsReceivedToServer";
    public static String MsgsReceivedToPeer = "MsgsReceivedToPeer";
    public static String MsgsSeenByPeer = "MsgsSeenByPeer";
    public static String MsgsDeletedFromServer = "MsgsDeletedFromServer";

    public static String CommandsReceivedToServer = "CommandsReceivedToServer";


    //messages Types
    public static final int MESSAGE_TEXT = 10;
    public static final int MESSAGE_CONTACT = 12;
    public static final int MESSAGE_lOCCASION = 14;
    public static final int MESSAGE_STICKER= 18;
    public static final int MESSAGE_POST = 30;
    public static final int MESSAGE_IMAGE = 40;
    public static final int MESSAGE_VIDEO = 42;
    public static final int MESSAGE_AUDIO = 44;
    public static final int MESSAGE_FILE = 46;

    //Msg media Status
	//messages must be atomic just Msg_Media_To_Push_And_Upload
    public static int Msg_Media_To_Push_And_Upload = 1; //for:me -- must be ByMe=1
    public static int Msg_Media_Uploaded = 2; //for:me&peer -- peer uploaded File now downloaded it
    public static int Msg_Media_Waiting = 3; //for:peer -- must be ByMe=0 -- waite peer upload File
	public static int Msg_Media_To_Download = 4; //for:peer -- must be ByMe=0 -- waite peer upload File
    public static int Msg_Media_Downloaded = 5; //for:me&peer -- must be ByMe=0 -- we downloaded file
    public static int Msg_Media_Deleteted_Server = 6; // ??

	public static int Msg_Media_Origin_Here = 1;
	public static int Msg_Media_Origin_Server = 2;

    // Notifications
    public static int NOTIFICATION_TYPE_POST_LIKED = 200;
    public static int NOTIFICATION_TYPE_POST_COMMENTED = 220 ;
    public static int NOTIFICATION_TYPE_FOLLOWED_YOU = 250 ;

    //Posts
    public static int POST_TYPE_TEXT = 1;
    public static int POST_TYPE_PHOTO = 2;
    //Hawk
    public static String SessionUserInfo = "SessionUserInfo";





}
