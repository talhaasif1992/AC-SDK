// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.bottomsheets;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConsultationPreviewDialogFragment_ViewBinding implements Unbinder {
  private ConsultationPreviewDialogFragment target;

  @UiThread
  public ConsultationPreviewDialogFragment_ViewBinding(ConsultationPreviewDialogFragment target,
      View source) {
    this.target = target;

    target.goBackLL = Utils.findRequiredViewAsType(source, R.id.goBackLL, "field 'goBackLL'", LinearLayout.class);
    target.ivThumb = Utils.findRequiredViewAsType(source, R.id.ivThumb, "field 'ivThumb'", CircularImageView.class);
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.txtTimeAndDate = Utils.findRequiredViewAsType(source, R.id.txtTimeAndDate, "field 'txtTimeAndDate'", TextView.class);
    target.callExpectTV = Utils.findRequiredViewAsType(source, R.id.callExpectTV, "field 'callExpectTV'", TextView.class);
    target.btnReject = Utils.findRequiredViewAsType(source, R.id.btnReject, "field 'btnReject'", Button.class);
    target.btnGoHome = Utils.findRequiredViewAsType(source, R.id.btnGoHome, "field 'btnGoHome'", Button.class);
    target.txtConnectingTimer = Utils.findRequiredViewAsType(source, R.id.txtConnectingTimer, "field 'txtConnectingTimer'", TextView.class);
    target.tvConnectingInLabel = Utils.findRequiredViewAsType(source, R.id.tv_connecting_in_label, "field 'tvConnectingInLabel'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConsultationPreviewDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.goBackLL = null;
    target.ivThumb = null;
    target.txtName = null;
    target.txtTimeAndDate = null;
    target.callExpectTV = null;
    target.btnReject = null;
    target.btnGoHome = null;
    target.txtConnectingTimer = null;
    target.tvConnectingInLabel = null;
  }
}
