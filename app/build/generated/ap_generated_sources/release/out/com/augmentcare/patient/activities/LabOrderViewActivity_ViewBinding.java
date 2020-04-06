// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LabOrderViewActivity_ViewBinding implements Unbinder {
  private LabOrderViewActivity target;

  @UiThread
  public LabOrderViewActivity_ViewBinding(LabOrderViewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LabOrderViewActivity_ViewBinding(LabOrderViewActivity target, View source) {
    this.target = target;

    target.mOrderWebView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'mOrderWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LabOrderViewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrderWebView = null;
  }
}
