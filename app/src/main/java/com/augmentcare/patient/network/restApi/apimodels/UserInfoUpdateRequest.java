package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfoUpdateRequest implements Parcelable {

    @SerializedName("update_user_type")
    @Expose
    private boolean updateUserType;
    @SerializedName("history")
    @Expose
    private boolean history;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("verify_phone")
    @Expose
    private boolean update_phone;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("photo")
    @Expose
    private String photo;
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
    public final static Parcelable.Creator<UserInfoUpdateRequest> CREATOR = new Creator<UserInfoUpdateRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserInfoUpdateRequest createFromParcel(Parcel in) {
            return new UserInfoUpdateRequest(in);
        }

        public UserInfoUpdateRequest[] newArray(int size) {
            return (new UserInfoUpdateRequest[size]);
        }

    };

    protected UserInfoUpdateRequest(Parcel in) {
        this.updateUserType = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.history = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue(String.class.getClassLoader()));
        this.update_phone = ((boolean) in.readValue(boolean.class.getClassLoader()));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.maritalStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((int) in.readValue((int.class.getClassLoader())));
        this.doctorType = ((String) in.readValue((String.class.getClassLoader())));
        this.patientType = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserInfoUpdateRequest(){}


    public boolean isUpdateUserType() {
        return updateUserType;
    }

    public void setUpdateUserType(boolean updateUserType) {
        this.updateUserType = updateUserType;
    }

    public UserInfoUpdateRequest withUpdateUserType(boolean updateUserType) {
        this.updateUserType = updateUserType;
        return this;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public UserInfoUpdateRequest withHistory(boolean history) {
        this.history = history;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfoUpdateRequest withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserInfoUpdateRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserInfoUpdateRequest withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserInfoUpdateRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public UserInfoUpdateRequest withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserInfoUpdateRequest withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserInfoUpdateRequest withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserInfoUpdateRequest withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public UserInfoUpdateRequest withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserInfoUpdateRequest withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserInfoUpdateRequest withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public UserInfoUpdateRequest withDoctorType(String doctorType) {
        this.doctorType = doctorType;
        return this;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public UserInfoUpdateRequest withPatientType(String patientType) {
        this.patientType = patientType;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UserInfoUpdateRequest withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(updateUserType);
        dest.writeValue(history);
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(phone);
        dest.writeValue(update_phone);
        dest.writeValue(dob);
        dest.writeValue(gender);
        dest.writeValue(address);
        dest.writeValue(country);
        dest.writeValue(maritalStatus);
        dest.writeValue(photo);
        dest.writeValue(userId);
        dest.writeValue(doctorType);
        dest.writeValue(patientType);
        dest.writeValue(userType);
    }

    public int describeContents() {
        return  0;
    }

    public UserInfoUpdateRequest setUserInfo(UserDataLogin userInfo){
        this.id = Integer.parseInt(userInfo.getId());
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.phone = userInfo.getPhone();
        this.update_phone = userInfo.isUpdate_phone();
        this.dob = userInfo.getDob();
        this.gender = userInfo.getGender();
        this.address = userInfo.getAddress();
        this.country = userInfo.getCountry();
        this.maritalStatus = userInfo.getMaritalStatus();
        this.photo = userInfo.getPhoto();
        this.userId = userInfo.getUserId();
        this.doctorType = userInfo.getDoctorType();
        this.patientType = userInfo.getPatientType();
        this.userType = userInfo.getUserType();
        return this;
    }

    public boolean getUpdate_phone() {
        return update_phone;
    }

    public void setUpdate_phone(boolean update_phone) {
        this.update_phone = update_phone;
    }

    public UserInfoUpdateRequest withUpdatePhone(boolean updatePhone){
        this.update_phone = update_phone;
        return this;
    }
}