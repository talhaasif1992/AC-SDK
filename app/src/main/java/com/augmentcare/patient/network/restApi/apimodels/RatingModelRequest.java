package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RatingModelRequest implements Parcelable {

    @SerializedName("consultation")
    @Expose
    private ConsultationRating consultationRating;
    public final static Parcelable.Creator<RatingModelRequest> CREATOR = new Creator<RatingModelRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RatingModelRequest createFromParcel(Parcel in) {
            return new RatingModelRequest(in);
        }

        public RatingModelRequest[] newArray(int size) {
            return (new RatingModelRequest[size]);
        }

    };

    protected RatingModelRequest(Parcel in) {
        this.consultationRating = ((ConsultationRating) in.readValue((ConsultationRating.class.getClassLoader())));
    }

    public RatingModelRequest() {
    }

    public ConsultationRating getConsultationRating() {
        return consultationRating;
    }

    public void setConsultationRating(ConsultationRating consultationRating) {
        this.consultationRating = consultationRating;
    }

    public RatingModelRequest withConsultationRating(ConsultationRating consultationRating) {
        this.consultationRating = consultationRating;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("consultationRating", consultationRating).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(consultationRating);
    }

    public int describeContents() {
        return 0;
    }

}