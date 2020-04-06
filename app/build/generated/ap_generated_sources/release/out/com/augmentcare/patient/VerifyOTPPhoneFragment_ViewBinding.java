// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VerifyOTPPhoneFragment_ViewBinding implements Unbinder {
  private VerifyOTPPhoneFragment target;

  @UiThread
  public VerifyOTPPhoneFragment_ViewBinding(VerifyOTPPhoneFragment target, View source) {
    this.target = target;

    target.txtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.txtPhoneNumber, "field 'txtPhoneNumber'", TextView.class);
    target.txtResendCode = Utils.findRequiredViewAsType(source, R.id.txtResendCode, "field 'txtResendCode'", TextView.class);
    target.txtChangePhone = Utils.findRequiredViewAsType(source, R.id.txtChangePhone, "field 'txtChangePhone'", TextView.class);
    target.layoutPhoneInput = Utils.findRequiredViewAsType(source, R.id.lytPhoneNumber, "field 'layoutPhoneInput'", PhoneInputLayout.class);
    target.otp_view = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otp_view'", OtpView.class);
    target.tvWeSentYouSMS = Utils.findRequiredViewAsType(source, R.id.tv_we_have_sent_you_an_sms_code_at, "field 'tvWeSentYouSMS'", TextView.class);
    target.tvNotYourNumber = Utils.findRequiredViewAsType(source, R.id.tv_not_your_number, "field 'tvNotYourNumber'", TextView.class);
    target.tvDidNotReceiveSMS = Utils.findRequiredViewAsType(source, R.id.tv_did_not_receive_sms, "field 'tvDidNotReceiveSMS'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VerifyOTPPhoneFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtPhoneNumber = null;
    target.txtResendCode = null;
    target.txtChangePhone = null;
    target.layoutPhoneInput = null;
    target.otp_view = null;
    target.tvWeSentYouSMS = null;
    target.tvNotYourNumber = null;
    target.tvDidNotReceiveSMS = null;
  }
}
