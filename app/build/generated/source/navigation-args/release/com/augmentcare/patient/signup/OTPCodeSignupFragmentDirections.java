package com.augmentcare.patient.signup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class OTPCodeSignupFragmentDirections {
  private OTPCodeSignupFragmentDirections() {
  }

  @NonNull
  public static ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement actionOTPCodeSignupFragmentToThankYouCodeSignUpFragement(@NonNull String fName,
      @NonNull String lName, @NonNull String email) {
    return new ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement(fName, lName, email);
  }

  public static class ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement(@NonNull String fName,
        @NonNull String lName, @NonNull String email) {
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
    public ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement setFName(@NonNull String fName) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement setLName(@NonNull String lName) {
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      return this;
    }

    @NonNull
    public ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement setPassword(@Nullable String password) {
      this.arguments.put("password", password);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_OTPCodeSignupFragment_to_thankYouCodeSignUpFragement;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement that = (ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionOTPCodeSignupFragmentToThankYouCodeSignUpFragement(actionId=" + getActionId() + "){"
          + "fName=" + getFName()
          + ", lName=" + getLName()
          + ", email=" + getEmail()
          + ", password=" + getPassword()
          + "}";
    }
  }
}
