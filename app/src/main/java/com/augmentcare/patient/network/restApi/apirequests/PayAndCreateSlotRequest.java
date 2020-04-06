package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PayAndCreateSlotRequest implements Parcelable {

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("available")
    @Expose
    private boolean available;
    @SerializedName("consultation_rate")
    @Expose
    private int consultationRate;
    @SerializedName("date_time")
    @Expose
    private String dateTime;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("doctor_id")
    @Expose
    private String doctorId;
    @SerializedName("doctor_sitting_id")
    @Expose
    private int doctorSittingId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("ice_uid")
    @Expose
    private int iceUid;
    @SerializedName("institute_info")
    @Expose
    private String instituteInfo;
    @SerializedName("location_id")
    @Expose
    private int locationId;
    @SerializedName("medical_practice_id")
    @Expose
    private int medicalPracticeId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("patient_firstName")
    @Expose
    private String patientFirstName;
    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("patient_lastName")
    @Expose
    private String patientLastName;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("stripeEmail")
    @Expose
    private String stripeEmail;
    @SerializedName("stripeToken")
    @Expose
    private String stripeToken;
    @SerializedName("type")
    @Expose
    private boolean type;
    @SerializedName("user_role_id")
    @Expose
    private int userRoleId;

    @SerializedName("payment_type")
    @Expose
    private String paymentMethodType;

    @SerializedName("booked_by_user_id")
    @Expose
    private String bookedByUserId;

    @SerializedName("card_id")
    @Expose
    private String cardId;

    @SerializedName("last_four_digits")
    @Expose
    private String lastFourDigits;

    @SerializedName("dependent_id")
    @Expose
    private String dependentId;


    public final static Parcelable.Creator<PayAndCreateSlotRequest> CREATOR = new Creator<PayAndCreateSlotRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PayAndCreateSlotRequest createFromParcel(Parcel in) {
            return new PayAndCreateSlotRequest(in);
        }

        public PayAndCreateSlotRequest[] newArray(int size) {
            return (new PayAndCreateSlotRequest[size]);
        }

    };

    protected PayAndCreateSlotRequest(Parcel in) {
        this.amount = ((int) in.readValue((int.class.getClassLoader())));
        this.available = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.consultationRate = ((int) in.readValue((int.class.getClassLoader())));
        this.dateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorSittingId = ((int) in.readValue((int.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.iceUid = ((int) in.readValue((int.class.getClassLoader())));
        this.instituteInfo = ((String) in.readValue((String.class.getClassLoader())));
        this.locationId = ((int) in.readValue((int.class.getClassLoader())));
        this.medicalPracticeId = ((int) in.readValue((int.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.patientFirstName = ((String) in.readValue((String.class.getClassLoader())));
        this.patientId = ((String) in.readValue((String.class.getClassLoader())));
        this.patientLastName = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.stripeEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.stripeToken = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.userRoleId = ((int) in.readValue((int.class.getClassLoader())));
        this.paymentMethodType = ((String) in.readValue((String.class.getClassLoader())));
        this.bookedByUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.cardId = ((String) in.readValue((String.class.getClassLoader())));
        this.lastFourDigits = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PayAndCreateSlotRequest() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PayAndCreateSlotRequest withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public PayAndCreateSlotRequest withAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public int getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(int consultationRate) {
        this.consultationRate = consultationRate;
    }

    public PayAndCreateSlotRequest withConsultationRate(int consultationRate) {
        this.consultationRate = consultationRate;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public PayAndCreateSlotRequest withDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public PayAndCreateSlotRequest withDay(String day) {
        this.day = day;
        return this;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public PayAndCreateSlotRequest withDoctorId(String doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public int getDoctorSittingId() {
        return doctorSittingId;
    }

    public void setDoctorSittingId(int doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
    }

    public PayAndCreateSlotRequest withDoctorSittingId(int doctorSittingId) {
        this.doctorSittingId = doctorSittingId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayAndCreateSlotRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PayAndCreateSlotRequest withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public int getIceUid() {
        return iceUid;
    }

    public void setIceUid(int iceUid) {
        this.iceUid = iceUid;
    }

    public PayAndCreateSlotRequest withIceUid(int iceUid) {
        this.iceUid = iceUid;
        return this;
    }

    public String getInstituteInfo() {
        return instituteInfo;
    }

    public void setInstituteInfo(String instituteInfo) {
        this.instituteInfo = instituteInfo;
    }

    public PayAndCreateSlotRequest withInstituteInfo(String instituteInfo) {
        this.instituteInfo = instituteInfo;
        return this;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public PayAndCreateSlotRequest withLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public int getMedicalPracticeId() {
        return medicalPracticeId;
    }

    public void setMedicalPracticeId(int medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
    }

    public PayAndCreateSlotRequest withMedicalPracticeId(int medicalPracticeId) {
        this.medicalPracticeId = medicalPracticeId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PayAndCreateSlotRequest withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PayAndCreateSlotRequest withName(String name) {
        this.name = name;
        return this;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public PayAndCreateSlotRequest withPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
        return this;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public PayAndCreateSlotRequest withPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public PayAndCreateSlotRequest withPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public PayAndCreateSlotRequest withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PayAndCreateSlotRequest withStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getStripeEmail() {
        return stripeEmail;
    }

    public void setStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
    }

    public PayAndCreateSlotRequest withStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
        return this;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }

    public PayAndCreateSlotRequest withStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
        return this;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public PayAndCreateSlotRequest withType(boolean type) {
        this.type = type;
        return this;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public PayAndCreateSlotRequest withUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("amount", amount).append("available", available).append("consultationRate", consultationRate).append("dateTime", dateTime).append("day", day).append("doctorId", doctorId).append("doctorSittingId", doctorSittingId).append("email", email).append("endTime", endTime).append("iceUid", iceUid).append("instituteInfo", instituteInfo).append("locationId", locationId).append("medicalPracticeId", medicalPracticeId).append("message", message).append("name", name).append("patientFirstName", patientFirstName).append("patientId", patientId).append("patientLastName", patientLastName).append("startTime", startTime).append("status", status).append("stripeEmail", stripeEmail).append("stripeToken", stripeToken).append("type", type).append("userRoleId", userRoleId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(available);
        dest.writeValue(consultationRate);
        dest.writeValue(dateTime);
        dest.writeValue(day);
        dest.writeValue(doctorId);
        dest.writeValue(doctorSittingId);
        dest.writeValue(email);
        dest.writeValue(endTime);
        dest.writeValue(iceUid);
        dest.writeValue(instituteInfo);
        dest.writeValue(locationId);
        dest.writeValue(medicalPracticeId);
        dest.writeValue(message);
        dest.writeValue(name);
        dest.writeValue(patientFirstName);
        dest.writeValue(patientId);
        dest.writeValue(patientLastName);
        dest.writeValue(startTime);
        dest.writeValue(status);
        dest.writeValue(stripeEmail);
        dest.writeValue(stripeToken);
        dest.writeValue(type);
        dest.writeValue(userRoleId);
        dest.writeValue(dependentId);
    }

    public int describeContents() {
        return 0;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }
    public PayAndCreateSlotRequest withPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
        return this;
    }

    public String getBookedByUserId() {
        return bookedByUserId;
    }
    public void setBookedByUserId(String bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }
    public PayAndCreateSlotRequest withBookedByUserId(String bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
        return this;
    }

    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public PayAndCreateSlotRequest withCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }
    public PayAndCreateSlotRequest withLastFourDigits(String lastFourDigits){
        this.lastFourDigits = lastFourDigits;
        return this;
    }

    public String getDependentId() {
        return dependentId;
    }

    public void setDependentId(String dependentId) {
        this.dependentId = dependentId;
    }

    public PayAndCreateSlotRequest withDependentId(String dependentId){
        this.dependentId = dependentId;
        return this;
    }
}