package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.augmentcare.patient.enums.APPOINTMENT_STATUS;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ConsultationDetails implements Parcelable {

    @SerializedName("institute_info")
    @Expose
    private InstituteInfo instituteInfo;
    @SerializedName("medical_practice_id")
    @Expose
    private Integer medicalPracticeId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Integer doctorSittingId;
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
    private List<LabTest> reportsList = new ArrayList<LabTest>();
    @SerializedName("email_text")
    @Expose
    private String emailText;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = new ArrayList<Object>();
    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;
    @SerializedName("consultation_object")
    @Expose
    private ConsultationObject consultationObject;
    @SerializedName("symptoms")
    @Expose
    private String symptoms;
    @SerializedName("prescription")
    @Expose
    private PrescriptionDetail prescription;
    @SerializedName("soapnotes")
    @Expose
    private String soapnotes;
    @SerializedName("health_points")
    @Expose
    private List<Object> healthPoints = new ArrayList<Object>();
    @SerializedName("patient_notes")
    @Expose
    private String patientNotes;
    @SerializedName("doctor_notes")
    @Expose
    private String doctorNotes;
    @SerializedName("requestedReports")
    @Expose
    private List<RequestedReports> requestedReports = new ArrayList<RequestedReports>();
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
    private Sicknotes sickNotes;
    @SerializedName("doctors_settings")
    @Expose
    private String doctorsSettings;
    @SerializedName("show_doctor_checklist")
    @Expose
    private Boolean showDoctorChecklist;
    @SerializedName("allow_medicine_heading")
    @Expose
    private Boolean allowMedicineHeading;
    @SerializedName("doctor_fullname")
    @Expose
    private String doctorFullname;
    @SerializedName("primary_user")
    @Expose
    private PrimaryUser primaryUser;
    public final static Parcelable.Creator<ConsultationDetails> CREATOR = new Creator<ConsultationDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ConsultationDetails createFromParcel(Parcel in) {
            return new ConsultationDetails(in);
        }

        public ConsultationDetails[] newArray(int size) {
            return (new ConsultationDetails[size]);
        }

    };

    protected ConsultationDetails(Parcel in) {
        this.instituteInfo = ((InstituteInfo) in.readValue((InstituteInfo.class.getClassLoader())));
        this.medicalPracticeId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doctorSittingId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.slot = ((Slot) in.readValue((Slot.class.getClassLoader())));
        this.userInfo = ((UserInfo) in.readValue((UserInfo.class.getClassLoader())));
        this.userRoleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.reportsList, (LabTest.class.getClassLoader()));
        this.emailText = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.attachments, (java.lang.Object.class.getClassLoader()));
        this.consultationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.consultationObject = ((ConsultationObject) in.readValue((ConsultationObject.class.getClassLoader())));
        this.symptoms = ((String) in.readValue((String.class.getClassLoader())));
        this.prescription = (PrescriptionDetail) in.readValue(PrescriptionDetail.class.getClassLoader());
        this.soapnotes = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.healthPoints, (java.lang.Object.class.getClassLoader()));
        this.patientNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorNotes = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.requestedReports, (RequestedReports.class.getClassLoader()));
        this.channelKey = ((String) in.readValue((String.class.getClassLoader())));
        this.pic = ((String) in.readValue((String.class.getClassLoader())));
        this.videoData = ((VideoData) in.readValue((VideoData.class.getClassLoader())));
        this.sickNotes = ((Sicknotes) in.readValue((Sicknotes.class.getClassLoader())));
        this.doctorsSettings = ((String) in.readValue((String.class.getClassLoader())));
        this.showDoctorChecklist = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.allowMedicineHeading = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.doctorFullname = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryUser = ((PrimaryUser) in.readValue((PrimaryUser.class.getClassLoader())));
    }

    public ConsultationDetails() {
    }

    public int getStatus() {
        if (slot != null) {
            if ((slot.getSlotStatus() != null && slot.getSlotStatus().contains("prescription_submitted")) ||
                    (slot.getCompleted() != null && slot.getCompleted())) {
                return APPOINTMENT_STATUS.COMPLETED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("cancelled_by_patient")) {
                return APPOINTMENT_STATUS.CANCELED;
            } else if ((slot.getSlotStatus() != null && slot.getSlotStatus().contains("cancelled_by_doctor")) ||
                    (slot.getRejected() != null && slot.getRejected())) {
                return APPOINTMENT_STATUS.REJECTED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("approved")) {
                return APPOINTMENT_STATUS.APPROVED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("pending")) {
                return APPOINTMENT_STATUS.PENDING;
            } else {
                return APPOINTMENT_STATUS.UNKNOWN;
            }
        }else{
            return APPOINTMENT_STATUS.UNKNOWN;
        }
    }

    public void setStatus(@APPOINTMENT_STATUS.AppointmentStatusType int slotStatus){
        switch (slotStatus){
            case APPOINTMENT_STATUS.APPROVED:
            case APPOINTMENT_STATUS.UPCOMMING:
                slot.setSlotStatus("approved");
                break;
            case APPOINTMENT_STATUS.COMPLETED:
                slot.setSlotStatus("prescription_submitted");
                break;
            case APPOINTMENT_STATUS.CANCELED:
                slot.setSlotStatus("cancelled_by_patient");
                break;
            case APPOINTMENT_STATUS.PENDING:
                slot.setSlotStatus("pending");
                break;
            case APPOINTMENT_STATUS.REJECTED:
                slot.setSlotStatus("cancelled_by_doctor");
                break;
            case APPOINTMENT_STATUS.UNKNOWN:
                slot.setSlotStatus("");
                break;
        }
    }

    public InstituteInfo getInstituteInfo() {
        return instituteInfo;
    }

    public void setInstituteInfo(InstituteInfo instituteInfo) {
        this.instituteInfo = instituteInfo;
    }

    public ConsultationDetails withInstituteInfo(InstituteInfo instituteInfo) {
        this.instituteInfo = instituteInfo;
        return this;
    }

    public Integer getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Integer medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public ConsultationDetails withMedicalPracticeId(Integer medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    public Integer getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Integer doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public ConsultationDetails withDoctorSittingId(Integer doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ConsultationDetails withSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ConsultationDetails withUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public ConsultationDetails withUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public List<LabTest> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<LabTest> reportsList) {
        this.reportsList = reportsList;
    }

    public ConsultationDetails withReportsList(List<LabTest> reportsList) {
        this.reportsList = reportsList;
        return this;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public ConsultationDetails withEmailText(String emailText) {
        this.emailText = emailText;
        return this;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public ConsultationDetails withAttachments(List<Object> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public ConsultationDetails withConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
        return this;
    }

    public ConsultationObject getConsultationObject() {
        return consultationObject;
    }

    public void setConsultationObject(ConsultationObject consultationObject) {
        this.consultationObject = consultationObject;
    }

    public ConsultationDetails withConsultationObject(ConsultationObject consultationObject) {
        this.consultationObject = consultationObject;
        return this;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public ConsultationDetails withSymptoms(String symptoms) {
        this.symptoms = symptoms;
        return this;
    }

    public PrescriptionDetail getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDetail prescription) {
        this.prescription = prescription;
    }

    public ConsultationDetails withPrescription(PrescriptionDetail prescription) {
        this.prescription = prescription;
        return this;
    }

    public String getSoapnotes() {
        return soapnotes;
    }

    public void setSoapnotes(String soapnotes) {
        this.soapnotes = soapnotes;
    }

    public ConsultationDetails withSoapnotes(String soapnotes) {
        this.soapnotes = soapnotes;
        return this;
    }

    public List<Object> getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(List<Object> healthPoints) {
        this.healthPoints = healthPoints;
    }

    public ConsultationDetails withHealthPoints(List<Object> healthPoints) {
        this.healthPoints = healthPoints;
        return this;
    }

    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }

    public ConsultationDetails withPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
        return this;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public ConsultationDetails withDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
        return this;
    }

    public List<RequestedReports> getRequestedReports() {
        return requestedReports;
    }

    public void setRequestedReports(List<RequestedReports> requestedReports) {
        this.requestedReports = requestedReports;
    }

    public ConsultationDetails withRequestedReports(List<RequestedReports> requestedReports) {
        this.requestedReports = requestedReports;
        return this;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public ConsultationDetails withChannelKey(String channelKey) {
        this.channelKey = channelKey;
        return this;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public ConsultationDetails withPic(String pic) {
        this.pic = pic;
        return this;
    }

    public VideoData getVideoData() {
        return videoData;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    public ConsultationDetails withVideoData(VideoData videoData) {
        this.videoData = videoData;
        return this;
    }

    public Sicknotes getSickNotes() {
        return sickNotes;
    }

    public void setSickNotes(Sicknotes sickNotes) {
        this.sickNotes = sickNotes;
    }

    public ConsultationDetails withSickNotes(Sicknotes sickNotes) {
        this.sickNotes = sickNotes;
        return this;
    }

    public String getDoctorsSettings() {
        return doctorsSettings;
    }

    public void setDoctorsSettings(String doctorsSettings) {
        this.doctorsSettings = doctorsSettings;
    }

    public ConsultationDetails withDoctorsSettings(String doctorsSettings) {
        this.doctorsSettings = doctorsSettings;
        return this;
    }

    public Boolean getShowDoctorChecklist() {
        return showDoctorChecklist;
    }

    public void setShowDoctorChecklist(Boolean showDoctorChecklist) {
        this.showDoctorChecklist = showDoctorChecklist;
    }

    public ConsultationDetails withShowDoctorChecklist(Boolean showDoctorChecklist) {
        this.showDoctorChecklist = showDoctorChecklist;
        return this;
    }

    public Boolean getAllowMedicineHeading() {
        return allowMedicineHeading;
    }

    public void setAllowMedicineHeading(Boolean allowMedicineHeading) {
        this.allowMedicineHeading = allowMedicineHeading;
    }

    public ConsultationDetails withAllowMedicineHeading(Boolean allowMedicineHeading) {
        this.allowMedicineHeading = allowMedicineHeading;
        return this;
    }

    public String getDoctorFullname() {
        return doctorFullname;
    }

    public void setDoctorFullname(String doctorFullname) {
        this.doctorFullname = doctorFullname;
    }

    public ConsultationDetails withDoctorFullname(String doctorFullname) {
        this.doctorFullname = doctorFullname;
        return this;
    }

    public PrimaryUser getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(PrimaryUser primaryUser) {
        this.primaryUser = primaryUser;
    }

    public ConsultationDetails withPrimaryUser(PrimaryUser primaryUser) {
        this.primaryUser = primaryUser;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("instituteInfo", instituteInfo).append("medicalPracticeId", medicalPracticeId).append("doctorSittingId", doctorSittingId).append("slot", slot).append("userInfo", userInfo).append("userRoleId", userRoleId).append("reportsList", reportsList).append("emailText", emailText).append("attachments", attachments).append("consultationId", consultationId).append("consultationObject", consultationObject).append("symptoms", symptoms).append("prescription", prescription).append("soapnotes", soapnotes).append("healthPoints", healthPoints).append("patientNotes", patientNotes).append("doctorNotes", doctorNotes).append("requestedReports", requestedReports).append("channelKey", channelKey).append("pic", pic).append("videoData", videoData).append("sickNotes", sickNotes).append("doctorsSettings", doctorsSettings).append("showDoctorChecklist", showDoctorChecklist).append("allowMedicineHeading", allowMedicineHeading).append("doctorFullname", doctorFullname).append("primaryUser", primaryUser).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(instituteInfo);
        dest.writeValue(medicalPracticeId);
        dest.writeValue(doctorSittingId);
        dest.writeValue(slot);
        dest.writeValue(userInfo);
        dest.writeValue(userRoleId);
        dest.writeList(reportsList);
        dest.writeValue(emailText);
        dest.writeList(attachments);
        dest.writeValue(consultationId);
        dest.writeValue(consultationObject);
        dest.writeValue(symptoms);
        dest.writeValue(prescription);
        dest.writeValue(soapnotes);
        dest.writeList(healthPoints);
        dest.writeValue(patientNotes);
        dest.writeValue(doctorNotes);
        dest.writeList(requestedReports);
        dest.writeValue(channelKey);
        dest.writeValue(pic);
        dest.writeValue(videoData);
        dest.writeValue(sickNotes);
        dest.writeValue(doctorsSettings);
        dest.writeValue(showDoctorChecklist);
        dest.writeValue(allowMedicineHeading);
        dest.writeValue(doctorFullname);
        dest.writeValue(primaryUser);
    }

    public int describeContents() {
        return 0;
    }

}