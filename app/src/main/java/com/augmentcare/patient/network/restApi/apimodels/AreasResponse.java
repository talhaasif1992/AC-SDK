package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class AreasResponse implements Parcelable {

    @SerializedName("areas")
    @Expose
    private List<Area> areas = new ArrayList<Area>();
    @SerializedName("cities")
    @Expose
    private List<City> cities = new ArrayList<City>();
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<AreasResponse> CREATOR = new Creator<AreasResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AreasResponse createFromParcel(Parcel in) {
            return new AreasResponse(in);
        }

        public AreasResponse[] newArray(int size) {
            return (new AreasResponse[size]);
        }

    };

    protected AreasResponse(Parcel in) {
        in.readList(this.areas, (com.augmentcare.patient.network.restApi.apimodels.Area.class.getClassLoader()));
        in.readList(this.cities, (com.augmentcare.patient.network.restApi.apimodels.City.class.getClassLoader()));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public AreasResponse() {
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public AreasResponse withAreas(List<Area> areas) {
        this.areas = areas;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public AreasResponse withCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public AreasResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("areas", areas).append("cities", cities).append("success", success).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(areas);
        dest.writeList(cities);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}