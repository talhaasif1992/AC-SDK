package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Role implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("role_id")
    @Expose
    private int roleId;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("verified")
    @Expose
    private boolean verified;
    public final static Parcelable.Creator<Role> CREATOR = new Creator<Role>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Role createFromParcel(Parcel in) {
            return new Role(in);
        }

        public Role[] newArray(int size) {
            return (new Role[size]);
        }

    };

    protected Role(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.roleId = ((int) in.readValue((int.class.getClassLoader())));
        this.userId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.verified = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Role() {
    }

    /**
     * @param createdAt
     * @param roleId
     * @param verified
     * @param id
     * @param userId
     * @param updatedAt
     */
    public Role(int id, int roleId, int userId, String createdAt, String updatedAt, boolean verified) {
        super();
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.verified = verified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role withId(int id) {
        this.id = id;
        return this;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role withRoleId(int roleId) {
        this.roleId = roleId;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Role withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Role withVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("roleId", roleId).append("userId", userId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("verified", verified).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(roleId);
        dest.writeValue(userId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(verified);
    }

    public int describeContents() {
        return 0;
    }

}