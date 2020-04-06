
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Experience {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("institution")
    @Expose
    private String institution;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("document1")
    @Expose
    private Object document1;
    @SerializedName("document2")
    @Expose
    private Object document2;
    @SerializedName("docter_id")
    @Expose
    private Integer docterId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("record_type")
    @Expose
    private String recordType;
    @SerializedName("to_date")
    @Expose
    private Boolean toDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Object getDocument1() {
        return document1;
    }

    public void setDocument1(Object document1) {
        this.document1 = document1;
    }

    public Object getDocument2() {
        return document2;
    }

    public void setDocument2(Object document2) {
        this.document2 = document2;
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

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Boolean getToDate() {
        return toDate;
    }

    public void setToDate(Boolean toDate) {
        this.toDate = toDate;
    }

    public Experience(Integer id, String name, String institution, String start, String end, String document1, String document2, Integer docterId, String createdAt, String updatedAt, String recordType, Boolean toDate) {
        this.id = id;
        this.name = name;
        this.institution = institution;
        this.start = start;
        this.end = end;
        this.document1 = document1;
        this.document2 = document2;
        this.docterId = docterId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.recordType = recordType;
        this.toDate = toDate;
    }
}
