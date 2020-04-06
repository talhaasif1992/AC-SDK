package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class Slot implements Parcelable {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("doctor_id")
    @Expose
    private Long doctorId;
    @SerializedName("patient_id")
    @Expose
    private Long patientId;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    @SerializedName("rejected")
    @Expose
    private Boolean rejected;
    @SerializedName("rejected_by")
    @Expose
    private String rejectedBy;
    @SerializedName("slot_type")
    @Expose
    private Boolean slotType;
    @SerializedName("location_id")
    @Expose
    private Long locationId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private Long doctorSittingId;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("payment_id")
    @Expose
    private Long paymentId;
    @SerializedName("medical_practice_id")
    @Expose
    private Long medicalPracticeId;
    @SerializedName("complaint")
    @Expose
    private String complaint;
    @SerializedName("patient_status")
    @Expose
    private String patientStatus;
    @SerializedName("patient_arrived_at")
    @Expose
    private String patientArrivedAt;
    @SerializedName("patient_checkin_at")
    @Expose
    private String patientCheckinAt;
    @SerializedName("patient_checkout_at")
    @Expose
    private String patientCheckoutAt;
    @SerializedName("appointment_token")
    @Expose
    private String appointmentToken;
    @SerializedName("booked_by_user_id")
    @Expose
    private Long bookedByUserId;
    @SerializedName("booked_by_role_id")
    @Expose
    private Long bookedByRoleId;
    @SerializedName("booked_from_platform")
    @Expose
    private String bookedFromPlatform;
    @SerializedName("reschedule_count")
    @Expose
    private Long rescheduleCount;
    @SerializedName("slot_status")
    @Expose
    private String slotStatus;
    @SerializedName("booking_time")
    @Expose
    private String bookingTime;
    @SerializedName("no_show")
    @Expose
    private Boolean noShow;
    @SerializedName("no_show_at")
    @Expose
    private String noShowAt;
    @SerializedName("follow_up_id")
    @Expose
    private Long followUpId;
    @SerializedName("is_paid")
    @Expose
    private Boolean isPaid;
    @SerializedName("booking_type")
    @Expose
    private String bookingType;
    @SerializedName("internal_procedure")
    @Expose
    private String internalProcedure;
    @SerializedName("doc_token")
    @Expose
    private String docToken;
    @SerializedName("follow_up_of")
    @Expose
    private String followUpOf;
    @SerializedName("dependent_id")
    @Expose
    private Long dependentId;
    @SerializedName("is_on_waiting")
    @Expose
    private Boolean isOnWaiting;
    @SerializedName("patient_priority")
    @Expose
    private String patientPriority;
    @SerializedName("completed_at")
    @Expose
    private String completedAt;
    @SerializedName("send_sms")
    @Expose
    private String sendSms;

    private String statusString;
    private Date startDateTime;
    private Date endDateTime;

    public final static Parcelable.Creator<Slot> CREATOR = new Creator<Slot>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Slot createFromParcel(Parcel in) {
            return new Slot(in);
        }

        public Slot[] newArray(int size) {
            return (new Slot[size]);
        }

    };

    protected Slot(Parcel in) {
        this.id = ((Long) in.readValue((Long.class.getClassLoader())));
        this.doctorId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.patientId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.available = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.completed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.rejected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.rejectedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.slotType = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.doctorSittingId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.medicalPracticeId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.complaint = ((String) in.readValue((String.class.getClassLoader())));
        this.patientStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.patientArrivedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.patientCheckinAt = ((String) in.readValue((String.class.getClassLoader())));
        this.patientCheckoutAt = ((String) in.readValue((String.class.getClassLoader())));
        this.appointmentToken = ((String) in.readValue((String.class.getClassLoader())));
        this.bookedByUserId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.bookedByRoleId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.bookedFromPlatform = ((String) in.readValue((String.class.getClassLoader())));
        this.rescheduleCount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.slotStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.bookingTime = ((String) in.readValue((String.class.getClassLoader())));
        this.noShow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.noShowAt = ((String) in.readValue((String.class.getClassLoader())));
        this.followUpId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.isPaid = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.bookingType = ((String) in.readValue((String.class.getClassLoader())));
        this.internalProcedure = ((String) in.readValue((String.class.getClassLoader())));
        this.docToken = ((String) in.readValue((String.class.getClassLoader())));
        this.followUpOf = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.isOnWaiting = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.patientPriority = ((String) in.readValue((String.class.getClassLoader())));
        this.completedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.sendSms = ((String) in.readValue((String.class.getClassLoader())));
        this.statusString = ((String) in.readValue((String.class.getClassLoader())));
        this.startDateTime = ((Date) in.readValue((Date.class.getClassLoader())));
        this.endDateTime = ((Date) in.readValue((Date.class.getClassLoader())));
    }

    public Slot() {
    }

    public Date getBookingDateTimeProcessed(){
        Date dateForAppointment = TextUtils.parseDate(getDay());
        Date timeOfAppointment = TextUtils.parseTime(getStartTime());

        // MMMM dd, yyyy hh:mm a
        String dateAndTimeOfAppointment =
                TextUtils.formatDate(dateForAppointment) + " " +
                        TextUtils.formatTime(timeOfAppointment);

        return TextUtils.parseDate(dateAndTimeOfAppointment,"MMMM dd, yyyy hh:mm a");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Slot withId(Long id) {
        this.id = id;
        return this;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Slot withDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Slot withPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Slot withAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Slot withDay(String day) {
        this.day = day;
        return this;
    }

    public Boolean getStatus() {
        return status!= null && status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Slot withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Slot withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Slot withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Slot withCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public Boolean getRejected() {
        return rejected!= null && rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Slot withRejected(Boolean rejected) {
        this.rejected = rejected;
        return this;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Slot withRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
        return this;
    }

    public Boolean getSlotType() {
        return slotType;
    }

    public void setSlotType(Boolean slotType) {
        this.slotType = slotType;
    }

    public Slot withSlotType(Boolean slotType) {
        this.slotType = slotType;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Slot withLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public Long getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Long doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public Slot withDoctorSittingId(Long doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Slot withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Slot withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Slot withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Long getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Long medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public Slot withMedicalPracticeId(Long medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Slot withComplaint(String complaint) {
        this.complaint = complaint;
        return this;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public Slot withPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
        return this;
    }

    public String getPatientArrivedAt() {
        return patientArrivedAt;
    }

    public void setPatientArrivedAt(String patientArrivedAt) {
        this.patientArrivedAt = patientArrivedAt;
    }

    public Slot withPatientArrivedAt(String patientArrivedAt) {
        this.patientArrivedAt = patientArrivedAt;
        return this;
    }

    public String getPatientCheckinAt() {
        return patientCheckinAt;
    }

    public void setPatientCheckinAt(String patientCheckinAt) {
        this.patientCheckinAt = patientCheckinAt;
    }

    public Slot withPatientCheckinAt(String patientCheckinAt) {
        this.patientCheckinAt = patientCheckinAt;
        return this;
    }

    public String getPatientCheckoutAt() {
        return patientCheckoutAt;
    }

    public void setPatientCheckoutAt(String patientCheckoutAt) {
        this.patientCheckoutAt = patientCheckoutAt;
    }

    public Slot withPatientCheckoutAt(String patientCheckoutAt) {
        this.patientCheckoutAt = patientCheckoutAt;
        return this;
    }

    public String getAppointmentToken() {
        return appointmentToken;
    }

    public void setAppointmentToken(String appointmentToken) {
        this.appointmentToken = appointmentToken;
    }

    public Slot withAppointmentToken(String appointmentToken) {
        this.appointmentToken = appointmentToken;
        return this;
    }

    public Long getBookedByUserId() {
        return bookedByUserId;
    }

    public void setBookedByUserId(Long bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }

    public Slot withBookedByUserId(Long bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
        return this;
    }

    public Long getBookedByRoleId() {
        return bookedByRoleId;
    }

    public void setBookedByRoleId(Long bookedByRoleId) {
        this.bookedByRoleId = bookedByRoleId;
    }

    public Slot withBookedByRoleId(Long bookedByRoleId) {
        this.bookedByRoleId = bookedByRoleId;
        return this;
    }

    public String getBookedFromPlatform() {
        return bookedFromPlatform;
    }

    public void setBookedFromPlatform(String bookedFromPlatform) {
        this.bookedFromPlatform = bookedFromPlatform;
    }

    public Slot withBookedFromPlatform(String bookedFromPlatform) {
        this.bookedFromPlatform = bookedFromPlatform;
        return this;
    }

    public Long getRescheduleCount() {
        return rescheduleCount;
    }

    public void setRescheduleCount(Long rescheduleCount) {
        this.rescheduleCount = rescheduleCount;
    }

    public Slot withRescheduleCount(Long rescheduleCount) {
        this.rescheduleCount = rescheduleCount;
        return this;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    public Slot withSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
        return this;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Slot withBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
        return this;
    }

    public Boolean getNoShow() {
        return noShow;
    }

    public void setNoShow(Boolean noShow) {
        this.noShow = noShow;
    }

    public Slot withNoShow(Boolean noShow) {
        this.noShow = noShow;
        return this;
    }

    public String getNoShowAt() {
        return noShowAt;
    }

    public void setNoShowAt(String noShowAt) {
        this.noShowAt = noShowAt;
    }

    public Slot withNoShowAt(String noShowAt) {
        this.noShowAt = noShowAt;
        return this;
    }

    public Long getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(Long followUpId) {
        this.followUpId = followUpId;
    }

    public Slot withFollowUpId(Long followUpId) {
        this.followUpId = followUpId;
        return this;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Slot withIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
        return this;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Slot withBookingType(String bookingType) {
        this.bookingType = bookingType;
        return this;
    }

    public String getInternalProcedure() {
        return internalProcedure;
    }

    public void setInternalProcedure(String internalProcedure) {
        this.internalProcedure = internalProcedure;
    }

    public Slot withInternalProcedure(String internalProcedure) {
        this.internalProcedure = internalProcedure;
        return this;
    }

    public String getDocToken() {
        return docToken;
    }

    public void setDocToken(String docToken) {
        this.docToken = docToken;
    }

    public Slot withDocToken(String docToken) {
        this.docToken = docToken;
        return this;
    }

    public String getFollowUpOf() {
        return followUpOf;
    }

    public void setFollowUpOf(String followUpOf) {
        this.followUpOf = followUpOf;
    }

    public Slot withFollowUpOf(String followUpOf) {
        this.followUpOf = followUpOf;
        return this;
    }

    public Long getDependentId() {
        return dependentId;
    }

    public void setDependentId(Long dependentId) {
        this.dependentId = dependentId;
    }

    public Slot withDependentId(Long dependentId) {
        this.dependentId = dependentId;
        return this;
    }

    public Boolean getIsOnWaiting() {
        return isOnWaiting;
    }

    public void setIsOnWaiting(Boolean isOnWaiting) {
        this.isOnWaiting = isOnWaiting;
    }

    public Slot withIsOnWaiting(Boolean isOnWaiting) {
        this.isOnWaiting = isOnWaiting;
        return this;
    }

    public String getPatientPriority() {
        return patientPriority;
    }

    public void setPatientPriority(String patientPriority) {
        this.patientPriority = patientPriority;
    }

    public Slot withPatientPriority(String patientPriority) {
        this.patientPriority = patientPriority;
        return this;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public Slot withCompletedAt(String completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    public String getSendSms() {
        return sendSms;
    }

    public void setSendSms(String sendSms) {
        this.sendSms = sendSms;
    }

    public Slot withSendSms(String sendSms) {
        this.sendSms = sendSms;
        return this;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("doctorId", doctorId).append("patientId", patientId).append("available", available).append("day", day).append("status", status).append("createdAt", createdAt).append("updatedAt", updatedAt).append("completed", completed).append("rejected", rejected).append("rejectedBy", rejectedBy).append("slotType", slotType).append("locationId", locationId).append("doctorSittingId", doctorSittingId).append("startTime", startTime).append("endTime", endTime).append("paymentId", paymentId).append("medicalPracticeId", medicalPracticeId).append("complaint", complaint).append("patientStatus", patientStatus).append("patientArrivedAt", patientArrivedAt).append("patientCheckinAt", patientCheckinAt).append("patientCheckoutAt", patientCheckoutAt).append("appointmentToken", appointmentToken).append("bookedByUserId", bookedByUserId).append("bookedByRoleId", bookedByRoleId).append("bookedFromPlatform", bookedFromPlatform).append("rescheduleCount", rescheduleCount).append("slotStatus", slotStatus).append("bookingTime", bookingTime).append("noShow", noShow).append("noShowAt", noShowAt).append("followUpId", followUpId).append("isPaid", isPaid).append("bookingType", bookingType).append("internalProcedure", internalProcedure).append("docToken", docToken).append("followUpOf", followUpOf).append("dependentId", dependentId).append("isOnWaiting", isOnWaiting).append("patientPriority", patientPriority).append("completedAt", completedAt).append("sendSms", sendSms).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(doctorId);
        dest.writeValue(patientId);
        dest.writeValue(available);
        dest.writeValue(day);
        dest.writeValue(status);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(completed);
        dest.writeValue(rejected);
        dest.writeValue(rejectedBy);
        dest.writeValue(slotType);
        dest.writeValue(locationId);
        dest.writeValue(doctorSittingId);
        dest.writeValue(startTime);
        dest.writeValue(endTime);
        dest.writeValue(paymentId);
        dest.writeValue(medicalPracticeId);
        dest.writeValue(complaint);
        dest.writeValue(patientStatus);
        dest.writeValue(patientArrivedAt);
        dest.writeValue(patientCheckinAt);
        dest.writeValue(patientCheckoutAt);
        dest.writeValue(appointmentToken);
        dest.writeValue(bookedByUserId);
        dest.writeValue(bookedByRoleId);
        dest.writeValue(bookedFromPlatform);
        dest.writeValue(rescheduleCount);
        dest.writeValue(slotStatus);
        dest.writeValue(bookingTime);
        dest.writeValue(noShow);
        dest.writeValue(noShowAt);
        dest.writeValue(followUpId);
        dest.writeValue(isPaid);
        dest.writeValue(bookingType);
        dest.writeValue(internalProcedure);
        dest.writeValue(docToken);
        dest.writeValue(followUpOf);
        dest.writeValue(dependentId);
        dest.writeValue(isOnWaiting);
        dest.writeValue(patientPriority);
        dest.writeValue(completedAt);
        dest.writeValue(sendSms);
        dest.writeValue(statusString);
        dest.writeValue(startDateTime);
        dest.writeValue(endDateTime);
    }

    public int describeContents() {
        return 0;
    }

}