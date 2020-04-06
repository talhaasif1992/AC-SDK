package com.augmentcare.patient.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentAtLocationFragment extends BaseFragment {

    private View rootView;

    @BindView(R.id.iv_pay_at_location)
    ImageView ivPayAtLocation;

    @BindView(R.id.btn_pay_at_location)
    Button btnPayAtLocation;

    @BindView(R.id.tv_pay_at_location)
    TextView tvPayAtLocation;

    @BindView(R.id.tv_online_case)
    TextView tvOnlineCase;

    NavController navController;
    private View.OnClickListener payClick;

    public PaymentAtLocationFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_payment_at_location, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,rootView);
        initMe();
    }

    private void initMe(){
        navController = Navigation.findNavController(rootView);

        btnPayAtLocation.setOnClickListener(view -> {
            if(payClick != null){
                payClick.onClick(view);
            }
        });
    }
    public void setOnPayAtLocationClick(View.OnClickListener payClick){
        this.payClick = payClick;
    }
}