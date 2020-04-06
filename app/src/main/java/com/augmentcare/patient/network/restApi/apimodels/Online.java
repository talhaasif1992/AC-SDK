
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Online implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("number_of_slots")
    @Expose
    private int numberOfSlots;
    @SerializedName("slot_duration")
    @Expose
    private int slotDuration;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("offline_location")
    @Expose
    private boolean offlineLocation;
    @SerializedName("day")
    @Expose
    private int day;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private String doctorSittingId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("medical_practice_id")
    @Expose
    private String medicalPracticeId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("doctor_id")
    @Expose
    private int doctorId;
    public final static Creator<Online> CREATOR = new Creator<Online>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Online createFromParcel(Parcel in) {
            return new Online(in);
        }

        public Online[] newArray(int size) {
            return (new Online[size]);
        }

    }
    ;

    protected Online(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.numberOfSlots = ((int) in.readValue((int.class.getClassLoader())));
        this.slotDuration = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.offlineLocation = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.day = ((int) in.readValue((int.class.getClassLoader())));
        this.locationId = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorSittingId = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.medicalPracticeId = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Online() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Online withId(int id) {
        this.id = id;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Online withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Online withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public Online withNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        return this;
    }

    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public Online withSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Online withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Online withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public boolean isOfflineLocation() {
        return offlineLocation;
    }

    public void setOfflineLocation(boolean offlineLocation) {
        this.offlineLocation = offlineLocation;
    }

    public Online withOfflineLocation(boolean offlineLocation) {
        this.offlineLocation = offlineLocation;
        return this;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Online withDay(int day) {
        this.day = day;
        return this;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Online withLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(String doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public Online withDoctorSittingId(String doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Online withName(String name) {
        this.name = name;
        return this;
    }

    public String getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(String medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public Online withMedicalPracticeId(String medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Online withStatus(String status) {
        this.status = status;
        return this;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Online withDoctorId(int doctorId) {
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
        return  0;
    }

}
