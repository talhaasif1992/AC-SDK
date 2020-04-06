package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DependentTypes implements Parcelable {

    @SerializedName("mother")
    @Expose
    private Integer mother;
    @SerializedName("father")
    @Expose
    private Integer father;
    @SerializedName("wife")
    @Expose
    private Integer wife;
    @SerializedName("husband")
    @Expose
    private Integer husband;
    @SerializedName("son")
    @Expose
    private Integer son;
    @SerializedName("daughter")
    @Expose
    private Integer daughter;
    @SerializedName("sibling")
    @Expose
    private Integer sibling;
    public final static Parcelable.Creator<DependentTypes> CREATOR = new Creator<DependentTypes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DependentTypes createFromParcel(Parcel in) {
            return new DependentTypes(in);
        }

        public DependentTypes[] newArray(int size) {
            return (new DependentTypes[size]);
        }

    };

    protected DependentTypes(Parcel in) {
        this.mother = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.father = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wife = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.husband = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.son = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.daughter = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sibling = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public DependentTypes() {
    }

    public Integer getMother() {
        return mother;
    }

    public void setMother(Integer mother) {
        this.mother = mother;
    }

    public DependentTypes withMother(Integer mother) {
        this.mother = mother;
        return this;
    }

    public Integer getFather() {
        return father;
    }

    public void setFather(Integer father) {
        this.father = father;
    }

    public DependentTypes withFather(Integer father) {
        this.father = father;
        return this;
    }

    public Integer getWife() {
        return wife;
    }

    public void setWife(Integer wife) {
        this.wife = wife;
    }

    public DependentTypes withWife(Integer wife) {
        this.wife = wife;
        return this;
    }

    public Integer getHusband() {
        return husband;
    }

    public void setHusband(Integer husband) {
        this.husband = husband;
    }

    public DependentTypes withHusband(Integer husband) {
        this.husband = husband;
        return this;
    }

    public Integer getSon() {
        return son;
    }

    public void setSon(Integer son) {
        this.son = son;
    }

    public DependentTypes withSon(Integer son) {
        this.son = son;
        return this;
    }

    public Integer getDaughter() {
        return daughter;
    }

    public void setDaughter(Integer daughter) {
        this.daughter = daughter;
    }

    public DependentTypes withDaughter(Integer daughter) {
        this.daughter = daughter;
        return this;
    }

    public Integer getSibling() {
        return sibling;
    }

    public void setSibling(Integer sibling) {
        this.sibling = sibling;
    }

    public DependentTypes withSibling(Integer sibling) {
        this.sibling = sibling;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("mother", mother).append("father", father).append("wife", wife).append("husband", husband).append("son", son).append("daughter", daughter).append("sibling", sibling).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mother);
        dest.writeValue(father);
        dest.writeValue(wife);
        dest.writeValue(husband);
        dest.writeValue(son);
        dest.writeValue(daughter);
        dest.writeValue(sibling);
    }

    public int describeContents() {
        return 0;
    }

}