
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Top_ {

    @SerializedName("v")
    @Expose
    private Integer v;
    @SerializedName("u")
    @Expose
    private String u;

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

}
