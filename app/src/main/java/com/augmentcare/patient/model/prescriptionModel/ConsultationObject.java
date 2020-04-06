
package com.augmentcare.patient.model.prescriptionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsultationObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("doctor_id")
    @Expose
    private Integer doctorId;
    @SerializedName("patient_id")
    @Expose
    private Integer patientId;
    @SerializedName("user_notes")
    @Expose
    private Object userNotes;
    @SerializedName("docter_notes")
    @Expose
    private String docterNotes;
    @SerializedName("prescription_id")
    @Expose
    private Integer prescriptionId;
    @SerializedName("request_slot_id")
    @Expose
    private Integer requestSlotId;
    @SerializedName("consultation_date")
    @Expose
    private String consultationDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("messages")
    @Expose
    private Object messages;
    @SerializedName("symptom_id")
    @Expose
    private Object symptomId;
    @SerializedName("soap_note_id")
    @Expose
    private Object soapNoteId;
    @SerializedName("feedback_submitted")
    @Expose
    private Boolean feedbackSubmitted;
    @SerializedName("prescription_submitted")
    @Expose
    private Boolean prescriptionSubmitted;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    @SerializedName("doctor_email_address")
    @Expose
    private String doctorEmailAddress;
    @SerializedName("patient_email_address")
    @Expose
    private String patientEmailAddress;
    @SerializedName("in_progress")
    @Expose
    private Boolean inProgress;
    @SerializedName("consultation_duration")
    @Expose
    private Object consultationDuration;
    @SerializedName("started_at")
    @Expose
    private Object startedAt;
    @SerializedName("completed_at")
    @Expose
    private Object completedAt;
    @SerializedName("patient_complaints")
    @Expose
    private String patientComplaints;
    @SerializedName("sign_and_symptoms")
    @Expose
    private String signAndSymptoms;
    @SerializedName("diagnosis_notes")
    @Expose
    private String diagnosisNotes;
    @SerializedName("personal_notes")
    @Expose
    private Object personalNotes;
    @SerializedName("is_follow_up_requested")
    @Expose
    private Boolean isFollowUpRequested;
    @SerializedName("follow_up_reason")
    @Expose
    private Object followUpReason;
    @SerializedName("follow_up_time")
    @Expose
    private Object followUpTime;
    @SerializedName("diet_notes")
    @Expose
    private String dietNotes;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("rating_comments")
    @Expose
    private String ratingComments;

    public Boolean getFollowUpRequested() {
        return isFollowUpRequested;
    }

    public void setFollowUpRequested(Boolean followUpRequested) {
        isFollowUpRequested = followUpRequested;
    }

    public String getInstructionsForPatient() {
        return instructionsForPatient;
    }

    public void setInstructionsForPatient(String instructionsForPatient) {
        this.instructionsForPatient = instructionsForPatient;
    }

    @SerializedName("instruction_for_patient")
    private String instructionsForPatient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Object getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(Object userNotes) {
        this.userNotes = userNotes;
    }

    public String getDocterNotes() {
        return docterNotes;
    }

    public void setDocterNotes(String docterNotes) {
        this.docterNotes = docterNotes;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getRequestSlotId() {
        return requestSlotId;
    }

    public void setRequestSlotId(Integer requestSlotId) {
        this.requestSlotId = requestSlotId;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getMessages() {
        return messages;
    }

    public void setMessages(Object messages) {
        this.messages = messages;
    }

    public Object getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Object symptomId) {
        this.symptomId = symptomId;
    }

    public Object getSoapNoteId() {
        return soapNoteId;
    }

    public void setSoapNoteId(Object soapNoteId) {
        this.soapNoteId = soapNoteId;
    }

    public Boolean getFeedbackSubmitted() {
        return feedbackSubmitted;
    }

    public void setFeedbackSubmitted(Boolean feedbackSubmitted) {
        this.feedbackSubmitted = feedbackSubmitted;
    }

    public Boolean getPrescriptionSubmitted() {
        return prescriptionSubmitted;
    }

    public void setPrescriptionSubmitted(Boolean prescriptionSubmitted) {
        this.prescriptionSubmitted = prescriptionSubmitted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDoctorEmailAddress() {
        return doctorEmailAddress;
    }

    public void setDoctorEmailAddress(String doctorEmailAddress) {
        this.doctorEmailAddress = doctorEmailAddress;
    }

    public String getPatientEmailAddress() {
        return patientEmailAddress;
    }

    public void setPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Object getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(Object consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public Object getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Object startedAt) {
        this.startedAt = startedAt;
    }

    public Object getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Object completedAt) {
        this.completedAt = completedAt;
    }

    public String getPatientComplaints() {
        return patientComplaints;
    }

    public void setPatientComplaints(String patientComplaints) {
        this.patientComplaints = patientComplaints;
    }

    public String getSignAndSymptoms() {
        return signAndSymptoms;
    }

    public void setSignAndSymptoms(String signAndSymptoms) {
        this.signAndSymptoms = signAndSymptoms;
    }

    public String getDiagnosisNotes() {
        return diagnosisNotes;
    }

    public void setDiagnosisNotes(String diagnosisNotes) {
        this.diagnosisNotes = diagnosisNotes;
    }

    public Object getPersonalNotes() {
        return personalNotes;
    }

    public void setPersonalNotes(Object personalNotes) {
        this.personalNotes = personalNotes;
    }

    public Boolean getIsFollowUpRequested() {
        return isFollowUpRequested;
    }

    public void setIsFollowUpRequested(Boolean isFollowUpRequested) {
        this.isFollowUpRequested = isFollowUpRequested;
    }

    public Object getFollowUpReason() {
        return followUpReason;
    }

    public void setFollowUpReason(Object followUpReason) {
        this.followUpReason = followUpReason;
    }

    public Object getFollowUpTime() {
        return followUpTime;
    }

    public void setFollowUpTime(Object followUpTime) {
        this.followUpTime = followUpTime;
    }

    public String getDietNotes() {
        return dietNotes;
    }

    public void setDietNotes(String dietNotes) {
        this.dietNotes = dietNotes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRatingComments() {
        return ratingComments;
    }

    public void setRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
    }

}
