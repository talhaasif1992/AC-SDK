
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.model.doctorDetails.Margins;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Invoice implements Parcelable
{

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
    private Margins margins;
    public final static Creator<Invoice> CREATOR = new Creator<Invoice>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Invoice createFromParcel(Parcel in) {
            return new Invoice(in);
        }

        public Invoice[] newArray(int size) {
            return (new Invoice[size]);
        }

    }
    ;

    protected Invoice(Parcel in) {
        this.paper = ((String) in.readValue((String.class.getClassLoader())));
        this.paperSize = ((String) in.readValue((String.class.getClassLoader())));
        this.orientation = ((String) in.readValue((String.class.getClassLoader())));
        this.margins = ((Margins) in.readValue((Margins.class.getClassLoader())));
    }

    public Invoice() {
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Invoice withPaper(String paper) {
        this.paper = paper;
        return this;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public Invoice withPaperSize(String paperSize) {
        this.paperSize = paperSize;
        return this;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Invoice withOrientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    public Margins getMargins() {
        return margins;
    }

    public void setMargins(Margins margins) {
        this.margins = margins;
    }

    public Invoice withMargins(Margins margins) {
        this.margins = margins;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("paper", paper).append("paperSize", paperSize).append("orientation", orientation).append("margins", margins).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(paper);
        dest.writeValue(paperSize);
        dest.writeValue(orientation);
        dest.writeValue(margins);
    }

    public int describeContents() {
        return  0;
    }

}
