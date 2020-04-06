package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.utils.TextUtils;

import java.util.Date;


/**
 * Created by Qamar Ul Zaman on 11/10/2017.
 */

public class SlotDay implements Parcelable{
    protected SlotDay(Parcel in) {
        day = in.readString();
        date =(Date) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeSerializable(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SlotDay> CREATOR = new Creator<SlotDay>() {
        @Override
        public SlotDay createFromParcel(Parcel in) {
            return new SlotDay(in);
        }

        @Override
        public SlotDay[] newArray(int size) {
            return new SlotDay[size];
        }
    };

    public Date getDate() {
        return date;
    }

    private String day;
    private Date date;

    public String getDay() {
        return day;
    }

    public SlotDay(String day, Date date){
        this.day = day;
        this.date = date;
    }
    public void setDay(String day) {
        this.day = day;

    }



    @Override
    public String toString() {
        String formatedDate ="";
        try {
            formatedDate = TextUtils.formatDate((date));
        } catch (Exception e){
            e.printStackTrace();
        }
        return day + "  " +formatedDate;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
