// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ResetPasswordFragmentByPhone_ViewBinding implements Unbinder {
  private ResetPasswordFragmentByPhone target;

  @UiThread
  public ResetPasswordFragmentByPhone_ViewBinding(ResetPasswordFragmentByPhone target,
      View source) {
    this.target = target;

    target.mCrossImageView = Utils.findRequiredViewAsType(source, R.id.mCrossImageView, "field 'mCrossImageView'", ImageView.class);
    target.tvResetByEmail = Utils.findRequiredViewAsType(source, R.id.tv_reset_by_email, "field 'tvResetByEmail'", TextView.class);
    target.layoutPhoneInput = Utils.findRequiredViewAsType(source, R.id.pet_phone_password, "field 'layoutPhoneInput'", PhoneEditTextNew.class);
    target.mResetPassword = Utils.findRequiredView(source, R.id.reset_password, "field 'mResetPassword'");
    target.tvSignIn = Utils.findRequiredView(source, R.id.tvSignin, "field 'tvSignIn'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ResetPasswordFragmentByPhone target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCrossImageView = null;
    target.tvResetByEmail = null;
    target.layoutPhoneInput = null;
    target.mResetPassword = null;
    target.tvSignIn = null;
  }
}
