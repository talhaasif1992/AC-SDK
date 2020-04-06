
package com.augmentcare.patient.model.instantDoctorModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specialization {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("specialization_id")
    @Expose
    private Integer specializationId;
    @SerializedName("docter_id")
    @Expose
    private Integer docterId;
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
    private List<ConditionsTreated> conditionsTreated = null;

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

    public Integer getDocterId() {
        return docterId;
    }

    public void setDocterId(Integer docterId) {
        this.docterId = docterId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConditionsTreated> getConditionsTreated() {
        return conditionsTreated;
    }

    public void setConditionsTreated(List<ConditionsTreated> conditionsTreated) {
        this.conditionsTreated = conditionsTreated;
    }

}
