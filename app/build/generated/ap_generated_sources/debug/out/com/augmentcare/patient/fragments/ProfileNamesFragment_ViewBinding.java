// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileNamesFragment_ViewBinding implements Unbinder {
  private ProfileNamesFragment target;

  @UiThread
  public ProfileNamesFragment_ViewBinding(ProfileNamesFragment target, View source) {
    this.target = target;

    target.etxtFirstName = Utils.findRequiredViewAsType(source, R.id.etxtFirstName, "field 'etxtFirstName'", AppCompatEditText.class);
    target.layoutFirstName = Utils.findRequiredViewAsType(source, R.id.layoutFirstName, "field 'layoutFirstName'", TextInputLayout.class);
    target.etxtLastName = Utils.findRequiredViewAsType(source, R.id.etxtLastName, "field 'etxtLastName'", AppCompatEditText.class);
    target.layoutLastName = Utils.findRequiredViewAsType(source, R.id.layoutLastName, "field 'layoutLastName'", TextInputLayout.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileNamesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etxtFirstName = null;
    target.layoutFirstName = null;
    target.etxtLastName = null;
    target.layoutLastName = null;
    target.btnNext = null;
  }
}
