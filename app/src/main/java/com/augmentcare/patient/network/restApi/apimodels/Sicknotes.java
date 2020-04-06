package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sicknotes implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("patient_id")
    @Expose
    private Integer patientId;
    @SerializedName("doctor_id")
    @Expose
    private Integer doctorId;
    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;
    @SerializedName("note")
    private String note;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("leave_start_date")
    @Expose
    private String leaveStartDate;
    @SerializedName("leave_end_date")
    @Expose
    private String leaveEndDate;
    @SerializedName("duty_start_date")
    @Expose
    private Object dutyStartDate;
    @SerializedName("organization_id")
    @Expose
    private Object organizationId;
    @SerializedName("allow_bed_rest")
    @Expose
    private Boolean allowBedRest;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public Object getDutyStartDate() {
        return dutyStartDate;
    }

    public void setDutyStartDate(Object dutyStartDate) {
        this.dutyStartDate = dutyStartDate;
    }

    public Object getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Object organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getAllowBedRest() {
        return allowBedRest;
    }

    public void setAllowBedRest(Boolean allowBedRest) {
        this.allowBedRest = allowBedRest;
    }

}