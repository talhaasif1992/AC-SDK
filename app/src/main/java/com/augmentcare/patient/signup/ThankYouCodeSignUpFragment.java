package com.augmentcare.patient.signup;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.fragments.SignupEmailFragmentArgs;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.identity.Registration;

import static com.augmentcare.patient.notifications.NotificationHelper.firebaseEvent;

public class ThankYouCodeSignUpFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtSkip)
    TextView txtSkip;
    @BindView(R.id.email_textview)
    TextView mEmailTextView;
    @BindView(R.id.txtMessage)
    TextView txtMessage;
    @BindView(R.id.signincontainer)
    View signincontainer;
    private ThankYouCodeSignUpFragmentArgs args;
    private NavController mainNav;

    public ThankYouCodeSignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lyt_thanks_code_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initMe();
    }

    private void initMe() {
        loadArgs();

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        setBackPress(false,() -> {
//            mainNav.popBackStack(R.id.loginFragment,false);
            mainNav.navigate(R.id.action_global_loginFragment);
        });

        setNames(args.getFName(), args.getLName(), args.getEmail());

        btnNext.setOnClickListener(this);
        txtSkip.setOnClickListener(this);
//        if (baseActivity instanceof PhoneVerificationActivity) {
//            txtMessage.setText("You will be receiving your \n" + "AugmentCare reminders on \n" + "your phone now");
//            signincontainer.setVisibility(View.GONE);
//        }


        GenApiLogger.fireThankyouEvent();


    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = ThankYouCodeSignUpFragmentArgs.fromBundle(getArguments());
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNext) {
            if(args.getEmail()!=null && args.getPassword()!=null) {
                doNormalLogin(args.getEmail(), args.getPassword());
            }
        }
//        if (view.getId() == R.id.txtSkip) {
//            Intent intent = new Intent(baseActivity, HomeScreenActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            startActivity(intent);
//            baseActivity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
//            ActivityCompat.finishAffinity(baseActivity);
//        }
    }

    private void doNormalLogin(String email, String password) {

        getDisposer().add(
                baseActivity.RXAPI.loginNormal(email.trim(), password)
                        .subscribe(res -> {
                            onLogginResponse(res);
                        }, e -> {
                            LogUtils.e(e);
//                            LocalUtils.processAPIError(e);
                            if (NetworkUtils.isConnected()){
                                Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
                            }
                            else{
                                Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
                            }
                        })
        );
    }

    private void onLogginResponse(UserLogin userLogin){
        PrefsHelper.setLoggedInUser(userLogin);
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
        if(userLogin.getUserData() != null && StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())){
            // if user phone is not verified
            String phone = userLogin.getUserData().getPhone();
            String email = userLogin.getUserData().getEmail();

            Toasty.info(baseActivity, "Please verify your phone number to continue.", Toast.LENGTH_LONG, false).show();

//            Intent intent = new Intent(this, PhoneVerificationActivity.class);
//            intent.putExtra("phone", phone);
//            intent.putExtra("email", email);
//            startActivity(intent);

            SignupEmailFragmentArgs args =
                    new SignupEmailFragmentArgs.Builder(userLogin.getUserData().getFirstName(),userLogin.getUserData().getLastName(),userLogin.getUserData().getEmail(),userLogin.getUserData().getPhone())
                            .setFromSignupFlow(false)
                            .build();
            mainNav.navigate(R.id.action_loginFragment_to_login_otp_verification_navigation, args.toBundle());

//            mainNav.setGraph(R.navigation.login_otp_verification_navigation,args.toBundle());

        } else if (userLogin.getUserData() != null && userLogin.getRoles() != null && !StringUtils.isEmpty(userLogin.getUserData().getPhoneVerified())) {

            GenApiLogger.fireOrginizationPhoneVirefied(userLogin);

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, userLogin.isIsOnPlan());
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_FROM_ORGANIZATION, userLogin.isFromOrganization());
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_DEPENDENT, userLogin.isIsDependent());

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
            PrefsHelper.get(baseActivity).putString(Constants.KEY_PART_OF_PROJECT, StringUtils.null2Length0(userLogin.getUserData().getPartOfProject()));

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_HR, LocalUtils.isThisUserType("HR"));


            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());

            if (userLogin.getDependents() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
            }


            MyApp.get().setOrganization(userLogin.getOrganization());


            if (userLogin.getPolicy() != null) {
                FirebaseLogger.firebaseUserPropertyEvent("is_on_policy", "true");
                PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
            } else {
                FirebaseLogger.firebaseUserPropertyEvent("is_on_policy", "false");
                PrefsHelper.get(baseActivity).remove(Constants.KEY_POLICY);
            }

            if (LocalUtils.isThisUserType("PATIENT")) {
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
                firebaseEvent(baseActivity,"signin_success");
                MyApp.get().adjustEvent(getString(R.string.adjust_signin_success));
                AppSocket.getInstance(MyApp.get()).getSocket().disconnect();

                mainNav.navigate(R.id.action_global_dashboardFragment2);
            }
            else {
                AnalyticsUtils.signinFail(baseActivity);
                firebaseEvent(baseActivity,"signin_fail");
                Toasty.info(baseActivity, R.string.only_for_patients, Toast.LENGTH_LONG, false).show();
                mainNav.navigate(R.id.action_global_loginFragment);
            }
        }
    }

    private void setNames(String firstName, String lastName, String email) {
        txtName.setText(MessageFormat.format("{0} {1}", firstName, lastName));
        mEmailTextView.setText(email);
        mEmailTextView.setVisibility(View.VISIBLE);
    }
}