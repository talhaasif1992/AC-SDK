// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentDetailsFragment_ViewBinding implements Unbinder {
  private AppointmentDetailsFragment target;

  @UiThread
  public AppointmentDetailsFragment_ViewBinding(AppointmentDetailsFragment target, View source) {
    this.target = target;

    target.civDoctorPic = Utils.findRequiredViewAsType(source, R.id.civDoctorPic, "field 'civDoctorPic'", CircleImageView.class);
    target.tvDoctorName = Utils.findRequiredViewAsType(source, R.id.tvDoctorName, "field 'tvDoctorName'", TextView.class);
    target.doctorDeegreeTV = Utils.findRequiredViewAsType(source, R.id.doctorDeegreeTV, "field 'doctorDeegreeTV'", TextView.class);
    target.doctorSpecTV = Utils.findRequiredViewAsType(source, R.id.doctorSpecTV, "field 'doctorSpecTV'", TextView.class);
    target.ratingTV = Utils.findRequiredViewAsType(source, R.id.ratingTV, "field 'ratingTV'", RatingBar.class);
    target.cvBookingDateTime = Utils.findRequiredViewAsType(source, R.id.cvBookingDateTime, "field 'cvBookingDateTime'", CardView.class);
    target.bookingDateTV = Utils.findRequiredViewAsType(source, R.id.bookingDateTV, "field 'bookingDateTV'", TextView.class);
    target.bookingStartEndTimeTV = Utils.findRequiredViewAsType(source, R.id.bookingStartEndTimeTV, "field 'bookingStartEndTimeTV'", TextView.class);
    target.cvComplains = Utils.findRequiredViewAsType(source, R.id.cvComplains, "field 'cvComplains'", CardView.class);
    target.complainsTV = Utils.findRequiredViewAsType(source, R.id.complainsTV, "field 'complainsTV'", TextView.class);
    target.cvInstructions = Utils.findRequiredViewAsType(source, R.id.cvInstructions, "field 'cvInstructions'", CardView.class);
    target.instructionsTV = Utils.findRequiredViewAsType(source, R.id.instructionsTV, "field 'instructionsTV'", TextView.class);
    target.cvDiagnosis = Utils.findRequiredViewAsType(source, R.id.cvDiagnosis, "field 'cvDiagnosis'", CardView.class);
    target.diagnosisTV = Utils.findRequiredViewAsType(source, R.id.diagnosisTV, "field 'diagnosisTV'", TextView.class);
    target.cvPrescriptions = Utils.findRequiredViewAsType(source, R.id.cvPrescriptions, "field 'cvPrescriptions'", CardView.class);
    target.prescriptionsTitleTV = Utils.findRequiredViewAsType(source, R.id.prescriptionsTitleTV, "field 'prescriptionsTitleTV'", TextView.class);
    target.rvPrescriptionMeds = Utils.findRequiredViewAsType(source, R.id.rvPrescriptionMeds, "field 'rvPrescriptionMeds'", RecyclerView.class);
    target.cvLabTests = Utils.findRequiredViewAsType(source, R.id.cvLabTests, "field 'cvLabTests'", CardView.class);
    target.rvLabTests = Utils.findRequiredViewAsType(source, R.id.rvLabTests, "field 'rvLabTests'", RecyclerView.class);
    target.cvTotalForMedsAndTest = Utils.findRequiredViewAsType(source, R.id.cvTotalForMedsAndTest, "field 'cvTotalForMedsAndTest'", CardView.class);
    target.totalMoneyTitleTV = Utils.findRequiredViewAsType(source, R.id.totalMoneyTitleTV, "field 'totalMoneyTitleTV'", TextView.class);
    target.totalPriceTV = Utils.findRequiredViewAsType(source, R.id.totalPriceTV, "field 'totalPriceTV'", TextView.class);
    target.clBottomOrderBTN = Utils.findRequiredViewAsType(source, R.id.clBottomOrderBTN, "field 'clBottomOrderBTN'", ConstraintLayout.class);
    target.btnSickNotes = Utils.findRequiredViewAsType(source, R.id.btnSickNotes, "field 'btnSickNotes'", TextView.class);
    target.fbDownload = Utils.findRequiredViewAsType(source, R.id.fbDownload, "field 'fbDownload'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AppointmentDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.civDoctorPic = null;
    target.tvDoctorName = null;
    target.doctorDeegreeTV = null;
    target.doctorSpecTV = null;
    target.ratingTV = null;
    target.cvBookingDateTime = null;
    target.bookingDateTV = null;
    target.bookingStartEndTimeTV = null;
    target.cvComplains = null;
    target.complainsTV = null;
    target.cvInstructions = null;
    target.instructionsTV = null;
    target.cvDiagnosis = null;
    target.diagnosisTV = null;
    target.cvPrescriptions = null;
    target.prescriptionsTitleTV = null;
    target.rvPrescriptionMeds = null;
    target.cvLabTests = null;
    target.rvLabTests = null;
    target.cvTotalForMedsAndTest = null;
    target.totalMoneyTitleTV = null;
    target.totalPriceTV = null;
    target.clBottomOrderBTN = null;
    target.btnSickNotes = null;
    target.fbDownload = null;
  }
}
