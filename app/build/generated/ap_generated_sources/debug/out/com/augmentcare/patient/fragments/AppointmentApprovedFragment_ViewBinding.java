// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
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

public class AppointmentApprovedFragment_ViewBinding implements Unbinder {
  private AppointmentApprovedFragment target;

  private View view7f0a014c;

  private View view7f0a0165;

  @UiThread
  public AppointmentApprovedFragment_ViewBinding(final AppointmentApprovedFragment target,
      View source) {
    this.target = target;

    View view;
    target.tvDoctorName = Utils.findRequiredViewAsType(source, R.id.tvDoctorName, "field 'tvDoctorName'", TextView.class);
    target.tvDoctorDegree = Utils.findRequiredViewAsType(source, R.id.doctorDeegreeTV, "field 'tvDoctorDegree'", TextView.class);
    target.tvDoctorSpeciality = Utils.findRequiredViewAsType(source, R.id.doctorSpecTV, "field 'tvDoctorSpeciality'", TextView.class);
    target.ciDoctorPicture = Utils.findRequiredViewAsType(source, R.id.civ_doctor_profile_pic, "field 'ciDoctorPicture'", CircleImageView.class);
    target.tvPateintName = Utils.findRequiredViewAsType(source, R.id.tv_patient_name, "field 'tvPateintName'", TextView.class);
    target.tvDate = Utils.findRequiredViewAsType(source, R.id.bookingDateTV, "field 'tvDate'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.bookingStartEndTimeTV, "field 'tvTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_cancel_appointment, "method 'cancelAppointment'");
    view7f0a014c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelAppointment();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_reshedule, "method 'rescheduleAppointment'");
    view7f0a0165 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rescheduleAppointment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AppointmentApprovedFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDoctorName = null;
    target.tvDoctorDegree = null;
    target.tvDoctorSpeciality = null;
    target.ciDoctorPicture = null;
    target.tvPateintName = null;
    target.tvDate = null;
    target.tvTime = null;

    view7f0a014c.setOnClickListener(null);
    view7f0a014c = null;
    view7f0a0165.setOnClickListener(null);
    view7f0a0165 = null;
  }
}
