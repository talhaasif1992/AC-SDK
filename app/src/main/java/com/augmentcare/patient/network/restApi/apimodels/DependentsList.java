package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class DependentsList implements Parcelable {

    @SerializedName("dependants")
    @Expose
    private List<Dependent> dependents = new ArrayList<Dependent>();
    public final static Parcelable.Creator<DependentsList> CREATOR = new Creator<DependentsList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DependentsList createFromParcel(Parcel in) {
            return new DependentsList(in);
        }

        public DependentsList[] newArray(int size) {
            return (new DependentsList[size]);
        }

    };

    protected DependentsList(Parcel in) {
        in.readList(this.dependents, (com.augmentcare.patient.network.restApi.apimodels.Dependent.class.getClassLoader()));
    }

    public DependentsList() {
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public DependentsList withDependents(List<Dependent> dependents) {
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