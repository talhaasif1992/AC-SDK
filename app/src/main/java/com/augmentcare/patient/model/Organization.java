package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 24/12/2017.
 */

public class Organization implements Parcelable {

    private String region;

    private String head_office_id;

    private String id;

    private String phone;

    private String updated_at;

    private String logo_updated_at;

    private String address;

    private String logo_content_type;

    private String name;

    private String created_at;

    private String corporate_account_id;

    private String logo_file_size;

    private String logo_file_name;

    private String logo_url;
    @SerializedName("feature_url")
    private String featureURL;

    protected Organization(Parcel in) {
        region = in.readString();
        head_office_id = in.readString();
        id = in.readString();
        phone = in.readString();
        updated_at = in.readString();
        logo_updated_at = in.readString();
        address = in.readString();
        logo_content_type = in.readString();
        name = in.readString();
        created_at = in.readString();
        logo_file_size = in.readString();
        logo_file_name = in.readString();
        logo_url = in.readString();
        featureURL = in.readString();
        corporate_account_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(region);
        dest.writeString(head_office_id);
        dest.writeString(id);
        dest.writeString(phone);
        dest.writeString(updated_at);
        dest.writeString(logo_updated_at);
        dest.writeString(address);
        dest.writeString(logo_content_type);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeString(logo_file_size);
        dest.writeString(logo_file_name);
        dest.writeString(logo_url);
        dest.writeString(featureURL);
        dest.writeString(corporate_account_id);
    }

    public String getCorporate_account_id() {
        return corporate_account_id;
    }

    public void setCorporate_account_id(String corporate_account_id) {
        this.corporate_account_id = corporate_account_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Organization> CREATOR = new Creator<Organization>() {
        @Override
        public Organization createFromParcel(Parcel in) {
            return new Organization(in);
        }

        @Override
        public Organization[] newArray(int size) {
            return new Organization[size];
        }
    };

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHead_office_id() {
        return head_office_id;
    }

    public void setHead_office_id(String head_office_id) {
        this.head_office_id = head_office_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLogo_updated_at() {
        return logo_updated_at;
    }

    public void setLogo_updated_at(String logo_updated_at) {
        this.logo_updated_at = logo_updated_at;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo_content_type() {
        return logo_content_type;
    }

    public void setLogo_content_type(String logo_content_type) {
        this.logo_content_type = logo_content_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLogo_file_size() {
        return logo_file_size;
    }

    public void setLogo_file_size(String logo_file_size) {
        this.logo_file_size = logo_file_size;
    }

    public String getLogo_file_name() {
        return logo_file_name;
    }

    public void setLogo_file_name(String logo_file_name) {
        this.logo_file_name = logo_file_name;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getFeatureURL() {
        return featureURL;
    }

    public void setFeatureURL(String featureURL) {
        this.featureURL = featureURL;
    }
}
