package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class EditProfileFragmentDirections {
  private EditProfileFragmentDirections() {
  }

  @NonNull
  public static ActionEditProfileFragmentToVerifyOTPPhoneFragment2 actionEditProfileFragmentToVerifyOTPPhoneFragment2() {
    return new ActionEditProfileFragmentToVerifyOTPPhoneFragment2();
  }

  @NonNull
  public static NavDirections actionGlobalDashboardFragment2() {
    return MainNavigationDirections.actionGlobalDashboardFragment2();
  }

  @NonNull
  public static NavDirections actionGlobalLoginFragment() {
    return MainNavigationDirections.actionGlobalLoginFragment();
  }

  @NonNull
  public static NavDirections actionGlobalSignUpFragment() {
    return MainNavigationDirections.actionGlobalSignUpFragment();
  }

  public static class ActionEditProfileFragmentToVerifyOTPPhoneFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionEditProfileFragmentToVerifyOTPPhoneFragment2() {
    }

    @NonNull
    public ActionEditProfileFragmentToVerifyOTPPhoneFragment2 setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public ActionEditProfileFragmentToVerifyOTPPhoneFragment2 setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public ActionEditProfileFragmentToVerifyOTPPhoneFragment2 setUserInfo(@Nullable UserDataLogin userInfo) {
      this.arguments.put("userInfo", userInfo);
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
      if (arguments.containsKey("userInfo")) {
        UserDataLogin userInfo = (UserDataLogin) arguments.get("userInfo");
        if (Parcelable.class.isAssignableFrom(UserDataLogin.class) || userInfo == null) {
          __result.putParcelable("userInfo", Parcelable.class.cast(userInfo));
        } else if (Serializable.class.isAssignableFrom(UserDataLogin.class)) {
          __result.putSerializable("userInfo", Serializable.class.cast(userInfo));
        } else {
          throw new UnsupportedOperationException(UserDataLogin.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_editProfileFragment_to_verifyOTPPhoneFragment2;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public UserDataLogin getUserInfo() {
      return (UserDataLogin) arguments.get("userInfo");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionEditProfileFragmentToVerifyOTPPhoneFragment2 that = (ActionEditProfileFragmentToVerifyOTPPhoneFragment2) object;
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
      if (arguments.containsKey("userInfo") != that.arguments.containsKey("userInfo")) {
        return false;
      }
      if (getUserInfo() != null ? !getUserInfo().equals(that.getUserInfo()) : that.getUserInfo() != null) {
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
      result = 31 * result + (getUserInfo() != null ? getUserInfo().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionEditProfileFragmentToVerifyOTPPhoneFragment2(actionId=" + getActionId() + "){"
          + "phone=" + getPhone()
          + ", email=" + getEmail()
          + ", userInfo=" + getUserInfo()
          + "}";
    }
  }
}
