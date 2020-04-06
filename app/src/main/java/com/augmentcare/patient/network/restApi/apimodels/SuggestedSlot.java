package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 30/05/2018.
 */

public class SuggestedSlot implements Parcelable{

    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("doctor_id")
    private String doctorId;
    @SerializedName("daySpinner")
    private String day;

    protected SuggestedSlot(Parcel in) {
        startTime = in.readString();
        endTime = in.readString();
        doctorId = in.readString();
        day = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startTime);
        dest.writeString(endTime);
        dest.writeString(doctorId);
        dest.writeString(day);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SuggestedSlot> CREATOR = new Creator<SuggestedSlot>() {
        @Override
        public SuggestedSlot createFromParcel(Parcel in) {
            return new SuggestedSlot(in);
        }

        @Override
        public SuggestedSlot[] newArray(int size) {
            return new SuggestedSlot[size];
        }
    };

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
