package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 27/03/2018.
 */

public class LabResult implements Parcelable{

    private AOrder order;
    private APartner partner;
    @SerializedName("order_items")
    private ArrayList<AOrderItem> orderItems;
    private String doctor;

    protected LabResult(Parcel in) {
        order = in.readParcelable(AOrder.class.getClassLoader());
        partner = in.readParcelable(APartner.class.getClassLoader());
        orderItems = in.createTypedArrayList(AOrderItem.CREATOR);
        doctor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(order, flags);
        dest.writeParcelable(partner, flags);
        dest.writeTypedList(orderItems);
        dest.writeString(doctor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LabResult> CREATOR = new Creator<LabResult>() {
        @Override
        public LabResult createFromParcel(Parcel in) {
            return new LabResult(in);
        }

        @Override
        public LabResult[] newArray(int size) {
            return new LabResult[size];
        }
    };

    public AOrder getOrder() {
        return order;
    }

    public void setOrder(AOrder order) {
        this.order = order;
    }

    public APartner getPartner() {
        return partner;
    }

    public void setPartner(APartner partner) {
        this.partner = partner;
    }

    public ArrayList<AOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<AOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
