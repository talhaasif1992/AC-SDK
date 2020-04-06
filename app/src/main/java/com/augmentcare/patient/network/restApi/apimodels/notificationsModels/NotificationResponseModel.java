package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NotificationResponseModel implements Parcelable {

	@SerializedName("total")
	private int total;

	@SerializedName("notification_counter")
	private NotificationCounter notificationCounter;

	@SerializedName("notifications")
	private List<NotificationsItem> notifications;

	protected NotificationResponseModel(Parcel in) {
		total = in.readInt();
		notifications = in.createTypedArrayList(NotificationsItem.CREATOR);
	}

	public static final Creator<NotificationResponseModel> CREATOR = new Creator<NotificationResponseModel>() {
		@Override
		public NotificationResponseModel createFromParcel(Parcel in) {
			return new NotificationResponseModel(in);
		}

		@Override
		public NotificationResponseModel[] newArray(int size) {
			return new NotificationResponseModel[size];
		}
	};

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setNotificationCounter(NotificationCounter notificationCounter){
		this.notificationCounter = notificationCounter;
	}

	public NotificationCounter getNotificationCounter(){
		return notificationCounter;
	}

	public void setNotifications(List<NotificationsItem> notifications){
		this.notifications = notifications;
	}

	public List<NotificationsItem> getNotifications(){
		return notifications;
	}

	@Override
 	public String toString(){
		return 
			"NotificationResponseModel{" + 
			"total = '" + total + '\'' + 
			",notification_counter = '" + notificationCounter + '\'' + 
			",notifications = '" + notifications + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(total);
		parcel.writeTypedList(notifications);
	}
}