
package com.augmentcare.patient.model.prescribedMedicineModel;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable {

    @SerializedName("prescribed_medicines")
    @Expose
    private List<PrescribedMedicine> prescribedMedicines = null;

    public List<PrescribedMedicine> getPrescribedMedicines() {
        return prescribedMedicines;
    }

    public void setPrescribedMedicines(List<PrescribedMedicine> prescribedMedicines) {
        this.prescribedMedicines = prescribedMedicines;
    }

}
