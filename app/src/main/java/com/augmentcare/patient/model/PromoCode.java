package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 20/12/2017.
 */

public class PromoCode implements Parcelable{
    /*
    * {"id":1,"code":"hamza","discount":"100","created_at":"2017-12-15T07:39:04.756Z","updated_at":"2017-12-20T06:28:20.494Z","validate_from":"2017-12-15T07:36:25.000Z","validate_till":"2017-12-23T06:04:52.705Z","max_count":10,"used_count":4,"active":true}
    * **/
    private long id;
    private String code;
    @SerializedName("validate_from")
    private String validFrom;
    @SerializedName("validate_till")
    private String validTill;
    @SerializedName("max_count")
    private int maxCount;

    private int discount;
    @SerializedName("used_count")
    private int usedCount;
    private boolean active;

    protected PromoCode(Parcel in) {
        id = in.readLong();
        code = in.readString();
        validFrom = in.readString();
        validTill = in.readString();
        maxCount = in.readInt();
        discount = in.readInt();
        usedCount = in.readInt();
        active = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(code);
        dest.writeString(validFrom);
        dest.writeString(validTill);
        dest.writeInt(maxCount);
        dest.writeInt(discount);
        dest.writeInt(usedCount);
        dest.writeByte((byte) (active ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PromoCode> CREATOR = new Creator<PromoCode>() {
        @Override
        public PromoCode createFromParcel(Parcel in) {
            return new PromoCode(in);
        }

        @Override
        public PromoCode[] newArray(int size) {
            return new PromoCode[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTill() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
