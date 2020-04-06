package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AddDependentResponse extends ErrorsResponse implements Parcelable {

    @SerializedName("notification")
    @Expose
    private String notification;
    @SerializedName("hr_user")
    @Expose
    private String hrUser;
    @SerializedName("dependent")
    @Expose
    private User dependent;
    @SerializedName("dependent_info")
    @Expose
    private Profile dependentInfo;
    public final static Parcelable.Creator<AddDependentResponse> CREATOR = new Creator<AddDependentResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AddDependentResponse createFromParcel(Parcel in) {
            return new AddDependentResponse(in);
        }

        public AddDependentResponse[] newArray(int size) {
            return (new AddDependentResponse[size]);
        }

    };

    protected AddDependentResponse(Parcel in) {
        this.notification = ((String) in.readValue((String.class.getClassLoader())));
        this.hrUser = ((String) in.readValue((String.class.getClassLoader())));
        this.dependent = ((User) in.readValue((User.class.getClassLoader())));
        this.dependentInfo = ((Profile) in.readValue((Profile.class.getClassLoader())));
    }

    public AddDependentResponse() {
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public AddDependentResponse withNotification(String notification) {
        this.notification = notification;
        return this;
    }

    public String getHrUser() {
        return hrUser;
    }

    public void setHrUser(String hrUser) {
        this.hrUser = hrUser;
    }

    public AddDependentResponse withHrUser(String hrUser) {
        this.hrUser = hrUser;
        return this;
    }

    public User getDependent() {
        return dependent;
    }

    public void setDependent(User dependent) {
        this.dependent = dependent;
    }

    public AddDependentResponse withDependent(User dependent) {
        this.dependent = dependent;
        return this;
    }

    public Profile getDependentInfo() {
        return dependentInfo;
    }

    public void setDependentInfo(Profile dependentInfo) {
        this.dependentInfo = dependentInfo;
    }

    public AddDependentResponse withDependentInfo(Profile dependentInfo) {
        this.dependentInfo = dependentInfo;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("notification", notification).append("hrUser", hrUser).append("dependent", dependent).append("dependentInfo", dependentInfo).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(notification);
        dest.writeValue(hrUser);
        dest.writeValue(dependent);
        dest.writeValue(dependentInfo);
    }

    public int describeContents() {
        return 0;
    }

}