package com.augmentcare.patient;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.Utils;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import static android.app.Activity.RESULT_OK;

public class VerifyOTPPhoneFragment extends BaseFragment{

    private View rootView;
    VerifyOTPPhoneFragmentArgs args;
    UserDataLogin userInfo;
    String phoneN;

    public static final String TAG = "OTPFragment";
    private NavController mainNav;

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
    int count = 0;

    public VerifyOTPPhoneFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_verify_otp_phone, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe(){
        loadArgs();
        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        resendOTP_API("", phoneN);

        setBackPress(false, () -> {
            if (!changeNumberFlag.equals("changeNumber")) {
                changePhoneNumberToggleDisplay();
            }
        });
        otp_view.setOtpCompletionListener(otp -> {
            MyApp.HANDLER.postDelayed(() -> {
                verifyOTP_API(otp,phoneN);
            }, 200);
        });

        txtPhoneNumber.setText(args.getPhone());
        layoutPhoneInput.setDefaultCountry("PK");
        txtResendCode.setOnClickListener(view -> {
            resendOTP_API("", phoneN);
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
                }else{
                    if(validate()){
                        phoneN = layoutPhoneInput.getPhoneNumber();
                        getDisposer().add(
                                baseActivity.RXAPI.getProfilesByPhone(phoneN,"")
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
                        baseActivity.RXAPI.resendOTP("", phoneN).subscribe(this::OnResendOTP, LocalUtils::processAPIError)
                );
            }
        }
    }

    private void OnResendOTP(Boolean aBoolean) {
        if(aBoolean){
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
        }
        else{
            Toasty.error(getContext(), "Something went wrong").show();
        }
    }
    private void loadArgs() {
        if (getArguments() != null){
            args = VerifyOTPPhoneFragmentArgs.fromBundle(getArguments());
            if(args.getUserInfo()!=null){
               userInfo = args.getUserInfo();
            }
            if(args.getPhone()!=null){
                phoneN = args.getPhone();
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

    private void verifyOTP_API(String otp, String phone) {
        getDisposer().add(
                baseActivity.RXAPI.verifyOTPPhone(phone, otp).subscribe(this::onVerifyOTP, LocalUtils::processAPIError)
        );
        otp_view.setText("");
    }
    private void onVerifyOTP(Boolean isVerified){
        if(isVerified){
            userInfo.setPhone(phoneN);
            userInfo.setUpdate_phone(true);
            callUpdateProfile(userInfo);
        }
        else{
            Toasty.error(getContext(),"Invalid Code").show();
        }
        otp_view.setText("");
    }

    private void callUpdateProfile(UserDataLogin user){
        getDisposer().add(
                baseActivity.RXAPI.updateUserProfile(
                        new UserInfoUpdateRequest()
                                .setUserInfo(user)

                ).subscribe(userInfo ->{
                    if(userInfo!=null){
                        //Toasty.success(Utils.getApp(), "Profile Updated", Toast.LENGTH_LONG, false).show();

                        if(baseActivity.userData != null){
                            PrefsHelper.setUserInfo(this.userInfo);
                        }
                        else{
                            PrefsHelper.get(baseActivity).clear();
                            if (!NavGraphUtils.getMe(mainNav).isLastDest(R.id.loginFragment)) {
                                Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                                mainNav.navigate(R.id.action_global_loginFragment);
                            }
                        }
                        baseActivity.setResult(RESULT_OK);

                        mainNav.navigate(VerifyOTPPhoneFragmentDirections
                                .actionVerifyOTPPhoneFragmentToThankYouFragmentVerifyPhone()
                                .setFName(userInfo.getFirstName())
                                .setLName(userInfo.getLastName())
                                .setPhone(userInfo.getPhone())
                        );
                    }
                }, LocalUtils::processAPIError)
        );
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
}
