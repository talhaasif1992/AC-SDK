package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ConditionsTreated implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("specialization_id")
    @Expose
    private Integer specializationId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_procedure")
    @Expose
    private Boolean isProcedure;
    public final static Parcelable.Creator<ConditionsTreated> CREATOR = new Creator<ConditionsTreated>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ConditionsTreated createFromParcel(Parcel in) {
            return new ConditionsTreated(in);
        }

        public ConditionsTreated[] newArray(int size) {
            return (new ConditionsTreated[size]);
        }

    };

    protected ConditionsTreated(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.specializationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.isProcedure = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public ConditionsTreated() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConditionsTreated withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConditionsTreated withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public ConditionsTreated withSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ConditionsTreated withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ConditionsTreated withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getIsProcedure() {
        return isProcedure;
    }

    public void setIsProcedure(Boolean isProcedure) {
        this.isProcedure = isProcedure;
    }

    public ConditionsTreated withIsProcedure(Boolean isProcedure) {
        this.isProcedure = isProcedure;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("specializationId", specializationId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("isProcedure", isProcedure).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(specializationId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(isProcedure);
    }

    public int describeContents() {
        return 0;
    }

}