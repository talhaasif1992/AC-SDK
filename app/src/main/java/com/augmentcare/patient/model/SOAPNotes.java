package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 23/08/2017.
 */

public class SOAPNotes implements Parcelable{
    private long id;

    private String updated_at;

    private String objective;

    private String plan;

    private String subjective;

    private String created_at;

    private String assessment;

    protected SOAPNotes(Parcel in) {
        id = in.readLong();
        updated_at = in.readString();
        objective = in.readString();
        plan = in.readString();
        subjective = in.readString();
        created_at = in.readString();
        assessment = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(updated_at);
        dest.writeString(objective);
        dest.writeString(plan);
        dest.writeString(subjective);
        dest.writeString(created_at);
        dest.writeString(assessment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SOAPNotes> CREATOR = new Creator<SOAPNotes>() {
        @Override
        public SOAPNotes createFromParcel(Parcel in) {
            return new SOAPNotes(in);
        }

        @Override
        public SOAPNotes[] newArray(int size) {
            return new SOAPNotes[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSubjective() {
        return subjective;
    }

    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
}
