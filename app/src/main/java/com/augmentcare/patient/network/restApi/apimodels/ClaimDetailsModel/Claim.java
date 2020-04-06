package com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Claim implements Parcelable{

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
    public final static Parcelable.Creator<Claim> CREATOR = new Creator<Claim>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Claim createFromParcel(Parcel in) {
            return new Claim(in);
        }

        public Claim[] newArray(int size) {
            return (new Claim[size]);
        }

    };

    protected Claim(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.claimType = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionType = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.consultationWith = ((String) in.readValue((String.class.getClassLoader())));
        this.speciality = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionFor = ((String) in.readValue((String.class.getClassLoader())));
        this.pharmacy = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lab = ((Object) in.readValue((Object.class.getClassLoader())));
        this.prescribedBy = ((Object) in.readValue((Object.class.getClassLoader())));
        this.other = ((Object) in.readValue((Object.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.relationWithPrimary = ((Object) in.readValue((Object.class.getClassLoader())));
        this.finalAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.organizationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.claimUid = ((String) in.readValue((String.class.getClassLoader())));
        this.notes = ((Object) in.readValue((Object.class.getClassLoader())));
        this.balanceBeforeTransaction = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdById = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userPolicyId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.availableBalance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.messageRead = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.dependent = ((Dependent) in.readValue((Dependent.class.getClassLoader())));
    }

    public Claim() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Claim withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public Claim withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Claim withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Claim withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getConsultationWith() {
        return consultationWith;
    }

    public void setConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
    }

    public Claim withConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Claim withSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Claim withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }

    public Claim withTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
        return this;
    }

    public Object getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Object pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Claim withPharmacy(Object pharmacy) {
        this.pharmacy = pharmacy;
        return this;
    }

    public Object getLab() {
        return lab;
    }

    public void setLab(Object lab) {
        this.lab = lab;
    }

    public Claim withLab(Object lab) {
        this.lab = lab;
        return this;
    }

    public Object getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(Object prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public Claim withPrescribedBy(Object prescribedBy) {
        this.prescribedBy = prescribedBy;
        return this;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public Claim withOther(Object other) {
        this.other = other;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Claim withDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Claim withTime(String time) {
        this.time = time;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Claim withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Claim withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Claim withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Claim withStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getDependentId() {
        return dependentId;
    }

    public void setDependentId(Integer dependentId) {
        this.dependentId = dependentId;
    }

    public Claim withDependentId(Integer dependentId) {
        this.dependentId = dependentId;
        return this;
    }

    public Object getRelationWithPrimary() {
        return relationWithPrimary;
    }

    public void setRelationWithPrimary(Object relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
    }

    public Claim withRelationWithPrimary(Object relationWithPrimary) {
        this.relationWithPrimary = relationWithPrimary;
        return this;
    }

    public Integer getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Claim withFinalAmount(Integer finalAmount) {
        this.finalAmount = finalAmount;
        return this;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Claim withOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getClaimUid() {
        return claimUid;
    }

    public void setClaimUid(String claimUid) {
        this.claimUid = claimUid;
    }

    public Claim withClaimUid(String claimUid) {
        this.claimUid = claimUid;
        return this;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Claim withNotes(Object notes) {
        this.notes = notes;
        return this;
    }

    public Integer getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(Integer balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public Claim withBalanceBeforeTransaction(Integer balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        return this;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public Claim withCreatedById(Integer createdById) {
        this.createdById = createdById;
        return this;
    }

    public Integer getUserPolicyId() {
        return userPolicyId;
    }

    public void setUserPolicyId(Integer userPolicyId) {
        this.userPolicyId = userPolicyId;
    }

    public Claim withUserPolicyId(Integer userPolicyId) {
        this.userPolicyId = userPolicyId;
        return this;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Claim withAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public Boolean getMessageRead() {
        return messageRead;
    }

    public void setMessageRead(Boolean messageRead) {
        this.messageRead = messageRead;
    }

    public Claim withMessageRead(Boolean messageRead) {
        this.messageRead = messageRead;
        return this;
    }

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public Claim withDependent(Dependent dependent) {
        this.dependent = dependent;
        return this;
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