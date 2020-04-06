package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorRatingDialogFragArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private DoctorRatingDialogFragArgs() {
  }

  private DoctorRatingDialogFragArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static DoctorRatingDialogFragArgs fromBundle(@NonNull Bundle bundle) {
    DoctorRatingDialogFragArgs __result = new DoctorRatingDialogFragArgs();
    bundle.setClassLoader(DoctorRatingDialogFragArgs.class.getClassLoader());
    if (bundle.containsKey("appointmentDateTime")) {
      String appointmentDateTime;
      appointmentDateTime = bundle.getString("appointmentDateTime");
      if (appointmentDateTime == null) {
        throw new IllegalArgumentException("Argument \"appointmentDateTime\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("appointmentDateTime", appointmentDateTime);
    } else {
      throw new IllegalArgumentException("Required argument \"appointmentDateTime\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("slotID")) {
      String slotID;
      slotID = bundle.getString("slotID");
      if (slotID == null) {
        throw new IllegalArgumentException("Argument \"slotID\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("slotID", slotID);
    } else {
      throw new IllegalArgumentException("Required argument \"slotID\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("doctorName")) {
      String doctorName;
      doctorName = bundle.getString("doctorName");
      if (doctorName == null) {
        throw new IllegalArgumentException("Argument \"doctorName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorName", doctorName);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorName\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("doctorPic")) {
      String doctorPic;
      doctorPic = bundle.getString("doctorPic");
      if (doctorPic == null) {
        throw new IllegalArgumentException("Argument \"doctorPic\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctorPic", doctorPic);
    } else {
      throw new IllegalArgumentException("Required argument \"doctorPic\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getAppointmentDateTime() {
    return (String) arguments.get("appointmentDateTime");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getSlotID() {
    return (String) arguments.get("slotID");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorName() {
    return (String) arguments.get("doctorName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getDoctorPic() {
    return (String) arguments.get("doctorPic");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("appointmentDateTime")) {
      String appointmentDateTime = (String) arguments.get("appointmentDateTime");
      __result.putString("appointmentDateTime", appointmentDateTime);
    }
    if (arguments.containsKey("slotID")) {
      String slotID = (String) arguments.get("slotID");
      __result.putString("slotID", slotID);
    }
    if (arguments.containsKey("doctorName")) {
      String doctorName = (String) arguments.get("doctorName");
      __result.putString("doctorName", doctorName);
    }
    if (arguments.containsKey("doctorPic")) {
      String doctorPic = (String) arguments.get("doctorPic");
      __result.putString("doctorPic", doctorPic);
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
    DoctorRatingDialogFragArgs that = (DoctorRatingDialogFragArgs) object;
    if (arguments.containsKey("appointmentDateTime") != that.arguments.containsKey("appointmentDateTime")) {
      return false;
    }
    if (getAppointmentDateTime() != null ? !getAppointmentDateTime().equals(that.getAppointmentDateTime()) : that.getAppointmentDateTime() != null) {
      return false;
    }
    if (arguments.containsKey("slotID") != that.arguments.containsKey("slotID")) {
      return false;
    }
    if (getSlotID() != null ? !getSlotID().equals(that.getSlotID()) : that.getSlotID() != null) {
      return false;
    }
    if (arguments.containsKey("doctorName") != that.arguments.containsKey("doctorName")) {
      return false;
    }
    if (getDoctorName() != null ? !getDoctorName().equals(that.getDoctorName()) : that.getDoctorName() != null) {
      return false;
    }
    if (arguments.containsKey("doctorPic") != that.arguments.containsKey("doctorPic")) {
      return false;
    }
    if (getDoctorPic() != null ? !getDoctorPic().equals(that.getDoctorPic()) : that.getDoctorPic() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getAppointmentDateTime() != null ? getAppointmentDateTime().hashCode() : 0);
    result = 31 * result + (getSlotID() != null ? getSlotID().hashCode() : 0);
    result = 31 * result + (getDoctorName() != null ? getDoctorName().hashCode() : 0);
    result = 31 * result + (getDoctorPic() != null ? getDoctorPic().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DoctorRatingDialogFragArgs{"
        + "appointmentDateTime=" + getAppointmentDateTime()
        + ", slotID=" + getSlotID()
        + ", doctorName=" + getDoctorName()
        + ", doctorPic=" + getDoctorPic()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(DoctorRatingDialogFragArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String appointmentDateTime, @NonNull String slotID,
        @NonNull String doctorName, @NonNull String doctorPic) {
      if (appointmentDateTime == null) {
        throw new IllegalArgumentException("Argument \"appointmentDateTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("appointmentDateTime", appointmentDateTime);
      if (slotID == null) {
        throw new IllegalArgumentException("Argument \"slotID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("slotID", slotID);
      if (doctorName == null) {
        throw new IllegalArgumentException("Argument \"doctorName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorName", doctorName);
      if (doctorPic == null) {
        throw new IllegalArgumentException("Argument \"doctorPic\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorPic", doctorPic);
    }

    @NonNull
    public DoctorRatingDialogFragArgs build() {
      DoctorRatingDialogFragArgs result = new DoctorRatingDialogFragArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setAppointmentDateTime(@NonNull String appointmentDateTime) {
      if (appointmentDateTime == null) {
        throw new IllegalArgumentException("Argument \"appointmentDateTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("appointmentDateTime", appointmentDateTime);
      return this;
    }

    @NonNull
    public Builder setSlotID(@NonNull String slotID) {
      if (slotID == null) {
        throw new IllegalArgumentException("Argument \"slotID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("slotID", slotID);
      return this;
    }

    @NonNull
    public Builder setDoctorName(@NonNull String doctorName) {
      if (doctorName == null) {
        throw new IllegalArgumentException("Argument \"doctorName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorName", doctorName);
      return this;
    }

    @NonNull
    public Builder setDoctorPic(@NonNull String doctorPic) {
      if (doctorPic == null) {
        throw new IllegalArgumentException("Argument \"doctorPic\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorPic", doctorPic);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getAppointmentDateTime() {
      return (String) arguments.get("appointmentDateTime");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getSlotID() {
      return (String) arguments.get("slotID");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorName() {
      return (String) arguments.get("doctorName");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorPic() {
      return (String) arguments.get("doctorPic");
    }
  }
}
