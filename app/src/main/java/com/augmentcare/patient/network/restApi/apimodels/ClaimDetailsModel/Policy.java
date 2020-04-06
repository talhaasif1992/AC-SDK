package com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Policy implements Parcelable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("op_allowance")
    @Expose
    private Integer opAllowance;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("organization_id")
    @Expose
    private Integer organizationId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_unlimited")
    @Expose
    private Boolean isUnlimited;
    @SerializedName("is_lab_allowed")
    @Expose
    private Boolean isLabAllowed;
    @SerializedName("is_pharmacy_allowed")
    @Expose
    private Boolean isPharmacyAllowed;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("remind_expiry")
    @Expose
    private Boolean remindExpiry;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("ip_allowance")
    @Expose
    private Integer ipAllowance;
    @SerializedName("mt_allowance")
    @Expose
    private Integer mtAllowance;
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

    }
            ;

    protected Policy(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.opAllowance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdBy = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.organizationId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.isUnlimited = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isLabAllowed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isPharmacyAllowed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.remindExpiry = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.ipAllowance = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mtAllowance = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Policy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Policy withId(Integer id) {
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

    public Integer getOpAllowance() {
        return opAllowance;
    }

    public void setOpAllowance(Integer opAllowance) {
        this.opAllowance = opAllowance;
    }

    public Policy withOpAllowance(Integer opAllowance) {
        this.opAllowance = opAllowance;
        return this;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Policy withCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Policy withOrganizationId(Integer organizationId) {
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

    public Boolean getIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public Policy withIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
        return this;
    }

    public Boolean getIsLabAllowed() {
        return isLabAllowed;
    }

    public void setIsLabAllowed(Boolean isLabAllowed) {
        this.isLabAllowed = isLabAllowed;
    }

    public Policy withIsLabAllowed(Boolean isLabAllowed) {
        this.isLabAllowed = isLabAllowed;
        return this;
    }

    public Boolean getIsPharmacyAllowed() {
        return isPharmacyAllowed;
    }

    public void setIsPharmacyAllowed(Boolean isPharmacyAllowed) {
        this.isPharmacyAllowed = isPharmacyAllowed;
    }

    public Policy withIsPharmacyAllowed(Boolean isPharmacyAllowed) {
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

    public Boolean getRemindExpiry() {
        return remindExpiry;
    }

    public void setRemindExpiry(Boolean remindExpiry) {
        this.remindExpiry = remindExpiry;
    }

    public Policy withRemindExpiry(Boolean remindExpiry) {
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

    public Integer getIpAllowance() {
        return ipAllowance;
    }

    public void setIpAllowance(Integer ipAllowance) {
        this.ipAllowance = ipAllowance;
    }

    public Policy withIpAllowance(Integer ipAllowance) {
        this.ipAllowance = ipAllowance;
        return this;
    }

    public Integer getMtAllowance() {
        return mtAllowance;
    }

    public void setMtAllowance(Integer mtAllowance) {
        this.mtAllowance = mtAllowance;
    }

    public Policy withMtAllowance(Integer mtAllowance) {
        this.mtAllowance = mtAllowance;
        return this;
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