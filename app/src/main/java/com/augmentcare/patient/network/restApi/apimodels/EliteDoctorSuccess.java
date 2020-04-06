package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class EliteDoctorSuccess extends ErrorsResponse implements Serializable {

    @SerializedName("payment")
    @Expose
    private Payment payment;

    @SerializedName("slot")
    @Expose
    private Slot slot;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("notification")
    @Expose
    private List<NotificationInternal> notification = null;

    @SerializedName("notification_counter")
    @Expose
    private NotificationCounter notificationCounter;

    @SerializedName("user_role")
    @Expose
    private UserRole userRole;

    @SerializedName("user")
    @Expose
    private User user;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<NotificationInternal> getNotification() {
        return notification;
    }

    public void setNotification(List<NotificationInternal> notification) {
        this.notification = notification;
    }

    public NotificationCounter getNotificationCounter() {
        return notificationCounter;
    }

    public void setNotificationCounter(NotificationCounter notificationCounter) {
        this.notificationCounter = notificationCounter;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
