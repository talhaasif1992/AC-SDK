package com.augmentcare.patient.signup;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.mukesh.OtpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class EmailCodeSignUpFragment extends BaseFragment {


    @BindView(R.id.txtPhoneNumber)
    TextView txtPhoneNumber;
    @BindView(R.id.otp_view)
    OtpView otp_view;
//    @BindView(R.id.tv_already_have_an_account)
//    TextView tv_already_have_an_account;

    private NavController mainNav;

    public EmailCodeSignUpFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emailcode_code_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        otp_view.setOtpCompletionListener(otp -> {
            MyApp.HANDLER.postDelayed(() -> {
                verifyCodeOfEmployee(otp);
            },200);
        });
//
//        tv_already_have_an_account.setOnClickListener(v -> {
//            ActivityUtils.startActivity(LoginFragment.class);
//            baseActivity.finish();
//        });
    }

    private void verifyCodeOfEmployee(String code) {
        GenApiLogger.fireRegisterCorporateUser();
        getDisposer().add(
                baseActivity.RXAPI.signUpVerifyEmployeeCode(code)
                        .subscribe(this::onVerifyCodeResponse, e -> {
                            otp_view.setText("");
                            LocalUtils.processAPIError(e);
                        })
        );

    }

    private void onVerifyCodeResponse(UserLogin response) {
        if (response != null && otp_view.getText() != null) {
            if (response.getUserData() != null) {
                //0.EmailCodeSignUpFragment
                //1. PasswordCodeSignupFragment
                //2. OTPCodeSignupFragment
                //3. ThankYouCodeSignUpFragment
                mainNav.navigate(
                        EmailCodeSignUpFragmentDirections.actionEmailCodeSignUpFragmentToPasswordCodeSignupFragment(
                                otp_view.getText().toString(),
                                response
                        )
                );

            } else {
                Toasty.error(baseActivity, "Invalid code provided", Toast.LENGTH_LONG, false).show();
            }
        } else {
            Toasty.error(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }



        GenApiLogger.fireRegisterCorporateUser();

        otp_view.setText("");

    }

}
