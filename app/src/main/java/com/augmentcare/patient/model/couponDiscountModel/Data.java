
package com.augmentcare.patient.model.couponDiscountModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable {

    @SerializedName("cart_details")
    @Expose
    private List<CartDetail> cartDetails = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("delivery_charges")
    @Expose
    private Integer deliveryCharges;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("speedy_delivery")
    @Expose
    private SpeedyDelivery speedyDelivery;
    @SerializedName("normal_delivery")
    @Expose
    private NormalDelivery normalDelivery;
    @SerializedName("out_of_city_delivery")
    @Expose
    private OutOfCityDelivery outOfCityDelivery;

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public SpeedyDelivery getSpeedyDelivery() {
        return speedyDelivery;
    }

    public void setSpeedyDelivery(SpeedyDelivery speedyDelivery) {
        this.speedyDelivery = speedyDelivery;
    }

    public NormalDelivery getNormalDelivery() {
        return normalDelivery;
    }

    public void setNormalDelivery(NormalDelivery normalDelivery) {
        this.normalDelivery = normalDelivery;
    }

    public OutOfCityDelivery getOutOfCityDelivery() {
        return outOfCityDelivery;
    }

    public void setOutOfCityDelivery(OutOfCityDelivery outOfCityDelivery) {
        this.outOfCityDelivery = outOfCityDelivery;
    }

}
