// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProileTypeFragment_ViewBinding implements Unbinder {
  private ProileTypeFragment target;

  @UiThread
  public ProileTypeFragment_ViewBinding(ProileTypeFragment target, View source) {
    this.target = target;

    target.btnMe = Utils.findRequiredViewAsType(source, R.id.btnMe, "field 'btnMe'", Button.class);
    target.btnFamily = Utils.findRequiredViewAsType(source, R.id.btnFamily, "field 'btnFamily'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProileTypeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnMe = null;
    target.btnFamily = null;
  }
}
