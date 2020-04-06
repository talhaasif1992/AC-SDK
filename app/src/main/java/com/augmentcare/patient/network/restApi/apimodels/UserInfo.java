
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserInfo implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
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
    private String primaryConsultant;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("doctor_type")
    @Expose
    private String doctorType;
    @SerializedName("patient_type")
    @Expose
    private String patientType;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("allergies")
    @Expose
    private String allergies;
    @SerializedName("conditions")
    @Expose
    private String conditions;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("diabetes")
    @Expose
    private String diabetes;
    @SerializedName("hypertension")
    @Expose
    private String hypertension;
    @SerializedName("surgical_history")
    @Expose
    private String surgicalHistory;
    @SerializedName("recent_diseases")
    @Expose
    private String recentDiseases;
    @SerializedName("medical_conditions")
    @Expose
    private String medicalConditions;
    @SerializedName("smoke")
    @Expose
    private String smoke;
    @SerializedName("recreational_drugs")
    @Expose
    private String recreationalDrugs;
    @SerializedName("alcohol")
    @Expose
    private String alcohol;
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("wellness_card_no")
    @Expose
    private String wellnessCardNo;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("other_field1")
    @Expose
    private String otherField1;
    @SerializedName("other_field2")
    @Expose
    private String otherField2;
    @SerializedName("beneficiary_type")
    @Expose
    private String beneficiaryType;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("guardian_name")
    @Expose
    private String guardianName;
    @SerializedName("age_in_years")
    @Expose
    private String ageInYears;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("dashboard_status")
    @Expose
    private String dashboardStatus;
    @SerializedName("age_months")
    @Expose
    private int ageMonths;
    @SerializedName("age_days")
    @Expose
    private int ageDays;
    @SerializedName("guardian_type")
    @Expose
    private String guardianType;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("dr_fullname")
    @Expose
    private String drFullname;
    public final static Creator<UserInfo> CREATOR = new Creator<UserInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(int size) {
            return (new UserInfo[size]);
        }

    }
    ;

    protected UserInfo(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.nic = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.maritalStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.spouse = ((String) in.readValue((String.class.getClassLoader())));
        this.employmentType = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryConsultant = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((int) in.readValue((int.class.getClassLoader())));
        this.doctorType = ((String) in.readValue((String.class.getClassLoader())));
        this.patientType = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
        this.allergies = ((String) in.readValue((String.class.getClassLoader())));
        this.conditions = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.diabetes = ((String) in.readValue((String.class.getClassLoader())));
        this.hypertension = ((String) in.readValue((String.class.getClassLoader())));
        this.surgicalHistory = ((String) in.readValue((String.class.getClassLoader())));
        this.recentDiseases = ((String) in.readValue((String.class.getClassLoader())));
        this.medicalConditions = ((String) in.readValue((String.class.getClassLoader())));
        this.smoke = ((String) in.readValue((String.class.getClassLoader())));
        this.recreationalDrugs = ((String) in.readValue((String.class.getClassLoader())));
        this.alcohol = ((String) in.readValue((String.class.getClassLoader())));
        this.memberId = ((String) in.readValue((String.class.getClassLoader())));
        this.wellnessCardNo = ((String) in.readValue((String.class.getClassLoader())));
        this.area = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCode = ((String) in.readValue((String.class.getClassLoader())));
        this.otherField1 = ((String) in.readValue((String.class.getClassLoader())));
        this.otherField2 = ((String) in.readValue((String.class.getClassLoader())));
        this.beneficiaryType = ((String) in.readValue((String.class.getClassLoader())));
        this.designation = ((String) in.readValue((String.class.getClassLoader())));
        this.companyName = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.guardianName = ((String) in.readValue((String.class.getClassLoader())));
        this.ageInYears = ((String) in.readValue((String.class.getClassLoader())));
        this.cityId = ((String) in.readValue((String.class.getClassLoader())));
        this.dashboardStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.ageMonths = ((int) in.readValue((int.class.getClassLoader())));
        this.ageDays = ((int) in.readValue((int.class.getClassLoader())));
        this.guardianType = ((String) in.readValue((String.class.getClassLoader())));
        this.weight = ((String) in.readValue((String.class.getClassLoader())));
        this.drFullname = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserInfo withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserInfo withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public UserInfo withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserInfo withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public UserInfo withNic(String nic) {
        this.nic = nic;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserInfo withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserInfo withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserInfo withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public UserInfo withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public UserInfo withSpouse(String spouse) {
        this.spouse = spouse;
        return this;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public UserInfo withEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserInfo withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getPrimaryConsultant() {
        return primaryConsultant;
    }

    public void setPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
    }

    public UserInfo withPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserInfo withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public UserInfo withDoctorType(String doctorType) {
        this.doctorType = doctorType;
        return this;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public UserInfo withPatientType(String patientType) {
        this.patientType = patientType;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserInfo withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public UserInfo withAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public UserInfo withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public UserInfo withHeight(String height) {
        this.height = height;
        return this;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public UserInfo withDiabetes(String diabetes) {
        this.diabetes = diabetes;
        return this;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public UserInfo withHypertension(String hypertension) {
        this.hypertension = hypertension;
        return this;
    }

    public String getSurgicalHistory() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public UserInfo withSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
        return this;
    }

    public String getRecentDiseases() {
        return recentDiseases;
    }

    public void setRecentDiseases(String recentDiseases) {
        this.recentDiseases = recentDiseases;
    }

    public UserInfo withRecentDiseases(String recentDiseases) {
        this.recentDiseases = recentDiseases;
        return this;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public UserInfo withMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
        return this;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public UserInfo withSmoke(String smoke) {
        this.smoke = smoke;
        return this;
    }

    public String getRecreationalDrugs() {
        return recreationalDrugs;
    }

    public void setRecreationalDrugs(String recreationalDrugs) {
        this.recreationalDrugs = recreationalDrugs;
    }

    public UserInfo withRecreationalDrugs(String recreationalDrugs) {
        this.recreationalDrugs = recreationalDrugs;
        return this;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public UserInfo withAlcohol(String alcohol) {
        this.alcohol = alcohol;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public UserInfo withMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getWellnessCardNo() {
        return wellnessCardNo;
    }

    public void setWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
    }

    public UserInfo withWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public UserInfo withArea(String area) {
        this.area = area;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserInfo withCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public UserInfo withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getOtherField1() {
        return otherField1;
    }

    public void setOtherField1(String otherField1) {
        this.otherField1 = otherField1;
    }

    public UserInfo withOtherField1(String otherField1) {
        this.otherField1 = otherField1;
        return this;
    }

    public String getOtherField2() {
        return otherField2;
    }

    public void setOtherField2(String otherField2) {
        this.otherField2 = otherField2;
    }

    public UserInfo withOtherField2(String otherField2) {
        this.otherField2 = otherField2;
        return this;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public UserInfo withBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public UserInfo withDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public UserInfo withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserInfo withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public UserInfo withGuardianName(String guardianName) {
        this.guardianName = guardianName;
        return this;
    }

    public String getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(String ageInYears) {
        this.ageInYears = ageInYears;
    }

    public UserInfo withAgeInYears(String ageInYears) {
        this.ageInYears = ageInYears;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public UserInfo withCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getDashboardStatus() {
        return dashboardStatus;
    }

    public void setDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
    }

    public UserInfo withDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
        return this;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public UserInfo withAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
        return this;
    }

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    public UserInfo withAgeDays(int ageDays) {
        this.ageDays = ageDays;
        return this;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }

    public UserInfo withGuardianType(String guardianType) {
        this.guardianType = guardianType;
        return this;
    }
    public UserInfo withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public UserInfo withDrFullName(String drFullName) {
        this.drFullname = drFullName;
        return this;
    }

    public String getDrFullName() {
        return drFullname;
    }

    public void setDrFullName(String drFullname) {
        this.drFullname = drFullname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("dob", dob).append("gender", gender).append("nic", nic).append("phone", phone).append("address", address).append("country", country).append("maritalStatus", maritalStatus).append("spouse", spouse).append("employmentType", employmentType).append("photo", photo).append("primaryConsultant", primaryConsultant).append("userId", userId).append("doctorType", doctorType).append("patientType", patientType).append("userType", userType).append("allergies", allergies).append("conditions", conditions).append("height", height).append("diabetes", diabetes).append("hypertension", hypertension).append("surgicalHistory", surgicalHistory).append("recentDiseases", recentDiseases).append("medicalConditions", medicalConditions).append("smoke", smoke).append("recreationalDrugs", recreationalDrugs).append("alcohol", alcohol).append("memberId", memberId).append("wellnessCardNo", wellnessCardNo).append("area", area).append("city", city).append("countryCode", countryCode).append("otherField1", otherField1).append("otherField2", otherField2).append("beneficiaryType", beneficiaryType).append("designation", designation).append("companyName", companyName).append("status", status).append("guardianName", guardianName).append("ageInYears", ageInYears).append("cityId", cityId).append("dashboardStatus", dashboardStatus).append("ageMonths", ageMonths).append("ageDays", ageDays).append("guardianType", guardianType).append("weight", weight).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(dob);
        dest.writeValue(gender);
        dest.writeValue(nic);
        dest.writeValue(phone);
        dest.writeValue(address);
        dest.writeValue(country);
        dest.writeValue(maritalStatus);
        dest.writeValue(spouse);
        dest.writeValue(employmentType);
        dest.writeValue(photo);
        dest.writeValue(primaryConsultant);
        dest.writeValue(userId);
        dest.writeValue(doctorType);
        dest.writeValue(patientType);
        dest.writeValue(userType);
        dest.writeValue(allergies);
        dest.writeValue(conditions);
        dest.writeValue(height);
        dest.writeValue(diabetes);
        dest.writeValue(hypertension);
        dest.writeValue(surgicalHistory);
        dest.writeValue(recentDiseases);
        dest.writeValue(medicalConditions);
        dest.writeValue(smoke);
        dest.writeValue(recreationalDrugs);
        dest.writeValue(alcohol);
        dest.writeValue(memberId);
        dest.writeValue(wellnessCardNo);
        dest.writeValue(area);
        dest.writeValue(city);
        dest.writeValue(countryCode);
        dest.writeValue(otherField1);
        dest.writeValue(otherField2);
        dest.writeValue(beneficiaryType);
        dest.writeValue(designation);
        dest.writeValue(companyName);
        dest.writeValue(status);
        dest.writeValue(guardianName);
        dest.writeValue(ageInYears);
        dest.writeValue(cityId);
        dest.writeValue(dashboardStatus);
        dest.writeValue(ageMonths);
        dest.writeValue(ageDays);
        dest.writeValue(guardianType);
        dest.writeValue(weight);
        dest.writeValue(drFullname);
    }

    public int describeContents() {
        return  0;
    }

}
