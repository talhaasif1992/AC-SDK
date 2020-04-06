package com.augmentcare.patient.claim;

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

public class FileAClaimFragmentDirections {
  private FileAClaimFragmentDirections() {
  }

  @NonNull
  public static ActionFileAClaimFragmentToConfirmClaimFragment actionFileAClaimFragmentToConfirmClaimFragment(@NonNull String consultationWith,
      @NonNull String location, @NonNull String time, @NonNull String timeChoose,
      @NonNull String date, @NonNull String transactionType, @NonNull String transactionFor,
      @NonNull String dependentId, @NonNull String dependentName, int userId,
      @NonNull String[] imagesList, @NonNull String details) {
    return new ActionFileAClaimFragmentToConfirmClaimFragment(consultationWith, location, time, timeChoose, date, transactionType, transactionFor, dependentId, dependentName, userId, imagesList, details);
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

  public static class ActionFileAClaimFragmentToConfirmClaimFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFileAClaimFragmentToConfirmClaimFragment(@NonNull String consultationWith,
        @NonNull String location, @NonNull String time, @NonNull String timeChoose,
        @NonNull String date, @NonNull String transactionType, @NonNull String transactionFor,
        @NonNull String dependentId, @NonNull String dependentName, int userId,
        @NonNull String[] imagesList, @NonNull String details) {
      if (consultationWith == null) {
        throw new IllegalArgumentException("Argument \"consultation_with\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("consultation_with", consultationWith);
      if (location == null) {
        throw new IllegalArgumentException("Argument \"location\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("location", location);
      if (time == null) {
        throw new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("time", time);
      if (timeChoose == null) {
        throw new IllegalArgumentException("Argument \"timeChoose\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("timeChoose", timeChoose);
      if (date == null) {
        throw new IllegalArgumentException("Argument \"date\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("date", date);
      if (transactionType == null) {
        throw new IllegalArgumentException("Argument \"transaction_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transaction_type", transactionType);
      if (transactionFor == null) {
        throw new IllegalArgumentException("Argument \"transaction_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transaction_for", transactionFor);
      if (dependentId == null) {
        throw new IllegalArgumentException("Argument \"dependent_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("dependent_id", dependentId);
      if (dependentName == null) {
        throw new IllegalArgumentException("Argument \"dependent_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("dependent_name", dependentName);
      this.arguments.put("user_id", userId);
      if (imagesList == null) {
        throw new IllegalArgumentException("Argument \"images_list\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("images_list", imagesList);
      if (details == null) {
        throw new IllegalArgumentException("Argument \"details\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("details", details);
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setAmount(@NonNull String amount) {
      if (amount == null) {
        throw new IllegalArgumentException("Argument \"amount\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("amount", amount);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setConsultationWith(@NonNull String consultationWith) {
      if (consultationWith == null) {
        throw new IllegalArgumentException("Argument \"consultation_with\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("consultation_with", consultationWith);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setSpeciality(@NonNull String speciality) {
      if (speciality == null) {
        throw new IllegalArgumentException("Argument \"speciality\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("speciality", speciality);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setLocation(@NonNull String location) {
      if (location == null) {
        throw new IllegalArgumentException("Argument \"location\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("location", location);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setTime(@NonNull String time) {
      if (time == null) {
        throw new IllegalArgumentException("Argument \"time\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("time", time);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setTimeChoose(@NonNull String timeChoose) {
      if (timeChoose == null) {
        throw new IllegalArgumentException("Argument \"timeChoose\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("timeChoose", timeChoose);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setDate(@NonNull String date) {
      if (date == null) {
        throw new IllegalArgumentException("Argument \"date\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("date", date);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setOrganizationId(int organizationId) {
      this.arguments.put("organization_id", organizationId);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setTransactionType(@NonNull String transactionType) {
      if (transactionType == null) {
        throw new IllegalArgumentException("Argument \"transaction_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transaction_type", transactionType);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setTransactionFor(@NonNull String transactionFor) {
      if (transactionFor == null) {
        throw new IllegalArgumentException("Argument \"transaction_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("transaction_for", transactionFor);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setDependentId(@NonNull String dependentId) {
      if (dependentId == null) {
        throw new IllegalArgumentException("Argument \"dependent_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("dependent_id", dependentId);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setDependentName(@NonNull String dependentName) {
      if (dependentName == null) {
        throw new IllegalArgumentException("Argument \"dependent_name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("dependent_name", dependentName);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setClaimType(@NonNull String claimType) {
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_type", claimType);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setUserId(int userId) {
      this.arguments.put("user_id", userId);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setImagesList(@NonNull String[] imagesList) {
      if (imagesList == null) {
        throw new IllegalArgumentException("Argument \"images_list\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("images_list", imagesList);
      return this;
    }

    @NonNull
    public ActionFileAClaimFragmentToConfirmClaimFragment setDetails(@NonNull String details) {
      if (details == null) {
        throw new IllegalArgumentException("Argument \"details\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("details", details);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("amount")) {
        String amount = (String) arguments.get("amount");
        __result.putString("amount", amount);
      }
      if (arguments.containsKey("consultation_with")) {
        String consultationWith = (String) arguments.get("consultation_with");
        __result.putString("consultation_with", consultationWith);
      }
      if (arguments.containsKey("speciality")) {
        String speciality = (String) arguments.get("speciality");
        __result.putString("speciality", speciality);
      }
      if (arguments.containsKey("location")) {
        String location = (String) arguments.get("location");
        __result.putString("location", location);
      }
      if (arguments.containsKey("time")) {
        String time = (String) arguments.get("time");
        __result.putString("time", time);
      }
      if (arguments.containsKey("timeChoose")) {
        String timeChoose = (String) arguments.get("timeChoose");
        __result.putString("timeChoose", timeChoose);
      }
      if (arguments.containsKey("date")) {
        String date = (String) arguments.get("date");
        __result.putString("date", date);
      }
      if (arguments.containsKey("organization_id")) {
        int organizationId = (int) arguments.get("organization_id");
        __result.putInt("organization_id", organizationId);
      }
      if (arguments.containsKey("transaction_type")) {
        String transactionType = (String) arguments.get("transaction_type");
        __result.putString("transaction_type", transactionType);
      }
      if (arguments.containsKey("transaction_for")) {
        String transactionFor = (String) arguments.get("transaction_for");
        __result.putString("transaction_for", transactionFor);
      }
      if (arguments.containsKey("dependent_id")) {
        String dependentId = (String) arguments.get("dependent_id");
        __result.putString("dependent_id", dependentId);
      }
      if (arguments.containsKey("dependent_name")) {
        String dependentName = (String) arguments.get("dependent_name");
        __result.putString("dependent_name", dependentName);
      }
      if (arguments.containsKey("claim_type")) {
        String claimType = (String) arguments.get("claim_type");
        __result.putString("claim_type", claimType);
      }
      if (arguments.containsKey("user_id")) {
        int userId = (int) arguments.get("user_id");
        __result.putInt("user_id", userId);
      }
      if (arguments.containsKey("images_list")) {
        String[] imagesList = (String[]) arguments.get("images_list");
        __result.putStringArray("images_list", imagesList);
      }
      if (arguments.containsKey("details")) {
        String details = (String) arguments.get("details");
        __result.putString("details", details);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_fileAClaimFragment_to_confirmClaimFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getAmount() {
      return (String) arguments.get("amount");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getConsultationWith() {
      return (String) arguments.get("consultation_with");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getSpeciality() {
      return (String) arguments.get("speciality");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getLocation() {
      return (String) arguments.get("location");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTime() {
      return (String) arguments.get("time");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTimeChoose() {
      return (String) arguments.get("timeChoose");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDate() {
      return (String) arguments.get("date");
    }

    @SuppressWarnings("unchecked")
    public int getOrganizationId() {
      return (int) arguments.get("organization_id");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTransactionType() {
      return (String) arguments.get("transaction_type");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTransactionFor() {
      return (String) arguments.get("transaction_for");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDependentId() {
      return (String) arguments.get("dependent_id");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDependentName() {
      return (String) arguments.get("dependent_name");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getClaimType() {
      return (String) arguments.get("claim_type");
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("user_id");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String[] getImagesList() {
      return (String[]) arguments.get("images_list");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDetails() {
      return (String) arguments.get("details");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFileAClaimFragmentToConfirmClaimFragment that = (ActionFileAClaimFragmentToConfirmClaimFragment) object;
      if (arguments.containsKey("amount") != that.arguments.containsKey("amount")) {
        return false;
      }
      if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) {
        return false;
      }
      if (arguments.containsKey("consultation_with") != that.arguments.containsKey("consultation_with")) {
        return false;
      }
      if (getConsultationWith() != null ? !getConsultationWith().equals(that.getConsultationWith()) : that.getConsultationWith() != null) {
        return false;
      }
      if (arguments.containsKey("speciality") != that.arguments.containsKey("speciality")) {
        return false;
      }
      if (getSpeciality() != null ? !getSpeciality().equals(that.getSpeciality()) : that.getSpeciality() != null) {
        return false;
      }
      if (arguments.containsKey("location") != that.arguments.containsKey("location")) {
        return false;
      }
      if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null) {
        return false;
      }
      if (arguments.containsKey("time") != that.arguments.containsKey("time")) {
        return false;
      }
      if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) {
        return false;
      }
      if (arguments.containsKey("timeChoose") != that.arguments.containsKey("timeChoose")) {
        return false;
      }
      if (getTimeChoose() != null ? !getTimeChoose().equals(that.getTimeChoose()) : that.getTimeChoose() != null) {
        return false;
      }
      if (arguments.containsKey("date") != that.arguments.containsKey("date")) {
        return false;
      }
      if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) {
        return false;
      }
      if (arguments.containsKey("organization_id") != that.arguments.containsKey("organization_id")) {
        return false;
      }
      if (getOrganizationId() != that.getOrganizationId()) {
        return false;
      }
      if (arguments.containsKey("transaction_type") != that.arguments.containsKey("transaction_type")) {
        return false;
      }
      if (getTransactionType() != null ? !getTransactionType().equals(that.getTransactionType()) : that.getTransactionType() != null) {
        return false;
      }
      if (arguments.containsKey("transaction_for") != that.arguments.containsKey("transaction_for")) {
        return false;
      }
      if (getTransactionFor() != null ? !getTransactionFor().equals(that.getTransactionFor()) : that.getTransactionFor() != null) {
        return false;
      }
      if (arguments.containsKey("dependent_id") != that.arguments.containsKey("dependent_id")) {
        return false;
      }
      if (getDependentId() != null ? !getDependentId().equals(that.getDependentId()) : that.getDependentId() != null) {
        return false;
      }
      if (arguments.containsKey("dependent_name") != that.arguments.containsKey("dependent_name")) {
        return false;
      }
      if (getDependentName() != null ? !getDependentName().equals(that.getDependentName()) : that.getDependentName() != null) {
        return false;
      }
      if (arguments.containsKey("claim_type") != that.arguments.containsKey("claim_type")) {
        return false;
      }
      if (getClaimType() != null ? !getClaimType().equals(that.getClaimType()) : that.getClaimType() != null) {
        return false;
      }
      if (arguments.containsKey("user_id") != that.arguments.containsKey("user_id")) {
        return false;
      }
      if (getUserId() != that.getUserId()) {
        return false;
      }
      if (arguments.containsKey("images_list") != that.arguments.containsKey("images_list")) {
        return false;
      }
      if (getImagesList() != null ? !getImagesList().equals(that.getImagesList()) : that.getImagesList() != null) {
        return false;
      }
      if (arguments.containsKey("details") != that.arguments.containsKey("details")) {
        return false;
      }
      if (getDetails() != null ? !getDetails().equals(that.getDetails()) : that.getDetails() != null) {
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
      result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
      result = 31 * result + (getConsultationWith() != null ? getConsultationWith().hashCode() : 0);
      result = 31 * result + (getSpeciality() != null ? getSpeciality().hashCode() : 0);
      result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
      result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
      result = 31 * result + (getTimeChoose() != null ? getTimeChoose().hashCode() : 0);
      result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
      result = 31 * result + getOrganizationId();
      result = 31 * result + (getTransactionType() != null ? getTransactionType().hashCode() : 0);
      result = 31 * result + (getTransactionFor() != null ? getTransactionFor().hashCode() : 0);
      result = 31 * result + (getDependentId() != null ? getDependentId().hashCode() : 0);
      result = 31 * result + (getDependentName() != null ? getDependentName().hashCode() : 0);
      result = 31 * result + (getClaimType() != null ? getClaimType().hashCode() : 0);
      result = 31 * result + getUserId();
      result = 31 * result + java.util.Arrays.hashCode(getImagesList());
      result = 31 * result + (getDetails() != null ? getDetails().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFileAClaimFragmentToConfirmClaimFragment(actionId=" + getActionId() + "){"
          + "amount=" + getAmount()
          + ", consultationWith=" + getConsultationWith()
          + ", speciality=" + getSpeciality()
          + ", location=" + getLocation()
          + ", time=" + getTime()
          + ", timeChoose=" + getTimeChoose()
          + ", date=" + getDate()
          + ", organizationId=" + getOrganizationId()
          + ", transactionType=" + getTransactionType()
          + ", transactionFor=" + getTransactionFor()
          + ", dependentId=" + getDependentId()
          + ", dependentName=" + getDependentName()
          + ", claimType=" + getClaimType()
          + ", userId=" + getUserId()
          + ", imagesList=" + getImagesList()
          + ", details=" + getDetails()
          + "}";
    }
  }
}
