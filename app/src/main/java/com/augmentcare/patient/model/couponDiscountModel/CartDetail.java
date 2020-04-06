
package com.augmentcare.patient.model.couponDiscountModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDetail implements Serializable {

    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("specimen")
    @Expose
    private String specimen;
    @SerializedName("prescription_required")
    @Expose
    private Boolean prescriptionRequired;
    @SerializedName("quantity_pack")
    @Expose
    private Integer quantityPack;
    @SerializedName("uploaded_prescription")
    @Expose
    private List<Object> uploadedPrescription = null;
    @SerializedName("available_in_loose")
    @Expose
    private Boolean availableInLoose;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("fasting_time")
    @Expose
    private String fastingTime;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("specimen_quantity")
    @Expose
    private String specimenQuantity;
    @SerializedName("relevant_disease")
    @Expose
    private String relevantDisease;
    @SerializedName("fasting_requirement")
    @Expose
    private Boolean fastingRequirement;
    @SerializedName("category")
    @Expose
    private String category;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public Boolean getPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(Boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public Integer getQuantityPack() {
        return quantityPack;
    }

    public void setQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
    }

    public List<Object> getUploadedPrescription() {
        return uploadedPrescription;
    }

    public void setUploadedPrescription(List<Object> uploadedPrescription) {
        this.uploadedPrescription = uploadedPrescription;
    }

    public Boolean getAvailableInLoose() {
        return availableInLoose;
    }

    public void setAvailableInLoose(Boolean availableInLoose) {
        this.availableInLoose = availableInLoose;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFastingTime() {
        return fastingTime;
    }

    public void setFastingTime(String fastingTime) {
        this.fastingTime = fastingTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSpecimenQuantity() {
        return specimenQuantity;
    }

    public void setSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public String getRelevantDisease() {
        return relevantDisease;
    }

    public void setRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
    }

    public Boolean getFastingRequirement() {
        return fastingRequirement;
    }

    public void setFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
