// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_tables.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_SettingNotification}
 */
public  final class PB_SettingNotification extends
    com.google.protobuf.GeneratedMessageLite<
        PB_SettingNotification, PB_SettingNotification.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_SettingNotification)
    PB_SettingNotificationOrBuilder {
  private PB_SettingNotification() {
    socialLedColor_ = "";
  }
  public static final int USERID_FIELD_NUMBER = 1;
  private int userId_;
  /**
   * <code>int32 UserId = 1;</code>
   */
  public int getUserId() {
    return userId_;
  }
  /**
   * <code>int32 UserId = 1;</code>
   */
  private void setUserId(int value) {
    
    userId_ = value;
  }
  /**
   * <code>int32 UserId = 1;</code>
   */
  private void clearUserId() {
    
    userId_ = 0;
  }

  public static final int SOCIALLEDON_FIELD_NUMBER = 3;
  private int socialLedOn_;
  /**
   * <code>int32 SocialLedOn = 3;</code>
   */
  public int getSocialLedOn() {
    return socialLedOn_;
  }
  /**
   * <code>int32 SocialLedOn = 3;</code>
   */
  private void setSocialLedOn(int value) {
    
    socialLedOn_ = value;
  }
  /**
   * <code>int32 SocialLedOn = 3;</code>
   */
  private void clearSocialLedOn() {
    
    socialLedOn_ = 0;
  }

  public static final int SOCIALLEDCOLOR_FIELD_NUMBER = 5;
  private java.lang.String socialLedColor_;
  /**
   * <code>string SocialLedColor = 5;</code>
   */
  public java.lang.String getSocialLedColor() {
    return socialLedColor_;
  }
  /**
   * <code>string SocialLedColor = 5;</code>
   */
  public com.google.protobuf.ByteString
      getSocialLedColorBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(socialLedColor_);
  }
  /**
   * <code>string SocialLedColor = 5;</code>
   */
  private void setSocialLedColor(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    socialLedColor_ = value;
  }
  /**
   * <code>string SocialLedColor = 5;</code>
   */
  private void clearSocialLedColor() {
    
    socialLedColor_ = getDefaultInstance().getSocialLedColor();
  }
  /**
   * <code>string SocialLedColor = 5;</code>
   */
  private void setSocialLedColorBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    socialLedColor_ = value.toStringUtf8();
  }

  public static final int REQESTTOFOLLOWYOU_FIELD_NUMBER = 7;
  private int reqestToFollowYou_;
  /**
   * <code>int32 ReqestToFollowYou = 7;</code>
   */
  public int getReqestToFollowYou() {
    return reqestToFollowYou_;
  }
  /**
   * <code>int32 ReqestToFollowYou = 7;</code>
   */
  private void setReqestToFollowYou(int value) {
    
    reqestToFollowYou_ = value;
  }
  /**
   * <code>int32 ReqestToFollowYou = 7;</code>
   */
  private void clearReqestToFollowYou() {
    
    reqestToFollowYou_ = 0;
  }

  public static final int FOLLOWEDYOU_FIELD_NUMBER = 9;
  private int followedYou_;
  /**
   * <code>int32 FollowedYou = 9;</code>
   */
  public int getFollowedYou() {
    return followedYou_;
  }
  /**
   * <code>int32 FollowedYou = 9;</code>
   */
  private void setFollowedYou(int value) {
    
    followedYou_ = value;
  }
  /**
   * <code>int32 FollowedYou = 9;</code>
   */
  private void clearFollowedYou() {
    
    followedYou_ = 0;
  }

  public static final int ACCPTEDYOURFOLLOWREQUEST_FIELD_NUMBER = 11;
  private int accptedYourFollowRequest_;
  /**
   * <code>int32 AccptedYourFollowRequest = 11;</code>
   */
  public int getAccptedYourFollowRequest() {
    return accptedYourFollowRequest_;
  }
  /**
   * <code>int32 AccptedYourFollowRequest = 11;</code>
   */
  private void setAccptedYourFollowRequest(int value) {
    
    accptedYourFollowRequest_ = value;
  }
  /**
   * <code>int32 AccptedYourFollowRequest = 11;</code>
   */
  private void clearAccptedYourFollowRequest() {
    
    accptedYourFollowRequest_ = 0;
  }

  public static final int YOURPOSTLIKED_FIELD_NUMBER = 13;
  private int yourPostLiked_;
  /**
   * <code>int32 YourPostLiked = 13;</code>
   */
  public int getYourPostLiked() {
    return yourPostLiked_;
  }
  /**
   * <code>int32 YourPostLiked = 13;</code>
   */
  private void setYourPostLiked(int value) {
    
    yourPostLiked_ = value;
  }
  /**
   * <code>int32 YourPostLiked = 13;</code>
   */
  private void clearYourPostLiked() {
    
    yourPostLiked_ = 0;
  }

  public static final int YOURPOSTCOMMENTED_FIELD_NUMBER = 15;
  private int yourPostCommented_;
  /**
   * <code>int32 YourPostCommented = 15;</code>
   */
  public int getYourPostCommented() {
    return yourPostCommented_;
  }
  /**
   * <code>int32 YourPostCommented = 15;</code>
   */
  private void setYourPostCommented(int value) {
    
    yourPostCommented_ = value;
  }
  /**
   * <code>int32 YourPostCommented = 15;</code>
   */
  private void clearYourPostCommented() {
    
    yourPostCommented_ = 0;
  }

  public static final int MENTHENEDYOUINPOST_FIELD_NUMBER = 17;
  private int menthenedYouInPost_;
  /**
   * <code>int32 MenthenedYouInPost = 17;</code>
   */
  public int getMenthenedYouInPost() {
    return menthenedYouInPost_;
  }
  /**
   * <code>int32 MenthenedYouInPost = 17;</code>
   */
  private void setMenthenedYouInPost(int value) {
    
    menthenedYouInPost_ = value;
  }
  /**
   * <code>int32 MenthenedYouInPost = 17;</code>
   */
  private void clearMenthenedYouInPost() {
    
    menthenedYouInPost_ = 0;
  }

  public static final int MENTHENEDYOUINCOMMENT_FIELD_NUMBER = 19;
  private int menthenedYouInComment_;
  /**
   * <code>int32 MenthenedYouInComment = 19;</code>
   */
  public int getMenthenedYouInComment() {
    return menthenedYouInComment_;
  }
  /**
   * <code>int32 MenthenedYouInComment = 19;</code>
   */
  private void setMenthenedYouInComment(int value) {
    
    menthenedYouInComment_ = value;
  }
  /**
   * <code>int32 MenthenedYouInComment = 19;</code>
   */
  private void clearMenthenedYouInComment() {
    
    menthenedYouInComment_ = 0;
  }

  public static final int YOURCONTACTSJOINED_FIELD_NUMBER = 21;
  private int yourContactsJoined_;
  /**
   * <code>int32 YourContactsJoined = 21;</code>
   */
  public int getYourContactsJoined() {
    return yourContactsJoined_;
  }
  /**
   * <code>int32 YourContactsJoined = 21;</code>
   */
  private void setYourContactsJoined(int value) {
    
    yourContactsJoined_ = value;
  }
  /**
   * <code>int32 YourContactsJoined = 21;</code>
   */
  private void clearYourContactsJoined() {
    
    yourContactsJoined_ = 0;
  }

  public static final int DIRECTMESSAGE_FIELD_NUMBER = 23;
  private int directMessage_;
  /**
   * <code>int32 DirectMessage = 23;</code>
   */
  public int getDirectMessage() {
    return directMessage_;
  }
  /**
   * <code>int32 DirectMessage = 23;</code>
   */
  private void setDirectMessage(int value) {
    
    directMessage_ = value;
  }
  /**
   * <code>int32 DirectMessage = 23;</code>
   */
  private void clearDirectMessage() {
    
    directMessage_ = 0;
  }

  public static final int DIRECTALERT_FIELD_NUMBER = 25;
  private int directAlert_;
  /**
   * <code>int32 DirectAlert = 25;</code>
   */
  public int getDirectAlert() {
    return directAlert_;
  }
  /**
   * <code>int32 DirectAlert = 25;</code>
   */
  private void setDirectAlert(int value) {
    
    directAlert_ = value;
  }
  /**
   * <code>int32 DirectAlert = 25;</code>
   */
  private void clearDirectAlert() {
    
    directAlert_ = 0;
  }

  public static final int DIRECTPERVIEW_FIELD_NUMBER = 27;
  private int directPerview_;
  /**
   * <code>int32 DirectPerview = 27;</code>
   */
  public int getDirectPerview() {
    return directPerview_;
  }
  /**
   * <code>int32 DirectPerview = 27;</code>
   */
  private void setDirectPerview(int value) {
    
    directPerview_ = value;
  }
  /**
   * <code>int32 DirectPerview = 27;</code>
   */
  private void clearDirectPerview() {
    
    directPerview_ = 0;
  }

  public static final int DIRECTLEDON_FIELD_NUMBER = 29;
  private int directLedOn_;
  /**
   * <code>int32 DirectLedOn = 29;</code>
   */
  public int getDirectLedOn() {
    return directLedOn_;
  }
  /**
   * <code>int32 DirectLedOn = 29;</code>
   */
  private void setDirectLedOn(int value) {
    
    directLedOn_ = value;
  }
  /**
   * <code>int32 DirectLedOn = 29;</code>
   */
  private void clearDirectLedOn() {
    
    directLedOn_ = 0;
  }

  public static final int DIRECTLEDCOLOR_FIELD_NUMBER = 31;
  private int directLedColor_;
  /**
   * <code>int32 DirectLedColor = 31;</code>
   */
  public int getDirectLedColor() {
    return directLedColor_;
  }
  /**
   * <code>int32 DirectLedColor = 31;</code>
   */
  private void setDirectLedColor(int value) {
    
    directLedColor_ = value;
  }
  /**
   * <code>int32 DirectLedColor = 31;</code>
   */
  private void clearDirectLedColor() {
    
    directLedColor_ = 0;
  }

  public static final int DIRECTVIBRATE_FIELD_NUMBER = 33;
  private int directVibrate_;
  /**
   * <code>int32 DirectVibrate = 33;</code>
   */
  public int getDirectVibrate() {
    return directVibrate_;
  }
  /**
   * <code>int32 DirectVibrate = 33;</code>
   */
  private void setDirectVibrate(int value) {
    
    directVibrate_ = value;
  }
  /**
   * <code>int32 DirectVibrate = 33;</code>
   */
  private void clearDirectVibrate() {
    
    directVibrate_ = 0;
  }

  public static final int DIRECTPOPUP_FIELD_NUMBER = 35;
  private int directPopup_;
  /**
   * <code>int32 DirectPopup = 35;</code>
   */
  public int getDirectPopup() {
    return directPopup_;
  }
  /**
   * <code>int32 DirectPopup = 35;</code>
   */
  private void setDirectPopup(int value) {
    
    directPopup_ = value;
  }
  /**
   * <code>int32 DirectPopup = 35;</code>
   */
  private void clearDirectPopup() {
    
    directPopup_ = 0;
  }

  public static final int DIRECTSOUND_FIELD_NUMBER = 37;
  private int directSound_;
  /**
   * <code>int32 DirectSound = 37;</code>
   */
  public int getDirectSound() {
    return directSound_;
  }
  /**
   * <code>int32 DirectSound = 37;</code>
   */
  private void setDirectSound(int value) {
    
    directSound_ = value;
  }
  /**
   * <code>int32 DirectSound = 37;</code>
   */
  private void clearDirectSound() {
    
    directSound_ = 0;
  }

  public static final int DIRECTPRIORITY_FIELD_NUMBER = 39;
  private int directPriority_;
  /**
   * <code>int32 DirectPriority = 39;</code>
   */
  public int getDirectPriority() {
    return directPriority_;
  }
  /**
   * <code>int32 DirectPriority = 39;</code>
   */
  private void setDirectPriority(int value) {
    
    directPriority_ = value;
  }
  /**
   * <code>int32 DirectPriority = 39;</code>
   */
  private void clearDirectPriority() {
    
    directPriority_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (socialLedOn_ != 0) {
      output.writeInt32(3, socialLedOn_);
    }
    if (!socialLedColor_.isEmpty()) {
      output.writeString(5, getSocialLedColor());
    }
    if (reqestToFollowYou_ != 0) {
      output.writeInt32(7, reqestToFollowYou_);
    }
    if (followedYou_ != 0) {
      output.writeInt32(9, followedYou_);
    }
    if (accptedYourFollowRequest_ != 0) {
      output.writeInt32(11, accptedYourFollowRequest_);
    }
    if (yourPostLiked_ != 0) {
      output.writeInt32(13, yourPostLiked_);
    }
    if (yourPostCommented_ != 0) {
      output.writeInt32(15, yourPostCommented_);
    }
    if (menthenedYouInPost_ != 0) {
      output.writeInt32(17, menthenedYouInPost_);
    }
    if (menthenedYouInComment_ != 0) {
      output.writeInt32(19, menthenedYouInComment_);
    }
    if (yourContactsJoined_ != 0) {
      output.writeInt32(21, yourContactsJoined_);
    }
    if (directMessage_ != 0) {
      output.writeInt32(23, directMessage_);
    }
    if (directAlert_ != 0) {
      output.writeInt32(25, directAlert_);
    }
    if (directPerview_ != 0) {
      output.writeInt32(27, directPerview_);
    }
    if (directLedOn_ != 0) {
      output.writeInt32(29, directLedOn_);
    }
    if (directLedColor_ != 0) {
      output.writeInt32(31, directLedColor_);
    }
    if (directVibrate_ != 0) {
      output.writeInt32(33, directVibrate_);
    }
    if (directPopup_ != 0) {
      output.writeInt32(35, directPopup_);
    }
    if (directSound_ != 0) {
      output.writeInt32(37, directSound_);
    }
    if (directPriority_ != 0) {
      output.writeInt32(39, directPriority_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, userId_);
    }
    if (socialLedOn_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, socialLedOn_);
    }
    if (!socialLedColor_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(5, getSocialLedColor());
    }
    if (reqestToFollowYou_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, reqestToFollowYou_);
    }
    if (followedYou_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(9, followedYou_);
    }
    if (accptedYourFollowRequest_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(11, accptedYourFollowRequest_);
    }
    if (yourPostLiked_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(13, yourPostLiked_);
    }
    if (yourPostCommented_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(15, yourPostCommented_);
    }
    if (menthenedYouInPost_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(17, menthenedYouInPost_);
    }
    if (menthenedYouInComment_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(19, menthenedYouInComment_);
    }
    if (yourContactsJoined_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(21, yourContactsJoined_);
    }
    if (directMessage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(23, directMessage_);
    }
    if (directAlert_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(25, directAlert_);
    }
    if (directPerview_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(27, directPerview_);
    }
    if (directLedOn_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(29, directLedOn_);
    }
    if (directLedColor_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(31, directLedColor_);
    }
    if (directVibrate_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(33, directVibrate_);
    }
    if (directPopup_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(35, directPopup_);
    }
    if (directSound_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(37, directSound_);
    }
    if (directPriority_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(39, directPriority_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_SettingNotification parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SettingNotification parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SettingNotification parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_SettingNotification parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_SettingNotification prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_SettingNotification}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_SettingNotification, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_SettingNotification)
      ir.ms.pb.PB_SettingNotificationOrBuilder {
    // Construct using ir.ms.pb.PB_SettingNotification.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 UserId = 1;</code>
     */
    public int getUserId() {
      return instance.getUserId();
    }
    /**
     * <code>int32 UserId = 1;</code>
     */
    public Builder setUserId(int value) {
      copyOnWrite();
      instance.setUserId(value);
      return this;
    }
    /**
     * <code>int32 UserId = 1;</code>
     */
    public Builder clearUserId() {
      copyOnWrite();
      instance.clearUserId();
      return this;
    }

    /**
     * <code>int32 SocialLedOn = 3;</code>
     */
    public int getSocialLedOn() {
      return instance.getSocialLedOn();
    }
    /**
     * <code>int32 SocialLedOn = 3;</code>
     */
    public Builder setSocialLedOn(int value) {
      copyOnWrite();
      instance.setSocialLedOn(value);
      return this;
    }
    /**
     * <code>int32 SocialLedOn = 3;</code>
     */
    public Builder clearSocialLedOn() {
      copyOnWrite();
      instance.clearSocialLedOn();
      return this;
    }

    /**
     * <code>string SocialLedColor = 5;</code>
     */
    public java.lang.String getSocialLedColor() {
      return instance.getSocialLedColor();
    }
    /**
     * <code>string SocialLedColor = 5;</code>
     */
    public com.google.protobuf.ByteString
        getSocialLedColorBytes() {
      return instance.getSocialLedColorBytes();
    }
    /**
     * <code>string SocialLedColor = 5;</code>
     */
    public Builder setSocialLedColor(
        java.lang.String value) {
      copyOnWrite();
      instance.setSocialLedColor(value);
      return this;
    }
    /**
     * <code>string SocialLedColor = 5;</code>
     */
    public Builder clearSocialLedColor() {
      copyOnWrite();
      instance.clearSocialLedColor();
      return this;
    }
    /**
     * <code>string SocialLedColor = 5;</code>
     */
    public Builder setSocialLedColorBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setSocialLedColorBytes(value);
      return this;
    }

    /**
     * <code>int32 ReqestToFollowYou = 7;</code>
     */
    public int getReqestToFollowYou() {
      return instance.getReqestToFollowYou();
    }
    /**
     * <code>int32 ReqestToFollowYou = 7;</code>
     */
    public Builder setReqestToFollowYou(int value) {
      copyOnWrite();
      instance.setReqestToFollowYou(value);
      return this;
    }
    /**
     * <code>int32 ReqestToFollowYou = 7;</code>
     */
    public Builder clearReqestToFollowYou() {
      copyOnWrite();
      instance.clearReqestToFollowYou();
      return this;
    }

    /**
     * <code>int32 FollowedYou = 9;</code>
     */
    public int getFollowedYou() {
      return instance.getFollowedYou();
    }
    /**
     * <code>int32 FollowedYou = 9;</code>
     */
    public Builder setFollowedYou(int value) {
      copyOnWrite();
      instance.setFollowedYou(value);
      return this;
    }
    /**
     * <code>int32 FollowedYou = 9;</code>
     */
    public Builder clearFollowedYou() {
      copyOnWrite();
      instance.clearFollowedYou();
      return this;
    }

    /**
     * <code>int32 AccptedYourFollowRequest = 11;</code>
     */
    public int getAccptedYourFollowRequest() {
      return instance.getAccptedYourFollowRequest();
    }
    /**
     * <code>int32 AccptedYourFollowRequest = 11;</code>
     */
    public Builder setAccptedYourFollowRequest(int value) {
      copyOnWrite();
      instance.setAccptedYourFollowRequest(value);
      return this;
    }
    /**
     * <code>int32 AccptedYourFollowRequest = 11;</code>
     */
    public Builder clearAccptedYourFollowRequest() {
      copyOnWrite();
      instance.clearAccptedYourFollowRequest();
      return this;
    }

    /**
     * <code>int32 YourPostLiked = 13;</code>
     */
    public int getYourPostLiked() {
      return instance.getYourPostLiked();
    }
    /**
     * <code>int32 YourPostLiked = 13;</code>
     */
    public Builder setYourPostLiked(int value) {
      copyOnWrite();
      instance.setYourPostLiked(value);
      return this;
    }
    /**
     * <code>int32 YourPostLiked = 13;</code>
     */
    public Builder clearYourPostLiked() {
      copyOnWrite();
      instance.clearYourPostLiked();
      return this;
    }

    /**
     * <code>int32 YourPostCommented = 15;</code>
     */
    public int getYourPostCommented() {
      return instance.getYourPostCommented();
    }
    /**
     * <code>int32 YourPostCommented = 15;</code>
     */
    public Builder setYourPostCommented(int value) {
      copyOnWrite();
      instance.setYourPostCommented(value);
      return this;
    }
    /**
     * <code>int32 YourPostCommented = 15;</code>
     */
    public Builder clearYourPostCommented() {
      copyOnWrite();
      instance.clearYourPostCommented();
      return this;
    }

    /**
     * <code>int32 MenthenedYouInPost = 17;</code>
     */
    public int getMenthenedYouInPost() {
      return instance.getMenthenedYouInPost();
    }
    /**
     * <code>int32 MenthenedYouInPost = 17;</code>
     */
    public Builder setMenthenedYouInPost(int value) {
      copyOnWrite();
      instance.setMenthenedYouInPost(value);
      return this;
    }
    /**
     * <code>int32 MenthenedYouInPost = 17;</code>
     */
    public Builder clearMenthenedYouInPost() {
      copyOnWrite();
      instance.clearMenthenedYouInPost();
      return this;
    }

    /**
     * <code>int32 MenthenedYouInComment = 19;</code>
     */
    public int getMenthenedYouInComment() {
      return instance.getMenthenedYouInComment();
    }
    /**
     * <code>int32 MenthenedYouInComment = 19;</code>
     */
    public Builder setMenthenedYouInComment(int value) {
      copyOnWrite();
      instance.setMenthenedYouInComment(value);
      return this;
    }
    /**
     * <code>int32 MenthenedYouInComment = 19;</code>
     */
    public Builder clearMenthenedYouInComment() {
      copyOnWrite();
      instance.clearMenthenedYouInComment();
      return this;
    }

    /**
     * <code>int32 YourContactsJoined = 21;</code>
     */
    public int getYourContactsJoined() {
      return instance.getYourContactsJoined();
    }
    /**
     * <code>int32 YourContactsJoined = 21;</code>
     */
    public Builder setYourContactsJoined(int value) {
      copyOnWrite();
      instance.setYourContactsJoined(value);
      return this;
    }
    /**
     * <code>int32 YourContactsJoined = 21;</code>
     */
    public Builder clearYourContactsJoined() {
      copyOnWrite();
      instance.clearYourContactsJoined();
      return this;
    }

    /**
     * <code>int32 DirectMessage = 23;</code>
     */
    public int getDirectMessage() {
      return instance.getDirectMessage();
    }
    /**
     * <code>int32 DirectMessage = 23;</code>
     */
    public Builder setDirectMessage(int value) {
      copyOnWrite();
      instance.setDirectMessage(value);
      return this;
    }
    /**
     * <code>int32 DirectMessage = 23;</code>
     */
    public Builder clearDirectMessage() {
      copyOnWrite();
      instance.clearDirectMessage();
      return this;
    }

    /**
     * <code>int32 DirectAlert = 25;</code>
     */
    public int getDirectAlert() {
      return instance.getDirectAlert();
    }
    /**
     * <code>int32 DirectAlert = 25;</code>
     */
    public Builder setDirectAlert(int value) {
      copyOnWrite();
      instance.setDirectAlert(value);
      return this;
    }
    /**
     * <code>int32 DirectAlert = 25;</code>
     */
    public Builder clearDirectAlert() {
      copyOnWrite();
      instance.clearDirectAlert();
      return this;
    }

    /**
     * <code>int32 DirectPerview = 27;</code>
     */
    public int getDirectPerview() {
      return instance.getDirectPerview();
    }
    /**
     * <code>int32 DirectPerview = 27;</code>
     */
    public Builder setDirectPerview(int value) {
      copyOnWrite();
      instance.setDirectPerview(value);
      return this;
    }
    /**
     * <code>int32 DirectPerview = 27;</code>
     */
    public Builder clearDirectPerview() {
      copyOnWrite();
      instance.clearDirectPerview();
      return this;
    }

    /**
     * <code>int32 DirectLedOn = 29;</code>
     */
    public int getDirectLedOn() {
      return instance.getDirectLedOn();
    }
    /**
     * <code>int32 DirectLedOn = 29;</code>
     */
    public Builder setDirectLedOn(int value) {
      copyOnWrite();
      instance.setDirectLedOn(value);
      return this;
    }
    /**
     * <code>int32 DirectLedOn = 29;</code>
     */
    public Builder clearDirectLedOn() {
      copyOnWrite();
      instance.clearDirectLedOn();
      return this;
    }

    /**
     * <code>int32 DirectLedColor = 31;</code>
     */
    public int getDirectLedColor() {
      return instance.getDirectLedColor();
    }
    /**
     * <code>int32 DirectLedColor = 31;</code>
     */
    public Builder setDirectLedColor(int value) {
      copyOnWrite();
      instance.setDirectLedColor(value);
      return this;
    }
    /**
     * <code>int32 DirectLedColor = 31;</code>
     */
    public Builder clearDirectLedColor() {
      copyOnWrite();
      instance.clearDirectLedColor();
      return this;
    }

    /**
     * <code>int32 DirectVibrate = 33;</code>
     */
    public int getDirectVibrate() {
      return instance.getDirectVibrate();
    }
    /**
     * <code>int32 DirectVibrate = 33;</code>
     */
    public Builder setDirectVibrate(int value) {
      copyOnWrite();
      instance.setDirectVibrate(value);
      return this;
    }
    /**
     * <code>int32 DirectVibrate = 33;</code>
     */
    public Builder clearDirectVibrate() {
      copyOnWrite();
      instance.clearDirectVibrate();
      return this;
    }

    /**
     * <code>int32 DirectPopup = 35;</code>
     */
    public int getDirectPopup() {
      return instance.getDirectPopup();
    }
    /**
     * <code>int32 DirectPopup = 35;</code>
     */
    public Builder setDirectPopup(int value) {
      copyOnWrite();
      instance.setDirectPopup(value);
      return this;
    }
    /**
     * <code>int32 DirectPopup = 35;</code>
     */
    public Builder clearDirectPopup() {
      copyOnWrite();
      instance.clearDirectPopup();
      return this;
    }

    /**
     * <code>int32 DirectSound = 37;</code>
     */
    public int getDirectSound() {
      return instance.getDirectSound();
    }
    /**
     * <code>int32 DirectSound = 37;</code>
     */
    public Builder setDirectSound(int value) {
      copyOnWrite();
      instance.setDirectSound(value);
      return this;
    }
    /**
     * <code>int32 DirectSound = 37;</code>
     */
    public Builder clearDirectSound() {
      copyOnWrite();
      instance.clearDirectSound();
      return this;
    }

    /**
     * <code>int32 DirectPriority = 39;</code>
     */
    public int getDirectPriority() {
      return instance.getDirectPriority();
    }
    /**
     * <code>int32 DirectPriority = 39;</code>
     */
    public Builder setDirectPriority(int value) {
      copyOnWrite();
      instance.setDirectPriority(value);
      return this;
    }
    /**
     * <code>int32 DirectPriority = 39;</code>
     */
    public Builder clearDirectPriority() {
      copyOnWrite();
      instance.clearDirectPriority();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_SettingNotification)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_SettingNotification();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        ir.ms.pb.PB_SettingNotification other = (ir.ms.pb.PB_SettingNotification) arg1;
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        socialLedOn_ = visitor.visitInt(socialLedOn_ != 0, socialLedOn_,
            other.socialLedOn_ != 0, other.socialLedOn_);
        socialLedColor_ = visitor.visitString(!socialLedColor_.isEmpty(), socialLedColor_,
            !other.socialLedColor_.isEmpty(), other.socialLedColor_);
        reqestToFollowYou_ = visitor.visitInt(reqestToFollowYou_ != 0, reqestToFollowYou_,
            other.reqestToFollowYou_ != 0, other.reqestToFollowYou_);
        followedYou_ = visitor.visitInt(followedYou_ != 0, followedYou_,
            other.followedYou_ != 0, other.followedYou_);
        accptedYourFollowRequest_ = visitor.visitInt(accptedYourFollowRequest_ != 0, accptedYourFollowRequest_,
            other.accptedYourFollowRequest_ != 0, other.accptedYourFollowRequest_);
        yourPostLiked_ = visitor.visitInt(yourPostLiked_ != 0, yourPostLiked_,
            other.yourPostLiked_ != 0, other.yourPostLiked_);
        yourPostCommented_ = visitor.visitInt(yourPostCommented_ != 0, yourPostCommented_,
            other.yourPostCommented_ != 0, other.yourPostCommented_);
        menthenedYouInPost_ = visitor.visitInt(menthenedYouInPost_ != 0, menthenedYouInPost_,
            other.menthenedYouInPost_ != 0, other.menthenedYouInPost_);
        menthenedYouInComment_ = visitor.visitInt(menthenedYouInComment_ != 0, menthenedYouInComment_,
            other.menthenedYouInComment_ != 0, other.menthenedYouInComment_);
        yourContactsJoined_ = visitor.visitInt(yourContactsJoined_ != 0, yourContactsJoined_,
            other.yourContactsJoined_ != 0, other.yourContactsJoined_);
        directMessage_ = visitor.visitInt(directMessage_ != 0, directMessage_,
            other.directMessage_ != 0, other.directMessage_);
        directAlert_ = visitor.visitInt(directAlert_ != 0, directAlert_,
            other.directAlert_ != 0, other.directAlert_);
        directPerview_ = visitor.visitInt(directPerview_ != 0, directPerview_,
            other.directPerview_ != 0, other.directPerview_);
        directLedOn_ = visitor.visitInt(directLedOn_ != 0, directLedOn_,
            other.directLedOn_ != 0, other.directLedOn_);
        directLedColor_ = visitor.visitInt(directLedColor_ != 0, directLedColor_,
            other.directLedColor_ != 0, other.directLedColor_);
        directVibrate_ = visitor.visitInt(directVibrate_ != 0, directVibrate_,
            other.directVibrate_ != 0, other.directVibrate_);
        directPopup_ = visitor.visitInt(directPopup_ != 0, directPopup_,
            other.directPopup_ != 0, other.directPopup_);
        directSound_ = visitor.visitInt(directSound_ != 0, directSound_,
            other.directSound_ != 0, other.directSound_);
        directPriority_ = visitor.visitInt(directPriority_ != 0, directPriority_,
            other.directPriority_ != 0, other.directPriority_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 8: {

                userId_ = input.readInt32();
                break;
              }
              case 24: {

                socialLedOn_ = input.readInt32();
                break;
              }
              case 42: {
                String s = input.readStringRequireUtf8();

                socialLedColor_ = s;
                break;
              }
              case 56: {

                reqestToFollowYou_ = input.readInt32();
                break;
              }
              case 72: {

                followedYou_ = input.readInt32();
                break;
              }
              case 88: {

                accptedYourFollowRequest_ = input.readInt32();
                break;
              }
              case 104: {

                yourPostLiked_ = input.readInt32();
                break;
              }
              case 120: {

                yourPostCommented_ = input.readInt32();
                break;
              }
              case 136: {

                menthenedYouInPost_ = input.readInt32();
                break;
              }
              case 152: {

                menthenedYouInComment_ = input.readInt32();
                break;
              }
              case 168: {

                yourContactsJoined_ = input.readInt32();
                break;
              }
              case 184: {

                directMessage_ = input.readInt32();
                break;
              }
              case 200: {

                directAlert_ = input.readInt32();
                break;
              }
              case 216: {

                directPerview_ = input.readInt32();
                break;
              }
              case 232: {

                directLedOn_ = input.readInt32();
                break;
              }
              case 248: {

                directLedColor_ = input.readInt32();
                break;
              }
              case 264: {

                directVibrate_ = input.readInt32();
                break;
              }
              case 280: {

                directPopup_ = input.readInt32();
                break;
              }
              case 296: {

                directSound_ = input.readInt32();
                break;
              }
              case 312: {

                directPriority_ = input.readInt32();
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_SettingNotification.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:PB_SettingNotification)
  private static final ir.ms.pb.PB_SettingNotification DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_SettingNotification();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_SettingNotification getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_SettingNotification> PARSER;

  public static com.google.protobuf.Parser<PB_SettingNotification> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

