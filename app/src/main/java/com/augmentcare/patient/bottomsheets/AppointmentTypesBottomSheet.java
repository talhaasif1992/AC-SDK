package com.augmentcare.patient.bottomsheets;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.AppointmentTypeAdapter;
import com.augmentcare.patient.base.BaseBottomSheetDialogFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentTypesBottomSheet extends BaseBottomSheetDialogFragment {

    private View rootView;

    private DoctorInfoLimited doctor;
    private DoctorDetail doctorDetail;
    private String doctorId, instantDoctor;

    private RecyclerView.LayoutManager myLayoutManager;
    private AppointmentTypeAdapter mAppointmentTypeAdapter;

    @BindView(R.id.medical_practice_listview)
    RecyclerView mMedicalPracticeRecyclerView;

    @BindView(R.id.radio_button_online)
    RadioButton radioButtonOnline;

    private boolean onlineButtonFlag = false;

    public AppointmentTypesBottomSheet() {
    }

    public static AppointmentTypesBottomSheet getInstance() {
        return new AppointmentTypesBottomSheet();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_practice_locations, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        gettingDataFromBundle();

        mAppointmentTypeAdapter = new AppointmentTypeAdapter(doctorDetail.getMedicalPractices(), baseActivity);
        mMedicalPracticeRecyclerView.setVisibility(View.VISIBLE);
        mMedicalPracticeRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getContext());
        mMedicalPracticeRecyclerView.setLayoutManager(myLayoutManager);
        mMedicalPracticeRecyclerView.setAdapter(mAppointmentTypeAdapter);

        mMedicalPracticeRecyclerView.setVisibility(View.VISIBLE);
        radioButtonOnline.setVisibility(View.VISIBLE);

        if(onlineButtonFlag){
            radioButtonOnline.setVisibility(View.VISIBLE);
        }
        else{
            radioButtonOnline.setVisibility(View.GONE);
        }

        mAppointmentTypeAdapter.setOnItemClickListener((medicalPracticeName, medicalPracticeId) -> {
            PrefsHelper.get(getContext()).putString(Constants.SLOT_LOCATION, Integer.toString(medicalPracticeId));
            safeNavigateTo(navController -> {
                navController.navigate(
                        AppointmentTypesBottomSheetDirections
                                .actionAppointmentTypesBottomSheetToBookAppointmentFragment()
                                .setDoctor(doctor)
                                .setDoctorId(doctorId)
                                .setDoctorDetailId(doctorDetail.getDocterInfo().getDoctorUid())
                                .setInstantDoctor(instantDoctor)
                                .setType("explore")
                                .setMedicalPracticeName(medicalPracticeName)
                                .setMedicalPracticeId(Integer.toString(medicalPracticeId))
                                .setAppointmentType("offline")
                );
            });
        });

        radioButtonOnline.setOnClickListener(view -> {
            PrefsHelper.get(getContext()).putString(Constants.SLOT_LOCATION, "Online");
            safeNavigateTo(navController -> {
                navController.navigate(AppointmentTypesBottomSheetDirections
                        .actionAppointmentTypesBottomSheetToBookAppointmentFragment()
                        .setDoctor(doctor)
                        .setInstantDoctor(instantDoctor)
                        .setDoctorId(doctorId)
                        .setDoctorDetailId(Integer.toString(doctorDetail.getDocterInfo().getId()))
                        .setType("explore")
                        .setMedicalPracticeId("")
                        .setMedicalPracticeName("")
                        .setAppointmentType("online"));
            });
        });
    }

    public void gettingDataFromBundle() {
        if (getArguments() != null) {
            AppointmentTypesBottomSheetArgs args = AppointmentTypesBottomSheetArgs.fromBundle(getArguments());
            doctorDetail = args.getDoctorDetail();
            doctor = args.getDoctor();
            doctorId = args.getDoctorId();
            instantDoctor = args.getInstantDoctor();
            onlineButtonFlag = args.getOnlineButtonFlag();
        }
    }
}