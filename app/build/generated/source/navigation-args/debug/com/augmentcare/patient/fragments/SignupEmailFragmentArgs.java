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

public class SignupEmailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SignupEmailFragmentArgs() {
  }

  private SignupEmailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SignupEmailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SignupEmailFragmentArgs __result = new SignupEmailFragmentArgs();
    bundle.setClassLoader(SignupEmailFragmentArgs.class.getClassLoader());
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
    if (bundle.containsKey("from_signup_flow")) {
      boolean fromSignupFlow;
      fromSignupFlow = bundle.getBoolean("from_signup_flow");
      __result.arguments.put("from_signup_flow", fromSignupFlow);
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      __result.arguments.put("email", email);
    } else {
      throw new IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      __result.arguments.put("phone", phone);
    } else {
      throw new IllegalArgumentException("Required argument \"phone\" is missing and does not have an android:defaultValue");
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
  public boolean getFromSignupFlow() {
    return (boolean) arguments.get("from_signup_flow");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getEmail() {
    return (String) arguments.get("email");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPhone() {
    return (String) arguments.get("phone");
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
    if (arguments.containsKey("from_signup_flow")) {
      boolean fromSignupFlow = (boolean) arguments.get("from_signup_flow");
      __result.putBoolean("from_signup_flow", fromSignupFlow);
    }
    if (arguments.containsKey("email")) {
      String email = (String) arguments.get("email");
      __result.putString("email", email);
    }
    if (arguments.containsKey("phone")) {
      String phone = (String) arguments.get("phone");
      __result.putString("phone", phone);
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
    SignupEmailFragmentArgs that = (SignupEmailFragmentArgs) object;
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
    if (arguments.containsKey("from_signup_flow") != that.arguments.containsKey("from_signup_flow")) {
      return false;
    }
    if (getFromSignupFlow() != that.getFromSignupFlow()) {
      return false;
    }
    if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
      return false;
    }
    if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
      return false;
    }
    if (arguments.containsKey("phone") != that.arguments.containsKey("phone")) {
      return false;
    }
    if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getFName() != null ? getFName().hashCode() : 0);
    result = 31 * result + (getLName() != null ? getLName().hashCode() : 0);
    result = 31 * result + (getFromSignupFlow() ? 1 : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SignupEmailFragmentArgs{"
        + "fName=" + getFName()
        + ", lName=" + getLName()
        + ", fromSignupFlow=" + getFromSignupFlow()
        + ", email=" + getEmail()
        + ", phone=" + getPhone()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SignupEmailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String fName, @NonNull String lName, @Nullable String email,
        @Nullable String phone) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      this.arguments.put("email", email);
      this.arguments.put("phone", phone);
    }

    @NonNull
    public SignupEmailFragmentArgs build() {
      SignupEmailFragmentArgs result = new SignupEmailFragmentArgs(arguments);
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
    public Builder setFromSignupFlow(boolean fromSignupFlow) {
      this.arguments.put("from_signup_flow", fromSignupFlow);
      return this;
    }

    @NonNull
    public Builder setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public Builder setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
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
    public boolean getFromSignupFlow() {
      return (boolean) arguments.get("from_signup_flow");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }
  }
}
