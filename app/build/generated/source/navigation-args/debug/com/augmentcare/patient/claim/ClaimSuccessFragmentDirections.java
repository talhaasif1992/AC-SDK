package com.augmentcare.patient.claim;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;

public class ClaimSuccessFragmentDirections {
  private ClaimSuccessFragmentDirections() {
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
}
