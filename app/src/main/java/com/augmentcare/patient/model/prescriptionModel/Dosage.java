
package com.augmentcare.patient.model.prescriptionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosage {

    @SerializedName("val")
    @Expose
    private String val;

    @SerializedName("unit")
    @Expose
    private String unit;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
