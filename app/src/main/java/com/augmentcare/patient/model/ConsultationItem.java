package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ConsultationItem implements Parcelable
{
    private ALocation location;
    private ASlot slot;
    private DependentSlots dependent;
    private UserInfo patient_info;
    private String docter_name;
    private String docter_pic;

    protected ConsultationItem(Parcel in)
    {
        location = in.readParcelable(ALocation.class.getClassLoader());
        slot = in.readParcelable(ASlot.class.getClassLoader());
        dependent = in.readParcelable(DependentSlots.class.getClassLoader());
        patient_info = in.readParcelable(UserInfo.class.getClassLoader());
        docter_name = in.readString();
        docter_pic = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeParcelable(location, flags);
        dest.writeParcelable(slot, flags);
        dest.writeParcelable(dependent, flags);
        dest.writeParcelable(patient_info, flags);
        dest.writeString(docter_name);
        dest.writeString(docter_pic);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConsultationItem> CREATOR = new Creator<ConsultationItem>() {
        @Override
        public ConsultationItem createFromParcel(Parcel in) {
            return new ConsultationItem(in);
        }

        @Override
        public ConsultationItem[] newArray(int size) {
            return new ConsultationItem[size];
        }
    };

    public ALocation getLocation() {
        return location;
    }

    public void setLocation(ALocation location) {
        this.location = location;
    }

    public ASlot getSlot() {
        return slot;
    }

    public DependentSlots getDependentSlots() {
        return dependent;
    }

    public void setDependentSlots(DependentSlots dependentSlots) {
        this.dependent = dependentSlots;
    }

    public void setSlot(ASlot slot) {
        this.slot = slot;
    }

    public String getDocter_name() {
        return docter_name;
    }

    public void setDocter_name(String docter_name) {
        this.docter_name = docter_name;
    }
    //private Object symptoms;

    public String getDocter_pic() {
        return docter_pic;
    }

    public void setDocter_pic(String docter_pic) {
        this.docter_pic = docter_pic;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof ASlot)
        {
            ASlot slot = (ASlot) obj;
            slot.getId().equalsIgnoreCase(slot.getId());
        }
        return false;
    }

    public UserInfo getPatient_info() {
        return patient_info;
    }

    public void setPatient_info(UserInfo patient_info) {
        this.patient_info = patient_info;
    }
}
