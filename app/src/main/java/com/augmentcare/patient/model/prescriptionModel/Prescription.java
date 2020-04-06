
package com.augmentcare.patient.model.prescriptionModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prescription {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("prescriptions_object")
    @Expose
    private List<PrescriptionsObject> prescriptionsObject = null;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("doctor_id")
    @Expose
    private String doctorId;
    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("prescription_pdflink")
    @Expose
    private Object prescriptionPdflink;
    @SerializedName("prescription_uid")
    private String prescriptionUid;
    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Object doctorSittingId;
    @SerializedName("added_by")
    @Expose
    private Integer addedBy;
    @SerializedName("added_by_role")
    @Expose
    private String addedByRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PrescriptionsObject> getPrescriptionsObject() {
        return prescriptionsObject;
    }

    public void setPrescriptionsObject(List<PrescriptionsObject> prescriptionsObject) {
        this.prescriptionsObject = prescriptionsObject;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Object getPrescriptionPdflink() {
        return prescriptionPdflink;
    }

    public void setPrescriptionPdflink(Object prescriptionPdflink) {
        this.prescriptionPdflink = prescriptionPdflink;
    }

    public String getPrescriptionUid() {
        return prescriptionUid;
    }

    public void setPrescriptionUid(String prescriptionUid) {
        this.prescriptionUid = prescriptionUid;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Object getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Object doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    public String getAddedByRole() {
        return addedByRole;
    }

    public void setAddedByRole(String addedByRole) {
        this.addedByRole = addedByRole;
    }

}
