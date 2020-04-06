package com.augmentcare.patient.network.restApi.apirequests;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.augmentcare.patient.network.restApi.apimodels.NotificationInternal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllNotificationResponse implements Parcelable
{

    @SerializedName("notification")
    @Expose
    private List<NotificationInternal> notifications = new ArrayList<>();
    @SerializedName("notification_counter")
    @Expose
    private int notificationCounter;
    @SerializedName("total")
    @Expose
    private int total;
    public final static Parcelable.Creator<AllNotificationResponse> CREATOR = new Creator<AllNotificationResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AllNotificationResponse createFromParcel(Parcel in) {
            return new AllNotificationResponse(in);
        }

        public AllNotificationResponse[] newArray(int size) {
            return (new AllNotificationResponse[size]);
        }

    }
            ;

    protected AllNotificationResponse(Parcel in) {
        in.readList(this.notifications, (java.lang.Object.class.getClassLoader()));
        this.notificationCounter = ((int) in.readValue((int.class.getClassLoader())));
        this.total = ((int) in.readValue((int.class.getClassLoader())));
    }

    public AllNotificationResponse() {
    }

    public List<NotificationInternal> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationInternal> notifications) {
        this.notifications = notifications;
    }

    public AllNotificationResponse withNotifications(List<NotificationInternal> notifications) {
        this.notifications = notifications;
        return this;
    }

    public int getNotificationCounter() {
        return notificationCounter;
    }

    public void setNotificationCounter(int notificationCounter) {
        this.notificationCounter = notificationCounter;
    }

    public AllNotificationResponse withNotificationCounter(int notificationCounter) {
        this.notificationCounter = notificationCounter;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public AllNotificationResponse withTotal(int total) {
        this.total = total;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(notifications);
        dest.writeValue(notificationCounter);
        dest.writeValue(total);
    }

    public int describeContents() {
        return 0;
    }

}