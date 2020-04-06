package com.augmentcare.patient.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorRatingDialogFragDirections {
  private DoctorRatingDialogFragDirections() {
  }

  @NonNull
  public static ActionDoctorRatingDialogFragToAppointmentDetailsFragment actionDoctorRatingDialogFragToAppointmentDetailsFragment(int slotID) {
    return new ActionDoctorRatingDialogFragToAppointmentDetailsFragment(slotID);
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

  public static class ActionDoctorRatingDialogFragToAppointmentDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDoctorRatingDialogFragToAppointmentDetailsFragment(int slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public ActionDoctorRatingDialogFragToAppointmentDetailsFragment setSlotID(int slotID) {
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
      return R.id.action_doctorRatingDialogFrag_to_appointmentDetailsFragment;
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
      ActionDoctorRatingDialogFragToAppointmentDetailsFragment that = (ActionDoctorRatingDialogFragToAppointmentDetailsFragment) object;
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
      return "ActionDoctorRatingDialogFragToAppointmentDetailsFragment(actionId=" + getActionId() + "){"
          + "slotID=" + getSlotID()
          + "}";
    }
  }
}
