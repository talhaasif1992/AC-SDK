package com.augmentcare.patient.model;

import java.util.ArrayList;

public class SlotsModel {
    String hours;
    String slots;

    public String getHours() {
        return hours;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public ArrayList<String> getSlotsArray() {
        return slotsArray;
    }

    public void setSlotsArray(ArrayList<String> slotsArray) {
        this.slotsArray = slotsArray;
    }

    ArrayList<String> slotsArray;

    public ArrayList<String> getTimeArray() {
        return timeArray;
    }

    public void setTimeArray(ArrayList<String> timeArray) {
        this.timeArray = timeArray;
    }

    ArrayList<String> timeArray;
}
