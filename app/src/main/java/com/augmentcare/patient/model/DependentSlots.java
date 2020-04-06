package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fahad Saleem on 31/01/2019.
 */

public class DependentSlots implements Parcelable {


    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;


    private DependentSlots(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DependentSlots> CREATOR = new Creator<DependentSlots>() {
        @Override
        public DependentSlots createFromParcel(Parcel in) {
            return new DependentSlots(in);
        }

        @Override
        public DependentSlots[] newArray(int size) {
            return new DependentSlots[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Creator<DependentSlots> getCREATOR() {
        return CREATOR;
    }
}
