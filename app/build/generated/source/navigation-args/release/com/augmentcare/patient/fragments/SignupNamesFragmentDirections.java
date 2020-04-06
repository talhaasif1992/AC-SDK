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

public class SignupNamesFragmentDirections {
  private SignupNamesFragmentDirections() {
  }

  @NonNull
  public static ActionSignupNamesFragmentToSignupEmailFragment actionSignupNamesFragmentToSignupEmailFragment(@NonNull String fName,
      @NonNull String lName, @Nullable String email, @Nullable String phone) {
    return new ActionSignupNamesFragmentToSignupEmailFragment(fName, lName, email, phone);
  }

  public static class ActionSignupNamesFragmentToSignupEmailFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSignupNamesFragmentToSignupEmailFragment(@NonNull String fName,
        @NonNull String lName, @Nullable String email, @Nullable String phone) {
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
    public ActionSignupNamesFragmentToSignupEmailFragment setFName(@NonNull String fName) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public ActionSignupNamesFragmentToSignupEmailFragment setLName(@NonNull String lName) {
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      return this;
    }

    @NonNull
    public ActionSignupNamesFragmentToSignupEmailFragment setFromSignupFlow(boolean fromSignupFlow) {
      this.arguments.put("from_signup_flow", fromSignupFlow);
      return this;
    }

    @NonNull
    public ActionSignupNamesFragmentToSignupEmailFragment setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionSignupNamesFragmentToSignupEmailFragment setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
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
    public int getActionId() {
      return R.id.action_signupNamesFragment_to_signupEmailFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSignupNamesFragmentToSignupEmailFragment that = (ActionSignupNamesFragmentToSignupEmailFragment) object;
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
      result = 31 * result + (getFromSignupFlow() ? 1 : 0);
      result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
      result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSignupNamesFragmentToSignupEmailFragment(actionId=" + getActionId() + "){"
          + "fName=" + getFName()
          + ", lName=" + getLName()
          + ", fromSignupFlow=" + getFromSignupFlow()
          + ", email=" + getEmail()
          + ", phone=" + getPhone()
          + "}";
    }
  }
}
