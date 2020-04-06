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

public class FreeCallCongratsDialogFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FreeCallCongratsDialogFragmentArgs() {
  }

  private FreeCallCongratsDialogFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FreeCallCongratsDialogFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FreeCallCongratsDialogFragmentArgs __result = new FreeCallCongratsDialogFragmentArgs();
    bundle.setClassLoader(FreeCallCongratsDialogFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("callType")) {
      String callType;
      callType = bundle.getString("callType");
      __result.arguments.put("callType", callType);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getCallType() {
    return (String) arguments.get("callType");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("callType")) {
      String callType = (String) arguments.get("callType");
      __result.putString("callType", callType);
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
    FreeCallCongratsDialogFragmentArgs that = (FreeCallCongratsDialogFragmentArgs) object;
    if (arguments.containsKey("callType") != that.arguments.containsKey("callType")) {
      return false;
    }
    if (getCallType() != null ? !getCallType().equals(that.getCallType()) : that.getCallType() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCallType() != null ? getCallType().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FreeCallCongratsDialogFragmentArgs{"
        + "callType=" + getCallType()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(FreeCallCongratsDialogFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public FreeCallCongratsDialogFragmentArgs build() {
      FreeCallCongratsDialogFragmentArgs result = new FreeCallCongratsDialogFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setCallType(@Nullable String callType) {
      this.arguments.put("callType", callType);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCallType() {
      return (String) arguments.get("callType");
    }
  }
}
