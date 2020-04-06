package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class DoctorFilterOptionResponse implements Parcelable {

    @SerializedName("specializations")
    @Expose
    private List<NameAndId> specializations = new ArrayList<NameAndId>();
    @SerializedName("cities")
    @Expose
    private List<City> cities = new ArrayList<City>();
    @SerializedName("medical_practices")
    @Expose
    private List<NameAndId> medicalPractices = new ArrayList<NameAndId>();
    public final static Parcelable.Creator<DoctorFilterOptionResponse> CREATOR = new Creator<DoctorFilterOptionResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DoctorFilterOptionResponse createFromParcel(Parcel in) {
            return new DoctorFilterOptionResponse(in);
        }

        public DoctorFilterOptionResponse[] newArray(int size) {
            return (new DoctorFilterOptionResponse[size]);
        }

    };

    protected DoctorFilterOptionResponse(Parcel in) {
        in.readList(this.specializations, (NameAndId.class.getClassLoader()));
        in.readList(this.cities, (com.augmentcare.patient.network.restApi.apimodels.City.class.getClassLoader()));
        in.readList(this.medicalPractices, (NameAndId.class.getClassLoader()));
    }

    public DoctorFilterOptionResponse() {
    }

    public List<NameAndId> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<NameAndId> specializations) {
        this.specializations = specializations;
    }

    public DoctorFilterOptionResponse withSpecializations(List<NameAndId> specializations) {
        this.specializations = specializations;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public DoctorFilterOptionResponse withCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public List<NameAndId> getMedicalPractices() {
        return medicalPractices;
    }

    public void setMedicalPractices(List<NameAndId> medicalPractices) {
        this.medicalPractices = medicalPractices;
    }

    public DoctorFilterOptionResponse withMedicalPractices(List<NameAndId> medicalPractices) {
        this.medicalPractices = medicalPractices;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("specializations", specializations).append("cities", cities).append("medicalPractices", medicalPractices).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(specializations);
        dest.writeList(cities);
        dest.writeList(medicalPractices);
    }

    public int describeContents() {
        return 0;
    }

}