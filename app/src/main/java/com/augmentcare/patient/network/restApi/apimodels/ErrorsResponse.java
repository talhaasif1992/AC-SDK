package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class ErrorsResponse implements Parcelable {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status")
    @Expose
    protected String status;
    @SerializedName("errors")
    @Expose
    protected List<String> errors; // because sometimes it also returns only List<>
    @SerializedName("error")
    @Expose
    protected String error;
    @SerializedName("message")
    @Expose
    protected String message;
    public final static Parcelable.Creator<ErrorsResponse> CREATOR = new Creator<ErrorsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ErrorsResponse createFromParcel(Parcel in) {
            return new ErrorsResponse(in);
        }

        public ErrorsResponse[] newArray(int size) {
            return (new ErrorsResponse[size]);
        }

    };

    protected ErrorsResponse(Parcel in) {
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.errors,String.class.getClassLoader());
        this.error = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public ErrorsResponse() {
    }

    /**
     * @param error
     * @param message
     * @param errors
     * @param status
     */
    public ErrorsResponse(boolean success, String status, List<String> errors, String error, String message) {
        super();
        this.success = success;
        this.status = status;
        this.errors = errors;
        this.error = error;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorsResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ErrorsResponse withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorsResponse withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorsResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isSuccess() {
        return success || (status != null && status.equalsIgnoreCase("SUCCESS"));
    }

    public void setSuccess(boolean success) {
        this.success = success;
        this.status = "SUCCESS";
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("success", success).append("status", status).append("errors", errors).append("error", error).append("message", message).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(status);
        dest.writeValue(errors);
        dest.writeValue(error);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}