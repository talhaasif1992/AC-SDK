package com.augmentcare.patient.network.restApi.apimodels.UserCurrentPlan;


import com.augmentcare.patient.network.restApi.apimodels.APlan;
import com.augmentcare.patient.network.restApi.apimodels.Plan;
import com.google.gson.annotations.SerializedName;

public class UserPlans{

	@SerializedName("cancelled_at")
	private String cancelledAt;

	@SerializedName("starting_date")
	private String startingDate;

	@SerializedName("is_active")
	private boolean isActive;

	@SerializedName("expiry_date")
	private String expiryDate;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("corporate_account_id")
	private Object corporateAccountId;

	@SerializedName("stripe_webhook")
	private Object stripeWebhook;

	@SerializedName("last_charged_at")
	private Object lastChargedAt;

	@SerializedName("current_period_end")
	private Object currentPeriodEnd;

	@SerializedName("subscription_id")
	private String subscriptionId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("stripe_plan_id")
	private String stripePlanId;

	@SerializedName("price")
	private int price;

	@SerializedName("organization_id")
	private Object organizationId;

	@SerializedName("id")
	private int id;

	@SerializedName("plan")
	private APlan plan;

	@SerializedName("plan_id")
	private int planId;

	@SerializedName("current_period_start")
	private Object currentPeriodStart;

	public void setCancelledAt(String cancelledAt){
		this.cancelledAt = cancelledAt;
	}

	public String getCancelledAt(){
		return cancelledAt;
	}

	public void setStartingDate(String startingDate){
		this.startingDate = startingDate;
	}

	public String getStartingDate(){
		return startingDate;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setExpiryDate(String expiryDate){
		this.expiryDate = expiryDate;
	}

	public String getExpiryDate(){
		return expiryDate;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setCorporateAccountId(Object corporateAccountId){
		this.corporateAccountId = corporateAccountId;
	}

	public Object getCorporateAccountId(){
		return corporateAccountId;
	}

	public void setStripeWebhook(Object stripeWebhook){
		this.stripeWebhook = stripeWebhook;
	}

	public Object getStripeWebhook(){
		return stripeWebhook;
	}

	public void setLastChargedAt(Object lastChargedAt){
		this.lastChargedAt = lastChargedAt;
	}

	public Object getLastChargedAt(){
		return lastChargedAt;
	}

	public void setCurrentPeriodEnd(Object currentPeriodEnd){
		this.currentPeriodEnd = currentPeriodEnd;
	}

	public Object getCurrentPeriodEnd(){
		return currentPeriodEnd;
	}

	public void setSubscriptionId(String subscriptionId){
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionId(){
		return subscriptionId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
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

	public void setOrganizationId(Object organizationId){
		this.organizationId = organizationId;
	}

	public Object getOrganizationId(){
		return organizationId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPlan(APlan plan){
		this.plan = plan;
	}

	public APlan getPlan(){
		return plan;
	}

	public void setPlanId(int planId){
		this.planId = planId;
	}

	public int getPlanId(){
		return planId;
	}

	public void setCurrentPeriodStart(Object currentPeriodStart){
		this.currentPeriodStart = currentPeriodStart;
	}

	public Object getCurrentPeriodStart(){
		return currentPeriodStart;
	}

	@Override
 	public String toString(){
		return 
			"UserPlans{" + 
			"cancelled_at = '" + cancelledAt + '\'' + 
			",starting_date = '" + startingDate + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",expiry_date = '" + expiryDate + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",corporate_account_id = '" + corporateAccountId + '\'' + 
			",stripe_webhook = '" + stripeWebhook + '\'' + 
			",last_charged_at = '" + lastChargedAt + '\'' + 
			",current_period_end = '" + currentPeriodEnd + '\'' + 
			",subscription_id = '" + subscriptionId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",stripe_plan_id = '" + stripePlanId + '\'' + 
			",price = '" + price + '\'' + 
			",organization_id = '" + organizationId + '\'' + 
			",id = '" + id + '\'' + 
			",plan = '" + plan + '\'' + 
			",plan_id = '" + planId + '\'' + 
			",current_period_start = '" + currentPeriodStart + '\'' + 
			"}";
		}
}