// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.gms.common.SignInButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  private View view7f0a012a;

  @UiThread
  public LoginFragment_ViewBinding(final LoginFragment target, View source) {
    this.target = target;

    View view;
    target.ivBack = Utils.findRequiredViewAsType(source, R.id.iv_back_arrow, "field 'ivBack'", ImageView.class);
    target.mEmailView = Utils.findRequiredViewAsType(source, R.id.email, "field 'mEmailView'", EditText.class);
    target.mPasswordView = Utils.findRequiredViewAsType(source, R.id.password, "field 'mPasswordView'", EditText.class);
    target.mLoginFormView = Utils.findRequiredView(source, R.id.email_login_form, "field 'mLoginFormView'");
    target.btnGoogle = Utils.findRequiredViewAsType(source, R.id.btn_google, "field 'btnGoogle'", Button.class);
    view = Utils.findRequiredView(source, R.id.btnGoogleSignin, "field 'btnGoogleSignin' and method 'clickGoogleLogin'");
    target.btnGoogleSignin = Utils.castView(view, R.id.btnGoogleSignin, "field 'btnGoogleSignin'", SignInButton.class);
    view7f0a012a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickGoogleLogin();
      }
    });
    target.tvRegisterNow = Utils.findRequiredViewAsType(source, R.id.tv_register_now, "field 'tvRegisterNow'", TextView.class);
    target.btnSignIn = Utils.findRequiredViewAsType(source, R.id.email_sign_in_button, "field 'btnSignIn'", Button.class);
    target.mForgotPassowrd = Utils.findRequiredViewAsType(source, R.id.tvForgot, "field 'mForgotPassowrd'", TextView.class);
    target.cb_remember_me = Utils.findRequiredViewAsType(source, R.id.cb_remember_me, "field 'cb_remember_me'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBack = null;
    target.mEmailView = null;
    target.mPasswordView = null;
    target.mLoginFormView = null;
    target.btnGoogle = null;
    target.btnGoogleSignin = null;
    target.tvRegisterNow = null;
    target.btnSignIn = null;
    target.mForgotPassowrd = null;
    target.cb_remember_me = null;

    view7f0a012a.setOnClickListener(null);
    view7f0a012a = null;
  }
}
