package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ClaimDetail implements Serializable {


    @Expose
    @SerializedName("data")
    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity implements Serializable {
        @Expose
        @SerializedName("other_user")
        private OtherUserEntity otherUser;
        @Expose
        @SerializedName("messages")
        private List<MessagesEntity> messages;
        @Expose
        @SerializedName("user_name")
        private String userName;
        @Expose
        @SerializedName("balance")
        private int balance;
        @Expose
        @SerializedName("uploaded_files")
        private List<String> uploadedFiles;
        @Expose
        @SerializedName("policies")
        private List<PoliciesEntity> policies;
        @Expose
        @SerializedName("claim")
        private ClaimEntity claim;

        public OtherUserEntity getOtherUser() {
            return otherUser;
        }

        public void setOtherUser(OtherUserEntity otherUser) {
            this.otherUser = otherUser;
        }

        public List<MessagesEntity> getMessages() {
            return messages;
        }

        public void setMessages(List<MessagesEntity> messages) {
            this.messages = messages;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public List<String> getUploadedFiles() {
            return uploadedFiles;
        }

        public void setUploadedFiles(List<String> uploadedFiles) {
            this.uploadedFiles = uploadedFiles;
        }

        public List<PoliciesEntity> getPolicies() {
            return policies;
        }

        public void setPolicies(List<PoliciesEntity> policies) {
            this.policies = policies;
        }

        public ClaimEntity getClaim() {
            return claim;
        }

        public void setClaim(ClaimEntity claim) {
            this.claim = claim;
        }
    }

    public static class OtherUserEntity implements Serializable {
        @Expose
        @SerializedName("age_days")
        private int ageDays;
        @Expose
        @SerializedName("age_months")
        private int ageMonths;
        @Expose
        @SerializedName("dashboard_status")
        private String dashboardStatus;
        @Expose
        @SerializedName("city")
        private String city;
        @Expose
        @SerializedName("user_type")
        private String userType;
        @Expose
        @SerializedName("user_id")
        private int userId;
        @Expose
        @SerializedName("photo")
        private String photo;
        @Expose
        @SerializedName("employment_type")
        private String employmentType;
        @Expose
        @SerializedName("spouse")
        private String spouse;
        @Expose
        @SerializedName("marital_status")
        private String maritalStatus;
        @Expose
        @SerializedName("country")
        private String country;
        @Expose
        @SerializedName("address")
        private String address;
        @Expose
        @SerializedName("phone")
        private String phone;
        @Expose
        @SerializedName("nic")
        private String nic;
        @Expose
        @SerializedName("gender")
        private String gender;
        @Expose
        @SerializedName("dob")
        private String dob;
        @Expose
        @SerializedName("last_name")
        private String lastName;
        @Expose
        @SerializedName("first_name")
        private String firstName;
        @Expose
        @SerializedName("id")
        private int id;

        public int getAgeDays() {
            return ageDays;
        }

        public void setAgeDays(int ageDays) {
            this.ageDays = ageDays;
        }

        public int getAgeMonths() {
            return ageMonths;
        }

        public void setAgeMonths(int ageMonths) {
            this.ageMonths = ageMonths;
        }

        public String getDashboardStatus() {
            return dashboardStatus;
        }

        public void setDashboardStatus(String dashboardStatus) {
            this.dashboardStatus = dashboardStatus;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getEmploymentType() {
            return employmentType;
        }

        public void setEmploymentType(String employmentType) {
            this.employmentType = employmentType;
        }

        public String getSpouse() {
            return spouse;
        }

        public void setSpouse(String spouse) {
            this.spouse = spouse;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNic() {
            return nic;
        }

        public void setNic(String nic) {
            this.nic = nic;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class MessagesEntity implements Serializable {
        @Expose
        @SerializedName("message_read")
        private boolean messageRead;
        @Expose
        @SerializedName("user_id")
        private int userId;
        @Expose
        @SerializedName("updated_at")
        private String updatedAt;
        @Expose
        @SerializedName("created_at")
        private String createdAt;
        @Expose
        @SerializedName("message")
        private String message;
        @Expose
        @SerializedName("claim_id")
        private int claimId;
        @Expose
        @SerializedName("id")
        private int id;

        public boolean getMessageRead() {
            return messageRead;
        }

        public void setMessageRead(boolean messageRead) {
            this.messageRead = messageRead;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getClaimId() {
            return claimId;
        }

        public void setClaimId(int claimId) {
            this.claimId = claimId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class PoliciesEntity implements Serializable {
        @Expose
        @SerializedName("mt_allowance")
        private int mtAllowance;
        @Expose
        @SerializedName("ip_allowance")
        private int ipAllowance;
        @Expose
        @SerializedName("code")
        private String code;
        @Expose
        @SerializedName("end_date")
        private String endDate;
        @Expose
        @SerializedName("start_date")
        private String startDate;
        @Expose
        @SerializedName("is_unlimited")
        private boolean isUnlimited;
        @Expose
        @SerializedName("updated_at")
        private String updatedAt;
        @Expose
        @SerializedName("created_at")
        private String createdAt;
        @Expose
        @SerializedName("organization_id")
        private int organizationId;
        @Expose
        @SerializedName("created_by")
        private int createdBy;
        @Expose
        @SerializedName("op_allowance")
        private int opAllowance;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private int id;

        public int getMtAllowance() {
            return mtAllowance;
        }

        public void setMtAllowance(int mtAllowance) {
            this.mtAllowance = mtAllowance;
        }

        public int getIpAllowance() {
            return ipAllowance;
        }

        public void setIpAllowance(int ipAllowance) {
            this.ipAllowance = ipAllowance;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public boolean getIsUnlimited() {
            return isUnlimited;
        }

        public void setIsUnlimited(boolean isUnlimited) {
            this.isUnlimited = isUnlimited;
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

        public int getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(int organizationId) {
            this.organizationId = organizationId;
        }

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public int getOpAllowance() {
            return opAllowance;
        }

        public void setOpAllowance(int opAllowance) {
            this.opAllowance = opAllowance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ClaimEntity implements Serializable {
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
