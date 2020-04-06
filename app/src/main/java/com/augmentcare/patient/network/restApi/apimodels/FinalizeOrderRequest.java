package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FinalizeOrderRequest implements Parcelable {

    @SerializedName("pharmacy")
    @Expose
    private Pharmacy pharmacy;
    @SerializedName("medicines")
    @Expose
    private String medicines;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("total_amount")
    @Expose
    private Integer totalAmount;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("origin_table")
    @Expose
    private String originTable;
    @SerializedName("slot_id")
    @Expose
    private String slotId;
    public final static Parcelable.Creator<FinalizeOrderRequest> CREATOR = new Creator<FinalizeOrderRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FinalizeOrderRequest createFromParcel(Parcel in) {
            return new FinalizeOrderRequest(in);
        }

        public FinalizeOrderRequest[] newArray(int size) {
            return (new FinalizeOrderRequest[size]);
        }

    };

    protected FinalizeOrderRequest(Parcel in) {
        this.pharmacy = ((Pharmacy) in.readValue((Pharmacy.class.getClassLoader())));
        this.medicines = ((String) in.readValue((String.class.getClassLoader())));
        this.orderId = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderType = ((String) in.readValue((String.class.getClassLoader())));
        this.originTable = ((String) in.readValue((String.class.getClassLoader())));
        this.slotId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FinalizeOrderRequest() {
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public FinalizeOrderRequest withPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
        return this;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public FinalizeOrderRequest withMedicines(String medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public FinalizeOrderRequest withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public FinalizeOrderRequest withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public FinalizeOrderRequest withTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public FinalizeOrderRequest withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getOriginTable() {
        return originTable;
    }

    public void setOriginTable(String originTable) {
        this.originTable = originTable;
    }

    public FinalizeOrderRequest withOriginTable(String originTable) {
        this.originTable = originTable;
        return this;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public FinalizeOrderRequest withSlotId(String slotId) {
        this.slotId = slotId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pharmacy", pharmacy).append("medicines", medicines).append("orderId", orderId).append("paymentMethod", paymentMethod).append("totalAmount", totalAmount).append("orderType", orderType).append("originTable", originTable).append("slotId", slotId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pharmacy);
        dest.writeValue(medicines);
        dest.writeValue(orderId);
        dest.writeValue(paymentMethod);
        dest.writeValue(totalAmount);
        dest.writeValue(orderType);
        dest.writeValue(originTable);
        dest.writeValue(slotId);
    }

    public int describeContents() {
        return 0;
    }

}