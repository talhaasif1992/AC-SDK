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

public class AppointmentDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private AppointmentDetailsFragmentArgs() {
  }

  private AppointmentDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static AppointmentDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    AppointmentDetailsFragmentArgs __result = new AppointmentDetailsFragmentArgs();
    bundle.setClassLoader(AppointmentDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("slotID")) {
      int slotID;
      slotID = bundle.getInt("slotID");
      __result.arguments.put("slotID", slotID);
    } else {
      throw new IllegalArgumentException("Required argument \"slotID\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getSlotID() {
    return (int) arguments.get("slotID");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("slotID")) {
      int slotID = (int) arguments.get("slotID");
      __result.putInt("slotID", slotID);
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
    AppointmentDetailsFragmentArgs that = (AppointmentDetailsFragmentArgs) object;
    if (arguments.containsKey("slotID") != that.arguments.containsKey("slotID")) {
      return false;
    }
    if (getSlotID() != that.getSlotID()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getSlotID();
    return result;
  }

  @Override
  public String toString() {
    return "AppointmentDetailsFragmentArgs{"
        + "slotID=" + getSlotID()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(AppointmentDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public AppointmentDetailsFragmentArgs build() {
      AppointmentDetailsFragmentArgs result = new AppointmentDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setSlotID(int slotID) {
      this.arguments.put("slotID", slotID);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getSlotID() {
      return (int) arguments.get("slotID");
    }
  }
}
