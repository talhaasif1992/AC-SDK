// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.bottomsheets;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointmentTypesBottomSheet_ViewBinding implements Unbinder {
  private AppointmentTypesBottomSheet target;

  @UiThread
  public AppointmentTypesBottomSheet_ViewBinding(AppointmentTypesBottomSheet target, View source) {
    this.target = target;

    target.mMedicalPracticeRecyclerView = Utils.findRequiredViewAsType(source, R.id.medical_practice_listview, "field 'mMedicalPracticeRecyclerView'", RecyclerView.class);
    target.radioButtonOnline = Utils.findRequiredViewAsType(source, R.id.radio_button_online, "field 'radioButtonOnline'", RadioButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AppointmentTypesBottomSheet target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMedicalPracticeRecyclerView = null;
    target.radioButtonOnline = null;
  }
}
