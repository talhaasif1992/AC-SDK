// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.DependentsView;
import com.vivekkaushik.datepicker.DatePickerTimeline;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BookAppointmentFragment_ViewBinding implements Unbinder {
  private BookAppointmentFragment target;

  @UiThread
  public BookAppointmentFragment_ViewBinding(BookAppointmentFragment target, View source) {
    this.target = target;

    target.tvDoctorName = Utils.findRequiredViewAsType(source, R.id.tv_selected_doctor_name, "field 'tvDoctorName'", TextView.class);
    target.tvDoctorDegree = Utils.findRequiredViewAsType(source, R.id.tv_selected_doctor_degree, "field 'tvDoctorDegree'", TextView.class);
    target.tvDoctorSpeciality = Utils.findRequiredViewAsType(source, R.id.tv_selected_doctor_speciality, "field 'tvDoctorSpeciality'", TextView.class);
    target.tvRating = Utils.findRequiredViewAsType(source, R.id.ratingTV, "field 'tvRating'", TextView.class);
    target.tvReviews = Utils.findRequiredViewAsType(source, R.id.tv_reviews, "field 'tvReviews'", TextView.class);
    target.ciPicture = Utils.findRequiredViewAsType(source, R.id.ci_selected_doctor_picture, "field 'ciPicture'", CircleImageView.class);
    target.datePickerTimeline = Utils.findRequiredViewAsType(source, R.id.datePickerTimeline, "field 'datePickerTimeline'", DatePickerTimeline.class);
    target.rvTimingSlots = Utils.findRequiredViewAsType(source, R.id.rvTimingSlots, "field 'rvTimingSlots'", RecyclerView.class);
    target.tvPickADateFirst = Utils.findRequiredViewAsType(source, R.id.tv_please_select_date_to_see_available_slots, "field 'tvPickADateFirst'", TextView.class);
    target.tvShift = Utils.findRequiredViewAsType(source, R.id.tv_shift, "field 'tvShift'", TextView.class);
    target.ivShiftBack = Utils.findRequiredViewAsType(source, R.id.iv_arrow_shift_left, "field 'ivShiftBack'", ImageView.class);
    target.ivShiftNext = Utils.findRequiredViewAsType(source, R.id.iv_arrow_shift_right, "field 'ivShiftNext'", ImageView.class);
    target.dependentsView = Utils.findRequiredViewAsType(source, R.id.dependentView, "field 'dependentsView'", DependentsView.class);
    target.buttonBookAppointment = Utils.findRequiredViewAsType(source, R.id.btn_book_appointment, "field 'buttonBookAppointment'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BookAppointmentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDoctorName = null;
    target.tvDoctorDegree = null;
    target.tvDoctorSpeciality = null;
    target.tvRating = null;
    target.tvReviews = null;
    target.ciPicture = null;
    target.datePickerTimeline = null;
    target.rvTimingSlots = null;
    target.tvPickADateFirst = null;
    target.tvShift = null;
    target.ivShiftBack = null;
    target.ivShiftNext = null;
    target.dependentsView = null;
    target.buttonBookAppointment = null;
  }
}
