package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Test implements Parcelable {

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
    private String quantityLoose;
    @SerializedName("origin_table")
    @Expose
    private String originTable;
    @SerializedName("report_id")
    @Expose
    private Integer reportId;
    @SerializedName("uploaded_link")
    @Expose
    private String uploadedLink;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type")
    @Expose
    private String itemType;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("strength")
    @Expose
    private String strength;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("prescription_status")
    @Expose
    private String prescriptionStatus;
    @SerializedName("cart_id")
    @Expose
    private Integer cartId;
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
    public final static Parcelable.Creator<Test> CREATOR = new Creator<Test>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        public Test[] newArray(int size) {
            return (new Test[size]);
        }

    };

    protected Test(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.itemName = ((String) in.readValue((String.class.getClassLoader())));
        this.itemPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.quantityPack = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sku = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.changedQuantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.quantityLoose = ((String) in.readValue((String.class.getClassLoader())));
        this.originTable = ((String) in.readValue((String.class.getClassLoader())));
        this.reportId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.uploadedLink = ((String) in.readValue((String.class.getClassLoader())));
        this.itemId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.itemType = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.strength = ((String) in.readValue((String.class.getClassLoader())));
        this.isDeleted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.prescriptionStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.cartId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.originalPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userPrescriptionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Test withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Test withOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Test withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Test withItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public Integer getQuantityPack() {
        return quantityPack;
    }

    public void setQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
    }

    public Test withQuantityPack(Integer quantityPack) {
        this.quantityPack = quantityPack;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Test withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Test withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Test withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getChangedQuantity() {
        return changedQuantity;
    }

    public void setChangedQuantity(Integer changedQuantity) {
        this.changedQuantity = changedQuantity;
    }

    public Test withChangedQuantity(Integer changedQuantity) {
        this.changedQuantity = changedQuantity;
        return this;
    }

    public String getQuantityLoose() {
        return quantityLoose;
    }

    public void setQuantityLoose(String quantityLoose) {
        this.quantityLoose = quantityLoose;
    }

    public Test withQuantityLoose(String quantityLoose) {
        this.quantityLoose = quantityLoose;
        return this;
    }

    public String getOriginTable() {
        return originTable;
    }

    public void setOriginTable(String originTable) {
        this.originTable = originTable;
    }

    public Test withOriginTable(String originTable) {
        this.originTable = originTable;
        return this;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Test withReportId(Integer reportId) {
        this.reportId = reportId;
        return this;
    }

    public String getUploadedLink() {
        return uploadedLink;
    }

    public void setUploadedLink(String uploadedLink) {
        this.uploadedLink = uploadedLink;
    }

    public Test withUploadedLink(String uploadedLink) {
        this.uploadedLink = uploadedLink;
        return this;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Test withItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Test withItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Test withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public Test withStrength(String strength) {
        this.strength = strength;
        return this;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Test withIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public String getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(String prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public Test withPrescriptionStatus(String prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
        return this;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Test withCartId(Integer cartId) {
        this.cartId = cartId;
        return this;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Test withOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Test withDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public Integer getUserPrescriptionId() {
        return userPrescriptionId;
    }

    public void setUserPrescriptionId(Integer userPrescriptionId) {
        this.userPrescriptionId = userPrescriptionId;
    }

    public Test withUserPrescriptionId(Integer userPrescriptionId) {
        this.userPrescriptionId = userPrescriptionId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Test withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("orderId", orderId).append("itemName", itemName).append("itemPrice", itemPrice).append("quantityPack", quantityPack).append("sku", sku).append("createdAt", createdAt).append("updatedAt", updatedAt).append("changedQuantity", changedQuantity).append("quantityLoose", quantityLoose).append("originTable", originTable).append("reportId", reportId).append("uploadedLink", uploadedLink).append("itemId", itemId).append("itemType", itemType).append("category", category).append("strength", strength).append("isDeleted", isDeleted).append("prescriptionStatus", prescriptionStatus).append("cartId", cartId).append("originalPrice", originalPrice).append("discount", discount).append("userPrescriptionId", userPrescriptionId).append("status", status).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(orderId);
        dest.writeValue(itemName);
        dest.writeValue(itemPrice);
        dest.writeValue(quantityPack);
        dest.writeValue(sku);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(changedQuantity);
        dest.writeValue(quantityLoose);
        dest.writeValue(originTable);
        dest.writeValue(reportId);
        dest.writeValue(uploadedLink);
        dest.writeValue(itemId);
        dest.writeValue(itemType);
        dest.writeValue(category);
        dest.writeValue(strength);
        dest.writeValue(isDeleted);
        dest.writeValue(prescriptionStatus);
        dest.writeValue(cartId);
        dest.writeValue(originalPrice);
        dest.writeValue(discount);
        dest.writeValue(userPrescriptionId);
        dest.writeValue(status);
    }

    public int describeContents() {
        return 0;
    }

}