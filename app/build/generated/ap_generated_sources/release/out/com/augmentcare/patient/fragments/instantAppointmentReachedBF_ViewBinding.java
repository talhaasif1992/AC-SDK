// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class instantAppointmentReachedBF_ViewBinding implements Unbinder {
  private instantAppointmentReachedBF target;

  private View view7f0a0179;

  private View view7f0a052a;

  @UiThread
  public instantAppointmentReachedBF_ViewBinding(final instantAppointmentReachedBF target,
      View source) {
    this.target = target;

    View view;
    target.callExpectTV = Utils.findRequiredViewAsType(source, R.id.callExpectTV, "field 'callExpectTV'", TextView.class);
    target.appointConfirmTV = Utils.findRequiredViewAsType(source, R.id.appointConfirmTV, "field 'appointConfirmTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cancelAppointmentBtn, "method 'cancelAppointment'");
    view7f0a0179 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelAppointment();
      }
    });
    view = Utils.findRequiredView(source, R.id.reschedBtn, "method 'reschedAppointment'");
    view7f0a052a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.reschedAppointment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    instantAppointmentReachedBF target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.callExpectTV = null;
    target.appointConfirmTV = null;

    view7f0a0179.setOnClickListener(null);
    view7f0a0179 = null;
    view7f0a052a.setOnClickListener(null);
    view7f0a052a = null;
  }
}
