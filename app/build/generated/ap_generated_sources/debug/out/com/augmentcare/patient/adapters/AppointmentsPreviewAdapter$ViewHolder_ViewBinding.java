// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentsPreviewAdapter$ViewHolder_ViewBinding implements Unbinder {
  private AppointmentsPreviewAdapter.ViewHolder target;

  private View view7f0a048f;

  @UiThread
  public AppointmentsPreviewAdapter$ViewHolder_ViewBinding(
      final AppointmentsPreviewAdapter.ViewHolder target, View source) {
    this.target = target;

    View view;
    target.cv_doctor = Utils.findRequiredViewAsType(source, R.id.cv_doctor, "field 'cv_doctor'", CardView.class);
    target.civDoctorImage = Utils.findRequiredViewAsType(source, R.id.civDoctorImage, "field 'civDoctorImage'", CircleImageView.class);
    target.approvedForTV = Utils.findRequiredViewAsType(source, R.id.approvedForTV, "field 'approvedForTV'", TextView.class);
    target.doctorNameTV = Utils.findRequiredViewAsType(source, R.id.doctorNameTV, "field 'doctorNameTV'", TextView.class);
    target.appointmentTimeTV = Utils.findRequiredViewAsType(source, R.id.appointmentDateTimeTV, "field 'appointmentTimeTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.nextAppointTV, "method 'scrollToNextAppointment'");
    view7f0a048f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.scrollToNextAppointment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AppointmentsPreviewAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cv_doctor = null;
    target.civDoctorImage = null;
    target.approvedForTV = null;
    target.doctorNameTV = null;
    target.appointmentTimeTV = null;

    view7f0a048f.setOnClickListener(null);
    view7f0a048f = null;
  }
}
