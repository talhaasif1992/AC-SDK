// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LabReportsPreviewAdapter$ViewHolder_ViewBinding implements Unbinder {
  private LabReportsPreviewAdapter.ViewHolder target;

  @UiThread
  public LabReportsPreviewAdapter$ViewHolder_ViewBinding(LabReportsPreviewAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.txtLabReportName = Utils.findRequiredViewAsType(source, R.id.txtLabReportName, "field 'txtLabReportName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LabReportsPreviewAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtLabReportName = null;
  }
}
