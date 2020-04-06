package com.augmentcare.patient.fragments;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.SignUpResponse;
import com.augmentcare.patient.network.restApi.apirequests.SignUpRequest;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikepenz.fastadapter.listeners.OnTouchListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class SignupPasswordFragment extends BaseFragment {
    private SignupPasswordFragmentArgs args;
    private NavController mainNav;

    private boolean showConfirmPassword = true;
    private boolean showPassword = true;

    public SignupPasswordFragment(){}

    @BindView(R.id.layout)
    ConstraintLayout lyt;
    @BindView(R.id.etxtPassword)
    AppCompatEditText etxtPassword;
    @BindView(R.id.etxtConfirmPassword)
    AppCompatEditText etxtConfirmPassword;
    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.tv_already_have_an_account)
    TextView alreadyHaveAccountTV;
    @BindView(R.id.passwordInputMeter)
    PasswordStrengthMeter meter;
    //@BindView(R.id.txtTermsAndConditions)
    //TextView txtTermsAndConditions;
    //  @BindView(R.id.lytTerms)
    //View lytTerms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initMe() {
        loadArgs();

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        etxtPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etxtPassword.getRight() - etxtPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showPassword){
                        etxtPassword.setTransformationMethod(null);
                        //etxtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        Drawable img = etxtPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etxtPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = false;
                    }
                    else{
                        etxtPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etxtPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etxtPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        etxtConfirmPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etxtConfirmPassword.getRight() - etxtConfirmPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showConfirmPassword){
                        etxtConfirmPassword.setTransformationMethod(null);
                        Drawable img = etxtConfirmPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etxtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = false;
                    }
                    else{
                        etxtConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etxtConfirmPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etxtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        etxtPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus){
                meter.setEditText(etxtPassword);
                meter.setVisibility(View.VISIBLE);
            }
            else{
                meter.setVisibility(View.INVISIBLE);
            }
        });

        btnNext.setOnClickListener(view -> {
            if (validate() && etxtPassword.getText() != null) {
                signUpAPI(
                        StringUtils.null2Length0(args.getEmail()),
                        StringUtils.null2Length0(etxtPassword.getText().toString()),
                        StringUtils.null2Length0(args.getFName()),
                        StringUtils.null2Length0(args.getLName()),
                        StringUtils.null2Length0(args.getPhone())
                );


            }
        });

        alreadyHaveAccountTV.setOnClickListener(v -> {
            mainNav.navigate(R.id.action_global_loginFragment);
        });

       /* txtTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(baseActivity, TermAndConditionActivity.class);
                baseActivity.startActivity(intent);
            }
        });*/
    }

    private void signUpAPI(String email, String password, String fname, String lname, String phone) {
        if (password != null && email != null && fname != null && lname != null) {
            getDisposer().add(
                    baseActivity.RXAPI.signUp(
                            new SignUpRequest()
                                    .withName(fname + " " + lname)
                                    .withFirstName(fname)
                                    .withLastName(lname)
                                    .withEmail(email)
                                    .withPassword(password)
                                    .withPhone(phone)
                    ).subscribe(res -> SignupPasswordFragment.this.onSignUpResponse(res, email, password, fname, lname, phone), e -> {
                        LocalUtils.processAPIError(e);
                        AnalyticsUtils.signupFail(baseActivity);
                        firebaseEvent("sign_up_fail");
                        baseActivity.onBackPressed(); // navigate to Email fragment
                    })
            );
        } else {
            Toasty.error(Utils.getApp(), "Fill all credentials to sign up...").show();
        }
    }

    private void onSignUpResponse(
            final SignUpResponse response,
            String email,
            final String password,
            final String fname,
            final String lname,
            final String phone
    ){
        if (response != null) {
            AnalyticsUtils.signupSuccess(baseActivity);
            firebaseEvent("signup_success");
            MyApp.get().adjustEvent(getString(R.string.adjust_signup_success));

            FirebaseAnalytics.getInstance(baseActivity)
                    .setUserProperty(
                            FirebaseEvents.REGISTER_PROP,
                            String.valueOf(true)
                    );
            PrefsHelper.get(baseActivity).putString("otpFirstName", fname);
            PrefsHelper.get(baseActivity).putString("otpLastName", lname);
            PrefsHelper.get(baseActivity).putString("otpPhone", phone);

            String resEmail = "";

            LogUtils.d("server email:",LocalUtils.getOr(response.getEmail(),""));
            LogUtils.d("Local email:",LocalUtils.getOr(email,""));

            if(StringUtils.isEmpty(response.getEmail())){
                if(StringUtils.isEmpty(email)){
                    Toasty.error(Utils.getApp(),"Masla").show();
                    return;
                }else{
                    resEmail = email;
                }
            }else{
                resEmail = response.getEmail();
            }


            if (resEmail.length() > 0){
                PrefsHelper.get(baseActivity).putString("otpEmail", resEmail);
            }
            else{
                resEmail = resEmail.replace("\"", "");
                PrefsHelper.get(baseActivity).putString("otpEmail", resEmail);
            }

//            resendOTP_API(email, phone, () -> {
                if(etxtPassword.getText() != null) {
                    mainNav.navigate(
                            SignupPasswordFragmentDirections.actionSignupPasswordFragmentToOTPFragment(
                                    StringUtils.null2Length0(etxtPassword.getText().toString()),
                                    resEmail,
                                    phone
                            ).setIsForgotPassword(false)
                                    .setIsGoogleSignUp(false)
                            .setFromSignUpFlow(true)
                    );
                }
//            });
            GenApiLogger.fireCompleterRegistrationEmailEvent(response);

        } else {
            Toasty.warning(Utils.getApp(), R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = SignupPasswordFragmentArgs.fromBundle(getArguments());
        }
    }

    private void resendOTP_API(String email, String phone,Runnable onDone) {
        getDisposer().add(
                baseActivity.RXAPI.resendOTP(email, phone)
                        .subscribe(sent -> {
                            if (sent) {
                                Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
                            }

                            onDone.run();
                        }, LocalUtils::processAPIError)
        );

    }

    private boolean validate() {
        if (etxtPassword.getText() == null || etxtConfirmPassword.getText() == null) return false;

        String password = etxtPassword.getText().toString().trim();
        String rePassword = etxtConfirmPassword.getText().toString().trim();

        if (password.isEmpty()) {
            Toasty.info(Utils.getApp(), getString(R.string.please_insert_password), Toast.LENGTH_LONG, false).show();
            return false;
        }

        if (password.length() < 8) {
            Toasty.info(Utils.getApp(), getString(R.string.password_length_short), Toast.LENGTH_LONG, false).show();
            return false;
        }

        if (rePassword.isEmpty()) {
            Toasty.info(Utils.getApp(), getString(R.string.please_insert_password), Toast.LENGTH_LONG, false).show();
            return false;
        }

        if (!password.equals(rePassword)) {
            Toasty.info(Utils.getApp(), getString(R.string.enter_same_password), Toast.LENGTH_LONG, false).show();
            etxtConfirmPassword.setText("");
            return false;
        }

        return true;
    }

    private void firebaseEvent(String type) {
        GenApiLogger.fireGenericSignupPassword(baseActivity,type);

    }
}