
package com.augmentcare.patient.model.prescribedLabsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrescribedTest {

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
    private Object specimen;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("report_type")
    @Expose
    private String reportType;
    @SerializedName("short_name")
    @Expose
    private Object shortName;
    @SerializedName("fasting_time")
    @Expose
    private Object fastingTime;
    @SerializedName("relevant_disease")
    @Expose
    private Object relevantDisease;
    @SerializedName("purpose")
    @Expose
    private Object purpose;
    @SerializedName("normal_test_value_range")
    @Expose
    private Object normalTestValueRange;
    @SerializedName("profile_name")
    @Expose
    private Object profileName;
    @SerializedName("specimen_quantity")
    @Expose
    private Object specimenQuantity;
    @SerializedName("specimen_nature")
    @Expose
    private Object specimenNature;
    @SerializedName("fasting_requirement")
    @Expose
    private Boolean fastingRequirement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Object getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Object specimen) {
        this.specimen = specimen;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Object getShortName() {
        return shortName;
    }

    public void setShortName(Object shortName) {
        this.shortName = shortName;
    }

    public Object getFastingTime() {
        return fastingTime;
    }

    public void setFastingTime(Object fastingTime) {
        this.fastingTime = fastingTime;
    }

    public Object getRelevantDisease() {
        return relevantDisease;
    }

    public void setRelevantDisease(Object relevantDisease) {
        this.relevantDisease = relevantDisease;
    }

    public Object getPurpose() {
        return purpose;
    }

    public void setPurpose(Object purpose) {
        this.purpose = purpose;
    }

    public Object getNormalTestValueRange() {
        return normalTestValueRange;
    }

    public void setNormalTestValueRange(Object normalTestValueRange) {
        this.normalTestValueRange = normalTestValueRange;
    }

    public Object getProfileName() {
        return profileName;
    }

    public void setProfileName(Object profileName) {
        this.profileName = profileName;
    }

    public Object getSpecimenQuantity() {
        return specimenQuantity;
    }

    public void setSpecimenQuantity(Object specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public Object getSpecimenNature() {
        return specimenNature;
    }

    public void setSpecimenNature(Object specimenNature) {
        this.specimenNature = specimenNature;
    }

    public Boolean getFastingRequirement() {
        return fastingRequirement;
    }

    public void setFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
    }

}
