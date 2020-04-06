package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DependentFragmentDirections {
  private DependentFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDependentFragmentToAddDependentMemberFragment() {
    return new ActionOnlyNavDirections(R.id.action_dependentFragment_to_addDependentMemberFragment);
  }

  @NonNull
  public static ActionDependentFragmentToUpdateDependentMemberFragment actionDependentFragmentToUpdateDependentMemberFragment() {
    return new ActionDependentFragmentToUpdateDependentMemberFragment();
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

  public static class ActionDependentFragmentToUpdateDependentMemberFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDependentFragmentToUpdateDependentMemberFragment() {
    }

    @NonNull
    public ActionDependentFragmentToUpdateDependentMemberFragment setDependent(@Nullable Dependent dependent) {
      this.arguments.put("dependent", dependent);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_dependentFragment_to_updateDependentMemberFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Dependent getDependent() {
      return (Dependent) arguments.get("dependent");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionDependentFragmentToUpdateDependentMemberFragment that = (ActionDependentFragmentToUpdateDependentMemberFragment) object;
      if (arguments.containsKey("dependent") != that.arguments.containsKey("dependent")) {
        return false;
      }
      if (getDependent() != null ? !getDependent().equals(that.getDependent()) : that.getDependent() != null) {
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
      result = 31 * result + (getDependent() != null ? getDependent().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionDependentFragmentToUpdateDependentMemberFragment(actionId=" + getActionId() + "){"
          + "dependent=" + getDependent()
          + "}";
    }
  }
}
