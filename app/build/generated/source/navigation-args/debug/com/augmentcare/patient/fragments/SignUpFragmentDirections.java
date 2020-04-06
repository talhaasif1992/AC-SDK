package com.augmentcare.patient.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;

public class SignUpFragmentDirections {
  private SignUpFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSignUpFragmentToSignUpNavigation() {
    return new ActionOnlyNavDirections(R.id.action_signUpFragment_to_sign_up_navigation);
  }

  @NonNull
  public static NavDirections actionSignUpFragmentToSignupEmployeeCodeNavigation() {
    return new ActionOnlyNavDirections(R.id.action_signUpFragment_to_signup_employee_code_navigation);
  }

  @NonNull
  public static NavDirections actionSignUpFragmentToLoginOtpVerificationNavigation() {
    return new ActionOnlyNavDirections(R.id.action_signUpFragment_to_login_otp_verification_navigation);
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
