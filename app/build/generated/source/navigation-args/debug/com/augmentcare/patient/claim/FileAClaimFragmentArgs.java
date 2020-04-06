package com.augmentcare.patient.claim;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FileAClaimFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FileAClaimFragmentArgs() {
  }

  private FileAClaimFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FileAClaimFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FileAClaimFragmentArgs __result = new FileAClaimFragmentArgs();
    bundle.setClassLoader(FileAClaimFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("availableLimit")) {
      float availableLimit;
      availableLimit = bundle.getFloat("availableLimit");
      __result.arguments.put("availableLimit", availableLimit);
    } else {
      throw new IllegalArgumentException("Required argument \"availableLimit\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public float getAvailableLimit() {
    return (float) arguments.get("availableLimit");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("availableLimit")) {
      float availableLimit = (float) arguments.get("availableLimit");
      __result.putFloat("availableLimit", availableLimit);
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
    FileAClaimFragmentArgs that = (FileAClaimFragmentArgs) object;
    if (arguments.containsKey("availableLimit") != that.arguments.containsKey("availableLimit")) {
      return false;
    }
    if (Float.compare(that.getAvailableLimit(), getAvailableLimit()) != 0) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + Float.floatToIntBits(getAvailableLimit());
    return result;
  }

  @Override
  public String toString() {
    return "FileAClaimFragmentArgs{"
        + "availableLimit=" + getAvailableLimit()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(FileAClaimFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(float availableLimit) {
      this.arguments.put("availableLimit", availableLimit);
    }

    @NonNull
    public FileAClaimFragmentArgs build() {
      FileAClaimFragmentArgs result = new FileAClaimFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setAvailableLimit(float availableLimit) {
      this.arguments.put("availableLimit", availableLimit);
      return this;
    }

    @SuppressWarnings("unchecked")
    public float getAvailableLimit() {
      return (float) arguments.get("availableLimit");
    }
  }
}
