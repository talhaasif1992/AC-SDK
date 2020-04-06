package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Doctor implements Parcelable{
    @SerializedName("user_info")
    private UserInfo userInfo;
    @SerializedName("docter_info")
    private DoctorInfo docterInfo;
    @SerializedName("docter_roles")
    private Role docterRoles;
    @SerializedName("education_experience")
    private ArrayList<Experience> educationAndExperience;
    @SerializedName("education")
    private ArrayList<Experience> education;
    @SerializedName("experience")
    private ArrayList<Experience> experience;

    //@SerializedName("docter_ratings")
    private ArrayList<Rating> docterRatings;
    @SerializedName("specializations")
    private ArrayList<Specialization> specializations;
    @SerializedName("UserChannel")
    private String userChannel;
    @SerializedName("on_policy")
    private boolean onPolicy;

    @SerializedName("is_free")
    private boolean isFree;
    private ArrayList<Condition> conditions;
    private ArrayList<APreference> preferences;


    protected Doctor(Parcel in) {
        userInfo = in.readParcelable(UserInfo.class.getClassLoader());
        docterInfo = in.readParcelable(DoctorInfo.class.getClassLoader());
        docterRoles = in.readParcelable(Role.class.getClassLoader());
        educationAndExperience = in.createTypedArrayList(Experience.CREATOR);
        preferences = in.createTypedArrayList(APreference.CREATOR);
        education = in.createTypedArrayList(Experience.CREATOR);
        experience = in.createTypedArrayList(Experience.CREATOR);
        docterRatings = in.createTypedArrayList(Rating.CREATOR);
        specializations = in.createTypedArrayList(Specialization.CREATOR);
        conditions = in.createTypedArrayList(Condition.CREATOR);
        userChannel = in.readString();
        onPolicy = in.readByte() != 0;
        isFree = in.readByte() != 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(userInfo, flags);
        dest.writeParcelable(docterInfo, flags);
        dest.writeParcelable(docterRoles, flags);
        dest.writeTypedList(educationAndExperience);
        dest.writeTypedList(preferences);
        dest.writeTypedList(education);
        dest.writeTypedList(experience);
        dest.writeTypedList(docterRatings);
        dest.writeTypedList(specializations);
        dest.writeTypedList(conditions);
        dest.writeString(userChannel);
        dest.writeByte((byte) (onPolicy ? 1 : 0));
        dest.writeByte((byte) (isFree ? 1 : 0));

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };

    public ArrayList<Rating> getDocterRatings() {
        return docterRatings;
    }

    public void setDocterRatings(ArrayList<Rating> docterRatings) {
        this.docterRatings = docterRatings;
    }



    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public DoctorInfo getDocterInfo() {
        return docterInfo;
    }

    public void setDocterInfo(DoctorInfo docterInfo) {
        this.docterInfo = docterInfo;
    }

    public Role getDocterRoles() {
        return docterRoles;
    }

    public void setDocterRoles(Role docterRoles) {
        this.docterRoles = docterRoles;
    }

    public ArrayList<Experience> getEducationAndExperience() {
        return educationAndExperience;
    }

    public void setEducationAndExperience(ArrayList<Experience> educationAndExperience) {
        this.educationAndExperience = educationAndExperience;
    }



    public ArrayList<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(ArrayList<Specialization> specializations) {
        this.specializations = specializations;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public ArrayList<Experience> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<Experience> education) {
        this.education = education;
    }

    public ArrayList<Experience> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Experience> experience) {
        this.experience = experience;
    }

    public boolean isOnPolicy() {
        return onPolicy;
    }

    public void setOnPolicy(boolean onPolicy) {
        this.onPolicy = onPolicy;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }


    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public ArrayList<APreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<APreference> preferences) {
        this.preferences = preferences;
    }
}
