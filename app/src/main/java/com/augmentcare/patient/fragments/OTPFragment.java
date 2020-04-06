package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Profile;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData1;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Objects;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.identity.Registration;

public class OTPFragment extends BaseFragment {
    public static final String TAG = "OTPFragment";
    private OTPFragmentArgs args;
    private NavController mainNav;
    private String passwordToLogin, emailToLogin;

    public OTPFragment() {}

    @BindView(R.id.txtPhoneNumber)
    TextView txtPhoneNumber;
    @BindView(R.id.txtResendCode)
    TextView txtResendCode;
    @BindView(R.id.txtChangePhone)
    TextView txtChangePhone;
    @BindView(R.id.lytPhoneNumber)
    PhoneInputLayout layoutPhoneInput;
    @BindView(R.id.otp_view)
    OtpView otp_view;
    @BindView(R.id.tv_we_have_sent_you_an_sms_code_at)
    TextView tvWeSentYouSMS;
    @BindView(R.id.tv_not_your_number)
    TextView tvNotYourNumber;
    @BindView(R.id.tv_did_not_receive_sms)
    TextView tvDidNotReceiveSMS;
    int size = 5;
    String changeNumberFlag = "changeNumber";
    boolean isForgotPassword;
    private boolean isGoogleSignUp = false;
    int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }
    private void initMe(){
        loadArgs();
        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        resendOTP_API(args.getEmail(), args.getPhone());
        setBackPress(false, () -> {
            if (!changeNumberFlag.equals("changeNumber")) {
                changePhoneNumberToggleDisplay();
            }
        });
        otp_view.setOtpCompletionListener(otp -> {
            MyApp.HANDLER.postDelayed(() -> {
                verifyOtp(otp);
            }, 200);
        });
        txtPhoneNumber.setText(args.getPhone());
        layoutPhoneInput.setDefaultCountry("PK");
        txtResendCode.setOnClickListener(view -> {
            resendOTP_API(args.getEmail(), args.getPhone());
            otp_view.setText("");
        });
        txtChangePhone.setOnClickListener(view -> {
            try {
                if (changeNumberFlag.equals("changeNumber")) {
                    otp_view.setVisibility(View.INVISIBLE);
                    tvWeSentYouSMS.setVisibility(View.INVISIBLE);
                    tvNotYourNumber.setVisibility(View.INVISIBLE);
                    tvDidNotReceiveSMS.setVisibility(View.INVISIBLE);
                    txtResendCode.setVisibility(View.INVISIBLE);
                    layoutPhoneInput.setVisibility(View.VISIBLE);
                    txtPhoneNumber.setVisibility(View.GONE);
                    txtChangePhone.setText("Save Number");
                    changeNumberFlag = "saveNumber";
                    count++;
                } else {
                    if (validate()){
                        getDisposer().add(
                                baseActivity.RXAPI.getProfilesByPhone(layoutPhoneInput.getPhoneNumber(),"")
                                        .subscribe(this::onGetProfileByPhone, LocalUtils::processAPIError)
                        );
                    }
                }
            } catch (Exception ignored){}
        });
//        if (baseActivity instanceof PhoneVerificationActivity) {
//            txtChangePhone.setVisibility(View.VISIBLE);
//        }
    }
    private void changePhoneNumberToggleDisplay() {
        if (changeNumberFlag.equals("changeNumber")) {
            otp_view.setVisibility(View.INVISIBLE);
            tvWeSentYouSMS.setVisibility(View.INVISIBLE);
            tvNotYourNumber.setVisibility(View.INVISIBLE);
            tvDidNotReceiveSMS.setVisibility(View.INVISIBLE);
            txtResendCode.setVisibility(View.INVISIBLE);
            layoutPhoneInput.setVisibility(View.VISIBLE);
            txtPhoneNumber.setVisibility(View.GONE);
            txtChangePhone.setText("Save Number");
            changeNumberFlag = "saveNumber";
            count++;
        } else {
            otp_view.setVisibility(View.VISIBLE);
            tvWeSentYouSMS.setVisibility(View.VISIBLE);
            tvNotYourNumber.setVisibility(View.VISIBLE);
            tvDidNotReceiveSMS.setVisibility(View.VISIBLE);
            txtResendCode.setVisibility(View.VISIBLE);
            layoutPhoneInput.setVisibility(View.GONE);
            txtPhoneNumber.setVisibility(View.VISIBLE);
            txtChangePhone.setText("changeNumber");
            changeNumberFlag = "changeNumber";
            count--;
        }
    }
    private void onGetProfileByPhone(ProfilesInfo profiles) {
        if (profiles != null){
            int registeredNoOfUsers = profiles.getCount();
            if (registeredNoOfUsers == 1) {
                Toasty.error(Objects.requireNonNull(getContext()), "There is already an account against this phone number",
                        Toast.LENGTH_LONG, false).show();
            }
            else if (registeredNoOfUsers > 1) {
                Toasty.error(Objects.requireNonNull(getContext()), "There are more than one account for this phone number",
                        Toast.LENGTH_LONG, false).show();
            }
            else {
                getDisposer().add(
                        baseActivity.RXAPI.resendOTP("", layoutPhoneInput.getPhoneNumber()).subscribe(this::OnResendOTP, LocalUtils::processAPIError)
                );
            }
        }
    }
    private void OnResendOTP(Boolean aBoolean) {
        if (aBoolean) {
            Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
            txtChangePhone.setText("Change Number");
            layoutPhoneInput.setVisibility(View.GONE);
            otp_view.setVisibility(View.VISIBLE);
            tvWeSentYouSMS.setVisibility(View.VISIBLE);
            tvNotYourNumber.setVisibility(View.VISIBLE);
            txtResendCode.setVisibility(View.VISIBLE);
            tvDidNotReceiveSMS.setVisibility(View.VISIBLE);
            txtPhoneNumber.setVisibility(View.VISIBLE);
            txtPhoneNumber.setText(layoutPhoneInput.getPhoneNumber());
            changeNumberFlag = "changeNumber";
        } else {
            Toasty.error(getContext(), "Something went wrong").show();
        }
    }
    private void loadArgs() {
        if (getArguments() != null) {
            args = OTPFragmentArgs.fromBundle(getArguments());
            if (args.getPassword() != null) {
                passwordToLogin = args.getPassword();
            }
            if (args.getEmail() != null) {
                emailToLogin = args.getEmail();
            }
        }
    }
    private void resendOTP_API(String email, String phone) {
        getDisposer().add(
                baseActivity.RXAPI.resendOTP(email, phone)
                        .subscribe(sent -> {
                            if (sent) {
                                Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
                            }
                        }, LocalUtils::processAPIError)
        );
    }
    private void verifyOtp(String otpStr){
        Bundle bundle = new Bundle();
        bundle.putString("otp", otpStr);
        bundle.putString("code", otpStr);
        bundle.putString("phone", txtPhoneNumber.getText().toString());
        bundle.putBoolean("is_google_sign_up", isGoogleSignUp);
        if (isForgotPassword) {
            ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
            changePasswordFragment.setArguments(bundle);
            FragmentTransaction ft = baseActivity.getSupportFragmentManager().beginTransaction();
            if (baseActivity.getSupportFragmentManager().findFragmentByTag(ChangePasswordFragment.TAG) == null) {
                ft.replace(R.id.contentFrame, changePasswordFragment);
                ft.addToBackStack(ChangePasswordFragment.TAG);
                ft.commit();
            }
        }
        else{
            verifyOTP_API(otpStr, txtPhoneNumber.getText().toString());
        }
    }
    private void verifyOTP_API(String otp, String phone) {
        getDisposer().add(
                baseActivity.RXAPI.verifyOTP(args.getEmail(), phone, otp)
                        .subscribe(userLogin -> {
                            afterVerify(userLogin);
                        }, e -> {
                            LocalUtils.processAPIError(e);
                            otp_view.setText("");
                        })
        );
    }
    private void afterVerify(UserLogin userLogin) {
        PrefsHelper.get(baseActivity).remove("otpPhone");
        PrefsHelper.get(baseActivity).remove("otpEmail");
        if (userLogin.getUserData() != null && userLogin.getRoles() != null) {
            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, GsonUtils.toJson(userLogin.getChannel()));
            GenApiLogger.fireCompleterRegistrationEmailEvent(userLogin);
            if (userLogin.getUserData().getUserType().toUpperCase().equalsIgnoreCase("PATIENT")) {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);
                PrefsHelper.setUserInfo(userLogin.getUserData());
                getUserInfo(userData -> {
                    baseActivity.userData = userData;
                });
                if (userLogin.getUserData() == null) {
                    PrefsHelper.get(baseActivity).clear();
                    if (!NavGraphUtils.getMe(mainNav).isLastDest(R.id.loginFragment)) {
                        Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                        //mainNav.navigate(R.id.action_global_loginFragment);
                        mainNav.popBackStack(R.id.action_global_loginFragment, false);
                    }
                }
                if (userLogin.getPlanDetails() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_PLAN_ID, userLogin.getPlanId500() + "");
                }
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_DEPENDENT, userLogin.isIsDependent());
                PrefsHelper.get(baseActivity).remove("otpPhone");
                PrefsHelper.get(baseActivity).remove("otpEmail");
                PrefsHelper.get(baseActivity).remove("otpFirstName");
                PrefsHelper.get(baseActivity).remove("otpLastName");
                // may be need to call refresh token API before this
                if(args != null && args.getFromSignUpFlow()){
                    mainNav.navigate(
                            OTPFragmentDirections.actionOTPFragmentToThankYouFragement(
                                    userLogin.getUserData().getFirstName(),
                                    userLogin.getUserData().getLastName()
                            ).setEmail(emailToLogin).setPassword(passwordToLogin)
                    );
                }
                else{
                    refreshTokenAPI(() -> {
                        ThankYouFragementArgs passingVals = new ThankYouFragementArgs.Builder(
                                userLogin.getUserData().getFirstName(),
                                userLogin.getUserData().getLastName()
                        ).setEmail(emailToLogin).setPassword(passwordToLogin).build();
                        mainNav.navigate(R.id.action_OTPFragment2_to_thankYouFragement2, passingVals.toBundle());
                    });
                }
            } else {
                Toasty.info(Utils.getApp(), "This app is for patients only!", Toast.LENGTH_LONG, false).show();
                return;
            }
            if (baseActivity.userData != null) {
                GenApiLogger.fireIntercomeRegisterUser(baseActivity);
            }
        } else {
            Toasty.error(Utils.getApp(), R.string.invalid_otp, Toast.LENGTH_LONG, false).show();
        }
        otp_view.setText("");
    }
    public void setPhoneNumber(String phoneNumber, boolean isGoogleSignUp) {
        txtPhoneNumber.setText(phoneNumber);
        this.isGoogleSignUp = isGoogleSignUp;
    }
    private boolean validate() {
        int errorCount = 0;
        if (!layoutPhoneInput.getPhoneNumber().trim().isEmpty() && layoutPhoneInput.getPhoneNumber().length() >= 11 &&
                PhoneNumberUtils.isGlobalPhoneNumber(layoutPhoneInput.getPhoneNumber().trim())) {
            layoutPhoneInput.setError(null);
        } else {
            layoutPhoneInput.setError(getString(R.string.error_enter_valid_phone));
            errorCount++;
        }
        return errorCount == 0;
    }
    private void refreshTokenAPI(Runnable done) {
        getDisposer().add(
                baseActivity.RXAPI.refreshTokenHeaders()
                        .subscribe(pair -> {
                            refreshTokenResponse(
                                    pair.second,
                                    pair.first,
                                    done
                            );
                        }, LocalUtils::processAPIError)
        );
    }
    private void refreshTokenResponse(ResponseData1<UserLogin> responseData, int statusCode, Runnable done) {
        if (statusCode == HttpURLConnection.HTTP_OK) {
            if (responseData.isSuccess()) {
                UserLogin userLogin = responseData.getData();
                PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
                PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());
                if (userLogin.getDependents() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, GsonUtils.toJson(userLogin.getDependents()));
                }
                UserDataLogin userInfo = userLogin.getUserData();
                if (userInfo != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_PART_OF_PROJECT, StringUtils.null2Length0(userInfo.getPartOfProject()));
                }
                if (userLogin.getOrganization() != null) {
                    MyApp.get().setOrganization(userLogin.getOrganization());
                } else {
                    PrefsHelper.get(baseActivity).remove(Constants.KEY_ORGANIZATION);
                }
                if (userLogin.getPolicy() != null) {
                    PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, GsonUtils.toJson(userLogin.getPolicy()));
                } else {
                    PrefsHelper.get(baseActivity).remove(Constants.KEY_POLICY);
                }
                PrefsHelper.setOnPlan(userLogin.isIsOnPlan());
                // PrefsHelper.setOnPlan(userLogin.isFromOrganization());
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);
                if (baseActivity.userData != null) {
                    PrefsHelper.setUserInfo(userInfo);
                } else {
                    PrefsHelper.get(baseActivity).clear();
                    if (!NavGraphUtils.getMe(mainNav).isLastDest(R.id.loginFragment)) {
                        Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                        mainNav.navigate(R.id.action_global_loginFragment);
                    }
                }
                if (MyApp.get() != null && baseActivity.userData != null && baseActivity.userData.getUserId() >= 0) {
                    Registration registration = Registration.create().withUserId("" + baseActivity.userData.getUserId());
                    Intercom.client().registerIdentifiedUser(registration);
                    if (baseActivity.userData.getAndroidhmc() != null && !baseActivity.userData.getAndroidhmc().isEmpty())
                        Intercom.client().setUserHash(baseActivity.userData.getAndroidhmc());
                    UserAttributes userAttributes = new UserAttributes.Builder()
                            .withName((baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName()))
                            .withEmail(baseActivity.userData.getEmail())
                            .withCustomAttribute("Phone", baseActivity.userData.getPhone())
                            .build();
                    Intercom.client().updateUser(userAttributes);
                } else {
                    Intercom.client().registerUnidentifiedUser();
                }
            }
        }
        done.run();
    }
}