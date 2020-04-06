// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignupEmailFragment_ViewBinding implements Unbinder {
  private SignupEmailFragment target;

  @UiThread
  public SignupEmailFragment_ViewBinding(SignupEmailFragment target, View source) {
    this.target = target;

    target.tvEmailMobile = Utils.findRequiredViewAsType(source, R.id.tvEmailMobile, "field 'tvEmailMobile'", TextView.class);
    target.tvNextStep = Utils.findRequiredViewAsType(source, R.id.tv_next_step_tell_us_about_your_new_mobile_number, "field 'tvNextStep'", TextView.class);
    target.etxtEmail = Utils.findRequiredViewAsType(source, R.id.etxtEmail, "field 'etxtEmail'", AppCompatEditText.class);
    target.pet_Phone = Utils.findRequiredViewAsType(source, R.id.pet_Phone, "field 'pet_Phone'", PhoneEditTextNew.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.alreadyHaveAccountTV = Utils.findRequiredViewAsType(source, R.id.tv_already_have_an_account, "field 'alreadyHaveAccountTV'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignupEmailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvEmailMobile = null;
    target.tvNextStep = null;
    target.etxtEmail = null;
    target.pet_Phone = null;
    target.btnNext = null;
    target.txtName = null;
    target.alreadyHaveAccountTV = null;
  }
}
