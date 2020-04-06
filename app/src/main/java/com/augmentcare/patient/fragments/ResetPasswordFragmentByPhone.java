package com.augmentcare.patient.fragments;


import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Profile;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class ResetPasswordFragmentByPhone extends BaseFragment{
    public static final String TAG = "ResetPasswordByPhone";

    public ResetPasswordFragmentByPhone(){}

    @BindView(R.id.mCrossImageView)
    ImageView mCrossImageView;

    @BindView(R.id.tv_reset_by_email)
    TextView tvResetByEmail;

    @BindView(R.id.pet_phone_password)
    PhoneEditTextNew layoutPhoneInput;

    @BindView(R.id.reset_password)
    View mResetPassword;

    @BindView(R.id.tvSignin)
    View tvSignIn;

    Bundle instance;
    private View rootView;

    NavController navController;
    String email="";
    String emailOtp = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        instance = savedInstanceState;
        rootView = inflater.inflate(R.layout.fragment_reset_password_by_phone, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initMe();
    }

    private void initMe(){

        navController = Navigation.findNavController(rootView);

        layoutPhoneInput.setDefaultCountry("PK");

        emailOtp = PrefsHelper.get(baseActivity).getString("otpEmail", "");

        mResetPassword.setOnClickListener(view14 ->{
            if(validate()){
                getDisposer().add(
                        baseActivity.RXAPI.getProfilesByPhone(layoutPhoneInput.getPhoneNumber(),"")
                                .subscribe(this::onGetProfileByPhone, LocalUtils::processAPIError)
                );

            }
            else{
                Toasty.error(Objects.requireNonNull(getContext()), R.string.error_enter_valid_phone, Toast.LENGTH_LONG, false).show();
            }
        });

        mCrossImageView.setOnClickListener(view1 -> Objects.requireNonNull(baseActivity).onBackPressed());

        tvResetByEmail.setOnClickListener(v ->{
            navController.navigate(
                    ResetPasswordFragmentByPhoneDirections.actionResetPasswordFragmentByPhoneToResetPasswordFragment()
            );
        });

        tvSignIn.setOnClickListener(view13 -> Objects.requireNonNull(baseActivity).onBackPressed());

        if (instance != null){}

        GenApiLogger.fireForgotPassword();

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
            Toasty.info(Objects.requireNonNull(getContext()), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
            navController.navigate(ResetPasswordFragmentByPhoneDirections
                    .actionResetPasswordFragmentByPhoneToResetPasswordOTPFragment()
                    .setPhone(layoutPhoneInput.getPhoneNumber())
            );
        }
        else{}
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context)
    {
        Log.d(TAG, TAG + " onAttach pass");
        super.onAttach(context);

    }

    @Override
    public void onDetach()
    {
        Log.d(TAG, TAG + " onDetach pass");
        super.onDetach();
    }

    private boolean validate()
    {
        if (!layoutPhoneInput.getPhoneNumber().trim().isEmpty() && PhoneNumberUtils.isGlobalPhoneNumber(layoutPhoneInput.getPhoneNumber().trim())
                && layoutPhoneInput.getPhoneNumber().trim().length() == 13){

            layoutPhoneInput.setError(null);
            return true;
        }
        else
        {
            layoutPhoneInput.setError(getString(R.string.error_enter_valid_phone));
            return false;
        }
    }
}