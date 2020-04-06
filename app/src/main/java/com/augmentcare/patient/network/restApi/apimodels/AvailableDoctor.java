
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.LocalUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class AvailableDoctor implements Parcelable
{

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("doctor")
    @Expose
    private DoctorDetail doctor;
    public final static Creator<AvailableDoctor> CREATOR = new Creator<AvailableDoctor>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AvailableDoctor createFromParcel(Parcel in) {
            return new AvailableDoctor(in);
        }

        public AvailableDoctor[] newArray(int size) {
            return (new AvailableDoctor[size]);
        }

    }
    ;

    protected AvailableDoctor(Parcel in) {
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.doctor = ((DoctorDetail) in.readValue((DoctorDetail.class.getClassLoader())));
    }

    public AvailableDoctor() {
    }

    public String getTime() {
        return LocalUtils.getOr(time,"");
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AvailableDoctor withTime(String time) {
        this.time = time;
        return this;
    }

    public DoctorDetail getDoctorDetail() {
        return LocalUtils.getOr(doctor,new DoctorDetail());
    }

    public void setDoctorDetail(DoctorDetail doctor) {
        this.doctor = doctor;
    }

    public AvailableDoctor withDoctorDetail(DoctorDetail doctor) {
        this.doctor = doctor;
        return this;
    }

    @NotNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("time", time).append("doctor", doctor).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(time);
        dest.writeValue(doctor);
    }

    public int describeContents() {
        return  0;
    }

}
