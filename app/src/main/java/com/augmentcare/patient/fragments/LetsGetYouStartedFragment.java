package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.blankj.utilcode.util.ActivityUtils;

import butterknife.ButterKnife;

public class LetsGetYouStartedFragment extends BaseFragment {

    Button btn_lets_get_you_started;
    private View rootView;
    private NavController mainNav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lets_get_you_started, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        handleBackPress();

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        btn_lets_get_you_started = rootView.findViewById(R.id.btn_lets_get_you_started);
        btn_lets_get_you_started.setOnClickListener(v -> {
            mainNav.navigate(LetsGetYouStartedFragmentDirections.actionLetsGetYouStartedFragmentToSignInSignUpActivity());
        });
    }

    private void handleBackPress() {
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                ActivityUtils.finishAllActivities();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

}
