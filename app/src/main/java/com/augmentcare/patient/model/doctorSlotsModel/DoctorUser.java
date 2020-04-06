
package com.augmentcare.patient.model.doctorSlotsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorUser {

    @SerializedName("id")
    @Expose
    private Integer id;
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
    private Object nickname;
    @SerializedName("image")
    @Expose
    private Object image;
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
    private Object deviceId;
    @SerializedName("origin")
    @Expose
    private Object origin;
    @SerializedName("phone_verified")
    @Expose
    private String phoneVerified;
    @SerializedName("partner_branch_id")
    @Expose
    private Object partnerBranchId;
    @SerializedName("created_by")
    @Expose
    private Object createdBy;
    @SerializedName("primary_id")
    @Expose
    private Object primaryId;
    @SerializedName("relation_with_primary")
    @Expose
    private Object relationWithPrimary;
    @SerializedName("user_uid")
    @Expose
    private String userUid;
    @SerializedName("mr_number")
    @Expose
    private Object mrNumber;
    @SerializedName("provider_id")
    @Expose
    private Object providerId;
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
    private Object trailStartDate;
    @SerializedName("trail_end_date")
    @Expose
    private Object trailEndDate;
    @SerializedName("allow_password_change")
    @Expose
    private Boolean allowPasswordChange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getStripeCardToken() {
        return stripeCardToken;
    }

    public void setStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    public Object getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Object deviceId) {
        this.deviceId = deviceId;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public Object getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(Object partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Object primaryId) {
        this.primaryId = primaryId;
    }

    public Object getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(Object relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Object getMrNumber() {
        return mrNumber;
    }

    public void setMrNumber(Object mrNumber) {
        this.mrNumber = mrNumber;
    }

    public Object getProviderId() {
        return providerId;
    }

    public void setProviderId(Object providerId) {
        this.providerId = providerId;
    }

    public Boolean getIsDoctorContactMe() {
        return isDoctorContactMe;
    }

    public void setIsDoctorContactMe(Boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public Boolean getOnTrail() {
        return onTrail;
    }

    public void setOnTrail(Boolean onTrail) {
        this.onTrail = onTrail;
    }

    public Object getTrailStartDate() {
        return trailStartDate;
    }

    public void setTrailStartDate(Object trailStartDate) {
        this.trailStartDate = trailStartDate;
    }

    public Object getTrailEndDate() {
        return trailEndDate;
    }

    public void setTrailEndDate(Object trailEndDate) {
        this.trailEndDate = trailEndDate;
    }

    public Boolean getAllowPasswordChange() {
        return allowPasswordChange;
    }

    public void setAllowPasswordChange(Boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
    }

}
