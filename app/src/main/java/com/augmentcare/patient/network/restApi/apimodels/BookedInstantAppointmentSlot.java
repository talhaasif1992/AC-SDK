package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class BookedInstantAppointmentSlot implements Parcelable {

    @SerializedName("slot")
    @Expose
    private Slot slot;
    @SerializedName("dependent")
    @Expose
    private Dependent dependent;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("errors")
    @Expose
    protected List<String> errors;
    public final static Parcelable.Creator<BookedInstantAppointmentSlot> CREATOR = new Creator<BookedInstantAppointmentSlot>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BookedInstantAppointmentSlot createFromParcel(Parcel in) {
            return new BookedInstantAppointmentSlot(in);
        }

        public BookedInstantAppointmentSlot[] newArray(int size) {
            return (new BookedInstantAppointmentSlot[size]);
        }

    };

    protected BookedInstantAppointmentSlot(Parcel in) {
        this.slot = ((Slot) in.readValue((Slot.class.getClassLoader())));
        this.dependent = ((Dependent) in.readValue((Dependent.class.getClassLoader())));
        this.doctorName = ((String) in.readValue((String.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public BookedInstantAppointmentSlot() {
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public BookedInstantAppointmentSlot withSlot(Slot slot) {
        this.slot = slot;
        return this;
    }
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public BookedInstantAppointmentSlot withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public BookedInstantAppointmentSlot withDependent(Dependent dependent) {
        this.dependent = dependent;
        return this;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public BookedInstantAppointmentSlot withDoctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookedInstantAppointmentSlot withUser(User user) {
        this.user = user;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BookedInstantAppointmentSlot withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("slot", slot).append("dependent", dependent).append("doctorName", doctorName).append("user", user).append("success", success).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slot);
        dest.writeValue(dependent);
        dest.writeValue(doctorName);
        dest.writeValue(user);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}