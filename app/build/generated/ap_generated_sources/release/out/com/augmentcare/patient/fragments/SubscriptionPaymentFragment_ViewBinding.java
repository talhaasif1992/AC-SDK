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

public class SubscriptionPaymentFragment_ViewBinding implements Unbinder {
  private SubscriptionPaymentFragment target;

  @UiThread
  public SubscriptionPaymentFragment_ViewBinding(SubscriptionPaymentFragment target, View source) {
    this.target = target;

    target.lytCreditCardBtn = Utils.findRequiredViewAsType(source, R.id.lyt_creditCard_btn, "field 'lytCreditCardBtn'", LinearLayout.class);
    target.lytJazzCashBtn = Utils.findRequiredViewAsType(source, R.id.lyt_jazzCash_btn, "field 'lytJazzCashBtn'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubscriptionPaymentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lytCreditCardBtn = null;
    target.lytJazzCashBtn = null;
  }
}
