package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class UserInfo implements Parcelable {
    private String uid;

    private String phone;
    @SerializedName("doctor_type")
    private String doctorType;
    @SerializedName("wellness_card_no")
    private String wellnessCardNo;
    @SerializedName("confirmed_at")
    private String confirmedAt;

    public String getPlanId500() {
        return planId500;
    }

    public void setPlanId500(String planId500) {
        this.planId500 = planId500;
    }

    @SerializedName("plan_id_500")

    private String planId500;

    private String id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("employment_type")
    private String employmentType;

    private String spouse;

    private String gender;

    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("marital_status")
    private String maritalStatus;
    @SerializedName("user_type")
    private String userType;

    private String nic;

    private String provider;

    private String photo;

    private String country;
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("patient_type")
    private String patientType;

    private String address;

    private String email;

    private String dob;
    @SerializedName("last_name")
    private String lastName;

    @SerializedName("androidhmc")
    private String androidhmc;

    @SerializedName("primary_consultant")
    private String primaryConsultant;
    private String height;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String address1;
    private String address2;
    private String area;
    private String city;
    /*private String allergies;
    private String alcohol;
    private String conditions;
    private String diabetes;
    private String height;
    private String hypertension;
    private String medical_conditions;
    private String recent_diseases;
    private String recreational_drugs;
    private String smoke;
    private String surgical_history;*/

    protected UserInfo(Parcel in) {
        uid = in.readString();
        phone = in.readString();
        doctorType = in.readString();
        wellnessCardNo = in.readString();
        confirmedAt = in.readString();
        id = in.readString();
        firstName = in.readString();
        employmentType = in.readString();
        spouse = in.readString();
        gender = in.readString();
        createdAt = in.readString();
        userId = in.readLong();
        maritalStatus = in.readString();
        userType = in.readString();
        nic = in.readString();
        provider = in.readString();
        photo = in.readString();
        country = in.readString();
        memberId = in.readString();
        patientType = in.readString();
        address = in.readString();
        email = in.readString();
        planId500 = in.readString();
        dob = in.readString();
        lastName = in.readString();
        primaryConsultant = in.readString();
        height = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        area = in.readString();
        city = in.readString();
        androidhmc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(phone);
        dest.writeString(doctorType);
        dest.writeString(wellnessCardNo);
        dest.writeString(confirmedAt);
        dest.writeString(id);
        dest.writeString(firstName);
        dest.writeString(employmentType);
        dest.writeString(spouse);
        dest.writeString(gender);
        dest.writeString(createdAt);
        dest.writeLong(userId);
        dest.writeString(maritalStatus);
        dest.writeString(userType);
        dest.writeString(nic);
        dest.writeString(provider);
        dest.writeString(photo);
        dest.writeString(country);
        dest.writeString(memberId);
        dest.writeString(patientType);
        dest.writeString(address);
        dest.writeString(email);
        dest.writeString(planId500);
        dest.writeString(dob);
        dest.writeString(lastName);
        dest.writeString(primaryConsultant);
        dest.writeString(height);
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(area);
        dest.writeString(city);
        dest.writeString(androidhmc);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getWellnessCardNo() {
        return wellnessCardNo;
    }

    public void setWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
    }

    public String getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(String confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryConsultant() {
        return primaryConsultant;
    }

    public void setPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAndroidhmc() {
        return androidhmc;
    }

    public void setAndroidhmc(String androidhmc) {
        this.androidhmc = androidhmc;
    }
}
