package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class MedicalPractice implements Parcelable {

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
    private List<String> contactNumber = null;
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
//    @SerializedName("settings")
//    @Expose
//    private Settings settings;
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
    public final static Parcelable.Creator<MedicalPractice> CREATOR = new Creator<MedicalPractice>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MedicalPractice createFromParcel(Parcel in) {
            return new MedicalPractice(in);
        }

        public MedicalPractice[] newArray(int size) {
            return (new MedicalPractice[size]);
        }

    };

    protected MedicalPractice(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.docterId = ((int) in.readValue((int.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.contactNumber, (java.lang.String.class.getClassLoader()));
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
//        this.settings = ((Settings) in.readValue((Settings.class.getClassLoader())));
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

    /**
     * No args constructor for use in serialization
     */
    public MedicalPractice() {
    }

    /**
     * @param latitude
     * @param postalCode
     * @param emergency
     * @param description
     * @param logoPicContentType
     * @param noOfBeds
     * @param cityId
     * @param type
     * @param invoiceSuffix
     * @param logoUpdatedAt
     * @param partOfUnlimitedPolicy
     * @param createdAt
     * @param isUnlimited
     * @param isDeleted
     * @param invoicePrefix
     * @param logoPicFileSize
     * @param coverContentType
     * @param endDay
     * @param contactNumber
     * @param logoContentType
     * @param id
     * @param logoPicUpdatedAt
     * @param coverPicUpdatedAt
     * @param updatedAt
     * @param longitude
     * @param logoPicFileName
     * @param settings
     * @param wheelChair
     * @param logoFileName
     * @param coverFileSize
     * @param startDay
     * @param coverPicContentType
     * @param ambulance
     * @param services
     * @param managerId
     * @param docterId
     * @param serialNo
     * @param coverFileName
     * @param noOfDoctors
     * @param acApproved
     * @param areaId
     * @param coverPicFileSize
     * @param streetAddress
     * @param name
     * @param coverPicFileName
     * @param logoFileSize
     * @param coverUpdatedAt
     */
    public MedicalPractice(int id, String type, String name, int docterId, String createdAt, String updatedAt, List<String> contactNumber, boolean emergency, boolean ambulance, boolean wheelChair, int noOfBeds, int noOfDoctors, String logoFileName, String logoContentType, String logoFileSize, String logoUpdatedAt, String coverFileName, String coverContentType, String coverFileSize, String coverUpdatedAt, String services, String endDay, String startDay, String description, String logoPicFileName, String logoPicContentType, String logoPicFileSize, String logoPicUpdatedAt, String coverPicFileName, String coverPicContentType, String coverPicFileSize, String coverPicUpdatedAt, boolean isUnlimited, int partOfUnlimitedPolicy, String invoicePrefix, int invoiceSuffix, Settings settings, boolean acApproved, boolean isDeleted, int managerId, int serialNo, int cityId, int areaId, String streetAddress, String latitude, String longitude, String postalCode) {
        super();
        this.id = id;
        this.type = type;
        this.name = name;
        this.docterId = docterId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.contactNumber = contactNumber;
        this.emergency = emergency;
        this.ambulance = ambulance;
        this.wheelChair = wheelChair;
        this.noOfBeds = noOfBeds;
        this.noOfDoctors = noOfDoctors;
        this.logoFileName = logoFileName;
        this.logoContentType = logoContentType;
        this.logoFileSize = logoFileSize;
        this.logoUpdatedAt = logoUpdatedAt;
        this.coverFileName = coverFileName;
        this.coverContentType = coverContentType;
        this.coverFileSize = coverFileSize;
        this.coverUpdatedAt = coverUpdatedAt;
        this.services = services;
        this.endDay = endDay;
        this.startDay = startDay;
        this.description = description;
        this.logoPicFileName = logoPicFileName;
        this.logoPicContentType = logoPicContentType;
        this.logoPicFileSize = logoPicFileSize;
        this.logoPicUpdatedAt = logoPicUpdatedAt;
        this.coverPicFileName = coverPicFileName;
        this.coverPicContentType = coverPicContentType;
        this.coverPicFileSize = coverPicFileSize;
        this.coverPicUpdatedAt = coverPicUpdatedAt;
        this.isUnlimited = isUnlimited;
        this.partOfUnlimitedPolicy = partOfUnlimitedPolicy;
        this.invoicePrefix = invoicePrefix;
        this.invoiceSuffix = invoiceSuffix;
//        this.settings = settings;
        this.acApproved = acApproved;
        this.isDeleted = isDeleted;
        this.managerId = managerId;
        this.serialNo = serialNo;
        this.cityId = cityId;
        this.areaId = areaId;
        this.streetAddress = streetAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDocterId() {
        return docterId;
    }

    public void setDocterId(int docterId) {
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

    public List<String> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<String> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public boolean isAmbulance() {
        return ambulance;
    }

    public void setAmbulance(boolean ambulance) {
        this.ambulance = ambulance;
    }

    public boolean isWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(boolean wheelChair) {
        this.wheelChair = wheelChair;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public int getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(int noOfDoctors) {
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

    public String getLogoFileSize() {
        return logoFileSize;
    }

    public void setLogoFileSize(String logoFileSize) {
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

    public String getCoverFileSize() {
        return coverFileSize;
    }

    public void setCoverFileSize(String coverFileSize) {
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

    public String getLogoPicFileName() {
        return logoPicFileName;
    }

    public void setLogoPicFileName(String logoPicFileName) {
        this.logoPicFileName = logoPicFileName;
    }

    public String getLogoPicContentType() {
        return logoPicContentType;
    }

    public void setLogoPicContentType(String logoPicContentType) {
        this.logoPicContentType = logoPicContentType;
    }

    public String getLogoPicFileSize() {
        return logoPicFileSize;
    }

    public void setLogoPicFileSize(String logoPicFileSize) {
        this.logoPicFileSize = logoPicFileSize;
    }

    public String getLogoPicUpdatedAt() {
        return logoPicUpdatedAt;
    }

    public void setLogoPicUpdatedAt(String logoPicUpdatedAt) {
        this.logoPicUpdatedAt = logoPicUpdatedAt;
    }

    public String getCoverPicFileName() {
        return coverPicFileName;
    }

    public void setCoverPicFileName(String coverPicFileName) {
        this.coverPicFileName = coverPicFileName;
    }

    public String getCoverPicContentType() {
        return coverPicContentType;
    }

    public void setCoverPicContentType(String coverPicContentType) {
        this.coverPicContentType = coverPicContentType;
    }

    public String getCoverPicFileSize() {
        return coverPicFileSize;
    }

    public void setCoverPicFileSize(String coverPicFileSize) {
        this.coverPicFileSize = coverPicFileSize;
    }

    public String getCoverPicUpdatedAt() {
        return coverPicUpdatedAt;
    }

    public void setCoverPicUpdatedAt(String coverPicUpdatedAt) {
        this.coverPicUpdatedAt = coverPicUpdatedAt;
    }

    public boolean isIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public int getPartOfUnlimitedPolicy() {
        return partOfUnlimitedPolicy;
    }

    public void setPartOfUnlimitedPolicy(int partOfUnlimitedPolicy) {
        this.partOfUnlimitedPolicy = partOfUnlimitedPolicy;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public int getInvoiceSuffix() {
        return invoiceSuffix;
    }

    public void setInvoiceSuffix(int invoiceSuffix) {
        this.invoiceSuffix = invoiceSuffix;
    }

//    public Settings getSettings() {
//        return settings;
//    }
//
//    public void setSettings(Settings settings) {
//        this.settings = settings;
//    }

    public boolean isAcApproved() {
        return acApproved;
    }

    public void setAcApproved(boolean acApproved) {
        this.acApproved = acApproved;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("type", type).append("name", name).append("docterId", docterId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("contactNumber", contactNumber).append("emergency", emergency).append("ambulance", ambulance).append("wheelChair", wheelChair).append("noOfBeds", noOfBeds).append("noOfDoctors", noOfDoctors).append("logoFileName", logoFileName).append("logoContentType", logoContentType).append("logoFileSize", logoFileSize).append("logoUpdatedAt", logoUpdatedAt).append("coverFileName", coverFileName).append("coverContentType", coverContentType).append("coverFileSize", coverFileSize).append("coverUpdatedAt", coverUpdatedAt).append("services", services).append("endDay", endDay).append("startDay", startDay).append("description", description).append("logoPicFileName", logoPicFileName).append("logoPicContentType", logoPicContentType).append("logoPicFileSize", logoPicFileSize).append("logoPicUpdatedAt", logoPicUpdatedAt).append("coverPicFileName", coverPicFileName).append("coverPicContentType", coverPicContentType).append("coverPicFileSize", coverPicFileSize).append("coverPicUpdatedAt", coverPicUpdatedAt).append("isUnlimited", isUnlimited).append("partOfUnlimitedPolicy", partOfUnlimitedPolicy).append("invoicePrefix", invoicePrefix).append("invoiceSuffix", invoiceSuffix)
//                .append("settings", settings)
                .append("acApproved", acApproved).append("isDeleted", isDeleted).append("managerId", managerId).append("serialNo", serialNo).append("cityId", cityId).append("areaId", areaId).append("streetAddress", streetAddress).append("latitude", latitude).append("longitude", longitude).append("postalCode", postalCode).toString();

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
//        dest.writeValue(settings);
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