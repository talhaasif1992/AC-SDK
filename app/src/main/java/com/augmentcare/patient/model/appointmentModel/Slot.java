
package com.augmentcare.patient.model.appointmentModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slot {

    @SerializedName("id")
    @Expose
    private Integer id;
    
    @SerializedName("doctor_id")
    @Expose
    private Integer doctor_id;
    
    @SerializedName("patient_id")
    @Expose
    private Integer patient_id;
    
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
    private String created_at;
    
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    
    @SerializedName("rejected")
    @Expose
    private Boolean rejected;
    
    @SerializedName("rejected_by")
    @Expose
    private Object rejected_by;
    
    @SerializedName("slot_type")
    @Expose
    private Boolean slot_type;
    
    @SerializedName("location_id")
    @Expose
    private Object location_id;
    
    @SerializedName("doctor_sitting_id")
    @Expose
    private Object doctor_sitting_id;
    
    @SerializedName("start_time")
    @Expose
    private String start_time;
  
    @SerializedName("end_time")
    @Expose
    private String end_time;
    
    @SerializedName("payment_id")
    @Expose
    private Integer payment_id;
   
    @SerializedName("medical_practice_id")
    @Expose
    private Object medical_practice_id;
   
    @SerializedName("complaint")
    @Expose
    private Object complaint;
   
    @SerializedName("patient_status")
    @Expose
    private String patient_status;
   
    @SerializedName("patient_arrived_at")
    @Expose
    private Object patient_arrived_at;
   
    @SerializedName("patient_checkin_at")
    @Expose
    private Object patient_checkin_at;
   
    @SerializedName("patient_checkout_at")
    @Expose
    private Object patient_checkout_at;
   
    @SerializedName("appointment_token")
    @Expose
    private Object appointment_token;
   
    @SerializedName("booked_by_user_id")
    @Expose
    private Integer booked_by_user_id;
   
    @SerializedName("booked_by_role_id")
    @Expose
    private Integer booked_by_role_id;
   
    @SerializedName("booked_from_platform")
    @Expose
    private String booked_from_platform;
   
    @SerializedName("reschedule_count")
    @Expose
    private Integer reschedule_count;
   
    @SerializedName("slot_status")
    @Expose
    private String slot_status;
   
    @SerializedName("booking_time")
    @Expose
    private String booking_time;
   
    @SerializedName("no_show")
    @Expose
    private Boolean no_show;
   
    @SerializedName("no_show_at")
    @Expose
    private Object no_show_at;
   
    @SerializedName("follow_up_id")
    @Expose
    private Object follow_up_id;
   
    @SerializedName("is_paid")
    @Expose
    private Boolean is_paid;
   
    @SerializedName("booking_type")
    @Expose
    private String booking_type;
   
    @SerializedName("internal_procedure")
    @Expose
    private Object internal_procedure;
   
    @SerializedName("doc_token")
    @Expose
    private String doc_token;
   
    @SerializedName("follow_up_of")
    @Expose
    private Object follow_up_of;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getPatientId() {
        return patient_id;
    }

    public void setPatientId(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
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
        return rejected_by;
    }

    public void setRejectedBy(Object rejected_by) {
        this.rejected_by = rejected_by;
    }

    public Boolean getSlotType() {
        return slot_type;
    }

    public void setSlotType(Boolean slot_type) {
        this.slot_type = slot_type;
    }

    public Object getLocationId() {
        return location_id;
    }

    public void setLocationId(Object location_id) {
        this.location_id = location_id;
    }

    public Object getDoctorSittingId() {
        return doctor_sitting_id;
    }

    public void setDoctorSittingId(Object doctor_sitting_id) {
        this.doctor_sitting_id = doctor_sitting_id;
    }

    public String getStartTime() {
        return start_time;
    }

    public void setStartTime(String start_time) {
        this.start_time = start_time;
    }

    public String getEndTime() {
        return end_time;
    }

    public void setEndTime(String end_time) {
        this.end_time = end_time;
    }

    public Integer getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public Object getMedicalPracticeId() {
        return medical_practice_id;
    }

    public void setMedicalPracticeId(Object medical_practice_id) {
        this.medical_practice_id = medical_practice_id;
    }

    public Object getComplaint() {
        return complaint;
    }

    public void setComplaint(Object complaint) {
        this.complaint = complaint;
    }

    public String getPatientStatus() {
        return patient_status;
    }

    public void setPatientStatus(String patient_status) {
        this.patient_status = patient_status;
    }

    public Object getPatientArrivedAt() {
        return patient_arrived_at;
    }

    public void setPatientArrivedAt(Object patient_arrived_at) {
        this.patient_arrived_at = patient_arrived_at;
    }

    public Object getPatientCheckinAt() {
        return patient_checkin_at;
    }

    public void setPatientCheckinAt(Object patient_checkin_at) {
        this.patient_checkin_at = patient_checkin_at;
    }

    public Object getPatientCheckoutAt() {
        return patient_checkout_at;
    }

    public void setPatientCheckoutAt(Object patient_checkout_at) {
        this.patient_checkout_at = patient_checkout_at;
    }

    public Object getAppointmentToken() {
        return appointment_token;
    }

    public void setAppointmentToken(Object appointment_token) {
        this.appointment_token = appointment_token;
    }

    public Integer getBookedByUserId() {
        return booked_by_user_id;
    }

    public void setBookedByUserId(Integer booked_by_user_id) {
        this.booked_by_user_id = booked_by_user_id;
    }

    public Integer getBookedByRoleId() {
        return booked_by_role_id;
    }

    public void setBookedByRoleId(Integer booked_by_role_id) {
        this.booked_by_role_id = booked_by_role_id;
    }

    public String getBookedFromPlatform() {
        return booked_from_platform;
    }

    public void setBookedFromPlatform(String booked_from_platform) {
        this.booked_from_platform = booked_from_platform;
    }

    public Integer getRescheduleCount() {
        return reschedule_count;
    }

    public void setRescheduleCount(Integer reschedule_count) {
        this.reschedule_count = reschedule_count;
    }

    public String getSlotStatus() {
        return slot_status;
    }

    public void setSlotStatus(String slot_status) {
        this.slot_status = slot_status;
    }

    public String getBookingTime() {
        return booking_time;
    }

    public void setBookingTime(String booking_time) {
        this.booking_time = booking_time;
    }

    public Boolean getNoShow() {
        return no_show;
    }

    public void setNoShow(Boolean no_show) {
        this.no_show = no_show;
    }

    public Object getNoShowAt() {
        return no_show_at;
    }

    public void setNoShowAt(Object no_show_at) {
        this.no_show_at = no_show_at;
    }

    public Object getFollowUpId() {
        return follow_up_id;
    }

    public void setFollowUpId(Object follow_up_id) {
        this.follow_up_id = follow_up_id;
    }

    public Boolean getIsPaid() {
        return is_paid;
    }

    public void setIsPaid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public String getBookingType() {
        return booking_type;
    }

    public void setBookingType(String booking_type) {
        this.booking_type = booking_type;
    }

    public Object getInternalProcedure() {
        return internal_procedure;
    }

    public void setInternalProcedure(Object internal_procedure) {
        this.internal_procedure = internal_procedure;
    }

    public String getDocToken() {
        return doc_token;
    }

    public void setDocToken(String doc_token) {
        this.doc_token = doc_token;
    }

    public Object getFollowUpOf() {
        return follow_up_of;
    }

    public void setFollowUpOf(Object follow_up_of) {
        this.follow_up_of = follow_up_of;
    }

}
