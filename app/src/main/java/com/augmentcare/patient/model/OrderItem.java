
package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("itemPrice")
    @Expose
    private Integer itemPrice;
    @SerializedName("quantity_pack")
    @Expose
    private Integer quantityPack;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("changed_quantity")
    @Expose
    private Integer changedQuantity;
    @SerializedName("quantity_loose")
    @Expose
    private Object quantityLoose;
    @SerializedName("origin_table")
    @Expose
    private Object originTable;
    @SerializedName("report_id")
    @Expose
    private Object reportId;
    @SerializedName("uploaded_link")
    @Expose
    private Object uploadedLink;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type")
    @Expose
    private String itemType;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("strength")
    @Expose
    private Object strength;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("prescription_status")
    @Expose
    private Object prescriptionStatus;
    @SerializedName("cart_id")
    @Expose
    private Object cartId;
    @SerializedName("original_price")
    @Expose
    private Integer originalPrice;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("user_prescription_id")
    @Expose
    private Integer userPrescriptionId;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getQuantityPack() {
        return quantityPack;
    }

    public void setQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getChangedQuantity() {
        return changedQuantity;
    }

    public void setChangedQuantity(Integer changedQuantity) {
        this.changedQuantity = changedQuantity;
    }

    public Object getQuantityLoose() {
        return quantityLoose;
    }

    public void setQuantityLoose(Object quantityLoose) {
        this.quantityLoose = quantityLoose;
    }

    public Object getOriginTable() {
        return originTable;
    }

    public void setOriginTable(Object originTable) {
        this.originTable = originTable;
    }

    public Object getReportId() {
        return reportId;
    }

    public void setReportId(Object reportId) {
        this.reportId = reportId;
    }

    public Object getUploadedLink() {
        return uploadedLink;
    }

    public void setUploadedLink(Object uploadedLink) {
        this.uploadedLink = uploadedLink;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Object getStrength() {
        return strength;
    }

    public void setStrength(Object strength) {
        this.strength = strength;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Object getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(Object prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public Object getCartId() {
        return cartId;
    }

    public void setCartId(Object cartId) {
        this.cartId = cartId;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getUserPrescriptionId() {
        return userPrescriptionId;
    }

    public void setUserPrescriptionId(Integer userPrescriptionId) {
        this.userPrescriptionId = userPrescriptionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
