package com.augmentcare.patient.RemoteMessage;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NotificationObject implements Parcelable {

	@SerializedName("start_time")
	private String startTime;

	@SerializedName("location_name")
	private String locationName;

	@SerializedName("slot_id")
	private int slotId;

	@SerializedName("model_type")
	private String modelType;

	@SerializedName("slot_type")
	private boolean slotType;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("day")
	private String day;

	@SerializedName("message")
	private String message;

	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	@SerializedName("id")
	private int id;

	@SerializedName("versionCode")
	private int versionCode;

	@SerializedName("enforced")
	private boolean enforced;

	public boolean isEnforced() {
		return enforced;
	}

	public void setEnforced(boolean enforced) {
		this.enforced = enforced;
	}

	@SerializedName("caller_info")
	private String caller_info;

	public String getCaller_info() {
		return caller_info;
	}

	public void setCaller_info(String caller_info) {
		this.caller_info = caller_info;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setLocationName(String locationName){
		this.locationName = locationName;
	}

	public String getLocationName(){
		return locationName;
	}

	public void setSlotId(int slotId){
		this.slotId = slotId;
	}

	public int getSlotId(){
		return slotId;
	}

	public void setModelType(String modelType){
		this.modelType = modelType;
	}

	public String getModelType(){
		return modelType;
	}

	public void setSlotType(boolean slotType){
		this.slotType = slotType;
	}

	public boolean isSlotType(){
		return slotType;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDay(String day){
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay(){
		return day;
	}

	@Override
	public String toString(){
		return
				"NotificationObject{" +
						"start_time = '" + startTime + '\'' +
						",location_name = '" + locationName + '\'' +
						",slot_id = '" + slotId + '\'' +
						",model_type = '" + modelType + '\'' +
						",slot_type = '" + slotType + '\'' +
						",last_name = '" + lastName + '\'' +
						",first_name = '" + firstName + '\'' +
						",day = '" + day + '\'' +
						"}";
	}

	protected NotificationObject(Parcel in) {
		startTime = in.readString();
		locationName = in.readString();
		slotId = in.readInt();
		modelType = in.readString();
		slotType = in.readByte() != 0x00;
		lastName = in.readString();
		firstName = in.readString();
		day = in.readString();
		message = in.readString();
		caller_info = in.readString();
		id = in.readInt();
		versionCode = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(startTime);
		dest.writeString(locationName);
		dest.writeInt(slotId);
		dest.writeString(modelType);
		dest.writeByte((byte) (slotType ? 0x01 : 0x00));
		dest.writeString(lastName);
		dest.writeString(firstName);
		dest.writeString(day);
		dest.writeString(message);
		dest.writeInt(id);
		dest.writeString(caller_info);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<NotificationObject> CREATOR = new Parcelable.Creator<NotificationObject>() {
		@Override
		public NotificationObject createFromParcel(Parcel in) {
			return new NotificationObject(in);
		}

		@Override
		public NotificationObject[] newArray(int size) {
			return new NotificationObject[size];
		}
	};
}