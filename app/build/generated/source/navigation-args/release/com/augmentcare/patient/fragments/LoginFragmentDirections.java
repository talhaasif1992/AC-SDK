package com.augmentcare.patient.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToSignUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_signUpFragment);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToLoginOtpVerificationNavigation() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_login_otp_verification_navigation);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToResetPasswordFragmentByPhone() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_resetPasswordFragmentByPhone);
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
