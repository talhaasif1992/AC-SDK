package com.augmentcare.patient.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.augmentcare.patient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentByCreditCardFragment extends Fragment {


    public PaymentByCreditCardFragment(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_by_credit_card, container, false);
    }

}
