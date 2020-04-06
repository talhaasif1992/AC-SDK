package com.augmentcare.patient.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;

public class AddCardFragmentDirections {
  private AddCardFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddCardFragmentToPaymentMethodActivity() {
    return new ActionOnlyNavDirections(R.id.action_addCardFragment_to_paymentMethodActivity);
  }

  @NonNull
  public static NavDirections actionAddCardFragmentToPaymentSuccessfullFragment() {
    return new ActionOnlyNavDirections(R.id.action_addCardFragment_to_paymentSuccessfullFragment);
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
