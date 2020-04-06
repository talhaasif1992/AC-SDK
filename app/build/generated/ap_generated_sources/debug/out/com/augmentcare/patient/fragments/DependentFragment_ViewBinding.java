// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DependentFragment_ViewBinding implements Unbinder {
  private DependentFragment target;

  @UiThread
  public DependentFragment_ViewBinding(DependentFragment target, View source) {
    this.target = target;

    target.mDependentRecyclerView = Utils.findRequiredViewAsType(source, R.id.dependent_recyclerview, "field 'mDependentRecyclerView'", RecyclerView.class);
    target.mNoResultsTextView = Utils.findRequiredViewAsType(source, R.id.txtNoResults, "field 'mNoResultsTextView'", TextView.class);
    target.mAddMemberButton = Utils.findRequiredViewAsType(source, R.id.add_member_button, "field 'mAddMemberButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DependentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDependentRecyclerView = null;
    target.mNoResultsTextView = null;
    target.mAddMemberButton = null;
  }
}
