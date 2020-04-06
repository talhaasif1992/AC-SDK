// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PatientProfileFragment_ViewBinding implements Unbinder {
  private PatientProfileFragment target;

  @UiThread
  public PatientProfileFragment_ViewBinding(PatientProfileFragment target, View source) {
    this.target = target;

    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.txtDOB = Utils.findRequiredViewAsType(source, R.id.txtDOB, "field 'txtDOB'", TextView.class);
    target.txtAge = Utils.findRequiredViewAsType(source, R.id.txtAge, "field 'txtAge'", TextView.class);
    target.ivGenderType = Utils.findRequiredViewAsType(source, R.id.ivGenderType, "field 'ivGenderType'", ImageView.class);
    target.txtGender = Utils.findRequiredViewAsType(source, R.id.txtGender, "field 'txtGender'", TextView.class);
    target.txtEmail = Utils.findRequiredViewAsType(source, R.id.txtEmail, "field 'txtEmail'", TextView.class);
    target.txtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.txtPhoneNumber, "field 'txtPhoneNumber'", TextView.class);
    target.btnAddProfile = Utils.findRequiredView(source, R.id.btnAddProfile, "field 'btnAddProfile'");
    target.txtEditProfile = Utils.findRequiredView(source, R.id.txtEditProfile, "field 'txtEditProfile'");
    target.ivArrow = Utils.findRequiredView(source, R.id.ivArrow, "field 'ivArrow'");
    target.cardBookAppointment = Utils.findRequiredView(source, R.id.cardBookAppointment, "field 'cardBookAppointment'");
    target.txtAgeType = Utils.findRequiredViewAsType(source, R.id.txtAgeType, "field 'txtAgeType'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PatientProfileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtName = null;
    target.txtDOB = null;
    target.txtAge = null;
    target.ivGenderType = null;
    target.txtGender = null;
    target.txtEmail = null;
    target.txtPhoneNumber = null;
    target.btnAddProfile = null;
    target.txtEditProfile = null;
    target.ivArrow = null;
    target.cardBookAppointment = null;
    target.txtAgeType = null;
  }
}
