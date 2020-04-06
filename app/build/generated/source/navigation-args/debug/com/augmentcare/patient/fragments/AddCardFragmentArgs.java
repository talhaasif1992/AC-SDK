package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AddCardFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private AddCardFragmentArgs() {
  }

  private AddCardFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static AddCardFragmentArgs fromBundle(@NonNull Bundle bundle) {
    AddCardFragmentArgs __result = new AddCardFragmentArgs();
    bundle.setClassLoader(AddCardFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("AddCardFlagToggle")) {
      boolean AddCardFlagToggle;
      AddCardFlagToggle = bundle.getBoolean("AddCardFlagToggle");
      __result.arguments.put("AddCardFlagToggle", AddCardFlagToggle);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public boolean getAddCardFlagToggle() {
    return (boolean) arguments.get("AddCardFlagToggle");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("AddCardFlagToggle")) {
      boolean AddCardFlagToggle = (boolean) arguments.get("AddCardFlagToggle");
      __result.putBoolean("AddCardFlagToggle", AddCardFlagToggle);
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
    AddCardFragmentArgs that = (AddCardFragmentArgs) object;
    if (arguments.containsKey("AddCardFlagToggle") != that.arguments.containsKey("AddCardFlagToggle")) {
      return false;
    }
    if (getAddCardFlagToggle() != that.getAddCardFlagToggle()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getAddCardFlagToggle() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AddCardFragmentArgs{"
        + "AddCardFlagToggle=" + getAddCardFlagToggle()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(AddCardFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public AddCardFragmentArgs build() {
      AddCardFragmentArgs result = new AddCardFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setAddCardFlagToggle(boolean AddCardFlagToggle) {
      this.arguments.put("AddCardFlagToggle", AddCardFlagToggle);
      return this;
    }

    @SuppressWarnings("unchecked")
    public boolean getAddCardFlagToggle() {
      return (boolean) arguments.get("AddCardFlagToggle");
    }
  }
}
