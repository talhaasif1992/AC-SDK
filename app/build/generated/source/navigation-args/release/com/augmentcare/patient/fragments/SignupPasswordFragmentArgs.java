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

public class SignupPasswordFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SignupPasswordFragmentArgs() {
  }

  private SignupPasswordFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SignupPasswordFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SignupPasswordFragmentArgs __result = new SignupPasswordFragmentArgs();
    bundle.setClassLoader(SignupPasswordFragmentArgs.class.getClassLoader());
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
    if (bundle.containsKey("is_google_sign_up")) {
      boolean isGoogleSignUp;
      isGoogleSignUp = bundle.getBoolean("is_google_sign_up");
      __result.arguments.put("is_google_sign_up", isGoogleSignUp);
    }
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
    return __result;
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
  public boolean getIsGoogleSignUp() {
    return (boolean) arguments.get("is_google_sign_up");
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
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("phone")) {
      String phone = (String) arguments.get("phone");
      __result.putString("phone", phone);
    }
    if (arguments.containsKey("email")) {
      String email = (String) arguments.get("email");
      __result.putString("email", email);
    }
    if (arguments.containsKey("is_google_sign_up")) {
      boolean isGoogleSignUp = (boolean) arguments.get("is_google_sign_up");
      __result.putBoolean("is_google_sign_up", isGoogleSignUp);
    }
    if (arguments.containsKey("fName")) {
      String fName = (String) arguments.get("fName");
      __result.putString("fName", fName);
    }
    if (arguments.containsKey("lName")) {
      String lName = (String) arguments.get("lName");
      __result.putString("lName", lName);
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
    SignupPasswordFragmentArgs that = (SignupPasswordFragmentArgs) object;
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
    if (arguments.containsKey("is_google_sign_up") != that.arguments.containsKey("is_google_sign_up")) {
      return false;
    }
    if (getIsGoogleSignUp() != that.getIsGoogleSignUp()) {
      return false;
    }
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getIsGoogleSignUp() ? 1 : 0);
    result = 31 * result + (getFName() != null ? getFName().hashCode() : 0);
    result = 31 * result + (getLName() != null ? getLName().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SignupPasswordFragmentArgs{"
        + "phone=" + getPhone()
        + ", email=" + getEmail()
        + ", isGoogleSignUp=" + getIsGoogleSignUp()
        + ", fName=" + getFName()
        + ", lName=" + getLName()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SignupPasswordFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String phone, @NonNull String email, @NonNull String fName,
        @NonNull String lName) {
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
    }

    @NonNull
    public SignupPasswordFragmentArgs build() {
      SignupPasswordFragmentArgs result = new SignupPasswordFragmentArgs(arguments);
      return result;
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

    @NonNull
    public Builder setIsGoogleSignUp(boolean isGoogleSignUp) {
      this.arguments.put("is_google_sign_up", isGoogleSignUp);
      return this;
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
    public boolean getIsGoogleSignUp() {
      return (boolean) arguments.get("is_google_sign_up");
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
  }
}
