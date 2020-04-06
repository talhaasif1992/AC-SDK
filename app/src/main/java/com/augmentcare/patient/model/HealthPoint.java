package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class HealthPoint implements Parcelable{
    private long user_role_id;

    private String health_type;

    private long id;

    private String updated_at;

    private String value;

    private String created_at;

    private String consultation_id;

    public long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getHealth_type() {
        return health_type;
    }

    public void setHealth_type(String health_type) {
        this.health_type = health_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(String consultation_id) {
        this.consultation_id = consultation_id;
    }

    public HealthPoint(){

    }
    protected HealthPoint(Parcel in) {
        user_role_id = in.readLong();
        health_type = in.readString();
        id = in.readLong();
        updated_at = in.readString();
        value = in.readString();
        created_at = in.readString();
        consultation_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(user_role_id);
        dest.writeString(health_type);
        dest.writeLong(id);
        dest.writeString(updated_at);
        dest.writeString(value);
        dest.writeString(created_at);
        dest.writeString(consultation_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HealthPoint> CREATOR = new Creator<HealthPoint>() {
        @Override
        public HealthPoint createFromParcel(Parcel in) {
            return new HealthPoint(in);
        }

        @Override
        public HealthPoint[] newArray(int size) {
            return new HealthPoint[size];
        }
    };
}
