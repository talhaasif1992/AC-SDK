package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class AuthenticateOEResponse implements Parcelable {

    @SerializedName("medicines")
    @Expose
    private List<Medicine> medicines = new ArrayList<Medicine>();
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<AuthenticateOEResponse> CREATOR = new Creator<AuthenticateOEResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AuthenticateOEResponse createFromParcel(Parcel in) {
            return new AuthenticateOEResponse(in);
        }

        public AuthenticateOEResponse[] newArray(int size) {
            return (new AuthenticateOEResponse[size]);
        }

    };

    protected AuthenticateOEResponse(Parcel in) {
        in.readList(this.medicines, (java.lang.Object.class.getClassLoader()));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AuthenticateOEResponse() {
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public AuthenticateOEResponse withMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AuthenticateOEResponse withError(String error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("medicines", medicines).append("error", error).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(medicines);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}