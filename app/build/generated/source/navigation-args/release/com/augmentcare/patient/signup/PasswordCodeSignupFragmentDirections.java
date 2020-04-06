package com.augmentcare.patient.signup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PasswordCodeSignupFragmentDirections {
  private PasswordCodeSignupFragmentDirections() {
  }

  @NonNull
  public static ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment actionPasswordCodeSignupFragmentToOTPCodeSignupFragment(@NonNull String password,
      @NonNull String phone, @NonNull String email) {
    return new ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment(password, phone, email);
  }

  public static class ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment(@NonNull String password,
        @NonNull String phone, @NonNull String email) {
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
    public ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment setPassword(@NonNull String password) {
      if (password == null) {
        throw new IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("password", password);
      return this;
    }

    @NonNull
    public ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment setPhone(@NonNull String phone) {
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_passwordCodeSignupFragment_to_OTPCodeSignupFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment that = (ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPasswordCodeSignupFragmentToOTPCodeSignupFragment(actionId=" + getActionId() + "){"
          + "password=" + getPassword()
          + ", phone=" + getPhone()
          + ", email=" + getEmail()
          + "}";
    }
  }
}
