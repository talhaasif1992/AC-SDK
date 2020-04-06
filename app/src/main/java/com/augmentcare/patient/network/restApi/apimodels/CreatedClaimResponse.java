package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.model.createClaimsModel.HrUser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreatedClaimResponse implements Parcelable {

    @SerializedName("claim")
    @Expose
    private DigitalClaim claim;

    @SerializedName("notification")
    @Expose
    private Notification notification;

    @SerializedName("hr_user")
    @Expose
    private HrUser hrUser;
    public final static Parcelable.Creator<CreatedClaimResponse> CREATOR = new Creator<CreatedClaimResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreatedClaimResponse createFromParcel(Parcel in) {
            return new CreatedClaimResponse(in);
        }

        public CreatedClaimResponse[] newArray(int size) {
            return (new CreatedClaimResponse[size]);
        }

    };

    protected CreatedClaimResponse(Parcel in) {
        this.claim = ((DigitalClaim) in.readValue((DigitalClaim.class.getClassLoader())));
        this.notification = ((Notification) in.readValue((Notification.class.getClassLoader())));
        this.hrUser = ((HrUser) in.readValue((HrUser.class.getClassLoader())));
    }

    public CreatedClaimResponse() {
    }

    public DigitalClaim getClaim() {
        return claim;
    }

    public void setClaim(DigitalClaim claim) {
        this.claim = claim;
    }

    public CreatedClaimResponse withClaim(DigitalClaim claim) {
        this.claim = claim;
        return this;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public CreatedClaimResponse withNotification(Notification notification) {
        this.notification = notification;
        return this;
    }

    public HrUser getHrUser() {
        return hrUser;
    }

    public void setHrUser(HrUser hrUser) {
        this.hrUser = hrUser;
    }

    public CreatedClaimResponse withHrUser(HrUser hrUser) {
        this.hrUser = hrUser;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("claim", claim).append("notification", notification).append("hrUser", hrUser).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(claim);
        dest.writeValue(notification);
        dest.writeValue(hrUser);
    }

    public int describeContents() {
        return 0;
    }

}