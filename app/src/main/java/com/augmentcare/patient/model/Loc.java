package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zmaan on 13/10/2017.
 */

public class Loc implements Parcelable{
    private String address1;
    private String locationable_type;

    protected Loc(Parcel in) {
        address1 = in.readString();
        locationable_type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address1);
        dest.writeString(locationable_type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Loc> CREATOR = new Creator<Loc>() {
        @Override
        public Loc createFromParcel(Parcel in) {
            return new Loc(in);
        }

        @Override
        public Loc[] newArray(int size) {
            return new Loc[size];
        }
    };

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLocationable_type() {
        return locationable_type;
    }

    public void setLocationable_type(String locationable_type) {
        this.locationable_type = locationable_type;
    }
}
