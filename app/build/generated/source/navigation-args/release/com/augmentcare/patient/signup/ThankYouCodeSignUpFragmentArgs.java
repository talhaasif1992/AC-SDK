package com.augmentcare.patient.signup;

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

public class ThankYouCodeSignUpFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ThankYouCodeSignUpFragmentArgs() {
  }

  private ThankYouCodeSignUpFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ThankYouCodeSignUpFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ThankYouCodeSignUpFragmentArgs __result = new ThankYouCodeSignUpFragmentArgs();
    bundle.setClassLoader(ThankYouCodeSignUpFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("fName")) {
      String fName;
      fName = bundle.getString("fName");
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("fName", fName);
    } else {
      throw new IllegalArgumentException("Required argument \"fName\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("lName")) {
      String lName;
      lName = bundle.getString("lName");
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("lName", lName);
    } else {
      throw new IllegalArgumentException("Required argument \"lName\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("email", email);
    } else {
      throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
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
  public String getFName() {
    return (String) arguments.get("fName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getLName() {
    return (String) arguments.get("lName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
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
    if (arguments.containsKey("fName")) {
      String fName = (String) arguments.get("fName");
      __result.putString("fName", fName);
    }
    if (arguments.containsKey("lName")) {
      String lName = (String) arguments.get("lName");
      __result.putString("lName", lName);
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
    ThankYouCodeSignUpFragmentArgs that = (ThankYouCodeSignUpFragmentArgs) object;
    if (arguments.containsKey("fName") != that.arguments.containsKey("fName")) {
      return false;
    }
    if (getFName() != null ? !getFName().equals(that.getFName()) : that.getFName() != null) {
      return false;
    }
    if (arguments.containsKey("lName") != that.arguments.containsKey("lName")) {
      return false;
    }
    if (getLName() != null ? !getLName().equals(that.getLName()) : that.getLName() != null) {
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
    result = 31 * result + (getFName() != null ? getFName().hashCode() : 0);
    result = 31 * result + (getLName() != null ? getLName().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ThankYouCodeSignUpFragmentArgs{"
        + "fName=" + getFName()
        + ", lName=" + getLName()
        + ", email=" + getEmail()
        + ", password=" + getPassword()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ThankYouCodeSignUpFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String fName, @NonNull String lName, @NonNull String email) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
    }

    @NonNull
    public ThankYouCodeSignUpFragmentArgs build() {
      ThankYouCodeSignUpFragmentArgs result = new ThankYouCodeSignUpFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setFName(@NonNull String fName) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public Builder setLName(@NonNull String lName) {
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      return this;
    }

    @NonNull
    public Builder setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
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
    public String getFName() {
      return (String) arguments.get("fName");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getLName() {
      return (String) arguments.get("lName");
    }

    @SuppressWarnings("unchecked")
    @NonNull
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
