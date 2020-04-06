package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Timing implements Parcelable {

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
    private Integer locationId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Integer doctorSittingId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("medical_practice_id")
    @Expose
    private Integer medicalPracticeId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("doctor_id")
    @Expose
    private Integer doctorId;
    public final static Parcelable.Creator<Timing> CREATOR = new Creator<Timing>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Timing createFromParcel(Parcel in) {
            return new Timing(in);
        }

        public Timing[] newArray(int size) {
            return (new Timing[size]);
        }

    };

    protected Timing(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.numberOfSlots = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.slotDuration = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.offlineLocation = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.day = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.locationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doctorSittingId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.medicalPracticeId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Timing() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timing withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Timing withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Timing withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(Integer numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public Timing withNumberOfSlots(Integer numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        return this;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

    public Timing withSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Timing withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timing withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getOfflineLocation() {
        return offlineLocation;
    }

    public void setOfflineLocation(Boolean offlineLocation) {
        this.offlineLocation = offlineLocation;
    }

    public Timing withOfflineLocation(Boolean offlineLocation) {
        this.offlineLocation = offlineLocation;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Timing withDay(Integer day) {
        this.day = day;
        return this;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Timing withLocationId(Integer locationId) {
        this.locationId = locationId;
        return this;
    }

    public Integer getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Integer doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public Timing withDoctorSittingId(Integer doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timing withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Integer medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public Timing withMedicalPracticeId(Integer medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timing withStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Timing withDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("startTime", startTime).append("endTime", endTime).append("numberOfSlots", numberOfSlots).append("slotDuration", slotDuration).append("createdAt", createdAt).append("updatedAt", updatedAt).append("offlineLocation", offlineLocation).append("day", day).append("locationId", locationId).append("doctorSittingId", doctorSittingId).append("name", name).append("medicalPracticeId", medicalPracticeId).append("status", status).append("doctorId", doctorId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(startTime);
        dest.writeValue(endTime);
        dest.writeValue(numberOfSlots);
        dest.writeValue(slotDuration);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(offlineLocation);
        dest.writeValue(day);
        dest.writeValue(locationId);
        dest.writeValue(doctorSittingId);
        dest.writeValue(name);
        dest.writeValue(medicalPracticeId);
        dest.writeValue(status);
        dest.writeValue(doctorId);
    }

    public int describeContents() {
        return 0;
    }

}