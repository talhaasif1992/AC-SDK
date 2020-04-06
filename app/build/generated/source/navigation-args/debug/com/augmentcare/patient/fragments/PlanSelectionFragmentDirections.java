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

public class PlanSelectionFragmentDirections {
  private PlanSelectionFragmentDirections() {
  }

  @NonNull
  public static ActionPlanSelectionFragmentToFindDoctorFragment actionPlanSelectionFragmentToFindDoctorFragment() {
    return new ActionPlanSelectionFragmentToFindDoctorFragment();
  }

  @NonNull
  public static NavDirections actionPlanSelectionFragmentToSubscriptionPaymentFragement() {
    return new ActionOnlyNavDirections(R.id.action_planSelectionFragment_to_subscriptionPaymentFragement);
  }

  @NonNull
  public static ActionPlanSelectionFragmentToAddCardFragment actionPlanSelectionFragmentToAddCardFragment() {
    return new ActionPlanSelectionFragmentToAddCardFragment();
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

  public static class ActionPlanSelectionFragmentToFindDoctorFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPlanSelectionFragmentToFindDoctorFragment() {
    }

    @NonNull
    public ActionPlanSelectionFragmentToFindDoctorFragment setNoOfFreeCalls(int noOfFreeCalls) {
      this.arguments.put("noOfFreeCalls", noOfFreeCalls);
      return this;
    }

    @NonNull
    public ActionPlanSelectionFragmentToFindDoctorFragment setShowBadge(boolean showBadge) {
      this.arguments.put("showBadge", showBadge);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_planSelectionFragment_to_findDoctorFragment;
    }

    @SuppressWarnings("unchecked")
    public int getNoOfFreeCalls() {
      return (int) arguments.get("noOfFreeCalls");
    }

    @SuppressWarnings("unchecked")
    public boolean getShowBadge() {
      return (boolean) arguments.get("showBadge");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPlanSelectionFragmentToFindDoctorFragment that = (ActionPlanSelectionFragmentToFindDoctorFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getNoOfFreeCalls();
      result = 31 * result + (getShowBadge() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPlanSelectionFragmentToFindDoctorFragment(actionId=" + getActionId() + "){"
          + "noOfFreeCalls=" + getNoOfFreeCalls()
          + ", showBadge=" + getShowBadge()
          + "}";
    }
  }

  public static class ActionPlanSelectionFragmentToAddCardFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPlanSelectionFragmentToAddCardFragment() {
    }

    @NonNull
    public ActionPlanSelectionFragmentToAddCardFragment setAddCardFlagToggle(boolean AddCardFlagToggle) {
      this.arguments.put("AddCardFlagToggle", AddCardFlagToggle);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("AddCardFlagToggle")) {
        boolean AddCardFlagToggle = (boolean) arguments.get("AddCardFlagToggle");
        __result.putBoolean("AddCardFlagToggle", AddCardFlagToggle);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_planSelectionFragment_to_addCardFragment;
    }

    @SuppressWarnings("unchecked")
    public boolean getAddCardFlagToggle() {
      return (boolean) arguments.get("AddCardFlagToggle");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPlanSelectionFragmentToAddCardFragment that = (ActionPlanSelectionFragmentToAddCardFragment) object;
      if (arguments.containsKey("AddCardFlagToggle") != that.arguments.containsKey("AddCardFlagToggle")) {
        return false;
      }
      if (getAddCardFlagToggle() != that.getAddCardFlagToggle()) {
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
      result = 31 * result + (getAddCardFlagToggle() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPlanSelectionFragmentToAddCardFragment(actionId=" + getActionId() + "){"
          + "AddCardFlagToggle=" + getAddCardFlagToggle()
          + "}";
    }
  }
}
