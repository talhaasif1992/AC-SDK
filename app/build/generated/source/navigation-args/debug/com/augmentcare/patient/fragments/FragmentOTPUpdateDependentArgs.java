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

public class FragmentOTPUpdateDependentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FragmentOTPUpdateDependentArgs() {
  }

  private FragmentOTPUpdateDependentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FragmentOTPUpdateDependentArgs fromBundle(@NonNull Bundle bundle) {
    FragmentOTPUpdateDependentArgs __result = new FragmentOTPUpdateDependentArgs();
    bundle.setClassLoader(FragmentOTPUpdateDependentArgs.class.getClassLoader());
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      __result.arguments.put("phone", phone);
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
    FragmentOTPUpdateDependentArgs that = (FragmentOTPUpdateDependentArgs) object;
    if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
      return false;
    }
    if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
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
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FragmentOTPUpdateDependentArgs{"
        + "phone=" + getPhone()
        + ", email=" + getEmail()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(FragmentOTPUpdateDependentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public FragmentOTPUpdateDependentArgs build() {
      FragmentOTPUpdateDependentArgs result = new FragmentOTPUpdateDependentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
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
    public String getEmail() {
      return (String) arguments.get("email");
    }
  }
}
