
package com.augmentcare.patient.model.instantDoctorModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Available {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("doctor")
    @Expose
    private Doctor doctor;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
