package com.augmentcare.patient.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.GoogleSignInUtils;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.apache.commons.lang3.math.NumberUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.identity.Registration;

public class LoginFragment extends BaseFragment {
    private boolean showPassword=true;

    @BindView(R.id.iv_back_arrow)
    ImageView ivBack;
    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.email_login_form)
    View mLoginFormView;
    @BindView(R.id.btn_google)
    Button btnGoogle;
    @BindView(R.id.btnGoogleSignin)
    SignInButton btnGoogleSignin;
    @BindView(R.id.tv_register_now)
    TextView tvRegisterNow;
    @BindView(R.id.email_sign_in_button)
    Button btnSignIn;
    @BindView(R.id.tvForgot)
    TextView mForgotPassowrd;
    @BindView(R.id.cb_remember_me)
    CheckBox cb_remember_me;
    private View rootView;
    private NavController mainNav;
    private GoogleSignInUtils signInUtils;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        if(!PrefsHelper.isRememberMe()){
            ((HomeScreenActivity)baseActivity).logout();
        }

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        mPasswordView.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (mPasswordView.getRight() - mPasswordView.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showPassword){
                        mPasswordView.setTransformationMethod(null);
                        //etxtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        Drawable img = mPasswordView.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        mPasswordView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = false;
                    }
                    else{
                        mPasswordView.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = mPasswordView.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        mPasswordView.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        ViewUtils.setGooglePlusButtonText(
                btnGoogleSignin,
                getString(R.string.label_google_signin)
        );

        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
            if (id == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });

        btnSignIn.setOnClickListener(view -> {
            PrefsHelper.setRemeberMe(cb_remember_me.isChecked());
            attemptLogin();
        });

        btnGoogle.setOnClickListener(v -> btnGoogleSignin.performClick());
        ivBack.setOnClickListener(view -> baseActivity.onBackPressed());


        btnGoogle.setOnClickListener(v -> {
            PrefsHelper.setRemeberMe(true);
            clickGoogleLogin();
        });

        tvRegisterNow.setOnClickListener(view -> {


            GenApiLogger.fireRegister();

            mainNav.navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment());
        });

        mForgotPassowrd.setOnClickListener(view -> {
//            mainNav.navigate(ResetPasswordFragmentDirections
//                    .actionResetPasswordFragmentToResetPasswordFragmentByPhone()
//            );

            mainNav.navigate(LoginFragmentDirections.actionLoginFragmentToResetPasswordFragmentByPhone());
        });

        cb_remember_me.setOnCheckedChangeListener((buttonView, isChecked) -> {
            PrefsHelper.setRemeberMe(isChecked);
        });

        cb_remember_me.setChecked(PrefsHelper.isRememberMe());


        AppSocket.getInstance(MyApp.get())
                .getSocket().emit(
                "remote_end_call_event_emit_from_chat",
                ""
        );

        signInUtils = GoogleSignInUtils.getInstance(baseActivity,BuildConfig.REQUEST_ID_TOKEN);

        setBackPress(false,() -> {
            mainNav.navigate(R.id.signInSignUpActivity);
        });

    }

    @OnClick(R.id.btnGoogleSignin)
    void clickGoogleLogin() {
        AnalyticsUtils.googleSigninClick(
                baseActivity,
                "Login"
        );

        GenApiLogger.fireLogin();



        signInUtils.signOut(v -> {
            signInUtils.signInWithinFragment(this,account -> {
                if (account != null) {
                    account.getEmail();
                    if (!StringUtils.isEmpty(account.getEmail()))
                        PrefsHelper.get(baseActivity).putString(Constants.KEY_EMAIL_GOOGLE_SIGN_IN, account.getEmail());
                }

                String gotToken = account != null ? StringUtils.null2Length0(account.getIdToken()) : "";
                baseActivity.showLoader();
                googleAPICall(gotToken, () -> {
                    PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);
                    mainNav.navigate(R.id.action_global_dashboardFragment2);
                });
            });
        });
//        ActivityUtils.startActivity(GoogleSigninActivity.class);
    }

    private void googleAPICall(String googleResultToken, Runnable done) {
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .flatMap(token -> baseActivity.RXAPI.loginGoogle(googleResultToken, token))
                        .subscribe(
                                userLogin -> {
                                    googleSignInResp(userLogin, done);
                                },
                                e -> {
                                    LocalUtils.processAPIError(e);
                                    AnalyticsUtils.googleSigninFail(
                                            baseActivity,
                                            "invalid_response"
                                    );
                                    firebaseEvent("gsign_in_fail");


//                                    ActivityUtils.startActivity(LoginFragment.class);
                                })
        );
    }

    private void googleSignInResp(UserLogin userLogin, Runnable done) {
        if (userLogin.getUserData() != null && StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) { // if user phone is not verified
            Toasty.info(baseActivity, "Please verify your phone number to continue.", Toast.LENGTH_LONG, false).show();
            SignupEmailFragmentArgs args =
                    new SignupEmailFragmentArgs.Builder(userLogin.getUserData().getFirstName(),userLogin.getUserData().getLastName(),userLogin.getUserData().getEmail(),userLogin.getUserData().getPhone())
                            .setFromSignupFlow(false)
                            .build();

//            mainNav.navigate(R.id.action_loginFragment_to_login_otp_verification_navigation,args.toBundle());

            mainNav.setGraph(R.navigation.login_otp_verification_navigation,args.toBundle());
        } else if (userLogin.getUserData() != null && userLogin.getRoles() != null && !StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) {

            PrefsHelper.setLoggedInUser(userLogin);
            PrefsHelper.setUserInfo(userLogin.getUserData());

            if (!BuildConfig.DEBUG)
                AnalyticsUtils.googleSigninSuccess(
                        baseActivity,
                        ""
                );

            firebaseEvent("gsign_in_success");

            MyApp.get().adjustEvent(getString(R.string.adjust_signin_success));

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, userLogin.isIsOnPlan());
            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

            if (LocalUtils.isThisUserType("PATIENT")) {
                if (userLogin.getDependents() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
                }

                PrefsHelper.get(baseActivity).putString(Constants.KEY_PLAN_ID, userLogin.getPlanId500() + "");

                MyApp.get().setOrganization(userLogin.getOrganization());

                if (userLogin.getPolicy() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
                }

                firebaseEvent("gsing_in_click");

                if (!BuildConfig.DEBUG)
                    FirebaseAnalytics.getInstance(baseActivity)
                            .setUserProperty(
                                    FirebaseEvents.GSIGNIN_PROP,
                                    String.valueOf(true)
                            );


                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);

                if (baseActivity.userData != null && baseActivity.userData.getUserId() >= 0) {
                    Registration registration = Registration.create().withUserId("" + baseActivity.userData.getUserId());
                    Intercom.client().registerIdentifiedUser(registration);

                    if (baseActivity.userData.getAndroidhmc() != null && !baseActivity.userData.getAndroidhmc().isEmpty())
                        Intercom.client().setUserHash(baseActivity.userData.getAndroidhmc());

                    UserAttributes userAttributes =
                            new UserAttributes.Builder()
                                    .withName((baseActivity.userData.getFirstName() + " "
                                            + baseActivity.userData.getLastName()))
                                    .withEmail(baseActivity.userData.getEmail())
                                    .withCustomAttribute("Phone", baseActivity.userData.getPhone())
                                    .build();
                    Intercom.client().updateUser(userAttributes);
                } else {
                    /* Since we aren't logged in, we are an unidentified user.
                     * Let's register. */
                    Intercom.client().registerUnidentifiedUser();
                }
                AppSocket.getInstance(MyApp.get()).getSocket().disconnect();
            }

            GenApiLogger.fireCompleterRegistrationEvent(userLogin);

            done.run();
        } else {
            AnalyticsUtils.googleSigninFail(
                    baseActivity,
                    "invalid_response"
            );
            Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
            firebaseEvent("gsign_in_fail");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        signInUtils.onActivityResult(requestCode, resultCode, data);
    }

    private void attemptLogin() {
        GenApiLogger.fireLogin();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        // Check for a valid password, if the user entered one.
        if (email.length() == 0) {
            Toasty.warning(baseActivity, R.string.provide_email_number, Toast.LENGTH_LONG, false).show();
            mEmailView.requestFocus();
            return;
        }

        if (password.length() == 0) {
            Toasty.warning(baseActivity, R.string.provide_password, Toast.LENGTH_LONG, false).show();
            mPasswordView.requestFocus();
            return;
        }

        AnalyticsUtils.signinClick(baseActivity);
        firebaseEvent("sign_in_click");
        KeyboardUtils.hideSoftInput(mEmailView);


//        getDisposer().add(
//                RXAPI.loginNormal(email.trim(),password)
//                        .subscribe(doctorDetail -> {
//                            Intent intent = new Intent(this, HomeScreenActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }, e -> {
//                            LogUtils.e(e);
//                            Toasty.error(this, e.getMessage(), Toast.LENGTH_LONG, false).show();
//                        }));


        doNormalLogin(email, password);
    }

    private void doNormalLogin(String email, String password) {

        getDisposer().add(
                baseActivity.RXAPI.loginNormal(email.trim(), password)
                        .subscribe(res -> {
                            onLogginResponse(res);
                        }, e -> {
//                            LogUtils.e(e);
//                            LocalUtils.processAPIError(e);
                            baseActivity.stopLoader();
                            if (NetworkUtils.isConnected()) {
                                Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
                            } else {
                                Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
                            }
                        })
        );
    }

    private void onLogginResponse(UserLogin userLogin) {

        if (userLogin.getUserData() != null && StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) { // if user phone is not verified

            Toasty.info(baseActivity, "Please verify your phone number to continue.", Toast.LENGTH_LONG, false).show();
            SignupEmailFragmentArgs args =
                    new SignupEmailFragmentArgs.Builder(userLogin.getUserData().getFirstName(),userLogin.getUserData().getLastName(),userLogin.getUserData().getEmail(),userLogin.getUserData().getPhone())
                            .setFromSignupFlow(false)
                            .build();
            mainNav.setGraph(R.navigation.login_otp_verification_navigation,args.toBundle());

        } else if (userLogin.getUserData() != null && userLogin.getRoles() != null && !StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) {
            PrefsHelper.setLoggedInUser(userLogin);
            PrefsHelper.setUserInfo(userLogin.getUserData());

            GenApiLogger.fireOrginizationPhoneVirefied(userLogin);

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, userLogin.isIsOnPlan());
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_FROM_ORGANIZATION, userLogin.isFromOrganization());
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_DEPENDENT, userLogin.isIsDependent());

            PrefsHelper.get(baseActivity).putString(Constants.KEY_PART_OF_PROJECT, StringUtils.null2Length0(userLogin.getUserData().getPartOfProject()));

            if (LocalUtils.isThisUserType("HR")) {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_HR, true);

                callUpdateUserInfoAPI(userLogin.getUserData().getUserType()); // this method calls login api again
                return;
            }

            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

            if (userLogin.getDependents() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
            }


            MyApp.get().setOrganization(userLogin.getOrganization());


            if (userLogin.getPolicy() != null) {
                GenApiLogger.fireisPoicy(userLogin.getUserData().getId(),"true");
                PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
            } else {
                GenApiLogger.fireisPoicy(userLogin.getUserData().getId(),"false");
                PrefsHelper.get(baseActivity).remove(Constants.KEY_POLICY);
            }

            if ((LocalUtils.isThisUserType("PATIENT"))) {
                PrefsHelper.setUserInfo(userLogin.getUserData());

                PrefsHelper.get(baseActivity).putString(Constants.KEY_PLAN_ID, userLogin.getPlanId500() + "");

                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);

                if (baseActivity.userData != null && baseActivity.userData.getUserId() >= 0) {
                    Registration registration = Registration.create().withUserId("" + baseActivity.userData.getUserId());
                    Intercom.client().registerIdentifiedUser(registration);

                    if (baseActivity.userData.getAndroidhmc() != null && !baseActivity.userData
                            .getAndroidhmc().isEmpty())
                        Intercom.client().setUserHash(baseActivity.userData.getAndroidhmc());
                    GenApiLogger.fireIntercomeRegisterUser(baseActivity);

                } else {
                    Intercom.client().registerUnidentifiedUser();
                }

                if (!BuildConfig.DEBUG)
                    FirebaseAnalytics.getInstance(baseActivity).setUserProperty(
                            FirebaseEvents.SIGNIN_PROP,
                            String.valueOf(true)
                    );

                AnalyticsUtils.signinSuccess(baseActivity);
                firebaseEvent("signin_success");
                MyApp.get().adjustEvent(getString(R.string.adjust_signin_success));
                AppSocket.getInstance(MyApp.get()).getSocket().disconnect();

                mainNav.navigate(R.id.action_global_dashboardFragment2);
            }
            else {
                AnalyticsUtils.signinFail(baseActivity);
                firebaseEvent("signin_fail");
                Toasty.info(baseActivity, R.string.only_for_patients, Toast.LENGTH_LONG, false).show();
            }
        }
    }

    private void callUpdateUserInfoAPI( String userType) {
        getDisposer().add(
                baseActivity.RXAPI.updateUserProfile(
                        new UserInfoUpdateRequest()
                                .withHistory(true)
                                .withId(NumberUtils.toInt(baseActivity.userData.getId()))
//                                .withUserType("patient") // working old
                                .withUserType(userType)
                ).subscribe(userInfo -> {
                    attemptLogin();
                }, e -> {
                    LogUtils.e(e);
                    if (NetworkUtils.isConnected()) {
                        Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
                    } else {
                        Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
                    }
                })
        );
    }


    private void firebaseEvent(String type) {

        GenApiLogger.fireGoogleEvent(baseActivity,type);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        RxSocialLogin.activityResult(requestCode, resultCode, data);
//    }
}