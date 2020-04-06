// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.skyhope.showmoretextview.ShowMoreTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutFragmentDoctor_ViewBinding implements Unbinder {
  private AboutFragmentDoctor target;

  @UiThread
  public AboutFragmentDoctor_ViewBinding(AboutFragmentDoctor target, View source) {
    this.target = target;

    target.aboutTv = Utils.findRequiredViewAsType(source, R.id.text_view_show_more, "field 'aboutTv'", ShowMoreTextView.class);
    target.pmdcTV = Utils.findRequiredViewAsType(source, R.id.pmdcTV, "field 'pmdcTV'", TextView.class);
    target.pmdcView = Utils.findRequiredViewAsType(source, R.id.pmdcView, "field 'pmdcView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutFragmentDoctor target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.aboutTv = null;
    target.pmdcTV = null;
    target.pmdcView = null;
  }
}
