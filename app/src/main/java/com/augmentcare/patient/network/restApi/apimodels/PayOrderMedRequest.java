package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class PayOrderMedRequest implements Parcelable {

    @SerializedName("medicines")
    @Expose
    private List<Medicine> medicines = new ArrayList<Medicine>();
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("payment_id")
    @Expose
    private Integer paymentId;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("pharmacy")
    @Expose
    private Pharmacy pharmacy;
    @SerializedName("stripeToken")
    @Expose
    private String stripeToken;
    @SerializedName("stripeEmail")
    @Expose
    private String stripeEmail;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    public final static Parcelable.Creator<PayOrderMedRequest> CREATOR = new Creator<PayOrderMedRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PayOrderMedRequest createFromParcel(Parcel in) {
            return new PayOrderMedRequest(in);
        }

        public PayOrderMedRequest[] newArray(int size) {
            return (new PayOrderMedRequest[size]);
        }

    };

    protected PayOrderMedRequest(Parcel in) {
        in.readList(this.medicines, (com.augmentcare.patient.network.restApi.apimodels.Medicine.class.getClassLoader()));
        this.orderId = ((String) in.readValue((String.class.getClassLoader())));
        this.orderType = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.pharmacy = ((Pharmacy) in.readValue((Pharmacy.class.getClassLoader())));
        this.stripeToken = ((String) in.readValue((String.class.getClassLoader())));
        this.stripeEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userRoleId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public PayOrderMedRequest() {
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public PayOrderMedRequest withMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PayOrderMedRequest withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public PayOrderMedRequest withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PayOrderMedRequest withPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PayOrderMedRequest withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public PayOrderMedRequest withPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
        return this;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }

    public PayOrderMedRequest withStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
        return this;
    }

    public String getStripeEmail() {
        return stripeEmail;
    }

    public void setStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
    }

    public PayOrderMedRequest withStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PayOrderMedRequest withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public PayOrderMedRequest withUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("medicines", medicines).append("orderId", orderId).append("orderType", orderType).append("paymentId", paymentId).append("paymentMethod", paymentMethod).append("pharmacy", pharmacy).append("stripeToken", stripeToken).append("stripeEmail", stripeEmail).append("amount", amount).append("userRoleId", userRoleId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(medicines);
        dest.writeValue(orderId);
        dest.writeValue(orderType);
        dest.writeValue(paymentId);
        dest.writeValue(paymentMethod);
        dest.writeValue(pharmacy);
        dest.writeValue(stripeToken);
        dest.writeValue(stripeEmail);
        dest.writeValue(amount);
        dest.writeValue(userRoleId);
    }

    public int describeContents() {
        return 0;
    }

}