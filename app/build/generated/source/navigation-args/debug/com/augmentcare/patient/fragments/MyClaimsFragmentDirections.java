package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MyClaimsFragmentDirections {
  private MyClaimsFragmentDirections() {
  }

  @NonNull
  public static ActionMyClaimsFragmentToFileAClaimFragment actionMyClaimsFragmentToFileAClaimFragment(float availableLimit) {
    return new ActionMyClaimsFragmentToFileAClaimFragment(availableLimit);
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

  public static class ActionMyClaimsFragmentToFileAClaimFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMyClaimsFragmentToFileAClaimFragment(float availableLimit) {
      this.arguments.put("availableLimit", availableLimit);
    }

    @NonNull
    public ActionMyClaimsFragmentToFileAClaimFragment setAvailableLimit(float availableLimit) {
      this.arguments.put("availableLimit", availableLimit);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("availableLimit")) {
        float availableLimit = (float) arguments.get("availableLimit");
        __result.putFloat("availableLimit", availableLimit);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_myClaimsFragment_to_fileAClaimFragment;
    }

    @SuppressWarnings("unchecked")
    public float getAvailableLimit() {
      return (float) arguments.get("availableLimit");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMyClaimsFragmentToFileAClaimFragment that = (ActionMyClaimsFragmentToFileAClaimFragment) object;
      if (arguments.containsKey("availableLimit") != that.arguments.containsKey("availableLimit")) {
        return false;
      }
      if (Float.compare(that.getAvailableLimit(), getAvailableLimit()) != 0) {
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
      result = 31 * result + Float.floatToIntBits(getAvailableLimit());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMyClaimsFragmentToFileAClaimFragment(actionId=" + getActionId() + "){"
          + "availableLimit=" + getAvailableLimit()
          + "}";
    }
  }
}
