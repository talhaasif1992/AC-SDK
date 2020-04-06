
package com.augmentcare.patient.model.appointmentModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appointment
{
    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("dependent")
    @Expose
    private Dependent dependent;

    @SerializedName("slot")
    @Expose
    private Slot slot;

    @SerializedName("user_info")
    @Expose
    private UserInfo user_info;

    @SerializedName("doctor_info")
    @Expose
    private UserInfo doctor_info;

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public UserInfo getUserInfo() {
        return user_info;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.user_info = userInfo;
    }

    public UserInfo getDoctorInfo() {
        return doctor_info;
    }

    public void setDoctorInfo(UserInfo doctorInfo) {
        this.doctor_info = doctorInfo;
    }
}