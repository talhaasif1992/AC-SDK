package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 09/04/2018.
 */

public class APreference implements Parcelable{
    private long id;
    private String preference_name;
    private String preference_value;

    protected APreference(Parcel in) {
        id = in.readLong();
        preference_name = in.readString();
        preference_value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(preference_name);
        dest.writeString(preference_value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<APreference> CREATOR = new Creator<APreference>() {
        @Override
        public APreference createFromParcel(Parcel in) {
            return new APreference(in);
        }

        @Override
        public APreference[] newArray(int size) {
            return new APreference[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPreference_name() {
        return preference_name;
    }

    public void setPreference_name(String preference_name) {
        this.preference_name = preference_name;
    }

    public String getPreference_value() {
        return preference_value;
    }

    public void setPreference_value(String preference_value) {
        this.preference_value = preference_value;
    }
}
