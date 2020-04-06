package com.augmentcare.patient.model.exploreDoctorModel;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("instant_doctor")
    @Expose
    private Boolean instantDoctor;

    @SerializedName("specialization")
    @Expose
    private List<String> specialization = null;

    @SerializedName("picture")
    @Expose
    private String picture;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("rated_count")
    @Expose
    private Integer ratedCount;

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) { this.ratedCount = ratedCount; }

    public Boolean getInstantDoctor() { return instantDoctor; }

    public void setInstantDoctor(Boolean instantDoctor) { this.instantDoctor = instantDoctor; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public List<String> getSpecialization() { return specialization; }

    public void setSpecialization(List<String> specialization) { this.specialization = specialization; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}