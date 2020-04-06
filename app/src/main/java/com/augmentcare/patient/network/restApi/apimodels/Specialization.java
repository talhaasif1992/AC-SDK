
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Specialization implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("specialization_id")
    @Expose
    private int specializationId;
    @SerializedName("docter_id")
    @Expose
    private int docterId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("conditions_treated")
    @Expose
    private List<ConditionsTreated> conditionsTreated;
    public final static Creator<Specialization> CREATOR = new Creator<Specialization>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Specialization createFromParcel(Parcel in) {
            return new Specialization(in);
        }

        public Specialization[] newArray(int size) {
            return (new Specialization[size]);
        }

    }
    ;

    protected Specialization(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.specializationId = ((int) in.readValue((int.class.getClassLoader())));
        this.docterId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.conditionsTreated,ConditionsTreated.class.getClassLoader());
    }

    public Specialization() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialization withId(int id) {
        this.id = id;
        return this;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public Specialization withSpecializationId(int specializationId) {
        this.specializationId = specializationId;
        return this;
    }

    public int getDocterId() {
        return docterId;
    }

    public void setDocterId(int docterId) {
        this.docterId = docterId;
    }

    public Specialization withDocterId(int docterId) {
        this.docterId = docterId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Specialization withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Specialization withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization withName(String name) {
        this.name = name;
        return this;
    }

    public List<ConditionsTreated> getConditionsTreated() {
        return conditionsTreated;
    }

    public void setConditionsTreated(List<ConditionsTreated> conditionsTreated) {
        this.conditionsTreated = conditionsTreated;
    }

    public Specialization withConditionsTreated(List<ConditionsTreated> conditionsTreated) {
        this.conditionsTreated = conditionsTreated;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("specializationId", specializationId).append("docterId", docterId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("name", name).append("conditionsTreated", conditionsTreated).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(specializationId);
        dest.writeValue(docterId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(name);
        dest.writeList(conditionsTreated);
    }

    public int describeContents() {
        return  0;
    }

}
