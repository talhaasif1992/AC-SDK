
package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("prescription_id")
    @Expose
    private Object prescriptionId;
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
    private Object doctorId;
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
    private Object orderUid;
    @SerializedName("patient_number")
    @Expose
    private Object patientNumber;
    @SerializedName("case_id")
    @Expose
    private Object caseId;
    @SerializedName("ch_status")
    @Expose
    private Object chStatus;
    @SerializedName("request_slot_id")
    @Expose
    private Object requestSlotId;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("area")
    @Expose
    private Object area;
    @SerializedName("partner_id")
    @Expose
    private Object partnerId;
    @SerializedName("partner_order_id")
    @Expose
    private Object partnerOrderId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Object prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Object getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Object doctorId) {
        this.doctorId = doctorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPartnerBranchId() {
        return partnerBranchId;
    }

    public void setPartnerBranchId(Integer partnerBranchId) {
        this.partnerBranchId = partnerBranchId;
    }

    public Object getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(Object orderUid) {
        this.orderUid = orderUid;
    }

    public Object getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Object patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Object getCaseId() {
        return caseId;
    }

    public void setCaseId(Object caseId) {
        this.caseId = caseId;
    }

    public Object getChStatus() {
        return chStatus;
    }

    public void setChStatus(Object chStatus) {
        this.chStatus = chStatus;
    }

    public Object getRequestSlotId() {
        return requestSlotId;
    }

    public void setRequestSlotId(Object requestSlotId) {
        this.requestSlotId = requestSlotId;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public Object getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Object partnerId) {
        this.partnerId = partnerId;
    }

    public Object getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(Object partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Integer getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Integer deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

}
