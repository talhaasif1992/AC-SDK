package com.augmentcare.patient.activities;

import android.os.Bundle;
import android.widget.Button;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;

public class BankAlfalahPaymentSuccessActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bank_alfalah_payment_success);

        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v -> finish());
    }
}
