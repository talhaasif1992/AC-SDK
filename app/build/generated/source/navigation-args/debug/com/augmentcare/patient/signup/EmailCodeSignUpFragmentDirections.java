package com.augmentcare.patient.signup;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class EmailCodeSignUpFragmentDirections {
  private EmailCodeSignUpFragmentDirections() {
  }

  @NonNull
  public static ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment actionEmailCodeSignUpFragmentToPasswordCodeSignupFragment(@NonNull String employeeCode,
      @NonNull UserLogin userLogin) {
    return new ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment(employeeCode, userLogin);
  }

  public static class ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment(@NonNull String employeeCode,
        @NonNull UserLogin userLogin) {
      if (employeeCode == null) {
        throw new IllegalArgumentException("Argument \"employeeCode\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("employeeCode", employeeCode);
      if (userLogin == null) {
        throw new IllegalArgumentException("Argument \"userLogin\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userLogin", userLogin);
    }

    @NonNull
    public ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment setEmployeeCode(@NonNull String employeeCode) {
      if (employeeCode == null) {
        throw new IllegalArgumentException("Argument \"employeeCode\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("employeeCode", employeeCode);
      return this;
    }

    @NonNull
    public ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment setUserLogin(@NonNull UserLogin userLogin) {
      if (userLogin == null) {
        throw new IllegalArgumentException("Argument \"userLogin\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userLogin", userLogin);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("employeeCode")) {
        String employeeCode = (String) arguments.get("employeeCode");
        __result.putString("employeeCode", employeeCode);
      }
      if (arguments.containsKey("userLogin")) {
        UserLogin userLogin = (UserLogin) arguments.get("userLogin");
        if (Parcelable.class.isAssignableFrom(UserLogin.class) || userLogin == null) {
          __result.putParcelable("userLogin", Parcelable.class.cast(userLogin));
        } else if (Serializable.class.isAssignableFrom(UserLogin.class)) {
          __result.putSerializable("userLogin", Serializable.class.cast(userLogin));
        } else {
          throw new UnsupportedOperationException(UserLogin.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_emailCodeSignUpFragment_to_passwordCodeSignupFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmployeeCode() {
      return (String) arguments.get("employeeCode");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public UserLogin getUserLogin() {
      return (UserLogin) arguments.get("userLogin");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment that = (ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment) object;
      if (arguments.containsKey("employeeCode") != that.arguments.containsKey("employeeCode")) {
        return false;
      }
      if (getEmployeeCode() != null ? !getEmployeeCode().equals(that.getEmployeeCode()) : that.getEmployeeCode() != null) {
        return false;
      }
      if (arguments.containsKey("userLogin") != that.arguments.containsKey("userLogin")) {
        return false;
      }
      if (getUserLogin() != null ? !getUserLogin().equals(that.getUserLogin()) : that.getUserLogin() != null) {
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
      result = 31 * result + (getEmployeeCode() != null ? getEmployeeCode().hashCode() : 0);
      result = 31 * result + (getUserLogin() != null ? getUserLogin().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionEmailCodeSignUpFragmentToPasswordCodeSignupFragment(actionId=" + getActionId() + "){"
          + "employeeCode=" + getEmployeeCode()
          + ", userLogin=" + getUserLogin()
          + "}";
    }
  }
}
