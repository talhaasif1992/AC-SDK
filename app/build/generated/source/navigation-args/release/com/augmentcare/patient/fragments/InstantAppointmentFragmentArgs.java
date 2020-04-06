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

public class InstantAppointmentFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private InstantAppointmentFragmentArgs() {
  }

  private InstantAppointmentFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static InstantAppointmentFragmentArgs fromBundle(@NonNull Bundle bundle) {
    InstantAppointmentFragmentArgs __result = new InstantAppointmentFragmentArgs();
    bundle.setClassLoader(InstantAppointmentFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("doctorID")) {
      String doctorID;
      doctorID = bundle.getString("doctorID");
      __result.arguments.put("doctorID", doctorID);
    }
    if (bundle.containsKey("orderID")) {
      String orderID;
      orderID = bundle.getString("orderID");
      __result.arguments.put("orderID", orderID);
    }
    if (bundle.containsKey("doContinue")) {
      boolean doContinue;
      doContinue = bundle.getBoolean("doContinue");
      __result.arguments.put("doContinue", doContinue);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getDoctorID() {
    return (String) arguments.get("doctorID");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getOrderID() {
    return (String) arguments.get("orderID");
  }

  @SuppressWarnings("unchecked")
  public boolean getDoContinue() {
    return (boolean) arguments.get("doContinue");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("doctorID")) {
      String doctorID = (String) arguments.get("doctorID");
      __result.putString("doctorID", doctorID);
    }
    if (arguments.containsKey("orderID")) {
      String orderID = (String) arguments.get("orderID");
      __result.putString("orderID", orderID);
    }
    if (arguments.containsKey("doContinue")) {
      boolean doContinue = (boolean) arguments.get("doContinue");
      __result.putBoolean("doContinue", doContinue);
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
    InstantAppointmentFragmentArgs that = (InstantAppointmentFragmentArgs) object;
    if (arguments.containsKey("doctorID") != that.arguments.containsKey("doctorID")) {
      return false;
    }
    if (getDoctorID() != null ? !getDoctorID().equals(that.getDoctorID()) : that.getDoctorID() != null) {
      return false;
    }
    if (arguments.containsKey("orderID") != that.arguments.containsKey("orderID")) {
      return false;
    }
    if (getOrderID() != null ? !getOrderID().equals(that.getOrderID()) : that.getOrderID() != null) {
      return false;
    }
    if (arguments.containsKey("doContinue") != that.arguments.containsKey("doContinue")) {
      return false;
    }
    if (getDoContinue() != that.getDoContinue()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctorID() != null ? getDoctorID().hashCode() : 0);
    result = 31 * result + (getOrderID() != null ? getOrderID().hashCode() : 0);
    result = 31 * result + (getDoContinue() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "InstantAppointmentFragmentArgs{"
        + "doctorID=" + getDoctorID()
        + ", orderID=" + getOrderID()
        + ", doContinue=" + getDoContinue()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(InstantAppointmentFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public InstantAppointmentFragmentArgs build() {
      InstantAppointmentFragmentArgs result = new InstantAppointmentFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctorID(@Nullable String doctorID) {
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public Builder setOrderID(@Nullable String orderID) {
      this.arguments.put("orderID", orderID);
      return this;
    }

    @NonNull
    public Builder setDoContinue(boolean doContinue) {
      this.arguments.put("doContinue", doContinue);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDoctorID() {
      return (String) arguments.get("doctorID");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getOrderID() {
      return (String) arguments.get("orderID");
    }

    @SuppressWarnings("unchecked")
    public boolean getDoContinue() {
      return (boolean) arguments.get("doContinue");
    }
  }
}
