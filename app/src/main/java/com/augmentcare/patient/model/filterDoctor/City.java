
package com.augmentcare.patient.model.filterDoctor;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City implements Parcelable {

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
    private List<Object> areas = null;
    @SerializedName("medical_practices")
    @Expose
    private List<Object> medicalPractices = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public Boolean getIsAvailableForChughtaiLab() {
        return isAvailableForChughtaiLab;
    }

    public void setIsAvailableForChughtaiLab(Boolean isAvailableForChughtaiLab) {
        this.isAvailableForChughtaiLab = isAvailableForChughtaiLab;
    }

    public List<Object> getAreas() {
        return areas;
    }

    public void setAreas(List<Object> areas) {
        this.areas = areas;
    }

    public List<Object> getMedicalPractices() {
        return medicalPractices;
    }

    public void setMedicalPractices(List<Object> medicalPractices) {
        this.medicalPractices = medicalPractices;
    }


    protected City(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
        countryId = in.readByte() == 0x00 ? null : in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        byte isAvailableForChughtaiLabVal = in.readByte();
        isAvailableForChughtaiLab = isAvailableForChughtaiLabVal == 0x02 ? null : isAvailableForChughtaiLabVal != 0x00;
        if (in.readByte() == 0x01) {
            areas = new ArrayList<Object>();
            in.readList(areas, Object.class.getClassLoader());
        } else {
            areas = null;
        }
        if (in.readByte() == 0x01) {
            medicalPractices = new ArrayList<Object>();
            in.readList(medicalPractices, Object.class.getClassLoader());
        } else {
            medicalPractices = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(name);
        if (countryId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(countryId);
        }
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        if (isAvailableForChughtaiLab == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isAvailableForChughtaiLab ? 0x01 : 0x00));
        }
        if (areas == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(areas);
        }
        if (medicalPractices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(medicalPractices);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}