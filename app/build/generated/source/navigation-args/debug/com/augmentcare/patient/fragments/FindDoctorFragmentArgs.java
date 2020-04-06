package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FindDoctorFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FindDoctorFragmentArgs() {
  }

  private FindDoctorFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FindDoctorFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FindDoctorFragmentArgs __result = new FindDoctorFragmentArgs();
    bundle.setClassLoader(FindDoctorFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("noOfFreeCalls")) {
      int noOfFreeCalls;
      noOfFreeCalls = bundle.getInt("noOfFreeCalls");
      __result.arguments.put("noOfFreeCalls", noOfFreeCalls);
    }
    if (bundle.containsKey("showBadge")) {
      boolean showBadge;
      showBadge = bundle.getBoolean("showBadge");
      __result.arguments.put("showBadge", showBadge);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getNoOfFreeCalls() {
    return (int) arguments.get("noOfFreeCalls");
  }

  @SuppressWarnings("unchecked")
  public boolean getShowBadge() {
    return (boolean) arguments.get("showBadge");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("noOfFreeCalls")) {
      int noOfFreeCalls = (int) arguments.get("noOfFreeCalls");
      __result.putInt("noOfFreeCalls", noOfFreeCalls);
    }
    if (arguments.containsKey("showBadge")) {
      boolean showBadge = (boolean) arguments.get("showBadge");
      __result.putBoolean("showBadge", showBadge);
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
    FindDoctorFragmentArgs that = (FindDoctorFragmentArgs) object;
    if (arguments.containsKey("noOfFreeCalls") != that.arguments.containsKey("noOfFreeCalls")) {
      return false;
    }
    if (getNoOfFreeCalls() != that.getNoOfFreeCalls()) {
      return false;
    }
    if (arguments.containsKey("showBadge") != that.arguments.containsKey("showBadge")) {
      return false;
    }
    if (getShowBadge() != that.getShowBadge()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getNoOfFreeCalls();
    result = 31 * result + (getShowBadge() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FindDoctorFragmentArgs{"
        + "noOfFreeCalls=" + getNoOfFreeCalls()
        + ", showBadge=" + getShowBadge()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(FindDoctorFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public FindDoctorFragmentArgs build() {
      FindDoctorFragmentArgs result = new FindDoctorFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setNoOfFreeCalls(int noOfFreeCalls) {
      this.arguments.put("noOfFreeCalls", noOfFreeCalls);
      return this;
    }

    @NonNull
    public Builder setShowBadge(boolean showBadge) {
      this.arguments.put("showBadge", showBadge);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getNoOfFreeCalls() {
      return (int) arguments.get("noOfFreeCalls");
    }

    @SuppressWarnings("unchecked")
    public boolean getShowBadge() {
      return (boolean) arguments.get("showBadge");
    }
  }
}
