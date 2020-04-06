package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NotificationCounter implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("offline_counter")
    @Expose
    private Long offlineCounter;
    @SerializedName("user_role_id")
    @Expose
    private Long userRoleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user_id")
    @Expose
    private Long userId;
    public final static Parcelable.Creator<NotificationCounter> CREATOR = new Creator<NotificationCounter>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotificationCounter createFromParcel(Parcel in) {
            return new NotificationCounter(in);
        }

        public NotificationCounter[] newArray(int size) {
            return (new NotificationCounter[size]);
        }

    };

    protected NotificationCounter(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.offlineCounter = ((Long) in.readValue((Long.class.getClassLoader())));
        this.userRoleId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Long) in.readValue((Long.class.getClassLoader())));
    }

    public NotificationCounter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationCounter withId(Long id) {
        this.id = id;
        return this;
    }

    public Long getOfflineCounter() {
        return offlineCounter;
    }

    public void setOfflineCounter(Long offlineCounter) {
        this.offlineCounter = offlineCounter;
    }

    public NotificationCounter withOfflineCounter(Long offlineCounter) {
        this.offlineCounter = offlineCounter;
        return this;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public NotificationCounter withUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public NotificationCounter withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public NotificationCounter withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public NotificationCounter withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("offlineCounter", offlineCounter).append("userRoleId", userRoleId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("userId", userId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(offlineCounter);
        dest.writeValue(userRoleId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(userId);
    }

    public int describeContents() {
        return 0;
    }

}