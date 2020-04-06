package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AppointmentTypesBottomSheetArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private AppointmentTypesBottomSheetArgs() {
  }

  private AppointmentTypesBottomSheetArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static AppointmentTypesBottomSheetArgs fromBundle(@NonNull Bundle bundle) {
    AppointmentTypesBottomSheetArgs __result = new AppointmentTypesBottomSheetArgs();
    bundle.setClassLoader(AppointmentTypesBottomSheetArgs.class.getClassLoader());
    if (bundle.containsKey("doctor")) {
      DoctorInfoLimited doctor;
      if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
        doctor = (DoctorInfoLimited) bundle.get("doctor");
      } else {
        throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctor", doctor);
    } else {
      throw new IllegalArgumentException("Required argument \"doctor\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("doctorId")) {
      String doctorId;
      doctorId = bundle.getString("doctorId");
      if (doctorId == null) {
        throw new IllegalArgumentException("Argument \"doctorId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorId", doctorId);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("instantDoctor")) {
      String instantDoctor;
      instantDoctor = bundle.getString("instantDoctor");
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("instantDoctor", instantDoctor);
    } else {
      throw new IllegalArgumentException("Required argument \"instantDoctor\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("doctorDetail")) {
      DoctorDetail doctorDetail;
      if (Parcelable.class.isAssignableFrom(DoctorDetail.class) || Serializable.class.isAssignableFrom(DoctorDetail.class)) {
        doctorDetail = (DoctorDetail) bundle.get("doctorDetail");
      } else {
        throw new UnsupportedOperationException(DoctorDetail.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (doctorDetail == null) {
        throw new IllegalArgumentException("Argument \"doctorDetail\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorDetail", doctorDetail);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorDetail\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("onlineButtonFlag")) {
      boolean onlineButtonFlag;
      onlineButtonFlag = bundle.getBoolean("onlineButtonFlag");
      __result.arguments.put("onlineButtonFlag", onlineButtonFlag);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public DoctorInfoLimited getDoctor() {
    return (DoctorInfoLimited) arguments.get("doctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorId() {
    return (String) arguments.get("doctorId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getInstantDoctor() {
    return (String) arguments.get("instantDoctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public DoctorDetail getDoctorDetail() {
    return (DoctorDetail) arguments.get("doctorDetail");
  }

  @SuppressWarnings("unchecked")
  public boolean getOnlineButtonFlag() {
    return (boolean) arguments.get("onlineButtonFlag");
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
    if (arguments.containsKey("instantDoctor")) {
      String instantDoctor = (String) arguments.get("instantDoctor");
      __result.putString("instantDoctor", instantDoctor);
    }
    if (arguments.containsKey("doctorDetail")) {
      DoctorDetail doctorDetail = (DoctorDetail) arguments.get("doctorDetail");
      if (Parcelable.class.isAssignableFrom(DoctorDetail.class) || doctorDetail == null) {
        __result.putParcelable("doctorDetail", Parcelable.class.cast(doctorDetail));
      } else if (Serializable.class.isAssignableFrom(DoctorDetail.class)) {
        __result.putSerializable("doctorDetail", Serializable.class.cast(doctorDetail));
      } else {
        throw new UnsupportedOperationException(DoctorDetail.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    if (arguments.containsKey("onlineButtonFlag")) {
      boolean onlineButtonFlag = (boolean) arguments.get("onlineButtonFlag");
      __result.putBoolean("onlineButtonFlag", onlineButtonFlag);
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
    AppointmentTypesBottomSheetArgs that = (AppointmentTypesBottomSheetArgs) object;
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
    if (arguments.containsKey("instantDoctor") != that.arguments.containsKey("instantDoctor")) {
      return false;
    }
    if (getInstantDoctor() != null ? !getInstantDoctor().equals(that.getInstantDoctor()) : that.getInstantDoctor() != null) {
      return false;
    }
    if (arguments.containsKey("doctorDetail") != that.arguments.containsKey("doctorDetail")) {
      return false;
    }
    if (getDoctorDetail() != null ? !getDoctorDetail().equals(that.getDoctorDetail()) : that.getDoctorDetail() != null) {
      return false;
    }
    if (arguments.containsKey("onlineButtonFlag") != that.arguments.containsKey("onlineButtonFlag")) {
      return false;
    }
    if (getOnlineButtonFlag() != that.getOnlineButtonFlag()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
    result = 31 * result + (getDoctorId() != null ? getDoctorId().hashCode() : 0);
    result = 31 * result + (getInstantDoctor() != null ? getInstantDoctor().hashCode() : 0);
    result = 31 * result + (getDoctorDetail() != null ? getDoctorDetail().hashCode() : 0);
    result = 31 * result + (getOnlineButtonFlag() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AppointmentTypesBottomSheetArgs{"
        + "doctor=" + getDoctor()
        + ", doctorId=" + getDoctorId()
        + ", instantDoctor=" + getInstantDoctor()
        + ", doctorDetail=" + getDoctorDetail()
        + ", onlineButtonFlag=" + getOnlineButtonFlag()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(AppointmentTypesBottomSheetArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull DoctorInfoLimited doctor, @NonNull String doctorId,
        @NonNull String instantDoctor, @NonNull DoctorDetail doctorDetail) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      if (doctorId == null) {
        throw new IllegalArgumentException("Argument \"doctorId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorId", doctorId);
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("instantDoctor", instantDoctor);
      if (doctorDetail == null) {
        throw new IllegalArgumentException("Argument \"doctorDetail\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorDetail", doctorDetail);
    }

    @NonNull
    public AppointmentTypesBottomSheetArgs build() {
      AppointmentTypesBottomSheetArgs result = new AppointmentTypesBottomSheetArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctor(@NonNull DoctorInfoLimited doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      return this;
    }

    @NonNull
    public Builder setDoctorId(@NonNull String doctorId) {
      if (doctorId == null) {
        throw new IllegalArgumentException("Argument \"doctorId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorId", doctorId);
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
    public Builder setDoctorDetail(@NonNull DoctorDetail doctorDetail) {
      if (doctorDetail == null) {
        throw new IllegalArgumentException("Argument \"doctorDetail\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorDetail", doctorDetail);
      return this;
    }

    @NonNull
    public Builder setOnlineButtonFlag(boolean onlineButtonFlag) {
      this.arguments.put("onlineButtonFlag", onlineButtonFlag);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public DoctorInfoLimited getDoctor() {
      return (DoctorInfoLimited) arguments.get("doctor");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorId() {
      return (String) arguments.get("doctorId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getInstantDoctor() {
      return (String) arguments.get("instantDoctor");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public DoctorDetail getDoctorDetail() {
      return (DoctorDetail) arguments.get("doctorDetail");
    }

    @SuppressWarnings("unchecked")
    public boolean getOnlineButtonFlag() {
      return (boolean) arguments.get("onlineButtonFlag");
    }
  }
}
