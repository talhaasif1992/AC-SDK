// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CancelAppointmentDialogFragment_ViewBinding implements Unbinder {
  private CancelAppointmentDialogFragment target;

  private View view7f0a0170;

  private View view7f0a015d;

  @UiThread
  public CancelAppointmentDialogFragment_ViewBinding(final CancelAppointmentDialogFragment target,
      View source) {
    this.target = target;

    View view;
    target.tvAreYouSure = Utils.findRequiredViewAsType(source, R.id.tv_are_you_sure_you_want_to_cancel, "field 'tvAreYouSure'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_yes_cancel_it, "field 'btnYes' and method 'yesCancelIt'");
    target.btnYes = Utils.castView(view, R.id.btn_yes_cancel_it, "field 'btnYes'", Button.class);
    view7f0a0170 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.yesCancelIt();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_no_i_dont, "field 'btnNo' and method 'dontCancel'");
    target.btnNo = Utils.castView(view, R.id.btn_no_i_dont, "field 'btnNo'", Button.class);
    view7f0a015d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.dontCancel();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CancelAppointmentDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAreYouSure = null;
    target.btnYes = null;
    target.btnNo = null;

    view7f0a0170.setOnClickListener(null);
    view7f0a0170 = null;
    view7f0a015d.setOnClickListener(null);
    view7f0a015d = null;
  }
}
