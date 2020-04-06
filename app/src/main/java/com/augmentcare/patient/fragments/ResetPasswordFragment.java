package com.augmentcare.patient.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FacebookLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.TextUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class ResetPasswordFragment extends BaseFragment{

    public static final String TAG = "ResetPasswordFragment";

    public ResetPasswordFragment(){}

    @BindView(R.id.mCrossImageView)
    ImageView mCrossImageView;

    @BindView(R.id.tv_reset_by_phone_number)
    TextView tvResetByPhoneNumber;

    @BindView(R.id.email)
    EditText mEmail;

    @BindView(R.id.reset_password)
    View mResetPassword;

    @BindView(R.id.layoutFormContainer)
    View layoutFormContainer;

    @BindView(R.id.tvSignin)
    View tvSignIn;

    Bundle instance;
    private View rootView;
    String email;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        instance = savedInstanceState;

        rootView = inflater.inflate(R.layout.fragment_reset_password, container, false);
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

        mResetPassword.setOnClickListener(view -> {
            if (validate())
            {
                email = mEmail.getText().toString();
                getDisposer().add(
                        baseActivity.RXAPI.resetPassword(email).subscribe(this::onResetPassword, LocalUtils::processAPIError)
                );
            }
            else
            {
                Toasty.error(getContext(), R.string.enter_valid_email, Toast.LENGTH_LONG, false).show();
            }
        });

        mCrossImageView.setOnClickListener(view -> baseActivity.onBackPressed());
        tvSignIn.setOnClickListener(view -> baseActivity.onBackPressed());
        tvResetByPhoneNumber.setOnClickListener(v ->{
            navController.popBackStack();
        });
        FacebookLogger.viewControllerLogEvent("register", "forgot_password", "ViewController", "0", "");
    }

    private void onResetPassword(String message) {
        ViewUtils.showOneButtonDialog(baseActivity, "Message",message, (dialogInterface, i) -> {
            navController.popBackStack(R.id.loginFragment, false);
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context){
        Log.d(TAG, TAG + " onAttach pass");
        super.onAttach(context);
    }

    @Override
    public void onDetach(){
        Log.d(TAG, TAG + " onDetach pass");
        super.onDetach();
    }

    private boolean validate(){
        return TextUtils.validateEmail(mEmail.getText().toString().trim());
    }
}