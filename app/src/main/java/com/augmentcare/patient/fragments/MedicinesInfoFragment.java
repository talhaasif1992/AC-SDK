package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.utils.LocalUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicinesInfoFragment extends BaseFragment {

    public static String TAG = "MedicinesFragment";

    private View rootView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.note)
    TextView tvNote;

    private MedicinesInfoFragmentArgs args;


    public MedicinesInfoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_medicines, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initMe();
    }

    private void initMe() {
       // loadArgs();

        ((HomeScreenActivity)baseActivity).setToolbarTitle("Coming Soon");

//        if(getCondition().equals("My Lab Reports")){
//            tvTitle.setText("Lab Tests");
//            tvNote.setText("Order lab Tests from your mobile and find all your reminders in place");
//        }
//        else if(getCondition().equals("My Medicines Orders")){
//            tvTitle.setText("MEDICINES & PRESCRIPTIONS");
//            tvNote.setText("Order medicines from your mobile and find all your reminders in place");
//        }
//        else if(getCondition().equals("My medical Records")){
//            tvTitle.setText("LABS & MEDICINES");
//            tvNote.setText("Order medicines & lab tests from your mobile and find all your reminders in place");
//        }
//        else{
//            if(args != null) {
//                if (args.getIsFromLab()) {
//                    tvTitle.setText("Lab Tests");
//                    tvNote.setText("Order lab Tests from your mobile and find all your reminders in place");
//                } else{
//                    tvTitle.setText("MEDICINES & PRESCRIPTIONS");
//                    tvNote.setText("Order medicines from your mobile and find all your reminders in place");
//                }
//            }
//        }
    }

    private void loadArgs() {
        if(getArguments() != null){
            args = MedicinesInfoFragmentArgs.fromBundle(getArguments());
        }
    }

    @NonNull
    private String getCondition(){
        if(args != null){
            return LocalUtils.getOr(args.getCondition(),"");
        }
        return "";
    }

}