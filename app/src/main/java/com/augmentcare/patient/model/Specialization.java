package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Specialization implements Parcelable{
    private long id;

    private long docter_id;

    private String updated_at;

    private String name;

    private String created_at;

    private long specialization_id;

    private ArrayList<Condition> conditions_treated;

    protected Specialization(Parcel in) {
        id = in.readLong();
        docter_id = in.readLong();
        updated_at = in.readString();
        name = in.readString();
        created_at = in.readString();
        specialization_id = in.readLong();
        conditions_treated = in.createTypedArrayList(Condition.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(docter_id);
        dest.writeString(updated_at);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeLong(specialization_id);
        dest.writeTypedList(conditions_treated);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Specialization> CREATOR = new Creator<Specialization>() {
        @Override
        public Specialization createFromParcel(Parcel in) {
            return new Specialization(in);
        }

        @Override
        public Specialization[] newArray(int size) {
            return new Specialization[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocter_id() {
        return docter_id;
    }

    public void setDocter_id(long docter_id) {
        this.docter_id = docter_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(long specialization_id) {
        this.specialization_id = specialization_id;
    }

    public ArrayList<Condition> getConditions_treated() {
        return conditions_treated;
    }

    public void setConditions_treated(ArrayList<Condition> conditions_treated) {
        this.conditions_treated = conditions_treated;
    }

    @Override
    public String toString() {
        return name;
    }
}
