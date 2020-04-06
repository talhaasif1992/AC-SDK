package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Healthpoint implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("health_type")
    @Expose
    private String healthType;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    public final static Parcelable.Creator<Healthpoint> CREATOR = new Creator<Healthpoint>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Healthpoint createFromParcel(Parcel in) {
            return new Healthpoint(in);
        }

        public Healthpoint[] newArray(int size) {
            return (new Healthpoint[size]);
        }

    };

    protected Healthpoint(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.healthType = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((String) in.readValue((String.class.getClassLoader())));
        this.userRoleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.consultationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Healthpoint() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Healthpoint withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getHealthType() {
        return healthType;
    }

    public void setHealthType(String healthType) {
        this.healthType = healthType;
    }

    public Healthpoint withHealthType(String healthType) {
        this.healthType = healthType;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Healthpoint withValue(String value) {
        this.value = value;
        return this;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Healthpoint withUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Healthpoint withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Healthpoint withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Healthpoint withConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Healthpoint withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("healthType", healthType).append("value", value).append("userRoleId", userRoleId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("consultationId", consultationId).append("userId", userId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(healthType);
        dest.writeValue(value);
        dest.writeValue(userRoleId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(consultationId);
        dest.writeValue(userId);
    }

    public int describeContents() {
        return 0;
    }

}