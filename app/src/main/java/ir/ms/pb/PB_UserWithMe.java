// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: global.proto

package ir.ms.pb;

/**
 * Protobuf type {@code PB_UserWithMe}
 */
public  final class PB_UserWithMe extends
    com.google.protobuf.GeneratedMessageLite<
        PB_UserWithMe, PB_UserWithMe.Builder> implements
    // @@protoc_insertion_point(message_implements:PB_UserWithMe)
    PB_UserWithMeOrBuilder {
  private PB_UserWithMe() {
    userName_ = "";
    firstName_ = "";
    lastName_ = "";
    about_ = "";
    fullName_ = "";
    avatarUrl_ = "";
    phone_ = "";
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

  public static final int USERNAME_FIELD_NUMBER = 2;
  private java.lang.String userName_;
  /**
   * <code>string UserName = 2;</code>
   */
  public java.lang.String getUserName() {
    return userName_;
  }
  /**
   * <code>string UserName = 2;</code>
   */
  public com.google.protobuf.ByteString
      getUserNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(userName_);
  }
  /**
   * <code>string UserName = 2;</code>
   */
  private void setUserName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    userName_ = value;
  }
  /**
   * <code>string UserName = 2;</code>
   */
  private void clearUserName() {
    
    userName_ = getDefaultInstance().getUserName();
  }
  /**
   * <code>string UserName = 2;</code>
   */
  private void setUserNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    userName_ = value.toStringUtf8();
  }

  public static final int FIRSTNAME_FIELD_NUMBER = 3;
  private java.lang.String firstName_;
  /**
   * <code>string FirstName = 3;</code>
   */
  public java.lang.String getFirstName() {
    return firstName_;
  }
  /**
   * <code>string FirstName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(firstName_);
  }
  /**
   * <code>string FirstName = 3;</code>
   */
  private void setFirstName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    firstName_ = value;
  }
  /**
   * <code>string FirstName = 3;</code>
   */
  private void clearFirstName() {
    
    firstName_ = getDefaultInstance().getFirstName();
  }
  /**
   * <code>string FirstName = 3;</code>
   */
  private void setFirstNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    firstName_ = value.toStringUtf8();
  }

  public static final int LASTNAME_FIELD_NUMBER = 4;
  private java.lang.String lastName_;
  /**
   * <code>string LastName = 4;</code>
   */
  public java.lang.String getLastName() {
    return lastName_;
  }
  /**
   * <code>string LastName = 4;</code>
   */
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(lastName_);
  }
  /**
   * <code>string LastName = 4;</code>
   */
  private void setLastName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    lastName_ = value;
  }
  /**
   * <code>string LastName = 4;</code>
   */
  private void clearLastName() {
    
    lastName_ = getDefaultInstance().getLastName();
  }
  /**
   * <code>string LastName = 4;</code>
   */
  private void setLastNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    lastName_ = value.toStringUtf8();
  }

  public static final int ABOUT_FIELD_NUMBER = 5;
  private java.lang.String about_;
  /**
   * <code>string About = 5;</code>
   */
  public java.lang.String getAbout() {
    return about_;
  }
  /**
   * <code>string About = 5;</code>
   */
  public com.google.protobuf.ByteString
      getAboutBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(about_);
  }
  /**
   * <code>string About = 5;</code>
   */
  private void setAbout(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    about_ = value;
  }
  /**
   * <code>string About = 5;</code>
   */
  private void clearAbout() {
    
    about_ = getDefaultInstance().getAbout();
  }
  /**
   * <code>string About = 5;</code>
   */
  private void setAboutBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    about_ = value.toStringUtf8();
  }

  public static final int FULLNAME_FIELD_NUMBER = 6;
  private java.lang.String fullName_;
  /**
   * <code>string FullName = 6;</code>
   */
  public java.lang.String getFullName() {
    return fullName_;
  }
  /**
   * <code>string FullName = 6;</code>
   */
  public com.google.protobuf.ByteString
      getFullNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(fullName_);
  }
  /**
   * <code>string FullName = 6;</code>
   */
  private void setFullName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    fullName_ = value;
  }
  /**
   * <code>string FullName = 6;</code>
   */
  private void clearFullName() {
    
    fullName_ = getDefaultInstance().getFullName();
  }
  /**
   * <code>string FullName = 6;</code>
   */
  private void setFullNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    fullName_ = value.toStringUtf8();
  }

  public static final int AVATARURL_FIELD_NUMBER = 7;
  private java.lang.String avatarUrl_;
  /**
   * <code>string AvatarUrl = 7;</code>
   */
  public java.lang.String getAvatarUrl() {
    return avatarUrl_;
  }
  /**
   * <code>string AvatarUrl = 7;</code>
   */
  public com.google.protobuf.ByteString
      getAvatarUrlBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(avatarUrl_);
  }
  /**
   * <code>string AvatarUrl = 7;</code>
   */
  private void setAvatarUrl(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    avatarUrl_ = value;
  }
  /**
   * <code>string AvatarUrl = 7;</code>
   */
  private void clearAvatarUrl() {
    
    avatarUrl_ = getDefaultInstance().getAvatarUrl();
  }
  /**
   * <code>string AvatarUrl = 7;</code>
   */
  private void setAvatarUrlBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    avatarUrl_ = value.toStringUtf8();
  }

  public static final int PRIVACYPROFILE_FIELD_NUMBER = 8;
  private int privacyProfile_;
  /**
   * <code>int32 PrivacyProfile = 8;</code>
   */
  public int getPrivacyProfile() {
    return privacyProfile_;
  }
  /**
   * <code>int32 PrivacyProfile = 8;</code>
   */
  private void setPrivacyProfile(int value) {
    
    privacyProfile_ = value;
  }
  /**
   * <code>int32 PrivacyProfile = 8;</code>
   */
  private void clearPrivacyProfile() {
    
    privacyProfile_ = 0;
  }

  public static final int PHONE_FIELD_NUMBER = 9;
  private java.lang.String phone_;
  /**
   * <code>string Phone = 9;</code>
   */
  public java.lang.String getPhone() {
    return phone_;
  }
  /**
   * <code>string Phone = 9;</code>
   */
  public com.google.protobuf.ByteString
      getPhoneBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(phone_);
  }
  /**
   * <code>string Phone = 9;</code>
   */
  private void setPhone(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    phone_ = value;
  }
  /**
   * <code>string Phone = 9;</code>
   */
  private void clearPhone() {
    
    phone_ = getDefaultInstance().getPhone();
  }
  /**
   * <code>string Phone = 9;</code>
   */
  private void setPhoneBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    phone_ = value.toStringUtf8();
  }

  public static final int UPDATEDTIME_FIELD_NUMBER = 10;
  private int updatedTime_;
  /**
   * <code>int32 UpdatedTime = 10;</code>
   */
  public int getUpdatedTime() {
    return updatedTime_;
  }
  /**
   * <code>int32 UpdatedTime = 10;</code>
   */
  private void setUpdatedTime(int value) {
    
    updatedTime_ = value;
  }
  /**
   * <code>int32 UpdatedTime = 10;</code>
   */
  private void clearUpdatedTime() {
    
    updatedTime_ = 0;
  }

  public static final int APPVERSION_FIELD_NUMBER = 11;
  private int appVersion_;
  /**
   * <code>int32 AppVersion = 11;</code>
   */
  public int getAppVersion() {
    return appVersion_;
  }
  /**
   * <code>int32 AppVersion = 11;</code>
   */
  private void setAppVersion(int value) {
    
    appVersion_ = value;
  }
  /**
   * <code>int32 AppVersion = 11;</code>
   */
  private void clearAppVersion() {
    
    appVersion_ = 0;
  }

  public static final int FOLLOWINGTYPE_FIELD_NUMBER = 14;
  private int followingType_;
  /**
   * <code>int32 FollowingType = 14;</code>
   */
  public int getFollowingType() {
    return followingType_;
  }
  /**
   * <code>int32 FollowingType = 14;</code>
   */
  private void setFollowingType(int value) {
    
    followingType_ = value;
  }
  /**
   * <code>int32 FollowingType = 14;</code>
   */
  private void clearFollowingType() {
    
    followingType_ = 0;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!userName_.isEmpty()) {
      output.writeString(2, getUserName());
    }
    if (!firstName_.isEmpty()) {
      output.writeString(3, getFirstName());
    }
    if (!lastName_.isEmpty()) {
      output.writeString(4, getLastName());
    }
    if (!about_.isEmpty()) {
      output.writeString(5, getAbout());
    }
    if (!fullName_.isEmpty()) {
      output.writeString(6, getFullName());
    }
    if (!avatarUrl_.isEmpty()) {
      output.writeString(7, getAvatarUrl());
    }
    if (privacyProfile_ != 0) {
      output.writeInt32(8, privacyProfile_);
    }
    if (!phone_.isEmpty()) {
      output.writeString(9, getPhone());
    }
    if (updatedTime_ != 0) {
      output.writeInt32(10, updatedTime_);
    }
    if (appVersion_ != 0) {
      output.writeInt32(11, appVersion_);
    }
    if (followingType_ != 0) {
      output.writeInt32(14, followingType_);
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
    if (!userName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(2, getUserName());
    }
    if (!firstName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(3, getFirstName());
    }
    if (!lastName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(4, getLastName());
    }
    if (!about_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(5, getAbout());
    }
    if (!fullName_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(6, getFullName());
    }
    if (!avatarUrl_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(7, getAvatarUrl());
    }
    if (privacyProfile_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, privacyProfile_);
    }
    if (!phone_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(9, getPhone());
    }
    if (updatedTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(10, updatedTime_);
    }
    if (appVersion_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(11, appVersion_);
    }
    if (followingType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(14, followingType_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static ir.ms.pb.PB_UserWithMe parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserWithMe parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserWithMe parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static ir.ms.pb.PB_UserWithMe parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ir.ms.pb.PB_UserWithMe prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code PB_UserWithMe}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        ir.ms.pb.PB_UserWithMe, Builder> implements
      // @@protoc_insertion_point(builder_implements:PB_UserWithMe)
      ir.ms.pb.PB_UserWithMeOrBuilder {
    // Construct using ir.ms.pb.PB_UserWithMe.newBuilder()
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
     * <code>string UserName = 2;</code>
     */
    public java.lang.String getUserName() {
      return instance.getUserName();
    }
    /**
     * <code>string UserName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUserNameBytes() {
      return instance.getUserNameBytes();
    }
    /**
     * <code>string UserName = 2;</code>
     */
    public Builder setUserName(
        java.lang.String value) {
      copyOnWrite();
      instance.setUserName(value);
      return this;
    }
    /**
     * <code>string UserName = 2;</code>
     */
    public Builder clearUserName() {
      copyOnWrite();
      instance.clearUserName();
      return this;
    }
    /**
     * <code>string UserName = 2;</code>
     */
    public Builder setUserNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setUserNameBytes(value);
      return this;
    }

    /**
     * <code>string FirstName = 3;</code>
     */
    public java.lang.String getFirstName() {
      return instance.getFirstName();
    }
    /**
     * <code>string FirstName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      return instance.getFirstNameBytes();
    }
    /**
     * <code>string FirstName = 3;</code>
     */
    public Builder setFirstName(
        java.lang.String value) {
      copyOnWrite();
      instance.setFirstName(value);
      return this;
    }
    /**
     * <code>string FirstName = 3;</code>
     */
    public Builder clearFirstName() {
      copyOnWrite();
      instance.clearFirstName();
      return this;
    }
    /**
     * <code>string FirstName = 3;</code>
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setFirstNameBytes(value);
      return this;
    }

    /**
     * <code>string LastName = 4;</code>
     */
    public java.lang.String getLastName() {
      return instance.getLastName();
    }
    /**
     * <code>string LastName = 4;</code>
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      return instance.getLastNameBytes();
    }
    /**
     * <code>string LastName = 4;</code>
     */
    public Builder setLastName(
        java.lang.String value) {
      copyOnWrite();
      instance.setLastName(value);
      return this;
    }
    /**
     * <code>string LastName = 4;</code>
     */
    public Builder clearLastName() {
      copyOnWrite();
      instance.clearLastName();
      return this;
    }
    /**
     * <code>string LastName = 4;</code>
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setLastNameBytes(value);
      return this;
    }

    /**
     * <code>string About = 5;</code>
     */
    public java.lang.String getAbout() {
      return instance.getAbout();
    }
    /**
     * <code>string About = 5;</code>
     */
    public com.google.protobuf.ByteString
        getAboutBytes() {
      return instance.getAboutBytes();
    }
    /**
     * <code>string About = 5;</code>
     */
    public Builder setAbout(
        java.lang.String value) {
      copyOnWrite();
      instance.setAbout(value);
      return this;
    }
    /**
     * <code>string About = 5;</code>
     */
    public Builder clearAbout() {
      copyOnWrite();
      instance.clearAbout();
      return this;
    }
    /**
     * <code>string About = 5;</code>
     */
    public Builder setAboutBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setAboutBytes(value);
      return this;
    }

    /**
     * <code>string FullName = 6;</code>
     */
    public java.lang.String getFullName() {
      return instance.getFullName();
    }
    /**
     * <code>string FullName = 6;</code>
     */
    public com.google.protobuf.ByteString
        getFullNameBytes() {
      return instance.getFullNameBytes();
    }
    /**
     * <code>string FullName = 6;</code>
     */
    public Builder setFullName(
        java.lang.String value) {
      copyOnWrite();
      instance.setFullName(value);
      return this;
    }
    /**
     * <code>string FullName = 6;</code>
     */
    public Builder clearFullName() {
      copyOnWrite();
      instance.clearFullName();
      return this;
    }
    /**
     * <code>string FullName = 6;</code>
     */
    public Builder setFullNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setFullNameBytes(value);
      return this;
    }

    /**
     * <code>string AvatarUrl = 7;</code>
     */
    public java.lang.String getAvatarUrl() {
      return instance.getAvatarUrl();
    }
    /**
     * <code>string AvatarUrl = 7;</code>
     */
    public com.google.protobuf.ByteString
        getAvatarUrlBytes() {
      return instance.getAvatarUrlBytes();
    }
    /**
     * <code>string AvatarUrl = 7;</code>
     */
    public Builder setAvatarUrl(
        java.lang.String value) {
      copyOnWrite();
      instance.setAvatarUrl(value);
      return this;
    }
    /**
     * <code>string AvatarUrl = 7;</code>
     */
    public Builder clearAvatarUrl() {
      copyOnWrite();
      instance.clearAvatarUrl();
      return this;
    }
    /**
     * <code>string AvatarUrl = 7;</code>
     */
    public Builder setAvatarUrlBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setAvatarUrlBytes(value);
      return this;
    }

    /**
     * <code>int32 PrivacyProfile = 8;</code>
     */
    public int getPrivacyProfile() {
      return instance.getPrivacyProfile();
    }
    /**
     * <code>int32 PrivacyProfile = 8;</code>
     */
    public Builder setPrivacyProfile(int value) {
      copyOnWrite();
      instance.setPrivacyProfile(value);
      return this;
    }
    /**
     * <code>int32 PrivacyProfile = 8;</code>
     */
    public Builder clearPrivacyProfile() {
      copyOnWrite();
      instance.clearPrivacyProfile();
      return this;
    }

    /**
     * <code>string Phone = 9;</code>
     */
    public java.lang.String getPhone() {
      return instance.getPhone();
    }
    /**
     * <code>string Phone = 9;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneBytes() {
      return instance.getPhoneBytes();
    }
    /**
     * <code>string Phone = 9;</code>
     */
    public Builder setPhone(
        java.lang.String value) {
      copyOnWrite();
      instance.setPhone(value);
      return this;
    }
    /**
     * <code>string Phone = 9;</code>
     */
    public Builder clearPhone() {
      copyOnWrite();
      instance.clearPhone();
      return this;
    }
    /**
     * <code>string Phone = 9;</code>
     */
    public Builder setPhoneBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setPhoneBytes(value);
      return this;
    }

    /**
     * <code>int32 UpdatedTime = 10;</code>
     */
    public int getUpdatedTime() {
      return instance.getUpdatedTime();
    }
    /**
     * <code>int32 UpdatedTime = 10;</code>
     */
    public Builder setUpdatedTime(int value) {
      copyOnWrite();
      instance.setUpdatedTime(value);
      return this;
    }
    /**
     * <code>int32 UpdatedTime = 10;</code>
     */
    public Builder clearUpdatedTime() {
      copyOnWrite();
      instance.clearUpdatedTime();
      return this;
    }

    /**
     * <code>int32 AppVersion = 11;</code>
     */
    public int getAppVersion() {
      return instance.getAppVersion();
    }
    /**
     * <code>int32 AppVersion = 11;</code>
     */
    public Builder setAppVersion(int value) {
      copyOnWrite();
      instance.setAppVersion(value);
      return this;
    }
    /**
     * <code>int32 AppVersion = 11;</code>
     */
    public Builder clearAppVersion() {
      copyOnWrite();
      instance.clearAppVersion();
      return this;
    }

    /**
     * <code>int32 FollowingType = 14;</code>
     */
    public int getFollowingType() {
      return instance.getFollowingType();
    }
    /**
     * <code>int32 FollowingType = 14;</code>
     */
    public Builder setFollowingType(int value) {
      copyOnWrite();
      instance.setFollowingType(value);
      return this;
    }
    /**
     * <code>int32 FollowingType = 14;</code>
     */
    public Builder clearFollowingType() {
      copyOnWrite();
      instance.clearFollowingType();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:PB_UserWithMe)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new ir.ms.pb.PB_UserWithMe();
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
        ir.ms.pb.PB_UserWithMe other = (ir.ms.pb.PB_UserWithMe) arg1;
        userId_ = visitor.visitInt(userId_ != 0, userId_,
            other.userId_ != 0, other.userId_);
        userName_ = visitor.visitString(!userName_.isEmpty(), userName_,
            !other.userName_.isEmpty(), other.userName_);
        firstName_ = visitor.visitString(!firstName_.isEmpty(), firstName_,
            !other.firstName_.isEmpty(), other.firstName_);
        lastName_ = visitor.visitString(!lastName_.isEmpty(), lastName_,
            !other.lastName_.isEmpty(), other.lastName_);
        about_ = visitor.visitString(!about_.isEmpty(), about_,
            !other.about_.isEmpty(), other.about_);
        fullName_ = visitor.visitString(!fullName_.isEmpty(), fullName_,
            !other.fullName_.isEmpty(), other.fullName_);
        avatarUrl_ = visitor.visitString(!avatarUrl_.isEmpty(), avatarUrl_,
            !other.avatarUrl_.isEmpty(), other.avatarUrl_);
        privacyProfile_ = visitor.visitInt(privacyProfile_ != 0, privacyProfile_,
            other.privacyProfile_ != 0, other.privacyProfile_);
        phone_ = visitor.visitString(!phone_.isEmpty(), phone_,
            !other.phone_.isEmpty(), other.phone_);
        updatedTime_ = visitor.visitInt(updatedTime_ != 0, updatedTime_,
            other.updatedTime_ != 0, other.updatedTime_);
        appVersion_ = visitor.visitInt(appVersion_ != 0, appVersion_,
            other.appVersion_ != 0, other.appVersion_);
        followingType_ = visitor.visitInt(followingType_ != 0, followingType_,
            other.followingType_ != 0, other.followingType_);
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
              case 18: {
                String s = input.readStringRequireUtf8();

                userName_ = s;
                break;
              }
              case 26: {
                String s = input.readStringRequireUtf8();

                firstName_ = s;
                break;
              }
              case 34: {
                String s = input.readStringRequireUtf8();

                lastName_ = s;
                break;
              }
              case 42: {
                String s = input.readStringRequireUtf8();

                about_ = s;
                break;
              }
              case 50: {
                String s = input.readStringRequireUtf8();

                fullName_ = s;
                break;
              }
              case 58: {
                String s = input.readStringRequireUtf8();

                avatarUrl_ = s;
                break;
              }
              case 64: {

                privacyProfile_ = input.readInt32();
                break;
              }
              case 74: {
                String s = input.readStringRequireUtf8();

                phone_ = s;
                break;
              }
              case 80: {

                updatedTime_ = input.readInt32();
                break;
              }
              case 88: {

                appVersion_ = input.readInt32();
                break;
              }
              case 112: {

                followingType_ = input.readInt32();
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
        if (PARSER == null) {    synchronized (ir.ms.pb.PB_UserWithMe.class) {
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


  // @@protoc_insertion_point(class_scope:PB_UserWithMe)
  private static final ir.ms.pb.PB_UserWithMe DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PB_UserWithMe();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static ir.ms.pb.PB_UserWithMe getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<PB_UserWithMe> PARSER;

  public static com.google.protobuf.Parser<PB_UserWithMe> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

