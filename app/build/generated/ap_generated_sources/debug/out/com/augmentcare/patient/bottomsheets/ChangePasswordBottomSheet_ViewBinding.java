// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.bottomsheets;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class ChangePasswordBottomSheet_ViewBinding implements Unbinder {
  private ChangePasswordBottomSheet target;

  @UiThread
  public ChangePasswordBottomSheet_ViewBinding(ChangePasswordBottomSheet target, View source) {
    this.target = target;

    target.mSaveButton = Utils.findRequiredViewAsType(source, R.id.save_button, "field 'mSaveButton'", Button.class);
    target.mPasswordTextView = Utils.findRequiredViewAsType(source, R.id.password, "field 'mPasswordTextView'", EditText.class);
    target.mConfirmPasswordTextView = Utils.findRequiredViewAsType(source, R.id.confirm_password, "field 'mConfirmPasswordTextView'", EditText.class);
    target.meter = Utils.findRequiredViewAsType(source, R.id.passwordInputMeter, "field 'meter'", PasswordStrengthMeter.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChangePasswordBottomSheet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSaveButton = null;
    target.mPasswordTextView = null;
    target.mConfirmPasswordTextView = null;
    target.meter = null;
  }
}
