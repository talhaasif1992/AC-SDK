
package com.augmentcare.patient.model.createClaimsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Claim {

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
    private Object pharmacy;
    @SerializedName("lab")
    @Expose
    private Object lab;
    @SerializedName("prescribed_by")
    @Expose
    private Object prescribedBy;
    @SerializedName("other")
    @Expose
    private Object other;
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
    private Object relationWithPrimary;
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
    private Object notes;
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
    private Dependent dependent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsultationWith() {
        return consultationWith;
    }

    public void setConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }

    public Object getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Object pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Object getLab() {
        return lab;
    }

    public void setLab(Object lab) {
        this.lab = lab;
    }

    public Object getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(Object prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDependentId() {
        return dependentId;
    }

    public void setDependentId(Integer dependentId) {
        this.dependentId = dependentId;
    }

    public Object getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(Object relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getClaimUid() {
        return claimUid;
    }

    public void setClaimUid(String claimUid) {
        this.claimUid = claimUid;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Integer getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(Integer balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public Integer getUserPolicyId() {
        return userPolicyId;
    }

    public void setUserPolicyId(Integer userPolicyId) {
        this.userPolicyId = userPolicyId;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Boolean getMessageRead() {
        return messageRead;
    }

    public void setMessageRead(Boolean messageRead) {
        this.messageRead = messageRead;
    }

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

}
