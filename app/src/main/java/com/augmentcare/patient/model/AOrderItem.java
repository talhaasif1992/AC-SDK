package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 27/03/2018.
 */

public class AOrderItem implements Parcelable{

    private String id;

    private String itemName;

    private String updated_at;

    private String quantity_pack;

    private String created_at;

    private String report_id;

    private String changed_quantity;

    private String uploaded_link;

    private String sku;

    private String itemPrice;

    private String order_id;

    private String origin_table;

    private String quantity_loose;

    protected AOrderItem(Parcel in) {
        id = in.readString();
        itemName = in.readString();
        updated_at = in.readString();
        quantity_pack = in.readString();
        created_at = in.readString();
        report_id = in.readString();
        changed_quantity = in.readString();
        uploaded_link = in.readString();
        sku = in.readString();
        itemPrice = in.readString();
        order_id = in.readString();
        origin_table = in.readString();
        quantity_loose = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(itemName);
        dest.writeString(updated_at);
        dest.writeString(quantity_pack);
        dest.writeString(created_at);
        dest.writeString(report_id);
        dest.writeString(changed_quantity);
        dest.writeString(uploaded_link);
        dest.writeString(sku);
        dest.writeString(itemPrice);
        dest.writeString(order_id);
        dest.writeString(origin_table);
        dest.writeString(quantity_loose);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AOrderItem> CREATOR = new Creator<AOrderItem>() {
        @Override
        public AOrderItem createFromParcel(Parcel in) {
            return new AOrderItem(in);
        }

        @Override
        public AOrderItem[] newArray(int size) {
            return new AOrderItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getQuantity_pack() {
        return quantity_pack;
    }

    public void setQuantity_pack(String quantity_pack) {
        this.quantity_pack = quantity_pack;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getChanged_quantity() {
        return changed_quantity;
    }

    public void setChanged_quantity(String changed_quantity) {
        this.changed_quantity = changed_quantity;
    }

    public String getUploaded_link() {
        return uploaded_link;
    }

    public void setUploaded_link(String uploaded_link) {
        this.uploaded_link = uploaded_link;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrigin_table() {
        return origin_table;
    }

    public void setOrigin_table(String origin_table) {
        this.origin_table = origin_table;
    }

    public String getQuantity_loose() {
        return quantity_loose;
    }

    public void setQuantity_loose(String quantity_loose) {
        this.quantity_loose = quantity_loose;
    }
}
