// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.signup;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.mukesh.OtpView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmailCodeSignUpFragment_ViewBinding implements Unbinder {
  private EmailCodeSignUpFragment target;

  @UiThread
  public EmailCodeSignUpFragment_ViewBinding(EmailCodeSignUpFragment target, View source) {
    this.target = target;

    target.txtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.txtPhoneNumber, "field 'txtPhoneNumber'", TextView.class);
    target.otp_view = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otp_view'", OtpView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EmailCodeSignUpFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtPhoneNumber = null;
    target.otp_view = null;
  }
}
