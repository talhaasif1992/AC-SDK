package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class ConsultationDetail implements Parcelable {
    private ASlot slot;
    private UserInfo user_info;
    private SickNotesInfo sick_notes;
    private long user_role_id;
    private ArrayList<LabTest> reportsList;
    private long consultation_id;
    private SOAPNotes soapnotes;
    private ArrayList<HealthPoint> health_points;
    private Prescription prescription;
    private ANote patient_notes;
    private ANote doctor_notes;
    private ConsultationsSpec consultation_object;
    private ArrayList<Report> requestedReports;
    private String channel_key;
    private String doctor_sitting_id;
    private Loc location;
    private ALocation institute_info;
    private String medical_practice_id;
    private String pic;

    protected ConsultationDetail(Parcel in) {
        slot = in.readParcelable(ASlot.class.getClassLoader());
        user_info = in.readParcelable(UserInfo.class.getClassLoader());
        sick_notes = in.readParcelable(SickNotesInfo.class.getClassLoader());
        user_role_id = in.readLong();
        reportsList = in.createTypedArrayList(LabTest.CREATOR);
        consultation_id = in.readLong();
        soapnotes = in.readParcelable(SOAPNotes.class.getClassLoader());
        health_points = in.createTypedArrayList(HealthPoint.CREATOR);
        prescription = in.readParcelable(Prescription.class.getClassLoader());
        patient_notes = in.readParcelable(ANote.class.getClassLoader());
        doctor_notes = in.readParcelable(ANote.class.getClassLoader());
        consultation_object = in.readParcelable(ConsultationsSpec.class.getClassLoader());
        requestedReports = in.createTypedArrayList(Report.CREATOR);
        channel_key = in.readString();
        pic = in.readString();
        doctor_sitting_id = in.readString();
        medical_practice_id = in.readString();
        location = in.readParcelable(Loc.class.getClassLoader());
        institute_info = in.readParcelable(ALocation.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(slot, flags);
        dest.writeParcelable(user_info, flags);
        dest.writeParcelable(sick_notes, flags);
        dest.writeLong(user_role_id);
        dest.writeTypedList(reportsList);
        dest.writeLong(consultation_id);
        dest.writeParcelable(soapnotes, flags);
        dest.writeTypedList(health_points);
        dest.writeParcelable(prescription, flags);
        dest.writeParcelable(patient_notes, flags);
        dest.writeParcelable(doctor_notes, flags);
        dest.writeParcelable(consultation_object, flags);
        dest.writeTypedList(requestedReports);
        dest.writeString(channel_key);
        dest.writeString(doctor_sitting_id);
        dest.writeString(medical_practice_id);
        dest.writeParcelable(location, flags);
        dest.writeParcelable(institute_info, flags);
        dest.writeString(pic);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConsultationDetail> CREATOR = new Creator<ConsultationDetail>() {
        @Override
        public ConsultationDetail createFromParcel(Parcel in) {
            return new ConsultationDetail(in);
        }

        @Override
        public ConsultationDetail[] newArray(int size) {
            return new ConsultationDetail[size];
        }
    };

    public ASlot getSlot() {
        return slot;
    }

    public void setSlot(ASlot slot) {
        this.slot = slot;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public SickNotesInfo getSick_notes() {
        return sick_notes;
    }

    public void setSick_notes(SickNotesInfo sick_notes) {
        this.sick_notes = sick_notes;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }

    public long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public ArrayList<LabTest> getReportsList() {
        return reportsList;
    }

    public void setReportsList(ArrayList<LabTest> reportsList) {
        this.reportsList = reportsList;
    }

    public long getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(long consultation_id) {
        this.consultation_id = consultation_id;
    }

    public SOAPNotes getSoapnotes() {
        return soapnotes;
    }

    public void setSoapnotes(SOAPNotes soapnotes) {
        this.soapnotes = soapnotes;
    }

    public ArrayList<HealthPoint> getHealth_points() {
        return health_points;
    }

    public void setHealth_points(ArrayList<HealthPoint> health_points) {
        this.health_points = health_points;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public ANote getPatient_notes() {
        return patient_notes;
    }

    public void setPatient_notes(ANote patient_notes) {
        this.patient_notes = patient_notes;
    }

    public ANote getDoctor_notes() {
        return doctor_notes;
    }

    public void setDoctor_notes(ANote doctor_notes) {
        this.doctor_notes = doctor_notes;
    }

    public ConsultationsSpec getConsultation_object() {
        return consultation_object;
    }

    public void setConsultation_object(ConsultationsSpec consultation_object) {
        this.consultation_object = consultation_object;
    }

    public ArrayList<Report> getRequestedReports() {
        return requestedReports;
    }

    public void setRequestedReports(ArrayList<Report> requestedReports) {
        this.requestedReports = requestedReports;
    }

    public String getChannel_key() {
        return channel_key;
    }

    public void setChannel_key(String channel_key) {
        this.channel_key = channel_key;
    }

    public Loc getLocation() {
        return location;
    }

    public void setLocation(Loc location) {
        this.location = location;
    }

    public String getDoctor_sitting_id() {
        return doctor_sitting_id;
    }

    public void setDoctor_sitting_id(String doctor_sitting_id) {
        this.doctor_sitting_id = doctor_sitting_id;
    }

    public ALocation getInstitute_info() {
        return institute_info;
    }

    public void setInstitute_info(ALocation institute_info) {
        this.institute_info = institute_info;
    }

    public String getMedical_practice_id() {
        return medical_practice_id;
    }

    public void setMedical_practice_id(String medical_practice_id) {
        this.medical_practice_id = medical_practice_id;
    }

    /*public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }*/
}
