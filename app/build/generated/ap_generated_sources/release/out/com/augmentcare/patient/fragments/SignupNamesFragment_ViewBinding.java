// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignupNamesFragment_ViewBinding implements Unbinder {
  private SignupNamesFragment target;

  @UiThread
  public SignupNamesFragment_ViewBinding(SignupNamesFragment target, View source) {
    this.target = target;

    target.etxtFirstName = Utils.findRequiredViewAsType(source, R.id.etxtFirstName, "field 'etxtFirstName'", AppCompatEditText.class);
    target.etxtLastName = Utils.findRequiredViewAsType(source, R.id.etxtLastName, "field 'etxtLastName'", AppCompatEditText.class);
    target.btnNext = Utils.findRequiredViewAsType(source, R.id.btnNext, "field 'btnNext'", Button.class);
    target.tvLogin = Utils.findRequiredViewAsType(source, R.id.tv_login, "field 'tvLogin'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignupNamesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etxtFirstName = null;
    target.etxtLastName = null;
    target.btnNext = null;
    target.tvLogin = null;
  }
}
