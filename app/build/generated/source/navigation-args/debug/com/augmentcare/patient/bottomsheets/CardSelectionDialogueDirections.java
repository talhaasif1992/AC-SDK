package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CardSelectionDialogueDirections {
  private CardSelectionDialogueDirections() {
  }

  @NonNull
  public static ActionCardSelectionDialogueToAddCardFragment actionCardSelectionDialogueToAddCardFragment() {
    return new ActionCardSelectionDialogueToAddCardFragment();
  }

  @NonNull
  public static ActionCardSelectionDialogueToEnterJazzCashNumberFragment actionCardSelectionDialogueToEnterJazzCashNumberFragment() {
    return new ActionCardSelectionDialogueToEnterJazzCashNumberFragment();
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

  public static class ActionCardSelectionDialogueToAddCardFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCardSelectionDialogueToAddCardFragment() {
    }

    @NonNull
    public ActionCardSelectionDialogueToAddCardFragment setAddCardFlagToggle(boolean AddCardFlagToggle) {
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
      return R.id.action_cardSelectionDialogue_to_addCardFragment;
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
      ActionCardSelectionDialogueToAddCardFragment that = (ActionCardSelectionDialogueToAddCardFragment) object;
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
      return "ActionCardSelectionDialogueToAddCardFragment(actionId=" + getActionId() + "){"
          + "AddCardFlagToggle=" + getAddCardFlagToggle()
          + "}";
    }
  }

  public static class ActionCardSelectionDialogueToEnterJazzCashNumberFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCardSelectionDialogueToEnterJazzCashNumberFragment() {
    }

    @NonNull
    public ActionCardSelectionDialogueToEnterJazzCashNumberFragment setPlanId(@Nullable String planId) {
      this.arguments.put("planId", planId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("planId")) {
        String planId = (String) arguments.get("planId");
        __result.putString("planId", planId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_cardSelectionDialogue_to_enterJazzCashNumberFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPlanId() {
      return (String) arguments.get("planId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCardSelectionDialogueToEnterJazzCashNumberFragment that = (ActionCardSelectionDialogueToEnterJazzCashNumberFragment) object;
      if (arguments.containsKey("planId") != that.arguments.containsKey("planId")) {
        return false;
      }
      if (getPlanId() != null ? !getPlanId().equals(that.getPlanId()) : that.getPlanId() != null) {
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
      result = 31 * result + (getPlanId() != null ? getPlanId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCardSelectionDialogueToEnterJazzCashNumberFragment(actionId=" + getActionId() + "){"
          + "planId=" + getPlanId()
          + "}";
    }
  }
}
