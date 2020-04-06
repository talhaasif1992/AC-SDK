// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.jaygoo.widget.RangeSeekBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RefineSearchFragment_ViewBinding implements Unbinder {
  private RefineSearchFragment target;

  @UiThread
  public RefineSearchFragment_ViewBinding(RefineSearchFragment target, View source) {
    this.target = target;

    target.ratingBar = Utils.findRequiredViewAsType(source, R.id.ratingBar, "field 'ratingBar'", RatingBar.class);
    target.tvRatings = Utils.findRequiredViewAsType(source, R.id.tvRatings, "field 'tvRatings'", TextView.class);
    target.btnMale = Utils.findRequiredViewAsType(source, R.id.btn_male, "field 'btnMale'", Button.class);
    target.btnFemale = Utils.findRequiredViewAsType(source, R.id.btn_female, "field 'btnFemale'", Button.class);
    target.btnApply = Utils.findRequiredViewAsType(source, R.id.btn_apply, "field 'btnApply'", Button.class);
    target.btnReset = Utils.findRequiredViewAsType(source, R.id.btn_reset, "field 'btnReset'", Button.class);
    target.spinnerHospital = Utils.findRequiredViewAsType(source, R.id.spinner_choose_hospital, "field 'spinnerHospital'", Spinner.class);
    target.spinnerLocation = Utils.findRequiredViewAsType(source, R.id.spinner_choose_location, "field 'spinnerLocation'", Spinner.class);
    target.spinnerSpecialization = Utils.findRequiredViewAsType(source, R.id.spinner_choose_specialization, "field 'spinnerSpecialization'", Spinner.class);
    target.seekbarDistance = Utils.findRequiredViewAsType(source, R.id.seekBar_distance, "field 'seekbarDistance'", RangeSeekBar.class);
    target.seekbarExperience = Utils.findRequiredViewAsType(source, R.id.seekBar_experience, "field 'seekbarExperience'", RangeSeekBar.class);
    target.seekbarFees = Utils.findRequiredViewAsType(source, R.id.seekBar_fees, "field 'seekbarFees'", RangeSeekBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RefineSearchFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ratingBar = null;
    target.tvRatings = null;
    target.btnMale = null;
    target.btnFemale = null;
    target.btnApply = null;
    target.btnReset = null;
    target.spinnerHospital = null;
    target.spinnerLocation = null;
    target.spinnerSpecialization = null;
    target.seekbarDistance = null;
    target.seekbarExperience = null;
    target.seekbarFees = null;
  }
}
