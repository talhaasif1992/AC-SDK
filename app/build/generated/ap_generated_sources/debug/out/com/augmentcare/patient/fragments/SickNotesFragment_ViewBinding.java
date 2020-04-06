// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SickNotesFragment_ViewBinding implements Unbinder {
  private SickNotesFragment target;

  @UiThread
  public SickNotesFragment_ViewBinding(SickNotesFragment target, View source) {
    this.target = target;

    target.mBedRestRelativeLayout = Utils.findRequiredViewAsType(source, R.id.bed_rest_relative_layout, "field 'mBedRestRelativeLayout'", RelativeLayout.class);
    target.mSickNotesRelativeLayout = Utils.findRequiredViewAsType(source, R.id.sick_notes_description_relativelayout, "field 'mSickNotesRelativeLayout'", RelativeLayout.class);
    target.mBedRestTextView = Utils.findRequiredViewAsType(source, R.id.bed_rest_textview, "field 'mBedRestTextView'", TextView.class);
    target.mBedRestDateTextView = Utils.findRequiredViewAsType(source, R.id.bed_rest_date, "field 'mBedRestDateTextView'", TextView.class);
    target.mSicktNotesDescriptionTextView = Utils.findRequiredViewAsType(source, R.id.sick_notes_description_textview, "field 'mSicktNotesDescriptionTextView'", TextView.class);
    target.tvEmptyState = Utils.findRequiredViewAsType(source, R.id.tvSickNoteEmptyState, "field 'tvEmptyState'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SickNotesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBedRestRelativeLayout = null;
    target.mSickNotesRelativeLayout = null;
    target.mBedRestTextView = null;
    target.mBedRestDateTextView = null;
    target.mSicktNotesDescriptionTextView = null;
    target.tvEmptyState = null;
  }
}
