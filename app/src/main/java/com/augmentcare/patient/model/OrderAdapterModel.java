
package com.augmentcare.patient.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.augmentcare.patient.model.appointmentModel.Dependent;

public class OrderAdapterModel {

    @SerializedName("order")
    @Expose
    private Order order;

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    @SerializedName("dependent")
    @Expose
    private Dependent dependent;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("order_items")
    @Expose
    private List<OrderItem> orderItems = null;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}