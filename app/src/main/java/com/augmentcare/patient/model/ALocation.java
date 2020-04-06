package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class ALocation implements Parcelable{
    @SerializedName("docter_id")
    private String docterId;

    private String logo;

    private String services;

    private String ambulance;
    @SerializedName("logo_content_type")
    private String logoContentType;

    private String emergency;
    @SerializedName("logo_file_size")
    private String logoFileSize;
    @SerializedName("wheel_chair")
    private String wheelChair;
    @SerializedName("no_of_doctors")
    private String noOfDoctors;
    @SerializedName("logo_file_name")
    private String logoFileName;
    @SerializedName("start_day")
    private String startDay;

    private String id;
    @SerializedName("contact_number")
    private String[] contactNumber;
    @SerializedName("cover_file_name")
    private String coverFileName;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("logo_updated_at")
    private String logoUdatedAt;

    private String description;
    @SerializedName("cover_file_size")
    private String coverFileSize;

    private String name;
    @SerializedName("no_of_beds")
    private String noOfBeds;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("end_day")
    private String endDay;

    @SerializedName("cover_updated_at")
    private String coverUpdatedAt;
    @SerializedName("cover_content_type")
    private String coverContentType;

    protected ALocation(Parcel in) {
        docterId = in.readString();
        logo = in.readString();
        services = in.readString();
        ambulance = in.readString();
        logoContentType = in.readString();
        emergency = in.readString();
        logoFileSize = in.readString();
        wheelChair = in.readString();
        noOfDoctors = in.readString();
        logoFileName = in.readString();
        startDay = in.readString();
        id = in.readString();
        contactNumber = in.createStringArray();
        coverFileName = in.readString();
        updatedAt = in.readString();
        logoUdatedAt = in.readString();
        description = in.readString();
        coverFileSize = in.readString();
        name = in.readString();
        noOfBeds = in.readString();
        createdAt = in.readString();
        endDay = in.readString();
        coverUpdatedAt = in.readString();
        coverContentType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(docterId);
        dest.writeString(logo);
        dest.writeString(services);
        dest.writeString(ambulance);
        dest.writeString(logoContentType);
        dest.writeString(emergency);
        dest.writeString(logoFileSize);
        dest.writeString(wheelChair);
        dest.writeString(noOfDoctors);
        dest.writeString(logoFileName);
        dest.writeString(startDay);
        dest.writeString(id);
        dest.writeStringArray(contactNumber);
        dest.writeString(coverFileName);
        dest.writeString(updatedAt);
        dest.writeString(logoUdatedAt);
        dest.writeString(description);
        dest.writeString(coverFileSize);
        dest.writeString(name);
        dest.writeString(noOfBeds);
        dest.writeString(createdAt);
        dest.writeString(endDay);
        dest.writeString(coverUpdatedAt);
        dest.writeString(coverContentType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ALocation> CREATOR = new Creator<ALocation>() {
        @Override
        public ALocation createFromParcel(Parcel in) {
            return new ALocation(in);
        }

        @Override
        public ALocation[] newArray(int size) {
            return new ALocation[size];
        }
    };

    public String getDocterId() {
        return docterId;
    }

    public void setDocterId(String docterId) {
        this.docterId = docterId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(String ambulance) {
        this.ambulance = ambulance;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
    }

    public String getWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(String wheelChair) {
        this.wheelChair = wheelChair;
    }

    public String getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(String noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String[] contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLogoUdatedAt() {
        return logoUdatedAt;
    }

    public void setLogoUdatedAt(String logoUdatedAt) {
        this.logoUdatedAt = logoUdatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverFileSize() {
        return coverFileSize;
    }

    public void setCoverFileSize(String coverFileSize) {
        this.coverFileSize = coverFileSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCoverUpdatedAt() {
        return coverUpdatedAt;
    }

    public void setCoverUpdatedAt(String coverUpdatedAt) {
        this.coverUpdatedAt = coverUpdatedAt;
    }

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }


}
