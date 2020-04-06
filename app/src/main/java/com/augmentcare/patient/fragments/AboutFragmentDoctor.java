package com.augmentcare.patient.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.PmdcWebViewActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.skyhope.showmoretextview.ShowMoreTextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AboutFragmentDoctor extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.text_view_show_more)
    ShowMoreTextView aboutTv;
    @BindView(R.id.pmdcTV)
    TextView pmdcTV;

    @BindView(R.id.pmdcView)
    TextView pmdcView;


    private View rootView;


    private DoctorDetail doctorDetail;

    public AboutFragmentDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_doctor, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pmdcView.setOnClickListener(this);
    }

    public void setDoctorDetail(DoctorDetail doctorDetail) {
        this.doctorDetail = doctorDetail;

        MyApp.HANDLER.post(() -> {
            if (doctorDetail != null) {
                if(doctorDetail.getDocterInfo().getPmdcNumber() != null && !doctorDetail.getDocterInfo().getPmdcNumber().isEmpty()) {
                    pmdcTV.setText(doctorDetail.getDocterInfo().getPmdcNumber());
                }
                String specialization="", education="", name, experience;

                name = doctorDetail.getDocterInfo().getName();

                if(doctorDetail.getDocterInfo().getSpecialization()==null){
                    for(int i=0; i < doctorDetail.getSpecializations().size(); i++) {
                        if(i== doctorDetail.getSpecializations().size()-1){
                            specialization = specialization + (doctorDetail.getSpecializations().get(i).getName());
                        }
                        else{
                            specialization = specialization + (doctorDetail.getSpecializations().get(i).getName()) +", ";
                        }
                    }
                }
                else{
                    specialization = doctorDetail.getDocterInfo().getSpecialization();
                }

                if(doctorDetail.getDocterInfo().getEducation() == null){
                    for(int i=0; i< doctorDetail.getEducationExperience().size(); i++) {
                        if(i==doctorDetail.getEducationExperience().size()-1) {
                            education = doctorDetail.getEducationExperience().get(i).getName();
                        }
                        else{
                            education = doctorDetail.getEducationExperience().get(i).getName()+", ";
                        }
                    }
                }
                else{
                    education = doctorDetail.getDocterInfo().getEducation();
                }
                if(doctorDetail.getDocterInfo().getExperience()== null || doctorDetail.getDocterInfo().getExperience()== 0){
                    experience = "";
                }
                else if(doctorDetail.getDocterInfo().getExperience() != null && doctorDetail.getDocterInfo().getExperience()==1){
                    experience = doctorDetail.getDocterInfo().getExperience() + " year experienced ";
                }
                else{
                    experience = doctorDetail.getDocterInfo().getExperience() + " years experienced ";
                }

                aboutTv.setText(name + " is a " +
                        experience +
                        specialization + ". " +
                        name + " has the following Degree/Degrees: " +
                        education + ". " + "You can book an Appointment with " +
                        name + " by using the 'Book Appointment' Button.");

                aboutTv.setShowingLine(2);
                aboutTv.addShowMoreText("Read More");
                aboutTv.setShowMoreColor(R.color.colorGrayDark);
                aboutTv.setShowLessTextColor(R.color.colorGrayDark);

            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pmdcView:
                try {
                    if (doctorDetail.getDocterInfo().getPmdcNumber() != null) {
                        Intent intent = new Intent(getContext(), PmdcWebViewActivity.class);
                        intent.putExtra("doctor_name", doctorDetail.getDocterInfo().getName());
                        intent.putExtra("pmdc_number", doctorDetail.getDocterInfo().getPmdcNumber() + "");
                        startActivity(intent);
                    }
                } catch (Exception ignored) {
                }
                break;
        }
    }
}
