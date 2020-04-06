package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Partner implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("center_type")
    @Expose
    private String centerType;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("logo_file_name")
    @Expose
    private String logoFileName;
    @SerializedName("logo_content_type")
    @Expose
    private String logoContentType;
    @SerializedName("logo_file_size")
    @Expose
    private String logoFileSize;
    @SerializedName("logo_updated_at")
    @Expose
    private String logoUpdatedAt;
    @SerializedName("api_key")
    @Expose
    private String apiKey;
    public final static Parcelable.Creator<Partner> CREATOR = new Creator<Partner>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Partner createFromParcel(Parcel in) {
            return new Partner(in);
        }

        public Partner[] newArray(int size) {
            return (new Partner[size]);
        }

    };

    protected Partner(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.centerType = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.logoFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.logoContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.logoFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.logoUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.apiKey = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Partner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Partner withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Partner withName(String name) {
        this.name = name;
        return this;
    }

    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
    }

    public Partner withCenterType(String centerType) {
        this.centerType = centerType;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Partner withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Partner withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Partner withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public Partner withLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
        return this;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Partner withLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public String getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
    }

    public Partner withLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
        return this;
    }

    public String getLogoUpdatedAt() {
        return logoUpdatedAt;
    }

    public void setLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
    }

    public Partner withLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Partner withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("centerType", centerType).append("address", address).append("createdAt", createdAt).append("updatedAt", updatedAt).append("logoFileName", logoFileName).append("logoContentType", logoContentType).append("logoFileSize", logoFileSize).append("logoUpdatedAt", logoUpdatedAt).append("apiKey", apiKey).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(centerType);
        dest.writeValue(address);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(logoFileName);
        dest.writeValue(logoContentType);
        dest.writeValue(logoFileSize);
        dest.writeValue(logoUpdatedAt);
        dest.writeValue(apiKey);
    }

    public int describeContents() {
        return 0;
    }

}