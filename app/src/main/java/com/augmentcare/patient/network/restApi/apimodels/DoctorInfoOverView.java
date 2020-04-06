package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DoctorInfoOverView implements Parcelable {

    @SerializedName("doctor_picture")
    @Expose
    private String doctorPicture;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("appointment_time")
    @Expose
    private String appointmentTime;
    public final static Parcelable.Creator<DoctorInfoOverView> CREATOR = new Creator<DoctorInfoOverView>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DoctorInfoOverView createFromParcel(Parcel in) {
            return new DoctorInfoOverView(in);
        }

        public DoctorInfoOverView[] newArray(int size) {
            return (new DoctorInfoOverView[size]);
        }

    };

    protected DoctorInfoOverView(Parcel in) {
        this.doctorPicture = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorName = ((String) in.readValue((String.class.getClassLoader())));
        this.duration = ((int) in.readValue((int.class.getClassLoader())));
        this.specialization = ((String) in.readValue((String.class.getClassLoader())));
        this.appointmentTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DoctorInfoOverView() {
    }

    public String getDoctorPicture() {
        return doctorPicture;
    }

    public void setDoctorPicture(String doctorPicture) {
        this.doctorPicture = doctorPicture;
    }

    public DoctorInfoOverView withDoctorPicture(String doctorPicture) {
        this.doctorPicture = doctorPicture;
        return this;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public DoctorInfoOverView withDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public DoctorInfoOverView withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public DoctorInfoOverView withSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public DoctorInfoOverView withAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("doctorPicture", doctorPicture).append("doctorName", doctorName).append("duration", duration).append("specialization", specialization).append("appointmentTime", appointmentTime).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(doctorPicture);
        dest.writeValue(doctorName);
        dest.writeValue(duration);
        dest.writeValue(specialization);
        dest.writeValue(appointmentTime);
    }

    public int describeContents() {
        return 0;
    }

}