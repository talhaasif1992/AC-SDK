package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AppSettingsFragmentDirections {
  private AppSettingsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAppSettingsFragmentToPaymentMethodActivity() {
    return new ActionOnlyNavDirections(R.id.action_appSettingsFragment_to_paymentMethodActivity);
  }

  @NonNull
  public static NavDirections actionAppSettingsFragmentToEditProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_appSettingsFragment_to_editProfileFragment);
  }

  @NonNull
  public static NavDirections actionAppSettingsFragmentToChangePasswordBottomSheet() {
    return new ActionOnlyNavDirections(R.id.action_appSettingsFragment_to_changePasswordBottomSheet);
  }

  @NonNull
  public static ActionAppSettingsFragmentToCreditCardFragment actionAppSettingsFragmentToCreditCardFragment() {
    return new ActionAppSettingsFragmentToCreditCardFragment();
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

  public static class ActionAppSettingsFragmentToCreditCardFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAppSettingsFragmentToCreditCardFragment() {
    }

    @NonNull
    public ActionAppSettingsFragmentToCreditCardFragment setIsFromSettings(boolean isFromSettings) {
      this.arguments.put("isFromSettings", isFromSettings);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("isFromSettings")) {
        boolean isFromSettings = (boolean) arguments.get("isFromSettings");
        __result.putBoolean("isFromSettings", isFromSettings);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_appSettingsFragment_to_creditCardFragment;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromSettings() {
      return (boolean) arguments.get("isFromSettings");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAppSettingsFragmentToCreditCardFragment that = (ActionAppSettingsFragmentToCreditCardFragment) object;
      if (arguments.containsKey("isFromSettings") != that.arguments.containsKey("isFromSettings")) {
        return false;
      }
      if (getIsFromSettings() != that.getIsFromSettings()) {
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
      result = 31 * result + (getIsFromSettings() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAppSettingsFragmentToCreditCardFragment(actionId=" + getActionId() + "){"
          + "isFromSettings=" + getIsFromSettings()
          + "}";
    }
  }
}
