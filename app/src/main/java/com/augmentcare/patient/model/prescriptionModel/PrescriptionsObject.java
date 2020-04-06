
package com.augmentcare.patient.model.prescriptionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PrescriptionsObject {

    @SerializedName("medicine")
    @Expose
    private Medicine medicine;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("dosage")
    @Expose
    private Dosage dosage;
    @SerializedName("duration")
    @Expose
    private Duration duration;
    @SerializedName("meal")
    @Expose
    private String meal;
    @SerializedName("notes")
    private String notes;
    @SerializedName("$$hashKey")
    @Expose
    private String $$hashKey;
    @SerializedName("packs")
    @Expose
    private Integer packs;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("is_loose")
    @Expose
    private Boolean isLoose;
    @SerializedName("price")
    @Expose
    private Integer price;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String get$$hashKey() {
        return $$hashKey;
    }

    public void set$$hashKey(String $$hashKey) {
        this.$$hashKey = $$hashKey;
    }

    public Integer getPacks() {
        return packs;
    }

    public void setPacks(Integer packs) {
        this.packs = packs;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsLoose() {
        return isLoose;
    }

    public void setIsLoose(Boolean isLoose) {
        this.isLoose = isLoose;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
