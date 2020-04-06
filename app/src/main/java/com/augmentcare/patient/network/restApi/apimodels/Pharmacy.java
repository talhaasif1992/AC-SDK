package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pharmacy implements Parcelable {

    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("total_price")
    @Expose
    private Integer totalPrice;
    @SerializedName("partner")
    @Expose
    private String partner;
    public final static Parcelable.Creator<Pharmacy> CREATOR = new Creator<Pharmacy>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Pharmacy createFromParcel(Parcel in) {
            return new Pharmacy(in);
        }

        public Pharmacy[] newArray(int size) {
            return (new Pharmacy[size]);
        }

    };

    protected Pharmacy(Parcel in) {
        this.branch = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderId = ((String) in.readValue((String.class.getClassLoader())));
        this.totalPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.partner = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Pharmacy() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Pharmacy withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pharmacy withAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pharmacy withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Pharmacy withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Pharmacy withTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Pharmacy withPartner(String partner) {
        this.partner = partner;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("branch", branch).append("address", address).append("id", id).append("orderId", orderId).append("totalPrice", totalPrice).append("partner", partner).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(branch);
        dest.writeValue(address);
        dest.writeValue(id);
        dest.writeValue(orderId);
        dest.writeValue(totalPrice);
        dest.writeValue(partner);
    }

    public int describeContents() {
        return 0;
    }

}