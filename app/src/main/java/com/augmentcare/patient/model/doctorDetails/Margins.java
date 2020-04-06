
package com.augmentcare.patient.model.doctorDetails;

import com.augmentcare.patient.network.restApi.apimodels.MarginSub;
import com.google.gson.annotations.SerializedName;

public class Margins {

    @SerializedName("top")
    private MarginSub top;
    @SerializedName("right")
    private MarginSub right;
    @SerializedName("bottom")
    private MarginSub bottom;
    @SerializedName("left")
    private MarginSub left;

    public MarginSub getTop() {
        return top;
    }

    public void setTop(MarginSub top) {
        this.top = top;
    }

    public MarginSub getRight() {
        return right;
    }

    public void setRight(MarginSub right) {
        this.right = right;
    }

    public MarginSub getBottom() {
        return bottom;
    }

    public void setBottom(MarginSub bottom) {
        this.bottom = bottom;
    }

    public MarginSub getLeft() {
        return left;
    }

    public void setLeft(MarginSub left) {
        this.left = left;
    }

}
