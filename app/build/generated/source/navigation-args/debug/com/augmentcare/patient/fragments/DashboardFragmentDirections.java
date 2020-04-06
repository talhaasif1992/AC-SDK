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
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DashboardFragmentDirections {
  private DashboardFragmentDirections() {
  }

  @NonNull
  public static ActionDashboardFragmentToFindDoctorFragment actionDashboardFragmentToFindDoctorFragment() {
    return new ActionDashboardFragmentToFindDoctorFragment();
  }

  @NonNull
  public static ActionDashboardFragmentToInstantAppointmentFragment actionDashboardFragmentToInstantAppointmentFragment() {
    return new ActionDashboardFragmentToInstantAppointmentFragment();
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToNotificationsFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_NotificationsFragment);
  }

  @NonNull
  public static ActionDashboardFragmentToMedicinesInfoFragment actionDashboardFragmentToMedicinesInfoFragment(@Nullable String Condition) {
    return new ActionDashboardFragmentToMedicinesInfoFragment(Condition);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToPlanSelectionFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_planSelectionFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToDependentFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_dependentFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToAppSettingsFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_appSettingsFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToVideoConsultationActivity() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_videoConsultationActivity);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToChatActivity() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_chatActivity);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToEditProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_editProfileFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToMyAppointmentsFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_myAppointmentsFragment);
  }

  @NonNull
  public static ActionDashboardFragmentToConsultationPreviewFragment actionDashboardFragmentToConsultationPreviewFragment(@Nullable String slotID) {
    return new ActionDashboardFragmentToConsultationPreviewFragment(slotID);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToMyClaimsFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_myClaimsFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_loginFragment);
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

  public static class ActionDashboardFragmentToFindDoctorFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDashboardFragmentToFindDoctorFragment() {
    }

    @NonNull
    public ActionDashboardFragmentToFindDoctorFragment setNoOfFreeCalls(int noOfFreeCalls) {
      this.arguments.put("noOfFreeCalls", noOfFreeCalls);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToFindDoctorFragment setShowBadge(boolean showBadge) {
      this.arguments.put("showBadge", showBadge);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("noOfFreeCalls")) {
        int noOfFreeCalls = (int) arguments.get("noOfFreeCalls");
        __result.putInt("noOfFreeCalls", noOfFreeCalls);
      }
      if (arguments.containsKey("showBadge")) {
        boolean showBadge = (boolean) arguments.get("showBadge");
        __result.putBoolean("showBadge", showBadge);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_dashboardFragment_to_findDoctorFragment;
    }

    @SuppressWarnings("unchecked")
    public int getNoOfFreeCalls() {
      return (int) arguments.get("noOfFreeCalls");
    }

    @SuppressWarnings("unchecked")
    public boolean getShowBadge() {
      return (boolean) arguments.get("showBadge");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionDashboardFragmentToFindDoctorFragment that = (ActionDashboardFragmentToFindDoctorFragment) object;
      if (arguments.containsKey("noOfFreeCalls") != that.arguments.containsKey("noOfFreeCalls")) {
        return false;
      }
      if (getNoOfFreeCalls() != that.getNoOfFreeCalls()) {
        return false;
      }
      if (arguments.containsKey("showBadge") != that.arguments.containsKey("showBadge")) {
        return false;
      }
      if (getShowBadge() != that.getShowBadge()) {
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
      result = 31 * result + getNoOfFreeCalls();
      result = 31 * result + (getShowBadge() ? 1 : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionDashboardFragmentToFindDoctorFragment(actionId=" + getActionId() + "){"
          + "noOfFreeCalls=" + getNoOfFreeCalls()
          + ", showBadge=" + getShowBadge()
          + "}";
    }
  }

  public static class ActionDashboardFragmentToInstantAppointmentFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDashboardFragmentToInstantAppointmentFragment() {
    }

    @NonNull
    public ActionDashboardFragmentToInstantAppointmentFragment setDoctorID(@Nullable String doctorID) {
      this.arguments.put("doctorID", doctorID);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToInstantAppointmentFragment setOrderID(@Nullable String orderID) {
      this.arguments.put("orderID", orderID);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToInstantAppointmentFragment setDoContinue(boolean doContinue) {
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
      return R.id.action_dashboardFragment_to_instantAppointmentFragment;
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
      ActionDashboardFragmentToInstantAppointmentFragment that = (ActionDashboardFragmentToInstantAppointmentFragment) object;
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
      return "ActionDashboardFragmentToInstantAppointmentFragment(actionId=" + getActionId() + "){"
          + "doctorID=" + getDoctorID()
          + ", orderID=" + getOrderID()
          + ", doContinue=" + getDoContinue()
          + "}";
    }
  }

  public static class ActionDashboardFragmentToMedicinesInfoFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDashboardFragmentToMedicinesInfoFragment(@Nullable String Condition) {
      this.arguments.put("Condition", Condition);
    }

    @NonNull
    public ActionDashboardFragmentToMedicinesInfoFragment setIsFromLab(boolean isFromLab) {
      this.arguments.put("isFromLab", isFromLab);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToMedicinesInfoFragment setCondition(@Nullable String Condition) {
      this.arguments.put("Condition", Condition);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("isFromLab")) {
        boolean isFromLab = (boolean) arguments.get("isFromLab");
        __result.putBoolean("isFromLab", isFromLab);
      }
      if (arguments.containsKey("Condition")) {
        String Condition = (String) arguments.get("Condition");
        __result.putString("Condition", Condition);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_dashboardFragment_to_medicinesInfoFragment;
    }

    @SuppressWarnings("unchecked")
    public boolean getIsFromLab() {
      return (boolean) arguments.get("isFromLab");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getCondition() {
      return (String) arguments.get("Condition");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionDashboardFragmentToMedicinesInfoFragment that = (ActionDashboardFragmentToMedicinesInfoFragment) object;
      if (arguments.containsKey("isFromLab") != that.arguments.containsKey("isFromLab")) {
        return false;
      }
      if (getIsFromLab() != that.getIsFromLab()) {
        return false;
      }
      if (arguments.containsKey("Condition") != that.arguments.containsKey("Condition")) {
        return false;
      }
      if (getCondition() != null ? !getCondition().equals(that.getCondition()) : that.getCondition() != null) {
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
      result = 31 * result + (getIsFromLab() ? 1 : 0);
      result = 31 * result + (getCondition() != null ? getCondition().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionDashboardFragmentToMedicinesInfoFragment(actionId=" + getActionId() + "){"
          + "isFromLab=" + getIsFromLab()
          + ", Condition=" + getCondition()
          + "}";
    }
  }

  public static class ActionDashboardFragmentToConsultationPreviewFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionDashboardFragmentToConsultationPreviewFragment(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
    }

    @NonNull
    public ActionDashboardFragmentToConsultationPreviewFragment setConsultation(@Nullable Consultation consultation) {
      this.arguments.put("consultation", consultation);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToConsultationPreviewFragment setSlotID(@Nullable String slotID) {
      this.arguments.put("slotID", slotID);
      return this;
    }

    @NonNull
    public ActionDashboardFragmentToConsultationPreviewFragment setIsFromNotificationFragment(boolean isFromNotificationFragment) {
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
      return R.id.action_dashboardFragment_to_consultationPreviewFragment;
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
      ActionDashboardFragmentToConsultationPreviewFragment that = (ActionDashboardFragmentToConsultationPreviewFragment) object;
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
      return "ActionDashboardFragmentToConsultationPreviewFragment(actionId=" + getActionId() + "){"
          + "consultation=" + getConsultation()
          + ", slotID=" + getSlotID()
          + ", isFromNotificationFragment=" + getIsFromNotificationFragment()
          + "}";
    }
  }
}
