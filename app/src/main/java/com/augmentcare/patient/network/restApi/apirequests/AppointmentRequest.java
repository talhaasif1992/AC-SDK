package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppointmentRequest implements Parcelable {

    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("doctor_id")
    @Expose
    private Long doctorId;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("type")
    @Expose
    private Boolean type;
    @SerializedName("location_id")
    @Expose
    private Long locationId;
    @SerializedName("date_time")
    @Expose
    private String dateTime;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Long doctorSittingId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("consultation_rate")
    @Expose
    private Long consultationRate;
    @SerializedName("patient_id")
    @Expose
    private Long patientId;
    @SerializedName("patient_firstName")
    @Expose
    private String patientFirstName;
    @SerializedName("patient_lastName")
    @Expose
    private String patientLastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("user_role_id")
    @Expose
    private Long userRoleId;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("institute_info")
    @Expose
    private String instituteInfo;
    @SerializedName("payment_id")
    @Expose
    private Long paymentId;
    @SerializedName("ice_uid")
    @Expose
    private Long iceUid;
    @SerializedName("medical_practice_id")
    @Expose
    private Long medicalPracticeId;
    public final static Parcelable.Creator<AppointmentRequest> CREATOR = new Creator<AppointmentRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AppointmentRequest createFromParcel(Parcel in) {
            return new AppointmentRequest(in);
        }

        public AppointmentRequest[] newArray(int size) {
            return (new AppointmentRequest[size]);
        }

    };

    protected AppointmentRequest(Parcel in) {
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.dateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorSittingId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.consultationRate = ((Long) in.readValue((Long.class.getClassLoader())));
        this.patientId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.patientFirstName = ((String) in.readValue((String.class.getClassLoader())));
        this.patientLastName = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.userRoleId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.available = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.instituteInfo = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.iceUid = ((Long) in.readValue((Long.class.getClassLoader())));
        this.medicalPracticeId = ((Long) in.readValue((Long.class.getClassLoader())));
    }

    public AppointmentRequest() {
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public AppointmentRequest withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public AppointmentRequest withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public AppointmentRequest withDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public AppointmentRequest withDay(String day) {
        this.day = day;
        return this;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public AppointmentRequest withType(Boolean type) {
        this.type = type;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public AppointmentRequest withLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public AppointmentRequest withDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Long getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Long doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public AppointmentRequest withDoctorSittingId(Long doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppointmentRequest withName(String name) {
        this.name = name;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppointmentRequest withMessage(String message) {
        this.message = message;
        return this;
    }

    public Long getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(Long consultationRate) {
        this.consultationRate = consultationRate;
    }

    public AppointmentRequest withConsultationRate(Long consultationRate) {
        this.consultationRate = consultationRate;
        return this;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public AppointmentRequest withPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public AppointmentRequest withPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
        return this;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public AppointmentRequest withPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppointmentRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public AppointmentRequest withUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public AppointmentRequest withAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AppointmentRequest withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public String getInstituteInfo() {
        return instituteInfo;
    }

    public void setInstituteInfo(String instituteInfo) {
        this.instituteInfo = instituteInfo;
    }

    public AppointmentRequest withInstituteInfo(String instituteInfo) {
        this.instituteInfo = instituteInfo;
        return this;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public AppointmentRequest withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Long getIceUid() {
        return iceUid;
    }

    public void setIceUid(Long iceUid) {
        this.iceUid = iceUid;
    }

    public AppointmentRequest withIceUid(Long iceUid) {
        this.iceUid = iceUid;
        return this;
    }

    public Long getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Long medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public AppointmentRequest withMedicalPracticeId(Long medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startTime", startTime).append("endTime", endTime).append("doctorId", doctorId).append("day", day).append("type", type).append("locationId", locationId).append("dateTime", dateTime).append("doctorSittingId", doctorSittingId).append("name", name).append("message", message).append("consultationRate", consultationRate).append("patientId", patientId).append("patientFirstName", patientFirstName).append("patientLastName", patientLastName).append("email", email).append("userRoleId", userRoleId).append("available", available).append("status", status).append("instituteInfo", instituteInfo).append("paymentId", paymentId).append("iceUid", iceUid).append("medicalPracticeId", medicalPracticeId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(startTime);
        dest.writeValue(endTime);
        dest.writeValue(doctorId);
        dest.writeValue(day);
        dest.writeValue(type);
        dest.writeValue(locationId);
        dest.writeValue(dateTime);
        dest.writeValue(doctorSittingId);
        dest.writeValue(name);
        dest.writeValue(message);
        dest.writeValue(consultationRate);
        dest.writeValue(patientId);
        dest.writeValue(patientFirstName);
        dest.writeValue(patientLastName);
        dest.writeValue(email);
        dest.writeValue(userRoleId);
        dest.writeValue(available);
        dest.writeValue(status);
        dest.writeValue(instituteInfo);
        dest.writeValue(paymentId);
        dest.writeValue(iceUid);
        dest.writeValue(medicalPracticeId);
    }

    public int describeContents() {
        return 0;
    }

}