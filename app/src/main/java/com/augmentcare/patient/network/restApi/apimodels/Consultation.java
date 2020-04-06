package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.enums.APPOINTMENT_STATUS;
import com.augmentcare.patient.utils.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultation implements Parcelable {

    @SerializedName("invoice")
    @Expose
    private Invoice invoice;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("slot")
    @Expose
    private Slot slot;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;
    @SerializedName("dependent")
    @Expose
    private Dependent dependent;
    @SerializedName("procedure")
    @Expose
    private List<Object> procedure = new ArrayList<Object>();
    @SerializedName("doctor_info")
    @Expose
    private UserInfo doctorInfo;
    @SerializedName("last_visit")
    @Expose
    private String lastVisit;
    @SerializedName("total_apts")
    @Expose
    private Integer totalApts;

    public final static Parcelable.Creator<Consultation> CREATOR = new Creator<Consultation>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Consultation createFromParcel(Parcel in) {
            return new Consultation(in);
        }

        public Consultation[] newArray(int size) {
            return (new Consultation[size]);
        }

    };

    protected Consultation(Parcel in) {
        this.invoice = ((Invoice) in.readValue((Invoice.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.slot = ((Slot) in.readValue((Slot.class.getClassLoader())));
        this.userInfo = ((UserInfo) in.readValue((UserInfo.class.getClassLoader())));
        this.dependent = ((Dependent) in.readValue((Dependent.class.getClassLoader())));
        in.readList(this.procedure, (java.lang.Object.class.getClassLoader()));
        this.doctorInfo = ((UserInfo) in.readValue((UserInfo.class.getClassLoader())));
        this.lastVisit = ((String) in.readValue((String.class.getClassLoader())));
        this.totalApts = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Consultation() {
    }

    public boolean isUpComingAppointment(){
        try {
            Date bookingDate = TextUtils.parseTime(slot.getBookingTime());
            Date presentDate = new Date();
            int status = getStatus();
            return status != APPOINTMENT_STATUS.COMPLETED &&
                    status != APPOINTMENT_STATUS.CANCELED &&
                    status != APPOINTMENT_STATUS.REJECTED &&
                    bookingDate.after(presentDate);
        }
        catch (Exception e)
        {

        }
        return false;
    }

    public int getStatus() {
        if (slot != null) {
            if ((slot.getSlotStatus() != null && slot.getSlotStatus().contains("prescription_submitted")) ||
                    (slot.getCompleted() != null && slot.getCompleted())) {
                return APPOINTMENT_STATUS.COMPLETED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("cancelled_by_patient")) {
                return APPOINTMENT_STATUS.CANCELED;
            } else if ((slot.getSlotStatus() != null && slot.getSlotStatus().contains("cancelled_by_doctor")) ||
                    (slot.getRejected() != null && slot.getRejected())) {
                return APPOINTMENT_STATUS.REJECTED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("approved")) {
                return APPOINTMENT_STATUS.APPROVED;
            } else if (slot.getSlotStatus() != null && slot.getSlotStatus().contains("pending")) {
                return APPOINTMENT_STATUS.PENDING;
            } else {
                return APPOINTMENT_STATUS.UNKNOWN;
            }
        }else{
            return APPOINTMENT_STATUS.UNKNOWN;
        }
    }


    public void setStatus(@APPOINTMENT_STATUS.AppointmentStatusType int slotStatus){
        switch (slotStatus){
            case APPOINTMENT_STATUS.APPROVED:
            case APPOINTMENT_STATUS.UPCOMMING:
                slot.setSlotStatus("approved");
                break;
            case APPOINTMENT_STATUS.COMPLETED:
                slot.setSlotStatus("prescription_submitted");
                break;
            case APPOINTMENT_STATUS.CANCELED:
                slot.setSlotStatus("cancelled_by_patient");
                break;
            case APPOINTMENT_STATUS.PENDING:
                slot.setSlotStatus("pending");
                break;
            case APPOINTMENT_STATUS.REJECTED:
                slot.setSlotStatus("cancelled_by_doctor");
                break;
            case APPOINTMENT_STATUS.UNKNOWN:
                slot.setSlotStatus("");
                break;
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Consultation withInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Consultation withLocation(Location location) {
        this.location = location;
        return this;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Consultation withSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Consultation withUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public Dependent getDependent() {
        return dependent;
    }

    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public Consultation withDependent(Dependent dependent) {
        this.dependent = dependent;
        return this;
    }

    public List<Object> getProcedure() {
        return procedure;
    }

    public void setProcedure(List<Object> procedure) {
        this.procedure = procedure;
    }

    public Consultation withProcedure(List<Object> procedure) {
        this.procedure = procedure;
        return this;
    }

    public UserInfo getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(UserInfo doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public Consultation withDoctorInfo(UserInfo doctorInfo) {
        this.doctorInfo = doctorInfo;
        return this;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Consultation withLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
        return this;
    }

    public Integer getTotalApts() {
        return totalApts;
    }

    public void setTotalApts(Integer totalApts) {
        this.totalApts = totalApts;
    }

    public Consultation withTotalApts(Integer totalApts) {
        this.totalApts = totalApts;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoice", invoice).append("location", location).append("slot", slot).append("userInfo", userInfo).append("dependent", dependent).append("procedure", procedure).append("doctorInfo", doctorInfo).append("lastVisit", lastVisit).append("totalApts", totalApts).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(invoice);
        dest.writeValue(location);
        dest.writeValue(slot);
        dest.writeValue(userInfo);
        dest.writeValue(dependent);
        dest.writeList(procedure);
        dest.writeValue(doctorInfo);
        dest.writeValue(lastVisit);
        dest.writeValue(totalApts);
    }

    public int describeContents() {
        return 0;
    }

}