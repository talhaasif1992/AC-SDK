package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable {

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
    @SerializedName("email")
    @Expose
    private String email;
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
    public final static Parcelable.Creator<Profile> CREATOR = new Creator<Profile>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        public Profile[] newArray(int size) {
            return (new Profile[size]);
        }

    };

    protected Profile(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.nic = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
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
    }

    /**
     * No args constructor for use in serialization
     */
    public Profile() {
    }

    /**
     * @param allergies
     * @param lastName
     * @param country
     * @param surgicalHistory
     * @param ageMonths
     * @param gender
     * @param city
     * @param companyName
     * @param guardianType
     * @param nic
     * @param patientType
     * @param cityId
     * @param wellnessCardNo
     * @param spouse
     * @param guardianName
     * @param countryCode
     * @param ageInYears
     * @param ageDays
     * @param id
     * @param recentDiseases
     * @param height
     * @param memberId
     * @param alcohol
     * @param area
     * @param doctorType
     * @param otherField1
     * @param address
     * @param employmentType
     * @param dashboardStatus
     * @param smoke
     * @param photo
     * @param weight
     * @param userId
     * @param otherField2
     * @param recreationalDrugs
     * @param medicalConditions
     * @param firstName
     * @param primaryConsultant
     * @param phone
     * @param dob
     * @param beneficiaryType
     * @param userType
     * @param designation
     * @param conditions
     * @param diabetes
     * @param hypertension
     * @param maritalStatus
     * @param status
     */
    public Profile(int id, String firstName, String lastName, String dob, String gender, String nic, String phone, String email, String address, String country, String maritalStatus, String spouse, String employmentType, String photo, String primaryConsultant, int userId, String doctorType, String patientType, String userType, String allergies, String conditions, String height, String diabetes, String hypertension, String surgicalHistory, String recentDiseases, String medicalConditions, String smoke, String recreationalDrugs, String alcohol, String memberId, String wellnessCardNo, String area, String city, String countryCode, String otherField1, String otherField2, String beneficiaryType, String designation, String companyName, String status, String guardianName, String ageInYears, String cityId, String dashboardStatus, int ageMonths, int ageDays, String guardianType, String weight) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.country = country;
        this.maritalStatus = maritalStatus;
        this.spouse = spouse;
        this.employmentType = employmentType;
        this.photo = photo;
        this.primaryConsultant = primaryConsultant;
        this.userId = userId;
        this.doctorType = doctorType;
        this.patientType = patientType;
        this.userType = userType;
        this.allergies = allergies;
        this.conditions = conditions;
        this.height = height;
        this.diabetes = diabetes;
        this.hypertension = hypertension;
        this.surgicalHistory = surgicalHistory;
        this.recentDiseases = recentDiseases;
        this.medicalConditions = medicalConditions;
        this.smoke = smoke;
        this.recreationalDrugs = recreationalDrugs;
        this.alcohol = alcohol;
        this.memberId = memberId;
        this.wellnessCardNo = wellnessCardNo;
        this.area = area;
        this.city = city;
        this.countryCode = countryCode;
        this.otherField1 = otherField1;
        this.otherField2 = otherField2;
        this.beneficiaryType = beneficiaryType;
        this.designation = designation;
        this.companyName = companyName;
        this.status = status;
        this.guardianName = guardianName;
        this.ageInYears = ageInYears;
        this.cityId = cityId;
        this.dashboardStatus = dashboardStatus;
        this.ageMonths = ageMonths;
        this.ageDays = ageDays;
        this.guardianType = guardianType;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Profile withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Profile withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Profile withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Profile withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Profile withNic(String nic) {
        this.nic = nic;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profile withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail(){ return email;}

    public void setEmail(String email){ this.email = email; }

    public Profile withEmail(String email){
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Profile withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Profile withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Profile withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public Profile withSpouse(String spouse) {
        this.spouse = spouse;
        return this;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public Profile withEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Profile withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getPrimaryConsultant() {
        return primaryConsultant;
    }

    public void setPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
    }

    public Profile withPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Profile withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public Profile withDoctorType(String doctorType) {
        this.doctorType = doctorType;
        return this;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public Profile withPatientType(String patientType) {
        this.patientType = patientType;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Profile withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Profile withAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Profile withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Profile withHeight(String height) {
        this.height = height;
        return this;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public Profile withDiabetes(String diabetes) {
        this.diabetes = diabetes;
        return this;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public Profile withHypertension(String hypertension) {
        this.hypertension = hypertension;
        return this;
    }

    public String getSurgicalHistory() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public Profile withSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
        return this;
    }

    public String getRecentDiseases() {
        return recentDiseases;
    }

    public void setRecentDiseases(String recentDiseases) {
        this.recentDiseases = recentDiseases;
    }

    public Profile withRecentDiseases(String recentDiseases) {
        this.recentDiseases = recentDiseases;
        return this;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public Profile withMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
        return this;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public Profile withSmoke(String smoke) {
        this.smoke = smoke;
        return this;
    }

    public String getRecreationalDrugs() {
        return recreationalDrugs;
    }

    public void setRecreationalDrugs(String recreationalDrugs) {
        this.recreationalDrugs = recreationalDrugs;
    }

    public Profile withRecreationalDrugs(String recreationalDrugs) {
        this.recreationalDrugs = recreationalDrugs;
        return this;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public Profile withAlcohol(String alcohol) {
        this.alcohol = alcohol;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Profile withMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getWellnessCardNo() {
        return wellnessCardNo;
    }

    public void setWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
    }

    public Profile withWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Profile withArea(String area) {
        this.area = area;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Profile withCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Profile withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getOtherField1() {
        return otherField1;
    }

    public void setOtherField1(String otherField1) {
        this.otherField1 = otherField1;
    }

    public Profile withOtherField1(String otherField1) {
        this.otherField1 = otherField1;
        return this;
    }

    public String getOtherField2() {
        return otherField2;
    }

    public void setOtherField2(String otherField2) {
        this.otherField2 = otherField2;
    }

    public Profile withOtherField2(String otherField2) {
        this.otherField2 = otherField2;
        return this;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public Profile withBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Profile withDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Profile withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Profile withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public Profile withGuardianName(String guardianName) {
        this.guardianName = guardianName;
        return this;
    }

    public String getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(String ageInYears) {
        this.ageInYears = ageInYears;
    }

    public Profile withAgeInYears(String ageInYears) {
        this.ageInYears = ageInYears;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Profile withCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getDashboardStatus() {
        return dashboardStatus;
    }

    public void setDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
    }

    public Profile withDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
        return this;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Profile withAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
        return this;
    }

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    public Profile withAgeDays(int ageDays) {
        this.ageDays = ageDays;
        return this;
    }

    public String getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(String guardianType) {
        this.guardianType = guardianType;
    }

    public Profile withGuardianType(String guardianType) {
        this.guardianType = guardianType;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Profile withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(dob);
        dest.writeValue(gender);
        dest.writeValue(nic);
        dest.writeValue(phone);
        dest.writeValue(email);
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
    }

    public int describeContents() {
        return 0;
    }

}