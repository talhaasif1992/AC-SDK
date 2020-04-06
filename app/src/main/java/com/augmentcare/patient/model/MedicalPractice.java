package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MedicalPractice implements Parcelable{
    private boolean ambulance;

    private String  logo_content_type;

    private boolean emergency;

    private String logo_file_size;

    private boolean wheel_chair;

    private String type;

    private String  logo_file_name;

    private String id;

    private String cover_file_name;

    private String description;

    private String name;

    private String no_of_beds;

    private String created_at;

    private String cover_updated_at;

    private String is_unlimited;

    private String logo;

    private String docter_id;

    private String services;

    private String no_of_doctors;

    private String start_day;

    private String[] contact_number;

    private String updated_at;

    private String logo_updated_at;

    private String cover_file_size;

    private String end_day;

    private String cover_content_type;

    public MedicalPractice(){}
    protected MedicalPractice(Parcel in) {
        ambulance = in.readByte() != 0;
        logo_content_type = in.readString();
        emergency = in.readByte() != 0;
        logo_file_size = in.readString();
        wheel_chair = in.readByte() != 0;
        type = in.readString();
        logo_file_name = in.readString();
        id = in.readString();
        cover_file_name = in.readString();
        description = in.readString();
        name = in.readString();
        no_of_beds = in.readString();
        created_at = in.readString();
        cover_updated_at = in.readString();
        is_unlimited = in.readString();
        logo = in.readString();
        docter_id = in.readString();
        services = in.readString();
        no_of_doctors = in.readString();
        start_day = in.readString();
        contact_number = in.createStringArray();
        updated_at = in.readString();
        logo_updated_at = in.readString();
        cover_file_size = in.readString();
        end_day = in.readString();
        cover_content_type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (ambulance ? 1 : 0));
        dest.writeString(logo_content_type);
        dest.writeByte((byte) (emergency ? 1 : 0));
        dest.writeString(logo_file_size);
        dest.writeByte((byte) (wheel_chair ? 1 : 0));
        dest.writeString(type);
        dest.writeString(logo_file_name);
        dest.writeString(id);
        dest.writeString(cover_file_name);
        dest.writeString(description);
        dest.writeString(name);
        dest.writeString(no_of_beds);
        dest.writeString(created_at);
        dest.writeString(cover_updated_at);
        dest.writeString(is_unlimited);
        dest.writeString(logo);
        dest.writeString(docter_id);
        dest.writeString(services);
        dest.writeString(no_of_doctors);
        dest.writeString(start_day);
        dest.writeStringArray(contact_number);
        dest.writeString(updated_at);
        dest.writeString(logo_updated_at);
        dest.writeString(cover_file_size);
        dest.writeString(end_day);
        dest.writeString(cover_content_type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MedicalPractice> CREATOR = new Creator<MedicalPractice>() {
        @Override
        public MedicalPractice createFromParcel(Parcel in) {
            return new MedicalPractice(in);
        }

        @Override
        public MedicalPractice[] newArray(int size) {
            return new MedicalPractice[size];
        }
    };

    public boolean isAmbulance() {
        return ambulance;
    }

    public void setAmbulance(boolean ambulance) {
        this.ambulance = ambulance;
    }

    public String getLogo_content_type() {
        return logo_content_type;
    }

    public void setLogo_content_type(String logo_content_type) {
        this.logo_content_type = logo_content_type;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public String getLogo_file_size() {
        return logo_file_size;
    }

    public void setLogo_file_size(String logo_file_size) {
        this.logo_file_size = logo_file_size;
    }

    public boolean isWheel_chair() {
        return wheel_chair;
    }

    public void setWheel_chair(boolean wheel_chair) {
        this.wheel_chair = wheel_chair;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo_file_name() {
        return logo_file_name;
    }

    public void setLogo_file_name(String logo_file_name) {
        this.logo_file_name = logo_file_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover_file_name() {
        return cover_file_name;
    }

    public void setCover_file_name(String cover_file_name) {
        this.cover_file_name = cover_file_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo_of_beds() {
        return no_of_beds;
    }

    public void setNo_of_beds(String no_of_beds) {
        this.no_of_beds = no_of_beds;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCover_updated_at() {
        return cover_updated_at;
    }

    public void setCover_updated_at(String cover_updated_at) {
        this.cover_updated_at = cover_updated_at;
    }

    public String getIs_unlimited() {
        return is_unlimited;
    }

    public void setIs_unlimited(String is_unlimited) {
        this.is_unlimited = is_unlimited;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDocter_id() {
        return docter_id;
    }

    public void setDocter_id(String docter_id) {
        this.docter_id = docter_id;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getNo_of_doctors() {
        return no_of_doctors;
    }

    public void setNo_of_doctors(String no_of_doctors) {
        this.no_of_doctors = no_of_doctors;
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String[] getContact_number() {
        return contact_number;
    }

    public void setContact_number(String[] contact_number) {
        this.contact_number = contact_number;
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

    public String getCover_file_size() {
        return cover_file_size;
    }

    public void setCover_file_size(String cover_file_size) {
        this.cover_file_size = cover_file_size;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getCover_content_type() {
        return cover_content_type;
    }

    public void setCover_content_type(String cover_content_type) {
        this.cover_content_type = cover_content_type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MedicalPractice){
            MedicalPractice inPractice = (MedicalPractice) obj;
            if(inPractice.id == null)
                return id == inPractice.id;
            else
                return inPractice.id.equals(id);
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return ""+ name;
    }
}
