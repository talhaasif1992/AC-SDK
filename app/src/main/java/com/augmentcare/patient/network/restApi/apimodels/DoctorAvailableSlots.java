package com.augmentcare.patient.network.restApi.apimodels;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorAvailableSlots implements Parcelable {

    public final static Parcelable.Creator<DoctorAvailableSlots> CREATOR = new Creator<DoctorAvailableSlots>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DoctorAvailableSlots createFromParcel(Parcel in) {
            return new DoctorAvailableSlots(in);
        }

        public DoctorAvailableSlots[] newArray(int size) {
            return (new DoctorAvailableSlots[size]);
        }

    };
    @SerializedName("doctor")
    @Expose
    private DocterInfo doctor;
    @SerializedName("doctor_user")
    @Expose
    private User doctorUser;
    @SerializedName("available_slots")
    @Expose
    private List<Slot> availableSlots = new ArrayList<>();

    protected DoctorAvailableSlots(Parcel in) {
        this.doctor = ((DocterInfo) in.readValue((DocterInfo.class.getClassLoader())));
        this.doctorUser = ((User) in.readValue((User.class.getClassLoader())));
        in.readList(this.availableSlots, (Slot.class.getClassLoader()));
    }

    public DoctorAvailableSlots() {
    }

    public DocterInfo getDoctor() {
        return doctor;
    }

    public void setDoctor(DocterInfo doctor) {
        this.doctor = doctor;
    }

    public DoctorAvailableSlots withDoctor(DocterInfo doctor) {
        this.doctor = doctor;
        return this;
    }

    public User getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(User doctorUser) {
        this.doctorUser = doctorUser;
    }

    public DoctorAvailableSlots withDoctorUser(User doctorUser) {
        this.doctorUser = doctorUser;
        return this;
    }

    public List<Slot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<Slot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public DoctorAvailableSlots withAvailableSlots(List<Slot> availableSlots) {
        this.availableSlots = availableSlots;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(doctor);
        dest.writeValue(doctorUser);
        dest.writeList(availableSlots);
    }

    public int describeContents() {
        return 0;
    }

}