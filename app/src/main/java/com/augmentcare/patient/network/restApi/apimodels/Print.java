
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Print implements Parcelable
{

    @SerializedName("prescription")
    @Expose
    private Prescription prescription;
    @SerializedName("invoice")
    @Expose
    private Invoice invoice;
    public final static Creator<Print> CREATOR = new Creator<Print>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Print createFromParcel(Parcel in) {
            return new Print(in);
        }

        public Print[] newArray(int size) {
            return (new Print[size]);
        }

    }
    ;

    protected Print(Parcel in) {
        this.prescription = ((Prescription) in.readValue((Prescription.class.getClassLoader())));
        this.invoice = ((Invoice) in.readValue((Invoice.class.getClassLoader())));
    }

    public Print() {
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Print withPrescription(Prescription prescription) {
        this.prescription = prescription;
        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Print withInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("prescription", prescription).append("invoice", invoice).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(prescription);
        dest.writeValue(invoice);
    }

    public int describeContents() {
        return  0;
    }

}
