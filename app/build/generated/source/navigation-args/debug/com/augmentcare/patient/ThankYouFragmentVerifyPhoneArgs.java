package com.augmentcare.patient;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ThankYouFragmentVerifyPhoneArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ThankYouFragmentVerifyPhoneArgs() {
  }

  private ThankYouFragmentVerifyPhoneArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ThankYouFragmentVerifyPhoneArgs fromBundle(@NonNull Bundle bundle) {
    ThankYouFragmentVerifyPhoneArgs __result = new ThankYouFragmentVerifyPhoneArgs();
    bundle.setClassLoader(ThankYouFragmentVerifyPhoneArgs.class.getClassLoader());
    if (bundle.containsKey("fName")) {
      String fName;
      fName = bundle.getString("fName");
      __result.arguments.put("fName", fName);
    }
    if (bundle.containsKey("lName")) {
      String lName;
      lName = bundle.getString("lName");
      __result.arguments.put("lName", lName);
    }
    if (bundle.containsKey("phone")) {
      String phone;
      phone = bundle.getString("phone");
      __result.arguments.put("phone", phone);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getFName() {
    return (String) arguments.get("fName");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getLName() {
    return (String) arguments.get("lName");
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
    ThankYouFragmentVerifyPhoneArgs that = (ThankYouFragmentVerifyPhoneArgs) object;
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
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ThankYouFragmentVerifyPhoneArgs{"
        + "fName=" + getFName()
        + ", lName=" + getLName()
        + ", phone=" + getPhone()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ThankYouFragmentVerifyPhoneArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ThankYouFragmentVerifyPhoneArgs build() {
      ThankYouFragmentVerifyPhoneArgs result = new ThankYouFragmentVerifyPhoneArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setFName(@Nullable String fName) {
      this.arguments.put("fName", fName);
      return this;
    }

    @NonNull
    public Builder setLName(@Nullable String lName) {
      this.arguments.put("lName", lName);
      return this;
    }

    @NonNull
    public Builder setPhone(@Nullable String phone) {
      this.arguments.put("phone", phone);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getFName() {
      return (String) arguments.get("fName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getLName() {
      return (String) arguments.get("lName");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPhone() {
      return (String) arguments.get("phone");
    }
  }
}
