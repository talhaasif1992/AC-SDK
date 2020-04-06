package com.augmentcare.patient.activities;

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

public class PaymentMethodFragmentDirections {
  private PaymentMethodFragmentDirections() {
  }

  @NonNull
  public static ActionPaymentMethodActivityToCardSelectionDialogue actionPaymentMethodActivityToCardSelectionDialogue() {
    return new ActionPaymentMethodActivityToCardSelectionDialogue();
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

  public static class ActionPaymentMethodActivityToCardSelectionDialogue implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPaymentMethodActivityToCardSelectionDialogue() {
    }

    @NonNull
    public ActionPaymentMethodActivityToCardSelectionDialogue setPlanId(@Nullable String planId) {
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
      return R.id.action_paymentMethodActivity_to_cardSelectionDialogue;
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
      ActionPaymentMethodActivityToCardSelectionDialogue that = (ActionPaymentMethodActivityToCardSelectionDialogue) object;
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
      return "ActionPaymentMethodActivityToCardSelectionDialogue(actionId=" + getActionId() + "){"
          + "planId=" + getPlanId()
          + "}";
    }
  }
}
