
package com.augmentcare.patient.model.doctorDetails;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.augmentcare.patient.model.exploreDoctorModel.MedicalPractices;

public class DoctorInfo {
    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
    }
    @SerializedName("fee")
    @Expose

    private String fee;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;
    @SerializedName("docter_info")
    @Expose
    private DocterInfo docterInfo;
    @SerializedName("specializations")
    @Expose
    private List<Specialization> specializations = null;
    @SerializedName("education")
    @Expose
    private List<Education> education = null;

    public List<MedicalPractices> getMedicalPractices() {
        return medicalPractices;
    }

    public void setMedicalPractices(List<MedicalPractices> medicalPractices) {
        this.medicalPractices = medicalPractices;
    }

    @SerializedName("experience")
    @Expose

    private List<Experience> experience = null;
    @SerializedName("medical_practices")
    @Expose
    private List<MedicalPractices> medicalPractices = null;
    @SerializedName("timings")
    @Expose
    private List<Timing> timings = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public DocterInfo getDocterInfo() {
        return docterInfo;
    }

    public void setDocterInfo(DocterInfo docterInfo) {
        this.docterInfo = docterInfo;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

//    public List<Object> getMedicalPractices() {
//        return medicalPractices;
//    }
//
//    public void setMedicalPractices(List<Object> medicalPractices) {
//        this.medicalPractices = medicalPractices;
//    }
    public List<Timing> getTimings() {
        return timings;
    }

    public void setTimings(List<Timing> timings) {
        this.timings = timings;
    }
}