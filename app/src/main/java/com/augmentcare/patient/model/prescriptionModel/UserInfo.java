
package com.augmentcare.patient.model.prescriptionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("nic")
    @Expose
    private String nic;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;

    @SerializedName("spouse")
    @Expose
    private String spouse;

    @SerializedName("employment_type")
    @Expose
    private String employmentType;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("primary_consultant")
    @Expose
    private Object primaryConsultant;

    @SerializedName("user_id")
    @Expose
    private Integer userId;

    @SerializedName("doctor_type")
    @Expose
    private Object doctorType;

    @SerializedName("patient_type")
    @Expose
    private Object patientType;

    @SerializedName("user_type")
    @Expose
    private String userType;

    @SerializedName("allergies")
    @Expose
    private Object allergies;

    @SerializedName("conditions")
    @Expose
    private Object conditions;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("diabetes")
    @Expose
    private Object diabetes;

    @SerializedName("hypertension")
    @Expose
    private Object hypertension;

    @SerializedName("surgical_history")
    @Expose
    private Object surgicalHistory;

    @SerializedName("recent_diseases")
    @Expose
    private Object recentDiseases;

    @SerializedName("medical_conditions")
    @Expose
    private Object medicalConditions;

    @SerializedName("smoke")
    @Expose
    private Object smoke;

    @SerializedName("recreational_drugs")
    @Expose
    private Object recreationalDrugs;

    @SerializedName("alcohol")
    @Expose
    private Object alcohol;

    @SerializedName("member_id")
    @Expose
    private Object memberId;

    @SerializedName("wellness_card_no")
    @Expose
    private Object wellnessCardNo;

    @SerializedName("area")
    @Expose
    private Object area;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("country_code")
    @Expose
    private Object countryCode;

    @SerializedName("other_field1")
    @Expose
    private Object otherField1;

    @SerializedName("other_field2")
    @Expose
    private Object otherField2;

    @SerializedName("beneficiary_type")
    @Expose
    private Object beneficiaryType;

    @SerializedName("designation")
    @Expose
    private Object designation;

    @SerializedName("company_name")
    @Expose
    private Object companyName;

    @SerializedName("status")
    @Expose
    private Object status;

    @SerializedName("guardian_name")
    @Expose
    private Object guardianName;

    @SerializedName("age_in_years")
    @Expose
    private Object ageInYears;

    @SerializedName("city_id")
    @Expose
    private Object cityId;

    @SerializedName("dashboard_status")
    @Expose
    private String dashboardStatus;

    @SerializedName("age_months")
    @Expose
    private Integer ageMonths;

    @SerializedName("age_days")
    @Expose
    private Integer ageDays;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Object getPrimaryConsultant() {
        return primaryConsultant;
    }

    public void setPrimaryConsultant(Object primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(Object doctorType) {
        this.doctorType = doctorType;
    }

    public Object getPatientType() {
        return patientType;
    }

    public void setPatientType(Object patientType) {
        this.patientType = patientType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Object getAllergies() {
        return allergies;
    }

    public void setAllergies(Object allergies) {
        this.allergies = allergies;
    }

    public Object getConditions() {
        return conditions;
    }

    public void setConditions(Object conditions) {
        this.conditions = conditions;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Object getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Object diabetes) {
        this.diabetes = diabetes;
    }

    public Object getHypertension() {
        return hypertension;
    }

    public void setHypertension(Object hypertension) {
        this.hypertension = hypertension;
    }

    public Object getSurgicalHistory() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(Object surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public Object getRecentDiseases() {
        return recentDiseases;
    }

    public void setRecentDiseases(Object recentDiseases) {
        this.recentDiseases = recentDiseases;
    }

    public Object getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(Object medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public Object getSmoke() {
        return smoke;
    }

    public void setSmoke(Object smoke) {
        this.smoke = smoke;
    }

    public Object getRecreationalDrugs() {
        return recreationalDrugs;
    }

    public void setRecreationalDrugs(Object recreationalDrugs) {
        this.recreationalDrugs = recreationalDrugs;
    }

    public Object getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Object alcohol) {
        this.alcohol = alcohol;
    }

    public Object getMemberId() {
        return memberId;
    }

    public void setMemberId(Object memberId) {
        this.memberId = memberId;
    }

    public Object getWellnessCardNo() {
        return wellnessCardNo;
    }

    public void setWellnessCardNo(Object wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public Object getOtherField1() {
        return otherField1;
    }

    public void setOtherField1(Object otherField1) {
        this.otherField1 = otherField1;
    }

    public Object getOtherField2() {
        return otherField2;
    }

    public void setOtherField2(Object otherField2) {
        this.otherField2 = otherField2;
    }

    public Object getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(Object beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public Object getDesignation() {
        return designation;
    }

    public void setDesignation(Object designation) {
        this.designation = designation;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(Object guardianName) {
        this.guardianName = guardianName;
    }

    public Object getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(Object ageInYears) {
        this.ageInYears = ageInYears;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public String getDashboardStatus() {
        return dashboardStatus;
    }

    public void setDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Integer getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(Integer ageDays) {
        this.ageDays = ageDays;
    }

}
