package com.augmentcare.patient;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.augmentcare.patient.base.BaseFragment;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThankYouFragmentVerifyPhone extends BaseFragment {
    private View rootView;
    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtSkip)
    TextView txtSkip;
    @BindView(R.id.txtMessage)
    TextView txtMessage;
    @BindView(R.id.signincontainer)
    View signincontainer;
    ThankYouFragmentVerifyPhoneArgs args;
    NavController navController;
    public ThankYouFragmentVerifyPhone(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_thank_you_verify_phone, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        baseActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initMe();
    }

    private void initMe(){
        loadArgs();
        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        setNames(args.getFName(), args.getLName());
        txtMessage.setText("Next time you have to use your email or new number "+ args.getPhone()  +" to login.");
        btnNext.setOnClickListener(v -> navController.popBackStack(R.id.dashboardFragment, false));
    }

    private void loadArgs() {
        if(getArguments() != null){
            args = ThankYouFragmentVerifyPhoneArgs.fromBundle(getArguments());
        }
    }
    private void setNames(String firstName, String lastName) {
        txtName.setText(MessageFormat.format("{0} {1}", firstName, lastName));
    }
}
