package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 09/03/2018.
 */

public class LabTest implements Parcelable{
    private String id;

    private String price;
    @SerializedName("updated_at")
    private String updatedAt;
    private String specimen;

    private String name;

    //private null report_type;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("fasting_requirement")
    private boolean fastingRequirement;
    private String report_type;
    private String short_name;
    private String fasting_time;
    private String relevant_disease;
    private String purpose;
    private String normal_test_value_range;

    private String profile_name;
    private String specimen_quantity;
    private String specimen_nature;

    public LabTest(){

    }

    protected LabTest(Parcel in) {
        id = in.readString();
        price = in.readString();
        updatedAt = in.readString();
        specimen = in.readString();
        name = in.readString();
        createdAt = in.readString();
        fastingRequirement = in.readByte() != 0;
        report_type = in.readString();
        short_name = in.readString();
        fasting_time = in.readString();
        relevant_disease = in.readString();
        purpose = in.readString();
        normal_test_value_range = in.readString();
        profile_name = in.readString();
        specimen_quantity = in.readString();
        specimen_nature = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(price);
        dest.writeString(updatedAt);
        dest.writeString(specimen);
        dest.writeString(name);
        dest.writeString(createdAt);
        dest.writeByte((byte) (fastingRequirement ? 1 : 0));
        dest.writeString(report_type);
        dest.writeString(short_name);
        dest.writeString(fasting_time);
        dest.writeString(relevant_disease);
        dest.writeString(purpose);
        dest.writeString(normal_test_value_range);
        dest.writeString(profile_name);
        dest.writeString(specimen_quantity);
        dest.writeString(specimen_nature);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LabTest> CREATOR = new Creator<LabTest>() {
        @Override
        public LabTest createFromParcel(Parcel in) {
            return new LabTest(in);
        }

        @Override
        public LabTest[] newArray(int size) {
            return new LabTest[size];
        }
    };

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getFasting_time() {
        return fasting_time;
    }

    public void setFasting_time(String fasting_time) {
        this.fasting_time = fasting_time;
    }

    public String getRelevant_disease() {
        return relevant_disease;
    }

    public void setRelevant_disease(String relevant_disease) {
        this.relevant_disease = relevant_disease;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNormal_test_value_range() {
        return normal_test_value_range;
    }

    public void setNormal_test_value_range(String normal_test_value_range) {
        this.normal_test_value_range = normal_test_value_range;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public String getSpecimen_quantity() {
        return specimen_quantity;
    }

    public void setSpecimen_quantity(String specimen_quantity) {
        this.specimen_quantity = specimen_quantity;
    }

    public String getSpecimen_nature() {
        return specimen_nature;
    }

    public void setSpecimen_nature(String specimen_nature) {
        this.specimen_nature = specimen_nature;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getFastingRequirement() {
        return fastingRequirement;
    }

    public void setFastingRequirement(boolean fastingRequirement) {
        this.fastingRequirement = fastingRequirement;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LabTest){
          LabTest test = (LabTest) obj;
          if(test.id !=null && id !=null)
              return id.equalsIgnoreCase(test.id);
          else
              return false;
        } else
            return false;
    }
}
