package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PolicyInfo implements Parcelable {

    @SerializedName("covered")
    @Expose
    private boolean covered;
    @SerializedName("active")
    @Expose
    private String active;
    public final static Parcelable.Creator<PolicyInfo> CREATOR = new Creator<PolicyInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PolicyInfo createFromParcel(Parcel in) {
            return new PolicyInfo(in);
        }

        public PolicyInfo[] newArray(int size) {
            return (new PolicyInfo[size]);
        }

    };

    protected PolicyInfo(Parcel in) {
        this.covered = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.active = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PolicyInfo() {
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public PolicyInfo withCovered(boolean covered) {
        this.covered = covered;
        return this;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public PolicyInfo withActive(String active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("covered", covered).append("active", active).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(covered);
        dest.writeValue(active);
    }

    public int describeContents() {
        return 0;
    }

}