// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WorkExpFragmentDoctor_ViewBinding implements Unbinder {
  private WorkExpFragmentDoctor target;

  @UiThread
  public WorkExpFragmentDoctor_ViewBinding(WorkExpFragmentDoctor target, View source) {
    this.target = target;

    target.mPracticeLocationRecyclerView = Utils.findRequiredViewAsType(source, R.id.work_exp_RV, "field 'mPracticeLocationRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WorkExpFragmentDoctor target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPracticeLocationRecyclerView = null;
  }
}
