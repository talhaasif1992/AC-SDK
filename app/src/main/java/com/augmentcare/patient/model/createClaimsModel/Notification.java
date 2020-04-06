
package com.augmentcare.patient.model.createClaimsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("notification_object")
    @Expose
    private NotificationObject notificationObject;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("model_id")
    @Expose
    private Integer modelId;
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
    private Object userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotificationObject getNotificationObject() {
        return notificationObject;
    }

    public void setNotificationObject(NotificationObject notificationObject) {
        this.notificationObject = notificationObject;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotifyText() {
        return notifyText;
    }

    public void setNotifyText(String notifyText) {
        this.notifyText = notifyText;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

}
