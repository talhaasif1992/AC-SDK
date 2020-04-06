// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignInSignUpFragment_ViewBinding implements Unbinder {
  private SignInSignUpFragment target;

  @UiThread
  public SignInSignUpFragment_ViewBinding(SignInSignUpFragment target, View source) {
    this.target = target;

    target.sign_up = Utils.findRequiredViewAsType(source, R.id.btn_sign_up, "field 'sign_up'", Button.class);
    target.sign_in = Utils.findRequiredViewAsType(source, R.id.btn_sign_in, "field 'sign_in'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignInSignUpFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sign_up = null;
    target.sign_in = null;
  }
}
