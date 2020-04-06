package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 03/04/2018.
 */

public class ADosage implements Parcelable{
    private String val;
    private String unit;

    protected ADosage(Parcel in) {
        val = in.readString();
        unit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(val);
        dest.writeString(unit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ADosage> CREATOR = new Creator<ADosage>() {
        @Override
        public ADosage createFromParcel(Parcel in) {
            return new ADosage(in);
        }

        @Override
        public ADosage[] newArray(int size) {
            return new ADosage[size];
        }
    };

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
