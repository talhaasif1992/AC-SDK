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

public class EducationFragmentDoctor_ViewBinding implements Unbinder {
  private EducationFragmentDoctor target;

  @UiThread
  public EducationFragmentDoctor_ViewBinding(EducationFragmentDoctor target, View source) {
    this.target = target;

    target.mEducationRecyclerView = Utils.findRequiredViewAsType(source, R.id.eduaction_RV, "field 'mEducationRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EducationFragmentDoctor target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEducationRecyclerView = null;
  }
}
