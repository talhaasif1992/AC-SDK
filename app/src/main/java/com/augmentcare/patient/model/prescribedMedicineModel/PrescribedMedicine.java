
package com.augmentcare.patient.model.prescribedMedicineModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrescribedMedicine implements Serializable {

    @SerializedName("con")
    @Expose
    private Integer con;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("meds")
    @Expose
    private List<Med> meds = null;
    @SerializedName("prescription_id")
    @Expose
    private Integer prescriptionId;

    public Integer getCon() {
        return con;
    }

    public void setCon(Integer con) {
        this.con = con;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Med> getMeds() {
        return meds;
    }

    public void setMeds(List<Med> meds) {
        this.meds = meds;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

}
