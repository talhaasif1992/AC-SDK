package com.augmentcare.patient.network.restApi.apimodels.FreeCallModel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FreeCallModel implements Parcelable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private Integer status;
    public final static Parcelable.Creator<FreeCallModel> CREATOR = new Creator<FreeCallModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FreeCallModel createFromParcel(Parcel in) {
            return new FreeCallModel(in);
        }

        public FreeCallModel[] newArray(int size) {
            return (new FreeCallModel[size]);
        }

    };

    protected FreeCallModel(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public FreeCallModel() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public FreeCallModel withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public FreeCallModel withData(Data data) {
        this.data = data;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public FreeCallModel withStatus(Integer status) {
        this.status = status;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(data);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}