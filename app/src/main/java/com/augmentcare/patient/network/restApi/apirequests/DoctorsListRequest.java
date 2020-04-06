package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DoctorsListRequest implements Parcelable {

    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("per_page")
    @Expose
    private String perPage;
    @SerializedName("filters")
    @Expose
    private String filters;
    @SerializedName("search")
    @Expose
    private String search;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("hospital_id")
    @Expose
    private String hospitalId;
    @SerializedName("fee_min")
    @Expose
    private String feeMin;
    @SerializedName("fee_max")
    @Expose
    private String feeMax;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("reviews")
    @Expose
    private String reviews;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("experience_min")
    @Expose
    private String experienceMin;
    @SerializedName("experience_max")
    @Expose
    private String experienceMax;
    @SerializedName("distance_min")
    @Expose
    private String distanceMin;
    @SerializedName("distance_max")
    @Expose
    private String distanceMax;
    public final static Parcelable.Creator<DoctorsListRequest> CREATOR = new Creator<DoctorsListRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DoctorsListRequest createFromParcel(Parcel in) {
            return new DoctorsListRequest(in);
        }

        public DoctorsListRequest[] newArray(int size) {
            return (new DoctorsListRequest[size]);
        }

    };

    protected DoctorsListRequest(Parcel in) {
        this.page = ((String) in.readValue((String.class.getClassLoader())));
        this.perPage = ((String) in.readValue((String.class.getClassLoader())));
        this.filters = ((String) in.readValue((String.class.getClassLoader())));
        this.search = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.specialization = ((String) in.readValue((String.class.getClassLoader())));
        this.cityId = ((String) in.readValue((String.class.getClassLoader())));
        this.hospitalId = ((String) in.readValue((String.class.getClassLoader())));
        this.feeMin = ((String) in.readValue((String.class.getClassLoader())));
        this.feeMax = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.reviews = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((String) in.readValue((String.class.getClassLoader())));
        this.experienceMin = ((String) in.readValue((String.class.getClassLoader())));
        this.experienceMax = ((String) in.readValue((String.class.getClassLoader())));
        this.distanceMin = ((String) in.readValue((String.class.getClassLoader())));
        this.distanceMax = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DoctorsListRequest() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public DoctorsListRequest withPage(String page) {
        this.page = page;
        return this;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public DoctorsListRequest withRating(String rating) {
        this.rating = rating;
        return this;
    }
    public String getExperienceMin() {
        return experienceMin;
    }

    public void setExperienceMin(String experienceMin) {
        this.experienceMin = experienceMin;
    }

    public DoctorsListRequest withExperienceMin(String experienceMin) {
        this.experienceMin = experienceMin;
        return this;
    }
    public String getExperienceMax() {
        return experienceMax;
    }

    public void setExperienceMax(String experienceMax) {
        this.experienceMax = experienceMax;
    }

    public DoctorsListRequest withExperienceMax(String experienceMax) {
        this.experienceMax = experienceMax;
        return this;
    }
    public String getDistanceMin() {
        return distanceMin;
    }

    public void setDistanceMin(String distanceMin) {
        this.distanceMin = distanceMin;
    }

    public DoctorsListRequest withDistanceMin(String distanceMin) {
        this.distanceMin = distanceMin;
        return this;
    }
    public String getDistanceMax() {
        return experienceMax;
    }

    public void setDistanceMax(String experienceMax) {
        this.experienceMax = experienceMax;
    }

    public DoctorsListRequest withDistanceMax(String experienceMax) {
        this.experienceMax = experienceMax;
        return this;
    }
    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public DoctorsListRequest withReviews(String reviews) {
        this.reviews = reviews;
        return this;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public DoctorsListRequest withPerPage(String perPage) {
        this.perPage = perPage;
        return this;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public DoctorsListRequest withFilters(String filters) {
        this.filters = filters;
        return this;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public DoctorsListRequest withSearch(String search) {
        this.search = search;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorsListRequest withName(String name) {
        this.name = name;
        return this;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public DoctorsListRequest withSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public DoctorsListRequest withCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public DoctorsListRequest withHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
        return this;
    }

    public String getFeeMin() {
        return feeMin;
    }

    public void setFeeMin(String feeMin) {
        this.feeMin = feeMin;
    }

    public DoctorsListRequest withFeeMin(String feeMin) {
        this.feeMin = feeMin;
        return this;
    }

    public String getFeeMax() {
        return feeMax;
    }

    public void setFeeMax(String feeMax) {
        this.feeMax = feeMax;
    }

    public DoctorsListRequest withFeeMax(String feeMax) {
        this.feeMax = feeMax;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DoctorsListRequest withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("perPage", perPage).append("filters", filters).append("search", search).append("name", name).append("specialization", specialization).append("cityId", cityId).append("hospitalId", hospitalId).append("feeMin", feeMin).append("feeMax", feeMax).append("gender", gender).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(perPage);
        dest.writeValue(filters);
        dest.writeValue(search);
        dest.writeValue(name);
        dest.writeValue(specialization);
        dest.writeValue(cityId);
        dest.writeValue(hospitalId);
        dest.writeValue(feeMin);
        dest.writeValue(feeMax);
        dest.writeValue(gender);
        dest.writeValue(reviews);
    }

    public int describeContents() {
        return 0;
    }

}