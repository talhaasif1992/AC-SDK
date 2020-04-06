
package com.augmentcare.patient.model.prescribedLabsModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("prescribed_tests")
    @Expose
    private List<PrescribedTest> prescribedTests = null;

    public List<PrescribedTest> getPrescribedTests() {
        return prescribedTests;
    }

    public void setPrescribedTests(List<PrescribedTest> prescribedTests) {
        this.prescribedTests = prescribedTests;
    }

}
