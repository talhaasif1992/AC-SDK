// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashFragment_ViewBinding implements Unbinder {
  private SplashFragment target;

  @UiThread
  public SplashFragment_ViewBinding(SplashFragment target, View source) {
    this.target = target;

    target.ivLogo = Utils.findRequiredViewAsType(source, R.id.iv_logo, "field 'ivLogo'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SplashFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivLogo = null;
  }
}
