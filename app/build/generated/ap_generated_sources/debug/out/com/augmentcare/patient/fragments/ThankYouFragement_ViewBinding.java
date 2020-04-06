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

public class ThankYouFragement_ViewBinding implements Unbinder {
  private ThankYouFragement target;

  @UiThread
  public ThankYouFragement_ViewBinding(ThankYouFragement target, View source) {
    this.target = target;

    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.txtSkip = Utils.findRequiredViewAsType(source, R.id.txtSkip, "field 'txtSkip'", TextView.class);
    target.txtMessage = Utils.findRequiredViewAsType(source, R.id.txtMessage, "field 'txtMessage'", TextView.class);
    target.signincontainer = Utils.findRequiredView(source, R.id.signincontainer, "field 'signincontainer'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ThankYouFragement target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnNext = null;
    target.txtName = null;
    target.txtSkip = null;
    target.txtMessage = null;
    target.signincontainer = null;
  }
}
