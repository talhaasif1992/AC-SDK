package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 22/08/2017.
 */

public class Rating implements Parcelable{
    private long id;
    @SerializedName("docter_id")
    private long docterId;
    @SerializedName("send_prescription")
    private String sendPrescription;
    @SerializedName("start_appointment")
    private String startAppointment;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("rating_count")
    private int ratingCount;
    @SerializedName("average_ratings")
    private String averageRatings;
    @SerializedName("audio_video")
    private String audioVideo;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("condition_treatment")
    private String conditionTreatment;

    protected Rating(Parcel in) {
        id = in.readLong();
        docterId = in.readLong();
        sendPrescription = in.readString();
        startAppointment = in.readString();
        updatedAt = in.readString();
        ratingCount = in.readInt();
        averageRatings = in.readString();
        audioVideo = in.readString();
        createdAt = in.readString();
        conditionTreatment = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(docterId);
        dest.writeString(sendPrescription);
        dest.writeString(startAppointment);
        dest.writeString(updatedAt);
        dest.writeInt(ratingCount);
        dest.writeString(averageRatings);
        dest.writeString(audioVideo);
        dest.writeString(createdAt);
        dest.writeString(conditionTreatment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocterId() {
        return docterId;
    }

    public void setDocterId(long docterId) {
        this.docterId = docterId;
    }

    public String getSendPrescription() {
        return sendPrescription;
    }

    public void setSendPrescription(String sendPrescription) {
        this.sendPrescription = sendPrescription;
    }

    public String getStartAppointment() {
        return startAppointment;
    }

    public void setStartAppointment(String startAppointment) {
        this.startAppointment = startAppointment;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(String averageRatings) {
        this.averageRatings = averageRatings;
    }

    public String getAudioVideo() {
        return audioVideo;
    }

    public void setAudioVideo(String audioVideo) {
        this.audioVideo = audioVideo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getConditionTreatment() {
        return conditionTreatment;
    }

    public void setConditionTreatment(String conditionTreatment) {
        this.conditionTreatment = conditionTreatment;
    }
}