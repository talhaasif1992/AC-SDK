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

public class OTPCodeSignupFragment_ViewBinding implements Unbinder {
  private OTPCodeSignupFragment target;

  @UiThread
  public OTPCodeSignupFragment_ViewBinding(OTPCodeSignupFragment target, View source) {
    this.target = target;

    target.txtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.txtPhoneNumber, "field 'txtPhoneNumber'", TextView.class);
    target.txtResendCode = Utils.findRequiredViewAsType(source, R.id.txtResendCode, "field 'txtResendCode'", TextView.class);
    target.otpView = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otpView'", OtpView.class);
    target.tvWeSentYouSMS = Utils.findRequiredViewAsType(source, R.id.tv_we_have_sent_you_an_sms_code_at, "field 'tvWeSentYouSMS'", TextView.class);
    target.tvDidNotReceiveSMS = Utils.findRequiredViewAsType(source, R.id.tv_did_not_receive_sms, "field 'tvDidNotReceiveSMS'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OTPCodeSignupFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtPhoneNumber = null;
    target.txtResendCode = null;
    target.otpView = null;
    target.tvWeSentYouSMS = null;
    target.tvDidNotReceiveSMS = null;
  }
}
