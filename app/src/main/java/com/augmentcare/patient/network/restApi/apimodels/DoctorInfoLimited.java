package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class DoctorInfoLimited implements Parcelable {

    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rated_count")
    @Expose
    private Integer ratedCount;
    @SerializedName("instant_doctor")
    @Expose
    private Boolean instantDoctor;
    @SerializedName("specialization")
    @Expose
    private List<String> specialization = new ArrayList<String>();
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("picture")
    @Expose
    private String picture;
    public final static Parcelable.Creator<DoctorInfoLimited> CREATOR = new Creator<DoctorInfoLimited>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DoctorInfoLimited createFromParcel(Parcel in) {
            return new DoctorInfoLimited(in);
        }

        public DoctorInfoLimited[] newArray(int size) {
            return (new DoctorInfoLimited[size]);
        }

    };

    protected DoctorInfoLimited(Parcel in) {
        this.rating = ((String) in.readValue((String.class.getClassLoader())));
        this.ratedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.instantDoctor = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.specialization, (java.lang.String.class.getClassLoader()));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.fee = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.picture = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DoctorInfoLimited() {
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public DoctorInfoLimited withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
    }

    public DoctorInfoLimited withRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
        return this;
    }

    public Boolean getInstantDoctor() {
        return instantDoctor;
    }

    public void setInstantDoctor(Boolean instantDoctor) {
        this.instantDoctor = instantDoctor;
    }

    public DoctorInfoLimited withInstantDoctor(Boolean instantDoctor) {
        this.instantDoctor = instantDoctor;
        return this;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<String> specialization) {
        this.specialization = specialization;
    }

    public DoctorInfoLimited withSpecialization(List<String> specialization) {
        this.specialization = specialization;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DoctorInfoLimited withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorInfoLimited withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public DoctorInfoLimited withFee(Integer fee) {
        this.fee = fee;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public DoctorInfoLimited withPicture(String picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rating", rating).append("ratedCount", ratedCount).append("instantDoctor", instantDoctor).append("specialization", specialization).append("id", id).append("name", name).append("fee", fee).append("picture", picture).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rating);
        dest.writeValue(ratedCount);
        dest.writeValue(instantDoctor);
        dest.writeList(specialization);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(fee);
        dest.writeValue(picture);
    }

    public int describeContents() {
        return 0;
    }

}