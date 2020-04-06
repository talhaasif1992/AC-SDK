package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 26/10/2017.
 */

public class AAdress implements Parcelable{
    @SerializedName("street_address1")
    private String address1;
    @SerializedName("street_address2")
    private String address2;
    private String area;
    private String city;
    private String city_id;
    private String area_id;
    private String longitude;
    private String latitude;


    public AAdress(){

    }

    protected AAdress(Parcel in) {
        address1 = in.readString();
        address2 = in.readString();
        area = in.readString();
        city = in.readString();
        city_id = in.readString();
        area_id = in.readString();
        longitude = in.readString();
        latitude = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(area);
        dest.writeString(city);
        dest.writeString(city_id);
        dest.writeString(area_id);
        dest.writeString(longitude);
        dest.writeString(latitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AAdress> CREATOR = new Creator<AAdress>() {
        @Override
        public AAdress createFromParcel(Parcel in) {
            return new AAdress(in);
        }

        @Override
        public AAdress[] newArray(int size) {
            return new AAdress[size];
        }
    };

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        if(address1!=null){
            builder.append(address1);
        }
        if(address2!=null){
            builder.append(", "+address2);
        }
        if(area!=null){
            builder.append(", "+area);
        }
        if(city!=null){
            builder.append(", "+city);
        }
        return builder.toString();
    }

    public String getFullAddress(){
        StringBuilder builder = new StringBuilder();
        if(address1!=null){
            builder.append(address1);
        }
        if(address2!=null){
            builder.append("\n"+address2);
        }
        if(area!=null){
            builder.append("\n"+area);
        }
        if(city!=null){
            builder.append("\n"+city);
        }
        return builder.toString();
    }
}
