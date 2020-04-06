// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpFragment_ViewBinding implements Unbinder {
  private SignUpFragment target;

  @UiThread
  public SignUpFragment_ViewBinding(SignUpFragment target, View source) {
    this.target = target;

    target.btnEmail = Utils.findRequiredViewAsType(source, R.id.btn_email, "field 'btnEmail'", Button.class);
    target.btnEmployeeCode = Utils.findRequiredViewAsType(source, R.id.btn_employee_code, "field 'btnEmployeeCode'", Button.class);
    target.btn_google_sign_up = Utils.findRequiredViewAsType(source, R.id.btn_google_sign_up, "field 'btn_google_sign_up'", Button.class);
    target.tv_already_have_an_account = Utils.findRequiredViewAsType(source, R.id.tv_already_have_an_account, "field 'tv_already_have_an_account'", TextView.class);
    target.iv_back_arrow = Utils.findRequiredViewAsType(source, R.id.iv_back_arrow, "field 'iv_back_arrow'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignUpFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnEmail = null;
    target.btnEmployeeCode = null;
    target.btn_google_sign_up = null;
    target.tv_already_have_an_account = null;
    target.iv_back_arrow = null;
  }
}
