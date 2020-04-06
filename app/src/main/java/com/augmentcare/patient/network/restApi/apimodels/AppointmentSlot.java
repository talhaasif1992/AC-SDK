package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppointmentSlot implements Parcelable {

    @SerializedName("slot")
    @Expose
    private Slot slot;
    @SerializedName("notification")
    @Expose
    private Notification notification;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("notification_counter")
    @Expose
    private NotificationCounter notificationCounter;
    @SerializedName("user_role")
    @Expose
    private UserRole userRole;
    public final static Parcelable.Creator<AppointmentSlot> CREATOR = new Creator<AppointmentSlot>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AppointmentSlot createFromParcel(Parcel in) {
            return new AppointmentSlot(in);
        }

        public AppointmentSlot[] newArray(int size) {
            return (new AppointmentSlot[size]);
        }

    };

    protected AppointmentSlot(Parcel in) {
        this.slot = ((Slot) in.readValue((Slot.class.getClassLoader())));
        this.notification = ((Notification) in.readValue((Notification.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.notificationCounter = ((NotificationCounter) in.readValue((NotificationCounter.class.getClassLoader())));
        this.userRole = ((UserRole) in.readValue((UserRole.class.getClassLoader())));
    }

    public AppointmentSlot() {
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public AppointmentSlot withSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public AppointmentSlot withNotification(Notification notification) {
        this.notification = notification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AppointmentSlot withUser(User user) {
        this.user = user;
        return this;
    }

    public NotificationCounter getNotificationCounter() {
        return notificationCounter;
    }

    public void setNotificationCounter(NotificationCounter notificationCounter) {
        this.notificationCounter = notificationCounter;
    }

    public AppointmentSlot withNotificationCounter(NotificationCounter notificationCounter) {
        this.notificationCounter = notificationCounter;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public AppointmentSlot withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("slot", slot).append("notification", notification).append("user", user).append("notificationCounter", notificationCounter).append("userRole", userRole).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slot);
        dest.writeValue(notification);
        dest.writeValue(user);
        dest.writeValue(notificationCounter);
        dest.writeValue(userRole);
    }

    public int describeContents() {
        return 0;
    }

}