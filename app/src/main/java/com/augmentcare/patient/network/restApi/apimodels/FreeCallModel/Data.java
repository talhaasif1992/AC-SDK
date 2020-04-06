package com.augmentcare.patient.network.restApi.apimodels.FreeCallModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

    @SerializedName("free_calls")
    @Expose
    private Integer freeCalls;
    @SerializedName("completed_calls")
    @Expose
    private Integer completedCalls;
    @SerializedName("pending_calls")
    @Expose
    private Integer pendingCalls;
    @SerializedName("today_calls")
    @Expose
    private TodayCalls todayCalls;

    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    };

    protected Data(Parcel in){
        this.freeCalls = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.completedCalls = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pendingCalls = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.todayCalls = ((TodayCalls) in.readValue((TodayCalls.class.getClassLoader())));
    }

    public Data() {
    }

    public Integer getFreeCalls() {
        return freeCalls;
    }

    public void setFreeCalls(Integer freeCalls) {
        this.freeCalls = freeCalls;
    }

    public Data withFreeCalls(Integer freeCalls) {
        this.freeCalls = freeCalls;
        return this;
    }

    public Integer getCompletedCalls() {
        return completedCalls;
    }

    public void setCompletedCalls(Integer completedCalls) {
        this.completedCalls = completedCalls;
    }

    public Data withCompletedCalls(Integer completedCalls) {
        this.completedCalls = completedCalls;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(freeCalls);
        dest.writeValue(completedCalls);
        dest.writeValue(pendingCalls);
        dest.writeValue(todayCalls);
    }

    public int describeContents() {
        return 0;
    }

    public Integer getPendingCalls() {
        return pendingCalls;
    }

    public void setPendingCalls(Integer pendingCalls) {
        this.pendingCalls = pendingCalls;
    }

    public Data withPendingCalls(Integer pendingCalls){
        this.pendingCalls = pendingCalls;
        return this;
    }

    public TodayCalls getTodayCalls() {
        return todayCalls;
    }

    public void setTodayCalls(TodayCalls todayCalls) {
        this.todayCalls = todayCalls;
    }
}