package com.augmentcare.patient.signup;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PasswordCodeSignupFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PasswordCodeSignupFragmentArgs() {
  }

  private PasswordCodeSignupFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PasswordCodeSignupFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PasswordCodeSignupFragmentArgs __result = new PasswordCodeSignupFragmentArgs();
    bundle.setClassLoader(PasswordCodeSignupFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("employeeCode")) {
      String employeeCode;
      employeeCode = bundle.getString("employeeCode");
      if (employeeCode == null) {
        throw new IllegalArgumentException("Argument \"employeeCode\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("employeeCode", employeeCode);
    } else {
      throw new IllegalArgumentException("Required argument \"employeeCode\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("userLogin")) {
      UserLogin userLogin;
      if (Parcelable.class.isAssignableFrom(UserLogin.class) || Serializable.class.isAssignableFrom(UserLogin.class)) {
        userLogin = (UserLogin) bundle.get("userLogin");
      } else {
        throw new UnsupportedOperationException(UserLogin.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (userLogin == null) {
        throw new IllegalArgumentException("Argument \"userLogin\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("userLogin", userLogin);
    } else {
      throw new IllegalArgumentException("Required argument \"userLogin\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PasswordCodeSignupFragmentArgs that = (PasswordCodeSignupFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getEmployeeCode() != null ? getEmployeeCode().hashCode() : 0);
    result = 31 * result + (getUserLogin() != null ? getUserLogin().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PasswordCodeSignupFragmentArgs{"
        + "employeeCode=" + getEmployeeCode()
        + ", userLogin=" + getUserLogin()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(PasswordCodeSignupFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String employeeCode, @NonNull UserLogin userLogin) {
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
    public PasswordCodeSignupFragmentArgs build() {
      PasswordCodeSignupFragmentArgs result = new PasswordCodeSignupFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setEmployeeCode(@NonNull String employeeCode) {
      if (employeeCode == null) {
        throw new IllegalArgumentException("Argument \"employeeCode\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("employeeCode", employeeCode);
      return this;
    }

    @NonNull
    public Builder setUserLogin(@NonNull UserLogin userLogin) {
      if (userLogin == null) {
        throw new IllegalArgumentException("Argument \"userLogin\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userLogin", userLogin);
      return this;
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
  }
}
