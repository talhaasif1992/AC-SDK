package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenRequest implements Parcelable {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("platform")
    @Expose
    private String platform;
    public final static Parcelable.Creator<TokenRequest> CREATOR = new Creator<TokenRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TokenRequest createFromParcel(Parcel in) {
            return new TokenRequest(in);
        }

        public TokenRequest[] newArray(int size) {
            return (new TokenRequest[size]);
        }

    };

    protected TokenRequest(Parcel in) {
        this.version = ((String) in.readValue((String.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.deviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.platform = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public TokenRequest() {
    }

    /**
     * @param deviceId
     * @param platform
     * @param token
     */
    public TokenRequest(String version,String token, String deviceId, String platform) {
        super();
        this.version = version;
        this.token = token;
        this.deviceId = deviceId;
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TokenRequest withVersion(String version) {
        this.version = version;
        return this;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenRequest withToken(String token) {
        this.token = token;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public TokenRequest withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public TokenRequest withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(token);
        dest.writeValue(deviceId);
        dest.writeValue(platform);
    }

    public int describeContents() {
        return 0;
    }

}