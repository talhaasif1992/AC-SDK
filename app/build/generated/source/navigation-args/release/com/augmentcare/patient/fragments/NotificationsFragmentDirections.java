package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.Consultation;
import com.augmentcare.patient.network.restApi.apimodels.Sicknotes;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NotificationsFragmentDirections {
  private NotificationsFragmentDirections() {
  }

  @NonNull
  public static ActionNotificationsFragmentToSickNotesFragment2 actionNotificationsFragmentToSickNotesFragment2(@NonNull Sicknotes sickNotes) {
    return new ActionNotificationsFragmentToSickNotesFragment2(sickNotes);
  }

  @NonNull
  public static ActionNotificationsFragmentToConsultationPreviewDialogFragment actionNotificationsFragmentToConsultationPreviewDialogFragment(@Nullable String slotID) {
    return new ActionNotificationsFragmentToConsultationPreviewDialogFragment(slotID);
  }

  @NonNull
  public static NavDirections actionNotificationsFragmentToChatActivity() {
    return new ActionOnlyNavDirections(R.id.action_NotificationsFragment_to_chatActivity);
  }

  @NonNull
  public static ActionNotificationsFragmentToAppointmentDetailsFragment actionNotificationsFragmentToAppointmentDetailsFragment(int slotID) {
    return new ActionNotificationsFragmentToAppointmentDetailsFragment(slotID);
  }

  @NonNull
  public static NavDirections actionNotificationsFragmentToMyClaimsFragment() {
    return new ActionOnlyNavDirections(R.id.action_NotificationsFragment_to_myClaimsFragment);
  }

  @NonNull
  public static NavDirections actionNotificationsFragmentToDependentFragment() {
    return new ActionOnlyNavDirections(R.id.action_NotificationsFragment_to_dependentFragment);
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

  public static class ActionNotificationsFragmentToSickNotesFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNotificationsFragmentToSickNotesFragment2(@NonNull Sicknotes sickNotes) {
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("sickNotes", sickNotes);
    }

    @NonNull
    public ActionNotificationsFragmentToSickNotesFragment2 setSickNotes(@NonNull Sicknotes sickNotes) {
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("sickNotes", sickNotes);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_NotificationsFragment_to_sickNotesFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Sicknotes getSickNotes() {
      return (Sicknotes) arguments.get("sickNotes");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNotificationsFragmentToSickNotesFragment2 that = (ActionNotificationsFragmentToSickNotesFragment2) object;
      if (arguments.containsKey("sickNotes") != that.arguments.containsKey("sickNotes")) {
        return false;
      }
      if (getSickNotes() != null ? !getSickNotes().equals(that.getSickNotes()) : that.getSickNotes() != null) {
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
      result = 31 * result + (getSickNotes() != null ? getSickNotes().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNotificationsFragmentToSickNotesFragment2(actionId=" + getActionId() + "){"
          + "sickNotes=" + getSickNotes()
          + "}";
    }
  }

  public static class ActionNotificationsFragmentToConsultationPreviewDialogFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNotificationsFragmentToConsultationPreviewDialogFragment(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public ActionNotificationsFragmentToConsultationPreviewDialogFragment setConsultation(@Nullable Consultation consultation) {
      this.arguments.put("consultation", consultation);
      return this;
    }

    @NonNull
    public ActionNotificationsFragmentToConsultationPreviewDialogFragment setSlotID(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
      return this;
    }

    @NonNull
    public ActionNotificationsFragmentToConsultationPreviewDialogFragment setIsFromNotificationFragment(boolean isFromNotificationFragment) {
      this.arguments.put("isFromNotificationFragment", isFromNotificationFragment);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_NotificationsFragment_to_consultationPreviewDialogFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNotificationsFragmentToConsultationPreviewDialogFragment that = (ActionNotificationsFragmentToConsultationPreviewDialogFragment) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNotificationsFragmentToConsultationPreviewDialogFragment(actionId=" + getActionId() + "){"
          + "consultation=" + getConsultation()
          + ", slotID=" + getSlotID()
          + ", isFromNotificationFragment=" + getIsFromNotificationFragment()
          + "}";
    }
  }

  public static class ActionNotificationsFragmentToAppointmentDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNotificationsFragmentToAppointmentDetailsFragment(int slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public ActionNotificationsFragmentToAppointmentDetailsFragment setSlotID(int slotID) {
      this.arguments.put("slotID", slotID);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("slotID")) {
        int slotID = (int) arguments.get("slotID");
        __result.putInt("slotID", slotID);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_NotificationsFragment_to_appointmentDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    public int getSlotID() {
      return (int) arguments.get("slotID");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNotificationsFragmentToAppointmentDetailsFragment that = (ActionNotificationsFragmentToAppointmentDetailsFragment) object;
      if (arguments.containsKey("slotID") != that.arguments.containsKey("slotID")) {
        return false;
      }
      if (getSlotID() != that.getSlotID()) {
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
      result = 31 * result + getSlotID();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNotificationsFragmentToAppointmentDetailsFragment(actionId=" + getActionId() + "){"
          + "slotID=" + getSlotID()
          + "}";
    }
  }
}
