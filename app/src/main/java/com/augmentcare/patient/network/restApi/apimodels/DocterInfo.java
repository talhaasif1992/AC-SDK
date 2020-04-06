
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DocterInfo implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("summary")
    @Expose
    private String summary;
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
    private String copyOfLicense;
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
    private String reminderSentAt;
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
    private String tagline;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("page_title")
    @Expose
    private String pageTitle;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("vacation_start_date")
    @Expose
    private String vacationStartDate;
    @SerializedName("vacation_end_date")
    @Expose
    private String vacationEndDate;
    @SerializedName("pre_booking_time")
    @Expose
    private Integer preBookingTime;
    @SerializedName("instant_doctor")
    @Expose
    private Boolean instantDoctor;
    @SerializedName("pmdc_number")
    @Expose
    private String pmdcNumber;
//    @SerializedName("settings")
//    @Expose
//    private Settings settings;
    @SerializedName("print_header")
    @Expose
    private String printHeader;
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
    private String cmsAccountId;
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
    @SerializedName("rated_count")
    @Expose
    private Integer ratedCount;
    @SerializedName("mrnumber_prefix")
    @Expose
    private String mrnumberPrefix;
    @SerializedName("mrnumber_postfix")
    @Expose
    private String mrnumberPostfix;
    @SerializedName("sms_language")
    @Expose
    private String smsLanguage;
    @SerializedName("print_token_when_arrived")
    @Expose
    private Boolean printTokenWhenArrived;
    @SerializedName("deactivate_sms")
    @Expose
    private Boolean deactivateSms;
    @SerializedName("deactivate_patient_sms")
    @Expose
    private Boolean deactivatePatientSms;
    @SerializedName("deactivate_doc_sms")
    @Expose
    private Boolean deactivateDocSms;
    @SerializedName("deactivate_doc_emails")
    @Expose
    private Boolean deactivateDocEmails;
    @SerializedName("show_doctor_checklist")
    @Expose
    private String showDoctorChecklist;
    @SerializedName("add_medicines")
    @Expose
    private String addMedicines;
    @SerializedName("hide_default_tags")
    @Expose
    private Boolean hideDefaultTags;
    @SerializedName("add_reports")
    @Expose
    private String addReports;
    @SerializedName("allow_medicine_heading")
    @Expose
    private Boolean allowMedicineHeading;
    public final static Creator<DocterInfo> CREATOR = new Creator<DocterInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DocterInfo createFromParcel(Parcel in) {
            return new DocterInfo(in);
        }

        public DocterInfo[] newArray(int size) {
            return (new DocterInfo[size]);
        }

    }
    ;

    protected DocterInfo(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.summary = ((String) in.readValue((String.class.getClassLoader())));
        this.education = ((String) in.readValue((String.class.getClassLoader())));
        this.experience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rating = ((String) in.readValue((String.class.getClassLoader())));
        this.userRoleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorType = ((String) in.readValue((String.class.getClassLoader())));
        this.consultationRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.copyOfLicense = ((String) in.readValue((String.class.getClassLoader())));
        this.consultationDuration = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.doctorUid = ((String) in.readValue((String.class.getClassLoader())));
        this.dailyReminderEmail = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.reminderSentAt = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.featured = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.specialization = ((String) in.readValue((String.class.getClassLoader())));
        this.tagline = ((String) in.readValue((String.class.getClassLoader())));
        this.about = ((String) in.readValue((String.class.getClassLoader())));
        this.pageTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.vacationStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.vacationEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.preBookingTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.instantDoctor = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pmdcNumber = ((String) in.readValue((String.class.getClassLoader())));
//        this.settings = ((Settings) in.readValue((Settings.class.getClassLoader())));
        this.printHeader = ((String) in.readValue((String.class.getClassLoader())));
        this.slotAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.eduExpAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.expAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.specAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.rateDurationAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pmdcLicenseAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isFree = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.allowRecpToEditPrescription = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.cmsAccountId = ((String) in.readValue((String.class.getClassLoader())));
        this.skippedOnboarding = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.onPayroll = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.accessAllPatients = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.smsQuota = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.smsUsage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ranking = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ratedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mrnumberPrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.mrnumberPostfix = ((String) in.readValue((String.class.getClassLoader())));
        this.smsLanguage = ((String) in.readValue((String.class.getClassLoader())));
        this.printTokenWhenArrived = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.deactivateSms = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.deactivatePatientSms = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.deactivateDocSms = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.deactivateDocEmails = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.showDoctorChecklist = ((String) in.readValue((String.class.getClassLoader())));
        this.addMedicines = ((String) in.readValue((String.class.getClassLoader())));
        this.hideDefaultTags = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.addReports = ((String) in.readValue((String.class.getClassLoader())));
        this.allowMedicineHeading = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public DocterInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocterInfo withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DocterInfo withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public DocterInfo withEducation(String education) {
        this.education = education;
        return this;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public DocterInfo withExperience(Integer experience) {
        this.experience = experience;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public DocterInfo withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public DocterInfo withUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DocterInfo withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DocterInfo withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public DocterInfo withDoctorType(String doctorType) {
        this.doctorType = doctorType;
        return this;
    }

    public Integer getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(Integer consultationRate) {
        this.consultationRate = consultationRate;
    }

    public DocterInfo withConsultationRate(Integer consultationRate) {
        this.consultationRate = consultationRate;
        return this;
    }

    public String getCopyOfLicense() {
        return copyOfLicense;
    }

    public void setCopyOfLicense(String copyOfLicense) {
        this.copyOfLicense = copyOfLicense;
    }

    public DocterInfo withCopyOfLicense(String copyOfLicense) {
        this.copyOfLicense = copyOfLicense;
        return this;
    }

    public Integer getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(Integer consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public DocterInfo withConsultationDuration(Integer consultationDuration) {
        this.consultationDuration = consultationDuration;
        return this;
    }

    public String getDoctorUid() {
        return doctorUid;
    }

    public void setDoctorUid(String doctorUid) {
        this.doctorUid = doctorUid;
    }

    public DocterInfo withDoctorUid(String doctorUid) {
        this.doctorUid = doctorUid;
        return this;
    }

    public Boolean isDailyReminderEmail() {
        return dailyReminderEmail;
    }

    public void setDailyReminderEmail(Boolean dailyReminderEmail) {
        this.dailyReminderEmail = dailyReminderEmail;
    }

    public DocterInfo withDailyReminderEmail(Boolean dailyReminderEmail) {
        this.dailyReminderEmail = dailyReminderEmail;
        return this;
    }

    public String getReminderSentAt() {
        return reminderSentAt;
    }

    public void setReminderSentAt(String reminderSentAt) {
        this.reminderSentAt = reminderSentAt;
    }

    public DocterInfo withReminderSentAt(String reminderSentAt) {
        this.reminderSentAt = reminderSentAt;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocterInfo withName(String name) {
        this.name = name;
        return this;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DocterInfo withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Boolean isFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public DocterInfo withFeatured(Boolean featured) {
        this.featured = featured;
        return this;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public DocterInfo withSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public DocterInfo withTagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public DocterInfo withAbout(String about) {
        this.about = about;
        return this;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public DocterInfo withPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public DocterInfo withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DocterInfo withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(String vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public DocterInfo withVacationStartDate(String vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
        return this;
    }

    public String getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(String vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public DocterInfo withVacationEndDate(String vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
        return this;
    }

    public Integer getPreBookingTime() {
        return preBookingTime;
    }

    public void setPreBookingTime(Integer preBookingTime) {
        this.preBookingTime = preBookingTime;
    }

    public DocterInfo withPreBookingTime(Integer preBookingTime) {
        this.preBookingTime = preBookingTime;
        return this;
    }

    public Boolean isInstantDoctor() {
        return instantDoctor;
    }

    public void setInstantDoctor(Boolean instantDoctor) {
        this.instantDoctor = instantDoctor;
    }

    public DocterInfo withInstantDoctor(Boolean instantDoctor) {
        this.instantDoctor = instantDoctor;
        return this;
    }

    public String getPmdcNumber() {
        return pmdcNumber;
    }

    public void setPmdcNumber(String pmdcNumber) {
        this.pmdcNumber = pmdcNumber;
    }

    public DocterInfo withPmdcNumber(String pmdcNumber) {
        this.pmdcNumber = pmdcNumber;
        return this;
    }

//    public Settings getSettings() {
//        return settings;
//    }
//
//    public void setSettings(Settings settings) {
//        this.settings = settings;
//    }
//
//    public DocterInfo withSettings(Settings settings) {
//        this.settings = settings;
//        return this;
//    }

    public String getPrintHeader() {
        return printHeader;
    }

    public void setPrintHeader(String printHeader) {
        this.printHeader = printHeader;
    }

    public DocterInfo withPrintHeader(String printHeader) {
        this.printHeader = printHeader;
        return this;
    }

    public Boolean isSlotAdded() {
        return slotAdded;
    }

    public void setSlotAdded(Boolean slotAdded) {
        this.slotAdded = slotAdded;
    }

    public DocterInfo withSlotAdded(Boolean slotAdded) {
        this.slotAdded = slotAdded;
        return this;
    }

    public Boolean isEduExpAdded() {
        return eduExpAdded;
    }

    public void setEduExpAdded(Boolean eduExpAdded) {
        this.eduExpAdded = eduExpAdded;
    }

    public DocterInfo withEduExpAdded(Boolean eduExpAdded) {
        this.eduExpAdded = eduExpAdded;
        return this;
    }

    public Boolean isExpAdded() {
        return expAdded;
    }

    public void setExpAdded(Boolean expAdded) {
        this.expAdded = expAdded;
    }

    public DocterInfo withExpAdded(Boolean expAdded) {
        this.expAdded = expAdded;
        return this;
    }

    public Boolean isSpecAdded() {
        return specAdded;
    }

    public void setSpecAdded(Boolean specAdded) {
        this.specAdded = specAdded;
    }

    public DocterInfo withSpecAdded(Boolean specAdded) {
        this.specAdded = specAdded;
        return this;
    }

    public Boolean isRateDurationAdded() {
        return rateDurationAdded;
    }

    public void setRateDurationAdded(Boolean rateDurationAdded) {
        this.rateDurationAdded = rateDurationAdded;
    }

    public DocterInfo withRateDurationAdded(Boolean rateDurationAdded) {
        this.rateDurationAdded = rateDurationAdded;
        return this;
    }

    public Boolean isPmdcLicenseAdded() {
        return pmdcLicenseAdded;
    }

    public void setPmdcLicenseAdded(Boolean pmdcLicenseAdded) {
        this.pmdcLicenseAdded = pmdcLicenseAdded;
    }

    public DocterInfo withPmdcLicenseAdded(Boolean pmdcLicenseAdded) {
        this.pmdcLicenseAdded = pmdcLicenseAdded;
        return this;
    }

    public Boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public DocterInfo withIsFree(Boolean isFree) {
        this.isFree = isFree;
        return this;
    }

    public Boolean isAllowRecpToEditPrescription() {
        return allowRecpToEditPrescription;
    }

    public void setAllowRecpToEditPrescription(Boolean allowRecpToEditPrescription) {
        this.allowRecpToEditPrescription = allowRecpToEditPrescription;
    }

    public DocterInfo withAllowRecpToEditPrescription(Boolean allowRecpToEditPrescription) {
        this.allowRecpToEditPrescription = allowRecpToEditPrescription;
        return this;
    }

    public String getCmsAccountId() {
        return cmsAccountId;
    }

    public void setCmsAccountId(String cmsAccountId) {
        this.cmsAccountId = cmsAccountId;
    }

    public DocterInfo withCmsAccountId(String cmsAccountId) {
        this.cmsAccountId = cmsAccountId;
        return this;
    }

    public Boolean isSkippedOnboarding() {
        return skippedOnboarding;
    }

    public void setSkippedOnboarding(Boolean skippedOnboarding) {
        this.skippedOnboarding = skippedOnboarding;
    }

    public DocterInfo withSkippedOnboarding(Boolean skippedOnboarding) {
        this.skippedOnboarding = skippedOnboarding;
        return this;
    }

    public Boolean isOnPayroll() {
        return onPayroll;
    }

    public void setOnPayroll(Boolean onPayroll) {
        this.onPayroll = onPayroll;
    }

    public DocterInfo withOnPayroll(Boolean onPayroll) {
        this.onPayroll = onPayroll;
        return this;
    }

    public Boolean isAccessAllPatients() {
        return accessAllPatients;
    }

    public void setAccessAllPatients(Boolean accessAllPatients) {
        this.accessAllPatients = accessAllPatients;
    }

    public DocterInfo withAccessAllPatients(Boolean accessAllPatients) {
        this.accessAllPatients = accessAllPatients;
        return this;
    }

    public Integer getSmsQuota() {
        return smsQuota;
    }

    public void setSmsQuota(Integer smsQuota) {
        this.smsQuota = smsQuota;
    }

    public DocterInfo withSmsQuota(Integer smsQuota) {
        this.smsQuota = smsQuota;
        return this;
    }

    public Integer getSmsUsage() {
        return smsUsage;
    }

    public void setSmsUsage(Integer smsUsage) {
        this.smsUsage = smsUsage;
    }

    public DocterInfo withSmsUsage(Integer smsUsage) {
        this.smsUsage = smsUsage;
        return this;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public DocterInfo withRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
    }

    public DocterInfo withRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
        return this;
    }

    public String getMrnumberPrefix() {
        return mrnumberPrefix;
    }

    public void setMrnumberPrefix(String mrnumberPrefix) {
        this.mrnumberPrefix = mrnumberPrefix;
    }

    public DocterInfo withMrnumberPrefix(String mrnumberPrefix) {
        this.mrnumberPrefix = mrnumberPrefix;
        return this;
    }

    public String getMrnumberPostfix() {
        return mrnumberPostfix;
    }

    public void setMrnumberPostfix(String mrnumberPostfix) {
        this.mrnumberPostfix = mrnumberPostfix;
    }

    public DocterInfo withMrnumberPostfix(String mrnumberPostfix) {
        this.mrnumberPostfix = mrnumberPostfix;
        return this;
    }

    public String getSmsLanguage() {
        return smsLanguage;
    }

    public void setSmsLanguage(String smsLanguage) {
        this.smsLanguage = smsLanguage;
    }

    public DocterInfo withSmsLanguage(String smsLanguage) {
        this.smsLanguage = smsLanguage;
        return this;
    }

    public Boolean isPrintTokenWhenArrived() {
        return printTokenWhenArrived;
    }

    public void setPrintTokenWhenArrived(Boolean printTokenWhenArrived) {
        this.printTokenWhenArrived = printTokenWhenArrived;
    }

    public DocterInfo withPrintTokenWhenArrived(Boolean printTokenWhenArrived) {
        this.printTokenWhenArrived = printTokenWhenArrived;
        return this;
    }

    public Boolean isDeactivateSms() {
        return deactivateSms;
    }

    public void setDeactivateSms(Boolean deactivateSms) {
        this.deactivateSms = deactivateSms;
    }

    public DocterInfo withDeactivateSms(Boolean deactivateSms) {
        this.deactivateSms = deactivateSms;
        return this;
    }

    public Boolean isDeactivatePatientSms() {
        return deactivatePatientSms;
    }

    public void setDeactivatePatientSms(Boolean deactivatePatientSms) {
        this.deactivatePatientSms = deactivatePatientSms;
    }

    public DocterInfo withDeactivatePatientSms(Boolean deactivatePatientSms) {
        this.deactivatePatientSms = deactivatePatientSms;
        return this;
    }

    public Boolean isDeactivateDocSms() {
        return deactivateDocSms;
    }

    public void setDeactivateDocSms(Boolean deactivateDocSms) {
        this.deactivateDocSms = deactivateDocSms;
    }

    public DocterInfo withDeactivateDocSms(Boolean deactivateDocSms) {
        this.deactivateDocSms = deactivateDocSms;
        return this;
    }

    public Boolean isDeactivateDocEmails() {
        return deactivateDocEmails;
    }

    public void setDeactivateDocEmails(Boolean deactivateDocEmails) {
        this.deactivateDocEmails = deactivateDocEmails;
    }

    public DocterInfo withDeactivateDocEmails(Boolean deactivateDocEmails) {
        this.deactivateDocEmails = deactivateDocEmails;
        return this;
    }

    public String getShowDoctorChecklist() {
        return showDoctorChecklist;
    }

    public void setShowDoctorChecklist(String showDoctorChecklist) {
        this.showDoctorChecklist = showDoctorChecklist;
    }

    public DocterInfo withShowDoctorChecklist(String showDoctorChecklist) {
        this.showDoctorChecklist = showDoctorChecklist;
        return this;
    }

    public String getAddMedicines() {
        return addMedicines;
    }

    public void setAddMedicines(String addMedicines) {
        this.addMedicines = addMedicines;
    }

    public DocterInfo withAddMedicines(String addMedicines) {
        this.addMedicines = addMedicines;
        return this;
    }

    public Boolean isHideDefaultTags() {
        return hideDefaultTags;
    }

    public void setHideDefaultTags(Boolean hideDefaultTags) {
        this.hideDefaultTags = hideDefaultTags;
    }

    public DocterInfo withHideDefaultTags(Boolean hideDefaultTags) {
        this.hideDefaultTags = hideDefaultTags;
        return this;
    }

    public String getAddReports() {
        return addReports;
    }

    public void setAddReports(String addReports) {
        this.addReports = addReports;
    }

    public DocterInfo withAddReports(String addReports) {
        this.addReports = addReports;
        return this;
    }

    public Boolean isAllowMedicineHeading() {
        return allowMedicineHeading;
    }

    public void setAllowMedicineHeading(Boolean allowMedicineHeading) {
        this.allowMedicineHeading = allowMedicineHeading;
    }

    public DocterInfo withAllowMedicineHeading(Boolean allowMedicineHeading) {
        this.allowMedicineHeading = allowMedicineHeading;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("summary", summary).append("education", education).append("experience", experience).append("rating", rating).append("userRoleId", userRoleId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("doctorType", doctorType).append("consultationRate", consultationRate).append("copyOfLicense", copyOfLicense).append("consultationDuration", consultationDuration).append("doctorUid", doctorUid).append("dailyReminderEmail", dailyReminderEmail).append("reminderSentAt", reminderSentAt).append("name", name).append("active", active).append("featured", featured).append("specialization", specialization).append("tagline", tagline).append("about", about).append("pageTitle", pageTitle).append("slug", slug).append("userId", userId).append("vacationStartDate", vacationStartDate).append("vacationEndDate", vacationEndDate).append("preBookingTime", preBookingTime).append("instantDoctor", instantDoctor).append("pmdcNumber", pmdcNumber)
//                .append("settings", settings)
                .append("printHeader", printHeader).append("slotAdded", slotAdded).append("eduExpAdded", eduExpAdded).append("expAdded", expAdded).append("specAdded", specAdded).append("rateDurationAdded", rateDurationAdded).append("pmdcLicenseAdded", pmdcLicenseAdded).append("isFree", isFree).append("allowRecpToEditPrescription", allowRecpToEditPrescription).append("cmsAccountId", cmsAccountId).append("skippedOnboarding", skippedOnboarding).append("onPayroll", onPayroll).append("accessAllPatients", accessAllPatients).append("smsQuota", smsQuota).append("smsUsage", smsUsage).append("ranking", ranking).append("ratedCount", ratedCount).append("mrnumberPrefix", mrnumberPrefix).append("mrnumberPostfix", mrnumberPostfix).append("smsLanguage", smsLanguage).append("printTokenWhenArrived", printTokenWhenArrived).append("deactivateSms", deactivateSms).append("deactivatePatientSms", deactivatePatientSms).append("deactivateDocSms", deactivateDocSms).append("deactivateDocEmails", deactivateDocEmails).append("showDoctorChecklist", showDoctorChecklist).append("addMedicines", addMedicines).append("hideDefaultTags", hideDefaultTags).append("addReports", addReports).append("allowMedicineHeading", allowMedicineHeading).toString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(summary);
        dest.writeValue(education);
        dest.writeValue(experience);
        dest.writeValue(rating);
        dest.writeValue(userRoleId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(doctorType);
        dest.writeValue(consultationRate);
        dest.writeValue(copyOfLicense);
        dest.writeValue(consultationDuration);
        dest.writeValue(doctorUid);
        dest.writeValue(dailyReminderEmail);
        dest.writeValue(reminderSentAt);
        dest.writeValue(name);
        dest.writeValue(active);
        dest.writeValue(featured);
        dest.writeValue(specialization);
        dest.writeValue(tagline);
        dest.writeValue(about);
        dest.writeValue(pageTitle);
        dest.writeValue(slug);
        dest.writeValue(userId);
        dest.writeValue(vacationStartDate);
        dest.writeValue(vacationEndDate);
        dest.writeValue(preBookingTime);
        dest.writeValue(instantDoctor);
        dest.writeValue(pmdcNumber);
//        dest.writeValue(settings);
        dest.writeValue(printHeader);
        dest.writeValue(slotAdded);
        dest.writeValue(eduExpAdded);
        dest.writeValue(expAdded);
        dest.writeValue(specAdded);
        dest.writeValue(rateDurationAdded);
        dest.writeValue(pmdcLicenseAdded);
        dest.writeValue(isFree);
        dest.writeValue(allowRecpToEditPrescription);
        dest.writeValue(cmsAccountId);
        dest.writeValue(skippedOnboarding);
        dest.writeValue(onPayroll);
        dest.writeValue(accessAllPatients);
        dest.writeValue(smsQuota);
        dest.writeValue(smsUsage);
        dest.writeValue(ranking);
        dest.writeValue(ratedCount);
        dest.writeValue(mrnumberPrefix);
        dest.writeValue(mrnumberPostfix);
        dest.writeValue(smsLanguage);
        dest.writeValue(printTokenWhenArrived);
        dest.writeValue(deactivateSms);
        dest.writeValue(deactivatePatientSms);
        dest.writeValue(deactivateDocSms);
        dest.writeValue(deactivateDocEmails);
        dest.writeValue(showDoctorChecklist);
        dest.writeValue(addMedicines);
        dest.writeValue(hideDefaultTags);
        dest.writeValue(addReports);
        dest.writeValue(allowMedicineHeading);
    }

    public int describeContents() {
        return  0;
    }
}
