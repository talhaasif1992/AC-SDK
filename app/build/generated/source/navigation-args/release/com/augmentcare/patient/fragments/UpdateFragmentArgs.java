package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class UpdateFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private UpdateFragmentArgs() {
  }

  private UpdateFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UpdateFragmentArgs fromBundle(@NonNull Bundle bundle) {
    UpdateFragmentArgs __result = new UpdateFragmentArgs();
    bundle.setClassLoader(UpdateFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("htmltext")) {
      String htmltext;
      htmltext = bundle.getString("htmltext");
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("htmltext", htmltext);
    } else {
      throw new IllegalArgumentException("Required argument \"htmltext\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("enforced")) {
      boolean enforced;
      enforced = bundle.getBoolean("enforced");
      __result.arguments.put("enforced", enforced);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getHtmltext() {
    return (String) arguments.get("htmltext");
  }

  @SuppressWarnings("unchecked")
  public boolean getEnforced() {
    return (boolean) arguments.get("enforced");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("htmltext")) {
      String htmltext = (String) arguments.get("htmltext");
      __result.putString("htmltext", htmltext);
    }
    if (arguments.containsKey("enforced")) {
      boolean enforced = (boolean) arguments.get("enforced");
      __result.putBoolean("enforced", enforced);
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
    UpdateFragmentArgs that = (UpdateFragmentArgs) object;
    if (arguments.containsKey("htmltext") != that.arguments.containsKey("htmltext")) {
      return false;
    }
    if (getHtmltext() != null ? !getHtmltext().equals(that.getHtmltext()) : that.getHtmltext() != null) {
      return false;
    }
    if (arguments.containsKey("enforced") != that.arguments.containsKey("enforced")) {
      return false;
    }
    if (getEnforced() != that.getEnforced()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getHtmltext() != null ? getHtmltext().hashCode() : 0);
    result = 31 * result + (getEnforced() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UpdateFragmentArgs{"
        + "htmltext=" + getHtmltext()
        + ", enforced=" + getEnforced()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(UpdateFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
    }

    @NonNull
    public UpdateFragmentArgs build() {
      UpdateFragmentArgs result = new UpdateFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setHtmltext(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
      return this;
    }

    @NonNull
    public Builder setEnforced(boolean enforced) {
      this.arguments.put("enforced", enforced);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getHtmltext() {
      return (String) arguments.get("htmltext");
    }

    @SuppressWarnings("unchecked")
    public boolean getEnforced() {
      return (boolean) arguments.get("enforced");
    }
  }
}
