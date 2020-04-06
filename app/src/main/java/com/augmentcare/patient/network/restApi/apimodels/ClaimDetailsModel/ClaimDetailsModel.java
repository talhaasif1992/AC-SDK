package com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ClaimDetailsModel implements Parcelable{

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<ClaimDetailsModel> CREATOR = new Creator<ClaimDetailsModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ClaimDetailsModel createFromParcel(Parcel in) {
            return new ClaimDetailsModel(in);
        }

        public ClaimDetailsModel[] newArray(int size) {
            return (new ClaimDetailsModel[size]);
        }

    }
            ;

    protected ClaimDetailsModel(Parcel in) {
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        in.readList(this.errors, (java.lang.Object.class.getClassLoader()));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public ClaimDetailsModel() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ClaimDetailsModel withData(Data data) {
        this.data = data;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public ClaimDetailsModel withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ClaimDetailsModel withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
        dest.writeList(errors);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}
