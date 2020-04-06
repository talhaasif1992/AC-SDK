package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ConsultationObject implements Parcelable {

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
    private String userNotes;
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
    private String messages;
    @SerializedName("symptom_id")
    @Expose
    private Integer symptomId;
    @SerializedName("soap_note_id")
    @Expose
    private Integer soapNoteId;
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
    private String consultationDuration;
    @SerializedName("started_at")
    @Expose
    private String startedAt;
    @SerializedName("completed_at")
    @Expose
    private String completedAt;
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
    private String personalNotes;
    @SerializedName("is_follow_up_requested")
    @Expose
    private Boolean isFollowUpRequested;
    @SerializedName("follow_up_reason")
    @Expose
    private String followUpReason;
    @SerializedName("follow_up_time")
    @Expose
    private String followUpTime;
    @SerializedName("diet_notes")
    @Expose
    private String dietNotes;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_comments")
    @Expose
    private String ratingComments;
    @SerializedName("systematic_notes")
    @Expose
    private String systematicNotes;
    @SerializedName("investigation_notes")
    @Expose
    private String investigationNotes;
    @SerializedName("differential_notes")
    @Expose
    private String differentialNotes;
    @SerializedName("provisional_notes")
    @Expose
    private String provisionalNotes;
    @SerializedName("instruction_for_patient")
    @Expose
    private String instructionForPatient;
    @SerializedName("follow_up_date")
    @Expose
    private String followUpDate;
//    @SerializedName("custom_fields")
//    @Expose
//    private String customFields;
    @SerializedName("dr_rating_to_patient")
    @Expose
    private String drRatingToPatient;
    @SerializedName("dr_video_quality_rating")
    @Expose
    private String drVideoQualityRating;
    @SerializedName("dr_rating_comment")
    @Expose
    private String drRatingComment;
    @SerializedName("dr_rating_tag")
    @Expose
    private String drRatingTag;
    public final static Parcelable.Creator<ConsultationObject> CREATOR = new Creator<ConsultationObject>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ConsultationObject createFromParcel(Parcel in) {
            return new ConsultationObject(in);
        }

        public ConsultationObject[] newArray(int size) {
            return (new ConsultationObject[size]);
        }

    };

    protected ConsultationObject(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doctorId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.patientId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.docterNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.prescriptionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.requestSlotId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.consultationDate = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.messages = ((String) in.readValue((String.class.getClassLoader())));
        this.symptomId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.soapNoteId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.feedbackSubmitted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.prescriptionSubmitted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.completed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.doctorEmailAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.patientEmailAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.inProgress = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.consultationDuration = ((String) in.readValue((String.class.getClassLoader())));
        this.startedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.completedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.patientComplaints = ((String) in.readValue((String.class.getClassLoader())));
        this.signAndSymptoms = ((String) in.readValue((String.class.getClassLoader())));
        this.diagnosisNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.personalNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.isFollowUpRequested = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.followUpReason = ((String) in.readValue((String.class.getClassLoader())));
        this.followUpTime = ((String) in.readValue((String.class.getClassLoader())));
        this.dietNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((Double) in.readValue((Double.class.getClassLoader())));
        this.ratingComments = ((String) in.readValue((String.class.getClassLoader())));
        this.systematicNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.investigationNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.differentialNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.provisionalNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.instructionForPatient = ((String) in.readValue((String.class.getClassLoader())));
        this.followUpDate = ((String) in.readValue((String.class.getClassLoader())));
//        this.customFields = ((String) in.readValue((String.class.getClassLoader())));
        this.drRatingToPatient = ((String) in.readValue((String.class.getClassLoader())));
        this.drVideoQualityRating = ((String) in.readValue((String.class.getClassLoader())));
        this.drRatingComment = ((String) in.readValue((String.class.getClassLoader())));
        this.drRatingTag = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ConsultationObject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsultationObject withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public ConsultationObject withDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public ConsultationObject withPatientId(Integer patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    public ConsultationObject withUserNotes(String userNotes) {
        this.userNotes = userNotes;
        return this;
    }

    public String getDocterNotes() {
        return docterNotes;
    }

    public void setDocterNotes(String docterNotes) {
        this.docterNotes = docterNotes;
    }

    public ConsultationObject withDocterNotes(String docterNotes) {
        this.docterNotes = docterNotes;
        return this;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public ConsultationObject withPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
        return this;
    }

    public Integer getRequestSlotId() {
        return requestSlotId;
    }

    public void setRequestSlotId(Integer requestSlotId) {
        this.requestSlotId = requestSlotId;
    }

    public ConsultationObject withRequestSlotId(Integer requestSlotId) {
        this.requestSlotId = requestSlotId;
        return this;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public ConsultationObject withConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ConsultationObject withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ConsultationObject withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public ConsultationObject withMessages(String messages) {
        this.messages = messages;
        return this;
    }

    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public ConsultationObject withSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
        return this;
    }

    public Integer getSoapNoteId() {
        return soapNoteId;
    }

    public void setSoapNoteId(Integer soapNoteId) {
        this.soapNoteId = soapNoteId;
    }

    public ConsultationObject withSoapNoteId(Integer soapNoteId) {
        this.soapNoteId = soapNoteId;
        return this;
    }

    public Boolean getFeedbackSubmitted() {
        return feedbackSubmitted;
    }

    public void setFeedbackSubmitted(Boolean feedbackSubmitted) {
        this.feedbackSubmitted = feedbackSubmitted;
    }

    public ConsultationObject withFeedbackSubmitted(Boolean feedbackSubmitted) {
        this.feedbackSubmitted = feedbackSubmitted;
        return this;
    }

    public Boolean getPrescriptionSubmitted() {
        return prescriptionSubmitted;
    }

    public void setPrescriptionSubmitted(Boolean prescriptionSubmitted) {
        this.prescriptionSubmitted = prescriptionSubmitted;
    }

    public ConsultationObject withPrescriptionSubmitted(Boolean prescriptionSubmitted) {
        this.prescriptionSubmitted = prescriptionSubmitted;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public ConsultationObject withCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public String getDoctorEmailAddress() {
        return doctorEmailAddress;
    }

    public void setDoctorEmailAddress(String doctorEmailAddress) {
        this.doctorEmailAddress = doctorEmailAddress;
    }

    public ConsultationObject withDoctorEmailAddress(String doctorEmailAddress) {
        this.doctorEmailAddress = doctorEmailAddress;
        return this;
    }

    public String getPatientEmailAddress() {
        return patientEmailAddress;
    }

    public void setPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
    }

    public ConsultationObject withPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
        return this;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public ConsultationObject withInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
        return this;
    }

    public String getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(String consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public ConsultationObject withConsultationDuration(String consultationDuration) {
        this.consultationDuration = consultationDuration;
        return this;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public ConsultationObject withStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public ConsultationObject withCompletedAt(String completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    public String getPatientComplaints() {
        return patientComplaints;
    }

    public void setPatientComplaints(String patientComplaints) {
        this.patientComplaints = patientComplaints;
    }

    public ConsultationObject withPatientComplaints(String patientComplaints) {
        this.patientComplaints = patientComplaints;
        return this;
    }

    public String getSignAndSymptoms() {
        return signAndSymptoms;
    }

    public void setSignAndSymptoms(String signAndSymptoms) {
        this.signAndSymptoms = signAndSymptoms;
    }

    public ConsultationObject withSignAndSymptoms(String signAndSymptoms) {
        this.signAndSymptoms = signAndSymptoms;
        return this;
    }

    public String getDiagnosisNotes() {
        return diagnosisNotes;
    }

    public void setDiagnosisNotes(String diagnosisNotes) {
        this.diagnosisNotes = diagnosisNotes;
    }

    public ConsultationObject withDiagnosisNotes(String diagnosisNotes) {
        this.diagnosisNotes = diagnosisNotes;
        return this;
    }

    public String getPersonalNotes() {
        return personalNotes;
    }

    public void setPersonalNotes(String personalNotes) {
        this.personalNotes = personalNotes;
    }

    public ConsultationObject withPersonalNotes(String personalNotes) {
        this.personalNotes = personalNotes;
        return this;
    }

    public Boolean getIsFollowUpRequested() {
        return isFollowUpRequested;
    }

    public void setIsFollowUpRequested(Boolean isFollowUpRequested) {
        this.isFollowUpRequested = isFollowUpRequested;
    }

    public ConsultationObject withIsFollowUpRequested(Boolean isFollowUpRequested) {
        this.isFollowUpRequested = isFollowUpRequested;
        return this;
    }

    public String getFollowUpReason() {
        return followUpReason;
    }

    public void setFollowUpReason(String followUpReason) {
        this.followUpReason = followUpReason;
    }

    public ConsultationObject withFollowUpReason(String followUpReason) {
        this.followUpReason = followUpReason;
        return this;
    }

    public String getFollowUpTime() {
        return followUpTime;
    }

    public void setFollowUpTime(String followUpTime) {
        this.followUpTime = followUpTime;
    }

    public ConsultationObject withFollowUpTime(String followUpTime) {
        this.followUpTime = followUpTime;
        return this;
    }

    public String getDietNotes() {
        return dietNotes;
    }

    public void setDietNotes(String dietNotes) {
        this.dietNotes = dietNotes;
    }

    public ConsultationObject withDietNotes(String dietNotes) {
        this.dietNotes = dietNotes;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ConsultationObject withRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getRatingComments() {
        return ratingComments;
    }

    public void setRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
    }

    public ConsultationObject withRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
        return this;
    }

    public String getSystematicNotes() {
        return systematicNotes;
    }

    public void setSystematicNotes(String systematicNotes) {
        this.systematicNotes = systematicNotes;
    }

    public ConsultationObject withSystematicNotes(String systematicNotes) {
        this.systematicNotes = systematicNotes;
        return this;
    }

    public String getInvestigationNotes() {
        return investigationNotes;
    }

    public void setInvestigationNotes(String investigationNotes) {
        this.investigationNotes = investigationNotes;
    }

    public ConsultationObject withInvestigationNotes(String investigationNotes) {
        this.investigationNotes = investigationNotes;
        return this;
    }

    public String getDifferentialNotes() {
        return differentialNotes;
    }

    public void setDifferentialNotes(String differentialNotes) {
        this.differentialNotes = differentialNotes;
    }

    public ConsultationObject withDifferentialNotes(String differentialNotes) {
        this.differentialNotes = differentialNotes;
        return this;
    }

    public String getProvisionalNotes() {
        return provisionalNotes;
    }

    public void setProvisionalNotes(String provisionalNotes) {
        this.provisionalNotes = provisionalNotes;
    }

    public ConsultationObject withProvisionalNotes(String provisionalNotes) {
        this.provisionalNotes = provisionalNotes;
        return this;
    }

    public String getInstructionForPatient() {
        return instructionForPatient;
    }

    public void setInstructionForPatient(String instructionForPatient) {
        this.instructionForPatient = instructionForPatient;
    }

    public ConsultationObject withInstructionForPatient(String instructionForPatient) {
        this.instructionForPatient = instructionForPatient;
        return this;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public ConsultationObject withFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
        return this;
    }

//    public String getCustomFields() {
//        return customFields;
//    }
//
//    public void setCustomFields(String customFields) {
//        this.customFields = customFields;
//    }
//
//    public ConsultationObject withCustomFields(String customFields) {
//        this.customFields = customFields;
//        return this;
//    }

    public String getDrRatingToPatient() {
        return drRatingToPatient;
    }

    public void setDrRatingToPatient(String drRatingToPatient) {
        this.drRatingToPatient = drRatingToPatient;
    }

    public ConsultationObject withDrRatingToPatient(String drRatingToPatient) {
        this.drRatingToPatient = drRatingToPatient;
        return this;
    }

    public String getDrVideoQualityRating() {
        return drVideoQualityRating;
    }

    public void setDrVideoQualityRating(String drVideoQualityRating) {
        this.drVideoQualityRating = drVideoQualityRating;
    }

    public ConsultationObject withDrVideoQualityRating(String drVideoQualityRating) {
        this.drVideoQualityRating = drVideoQualityRating;
        return this;
    }

    public String getDrRatingComment() {
        return drRatingComment;
    }

    public void setDrRatingComment(String drRatingComment) {
        this.drRatingComment = drRatingComment;
    }

    public ConsultationObject withDrRatingComment(String drRatingComment) {
        this.drRatingComment = drRatingComment;
        return this;
    }

    public String getDrRatingTag() {
        return drRatingTag;
    }

    public void setDrRatingTag(String drRatingTag) {
        this.drRatingTag = drRatingTag;
    }

    public ConsultationObject withDrRatingTag(String drRatingTag) {
        this.drRatingTag = drRatingTag;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("doctorId", doctorId).append("patientId", patientId).append("userNotes", userNotes).append("docterNotes", docterNotes).append("prescriptionId", prescriptionId).append("requestSlotId", requestSlotId).append("consultationDate", consultationDate).append("createdAt", createdAt).append("updatedAt", updatedAt).append("messages", messages).append("symptomId", symptomId).append("soapNoteId", soapNoteId).append("feedbackSubmitted", feedbackSubmitted).append("prescriptionSubmitted", prescriptionSubmitted).append("completed", completed).append("doctorEmailAddress", doctorEmailAddress).append("patientEmailAddress", patientEmailAddress).append("inProgress", inProgress).append("consultationDuration", consultationDuration).append("startedAt", startedAt).append("completedAt", completedAt).append("patientComplaints", patientComplaints).append("signAndSymptoms", signAndSymptoms).append("diagnosisNotes", diagnosisNotes).append("personalNotes", personalNotes).append("isFollowUpRequested", isFollowUpRequested).append("followUpReason", followUpReason).append("followUpTime", followUpTime).append("dietNotes", dietNotes).append("rating", rating).append("ratingComments", ratingComments).append("systematicNotes", systematicNotes).append("investigationNotes", investigationNotes).append("differentialNotes", differentialNotes).append("provisionalNotes", provisionalNotes).append("instructionForPatient", instructionForPatient).append("followUpDate", followUpDate)
//                .append("customFields", customFields)
                .append("drRatingToPatient", drRatingToPatient).append("drVideoQualityRating", drVideoQualityRating).append("drRatingComment", drRatingComment).append("drRatingTag", drRatingTag).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(id);
        dest.writeValue(doctorId);
        dest.writeValue(patientId);
        dest.writeValue(userNotes);
        dest.writeValue(docterNotes);
        dest.writeValue(prescriptionId);
        dest.writeValue(requestSlotId);
        dest.writeValue(consultationDate);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(messages);
        dest.writeValue(symptomId);
        dest.writeValue(soapNoteId);
        dest.writeValue(feedbackSubmitted);
        dest.writeValue(prescriptionSubmitted);
        dest.writeValue(completed);
        dest.writeValue(doctorEmailAddress);
        dest.writeValue(patientEmailAddress);
        dest.writeValue(inProgress);
        dest.writeValue(consultationDuration);
        dest.writeValue(startedAt);
        dest.writeValue(completedAt);
        dest.writeValue(patientComplaints);
        dest.writeValue(signAndSymptoms);
        dest.writeValue(diagnosisNotes);
        dest.writeValue(personalNotes);
        dest.writeValue(isFollowUpRequested);
        dest.writeValue(followUpReason);
        dest.writeValue(followUpTime);
        dest.writeValue(dietNotes);
        dest.writeValue(rating);
        dest.writeValue(ratingComments);
        dest.writeValue(systematicNotes);
        dest.writeValue(investigationNotes);
        dest.writeValue(differentialNotes);
        dest.writeValue(provisionalNotes);
        dest.writeValue(instructionForPatient);
        dest.writeValue(followUpDate);
//        dest.writeValue(customFields);
        dest.writeValue(drRatingToPatient);
        dest.writeValue(drVideoQualityRating);
        dest.writeValue(drRatingComment);
        dest.writeValue(drRatingTag);
    }

    public int describeContents() {
        return 0;
    }

}