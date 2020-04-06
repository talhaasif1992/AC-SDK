package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NotificationCounter implements Parcelable {

	@SerializedName("user_role_id")
	private int userRoleId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private Object userId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("offline_counter")
	private int offlineCounter;

	@SerializedName("id")
	private int id;

	protected NotificationCounter(Parcel in) {
		userRoleId = in.readInt();
		updatedAt = in.readString();
		createdAt = in.readString();
		offlineCounter = in.readInt();
		id = in.readInt();
	}

	public static final Creator<NotificationCounter> CREATOR = new Creator<NotificationCounter>() {
		@Override
		public NotificationCounter createFromParcel(Parcel in) {
			return new NotificationCounter(in);
		}

		@Override
		public NotificationCounter[] newArray(int size) {
			return new NotificationCounter[size];
		}
	};

	public void setUserRoleId(int userRoleId){
		this.userRoleId = userRoleId;
	}

	public int getUserRoleId(){
		return userRoleId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(Object userId){
		this.userId = userId;
	}

	public Object getUserId(){
		return userId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setOfflineCounter(int offlineCounter){
		this.offlineCounter = offlineCounter;
	}

	public int getOfflineCounter(){
		return offlineCounter;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"NotificationCounter{" + 
			"user_role_id = '" + userRoleId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",offline_counter = '" + offlineCounter + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(userRoleId);
		parcel.writeString(updatedAt);
		parcel.writeString(createdAt);
		parcel.writeInt(offlineCounter);
		parcel.writeInt(id);
	}
}