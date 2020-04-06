package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Errors implements Parcelable {

    @SerializedName("phone_number")
    @Expose
    private List<String> phoneNumber = null;
    @SerializedName("full_messages")
    @Expose
    private List<String> fullMessages = null;
    public final static Parcelable.Creator<Errors> CREATOR = new Creator<Errors>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Errors createFromParcel(Parcel in) {
            return new Errors(in);
        }

        public Errors[] newArray(int size) {
            return (new Errors[size]);
        }

    };

    protected Errors(Parcel in) {
        in.readList(this.phoneNumber, (java.lang.String.class.getClassLoader()));
        in.readList(this.fullMessages, (java.lang.String.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public Errors() {
    }

    /**
     * @param phoneNumber
     * @param fullMessages
     */
    public Errors(List<String> phoneNumber, List<String> fullMessages) {
        super();
        this.phoneNumber = phoneNumber;
        this.fullMessages = fullMessages;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Errors withPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<String> getFullMessages() {
        return fullMessages;
    }

    public void setFullMessages(List<String> fullMessages) {
        this.fullMessages = fullMessages;
    }

    public Errors withFullMessages(List<String> fullMessages) {
        this.fullMessages = fullMessages;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("phoneNumber", phoneNumber).append("fullMessages", fullMessages).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(phoneNumber);
        dest.writeList(fullMessages);
    }

    public int describeContents() {
        return 0;
    }

}