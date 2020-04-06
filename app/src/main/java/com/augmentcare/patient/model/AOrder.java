package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 27/03/2018.
 */

public class AOrder implements Parcelable{

    private String total_amount;

    private String partner_id;

    private String order_uid;

    private String status;

    private String partner_branch_id;

    private String doctor_id;

    private String city;

    private String id;

    private String area;

    private String updated_at;

    private String address;

    private String request_slot_id;

    private String  case_id;

    private String created_at;

    private String  partner_order_id;

    private String patient_number;

    private String prescription_id;

    private String patient_id;

    private String payment_id;

    private String payment_method;

    private String order_type;

    protected AOrder(Parcel in) {
        total_amount = in.readString();
        partner_id = in.readString();
        order_uid = in.readString();
        status = in.readString();
        partner_branch_id = in.readString();
        doctor_id = in.readString();
        city = in.readString();
        id = in.readString();
        area = in.readString();
        updated_at = in.readString();
        address = in.readString();
        request_slot_id = in.readString();
        case_id = in.readString();
        created_at = in.readString();
        partner_order_id = in.readString();
        patient_number = in.readString();
        prescription_id = in.readString();
        patient_id = in.readString();
        payment_id = in.readString();
        payment_method = in.readString();
        order_type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(total_amount);
        dest.writeString(partner_id);
        dest.writeString(order_uid);
        dest.writeString(status);
        dest.writeString(partner_branch_id);
        dest.writeString(doctor_id);
        dest.writeString(city);
        dest.writeString(id);
        dest.writeString(area);
        dest.writeString(updated_at);
        dest.writeString(address);
        dest.writeString(request_slot_id);
        dest.writeString(case_id);
        dest.writeString(created_at);
        dest.writeString(partner_order_id);
        dest.writeString(patient_number);
        dest.writeString(prescription_id);
        dest.writeString(patient_id);
        dest.writeString(payment_id);
        dest.writeString(payment_method);
        dest.writeString(order_type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AOrder> CREATOR = new Creator<AOrder>() {
        @Override
        public AOrder createFromParcel(Parcel in) {
            return new AOrder(in);
        }

        @Override
        public AOrder[] newArray(int size) {
            return new AOrder[size];
        }
    };

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getOrder_uid() {
        return order_uid;
    }

    public void setOrder_uid(String order_uid) {
        this.order_uid = order_uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPartner_branch_id() {
        return partner_branch_id;
    }

    public void setPartner_branch_id(String partner_branch_id) {
        this.partner_branch_id = partner_branch_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequest_slot_id() {
        return request_slot_id;
    }

    public void setRequest_slot_id(String request_slot_id) {
        this.request_slot_id = request_slot_id;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }

    public void setPartner_order_id(String partner_order_id) {
        this.partner_order_id = partner_order_id;
    }

    public String getPatient_number() {
        return patient_number;
    }

    public void setPatient_number(String patient_number) {
        this.patient_number = patient_number;
    }

    public String getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(String prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }
}
