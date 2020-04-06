package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestedReports {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("consultation_id")
    @Expose
    private Integer consultationId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uploaded_link")
    @Expose
    private String uploadedLink;
    @SerializedName("uploaded")
    @Expose
    private Boolean uploaded;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("reports_test_id")
    @Expose
    private Integer reportsTestId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("is_radiology")
    @Expose
    private Boolean isRadiology;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadedLink() {
        return uploadedLink;
    }

    public void setUploadedLink(String uploadedLink) {
        this.uploadedLink = uploadedLink;
    }

    public Boolean getUploaded() {
        return uploaded;
    }

    public void setUploaded(Boolean uploaded) {
        this.uploaded = uploaded;
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

    public Integer getReportsTestId() {
        return reportsTestId;
    }

    public void setReportsTestId(Integer reportsTestId) {
        this.reportsTestId = reportsTestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsRadiology() {
        return isRadiology;
    }

    public void setIsRadiology(Boolean isRadiology) {
        this.isRadiology = isRadiology;
    }

}