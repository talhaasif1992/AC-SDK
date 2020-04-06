package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class VerifyOTPRequest implements Parcelable {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("confirm_success_url")
    @Expose
    private String confirmSuccessUrl;
    @SerializedName("config_name")
    @Expose
    private String configName;
    @SerializedName("AC_PATIENT_MOBILE_APP_4969208517")
    @Expose
    private boolean aCPATIENTMOBILEAPP4969208517;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    public final static Parcelable.Creator<VerifyOTPRequest> CREATOR = new Creator<VerifyOTPRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VerifyOTPRequest createFromParcel(Parcel in) {
            return new VerifyOTPRequest(in);
        }

        public VerifyOTPRequest[] newArray(int size) {
            return (new VerifyOTPRequest[size]);
        }

    };

    protected VerifyOTPRequest(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmSuccessUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.configName = ((String) in.readValue((String.class.getClassLoader())));
        this.aCPATIENTMOBILEAPP4969208517 = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public VerifyOTPRequest() {
    }

    /**
     * @param configName
     * @param code
     * @param phone
     * @param confirmSuccessUrl
     * @param aCPATIENTMOBILEAPP4969208517
     * @param deviceId
     * @param email
     */
    public VerifyOTPRequest(String email, String phone, String password, String confirmSuccessUrl, String configName, boolean aCPATIENTMOBILEAPP4969208517, String code, String deviceId) {
        super();
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmSuccessUrl = confirmSuccessUrl;
        this.configName = configName;
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        this.code = code;
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VerifyOTPRequest withEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VerifyOTPRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VerifyOTPRequest withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getConfirmSuccessUrl() {
        return confirmSuccessUrl;
    }

    public void setConfirmSuccessUrl(String confirmSuccessUrl) {
        this.confirmSuccessUrl = confirmSuccessUrl;
    }

    public VerifyOTPRequest withConfirmSuccessUrl(String confirmSuccessUrl) {
        this.confirmSuccessUrl = confirmSuccessUrl;
        return this;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public VerifyOTPRequest withConfigName(String configName) {
        this.configName = configName;
        return this;
    }

    public boolean isACPATIENTMOBILEAPP4969208517() {
        return aCPATIENTMOBILEAPP4969208517;
    }

    public void setACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
    }

    public VerifyOTPRequest withACPATIENTMOBILEAPP4969208517(boolean aCPATIENTMOBILEAPP4969208517) {
        this.aCPATIENTMOBILEAPP4969208517 = aCPATIENTMOBILEAPP4969208517;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VerifyOTPRequest withCode(String code) {
        this.code = code;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public VerifyOTPRequest withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("phone", phone).append("password", password).append("confirmSuccessUrl", confirmSuccessUrl).append("configName", configName).append("aCPATIENTMOBILEAPP4969208517", aCPATIENTMOBILEAPP4969208517).append("code", code).append("deviceId", deviceId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(phone);
        dest.writeValue(password);
        dest.writeValue(confirmSuccessUrl);
        dest.writeValue(configName);
        dest.writeValue(aCPATIENTMOBILEAPP4969208517);
        dest.writeValue(code);
        dest.writeValue(deviceId);
    }

    public int describeContents() {
        return 0;
    }

}