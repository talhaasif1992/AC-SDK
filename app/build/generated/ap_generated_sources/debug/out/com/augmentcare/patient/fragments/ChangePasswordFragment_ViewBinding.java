// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangePasswordFragment_ViewBinding implements Unbinder {
  private ChangePasswordFragment target;

  @UiThread
  public ChangePasswordFragment_ViewBinding(ChangePasswordFragment target, View source) {
    this.target = target;

    target.etNewPassword = Utils.findRequiredViewAsType(source, R.id.et_new_password, "field 'etNewPassword'", AppCompatEditText.class);
    target.etConfirmNewPassword = Utils.findRequiredViewAsType(source, R.id.et_confirm_new_password, "field 'etConfirmNewPassword'", AppCompatEditText.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ChangePasswordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etNewPassword = null;
    target.etConfirmNewPassword = null;
    target.btnNext = null;
  }
}
