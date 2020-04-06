
package com.augmentcare.patient.model.filterDoctor;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable {

    @SerializedName("specializations")
    @Expose
    private List<Specialization> specializations = null;

    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    @SerializedName("medical_practices")
    @Expose
    private List<MedicalPractice> medicalPractices = null;

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public List<MedicalPractice> getMedicalPractices() {
        return medicalPractices;
    }

    public void setMedicalPractices(List<MedicalPractice> medicalPractices) {
        this.medicalPractices = medicalPractices;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
