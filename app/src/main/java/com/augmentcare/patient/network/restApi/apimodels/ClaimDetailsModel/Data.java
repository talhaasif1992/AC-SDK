package com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.network.restApi.apimodels.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data implements Parcelable{

    @SerializedName("claim")
    @Expose
    private Claim claim;
    @SerializedName("policies")
    @Expose
    private List<Policy> policies = null;
    @SerializedName("uploaded_files")
    @Expose
    private List<String> uploadedFiles = null;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;
    @SerializedName("other_user")
    @Expose
    private OtherUser otherUser;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(Parcel in) {
        this.claim = ((Claim) in.readValue((Claim.class.getClassLoader())));
        in.readList(this.policies, (com.augmentcare.patient.network.restApi.apimodels.Policy.class.getClassLoader()));
        in.readList(this.uploadedFiles, (java.lang.String.class.getClassLoader()));
        this.balance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.messages, (java.lang.Object.class.getClassLoader()));
        this.otherUser = ((OtherUser) in.readValue((OtherUser.class.getClassLoader())));
    }

    public Data() {
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Data withClaim(Claim claim) {
        this.claim = claim;
        return this;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public Data withPolicies(List<Policy> policies) {
        this.policies = policies;
        return this;
    }

    public List<String> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<String> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public Data withUploadedFiles(List<String> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
        return this;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Data withBalance(Integer balance) {
        this.balance = balance;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Data withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Data withMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public OtherUser getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(OtherUser otherUser) {
        this.otherUser = otherUser;
    }

    public Data withOtherUser(OtherUser otherUser) {
        this.otherUser = otherUser;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(claim);
        dest.writeList(policies);
        dest.writeList(uploadedFiles);
        dest.writeValue(balance);
        dest.writeValue(userName);
        dest.writeList(messages);
        dest.writeValue(otherUser);
    }

    public int describeContents() {
        return 0;
    }

}