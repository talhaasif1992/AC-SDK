package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
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

public class FindDoctorFragmentDirections {
  private FindDoctorFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFindDoctorFragmentToRefineSearchFragment() {
    return new ActionOnlyNavDirections(R.id.action_findDoctorFragment_to_refineSearchFragment);
  }

  @NonNull
  public static ActionFindDoctorFragmentToInstantAppointmentFragment actionFindDoctorFragmentToInstantAppointmentFragment() {
    return new ActionFindDoctorFragmentToInstantAppointmentFragment();
  }

  @NonNull
  public static ActionFindDoctorFragmentToDoctorProfileFragment actionFindDoctorFragmentToDoctorProfileFragment(@NonNull String doctorID) {
    return new ActionFindDoctorFragmentToDoctorProfileFragment(doctorID);
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

  public static class ActionFindDoctorFragmentToInstantAppointmentFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFindDoctorFragmentToInstantAppointmentFragment() {
    }

    @NonNull
    public ActionFindDoctorFragmentToInstantAppointmentFragment setDoctorID(@Nullable String doctorID) {
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public ActionFindDoctorFragmentToInstantAppointmentFragment setOrderID(@Nullable String orderID) {
      this.arguments.put("orderID", orderID);
      return this;
    }

    @NonNull
    public ActionFindDoctorFragmentToInstantAppointmentFragment setDoContinue(boolean doContinue) {
      this.arguments.put("doContinue", doContinue);
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
      if (arguments.containsKey("orderID")) {
        String orderID = (String) arguments.get("orderID");
        __result.putString("orderID", orderID);
      }
      if (arguments.containsKey("doContinue")) {
        boolean doContinue = (boolean) arguments.get("doContinue");
        __result.putBoolean("doContinue", doContinue);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_findDoctorFragment_to_instantAppointmentFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getDoctorID() {
      return (String) arguments.get("doctorID");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getOrderID() {
      return (String) arguments.get("orderID");
    }

    @SuppressWarnings("unchecked")
    public boolean getDoContinue() {
      return (boolean) arguments.get("doContinue");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFindDoctorFragmentToInstantAppointmentFragment that = (ActionFindDoctorFragmentToInstantAppointmentFragment) object;
      if (arguments.containsKey("doctorID") != that.arguments.containsKey("doctorID")) {
        return false;
      }
      if (getDoctorID() != null ? !getDoctorID().equals(that.getDoctorID()) : that.getDoctorID() != null) {
        return false;
      }
      if (arguments.containsKey("orderID") != that.arguments.containsKey("orderID")) {
        return false;
      }
      if (getOrderID() != null ? !getOrderID().equals(that.getOrderID()) : that.getOrderID() != null) {
        return false;
      }
      if (arguments.containsKey("doContinue") != that.arguments.containsKey("doContinue")) {
        return false;
      }
      if (getDoContinue() != that.getDoContinue()) {
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
      result = 31 * result + (getOrderID() != null ? getOrderID().hashCode() : 0);
      result = 31 * result + (getDoContinue() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFindDoctorFragmentToInstantAppointmentFragment(actionId=" + getActionId() + "){"
          + "doctorID=" + getDoctorID()
          + ", orderID=" + getOrderID()
          + ", doContinue=" + getDoContinue()
          + "}";
    }
  }

  public static class ActionFindDoctorFragmentToDoctorProfileFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFindDoctorFragmentToDoctorProfileFragment(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
    }

    @NonNull
    public ActionFindDoctorFragmentToDoctorProfileFragment setDoctorID(@NonNull String doctorID) {
      if (doctorID == null) {
        throw new IllegalArgumentException("Argument \"doctorID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public ActionFindDoctorFragmentToDoctorProfileFragment setShowBookAppointmentBtn(boolean showBookAppointmentBtn) {
      this.arguments.put("show_book_appointment_btn", showBookAppointmentBtn);
      return this;
    }

    @NonNull
    public ActionFindDoctorFragmentToDoctorProfileFragment setDoctor(@Nullable DoctorInfoLimited doctor) {
      this.arguments.put("doctor", doctor);
      return this;
    }

    @NonNull
    public ActionFindDoctorFragmentToDoctorProfileFragment setInstantDoctor(@NonNull String instantDoctor) {
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
      return R.id.action_findDoctorFragment_to_doctorProfileFragment;
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
      ActionFindDoctorFragmentToDoctorProfileFragment that = (ActionFindDoctorFragmentToDoctorProfileFragment) object;
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
      return "ActionFindDoctorFragmentToDoctorProfileFragment(actionId=" + getActionId() + "){"
          + "doctorID=" + getDoctorID()
          + ", showBookAppointmentBtn=" + getShowBookAppointmentBtn()
          + ", doctor=" + getDoctor()
          + ", instantDoctor=" + getInstantDoctor()
          + "}";
    }
  }
}
