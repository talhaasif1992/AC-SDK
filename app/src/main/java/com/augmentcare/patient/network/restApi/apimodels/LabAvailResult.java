package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class LabAvailResult implements Parcelable
{

    @SerializedName("labs")
    @Expose
    private List<Lab> labs = new ArrayList<Lab>();
    public final static Parcelable.Creator<LabAvailResult> CREATOR = new Creator<LabAvailResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LabAvailResult createFromParcel(Parcel in) {
            return new LabAvailResult(in);
        }

        public LabAvailResult[] newArray(int size) {
            return (new LabAvailResult[size]);
        }

    }
            ;

    protected LabAvailResult(Parcel in) {
        in.readList(this.labs, (com.augmentcare.patient.network.restApi.apimodels.Lab.class.getClassLoader()));
    }

    public LabAvailResult() {
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }

    public LabAvailResult withLabs(List<Lab> labs) {
        this.labs = labs;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("labs", labs).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(labs);
    }

    public int describeContents() {
        return 0;
    }

}
