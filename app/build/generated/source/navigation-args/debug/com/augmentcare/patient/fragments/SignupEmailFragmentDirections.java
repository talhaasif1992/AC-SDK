package com.augmentcare.patient.fragments;

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

public class SignupEmailFragmentDirections {
  private SignupEmailFragmentDirections() {
  }

  @NonNull
  public static ActionSignupEmailFragmentToSignupPasswordFragment actionSignupEmailFragmentToSignupPasswordFragment(@NonNull String phone,
      @NonNull String email, @NonNull String fName, @NonNull String lName) {
    return new ActionSignupEmailFragmentToSignupPasswordFragment(phone, email, fName, lName);
  }

  public static class ActionSignupEmailFragmentToSignupPasswordFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSignupEmailFragmentToSignupPasswordFragment(@NonNull String phone,
        @NonNull String email, @NonNull String fName, @NonNull String lName) {
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
    public ActionSignupEmailFragmentToSignupPasswordFragment setPhone(@NonNull String phone) {
      if (phone == null) {
        throw new IllegalArgumentException("Argument \"phone\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public ActionSignupEmailFragmentToSignupPasswordFragment setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionSignupEmailFragmentToSignupPasswordFragment setIsGoogleSignUp(boolean isGoogleSignUp) {
      this.arguments.put("is_google_sign_up", isGoogleSignUp);
      return this;
    }

    @NonNull
    public ActionSignupEmailFragmentToSignupPasswordFragment setFName(@NonNull String fName) {
      if (fName == null) {
        throw new IllegalArgumentException("Argument \"fName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public ActionSignupEmailFragmentToSignupPasswordFragment setLName(@NonNull String lName) {
      if (lName == null) {
        throw new IllegalArgumentException("Argument \"lName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("lName", lName);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_signupEmailFragment_to_signupPasswordFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSignupEmailFragmentToSignupPasswordFragment that = (ActionSignupEmailFragmentToSignupPasswordFragment) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSignupEmailFragmentToSignupPasswordFragment(actionId=" + getActionId() + "){"
          + "phone=" + getPhone()
          + ", email=" + getEmail()
          + ", isGoogleSignUp=" + getIsGoogleSignUp()
          + ", fName=" + getFName()
          + ", lName=" + getLName()
          + "}";
    }
  }
}
