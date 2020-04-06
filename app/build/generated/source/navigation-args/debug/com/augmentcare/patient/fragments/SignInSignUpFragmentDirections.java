package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SignInSignUpFragmentDirections {
  private SignInSignUpFragmentDirections() {
  }

  @NonNull
  public static ActionSignInSignUpActivityToUpdateFragment actionSignInSignUpActivityToUpdateFragment(@NonNull String htmltext) {
    return new ActionSignInSignUpActivityToUpdateFragment(htmltext);
  }

  @NonNull
  public static NavDirections actionSignInSignUpActivityToSignUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_signInSignUpActivity_to_signUpFragment);
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

  public static class ActionSignInSignUpActivityToUpdateFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSignInSignUpActivityToUpdateFragment(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
    }

    @NonNull
    public ActionSignInSignUpActivityToUpdateFragment setHtmltext(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
      return this;
    }

    @NonNull
    public ActionSignInSignUpActivityToUpdateFragment setEnforced(boolean enforced) {
      this.arguments.put("enforced", enforced);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("htmltext")) {
        String htmltext = (String) arguments.get("htmltext");
        __result.putString("htmltext", htmltext);
      }
      if (arguments.containsKey("enforced")) {
        boolean enforced = (boolean) arguments.get("enforced");
        __result.putBoolean("enforced", enforced);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_signInSignUpActivity_to_updateFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getHtmltext() {
      return (String) arguments.get("htmltext");
    }

    @SuppressWarnings("unchecked")
    public boolean getEnforced() {
      return (boolean) arguments.get("enforced");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSignInSignUpActivityToUpdateFragment that = (ActionSignInSignUpActivityToUpdateFragment) object;
      if (arguments.containsKey("htmltext") != that.arguments.containsKey("htmltext")) {
        return false;
      }
      if (getHtmltext() != null ? !getHtmltext().equals(that.getHtmltext()) : that.getHtmltext() != null) {
        return false;
      }
      if (arguments.containsKey("enforced") != that.arguments.containsKey("enforced")) {
        return false;
      }
      if (getEnforced() != that.getEnforced()) {
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
      result = 31 * result + (getHtmltext() != null ? getHtmltext().hashCode() : 0);
      result = 31 * result + (getEnforced() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSignInSignUpActivityToUpdateFragment(actionId=" + getActionId() + "){"
          + "htmltext=" + getHtmltext()
          + ", enforced=" + getEnforced()
          + "}";
    }
  }
}
