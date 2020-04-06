package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 22/12/2017.
 */

public class DependentType implements Parcelable{
    private String id;
    private String title;

    public DependentType(){

    }
    protected DependentType(Parcel in) {
        id = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DependentType> CREATOR = new Creator<DependentType>() {
        @Override
        public DependentType createFromParcel(Parcel in) {
            return new DependentType(in);
        }

        @Override
        public DependentType[] newArray(int size) {
            return new DependentType[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
