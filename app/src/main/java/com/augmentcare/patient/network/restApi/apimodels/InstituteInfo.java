package com.augmentcare.patient.network.restApi.apimodels;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class InstituteInfo implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("docter_id")
    @Expose
    private int docterId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("contact_number")
    @Expose
    private List<Object> contactNumber = new ArrayList<Object>();
    @SerializedName("emergency")
    @Expose
    private boolean emergency;
    @SerializedName("ambulance")
    @Expose
    private boolean ambulance;
    @SerializedName("wheel_chair")
    @Expose
    private boolean wheelChair;
    @SerializedName("no_of_beds")
    @Expose
    private int noOfBeds;
    @SerializedName("no_of_doctors")
    @Expose
    private int noOfDoctors;
    @SerializedName("logo_file_name")
    @Expose
    private String logoFileName;
    @SerializedName("logo_content_type")
    @Expose
    private String logoContentType;
    @SerializedName("logo_file_size")
    @Expose
    private String logoFileSize;
    @SerializedName("logo_updated_at")
    @Expose
    private String logoUpdatedAt;
    @SerializedName("cover_file_name")
    @Expose
    private String coverFileName;
    @SerializedName("cover_content_type")
    @Expose
    private String coverContentType;
    @SerializedName("cover_file_size")
    @Expose
    private String coverFileSize;
    @SerializedName("cover_updated_at")
    @Expose
    private String coverUpdatedAt;
    @SerializedName("services")
    @Expose
    private String services;
    @SerializedName("end_day")
    @Expose
    private String endDay;
    @SerializedName("start_day")
    @Expose
    private String startDay;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("logo_pic_file_name")
    @Expose
    private String logoPicFileName;
    @SerializedName("logo_pic_content_type")
    @Expose
    private String logoPicContentType;
    @SerializedName("logo_pic_file_size")
    @Expose
    private String logoPicFileSize;
    @SerializedName("logo_pic_updated_at")
    @Expose
    private String logoPicUpdatedAt;
    @SerializedName("cover_pic_file_name")
    @Expose
    private String coverPicFileName;
    @SerializedName("cover_pic_content_type")
    @Expose
    private String coverPicContentType;
    @SerializedName("cover_pic_file_size")
    @Expose
    private String coverPicFileSize;
    @SerializedName("cover_pic_updated_at")
    @Expose
    private String coverPicUpdatedAt;
    @SerializedName("is_unlimited")
    @Expose
    private boolean isUnlimited;
    @SerializedName("part_of_unlimited_policy")
    @Expose
    private int partOfUnlimitedPolicy;
    @SerializedName("invoice_prefix")
    @Expose
    private String invoicePrefix;
    @SerializedName("invoice_suffix")
    @Expose
    private int invoiceSuffix;
    @SerializedName("ac_approved")
    @Expose
    private boolean acApproved;
    @SerializedName("is_deleted")
    @Expose
    private boolean isDeleted;
    @SerializedName("manager_id")
    @Expose
    private int managerId;
    @SerializedName("serial_no")
    @Expose
    private int serialNo;
    @SerializedName("city_id")
    @Expose
    private int cityId;
    @SerializedName("area_id")
    @Expose
    private int areaId;
    @SerializedName("street_address")
    @Expose
    private String streetAddress;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    public final static Parcelable.Creator<InstituteInfo> CREATOR = new Creator<InstituteInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public InstituteInfo createFromParcel(Parcel in) {
            return new InstituteInfo(in);
        }

        public InstituteInfo[] newArray(int size) {
            return (new InstituteInfo[size]);
        }

    };

    protected InstituteInfo(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.docterId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.contactNumber, (java.lang.Object.class.getClassLoader()));
        this.emergency = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.ambulance = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.wheelChair = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.noOfBeds = ((int) in.readValue((int.class.getClassLoader())));
        this.noOfDoctors = ((int) in.readValue((int.class.getClassLoader())));
        this.logoFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.logoContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.logoFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.logoUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.coverFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.coverContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.coverFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.coverUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.services = ((String) in.readValue((String.class.getClassLoader())));
        this.endDay = ((String) in.readValue((String.class.getClassLoader())));
        this.startDay = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.logoPicFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.logoPicContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.logoPicFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.logoPicUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.coverPicFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.coverPicContentType = ((String) in.readValue((String.class.getClassLoader())));
        this.coverPicFileSize = ((String) in.readValue((String.class.getClassLoader())));
        this.coverPicUpdatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.isUnlimited = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.partOfUnlimitedPolicy = ((int) in.readValue((int.class.getClassLoader())));
        this.invoicePrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.invoiceSuffix = ((int) in.readValue((int.class.getClassLoader())));
        this.acApproved = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.isDeleted = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.managerId = ((int) in.readValue((int.class.getClassLoader())));
        this.serialNo = ((int) in.readValue((int.class.getClassLoader())));
        this.cityId = ((int) in.readValue((int.class.getClassLoader())));
        this.areaId = ((int) in.readValue((int.class.getClassLoader())));
        this.streetAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.postalCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public InstituteInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InstituteInfo withId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InstituteInfo withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstituteInfo withName(String name) {
        this.name = name;
        return this;
    }

    public int getDocterId() {
        return docterId;
    }

    public void setDocterId(int docterId) {
        this.docterId = docterId;
    }

    public InstituteInfo withDocterId(int docterId) {
        this.docterId = docterId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public InstituteInfo withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public InstituteInfo withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public List<Object> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<Object> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public InstituteInfo withContactNumber(List<Object> contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public InstituteInfo withEmergency(boolean emergency) {
        this.emergency = emergency;
        return this;
    }

    public boolean isAmbulance() {
        return ambulance;
    }

    public void setAmbulance(boolean ambulance) {
        this.ambulance = ambulance;
    }

    public InstituteInfo withAmbulance(boolean ambulance) {
        this.ambulance = ambulance;
        return this;
    }

    public boolean isWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(boolean wheelChair) {
        this.wheelChair = wheelChair;
    }

    public InstituteInfo withWheelChair(boolean wheelChair) {
        this.wheelChair = wheelChair;
        return this;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public InstituteInfo withNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
        return this;
    }

    public int getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(int noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
    }

    public InstituteInfo withNoOfDoctors(int noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
        return this;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public InstituteInfo withLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
        return this;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public InstituteInfo withLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public String getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
    }

    public InstituteInfo withLogoFileSize(String logoFileSize) {
        this.logoFileSize = logoFileSize;
        return this;
    }

    public String getLogoUpdatedAt() {
        return logoUpdatedAt;
    }

    public void setLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
    }

    public InstituteInfo withLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
        return this;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public InstituteInfo withCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
        return this;
    }

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    public InstituteInfo withCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
        return this;
    }

    public String getCoverFileSize() {
        return coverFileSize;
    }

    public void setCoverFileSize(String coverFileSize) {
        this.coverFileSize = coverFileSize;
    }

    public InstituteInfo withCoverFileSize(String coverFileSize) {
        this.coverFileSize = coverFileSize;
        return this;
    }

    public String getCoverUpdatedAt() {
        return coverUpdatedAt;
    }

    public void setCoverUpdatedAt(String coverUpdatedAt) {
        this.coverUpdatedAt = coverUpdatedAt;
    }

    public InstituteInfo withCoverUpdatedAt(String coverUpdatedAt) {
        this.coverUpdatedAt = coverUpdatedAt;
        return this;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public InstituteInfo withServices(String services) {
        this.services = services;
        return this;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public InstituteInfo withEndDay(String endDay) {
        this.endDay = endDay;
        return this;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public InstituteInfo withStartDay(String startDay) {
        this.startDay = startDay;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstituteInfo withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLogoPicFileName() {
        return logoPicFileName;
    }

    public void setLogoPicFileName(String logoPicFileName) {
        this.logoPicFileName = logoPicFileName;
    }

    public InstituteInfo withLogoPicFileName(String logoPicFileName) {
        this.logoPicFileName = logoPicFileName;
        return this;
    }

    public String getLogoPicContentType() {
        return logoPicContentType;
    }

    public void setLogoPicContentType(String logoPicContentType) {
        this.logoPicContentType = logoPicContentType;
    }

    public InstituteInfo withLogoPicContentType(String logoPicContentType) {
        this.logoPicContentType = logoPicContentType;
        return this;
    }

    public String getLogoPicFileSize() {
        return logoPicFileSize;
    }

    public void setLogoPicFileSize(String logoPicFileSize) {
        this.logoPicFileSize = logoPicFileSize;
    }

    public InstituteInfo withLogoPicFileSize(String logoPicFileSize) {
        this.logoPicFileSize = logoPicFileSize;
        return this;
    }

    public String getLogoPicUpdatedAt() {
        return logoPicUpdatedAt;
    }

    public void setLogoPicUpdatedAt(String logoPicUpdatedAt) {
        this.logoPicUpdatedAt = logoPicUpdatedAt;
    }

    public InstituteInfo withLogoPicUpdatedAt(String logoPicUpdatedAt) {
        this.logoPicUpdatedAt = logoPicUpdatedAt;
        return this;
    }

    public String getCoverPicFileName() {
        return coverPicFileName;
    }

    public void setCoverPicFileName(String coverPicFileName) {
        this.coverPicFileName = coverPicFileName;
    }

    public InstituteInfo withCoverPicFileName(String coverPicFileName) {
        this.coverPicFileName = coverPicFileName;
        return this;
    }

    public String getCoverPicContentType() {
        return coverPicContentType;
    }

    public void setCoverPicContentType(String coverPicContentType) {
        this.coverPicContentType = coverPicContentType;
    }

    public InstituteInfo withCoverPicContentType(String coverPicContentType) {
        this.coverPicContentType = coverPicContentType;
        return this;
    }

    public String getCoverPicFileSize() {
        return coverPicFileSize;
    }

    public void setCoverPicFileSize(String coverPicFileSize) {
        this.coverPicFileSize = coverPicFileSize;
    }

    public InstituteInfo withCoverPicFileSize(String coverPicFileSize) {
        this.coverPicFileSize = coverPicFileSize;
        return this;
    }

    public String getCoverPicUpdatedAt() {
        return coverPicUpdatedAt;
    }

    public void setCoverPicUpdatedAt(String coverPicUpdatedAt) {
        this.coverPicUpdatedAt = coverPicUpdatedAt;
    }

    public InstituteInfo withCoverPicUpdatedAt(String coverPicUpdatedAt) {
        this.coverPicUpdatedAt = coverPicUpdatedAt;
        return this;
    }

    public boolean isIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public InstituteInfo withIsUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
        return this;
    }

    public int getPartOfUnlimitedPolicy() {
        return partOfUnlimitedPolicy;
    }

    public void setPartOfUnlimitedPolicy(int partOfUnlimitedPolicy) {
        this.partOfUnlimitedPolicy = partOfUnlimitedPolicy;
    }

    public InstituteInfo withPartOfUnlimitedPolicy(int partOfUnlimitedPolicy) {
        this.partOfUnlimitedPolicy = partOfUnlimitedPolicy;
        return this;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public InstituteInfo withInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
        return this;
    }

    public int getInvoiceSuffix() {
        return invoiceSuffix;
    }

    public void setInvoiceSuffix(int invoiceSuffix) {
        this.invoiceSuffix = invoiceSuffix;
    }

    public InstituteInfo withInvoiceSuffix(int invoiceSuffix) {
        this.invoiceSuffix = invoiceSuffix;
        return this;
    }

    public boolean isAcApproved() {
        return acApproved;
    }

    public void setAcApproved(boolean acApproved) {
        this.acApproved = acApproved;
    }

    public InstituteInfo withAcApproved(boolean acApproved) {
        this.acApproved = acApproved;
        return this;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public InstituteInfo withIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public InstituteInfo withManagerId(int managerId) {
        this.managerId = managerId;
        return this;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public InstituteInfo withSerialNo(int serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public InstituteInfo withCityId(int cityId) {
        this.cityId = cityId;
        return this;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public InstituteInfo withAreaId(int areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public InstituteInfo withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public InstituteInfo withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public InstituteInfo withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public InstituteInfo withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("type", type).append("name", name).append("docterId", docterId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("contactNumber", contactNumber).append("emergency", emergency).append("ambulance", ambulance).append("wheelChair", wheelChair).append("noOfBeds", noOfBeds).append("noOfDoctors", noOfDoctors).append("logoFileName", logoFileName).append("logoContentType", logoContentType).append("logoFileSize", logoFileSize).append("logoUpdatedAt", logoUpdatedAt).append("coverFileName", coverFileName).append("coverContentType", coverContentType).append("coverFileSize", coverFileSize).append("coverUpdatedAt", coverUpdatedAt).append("services", services).append("endDay", endDay).append("startDay", startDay).append("description", description).append("logoPicFileName", logoPicFileName).append("logoPicContentType", logoPicContentType).append("logoPicFileSize", logoPicFileSize).append("logoPicUpdatedAt", logoPicUpdatedAt).append("coverPicFileName", coverPicFileName).append("coverPicContentType", coverPicContentType).append("coverPicFileSize", coverPicFileSize).append("coverPicUpdatedAt", coverPicUpdatedAt).append("isUnlimited", isUnlimited).append("partOfUnlimitedPolicy", partOfUnlimitedPolicy).append("invoicePrefix", invoicePrefix).append("invoiceSuffix", invoiceSuffix).append("acApproved", acApproved).append("isDeleted", isDeleted).append("managerId", managerId).append("serialNo", serialNo).append("cityId", cityId).append("areaId", areaId).append("streetAddress", streetAddress).append("latitude", latitude).append("longitude", longitude).append("postalCode", postalCode).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeValue(docterId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeList(contactNumber);
        dest.writeValue(emergency);
        dest.writeValue(ambulance);
        dest.writeValue(wheelChair);
        dest.writeValue(noOfBeds);
        dest.writeValue(noOfDoctors);
        dest.writeValue(logoFileName);
        dest.writeValue(logoContentType);
        dest.writeValue(logoFileSize);
        dest.writeValue(logoUpdatedAt);
        dest.writeValue(coverFileName);
        dest.writeValue(coverContentType);
        dest.writeValue(coverFileSize);
        dest.writeValue(coverUpdatedAt);
        dest.writeValue(services);
        dest.writeValue(endDay);
        dest.writeValue(startDay);
        dest.writeValue(description);
        dest.writeValue(logoPicFileName);
        dest.writeValue(logoPicContentType);
        dest.writeValue(logoPicFileSize);
        dest.writeValue(logoPicUpdatedAt);
        dest.writeValue(coverPicFileName);
        dest.writeValue(coverPicContentType);
        dest.writeValue(coverPicFileSize);
        dest.writeValue(coverPicUpdatedAt);
        dest.writeValue(isUnlimited);
        dest.writeValue(partOfUnlimitedPolicy);
        dest.writeValue(invoicePrefix);
        dest.writeValue(invoiceSuffix);
        dest.writeValue(acApproved);
        dest.writeValue(isDeleted);
        dest.writeValue(managerId);
        dest.writeValue(serialNo);
        dest.writeValue(cityId);
        dest.writeValue(areaId);
        dest.writeValue(streetAddress);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(postalCode);
    }

    public int describeContents() {
        return 0;
    }

}