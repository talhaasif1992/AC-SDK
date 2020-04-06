
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class InstantAppointmentSlotResult implements Parcelable
{

    @SerializedName("available")
    @Expose
    private AvailableDoctor availableDoctor;
    @SerializedName("suggestions")
    @Expose
    private List<AvailableDoctor> suggestedDoctors;
    public final static Creator<InstantAppointmentSlotResult> CREATOR = new Creator<InstantAppointmentSlotResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public InstantAppointmentSlotResult createFromParcel(Parcel in) {
            return new InstantAppointmentSlotResult(in);
        }

        public InstantAppointmentSlotResult[] newArray(int size) {
            return (new InstantAppointmentSlotResult[size]);
        }

    }
    ;

    protected InstantAppointmentSlotResult(Parcel in) {
        this.availableDoctor = ((AvailableDoctor) in.readValue((AvailableDoctor.class.getClassLoader())));
        in.readList(suggestedDoctors,AvailableDoctor.class.getClassLoader());
    }

    public InstantAppointmentSlotResult() {
    }

    public AvailableDoctor getAvailableDoctor() {
        return availableDoctor;
    }

    public void setAvailableDoctor(AvailableDoctor availableDoctor) {
        this.availableDoctor = availableDoctor;
    }

    public InstantAppointmentSlotResult withAvailable(AvailableDoctor availableDoctor) {
        this.availableDoctor = availableDoctor;
        return this;
    }
    public List<AvailableDoctor> getSuggestedDoctors() {
        return suggestedDoctors;
    }

    public void setuggestedDoctors(List<AvailableDoctor> suggestedDoctors) {
        this.suggestedDoctors = suggestedDoctors;
    }

    public InstantAppointmentSlotResult withuggestedDoctors(List<AvailableDoctor> suggestedDoctors) {
        this.suggestedDoctors = suggestedDoctors;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("availableDoctor", availableDoctor)
                .append("suggestedDoctors", suggestedDoctors)
                .toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(availableDoctor);
        dest.writeList(suggestedDoctors);
    }

    public int describeContents() {
        return  0;
    }

}
