package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginRequest implements Parcelable {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("AC_PATIENT_MOBILE_APP_4969208517")
    @Expose
    private boolean aCPATIENTMOBILEAPP4969208517;
    @SerializedName("part_of_project")
    @Expose
    private String partOfProject;
    @SerializedName("app_id")
    @Expose
    private String appId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("nic")
    @Expose
    private String nic;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("redirect_url")
    @Expose
    private String redirectURL;

    public final static Parcelable.Creator<LoginRequest> CREATOR = new Creator<LoginRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginRequest createFromParcel(Parcel in) {
            return new LoginRequest(in);
        }

        public LoginRequest[] newArray(int size) {
            return (new LoginRequest[size]);
        }

    };

    protected LoginRequest(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.platform = ((String) in.readValue((String.class.getClassLoader())));
        this.aCPATIENTMOBILEAPP4969208517 = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.partOfProject = ((String) in.readValue((String.class.getClassLoader())));
        this.appId = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.nic = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.redirectURL = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public LoginRequest() {
    }

    /**
     * @param lastName
     * @param gender
     * @param nic
     * @param aCPATIENTMOBILEAPP4969208517
     * @param deviceId
     * @param platform
     * @param partOfProject
     * @param firstName
     * @param password
     * @param phone
     * @param dob
     * @param appId
     * @param email
     */
    public LoginRequest(String email, String password, String deviceId, String platform, boolean aCPATIENTMOBILEAPP4969208517, String partOfProject, String appId, String phone, String firstName, String lastName, String nic, String gender, String dob, String redirectURL) {
        super();
        this.email = email;
        this.password = password;
        this.deviceId = deviceId;
        this.platform = platform;
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        this.partOfProject = partOfProject;
        this.appId = appId;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.gender = gender;
        this.dob = dob;
        this.redirectURL = redirectURL;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public LoginRequest withRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LoginRequest withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LoginRequest withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public boolean isACPATIENTMOBILEAPP4969208517() {
        return aCPATIENTMOBILEAPP4969208517;
    }

    public void setACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
    }

    public LoginRequest withACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        return this;
    }

    public String getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
    }

    public LoginRequest withPartOfProject(String partOfProject) {
        this.partOfProject = partOfProject;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public LoginRequest withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LoginRequest withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LoginRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LoginRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public LoginRequest withNic(String nic) {
        this.nic = nic;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LoginRequest withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public LoginRequest withDob(String dob) {
        this.dob = dob;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("password", password).append("deviceId", deviceId).append("platform", platform).append("aCPATIENTMOBILEAPP4969208517", aCPATIENTMOBILEAPP4969208517).append("partOfProject", partOfProject).append("appId", appId).append("phone", phone).append("firstName", firstName).append("lastName", lastName).append("nic", nic).append("gender", gender).append("dob", dob).append("redirect_url", redirectURL).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(password);
        dest.writeValue(deviceId);
        dest.writeValue(platform);
        dest.writeValue(aCPATIENTMOBILEAPP4969208517);
        dest.writeValue(partOfProject);
        dest.writeValue(appId);
        dest.writeValue(phone);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(nic);
        dest.writeValue(gender);
        dest.writeValue(dob);
        dest.writeValue(redirectURL);
    }

    public int describeContents() {
        return 0;
    }

}