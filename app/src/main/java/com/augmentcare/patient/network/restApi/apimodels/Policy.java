package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Policy implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("op_allowance")
    @Expose
    private int opAllowance;
    @SerializedName("created_by")
    @Expose
    private int createdBy;
    @SerializedName("organization_id")
    @Expose
    private int organizationId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_unlimited")
    @Expose
    private boolean isUnlimited;
    @SerializedName("is_lab_allowed")
    @Expose
    private boolean isLabAllowed;
    @SerializedName("is_pharmacy_allowed")
    @Expose
    private boolean isPharmacyAllowed;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("remind_expiry")
    @Expose
    private boolean remindExpiry;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("ip_allowance")
    @Expose
    private int ipAllowance;
    @SerializedName("mt_allowance")
    @Expose
    private int mtAllowance;
    public final static Parcelable.Creator<Policy> CREATOR = new Creator<Policy>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Policy createFromParcel(Parcel in) {
            return new Policy(in);
        }

        public Policy[] newArray(int size) {
            return (new Policy[size]);
        }

    };

    protected Policy(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.opAllowance = ((int) in.readValue((int.class.getClassLoader())));
        this.createdBy = ((int) in.readValue((int.class.getClassLoader())));
        this.organizationId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.isUnlimited = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isLabAllowed = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isPharmacyAllowed = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.remindExpiry = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.ipAllowance = ((int) in.readValue((int.class.getClassLoader())));
        this.mtAllowance = ((int) in.readValue((int.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Policy() {
    }

    /**
     * @param ipAllowance
     * @param code
     * @param endDate
     * @param isLabAllowed
     * @param organizationId
     * @param createdAt
     * @param isUnlimited
     * @param remindExpiry
     * @param createdBy
     * @param isPharmacyAllowed
     * @param name
     * @param opAllowance
     * @param id
     * @param mtAllowance
     * @param startDate
     * @param updatedAt
     */
    public Policy(int id, String name, int opAllowance, int createdBy, int organizationId, String createdAt, String updatedAt, boolean isUnlimited, boolean isLabAllowed, boolean isPharmacyAllowed, String startDate, String endDate, boolean remindExpiry, String code, int ipAllowance, int mtAllowance) {
        super();
        this.id = id;
        this.name = name;
        this.opAllowance = opAllowance;
        this.createdBy = createdBy;
        this.organizationId = organizationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isUnlimited = isUnlimited;
        this.isLabAllowed = isLabAllowed;
        this.isPharmacyAllowed = isPharmacyAllowed;
        this.startDate = startDate;
        this.endDate = endDate;
        this.remindExpiry = remindExpiry;
        this.code = code;
        this.ipAllowance = ipAllowance;
        this.mtAllowance = mtAllowance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Policy withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Policy withName(String name) {
        this.name = name;
        return this;
    }

    public int getOpAllowance() {
        return opAllowance;
    }

    public void setOpAllowance(int opAllowance) {
        this.opAllowance = opAllowance;
    }

    public Policy withOpAllowance(int opAllowance) {
        this.opAllowance = opAllowance;
        return this;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Policy withCreatedBy(int createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public Policy withOrganizationId(int organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Policy withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Policy withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public boolean isIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public Policy withIsUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
        return this;
    }

    public boolean isIsLabAllowed() {
        return isLabAllowed;
    }

    public void setIsLabAllowed(boolean isLabAllowed) {
        this.isLabAllowed = isLabAllowed;
    }

    public Policy withIsLabAllowed(boolean isLabAllowed) {
        this.isLabAllowed = isLabAllowed;
        return this;
    }

    public boolean isIsPharmacyAllowed() {
        return isPharmacyAllowed;
    }

    public void setIsPharmacyAllowed(boolean isPharmacyAllowed) {
        this.isPharmacyAllowed = isPharmacyAllowed;
    }

    public Policy withIsPharmacyAllowed(boolean isPharmacyAllowed) {
        this.isPharmacyAllowed = isPharmacyAllowed;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Policy withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Policy withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public boolean isRemindExpiry() {
        return remindExpiry;
    }

    public void setRemindExpiry(boolean remindExpiry) {
        this.remindExpiry = remindExpiry;
    }

    public Policy withRemindExpiry(boolean remindExpiry) {
        this.remindExpiry = remindExpiry;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Policy withCode(String code) {
        this.code = code;
        return this;
    }

    public int getIpAllowance() {
        return ipAllowance;
    }

    public void setIpAllowance(int ipAllowance) {
        this.ipAllowance = ipAllowance;
    }

    public Policy withIpAllowance(int ipAllowance) {
        this.ipAllowance = ipAllowance;
        return this;
    }

    public int getMtAllowance() {
        return mtAllowance;
    }

    public void setMtAllowance(int mtAllowance) {
        this.mtAllowance = mtAllowance;
    }

    public Policy withMtAllowance(int mtAllowance) {
        this.mtAllowance = mtAllowance;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("opAllowance", opAllowance).append("createdBy", createdBy).append("organizationId", organizationId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("isUnlimited", isUnlimited).append("isLabAllowed", isLabAllowed).append("isPharmacyAllowed", isPharmacyAllowed).append("startDate", startDate).append("endDate", endDate).append("remindExpiry", remindExpiry).append("code", code).append("ipAllowance", ipAllowance).append("mtAllowance", mtAllowance).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(opAllowance);
        dest.writeValue(createdBy);
        dest.writeValue(organizationId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(isUnlimited);
        dest.writeValue(isLabAllowed);
        dest.writeValue(isPharmacyAllowed);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(remindExpiry);
        dest.writeValue(code);
        dest.writeValue(ipAllowance);
        dest.writeValue(mtAllowance);
    }

    public int describeContents() {
        return 0;
    }

}