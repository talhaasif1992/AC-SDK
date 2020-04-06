package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 25/10/2017.
 */

public class Patient implements Parcelable{
    private PatientInfo user_info;
    @SerializedName("UserChannel")
    private String userChannel;

    protected Patient(Parcel in) {
        user_info = in.readParcelable(UserInfo.class.getClassLoader());
        userChannel = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(user_info, flags);
        dest.writeString(userChannel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public PatientInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(PatientInfo user_info) {
        this.user_info = user_info;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }
}
