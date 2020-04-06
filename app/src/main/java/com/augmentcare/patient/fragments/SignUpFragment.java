package com.augmentcare.patient.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.notifications.NotificationHelper;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.GoogleSignInUtils;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.identity.Registration;

import static com.augmentcare.patient.notifications.NotificationHelper.firebaseEvent;

public class SignUpFragment extends BaseFragment {

    @BindView(R.id.btn_email)
    Button btnEmail;
    @BindView(R.id.btn_employee_code)
    Button btnEmployeeCode;

    @BindView(R.id.btn_google_sign_up)
    Button btn_google_sign_up;
    @BindView(R.id.tv_already_have_an_account)
    TextView tv_already_have_an_account;
    @BindView(R.id.iv_back_arrow)
    ImageView iv_back_arrow;
    private View rootView;
    private NavController mainNav;
    private GoogleSignInUtils signInUtils;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sign_up_new, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {

//        setBackPress(true);

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        btnEmail.setOnClickListener(v -> {
            mainNav.navigate(R.id.action_signUpFragment_to_sign_up_navigation);
        });

        btnEmployeeCode.setOnClickListener(v -> {
            mainNav.navigate(R.id.action_signUpFragment_to_signup_employee_code_navigation);
        });

        NotificationHelper.dismissNotificationAll(baseActivity);

        tv_already_have_an_account.setOnClickListener(v -> {
            mainNav.navigate(R.id.action_global_loginFragment);
        });

        iv_back_arrow.setOnClickListener(v -> {
            baseActivity.onBackPressed();
        });

        btn_google_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefsHelper.setRemeberMe(true);
                clickGoogleLogin();
            }
        });

        signInUtils = GoogleSignInUtils.getInstance(baseActivity, BuildConfig.REQUEST_ID_TOKEN);

    }
    private void clickGoogleLogin() {
        AnalyticsUtils.googleSigninClick(
                baseActivity,
                "Login"
        );

        GenApiLogger.fireLogin();

        signInUtils.signOut(new GoogleSignInUtils.OnValueGot<Boolean>() {
            @Override
            public void gotIt(Boolean v){
                signInUtils.signInWithinFragment(SignUpFragment.this, new GoogleSignInUtils.OnValueGot<GoogleSignInAccount>() {
                    @Override
                    public void gotIt(GoogleSignInAccount account) {
                        if (account != null){
                            account.getEmail();
                            if (!StringUtils.isEmpty(account.getEmail()))
                                PrefsHelper.get(baseActivity).putString(Constants.KEY_EMAIL_GOOGLE_SIGN_IN, account.getEmail());
                        }

                        String gotToken = account != null ? StringUtils.null2Length0(account.getIdToken()) : "";
                        baseActivity.showLoader();
                        SignUpFragment.this.googleAPICall(gotToken, verified -> {
                            if (verified != null && verified){
                                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);
                                mainNav.navigate(R.id.action_global_dashboardFragment2);
                            }
                        });
                    }
                });
            }
        });
//        ActivityUtils.startActivity(GoogleSigninActivity.class);
    }

    private void googleAPICall(String googleResultToken, GoogleSignInUtils.OnValueGot<Boolean> verified) {
        getDisposer().add(
                LocalUtils.getFirebaseToken()
                        .flatMap(token -> baseActivity.RXAPI.loginGoogle(googleResultToken, token))
                        .subscribe(
                                userLogin -> {
                                    googleSignInResp(userLogin, verified);
                                },
                                e -> {
                                    LocalUtils.processAPIError(e);
                                    AnalyticsUtils.googleSigninFail(
                                            baseActivity,
                                            "invalid_response"
                                    );
                                    firebaseEvent(baseActivity,"gsign_in_fail");


//                                    ActivityUtils.startActivity(LoginFragment.class);
                                })
        );
    }

    private void googleSignInResp(UserLogin userLogin, GoogleSignInUtils.OnValueGot<Boolean> verified) {
        if (userLogin.getUserData() != null && StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) { // if user phone is not verified
            Toasty.info(baseActivity, "Please verify your phone number to continue.", Toast.LENGTH_LONG, false).show();

//            Intent intent = new Intent(baseActivity, PhoneVerificationActivity.class);
//            intent.putExtra("phone", phone);
//            intent.putExtra("email", email);
//            startActivity(intent);
//            finish();
            SignupEmailFragmentArgs args =
                    new SignupEmailFragmentArgs.Builder(userLogin.getUserData().getFirstName(),userLogin.getUserData().getLastName(),userLogin.getUserData().getEmail(),userLogin.getUserData().getPhone())
                            .setFromSignupFlow(false)
                            .build();

            // #TODO Check navigation for fragment

            mainNav.navigate(R.id.action_signUpFragment_to_login_otp_verification_navigation,args.toBundle());

            verified.gotIt(false);
            return;
//            mainNav.setGraph(R.navigation.login_otp_verification_navigation,args.toBundle());
        }
        else if (userLogin.getUserData() != null && userLogin.getRoles() != null && !StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())){

            PrefsHelper.setLoggedInUser(userLogin);

            baseActivity.userData = userLogin.getUserData();

            if(baseActivity.userData!=null) {
                PrefsHelper.setUserInfo(userLogin.getUserData());
            }
            else{
                PrefsHelper.get(baseActivity).clear();
                if(!NavGraphUtils.getMe(mainNav).isLastDest(R.id.loginFragment)) {
                    Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                    mainNav.navigate(R.id.action_global_loginFragment);
                }
            }
            if (!BuildConfig.DEBUG)
                AnalyticsUtils.googleSigninSuccess(
                        baseActivity,
                        ""
                );

            firebaseEvent(baseActivity,"gsign_in_success");

            MyApp.get().adjustEvent(getString(R.string.adjust_signin_success));

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, userLogin.isIsOnPlan());
            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

            if (LocalUtils.isThisUserType("PATIENT")) {
                if (userLogin.getDependents() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
                }

                MyApp.get().setOrganization(userLogin.getOrganization());

                if (userLogin.getPolicy() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
                }

                firebaseEvent(baseActivity,"gsing_in_click");

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

                AppSocket.getInstance(baseActivity).getSocket().disconnect();
            }

            GenApiLogger.fireCompleterRegistrationGoogleEvent(userLogin);

            verified.gotIt(true);
            return;
        } else {
            AnalyticsUtils.googleSigninFail(
                    baseActivity,
                    "invalid_response"
            );
            Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
            firebaseEvent(baseActivity,"gsign_in_fail");
        }
        verified.gotIt(false);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        signInUtils.onActivityResult(requestCode, resultCode, data);
    }
}