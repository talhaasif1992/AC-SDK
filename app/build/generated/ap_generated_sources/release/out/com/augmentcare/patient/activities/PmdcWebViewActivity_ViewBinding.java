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

public class PmdcWebViewActivity_ViewBinding implements Unbinder {
  private PmdcWebViewActivity target;

  @UiThread
  public PmdcWebViewActivity_ViewBinding(PmdcWebViewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PmdcWebViewActivity_ViewBinding(PmdcWebViewActivity target, View source) {
    this.target = target;

    target.mPmdcWebView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'mPmdcWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PmdcWebViewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPmdcWebView = null;
  }
}
