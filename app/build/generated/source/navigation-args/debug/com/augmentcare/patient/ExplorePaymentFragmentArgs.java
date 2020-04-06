package com.augmentcare.patient;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ExplorePaymentFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ExplorePaymentFragmentArgs() {
  }

  private ExplorePaymentFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ExplorePaymentFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ExplorePaymentFragmentArgs __result = new ExplorePaymentFragmentArgs();
    bundle.setClassLoader(ExplorePaymentFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("doctor")) {
      DoctorInfoLimited doctor;
      if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
        doctor = (DoctorInfoLimited) bundle.get("doctor");
      } else {
        throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("doctor", doctor);
    }
    if (bundle.containsKey("pateintName")) {
      String pateintName;
      pateintName = bundle.getString("pateintName");
      __result.arguments.put("pateintName", pateintName);
    }
    if (bundle.containsKey("selectedDate")) {
      String selectedDate;
      selectedDate = bundle.getString("selectedDate");
      __result.arguments.put("selectedDate", selectedDate);
    }
    if (bundle.containsKey("timeSlot")) {
      String timeSlot;
      timeSlot = bundle.getString("timeSlot");
      __result.arguments.put("timeSlot", timeSlot);
    }
    if (bundle.containsKey("dependentId")) {
      String dependentId;
      dependentId = bundle.getString("dependentId");
      __result.arguments.put("dependentId", dependentId);
    }
    if (bundle.containsKey("cardId")) {
      String cardId;
      cardId = bundle.getString("cardId");
      __result.arguments.put("cardId", cardId);
    }
    if (bundle.containsKey("endTime")) {
      String endTime;
      endTime = bundle.getString("endTime");
      __result.arguments.put("endTime", endTime);
    }
    if (bundle.containsKey("exploreDoctorSuccessResponseObj")) {
      EliteDoctorSuccess exploreDoctorSuccessResponseObj;
      if (Parcelable.class.isAssignableFrom(EliteDoctorSuccess.class) || Serializable.class.isAssignableFrom(EliteDoctorSuccess.class)) {
        exploreDoctorSuccessResponseObj = (EliteDoctorSuccess) bundle.get("exploreDoctorSuccessResponseObj");
      } else {
        throw new UnsupportedOperationException(EliteDoctorSuccess.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("exploreDoctorSuccessResponseObj", exploreDoctorSuccessResponseObj);
    }
    if (bundle.containsKey("appointmentType")) {
      String appointmentType;
      appointmentType = bundle.getString("appointmentType");
      __result.arguments.put("appointmentType", appointmentType);
    }
    if (bundle.containsKey("doctorDetailId")) {
      String doctorDetailId;
      doctorDetailId = bundle.getString("doctorDetailId");
      __result.arguments.put("doctorDetailId", doctorDetailId);
    }
    if (bundle.containsKey("medicalPracticeId")) {
      String medicalPracticeId;
      medicalPracticeId = bundle.getString("medicalPracticeId");
      __result.arguments.put("medicalPracticeId", medicalPracticeId);
    }
    if (bundle.containsKey("medicalPracticeName")) {
      String medicalPracticeName;
      medicalPracticeName = bundle.getString("medicalPracticeName");
      __result.arguments.put("medicalPracticeName", medicalPracticeName);
    }
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      __result.arguments.put("type", type);
    }
    if (bundle.containsKey("instantDoctor")) {
      String instantDoctor;
      instantDoctor = bundle.getString("instantDoctor");
      __result.arguments.put("instantDoctor", instantDoctor);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public DoctorInfoLimited getDoctor() {
    return (DoctorInfoLimited) arguments.get("doctor");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPateintName() {
    return (String) arguments.get("pateintName");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getSelectedDate() {
    return (String) arguments.get("selectedDate");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getTimeSlot() {
    return (String) arguments.get("timeSlot");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getDependentId() {
    return (String) arguments.get("dependentId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getCardId() {
    return (String) arguments.get("cardId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getEndTime() {
    return (String) arguments.get("endTime");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public EliteDoctorSuccess getExploreDoctorSuccessResponseObj() {
    return (EliteDoctorSuccess) arguments.get("exploreDoctorSuccessResponseObj");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getAppointmentType() {
    return (String) arguments.get("appointmentType");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getDoctorDetailId() {
    return (String) arguments.get("doctorDetailId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getMedicalPracticeId() {
    return (String) arguments.get("medicalPracticeId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getMedicalPracticeName() {
    return (String) arguments.get("medicalPracticeName");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getType() {
    return (String) arguments.get("type");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getInstantDoctor() {
    return (String) arguments.get("instantDoctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("doctor")) {
      DoctorInfoLimited doctor = (DoctorInfoLimited) arguments.get("doctor");
      if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || doctor == null) {
        __result.putParcelable("doctor", Parcelable.class.cast(doctor));
      } else if (Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
        __result.putSerializable("doctor", Serializable.class.cast(doctor));
      } else {
        throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    if (arguments.containsKey("pateintName")) {
      String pateintName = (String) arguments.get("pateintName");
      __result.putString("pateintName", pateintName);
    }
    if (arguments.containsKey("selectedDate")) {
      String selectedDate = (String) arguments.get("selectedDate");
      __result.putString("selectedDate", selectedDate);
    }
    if (arguments.containsKey("timeSlot")) {
      String timeSlot = (String) arguments.get("timeSlot");
      __result.putString("timeSlot", timeSlot);
    }
    if (arguments.containsKey("dependentId")) {
      String dependentId = (String) arguments.get("dependentId");
      __result.putString("dependentId", dependentId);
    }
    if (arguments.containsKey("cardId")) {
      String cardId = (String) arguments.get("cardId");
      __result.putString("cardId", cardId);
    }
    if (arguments.containsKey("endTime")) {
      String endTime = (String) arguments.get("endTime");
      __result.putString("endTime", endTime);
    }
    if (arguments.containsKey("exploreDoctorSuccessResponseObj")) {
      EliteDoctorSuccess exploreDoctorSuccessResponseObj = (EliteDoctorSuccess) arguments.get("exploreDoctorSuccessResponseObj");
      if (Parcelable.class.isAssignableFrom(EliteDoctorSuccess.class) || exploreDoctorSuccessResponseObj == null) {
        __result.putParcelable("exploreDoctorSuccessResponseObj", Parcelable.class.cast(exploreDoctorSuccessResponseObj));
      } else if (Serializable.class.isAssignableFrom(EliteDoctorSuccess.class)) {
        __result.putSerializable("exploreDoctorSuccessResponseObj", Serializable.class.cast(exploreDoctorSuccessResponseObj));
      } else {
        throw new UnsupportedOperationException(EliteDoctorSuccess.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    if (arguments.containsKey("appointmentType")) {
      String appointmentType = (String) arguments.get("appointmentType");
      __result.putString("appointmentType", appointmentType);
    }
    if (arguments.containsKey("doctorDetailId")) {
      String doctorDetailId = (String) arguments.get("doctorDetailId");
      __result.putString("doctorDetailId", doctorDetailId);
    }
    if (arguments.containsKey("medicalPracticeId")) {
      String medicalPracticeId = (String) arguments.get("medicalPracticeId");
      __result.putString("medicalPracticeId", medicalPracticeId);
    }
    if (arguments.containsKey("medicalPracticeName")) {
      String medicalPracticeName = (String) arguments.get("medicalPracticeName");
      __result.putString("medicalPracticeName", medicalPracticeName);
    }
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.putString("type", type);
    }
    if (arguments.containsKey("instantDoctor")) {
      String instantDoctor = (String) arguments.get("instantDoctor");
      __result.putString("instantDoctor", instantDoctor);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ExplorePaymentFragmentArgs that = (ExplorePaymentFragmentArgs) object;
    if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
      return false;
    }
    if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
      return false;
    }
    if (arguments.containsKey("pateintName") != that.arguments.containsKey("pateintName")) {
      return false;
    }
    if (getPateintName() != null ? !getPateintName().equals(that.getPateintName()) : that.getPateintName() != null) {
      return false;
    }
    if (arguments.containsKey("selectedDate") != that.arguments.containsKey("selectedDate")) {
      return false;
    }
    if (getSelectedDate() != null ? !getSelectedDate().equals(that.getSelectedDate()) : that.getSelectedDate() != null) {
      return false;
    }
    if (arguments.containsKey("timeSlot") != that.arguments.containsKey("timeSlot")) {
      return false;
    }
    if (getTimeSlot() != null ? !getTimeSlot().equals(that.getTimeSlot()) : that.getTimeSlot() != null) {
      return false;
    }
    if (arguments.containsKey("dependentId") != that.arguments.containsKey("dependentId")) {
      return false;
    }
    if (getDependentId() != null ? !getDependentId().equals(that.getDependentId()) : that.getDependentId() != null) {
      return false;
    }
    if (arguments.containsKey("cardId") != that.arguments.containsKey("cardId")) {
      return false;
    }
    if (getCardId() != null ? !getCardId().equals(that.getCardId()) : that.getCardId() != null) {
      return false;
    }
    if (arguments.containsKey("endTime") != that.arguments.containsKey("endTime")) {
      return false;
    }
    if (getEndTime() != null ? !getEndTime().equals(that.getEndTime()) : that.getEndTime() != null) {
      return false;
    }
    if (arguments.containsKey("exploreDoctorSuccessResponseObj") != that.arguments.containsKey("exploreDoctorSuccessResponseObj")) {
      return false;
    }
    if (getExploreDoctorSuccessResponseObj() != null ? !getExploreDoctorSuccessResponseObj().equals(that.getExploreDoctorSuccessResponseObj()) : that.getExploreDoctorSuccessResponseObj() != null) {
      return false;
    }
    if (arguments.containsKey("appointmentType") != that.arguments.containsKey("appointmentType")) {
      return false;
    }
    if (getAppointmentType() != null ? !getAppointmentType().equals(that.getAppointmentType()) : that.getAppointmentType() != null) {
      return false;
    }
    if (arguments.containsKey("doctorDetailId") != that.arguments.containsKey("doctorDetailId")) {
      return false;
    }
    if (getDoctorDetailId() != null ? !getDoctorDetailId().equals(that.getDoctorDetailId()) : that.getDoctorDetailId() != null) {
      return false;
    }
    if (arguments.containsKey("medicalPracticeId") != that.arguments.containsKey("medicalPracticeId")) {
      return false;
    }
    if (getMedicalPracticeId() != null ? !getMedicalPracticeId().equals(that.getMedicalPracticeId()) : that.getMedicalPracticeId() != null) {
      return false;
    }
    if (arguments.containsKey("medicalPracticeName") != that.arguments.containsKey("medicalPracticeName")) {
      return false;
    }
    if (getMedicalPracticeName() != null ? !getMedicalPracticeName().equals(that.getMedicalPracticeName()) : that.getMedicalPracticeName() != null) {
      return false;
    }
    if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
      return false;
    }
    if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
      return false;
    }
    if (arguments.containsKey("instantDoctor") != that.arguments.containsKey("instantDoctor")) {
      return false;
    }
    if (getInstantDoctor() != null ? !getInstantDoctor().equals(that.getInstantDoctor()) : that.getInstantDoctor() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
    result = 31 * result + (getPateintName() != null ? getPateintName().hashCode() : 0);
    result = 31 * result + (getSelectedDate() != null ? getSelectedDate().hashCode() : 0);
    result = 31 * result + (getTimeSlot() != null ? getTimeSlot().hashCode() : 0);
    result = 31 * result + (getDependentId() != null ? getDependentId().hashCode() : 0);
    result = 31 * result + (getCardId() != null ? getCardId().hashCode() : 0);
    result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
    result = 31 * result + (getExploreDoctorSuccessResponseObj() != null ? getExploreDoctorSuccessResponseObj().hashCode() : 0);
    result = 31 * result + (getAppointmentType() != null ? getAppointmentType().hashCode() : 0);
    result = 31 * result + (getDoctorDetailId() != null ? getDoctorDetailId().hashCode() : 0);
    result = 31 * result + (getMedicalPracticeId() != null ? getMedicalPracticeId().hashCode() : 0);
    result = 31 * result + (getMedicalPracticeName() != null ? getMedicalPracticeName().hashCode() : 0);
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    result = 31 * result + (getInstantDoctor() != null ? getInstantDoctor().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ExplorePaymentFragmentArgs{"
        + "doctor=" + getDoctor()
        + ", pateintName=" + getPateintName()
        + ", selectedDate=" + getSelectedDate()
        + ", timeSlot=" + getTimeSlot()
        + ", dependentId=" + getDependentId()
        + ", cardId=" + getCardId()
        + ", endTime=" + getEndTime()
        + ", exploreDoctorSuccessResponseObj=" + getExploreDoctorSuccessResponseObj()
        + ", appointmentType=" + getAppointmentType()
        + ", doctorDetailId=" + getDoctorDetailId()
        + ", medicalPracticeId=" + getMedicalPracticeId()
        + ", medicalPracticeName=" + getMedicalPracticeName()
        + ", type=" + getType()
        + ", instantDoctor=" + getInstantDoctor()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ExplorePaymentFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ExplorePaymentFragmentArgs build() {
      ExplorePaymentFragmentArgs result = new ExplorePaymentFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctor(@Nullable DoctorInfoLimited doctor) {
      this.arguments.put("doctor", doctor);
      return this;
    }

    @NonNull
    public Builder setPateintName(@Nullable String pateintName) {
      this.arguments.put("pateintName", pateintName);
      return this;
    }

    @NonNull
    public Builder setSelectedDate(@Nullable String selectedDate) {
      this.arguments.put("selectedDate", selectedDate);
      return this;
    }

    @NonNull
    public Builder setTimeSlot(@Nullable String timeSlot) {
      this.arguments.put("timeSlot", timeSlot);
      return this;
    }

    @NonNull
    public Builder setDependentId(@Nullable String dependentId) {
      this.arguments.put("dependentId", dependentId);
      return this;
    }

    @NonNull
    public Builder setCardId(@Nullable String cardId) {
      this.arguments.put("cardId", cardId);
      return this;
    }

    @NonNull
    public Builder setEndTime(@Nullable String endTime) {
      this.arguments.put("endTime", endTime);
      return this;
    }

    @NonNull
    public Builder setExploreDoctorSuccessResponseObj(@Nullable EliteDoctorSuccess exploreDoctorSuccessResponseObj) {
      this.arguments.put("exploreDoctorSuccessResponseObj", exploreDoctorSuccessResponseObj);
      return this;
    }

    @NonNull
    public Builder setAppointmentType(@Nullable String appointmentType) {
      this.arguments.put("appointmentType", appointmentType);
      return this;
    }

    @NonNull
    public Builder setDoctorDetailId(@Nullable String doctorDetailId) {
      this.arguments.put("doctorDetailId", doctorDetailId);
      return this;
    }

    @NonNull
    public Builder setMedicalPracticeId(@Nullable String medicalPracticeId) {
      this.arguments.put("medicalPracticeId", medicalPracticeId);
      return this;
    }

    @NonNull
    public Builder setMedicalPracticeName(@Nullable String medicalPracticeName) {
      this.arguments.put("medicalPracticeName", medicalPracticeName);
      return this;
    }

    @NonNull
    public Builder setType(@Nullable String type) {
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    public Builder setInstantDoctor(@Nullable String instantDoctor) {
      this.arguments.put("instantDoctor", instantDoctor);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public DoctorInfoLimited getDoctor() {
      return (DoctorInfoLimited) arguments.get("doctor");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPateintName() {
      return (String) arguments.get("pateintName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getSelectedDate() {
      return (String) arguments.get("selectedDate");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getTimeSlot() {
      return (String) arguments.get("timeSlot");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDependentId() {
      return (String) arguments.get("dependentId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCardId() {
      return (String) arguments.get("cardId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEndTime() {
      return (String) arguments.get("endTime");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public EliteDoctorSuccess getExploreDoctorSuccessResponseObj() {
      return (EliteDoctorSuccess) arguments.get("exploreDoctorSuccessResponseObj");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getAppointmentType() {
      return (String) arguments.get("appointmentType");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDoctorDetailId() {
      return (String) arguments.get("doctorDetailId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getMedicalPracticeId() {
      return (String) arguments.get("medicalPracticeId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getMedicalPracticeName() {
      return (String) arguments.get("medicalPracticeName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getType() {
      return (String) arguments.get("type");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getInstantDoctor() {
      return (String) arguments.get("instantDoctor");
    }
  }
}
