package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ResetPasswordOTPFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ResetPasswordOTPFragmentArgs() {
  }

  private ResetPasswordOTPFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ResetPasswordOTPFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ResetPasswordOTPFragmentArgs __result = new ResetPasswordOTPFragmentArgs();
    bundle.setClassLoader(ResetPasswordOTPFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      __result.arguments.put("phone", phone);
    }
    if (bundle.containsKey("code")) {
      String code;
      code = bundle.getString("code");
      __result.arguments.put("code", code);
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      __result.arguments.put("email", email);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPhone() {
    return (String) arguments.get("phone");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getCode() {
    return (String) arguments.get("code");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getEmail() {
    return (String) arguments.get("email");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("phone")) {
      String phone = (String) arguments.get("phone");
      __result.putString("phone", phone);
    }
    if (arguments.containsKey("code")) {
      String code = (String) arguments.get("code");
      __result.putString("code", code);
    }
    if (arguments.containsKey("email")) {
      String email = (String) arguments.get("email");
      __result.putString("email", email);
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
    ResetPasswordOTPFragmentArgs that = (ResetPasswordOTPFragmentArgs) object;
    if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
      return false;
    }
    if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
      return false;
    }
    if (arguments.containsKey("code") != that.arguments.containsKey("code")) {
      return false;
    }
    if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) {
      return false;
    }
    if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
      return false;
    }
    if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ResetPasswordOTPFragmentArgs{"
        + "phone=" + getPhone()
        + ", code=" + getCode()
        + ", email=" + getEmail()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ResetPasswordOTPFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ResetPasswordOTPFragmentArgs build() {
      ResetPasswordOTPFragmentArgs result = new ResetPasswordOTPFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public Builder setCode(@Nullable String code) {
      this.arguments.put("code", code);
      return this;
    }

    @NonNull
    public Builder setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCode() {
      return (String) arguments.get("code");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEmail() {
      return (String) arguments.get("email");
    }
  }
}
