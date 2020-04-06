package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DependentTypesResponse implements Parcelable {

    @SerializedName("dependent_types")
    @Expose
    private DependentTypes dependentTypes;
    public final static Parcelable.Creator<DependentTypesResponse> CREATOR = new Creator<DependentTypesResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DependentTypesResponse createFromParcel(Parcel in) {
            return new DependentTypesResponse(in);
        }

        public DependentTypesResponse[] newArray(int size) {
            return (new DependentTypesResponse[size]);
        }

    };

    protected DependentTypesResponse(Parcel in) {
        this.dependentTypes = ((DependentTypes) in.readValue((DependentTypes.class.getClassLoader())));
    }

    public DependentTypesResponse() {
    }

    public DependentTypes getDependentTypes() {
        return dependentTypes;
    }

    public void setDependentTypes(DependentTypes dependentTypes) {
        this.dependentTypes = dependentTypes;
    }

    public DependentTypesResponse withDependentTypes(DependentTypes dependentTypes) {
        this.dependentTypes = dependentTypes;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dependentTypes", dependentTypes).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dependentTypes);
    }

    public int describeContents() {
        return 0;
    }

}