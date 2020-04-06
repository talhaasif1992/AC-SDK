package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Payment implements Serializable {
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("user_role_id")
    @Expose
    private Object userRoleId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("promocode_id")
    @Expose
    private String promocodeId;
    @SerializedName("ice_uid")
    @Expose
    private Object iceUid;
    @SerializedName("original_amount")
    @Expose
    private Integer originalAmount;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("user_id")
    @Expose
    private Object userId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Object userRoleId) {
        this.userRoleId = userRoleId;
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

    public String getPromocodeId() {
        return promocodeId;
    }

    public void setPromocodeId(String promocodeId) {
        this.promocodeId = promocodeId;
    }

    public Object getIceUid() {
        return iceUid;
    }

    public void setIceUid(Object iceUid) {
        this.iceUid = iceUid;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }
}
