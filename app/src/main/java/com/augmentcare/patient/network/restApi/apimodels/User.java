package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("channel_key")
    @Expose
    private String channelKey;
    @SerializedName("stripe_card_token")
    @Expose
    private String stripeCardToken;
    @SerializedName("stripe_customer_id")
    @Expose
    private String stripeCustomerId;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("phone_verified")
    @Expose
    private String phoneVerified;
    @SerializedName("partner_branch_id")
    @Expose
    private Long partnerBranchId;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("primary_id")
    @Expose
    private Long primaryId;
    @SerializedName("relation_with_primary")
    @Expose
    private String relationWithPrimary;
    @SerializedName("user_uid")
    @Expose
    private String userUid;
    @SerializedName("mr_number")
    @Expose
    private String mrNumber;
    @SerializedName("provider_id")
    @Expose
    private Long providerId;
    @SerializedName("is_doctor_contact_me")
    @Expose
    private Boolean isDoctorContactMe;
    @SerializedName("part_of_project")
    @Expose
    private String partOfProject;
    @SerializedName("on_trail")
    @Expose
    private Boolean onTrail;
    @SerializedName("trail_start_date")
    @Expose
    private String trailStartDate;
    @SerializedName("trail_end_date")
    @Expose
    private String trailEndDate;
    @SerializedName("allow_password_change")
    @Expose
    private Boolean allowPasswordChange;
    @SerializedName("dr_mrnumber")
    @Expose
    private String drMrnumber;
    @SerializedName("can_login")
    @Expose
    private Boolean canLogin;
    @SerializedName("is_black_list")
    @Expose
    private Boolean isBlackList;
    @SerializedName("last_seen_at")
    @Expose
    private String lastSeenAt;
    @SerializedName("initial_quiz_attempted")
    @Expose
    private Boolean initialQuizAttempted;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    };

    protected User(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.provider = ((String) in.readValue((String.class.getClassLoader())));
        this.uid = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.nickname = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.channelKey = ((String) in.readValue((String.class.getClassLoader())));
        this.stripeCardToken = ((String) in.readValue((String.class.getClassLoader())));
        this.stripeCustomerId = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((Long.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.phoneVerified = ((String) in.readValue((String.class.getClassLoader())));
        this.partnerBranchId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.relationWithPrimary = ((String) in.readValue((String.class.getClassLoader())));
        this.userUid = ((String) in.readValue((String.class.getClassLoader())));
        this.mrNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.providerId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.isDoctorContactMe = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.partOfProject = ((String) in.readValue((String.class.getClassLoader())));
        this.onTrail = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.trailStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.trailEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.allowPasswordChange = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.drMrnumber = ((String) in.readValue((String.class.getClassLoader())));
        this.canLogin = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isBlackList = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lastSeenAt = ((String) in.readValue((String.class.getClassLoader())));
        this.initialQuizAttempted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User withId(Long id) {
        this.id = id;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public User withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User withImage(String image) {
        this.image = image;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public User withChannelKey(String channelKey) {
        this.channelKey = channelKey;
        return this;
    }

    public String getStripeCardToken() {
        return stripeCardToken;
    }

    public void setStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
    }

    public User withStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
        return this;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    public User withStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public User withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public User withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public User withPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
        return this;
    }

    public Long getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(Long partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public User withPartnerBranchId(Long partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public User withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Long getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Long primaryId) {
        this.primaryId = primaryId;
    }

    public User withPrimaryId(Long primaryId) {
        this.primaryId = primaryId;
        return this;
    }

    public String getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public User withRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public User withUserUid(String userUid) {
        this.userUid = userUid;
        return this;
    }

    public String getMrNumber() {
        return mrNumber;
    }

    public void setMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
    }

    public User withMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
        return this;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public User withProviderId(Long providerId) {
        this.providerId = providerId;
        return this;
    }

    public Boolean getIsDoctorContactMe() {
        return isDoctorContactMe;
    }

    public void setIsDoctorContactMe(Boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
    }

    public User withIsDoctorContactMe(Boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
        return this;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public User withPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
        return this;
    }

    public Boolean getOnTrail() {
        return onTrail;
    }

    public void setOnTrail(Boolean onTrail) {
        this.onTrail = onTrail;
    }

    public User withOnTrail(Boolean onTrail) {
        this.onTrail = onTrail;
        return this;
    }

    public String getTrailStartDate() {
        return trailStartDate;
    }

    public void setTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
    }

    public User withTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
        return this;
    }

    public String getTrailEndDate() {
        return trailEndDate;
    }

    public void setTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
    }

    public User withTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
        return this;
    }

    public Boolean getAllowPasswordChange() {
        return allowPasswordChange;
    }

    public void setAllowPasswordChange(Boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
    }

    public User withAllowPasswordChange(Boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
        return this;
    }

    public String getDrMrnumber() {
        return drMrnumber;
    }

    public void setDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
    }

    public User withDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
        return this;
    }

    public Boolean getCanLogin() {
        return canLogin;
    }

    public void setCanLogin(Boolean canLogin) {
        this.canLogin = canLogin;
    }

    public User withCanLogin(Boolean canLogin) {
        this.canLogin = canLogin;
        return this;
    }

    public Boolean getIsBlackList() {
        return isBlackList;
    }

    public void setIsBlackList(Boolean isBlackList) {
        this.isBlackList = isBlackList;
    }

    public User withIsBlackList(Boolean isBlackList) {
        this.isBlackList = isBlackList;
        return this;
    }

    public String getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    public User withLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
        return this;
    }

    public Boolean getInitialQuizAttempted() {
        return initialQuizAttempted;
    }

    public void setInitialQuizAttempted(Boolean initialQuizAttempted) {
        this.initialQuizAttempted = initialQuizAttempted;
    }

    public User withInitialQuizAttempted(Boolean initialQuizAttempted) {
        this.initialQuizAttempted = initialQuizAttempted;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("provider", provider).append("uid", uid).append("name", name).append("nickname", nickname).append("image", image).append("email", email).append("createdAt", createdAt).append("updatedAt", updatedAt).append("channelKey", channelKey).append("stripeCardToken", stripeCardToken).append("stripeCustomerId", stripeCustomerId).append("deviceId", deviceId).append("origin", origin).append("phoneVerified", phoneVerified).append("partnerBranchId", partnerBranchId).append("createdBy", createdBy).append("primaryId", primaryId).append("relationWithPrimary", relationWithPrimary).append("userUid", userUid).append("mrNumber", mrNumber).append("providerId", providerId).append("isDoctorContactMe", isDoctorContactMe).append("partOfProject", partOfProject).append("onTrail", onTrail).append("trailStartDate", trailStartDate).append("trailEndDate", trailEndDate).append("allowPasswordChange", allowPasswordChange).append("drMrnumber", drMrnumber).append("canLogin", canLogin).append("isBlackList", isBlackList).append("lastSeenAt", lastSeenAt).append("initialQuizAttempted", initialQuizAttempted).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(provider);
        dest.writeValue(uid);
        dest.writeValue(name);
        dest.writeValue(nickname);
        dest.writeValue(image);
        dest.writeValue(email);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(channelKey);
        dest.writeValue(stripeCardToken);
        dest.writeValue(stripeCustomerId);
        dest.writeValue(deviceId);
        dest.writeValue(origin);
        dest.writeValue(phoneVerified);
        dest.writeValue(partnerBranchId);
        dest.writeValue(createdBy);
        dest.writeValue(primaryId);
        dest.writeValue(relationWithPrimary);
        dest.writeValue(userUid);
        dest.writeValue(mrNumber);
        dest.writeValue(providerId);
        dest.writeValue(isDoctorContactMe);
        dest.writeValue(partOfProject);
        dest.writeValue(onTrail);
        dest.writeValue(trailStartDate);
        dest.writeValue(trailEndDate);
        dest.writeValue(allowPasswordChange);
        dest.writeValue(drMrnumber);
        dest.writeValue(canLogin);
        dest.writeValue(isBlackList);
        dest.writeValue(lastSeenAt);
        dest.writeValue(initialQuizAttempted);
    }

    public int describeContents() {
        return 0;
    }

}