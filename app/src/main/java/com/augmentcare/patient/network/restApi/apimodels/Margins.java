
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Margins implements Parcelable
{

    @SerializedName("top")
    @Expose
    private MarginSub top;
    @SerializedName("right")
    @Expose
    private MarginSub right;
    @SerializedName("bottom")
    @Expose
    private MarginSub bottom;
    @SerializedName("left")
    @Expose
    private MarginSub left;
    public final static Creator<Margins> CREATOR = new Creator<Margins>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Margins createFromParcel(Parcel in) {
            return new Margins(in);
        }

        public Margins[] newArray(int size) {
            return (new Margins[size]);
        }

    }
    ;

    protected Margins(Parcel in) {
        this.top = ((MarginSub) in.readValue((MarginSub.class.getClassLoader())));
        this.right = ((MarginSub) in.readValue((MarginSub.class.getClassLoader())));
        this.bottom = ((MarginSub) in.readValue((MarginSub.class.getClassLoader())));
        this.left = ((MarginSub) in.readValue((MarginSub.class.getClassLoader())));
    }

    public Margins() {
    }

    public MarginSub getTop() {
        return top;
    }

    public void setTop(MarginSub top) {
        this.top = top;
    }

    public Margins withTop(MarginSub top) {
        this.top = top;
        return this;
    }

    public MarginSub getRight() {
        return right;
    }

    public void setRight(MarginSub right) {
        this.right = right;
    }

    public Margins withRight(MarginSub right) {
        this.right = right;
        return this;
    }

    public MarginSub getBottom() {
        return bottom;
    }

    public void setBottom(MarginSub bottom) {
        this.bottom = bottom;
    }

    public Margins withBottom(MarginSub bottom) {
        this.bottom = bottom;
        return this;
    }

    public MarginSub getLeft() {
        return left;
    }

    public void setLeft(MarginSub left) {
        this.left = left;
    }

    public Margins withLeft(MarginSub left) {
        this.left = left;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("top", top).append("right", right).append("bottom", bottom).append("left", left).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(top);
        dest.writeValue(right);
        dest.writeValue(bottom);
        dest.writeValue(left);
    }

    public int describeContents() {
        return  0;
    }

}
