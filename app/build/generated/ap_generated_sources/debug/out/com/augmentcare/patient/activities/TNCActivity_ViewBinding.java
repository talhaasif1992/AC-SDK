// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TNCActivity_ViewBinding implements Unbinder {
  private TNCActivity target;

  @UiThread
  public TNCActivity_ViewBinding(TNCActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TNCActivity_ViewBinding(TNCActivity target, View source) {
    this.target = target;

    target.tvTNC = Utils.findRequiredViewAsType(source, R.id.tvTNC, "field 'tvTNC'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TNCActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTNC = null;
  }
}
