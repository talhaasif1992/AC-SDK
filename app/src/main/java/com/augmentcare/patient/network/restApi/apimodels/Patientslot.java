package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Patientslot implements Parcelable {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("slot")
    @Expose
    private Slot slot;
    @SerializedName("docter_name")
    @Expose
    private String docterName;
    @SerializedName("docter_pic")
    @Expose
    private String docterPic;
    @SerializedName("docter")
    @Expose
    private DocterInfo docter;
    @SerializedName("specialization")
    @Expose
    private List<Specialization> specialization = new ArrayList<Specialization>();
    @SerializedName("dependent")
    @Expose
    private Dependent dependent;
    public final static Parcelable.Creator<Patientslot> CREATOR = new Creator<Patientslot>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Patientslot createFromParcel(Parcel in) {
            return new Patientslot(in);
        }

        public Patientslot[] newArray(int size) {
            return (new Patientslot[size]);
        }

    };

    protected Patientslot(Parcel in) {
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.slot = ((Slot) in.readValue((Slot.class.getClassLoader())));
        this.docterName = ((String) in.readValue((String.class.getClassLoader())));
        this.docterPic = ((String) in.readValue((String.class.getClassLoader())));
        this.docter = ((DocterInfo) in.readValue((DocterInfo.class.getClassLoader())));
        in.readList(this.specialization, (com.augmentcare.patient.network.restApi.apimodels.Specialization.class.getClassLoader()));
        this.dependent = ((Dependent) in.readValue((Dependent.class.getClassLoader())));
    }

    public Patientslot() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Patientslot withLocation(Location location) {
        this.location = location;
        return this;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Patientslot withSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public String getDocterName() {
        return docterName;
    }

    public void setDocterName(String docterName) {
        this.docterName = docterName;
    }

    public Patientslot withDocterName(String docterName) {
        this.docterName = docterName;
        return this;
    }

    public String getDocterPic() {
        return docterPic;
    }

    public void setDocterPic(String docterPic) {
        this.docterPic = docterPic;
    }

    public Patientslot withDocterPic(String docterPic) {
        this.docterPic = docterPic;
        return this;
    }

    public DocterInfo getDocter() {
        return docter;
    }

    public void setDocter(DocterInfo docter) {
        this.docter = docter;
    }

    public Patientslot withDocter(DocterInfo docter) {
        this.docter = docter;
        return this;
    }

    public List<Specialization> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<Specialization> specialization) {
        this.specialization = specialization;
    }

    public Patientslot withSpecialization(List<Specialization> specialization) {
        this.specialization = specialization;
        return this;
    }

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public Patientslot withDependent(Dependent dependent) {
        this.dependent = dependent;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("location", location).append("slot", slot).append("docterName", docterName).append("docterPic", docterPic).append("docter", docter).append("specialization", specialization).append("dependent", dependent).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeValue(slot);
        dest.writeValue(docterName);
        dest.writeValue(docterPic);
        dest.writeValue(docter);
        dest.writeList(specialization);
        dest.writeValue(dependent);
    }

    public int describeContents() {
        return 0;
    }

}