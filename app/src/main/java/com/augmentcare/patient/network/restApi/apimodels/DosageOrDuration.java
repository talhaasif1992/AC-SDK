package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DosageOrDuration implements Parcelable {

    @SerializedName("val")
    @Expose
    private Float val;
    @SerializedName("unit")
    @Expose
    private String unit;
    public final static Parcelable.Creator<DosageOrDuration> CREATOR = new Creator<DosageOrDuration>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DosageOrDuration createFromParcel(Parcel in) {
            return new DosageOrDuration(in);
        }

        public DosageOrDuration[] newArray(int size) {
            return (new DosageOrDuration[size]);
        }

    };

    protected DosageOrDuration(Parcel in) {
        this.val = ((Float) in.readValue((Float.class.getClassLoader())));
        this.unit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DosageOrDuration() {
    }

    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }

    public DosageOrDuration withVal(Float val) {
        this.val = val;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public DosageOrDuration withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("val", val).append("unit", unit).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(val);
        dest.writeValue(unit);
    }

    public int describeContents() {
        return 0;
    }

}