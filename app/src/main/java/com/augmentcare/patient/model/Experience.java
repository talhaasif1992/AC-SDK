package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Experience implements Parcelable{
    private long id;
    @SerializedName("docter_id")
    private long docterId;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("record_type")
    private String recordType;

    private String start;

    private String document1;

    private String document2;

    private String name;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("to_date")
    private String toDate;

    private String end;

    private String institution;

    public Experience(Parcel in) {
        id = in.readLong();
        docterId = in.readLong();
        updatedAt = in.readString();
        recordType = in.readString();
        start = in.readString();
        document1 = in.readString();
        document2 = in.readString();
        name = in.readString();
        createdAt = in.readString();
        toDate = in.readString();
        end = in.readString();
        institution = in.readString();
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(docterId);
        dest.writeString(updatedAt);
        dest.writeString(recordType);
        dest.writeString(start);
        dest.writeString(document1);
        dest.writeString(document2);
        dest.writeString(name);
        dest.writeString(createdAt);
        dest.writeString(toDate);
        dest.writeString(end);
        dest.writeString(institution);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Experience> CREATOR = new Creator<Experience>() {
        @Override
        public Experience createFromParcel(Parcel in) {
            return new Experience(in);
        }

        @Override
        public Experience[] newArray(int size) {
            return new Experience[size];
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

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDocument1() {
        return document1;
    }

    public void setDocument1(String document1) {
        this.document1 = document1;
    }

    public String getDocument2() {
        return document2;
    }

    public void setDocument2(String document2) {
        this.document2 = document2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
