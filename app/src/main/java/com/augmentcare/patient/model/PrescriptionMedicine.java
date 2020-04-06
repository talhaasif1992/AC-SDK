package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class PrescriptionMedicine implements Parcelable{
    private String E;

    private String days;

    private String A;

    private String M;

    private String medicine_name;
    private String code;
    private String packs;
    private String quantity;
    private String type;

    protected PrescriptionMedicine(Parcel in) {
        E = in.readString();
        days = in.readString();
        A = in.readString();
        M = in.readString();
        medicine_name = in.readString();
        code = in.readString();
        packs = in.readString();
        quantity = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(E);
        dest.writeString(days);
        dest.writeString(A);
        dest.writeString(M);
        dest.writeString(medicine_name);
        dest.writeString(code);
        dest.writeString(packs);
        dest.writeString(quantity);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PrescriptionMedicine> CREATOR = new Creator<PrescriptionMedicine>() {
        @Override
        public PrescriptionMedicine createFromParcel(Parcel in) {
            return new PrescriptionMedicine(in);
        }

        @Override
        public PrescriptionMedicine[] newArray(int size) {
            return new PrescriptionMedicine[size];
        }
    };

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPacks() {
        return packs;
    }

    public void setPacks(String packs) {
        this.packs = packs;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
