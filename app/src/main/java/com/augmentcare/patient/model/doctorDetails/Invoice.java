
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Invoice {

    @SerializedName("paper")
    @Expose
    private String paper;
    @SerializedName("paper_size")
    @Expose
    private String paperSize;
    @SerializedName("orientation")
    @Expose
    private String orientation;
    @SerializedName("margins")
    @Expose
    private Margins_ margins;

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Margins_ getMargins() {
        return margins;
    }

    public void setMargins(Margins_ margins) {
        this.margins = margins;
    }

}
