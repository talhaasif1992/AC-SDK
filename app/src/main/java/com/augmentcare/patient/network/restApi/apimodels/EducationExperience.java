
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EducationExperience implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
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
    private String document1;
    @SerializedName("document2")
    @Expose
    private String document2;
    @SerializedName("docter_id")
    @Expose
    private int docterId;
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
    private boolean toDate;
    public final static Creator<EducationExperience> CREATOR = new Creator<EducationExperience>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EducationExperience createFromParcel(Parcel in) {
            return new EducationExperience(in);
        }

        public EducationExperience[] newArray(int size) {
            return (new EducationExperience[size]);
        }

    }
    ;

    protected EducationExperience(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.institution = ((String) in.readValue((String.class.getClassLoader())));
        this.start = ((String) in.readValue((String.class.getClassLoader())));
        this.end = ((String) in.readValue((String.class.getClassLoader())));
        this.document1 = ((String) in.readValue((String.class.getClassLoader())));
        this.document2 = ((String) in.readValue((String.class.getClassLoader())));
        this.docterId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.recordType = ((String) in.readValue((String.class.getClassLoader())));
        this.toDate = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public EducationExperience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EducationExperience withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EducationExperience withName(String name) {
        this.name = name;
        return this;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public EducationExperience withInstitution(String institution) {
        this.institution = institution;
        return this;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public EducationExperience withStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public EducationExperience withEnd(String end) {
        this.end = end;
        return this;
    }

    public String getDocument1() {
        return document1;
    }

    public void setDocument1(String document1) {
        this.document1 = document1;
    }

    public EducationExperience withDocument1(String document1) {
        this.document1 = document1;
        return this;
    }

    public String getDocument2() {
        return document2;
    }

    public void setDocument2(String document2) {
        this.document2 = document2;
    }

    public EducationExperience withDocument2(String document2) {
        this.document2 = document2;
        return this;
    }

    public int getDocterId() {
        return docterId;
    }

    public void setDocterId(int docterId) {
        this.docterId = docterId;
    }

    public EducationExperience withDocterId(int docterId) {
        this.docterId = docterId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EducationExperience withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public EducationExperience withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public EducationExperience withRecordType(String recordType) {
        this.recordType = recordType;
        return this;
    }

    public boolean isToDate() {
        return toDate;
    }

    public void setToDate(boolean toDate) {
        this.toDate = toDate;
    }

    public EducationExperience withToDate(boolean toDate) {
        this.toDate = toDate;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("institution", institution).append("start", start).append("end", end).append("document1", document1).append("document2", document2).append("docterId", docterId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("recordType", recordType).append("toDate", toDate).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(institution);
        dest.writeValue(start);
        dest.writeValue(end);
        dest.writeValue(document1);
        dest.writeValue(document2);
        dest.writeValue(docterId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(recordType);
        dest.writeValue(toDate);
    }

    public int describeContents() {
        return  0;
    }


    public EducationExperience(Integer id, String name, String institution, String start, String end, String document1, String document2, Integer docterId, String createdAt, String updatedAt, String recordType, Boolean toDate) {
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
