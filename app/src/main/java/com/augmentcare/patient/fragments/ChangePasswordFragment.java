package com.augmentcare.patient.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class ChangePasswordFragment extends BaseFragment{

    public static final String TAG = "ChangePasswordFragment";

    private View view;

    Bundle bundle = new Bundle();
    String phone, otp, password;

    NavController navController;
    public ChangePasswordFragment(){}

    @BindView(R.id.et_new_password)
    AppCompatEditText etNewPassword;
    @BindView(R.id.et_confirm_new_password)
    AppCompatEditText etConfirmNewPassword;
    @BindView(R.id.btnNext)
    View btnNext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_change_password, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initMe();
    }

    private void initMe(){
        navController = Navigation.findNavController(view);

//        if (getArguments() != null) {
//            ChangePasswordFragmentArgs args = ChangePasswordFragmentArgs.fromBundle(getArguments());
//
//            if(args.getPhone()!=null){
//                phone = args.getPhone();
//            }
//            if(args.getCode()!=null){
//                otp = args.getCode();
//            }
//        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (validate())
                {
                    getDisposer().add(
                            baseActivity.RXAPI.verifyOTPandThenChangePassword(phone,otp,password)
                                    .subscribe(this::onVerifyOTPandChangePassword, LocalUtils::processAPIError)
                    );
                }
            }

            private void onVerifyOTPandChangePassword(Boolean aBoolean) {
                if(aBoolean)
                {
                    Toasty.success(getContext(), "Password changed successfully. Please log in using new password.", Toast.LENGTH_LONG, false).show();
                    navController.popBackStack(R.id.loginFragment, false);
                }
            }
        });
    }

    private boolean validate(){
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