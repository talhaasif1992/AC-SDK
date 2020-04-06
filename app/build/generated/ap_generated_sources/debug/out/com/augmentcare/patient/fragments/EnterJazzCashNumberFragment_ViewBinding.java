// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EnterJazzCashNumberFragment_ViewBinding implements Unbinder {
  private EnterJazzCashNumberFragment target;

  @UiThread
  public EnterJazzCashNumberFragment_ViewBinding(EnterJazzCashNumberFragment target, View source) {
    this.target = target;

    target.etAccountNumber = Utils.findRequiredViewAsType(source, R.id.et_account_number, "field 'etAccountNumber'", EditText.class);
    target.tvCancel = Utils.findRequiredViewAsType(source, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    target.tvOK = Utils.findRequiredViewAsType(source, R.id.tv_ok, "field 'tvOK'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EnterJazzCashNumberFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etAccountNumber = null;
    target.tvCancel = null;
    target.tvOK = null;
  }
}
