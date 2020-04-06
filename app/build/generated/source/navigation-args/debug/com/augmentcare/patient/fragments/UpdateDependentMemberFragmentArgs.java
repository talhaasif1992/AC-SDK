package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class UpdateDependentMemberFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private UpdateDependentMemberFragmentArgs() {
  }

  private UpdateDependentMemberFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UpdateDependentMemberFragmentArgs fromBundle(@NonNull Bundle bundle) {
    UpdateDependentMemberFragmentArgs __result = new UpdateDependentMemberFragmentArgs();
    bundle.setClassLoader(UpdateDependentMemberFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("dependent")) {
      Dependent dependent;
      if (Parcelable.class.isAssignableFrom(Dependent.class) || Serializable.class.isAssignableFrom(Dependent.class)) {
        dependent = (Dependent) bundle.get("dependent");
      } else {
        throw new UnsupportedOperationException(Dependent.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("dependent", dependent);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Dependent getDependent() {
    return (Dependent) arguments.get("dependent");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("dependent")) {
      Dependent dependent = (Dependent) arguments.get("dependent");
      if (Parcelable.class.isAssignableFrom(Dependent.class) || dependent == null) {
        __result.putParcelable("dependent", Parcelable.class.cast(dependent));
      } else if (Serializable.class.isAssignableFrom(Dependent.class)) {
        __result.putSerializable("dependent", Serializable.class.cast(dependent));
      } else {
        throw new UnsupportedOperationException(Dependent.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    UpdateDependentMemberFragmentArgs that = (UpdateDependentMemberFragmentArgs) object;
    if (arguments.containsKey("dependent") != that.arguments.containsKey("dependent")) {
      return false;
    }
    if (getDependent() != null ? !getDependent().equals(that.getDependent()) : that.getDependent() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDependent() != null ? getDependent().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UpdateDependentMemberFragmentArgs{"
        + "dependent=" + getDependent()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(UpdateDependentMemberFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public UpdateDependentMemberFragmentArgs build() {
      UpdateDependentMemberFragmentArgs result = new UpdateDependentMemberFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDependent(@Nullable Dependent dependent) {
      this.arguments.put("dependent", dependent);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Dependent getDependent() {
      return (Dependent) arguments.get("dependent");
    }
  }
}
