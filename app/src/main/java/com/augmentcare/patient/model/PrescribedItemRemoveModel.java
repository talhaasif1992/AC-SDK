package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class PrescribedItemRemoveModel {

    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("data")
    private Data data;
    @Expose
    @SerializedName("success")
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class Data {
        @Expose
        @SerializedName("delivery_charges")
        private int delivery_charges;
        @Expose
        @SerializedName("total")
        private int total;
        @Expose
        @SerializedName("cart_details")
        private List<Cart_details> cart_details;

        public int getDelivery_charges() {
            return delivery_charges;
        }

        public void setDelivery_charges(int delivery_charges) {
            this.delivery_charges = delivery_charges;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Cart_details> getCart_details() {
            return cart_details;
        }

        public void setCart_details(List<Cart_details> cart_details) {
            this.cart_details = cart_details;
        }
    }

    public static class Cart_details {
        @Expose
        @SerializedName("available_in_loose")
        private boolean available_in_loose;
        @Expose
        @SerializedName("uploaded_prescription")
        private List<String> uploaded_prescription;
        @Expose
        @SerializedName("quantity_pack")
        private int quantity_pack;
        @Expose
        @SerializedName("prescription_required")
        private boolean prescription_required;
        @Expose
        @SerializedName("specimen")
        private String specimen;
        @Expose
        @SerializedName("price")
        private int price;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("type")
        private String type;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("item_id")
        private int item_id;

        public boolean getAvailable_in_loose() {
            return available_in_loose;
        }

        public void setAvailable_in_loose(boolean available_in_loose) {
            this.available_in_loose = available_in_loose;
        }

        public List<String> getUploaded_prescription() {
            return uploaded_prescription;
        }

        public void setUploaded_prescription(List<String> uploaded_prescription) {
            this.uploaded_prescription = uploaded_prescription;
        }

        public int getQuantity_pack() {
            return quantity_pack;
        }

        public void setQuantity_pack(int quantity_pack) {
            this.quantity_pack = quantity_pack;
        }

        public boolean getPrescription_required() {
            return prescription_required;
        }

        public void setPrescription_required(boolean prescription_required) {
            this.prescription_required = prescription_required;
        }

        public String getSpecimen() {
            return specimen;
        }

        public void setSpecimen(String specimen) {
            this.specimen = specimen;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }
    }
}
