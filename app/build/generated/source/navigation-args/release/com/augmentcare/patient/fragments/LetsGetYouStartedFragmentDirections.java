package com.augmentcare.patient.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;

public class LetsGetYouStartedFragmentDirections {
  private LetsGetYouStartedFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLetsGetYouStartedFragmentToSignInSignUpActivity() {
    return new ActionOnlyNavDirections(R.id.action_letsGetYouStartedFragment_to_signInSignUpActivity);
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
