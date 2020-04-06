// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PaymentMethodFragment_ViewBinding implements Unbinder {
  private PaymentMethodFragment target;

  @UiThread
  public PaymentMethodFragment_ViewBinding(PaymentMethodFragment target, View source) {
    this.target = target;

    target.lytPaymentOptions = Utils.findRequiredViewAsType(source, R.id.lytPaymentOptions, "field 'lytPaymentOptions'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentMethodFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lytPaymentOptions = null;
  }
}
