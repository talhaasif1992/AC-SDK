package com.augmentcare.patient.claim;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ClaimSuccessFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ClaimSuccessFragmentArgs() {
  }

  private ClaimSuccessFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ClaimSuccessFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ClaimSuccessFragmentArgs __result = new ClaimSuccessFragmentArgs();
    bundle.setClassLoader(ClaimSuccessFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("amount")) {
      int amount;
      amount = bundle.getInt("amount");
      __result.arguments.put("amount", amount);
    }
    if (bundle.containsKey("claim_type")) {
      String claimType;
      claimType = bundle.getString("claim_type");
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("claim_type", claimType);
    } else {
      throw new IllegalArgumentException("Required argument \"claim_type\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("claim_for")) {
      String claimFor;
      claimFor = bundle.getString("claim_for");
      if (claimFor == null) {
        throw new IllegalArgumentException("Argument \"claim_for\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("claim_for", claimFor);
    } else {
      throw new IllegalArgumentException("Required argument \"claim_for\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("claim_details")) {
      String claimDetails;
      claimDetails = bundle.getString("claim_details");
      __result.arguments.put("claim_details", claimDetails);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getAmount() {
    return (int) arguments.get("amount");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getClaimType() {
    return (String) arguments.get("claim_type");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getClaimFor() {
    return (String) arguments.get("claim_for");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getClaimDetails() {
    return (String) arguments.get("claim_details");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("amount")) {
      int amount = (int) arguments.get("amount");
      __result.putInt("amount", amount);
    }
    if (arguments.containsKey("claim_type")) {
      String claimType = (String) arguments.get("claim_type");
      __result.putString("claim_type", claimType);
    }
    if (arguments.containsKey("claim_for")) {
      String claimFor = (String) arguments.get("claim_for");
      __result.putString("claim_for", claimFor);
    }
    if (arguments.containsKey("claim_details")) {
      String claimDetails = (String) arguments.get("claim_details");
      __result.putString("claim_details", claimDetails);
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
    ClaimSuccessFragmentArgs that = (ClaimSuccessFragmentArgs) object;
    if (arguments.containsKey("amount") != that.arguments.containsKey("amount")) {
      return false;
    }
    if (getAmount() != that.getAmount()) {
      return false;
    }
    if (arguments.containsKey("claim_type") != that.arguments.containsKey("claim_type")) {
      return false;
    }
    if (getClaimType() != null ? !getClaimType().equals(that.getClaimType()) : that.getClaimType() != null) {
      return false;
    }
    if (arguments.containsKey("claim_for") != that.arguments.containsKey("claim_for")) {
      return false;
    }
    if (getClaimFor() != null ? !getClaimFor().equals(that.getClaimFor()) : that.getClaimFor() != null) {
      return false;
    }
    if (arguments.containsKey("claim_details") != that.arguments.containsKey("claim_details")) {
      return false;
    }
    if (getClaimDetails() != null ? !getClaimDetails().equals(that.getClaimDetails()) : that.getClaimDetails() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getAmount();
    result = 31 * result + (getClaimType() != null ? getClaimType().hashCode() : 0);
    result = 31 * result + (getClaimFor() != null ? getClaimFor().hashCode() : 0);
    result = 31 * result + (getClaimDetails() != null ? getClaimDetails().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ClaimSuccessFragmentArgs{"
        + "amount=" + getAmount()
        + ", claimType=" + getClaimType()
        + ", claimFor=" + getClaimFor()
        + ", claimDetails=" + getClaimDetails()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ClaimSuccessFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String claimType, @NonNull String claimFor) {
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_type", claimType);
      if (claimFor == null) {
        throw new IllegalArgumentException("Argument \"claim_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_for", claimFor);
    }

    @NonNull
    public ClaimSuccessFragmentArgs build() {
      ClaimSuccessFragmentArgs result = new ClaimSuccessFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setAmount(int amount) {
      this.arguments.put("amount", amount);
      return this;
    }

    @NonNull
    public Builder setClaimType(@NonNull String claimType) {
      if (claimType == null) {
        throw new IllegalArgumentException("Argument \"claim_type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_type", claimType);
      return this;
    }

    @NonNull
    public Builder setClaimFor(@NonNull String claimFor) {
      if (claimFor == null) {
        throw new IllegalArgumentException("Argument \"claim_for\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("claim_for", claimFor);
      return this;
    }

    @NonNull
    public Builder setClaimDetails(@Nullable String claimDetails) {
      this.arguments.put("claim_details", claimDetails);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getAmount() {
      return (int) arguments.get("amount");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getClaimType() {
      return (String) arguments.get("claim_type");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getClaimFor() {
      return (String) arguments.get("claim_for");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getClaimDetails() {
      return (String) arguments.get("claim_details");
    }
  }
}
