// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.signup;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class PasswordCodeSignupFragment_ViewBinding implements Unbinder {
  private PasswordCodeSignupFragment target;

  @UiThread
  public PasswordCodeSignupFragment_ViewBinding(PasswordCodeSignupFragment target, View source) {
    this.target = target;

    target.etxtPassword = Utils.findRequiredViewAsType(source, R.id.etxtPassword, "field 'etxtPassword'", AppCompatEditText.class);
    target.etxtConfirmPassword = Utils.findRequiredViewAsType(source, R.id.etxtConfirmPassword, "field 'etxtConfirmPassword'", AppCompatEditText.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.tvUserName = Utils.findRequiredViewAsType(source, R.id.tvUserName, "field 'tvUserName'", TextView.class);
    target.meter = Utils.findRequiredViewAsType(source, R.id.passwordInputMeter, "field 'meter'", PasswordStrengthMeter.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PasswordCodeSignupFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etxtPassword = null;
    target.etxtConfirmPassword = null;
    target.btnNext = null;
    target.tvUserName = null;
    target.meter = null;
  }
}
