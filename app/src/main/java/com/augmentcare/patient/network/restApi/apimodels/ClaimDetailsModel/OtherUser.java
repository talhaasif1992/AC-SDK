package com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OtherUser  implements Serializable {
    @Expose
    @SerializedName("age_days")
    private int ageDays;
    @Expose
    @SerializedName("age_months")
    private int ageMonths;
    @Expose
    @SerializedName("dashboard_status")
    private String dashboardStatus;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("user_type")
    private String userType;
    @Expose
    @SerializedName("user_id")
    private int userId;
    @Expose
    @SerializedName("photo")
    private String photo;
    @Expose
    @SerializedName("employment_type")
    private String employmentType;
    @Expose
    @SerializedName("spouse")
    private String spouse;
    @Expose
    @SerializedName("marital_status")
    private String maritalStatus;
    @Expose
    @SerializedName("country")
    private String country;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("nic")
    private String nic;
    @Expose
    @SerializedName("gender")
    private String gender;
    @Expose
    @SerializedName("dob")
    private String dob;
    @Expose
    @SerializedName("last_name")
    private String lastName;
    @Expose
    @SerializedName("first_name")
    private String firstName;
    @Expose
    @SerializedName("id")
    private int id;

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public String getDashboardStatus() {
        return dashboardStatus;
    }

    public void setDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
