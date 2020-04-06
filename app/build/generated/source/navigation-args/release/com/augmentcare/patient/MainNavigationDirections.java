package com.augmentcare.patient;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MainNavigationDirections {
  private MainNavigationDirections() {
  }

  @NonNull
  public static NavDirections actionGlobalDashboardFragment2() {
    return new ActionOnlyNavDirections(R.id.action_global_dashboardFragment2);
  }

  @NonNull
  public static NavDirections actionGlobalLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_loginFragment);
  }

  @NonNull
  public static NavDirections actionGlobalSignUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_global_signUpFragment);
  }
}
