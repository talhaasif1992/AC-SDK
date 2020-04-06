package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class ASlot implements Parcelable
{

    @SerializedName("doctor_id")
    private String doctorID;
    @SerializedName("rejected_by")
    private String rejectedBy;

    private String available;
    @SerializedName("location_id")
    private String locationID;

    private String id;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("end_time")
    private String endTime;

    private boolean rejected;
    @SerializedName("doctor_sitting_id")
    private String doctorSittingId;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("patient_id")
    private String patientId;

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    @SerializedName("booking_time")
    private String bookingTime;

    @SerializedName("slot_type")
    private String slotType;


    private boolean completed;
    private String statusString;
    private Date startDateTime;
    private Date endDateTime;
    private String slot_status;
    private boolean status;
    private String day;
    private String payment_id;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    protected ASlot(Parcel in) {
        status = in.readByte() != 0;
        doctorID = in.readString();
        rejectedBy = in.readString();
        available = in.readString();
        locationID = in.readString();
        id = in.readString();
        updatedAt = in.readString();
        endTime = in.readString();
        rejected = in.readByte() != 0;
        doctorSittingId = in.readString();
        startTime = in.readString();
        createdAt = in.readString();
        patientId = in.readString();
        day = in.readString();
        slotType = in.readString();
        completed = in.readByte() != 0;
        statusString = in.readString();
        payment_id = in.readString();
        startDateTime = (Date) in.readSerializable();
        endDateTime = (Date) in.readSerializable();
        slot_status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeString(doctorID);
        dest.writeString(rejectedBy);
        dest.writeString(available);
        dest.writeString(locationID);
        dest.writeString(id);
        dest.writeString(updatedAt);
        dest.writeString(endTime);
        dest.writeByte((byte) (rejected ? 1 : 0));
        dest.writeString(doctorSittingId);
        dest.writeString(startTime);
        dest.writeString(createdAt);
        dest.writeString(patientId);
        dest.writeString(day);
        dest.writeString(slotType);
        dest.writeByte((byte) (completed ? 1 : 0));
        dest.writeString(statusString);
        dest.writeString(payment_id);
        dest.writeSerializable(startDateTime);
        dest.writeSerializable(endDateTime);
        dest.writeString(slot_status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ASlot> CREATOR = new Creator<ASlot>() {
        @Override
        public ASlot createFromParcel(Parcel in) {
            return new ASlot(in);
        }

        @Override
        public ASlot[] newArray(int size) {
            return new ASlot[size];
        }
    };



    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public String getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(String doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }


    public String getSlot_status() {
        return slot_status;
    }

    public void setSlot_status(String slot_status) {
        this.slot_status = slot_status;
    }
}
