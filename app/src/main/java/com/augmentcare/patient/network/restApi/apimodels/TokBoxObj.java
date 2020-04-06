package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TokBoxObj implements Parcelable {

    @SerializedName("api")
    public String api;
    @SerializedName("token")
    public String token;
    @SerializedName("session_id")
    public String session_id;

    public TokBoxObj(String api, String token, String session_id) {
        this.api = api;
        this.token = token;
        this.session_id = session_id;
    }

    protected TokBoxObj(Parcel in) {
        api = in.readString();
        token = in.readString();
        session_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(api);
        dest.writeString(token);
        dest.writeString(session_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TokBoxObj> CREATOR = new Creator<TokBoxObj>() {
        @Override
        public TokBoxObj createFromParcel(Parcel in) {
            return new TokBoxObj(in);
        }

        @Override
        public TokBoxObj[] newArray(int size) {
            return new TokBoxObj[size];
        }
    };
}