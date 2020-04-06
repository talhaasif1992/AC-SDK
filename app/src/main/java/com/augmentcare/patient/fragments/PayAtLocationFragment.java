package com.augmentcare.patient.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.PrefsHelper;

public class PayAtLocationFragment extends BaseFragment {
    Button mPayByCashButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_cash, container, false);
        mPayByCashButton = view.findViewById(R.id.pay_by_cash_button);
        mPayByCashButton.setText("Pay at Location");
        mPayByCashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labPaymentMethodAddEvent("cod");
                facebookEvents("select_payment_method");
                firebaseEvents("find_a_doctor_select_payment_method");
                CreditCardFragment.lastFourDigits = "";
                PrefsHelper.get(baseActivity).putString(Constants.KEY_PAY_AT_LOCATION, "Pay at Location");
                baseActivity.finish();
                Intent intent = new Intent(baseActivity, AppointmentApprovedFragment.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void labPaymentMethodAddEvent(String type) {

        GenApiLogger.fireLabPaymentMethodAddEvent(type);

    }

    private void facebookEvents(String type) {
        GenApiLogger.firefindADoctor(type);

    }

    private void firebaseEvents(String type) {

        GenApiLogger.fireFindADoctorSelectPaymentMethod(baseActivity,type);


    }
}
