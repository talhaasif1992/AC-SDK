package com.augmentcare.patient.model;

public class QuantityModel {
    String quantity;
    int quantityItemPosition;
    String name;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityItemPosition() {
        return quantityItemPosition;
    }

    public void setQuantityItemPosition(int quantityItemPosition) {
        this.quantityItemPosition = quantityItemPosition;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
