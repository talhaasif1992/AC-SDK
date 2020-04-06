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

public class LabAndMedsPreviewListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private LabAndMedsPreviewListAdapter.ViewHolder target;

  @UiThread
  public LabAndMedsPreviewListAdapter$ViewHolder_ViewBinding(
      LabAndMedsPreviewListAdapter.ViewHolder target, View source) {
    this.target = target;

    target.txtMedicine = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtMedicine'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txtQty1, "field 'txtPrice'", TextView.class);
    target.mInstructionTitleTextView = Utils.findRequiredViewAsType(source, R.id.instruction_title, "field 'mInstructionTitleTextView'", TextView.class);
    target.mInstructionTextView = Utils.findRequiredViewAsType(source, R.id.instructions_textview, "field 'mInstructionTextView'", TextView.class);
    target.ivIcon = Utils.findRequiredView(source, R.id.ivIcon, "field 'ivIcon'");
  }

  @Override
  @CallSuper
  public void unbind() {
    LabAndMedsPreviewListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtMedicine = null;
    target.txtPrice = null;
    target.mInstructionTitleTextView = null;
    target.mInstructionTextView = null;
    target.ivIcon = null;
  }
}
