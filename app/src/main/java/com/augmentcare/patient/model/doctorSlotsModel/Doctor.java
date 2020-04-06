
package com.augmentcare.patient.model.doctorSlotsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("summary")
    @Expose
    private Object summary;
    @SerializedName("education")
    @Expose
    private String education;
    @SerializedName("experience")
    @Expose
    private Integer experience;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("doctor_type")
    @Expose
    private String doctorType;
    @SerializedName("consultation_rate")
    @Expose
    private Integer consultationRate;
    @SerializedName("copy_of_license")
    @Expose
    private Object copyOfLicense;
    @SerializedName("consultation_duration")
    @Expose
    private Integer consultationDuration;
    @SerializedName("doctor_uid")
    @Expose
    private String doctorUid;
    @SerializedName("daily_reminder_email")
    @Expose
    private Boolean dailyReminderEmail;
    @SerializedName("reminder_sent_at")
    @Expose
    private Object reminderSentAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("tagline")
    @Expose
    private Object tagline;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("page_title")
    @Expose
    private Object pageTitle;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("vacation_start_date")
    @Expose
    private Object vacationStartDate;
    @SerializedName("vacation_end_date")
    @Expose
    private Object vacationEndDate;
    @SerializedName("pre_booking_time")
    @Expose
    private Integer preBookingTime;
    @SerializedName("instant_doctor")
    @Expose
    private Boolean instantDoctor;
    @SerializedName("pmdc_number")
    @Expose
    private Object pmdcNumber;
    @SerializedName("print_header")
    @Expose
    private Object printHeader;
    @SerializedName("slot_added")
    @Expose
    private Boolean slotAdded;
    @SerializedName("edu_exp_added")
    @Expose
    private Boolean eduExpAdded;
    @SerializedName("exp_added")
    @Expose
    private Boolean expAdded;
    @SerializedName("spec_added")
    @Expose
    private Boolean specAdded;
    @SerializedName("rate_duration_added")
    @Expose
    private Boolean rateDurationAdded;
    @SerializedName("pmdc_license_added")
    @Expose
    private Boolean pmdcLicenseAdded;
    @SerializedName("is_free")
    @Expose
    private Boolean isFree;
    @SerializedName("allow_recp_to_edit_prescription")
    @Expose
    private Boolean allowRecpToEditPrescription;
    @SerializedName("cms_account_id")
    @Expose
    private Object cmsAccountId;
    @SerializedName("skipped_onboarding")
    @Expose
    private Boolean skippedOnboarding;
    @SerializedName("on_payroll")
    @Expose
    private Boolean onPayroll;
    @SerializedName("access_all_patients")
    @Expose
    private Boolean accessAllPatients;
    @SerializedName("sms_quota")
    @Expose
    private Integer smsQuota;
    @SerializedName("sms_usage")
    @Expose
    private Integer smsUsage;
    @SerializedName("ranking")
    @Expose
    private Integer ranking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public Integer getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(Integer consultationRate) {
        this.consultationRate = consultationRate;
    }

    public Object getCopyOfLicense() {
        return copyOfLicense;
    }

    public void setCopyOfLicense(Object copyOfLicense) {
        this.copyOfLicense = copyOfLicense;
    }

    public Integer getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(Integer consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public String getDoctorUid() {
        return doctorUid;
    }

    public void setDoctorUid(String doctorUid) {
        this.doctorUid = doctorUid;
    }

    public Boolean getDailyReminderEmail() {
        return dailyReminderEmail;
    }

    public void setDailyReminderEmail(Boolean dailyReminderEmail) {
        this.dailyReminderEmail = dailyReminderEmail;
    }

    public Object getReminderSentAt() {
        return reminderSentAt;
    }

    public void setReminderSentAt(Object reminderSentAt) {
        this.reminderSentAt = reminderSentAt;
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

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Object getTagline() {
        return tagline;
    }

    public void setTagline(Object tagline) {
        this.tagline = tagline;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public Object getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(Object pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Object vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Object getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Object vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public Integer getPreBookingTime() {
        return preBookingTime;
    }

    public void setPreBookingTime(Integer preBookingTime) {
        this.preBookingTime = preBookingTime;
    }

    public Boolean getInstantDoctor() {
        return instantDoctor;
    }

    public void setInstantDoctor(Boolean instantDoctor) {
        this.instantDoctor = instantDoctor;
    }

    public Object getPmdcNumber() {
        return pmdcNumber;
    }

    public void setPmdcNumber(Object pmdcNumber) {
        this.pmdcNumber = pmdcNumber;
    }

    public Object getPrintHeader() {
        return printHeader;
    }

    public void setPrintHeader(Object printHeader) {
        this.printHeader = printHeader;
    }

    public Boolean getSlotAdded() {
        return slotAdded;
    }

    public void setSlotAdded(Boolean slotAdded) {
        this.slotAdded = slotAdded;
    }

    public Boolean getEduExpAdded() {
        return eduExpAdded;
    }

    public void setEduExpAdded(Boolean eduExpAdded) {
        this.eduExpAdded = eduExpAdded;
    }

    public Boolean getExpAdded() {
        return expAdded;
    }

    public void setExpAdded(Boolean expAdded) {
        this.expAdded = expAdded;
    }

    public Boolean getSpecAdded() {
        return specAdded;
    }

    public void setSpecAdded(Boolean specAdded) {
        this.specAdded = specAdded;
    }

    public Boolean getRateDurationAdded() {
        return rateDurationAdded;
    }

    public void setRateDurationAdded(Boolean rateDurationAdded) {
        this.rateDurationAdded = rateDurationAdded;
    }

    public Boolean getPmdcLicenseAdded() {
        return pmdcLicenseAdded;
    }

    public void setPmdcLicenseAdded(Boolean pmdcLicenseAdded) {
        this.pmdcLicenseAdded = pmdcLicenseAdded;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Boolean getAllowRecpToEditPrescription() {
        return allowRecpToEditPrescription;
    }

    public void setAllowRecpToEditPrescription(Boolean allowRecpToEditPrescription) {
        this.allowRecpToEditPrescription = allowRecpToEditPrescription;
    }

    public Object getCmsAccountId() {
        return cmsAccountId;
    }

    public void setCmsAccountId(Object cmsAccountId) {
        this.cmsAccountId = cmsAccountId;
    }

    public Boolean getSkippedOnboarding() {
        return skippedOnboarding;
    }

    public void setSkippedOnboarding(Boolean skippedOnboarding) {
        this.skippedOnboarding = skippedOnboarding;
    }

    public Boolean getOnPayroll() {
        return onPayroll;
    }

    public void setOnPayroll(Boolean onPayroll) {
        this.onPayroll = onPayroll;
    }

    public Boolean getAccessAllPatients() {
        return accessAllPatients;
    }

    public void setAccessAllPatients(Boolean accessAllPatients) {
        this.accessAllPatients = accessAllPatients;
    }

    public Integer getSmsQuota() {
        return smsQuota;
    }

    public void setSmsQuota(Integer smsQuota) {
        this.smsQuota = smsQuota;
    }

    public Integer getSmsUsage() {
        return smsUsage;
    }

    public void setSmsUsage(Integer smsUsage) {
        this.smsUsage = smsUsage;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

}
