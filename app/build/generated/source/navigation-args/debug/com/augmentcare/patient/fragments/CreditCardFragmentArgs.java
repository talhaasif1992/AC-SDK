package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CreditCardFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CreditCardFragmentArgs() {
  }

  private CreditCardFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CreditCardFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CreditCardFragmentArgs __result = new CreditCardFragmentArgs();
    bundle.setClassLoader(CreditCardFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("isFromSettings")) {
      boolean isFromSettings;
      isFromSettings = bundle.getBoolean("isFromSettings");
      __result.arguments.put("isFromSettings", isFromSettings);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public boolean getIsFromSettings() {
    return (boolean) arguments.get("isFromSettings");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("isFromSettings")) {
      boolean isFromSettings = (boolean) arguments.get("isFromSettings");
      __result.putBoolean("isFromSettings", isFromSettings);
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
    CreditCardFragmentArgs that = (CreditCardFragmentArgs) object;
    if (arguments.containsKey("isFromSettings") != that.arguments.containsKey("isFromSettings")) {
      return false;
    }
    if (getIsFromSettings() != that.getIsFromSettings()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getIsFromSettings() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CreditCardFragmentArgs{"
        + "isFromSettings=" + getIsFromSettings()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CreditCardFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CreditCardFragmentArgs build() {
      CreditCardFragmentArgs result = new CreditCardFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setIsFromSettings(boolean isFromSettings) {
      this.arguments.put("isFromSettings", isFromSettings);
      return this;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromSettings() {
      return (boolean) arguments.get("isFromSettings");
    }
  }
}
