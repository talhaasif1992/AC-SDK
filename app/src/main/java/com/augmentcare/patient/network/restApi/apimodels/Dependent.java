package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Dependent implements Parcelable
{

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
    private String nickname;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("dob")
    @Expose
    private String dob;
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
    private Integer primaryId;
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
    @SerializedName("dependent_type")
    @Expose
    private String dependentType;
    @SerializedName("can_login")
    @Expose
    private String canLogin;
    @SerializedName("is_black_list")
    @Expose
    private Boolean isBlackList;
    @SerializedName("last_seen_at")
    @Expose
    private String lastSeenAt;
    @SerializedName("initial_quiz_attempted")
    @Expose
    private Boolean initialQuizAttempted;
    @SerializedName("relationship_id")
    @Expose
    private Integer relationshipId;
    @SerializedName("policy_info")
    @Expose
    private PolicyInfo policyInfo;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("organization_id")
    @Expose
    private Integer organizationId;
    public final static Parcelable.Creator<Dependent> CREATOR = new Creator<Dependent>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Dependent createFromParcel(Parcel in) {
            return new Dependent(in);
        }

        public Dependent[] newArray(int size) {
            return (new Dependent[size]);
        }

    }
            ;

    protected Dependent(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.provider = ((String) in.readValue((String.class.getClassLoader())));
        this.uid = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.nickname = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
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
        this.primaryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.relationWithPrimary = ((String) in.readValue((String.class.getClassLoader())));
        this.userUid = ((String) in.readValue((String.class.getClassLoader())));
        this.mrNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.providerId = ((String) in.readValue((String.class.getClassLoader())));
        this.isDoctorContactMe = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.partOfProject = ((String) in.readValue((String.class.getClassLoader())));
        this.onTrail = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.trailStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.trailEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.allowPasswordChange = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.drMrnumber = ((String) in.readValue((String.class.getClassLoader())));
        this.canLogin = ((String) in.readValue((String.class.getClassLoader())));
        this.isBlackList = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lastSeenAt = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentType = ((String) in.readValue((String.class.getClassLoader())));
        this.initialQuizAttempted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.relationshipId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.organizationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.policyInfo = ((PolicyInfo) in.readValue((PolicyInfo.class.getClassLoader())));
    }

    public Dependent() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Dependent withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Dependent withOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dependent withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Dependent withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Dependent withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dependent withName(String name) {
        this.name = name;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Dependent withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Dependent withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Dependent withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Dependent withImage(String image) {
        this.image = image;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Dependent withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Dependent withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Dependent withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dependent withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Dependent withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Dependent withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public Dependent withChannelKey(String channelKey) {
        this.channelKey = channelKey;
        return this;
    }

    public String getStripeCardToken() {
        return stripeCardToken;
    }

    public void setStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
    }

    public Dependent withStripeCardToken(String stripeCardToken) {
        this.stripeCardToken = stripeCardToken;
        return this;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    public Dependent withStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Dependent withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Dependent withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public Dependent withPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
        return this;
    }

    public String getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(String partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public Dependent withPartnerBranchId(String partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Dependent withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Integer getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }

    public Dependent withPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
        return this;
    }

    public String getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public Dependent withRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Dependent withUserUid(String userUid) {
        this.userUid = userUid;
        return this;
    }

    public String getMrNumber() {
        return mrNumber;
    }

    public void setMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
    }

    public Dependent withMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
        return this;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Dependent withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public Boolean getIsDoctorContactMe() {
        return isDoctorContactMe;
    }

    public void setIsDoctorContactMe(Boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
    }

    public Dependent withIsDoctorContactMe(Boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
        return this;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public Dependent withPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
        return this;
    }

    public Boolean getOnTrail() {
        return onTrail;
    }

    public void setOnTrail(Boolean onTrail) {
        this.onTrail = onTrail;
    }

    public Dependent withOnTrail(Boolean onTrail) {
        this.onTrail = onTrail;
        return this;
    }

    public String getTrailStartDate() {
        return trailStartDate;
    }

    public void setTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
    }

    public Dependent withTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
        return this;
    }

    public String getTrailEndDate() {
        return trailEndDate;
    }

    public void setTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
    }

    public Dependent withTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
        return this;
    }

    public Boolean getAllowPasswordChange() {
        return allowPasswordChange;
    }

    public void setAllowPasswordChange(Boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
    }

    public Dependent withAllowPasswordChange(Boolean allowPasswordChange) {
        this.allowPasswordChange = allowPasswordChange;
        return this;
    }

    public String getDrMrnumber() {
        return drMrnumber;
    }

    public void setDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
    }

    public Dependent withDrMrnumber(String drMrnumber) {
        this.drMrnumber = drMrnumber;
        return this;
    }

    public String getCanLogin() {
        return canLogin;
    }

    public void setCanLogin(String canLogin) {
        this.canLogin = canLogin;
    }

    public Dependent withCanLogin(String canLogin) {
        this.canLogin = canLogin;
        return this;
    }

    public Boolean getIsBlackList() {
        return isBlackList;
    }

    public void setIsBlackList(Boolean isBlackList) {
        this.isBlackList = isBlackList;
    }

    public Dependent withIsBlackList(Boolean isBlackList) {
        this.isBlackList = isBlackList;
        return this;
    }

    public String getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    public Dependent withLastSeenAt(String lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
        return this;
    }
    public String getDependentType() {
        return dependentType;
    }

    public void setDependentType(String dependentType) {
        this.dependentType = lastSeenAt;
    }

    public Dependent withDependentType(String dependentType) {
        this.dependentType = dependentType;
        return this;
    }

    public Boolean getInitialQuizAttempted() {
        return initialQuizAttempted;
    }

    public void setInitialQuizAttempted(Boolean initialQuizAttempted) {
        this.initialQuizAttempted = initialQuizAttempted;
    }

    public Dependent withInitialQuizAttempted(Boolean initialQuizAttempted) {
        this.initialQuizAttempted = initialQuizAttempted;
        return this;
    }

    public Integer getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Dependent withRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
        return this;
    }

    public PolicyInfo getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(PolicyInfo policyInfo) {
        this.policyInfo = policyInfo;
    }

    public Dependent withPolicyInfo(PolicyInfo policyInfo) {
        this.policyInfo = policyInfo;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("provider", provider).append("uid", uid).append("name", name).append("nickname", nickname).append("firstName", firstName).append("lastName", lastName).append("image", image).append("photo", photo).append("phone", phone).append("dob", dob).append("email", email).append("createdAt", createdAt).append("updatedAt", updatedAt).append("channelKey", channelKey).append("stripeCardToken", stripeCardToken).append("stripeCustomerId", stripeCustomerId).append("deviceId", deviceId).append("origin", origin).append("phoneVerified", phoneVerified).append("partnerBranchId", partnerBranchId).append("createdBy", createdBy).append("primaryId", primaryId).append("relationWithPrimary", relationWithPrimary).append("userUid", userUid).append("mrNumber", mrNumber).append("providerId", providerId).append("isDoctorContactMe", isDoctorContactMe).append("partOfProject", partOfProject).append("onTrail", onTrail).append("trailStartDate", trailStartDate).append("trailEndDate", trailEndDate).append("allowPasswordChange", allowPasswordChange).append("drMrnumber", drMrnumber).append("canLogin", canLogin).append("isBlackList", isBlackList).append("lastSeenAt", lastSeenAt).append("initialQuizAttempted", initialQuizAttempted).append("relationshipId", relationshipId).append("policyInfo", policyInfo).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(provider);
        dest.writeValue(uid);
        dest.writeValue(name);
        dest.writeValue(nickname);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(image);
        dest.writeValue(photo);
        dest.writeValue(phone);
        dest.writeValue(dob);
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
        dest.writeValue(dependentType);
        dest.writeValue(initialQuizAttempted);
        dest.writeValue(relationshipId);
        dest.writeValue(policyInfo);
    }

    public int describeContents() {
        return 0;
    }

}