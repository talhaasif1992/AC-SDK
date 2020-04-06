package com.augmentcare.patient.fragments;

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

public class OTPFragmentDirections {
  private OTPFragmentDirections() {
  }

  @NonNull
  public static ActionOTPFragmentToThankYouFragement actionOTPFragmentToThankYouFragement(@NonNull String fname,
      @NonNull String lname) {
    return new ActionOTPFragmentToThankYouFragement(fname, lname);
  }

  public static class ActionOTPFragmentToThankYouFragement implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionOTPFragmentToThankYouFragement(@NonNull String fname, @NonNull String lname) {
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
    public ActionOTPFragmentToThankYouFragement setFname(@NonNull String fname) {
      if (fname == null) {
        throw new IllegalArgumentException("Argument \"fname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fname", fname);
      return this;
    }

    @NonNull
    public ActionOTPFragmentToThankYouFragement setLname(@NonNull String lname) {
      if (lname == null) {
        throw new IllegalArgumentException("Argument \"lname\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lname", lname);
      return this;
    }

    @NonNull
    public ActionOTPFragmentToThankYouFragement setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionOTPFragmentToThankYouFragement setPassword(@Nullable String password) {
      this.arguments.put("password", password);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_OTPFragment_to_thankYouFragement;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionOTPFragmentToThankYouFragement that = (ActionOTPFragmentToThankYouFragement) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionOTPFragmentToThankYouFragement(actionId=" + getActionId() + "){"
          + "fname=" + getFname()
          + ", lname=" + getLname()
          + ", email=" + getEmail()
          + ", password=" + getPassword()
          + "}";
    }
  }
}
