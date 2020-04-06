
package com.augmentcare.patient.model.uploadedLabsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public String getDoctorShouldSee() {
        return doctorShouldSee;
    }

    public void setDoctorShouldSee(String doctorShouldSee) {
        this.doctorShouldSee = doctorShouldSee;
    }

    @SerializedName("doctor_should_see")
    @Expose

    private String doctorShouldSee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}