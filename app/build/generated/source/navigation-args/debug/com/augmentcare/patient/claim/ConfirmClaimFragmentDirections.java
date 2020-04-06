package com.augmentcare.patient.claim;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ConfirmClaimFragmentDirections {
  private ConfirmClaimFragmentDirections() {
  }

  @NonNull
  public static ActionConfirmClaimFragmentToClaimSuccessFragment actionConfirmClaimFragmentToClaimSuccessFragment(@NonNull String claimType,
      @NonNull String claimFor) {
    return new ActionConfirmClaimFragmentToClaimSuccessFragment(claimType, claimFor);
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

  public static class ActionConfirmClaimFragmentToClaimSuccessFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionConfirmClaimFragmentToClaimSuccessFragment(@NonNull String claimType,
        @NonNull String claimFor) {
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_type", claimType);
      if (claimFor == null) {
        throw new IllegalArgumentException("Argument \"claim_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_for", claimFor);
    }

    @NonNull
    public ActionConfirmClaimFragmentToClaimSuccessFragment setAmount(int amount) {
      this.arguments.put("amount", amount);
      return this;
    }

    @NonNull
    public ActionConfirmClaimFragmentToClaimSuccessFragment setClaimType(@NonNull String claimType) {
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_type", claimType);
      return this;
    }

    @NonNull
    public ActionConfirmClaimFragmentToClaimSuccessFragment setClaimFor(@NonNull String claimFor) {
      if (claimFor == null) {
        throw new IllegalArgumentException("Argument \"claim_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_for", claimFor);
      return this;
    }

    @NonNull
    public ActionConfirmClaimFragmentToClaimSuccessFragment setClaimDetails(@Nullable String claimDetails) {
      this.arguments.put("claim_details", claimDetails);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("amount")) {
        int amount = (int) arguments.get("amount");
        __result.putInt("amount", amount);
      }
      if (arguments.containsKey("claim_type")) {
        String claimType = (String) arguments.get("claim_type");
        __result.putString("claim_type", claimType);
      }
      if (arguments.containsKey("claim_for")) {
        String claimFor = (String) arguments.get("claim_for");
        __result.putString("claim_for", claimFor);
      }
      if (arguments.containsKey("claim_details")) {
        String claimDetails = (String) arguments.get("claim_details");
        __result.putString("claim_details", claimDetails);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_confirmClaimFragment_to_claimSuccessFragment;
    }

    @SuppressWarnings("unchecked")
    public int getAmount() {
      return (int) arguments.get("amount");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getClaimType() {
      return (String) arguments.get("claim_type");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getClaimFor() {
      return (String) arguments.get("claim_for");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getClaimDetails() {
      return (String) arguments.get("claim_details");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionConfirmClaimFragmentToClaimSuccessFragment that = (ActionConfirmClaimFragmentToClaimSuccessFragment) object;
      if (arguments.containsKey("amount") != that.arguments.containsKey("amount")) {
        return false;
      }
      if (getAmount() != that.getAmount()) {
        return false;
      }
      if (arguments.containsKey("claim_type") != that.arguments.containsKey("claim_type")) {
        return false;
      }
      if (getClaimType() != null ? !getClaimType().equals(that.getClaimType()) : that.getClaimType() != null) {
        return false;
      }
      if (arguments.containsKey("claim_for") != that.arguments.containsKey("claim_for")) {
        return false;
      }
      if (getClaimFor() != null ? !getClaimFor().equals(that.getClaimFor()) : that.getClaimFor() != null) {
        return false;
      }
      if (arguments.containsKey("claim_details") != that.arguments.containsKey("claim_details")) {
        return false;
      }
      if (getClaimDetails() != null ? !getClaimDetails().equals(that.getClaimDetails()) : that.getClaimDetails() != null) {
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
      result = 31 * result + getAmount();
      result = 31 * result + (getClaimType() != null ? getClaimType().hashCode() : 0);
      result = 31 * result + (getClaimFor() != null ? getClaimFor().hashCode() : 0);
      result = 31 * result + (getClaimDetails() != null ? getClaimDetails().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionConfirmClaimFragmentToClaimSuccessFragment(actionId=" + getActionId() + "){"
          + "amount=" + getAmount()
          + ", claimType=" + getClaimType()
          + ", claimFor=" + getClaimFor()
          + ", claimDetails=" + getClaimDetails()
          + "}";
    }
  }
}
