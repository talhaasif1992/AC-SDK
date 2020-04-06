package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.Slot;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class instantAppointmentReachedBFArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private instantAppointmentReachedBFArgs() {
  }

  private instantAppointmentReachedBFArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static instantAppointmentReachedBFArgs fromBundle(@NonNull Bundle bundle) {
    instantAppointmentReachedBFArgs __result = new instantAppointmentReachedBFArgs();
    bundle.setClassLoader(instantAppointmentReachedBFArgs.class.getClassLoader());
    if (bundle.containsKey("doctorAvailableTime")) {
      String doctorAvailableTime;
      doctorAvailableTime = bundle.getString("doctorAvailableTime");
      if (doctorAvailableTime == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableTime\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorAvailableTime", doctorAvailableTime);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorAvailableTime\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("doctorAvailableDate")) {
      String doctorAvailableDate;
      doctorAvailableDate = bundle.getString("doctorAvailableDate");
      if (doctorAvailableDate == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableDate\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorAvailableDate", doctorAvailableDate);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorAvailableDate\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("bookedDoctorSlot")) {
      Slot bookedDoctorSlot;
      if (Parcelable.class.isAssignableFrom(Slot.class) || Serializable.class.isAssignableFrom(Slot.class)) {
        bookedDoctorSlot = (Slot) bundle.get("bookedDoctorSlot");
      } else {
        throw new UnsupportedOperationException(Slot.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("bookedDoctorSlot", bookedDoctorSlot);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorAvailableTime() {
    return (String) arguments.get("doctorAvailableTime");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorAvailableDate() {
    return (String) arguments.get("doctorAvailableDate");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Slot getBookedDoctorSlot() {
    return (Slot) arguments.get("bookedDoctorSlot");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("doctorAvailableTime")) {
      String doctorAvailableTime = (String) arguments.get("doctorAvailableTime");
      __result.putString("doctorAvailableTime", doctorAvailableTime);
    }
    if (arguments.containsKey("doctorAvailableDate")) {
      String doctorAvailableDate = (String) arguments.get("doctorAvailableDate");
      __result.putString("doctorAvailableDate", doctorAvailableDate);
    }
    if (arguments.containsKey("bookedDoctorSlot")) {
      Slot bookedDoctorSlot = (Slot) arguments.get("bookedDoctorSlot");
      if (Parcelable.class.isAssignableFrom(Slot.class) || bookedDoctorSlot == null) {
        __result.putParcelable("bookedDoctorSlot", Parcelable.class.cast(bookedDoctorSlot));
      } else if (Serializable.class.isAssignableFrom(Slot.class)) {
        __result.putSerializable("bookedDoctorSlot", Serializable.class.cast(bookedDoctorSlot));
      } else {
        throw new UnsupportedOperationException(Slot.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
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
    instantAppointmentReachedBFArgs that = (instantAppointmentReachedBFArgs) object;
    if (arguments.containsKey("doctorAvailableTime") != that.arguments.containsKey("doctorAvailableTime")) {
      return false;
    }
    if (getDoctorAvailableTime() != null ? !getDoctorAvailableTime().equals(that.getDoctorAvailableTime()) : that.getDoctorAvailableTime() != null) {
      return false;
    }
    if (arguments.containsKey("doctorAvailableDate") != that.arguments.containsKey("doctorAvailableDate")) {
      return false;
    }
    if (getDoctorAvailableDate() != null ? !getDoctorAvailableDate().equals(that.getDoctorAvailableDate()) : that.getDoctorAvailableDate() != null) {
      return false;
    }
    if (arguments.containsKey("bookedDoctorSlot") != that.arguments.containsKey("bookedDoctorSlot")) {
      return false;
    }
    if (getBookedDoctorSlot() != null ? !getBookedDoctorSlot().equals(that.getBookedDoctorSlot()) : that.getBookedDoctorSlot() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctorAvailableTime() != null ? getDoctorAvailableTime().hashCode() : 0);
    result = 31 * result + (getDoctorAvailableDate() != null ? getDoctorAvailableDate().hashCode() : 0);
    result = 31 * result + (getBookedDoctorSlot() != null ? getBookedDoctorSlot().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "instantAppointmentReachedBFArgs{"
        + "doctorAvailableTime=" + getDoctorAvailableTime()
        + ", doctorAvailableDate=" + getDoctorAvailableDate()
        + ", bookedDoctorSlot=" + getBookedDoctorSlot()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(instantAppointmentReachedBFArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String doctorAvailableTime, @NonNull String doctorAvailableDate) {
      if (doctorAvailableTime == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorAvailableTime", doctorAvailableTime);
      if (doctorAvailableDate == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableDate\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorAvailableDate", doctorAvailableDate);
    }

    @NonNull
    public instantAppointmentReachedBFArgs build() {
      instantAppointmentReachedBFArgs result = new instantAppointmentReachedBFArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctorAvailableTime(@NonNull String doctorAvailableTime) {
      if (doctorAvailableTime == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorAvailableTime", doctorAvailableTime);
      return this;
    }

    @NonNull
    public Builder setDoctorAvailableDate(@NonNull String doctorAvailableDate) {
      if (doctorAvailableDate == null) {
        throw new IllegalArgumentException("Argument \"doctorAvailableDate\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorAvailableDate", doctorAvailableDate);
      return this;
    }

    @NonNull
    public Builder setBookedDoctorSlot(@Nullable Slot bookedDoctorSlot) {
      this.arguments.put("bookedDoctorSlot", bookedDoctorSlot);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorAvailableTime() {
      return (String) arguments.get("doctorAvailableTime");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorAvailableDate() {
      return (String) arguments.get("doctorAvailableDate");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Slot getBookedDoctorSlot() {
      return (Slot) arguments.get("bookedDoctorSlot");
    }
  }
}
