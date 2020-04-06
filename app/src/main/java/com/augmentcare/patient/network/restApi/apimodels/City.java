package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class City implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country_id")
    @Expose
    private Integer countryId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_available_for_chughtai_lab")
    @Expose
    private Boolean isAvailableForChughtaiLab;
    @SerializedName("areas")
    @Expose
    private List<Area> areas = new ArrayList<Area>();
    public final static Parcelable.Creator<City> CREATOR = new Creator<City>() {


        @SuppressWarnings({
                "unchecked"
        })
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return (new City[size]);
        }

    }
            ;

    protected City(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.countryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.isAvailableForChughtaiLab = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.areas, (com.augmentcare.patient.network.restApi.apimodels.Area.class.getClassLoader()));
    }

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public City withCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public City withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public City withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getIsAvailableForChughtaiLab() {
        return isAvailableForChughtaiLab;
    }

    public void setIsAvailableForChughtaiLab(Boolean isAvailableForChughtaiLab) {
        this.isAvailableForChughtaiLab = isAvailableForChughtaiLab;
    }

    public City withIsAvailableForChughtaiLab(Boolean isAvailableForChughtaiLab) {
        this.isAvailableForChughtaiLab = isAvailableForChughtaiLab;
        return this;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public City withAreas(List<Area> areas) {
        this.areas = areas;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("countryId", countryId).append("createdAt", createdAt).append("updatedAt", updatedAt).append("isAvailableForChughtaiLab", isAvailableForChughtaiLab).append("areas", areas).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(countryId);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(isAvailableForChughtaiLab);
        dest.writeList(areas);
    }

    public int describeContents() {
        return 0;
    }

}