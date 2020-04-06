package com.augmentcare.patient.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;

public class claimDetailsFragmentDirections {
  private claimDetailsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionClaimDetailsFragmentToUploadClaimsImages() {
    return new ActionOnlyNavDirections(R.id.action_claimDetailsFragment_to_uploadClaimsImages);
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
