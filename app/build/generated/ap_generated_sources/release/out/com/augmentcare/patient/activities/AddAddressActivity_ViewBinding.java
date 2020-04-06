// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatSpinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddAddressActivity_ViewBinding implements Unbinder {
  private AddAddressActivity target;

  @UiThread
  public AddAddressActivity_ViewBinding(AddAddressActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddAddressActivity_ViewBinding(AddAddressActivity target, View source) {
    this.target = target;

    target.btnAddress = Utils.findRequiredViewAsType(source, R.id.btnAdd, "field 'btnAddress'", Button.class);
    target.spnrCity = Utils.findRequiredViewAsType(source, R.id.spnrCity, "field 'spnrCity'", AppCompatSpinner.class);
    target.spnrArea = Utils.findRequiredViewAsType(source, R.id.spnrArea, "field 'spnrArea'", AppCompatSpinner.class);
    target.etxtAddress1 = Utils.findRequiredViewAsType(source, R.id.etxtAddress1, "field 'etxtAddress1'", AutoCompleteTextView.class);
    target.etxtAddress2 = Utils.findRequiredViewAsType(source, R.id.etxtAddress2, "field 'etxtAddress2'", AutoCompleteTextView.class);
    target.contentFrame = Utils.findRequiredView(source, R.id.contentFrame, "field 'contentFrame'");
    target.btnPickLocation = Utils.findRequiredViewAsType(source, R.id.btnPickLocation, "field 'btnPickLocation'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddAddressActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnAddress = null;
    target.spnrCity = null;
    target.spnrArea = null;
    target.etxtAddress1 = null;
    target.etxtAddress2 = null;
    target.contentFrame = null;
    target.btnPickLocation = null;
  }
}
