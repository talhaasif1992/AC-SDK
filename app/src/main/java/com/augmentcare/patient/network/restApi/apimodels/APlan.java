package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 14/05/2018.
 */

public class APlan implements Parcelable {

    private long id;
    private String name;
    private double price;
    private int duration;
    private boolean status;
    @SerializedName("description")
    private ArrayList<String> descriptionList;
    @SerializedName("plan_type")
    private String planType;
    //@SerializedName("tesaldkf")
    private String description1;
    @SerializedName("currency_code")
    String currency_code;

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public APlan() {

    }

    protected APlan(Parcel in) {
        id = in.readLong();
        name = in.readString();
        price = in.readDouble();
        duration = in.readInt();
        status = in.readByte() != 0;
        descriptionList = in.createStringArrayList();
        planType = in.readString();
        description1 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(duration);
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeStringList(descriptionList);
        dest.writeString(planType);
        dest.writeString(description1);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<APlan> CREATOR = new Creator<APlan>() {
        @Override
        public APlan createFromParcel(Parcel in) {
            return new APlan(in);
        }

        @Override
        public APlan[] newArray(int size) {
            return new APlan[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(ArrayList<String> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getDescription() {
        return description1;
    }

    public void setDescription(String description) {
        this.description1 = description;
    }

    public APlan(long id, String name, double price, int duration, boolean status, ArrayList<String> descriptionList, String planType, String description1, String currency_code) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.status = status;
        this.descriptionList = descriptionList;
        this.planType = planType;
        this.description1 = description1;
        this.currency_code = currency_code;
    }
}
