package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class VideoData implements Parcelable {

    @SerializedName("api")
    @Expose
    private String api;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    public final static Parcelable.Creator<VideoData> CREATOR = new Creator<VideoData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VideoData createFromParcel(Parcel in) {
            return new VideoData(in);
        }

        public VideoData[] newArray(int size) {
            return (new VideoData[size]);
        }

    };

    protected VideoData(Parcel in) {
        this.api = ((String) in.readValue((String.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.sessionId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public VideoData() {
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public VideoData withApi(String api) {
        this.api = api;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public VideoData withToken(String token) {
        this.token = token;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public VideoData withSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("api", api).append("token", token).append("sessionId", sessionId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(api);
        dest.writeValue(token);
        dest.writeValue(sessionId);
    }

    public int describeContents() {
        return 0;
    }

}