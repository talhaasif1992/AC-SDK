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

public class ReviewDoctorFragment_ViewBinding implements Unbinder {
  private ReviewDoctorFragment target;

  @UiThread
  public ReviewDoctorFragment_ViewBinding(ReviewDoctorFragment target, View source) {
    this.target = target;

    target.ratingRecyclerView = Utils.findRequiredViewAsType(source, R.id.review_RV, "field 'ratingRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReviewDoctorFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ratingRecyclerView = null;
  }
}
