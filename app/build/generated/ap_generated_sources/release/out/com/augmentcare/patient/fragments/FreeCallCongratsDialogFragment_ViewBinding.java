// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FreeCallCongratsDialogFragment_ViewBinding implements Unbinder {
  private FreeCallCongratsDialogFragment target;

  @UiThread
  public FreeCallCongratsDialogFragment_ViewBinding(FreeCallCongratsDialogFragment target,
      View source) {
    this.target = target;

    target.tvCongratsUser = Utils.findRequiredViewAsType(source, R.id.tv_congrats, "field 'tvCongratsUser'", TextView.class);
    target.tvNote = Utils.findRequiredViewAsType(source, R.id.tv_you_are_going_to_make_your_first_free_call, "field 'tvNote'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FreeCallCongratsDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCongratsUser = null;
    target.tvNote = null;
  }
}
