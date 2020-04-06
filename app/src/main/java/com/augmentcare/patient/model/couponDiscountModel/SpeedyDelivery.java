
package com.augmentcare.patient.model.couponDiscountModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SpeedyDelivery implements Serializable {

    @SerializedName("charges")
    @Expose
    private Integer charges;
    @SerializedName("delivery_time")
    @Expose
    private String deliveryTime;

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
