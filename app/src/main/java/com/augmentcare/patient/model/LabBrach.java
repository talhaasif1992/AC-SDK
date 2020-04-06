package com.augmentcare.patient.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LabBrach implements Parcelable{

    private String price;

    private String address;
    @SerializedName("lab_id")
    private String labId;

    private String name;

    private String branch;

    private String unitPrice;
    @SerializedName("branch_id")
    private String branchId;

    protected LabBrach(Parcel in) {
        price = in.readString();
        address = in.readString();
        labId = in.readString();
        name = in.readString();
        branch = in.readString();
        unitPrice = in.readString();
        branchId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(price);
        dest.writeString(address);
        dest.writeString(labId);
        dest.writeString(name);
        dest.writeString(branch);
        dest.writeString(unitPrice);
        dest.writeString(branchId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LabBrach> CREATOR = new Creator<LabBrach>() {
        @Override
        public LabBrach createFromParcel(Parcel in) {
            return new LabBrach(in);
        }

        @Override
        public LabBrach[] newArray(int size) {
            return new LabBrach[size];
        }
    };

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}
