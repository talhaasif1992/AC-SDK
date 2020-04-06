
package com.augmentcare.patient.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDetail {

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
}
