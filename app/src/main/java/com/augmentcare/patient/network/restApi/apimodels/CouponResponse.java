package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class CouponResponse implements Parcelable
{

    @SerializedName("cart_details")
    @Expose
    private List<CartDetail> cartDetails = new ArrayList<CartDetail>();
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
    private DeliveryDetail speedyDelivery;
    @SerializedName("normal_delivery")
    @Expose
    private DeliveryDetail normalDelivery;
    @SerializedName("out_of_city_delivery")
    @Expose
    private DeliveryDetail outOfCityDelivery;
    public final static Parcelable.Creator<CouponResponse> CREATOR = new Creator<CouponResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CouponResponse createFromParcel(Parcel in) {
            return new CouponResponse(in);
        }

        public CouponResponse[] newArray(int size) {
            return (new CouponResponse[size]);
        }

    }
            ;

    protected CouponResponse(Parcel in) {
        in.readList(this.cartDetails, (CartDetail.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deliveryCharges = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.speedyDelivery = ((DeliveryDetail) in.readValue((DeliveryDetail.class.getClassLoader())));
        this.normalDelivery = ((DeliveryDetail) in.readValue((DeliveryDetail.class.getClassLoader())));
        this.outOfCityDelivery = ((DeliveryDetail) in.readValue((DeliveryDetail.class.getClassLoader())));
    }

    public CouponResponse() {
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public CouponResponse withCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public CouponResponse withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public CouponResponse withDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public CouponResponse withDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public DeliveryDetail getSpeedyDelivery() {
        return speedyDelivery;
    }

    public void setSpeedyDelivery(DeliveryDetail speedyDelivery) {
        this.speedyDelivery = speedyDelivery;
    }

    public CouponResponse withSpeedyDelivery(DeliveryDetail speedyDelivery) {
        this.speedyDelivery = speedyDelivery;
        return this;
    }

    public DeliveryDetail getNormalDelivery() {
        return normalDelivery;
    }

    public void setNormalDelivery(DeliveryDetail normalDelivery) {
        this.normalDelivery = normalDelivery;
    }

    public CouponResponse withNormalDelivery(DeliveryDetail normalDelivery) {
        this.normalDelivery = normalDelivery;
        return this;
    }

    public DeliveryDetail getOutOfCityDelivery() {
        return outOfCityDelivery;
    }

    public void setOutOfCityDelivery(DeliveryDetail outOfCityDelivery) {
        this.outOfCityDelivery = outOfCityDelivery;
    }

    public CouponResponse withOutOfCityDelivery(DeliveryDetail outOfCityDelivery) {
        this.outOfCityDelivery = outOfCityDelivery;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cartDetails", cartDetails).append("total", total).append("deliveryCharges", deliveryCharges).append("discount", discount).append("speedyDelivery", speedyDelivery).append("normalDelivery", normalDelivery).append("outOfCityDelivery", outOfCityDelivery).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cartDetails);
        dest.writeValue(total);
        dest.writeValue(deliveryCharges);
        dest.writeValue(discount);
        dest.writeValue(speedyDelivery);
        dest.writeValue(normalDelivery);
        dest.writeValue(outOfCityDelivery);
    }

    public int describeContents() {
        return 0;
    }

}