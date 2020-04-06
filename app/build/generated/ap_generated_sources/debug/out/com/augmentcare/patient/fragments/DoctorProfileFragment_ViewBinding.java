// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.material.tabs.TabLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DoctorProfileFragment_ViewBinding implements Unbinder {
  private DoctorProfileFragment target;

  private View view7f0a011e;

  @UiThread
  public DoctorProfileFragment_ViewBinding(final DoctorProfileFragment target, View source) {
    this.target = target;

    View view;
    target.doctorImageIV = Utils.findRequiredViewAsType(source, R.id.doctorImageIV_fia, "field 'doctorImageIV'", CircleImageView.class);
    target.doctorNameTV_fia = Utils.findRequiredViewAsType(source, R.id.doctorNameTV_fia, "field 'doctorNameTV_fia'", TextView.class);
    target.educationTV_fia = Utils.findRequiredViewAsType(source, R.id.educationTV_fia, "field 'educationTV_fia'", TextView.class);
    target.specializeTV_fia = Utils.findRequiredViewAsType(source, R.id.specializeTV_fia, "field 'specializeTV_fia'", TextView.class);
    target.clinicTV_fia = Utils.findRequiredViewAsType(source, R.id.clinicTV_fia, "field 'clinicTV_fia'", TextView.class);
    target.reviews_fia = Utils.findRequiredViewAsType(source, R.id.reviews_fia, "field 'reviews_fia'", TextView.class);
    target.experienceTV_fia = Utils.findRequiredViewAsType(source, R.id.experienceTV_fia, "field 'experienceTV_fia'", TextView.class);
    target.ratingTV_fia = Utils.findRequiredViewAsType(source, R.id.ratingTV_fia, "field 'ratingTV_fia'", TextView.class);
    target.feesTV_fia = Utils.findRequiredViewAsType(source, R.id.feesTV_fia, "field 'feesTV_fia'", TextView.class);
    target.startEndTimeTV_fia = Utils.findRequiredViewAsType(source, R.id.startEndTimeTV_fia, "field 'startEndTimeTV_fia'", TextView.class);
    target.tvInstantDoctor_fia = Utils.findRequiredViewAsType(source, R.id.tvInstantDoctor_fia, "field 'tvInstantDoctor_fia'", TextView.class);
    target.btn_instantID = Utils.findRequiredViewAsType(source, R.id.btn_instantID, "field 'btn_instantID'", TextView.class);
    target.rl_book_apoint = Utils.findRequiredViewAsType(source, R.id.rl_book_apoint, "field 'rl_book_apoint'", RelativeLayout.class);
    target.doctorRatingRB_fia = Utils.findRequiredViewAsType(source, R.id.doctorRatingRB_fia, "field 'doctorRatingRB_fia'", AppCompatRatingBar.class);
    target.tabs = Utils.findRequiredViewAsType(source, R.id.tabs, "field 'tabs'", TabLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewpager, "field 'viewPager'", ViewPager.class);
    target.tvRatingTitle = Utils.findRequiredViewAsType(source, R.id.tvRating, "field 'tvRatingTitle'", TextView.class);
    target.feeTitleTV = Utils.findRequiredViewAsType(source, R.id.feeTitleTV, "field 'feeTitleTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnBookAppointment, "method 'clickAppointmentBtn'");
    view7f0a011e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickAppointmentBtn();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DoctorProfileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.doctorImageIV = null;
    target.doctorNameTV_fia = null;
    target.educationTV_fia = null;
    target.specializeTV_fia = null;
    target.clinicTV_fia = null;
    target.reviews_fia = null;
    target.experienceTV_fia = null;
    target.ratingTV_fia = null;
    target.feesTV_fia = null;
    target.startEndTimeTV_fia = null;
    target.tvInstantDoctor_fia = null;
    target.btn_instantID = null;
    target.rl_book_apoint = null;
    target.doctorRatingRB_fia = null;
    target.tabs = null;
    target.viewPager = null;
    target.tvRatingTitle = null;
    target.feeTitleTV = null;

    view7f0a011e.setOnClickListener(null);
    view7f0a011e = null;
  }
}
