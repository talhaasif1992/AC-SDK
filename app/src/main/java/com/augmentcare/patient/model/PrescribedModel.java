package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrescribedModel
{
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("specimen")
    @Expose
    private String specimen;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("objectID")
    @Expose
    private String objectID;

    @SerializedName("short_name")
    @Expose
    private String shortName;

    @SerializedName("specimen_quantity")
    @Expose
    private String specimenQuantity;

    @SerializedName("fasting_requirement")
    @Expose
    private Boolean isFastingRequired;

    @SerializedName("relevant_disease")
    @Expose
    private String relevantDisease;

    @SerializedName("purpose")
    @Expose
    private String purpose;

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getObjectID() {
        return objectID;
    }
    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecimen() {
        return specimen;
    }
    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public PrescribedModel() {
    }

    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSpecimenQuantity() {
        return specimenQuantity;
    }
    public void setSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public Boolean getFastingRequired() {
        return isFastingRequired;
    }
    public void setFastingRequired(Boolean fastingRequired) {
        isFastingRequired = fastingRequired;
    }

    public String getRelevantDisease() {
        return relevantDisease;
    }
    public void setRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
