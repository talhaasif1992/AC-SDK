package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.utils.PrefsHelper;

public class PaymentSuccessfullFragment extends BaseFragment {
    private View rootView;
    NavController navController;

    public PaymentSuccessfullFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_payment_successfull, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(rootView);
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Payment Successful");
        ((HomeScreenActivity) baseActivity).showHideBackToolbar(true);

        view.findViewById(R.id.back_to_home).setOnClickListener(v -> navController.navigate(R.id.dashboardFragment));

    }

}
