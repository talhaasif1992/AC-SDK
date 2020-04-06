package com.augmentcare.patient.signup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class OTPCodeSignupFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private OTPCodeSignupFragmentArgs() {
  }

  private OTPCodeSignupFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static OTPCodeSignupFragmentArgs fromBundle(@NonNull Bundle bundle) {
    OTPCodeSignupFragmentArgs __result = new OTPCodeSignupFragmentArgs();
    bundle.setClassLoader(OTPCodeSignupFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("password")) {
      String password;
      password = bundle.getString("password");
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("password", password);
    } else {
      throw new IllegalArgumentException("Required argument \"password\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("phone", phone);
    } else {
      throw new IllegalArgumentException("Required argument \"phone\" is missing and does not have an android:defaultValue");
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
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getPassword() {
    return (String) arguments.get("password");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getPhone() {
    return (String) arguments.get("phone");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getEmail() {
    return (String) arguments.get("email");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("password")) {
      String password = (String) arguments.get("password");
      __result.putString("password", password);
    }
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
    OTPCodeSignupFragmentArgs that = (OTPCodeSignupFragmentArgs) object;
    if (arguments.containsKey("password") != that.arguments.containsKey("password")) {
      return false;
    }
    if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null) {
      return false;
    }
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
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OTPCodeSignupFragmentArgs{"
        + "password=" + getPassword()
        + ", phone=" + getPhone()
        + ", email=" + getEmail()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(OTPCodeSignupFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String password, @NonNull String phone, @NonNull String email) {
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
    }

    @NonNull
    public OTPCodeSignupFragmentArgs build() {
      OTPCodeSignupFragmentArgs result = new OTPCodeSignupFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPassword(@NonNull String password) {
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      return this;
    }

    @NonNull
    public Builder setPhone(@NonNull String phone) {
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
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

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPassword() {
      return (String) arguments.get("password");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmail() {
      return (String) arguments.get("email");
    }
  }
}
