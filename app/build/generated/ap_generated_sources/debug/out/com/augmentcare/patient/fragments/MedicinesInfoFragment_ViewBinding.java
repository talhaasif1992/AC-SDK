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

public class MedicinesInfoFragment_ViewBinding implements Unbinder {
  private MedicinesInfoFragment target;

  @UiThread
  public MedicinesInfoFragment_ViewBinding(MedicinesInfoFragment target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvNote = Utils.findRequiredViewAsType(source, R.id.note, "field 'tvNote'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MedicinesInfoFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvNote = null;
  }
}
