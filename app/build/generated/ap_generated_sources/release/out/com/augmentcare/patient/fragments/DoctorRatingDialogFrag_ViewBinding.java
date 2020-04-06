// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class DoctorRatingDialogFrag_ViewBinding implements Unbinder {
  private DoctorRatingDialogFrag target;

  private View view7f0a05b1;

  @UiThread
  public DoctorRatingDialogFrag_ViewBinding(final DoctorRatingDialogFrag target, View source) {
    this.target = target;

    View view;
    target.rateConsultTitleTV = Utils.findRequiredViewAsType(source, R.id.rateConsultTitleTV, "field 'rateConsultTitleTV'", TextView.class);
    target.civDoctorPic = Utils.findRequiredViewAsType(source, R.id.civDoctorPic, "field 'civDoctorPic'", CircleImageView.class);
    target.drNameTV = Utils.findRequiredViewAsType(source, R.id.drNameTV, "field 'drNameTV'", TextView.class);
    target.mrbDoctorRate = Utils.findRequiredViewAsType(source, R.id.mrbDoctorRate, "field 'mrbDoctorRate'", MaterialRatingBar.class);
    target.edtRatingComments = Utils.findRequiredViewAsType(source, R.id.edtRatingComments, "field 'edtRatingComments'", AppCompatEditText.class);
    target.appointDescTV = Utils.findRequiredViewAsType(source, R.id.appointDescTV, "field 'appointDescTV'", TextView.class);
    view = Utils.findRequiredView(source, R.id.submitFeedbackBtn, "method 'submitRating'");
    view7f0a05b1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitRating();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DoctorRatingDialogFrag target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rateConsultTitleTV = null;
    target.civDoctorPic = null;
    target.drNameTV = null;
    target.mrbDoctorRate = null;
    target.edtRatingComments = null;
    target.appointDescTV = null;

    view7f0a05b1.setOnClickListener(null);
    view7f0a05b1 = null;
  }
}
