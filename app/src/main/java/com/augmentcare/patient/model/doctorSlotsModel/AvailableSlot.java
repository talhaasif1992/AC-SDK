
package com.augmentcare.patient.model.doctorSlotsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableSlot {

    @SerializedName("start_time")
    @Expose
    private String startTime;

    @SerializedName("end_time")
    @Expose
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
