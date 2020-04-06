
package com.augmentcare.patient.model.filterDoctor;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specialization implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("specialization_id")
    @Expose
    private Integer specializationId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    protected Specialization(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        specializationId = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        if (specializationId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(specializationId);
        }
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Specialization> CREATOR = new Parcelable.Creator<Specialization>() {
        @Override
        public Specialization createFromParcel(Parcel in) {
            return new Specialization(in);
        }

        @Override
        public Specialization[] newArray(int size) {
            return new Specialization[size];
        }
    };
}