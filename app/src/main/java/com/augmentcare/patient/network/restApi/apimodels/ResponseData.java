package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData<T> extends ErrorResponse{


    @SerializedName("data")
    @Expose
    private T data;
    /**
     * No args constructor for use in serialization
     */
    public ResponseData() {
    }

    /**
     * @param data
     */
    public ResponseData(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseData withData(T data) {
        this.data = data;
        return this;
    }

}