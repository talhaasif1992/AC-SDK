package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SplashFragmentDirections {
  private SplashFragmentDirections() {
  }

  @NonNull
  public static ActionSplashFragmentToTutorialFragment actionSplashFragmentToTutorialFragment() {
    return new ActionSplashFragmentToTutorialFragment();
  }

  @NonNull
  public static ActionSplashFragmentToUpdateFragment actionSplashFragmentToUpdateFragment(@NonNull String htmltext) {
    return new ActionSplashFragmentToUpdateFragment(htmltext);
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

  public static class ActionSplashFragmentToTutorialFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSplashFragmentToTutorialFragment() {
    }

    @NonNull
    public ActionSplashFragmentToTutorialFragment setIsEnd(boolean isEnd) {
      this.arguments.put("isEnd", isEnd);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("isEnd")) {
        boolean isEnd = (boolean) arguments.get("isEnd");
        __result.putBoolean("isEnd", isEnd);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_splashFragment_to_tutorialFragment;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsEnd() {
      return (boolean) arguments.get("isEnd");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSplashFragmentToTutorialFragment that = (ActionSplashFragmentToTutorialFragment) object;
      if (arguments.containsKey("isEnd") != that.arguments.containsKey("isEnd")) {
        return false;
      }
      if (getIsEnd() != that.getIsEnd()) {
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
      result = 31 * result + (getIsEnd() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSplashFragmentToTutorialFragment(actionId=" + getActionId() + "){"
          + "isEnd=" + getIsEnd()
          + "}";
    }
  }

  public static class ActionSplashFragmentToUpdateFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSplashFragmentToUpdateFragment(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
    }

    @NonNull
    public ActionSplashFragmentToUpdateFragment setHtmltext(@NonNull String htmltext) {
      if (htmltext == null) {
        throw new IllegalArgumentException("Argument \"htmltext\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("htmltext", htmltext);
      return this;
    }

    @NonNull
    public ActionSplashFragmentToUpdateFragment setEnforced(boolean enforced) {
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
      return R.id.action_splashFragment_to_updateFragment;
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
      ActionSplashFragmentToUpdateFragment that = (ActionSplashFragmentToUpdateFragment) object;
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
      return "ActionSplashFragmentToUpdateFragment(actionId=" + getActionId() + "){"
          + "htmltext=" + getHtmltext()
          + ", enforced=" + getEnforced()
          + "}";
    }
  }
}
