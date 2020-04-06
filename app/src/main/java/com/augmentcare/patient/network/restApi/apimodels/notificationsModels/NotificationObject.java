package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class NotificationObject implements Parcelable {

	@SerializedName("claim_uid")
	private String claimUid;

	@SerializedName("amount")
	private int amount;

	@SerializedName("transaction_for")
	private String transactionFor;

	@SerializedName("employee_id")
	private int employeeId;

	@SerializedName("organization_id")
	private int organizationId;

	@SerializedName("name")
	private String name;

	@SerializedName("model_type")
	private String modelType;

	@SerializedName("claim_type")
	private String claimType;

	@SerializedName("type")
	private String type;

	@SerializedName("message")
	private String message;

	@SerializedName("start_time")
	private String startTime;

	@SerializedName("location_name")
	private String locationName;

	@SerializedName("slot_id")
	private int slotId;

	@SerializedName("slot_type")
	private boolean slotType;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("day")
	private String day;

	protected NotificationObject(Parcel in) {
		claimUid = in.readString();
		amount = in.readInt();
		transactionFor = in.readString();
		employeeId = in.readInt();
		organizationId = in.readInt();
		name = in.readString();
		modelType = in.readString();
		claimType = in.readString();
		type = in.readString();
		message = in.readString();
		startTime = in.readString();
		locationName = in.readString();
		slotId = in.readInt();
		slotType = in.readByte() != 0;
		lastName = in.readString();
		firstName = in.readString();
		day = in.readString();
	}

	public static final Creator<NotificationObject> CREATOR = new Creator<NotificationObject>() {
		@Override
		public NotificationObject createFromParcel(Parcel in) {
			return new NotificationObject(in);
		}

		@Override
		public NotificationObject[] newArray(int size) {
			return new NotificationObject[size];
		}
	};

	public void setClaimUid(String claimUid){
		this.claimUid = claimUid;
	}

	public String getClaimUid(){
		return claimUid;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setTransactionFor(String transactionFor){
		this.transactionFor = transactionFor;
	}

	public String getTransactionFor(){
		return transactionFor;
	}

	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}

	public int getEmployeeId(){
		return employeeId;
	}

	public void setOrganizationId(int organizationId){
		this.organizationId = organizationId;
	}

	public int getOrganizationId(){
		return organizationId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setModelType(String modelType){
		this.modelType = modelType;
	}

	public String getModelType(){
		return modelType;
	}

	public void setClaimType(String claimType){
		this.claimType = claimType;
	}

	public String getClaimType(){
		return claimType;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
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

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"NotificationObject{" + 
			"claim_uid = '" + claimUid + '\'' + 
			",amount = '" + amount + '\'' + 
			",transaction_for = '" + transactionFor + '\'' + 
			",employee_id = '" + employeeId + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",name = '" + name + '\'' + 
			",model_type = '" + modelType + '\'' + 
			",claim_type = '" + claimType + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",start_time = '" + startTime + '\'' + 
			",location_name = '" + locationName + '\'' + 
			",slot_id = '" + slotId + '\'' + 
			",slot_type = '" + slotType + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(claimUid);
		parcel.writeInt(amount);
		parcel.writeString(transactionFor);
		parcel.writeInt(employeeId);
		parcel.writeInt(organizationId);
		parcel.writeString(name);
		parcel.writeString(modelType);
		parcel.writeString(claimType);
		parcel.writeString(type);
		parcel.writeString(message);
		parcel.writeString(startTime);
		parcel.writeString(locationName);
		parcel.writeInt(slotId);
		parcel.writeByte((byte) (slotType ? 1 : 0));
		parcel.writeString(lastName);
		parcel.writeString(firstName);
		parcel.writeString(day);
	}
}