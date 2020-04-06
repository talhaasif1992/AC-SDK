
package com.augmentcare.patient.model.createClaimsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("claim")
    @Expose
    private Claim claim;
    @SerializedName("notification")
    @Expose
    private Notification notification;
    @SerializedName("hr_user")
    @Expose
    private HrUser hrUser;

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public HrUser getHrUser() {
        return hrUser;
    }

    public void setHrUser(HrUser hrUser) {
        this.hrUser = hrUser;
    }

}
