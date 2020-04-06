package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 03/04/2018.
 */

public class APrescription implements Parcelable{
    private AMedicine medicine;
    private String frequency;
    private ADosage dosage;
    private ADuration duration;
    private AAdministration administration;
    private String notes;
    private String meal;
    private int price;
    private String type;
    private int quantity;
    private int packs;
    @SerializedName("is_loose")
    private boolean isLoose;

    protected APrescription(Parcel in) {
        medicine = in.readParcelable(AMedicine.class.getClassLoader());
        frequency = in.readString();
        dosage = in.readParcelable(ADosage.class.getClassLoader());
        duration = in.readParcelable(ADuration.class.getClassLoader());
        notes = in.readString();
        meal = in.readString();
        price = in.readInt();
        type = in.readString();
        quantity = in.readInt();
        packs = in.readInt();
        isLoose = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(medicine, flags);
        dest.writeString(frequency);
        dest.writeParcelable(dosage, flags);
        dest.writeParcelable(duration, flags);
        dest.writeString(notes);
        dest.writeString(meal);
        dest.writeInt(price);
        dest.writeString(type);
        dest.writeInt(quantity);
        dest.writeInt(packs);
        dest.writeByte((byte) (isLoose ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<APrescription> CREATOR = new Creator<APrescription>() {
        @Override
        public APrescription createFromParcel(Parcel in) {
            return new APrescription(in);
        }

        @Override
        public APrescription[] newArray(int size) {
            return new APrescription[size];
        }
    };

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPacks() {
        return packs;
    }

    public void setPacks(int packs) {
        this.packs = packs;
    }

    public boolean isLoose() {
        return isLoose;
    }

    public void setLoose(boolean loose) {
        isLoose = loose;
    }



    public AMedicine getMedicine() {
        return medicine;
    }

    public void setMedicine(AMedicine medicine) {
        this.medicine = medicine;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public ADosage getDosage() {
        return dosage;
    }

    public void setDosage(ADosage dosage) {
        this.dosage = dosage;
    }

    public ADuration getDuration() {
        return duration;
    }

    public void setDuration(ADuration duration) {
        this.duration = duration;
    }

    public AAdministration getAdministration() {
        return administration;
    }

    public void setAdministration(AAdministration administration) {
        this.administration = administration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
}
