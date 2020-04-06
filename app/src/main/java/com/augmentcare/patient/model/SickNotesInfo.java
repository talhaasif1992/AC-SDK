package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SickNotesInfo implements Parcelable {
    @SerializedName("id")
    private String id;
    @SerializedName("patient_id")
    private String patient_id;
    @SerializedName("doctor_id")
    private String doctor_id;
    @SerializedName("consultation_id")
    private String consultation_id;
    @SerializedName("note")
    private String note;
    @SerializedName("allow_bed_rest")
    private String allow_bed_rest;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("leave_start_date")
    private String leave_start_date;
    @SerializedName("leave_end_date")
    private String leave_end_date;

    protected SickNotesInfo(Parcel in) {
        patient_id = in.readString();
        id = in.readString();
        doctor_id = in.readString();
        consultation_id = in.readString();
        note = in.readString();
        allow_bed_rest = in.readString();
        created_at = in.readString();
        leave_start_date = in.readString();
        leave_end_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(patient_id);
        dest.writeString(doctor_id);
        dest.writeString(id);
        dest.writeString(consultation_id);
        dest.writeString(note);
        dest.writeString(allow_bed_rest);
        dest.writeString(created_at);
        dest.writeString(leave_start_date);
        dest.writeString(leave_end_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SickNotesInfo> CREATOR = new Creator<SickNotesInfo>() {
        @Override
        public SickNotesInfo createFromParcel(Parcel in) {
            return new SickNotesInfo(in);
        }

        @Override
        public SickNotesInfo[] newArray(int size) {
            return new SickNotesInfo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAllow_bed_rest() {
        return allow_bed_rest;
    }

    public void setAllow_bed_rest(String allow_bed_rest) {
        this.allow_bed_rest = allow_bed_rest;
    }

    public String getLeave_start_date() {
        return leave_start_date;
    }

    public void setLeave_start_date(String leave_start_date) {
        this.leave_start_date = leave_start_date;
    }

    public String getLeave_end_date() {
        return leave_end_date;
    }

    public void setLeave_end_date(String leave_end_date) {
        this.leave_end_date = leave_end_date;
    }

    public String getCreated_at() {
        return created_at;

    }
}
