package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Organization implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("head_office_id")
    @Expose
    private String headOfficeId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("logo_url")
    @Expose
    private String logoUrl;
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
    @SerializedName("mr_extension")
    @Expose
    private String mrExtension;
    @SerializedName("strength")
    @Expose
    private String strength;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("corporate_account_id")
    @Expose
    private int corporateAccountId;
    public final static Parcelable.Creator<Organization> CREATOR = new Creator<Organization>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Organization createFromParcel(Parcel in) {
            return new Organization(in);
        }

        public Organization[] newArray(int size) {
            return (new Organization[size]);
        }

    };

    protected Organization(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.headOfficeId = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.region = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.logoUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.logoFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.logoContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.logoFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.logoUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.mrExtension = ((String) in.readValue((String.class.getClassLoader())));
        this.strength = ((String) in.readValue((String.class.getClassLoader())));
        this.domain = ((String) in.readValue((String.class.getClassLoader())));
        this.corporateAccountId = ((int) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Organization() {
    }

    /**
     * @param address
     * @param strength
     * @param city
     * @param headOfficeId
     * @param logoFileName
     * @param logoUrl
     * @param logoUpdatedAt
     * @param createdAt
     * @param phone
     * @param domain
     * @param name
     * @param logoContentType
     * @param mrExtension
     * @param id
     * @param region
     * @param corporateAccountId
     * @param logoFileSize
     * @param updatedAt
     */
    public Organization(int id, String name, String address, String createdAt, String updatedAt, String headOfficeId, String phone, String region, String city, String logoUrl, String logoFileName, String logoContentType, String logoFileSize, String logoUpdatedAt, String mrExtension, String strength, String domain, int corporateAccountId) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.headOfficeId = headOfficeId;
        this.phone = phone;
        this.region = region;
        this.city = city;
        this.logoUrl = logoUrl;
        this.logoFileName = logoFileName;
        this.logoContentType = logoContentType;
        this.logoFileSize = logoFileSize;
        this.logoUpdatedAt = logoUpdatedAt;
        this.mrExtension = mrExtension;
        this.strength = strength;
        this.domain = domain;
        this.corporateAccountId = corporateAccountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organization withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization withName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organization withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Organization withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Organization withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getHeadOfficeId() {
        return headOfficeId;
    }

    public void setHeadOfficeId(String headOfficeId) {
        this.headOfficeId = headOfficeId;
    }

    public Organization withHeadOfficeId(String headOfficeId) {
        this.headOfficeId = headOfficeId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Organization withRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Organization withCity(String city) {
        this.city = city;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Organization withLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public Organization withLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
        return this;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Organization withLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public String getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
    }

    public Organization withLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
        return this;
    }

    public String getLogoUpdatedAt() {
        return logoUpdatedAt;
    }

    public void setLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
    }

    public Organization withLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
        return this;
    }

    public String getMrExtension() {
        return mrExtension;
    }

    public void setMrExtension(String mrExtension) {
        this.mrExtension = mrExtension;
    }

    public Organization withMrExtension(String mrExtension) {
        this.mrExtension = mrExtension;
        return this;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public Organization withStrength(String strength) {
        this.strength = strength;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Organization withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public int getCorporateAccountId() {
        return corporateAccountId;
    }

    public void setCorporateAccountId(int corporateAccountId) {
        this.corporateAccountId = corporateAccountId;
    }

    public Organization withCorporateAccountId(int corporateAccountId) {
        this.corporateAccountId = corporateAccountId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("address", address).append("createdAt", createdAt).append("updatedAt", updatedAt).append("headOfficeId", headOfficeId).append("phone", phone).append("region", region).append("city", city).append("logoUrl", logoUrl).append("logoFileName", logoFileName).append("logoContentType", logoContentType).append("logoFileSize", logoFileSize).append("logoUpdatedAt", logoUpdatedAt).append("mrExtension", mrExtension).append("strength", strength).append("domain", domain).append("corporateAccountId", corporateAccountId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(address);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(headOfficeId);
        dest.writeValue(phone);
        dest.writeValue(region);
        dest.writeValue(city);
        dest.writeValue(logoUrl);
        dest.writeValue(logoFileName);
        dest.writeValue(logoContentType);
        dest.writeValue(logoFileSize);
        dest.writeValue(logoUpdatedAt);
        dest.writeValue(mrExtension);
        dest.writeValue(strength);
        dest.writeValue(domain);
        dest.writeValue(corporateAccountId);
    }

    public int describeContents() {
        return 0;
    }

}