// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DOBFragment_ViewBinding implements Unbinder {
  private DOBFragment target;

  @UiThread
  public DOBFragment_ViewBinding(DOBFragment target, View source) {
    this.target = target;

    target.lytDob = Utils.findRequiredView(source, R.id.lytDob, "field 'lytDob'");
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.txtDay = Utils.findRequiredViewAsType(source, R.id.txtDay, "field 'txtDay'", TextView.class);
    target.txtMonth = Utils.findRequiredViewAsType(source, R.id.txtMonth, "field 'txtMonth'", TextView.class);
    target.txtYear = Utils.findRequiredViewAsType(source, R.id.txtYear, "field 'txtYear'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DOBFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lytDob = null;
    target.btnNext = null;
    target.txtName = null;
    target.txtDay = null;
    target.txtMonth = null;
    target.txtYear = null;
  }
}
