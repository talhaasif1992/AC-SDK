package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class OTPFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private OTPFragmentArgs() {
  }

  private OTPFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static OTPFragmentArgs fromBundle(@NonNull Bundle bundle) {
    OTPFragmentArgs __result = new OTPFragmentArgs();
    bundle.setClassLoader(OTPFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("password")) {
      String password;
      password = bundle.getString("password");
      __result.arguments.put("password", password);
    } else {
      throw new IllegalArgumentException("Required argument \"password\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("isForgotPassword")) {
      boolean isForgotPassword;
      isForgotPassword = bundle.getBoolean("isForgotPassword");
      __result.arguments.put("isForgotPassword", isForgotPassword);
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("email", email);
    } else {
      throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("is_google_sign_up")) {
      boolean isGoogleSignUp;
      isGoogleSignUp = bundle.getBoolean("is_google_sign_up");
      __result.arguments.put("is_google_sign_up", isGoogleSignUp);
    }
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("phone", phone);
    } else {
      throw new IllegalArgumentException("Required argument \"phone\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("from_sign_up_flow")) {
      boolean fromSignUpFlow;
      fromSignUpFlow = bundle.getBoolean("from_sign_up_flow");
      __result.arguments.put("from_sign_up_flow", fromSignUpFlow);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPassword() {
    return (String) arguments.get("password");
  }

  @SuppressWarnings("unchecked")
  public boolean getIsForgotPassword() {
    return (boolean) arguments.get("isForgotPassword");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getEmail() {
    return (String) arguments.get("email");
  }

  @SuppressWarnings("unchecked")
  public boolean getIsGoogleSignUp() {
    return (boolean) arguments.get("is_google_sign_up");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getPhone() {
    return (String) arguments.get("phone");
  }

  @SuppressWarnings("unchecked")
  public boolean getFromSignUpFlow() {
    return (boolean) arguments.get("from_sign_up_flow");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("password")) {
      String password = (String) arguments.get("password");
      __result.putString("password", password);
    }
    if (arguments.containsKey("isForgotPassword")) {
      boolean isForgotPassword = (boolean) arguments.get("isForgotPassword");
      __result.putBoolean("isForgotPassword", isForgotPassword);
    }
    if (arguments.containsKey("email")) {
      String email = (String) arguments.get("email");
      __result.putString("email", email);
    }
    if (arguments.containsKey("is_google_sign_up")) {
      boolean isGoogleSignUp = (boolean) arguments.get("is_google_sign_up");
      __result.putBoolean("is_google_sign_up", isGoogleSignUp);
    }
    if (arguments.containsKey("phone")) {
      String phone = (String) arguments.get("phone");
      __result.putString("phone", phone);
    }
    if (arguments.containsKey("from_sign_up_flow")) {
      boolean fromSignUpFlow = (boolean) arguments.get("from_sign_up_flow");
      __result.putBoolean("from_sign_up_flow", fromSignUpFlow);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    OTPFragmentArgs that = (OTPFragmentArgs) object;
    if (arguments.containsKey("password") != that.arguments.containsKey("password")) {
      return false;
    }
    if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null) {
      return false;
    }
    if (arguments.containsKey("isForgotPassword") != that.arguments.containsKey("isForgotPassword")) {
      return false;
    }
    if (getIsForgotPassword() != that.getIsForgotPassword()) {
      return false;
    }
    if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
      return false;
    }
    if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
      return false;
    }
    if (arguments.containsKey("is_google_sign_up") != that.arguments.containsKey("is_google_sign_up")) {
      return false;
    }
    if (getIsGoogleSignUp() != that.getIsGoogleSignUp()) {
      return false;
    }
    if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
      return false;
    }
    if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
      return false;
    }
    if (arguments.containsKey("from_sign_up_flow") != that.arguments.containsKey("from_sign_up_flow")) {
      return false;
    }
    if (getFromSignUpFlow() != that.getFromSignUpFlow()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + (getIsForgotPassword() ? 1 : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getIsGoogleSignUp() ? 1 : 0);
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    result = 31 * result + (getFromSignUpFlow() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OTPFragmentArgs{"
        + "password=" + getPassword()
        + ", isForgotPassword=" + getIsForgotPassword()
        + ", email=" + getEmail()
        + ", isGoogleSignUp=" + getIsGoogleSignUp()
        + ", phone=" + getPhone()
        + ", fromSignUpFlow=" + getFromSignUpFlow()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(OTPFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@Nullable String password, @NonNull String email, @NonNull String phone) {
      this.arguments.put("password", password);
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
    }

    @NonNull
    public OTPFragmentArgs build() {
      OTPFragmentArgs result = new OTPFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPassword(@Nullable String password) {
      this.arguments.put("password", password);
      return this;
    }

    @NonNull
    public Builder setIsForgotPassword(boolean isForgotPassword) {
      this.arguments.put("isForgotPassword", isForgotPassword);
      return this;
    }

    @NonNull
    public Builder setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public Builder setIsGoogleSignUp(boolean isGoogleSignUp) {
      this.arguments.put("is_google_sign_up", isGoogleSignUp);
      return this;
    }

    @NonNull
    public Builder setPhone(@NonNull String phone) {
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public Builder setFromSignUpFlow(boolean fromSignUpFlow) {
      this.arguments.put("from_sign_up_flow", fromSignUpFlow);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPassword() {
      return (String) arguments.get("password");
    }

    @SuppressWarnings("unchecked")
    public boolean getIsForgotPassword() {
      return (boolean) arguments.get("isForgotPassword");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    public boolean getIsGoogleSignUp() {
      return (boolean) arguments.get("is_google_sign_up");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @SuppressWarnings("unchecked")
    public boolean getFromSignUpFlow() {
      return (boolean) arguments.get("from_sign_up_flow");
    }
  }
}
