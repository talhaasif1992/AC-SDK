package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsResponse implements Parcelable {

    @SerializedName("results")
    @Expose
    private List<OrderResults> results = new ArrayList<OrderResults>();
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("prescription_id")
    @Expose
    private Integer prescriptionId;
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<OrderDetailsResponse> CREATOR = new Creator<OrderDetailsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrderDetailsResponse createFromParcel(Parcel in) {
            return new OrderDetailsResponse(in);
        }

        public OrderDetailsResponse[] newArray(int size) {
            return (new OrderDetailsResponse[size]);
        }

    };

    protected OrderDetailsResponse(Parcel in) {
        in.readList(this.results, (OrderResults.class.getClassLoader()));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.prescriptionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public OrderDetailsResponse() {
    }

    public List<OrderResults> getResults() {
        return results;
    }

    public void setResults(List<OrderResults> results) {
        this.results = results;
    }

    public OrderDetailsResponse withResults(List<OrderResults> results) {
        this.results = results;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderDetailsResponse withAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public OrderDetailsResponse withPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public OrderDetailsResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("results", results).append("address", address).append("prescriptionId", prescriptionId).append("success", success).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(address);
        dest.writeValue(prescriptionId);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}