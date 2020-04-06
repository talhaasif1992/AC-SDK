// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ResetPasswordFragment_ViewBinding implements Unbinder {
  private ResetPasswordFragment target;

  @UiThread
  public ResetPasswordFragment_ViewBinding(ResetPasswordFragment target, View source) {
    this.target = target;

    target.mCrossImageView = Utils.findRequiredViewAsType(source, R.id.mCrossImageView, "field 'mCrossImageView'", ImageView.class);
    target.tvResetByPhoneNumber = Utils.findRequiredViewAsType(source, R.id.tv_reset_by_phone_number, "field 'tvResetByPhoneNumber'", TextView.class);
    target.mEmail = Utils.findRequiredViewAsType(source, R.id.email, "field 'mEmail'", EditText.class);
    target.mResetPassword = Utils.findRequiredView(source, R.id.reset_password, "field 'mResetPassword'");
    target.layoutFormContainer = Utils.findRequiredView(source, R.id.layoutFormContainer, "field 'layoutFormContainer'");
    target.tvSignIn = Utils.findRequiredView(source, R.id.tvSignin, "field 'tvSignIn'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ResetPasswordFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCrossImageView = null;
    target.tvResetByPhoneNumber = null;
    target.mEmail = null;
    target.mResetPassword = null;
    target.layoutFormContainer = null;
    target.tvSignIn = null;
  }
}
