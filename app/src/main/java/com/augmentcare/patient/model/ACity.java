package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 26/10/2017.
 */

public class ACity implements Parcelable{
    private String id;
    private String name;
    protected ArrayList<AArea> areas;

    public ACity(){}

    protected ACity(Parcel in) {
        id = in.readString();
        name = in.readString();
        areas = in.createTypedArrayList(AArea.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeTypedList(areas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ACity> CREATOR = new Creator<ACity>() {
        @Override
        public ACity createFromParcel(Parcel in) {
            return new ACity(in);
        }

        @Override
        public ACity[] newArray(int size) {
            return new ACity[size];
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

    public ArrayList<AArea> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<AArea> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return ""+name;
    }
}
