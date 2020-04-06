
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MarginSub implements Parcelable
{

    @SerializedName("v")
    @Expose
    private int v;
    @SerializedName("u")
    @Expose
    private String u;
    public final static Creator<MarginSub> CREATOR = new Creator<MarginSub>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MarginSub createFromParcel(Parcel in) {
            return new MarginSub(in);
        }

        public MarginSub[] newArray(int size) {
            return (new MarginSub[size]);
        }

    }
    ;

    protected MarginSub(Parcel in) {
        this.v = ((int) in.readValue((int.class.getClassLoader())));
        this.u = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MarginSub() {
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public MarginSub withV(int v) {
        this.v = v;
        return this;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public MarginSub withU(String u) {
        this.u = u;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("v", v).append("u", u).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(v);
        dest.writeValue(u);
    }

    public int describeContents() {
        return  0;
    }

}
