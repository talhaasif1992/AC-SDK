package com.augmentcare.patient.viewmodels;

import androidx.lifecycle.ViewModel;

import com.augmentcare.patient.network.restApi.apirequests.DoctorsListRequest;

public class FindDoctorVM extends ViewModel {
    private DoctorsListRequest doctorsListRequest;

    public DoctorsListRequest getDoctorsListRequest() {
        return doctorsListRequest;
    }

    public void setDoctorsListRequest(DoctorsListRequest doctorsListRequest) {
        this.doctorsListRequest = doctorsListRequest;
    }

    public void resetDoctorsListRequest(){
        this.doctorsListRequest = null;
    }

}
