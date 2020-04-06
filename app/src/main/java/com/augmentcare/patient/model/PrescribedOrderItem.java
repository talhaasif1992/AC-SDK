package com.augmentcare.patient.model;

public class PrescribedOrderItem {
    String item_id;
    String itemName;
    String ItemPrice;
    String orignal_price;
    String discount;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String setItemPrice) {
        this.ItemPrice = setItemPrice;
    }

    public String getOrignal_price() {
        return orignal_price;
    }

    public void setOrignal_price(String orignal_price) {
        this.orignal_price = orignal_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
