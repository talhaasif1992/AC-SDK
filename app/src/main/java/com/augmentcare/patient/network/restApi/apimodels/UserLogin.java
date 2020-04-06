package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserLogin implements Parcelable {

    @SerializedName("userData")
    @Expose
    private UserDataLogin userData;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = new ArrayList<>();
    @SerializedName("roles_name")
    @Expose
    private List<RolesName> rolesName = new ArrayList<>();
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("is_dependent")
    @Expose
    private boolean isDependent;
    @SerializedName("dependents")
    @Expose
    private List<Dependent> dependents = new ArrayList<>();
    @SerializedName("relation_with_primary")
    @Expose
    private String relationWithPrimary;

    public String getStripe_token() {
        return stripe_token;
    }

    public void setStripe_token(String stripe_token) {
        this.stripe_token = stripe_token;
    }

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("organization")
    @Expose
    private Organization organization;
    @SerializedName("policy")
    @Expose
    private List<Policy> policy = new ArrayList<>();
    @SerializedName("from_organization")
    @Expose
    private boolean fromOrganization;
    @SerializedName("is_on_plan")
    @Expose
    private boolean isOnPlan;
    @SerializedName("plan_details")
    @Expose
    private PlanDetails planDetails;
    @SerializedName("plan_id_500")
    @Expose
    private int planId500;
    @SerializedName("stripe_token")
    @Expose
    private String stripe_token;
    @SerializedName("access-token")
    @Expose
    private String header_access_token;
    @SerializedName("client")
    @Expose
    private String header_clientID;
    @SerializedName("uid")
    @Expose
    private String header_uID;
    public final static Parcelable.Creator<UserLogin> CREATOR = new Creator<UserLogin>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserLogin createFromParcel(Parcel in) {
            return new UserLogin(in);
        }

        public UserLogin[] newArray(int size) {
            return (new UserLogin[size]);
        }

    };

    protected UserLogin(Parcel in) {
        this.userData = ((UserDataLogin) in.readValue((UserDataLogin.class.getClassLoader())));
        in.readList(this.roles, (com.augmentcare.patient.network.restApi.apimodels.Role.class.getClassLoader()));
        in.readList(this.rolesName, (com.augmentcare.patient.network.restApi.apimodels.RolesName.class.getClassLoader()));
        this.channel = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.provider = ((String) in.readValue((String.class.getClassLoader())));
        this.isDependent = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.dependents, (java.lang.Object.class.getClassLoader()));
        this.relationWithPrimary = ((String) in.readValue((String.class.getClassLoader())));
        this.primary = ((String) in.readValue((String.class.getClassLoader())));
        this.organization = ((Organization) in.readValue((Organization.class.getClassLoader())));
        in.readList(this.policy, (com.augmentcare.patient.network.restApi.apimodels.Policy.class.getClassLoader()));
        this.fromOrganization = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isOnPlan = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.planDetails = ((PlanDetails) in.readValue((PlanDetails.class.getClassLoader())));
        this.planId500 = ((int) in.readValue((int.class.getClassLoader())));
        this.header_access_token = ((String) in.readValue((String.class.getClassLoader())));
        this.header_uID = ((String) in.readValue((String.class.getClassLoader())));
        this.header_clientID = ((String) in.readValue((String.class.getClassLoader())));
        this.stripe_token = ((String) in.readValue((String.class.getClassLoader())));

    }

    /**
     * No args constructor for use in serialization
     */
    public UserLogin() {
    }

    /**
     * @param planId500
     * @param userData
     * @param fromOrganization
     * @param roles
     * @param rolesName
     * @param channel
     * @param isDependent
     * @param relationWithPrimary
     * @param uid
     * @param planDetails
     * @param provider
     * @param organization
     * @param isOnPlan
     * @param dependents
     * @param email
     * @param primary
     * @param policy
     */
    public UserLogin(UserDataLogin userData, List<Role> roles, List<RolesName> rolesName, String channel, String uid, String email, String provider, boolean isDependent, List<Dependent> dependents, String relationWithPrimary, String primary, Organization organization, List<Policy> policy, boolean fromOrganization, boolean isOnPlan, PlanDetails planDetails, int planId500) {
        super();
        this.userData = userData;
        this.roles = roles;
        this.rolesName = rolesName;
        this.channel = channel;
        this.header_uID = uid;
        this.email = email;
        this.provider = provider;
        this.isDependent = isDependent;
        this.dependents = dependents;
        this.relationWithPrimary = relationWithPrimary;
        this.primary = primary;
        this.organization = organization;
        this.policy = policy;
        this.fromOrganization = fromOrganization;
        this.isOnPlan = isOnPlan;
        this.planDetails = planDetails;
        this.planId500 = planId500;
    }

    public String getHeader_access_token() {
        return header_access_token;
    }

    public void setHeader_access_token(String header_access_token) {
        this.header_access_token = header_access_token;
    }

    public UserLogin withHeader_access_token(String header_access_token) {
        this.header_access_token = header_access_token;
        return this;
    }

    public String getHeader_clientID() {
        return header_clientID;
    }

    public void setHeader_clientID(String header_clientID) {
        this.header_clientID = header_clientID;
    }

    public UserLogin withHeader_clientID(String header_clientID) {
        this.header_clientID = header_clientID;
        return this;
    }


    public String getHeader_uID() {
        return header_uID;
    }

    public void setHeader_uID(String header_uID) {
        this.header_uID = header_uID;
    }

    public UserLogin withHeader_uID(String header_uID) {
        this.header_uID = header_uID;
        return this;
    }


    public UserDataLogin getUserData() {
        return userData;
    }

    public void setUserData(UserDataLogin userData) {
        this.userData = userData;
    }

    public UserLogin withUserData(UserDataLogin userData) {
        this.userData = userData;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public UserLogin withRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
    public UserLogin withStripeToke(String stripe_token) {
        this.stripe_token = stripe_token;
        return this;
    }

    public List<RolesName> getRolesName() {
        return rolesName;
    }

    public void setRolesName(List<RolesName> rolesName) {
        this.rolesName = rolesName;
    }

    public UserLogin withRolesName(List<RolesName> rolesName) {
        this.rolesName = rolesName;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public UserLogin withChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public String getUid() {
        return header_uID;
    }

    public void setUid(String uid) {
        this.header_uID = uid;
    }

    public UserLogin withUid(String uid) {
        this.header_uID = uid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserLogin withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public UserLogin withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public boolean isIsDependent() {
        return isDependent;
    }

    public void setIsDependent(boolean isDependent) {
        this.isDependent = isDependent;
    }

    public UserLogin withIsDependent(boolean isDependent) {
        this.isDependent = isDependent;
        return this;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public UserLogin withDependents(List<Dependent> dependents) {
        this.dependents = dependents;
        return this;
    }

    public String getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public UserLogin withRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public UserLogin withPrimary(String primary) {
        this.primary = primary;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public UserLogin withOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public List<Policy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

    public UserLogin withPolicy(List<Policy> policy) {
        this.policy = policy;
        return this;
    }

    public boolean isFromOrganization() {
        return fromOrganization;
    }

    public void setFromOrganization(boolean fromOrganization) {
        this.fromOrganization = fromOrganization;
    }

    public UserLogin withFromOrganization(boolean fromOrganization) {
        this.fromOrganization = fromOrganization;
        return this;
    }

    public boolean isIsOnPlan() {
        return isOnPlan;
    }

    public void setIsOnPlan(boolean isOnPlan) {
        this.isOnPlan = isOnPlan;
    }

    public UserLogin withIsOnPlan(boolean isOnPlan) {
        this.isOnPlan = isOnPlan;
        return this;
    }

    public PlanDetails getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(PlanDetails planDetails) {
        this.planDetails = planDetails;
    }

    public UserLogin withPlanDetails(PlanDetails planDetails) {
        this.planDetails = planDetails;
        return this;
    }

    public int getPlanId500() {
        return planId500;
    }

    public void setPlanId500(int planId500) {
        this.planId500 = planId500;
    }

    public UserLogin withPlanId500(int planId500) {
        this.planId500 = planId500;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userData", userData).append("roles", roles).append("rolesName", rolesName).append("channel", channel).append("uid", header_uID).append("email", email).append("provider", provider).append("isDependent", isDependent).append("dependents", dependents).append("relationWithPrimary", relationWithPrimary).append("primary", primary).append("organization", organization).append("policy", policy).append("fromOrganization", fromOrganization).append("isOnPlan", isOnPlan).append("planDetails", planDetails).append("planId500", planId500).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userData);
        dest.writeList(roles);
        dest.writeList(rolesName);
        dest.writeValue(channel);
        dest.writeValue(header_uID);
        dest.writeValue(email);
        dest.writeValue(provider);
        dest.writeValue(isDependent);
        dest.writeList(dependents);
        dest.writeValue(relationWithPrimary);
        dest.writeValue(primary);
        dest.writeValue(organization);
        dest.writeList(policy);
        dest.writeValue(fromOrganization);
        dest.writeValue(isOnPlan);
        dest.writeValue(planDetails);
        dest.writeValue(planId500);
        dest.writeValue(stripe_token);
    }

    public int describeContents() {
        return 0;
    }

}