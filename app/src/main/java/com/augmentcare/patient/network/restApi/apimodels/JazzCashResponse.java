package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JazzCashResponse implements Parcelable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("errors")
    @Expose
    private String errors;
    @SerializedName("status")
    @Expose
    private Integer status;
    public final static Parcelable.Creator<JazzCashResponse> CREATOR = new Creator<JazzCashResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JazzCashResponse createFromParcel(Parcel in) {
            return new JazzCashResponse(in);
        }

        public JazzCashResponse[] newArray(int size) {
            return (new JazzCashResponse[size]);
        }

    }
            ;

    protected JazzCashResponse(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.errors = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public JazzCashResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public JazzCashResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public JazzCashResponse withErrors(String errors) {
        this.errors = errors;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public JazzCashResponse withStatus(Integer status) {
        this.status = status;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(errors);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }
}