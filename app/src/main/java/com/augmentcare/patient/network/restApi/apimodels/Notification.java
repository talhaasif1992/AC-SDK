package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Notification implements Parcelable {

    @SerializedName("notifications")
    @Expose
    private List<NotificationInternal> notification = new ArrayList<NotificationInternal>();
    @SerializedName("notification_counter")
    @Expose
    private NotificationCounter notificationCounter;
    @SerializedName("user_role")
    @Expose
    private UserRole userRole;
    public final static Parcelable.Creator<Notification> CREATOR = new Creator<Notification>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Notification createFromParcel(Parcel in) {
            return new Notification(in);
        }

        public Notification[] newArray(int size) {
            return (new Notification[size]);
        }

    };

    protected Notification(Parcel in) {
        in.readList(this.notification, (NotificationInternal.class.getClassLoader()));
        this.notificationCounter = ((NotificationCounter) in.readValue((NotificationCounter.class.getClassLoader())));
        this.userRole = ((UserRole) in.readValue((UserRole.class.getClassLoader())));
    }

    public Notification() {
    }

    public List<NotificationInternal> getNotification() {
        return notification;
    }

    public void setNotification(List<NotificationInternal> notification) {
        this.notification = notification;
    }

    public Notification withNotification(List<NotificationInternal> notification) {
        this.notification = notification;
        return this;
    }

    public NotificationCounter getNotificationCounter() {
        return notificationCounter;
    }

    public void setNotificationCounter(NotificationCounter notificationCounter) {
        this.notificationCounter = notificationCounter;
    }

    public Notification withNotificationCounter(NotificationCounter notificationCounter) {
        this.notificationCounter = notificationCounter;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Notification withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("notification", notification).append("notificationCounter", notificationCounter).append("userRole", userRole).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(notification);
        dest.writeValue(notificationCounter);
        dest.writeValue(userRole);
    }

    public int describeContents() {
        return 0;
    }

}