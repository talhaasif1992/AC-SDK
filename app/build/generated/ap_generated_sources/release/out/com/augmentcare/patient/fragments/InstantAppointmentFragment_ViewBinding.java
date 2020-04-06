// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.DependentsView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InstantAppointmentFragment_ViewBinding implements Unbinder {
  private InstantAppointmentFragment target;

  private View view7f0a011f;

  private View view7f0a021d;

  @UiThread
  public InstantAppointmentFragment_ViewBinding(final InstantAppointmentFragment target,
      View source) {
    this.target = target;

    View view;
    target.ivdocImage = Utils.findRequiredViewAsType(source, R.id.doctorImageIV_fia, "field 'ivdocImage'", CircleImageView.class);
    target.doctorNameTV = Utils.findRequiredViewAsType(source, R.id.doctorNameTV_fia, "field 'doctorNameTV'", TextView.class);
    target.doctorEducationTV = Utils.findRequiredViewAsType(source, R.id.educationTV_fia, "field 'doctorEducationTV'", TextView.class);
    target.doctorspecializeTV = Utils.findRequiredViewAsType(source, R.id.specializeTV_fia, "field 'doctorspecializeTV'", TextView.class);
    target.doctorExperienceTV = Utils.findRequiredViewAsType(source, R.id.experienceTV_fia, "field 'doctorExperienceTV'", TextView.class);
    target.doctorRatingRB = Utils.findRequiredViewAsType(source, R.id.doctorRatingRB_fia, "field 'doctorRatingRB'", RatingBar.class);
    target.ratingTV = Utils.findRequiredViewAsType(source, R.id.ratingTV_fia, "field 'ratingTV'", TextView.class);
    target.rlContBookAnAppointment = Utils.findRequiredViewAsType(source, R.id.btn_start_video_appointment, "field 'rlContBookAnAppointment'", Button.class);
    target.btnBookAppointmentLater = Utils.findRequiredViewAsType(source, R.id.btn_book_later, "field 'btnBookAppointmentLater'", Button.class);
    target.startEndTimeTV_fia = Utils.findRequiredViewAsType(source, R.id.startEndTimeTV_fia, "field 'startEndTimeTV_fia'", TextView.class);
    target.daysTV_fia = Utils.findRequiredViewAsType(source, R.id.daysTV_fia, "field 'daysTV_fia'", TextView.class);
    target.doctorFlagIV_fia = Utils.findRequiredViewAsType(source, R.id.doctorFlagIV_fia, "field 'doctorFlagIV_fia'", ImageView.class);
    target.tvInstantDoctor_fia = Utils.findRequiredViewAsType(source, R.id.tvInstantDoctor_fia, "field 'tvInstantDoctor_fia'", TextView.class);
    target.btn_ID = Utils.findRequiredViewAsType(source, R.id.btn_instantID, "field 'btn_ID'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnCancelAppointment, "field 'btnCancelAppointment' and method 'clickCancel'");
    target.btnCancelAppointment = Utils.castView(view, R.id.btnCancelAppointment, "field 'btnCancelAppointment'", Button.class);
    view7f0a011f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickCancel();
      }
    });
    target.callExpectTV = Utils.findRequiredViewAsType(source, R.id.callExpectTV, "field 'callExpectTV'", TextView.class);
    target.tvDay = Utils.findRequiredViewAsType(source, R.id.tvDay, "field 'tvDay'", TextView.class);
    target.tvHrs = Utils.findRequiredViewAsType(source, R.id.tvHrs, "field 'tvHrs'", TextView.class);
    target.tvMins = Utils.findRequiredViewAsType(source, R.id.tvMins, "field 'tvMins'", TextView.class);
    target.tvSecs = Utils.findRequiredViewAsType(source, R.id.tvSecs, "field 'tvSecs'", TextView.class);
    target.bookLaterCV = Utils.findRequiredViewAsType(source, R.id.bookLaterCV, "field 'bookLaterCV'", CardView.class);
    target.tvDepLabel = Utils.findRequiredViewAsType(source, R.id.tvDepLabel, "field 'tvDepLabel'", TextView.class);
    target.dependentsDV = Utils.findRequiredViewAsType(source, R.id.dependentsDV, "field 'dependentsDV'", DependentsView.class);
    view = Utils.findRequiredView(source, R.id.cv_doctor_profile, "method 'openDoctorProfile'");
    view7f0a021d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openDoctorProfile();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    InstantAppointmentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivdocImage = null;
    target.doctorNameTV = null;
    target.doctorEducationTV = null;
    target.doctorspecializeTV = null;
    target.doctorExperienceTV = null;
    target.doctorRatingRB = null;
    target.ratingTV = null;
    target.rlContBookAnAppointment = null;
    target.btnBookAppointmentLater = null;
    target.startEndTimeTV_fia = null;
    target.daysTV_fia = null;
    target.doctorFlagIV_fia = null;
    target.tvInstantDoctor_fia = null;
    target.btn_ID = null;
    target.btnCancelAppointment = null;
    target.callExpectTV = null;
    target.tvDay = null;
    target.tvHrs = null;
    target.tvMins = null;
    target.tvSecs = null;
    target.bookLaterCV = null;
    target.tvDepLabel = null;
    target.dependentsDV = null;

    view7f0a011f.setOnClickListener(null);
    view7f0a011f = null;
    view7f0a021d.setOnClickListener(null);
    view7f0a021d = null;
  }
}
