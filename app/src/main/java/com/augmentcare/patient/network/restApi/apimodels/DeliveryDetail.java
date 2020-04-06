package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DeliveryDetail implements Parcelable {

    @SerializedName("charges")
    @Expose
    private int charges;
    @SerializedName("delivery_time")
    @Expose
    private String deliveryTime;
    public final static Parcelable.Creator<DeliveryDetail> CREATOR = new Creator<DeliveryDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DeliveryDetail createFromParcel(Parcel in) {
            return new DeliveryDetail(in);
        }

        public DeliveryDetail[] newArray(int size) {
            return (new DeliveryDetail[size]);
        }

    };

    protected DeliveryDetail(Parcel in) {
        this.charges = ((int) in.readValue((int.class.getClassLoader())));
        this.deliveryTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DeliveryDetail() {
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public DeliveryDetail withCharges(int charges) {
        this.charges = charges;
        return this;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public DeliveryDetail withDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("charges", charges).append("deliveryTime", deliveryTime).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(charges);
        dest.writeValue(deliveryTime);
    }

    public int describeContents() {
        return 0;
    }

}