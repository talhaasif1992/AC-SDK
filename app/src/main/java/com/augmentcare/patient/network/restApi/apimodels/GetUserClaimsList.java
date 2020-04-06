package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.LocalUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GetUserClaimsList implements Parcelable {

    @SerializedName("digital_claims")
    @Expose
    private List<UserClaims.ReimbursementsEntity> digitalClaims = new ArrayList<UserClaims.ReimbursementsEntity>();
    @SerializedName("reimbursements")
    @Expose
    private List<UserClaims.ReimbursementsEntity> reimbursements = new ArrayList<UserClaims.ReimbursementsEntity>();
    @SerializedName("available_balance")
    @Expose
    private Integer availableBalance;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public List<UserPolicyItem> getUserPolicy() {
        return LocalUtils.getOr(userPolicy,new ArrayList<>());
    }

    public void setUserPolicy(List<UserPolicyItem> userPolicy) {
        this.userPolicy = userPolicy;
    }

    public static Creator<GetUserClaimsList> getCREATOR() {
        return CREATOR;
    }

    @Expose
    @SerializedName("user_policy")
    private List<UserPolicyItem> userPolicy;
    public final static Parcelable.Creator<GetUserClaimsList> CREATOR = new Creator<GetUserClaimsList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetUserClaimsList createFromParcel(Parcel in) {
            return new GetUserClaimsList(in);
        }

        public GetUserClaimsList[] newArray(int size) {
            return (new GetUserClaimsList[size]);
        }

    };

    protected GetUserClaimsList(Parcel in) {
        in.readList(this.digitalClaims, (com.augmentcare.patient.network.restApi.apimodels.UserClaims.ReimbursementsEntity.class.getClassLoader()));
        in.readList(this.reimbursements, (com.augmentcare.patient.network.restApi.apimodels.UserClaims.ReimbursementsEntity.class.getClassLoader()));
        this.availableBalance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.limit = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public GetUserClaimsList() {
    }

    public List<UserClaims.ReimbursementsEntity> getDigitalClaims() {
        return LocalUtils.getOr(digitalClaims,new ArrayList<>());
    }

    public void setDigitalClaims(List<UserClaims.ReimbursementsEntity> digitalClaims) {
        this.digitalClaims = digitalClaims;
    }

    public GetUserClaimsList withDigitalClaims(List<UserClaims.ReimbursementsEntity> digitalClaims) {
        this.digitalClaims = digitalClaims;
        return this;
    }

    public List<UserClaims.ReimbursementsEntity> getReimbursements() {
        return LocalUtils.getOr(reimbursements,new ArrayList<>());
    }

    public void setReimbursements(List<UserClaims.ReimbursementsEntity> reimbursements) {
        this.reimbursements = reimbursements;
    }

    public GetUserClaimsList withReimbursements(List<UserClaims.ReimbursementsEntity> reimbursements) {
        this.reimbursements = reimbursements;
        return this;
    }

    public Integer getAvailableBalance() {
        return LocalUtils.getOr(availableBalance,0);
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public GetUserClaimsList withAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public Integer getLimit() {
        return LocalUtils.getOr(limit,0);
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public GetUserClaimsList withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @NotNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("digitalClaims", digitalClaims).append("reimbursements", reimbursements).append("availableBalance", availableBalance).append("limit", limit).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(digitalClaims);
        dest.writeList(reimbursements);
        dest.writeValue(availableBalance);
        dest.writeValue(limit);
    }

    public int describeContents() {
        return 0;
    }

}