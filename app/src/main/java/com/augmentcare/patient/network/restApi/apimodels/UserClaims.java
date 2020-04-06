package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserClaims implements Parcelable {


    @Expose
    @SerializedName("data")
    private DataEntity data;



    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        @Expose
        @SerializedName("limit")
        private int limit;
        @Expose
        @SerializedName("available_balance")
        private int availableBalance;
        @Expose
        @SerializedName("reimbursements")
        private List<ReimbursementsEntity> reimbursements;
        @Expose
        @SerializedName("digital_claims")
        private List<ReimbursementsEntity> digitalClaims;


        @Expose
        @SerializedName("user_policy")
        private List<UserPolicyItem> userPolicy;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getAvailableBalance() {
            return availableBalance;
        }

        public void setAvailableBalance(int availableBalance) {
            this.availableBalance = availableBalance;
        }

        public List<ReimbursementsEntity> getReimbursements() {
            return reimbursements;
        }

        public void setReimbursements(List<ReimbursementsEntity> reimbursements) {
            this.reimbursements = reimbursements;
        }

        public List<ReimbursementsEntity> getDigitalClaims() {
            return digitalClaims;
        }

        public void setDigitalClaims(List<ReimbursementsEntity> digitalClaims) {
            this.digitalClaims = digitalClaims;
        }

        public void setUserPolicy(List<UserPolicyItem> userPolicy){
            this.userPolicy = userPolicy;
        }

        public List<UserPolicyItem> getUserPolicy(){
            return userPolicy;
        }

    }

    public static class ReimbursementsEntity implements Serializable {
        @Expose
        @SerializedName("message_read")
        private boolean messageRead;
        @Expose
        @SerializedName("created_by_id")
        private int createdById;
        @Expose
        @SerializedName("balance_before_transaction")
        private int balanceBeforeTransaction;
        @Expose
        @SerializedName("claim_uid")
        private String claimUid;
        @Expose
        @SerializedName("organization_id")
        private int organizationId;
        @Expose
        @SerializedName("final_amount")
        private int finalAmount;
        @Expose
        @SerializedName("status")
        private String status;
        @Expose
        @SerializedName("amount")
        private int amount;
        @Expose
        @SerializedName("updated_at")
        private String updatedAt;
        @Expose
        @SerializedName("created_at")
        private String createdAt;
        @Expose
        @SerializedName("time")
        private String time;
        @Expose
        @SerializedName("date")
        private String date;
        @Expose
        @SerializedName("transaction_for")
        private String transactionFor;
        @Expose
        @SerializedName("location")
        private String location;
        @Expose
        @SerializedName("speciality")
        private String speciality;
        @Expose
        @SerializedName("consultation_with")
        private String consultationWith;
        @Expose
        @SerializedName("user_id")
        private int userId;
        @Expose
        @SerializedName("transaction_type")
        private String transactionType;
        @Expose
        @SerializedName("claim_type")
        private String claimType;
        @Expose
        @SerializedName("id")
        private int id;
        @SerializedName("dependent")
        @Expose
        private Dependent dependent;

        public boolean getMessageRead() {
            return messageRead;
        }

        public void setMessageRead(boolean messageRead) {
            this.messageRead = messageRead;
        }

        public int getCreatedById() {
            return createdById;
        }

        public void setCreatedById(int createdById) {
            this.createdById = createdById;
        }

        public int getBalanceBeforeTransaction() {
            return balanceBeforeTransaction;
        }

        public void setBalanceBeforeTransaction(int balanceBeforeTransaction) {
            this.balanceBeforeTransaction = balanceBeforeTransaction;
        }

        public Dependent getDependent() {
            return dependent;
        }

        public void setDependent(Dependent dependent) {
            this.dependent = dependent;
        }

        public String getClaimUid() {
            return claimUid;
        }

        public void setClaimUid(String claimUid) {
            this.claimUid = claimUid;
        }

        public int getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(int organizationId) {
            this.organizationId = organizationId;
        }

        public int getFinalAmount() {
            return finalAmount;
        }

        public void setFinalAmount(int finalAmount) {
            this.finalAmount = finalAmount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTransactionFor() {
            return transactionFor;
        }

        public void setTransactionFor(String transactionFor) {
            this.transactionFor = transactionFor;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getConsultationWith() {
            return consultationWith;
        }

        public void setConsultationWith(String consultationWith) {
            this.consultationWith = consultationWith;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getClaimType() {
            return claimType;
        }

        public void setClaimType(String claimType) {
            this.claimType = claimType;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class Dependent implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class UserPolicyItem  implements Serializable{

        @SerializedName("used_balance")
        private int usedBalance;

        @SerializedName("policy_id")
        private int policyId;

        @SerializedName("active")
        private boolean active;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("policy_yearly_allowance")
        private double policyYearlyAllowance;

        @SerializedName("old_available_policy_blnc")
        private Object oldAvailablePolicyBlnc;

        @SerializedName("available_balance")
        private int availableBalance;

        @SerializedName("policy_available_allowance")
        private double policyAvailableAllowance;

        @SerializedName("old_yearly_policy_blnc")
        private Object oldYearlyPolicyBlnc;

        @SerializedName("updated_at")
        private String updatedAt;

        @SerializedName("policy_end_date")
        private Object policyEndDate;

        @SerializedName("user_id")
        private int userId;

        @SerializedName("policy_start_date")
        private String policyStartDate;

        @SerializedName("id")
        private int id;

        @SerializedName("pr_balance_when_end")
        private double prBalanceWhenEnd;

        public void setUsedBalance(int usedBalance){
            this.usedBalance = usedBalance;
        }

        public int getUsedBalance(){
            return usedBalance;
        }

        public void setPolicyId(int policyId){
            this.policyId = policyId;
        }

        public int getPolicyId(){
            return policyId;
        }

        public void setActive(boolean active){
            this.active = active;
        }

        public boolean isActive(){
            return active;
        }

        public void setCreatedAt(String createdAt){
            this.createdAt = createdAt;
        }

        public String getCreatedAt(){
            return createdAt;
        }

        public void setPolicyYearlyAllowance(double policyYearlyAllowance){
            this.policyYearlyAllowance = policyYearlyAllowance;
        }

        public double getPolicyYearlyAllowance(){
            return policyYearlyAllowance;
        }

        public void setOldAvailablePolicyBlnc(Object oldAvailablePolicyBlnc){
            this.oldAvailablePolicyBlnc = oldAvailablePolicyBlnc;
        }

        public Object getOldAvailablePolicyBlnc(){
            return oldAvailablePolicyBlnc;
        }

        public void setAvailableBalance(int availableBalance){
            this.availableBalance = availableBalance;
        }

        public int getAvailableBalance(){
            return availableBalance;
        }

        public void setPolicyAvailableAllowance(double policyAvailableAllowance){
            this.policyAvailableAllowance = policyAvailableAllowance;
        }

        public double getPolicyAvailableAllowance(){
            return policyAvailableAllowance;
        }

        public void setOldYearlyPolicyBlnc(Object oldYearlyPolicyBlnc){
            this.oldYearlyPolicyBlnc = oldYearlyPolicyBlnc;
        }

        public Object getOldYearlyPolicyBlnc(){
            return oldYearlyPolicyBlnc;
        }

        public void setUpdatedAt(String updatedAt){
            this.updatedAt = updatedAt;
        }

        public String getUpdatedAt(){
            return updatedAt;
        }

        public void setPolicyEndDate(Object policyEndDate){
            this.policyEndDate = policyEndDate;
        }

        public Object getPolicyEndDate(){
            return policyEndDate;
        }

        public void setUserId(int userId){
            this.userId = userId;
        }

        public int getUserId(){
            return userId;
        }

        public void setPolicyStartDate(String policyStartDate){
            this.policyStartDate = policyStartDate;
        }

        public String getPolicyStartDate(){
            return policyStartDate;
        }

        public void setId(int id){
            this.id = id;
        }

        public int getId(){
            return id;
        }

        public void setPrBalanceWhenEnd(double prBalanceWhenEnd){
            this.prBalanceWhenEnd = prBalanceWhenEnd;
        }

        public double getPrBalanceWhenEnd(){
            return prBalanceWhenEnd;
        }


    }

    protected UserClaims(Parcel in) {
        data = (DataEntity) in.readValue(DataEntity.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserClaims> CREATOR = new Parcelable.Creator<UserClaims>() {
        @Override
        public UserClaims createFromParcel(Parcel in) {
            return new UserClaims(in);
        }

        @Override
        public UserClaims[] newArray(int size) {
            return new UserClaims[size];
        }
    };
}
