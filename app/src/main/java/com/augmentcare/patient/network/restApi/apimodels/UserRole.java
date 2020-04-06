package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserRole implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("role_id")
    @Expose
    private Long roleId;
    @SerializedName("user_id")
    @Expose
    private Long userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    public final static Parcelable.Creator<UserRole> CREATOR = new Creator<UserRole>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserRole createFromParcel(Parcel in) {
            return new UserRole(in);
        }

        public UserRole[] newArray(int size) {
            return (new UserRole[size]);
        }

    };

    protected UserRole(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.roleId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.userId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole withId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UserRole withRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRole withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserRole withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserRole withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public UserRole withVerified(Boolean verified) {
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