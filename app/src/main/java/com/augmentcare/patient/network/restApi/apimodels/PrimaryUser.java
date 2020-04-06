package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PrimaryUser implements Parcelable {

    public final static Parcelable.Creator<PrimaryUser> CREATOR = new Creator<PrimaryUser>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PrimaryUser createFromParcel(Parcel in) {
            return new PrimaryUser(in);
        }

        public PrimaryUser[] newArray(int size) {
            return (new PrimaryUser[size]);
        }

    };

    protected PrimaryUser(Parcel in) {
    }

    public PrimaryUser() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return 0;
    }

}