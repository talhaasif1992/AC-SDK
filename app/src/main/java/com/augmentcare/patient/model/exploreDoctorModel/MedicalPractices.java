
package com.augmentcare.patient.model.exploreDoctorModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicalPractices {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("docter_id")
    @Expose
    private Object docterId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("contact_number")
    @Expose
    private List<Object> contactNumber = null;
    @SerializedName("emergency")
    @Expose
    private Boolean emergency;
    @SerializedName("ambulance")
    @Expose
    private Boolean ambulance;
    @SerializedName("wheel_chair")
    @Expose
    private Boolean wheelChair;
    @SerializedName("no_of_beds")
    @Expose
    private Integer noOfBeds;
    @SerializedName("no_of_doctors")
    @Expose
    private Integer noOfDoctors;
    @SerializedName("logo_file_name")
    @Expose
    private String logoFileName;
    @SerializedName("logo_content_type")
    @Expose
    private String logoContentType;
    @SerializedName("logo_file_size")
    @Expose
    private Integer logoFileSize;
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
    private Integer coverFileSize;
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
    private Object logoPicFileName;
    @SerializedName("logo_pic_content_type")
    @Expose
    private Object logoPicContentType;
    @SerializedName("logo_pic_file_size")
    @Expose
    private Object logoPicFileSize;
    @SerializedName("logo_pic_updated_at")
    @Expose
    private Object logoPicUpdatedAt;
    @SerializedName("cover_pic_file_name")
    @Expose
    private Object coverPicFileName;
    @SerializedName("cover_pic_content_type")
    @Expose
    private Object coverPicContentType;
    @SerializedName("cover_pic_file_size")
    @Expose
    private Object coverPicFileSize;
    @SerializedName("cover_pic_updated_at")
    @Expose
    private Object coverPicUpdatedAt;
    @SerializedName("is_unlimited")
    @Expose
    private Boolean isUnlimited;
    @SerializedName("part_of_unlimited_policy")
    @Expose
    private Integer partOfUnlimitedPolicy;
    @SerializedName("invoice_prefix")
    @Expose
    private String invoicePrefix;
    @SerializedName("invoice_suffix")
    @Expose
    private Integer invoiceSuffix;
    @SerializedName("ac_approved")
    @Expose
    private Boolean acApproved;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("manager_id")
    @Expose
    private Object managerId;
    @SerializedName("serial_no")
    @Expose
    private Integer serialNo;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("area_id")
    @Expose
    private Object areaId;
    @SerializedName("street_address")
    @Expose
    private Object streetAddress;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("postal_code")
    @Expose
    private Object postalCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDocterId() {
        return docterId;
    }

    public void setDocterId(Object docterId) {
        this.docterId = docterId;
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

    public List<Object> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<Object> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Boolean getEmergency() {
        return emergency;
    }

    public void setEmergency(Boolean emergency) {
        this.emergency = emergency;
    }

    public Boolean getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Boolean ambulance) {
        this.ambulance = ambulance;
    }

    public Boolean getWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(Boolean wheelChair) {
        this.wheelChair = wheelChair;
    }

    public Integer getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(Integer noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public Integer getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(Integer noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Integer getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(Integer logoFileSize) {
        this.logoFileSize = logoFileSize;
    }

    public String getLogoUpdatedAt() {
        return logoUpdatedAt;
    }

    public void setLogoUpdatedAt(String logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    public Integer getCoverFileSize() {
        return coverFileSize;
    }

    public void setCoverFileSize(Integer coverFileSize) {
        this.coverFileSize = coverFileSize;
    }

    public String getCoverUpdatedAt() {
        return coverUpdatedAt;
    }

    public void setCoverUpdatedAt(String coverUpdatedAt) {
        this.coverUpdatedAt = coverUpdatedAt;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getLogoPicFileName() {
        return logoPicFileName;
    }

    public void setLogoPicFileName(Object logoPicFileName) {
        this.logoPicFileName = logoPicFileName;
    }

    public Object getLogoPicContentType() {
        return logoPicContentType;
    }

    public void setLogoPicContentType(Object logoPicContentType) {
        this.logoPicContentType = logoPicContentType;
    }

    public Object getLogoPicFileSize() {
        return logoPicFileSize;
    }

    public void setLogoPicFileSize(Object logoPicFileSize) {
        this.logoPicFileSize = logoPicFileSize;
    }

    public Object getLogoPicUpdatedAt() {
        return logoPicUpdatedAt;
    }

    public void setLogoPicUpdatedAt(Object logoPicUpdatedAt) {
        this.logoPicUpdatedAt = logoPicUpdatedAt;
    }

    public Object getCoverPicFileName() {
        return coverPicFileName;
    }

    public void setCoverPicFileName(Object coverPicFileName) {
        this.coverPicFileName = coverPicFileName;
    }

    public Object getCoverPicContentType() {
        return coverPicContentType;
    }

    public void setCoverPicContentType(Object coverPicContentType) {
        this.coverPicContentType = coverPicContentType;
    }

    public Object getCoverPicFileSize() {
        return coverPicFileSize;
    }

    public void setCoverPicFileSize(Object coverPicFileSize) {
        this.coverPicFileSize = coverPicFileSize;
    }

    public Object getCoverPicUpdatedAt() {
        return coverPicUpdatedAt;
    }

    public void setCoverPicUpdatedAt(Object coverPicUpdatedAt) {
        this.coverPicUpdatedAt = coverPicUpdatedAt;
    }

    public Boolean getIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public Integer getPartOfUnlimitedPolicy() {
        return partOfUnlimitedPolicy;
    }

    public void setPartOfUnlimitedPolicy(Integer partOfUnlimitedPolicy) {
        this.partOfUnlimitedPolicy = partOfUnlimitedPolicy;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public Integer getInvoiceSuffix() {
        return invoiceSuffix;
    }

    public void setInvoiceSuffix(Integer invoiceSuffix) {
        this.invoiceSuffix = invoiceSuffix;
    }

    public Boolean getAcApproved() {
        return acApproved;
    }

    public void setAcApproved(Boolean acApproved) {
        this.acApproved = acApproved;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Object getManagerId() {
        return managerId;
    }

    public void setManagerId(Object managerId) {
        this.managerId = managerId;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public Object getAreaId() {
        return areaId;
    }

    public void setAreaId(Object areaId) {
        this.areaId = areaId;
    }

    public Object getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(Object streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

}
