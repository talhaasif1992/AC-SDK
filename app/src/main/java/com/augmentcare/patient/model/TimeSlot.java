package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.TextUtils;

/**
 * Created by Qamar Ul Zaman on 13/09/2017.
 */

public class TimeSlot implements Parcelable{
    private String id;

    private String updated_at;

    private String offline_location;

    private String slot_duration;

    private String end_time;

    private String number_of_slots;

    private String name;
    private String patient_id;
    private String doctor_sitting_id;

    private String doctor_id;

    private String created_at;

    private String start_time;

    private String day;
    private boolean available;
    private String location_id;
    private String medical_practice_id;

    protected TimeSlot(Parcel in) {
        id = in.readString();
        updated_at = in.readString();
        offline_location = in.readString();
        slot_duration = in.readString();
        end_time = in.readString();
        number_of_slots = in.readString();
        name = in.readString();
        patient_id = in.readString();
        doctor_sitting_id = in.readString();
        doctor_id = in.readString();
        created_at = in.readString();
        start_time = in.readString();
        day = in.readString();
        available = in.readByte() != 0;
        location_id = in.readString();
        medical_practice_id = in.readString();
    }

    public static final Creator<TimeSlot> CREATOR = new Creator<TimeSlot>() {
        @Override
        public TimeSlot createFromParcel(Parcel in) {
            return new TimeSlot(in);
        }

        @Override
        public TimeSlot[] newArray(int size) {
            return new TimeSlot[size];
        }
    };

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getOffline_location ()
    {
        return offline_location;
    }

    public void setOffline_location (String offline_location)
    {
        this.offline_location = offline_location;
    }

    public String getSlot_duration ()
    {
        return slot_duration;
    }

    public void setSlot_duration (String slot_duration)
    {
        this.slot_duration = slot_duration;
    }

    public String getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (String end_time)
    {
        this.end_time = end_time;
    }

    public String getNumber_of_slots ()
    {
        return number_of_slots;
    }

    public void setNumber_of_slots (String number_of_slots)
    {
        this.number_of_slots = number_of_slots;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDoctor_sitting_id ()
    {
        return doctor_sitting_id;
    }

    public void setDoctor_sitting_id (String doctor_sitting_id)
    {
        this.doctor_sitting_id = doctor_sitting_id;
    }

    public String getDoctor_id ()
    {
        return doctor_id;
    }

    public void setDoctor_id (String doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }


    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return  TextUtils.formatTime(TextUtils.parseTime(start_time));
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getMedical_practice_id() {
        return medical_practice_id;
    }

    public void setMedical_practice_id(String medical_practice_id) {
        this.medical_practice_id = medical_practice_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(updated_at);
        parcel.writeString(offline_location);
        parcel.writeString(slot_duration);
        parcel.writeString(end_time);
        parcel.writeString(number_of_slots);
        parcel.writeString(name);
        parcel.writeString(patient_id);
        parcel.writeString(doctor_sitting_id);
        parcel.writeString(doctor_id);
        parcel.writeString(created_at);
        parcel.writeString(start_time);
        parcel.writeString(day);
        parcel.writeByte((byte) (available ? 1 : 0));
        parcel.writeString(location_id);
        parcel.writeString(medical_practice_id);
    }
}
