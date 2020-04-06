package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.Sicknotes;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SickNotesFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SickNotesFragmentArgs() {
  }

  private SickNotesFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SickNotesFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SickNotesFragmentArgs __result = new SickNotesFragmentArgs();
    bundle.setClassLoader(SickNotesFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("sickNotes")) {
      Sicknotes sickNotes;
      if (Parcelable.class.isAssignableFrom(Sicknotes.class) || Serializable.class.isAssignableFrom(Sicknotes.class)) {
        sickNotes = (Sicknotes) bundle.get("sickNotes");
      } else {
        throw new UnsupportedOperationException(Sicknotes.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("sickNotes", sickNotes);
    } else {
      throw new IllegalArgumentException("Required argument \"sickNotes\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Sicknotes getSickNotes() {
    return (Sicknotes) arguments.get("sickNotes");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("sickNotes")) {
      Sicknotes sickNotes = (Sicknotes) arguments.get("sickNotes");
      if (Parcelable.class.isAssignableFrom(Sicknotes.class) || sickNotes == null) {
        __result.putParcelable("sickNotes", Parcelable.class.cast(sickNotes));
      } else if (Serializable.class.isAssignableFrom(Sicknotes.class)) {
        __result.putSerializable("sickNotes", Serializable.class.cast(sickNotes));
      } else {
        throw new UnsupportedOperationException(Sicknotes.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    SickNotesFragmentArgs that = (SickNotesFragmentArgs) object;
    if (arguments.containsKey("sickNotes") != that.arguments.containsKey("sickNotes")) {
      return false;
    }
    if (getSickNotes() != null ? !getSickNotes().equals(that.getSickNotes()) : that.getSickNotes() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getSickNotes() != null ? getSickNotes().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SickNotesFragmentArgs{"
        + "sickNotes=" + getSickNotes()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SickNotesFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Sicknotes sickNotes) {
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("sickNotes", sickNotes);
    }

    @NonNull
    public SickNotesFragmentArgs build() {
      SickNotesFragmentArgs result = new SickNotesFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setSickNotes(@NonNull Sicknotes sickNotes) {
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("sickNotes", sickNotes);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Sicknotes getSickNotes() {
      return (Sicknotes) arguments.get("sickNotes");
    }
  }
}
