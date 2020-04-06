package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlanDetails implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("plan_id")
    @Expose
    private int planId;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("starting_date")
    @Expose
    private String startingDate;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("is_active")
    @Expose
    private boolean isActive;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("subscription_id")
    @Expose
    private String subscriptionId;
    @SerializedName("stripe_plan_id")
    @Expose
    private String stripePlanId;
    @SerializedName("current_period_start")
    @Expose
    private String currentPeriodStart;
    @SerializedName("current_period_end")
    @Expose
    private String currentPeriodEnd;
    @SerializedName("organization_id")
    @Expose
    private int organizationId;
    @SerializedName("corporate_account_id")
    @Expose
    private int corporateAccountId;
    @SerializedName("last_charged_at")
    @Expose
    private String lastChargedAt;
    @SerializedName("stripe_webhook")
    @Expose
    private String stripeWebhook;
    @SerializedName("cancelled_at")
    @Expose
    private String cancelledAt;
    public final static Parcelable.Creator<PlanDetails> CREATOR = new Creator<PlanDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PlanDetails createFromParcel(Parcel in) {
            return new PlanDetails(in);
        }

        public PlanDetails[] newArray(int size) {
            return (new PlanDetails[size]);
        }

    };

    protected PlanDetails(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.userId = ((String) in.readValue((int.class.getClassLoader())));
        this.planId = ((int) in.readValue((int.class.getClassLoader())));
        this.price = ((int) in.readValue((int.class.getClassLoader())));
        this.startingDate = ((String) in.readValue((String.class.getClassLoader())));
        this.expiryDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.subscriptionId = ((String) in.readValue((String.class.getClassLoader())));
        this.stripePlanId = ((String) in.readValue((String.class.getClassLoader())));
        this.currentPeriodStart = ((String) in.readValue((String.class.getClassLoader())));
        this.currentPeriodEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationId = ((int) in.readValue((int.class.getClassLoader())));
        this.corporateAccountId = ((int) in.readValue((int.class.getClassLoader())));
        this.lastChargedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.stripeWebhook = ((String) in.readValue((String.class.getClassLoader())));
        this.cancelledAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public PlanDetails() {
    }

    /**
     * @param stripePlanId
     * @param currentPeriodStart
     * @param currentPeriodEnd
     * @param cancelledAt
     * @param isActive
     * @param stripeWebhook
     * @param userId
     * @param expiryDate
     * @param organizationId
     * @param lastChargedAt
     * @param createdAt
     * @param price
     * @param planId
     * @param id
     * @param subscriptionId
     * @param startingDate
     * @param corporateAccountId
     * @param updatedAt
     */
    public PlanDetails(int id, String userId, int planId, int price, String startingDate, String expiryDate, boolean isActive, String createdAt, String updatedAt, String subscriptionId, String stripePlanId, String currentPeriodStart, String currentPeriodEnd, int organizationId, int corporateAccountId, String lastChargedAt, String stripeWebhook, String cancelledAt) {
        super();
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.price = price;
        this.startingDate = startingDate;
        this.expiryDate = expiryDate;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.subscriptionId = subscriptionId;
        this.stripePlanId = stripePlanId;
        this.currentPeriodStart = currentPeriodStart;
        this.currentPeriodEnd = currentPeriodEnd;
        this.organizationId = organizationId;
        this.corporateAccountId = corporateAccountId;
        this.lastChargedAt = lastChargedAt;
        this.stripeWebhook = stripeWebhook;
        this.cancelledAt = cancelledAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlanDetails withId(int id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PlanDetails withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public PlanDetails withPlanId(int planId) {
        this.planId = planId;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PlanDetails withPrice(int price) {
        this.price = price;
        return this;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public PlanDetails withStartingDate(String startingDate) {
        this.startingDate = startingDate;
        return this;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public PlanDetails withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public PlanDetails withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public PlanDetails withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PlanDetails withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public PlanDetails withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public String getStripePlanId() {
        return stripePlanId;
    }

    public void setStripePlanId(String stripePlanId) {
        this.stripePlanId = stripePlanId;
    }

    public PlanDetails withStripePlanId(String stripePlanId) {
        this.stripePlanId = stripePlanId;
        return this;
    }

    public String getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    public void setCurrentPeriodStart(String currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
    }

    public PlanDetails withCurrentPeriodStart(String currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
        return this;
    }

    public String getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    public void setCurrentPeriodEnd(String currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
    }

    public PlanDetails withCurrentPeriodEnd(String currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
        return this;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public PlanDetails withOrganizationId(int organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public int getCorporateAccountId() {
        return corporateAccountId;
    }

    public void setCorporateAccountId(int corporateAccountId) {
        this.corporateAccountId = corporateAccountId;
    }

    public PlanDetails withCorporateAccountId(int corporateAccountId) {
        this.corporateAccountId = corporateAccountId;
        return this;
    }

    public String getLastChargedAt() {
        return lastChargedAt;
    }

    public void setLastChargedAt(String lastChargedAt) {
        this.lastChargedAt = lastChargedAt;
    }

    public PlanDetails withLastChargedAt(String lastChargedAt) {
        this.lastChargedAt = lastChargedAt;
        return this;
    }

    public String getStripeWebhook() {
        return stripeWebhook;
    }

    public void setStripeWebhook(String stripeWebhook) {
        this.stripeWebhook = stripeWebhook;
    }

    public PlanDetails withStripeWebhook(String stripeWebhook) {
        this.stripeWebhook = stripeWebhook;
        return this;
    }


    public String getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(String cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public PlanDetails withCancelledAt(String cancelledAt) {
        this.cancelledAt = cancelledAt;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("userId", userId).append("planId", planId).append("price", price).append("startingDate", startingDate).append("expiryDate", expiryDate).append("isActive", isActive).append("createdAt", createdAt).append("updatedAt", updatedAt).append("subscriptionId", subscriptionId).append("stripePlanId", stripePlanId).append("currentPeriodStart", currentPeriodStart).append("currentPeriodEnd", currentPeriodEnd).append("organizationId", organizationId).append("corporateAccountId", corporateAccountId).append("lastChargedAt", lastChargedAt).append("stripeWebhook", stripeWebhook).append("cancelledAt", cancelledAt).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userId);
        dest.writeValue(planId);
        dest.writeValue(price);
        dest.writeValue(startingDate);
        dest.writeValue(expiryDate);
        dest.writeValue(isActive);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(subscriptionId);
        dest.writeValue(stripePlanId);
        dest.writeValue(currentPeriodStart);
        dest.writeValue(currentPeriodEnd);
        dest.writeValue(organizationId);
        dest.writeValue(corporateAccountId);
        dest.writeValue(lastChargedAt);
        dest.writeValue(stripeWebhook);
        dest.writeValue(cancelledAt);
    }

    public int describeContents() {
        return 0;
    }

}