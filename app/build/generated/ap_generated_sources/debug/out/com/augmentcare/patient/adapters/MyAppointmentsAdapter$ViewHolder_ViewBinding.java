// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyAppointmentsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MyAppointmentsAdapter.ViewHolder target;

  private View view7f0a011f;

  private View view7f0a0164;

  @UiThread
  public MyAppointmentsAdapter$ViewHolder_ViewBinding(final MyAppointmentsAdapter.ViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.root_parent = Utils.findRequiredView(source, R.id.root_parent, "field 'root_parent'");
    target.doctorIV = Utils.findRequiredViewAsType(source, R.id.civDoctorImage, "field 'doctorIV'", CircleImageView.class);
    target.appointmentStatusTV = Utils.findRequiredViewAsType(source, R.id.appointmentStatusTV, "field 'appointmentStatusTV'", TextView.class);
    target.doctorNameTV = Utils.findRequiredViewAsType(source, R.id.doctorNameTV, "field 'doctorNameTV'", TextView.class);
    target.educationTV = Utils.findRequiredViewAsType(source, R.id.appointmentDateTimeTV, "field 'educationTV'", TextView.class);
    target.specializationTV = Utils.findRequiredViewAsType(source, R.id.specializationTV, "field 'specializationTV'", TextView.class);
    target.dependentNameTV = Utils.findRequiredViewAsType(source, R.id.dependentNameTV, "field 'dependentNameTV'", TextView.class);
    target.civDependentImage = Utils.findRequiredViewAsType(source, R.id.civDependentImage, "field 'civDependentImage'", CircleImageView.class);
    target.appointmentTimeTV = Utils.findRequiredViewAsType(source, R.id.appointmentTimeTV, "field 'appointmentTimeTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnCancelAppointment, "field 'btnCancelAppointment' and method 'cancelTheAppointment'");
    target.btnCancelAppointment = Utils.castView(view, R.id.btnCancelAppointment, "field 'btnCancelAppointment'", Button.class);
    view7f0a011f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelTheAppointment();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_reshed_appointment, "field 'btn_reshed_appointment' and method 'reschedTheAppointment'");
    target.btn_reshed_appointment = Utils.castView(view, R.id.btn_reshed_appointment, "field 'btn_reshed_appointment'", Button.class);
    view7f0a0164 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.reschedTheAppointment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MyAppointmentsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.root_parent = null;
    target.doctorIV = null;
    target.appointmentStatusTV = null;
    target.doctorNameTV = null;
    target.educationTV = null;
    target.specializationTV = null;
    target.dependentNameTV = null;
    target.civDependentImage = null;
    target.appointmentTimeTV = null;
    target.btnCancelAppointment = null;
    target.btn_reshed_appointment = null;

    view7f0a011f.setOnClickListener(null);
    view7f0a011f = null;
    view7f0a0164.setOnClickListener(null);
    view7f0a0164 = null;
  }
}
