package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Plan implements Parcelable {

	@SerializedName("plan_type")
	private String planType;

	@SerializedName("policy_id")
	private int policyId;

	@SerializedName("currency_symbol")
	private String currencySymbol;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("description")
	private List<String> description;

	@SerializedName("currency_code")
	private String currencyCode;

	@SerializedName("duration")
	private int duration;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("stripe_plan_id")
	private String stripePlanId;

	@SerializedName("price")
	private int price;

	@SerializedName("organization_id")
	private int organizationId;

	@SerializedName("name")
	private String name;

	@SerializedName("stripe_plan_name")
	private String stripePlanName;

	@SerializedName("id")
	private int id;

	@SerializedName("category")
	private String category;

	@SerializedName("status")
	private boolean status;

	protected Plan(Parcel in) {
		planType = in.readString();
		policyId = in.readInt();
		currencySymbol = in.readString();
		createdAt = in.readString();
		description = in.createStringArrayList();
		currencyCode = in.readString();
		duration = in.readInt();
		updatedAt = in.readString();
		stripePlanId = in.readString();
		price = in.readInt();
		organizationId = in.readInt();
		name = in.readString();
		stripePlanName = in.readString();
		id = in.readInt();
		category = in.readString();
		status = in.readByte() != 0;
	}

	public static final Creator<Plan> CREATOR = new Creator<Plan>() {
		@Override
		public Plan createFromParcel(Parcel in) {
			return new Plan(in);
		}

		@Override
		public Plan[] newArray(int size) {
			return new Plan[size];
		}
	};

	public void setPlanType(String planType){
		this.planType = planType;
	}

	public String getPlanType(){
		return planType;
	}

	public void setPolicyId(int policyId){
		this.policyId = policyId;
	}

	public int getPolicyId(){
		return policyId;
	}

	public void setCurrencySymbol(String currencySymbol){
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencySymbol(){
		return currencySymbol;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDescription(List<String> description){
		this.description = description;
	}

	public List<String> getDescription(){
		return description;
	}

	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setStripePlanId(String stripePlanId){
		this.stripePlanId = stripePlanId;
	}

	public String getStripePlanId(){
		return stripePlanId;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
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

	public void setStripePlanName(String stripePlanName){
		this.stripePlanName = stripePlanName;
	}

	public String getStripePlanName(){
		return stripePlanName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Plan{" + 
			"plan_type = '" + planType + '\'' + 
			",policy_id = '" + policyId + '\'' + 
			",currency_symbol = '" + currencySymbol + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",description = '" + description + '\'' + 
			",currency_code = '" + currencyCode + '\'' + 
			",duration = '" + duration + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",stripe_plan_id = '" + stripePlanId + '\'' + 
			",price = '" + price + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",name = '" + name + '\'' + 
			",stripe_plan_name = '" + stripePlanName + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(planType);
		dest.writeInt(policyId);
		dest.writeString(currencySymbol);
		dest.writeString(createdAt);
		dest.writeStringList(description);
		dest.writeString(currencyCode);
		dest.writeInt(duration);
		dest.writeString(updatedAt);
		dest.writeString(stripePlanId);
		dest.writeInt(price);
		dest.writeInt(organizationId);
		dest.writeString(name);
		dest.writeString(stripePlanName);
		dest.writeInt(id);
		dest.writeString(category);
		dest.writeByte((byte) (status ? 1 : 0));
	}
}