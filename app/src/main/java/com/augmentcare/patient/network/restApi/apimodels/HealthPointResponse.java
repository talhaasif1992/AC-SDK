package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HealthPointResponse implements Parcelable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("healthpoint")
    @Expose
    private Healthpoint healthpoint;
    public final static Parcelable.Creator<HealthPointResponse> CREATOR = new Creator<HealthPointResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HealthPointResponse createFromParcel(Parcel in) {
            return new HealthPointResponse(in);
        }

        public HealthPointResponse[] newArray(int size) {
            return (new HealthPointResponse[size]);
        }

    };

    protected HealthPointResponse(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.healthpoint = ((Healthpoint) in.readValue((Healthpoint.class.getClassLoader())));
    }

    public HealthPointResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public HealthPointResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Healthpoint getHealthpoint() {
        return healthpoint;
    }

    public void setHealthpoint(Healthpoint healthpoint) {
        this.healthpoint = healthpoint;
    }

    public HealthPointResponse withHealthpoint(Healthpoint healthpoint) {
        this.healthpoint = healthpoint;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("success", success).append("healthpoint", healthpoint).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(healthpoint);
    }

    public int describeContents() {
        return 0;
    }

}