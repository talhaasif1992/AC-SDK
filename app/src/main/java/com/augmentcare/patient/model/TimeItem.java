package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.TextUtils;

import java.util.Date;

/**
 * Created by Qamar Ul Zaman on 13/09/2017.
 */

public class TimeItem implements Parcelable{
    private Date startTime;
    private Date endTime;
    private int duration;
    private Date day;
    private TimeSlot timeSlot;
    public TimeItem(){}

    protected TimeItem(Parcel in) {
        duration  = in.readInt();
        startTime =(Date) in.readSerializable();
        endTime   = (Date) in.readSerializable();
        day       = (Date) in.readSerializable();
        timeSlot  = in.readParcelable(TimeSlot.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(duration);
        dest.writeSerializable(startTime);
        dest.writeSerializable(endTime);
        dest.writeSerializable(day);
        dest.writeParcelable(timeSlot,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TimeItem> CREATOR = new Creator<TimeItem>() {
        @Override
        public TimeItem createFromParcel(Parcel in) {
            return new TimeItem(in);
        }

        @Override
        public TimeItem[] newArray(int size) {
            return new TimeItem[size];
        }
    };

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return TextUtils.formatTime24(startTime) + "   -   " +TextUtils.formatTime24(new Date(startTime.getTime() + duration * 60000));
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TimeItem){
            TimeItem timeSlot = (TimeItem) obj;
            return timeSlot.getStartTime().compareTo(startTime) == 0 && TextUtils.formatDate(timeSlot.day).equals(TextUtils.formatDate(day));
        } else {
            return false;
        }
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
