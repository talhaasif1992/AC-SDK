package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ConsultationRating implements Parcelable {

    @SerializedName("slot_id")
    @Expose
    private String slotId;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rating_comments")
    @Expose
    private String ratingComments;
    public final static Parcelable.Creator<ConsultationRating> CREATOR = new Creator<ConsultationRating>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ConsultationRating createFromParcel(Parcel in) {
            return new ConsultationRating(in);
        }

        public ConsultationRating[] newArray(int size) {
            return (new ConsultationRating[size]);
        }

    };

    protected ConsultationRating(Parcel in) {
        this.slotId = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((String) in.readValue((String.class.getClassLoader())));
        this.ratingComments = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ConsultationRating() {
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public ConsultationRating withSlotId(String slotId) {
        this.slotId = slotId;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ConsultationRating withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getRatingComments() {
        return ratingComments;
    }

    public void setRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
    }

    public ConsultationRating withRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("slotId", slotId).append("rating", rating).append("ratingComments", ratingComments).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slotId);
        dest.writeValue(rating);
        dest.writeValue(ratingComments);
    }

    public int describeContents() {
        return 0;
    }

}