package com.augmentcare.patient;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class VerifyOTPPhoneFragmentDirections {
  private VerifyOTPPhoneFragmentDirections() {
  }

  @NonNull
  public static ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone actionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone() {
    return new ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone();
  }

  @NonNull
  public static NavDirections actionGlobalDashboardFragment2() {
    return MainNavigationDirections.actionGlobalDashboardFragment2();
  }

  @NonNull
  public static NavDirections actionGlobalLoginFragment() {
    return MainNavigationDirections.actionGlobalLoginFragment();
  }

  @NonNull
  public static NavDirections actionGlobalSignUpFragment() {
    return MainNavigationDirections.actionGlobalSignUpFragment();
  }

  public static class ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone() {
    }

    @NonNull
    public ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone setFName(@Nullable String fName) {
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone setLName(@Nullable String lName) {
      this.arguments.put("lName", lName);
      return this;
    }

    @NonNull
    public ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("fName")) {
        String fName = (String) arguments.get("fName");
        __result.putString("fName", fName);
      }
      if (arguments.containsKey("lName")) {
        String lName = (String) arguments.get("lName");
        __result.putString("lName", lName);
      }
      if (arguments.containsKey("phone")) {
        String phone = (String) arguments.get("phone");
        __result.putString("phone", phone);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_verifyOTPPhoneFragment_to_thankYouFragmentVerifyPhone;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getFName() {
      return (String) arguments.get("fName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getLName() {
      return (String) arguments.get("lName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone that = (ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone) object;
      if (arguments.containsKey("fName") != that.arguments.containsKey("fName")) {
        return false;
      }
      if (getFName() != null ? !getFName().equals(that.getFName()) : that.getFName() != null) {
        return false;
      }
      if (arguments.containsKey("lName") != that.arguments.containsKey("lName")) {
        return false;
      }
      if (getLName() != null ? !getLName().equals(that.getLName()) : that.getLName() != null) {
        return false;
      }
      if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
        return false;
      }
      if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getFName() != null ? getFName().hashCode() : 0);
      result = 31 * result + (getLName() != null ? getLName().hashCode() : 0);
      result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone(actionId=" + getActionId() + "){"
          + "fName=" + getFName()
          + ", lName=" + getLName()
          + ", phone=" + getPhone()
          + "}";
    }
  }
}
