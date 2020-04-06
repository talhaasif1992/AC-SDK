
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VitalsAdditional {

    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("u")
    @Expose
    private String u;
    @SerializedName("c")
    @Expose
    private String c;

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

}
