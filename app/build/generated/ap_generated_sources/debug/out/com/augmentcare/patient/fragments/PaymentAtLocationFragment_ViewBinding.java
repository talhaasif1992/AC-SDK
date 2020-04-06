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

public class PaymentAtLocationFragment_ViewBinding implements Unbinder {
  private PaymentAtLocationFragment target;

  @UiThread
  public PaymentAtLocationFragment_ViewBinding(PaymentAtLocationFragment target, View source) {
    this.target = target;

    target.ivPayAtLocation = Utils.findRequiredViewAsType(source, R.id.iv_pay_at_location, "field 'ivPayAtLocation'", ImageView.class);
    target.btnPayAtLocation = Utils.findRequiredViewAsType(source, R.id.btn_pay_at_location, "field 'btnPayAtLocation'", Button.class);
    target.tvPayAtLocation = Utils.findRequiredViewAsType(source, R.id.tv_pay_at_location, "field 'tvPayAtLocation'", TextView.class);
    target.tvOnlineCase = Utils.findRequiredViewAsType(source, R.id.tv_online_case, "field 'tvOnlineCase'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentAtLocationFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivPayAtLocation = null;
    target.btnPayAtLocation = null;
    target.tvPayAtLocation = null;
    target.tvOnlineCase = null;
  }
}
