package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Medicine implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unit")
    @Expose
    private Integer unit;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("unit_price")
    @Expose
    private Double unitPrice;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("purchase_conversion_factor")
    @Expose
    private Double purchaseConversionFactor;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pharmacy_med_name")
    @Expose
    private String pharmacyMedName;
    @SerializedName("in_loose")
    @Expose
    private Boolean inLoose;
    @SerializedName("sehat_id")
    @Expose
    private Integer sehatId;
    @SerializedName("is_prescription_required")
    @Expose
    private Boolean isPrescriptionRequired;
    @SerializedName("med_for")
    @Expose
    private String medFor;
    @SerializedName("medicine_manufacturer_id")
    @Expose
    private Integer medicineManufacturerId;
    @SerializedName("added_by_id")
    @Expose
    private String addedById;
    @SerializedName("added_by_status")
    @Expose
    private Boolean addedByStatus;
    public final static Parcelable.Creator<Medicine> CREATOR = new Creator<Medicine>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        public Medicine[] newArray(int size) {
            return (new Medicine[size]);
        }

    };

    protected Medicine(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.unit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.unitPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discount = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseConversionFactor = ((Double) in.readValue((Double.class.getClassLoader())));
        this.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.pharmacyMedName = ((String) in.readValue((String.class.getClassLoader())));
        this.inLoose = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.sehatId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isPrescriptionRequired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.medFor = ((String) in.readValue((String.class.getClassLoader())));
        this.medicineManufacturerId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.addedById = ((String) in.readValue((String.class.getClassLoader())));
        this.addedByStatus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Medicine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medicine withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Medicine withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Medicine withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Medicine withUnit(Integer unit) {
        this.unit = unit;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Medicine withCategory(String category) {
        this.category = category;
        return this;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Medicine withUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Medicine withDiscount(String discount) {
        this.discount = discount;
        return this;
    }

    public Double getPurchaseConversionFactor() {
        return purchaseConversionFactor;
    }

    public void setPurchaseConversionFactor(Double purchaseConversionFactor) {
        this.purchaseConversionFactor = purchaseConversionFactor;
    }

    public Medicine withPurchaseConversionFactor(Double purchaseConversionFactor) {
        this.purchaseConversionFactor = purchaseConversionFactor;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Medicine withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Medicine withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Medicine withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getPharmacyMedName() {
        return pharmacyMedName;
    }

    public void setPharmacyMedName(String pharmacyMedName) {
        this.pharmacyMedName = pharmacyMedName;
    }

    public Medicine withPharmacyMedName(String pharmacyMedName) {
        this.pharmacyMedName = pharmacyMedName;
        return this;
    }

    public Boolean getInLoose() {
        return inLoose;
    }

    public void setInLoose(Boolean inLoose) {
        this.inLoose = inLoose;
    }

    public Medicine withInLoose(Boolean inLoose) {
        this.inLoose = inLoose;
        return this;
    }

    public Integer getSehatId() {
        return sehatId;
    }

    public void setSehatId(Integer sehatId) {
        this.sehatId = sehatId;
    }

    public Medicine withSehatId(Integer sehatId) {
        this.sehatId = sehatId;
        return this;
    }

    public Boolean getIsPrescriptionRequired() {
        return isPrescriptionRequired;
    }

    public void setIsPrescriptionRequired(Boolean isPrescriptionRequired) {
        this.isPrescriptionRequired = isPrescriptionRequired;
    }

    public Medicine withIsPrescriptionRequired(Boolean isPrescriptionRequired) {
        this.isPrescriptionRequired = isPrescriptionRequired;
        return this;
    }

    public String getMedFor() {
        return medFor;
    }

    public void setMedFor(String medFor) {
        this.medFor = medFor;
    }

    public Medicine withMedFor(String medFor) {
        this.medFor = medFor;
        return this;
    }

    public Integer getMedicineManufacturerId() {
        return medicineManufacturerId;
    }

    public void setMedicineManufacturerId(Integer medicineManufacturerId) {
        this.medicineManufacturerId = medicineManufacturerId;
    }

    public Medicine withMedicineManufacturerId(Integer medicineManufacturerId) {
        this.medicineManufacturerId = medicineManufacturerId;
        return this;
    }

    public String getAddedById() {
        return addedById;
    }

    public void setAddedById(String addedById) {
        this.addedById = addedById;
    }

    public Medicine withAddedById(String addedById) {
        this.addedById = addedById;
        return this;
    }

    public Boolean getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(Boolean addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public Medicine withAddedByStatus(Boolean addedByStatus) {
        this.addedByStatus = addedByStatus;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("code", code).append("name", name).append("unit", unit).append("category", category).append("unitPrice", unitPrice).append("discount", discount).append("purchaseConversionFactor", purchaseConversionFactor).append("active", active).append("createdAt", createdAt).append("updatedAt", updatedAt).append("pharmacyMedName", pharmacyMedName).append("inLoose", inLoose).append("sehatId", sehatId).append("isPrescriptionRequired", isPrescriptionRequired).append("medFor", medFor).append("medicineManufacturerId", medicineManufacturerId).append("addedById", addedById).append("addedByStatus", addedByStatus).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(code);
        dest.writeValue(name);
        dest.writeValue(unit);
        dest.writeValue(category);
        dest.writeValue(unitPrice);
        dest.writeValue(discount);
        dest.writeValue(purchaseConversionFactor);
        dest.writeValue(active);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(pharmacyMedName);
        dest.writeValue(inLoose);
        dest.writeValue(sehatId);
        dest.writeValue(isPrescriptionRequired);
        dest.writeValue(medFor);
        dest.writeValue(medicineManufacturerId);
        dest.writeValue(addedById);
        dest.writeValue(addedByStatus);
    }

    public int describeContents() {
        return 0;
    }

}