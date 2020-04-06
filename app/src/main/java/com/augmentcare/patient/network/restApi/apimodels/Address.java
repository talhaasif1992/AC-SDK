package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("area_id")
    @Expose
    private Integer areaId;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("street_address1")
    @Expose
    private String streetAddress1;
    @SerializedName("street_address2")
    @Expose
    private String streetAddress2;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("first_name")
    @Expose
    private Object firstName;
    @SerializedName("last_name")
    @Expose
    private Object lastName;
    @SerializedName("postal_code")
    @Expose
    private Object postalCode;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("address_type")
    @Expose
    private Object addressType;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    public final static Parcelable.Creator<Address> CREATOR = new Creator<Address>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        public Address[] newArray(int size) {
            return (new Address[size]);
        }

    };

    protected Address(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.areaId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cityId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.streetAddress1 = ((String) in.readValue((String.class.getClassLoader())));
        this.streetAddress2 = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.area = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = in.readValue((Object.class.getClassLoader()));
        this.lastName = in.readValue((Object.class.getClassLoader()));
        this.postalCode = in.readValue((Object.class.getClassLoader()));
        this.country = in.readValue((Object.class.getClassLoader()));
        this.state = in.readValue((Object.class.getClassLoader()));
        this.addressType = in.readValue((Object.class.getClassLoader()));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Address withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Address withAreaId(Integer areaId) {
        this.areaId = areaId;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Address withCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public Address withStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
        return this;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public Address withStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Address withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Address withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Address withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Address withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Address withArea(String area) {
        this.area = area;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Address withTitle(String title) {
        this.title = title;
        return this;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Address withFirstName(Object firstName) {
        this.firstName = firstName;
        return this;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public Address withLastName(Object lastName) {
        this.lastName = lastName;
        return this;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Address withPostalCode(Object postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Address withCountry(Object country) {
        this.country = country;
        return this;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Address withState(Object state) {
        this.state = state;
        return this;
    }

    public Object getAddressType() {
        return addressType;
    }

    public void setAddressType(Object addressType) {
        this.addressType = addressType;
    }

    public Address withAddressType(Object addressType) {
        this.addressType = addressType;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Address withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("userId", userId).append("areaId", areaId).append("cityId", cityId).append("streetAddress1", streetAddress1).append("streetAddress2", streetAddress2).append("longitude", longitude).append("latitude", latitude).append("createdAt", createdAt).append("updatedAt", updatedAt).append("area", area).append("city", city).append("title", title).append("firstName", firstName).append("lastName", lastName).append("postalCode", postalCode).append("country", country).append("state", state).append("addressType", addressType).append("isActive", isActive).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userId);
        dest.writeValue(areaId);
        dest.writeValue(cityId);
        dest.writeValue(streetAddress1);
        dest.writeValue(streetAddress2);
        dest.writeValue(longitude);
        dest.writeValue(latitude);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(area);
        dest.writeValue(city);
        dest.writeValue(title);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(postalCode);
        dest.writeValue(country);
        dest.writeValue(state);
        dest.writeValue(addressType);
        dest.writeValue(isActive);
    }

    public int describeContents() {
        return 0;
    }

}