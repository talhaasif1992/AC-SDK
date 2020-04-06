package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NotificationsItem implements Parcelable {

	@SerializedName("notification")
	private Notification notification;

	@SerializedName("location")
	private Object location;

	@SerializedName("slot")
	private Slot slot;

	protected NotificationsItem(Parcel in) {
		slot = in.readParcelable(Slot.class.getClassLoader());
	}

	public static final Creator<NotificationsItem> CREATOR = new Creator<NotificationsItem>() {
		@Override
		public NotificationsItem createFromParcel(Parcel in) {
			return new NotificationsItem(in);
		}

		@Override
		public NotificationsItem[] newArray(int size) {
			return new NotificationsItem[size];
		}
	};

	public void setNotification(Notification notification){
		this.notification = notification;
	}

	public Notification getNotification(){
		return notification;
	}

	public void setLocation(Object location){
		this.location = location;
	}

	public Object getLocation(){
		return location;
	}

	public void setSlot(Slot slot){
		this.slot = slot;
	}

	public Slot getSlot(){
		return slot;
	}

	@Override
 	public String toString(){
		return 
			"NotificationsItem{" + 
			"notification = '" + notification + '\'' + 
			",location = '" + location + '\'' + 
			",slot = '" + slot + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeParcelable(slot, i);
	}
}