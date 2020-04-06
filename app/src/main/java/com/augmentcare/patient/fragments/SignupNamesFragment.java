package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class SignupNamesFragment extends BaseFragment {
    @BindView(R.id.etxtFirstName)
    AppCompatEditText etxtFirstName;


    @BindView(R.id.etxtLastName)
    AppCompatEditText etxtLastName;


    @BindView(R.id.btnNext)
    Button btnNext;

    @BindView(R.id.tv_login)
    TextView tvLogin;

    NavController navController;

    public SignupNamesFragment() {
    }


    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_names, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        btnNext.setOnClickListener(btnNextView -> {
            if (validateForm()) {
                navController.navigate(
                        SignupNamesFragmentDirections.actionSignupNamesFragmentToSignupEmailFragment(
                                StringUtils.null2Length0(etxtFirstName.getText().toString()),
                                StringUtils.null2Length0(etxtLastName.getText().toString()),
                                null,
                                null
                        )
                );
            }
        });

        tvLogin.setOnClickListener(tvLoginView -> {
            baseActivity.onBackPressed();
        });
    }

    private boolean validateForm() {
//        int errorCount = 0;
//        if (Objects.requireNonNull(etxtFirstName.getText()).toString().trim().isEmpty())
//        {
//            Toasty.info(Utils.getApp(), getString(R.string.error_enter_valid_name), Toast.LENGTH_LONG, false).show();
//            errorCount++;
//        }
//
//        if (Objects.requireNonNull(etxtLastName.getText()).toString().trim().isEmpty())
//        {
//            Toasty.info(Utils.getApp(), getString(R.string.error_enter_valid_name), Toast.LENGTH_LONG, false).show();
//            errorCount++;
//        }
//        return errorCount == 0;
//    }
        if (etxtFirstName.getText().toString().isEmpty()) {
            etxtFirstName.setError("Enter First Name");
            return false;
        } else if (etxtLastName.getText().toString().isEmpty()) {
            etxtLastName.setError("Enter Last Name");
            return false;
        }
        return true;
    }
}
