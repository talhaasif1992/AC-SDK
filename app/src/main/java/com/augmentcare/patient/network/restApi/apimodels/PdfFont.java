package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PdfFont implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("dpi")
    @Expose
    private int dpi;
    public final static Parcelable.Creator<PdfFont> CREATOR = new Creator<PdfFont>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PdfFont createFromParcel(Parcel in) {
            return new PdfFont(in);
        }

        public PdfFont[] newArray(int size) {
            return (new PdfFont[size]);
        }

    };

    protected PdfFont(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((String) in.readValue((String.class.getClassLoader())));
        this.dpi = ((int) in.readValue((int.class.getClassLoader())));
    }

    public PdfFont() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PdfFont withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PdfFont withName(String name) {
        this.name = name;
        return this;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public PdfFont withSize(String size) {
        this.size = size;
        return this;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public PdfFont withDpi(int dpi) {
        this.dpi = dpi;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("size", size).append("dpi", dpi).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(size);
        dest.writeValue(dpi);
    }

    public int describeContents() {
        return 0;
    }

}