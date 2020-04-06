package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by qamar on 17/01/2018.
 */

public class DoctorItem implements Parcelable{
    private String consultation_rate;

    private String user_role_id;

    private boolean on_policy;

    private String role_id;

    private String doctor_uid;

    private String no_of_experience;

    private String average_rating;

    private String consultation_duration;

    private ArrayList<String> education;

    private ArrayList<String> specializations;
    private ArrayList<String> specialization_cond;

    private String channel_key;

    private String[] cities;

    private String name;

    private ArrayList<String> experience;

    private String user_id;

    private String thumb;

    private String docter_rating;

    private boolean is_free;


    protected DoctorItem(Parcel in) {
        consultation_rate = in.readString();
        user_role_id = in.readString();
        on_policy = in.readByte() != 0;
        role_id = in.readString();
        doctor_uid = in.readString();
        no_of_experience = in.readString();
        average_rating = in.readString();
        consultation_duration = in.readString();
        education = in.createStringArrayList();
        specializations = in.createStringArrayList();
        specialization_cond = in.createStringArrayList();
        channel_key = in.readString();
        cities = in.createStringArray();
        name = in.readString();
        experience = in.createStringArrayList();
        user_id = in.readString();
        thumb = in.readString();
        docter_rating = in.readString();
        is_free = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(consultation_rate);
        dest.writeString(user_role_id);
        dest.writeByte((byte) (on_policy ? 1 : 0));
        dest.writeString(role_id);
        dest.writeString(doctor_uid);
        dest.writeString(no_of_experience);
        dest.writeString(average_rating);
        dest.writeString(consultation_duration);
        dest.writeStringList(education);
        dest.writeStringList(specializations);
        dest.writeStringList(specialization_cond);
        dest.writeString(channel_key);
        dest.writeStringArray(cities);
        dest.writeString(name);
        dest.writeStringList(experience);
        dest.writeString(user_id);
        dest.writeString(thumb);
        dest.writeString(docter_rating);
        dest.writeByte((byte) (is_free ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DoctorItem> CREATOR = new Creator<DoctorItem>() {
        @Override
        public DoctorItem createFromParcel(Parcel in) {
            return new DoctorItem(in);
        }

        @Override
        public DoctorItem[] newArray(int size) {
            return new DoctorItem[size];
        }
    };

    public String getConsultation_rate() {
        return consultation_rate;
    }

    public void setConsultation_rate(String consultation_rate) {
        this.consultation_rate = consultation_rate;
    }

    public String getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(String user_role_id) {
        this.user_role_id = user_role_id;
    }

    public boolean getOn_policy() {
        return on_policy;
    }

    public void setOn_policy(boolean on_policy) {
        this.on_policy = on_policy;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getDoctor_uid() {
        return doctor_uid;
    }

    public void setDoctor_uid(String doctor_uid) {
        this.doctor_uid = doctor_uid;
    }

    public String getNo_of_experience() {
        return no_of_experience;
    }

    public void setNo_of_experience(String no_of_experience) {
        this.no_of_experience = no_of_experience;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getConsultation_duration() {
        return consultation_duration;
    }

    public void setConsultation_duration(String consultation_duration) {
        this.consultation_duration = consultation_duration;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    public ArrayList<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(ArrayList<String> specializations) {
        this.specializations = specializations;
    }

    public String getChannel_key() {
        return channel_key;
    }

    public void setChannel_key(String channel_key) {
        this.channel_key = channel_key;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<String> experience) {
        this.experience = experience;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDocter_rating() {
        return docter_rating;
    }

    public void setDocter_rating(String docter_rating) {
        this.docter_rating = docter_rating;
    }

    public boolean getIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public ArrayList<String> getSpecialization_cond() {
        return specialization_cond;
    }

    public void setSpecialization_cond(ArrayList<String> specialization_cond) {
        this.specialization_cond = specialization_cond;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DoctorItem){
            try{
            DoctorItem item = (DoctorItem) obj;
            return item.getDoctor_uid().equalsIgnoreCase(doctor_uid);
            }catch (Exception e){
                return false;
            }
        }else{
            return false;
        }
    }
}
