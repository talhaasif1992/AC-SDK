// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FindDoctorFragment_ViewBinding implements Unbinder {
  private FindDoctorFragment target;

  @UiThread
  public FindDoctorFragment_ViewBinding(FindDoctorFragment target, View source) {
    this.target = target;

    target.etSearchView = Utils.findRequiredViewAsType(source, R.id.etSearchView, "field 'etSearchView'", AppCompatEditText.class);
    target.ivFilters = Utils.findRequiredViewAsType(source, R.id.ivFilters, "field 'ivFilters'", AppCompatImageView.class);
    target.rvInstantDoctor = Utils.findRequiredViewAsType(source, R.id.rvInstantDoctor, "field 'rvInstantDoctor'", RecyclerView.class);
    target.rvElitePanelDoctor = Utils.findRequiredViewAsType(source, R.id.rvElitePanelDoctor, "field 'rvElitePanelDoctor'", RecyclerView.class);
    target.tvNoInstantDoctorFound = Utils.findRequiredViewAsType(source, R.id.tv_no_instant_doctor_found, "field 'tvNoInstantDoctorFound'", TextView.class);
    target.tvNoEliteDoctorFound = Utils.findRequiredViewAsType(source, R.id.tv_no_elite_doctor_found, "field 'tvNoEliteDoctorFound'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FindDoctorFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etSearchView = null;
    target.ivFilters = null;
    target.rvInstantDoctor = null;
    target.rvElitePanelDoctor = null;
    target.tvNoInstantDoctorFound = null;
    target.tvNoEliteDoctorFound = null;
  }
}
