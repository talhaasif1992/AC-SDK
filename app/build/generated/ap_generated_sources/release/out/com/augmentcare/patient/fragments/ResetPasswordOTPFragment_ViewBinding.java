// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;
import java.lang.IllegalStateException;
import java.lang.Override;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class ResetPasswordOTPFragment_ViewBinding implements Unbinder {
  private ResetPasswordOTPFragment target;

  @UiThread
  public ResetPasswordOTPFragment_ViewBinding(ResetPasswordOTPFragment target, View source) {
    this.target = target;

    target.tvSentYouCode = Utils.findRequiredViewAsType(source, R.id.tv_we_have_sent_you_an_sms_code_at, "field 'tvSentYouCode'", TextView.class);
    target.tvNotYourNumber = Utils.findRequiredViewAsType(source, R.id.tv_not_your_number, "field 'tvNotYourNumber'", TextView.class);
    target.tvDidNotReceive = Utils.findRequiredViewAsType(source, R.id.tv_did_not_receive_sms, "field 'tvDidNotReceive'", TextView.class);
    target.txtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.txtPhoneNumber, "field 'txtPhoneNumber'", TextView.class);
    target.txtResendCode = Utils.findRequiredViewAsType(source, R.id.txtResendCode, "field 'txtResendCode'", TextView.class);
    target.txtChangePhone = Utils.findRequiredViewAsType(source, R.id.txtChangePhone, "field 'txtChangePhone'", TextView.class);
    target.layoutPhoneInput = Utils.findRequiredViewAsType(source, R.id.lytPhoneNumber, "field 'layoutPhoneInput'", PhoneInputLayout.class);
    target.otp_view = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otp_view'", OtpView.class);
    target.etNewPassword = Utils.findRequiredViewAsType(source, R.id.et_new_password, "field 'etNewPassword'", EditText.class);
    target.etConfirmNewPassword = Utils.findRequiredViewAsType(source, R.id.et_confirm_new_password, "field 'etConfirmNewPassword'", EditText.class);
    target.btnNext = Utils.findRequiredView(source, R.id.btnNext, "field 'btnNext'");
    target.meter = Utils.findRequiredViewAsType(source, R.id.passwordInputMeter, "field 'meter'", PasswordStrengthMeter.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ResetPasswordOTPFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSentYouCode = null;
    target.tvNotYourNumber = null;
    target.tvDidNotReceive = null;
    target.txtPhoneNumber = null;
    target.txtResendCode = null;
    target.txtChangePhone = null;
    target.layoutPhoneInput = null;
    target.otp_view = null;
    target.etNewPassword = null;
    target.etConfirmNewPassword = null;
    target.btnNext = null;
    target.meter = null;
  }
}
