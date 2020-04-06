package com.augmentcare.patient.network.restApi.apimodels.FreeCallModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodayCalls implements Parcelable{

    @SerializedName("pending")
    @Expose
    private Integer todayPending;
    @SerializedName("approved")
    @Expose
    private Integer todayApproved;
    @SerializedName("cancelled_by_patient")
    @Expose
    private Integer todayCancelledByPatient;
    @SerializedName("cancelled_by_doctor")
    @Expose
    private Integer todayCancelledByDoctor;
    @SerializedName("in_progress")
    @Expose
    private Integer todayInProgress;
    @SerializedName("prescription_pending")
    @Expose
    private Integer todayPrescriptionPending;
    @SerializedName("prescription_submitted")
    @Expose
    private Integer todayPrescriptionSubmitted;
    @SerializedName("not_responding")
    @Expose
    private Integer todayNotResponding;
    @SerializedName("lab_advised")
    @Expose
    private Integer todayLabAdvised;

    public final static Parcelable.Creator<TodayCalls> CREATOR = new Creator<TodayCalls>() {

        @SuppressWarnings({
                "unchecked"
        })
        public TodayCalls createFromParcel(Parcel in){
            return new TodayCalls(in);
        }

        public TodayCalls[] newArray(int size) {
            return (new TodayCalls[size]);
        }

    };

    protected TodayCalls(Parcel in){
        this.todayApproved = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayCancelledByDoctor = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayCancelledByPatient = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayInProgress = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayLabAdvised = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayNotResponding = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayPending = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayPrescriptionPending = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayPrescriptionSubmitted = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public TodayCalls(){}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(todayApproved);
        dest.writeValue(todayCancelledByDoctor);
        dest.writeValue(todayCancelledByPatient);
        dest.writeValue(todayInProgress);
        dest.writeValue(todayLabAdvised);
        dest.writeValue(todayNotResponding);
        dest.writeValue(todayPending);
        dest.writeValue(todayPrescriptionPending);
        dest.writeValue(todayPrescriptionSubmitted);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public TodayCalls withTodayPending(Integer todayPending){
        this.todayPending = todayPending;
        return this;
    }
    public Integer getTodayPending() {
        return todayPending;
    }
    public void setTodayPending(Integer todayPending) {
        this.todayPending = todayPending;
    }
////////////////////////////////////////////////////////////////////////////////
    public TodayCalls withTodayApproved(Integer todayApproved){
        this.todayApproved = todayApproved;
        return this;
    }
    public Integer getTodayApproved() {
        return todayApproved;
    }

    public void setTodayApproved(Integer todayApproved) {
        this.todayApproved = todayApproved;
    }
////////////////////////////////////////////////////////////////////////////////

    public TodayCalls withTodayCancelledByPatient(Integer todayCancelledByPatient){
        this.todayCancelledByPatient = todayCancelledByPatient;
        return this;
    }

    public Integer getTodayCancelledByPatient() {
        return todayCancelledByPatient;
    }

    public void setTodayCancelledByPatient(Integer todayCancelledByPatient) {
        this.todayCancelledByPatient = todayCancelledByPatient;
    }
//////////////////////////////////////////////////////////////////////////////////

    public TodayCalls withTodayCancelledByDoctor(Integer todayCancelledByDoctor){
        this.todayCancelledByDoctor = todayCancelledByDoctor;
        return this;
    }

    public Integer getTodayCancelledByDoctor() {
        return todayCancelledByDoctor;
    }

    public void setTodayCancelledByDoctor(Integer todayCancelledByDoctor) {
        this.todayCancelledByDoctor = todayCancelledByDoctor;
    }
////////////////////////////////////////////////////////////////////////////////////////

    public TodayCalls withTodayInProgress(Integer todayInProgress){
        this.todayInProgress = todayInProgress;
        return this;
    }

    public Integer getTodayInProgress() {
        return todayInProgress;
    }

    public void setTodayInProgress(Integer todayInProgress) {
        this.todayInProgress = todayInProgress;
    }
////////////////////////////////////////////////////////////////////////////////////////

    public TodayCalls withTodayPrescriptionPending(Integer todayPrescriptionPending){
        this.todayPrescriptionPending = todayPrescriptionPending;
        return this;
    }

    public Integer getTodayPrescriptionPending() {
        return todayPrescriptionPending;
    }

    public void setTodayPrescriptionPending(Integer todayPrescriptionPending) {
        this.todayPrescriptionPending = todayPrescriptionPending;
    }
////////////////////////////////////////////////////////////////////////////////////////
    public TodayCalls withTodayPrescriptionSubmitted(Integer todayPrescriptionSubmitted){
        this.todayPrescriptionSubmitted = todayPrescriptionSubmitted;
        return this;
    }

    public Integer getTodayPrescriptionSubmitted() {
        return todayPrescriptionSubmitted;
    }

    public void setTodayPrescriptionSubmitted(Integer todayPrescriptionSubmitted){
        this.todayPrescriptionSubmitted = todayPrescriptionSubmitted;
    }
////////////////////////////////////////////////////////////////////////////////////////////

    public TodayCalls withTodayNotResponding(Integer todayNotResponding){
        this.todayNotResponding = todayNotResponding;
        return this;
    }

    public Integer getTodayNotResponding() {
        return todayNotResponding;
    }

    public void setTodayNotResponding(Integer todayNotResponding) {
        this.todayNotResponding = todayNotResponding;
    }
///////////////////////////////////////////////////////////////////////////////////////////
    public TodayCalls withTodayLabAdvised(Integer todayLabAdvised){
        this.todayLabAdvised = todayLabAdvised;
        return this;
    }

    public Integer getTodayLabAdvised() {
        return todayLabAdvised;
    }

    public void setTodayLabAdvised(Integer todayLabAdvised) {
        this.todayLabAdvised = todayLabAdvised;
    }
}