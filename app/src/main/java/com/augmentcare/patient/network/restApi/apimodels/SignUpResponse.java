package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SignUpResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
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
    private String partnerBranchId;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("primary_id")
    @Expose
    private String primaryId;
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
    private String providerId;
    @SerializedName("is_doctor_contact_me")
    @Expose
    private boolean isDoctorContactMe;
    @SerializedName("part_of_project")
    @Expose
    private String partOfProject;
    @SerializedName("on_trail")
    @Expose
    private boolean onTrail;
    @SerializedName("trail_start_date")
    @Expose
    private String trailStartDate;
    @SerializedName("trail_end_date")
    @Expose
    private String trailEndDate;
    @SerializedName("allow_password_change")
    @Expose
    private boolean allowPasswordChange;
    @SerializedName("dr_mrnumber")
    @Expose
    private String drMrnumber;
    @SerializedName("can_login")
    @Expose
    private boolean canLogin;
    @SerializedName("is_black_list")
    @Expose
    private boolean isBlackList;
    @SerializedName("last_seen_at")
    @Expose
    private String lastSeenAt;
    public final static Parcelable.Creator<SignUpResponse> CREATOR = new Creator<SignUpResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SignUpResponse createFromParcel(Parcel in) {
            return new SignUpResponse(in);
        }

        public SignUpResponse[] newArray(int size) {
            return (new SignUpResponse[size]);
        }

    };

    protected SignUpResponse(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
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
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.origin = ((String) in.readValue((String.class.getClassLoader())));
        this.phoneVerified = ((String) in.readValue((String.class.getClassLoader())));
        this.partnerBranchId = ((String) in.readValue((String.class.getClassLoader())));
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryId = ((String) in.readValue((String.class.getClassLoader())));
        this.relationWithPrimary = ((String) in.readValue((String.class.getClassLoader())));
        this.userUid = ((String) in.readValue((String.class.getClassLoader())));
        this.mrNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.providerId = ((String) in.readValue((String.class.getClassLoader())));
        this.isDoctorContactMe = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.partOfProject = ((String) in.readValue((String.class.getClassLoader())));
        this.onTrail = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.trailStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.trailEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.allowPasswordChange = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.drMrnumber = ((String) in.readValue((String.class.getClassLoader())));
        this.canLogin = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isBlackList = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.lastSeenAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public SignUpResponse() {
    }

    /**
     * @param lastSeenAt
     * @param origin
     * @param primaryId
     * @param deviceId
     * @param uid
     * @param createdAt
     * @param canLogin
     * @param isBlackList
     * @param allowPasswordChange
     * @param provider
     * @param providerId
     * @param nickname
     * @param id
     * @param trailEndDate
     * @param email
     * @param updatedAt
     * @param drMrnumber
     * @param image
     * @param phoneVerified
     * @param mrNumber
     * @param partnerBranchId
     * @param relationWithPrimary
     * @param partOfProject
     * @param isDoctorContactMe
     * @param channelKey
     * @param createdBy
     * @param name
     * @param onTrail
     * @param stripeCardToken
     * @param trailStartDate
     * @param stripeCustomerId
     * @param userUid
     */
    public SignUpResponse(int id, String provider, String uid, String name, String nickname, String image, String email, String createdAt, String updatedAt, String channelKey, String stripeCardToken, String stripeCustomerId, String deviceId, String origin, String phoneVerified, String partnerBranchId, String createdBy, String primaryId, String relationWithPrimary, String userUid, String mrNumber, String providerId, boolean isDoctorContactMe, String partOfProject, boolean onTrail, String trailStartDate, String trailEndDate, boolean allowPasswordChange, String drMrnumber, boolean canLogin, boolean isBlackList, String lastSeenAt) {
        super();
        this.id = id;
        this.provider = provider;
        this.uid = uid;
        this.name = name;
        this.nickname = nickname;
        this.image = image;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.channelKey = channelKey;
        this.stripeCardToken = stripeCardToken;
        this.stripeCustomerId = stripeCustomerId;
        this.deviceId = deviceId;
        this.origin = origin;
        this.phoneVerified = phoneVerified;
        this.partnerBranchId = partnerBranchId;
        this.createdBy = createdBy;
        this.primaryId = primaryId;
        this.relationWithPrimary = relationWithPrimary;
        this.userUid = userUid;
        this.mrNumber = mrNumber;
        this.providerId = providerId;
        this.isDoctorContactMe = isDoctorContactMe;
        this.partOfProject = partOfProject;
        this.onTrail = onTrail;
        this.trailStartDate = trailStartDate;
        this.trailEndDate = trailEndDate;
        this.allowPasswordChange = allowPasswordChange;
        this.drMrnumber = drMrnumber;
        this.canLogin = canLogin;
        this.isBlackList = isBlackList;
        this.lastSeenAt = lastSeenAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SignUpResponse withId(int id) {
        this.id = id;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public SignUpResponse withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public SignUpResponse withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignUpResponse withName(String name) {
        this.name = name;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SignUpResponse withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SignUpResponse withImage(String image) {
        this.image = image;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SignUpResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public SignUpResponse withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SignUpResponse withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public SignUpResponse withChannelKey(String channelKey) {
        this.channelKey = channelKey;
        return this;
    }

    public String getStripeCardToken() {
        return stripeCardToken;
    }

    public void setStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
    }

    public SignUpResponse withStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
        return this;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    public SignUpResponse withStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public SignUpResponse withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public SignUpResponse withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public SignUpResponse withPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
        return this;
    }

    public String getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(String partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public SignUpResponse withPartnerBranchId(String partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public SignUpResponse withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public SignUpResponse withPrimaryId(String primaryId) {
        this.primaryId = primaryId;
        return this;
    }

    public String getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public SignUpResponse withRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public SignUpResponse withUserUid(String userUid) {
        this.userUid = userUid;
        return this;
    }

    public String getMrNumber() {
        return mrNumber;
    }

    public void setMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
    }

    public SignUpResponse withMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
        return this;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public SignUpResponse withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public boolean isIsDoctorContactMe() {
        return isDoctorContactMe;
    }

    public void setIsDoctorContactMe(boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
    }

    public SignUpResponse withIsDoctorContactMe(boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
        return this;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public SignUpResponse withPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
        return this;
    }

    public boolean isOnTrail() {
        return onTrail;
    }

    public void setOnTrail(boolean onTrail) {
        this.onTrail = onTrail;
    }

    public SignUpResponse withOnTrail(boolean onTrail) {
        this.onTrail = onTrail;
        return this;
    }

    public String getTrailStartDate() {
        return trailStartDate;
    }

    public void setTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
    }

    public SignUpResponse withTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
        return this;
    }

    public String getTrailEndDate() {
        return trailEndDate;
    }

    public void setTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
    }

    public SignUpResponse withTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
        return this;
    }

    public boolean isAllowPasswordChange() {
        return allowPasswordChange;
    }

    public void setAllowPasswordChange(boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
    }

    public SignUpResponse withAllowPasswordChange(boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
        return this;
    }

    public String getDrMrnumber() {
        return drMrnumber;
    }

    public void setDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
    }

    public SignUpResponse withDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
        return this;
    }

    public boolean isCanLogin() {
        return canLogin;
    }

    public void setCanLogin(boolean canLogin) {
        this.canLogin = canLogin;
    }

    public SignUpResponse withCanLogin(boolean canLogin) {
        this.canLogin = canLogin;
        return this;
    }

    public boolean isIsBlackList() {
        return isBlackList;
    }

    public void setIsBlackList(boolean isBlackList) {
        this.isBlackList = isBlackList;
    }

    public SignUpResponse withIsBlackList(boolean isBlackList) {
        this.isBlackList = isBlackList;
        return this;
    }

    public String getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    public SignUpResponse withLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("provider", provider).append("uid", uid).append("name", name).append("nickname", nickname).append("image", image).append("email", email).append("createdAt", createdAt).append("updatedAt", updatedAt).append("channelKey", channelKey).append("stripeCardToken", stripeCardToken).append("stripeCustomerId", stripeCustomerId).append("deviceId", deviceId).append("origin", origin).append("phoneVerified", phoneVerified).append("partnerBranchId", partnerBranchId).append("createdBy", createdBy).append("primaryId", primaryId).append("relationWithPrimary", relationWithPrimary).append("userUid", userUid).append("mrNumber", mrNumber).append("providerId", providerId).append("isDoctorContactMe", isDoctorContactMe).append("partOfProject", partOfProject).append("onTrail", onTrail).append("trailStartDate", trailStartDate).append("trailEndDate", trailEndDate).append("allowPasswordChange", allowPasswordChange).append("drMrnumber", drMrnumber).append("canLogin", canLogin).append("isBlackList", isBlackList).append("lastSeenAt", lastSeenAt).toString();
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
    }

    public int describeContents() {
        return 0;
    }

}