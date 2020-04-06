package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class DependentsCoveredResponse implements Parcelable {

    @SerializedName("dependents")
    @Expose
    private List<Dependent> dependents = new ArrayList<Dependent>();
    public final static Parcelable.Creator<DependentsCoveredResponse> CREATOR = new Creator<DependentsCoveredResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DependentsCoveredResponse createFromParcel(Parcel in) {
            return new DependentsCoveredResponse(in);
        }

        public DependentsCoveredResponse[] newArray(int size) {
            return (new DependentsCoveredResponse[size]);
        }

    };

    protected DependentsCoveredResponse(Parcel in) {
        in.readList(this.dependents, (Dependent.class.getClassLoader()));
    }

    public DependentsCoveredResponse() {
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public DependentsCoveredResponse withDependents(List<Dependent> dependents) {
        this.dependents = dependents;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dependents", dependents).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(dependents);
    }

    public int describeContents() {
        return 0;
    }

}