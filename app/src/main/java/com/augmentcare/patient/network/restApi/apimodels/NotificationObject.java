package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NotificationObject implements Parcelable {

    @SerializedName("slot_id")
    @Expose
    private int slotId;
    @SerializedName("model_type")
    @Expose
    private String modelType;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("slot_type")
    @Expose
    private Boolean slotType;
    @SerializedName("location_name")
    @Expose
    private String locationName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("claim_uid")
    @Expose
    private String claimUid;
    @SerializedName("claim_type")
    @Expose
    private String claimType;
    @SerializedName("employee_id")
    @Expose
    private Long employeeId;
    @SerializedName("amount")
    @Expose
    private Long amount;
    @SerializedName("organization_id")
    @Expose
    private Long organizationId;
    @SerializedName("transaction_for")
    @Expose
    private String transactionFor;
    public final static Parcelable.Creator<NotificationObject> CREATOR = new Creator<NotificationObject>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotificationObject createFromParcel(Parcel in) {
            return new NotificationObject(in);
        }

        public NotificationObject[] newArray(int size) {
            return (new NotificationObject[size]);
        }

    };

    protected NotificationObject(Parcel in) {
        this.slotId = ((int) in.readValue((int.class.getClassLoader())));
        this.modelType = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.slotType = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationName = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.claimUid = ((String) in.readValue((String.class.getClassLoader())));
        this.claimType = ((String) in.readValue((String.class.getClassLoader())));
        this.employeeId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.amount = ((Long) in.readValue((Long.class.getClassLoader())));
        this.organizationId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.transactionFor = ((String) in.readValue((String.class.getClassLoader())));
    }

    public NotificationObject() {
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public NotificationObject withSlotId(int slotId) {
        this.slotId = slotId;
        return this;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public NotificationObject withModelType(String modelType) {
        this.modelType = modelType;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public NotificationObject withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NotificationObject withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public NotificationObject withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public NotificationObject withDay(String day) {
        this.day = day;
        return this;
    }

    public Boolean getSlotType() {
        return slotType;
    }

    public void setSlotType(Boolean slotType) {
        this.slotType = slotType;
    }

    public NotificationObject withSlotType(Boolean slotType) {
        this.slotType = slotType;
        return this;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public NotificationObject withLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NotificationObject withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NotificationObject withType(String type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationObject withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getClaimUid() {
        return claimUid;
    }

    public void setClaimUid(String claimUid) {
        this.claimUid = claimUid;
    }

    public NotificationObject withClaimUid(String claimUid) {
        this.claimUid = claimUid;
        return this;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public NotificationObject withClaimType(String claimType) {
        this.claimType = claimType;
        return this;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public NotificationObject withEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public NotificationObject withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public NotificationObject withOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }

    public NotificationObject withTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("slotId", slotId).append("modelType", modelType).append("firstName", firstName).append("lastName", lastName).append("startTime", startTime).append("day", day).append("slotType", slotType).append("locationName", locationName).append("name", name).append("type", type).append("message", message).append("claimUid", claimUid).append("claimType", claimType).append("employeeId", employeeId).append("amount", amount).append("organizationId", organizationId).append("transactionFor", transactionFor).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slotId);
        dest.writeValue(modelType);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(startTime);
        dest.writeValue(day);
        dest.writeValue(slotType);
        dest.writeValue(locationName);
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(message);
        dest.writeValue(claimUid);
        dest.writeValue(claimType);
        dest.writeValue(employeeId);
        dest.writeValue(amount);
        dest.writeValue(organizationId);
        dest.writeValue(transactionFor);
    }

    public int describeContents() {
        return 0;
    }

}