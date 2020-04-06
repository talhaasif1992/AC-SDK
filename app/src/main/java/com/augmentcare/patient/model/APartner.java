package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 27/03/2018.
 */

public class APartner implements Parcelable{

    private String id;

    private String updated_at;

    private String logo_updated_at;

    private String address;

    private String api_key;

    private String logo_content_type;

    private String name;

    private String created_at;

    private String logo_file_size;

    private String center_type;

    private String logo_file_name;

    protected APartner(Parcel in) {
        id = in.readString();
        updated_at = in.readString();
        logo_updated_at = in.readString();
        address = in.readString();
        api_key = in.readString();
        logo_content_type = in.readString();
        name = in.readString();
        created_at = in.readString();
        logo_file_size = in.readString();
        center_type = in.readString();
        logo_file_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(updated_at);
        dest.writeString(logo_updated_at);
        dest.writeString(address);
        dest.writeString(api_key);
        dest.writeString(logo_content_type);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeString(logo_file_size);
        dest.writeString(center_type);
        dest.writeString(logo_file_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<APartner> CREATOR = new Creator<APartner>() {
        @Override
        public APartner createFromParcel(Parcel in) {
            return new APartner(in);
        }

        @Override
        public APartner[] newArray(int size) {
            return new APartner[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
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

    public String getCenter_type() {
        return center_type;
    }

    public void setCenter_type(String center_type) {
        this.center_type = center_type;
    }

    public String getLogo_file_name() {
        return logo_file_name;
    }

    public void setLogo_file_name(String logo_file_name) {
        this.logo_file_name = logo_file_name;
    }
}
