package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class CartDetail implements Parcelable {

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
    private List<String> uploadedPrescription = new ArrayList<String>();
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
    public final static Parcelable.Creator<CartDetail> CREATOR = new Creator<CartDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CartDetail createFromParcel(Parcel in) {
            return new CartDetail(in);
        }

        public CartDetail[] newArray(int size) {
            return (new CartDetail[size]);
        }

    };

    protected CartDetail(Parcel in) {
        this.itemId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.specimen = ((String) in.readValue((String.class.getClassLoader())));
        this.prescriptionRequired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.quantityPack = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.uploadedPrescription, (java.lang.String.class.getClassLoader()));
        this.availableInLoose = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.shortName = ((String) in.readValue((String.class.getClassLoader())));
        this.fastingTime = ((String) in.readValue((String.class.getClassLoader())));
        this.purpose = ((String) in.readValue((String.class.getClassLoader())));
        this.specimenQuantity = ((String) in.readValue((String.class.getClassLoader())));
        this.relevantDisease = ((String) in.readValue((String.class.getClassLoader())));
        this.fastingRequirement = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CartDetail() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public CartDetail withItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartDetail withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CartDetail withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CartDetail withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CartDetail withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public CartDetail withSpecimen(String specimen) {
        this.specimen = specimen;
        return this;
    }

    public Boolean getPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(Boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public CartDetail withPrescriptionRequired(Boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
        return this;
    }

    public Integer getQuantityPack() {
        return quantityPack;
    }

    public void setQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
    }

    public CartDetail withQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
        return this;
    }

    public List<String> getUploadedPrescription() {
        return uploadedPrescription;
    }

    public void setUploadedPrescription(List<String> uploadedPrescription) {
        this.uploadedPrescription = uploadedPrescription;
    }

    public CartDetail withUploadedPrescription(List<String> uploadedPrescription) {
        this.uploadedPrescription = uploadedPrescription;
        return this;
    }

    public Boolean getAvailableInLoose() {
        return availableInLoose;
    }

    public void setAvailableInLoose(Boolean availableInLoose) {
        this.availableInLoose = availableInLoose;
    }

    public CartDetail withAvailableInLoose(Boolean availableInLoose) {
        this.availableInLoose = availableInLoose;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public CartDetail withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getFastingTime() {
        return fastingTime;
    }

    public void setFastingTime(String fastingTime) {
        this.fastingTime = fastingTime;
    }

    public CartDetail withFastingTime(String fastingTime) {
        this.fastingTime = fastingTime;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public CartDetail withPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public String getSpecimenQuantity() {
        return specimenQuantity;
    }

    public void setSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public CartDetail withSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
        return this;
    }

    public String getRelevantDisease() {
        return relevantDisease;
    }

    public void setRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
    }

    public CartDetail withRelevantDisease(String relevantDisease) {
        this.relevantDisease = relevantDisease;
        return this;
    }

    public Boolean getFastingRequirement() {
        return fastingRequirement;
    }

    public void setFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
    }

    public CartDetail withFastingRequirement(Boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CartDetail withCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("itemId", itemId).append("id", id).append("type", type).append("name", name).append("price", price).append("specimen", specimen).append("prescriptionRequired", prescriptionRequired).append("quantityPack", quantityPack).append("uploadedPrescription", uploadedPrescription).append("availableInLoose", availableInLoose).append("shortName", shortName).append("fastingTime", fastingTime).append("purpose", purpose).append("specimenQuantity", specimenQuantity).append("relevantDisease", relevantDisease).append("fastingRequirement", fastingRequirement).append("category", category).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(itemId);
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeValue(price);
        dest.writeValue(specimen);
        dest.writeValue(prescriptionRequired);
        dest.writeValue(quantityPack);
        dest.writeList(uploadedPrescription);
        dest.writeValue(availableInLoose);
        dest.writeValue(shortName);
        dest.writeValue(fastingTime);
        dest.writeValue(purpose);
        dest.writeValue(specimenQuantity);
        dest.writeValue(relevantDisease);
        dest.writeValue(fastingRequirement);
        dest.writeValue(category);
    }

    public int describeContents() {
        return 0;
    }

}