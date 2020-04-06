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
import com.augmentcare.patient.base.BaseFragment;

public class BankAlfalahPaymentSuccessFragment extends BaseFragment {

    View rootView;
    private NavController navController;


    public BankAlfalahPaymentSuccessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=  inflater.inflate(R.layout.fragment_bank_alfalah_payment_success, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        view.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              navController.popBackStack(R.id.dashboardFragment,false);

          }
      });
    }
}
