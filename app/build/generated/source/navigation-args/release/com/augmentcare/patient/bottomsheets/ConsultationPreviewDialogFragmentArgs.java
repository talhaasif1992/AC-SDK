package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ConsultationPreviewDialogFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ConsultationPreviewDialogFragmentArgs() {
  }

  private ConsultationPreviewDialogFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ConsultationPreviewDialogFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ConsultationPreviewDialogFragmentArgs __result = new ConsultationPreviewDialogFragmentArgs();
    bundle.setClassLoader(ConsultationPreviewDialogFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("consultation")) {
      Consultation consultation;
      if (Parcelable.class.isAssignableFrom(Consultation.class) || Serializable.class.isAssignableFrom(Consultation.class)) {
        consultation = (Consultation) bundle.get("consultation");
      } else {
        throw new UnsupportedOperationException(Consultation.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("consultation", consultation);
    }
    if (bundle.containsKey("slotID")) {
      String slotID;
      slotID = bundle.getString("slotID");
      __result.arguments.put("slotID", slotID);
    } else {
      throw new IllegalArgumentException("Required argument \"slotID\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("isFromNotificationFragment")) {
      boolean isFromNotificationFragment;
      isFromNotificationFragment = bundle.getBoolean("isFromNotificationFragment");
      __result.arguments.put("isFromNotificationFragment", isFromNotificationFragment);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public Consultation getConsultation() {
    return (Consultation) arguments.get("consultation");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getSlotID() {
    return (String) arguments.get("slotID");
  }

  @SuppressWarnings("unchecked")
  public boolean getIsFromNotificationFragment() {
    return (boolean) arguments.get("isFromNotificationFragment");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("consultation")) {
      Consultation consultation = (Consultation) arguments.get("consultation");
      if (Parcelable.class.isAssignableFrom(Consultation.class) || consultation == null) {
        __result.putParcelable("consultation", Parcelable.class.cast(consultation));
      } else if (Serializable.class.isAssignableFrom(Consultation.class)) {
        __result.putSerializable("consultation", Serializable.class.cast(consultation));
      } else {
        throw new UnsupportedOperationException(Consultation.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    if (arguments.containsKey("slotID")) {
      String slotID = (String) arguments.get("slotID");
      __result.putString("slotID", slotID);
    }
    if (arguments.containsKey("isFromNotificationFragment")) {
      boolean isFromNotificationFragment = (boolean) arguments.get("isFromNotificationFragment");
      __result.putBoolean("isFromNotificationFragment", isFromNotificationFragment);
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
    ConsultationPreviewDialogFragmentArgs that = (ConsultationPreviewDialogFragmentArgs) object;
    if (arguments.containsKey("consultation") != that.arguments.containsKey("consultation")) {
      return false;
    }
    if (getConsultation() != null ? !getConsultation().equals(that.getConsultation()) : that.getConsultation() != null) {
      return false;
    }
    if (arguments.containsKey("slotID") != that.arguments.containsKey("slotID")) {
      return false;
    }
    if (getSlotID() != null ? !getSlotID().equals(that.getSlotID()) : that.getSlotID() != null) {
      return false;
    }
    if (arguments.containsKey("isFromNotificationFragment") != that.arguments.containsKey("isFromNotificationFragment")) {
      return false;
    }
    if (getIsFromNotificationFragment() != that.getIsFromNotificationFragment()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getConsultation() != null ? getConsultation().hashCode() : 0);
    result = 31 * result + (getSlotID() != null ? getSlotID().hashCode() : 0);
    result = 31 * result + (getIsFromNotificationFragment() ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ConsultationPreviewDialogFragmentArgs{"
        + "consultation=" + getConsultation()
        + ", slotID=" + getSlotID()
        + ", isFromNotificationFragment=" + getIsFromNotificationFragment()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ConsultationPreviewDialogFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public ConsultationPreviewDialogFragmentArgs build() {
      ConsultationPreviewDialogFragmentArgs result = new ConsultationPreviewDialogFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setConsultation(@Nullable Consultation consultation) {
      this.arguments.put("consultation", consultation);
      return this;
    }

    @NonNull
    public Builder setSlotID(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
      return this;
    }

    @NonNull
    public Builder setIsFromNotificationFragment(boolean isFromNotificationFragment) {
      this.arguments.put("isFromNotificationFragment", isFromNotificationFragment);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Consultation getConsultation() {
      return (Consultation) arguments.get("consultation");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getSlotID() {
      return (String) arguments.get("slotID");
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromNotificationFragment() {
      return (boolean) arguments.get("isFromNotificationFragment");
    }
  }
}
