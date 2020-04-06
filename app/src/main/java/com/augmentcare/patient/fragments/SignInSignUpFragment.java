package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInSignUpFragment extends BaseFragment {
    @BindView(R.id.btn_sign_up)
    Button sign_up;
    @BindView(R.id.btn_sign_in)
    Button sign_in;
    private View rootView;
    private NavController mainNav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sign_in_sign_up, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        sign_up.setOnClickListener(v ->
                mainNav.navigate(SignInSignUpFragmentDirections.actionSignInSignUpActivityToSignUpFragment())
        );

        sign_in.setOnClickListener(v -> {
            mainNav.navigate(R.id.action_global_loginFragment);
        });

        setBackPress(false,() -> {
            baseActivity.finish();
        });
    }


}
