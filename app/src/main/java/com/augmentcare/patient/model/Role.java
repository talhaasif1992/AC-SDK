package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Role implements Parcelable{
    private long id;
    @SerializedName("docter_id")
    private long docterId;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("role_id")
    private String roleId;

    private String verified;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("patient_id")
    private long patientId;

    protected Role(Parcel in) {
        id = in.readLong();
        docterId = in.readLong();
        updatedAt = in.readString();
        roleId = in.readString();
        verified = in.readString();
        createdAt = in.readString();
        userId = in.readLong();
        patientId = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(docterId);
        dest.writeString(updatedAt);
        dest.writeString(roleId);
        dest.writeString(verified);
        dest.writeString(createdAt);
        dest.writeLong(userId);
        dest.writeLong(patientId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Role> CREATOR = new Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel in) {
            return new Role(in);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocterId() {
        return docterId;
    }

    public void setDocterId(long docterId) {
        this.docterId = docterId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
}
