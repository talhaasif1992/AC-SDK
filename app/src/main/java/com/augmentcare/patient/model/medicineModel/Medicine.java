
package com.augmentcare.patient.model.medicineModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medicine {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unit")
    @Expose
    private Integer unit;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("unit_price")
    @Expose
    private Integer unitPrice;
    @SerializedName("discount")
    @Expose
    private Object discount;
    @SerializedName("purchase_conversion_factor")
    @Expose
    private Integer purchaseConversionFactor;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pharmacy_med_name")
    @Expose
    private String pharmacyMedName;
    @SerializedName("in_loose")
    @Expose
    private Boolean inLoose;
    @SerializedName("sehat_id")
    @Expose
    private Object sehatId;
    @SerializedName("is_prescription_required")
    @Expose
    private Boolean isPrescriptionRequired;

    private String quantity;

    public Boolean getPrescriptionRequired() {
        return isPrescriptionRequired;
    }

    public void setPrescriptionRequired(Boolean prescriptionRequired) {
        isPrescriptionRequired = prescriptionRequired;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public Integer getPurchaseConversionFactor() {
        return purchaseConversionFactor;
    }

    public void setPurchaseConversionFactor(Integer purchaseConversionFactor) {
        this.purchaseConversionFactor = purchaseConversionFactor;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public String getPharmacyMedName() {
        return pharmacyMedName;
    }

    public void setPharmacyMedName(String pharmacyMedName) {
        this.pharmacyMedName = pharmacyMedName;
    }

    public Boolean getInLoose() {
        return inLoose;
    }

    public void setInLoose(Boolean inLoose) {
        this.inLoose = inLoose;
    }

    public Object getSehatId() {
        return sehatId;
    }

    public void setSehatId(Object sehatId) {
        this.sehatId = sehatId;
    }

    public Boolean getIsPrescriptionRequired() {
        return isPrescriptionRequired;
    }

    public void setIsPrescriptionRequired(Boolean isPrescriptionRequired) {
        this.isPrescriptionRequired = isPrescriptionRequired;
    }
}