package com.augmentcare.patient.RemoteMessage;

import android.os.Parcel;
import android.os.Parcelable;

import com.blankj.utilcode.util.StringUtils;
import com.google.gson.annotations.SerializedName;

public class RemoteNotificationResponseModel implements Parcelable {

	@SerializedName(value = "notification_type")
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

	@SerializedName("title")
	private String title;

	@SerializedName("message")
	private String message;

	@SerializedName("notification_time")
	private String notification_time;

	@SerializedName("event_type")
	private String event_type;

	public String getTitle() {
		return StringUtils.null2Length0(title);
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getMessage() {
		return StringUtils.null2Length0(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getNotification_time() {
		return StringUtils.null2Length0(notification_time);
	}

	public void setNotification_time(String notification_time) {
		this.notification_time = notification_time;
	}



	public String getEvent_type() {
		return StringUtils.null2Length0(event_type);
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public void setNotificationType(String notificationType){
		this.notificationType = notificationType;
	}

	public String getNotificationType(){
		return StringUtils.null2Length0(notificationType);
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
		return StringUtils.null2Length0(notifyText);
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
		return StringUtils.null2Length0(updatedAt);
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
		return StringUtils.null2Length0(createdAt);
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
				"RemoteNotificationResponseModel{" +
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

	protected RemoteNotificationResponseModel(Parcel in) {
		notificationType = in.readString();
		userRoleId = in.readInt();
		notificationObject = (NotificationObject) in.readValue(NotificationObject.class.getClassLoader());
		notifyText = in.readString();
		read = in.readByte() != 0x00;
		updatedAt = in.readString();
		userId = in.readValue(Object.class.getClassLoader());
		modelType = in.readValue(Object.class.getClassLoader());
		createdAt = in.readString();
		id = in.readInt();
		modelId = in.readInt();
		title = in.readString();
		message = in.readString();
		event_type = in.readString();
		notification_time = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(notificationType);
		dest.writeInt(userRoleId);
		dest.writeValue(notificationObject);
		dest.writeString(notifyText);
		dest.writeByte((byte) (read ? 0x01 : 0x00));
		dest.writeString(updatedAt);
		dest.writeValue(userId);
		dest.writeValue(modelType);
		dest.writeString(createdAt);
		dest.writeInt(id);
		dest.writeInt(modelId);
		dest.writeString(title);
		dest.writeString(message);
		dest.writeString(notification_time);
		dest.writeString(event_type);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<RemoteNotificationResponseModel> CREATOR = new Parcelable.Creator<RemoteNotificationResponseModel>() {
		@Override
		public RemoteNotificationResponseModel createFromParcel(Parcel in) {
			return new RemoteNotificationResponseModel(in);
		}

		@Override
		public RemoteNotificationResponseModel[] newArray(int size) {
			return new RemoteNotificationResponseModel[size];
		}
	};
}