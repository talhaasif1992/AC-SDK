package com.augmentcare.patient.signup;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.appevents.AppEventsConstants;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;

import java.util.Objects;

import java.util.Objects;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class OTPCodeSignupFragment extends BaseFragment{
    private boolean isPateint = false;

    @BindView(R.id.txtPhoneNumber)
    TextView txtPhoneNumber;
    @BindView(R.id.txtResendCode)
    TextView txtResendCode;

    @BindView(R.id.otp_view)
    OtpView otpView;

    @BindView(R.id.tv_we_have_sent_you_an_sms_code_at)
    TextView tvWeSentYouSMS;

    @BindView(R.id.tv_did_not_receive_sms)
    TextView tvDidNotReceiveSMS;

    private OTPCodeSignupFragmentArgs args;
    private NavController employeeSignUpNav;

    public OTPCodeSignupFragment(){}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_code_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }
    private void initMe() {
        loadArgs();
        employeeSignUpNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        txtPhoneNumber.setText(args.getPhone());
        txtResendCode.setOnClickListener(view -> resendOTP_API(args.getEmail(),args.getPhone()));
        otpView.setOtpCompletionListener(otp -> {
            verifyOtp(
                    args.getEmail(),
                    args.getPhone(),
                    otp
            );
        });

        txtPhoneNumber.setText(args.getPhone());

        txtPhoneNumber.setText(args.getPhone());
//        if (baseActivity instanceof PhoneVerificationActivity) {
//            txtChangePhone.setVisibility(View.VISIBLE);
//        }
        GenApiLogger.fireRegisterPhoneVerified();
    }
    private void loadArgs() {
        if(getArguments() != null){
            args = OTPCodeSignupFragmentArgs.fromBundle(getArguments());
        }
    }
    private void verifyOtp(String email,String phone,String code) {
        getDisposer().add(
                baseActivity.RXAPI.verifyOTP(email,phone,code)
                        .subscribe(this::onVerifyOTPResponse, e -> {
                            LogUtils.e(e);
                            Toasty.error(Utils.getApp(), R.string.invalid_otp, Toast.LENGTH_LONG, false).show();
                            otpView.setText("");
                        })
        );
    }
    private void onVerifyOTPResponse(UserLogin userLogin){
        if (userLogin != null) {
            if (userLogin.getUserData() != null && userLogin.getRoles() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, GsonUtils.toJson(userLogin.getRoles()));
                PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, userLogin.getChannel());
                GenApiLogger.fireCompleterRegistrationEmailEvent(userLogin);
                if(userLogin.getRolesName().size()>0){
                    for(int i=0; i < userLogin.getRolesName().size() ; i++){
                        if(userLogin.getRolesName().get(i).getName().equalsIgnoreCase("patient")){
                            isPateint = true;
                        }
                    }
                    if(isPateint){
                        PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);
                        PrefsHelper.get(baseActivity).putString(Constants.KEY_USER_DATA, GsonUtils.toJson(userLogin.getUserData()));
                        PrefsHelper.get(baseActivity).putString(Constants.KEY_PLAN_ID,userLogin.getPlanId500()+"");

                        employeeSignUpNav.navigate(
                                OTPCodeSignupFragmentDirections.actionOTPCodeSignupFragmentToThankYouCodeSignUpFragement(
                                        userLogin.getUserData().getFirstName(),
                                        userLogin.getUserData().getLastName(),
                                        userLogin.getEmail()
                                ).setPassword(args.getPassword())
                        );
                    }
                    else{
                        Toasty.error(Utils.getApp(), "This app is for patients only!", Toast.LENGTH_LONG, false).show();
                    }
                }
            } else {
                Toasty.error(Utils.getApp(), R.string.invalid_otp, Toast.LENGTH_LONG, false).show();
            }
//                    try {
//                        FacebookLogger.logCompleteRegistrationEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, "", "", response.getAsJsonObject("data").get("name").getAsString(), response.getAsJsonObject("data").get("id").getAsString());
//                    } catch (Exception e) {
//                    }
        }
        otpView.setText("");
    }
    private void resendOTP_API(String email, String phone) {
        getDisposer().add(
                baseActivity.RXAPI.resendOTP(email, phone)
                        .subscribe(sent -> {
                            if (sent) {
                                Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
                            }
                        }, e -> {
                            LogUtils.e(e);
                            Toasty.info(Utils.getApp(), "Error Sending OTP Number is Invalid Or Already Registered...", Toast.LENGTH_LONG, false).show();
                        })
        );
    }
}