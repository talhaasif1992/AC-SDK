package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class Prescription implements Parcelable{
    private String id;

    private String updated_at;

    private String prescription_pdflink;

    private String prescription_uid;

    private String doctor_sitting_id;

    private String doctor_id;

    private String created_at;

    private String patient_id;

    private String consultation_id;
    private ArrayList<APrescription> prescriptions_object;

    public ArrayList<APrescription> getPrescriptions_object() {
        return prescriptions_object;
    }

    public void setPrescriptions_object(ArrayList<APrescription> prescriptions_object) {
        this.prescriptions_object = prescriptions_object;
    }

    protected Prescription(Parcel in) {
        id = in.readString();
        updated_at = in.readString();
        prescription_pdflink = in.readString();
        prescription_uid = in.readString();
        doctor_sitting_id = in.readString();
        doctor_id = in.readString();
        created_at = in.readString();
        patient_id = in.readString();
        consultation_id = in.readString();
        prescriptions_object = in.createTypedArrayList(APrescription.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(updated_at);
        dest.writeString(prescription_pdflink);
        dest.writeString(prescription_uid);
        dest.writeString(doctor_sitting_id);
        dest.writeString(doctor_id);
        dest.writeString(created_at);
        dest.writeString(patient_id);
        dest.writeString(consultation_id);
        dest.writeTypedList(prescriptions_object);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Prescription> CREATOR = new Creator<Prescription>() {
        @Override
        public Prescription createFromParcel(Parcel in) {
            return new Prescription(in);
        }

        @Override
        public Prescription[] newArray(int size) {
            return new Prescription[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPrescription_pdflink() {
        return prescription_pdflink;
    }

    public void setPrescription_pdflink(String prescription_pdflink) {
        this.prescription_pdflink = prescription_pdflink;
    }

    public String getPrescription_uid() {
        return prescription_uid;
    }

    public void setPrescription_uid(String prescription_uid) {
        this.prescription_uid = prescription_uid;
    }

    public String getDoctor_sitting_id() {
        return doctor_sitting_id;
    }

    public void setDoctor_sitting_id(String doctor_sitting_id) {
        this.doctor_sitting_id = doctor_sitting_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }



}
