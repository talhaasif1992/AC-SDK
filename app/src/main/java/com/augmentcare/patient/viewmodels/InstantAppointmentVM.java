package com.augmentcare.patient.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.augmentcare.patient.network.restApi.apimodels.Dependent;

public class InstantAppointmentVM extends ViewModel {
    private MutableLiveData<Dependent> dependentMutableLiveData;


    public LiveData<Dependent> getDependent() {
        if(dependentMutableLiveData == null){
            dependentMutableLiveData = new MutableLiveData<Dependent>();
        }
        return dependentMutableLiveData;
    }

    public void setDependent(Dependent dependent) {
        this.dependentMutableLiveData.postValue(dependent);
    }
}
