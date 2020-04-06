package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderResults implements Parcelable {

    @SerializedName("medicine")
    @Expose
    private Medicine medicine;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("dosage")
    @Expose
    private DosageOrDuration dosage;
    @SerializedName("duration")
    @Expose
    private DosageOrDuration duration;
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
    @SerializedName("meal")
    @Expose
    private String meal;
    @SerializedName("notes")
    private String notes;
    public final static Parcelable.Creator<OrderResults> CREATOR = new Creator<OrderResults>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrderResults createFromParcel(Parcel in) {
            return new OrderResults(in);
        }

        public OrderResults[] newArray(int size) {
            return (new OrderResults[size]);
        }

    };

    protected OrderResults(Parcel in) {
        this.medicine = ((Medicine) in.readValue((Medicine.class.getClassLoader())));
        this.frequency = ((String) in.readValue((String.class.getClassLoader())));
        this.dosage = ((DosageOrDuration) in.readValue((DosageOrDuration.class.getClassLoader())));
        this.duration = ((DosageOrDuration) in.readValue((DosageOrDuration.class.getClassLoader())));
        this.$$hashKey = ((String) in.readValue((String.class.getClassLoader())));
        this.packs = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.isLoose = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.price = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.meal = ((String) in.readValue((String.class.getClassLoader())));
        this.notes = ((String) in.readValue((String.class.getClassLoader())));

    }

    public OrderResults() {
    }

    public OrderResults withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public OrderResults withMeal(String meal) {
        this.meal = meal;
        return this;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public OrderResults withMedicine(Medicine medicine) {
        this.medicine = medicine;
        return this;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public OrderResults withFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public DosageOrDuration getDosage() {
        return dosage;
    }

    public void setDosage(DosageOrDuration dosage) {
        this.dosage = dosage;
    }

    public OrderResults withDosage(DosageOrDuration dosage) {
        this.dosage = dosage;
        return this;
    }

    public DosageOrDuration getDuration() {
        return duration;
    }

    public void setDuration(DosageOrDuration duration) {
        this.duration = duration;
    }

    public OrderResults withDuration(DosageOrDuration duration) {
        this.duration = duration;
        return this;
    }

    public String get$$hashKey() {
        return $$hashKey;
    }

    public void set$$hashKey(String $$hashKey) {
        this.$$hashKey = $$hashKey;
    }

    public OrderResults with$$hashKey(String $$hashKey) {
        this.$$hashKey = $$hashKey;
        return this;
    }

    public Integer getPacks() {
        return packs;
    }

    public void setPacks(Integer packs) {
        this.packs = packs;
    }

    public OrderResults withPacks(Integer packs) {
        this.packs = packs;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderResults withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderResults withType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getIsLoose() {
        return isLoose;
    }

    public void setIsLoose(Boolean isLoose) {
        this.isLoose = isLoose;
    }

    public OrderResults withIsLoose(Boolean isLoose) {
        this.isLoose = isLoose;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public OrderResults withPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("medicine", medicine).append("frequency", frequency).append("dosage", dosage).append("duration", duration).append("$$hashKey", $$hashKey).append("packs", packs).append("quantity", quantity).append("type", type).append("isLoose", isLoose).append("price", price).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(medicine);
        dest.writeValue(frequency);
        dest.writeValue(dosage);
        dest.writeValue(duration);
        dest.writeValue($$hashKey);
        dest.writeValue(packs);
        dest.writeValue(quantity);
        dest.writeValue(type);
        dest.writeValue(isLoose);
        dest.writeValue(price);
        dest.writeValue(meal);
        dest.writeValue(notes);

    }

    public int describeContents() {
        return 0;
    }

}