package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("prescription_id")
    @Expose
    private Integer prescriptionId;
    @SerializedName("patient_id")
    @Expose
    private Integer patientId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("doctor_id")
    @Expose
    private Integer doctorId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("payment_id")
    @Expose
    private Integer paymentId;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("total_amount")
    @Expose
    private Double totalAmount;
    @SerializedName("partner_branch_id")
    @Expose
    private Integer partnerBranchId;
    @SerializedName("order_uid")
    @Expose
    private String orderUid;
    @SerializedName("patient_number")
    @Expose
    private String patientNumber;
    @SerializedName("case_id")
    @Expose
    private Integer caseId;
    @SerializedName("ch_status")
    @Expose
    private String chStatus;
    @SerializedName("request_slot_id")
    @Expose
    private Integer requestSlotId;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("partner_id")
    @Expose
    private Integer partnerId;
    @SerializedName("partner_order_id")
    @Expose
    private Integer partnerOrderId;
    @SerializedName("billing_address_id")
    @Expose
    private Integer billingAddressId;
    @SerializedName("shipping_address_id")
    @Expose
    private Integer shippingAddressId;
    @SerializedName("total_discount")
    @Expose
    private Integer totalDiscount;
    @SerializedName("order_source")
    @Expose
    private String orderSource;
    @SerializedName("delivery_charges")
    @Expose
    private Integer deliveryCharges;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("dependent_id")
    @Expose
    private Integer dependentId;
    public final static Parcelable.Creator<Order> CREATOR = new Creator<Order>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        public Order[] newArray(int size) {
            return (new Order[size]);
        }

    };

    protected Order(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.prescriptionId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.patientId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderType = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.partnerBranchId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderUid = ((String) in.readValue((String.class.getClassLoader())));
        this.patientNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.caseId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.chStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.requestSlotId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.area = ((String) in.readValue((String.class.getClassLoader())));
        this.partnerId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.partnerOrderId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.billingAddressId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.shippingAddressId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalDiscount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.orderSource = ((String) in.readValue((String.class.getClassLoader())));
        this.deliveryCharges = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.deliveryType = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Order withPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
        return this;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Order withPatientId(Integer patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Order withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Order withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Order withDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Order withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Order withPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Order withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order withTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Integer getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(Integer partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public Order withPartnerBranchId(Integer partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
        return this;
    }

    public String getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    public Order withOrderUid(String orderUid) {
        this.orderUid = orderUid;
        return this;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Order withPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
        return this;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Order withCaseId(Integer caseId) {
        this.caseId = caseId;
        return this;
    }

    public String getChStatus() {
        return chStatus;
    }

    public void setChStatus(String chStatus) {
        this.chStatus = chStatus;
    }

    public Order withChStatus(String chStatus) {
        this.chStatus = chStatus;
        return this;
    }

    public Integer getRequestSlotId() {
        return requestSlotId;
    }

    public void setRequestSlotId(Integer requestSlotId) {
        this.requestSlotId = requestSlotId;
    }

    public Order withRequestSlotId(Integer requestSlotId) {
        this.requestSlotId = requestSlotId;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Order withCity(String city) {
        this.city = city;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Order withArea(String area) {
        this.area = area;
        return this;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Order withPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
        return this;
    }

    public Integer getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(Integer partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    public Order withPartnerOrderId(Integer partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
        return this;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Order withBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
        return this;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Order withShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
        return this;
    }

    public Integer getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Order withTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
        return this;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Order withOrderSource(String orderSource) {
        this.orderSource = orderSource;
        return this;
    }

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Order withDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
        return this;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Order withDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
    }

    public Integer getDependentId() {
        return dependentId;
    }

    public void setDependentId(Integer dependentId) {
        this.dependentId = dependentId;
    }

    public Order withDependentId(Integer dependentId) {
        this.dependentId = dependentId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("prescriptionId", prescriptionId).append("patientId", patientId).append("address", address).append("createdAt", createdAt).append("updatedAt", updatedAt).append("doctorId", doctorId).append("status", status).append("paymentMethod", paymentMethod).append("paymentId", paymentId).append("orderType", orderType).append("totalAmount", totalAmount).append("partnerBranchId", partnerBranchId).append("orderUid", orderUid).append("patientNumber", patientNumber).append("caseId", caseId).append("chStatus", chStatus).append("requestSlotId", requestSlotId).append("city", city).append("area", area).append("partnerId", partnerId).append("partnerOrderId", partnerOrderId).append("billingAddressId", billingAddressId).append("shippingAddressId", shippingAddressId).append("totalDiscount", totalDiscount).append("orderSource", orderSource).append("deliveryCharges", deliveryCharges).append("deliveryType", deliveryType).append("dependentId", dependentId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(prescriptionId);
        dest.writeValue(patientId);
        dest.writeValue(address);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(doctorId);
        dest.writeValue(status);
        dest.writeValue(paymentMethod);
        dest.writeValue(paymentId);
        dest.writeValue(orderType);
        dest.writeValue(totalAmount);
        dest.writeValue(partnerBranchId);
        dest.writeValue(orderUid);
        dest.writeValue(patientNumber);
        dest.writeValue(caseId);
        dest.writeValue(chStatus);
        dest.writeValue(requestSlotId);
        dest.writeValue(city);
        dest.writeValue(area);
        dest.writeValue(partnerId);
        dest.writeValue(partnerOrderId);
        dest.writeValue(billingAddressId);
        dest.writeValue(shippingAddressId);
        dest.writeValue(totalDiscount);
        dest.writeValue(orderSource);
        dest.writeValue(deliveryCharges);
        dest.writeValue(deliveryType);
        dest.writeValue(dependentId);
    }

    public int describeContents() {
        return 0;
    }

}