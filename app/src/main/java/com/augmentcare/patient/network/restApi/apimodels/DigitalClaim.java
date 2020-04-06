package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DigitalClaim implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("claim_type")
    @Expose
    private String claimType;
    @SerializedName("transaction_type")
    @Expose
    private String transactionType;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("consultation_with")
    @Expose
    private String consultationWith;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("transaction_for")
    @Expose
    private String transactionFor;
    @SerializedName("pharmacy")
    @Expose
    private String pharmacy;
    @SerializedName("lab")
    @Expose
    private String lab;
    @SerializedName("prescribed_by")
    @Expose
    private String prescribedBy;
    @SerializedName("other")
    @Expose
    private String other;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("dependent_id")
    @Expose
    private Integer dependentId;
    @SerializedName("relation_with_primary")
    @Expose
    private String relationWithPrimary;
    @SerializedName("final_amount")
    @Expose
    private Integer finalAmount;
    @SerializedName("organization_id")
    @Expose
    private Integer organizationId;
    @SerializedName("claim_uid")
    @Expose
    private String claimUid;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("balance_before_transaction")
    @Expose
    private Integer balanceBeforeTransaction;
    @SerializedName("created_by_id")
    @Expose
    private Integer createdById;
    @SerializedName("user_policy_id")
    @Expose
    private Integer userPolicyId;
    @SerializedName("available_balance")
    @Expose
    private Integer availableBalance;
    @SerializedName("message_read")
    @Expose
    private Boolean messageRead;
    @SerializedName("dependent")
    @Expose
    private UserClaims.Dependent dependent;
    public final static Parcelable.Creator<DigitalClaim> CREATOR = new Creator<DigitalClaim>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DigitalClaim createFromParcel(Parcel in) {
            return new DigitalClaim(in);
        }

        public DigitalClaim[] newArray(int size) {
            return (new DigitalClaim[size]);
        }

    };

    protected DigitalClaim(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.claimType = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionType = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.consultationWith = ((String) in.readValue((String.class.getClassLoader())));
        this.speciality = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionFor = ((String) in.readValue((String.class.getClassLoader())));
        this.pharmacy = ((String) in.readValue((String.class.getClassLoader())));
        this.lab = ((String) in.readValue((String.class.getClassLoader())));
        this.prescribedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.other = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.relationWithPrimary = ((String) in.readValue((String.class.getClassLoader())));
        this.finalAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.organizationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.claimUid = ((String) in.readValue((String.class.getClassLoader())));
        this.notes = ((String) in.readValue((String.class.getClassLoader())));
        this.balanceBeforeTransaction = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdById = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userPolicyId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.availableBalance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.messageRead = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.dependent = ((UserClaims.Dependent) in.readValue((UserClaims.Dependent.class.getClassLoader())));
    }

    public DigitalClaim() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DigitalClaim withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public DigitalClaim withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public DigitalClaim withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DigitalClaim withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getConsultationWith() {
        return consultationWith;
    }

    public void setConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
    }

    public DigitalClaim withConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public DigitalClaim withSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DigitalClaim withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }

    public DigitalClaim withTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
        return this;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public DigitalClaim withPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
        return this;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public DigitalClaim withLab(String lab) {
        this.lab = lab;
        return this;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public DigitalClaim withPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
        return this;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public DigitalClaim withOther(String other) {
        this.other = other;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DigitalClaim withDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DigitalClaim withTime(String time) {
        this.time = time;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DigitalClaim withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DigitalClaim withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public DigitalClaim withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DigitalClaim withStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getDependentId() {
        return dependentId;
    }

    public void setDependentId(Integer dependentId) {
        this.dependentId = dependentId;
    }

    public DigitalClaim withDependentId(Integer dependentId) {
        this.dependentId = dependentId;
        return this;
    }

    public String getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public DigitalClaim withRelationWithPrimary(String relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }

    public DigitalClaim withFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
        return this;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public DigitalClaim withOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getClaimUid() {
        return claimUid;
    }

    public void setClaimUid(String claimUid) {
        this.claimUid = claimUid;
    }

    public DigitalClaim withClaimUid(String claimUid) {
        this.claimUid = claimUid;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DigitalClaim withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Integer getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(Integer balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public DigitalClaim withBalanceBeforeTransaction(Integer balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        return this;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public DigitalClaim withCreatedById(Integer createdById) {
        this.createdById = createdById;
        return this;
    }

    public Integer getUserPolicyId() {
        return userPolicyId;
    }

    public void setUserPolicyId(Integer userPolicyId) {
        this.userPolicyId = userPolicyId;
    }

    public DigitalClaim withUserPolicyId(Integer userPolicyId) {
        this.userPolicyId = userPolicyId;
        return this;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public DigitalClaim withAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public Boolean getMessageRead() {
        return messageRead;
    }

    public void setMessageRead(Boolean messageRead) {
        this.messageRead = messageRead;
    }

    public DigitalClaim withMessageRead(Boolean messageRead) {
        this.messageRead = messageRead;
        return this;
    }

    public UserClaims.Dependent getDependent() {
        return dependent;
    }

    public void setDependent(UserClaims.Dependent dependent) {
        this.dependent = dependent;
    }

    public DigitalClaim withDependent(UserClaims.Dependent dependent) {
        this.dependent = dependent;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("claimType", claimType).append("transactionType", transactionType).append("userId", userId).append("consultationWith", consultationWith).append("speciality", speciality).append("location", location).append("transactionFor", transactionFor).append("pharmacy", pharmacy).append("lab", lab).append("prescribedBy", prescribedBy).append("other", other).append("date", date).append("time", time).append("createdAt", createdAt).append("updatedAt", updatedAt).append("amount", amount).append("status", status).append("dependentId", dependentId).append("relationWithPrimary", relationWithPrimary).append("finalAmount", finalAmount).append("organizationId", organizationId).append("claimUid", claimUid).append("notes", notes).append("balanceBeforeTransaction", balanceBeforeTransaction).append("createdById", createdById).append("userPolicyId", userPolicyId).append("availableBalance", availableBalance).append("messageRead", messageRead).append("dependent", dependent).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(claimType);
        dest.writeValue(transactionType);
        dest.writeValue(userId);
        dest.writeValue(consultationWith);
        dest.writeValue(speciality);
        dest.writeValue(location);
        dest.writeValue(transactionFor);
        dest.writeValue(pharmacy);
        dest.writeValue(lab);
        dest.writeValue(prescribedBy);
        dest.writeValue(other);
        dest.writeValue(date);
        dest.writeValue(time);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(amount);
        dest.writeValue(status);
        dest.writeValue(dependentId);
        dest.writeValue(relationWithPrimary);
        dest.writeValue(finalAmount);
        dest.writeValue(organizationId);
        dest.writeValue(claimUid);
        dest.writeValue(notes);
        dest.writeValue(balanceBeforeTransaction);
        dest.writeValue(createdById);
        dest.writeValue(userPolicyId);
        dest.writeValue(availableBalance);
        dest.writeValue(messageRead);
        dest.writeValue(dependent);
    }

    public int describeContents() {
        return 0;
    }

}