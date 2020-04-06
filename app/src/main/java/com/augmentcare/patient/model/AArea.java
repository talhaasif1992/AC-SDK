package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 24/10/2017.
 */

public class AArea implements Parcelable{
    private String id;
    private String city_id;
    private String name;
    private String created_at;
    private String updated_at;

    public AArea(){}
    protected AArea(Parcel in) {
        id = in.readString();
        city_id = in.readString();
        name = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(city_id);
        dest.writeString(name);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AArea> CREATOR = new Creator<AArea>() {
        @Override
        public AArea createFromParcel(Parcel in) {
            return new AArea(in);
        }

        @Override
        public AArea[] newArray(int size) {
            return new AArea[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
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

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return ""+name;
    }
}
