
package com.augmentcare.patient.model.prescriptionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slot {

    @SerializedName("id")
    private Integer id;

    @SerializedName("doctor_id")
    private Integer doctorId;

    @SerializedName("patient_id")
    private Integer patientId;

    @SerializedName("available")
    @Expose
    private Object available;

    @SerializedName("day")
    @Expose
    private String day;

    @SerializedName("status")
    @Expose
    private Object status;

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
    private Object rejectedBy;

    @SerializedName("slot_type")
    @Expose
    private Object slotType;

    @SerializedName("location_id")
    @Expose
    private Object locationId;

    @SerializedName("doctor_sitting_id")
    @Expose
    private Object doctorSittingId;

    @SerializedName("start_time")
    @Expose
    private String startTime;

    @SerializedName("end_time")
    @Expose
    private String endTime;

    @SerializedName("payment_id")
    @Expose
    private Object paymentId;

    @SerializedName("medical_practice_id")
    @Expose
    private Object medicalPracticeId;

    @SerializedName("complaint")
    @Expose
    private Object complaint;

    @SerializedName("patient_status")
    @Expose
    private String patientStatus;

    @SerializedName("patient_arrived_at")
    @Expose
    private Object patientArrivedAt;

    @SerializedName("patient_checkin_at")
    @Expose
    private Object patientCheckinAt;

    @SerializedName("patient_checkout_at")
    @Expose
    private Object patientCheckoutAt;

    @SerializedName("appointment_token")
    @Expose
    private Object appointmentToken;

    @SerializedName("booked_by_user_id")
    @Expose
    private Integer bookedByUserId;

    @SerializedName("booked_by_role_id")
    @Expose
    private Integer bookedByRoleId;

    @SerializedName("booked_from_platform")
    @Expose
    private String bookedFromPlatform;

    @SerializedName("reschedule_count")
    @Expose
    private Integer rescheduleCount;

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
    private Object noShowAt;

    @SerializedName("follow_up_id")
    @Expose
    private Object followUpId;

    @SerializedName("is_paid")
    @Expose
    private Boolean isPaid;

    @SerializedName("booking_type")
    @Expose
    private String bookingType;

    @SerializedName("internal_procedure")
    @Expose
    private Object internalProcedure;

    @SerializedName("doc_token")
    @Expose
    private Object docToken;

    @SerializedName("follow_up_of")
    @Expose
    private Object followUpOf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Object getAvailable() {
        return available;
    }

    public void setAvailable(Object available) {
        this.available = available;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Object getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(Object rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Object getSlotType() {
        return slotType;
    }

    public void setSlotType(Object slotType) {
        this.slotType = slotType;
    }

    public Object getLocationId() {
        return locationId;
    }

    public void setLocationId(Object locationId) {
        this.locationId = locationId;
    }

    public Object getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(Object doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Object getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Object paymentId) {
        this.paymentId = paymentId;
    }

    public Object getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(Object medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public Object getComplaint() {
        return complaint;
    }

    public void setComplaint(Object complaint) {
        this.complaint = complaint;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public Object getPatientArrivedAt() {
        return patientArrivedAt;
    }

    public void setPatientArrivedAt(Object patientArrivedAt) {
        this.patientArrivedAt = patientArrivedAt;
    }

    public Object getPatientCheckinAt() {
        return patientCheckinAt;
    }

    public void setPatientCheckinAt(Object patientCheckinAt) {
        this.patientCheckinAt = patientCheckinAt;
    }

    public Object getPatientCheckoutAt() {
        return patientCheckoutAt;
    }

    public void setPatientCheckoutAt(Object patientCheckoutAt) {
        this.patientCheckoutAt = patientCheckoutAt;
    }

    public Object getAppointmentToken() {
        return appointmentToken;
    }

    public void setAppointmentToken(Object appointmentToken) {
        this.appointmentToken = appointmentToken;
    }

    public Integer getBookedByUserId() {
        return bookedByUserId;
    }

    public void setBookedByUserId(Integer bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }

    public Integer getBookedByRoleId() {
        return bookedByRoleId;
    }

    public void setBookedByRoleId(Integer bookedByRoleId) {
        this.bookedByRoleId = bookedByRoleId;
    }

    public String getBookedFromPlatform() {
        return bookedFromPlatform;
    }

    public void setBookedFromPlatform(String bookedFromPlatform) {
        this.bookedFromPlatform = bookedFromPlatform;
    }

    public Integer getRescheduleCount() {
        return rescheduleCount;
    }

    public void setRescheduleCount(Integer rescheduleCount) {
        this.rescheduleCount = rescheduleCount;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Boolean getNoShow() {
        return noShow;
    }

    public void setNoShow(Boolean noShow) {
        this.noShow = noShow;
    }

    public Object getNoShowAt() {
        return noShowAt;
    }

    public void setNoShowAt(Object noShowAt) {
        this.noShowAt = noShowAt;
    }

    public Object getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(Object followUpId) {
        this.followUpId = followUpId;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Object getInternalProcedure() {
        return internalProcedure;
    }

    public void setInternalProcedure(Object internalProcedure) {
        this.internalProcedure = internalProcedure;
    }

    public Object getDocToken() {
        return docToken;
    }

    public void setDocToken(Object docToken) {
        this.docToken = docToken;
    }

    public Object getFollowUpOf() {
        return followUpOf;
    }

    public void setFollowUpOf(Object followUpOf) {
        this.followUpOf = followUpOf;
    }

}
