
package com.augmentcare.patient.model.prescriptionModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("institute_info")
    @Expose
    private Object instituteInfo;

    @SerializedName("medical_practice_id")
    @Expose
    private Object medicalPracticeId;

    @SerializedName("doctor_sitting_id")
    @Expose
    private Object doctorSittingId;

    @SerializedName("slot")
    @Expose
    private Slot slot;

    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;

    @SerializedName("reportsList")
    @Expose
    private List<Object> reportsList = null;

    @SerializedName("email_text")
    @Expose
    private String emailText;

    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = null;

    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;

    @SerializedName("consultation_object")
    @Expose
    private ConsultationObject consultationObject;

    @SerializedName("symptoms")
    @Expose
    private Object symptoms;

    @SerializedName("prescription")
    @Expose
    private Prescription prescription;

    @SerializedName("soapnotes")
    @Expose
    private Object soapnotes;

    @SerializedName("health_points")
    @Expose
    private List<Object> healthPoints = null;

    @SerializedName("patient_notes")
    @Expose
    private Object patientNotes;

    @SerializedName("doctor_notes")
    @Expose
    private Object doctorNotes;

    @SerializedName("requestedReports")
    @Expose
    private List<RequestedReport> requestedReports = null;

    @SerializedName("channel_key")
    @Expose
    private String channelKey;

    @SerializedName("pic")
    @Expose
    private String pic;

    @SerializedName("video_data")
    @Expose
    private VideoData videoData;

    @SerializedName("sick_notes")
    @Expose
    private SickNotes sickNotes;

    @SerializedName("doctors_settings")
    @Expose
    private Object doctorsSettings;

    @SerializedName("primary_user")
    @Expose
    private PrimaryUser primaryUser;

    public Object getInstituteInfo() {
        return instituteInfo;
    }

    public void setInstituteInfo(Object instituteInfo) {
        this.instituteInfo = instituteInfo;
    }

    public Object getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Object medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public Object getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Object doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public List<Object> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<Object> reportsList) {
        this.reportsList = reportsList;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public ConsultationObject getConsultationObject() {
        return consultationObject;
    }

    public void setConsultationObject(ConsultationObject consultationObject) {
        this.consultationObject = consultationObject;
    }

    public Object getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Object symptoms) {
        this.symptoms = symptoms;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Object getSoapnotes() {
        return soapnotes;
    }

    public void setSoapnotes(Object soapnotes) {
        this.soapnotes = soapnotes;
    }

    public List<Object> getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(List<Object> healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Object getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(Object patientNotes) {
        this.patientNotes = patientNotes;
    }

    public Object getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(Object doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public List<RequestedReport> getRequestedReports() {
        return requestedReports;
    }

    public void setRequestedReports(List<RequestedReport> requestedReports) {
        this.requestedReports = requestedReports;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public VideoData getVideoData() {
        return videoData;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    public SickNotes getSickNotes() {
        return sickNotes;
    }

    public void setSickNotes(SickNotes sickNotes) {
        this.sickNotes = sickNotes;
    }

    public Object getDoctorsSettings() {
        return doctorsSettings;
    }

    public void setDoctorsSettings(Object doctorsSettings) {
        this.doctorsSettings = doctorsSettings;
    }

    public PrimaryUser getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(PrimaryUser primaryUser) {
        this.primaryUser = primaryUser;
    }

}
