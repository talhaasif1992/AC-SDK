package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Lab implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer labID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("available_at")
    @Expose
    private List<String> availableAt = new ArrayList<String>();
    public final static Parcelable.Creator<Lab> CREATOR = new Creator<Lab>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Lab createFromParcel(Parcel in) {
            return new Lab(in);
        }

        public Lab[] newArray(int size) {
            return (new Lab[size]);
        }

    };

    protected Lab(Parcel in) {
        this.labID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.availableAt, (java.lang.String.class.getClassLoader()));
    }

    public Lab() {
    }

    public Integer getID() {
        return labID;
    }

    public void setID(Integer labID) {
        this.labID = labID;
    }

    public Lab withID(Integer labID) {
        this.labID = labID;
        return this;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lab withName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Lab withCategory(String category) {
        this.category = category;
        return this;
    }

    public List<String> getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(List<String> availableAt) {
        this.availableAt = availableAt;
    }

    public Lab withAvailableAt(List<String> availableAt) {
        this.availableAt = availableAt;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("name", name).append("category", category).append("availableAt", availableAt).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(labID);
        dest.writeValue(name);
        dest.writeValue(category);
        dest.writeList(availableAt);
    }

    public int describeContents() {
        return 0;
    }

}