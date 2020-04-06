
package com.augmentcare.patient.model.doctorDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Margins_ {

    @SerializedName("top")
    @Expose
    private Top_ top;
    @SerializedName("right")
    @Expose
    private Right_ right;
    @SerializedName("bottom")
    @Expose
    private Bottom_ bottom;
    @SerializedName("left")
    @Expose
    private Left_ left;

    public Top_ getTop() {
        return top;
    }

    public void setTop(Top_ top) {
        this.top = top;
    }

    public Right_ getRight() {
        return right;
    }

    public void setRight(Right_ right) {
        this.right = right;
    }

    public Bottom_ getBottom() {
        return bottom;
    }

    public void setBottom(Bottom_ bottom) {
        this.bottom = bottom;
    }

    public Left_ getLeft() {
        return left;
    }

    public void setLeft(Left_ left) {
        this.left = left;
    }

}
