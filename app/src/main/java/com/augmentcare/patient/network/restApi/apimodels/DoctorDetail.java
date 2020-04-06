
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class DoctorDetail implements Parcelable
{

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName(value = "user_info",alternate = "info")
    @Expose
    private UserInfo userInfo;
    @SerializedName(value = "docter_info",alternate = "docter")
    @Expose
    private DocterInfo docterInfo;
    @SerializedName("docter_roles")
    @Expose
    private DocterRoles docterRoles;
    @SerializedName("specializations")
    @Expose
    private List<Specialization> specializations = new ArrayList<>();
    @SerializedName(value = "education_experience",alternate = "education")
    @Expose
    private List<EducationExperience> educationExperience = new ArrayList<>();
    @SerializedName("experience")
    @Expose
    private List<EducationExperience> experience = new ArrayList<>();
    @SerializedName("UserChannel")
    @Expose
    private String userChannel;
    @SerializedName("working_days")
    @Expose
    private List<Integer> workingDays = new ArrayList<>();

    @SerializedName("docter_ratings")
    @Expose
    private String docterRatings;

    @SerializedName("online")
    @Expose
    private List<Online> online = new ArrayList<>();
    @SerializedName("ranking")
    @Expose
    private int ranking;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("medical_practices")
    @Expose
    private List<MedicalPractice> medicalPractices = new ArrayList<MedicalPractice>();
    @SerializedName("timings")
    @Expose
    private List<Timing> timings = new ArrayList<Timing>();
    public final static Creator<DoctorDetail> CREATOR = new Creator<DoctorDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DoctorDetail createFromParcel(Parcel in) {
            return new DoctorDetail(in);
        }

        public DoctorDetail[] newArray(int size) {
            return (new DoctorDetail[size]);
        }

    }
    ;

    protected DoctorDetail(Parcel in) {
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.userInfo = ((UserInfo) in.readValue((UserInfo.class.getClassLoader())));
        this.docterInfo = ((DocterInfo) in.readValue((DocterInfo.class.getClassLoader())));
        this.docterRoles = ((DocterRoles) in.readValue((DocterRoles.class.getClassLoader())));
        in.readList(this.specializations, (com.augmentcare.patient.network.restApi.apimodels.Specialization.class.getClassLoader()));
        in.readList(this.educationExperience, (com.augmentcare.patient.network.restApi.apimodels.EducationExperience.class.getClassLoader()));
        in.readList(this.experience, (com.augmentcare.patient.network.restApi.apimodels.EducationExperience.class.getClassLoader()));
        this.userChannel = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.workingDays, (Integer.class.getClassLoader()));
        this.docterRatings = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.online, (com.augmentcare.patient.network.restApi.apimodels.Online.class.getClassLoader()));
        this.ranking = ((int) in.readValue((int.class.getClassLoader())));
    }

    public DoctorDetail() {
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public DoctorDetail withFee(Integer fee) {
        this.fee = fee;
        return this;
    }

    public List<MedicalPractice> getMedicalPractices() {
        return medicalPractices;
    }

    public void setMedicalPractices(List<MedicalPractice> medicalPractices) {
        this.medicalPractices = medicalPractices;
    }

    public DoctorDetail withMedicalPractices(List<MedicalPractice> medicalPractices) {
        this.medicalPractices = medicalPractices;
        return this;
    }

    public List<Timing> getTimings() {
        return timings;
    }

    public void setTimings(List<Timing> timings) {
        this.timings = timings;
    }

    public DoctorDetail withTimings(List<Timing> timings) {
        this.timings = timings;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DoctorDetail withUser(User user) {
        this.user = user;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public DoctorDetail withUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public DocterInfo getDocterInfo() {
        return docterInfo;
    }

    public void setDocterInfo(DocterInfo docterInfo) {
        this.docterInfo = docterInfo;
    }

    public DoctorDetail withDocterInfo(DocterInfo docterInfo) {
        this.docterInfo = docterInfo;
        return this;
    }

    public DocterRoles getDocterRoles() {
        return docterRoles;
    }

    public void setDocterRoles(DocterRoles docterRoles) {
        this.docterRoles = docterRoles;
    }

    public DoctorDetail withDocterRoles(DocterRoles docterRoles) {
        this.docterRoles = docterRoles;
        return this;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public DoctorDetail withSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
        return this;
    }

    public List<EducationExperience> getEducationExperience() {
        return educationExperience;
    }

    public void setEducationExperience(List<EducationExperience> educationExperience) {
        this.educationExperience = educationExperience;
    }

    public DoctorDetail withEducationExperience(List<EducationExperience> educationExperience) {
        this.educationExperience = educationExperience;
        return this;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public DoctorDetail withUserChannel(String userChannel) {
        this.userChannel = userChannel;
        return this;
    }

    public List<Integer> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<Integer> workingDays) {
        this.workingDays = workingDays;
    }

    public DoctorDetail withWorkingDays(List<Integer> workingDays) {
        this.workingDays = workingDays;
        return this;
    }

    public String getDocterRatings() {
        return docterRatings;
    }

    public void setDocterRatings(String docterRatings) {
        this.docterRatings = docterRatings;
    }

    public DoctorDetail withDocterRatings(String docterRatings) {
        this.docterRatings = docterRatings;
        return this;
    }

    public List<EducationExperience> getExperience() {
        return experience;
    }

    public void setExperience(List<EducationExperience> experience) {
        this.experience = experience;
    }

    public DoctorDetail withExperience(List<EducationExperience> experience) {
        this.experience = experience;
        return this;
    }
    public List<Online> getOnline() {
        return online;
    }

    public void setOnline(List<Online> online) {
        this.online = online;
    }

    public DoctorDetail withOnline(List<Online> online) {
        this.online = online;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public DoctorDetail withRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("user", user).append("userInfo", userInfo).append("docterInfo", docterInfo).append("docterRoles", docterRoles).append("specializations", specializations).append("educationExperience", educationExperience).append("userChannel", userChannel).append("workingDays", workingDays).append("docterRatings", docterRatings).append("online", online).append("ranking", ranking).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(user);
        dest.writeValue(userInfo);
        dest.writeValue(docterInfo);
        dest.writeValue(docterRoles);
        dest.writeList(specializations);
        dest.writeList(educationExperience);
        dest.writeValue(userChannel);
        dest.writeList(workingDays);
        dest.writeValue(docterRatings);
        dest.writeList(online);
        dest.writeValue(ranking);
    }

    public int describeContents() {
        return  0;
    }

}
