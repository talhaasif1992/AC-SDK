// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class SignupPasswordFragment_ViewBinding implements Unbinder {
  private SignupPasswordFragment target;

  @UiThread
  public SignupPasswordFragment_ViewBinding(SignupPasswordFragment target, View source) {
    this.target = target;

    target.lyt = Utils.findRequiredViewAsType(source, R.id.layout, "field 'lyt'", ConstraintLayout.class);
    target.etxtPassword = Utils.findRequiredViewAsType(source, R.id.etxtPassword, "field 'etxtPassword'", AppCompatEditText.class);
    target.etxtConfirmPassword = Utils.findRequiredViewAsType(source, R.id.etxtConfirmPassword, "field 'etxtConfirmPassword'", AppCompatEditText.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.alreadyHaveAccountTV = Utils.findRequiredViewAsType(source, R.id.tv_already_have_an_account, "field 'alreadyHaveAccountTV'", TextView.class);
    target.meter = Utils.findRequiredViewAsType(source, R.id.passwordInputMeter, "field 'meter'", PasswordStrengthMeter.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignupPasswordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lyt = null;
    target.etxtPassword = null;
    target.etxtConfirmPassword = null;
    target.btnNext = null;
    target.alreadyHaveAccountTV = null;
    target.meter = null;
  }
}
