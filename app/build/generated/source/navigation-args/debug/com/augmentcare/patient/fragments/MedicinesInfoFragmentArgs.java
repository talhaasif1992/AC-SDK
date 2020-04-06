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

public class MedicinesInfoFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MedicinesInfoFragmentArgs() {
  }

  private MedicinesInfoFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MedicinesInfoFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MedicinesInfoFragmentArgs __result = new MedicinesInfoFragmentArgs();
    bundle.setClassLoader(MedicinesInfoFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("isFromLab")) {
      boolean isFromLab;
      isFromLab = bundle.getBoolean("isFromLab");
      __result.arguments.put("isFromLab", isFromLab);
    }
    if (bundle.containsKey("Condition")) {
      String Condition;
      Condition = bundle.getString("Condition");
      __result.arguments.put("Condition", Condition);
    } else {
      throw new IllegalArgumentException("Required argument \"Condition\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public boolean getIsFromLab() {
    return (boolean) arguments.get("isFromLab");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getCondition() {
    return (String) arguments.get("Condition");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("isFromLab")) {
      boolean isFromLab = (boolean) arguments.get("isFromLab");
      __result.putBoolean("isFromLab", isFromLab);
    }
    if (arguments.containsKey("Condition")) {
      String Condition = (String) arguments.get("Condition");
      __result.putString("Condition", Condition);
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
    MedicinesInfoFragmentArgs that = (MedicinesInfoFragmentArgs) object;
    if (arguments.containsKey("isFromLab") != that.arguments.containsKey("isFromLab")) {
      return false;
    }
    if (getIsFromLab() != that.getIsFromLab()) {
      return false;
    }
    if (arguments.containsKey("Condition") != that.arguments.containsKey("Condition")) {
      return false;
    }
    if (getCondition() != null ? !getCondition().equals(that.getCondition()) : that.getCondition() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getIsFromLab() ? 1 : 0);
    result = 31 * result + (getCondition() != null ? getCondition().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MedicinesInfoFragmentArgs{"
        + "isFromLab=" + getIsFromLab()
        + ", Condition=" + getCondition()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(MedicinesInfoFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@Nullable String Condition) {
      this.arguments.put("Condition", Condition);
    }

    @NonNull
    public MedicinesInfoFragmentArgs build() {
      MedicinesInfoFragmentArgs result = new MedicinesInfoFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setIsFromLab(boolean isFromLab) {
      this.arguments.put("isFromLab", isFromLab);
      return this;
    }

    @NonNull
    public Builder setCondition(@Nullable String Condition) {
      this.arguments.put("Condition", Condition);
      return this;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromLab() {
      return (boolean) arguments.get("isFromLab");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCondition() {
      return (String) arguments.get("Condition");
    }
  }
}
