package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 31/10/2017.
 */

public class CartItem implements Parcelable{
    private String sku;
    private String name;
    private long conversionFactor;
    private ArrayList<Pharmacy> available_at;
    private boolean in_loose;


    protected CartItem(Parcel in) {
        sku = in.readString();
        name = in.readString();
        conversionFactor = in.readLong();
        available_at = in.createTypedArrayList(Pharmacy.CREATOR);
        in_loose = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sku);
        dest.writeString(name);
        dest.writeLong(conversionFactor);
        dest.writeTypedList(available_at);
        dest.writeByte((byte) (in_loose ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(long conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public ArrayList<Pharmacy> getAvailable_at() {
        return available_at;
    }

    public void setAvailable_at(ArrayList<Pharmacy> available_at) {
        this.available_at = available_at;
    }

    public boolean isIn_loose() {
        return in_loose;
    }

    public void setIn_loose(boolean in_loose) {
        this.in_loose = in_loose;
    }
}
