package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 11/11/2017.
 */

public class PatientInfo implements Parcelable{
    private String phone;

    private String doctor_type;

    private String wellness_card_no;

    private String surgical_history;

    private String diabetes;

    private String city;

    private String recent_diseases;

    private String id;

    private String first_name;

    private String area;

    private String employment_type;

    private String height;

    private String spouse;

    private String gender;



    private String marital_status;

    private String medical_conditions;

    private String allergies;

    private String user_type;

    private String nic;

    private String country_code;

    private String photo;

    private String smoke;

    private String member_id;

    private String country;

    private String patient_type;

    private String conditions;

    private String address;

    private String alcohol;

    private String recreational_drugs;

    private String dob;

    private String hypertension;

    private String last_name;

    private String primary_consultant;
    @SerializedName("user_id")
    private long userId;

    protected PatientInfo(Parcel in) {
        phone = in.readString();
        doctor_type = in.readString();
        wellness_card_no = in.readString();
        surgical_history = in.readString();
        diabetes = in.readString();
        city = in.readString();
        recent_diseases = in.readString();
        id = in.readString();
        first_name = in.readString();
        area = in.readString();
        employment_type = in.readString();
        height = in.readString();
        spouse = in.readString();
        gender = in.readString();

        marital_status = in.readString();
        medical_conditions = in.readString();
        allergies = in.readString();
        user_type = in.readString();
        nic = in.readString();
        country_code = in.readString();
        photo = in.readString();
        smoke = in.readString();
        member_id = in.readString();
        country = in.readString();
        patient_type = in.readString();
        conditions = in.readString();
        address = in.readString();
        alcohol = in.readString();
        recreational_drugs = in.readString();
        dob = in.readString();
        hypertension = in.readString();
        last_name = in.readString();
        primary_consultant = in.readString();
        userId = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(phone);
        dest.writeString(doctor_type);
        dest.writeString(wellness_card_no);
        dest.writeString(surgical_history);
        dest.writeString(diabetes);
        dest.writeString(city);
        dest.writeString(recent_diseases);
        dest.writeString(id);
        dest.writeString(first_name);
        dest.writeString(area);
        dest.writeString(employment_type);
        dest.writeString(height);
        dest.writeString(spouse);
        dest.writeString(gender);
        dest.writeString(marital_status);
        dest.writeString(medical_conditions);
        dest.writeString(allergies);
        dest.writeString(user_type);
        dest.writeString(nic);
        dest.writeString(country_code);
        dest.writeString(photo);
        dest.writeString(smoke);
        dest.writeString(member_id);
        dest.writeString(country);
        dest.writeString(patient_type);
        dest.writeString(conditions);
        dest.writeString(address);
        dest.writeString(alcohol);
        dest.writeString(recreational_drugs);
        dest.writeString(dob);
        dest.writeString(hypertension);
        dest.writeString(last_name);
        dest.writeString(primary_consultant);
        dest.writeLong(userId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PatientInfo> CREATOR = new Creator<PatientInfo>() {
        @Override
        public PatientInfo createFromParcel(Parcel in) {
            return new PatientInfo(in);
        }

        @Override
        public PatientInfo[] newArray(int size) {
            return new PatientInfo[size];
        }
    };

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoctor_type() {
        return doctor_type;
    }

    public void setDoctor_type(String doctor_type) {
        this.doctor_type = doctor_type;
    }

    public String getWellness_card_no() {
        return wellness_card_no;
    }

    public void setWellness_card_no(String wellness_card_no) {
        this.wellness_card_no = wellness_card_no;
    }

    public String getSurgical_history() {
        return surgical_history;
    }

    public void setSurgical_history(String surgical_history) {
        this.surgical_history = surgical_history;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRecent_diseases() {
        return recent_diseases;
    }

    public void setRecent_diseases(String recent_diseases) {
        this.recent_diseases = recent_diseases;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getMedical_conditions() {
        return medical_conditions;
    }

    public void setMedical_conditions(String medical_conditions) {
        this.medical_conditions = medical_conditions;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPatient_type() {
        return patient_type;
    }

    public void setPatient_type(String patient_type) {
        this.patient_type = patient_type;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getRecreational_drugs() {
        return recreational_drugs;
    }

    public void setRecreational_drugs(String recreational_drugs) {
        this.recreational_drugs = recreational_drugs;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPrimary_consultant() {
        return primary_consultant;
    }

    public void setPrimary_consultant(String primary_consultant) {
        this.primary_consultant = primary_consultant;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
