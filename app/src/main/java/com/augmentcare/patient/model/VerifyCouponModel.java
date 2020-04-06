package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyCouponModel
{
    @Expose
    @SerializedName("data")
    private DataEntity data;

    @Expose
    @SerializedName("success")
    private boolean success;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity
    {
        @Expose
        @SerializedName("final_amount")
        private int finalAmount;

        @Expose
        @SerializedName("discount")
        private int discount;

        @Expose
        @SerializedName("coupon")
        private CouponEntity coupon;

        @Expose
        @SerializedName("message")
        private String message;

        public int getFinalAmount() {
            return finalAmount;
        }

        public void setFinalAmount(int finalAmount) {
            this.finalAmount = finalAmount;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public CouponEntity getCoupon() {
            return coupon;
        }

        public void setCoupon(CouponEntity coupon) {
            this.coupon = coupon;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class CouponEntity
    {
        @Expose
        @SerializedName("valid")
        private boolean valid;

        @Expose
        @SerializedName("times_redeemed")
        private int timesRedeemed;

        @Expose
        @SerializedName("percent_off_precise")
        private int percentOffPrecise;

        @Expose
        @SerializedName("percent_off")
        private int percentOff;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("metadata")
        private MetadataEntity metadata;

        @Expose
        @SerializedName("livemode")
        private boolean livemode;

        @Expose
        @SerializedName("duration")
        private String duration;

        @Expose
        @SerializedName("created")
        private int created;

        @Expose
        @SerializedName("object")
        private String object;

        @Expose
        @SerializedName("id")
        private String id;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public boolean getValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public int getTimesRedeemed() {
            return timesRedeemed;
        }

        public void setTimesRedeemed(int timesRedeemed) {
            this.timesRedeemed = timesRedeemed;
        }

        public int getPercentOffPrecise() {
            return percentOffPrecise;
        }

        public void setPercentOffPrecise(int percentOffPrecise) {
            this.percentOffPrecise = percentOffPrecise;
        }

        public int getPercentOff() {
            return percentOff;
        }

        public void setPercentOff(int percentOff) {
            this.percentOff = percentOff;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public MetadataEntity getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataEntity metadata) {
            this.metadata = metadata;
        }

        public boolean getLivemode() {
            return livemode;
        }

        public void setLivemode(boolean livemode) {
            this.livemode = livemode;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class MetadataEntity {
    }
}