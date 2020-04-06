package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Condition implements Parcelable{
    private long id;
    private String name;
    private long specialization_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(long specialization_id) {
        this.specialization_id = specialization_id;
    }

    protected Condition(Parcel in) {
        id = in.readLong();
        name = in.readString();
        specialization_id = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeLong(specialization_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Condition> CREATOR = new Creator<Condition>() {
        @Override
        public Condition createFromParcel(Parcel in) {
            return new Condition(in);
        }

        @Override
        public Condition[] newArray(int size) {
            return new Condition[size];
        }
    };

    @Override
    public String toString() {
        return name;
    }
}
