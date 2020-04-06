
package com.augmentcare.patient.model.labOrderSuccessModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    @SerializedName("med_order")
    @Expose
    private Object medOrder;
    @SerializedName("lab_order")
    @Expose
    private LabOrder labOrder;

    public Object getMedOrder() {
        return medOrder;
    }

    public void setMedOrder(Object medOrder) {
        this.medOrder = medOrder;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public void setLabOrder(LabOrder labOrder) {
        this.labOrder = labOrder;
    }

}
