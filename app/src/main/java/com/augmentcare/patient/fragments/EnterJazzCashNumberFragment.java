package com.augmentcare.patient.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.network.restApi.apimodels.JazzCashResponse;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.LocalUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class EnterJazzCashNumberFragment extends BaseDialogFragment {

    private View rootView;

    @BindView(R.id.et_account_number)
    EditText etAccountNumber;

    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_ok)
    TextView tvOK;

    int plan_id;
    String phoneNumber;
    NavController navController;

    public EnterJazzCashNumberFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_enter_jazz_cash_number, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initMe();
    }

    private void initMe(){
        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        loadArguments();

        tvCancel.setOnClickListener(v -> {
            navController.popBackStack();
        });

        tvOK.setOnClickListener(v->{
            phoneNumber = etAccountNumber.getText().toString();

            getDisposer().add(
                    baseActivity.RXAPI.jazzCashPayPlan(plan_id, phoneNumber).subscribe(this::jazzCashPayment, LocalUtils::processAPIError)
            );
        });
    }

    private void jazzCashPayment(JazzCashResponse paymentResponse){
        if(paymentResponse.getSuccess()){
            navController.navigate(R.id.paymentSuccessfullFragment);
        }
        else{
            Toasty.error(baseActivity, paymentResponse.getErrors(), Toasty.LENGTH_LONG).show();
        }
    }

    public void loadArguments(){
        Bundle b = getArguments();
        if (b != null) {
            plan_id = b.getInt("plan_id");
        }
    }
}