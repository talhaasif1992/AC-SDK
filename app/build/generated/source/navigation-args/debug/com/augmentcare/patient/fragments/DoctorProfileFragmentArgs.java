package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorProfileFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private DoctorProfileFragmentArgs() {
  }

  private DoctorProfileFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static DoctorProfileFragmentArgs fromBundle(@NonNull Bundle bundle) {
    DoctorProfileFragmentArgs __result = new DoctorProfileFragmentArgs();
    bundle.setClassLoader(DoctorProfileFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("doctorID")) {
      String doctorID;
      doctorID = bundle.getString("doctorID");
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorID", doctorID);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorID\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("show_book_appointment_btn")) {
      boolean showBookAppointmentBtn;
      showBookAppointmentBtn = bundle.getBoolean("show_book_appointment_btn");
      __result.arguments.put("show_book_appointment_btn", showBookAppointmentBtn);
    }
    if (bundle.containsKey("doctor")) {
      DoctorInfoLimited doctor;
      if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
        doctor = (DoctorInfoLimited) bundle.get("doctor");
      } else {
        throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("doctor", doctor);
    }
    if (bundle.containsKey("instantDoctor")) {
      String instantDoctor;
      instantDoctor = bundle.getString("instantDoctor");
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("instantDoctor", instantDoctor);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorID() {
    return (String) arguments.get("doctorID");
  }

  @SuppressWarnings("unchecked")
  public boolean getShowBookAppointmentBtn() {
    return (boolean) arguments.get("show_book_appointment_btn");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public DoctorInfoLimited getDoctor() {
    return (DoctorInfoLimited) arguments.get("doctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getInstantDoctor() {
    return (String) arguments.get("instantDoctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("doctorID")) {
      String doctorID = (String) arguments.get("doctorID");
      __result.putString("doctorID", doctorID);
    }
    if (arguments.containsKey("show_book_appointment_btn")) {
      boolean showBookAppointmentBtn = (boolean) arguments.get("show_book_appointment_btn");
      __result.putBoolean("show_book_appointment_btn", showBookAppointmentBtn);
    }
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
    DoctorProfileFragmentArgs that = (DoctorProfileFragmentArgs) object;
    if (arguments.containsKey("doctorID") != that.arguments.containsKey("doctorID")) {
      return false;
    }
    if (getDoctorID() != null ? !getDoctorID().equals(that.getDoctorID()) : that.getDoctorID() != null) {
      return false;
    }
    if (arguments.containsKey("show_book_appointment_btn") != that.arguments.containsKey("show_book_appointment_btn")) {
      return false;
    }
    if (getShowBookAppointmentBtn() != that.getShowBookAppointmentBtn()) {
      return false;
    }
    if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
      return false;
    }
    if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
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
    result = 31 * result + (getDoctorID() != null ? getDoctorID().hashCode() : 0);
    result = 31 * result + (getShowBookAppointmentBtn() ? 1 : 0);
    result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
    result = 31 * result + (getInstantDoctor() != null ? getInstantDoctor().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DoctorProfileFragmentArgs{"
        + "doctorID=" + getDoctorID()
        + ", showBookAppointmentBtn=" + getShowBookAppointmentBtn()
        + ", doctor=" + getDoctor()
        + ", instantDoctor=" + getInstantDoctor()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(DoctorProfileFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
    }

    @NonNull
    public DoctorProfileFragmentArgs build() {
      DoctorProfileFragmentArgs result = new DoctorProfileFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctorID(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public Builder setShowBookAppointmentBtn(boolean showBookAppointmentBtn) {
      this.arguments.put("show_book_appointment_btn", showBookAppointmentBtn);
      return this;
    }

    @NonNull
    public Builder setDoctor(@Nullable DoctorInfoLimited doctor) {
      this.arguments.put("doctor", doctor);
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

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorID() {
      return (String) arguments.get("doctorID");
    }

    @SuppressWarnings("unchecked")
    public boolean getShowBookAppointmentBtn() {
      return (boolean) arguments.get("show_book_appointment_btn");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public DoctorInfoLimited getDoctor() {
      return (DoctorInfoLimited) arguments.get("doctor");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getInstantDoctor() {
      return (String) arguments.get("instantDoctor");
    }
  }
}
