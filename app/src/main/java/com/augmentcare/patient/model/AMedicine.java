package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 03/04/2018.
 */

public class AMedicine implements Parcelable{

    private String purchase_conversion_factor;

    private String code;

    private String in_loose;

    private String unit_price;

    private String discount;

    private String id;

    private String unit;

    private String category;

    private String updated_at;

    private String pharmacy_med_name;

    private String name;

    private String active;

    private String created_at;

    private String sehat_id;

    protected AMedicine(Parcel in) {
        purchase_conversion_factor = in.readString();
        code = in.readString();
        in_loose = in.readString();
        unit_price = in.readString();
        discount = in.readString();
        id = in.readString();
        unit = in.readString();
        category = in.readString();
        updated_at = in.readString();
        pharmacy_med_name = in.readString();
        name = in.readString();
        active = in.readString();
        created_at = in.readString();
        sehat_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(purchase_conversion_factor);
        dest.writeString(code);
        dest.writeString(in_loose);
        dest.writeString(unit_price);
        dest.writeString(discount);
        dest.writeString(id);
        dest.writeString(unit);
        dest.writeString(category);
        dest.writeString(updated_at);
        dest.writeString(pharmacy_med_name);
        dest.writeString(name);
        dest.writeString(active);
        dest.writeString(created_at);
        dest.writeString(sehat_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AMedicine> CREATOR = new Creator<AMedicine>() {
        @Override
        public AMedicine createFromParcel(Parcel in) {
            return new AMedicine(in);
        }

        @Override
        public AMedicine[] newArray(int size) {
            return new AMedicine[size];
        }
    };

    public String getPurchase_conversion_factor() {
        return purchase_conversion_factor;
    }

    public void setPurchase_conversion_factor(String purchase_conversion_factor) {
        this.purchase_conversion_factor = purchase_conversion_factor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIn_loose() {
        return in_loose;
    }

    public void setIn_loose(String in_loose) {
        this.in_loose = in_loose;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPharmacy_med_name() {
        return pharmacy_med_name;
    }

    public void setPharmacy_med_name(String pharmacy_med_name) {
        this.pharmacy_med_name = pharmacy_med_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSehat_id() {
        return sehat_id;
    }

    public void setSehat_id(String sehat_id) {
        this.sehat_id = sehat_id;
    }
}
