package com.augmentcare.patient.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.telephony.PhoneNumberUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Profile;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.utils.LocalUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.textfield.TextInputLayout;
import com.lamudi.phonefield.PhoneInputLayout;
import com.mukesh.OtpView;


import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class ResetPasswordOTPFragment extends BaseFragment {
    ResetPasswordOTPFragmentArgs args;
    private View rootView;

    private boolean showPassword = true, showConfirmPassword = true;

    @BindView(R.id.tv_we_have_sent_you_an_sms_code_at)
    TextView tvSentYouCode;
    @BindView(R.id.tv_not_your_number)
    TextView tvNotYourNumber;
    @BindView(R.id.tv_did_not_receive_sms)
    TextView tvDidNotReceive;

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

    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_confirm_new_password)
    EditText etConfirmNewPassword;
    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.passwordInputMeter)
    PasswordStrengthMeter meter;

    NavController mainNav;

    int size = 5;
    String changeNumberFlag = "changeNumber";
    String phoneN = "";
    String code = "";

    String otp, password;

    public ResetPasswordOTPFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_reset_password_otp, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getArguments()!=null){
            args = ResetPasswordOTPFragmentArgs.fromBundle(getArguments());
            if(args.getPhone()!=null){
                phoneN = args.getPhone();
            }
        }
        initMe();
    }

    public void initMe(){
        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        otp_view.setOtpCompletionListener(otp -> {
            MyApp.HANDLER.postDelayed(() -> ResetPasswordOTPFragment.this.verifyOtp(otp), 200);
        });

        etNewPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etNewPassword.getRight() - etNewPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showPassword){
                        etNewPassword.setTransformationMethod(null);
                        //etxtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        Drawable img = etNewPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etNewPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = false;
                    }
                    else{
                        etNewPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etNewPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etNewPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        etConfirmNewPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etConfirmNewPassword.getRight() - etConfirmNewPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showConfirmPassword){
                        etConfirmNewPassword.setTransformationMethod(null);
                        Drawable img = etConfirmNewPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etConfirmNewPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = false;
                    }
                    else{
                        etConfirmNewPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etConfirmNewPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etConfirmNewPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });

        etNewPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus){
                meter.setEditText(etNewPassword);
                meter.setVisibility(View.VISIBLE);
            }
            else{
                meter.setVisibility(View.INVISIBLE);
            }
        });

        txtPhoneNumber.setText(args.getPhone());
        layoutPhoneInput.setDefaultCountry("PK");

        etNewPassword.setEnabled(false);
        etConfirmNewPassword.setEnabled(false);
        btnNext.setEnabled(false);

        txtResendCode.setOnClickListener(view -> {
            etNewPassword.setEnabled(false);
            etConfirmNewPassword.setEnabled(false);
            btnNext.setEnabled(false);
            resendOTP_API("", args.getPhone());
            otp_view.setText("");
        });

        txtChangePhone.setOnClickListener(view -> {
            try{
                if(changeNumberFlag.equals("changeNumber")){
                    tvSentYouCode.setVisibility(View.INVISIBLE);
                    tvNotYourNumber.setVisibility(View.INVISIBLE);
                    otp_view.setVisibility(View.INVISIBLE);
                    txtResendCode.setVisibility(View.INVISIBLE);
                    tvDidNotReceive.setVisibility(View.INVISIBLE);
                    etNewPassword.setEnabled(false);
                    etConfirmNewPassword.setEnabled(false);
                    btnNext.setEnabled(false);
                    layoutPhoneInput.setVisibility(View.VISIBLE);
                    layoutPhoneInput.setPhoneNumber("");
                    layoutPhoneInput.setFocusable(true);
                    layoutPhoneInput.requestFocus();
                    txtPhoneNumber.setVisibility(View.GONE);
                    txtChangePhone.setText("Save Number");
                    changeNumberFlag = "saveNumber";
                }
                else{
                    if(validate()){
                        getDisposer().add(
                                baseActivity.RXAPI.getProfilesByPhone(layoutPhoneInput.getPhoneNumber(),"")
                                        .subscribe(this::onGetProfileByPhone, LocalUtils::processAPIError)
                        );
                    }
                }
            }
            catch(Exception ignored){}
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validateP())
                {
                    getDisposer().add(
                            baseActivity.RXAPI.verifyOTPandThenChangePassword(phoneN,code,password)
                                    .subscribe(this::onVerifyOTPandChangePassword, LocalUtils::processAPIError)
                    );
                }
            }

            private void onVerifyOTPandChangePassword(Boolean aBoolean){
                if(aBoolean)
                {
                    Toasty.success(getContext(), "Password changed successfully. Please log in using new password.", Toast.LENGTH_LONG, false).show();
                    mainNav.popBackStack(R.id.loginFragment, false);
                }
            }
        });
    }

    private void onGetProfileByPhone(ProfilesInfo profiles){
        if(profiles!=null){
            int registeredNoOfUsers = profiles.getProfiles().size();
            if(registeredNoOfUsers == 0)
            {
                Toasty.error(Objects.requireNonNull(getContext()), "This phone number does not exist",
                        Toast.LENGTH_LONG, false).show();
            }
            else if(registeredNoOfUsers > 1)
            {
                Toasty.error(Objects.requireNonNull(getContext()), "There are more than one account for this phone number",
                        Toast.LENGTH_LONG, false).show();
            }
            else
            {
                getDisposer().add(
                        baseActivity.RXAPI.resendOTP("",layoutPhoneInput.getPhoneNumber()).subscribe(this::OnResendOTP,LocalUtils::processAPIError)
                );
            }
        }
    }

    private void OnResendOTP(Boolean aBoolean){
        if (aBoolean)
        {
            txtChangePhone.setText("Change Number");
            layoutPhoneInput.setVisibility(View.GONE);
            layoutPhoneInput.setPhoneNumber("");
            tvSentYouCode.setVisibility(View.VISIBLE);
            tvNotYourNumber.setVisibility(View.VISIBLE);
            txtPhoneNumber.setVisibility(View.VISIBLE);
            otp_view.setText("");
            otp_view.setVisibility(View.VISIBLE);
            otp_view.setFocusable(true);
            otp_view.requestFocus();
            txtResendCode.setVisibility(View.VISIBLE);
            tvDidNotReceive.setVisibility(View.VISIBLE);
            etNewPassword.setEnabled(true);
            etConfirmNewPassword.setEnabled(true);
            btnNext.setEnabled(true);
            txtPhoneNumber.setText(layoutPhoneInput.getPhoneNumber());
            changeNumberFlag = "changeNumber";
            phoneN = layoutPhoneInput.getPhoneNumber();
        }
        else
        {
            Toasty.error(getContext(), "Something went wrong").show();
        }
    }

    private void resendOTP_API(String email, String phone){
        getDisposer().add(
                baseActivity.RXAPI.resendOTP(email, phone)
                        .subscribe(sent -> {
                            if (sent){
                                Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
                            }
                        }, LocalUtils::processAPIError)
        );
    }

    private void verifyOtp(String otpStr){
        code = otpStr;
        if(changeNumberFlag.equals("changeNumber")){
            etNewPassword.setEnabled(true);
            etConfirmNewPassword.setEnabled(true);
            btnNext.setEnabled(true);
            etNewPassword.setFocusableInTouchMode(true);
            etNewPassword.setFocusable(true);
            etNewPassword.requestFocus();
        }
//        mainNav.navigate(ResetPasswordOTPFragmentDirections
//                .actionResetPasswordOTPFragmentToChangePasswordFragment()
//                .setPhone(phoneN)
//                .setCode(otpStr)
//        );
    }

    private boolean validate() {
        int errorCount = 0;
        if (!layoutPhoneInput.getPhoneNumber().trim().isEmpty() && layoutPhoneInput.getPhoneNumber().length() >= 11 &&
                PhoneNumberUtils.isGlobalPhoneNumber(layoutPhoneInput.getPhoneNumber().trim())) {
            layoutPhoneInput.setError(null);
        }
        else{
            layoutPhoneInput.setError(getString(R.string.error_enter_valid_phone));
            errorCount++;
        }
        return errorCount == 0;
    }

    private boolean validateP()
    {
        password = etNewPassword.getText().toString().trim();
        String rePassword = etConfirmNewPassword.getText().toString().trim();

        if (password.isEmpty()){
            Toasty.error(getContext(),"Please insert password").show();
            return false;
        }

        if (password.length() < 8){
            Toasty.error(getContext(),"Password length must be at least 8 characters").show();
            return false;
        }

        if (rePassword.isEmpty()){
            Toasty.error(getContext(),"Please insert password to verify").show();
            return false;
        }

        if (!password.equals(rePassword)){
            Toasty.error(getContext(),"Password and confirm password should be same").show();
            etConfirmNewPassword.setText("");
            return false;
        }
        return true;
    }
}
