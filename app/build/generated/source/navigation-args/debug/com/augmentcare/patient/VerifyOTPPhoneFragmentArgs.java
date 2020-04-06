package com.augmentcare.patient;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class VerifyOTPPhoneFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private VerifyOTPPhoneFragmentArgs() {
  }

  private VerifyOTPPhoneFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static VerifyOTPPhoneFragmentArgs fromBundle(@NonNull Bundle bundle) {
    VerifyOTPPhoneFragmentArgs __result = new VerifyOTPPhoneFragmentArgs();
    bundle.setClassLoader(VerifyOTPPhoneFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      __result.arguments.put("phone", phone);
    }
    if (bundle.containsKey("email")) {
      String email;
      email = bundle.getString("email");
      __result.arguments.put("email", email);
    }
    if (bundle.containsKey("userInfo")) {
      UserDataLogin userInfo;
      if (Parcelable.class.isAssignableFrom(UserDataLogin.class) || Serializable.class.isAssignableFrom(UserDataLogin.class)) {
        userInfo = (UserDataLogin) bundle.get("userInfo");
      } else {
        throw new UnsupportedOperationException(UserDataLogin.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("userInfo", userInfo);
    }
    return __result;
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    VerifyOTPPhoneFragmentArgs that = (VerifyOTPPhoneFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getUserInfo() != null ? getUserInfo().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "VerifyOTPPhoneFragmentArgs{"
        + "phone=" + getPhone()
        + ", email=" + getEmail()
        + ", userInfo=" + getUserInfo()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(VerifyOTPPhoneFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public VerifyOTPPhoneFragmentArgs build() {
      VerifyOTPPhoneFragmentArgs result = new VerifyOTPPhoneFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @NonNull
    public Builder setEmail(@Nullable String email) {
      this.arguments.put("email", email);
      return this;
    }

    @NonNull
    public Builder setUserInfo(@Nullable UserDataLogin userInfo) {
      this.arguments.put("userInfo", userInfo);
      return this;
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
  }
}
