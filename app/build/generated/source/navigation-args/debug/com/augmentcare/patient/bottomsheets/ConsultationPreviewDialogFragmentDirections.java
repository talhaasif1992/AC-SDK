package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.augmentcare.patient.MainNavigationDirections;
import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ConsultationPreviewDialogFragmentDirections {
  private ConsultationPreviewDialogFragmentDirections() {
  }

  @NonNull
  public static ActionConsultationPreviewFragmentToDoctorProfileFragment actionConsultationPreviewFragmentToDoctorProfileFragment(@NonNull String doctorID) {
    return new ActionConsultationPreviewFragmentToDoctorProfileFragment(doctorID);
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

  public static class ActionConsultationPreviewFragmentToDoctorProfileFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionConsultationPreviewFragmentToDoctorProfileFragment(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
    }

    @NonNull
    public ActionConsultationPreviewFragmentToDoctorProfileFragment setDoctorID(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public ActionConsultationPreviewFragmentToDoctorProfileFragment setShowBookAppointmentBtn(boolean showBookAppointmentBtn) {
      this.arguments.put("show_book_appointment_btn", showBookAppointmentBtn);
      return this;
    }

    @NonNull
    public ActionConsultationPreviewFragmentToDoctorProfileFragment setDoctor(@Nullable DoctorInfoLimited doctor) {
      this.arguments.put("doctor", doctor);
      return this;
    }

    @NonNull
    public ActionConsultationPreviewFragmentToDoctorProfileFragment setInstantDoctor(@NonNull String instantDoctor) {
      if (instantDoctor == null) {
        throw new IllegalArgumentException("Argument \"instantDoctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("instantDoctor", instantDoctor);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("doctorID")) {
        String doctorID = (String) arguments.get("doctorID");
        __result.putString("doctorID", doctorID);
      }
      if (arguments.containsKey("show_book_appointment_btn")) {
        boolean showBookAppointmentBtn = (boolean) arguments.get("show_book_appointment_btn");
        __result.putBoolean("show_book_appointment_btn", showBookAppointmentBtn);
      }
      if (arguments.containsKey("doctor")) {
        DoctorInfoLimited doctor = (DoctorInfoLimited) arguments.get("doctor");
        if (Parcelable.class.isAssignableFrom(DoctorInfoLimited.class) || doctor == null) {
          __result.putParcelable("doctor", Parcelable.class.cast(doctor));
        } else if (Serializable.class.isAssignableFrom(DoctorInfoLimited.class)) {
          __result.putSerializable("doctor", Serializable.class.cast(doctor));
        } else {
          throw new UnsupportedOperationException(DoctorInfoLimited.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      if (arguments.containsKey("instantDoctor")) {
        String instantDoctor = (String) arguments.get("instantDoctor");
        __result.putString("instantDoctor", instantDoctor);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_consultationPreviewFragment_to_doctorProfileFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDoctorID() {
      return (String) arguments.get("doctorID");
    }

    @SuppressWarnings("unchecked")
    public boolean getShowBookAppointmentBtn() {
      return (boolean) arguments.get("show_book_appointment_btn");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public DoctorInfoLimited getDoctor() {
      return (DoctorInfoLimited) arguments.get("doctor");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getInstantDoctor() {
      return (String) arguments.get("instantDoctor");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionConsultationPreviewFragmentToDoctorProfileFragment that = (ActionConsultationPreviewFragmentToDoctorProfileFragment) object;
      if (arguments.containsKey("doctorID") != that.arguments.containsKey("doctorID")) {
        return false;
      }
      if (getDoctorID() != null ? !getDoctorID().equals(that.getDoctorID()) : that.getDoctorID() != null) {
        return false;
      }
      if (arguments.containsKey("show_book_appointment_btn") != that.arguments.containsKey("show_book_appointment_btn")) {
        return false;
      }
      if (getShowBookAppointmentBtn() != that.getShowBookAppointmentBtn()) {
        return false;
      }
      if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
        return false;
      }
      if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
        return false;
      }
      if (arguments.containsKey("instantDoctor") != that.arguments.containsKey("instantDoctor")) {
        return false;
      }
      if (getInstantDoctor() != null ? !getInstantDoctor().equals(that.getInstantDoctor()) : that.getInstantDoctor() != null) {
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
      result = 31 * result + (getDoctorID() != null ? getDoctorID().hashCode() : 0);
      result = 31 * result + (getShowBookAppointmentBtn() ? 1 : 0);
      result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
      result = 31 * result + (getInstantDoctor() != null ? getInstantDoctor().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionConsultationPreviewFragmentToDoctorProfileFragment(actionId=" + getActionId() + "){"
          + "doctorID=" + getDoctorID()
          + ", showBookAppointmentBtn=" + getShowBookAppointmentBtn()
          + ", doctor=" + getDoctor()
          + ", instantDoctor=" + getInstantDoctor()
          + "}";
    }
  }
}
