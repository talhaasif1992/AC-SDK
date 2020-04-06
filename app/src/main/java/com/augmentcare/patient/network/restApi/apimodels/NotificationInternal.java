package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NotificationInternal implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("notification_object")
    @Expose
    private NotificationObject notificationObject;
    @SerializedName("user_role_id")
    @Expose
    private Long userRoleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("model_id")
    @Expose
    private Long modelId;
    @SerializedName("notification_type")
    @Expose
    private String notificationType;
    @SerializedName("notify_text")
    @Expose
    private String notifyText;
    @SerializedName("read")
    @Expose
    private Boolean read;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("user_id")
    @Expose
    private Long userId;
    public final static Parcelable.Creator<NotificationInternal> CREATOR = new Creator<NotificationInternal>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotificationInternal createFromParcel(Parcel in) {
            return new NotificationInternal(in);
        }

        public NotificationInternal[] newArray(int size) {
            return (new NotificationInternal[size]);
        }

    };

    protected NotificationInternal(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.notificationObject = ((NotificationObject) in.readValue((NotificationObject.class.getClassLoader())));
        this.userRoleId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.modelId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.notificationType = ((String) in.readValue((String.class.getClassLoader())));
        this.notifyText = ((String) in.readValue((String.class.getClassLoader())));
        this.read = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.modelType = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Long) in.readValue((Long.class.getClassLoader())));
    }

    public NotificationInternal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationInternal withId(Long id) {
        this.id = id;
        return this;
    }

    public NotificationObject getNotificationObject() {
        return notificationObject;
    }

    public void setNotificationObject(NotificationObject notificationObject) {
        this.notificationObject = notificationObject;
    }

    public NotificationInternal withNotificationObject(NotificationObject notificationObject) {
        this.notificationObject = notificationObject;
        return this;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public NotificationInternal withUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public NotificationInternal withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public NotificationInternal withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public NotificationInternal withModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationInternal withNotificationType(String notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public String getNotifyText() {
        return notifyText;
    }

    public void setNotifyText(String notifyText) {
        this.notifyText = notifyText;
    }

    public NotificationInternal withNotifyText(String notifyText) {
        this.notifyText = notifyText;
        return this;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public NotificationInternal withRead(Boolean read) {
        this.read = read;
        return this;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public NotificationInternal withModelType(String modelType) {
        this.modelType = modelType;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public NotificationInternal withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("notificationObject", notificationObject).append("userRoleId", userRoleId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("modelId", modelId).append("notificationType", notificationType).append("notifyText", notifyText).append("read", read).append("modelType", modelType).append("userId", userId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(notificationObject);
        dest.writeValue(userRoleId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(modelId);
        dest.writeValue(notificationType);
        dest.writeValue(notifyText);
        dest.writeValue(read);
        dest.writeValue(modelType);
        dest.writeValue(userId);
    }

    public int describeContents() {
        return 0;
    }

}