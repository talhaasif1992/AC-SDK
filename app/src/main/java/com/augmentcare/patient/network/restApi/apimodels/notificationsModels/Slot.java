package com.augmentcare.patient.network.restApi.apimodels.notificationsModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Slot implements Parcelable {

	@SerializedName("internal_procedure")
	private Object internalProcedure;

	@SerializedName("follow_up_id")
	private Object followUpId;

	@SerializedName("rejected")
	private boolean rejected;

	@SerializedName("available")
	private Object available;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("patient_status")
	private String patientStatus;

	@SerializedName("location_id")
	private Object locationId;

	@SerializedName("appointment_token")
	private Object appointmentToken;

	@SerializedName("rejected_by")
	private Object rejectedBy;

	@SerializedName("doctor_id")
	private int doctorId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("dependent_id")
	private int dependentId;

	@SerializedName("payment_id")
	private Object paymentId;

	@SerializedName("follow_up_of")
	private Object followUpOf;

	@SerializedName("id")
	private int id;

	@SerializedName("booked_by_role_id")
	private int bookedByRoleId;

	@SerializedName("is_paid")
	private boolean isPaid;

	@SerializedName("doctor_sitting_id")
	private Object doctorSittingId;

	@SerializedName("day")
	private String day;

	@SerializedName("reschedule_count")
	private int rescheduleCount;

	@SerializedName("patient_priority")
	private String patientPriority;

	@SerializedName("is_on_waiting")
	private boolean isOnWaiting;

	@SerializedName("slot_type")
	private Object slotType;

	@SerializedName("end_time")
	private String endTime;

	@SerializedName("patient_checkin_at")
	private Object patientCheckinAt;

	@SerializedName("booking_time")
	private String bookingTime;

	@SerializedName("completed")
	private boolean completed;

	@SerializedName("doc_token")
	private Object docToken;

	@SerializedName("booked_by_user_id")
	private int bookedByUserId;

	@SerializedName("start_time")
	private String startTime;

	@SerializedName("completed_at")
	private Object completedAt;

	@SerializedName("patient_arrived_at")
	private Object patientArrivedAt;

	@SerializedName("complaint")
	private Object complaint;

	@SerializedName("no_show_at")
	private Object noShowAt;

	@SerializedName("patient_id")
	private int patientId;

	@SerializedName("medical_practice_id")
	private Object medicalPracticeId;

	@SerializedName("booked_from_platform")
	private String bookedFromPlatform;

	@SerializedName("slot_status")
	private String slotStatus;

	@SerializedName("booking_type")
	private String bookingType;

	@SerializedName("no_show")
	private boolean noShow;

	@SerializedName("send_sms")
	private Object sendSms;

	@SerializedName("status")
	private Object status;

	@SerializedName("patient_checkout_at")
	private Object patientCheckoutAt;

	protected Slot(Parcel in) {
		rejected = in.readByte() != 0;
		createdAt = in.readString();
		patientStatus = in.readString();
		doctorId = in.readInt();
		updatedAt = in.readString();
		dependentId = in.readInt();
		id = in.readInt();
		bookedByRoleId = in.readInt();
		isPaid = in.readByte() != 0;
		day = in.readString();
		rescheduleCount = in.readInt();
		patientPriority = in.readString();
		isOnWaiting = in.readByte() != 0;
		endTime = in.readString();
		bookingTime = in.readString();
		completed = in.readByte() != 0;
		bookedByUserId = in.readInt();
		startTime = in.readString();
		patientId = in.readInt();
		bookedFromPlatform = in.readString();
		slotStatus = in.readString();
		bookingType = in.readString();
		noShow = in.readByte() != 0;
	}

	public static final Creator<Slot> CREATOR = new Creator<Slot>() {
		@Override
		public Slot createFromParcel(Parcel in) {
			return new Slot(in);
		}

		@Override
		public Slot[] newArray(int size) {
			return new Slot[size];
		}
	};

	public void setInternalProcedure(Object internalProcedure){
		this.internalProcedure = internalProcedure;
	}

	public Object getInternalProcedure(){
		return internalProcedure;
	}

	public void setFollowUpId(Object followUpId){
		this.followUpId = followUpId;
	}

	public Object getFollowUpId(){
		return followUpId;
	}

	public void setRejected(boolean rejected){
		this.rejected = rejected;
	}

	public boolean isRejected(){
		return rejected;
	}

	public void setAvailable(Object available){
		this.available = available;
	}

	public Object getAvailable(){
		return available;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setPatientStatus(String patientStatus){
		this.patientStatus = patientStatus;
	}

	public String getPatientStatus(){
		return patientStatus;
	}

	public void setLocationId(Object locationId){
		this.locationId = locationId;
	}

	public Object getLocationId(){
		return locationId;
	}

	public void setAppointmentToken(Object appointmentToken){
		this.appointmentToken = appointmentToken;
	}

	public Object getAppointmentToken(){
		return appointmentToken;
	}

	public void setRejectedBy(Object rejectedBy){
		this.rejectedBy = rejectedBy;
	}

	public Object getRejectedBy(){
		return rejectedBy;
	}

	public void setDoctorId(int doctorId){
		this.doctorId = doctorId;
	}

	public int getDoctorId(){
		return doctorId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setDependentId(int dependentId){
		this.dependentId = dependentId;
	}

	public int getDependentId(){
		return dependentId;
	}

	public void setPaymentId(Object paymentId){
		this.paymentId = paymentId;
	}

	public Object getPaymentId(){
		return paymentId;
	}

	public void setFollowUpOf(Object followUpOf){
		this.followUpOf = followUpOf;
	}

	public Object getFollowUpOf(){
		return followUpOf;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBookedByRoleId(int bookedByRoleId){
		this.bookedByRoleId = bookedByRoleId;
	}

	public int getBookedByRoleId(){
		return bookedByRoleId;
	}

	public void setIsPaid(boolean isPaid){
		this.isPaid = isPaid;
	}

	public boolean isIsPaid(){
		return isPaid;
	}

	public void setDoctorSittingId(Object doctorSittingId){
		this.doctorSittingId = doctorSittingId;
	}

	public Object getDoctorSittingId(){
		return doctorSittingId;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	public void setRescheduleCount(int rescheduleCount){
		this.rescheduleCount = rescheduleCount;
	}

	public int getRescheduleCount(){
		return rescheduleCount;
	}

	public void setPatientPriority(String patientPriority){
		this.patientPriority = patientPriority;
	}

	public String getPatientPriority(){
		return patientPriority;
	}

	public void setIsOnWaiting(boolean isOnWaiting){
		this.isOnWaiting = isOnWaiting;
	}

	public boolean isIsOnWaiting(){
		return isOnWaiting;
	}

	public void setSlotType(Object slotType){
		this.slotType = slotType;
	}

	public Object getSlotType(){
		return slotType;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setPatientCheckinAt(Object patientCheckinAt){
		this.patientCheckinAt = patientCheckinAt;
	}

	public Object getPatientCheckinAt(){
		return patientCheckinAt;
	}

	public void setBookingTime(String bookingTime){
		this.bookingTime = bookingTime;
	}

	public String getBookingTime(){
		return bookingTime;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public boolean isCompleted(){
		return completed;
	}

	public void setDocToken(Object docToken){
		this.docToken = docToken;
	}

	public Object getDocToken(){
		return docToken;
	}

	public void setBookedByUserId(int bookedByUserId){
		this.bookedByUserId = bookedByUserId;
	}

	public int getBookedByUserId(){
		return bookedByUserId;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setCompletedAt(Object completedAt){
		this.completedAt = completedAt;
	}

	public Object getCompletedAt(){
		return completedAt;
	}

	public void setPatientArrivedAt(Object patientArrivedAt){
		this.patientArrivedAt = patientArrivedAt;
	}

	public Object getPatientArrivedAt(){
		return patientArrivedAt;
	}

	public void setComplaint(Object complaint){
		this.complaint = complaint;
	}

	public Object getComplaint(){
		return complaint;
	}

	public void setNoShowAt(Object noShowAt){
		this.noShowAt = noShowAt;
	}

	public Object getNoShowAt(){
		return noShowAt;
	}

	public void setPatientId(int patientId){
		this.patientId = patientId;
	}

	public int getPatientId(){
		return patientId;
	}

	public void setMedicalPracticeId(Object medicalPracticeId){
		this.medicalPracticeId = medicalPracticeId;
	}

	public Object getMedicalPracticeId(){
		return medicalPracticeId;
	}

	public void setBookedFromPlatform(String bookedFromPlatform){
		this.bookedFromPlatform = bookedFromPlatform;
	}

	public String getBookedFromPlatform(){
		return bookedFromPlatform;
	}

	public void setSlotStatus(String slotStatus){
		this.slotStatus = slotStatus;
	}

	public String getSlotStatus(){
		return slotStatus;
	}

	public void setBookingType(String bookingType){
		this.bookingType = bookingType;
	}

	public String getBookingType(){
		return bookingType;
	}

	public void setNoShow(boolean noShow){
		this.noShow = noShow;
	}

	public boolean isNoShow(){
		return noShow;
	}

	public void setSendSms(Object sendSms){
		this.sendSms = sendSms;
	}

	public Object getSendSms(){
		return sendSms;
	}

	public void setStatus(Object status){
		this.status = status;
	}

	public Object getStatus(){
		return status;
	}

	public void setPatientCheckoutAt(Object patientCheckoutAt){
		this.patientCheckoutAt = patientCheckoutAt;
	}

	public Object getPatientCheckoutAt(){
		return patientCheckoutAt;
	}

	@Override
 	public String toString(){
		return 
			"Slot{" + 
			"internal_procedure = '" + internalProcedure + '\'' + 
			",follow_up_id = '" + followUpId + '\'' + 
			",rejected = '" + rejected + '\'' + 
			",available = '" + available + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",patient_status = '" + patientStatus + '\'' + 
			",location_id = '" + locationId + '\'' + 
			",appointment_token = '" + appointmentToken + '\'' + 
			",rejected_by = '" + rejectedBy + '\'' + 
			",doctor_id = '" + doctorId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",dependent_id = '" + dependentId + '\'' + 
			",payment_id = '" + paymentId + '\'' + 
			",follow_up_of = '" + followUpOf + '\'' + 
			",id = '" + id + '\'' + 
			",booked_by_role_id = '" + bookedByRoleId + '\'' + 
			",is_paid = '" + isPaid + '\'' + 
			",doctor_sitting_id = '" + doctorSittingId + '\'' + 
			",day = '" + day + '\'' + 
			",reschedule_count = '" + rescheduleCount + '\'' + 
			",patient_priority = '" + patientPriority + '\'' + 
			",is_on_waiting = '" + isOnWaiting + '\'' + 
			",slot_type = '" + slotType + '\'' + 
			",end_time = '" + endTime + '\'' + 
			",patient_checkin_at = '" + patientCheckinAt + '\'' + 
			",booking_time = '" + bookingTime + '\'' + 
			",completed = '" + completed + '\'' + 
			",doc_token = '" + docToken + '\'' + 
			",booked_by_user_id = '" + bookedByUserId + '\'' + 
			",start_time = '" + startTime + '\'' + 
			",completed_at = '" + completedAt + '\'' + 
			",patient_arrived_at = '" + patientArrivedAt + '\'' + 
			",complaint = '" + complaint + '\'' + 
			",no_show_at = '" + noShowAt + '\'' + 
			",patient_id = '" + patientId + '\'' + 
			",medical_practice_id = '" + medicalPracticeId + '\'' + 
			",booked_from_platform = '" + bookedFromPlatform + '\'' + 
			",slot_status = '" + slotStatus + '\'' + 
			",booking_type = '" + bookingType + '\'' + 
			",no_show = '" + noShow + '\'' + 
			",send_sms = '" + sendSms + '\'' + 
			",status = '" + status + '\'' + 
			",patient_checkout_at = '" + patientCheckoutAt + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeByte((byte) (rejected ? 1 : 0));
		parcel.writeString(createdAt);
		parcel.writeString(patientStatus);
		parcel.writeInt(doctorId);
		parcel.writeString(updatedAt);
		parcel.writeInt(dependentId);
		parcel.writeInt(id);
		parcel.writeInt(bookedByRoleId);
		parcel.writeByte((byte) (isPaid ? 1 : 0));
		parcel.writeString(day);
		parcel.writeInt(rescheduleCount);
		parcel.writeString(patientPriority);
		parcel.writeByte((byte) (isOnWaiting ? 1 : 0));
		parcel.writeString(endTime);
		parcel.writeString(bookingTime);
		parcel.writeByte((byte) (completed ? 1 : 0));
		parcel.writeInt(bookedByUserId);
		parcel.writeString(startTime);
		parcel.writeInt(patientId);
		parcel.writeString(bookedFromPlatform);
		parcel.writeString(slotStatus);
		parcel.writeString(bookingType);
		parcel.writeByte((byte) (noShow ? 1 : 0));
	}
}