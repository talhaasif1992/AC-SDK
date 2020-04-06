package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MessageResponse implements Parcelable
{

    @SerializedName("message")
    @Expose
    private Message message;
    public final static Parcelable.Creator<MessageResponse> CREATOR = new Creator<MessageResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MessageResponse createFromParcel(Parcel in) {
            return new MessageResponse(in);
        }

        public MessageResponse[] newArray(int size) {
            return (new MessageResponse[size]);
        }

    }
            ;

    protected MessageResponse(Parcel in) {
        this.message = ((Message) in.readValue((Message.class.getClassLoader())));
    }

    public MessageResponse() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MessageResponse withMessage(Message message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("message", message).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}