
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timing {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("number_of_slots")
    @Expose
    private Integer numberOfSlots;
    @SerializedName("slot_duration")
    @Expose
    private Integer slotDuration;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("offline_location")
    @Expose
    private Boolean offlineLocation;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("location_id")
    @Expose
    private Object locationId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Object doctorSittingId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("medical_practice_id")
    @Expose
    private Object medicalPracticeId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("doctor_id")
    @Expose
    private Integer doctorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(Integer numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
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

    public Boolean getOfflineLocation() {
        return offlineLocation;
    }

    public void setOfflineLocation(Boolean offlineLocation) {
        this.offlineLocation = offlineLocation;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Object getLocationId() {
        return locationId;
    }

    public void setLocationId(Object locationId) {
        this.locationId = locationId;
    }

    public Object getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Object doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Object medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

}
