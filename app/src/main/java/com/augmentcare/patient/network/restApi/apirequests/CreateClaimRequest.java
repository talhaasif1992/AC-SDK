package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class CreateClaimRequest implements Parcelable {

    @SerializedName("transaction_type")
    @Expose
    private String transactionType;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("consultation_with")
    @Expose
    private String consultationWith;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("organization_id")
    @Expose
    private Integer organizationId;
    @SerializedName("transaction_for")
    @Expose
    private String transactionFor;
    @SerializedName("uploaded_files")
    @Expose
    private List<String> uploadedFiles = new ArrayList<String>();
    @SerializedName("claim_type")
    @Expose
    private String claimType;

    @SerializedName("dependent_id")
    @Expose
    private String dependentId;

    public final static Parcelable.Creator<CreateClaimRequest> CREATOR = new Creator<CreateClaimRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreateClaimRequest createFromParcel(Parcel in) {
            return new CreateClaimRequest(in);
        }

        public CreateClaimRequest[] newArray(int size) {
            return (new CreateClaimRequest[size]);
        }

    };

    protected CreateClaimRequest(Parcel in) {
        this.transactionType = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.consultationWith = ((String) in.readValue((String.class.getClassLoader())));
        this.speciality = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.transactionFor = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.uploadedFiles, (java.lang.String.class.getClassLoader()));
        this.claimType = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CreateClaimRequest() {
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public CreateClaimRequest withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CreateClaimRequest withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getConsultationWith() {
        return consultationWith;
    }

    public void setConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
    }

    public CreateClaimRequest withConsultationWith(String consultationWith) {
        this.consultationWith = consultationWith;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public CreateClaimRequest withSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CreateClaimRequest withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CreateClaimRequest withDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CreateClaimRequest withTime(String time) {
        this.time = time;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CreateClaimRequest withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public CreateClaimRequest withOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }

    public CreateClaimRequest withTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
        return this;
    }

    public List<String> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<String> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public CreateClaimRequest withUploadedFiles(List<String> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
        return this;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public CreateClaimRequest withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("transactionType", transactionType).append("amount", amount).append("consultationWith", consultationWith).append("speciality", speciality).append("location", location).append("date", date).append("time", time).append("userId", userId).append("organizationId", organizationId).append("transactionFor", transactionFor).append("uploadedFiles", uploadedFiles).append("claimType", claimType).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(transactionType);
        dest.writeValue(amount);
        dest.writeValue(consultationWith);
        dest.writeValue(speciality);
        dest.writeValue(location);
        dest.writeValue(date);
        dest.writeValue(time);
        dest.writeValue(userId);
        dest.writeValue(organizationId);
        dest.writeValue(transactionFor);
        dest.writeList(uploadedFiles);
        dest.writeValue(claimType);
        dest.writeValue(dependentId);
    }

    public int describeContents() {
        return 0;
    }

    public String getDependentId() {
        return dependentId;
    }

    public void setDependentId(String dependentId) {
        this.dependentId = dependentId;
    }

    public CreateClaimRequest withDependentId(String dependentId){
        this.dependentId = dependentId;
        return this;
    }
}