package com.augmentcare.patient.network.restApi.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConsultationSlots implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("slots")
    @Expose
    private List<List<Slot>> slots = new ArrayList<List<Slot>>();
    @SerializedName("booked_slots")
    @Expose
    private List<List<Slot>> bookedSlots = new ArrayList<List<Slot>>();
    private final static long serialVersionUID = 1412814902150097695L;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ConsultationSlots withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public List<List<Slot>> getSlots() {
        return slots;
    }

    public void setSlots(List<List<Slot>> slots) {
        this.slots = slots;
    }

    public ConsultationSlots withSlots(List<List<Slot>> slots) {
        this.slots = slots;
        return this;
    }

    public List<List<Slot>> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<List<Slot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public ConsultationSlots withBookedSlots(List<List<Slot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("success", success).append("slots", slots).append("bookedSlots", bookedSlots).toString();
    }

}