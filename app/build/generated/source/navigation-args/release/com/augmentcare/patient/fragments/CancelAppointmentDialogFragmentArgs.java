package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CancelAppointmentDialogFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CancelAppointmentDialogFragmentArgs() {
  }

  private CancelAppointmentDialogFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CancelAppointmentDialogFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CancelAppointmentDialogFragmentArgs __result = new CancelAppointmentDialogFragmentArgs();
    bundle.setClassLoader(CancelAppointmentDialogFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("pateintId")) {
      String pateintId;
      pateintId = bundle.getString("pateintId");
      __result.arguments.put("pateintId", pateintId);
    }
    if (bundle.containsKey("doctorId")) {
      String doctorId;
      doctorId = bundle.getString("doctorId");
      __result.arguments.put("doctorId", doctorId);
    }
    if (bundle.containsKey("slotId")) {
      String slotId;
      slotId = bundle.getString("slotId");
      __result.arguments.put("slotId", slotId);
    }
    if (bundle.containsKey("btnPressed")) {
      String btnPressed;
      btnPressed = bundle.getString("btnPressed");
      __result.arguments.put("btnPressed", btnPressed);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPateintId() {
    return (String) arguments.get("pateintId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getDoctorId() {
    return (String) arguments.get("doctorId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getSlotId() {
    return (String) arguments.get("slotId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getBtnPressed() {
    return (String) arguments.get("btnPressed");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("pateintId")) {
      String pateintId = (String) arguments.get("pateintId");
      __result.putString("pateintId", pateintId);
    }
    if (arguments.containsKey("doctorId")) {
      String doctorId = (String) arguments.get("doctorId");
      __result.putString("doctorId", doctorId);
    }
    if (arguments.containsKey("slotId")) {
      String slotId = (String) arguments.get("slotId");
      __result.putString("slotId", slotId);
    }
    if (arguments.containsKey("btnPressed")) {
      String btnPressed = (String) arguments.get("btnPressed");
      __result.putString("btnPressed", btnPressed);
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
    CancelAppointmentDialogFragmentArgs that = (CancelAppointmentDialogFragmentArgs) object;
    if (arguments.containsKey("pateintId") != that.arguments.containsKey("pateintId")) {
      return false;
    }
    if (getPateintId() != null ? !getPateintId().equals(that.getPateintId()) : that.getPateintId() != null) {
      return false;
    }
    if (arguments.containsKey("doctorId") != that.arguments.containsKey("doctorId")) {
      return false;
    }
    if (getDoctorId() != null ? !getDoctorId().equals(that.getDoctorId()) : that.getDoctorId() != null) {
      return false;
    }
    if (arguments.containsKey("slotId") != that.arguments.containsKey("slotId")) {
      return false;
    }
    if (getSlotId() != null ? !getSlotId().equals(that.getSlotId()) : that.getSlotId() != null) {
      return false;
    }
    if (arguments.containsKey("btnPressed") != that.arguments.containsKey("btnPressed")) {
      return false;
    }
    if (getBtnPressed() != null ? !getBtnPressed().equals(that.getBtnPressed()) : that.getBtnPressed() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPateintId() != null ? getPateintId().hashCode() : 0);
    result = 31 * result + (getDoctorId() != null ? getDoctorId().hashCode() : 0);
    result = 31 * result + (getSlotId() != null ? getSlotId().hashCode() : 0);
    result = 31 * result + (getBtnPressed() != null ? getBtnPressed().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CancelAppointmentDialogFragmentArgs{"
        + "pateintId=" + getPateintId()
        + ", doctorId=" + getDoctorId()
        + ", slotId=" + getSlotId()
        + ", btnPressed=" + getBtnPressed()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CancelAppointmentDialogFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CancelAppointmentDialogFragmentArgs build() {
      CancelAppointmentDialogFragmentArgs result = new CancelAppointmentDialogFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPateintId(@Nullable String pateintId) {
      this.arguments.put("pateintId", pateintId);
      return this;
    }

    @NonNull
    public Builder setDoctorId(@Nullable String doctorId) {
      this.arguments.put("doctorId", doctorId);
      return this;
    }

    @NonNull
    public Builder setSlotId(@Nullable String slotId) {
      this.arguments.put("slotId", slotId);
      return this;
    }

    @NonNull
    public Builder setBtnPressed(@Nullable String btnPressed) {
      this.arguments.put("btnPressed", btnPressed);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPateintId() {
      return (String) arguments.get("pateintId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDoctorId() {
      return (String) arguments.get("doctorId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getSlotId() {
      return (String) arguments.get("slotId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getBtnPressed() {
      return (String) arguments.get("btnPressed");
    }
  }
}
