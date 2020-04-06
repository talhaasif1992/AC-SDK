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

public class GenderFragment_ViewBinding implements Unbinder {
  private GenderFragment target;

  @UiThread
  public GenderFragment_ViewBinding(GenderFragment target, View source) {
    this.target = target;

    target.lytMale = Utils.findRequiredView(source, R.id.lytMale, "field 'lytMale'");
    target.lytFemale = Utils.findRequiredView(source, R.id.lytFemale, "field 'lytFemale'");
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GenderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lytMale = null;
    target.lytFemale = null;
    target.txtName = null;
  }
}
