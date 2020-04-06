package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CardSelectionDialogueArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CardSelectionDialogueArgs() {
  }

  private CardSelectionDialogueArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CardSelectionDialogueArgs fromBundle(@NonNull Bundle bundle) {
    CardSelectionDialogueArgs __result = new CardSelectionDialogueArgs();
    bundle.setClassLoader(CardSelectionDialogueArgs.class.getClassLoader());
    if (bundle.containsKey("planId")) {
      String planId;
      planId = bundle.getString("planId");
      __result.arguments.put("planId", planId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPlanId() {
    return (String) arguments.get("planId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("planId")) {
      String planId = (String) arguments.get("planId");
      __result.putString("planId", planId);
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
    CardSelectionDialogueArgs that = (CardSelectionDialogueArgs) object;
    if (arguments.containsKey("planId") != that.arguments.containsKey("planId")) {
      return false;
    }
    if (getPlanId() != null ? !getPlanId().equals(that.getPlanId()) : that.getPlanId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPlanId() != null ? getPlanId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CardSelectionDialogueArgs{"
        + "planId=" + getPlanId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CardSelectionDialogueArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CardSelectionDialogueArgs build() {
      CardSelectionDialogueArgs result = new CardSelectionDialogueArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPlanId(@Nullable String planId) {
      this.arguments.put("planId", planId);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPlanId() {
      return (String) arguments.get("planId");
    }
  }
}
