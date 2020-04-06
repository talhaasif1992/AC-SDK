package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserPolicyItem  implements Serializable {

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