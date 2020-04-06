package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CancelDoctorAppointmentRequest implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("doctor_id")
    @Expose
    private int doctorId;
    @SerializedName("patient_id")
    @Expose
    private int patientId;
    @SerializedName("rejected")
    @Expose
    private boolean rejected;
    @SerializedName("notify_doctor")
    @Expose
    private boolean notifyDoctor;
    @SerializedName("rejected_by")
    @Expose
    private String rejectedBy;
    public final static Parcelable.Creator<CancelDoctorAppointmentRequest> CREATOR = new Creator<CancelDoctorAppointmentRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CancelDoctorAppointmentRequest createFromParcel(Parcel in) {
            return new CancelDoctorAppointmentRequest(in);
        }

        public CancelDoctorAppointmentRequest[] newArray(int size) {
            return (new CancelDoctorAppointmentRequest[size]);
        }

    };

    protected CancelDoctorAppointmentRequest(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.doctorId = ((int) in.readValue((int.class.getClassLoader())));
        this.patientId = ((int) in.readValue((int.class.getClassLoader())));
        this.rejected = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.notifyDoctor = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.rejectedBy = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public CancelDoctorAppointmentRequest() {
    }

    /**
     * @param rejectedBy
     * @param doctorId
     * @param patientId
     * @param rejected
     * @param id
     * @param notifyDoctor
     */
    public CancelDoctorAppointmentRequest(int id, int doctorId, int patientId, boolean rejected, boolean notifyDoctor, String rejectedBy) {
        super();
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.rejected = rejected;
        this.notifyDoctor = notifyDoctor;
        this.rejectedBy = rejectedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CancelDoctorAppointmentRequest withId(int id) {
        this.id = id;
        return this;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public CancelDoctorAppointmentRequest withDoctorId(int doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public CancelDoctorAppointmentRequest withPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public CancelDoctorAppointmentRequest withRejected(boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    public boolean isNotifyDoctor() {
        return notifyDoctor;
    }

    public void setNotifyDoctor(boolean notifyDoctor) {
        this.notifyDoctor = notifyDoctor;
    }

    public CancelDoctorAppointmentRequest withNotifyDoctor(boolean notifyDoctor) {
        this.notifyDoctor = notifyDoctor;
        return this;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public CancelDoctorAppointmentRequest withRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("doctorId", doctorId).append("patientId", patientId).append("rejected", rejected).append("notifyDoctor", notifyDoctor).append("rejectedBy", rejectedBy).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(doctorId);
        dest.writeValue(patientId);
        dest.writeValue(rejected);
        dest.writeValue(notifyDoctor);
        dest.writeValue(rejectedBy);
    }

    public int describeContents() {
        return 0;
    }

}
