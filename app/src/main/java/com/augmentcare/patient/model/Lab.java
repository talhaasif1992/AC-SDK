package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Lab implements Parcelable{

    private String name;
    private String category;
    @SerializedName("available_at")
    private ArrayList<LabBrach> availableAt;

    protected Lab(Parcel in) {
        name = in.readString();
        category = in.readString();
        availableAt = in.createTypedArrayList(LabBrach.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category);
        dest.writeTypedList(availableAt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lab> CREATOR = new Creator<Lab>() {
        @Override
        public Lab createFromParcel(Parcel in) {
            return new Lab(in);
        }

        @Override
        public Lab[] newArray(int size) {
            return new Lab[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<LabBrach> getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(ArrayList<LabBrach> availableAt) {
        this.availableAt = availableAt;
    }
}
