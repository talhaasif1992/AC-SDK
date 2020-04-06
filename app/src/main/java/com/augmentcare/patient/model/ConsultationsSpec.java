package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class ConsultationsSpec implements Parcelable{
    private String completed_at;

    private String doctor_id;

    private String user_notes;

    private String consultation_duration;

    private String doctor_email_address;

    private String feedback_submitted;

    private String consultation_date;

    private String messages;

    private String symptom_id;

    private String id;

    private String patient_email_address;

    private String updated_at;

    private String in_progress;

    private String request_slot_id;

    private String started_at;

    private String prescription_submitted;

    private String soap_note_id;

    private String created_at;

    private String patient_id;

    private String prescription_id;

    private String docter_notes;

    private String completed;
    private String sign_and_symptoms;
    private String diagnosis_notes;

    public String getSign_and_symptoms() {
        return sign_and_symptoms;
    }

    public void setSign_and_symptoms(String sign_and_symptoms) {
        this.sign_and_symptoms = sign_and_symptoms;
    }

    public String getDiagnosis_notes() {
        return diagnosis_notes;
    }

    public void setDiagnosis_notes(String diagnosis_notes) {
        this.diagnosis_notes = diagnosis_notes;
    }

    protected ConsultationsSpec(Parcel in) {
        completed_at = in.readString();
        doctor_id = in.readString();
        user_notes = in.readString();
        consultation_duration = in.readString();
        doctor_email_address = in.readString();
        feedback_submitted = in.readString();
        consultation_date = in.readString();
        messages = in.readString();
        symptom_id = in.readString();
        id = in.readString();
        patient_email_address = in.readString();
        updated_at = in.readString();
        in_progress = in.readString();
        request_slot_id = in.readString();
        started_at = in.readString();
        prescription_submitted = in.readString();
        soap_note_id = in.readString();
        created_at = in.readString();
        patient_id = in.readString();
        prescription_id = in.readString();
        docter_notes = in.readString();
        completed = in.readString();
        sign_and_symptoms = in.readString();
        diagnosis_notes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(completed_at);
        dest.writeString(doctor_id);
        dest.writeString(user_notes);
        dest.writeString(consultation_duration);
        dest.writeString(doctor_email_address);
        dest.writeString(feedback_submitted);
        dest.writeString(consultation_date);
        dest.writeString(messages);
        dest.writeString(symptom_id);
        dest.writeString(id);
        dest.writeString(patient_email_address);
        dest.writeString(updated_at);
        dest.writeString(in_progress);
        dest.writeString(request_slot_id);
        dest.writeString(started_at);
        dest.writeString(prescription_submitted);
        dest.writeString(soap_note_id);
        dest.writeString(created_at);
        dest.writeString(patient_id);
        dest.writeString(prescription_id);
        dest.writeString(docter_notes);
        dest.writeString(completed);
        dest.writeString(sign_and_symptoms);
        dest.writeString(diagnosis_notes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConsultationsSpec> CREATOR = new Creator<ConsultationsSpec>() {
        @Override
        public ConsultationsSpec createFromParcel(Parcel in) {
            return new ConsultationsSpec(in);
        }

        @Override
        public ConsultationsSpec[] newArray(int size) {
            return new ConsultationsSpec[size];
        }
    };

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getUser_notes() {
        return user_notes;
    }

    public void setUser_notes(String user_notes) {
        this.user_notes = user_notes;
    }

    public String getConsultation_duration() {
        return consultation_duration;
    }

    public void setConsultation_duration(String consultation_duration) {
        this.consultation_duration = consultation_duration;
    }

    public String getDoctor_email_address() {
        return doctor_email_address;
    }

    public void setDoctor_email_address(String doctor_email_address) {
        this.doctor_email_address = doctor_email_address;
    }

    public String getFeedback_submitted() {
        return feedback_submitted;
    }

    public void setFeedback_submitted(String feedback_submitted) {
        this.feedback_submitted = feedback_submitted;
    }

    public String getConsultation_date() {
        return consultation_date;
    }

    public void setConsultation_date(String consultation_date) {
        this.consultation_date = consultation_date;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(String symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_email_address() {
        return patient_email_address;
    }

    public void setPatient_email_address(String patient_email_address) {
        this.patient_email_address = patient_email_address;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getIn_progress() {
        return in_progress;
    }

    public void setIn_progress(String in_progress) {
        this.in_progress = in_progress;
    }

    public String getRequest_slot_id() {
        return request_slot_id;
    }

    public void setRequest_slot_id(String request_slot_id) {
        this.request_slot_id = request_slot_id;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getPrescription_submitted() {
        return prescription_submitted;
    }

    public void setPrescription_submitted(String prescription_submitted) {
        this.prescription_submitted = prescription_submitted;
    }

    public String getSoap_note_id() {
        return soap_note_id;
    }

    public void setSoap_note_id(String soap_note_id) {
        this.soap_note_id = soap_note_id;
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

    public String getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(String prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getDocter_notes() {
        return docter_notes;
    }

    public void setDocter_notes(String docter_notes) {
        this.docter_notes = docter_notes;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

}
