package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class ANote implements Parcelable{
    private long user_role_id;

    private long id;

    private String text;

    private String updated_at;

    private long doctor_id;

    private String created_at;

    public long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    protected ANote(Parcel in) {
        user_role_id = in.readLong();
        id = in.readLong();
        text = in.readString();
        updated_at = in.readString();
        doctor_id = in.readLong();
        created_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(user_role_id);
        dest.writeLong(id);
        dest.writeString(text);
        dest.writeString(updated_at);
        dest.writeLong(doctor_id);
        dest.writeString(created_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ANote> CREATOR = new Creator<ANote>() {
        @Override
        public ANote createFromParcel(Parcel in) {
            return new ANote(in);
        }

        @Override
        public ANote[] newArray(int size) {
            return new ANote[size];
        }
    };
}
