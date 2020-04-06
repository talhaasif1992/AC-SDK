package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class DoctorInfo implements Parcelable{
    private String summary;
    @SerializedName("user_role_id")
    private long userRoleId;
    @SerializedName("consultation_rate")
    private long consultationRate;
    @SerializedName("doctor_type")
    private String doctorType;
    @SerializedName("doctor_uid")
    private String doctorUid;
    @SerializedName("reminder_sent_at")
    private String reminderSentAt;

    private Boolean featured;
    @SerializedName("consultation_duration")
    private int consultationDuration;

    private String education;

    private long id;
    @SerializedName("updated_at")
    private String updatedAt;

    private String name;

    private Boolean active;
    @SerializedName("created_at")
    private String createdAt;

    private int experience;
    @SerializedName("daily_reminder_email")
    private Boolean dailyReminderEmail;

    private String rating;
    @SerializedName("copy_of_license")
    private String copyOfLicense;
    @SerializedName("vacation_start_date")
    private String vacationStartDate;
    @SerializedName("vacation_end_date")
    private String vacationEndDate;
    private int pre_booking_time;

    public String getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(String vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public String getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(String vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    protected DoctorInfo(Parcel in) {
        summary = in.readString();
        userRoleId = in.readLong();
        consultationRate = in.readLong();
        doctorType = in.readString();
        doctorUid = in.readString();
        reminderSentAt = in.readString();
        consultationDuration = in.readInt();
        education = in.readString();
        id = in.readLong();
        updatedAt = in.readString();
        name = in.readString();
        createdAt = in.readString();
        experience = in.readInt();
        rating = in.readString();
        copyOfLicense = in.readString();
        vacationStartDate = in.readString();
        vacationEndDate = in.readString();
        pre_booking_time = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(summary);
        dest.writeLong(userRoleId);
        dest.writeLong(consultationRate);
        dest.writeString(doctorType);
        dest.writeString(doctorUid);
        dest.writeString(reminderSentAt);
        dest.writeInt(consultationDuration);
        dest.writeString(education);
        dest.writeLong(id);
        dest.writeString(updatedAt);
        dest.writeString(name);
        dest.writeString(createdAt);
        dest.writeInt(experience);
        dest.writeString(rating);
        dest.writeString(copyOfLicense);
        dest.writeString(vacationEndDate);
        dest.writeString(vacationStartDate);
        dest.writeInt(pre_booking_time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DoctorInfo> CREATOR = new Creator<DoctorInfo>() {
        @Override
        public DoctorInfo createFromParcel(Parcel in) {
            return new DoctorInfo(in);
        }

        @Override
        public DoctorInfo[] newArray(int size) {
            return new DoctorInfo[size];
        }
    };

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public long getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(long consultationRate) {
        this.consultationRate = consultationRate;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getDoctorUid() {
        return doctorUid;
    }

    public void setDoctorUid(String doctorUid) {
        this.doctorUid = doctorUid;
    }

    public String getReminderSentAt() {
        return reminderSentAt;
    }

    public void setReminderSentAt(String reminderSentAt) {
        this.reminderSentAt = reminderSentAt;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Boolean getDailyReminderEmail() {
        return dailyReminderEmail;
    }

    public void setDailyReminderEmail(Boolean dailyReminderEmail) {
        this.dailyReminderEmail = dailyReminderEmail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCopyOfLicense() {
        return copyOfLicense;
    }

    public void setCopyOfLicense(String copyOfLicense) {
        this.copyOfLicense = copyOfLicense;
    }

    public int getPre_booking_time() {
        return pre_booking_time;
    }

    public void setPre_booking_time(int pre_booking_time) {
        this.pre_booking_time = pre_booking_time;
    }
}
