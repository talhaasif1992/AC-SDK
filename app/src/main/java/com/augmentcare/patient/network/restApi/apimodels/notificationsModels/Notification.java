package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
public class Notification implements Parcelable {

	@SerializedName("notification_type")
	private String notificationType;

	@SerializedName("user_role_id")
	private int userRoleId;

	@SerializedName("notification_object")
	private NotificationObject notificationObject;

	@SerializedName("notify_text")
	private String notifyText;

	@SerializedName("read")
	private boolean read;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private Object userId;

	@SerializedName("model_type")
	private Object modelType;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("model_id")
	private int modelId;

	protected Notification(Parcel in) {
		notificationType = in.readString();
		userRoleId = in.readInt();
		notificationObject = in.readParcelable(NotificationObject.class.getClassLoader());
		notifyText = in.readString();
		read = in.readByte() != 0;
		updatedAt = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		modelId = in.readInt();
	}

	public static final Creator<Notification> CREATOR = new Creator<Notification>() {
		@Override
		public Notification createFromParcel(Parcel in) {
			return new Notification(in);
		}

		@Override
		public Notification[] newArray(int size) {
			return new Notification[size];
		}
	};

	public void setNotificationType(String notificationType){
		this.notificationType = notificationType;
	}

	public String getNotificationType(){
		return notificationType;
	}

	public void setUserRoleId(int userRoleId){
		this.userRoleId = userRoleId;
	}

	public int getUserRoleId(){
		return userRoleId;
	}

	public void setNotificationObject(NotificationObject notificationObject){
		this.notificationObject = notificationObject;
	}

	public NotificationObject getNotificationObject(){
		return notificationObject;
	}

	public void setNotifyText(String notifyText){
		this.notifyText = notifyText;
	}

	public String getNotifyText(){
		return notifyText;
	}

	public void setRead(boolean read){
		this.read = read;
	}

	public boolean isRead(){
		return read;
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

	public void setModelType(Object modelType){
		this.modelType = modelType;
	}

	public Object getModelType(){
		return modelType;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setModelId(int modelId){
		this.modelId = modelId;
	}

	public int getModelId(){
		return modelId;
	}

	@Override
 	public String toString(){
		return 
			"Notification{" + 
			"notification_type = '" + notificationType + '\'' + 
			",user_role_id = '" + userRoleId + '\'' + 
			",notification_object = '" + notificationObject + '\'' + 
			",notify_text = '" + notifyText + '\'' + 
			",read = '" + read + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",model_type = '" + modelType + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",model_id = '" + modelId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(notificationType);
		parcel.writeInt(userRoleId);
		parcel.writeParcelable(notificationObject, i);
		parcel.writeString(notifyText);
		parcel.writeByte((byte) (read ? 1 : 0));
		parcel.writeString(updatedAt);
		parcel.writeString(createdAt);
		parcel.writeInt(id);
		parcel.writeInt(modelId);
	}
}