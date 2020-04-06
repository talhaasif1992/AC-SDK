package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TutorialFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TutorialFragmentArgs() {
  }

  private TutorialFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TutorialFragmentArgs fromBundle(@NonNull Bundle bundle) {
    TutorialFragmentArgs __result = new TutorialFragmentArgs();
    bundle.setClassLoader(TutorialFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("isEnd")) {
      boolean isEnd;
      isEnd = bundle.getBoolean("isEnd");
      __result.arguments.put("isEnd", isEnd);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public boolean getIsEnd() {
    return (boolean) arguments.get("isEnd");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("isEnd")) {
      boolean isEnd = (boolean) arguments.get("isEnd");
      __result.putBoolean("isEnd", isEnd);
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
    TutorialFragmentArgs that = (TutorialFragmentArgs) object;
    if (arguments.containsKey("isEnd") != that.arguments.containsKey("isEnd")) {
      return false;
    }
    if (getIsEnd() != that.getIsEnd()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getIsEnd() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TutorialFragmentArgs{"
        + "isEnd=" + getIsEnd()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(TutorialFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public TutorialFragmentArgs build() {
      TutorialFragmentArgs result = new TutorialFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setIsEnd(boolean isEnd) {
      this.arguments.put("isEnd", isEnd);
      return this;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsEnd() {
      return (boolean) arguments.get("isEnd");
    }
  }
}
