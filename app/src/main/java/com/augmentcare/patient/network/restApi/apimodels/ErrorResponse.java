package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class ErrorResponse implements Parcelable {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("status")
    @Expose
    protected String status;
    @SerializedName("errors")
    @Expose
    protected Errors errors; // because sometimes it also returns only List<>
    @SerializedName("error")
    @Expose
    protected String error;
    @SerializedName("message")
    @Expose
    protected String message;
    public final static Parcelable.Creator<ErrorResponse> CREATOR = new Creator<ErrorResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ErrorResponse createFromParcel(Parcel in) {
            return new ErrorResponse(in);
        }

        public ErrorResponse[] newArray(int size) {
            return (new ErrorResponse[size]);
        }

    };

    protected ErrorResponse(Parcel in) {
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.errors = ((Errors) in.readValue((Errors.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public ErrorResponse() {
    }

    /**
     * @param error
     * @param message
     * @param errors
     * @param status
     */
    public ErrorResponse(boolean success, String status, Errors errors, String error, String message) {
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

    public ErrorResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public ErrorResponse withErrors(Errors errors) {
        this.errors = errors;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorResponse withError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse withMessage(String message) {
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

    @NotNull
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