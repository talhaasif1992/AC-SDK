package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LabTest implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("specimen")
    @Expose
    private String specimen;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("report_type")
    @Expose
    private String reportType;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("fasting_time")
    @Expose
    private String fastingTime;
    @SerializedName("relevant_disease")
    @Expose
    private String relevantDisease;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("normal_test_value_range")
    @Expose
    private String normalTestValueRange;
    @SerializedName("profile_name")
    @Expose
    private String profileName;
    @SerializedName("specimen_quantity")
    @Expose
    private String specimenQuantity;
    @SerializedName("specimen_nature")
    @Expose
    private String specimenNature;
    @SerializedName("fasting_requirement")
    @Expose
    private Boolean fastingRequirement;
    @SerializedName("added_by_status")
    @Expose
    private Boolean addedByStatus;
    @SerializedName("added_by_id")
    @Expose
    private Integer addedById;
    public final static Parcelable.Creator<LabTest> CREATOR = new Creator<LabTest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LabTest createFromParcel(Parcel in) {
            return new LabTest(in);
        }

        public LabTest[] newArray(int size) {
            return (new LabTest[size]);
        }

    };

    protected LabTest(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.specimen = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.reportType = ((String) in.readValue((String.class.getClassLoader())));
        this.shortName = ((String) in.readValue((String.class.getClassLoader())));
        this.fastingTime = ((String) in.readValue((String.class.getClassLoader())));
        this.relevantDisease = ((String) in.readValue((String.class.getClassLoader())));
        this.purpose = ((String) in.readValue((String.class.getClassLoader())));
        this.normalTestValueRange = ((String) in.readValue((String.class.getClassLoader())));
        this.profileName = ((String) in.readValue((String.class.getClassLoader())));
        this.specimenQuantity = ((String) in.readValue((String.class.getClassLoader())));
        this.specimenNature = ((String) in.readValue((String.class.getClassLoader())));
        this.fastingRequirement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.addedByStatus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.addedById = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public LabTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LabTest withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabTest withName(String name) {
        this.name = name;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public LabTest withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LabTest withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public LabTest withSpecimen(String specimen) {
        this.specimen = specimen;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LabTest withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LabTest withReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LabTest withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getFastingTime() {
        return fastingTime;
    }

    public void setFastingTime(String fastingTime) {
        this.fastingTime = fastingTime;
    }

    public LabTest withFastingTime(String fastingTime) {
        this.fastingTime = fastingTime;
        return this;
    }

    public String getRelevantDisease() {
        return relevantDisease;
    }

    public void setRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
    }

    public LabTest withRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LabTest withPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public String getNormalTestValueRange() {
        return normalTestValueRange;
    }

    public void setNormalTestValueRange(String normalTestValueRange) {
        this.normalTestValueRange = normalTestValueRange;
    }

    public LabTest withNormalTestValueRange(String normalTestValueRange) {
        this.normalTestValueRange = normalTestValueRange;
        return this;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LabTest withProfileName(String profileName) {
        this.profileName = profileName;
        return this;
    }

    public String getSpecimenQuantity() {
        return specimenQuantity;
    }

    public void setSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public LabTest withSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
        return this;
    }

    public String getSpecimenNature() {
        return specimenNature;
    }

    public void setSpecimenNature(String specimenNature) {
        this.specimenNature = specimenNature;
    }

    public LabTest withSpecimenNature(String specimenNature) {
        this.specimenNature = specimenNature;
        return this;
    }

    public Boolean getFastingRequirement() {
        return fastingRequirement;
    }

    public void setFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
    }

    public LabTest withFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
        return this;
    }

    public Boolean getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(Boolean addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public LabTest withAddedByStatus(Boolean addedByStatus) {
        this.addedByStatus = addedByStatus;
        return this;
    }

    public Integer getAddedById() {
        return addedById;
    }

    public void setAddedById(Integer addedById) {
        this.addedById = addedById;
    }

    public LabTest withAddedById(Integer addedById) {
        this.addedById = addedById;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("createdAt", createdAt).append("updatedAt", updatedAt).append("specimen", specimen).append("price", price).append("reportType", reportType).append("shortName", shortName).append("fastingTime", fastingTime).append("relevantDisease", relevantDisease).append("purpose", purpose).append("normalTestValueRange", normalTestValueRange).append("profileName", profileName).append("specimenQuantity", specimenQuantity).append("specimenNature", specimenNature).append("fastingRequirement", fastingRequirement).append("addedByStatus", addedByStatus).append("addedById", addedById).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(specimen);
        dest.writeValue(price);
        dest.writeValue(reportType);
        dest.writeValue(shortName);
        dest.writeValue(fastingTime);
        dest.writeValue(relevantDisease);
        dest.writeValue(purpose);
        dest.writeValue(normalTestValueRange);
        dest.writeValue(profileName);
        dest.writeValue(specimenQuantity);
        dest.writeValue(specimenNature);
        dest.writeValue(fastingRequirement);
        dest.writeValue(addedByStatus);
        dest.writeValue(addedById);
    }

    public int describeContents() {
        return 0;
    }

}