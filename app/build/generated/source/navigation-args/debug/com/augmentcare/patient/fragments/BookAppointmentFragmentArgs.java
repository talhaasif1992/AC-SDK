package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.BookedInstantAppointmentSlot;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.EliteDoctorSuccess;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookAppointmentFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private BookAppointmentFragmentArgs() {
  }

  private BookAppointmentFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static BookAppointmentFragmentArgs fromBundle(@NonNull Bundle bundle) {
    BookAppointmentFragmentArgs __result = new BookAppointmentFragmentArgs();
    bundle.setClassLoader(BookAppointmentFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("doctor")) {
      DoctorInfoLimited doctor;
      if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
        doctor = (DoctorInfoLimited) bundle.get("doctor");
      } else {
        throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("doctor", doctor);
    }
    if (bundle.containsKey("doctorId")) {
      String doctorId;
      doctorId = bundle.getString("doctorId");
      __result.arguments.put("doctorId", doctorId);
    }
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      __result.arguments.put("type", type);
    }
    if (bundle.containsKey("medicalPracticeName")) {
      String medicalPracticeName;
      medicalPracticeName = bundle.getString("medicalPracticeName");
      __result.arguments.put("medicalPracticeName", medicalPracticeName);
    }
    if (bundle.containsKey("medicalPracticeId")) {
      String medicalPracticeId;
      medicalPracticeId = bundle.getString("medicalPracticeId");
      __result.arguments.put("medicalPracticeId", medicalPracticeId);
    }
    if (bundle.containsKey("instantDoctor")) {
      String instantDoctor;
      instantDoctor = bundle.getString("instantDoctor");
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("instantDoctor", instantDoctor);
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
    if (bundle.containsKey("dependentId")) {
      String dependentId;
      dependentId = bundle.getString("dependentId");
      __result.arguments.put("dependentId", dependentId);
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
    if (bundle.containsKey("exploreInstantModelResponseObj")) {
      BookedInstantAppointmentSlot exploreInstantModelResponseObj;
      if (Parcelable.class.isAssignableFrom(BookedInstantAppointmentSlot.class) || Serializable.class.isAssignableFrom(BookedInstantAppointmentSlot.class)) {
        exploreInstantModelResponseObj = (BookedInstantAppointmentSlot) bundle.get("exploreInstantModelResponseObj");
      } else {
        throw new UnsupportedOperationException(BookedInstantAppointmentSlot.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("exploreInstantModelResponseObj", exploreInstantModelResponseObj);
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
    if (bundle.containsKey("time")) {
      String time;
      time = bundle.getString("time");
      __result.arguments.put("time", time);
    }
    if (bundle.containsKey("isFromReschedule")) {
      boolean isFromReschedule;
      isFromReschedule = bundle.getBoolean("isFromReschedule");
      __result.arguments.put("isFromReschedule", isFromReschedule);
    }
    if (bundle.containsKey("cardId")) {
      String cardId;
      cardId = bundle.getString("cardId");
      __result.arguments.put("cardId", cardId);
    }
    if (bundle.containsKey("startTime")) {
      String startTime;
      startTime = bundle.getString("startTime");
      __result.arguments.put("startTime", startTime);
    }
    if (bundle.containsKey("endTime")) {
      String endTime;
      endTime = bundle.getString("endTime");
      __result.arguments.put("endTime", endTime);
    }
    if (bundle.containsKey("paymentMethodType")) {
      String paymentMethodType;
      paymentMethodType = bundle.getString("paymentMethodType");
      __result.arguments.put("paymentMethodType", paymentMethodType);
    }
    if (bundle.containsKey("bookByUser")) {
      String bookByUser;
      bookByUser = bundle.getString("bookByUser");
      __result.arguments.put("bookByUser", bookByUser);
    }
    if (bundle.containsKey("pateintId")) {
      String pateintId;
      pateintId = bundle.getString("pateintId");
      __result.arguments.put("pateintId", pateintId);
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
  public String getDoctorId() {
    return (String) arguments.get("doctorId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getType() {
    return (String) arguments.get("type");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getMedicalPracticeName() {
    return (String) arguments.get("medicalPracticeName");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getMedicalPracticeId() {
    return (String) arguments.get("medicalPracticeId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getInstantDoctor() {
    return (String) arguments.get("instantDoctor");
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
  public String getDependentId() {
    return (String) arguments.get("dependentId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public EliteDoctorSuccess getExploreDoctorSuccessResponseObj() {
    return (EliteDoctorSuccess) arguments.get("exploreDoctorSuccessResponseObj");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public BookedInstantAppointmentSlot getExploreInstantModelResponseObj() {
    return (BookedInstantAppointmentSlot) arguments.get("exploreInstantModelResponseObj");
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
  public String getTime() {
    return (String) arguments.get("time");
  }

  @SuppressWarnings("unchecked")
  public boolean getIsFromReschedule() {
    return (boolean) arguments.get("isFromReschedule");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getCardId() {
    return (String) arguments.get("cardId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getStartTime() {
    return (String) arguments.get("startTime");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getEndTime() {
    return (String) arguments.get("endTime");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPaymentMethodType() {
    return (String) arguments.get("paymentMethodType");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getBookByUser() {
    return (String) arguments.get("bookByUser");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPateintId() {
    return (String) arguments.get("pateintId");
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
    if (arguments.containsKey("doctorId")) {
      String doctorId = (String) arguments.get("doctorId");
      __result.putString("doctorId", doctorId);
    }
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.putString("type", type);
    }
    if (arguments.containsKey("medicalPracticeName")) {
      String medicalPracticeName = (String) arguments.get("medicalPracticeName");
      __result.putString("medicalPracticeName", medicalPracticeName);
    }
    if (arguments.containsKey("medicalPracticeId")) {
      String medicalPracticeId = (String) arguments.get("medicalPracticeId");
      __result.putString("medicalPracticeId", medicalPracticeId);
    }
    if (arguments.containsKey("instantDoctor")) {
      String instantDoctor = (String) arguments.get("instantDoctor");
      __result.putString("instantDoctor", instantDoctor);
    }
    if (arguments.containsKey("appointmentType")) {
      String appointmentType = (String) arguments.get("appointmentType");
      __result.putString("appointmentType", appointmentType);
    }
    if (arguments.containsKey("doctorDetailId")) {
      String doctorDetailId = (String) arguments.get("doctorDetailId");
      __result.putString("doctorDetailId", doctorDetailId);
    }
    if (arguments.containsKey("dependentId")) {
      String dependentId = (String) arguments.get("dependentId");
      __result.putString("dependentId", dependentId);
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
    if (arguments.containsKey("exploreInstantModelResponseObj")) {
      BookedInstantAppointmentSlot exploreInstantModelResponseObj = (BookedInstantAppointmentSlot) arguments.get("exploreInstantModelResponseObj");
      if (Parcelable.class.isAssignableFrom(BookedInstantAppointmentSlot.class) || exploreInstantModelResponseObj == null) {
        __result.putParcelable("exploreInstantModelResponseObj", Parcelable.class.cast(exploreInstantModelResponseObj));
      } else if (Serializable.class.isAssignableFrom(BookedInstantAppointmentSlot.class)) {
        __result.putSerializable("exploreInstantModelResponseObj", Serializable.class.cast(exploreInstantModelResponseObj));
      } else {
        throw new UnsupportedOperationException(BookedInstantAppointmentSlot.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    if (arguments.containsKey("time")) {
      String time = (String) arguments.get("time");
      __result.putString("time", time);
    }
    if (arguments.containsKey("isFromReschedule")) {
      boolean isFromReschedule = (boolean) arguments.get("isFromReschedule");
      __result.putBoolean("isFromReschedule", isFromReschedule);
    }
    if (arguments.containsKey("cardId")) {
      String cardId = (String) arguments.get("cardId");
      __result.putString("cardId", cardId);
    }
    if (arguments.containsKey("startTime")) {
      String startTime = (String) arguments.get("startTime");
      __result.putString("startTime", startTime);
    }
    if (arguments.containsKey("endTime")) {
      String endTime = (String) arguments.get("endTime");
      __result.putString("endTime", endTime);
    }
    if (arguments.containsKey("paymentMethodType")) {
      String paymentMethodType = (String) arguments.get("paymentMethodType");
      __result.putString("paymentMethodType", paymentMethodType);
    }
    if (arguments.containsKey("bookByUser")) {
      String bookByUser = (String) arguments.get("bookByUser");
      __result.putString("bookByUser", bookByUser);
    }
    if (arguments.containsKey("pateintId")) {
      String pateintId = (String) arguments.get("pateintId");
      __result.putString("pateintId", pateintId);
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
    BookAppointmentFragmentArgs that = (BookAppointmentFragmentArgs) object;
    if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
      return false;
    }
    if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
      return false;
    }
    if (arguments.containsKey("doctorId") != that.arguments.containsKey("doctorId")) {
      return false;
    }
    if (getDoctorId() != null ? !getDoctorId().equals(that.getDoctorId()) : that.getDoctorId() != null) {
      return false;
    }
    if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
      return false;
    }
    if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
      return false;
    }
    if (arguments.containsKey("medicalPracticeName") != that.arguments.containsKey("medicalPracticeName")) {
      return false;
    }
    if (getMedicalPracticeName() != null ? !getMedicalPracticeName().equals(that.getMedicalPracticeName()) : that.getMedicalPracticeName() != null) {
      return false;
    }
    if (arguments.containsKey("medicalPracticeId") != that.arguments.containsKey("medicalPracticeId")) {
      return false;
    }
    if (getMedicalPracticeId() != null ? !getMedicalPracticeId().equals(that.getMedicalPracticeId()) : that.getMedicalPracticeId() != null) {
      return false;
    }
    if (arguments.containsKey("instantDoctor") != that.arguments.containsKey("instantDoctor")) {
      return false;
    }
    if (getInstantDoctor() != null ? !getInstantDoctor().equals(that.getInstantDoctor()) : that.getInstantDoctor() != null) {
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
    if (arguments.containsKey("dependentId") != that.arguments.containsKey("dependentId")) {
      return false;
    }
    if (getDependentId() != null ? !getDependentId().equals(that.getDependentId()) : that.getDependentId() != null) {
      return false;
    }
    if (arguments.containsKey("exploreDoctorSuccessResponseObj") != that.arguments.containsKey("exploreDoctorSuccessResponseObj")) {
      return false;
    }
    if (getExploreDoctorSuccessResponseObj() != null ? !getExploreDoctorSuccessResponseObj().equals(that.getExploreDoctorSuccessResponseObj()) : that.getExploreDoctorSuccessResponseObj() != null) {
      return false;
    }
    if (arguments.containsKey("exploreInstantModelResponseObj") != that.arguments.containsKey("exploreInstantModelResponseObj")) {
      return false;
    }
    if (getExploreInstantModelResponseObj() != null ? !getExploreInstantModelResponseObj().equals(that.getExploreInstantModelResponseObj()) : that.getExploreInstantModelResponseObj() != null) {
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
    if (arguments.containsKey("time") != that.arguments.containsKey("time")) {
      return false;
    }
    if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) {
      return false;
    }
    if (arguments.containsKey("isFromReschedule") != that.arguments.containsKey("isFromReschedule")) {
      return false;
    }
    if (getIsFromReschedule() != that.getIsFromReschedule()) {
      return false;
    }
    if (arguments.containsKey("cardId") != that.arguments.containsKey("cardId")) {
      return false;
    }
    if (getCardId() != null ? !getCardId().equals(that.getCardId()) : that.getCardId() != null) {
      return false;
    }
    if (arguments.containsKey("startTime") != that.arguments.containsKey("startTime")) {
      return false;
    }
    if (getStartTime() != null ? !getStartTime().equals(that.getStartTime()) : that.getStartTime() != null) {
      return false;
    }
    if (arguments.containsKey("endTime") != that.arguments.containsKey("endTime")) {
      return false;
    }
    if (getEndTime() != null ? !getEndTime().equals(that.getEndTime()) : that.getEndTime() != null) {
      return false;
    }
    if (arguments.containsKey("paymentMethodType") != that.arguments.containsKey("paymentMethodType")) {
      return false;
    }
    if (getPaymentMethodType() != null ? !getPaymentMethodType().equals(that.getPaymentMethodType()) : that.getPaymentMethodType() != null) {
      return false;
    }
    if (arguments.containsKey("bookByUser") != that.arguments.containsKey("bookByUser")) {
      return false;
    }
    if (getBookByUser() != null ? !getBookByUser().equals(that.getBookByUser()) : that.getBookByUser() != null) {
      return false;
    }
    if (arguments.containsKey("pateintId") != that.arguments.containsKey("pateintId")) {
      return false;
    }
    if (getPateintId() != null ? !getPateintId().equals(that.getPateintId()) : that.getPateintId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
    result = 31 * result + (getDoctorId() != null ? getDoctorId().hashCode() : 0);
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    result = 31 * result + (getMedicalPracticeName() != null ? getMedicalPracticeName().hashCode() : 0);
    result = 31 * result + (getMedicalPracticeId() != null ? getMedicalPracticeId().hashCode() : 0);
    result = 31 * result + (getInstantDoctor() != null ? getInstantDoctor().hashCode() : 0);
    result = 31 * result + (getAppointmentType() != null ? getAppointmentType().hashCode() : 0);
    result = 31 * result + (getDoctorDetailId() != null ? getDoctorDetailId().hashCode() : 0);
    result = 31 * result + (getDependentId() != null ? getDependentId().hashCode() : 0);
    result = 31 * result + (getExploreDoctorSuccessResponseObj() != null ? getExploreDoctorSuccessResponseObj().hashCode() : 0);
    result = 31 * result + (getExploreInstantModelResponseObj() != null ? getExploreInstantModelResponseObj().hashCode() : 0);
    result = 31 * result + (getPateintName() != null ? getPateintName().hashCode() : 0);
    result = 31 * result + (getSelectedDate() != null ? getSelectedDate().hashCode() : 0);
    result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
    result = 31 * result + (getIsFromReschedule() ? 1 : 0);
    result = 31 * result + (getCardId() != null ? getCardId().hashCode() : 0);
    result = 31 * result + (getStartTime() != null ? getStartTime().hashCode() : 0);
    result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
    result = 31 * result + (getPaymentMethodType() != null ? getPaymentMethodType().hashCode() : 0);
    result = 31 * result + (getBookByUser() != null ? getBookByUser().hashCode() : 0);
    result = 31 * result + (getPateintId() != null ? getPateintId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "BookAppointmentFragmentArgs{"
        + "doctor=" + getDoctor()
        + ", doctorId=" + getDoctorId()
        + ", type=" + getType()
        + ", medicalPracticeName=" + getMedicalPracticeName()
        + ", medicalPracticeId=" + getMedicalPracticeId()
        + ", instantDoctor=" + getInstantDoctor()
        + ", appointmentType=" + getAppointmentType()
        + ", doctorDetailId=" + getDoctorDetailId()
        + ", dependentId=" + getDependentId()
        + ", exploreDoctorSuccessResponseObj=" + getExploreDoctorSuccessResponseObj()
        + ", exploreInstantModelResponseObj=" + getExploreInstantModelResponseObj()
        + ", pateintName=" + getPateintName()
        + ", selectedDate=" + getSelectedDate()
        + ", time=" + getTime()
        + ", isFromReschedule=" + getIsFromReschedule()
        + ", cardId=" + getCardId()
        + ", startTime=" + getStartTime()
        + ", endTime=" + getEndTime()
        + ", paymentMethodType=" + getPaymentMethodType()
        + ", bookByUser=" + getBookByUser()
        + ", pateintId=" + getPateintId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(BookAppointmentFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public BookAppointmentFragmentArgs build() {
      BookAppointmentFragmentArgs result = new BookAppointmentFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctor(@Nullable DoctorInfoLimited doctor) {
      this.arguments.put("doctor", doctor);
      return this;
    }

    @NonNull
    public Builder setDoctorId(@Nullable String doctorId) {
      this.arguments.put("doctorId", doctorId);
      return this;
    }

    @NonNull
    public Builder setType(@Nullable String type) {
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    public Builder setMedicalPracticeName(@Nullable String medicalPracticeName) {
      this.arguments.put("medicalPracticeName", medicalPracticeName);
      return this;
    }

    @NonNull
    public Builder setMedicalPracticeId(@Nullable String medicalPracticeId) {
      this.arguments.put("medicalPracticeId", medicalPracticeId);
      return this;
    }

    @NonNull
    public Builder setInstantDoctor(@NonNull String instantDoctor) {
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("instantDoctor", instantDoctor);
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
    public Builder setDependentId(@Nullable String dependentId) {
      this.arguments.put("dependentId", dependentId);
      return this;
    }

    @NonNull
    public Builder setExploreDoctorSuccessResponseObj(@Nullable EliteDoctorSuccess exploreDoctorSuccessResponseObj) {
      this.arguments.put("exploreDoctorSuccessResponseObj", exploreDoctorSuccessResponseObj);
      return this;
    }

    @NonNull
    public Builder setExploreInstantModelResponseObj(@Nullable BookedInstantAppointmentSlot exploreInstantModelResponseObj) {
      this.arguments.put("exploreInstantModelResponseObj", exploreInstantModelResponseObj);
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
    public Builder setTime(@Nullable String time) {
      this.arguments.put("time", time);
      return this;
    }

    @NonNull
    public Builder setIsFromReschedule(boolean isFromReschedule) {
      this.arguments.put("isFromReschedule", isFromReschedule);
      return this;
    }

    @NonNull
    public Builder setCardId(@Nullable String cardId) {
      this.arguments.put("cardId", cardId);
      return this;
    }

    @NonNull
    public Builder setStartTime(@Nullable String startTime) {
      this.arguments.put("startTime", startTime);
      return this;
    }

    @NonNull
    public Builder setEndTime(@Nullable String endTime) {
      this.arguments.put("endTime", endTime);
      return this;
    }

    @NonNull
    public Builder setPaymentMethodType(@Nullable String paymentMethodType) {
      this.arguments.put("paymentMethodType", paymentMethodType);
      return this;
    }

    @NonNull
    public Builder setBookByUser(@Nullable String bookByUser) {
      this.arguments.put("bookByUser", bookByUser);
      return this;
    }

    @NonNull
    public Builder setPateintId(@Nullable String pateintId) {
      this.arguments.put("pateintId", pateintId);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public DoctorInfoLimited getDoctor() {
      return (DoctorInfoLimited) arguments.get("doctor");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDoctorId() {
      return (String) arguments.get("doctorId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getType() {
      return (String) arguments.get("type");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getMedicalPracticeName() {
      return (String) arguments.get("medicalPracticeName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getMedicalPracticeId() {
      return (String) arguments.get("medicalPracticeId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getInstantDoctor() {
      return (String) arguments.get("instantDoctor");
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
    public String getDependentId() {
      return (String) arguments.get("dependentId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public EliteDoctorSuccess getExploreDoctorSuccessResponseObj() {
      return (EliteDoctorSuccess) arguments.get("exploreDoctorSuccessResponseObj");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public BookedInstantAppointmentSlot getExploreInstantModelResponseObj() {
      return (BookedInstantAppointmentSlot) arguments.get("exploreInstantModelResponseObj");
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
    public String getTime() {
      return (String) arguments.get("time");
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromReschedule() {
      return (boolean) arguments.get("isFromReschedule");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCardId() {
      return (String) arguments.get("cardId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getStartTime() {
      return (String) arguments.get("startTime");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEndTime() {
      return (String) arguments.get("endTime");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPaymentMethodType() {
      return (String) arguments.get("paymentMethodType");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getBookByUser() {
      return (String) arguments.get("bookByUser");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPateintId() {
      return (String) arguments.get("pateintId");
    }
  }
}
