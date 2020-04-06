package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 31/10/2017.
 */

public class Pharmacy implements Parcelable{

    private String pharmacy_id;
    private String name;
    private String pharmacy_name;
    private String unitPrice;
    private String branch_id;
    private String branch;
    private String address;
    private double price;
    private int qty;
    private boolean in_loose;

    protected Pharmacy(Parcel in) {
        pharmacy_id = in.readString();
        name = in.readString();
        unitPrice = in.readString();
        branch_id = in.readString();
        branch = in.readString();
        address = in.readString();
        price = in.readDouble();
        qty = in.readInt();
        in_loose = in.readByte() != 0;
        pharmacy_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pharmacy_id);
        dest.writeString(name);
        dest.writeString(unitPrice);
        dest.writeString(branch_id);
        dest.writeString(branch);
        dest.writeString(address);
        dest.writeDouble(price);
        dest.writeInt(qty);
        dest.writeByte((byte) (in_loose ? 1 : 0));
        dest.writeString(pharmacy_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pharmacy> CREATOR = new Creator<Pharmacy>() {
        @Override
        public Pharmacy createFromParcel(Parcel in) {
            return new Pharmacy(in);
        }

        @Override
        public Pharmacy[] newArray(int size) {
            return new Pharmacy[size];
        }
    };

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isIn_loose() {
        return in_loose;
    }

    public void setIn_loose(boolean in_loose) {
        this.in_loose = in_loose;
    }

    public Pharmacy(){

    }


    public String getPharmacy_id() {
        return pharmacy_id;
    }

    public void setPharmacy_id(String pharmacy_id) {
        this.pharmacy_id = pharmacy_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPharmacy_name() {
        return pharmacy_name;
    }
}

