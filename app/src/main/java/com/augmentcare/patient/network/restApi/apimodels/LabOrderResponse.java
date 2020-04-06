package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class LabOrderResponse implements Parcelable {

    @SerializedName("order")
    @Expose
    private Order order;
    @SerializedName("order_items")
    @Expose
    private List<Test> orderItems = new ArrayList<Test>();
    public final static Parcelable.Creator<LabOrderResponse> CREATOR = new Creator<LabOrderResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LabOrderResponse createFromParcel(Parcel in) {
            return new LabOrderResponse(in);
        }

        public LabOrderResponse[] newArray(int size) {
            return (new LabOrderResponse[size]);
        }

    };

    protected LabOrderResponse(Parcel in) {
        this.order = ((Order) in.readValue((Order.class.getClassLoader())));
        in.readList(this.orderItems, (Test.class.getClassLoader()));
    }

    public LabOrderResponse() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LabOrderResponse withOrder(Order order) {
        this.order = order;
        return this;
    }

    public List<Test> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Test> orderItems) {
        this.orderItems = orderItems;
    }

    public LabOrderResponse withOrderItems(List<Test> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("order", order).append("orderItems", orderItems).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(order);
        dest.writeList(orderItems);
    }

    public int describeContents() {
        return 0;
    }

}