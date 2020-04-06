package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserDataLogin implements Parcelable {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("phone_verified")
    @Expose
    private String phoneVerified;
    @SerializedName("verify_phone")
    @Expose
    private boolean update_phone;
    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("spouse")
    @Expose
    private String spouse;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("employment_type")
    @Expose
    private String employmentType;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("primary_consultant")
    @Expose
    private String primaryConsultant;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("patient_type")
    @Expose
    private String patientType;
    @SerializedName("doctor_type")
    @Expose
    private String doctorType;
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("wellness_card_no")
    @Expose
    private String wellnessCardNo;
    @SerializedName("dashboard_status")
    @Expose
    private String dashboardStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("confirmed_at")
    @Expose
    private String confirmedAt;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("is_doctor_contact_me")
    @Expose
    private boolean isDoctorContactMe;
    @SerializedName("part_of_project")
    @Expose
    private String partOfProject;
    @SerializedName("on_trail")
    @Expose
    private boolean onTrail;
    @SerializedName("trail_start_date")
    @Expose
    private String trailStartDate;
    @SerializedName("trail_end_date")
    @Expose
    private String trailEndDate;
    @SerializedName("inhmc")
    @Expose
    private String inhmc;
    @SerializedName("iohmc")
    @Expose
    private String iohmc;
    @SerializedName("androidhmc")
    @Expose
    private String androidhmc;
    public final static Parcelable.Creator<UserDataLogin> CREATOR = new Creator<UserDataLogin>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserDataLogin createFromParcel(Parcel in) {
            return new UserDataLogin(in);
        }

        public UserDataLogin[] newArray(int size) {
            return (new UserDataLogin[size]);
        }

    };

    protected UserDataLogin(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.uid = ((String) in.readValue((String.class.getClassLoader())));
        this.provider = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((int) in.readValue((int.class.getClassLoader())));
        this.phoneVerified = ((String) in.readValue((String.class.getClassLoader())));
        this.update_phone = ((boolean) in.readValue(boolean.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.nic = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.spouse = ((String) in.readValue((String.class.getClassLoader())));
        this.maritalStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.employmentType = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryConsultant = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
        this.patientType = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorType = ((String) in.readValue((String.class.getClassLoader())));
        this.memberId = ((String) in.readValue((String.class.getClassLoader())));
        this.wellnessCardNo = ((String) in.readValue((String.class.getClassLoader())));
        this.dashboardStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.isDoctorContactMe = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.partOfProject = ((String) in.readValue((String.class.getClassLoader())));
        this.onTrail = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.trailStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.trailEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.inhmc = ((String) in.readValue((String.class.getClassLoader())));
        this.iohmc = ((String) in.readValue((String.class.getClassLoader())));
        this.androidhmc = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public UserDataLogin(){}

    /**
     * @param lastName
     * @param country
     * @param inhmc
     * @param gender
     * @param nic
     * @param patientType
     * @param wellnessCardNo
     * @param deviceId
     * @param spouse
     * @param uid
     * @param createdAt
     * @param provider
     * @param id
     * @param trailEndDate
     * @param email
     * @param memberId
     * @param doctorType
     * @param address
     * @param iohmc
     * @param employmentType
     * @param phoneVerified
     * @param dashboardStatus
     * @param photo
     * @param userId
     * @param partOfProject
     * @param firstName
     * @param isDoctorContactMe
     * @param primaryConsultant
     * @param phone
     * @param dob
     * @param androidhmc
     * @param onTrail
     * @param userType
     * @param trailStartDate
     * @param confirmedAt
     * @param maritalStatus
     */
    public UserDataLogin(String email, String uid, String provider, int userId, String phoneVerified,boolean updatePhone, String id, String firstName, String lastName, String dob, String gender, String nic, String phone, String address, String country, String spouse, String maritalStatus, String employmentType, String photo, String primaryConsultant, String userType, String patientType, String doctorType, String memberId, String wellnessCardNo, String dashboardStatus, String createdAt, String confirmedAt, String deviceId, boolean isDoctorContactMe, String partOfProject, boolean onTrail, String trailStartDate, String trailEndDate, String inhmc, String iohmc, String androidhmc) {
        super();
        this.email = email;
        this.uid = uid;
        this.provider = provider;
        this.userId = userId;
        this.phoneVerified = phoneVerified;
        this.update_phone = updatePhone;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.spouse = spouse;
        this.maritalStatus = maritalStatus;
        this.employmentType = employmentType;
        this.photo = photo;
        this.primaryConsultant = primaryConsultant;
        this.userType = userType;
        this.patientType = patientType;
        this.doctorType = doctorType;
        this.memberId = memberId;
        this.wellnessCardNo = wellnessCardNo;
        this.dashboardStatus = dashboardStatus;
        this.createdAt = createdAt;
        this.confirmedAt = confirmedAt;
        this.deviceId = deviceId;
        this.isDoctorContactMe = isDoctorContactMe;
        this.partOfProject = partOfProject;
        this.onTrail = onTrail;
        this.trailStartDate = trailStartDate;
        this.trailEndDate = trailEndDate;
        this.inhmc = inhmc;
        this.iohmc = iohmc;
        this.androidhmc = androidhmc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDataLogin withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDataLogin withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public UserDataLogin withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserDataLogin withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public UserDataLogin withPhoneVerified(String phoneVerified) {
        this.phoneVerified = phoneVerified;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDataLogin withId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserDataLogin withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDataLogin withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public UserDataLogin withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserDataLogin withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public UserDataLogin withNic(String nic) {
        this.nic = nic;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDataLogin withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDataLogin withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserDataLogin withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public UserDataLogin withSpouse(String spouse) {
        this.spouse = spouse;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public UserDataLogin withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public UserDataLogin withEmploymentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserDataLogin withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getPrimaryConsultant() {
        return primaryConsultant;
    }

    public void setPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
    }

    public UserDataLogin withPrimaryConsultant(String primaryConsultant) {
        this.primaryConsultant = primaryConsultant;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserDataLogin withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public UserDataLogin withPatientType(String patientType) {
        this.patientType = patientType;
        return this;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public UserDataLogin withDoctorType(String doctorType) {
        this.doctorType = doctorType;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public UserDataLogin withMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getWellnessCardNo() {
        return wellnessCardNo;
    }

    public void setWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
    }

    public UserDataLogin withWellnessCardNo(String wellnessCardNo) {
        this.wellnessCardNo = wellnessCardNo;
        return this;
    }

    public String getDashboardStatus() {
        return dashboardStatus;
    }

    public void setDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
    }

    public UserDataLogin withDashboardStatus(String dashboardStatus) {
        this.dashboardStatus = dashboardStatus;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserDataLogin withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(String confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public UserDataLogin withConfirmedAt(String confirmedAt) {
        this.confirmedAt = confirmedAt;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public UserDataLogin withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public boolean isIsDoctorContactMe() {
        return isDoctorContactMe;
    }

    public void setIsDoctorContactMe(boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
    }

    public UserDataLogin withIsDoctorContactMe(boolean isDoctorContactMe) {
        this.isDoctorContactMe = isDoctorContactMe;
        return this;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public UserDataLogin withPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
        return this;
    }

    public boolean isOnTrail() {
        return onTrail;
    }

    public void setOnTrail(boolean onTrail) {
        this.onTrail = onTrail;
    }

    public UserDataLogin withOnTrail(boolean onTrail) {
        this.onTrail = onTrail;
        return this;
    }

    public String getTrailStartDate() {
        return trailStartDate;
    }

    public void setTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
    }

    public UserDataLogin withTrailStartDate(String trailStartDate) {
        this.trailStartDate = trailStartDate;
        return this;
    }

    public String getTrailEndDate() {
        return trailEndDate;
    }

    public void setTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
    }

    public UserDataLogin withTrailEndDate(String trailEndDate) {
        this.trailEndDate = trailEndDate;
        return this;
    }

    public String getInhmc() {
        return inhmc;
    }

    public void setInhmc(String inhmc) {
        this.inhmc = inhmc;
    }

    public UserDataLogin withInhmc(String inhmc) {
        this.inhmc = inhmc;
        return this;
    }

    public String getIohmc() {
        return iohmc;
    }

    public void setIohmc(String iohmc) {
        this.iohmc = iohmc;
    }

    public UserDataLogin withIohmc(String iohmc) {
        this.iohmc = iohmc;
        return this;
    }

    public String getAndroidhmc() {
        return androidhmc;
    }

    public void setAndroidhmc(String androidhmc) {
        this.androidhmc = androidhmc;
    }

    public UserDataLogin withAndroidhmc(String androidhmc) {
        this.androidhmc = androidhmc;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public boolean isUpdate_phone() {
        return update_phone;
    }

    public void setUpdate_phone(boolean update_phone) {
        this.update_phone = update_phone;
    }

    public UserDataLogin withUpdatePhone(boolean update_phone){
        this.update_phone = update_phone;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("uid", uid).append("provider", provider).append("userId", userId).append("phoneVerified", phoneVerified).append("id", id).append("firstName", firstName).append("lastName", lastName).append("dob", dob).append("gender", gender).append("nic", nic).append("phone", phone).append("address", address).append("country", country).append("spouse", spouse).append("maritalStatus", maritalStatus).append("employmentType", employmentType).append("photo", photo).append("primaryConsultant", primaryConsultant).append("userType", userType).append("patientType", patientType).append("doctorType", doctorType).append("memberId", memberId).append("wellnessCardNo", wellnessCardNo).append("dashboardStatus", dashboardStatus).append("createdAt", createdAt).append("confirmedAt", confirmedAt).append("deviceId", deviceId).append("isDoctorContactMe", isDoctorContactMe).append("partOfProject", partOfProject).append("onTrail", onTrail).append("trailStartDate", trailStartDate).append("trailEndDate", trailEndDate).append("inhmc", inhmc).append("iohmc", iohmc).append("androidhmc", androidhmc).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(uid);
        dest.writeValue(provider);
        dest.writeValue(userId);
        dest.writeValue(phoneVerified);
        dest.writeValue(update_phone);
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(dob);
        dest.writeValue(gender);
        dest.writeValue(nic);
        dest.writeValue(phone);
        dest.writeValue(address);
        dest.writeValue(country);
        dest.writeValue(spouse);
        dest.writeValue(maritalStatus);
        dest.writeValue(employmentType);
        dest.writeValue(photo);
        dest.writeValue(primaryConsultant);
        dest.writeValue(userType);
        dest.writeValue(patientType);
        dest.writeValue(doctorType);
        dest.writeValue(memberId);
        dest.writeValue(wellnessCardNo);
        dest.writeValue(dashboardStatus);
        dest.writeValue(createdAt);
        dest.writeValue(confirmedAt);
        dest.writeValue(deviceId);
        dest.writeValue(isDoctorContactMe);
        dest.writeValue(partOfProject);
        dest.writeValue(onTrail);
        dest.writeValue(trailStartDate);
        dest.writeValue(trailEndDate);
        dest.writeValue(inhmc);
        dest.writeValue(iohmc);
        dest.writeValue(androidhmc);
    }
}