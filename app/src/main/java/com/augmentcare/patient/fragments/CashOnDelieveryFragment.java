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

public class CashOnDelieveryFragment extends BaseFragment {
    Button mPayByCashButton;
    String type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_cash, container, false);
        mPayByCashButton = view.findViewById(R.id.pay_by_cash_button);
        try {
            Bundle extras = baseActivity.getIntent().getExtras();
            if (extras != null) {
                type = extras.getString("type");
            }
        } catch (Exception ignored) {
        }
        mPayByCashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  labPaymentMethodAddEvent("cod");
                GenApiLogger.firePaymentMethodAddEvent("cod");

                CreditCardFragment.lastFourDigits = "";
                if (type != null && type.equals("Meds")) {
                    PrefsHelper.get(baseActivity).putString(Constants.CASH_ON_DELIVERY, "cod");
                    baseActivity.finish();
                } else {
//                    Intent intent = new Intent(baseActivity, LabOrderSummaryActivity.class);
//                    intent.putExtra("cod", "Cash on Delivery");
//                    startActivity(intent);
                }
            }
        });
        return view;
    }


}
