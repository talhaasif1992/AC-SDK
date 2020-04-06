package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 05/09/2017.
 */

public class TokBoxObject implements Parcelable{
    public String api;
    public String token;
    public String session_id;

    protected TokBoxObject(Parcel in) {
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

    public static final Creator<TokBoxObject> CREATOR = new Creator<TokBoxObject>() {
        @Override
        public TokBoxObject createFromParcel(Parcel in) {
            return new TokBoxObject(in);
        }

        @Override
        public TokBoxObject[] newArray(int size) {
            return new TokBoxObject[size];
        }
    };
}
