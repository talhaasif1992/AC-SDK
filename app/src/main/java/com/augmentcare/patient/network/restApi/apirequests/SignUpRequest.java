package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SignUpRequest implements Parcelable {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("config_name")
    @Expose
    private String configName;
    @SerializedName("AC_PATIENT_MOBILE_APP_4969208517")
    @Expose
    private boolean aCPATIENTMOBILEAPP4969208517;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("confirm_success_url")
    @Expose
    private String confirmSuccessUrl;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    public final static Parcelable.Creator<SignUpRequest> CREATOR = new Creator<SignUpRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SignUpRequest createFromParcel(Parcel in) {
            return new SignUpRequest(in);
        }

        public SignUpRequest[] newArray(int size) {
            return (new SignUpRequest[size]);
        }

    };

    protected SignUpRequest(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.configName = ((String) in.readValue((String.class.getClassLoader())));
        this.aCPATIENTMOBILEAPP4969208517 = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmSuccessUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public SignUpRequest() {
    }

    /**
     * @param configName
     * @param firstName
     * @param lastName
     * @param password
     * @param phone
     * @param name
     * @param confirmSuccessUrl
     * @param aCPATIENTMOBILEAPP4969208517
     * @param deviceId
     * @param email
     */
    public SignUpRequest(String email, String firstName, String lastName, String name, String phone, String configName, boolean aCPATIENTMOBILEAPP4969208517, String password, String confirmSuccessUrl, String deviceId) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.phone = phone;
        this.configName = configName;
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        this.password = password;
        this.confirmSuccessUrl = confirmSuccessUrl;
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SignUpRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public SignUpRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SignUpRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignUpRequest withName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SignUpRequest withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public SignUpRequest withConfigName(String configName) {
        this.configName = configName;
        return this;
    }

    public boolean isACPATIENTMOBILEAPP4969208517() {
        return aCPATIENTMOBILEAPP4969208517;
    }

    public void setACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
    }

    public SignUpRequest withACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmSuccessUrl() {
        return confirmSuccessUrl;
    }

    public void setConfirmSuccessUrl(String confirmSuccessUrl) {
        this.confirmSuccessUrl = confirmSuccessUrl;
    }

    public SignUpRequest withConfirmSuccessUrl(String confirmSuccessUrl) {
        this.confirmSuccessUrl = confirmSuccessUrl;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public SignUpRequest withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("firstName", firstName).append("lastName", lastName).append("name", name).append("phone", phone).append("configName", configName).append("aCPATIENTMOBILEAPP4969208517", aCPATIENTMOBILEAPP4969208517).append("password", password).append("confirmSuccessUrl", confirmSuccessUrl).append("deviceId", deviceId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(name);
        dest.writeValue(phone);
        dest.writeValue(configName);
        dest.writeValue(aCPATIENTMOBILEAPP4969208517);
        dest.writeValue(password);
        dest.writeValue(confirmSuccessUrl);
        dest.writeValue(deviceId);
    }

    public int describeContents() {
        return 0;
    }

}