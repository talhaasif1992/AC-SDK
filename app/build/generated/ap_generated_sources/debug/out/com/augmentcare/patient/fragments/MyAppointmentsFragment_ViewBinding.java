// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyAppointmentsFragment_ViewBinding implements Unbinder {
  private MyAppointmentsFragment target;

  @UiThread
  public MyAppointmentsFragment_ViewBinding(MyAppointmentsFragment target, View source) {
    this.target = target;

    target.smartTabs = Utils.findRequiredViewAsType(source, R.id.stl_appointments, "field 'smartTabs'", SmartTabLayout.class);
    target.vp_appointments = Utils.findRequiredViewAsType(source, R.id.vp_appointments, "field 'vp_appointments'", ViewPager.class);
    target.tvEmptyState = Utils.findRequiredViewAsType(source, R.id.tv_empty_state, "field 'tvEmptyState'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyAppointmentsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.smartTabs = null;
    target.vp_appointments = null;
    target.tvEmptyState = null;
  }
}
