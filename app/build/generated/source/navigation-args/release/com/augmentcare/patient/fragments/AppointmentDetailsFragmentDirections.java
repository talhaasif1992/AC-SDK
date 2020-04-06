package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.Sicknotes;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AppointmentDetailsFragmentDirections {
  private AppointmentDetailsFragmentDirections() {
  }

  @NonNull
  public static ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag actionAppointmentDetailsFragmentToDoctorRatingDialogFrag(@NonNull String appointmentDateTime,
      @NonNull String slotID, @NonNull String doctorName, @NonNull String doctorPic) {
    return new ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag(appointmentDateTime, slotID, doctorName, doctorPic);
  }

  @NonNull
  public static ActionAppointmentDetailsFragmentToSickNotesFragment2 actionAppointmentDetailsFragmentToSickNotesFragment2(@NonNull Sicknotes sickNotes) {
    return new ActionAppointmentDetailsFragmentToSickNotesFragment2(sickNotes);
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

  public static class ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag(@NonNull String appointmentDateTime,
        @NonNull String slotID, @NonNull String doctorName, @NonNull String doctorPic) {
      if (appointmentDateTime == null) {
        throw new IllegalArgumentException("Argument \"appointmentDateTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("appointmentDateTime", appointmentDateTime);
      if (slotID == null) {
        throw new IllegalArgumentException("Argument \"slotID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("slotID", slotID);
      if (doctorName == null) {
        throw new IllegalArgumentException("Argument \"doctorName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorName", doctorName);
      if (doctorPic == null) {
        throw new IllegalArgumentException("Argument \"doctorPic\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorPic", doctorPic);
    }

    @NonNull
    public ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag setAppointmentDateTime(@NonNull String appointmentDateTime) {
      if (appointmentDateTime == null) {
        throw new IllegalArgumentException("Argument \"appointmentDateTime\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("appointmentDateTime", appointmentDateTime);
      return this;
    }

    @NonNull
    public ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag setSlotID(@NonNull String slotID) {
      if (slotID == null) {
        throw new IllegalArgumentException("Argument \"slotID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("slotID", slotID);
      return this;
    }

    @NonNull
    public ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag setDoctorName(@NonNull String doctorName) {
      if (doctorName == null) {
        throw new IllegalArgumentException("Argument \"doctorName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorName", doctorName);
      return this;
    }

    @NonNull
    public ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag setDoctorPic(@NonNull String doctorPic) {
      if (doctorPic == null) {
        throw new IllegalArgumentException("Argument \"doctorPic\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorPic", doctorPic);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("appointmentDateTime")) {
        String appointmentDateTime = (String) arguments.get("appointmentDateTime");
        __result.putString("appointmentDateTime", appointmentDateTime);
      }
      if (arguments.containsKey("slotID")) {
        String slotID = (String) arguments.get("slotID");
        __result.putString("slotID", slotID);
      }
      if (arguments.containsKey("doctorName")) {
        String doctorName = (String) arguments.get("doctorName");
        __result.putString("doctorName", doctorName);
      }
      if (arguments.containsKey("doctorPic")) {
        String doctorPic = (String) arguments.get("doctorPic");
        __result.putString("doctorPic", doctorPic);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_appointmentDetailsFragment_to_doctorRatingDialogFrag;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getAppointmentDateTime() {
      return (String) arguments.get("appointmentDateTime");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getSlotID() {
      return (String) arguments.get("slotID");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorName() {
      return (String) arguments.get("doctorName");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorPic() {
      return (String) arguments.get("doctorPic");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag that = (ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag) object;
      if (arguments.containsKey("appointmentDateTime") != that.arguments.containsKey("appointmentDateTime")) {
        return false;
      }
      if (getAppointmentDateTime() != null ? !getAppointmentDateTime().equals(that.getAppointmentDateTime()) : that.getAppointmentDateTime() != null) {
        return false;
      }
      if (arguments.containsKey("slotID") != that.arguments.containsKey("slotID")) {
        return false;
      }
      if (getSlotID() != null ? !getSlotID().equals(that.getSlotID()) : that.getSlotID() != null) {
        return false;
      }
      if (arguments.containsKey("doctorName") != that.arguments.containsKey("doctorName")) {
        return false;
      }
      if (getDoctorName() != null ? !getDoctorName().equals(that.getDoctorName()) : that.getDoctorName() != null) {
        return false;
      }
      if (arguments.containsKey("doctorPic") != that.arguments.containsKey("doctorPic")) {
        return false;
      }
      if (getDoctorPic() != null ? !getDoctorPic().equals(that.getDoctorPic()) : that.getDoctorPic() != null) {
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
      result = 31 * result + (getAppointmentDateTime() != null ? getAppointmentDateTime().hashCode() : 0);
      result = 31 * result + (getSlotID() != null ? getSlotID().hashCode() : 0);
      result = 31 * result + (getDoctorName() != null ? getDoctorName().hashCode() : 0);
      result = 31 * result + (getDoctorPic() != null ? getDoctorPic().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAppointmentDetailsFragmentToDoctorRatingDialogFrag(actionId=" + getActionId() + "){"
          + "appointmentDateTime=" + getAppointmentDateTime()
          + ", slotID=" + getSlotID()
          + ", doctorName=" + getDoctorName()
          + ", doctorPic=" + getDoctorPic()
          + "}";
    }
  }

  public static class ActionAppointmentDetailsFragmentToSickNotesFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAppointmentDetailsFragmentToSickNotesFragment2(@NonNull Sicknotes sickNotes) {
      if (sickNotes == null) {
        throw new IllegalArgumentException("Argument \"sickNotes\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("sickNotes", sickNotes);
    }

    @NonNull
    public ActionAppointmentDetailsFragmentToSickNotesFragment2 setSickNotes(@NonNull Sicknotes sickNotes) {
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
      return R.id.action_appointmentDetailsFragment_to_sickNotesFragment2;
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
      ActionAppointmentDetailsFragmentToSickNotesFragment2 that = (ActionAppointmentDetailsFragmentToSickNotesFragment2) object;
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
      return "ActionAppointmentDetailsFragmentToSickNotesFragment2(actionId=" + getActionId() + "){"
          + "sickNotes=" + getSickNotes()
          + "}";
    }
  }
}
