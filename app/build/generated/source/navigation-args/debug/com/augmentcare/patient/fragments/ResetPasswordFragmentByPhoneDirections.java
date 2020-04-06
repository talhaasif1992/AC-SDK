package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ResetPasswordFragmentByPhoneDirections {
  private ResetPasswordFragmentByPhoneDirections() {
  }

  @NonNull
  public static NavDirections actionResetPasswordFragmentByPhoneToResetPasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_resetPasswordFragmentByPhone_to_resetPasswordFragment);
  }

  @NonNull
  public static ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment actionResetPasswordFragmentByPhoneToResetPasswordOTPFragment() {
    return new ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment();
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

  public static class ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment() {
    }

    @NonNull
    public ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment setCode(@Nullable String code) {
      this.arguments.put("code", code);
      return this;
    }

    @NonNull
    public ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("phone")) {
        String phone = (String) arguments.get("phone");
        __result.putString("phone", phone);
      }
      if (arguments.containsKey("code")) {
        String code = (String) arguments.get("code");
        __result.putString("code", code);
      }
      if (arguments.containsKey("email")) {
        String email = (String) arguments.get("email");
        __result.putString("email", email);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_resetPasswordFragmentByPhone_to_resetPasswordOTPFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCode() {
      return (String) arguments.get("code");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment that = (ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment) object;
      if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
        return false;
      }
      if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
        return false;
      }
      if (arguments.containsKey("code") != that.arguments.containsKey("code")) {
        return false;
      }
      if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) {
        return false;
      }
      if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
        return false;
      }
      if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
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
      result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
      result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
      result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionResetPasswordFragmentByPhoneToResetPasswordOTPFragment(actionId=" + getActionId() + "){"
          + "phone=" + getPhone()
          + ", code=" + getCode()
          + ", email=" + getEmail()
          + "}";
    }
  }
}
