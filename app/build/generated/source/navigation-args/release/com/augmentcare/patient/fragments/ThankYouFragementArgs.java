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

public class ThankYouFragementArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ThankYouFragementArgs() {
  }

  private ThankYouFragementArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ThankYouFragementArgs fromBundle(@NonNull Bundle bundle) {
    ThankYouFragementArgs __result = new ThankYouFragementArgs();
    bundle.setClassLoader(ThankYouFragementArgs.class.getClassLoader());
    if (bundle.containsKey("fname")) {
      String fname;
      fname = bundle.getString("fname");
      if (fname == null) {
        throw new IllegalArgumentException("Argument \"fname\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("fname", fname);
    } else {
      throw new IllegalArgumentException("Required argument \"fname\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("lname")) {
      String lname;
      lname = bundle.getString("lname");
      if (lname == null) {
        throw new IllegalArgumentException("Argument \"lname\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("lname", lname);
    } else {
      throw new IllegalArgumentException("Required argument \"lname\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      __result.arguments.put("email", email);
    }
    if (bundle.containsKey("password")) {
      String password;
      password = bundle.getString("password");
      __result.arguments.put("password", password);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getFname() {
    return (String) arguments.get("fname");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getLname() {
    return (String) arguments.get("lname");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getEmail() {
    return (String) arguments.get("email");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPassword() {
    return (String) arguments.get("password");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("fname")) {
      String fname = (String) arguments.get("fname");
      __result.putString("fname", fname);
    }
    if (arguments.containsKey("lname")) {
      String lname = (String) arguments.get("lname");
      __result.putString("lname", lname);
    }
    if (arguments.containsKey("email")) {
      String email = (String) arguments.get("email");
      __result.putString("email", email);
    }
    if (arguments.containsKey("password")) {
      String password = (String) arguments.get("password");
      __result.putString("password", password);
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
    ThankYouFragementArgs that = (ThankYouFragementArgs) object;
    if (arguments.containsKey("fname") != that.arguments.containsKey("fname")) {
      return false;
    }
    if (getFname() != null ? !getFname().equals(that.getFname()) : that.getFname() != null) {
      return false;
    }
    if (arguments.containsKey("lname") != that.arguments.containsKey("lname")) {
      return false;
    }
    if (getLname() != null ? !getLname().equals(that.getLname()) : that.getLname() != null) {
      return false;
    }
    if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
      return false;
    }
    if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
      return false;
    }
    if (arguments.containsKey("password") != that.arguments.containsKey("password")) {
      return false;
    }
    if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getFname() != null ? getFname().hashCode() : 0);
    result = 31 * result + (getLname() != null ? getLname().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ThankYouFragementArgs{"
        + "fname=" + getFname()
        + ", lname=" + getLname()
        + ", email=" + getEmail()
        + ", password=" + getPassword()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ThankYouFragementArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String fname, @NonNull String lname) {
      if (fname == null) {
        throw new IllegalArgumentException("Argument \"fname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fname", fname);
      if (lname == null) {
        throw new IllegalArgumentException("Argument \"lname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lname", lname);
    }

    @NonNull
    public ThankYouFragementArgs build() {
      ThankYouFragementArgs result = new ThankYouFragementArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setFname(@NonNull String fname) {
      if (fname == null) {
        throw new IllegalArgumentException("Argument \"fname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fname", fname);
      return this;
    }

    @NonNull
    public Builder setLname(@NonNull String lname) {
      if (lname == null) {
        throw new IllegalArgumentException("Argument \"lname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lname", lname);
      return this;
    }

    @NonNull
    public Builder setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public Builder setPassword(@Nullable String password) {
      this.arguments.put("password", password);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getFname() {
      return (String) arguments.get("fname");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getLname() {
      return (String) arguments.get("lname");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPassword() {
      return (String) arguments.get("password");
    }
  }
}
