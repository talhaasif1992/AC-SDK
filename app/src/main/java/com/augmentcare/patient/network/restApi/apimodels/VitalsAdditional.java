
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class VitalsAdditional implements Parcelable
{

    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("u")
    @Expose
    private String u;
    @SerializedName("c")
    @Expose
    private String c;
    public final static Creator<VitalsAdditional> CREATOR = new Creator<VitalsAdditional>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VitalsAdditional createFromParcel(Parcel in) {
            return new VitalsAdditional(in);
        }

        public VitalsAdditional[] newArray(int size) {
            return (new VitalsAdditional[size]);
        }

    }
    ;

    protected VitalsAdditional(Parcel in) {
        this.l = ((String) in.readValue((String.class.getClassLoader())));
        this.u = ((String) in.readValue((String.class.getClassLoader())));
        this.c = ((String) in.readValue((String.class.getClassLoader())));
    }

    public VitalsAdditional() {
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public VitalsAdditional withL(String l) {
        this.l = l;
        return this;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public VitalsAdditional withU(String u) {
        this.u = u;
        return this;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public VitalsAdditional withC(String c) {
        this.c = c;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("l", l).append("u", u).append("c", c).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(l);
        dest.writeValue(u);
        dest.writeValue(c);
    }

    public int describeContents() {
        return  0;
    }

}
