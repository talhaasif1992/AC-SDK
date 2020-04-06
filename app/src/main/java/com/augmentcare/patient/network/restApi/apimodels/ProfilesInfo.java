package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProfilesInfo implements Parcelable {

    @SerializedName("profiles")
    @Expose
    private List<Profile> profiles = new ArrayList<Profile>();
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("email_exists")
    @Expose
    private boolean email_exists;

    public final static Parcelable.Creator<ProfilesInfo> CREATOR = new Creator<ProfilesInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ProfilesInfo createFromParcel(Parcel in) {
            return new ProfilesInfo(in);
        }

        public ProfilesInfo[] newArray(int size) {
            return (new ProfilesInfo[size]);
        }

    };

    protected ProfilesInfo(Parcel in) {
        in.readList(this.profiles, (Profile.class.getClassLoader()));
        this.count = ((int) in.readValue((int.class.getClassLoader())));
        this.email_exists = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public ProfilesInfo() {
    }

    /**
     * @param profiles
     * @param count
     * @param email_exists
     */
    public ProfilesInfo(List<Profile> profiles, int count, boolean email_exists){
        super();
        this.profiles = profiles;
        this.count = count;
        this.email_exists = email_exists;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public ProfilesInfo withProfiles(List<Profile> profiles) {
        this.profiles = profiles;
        return this;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProfilesInfo withCount(int count) {
        this.count = count;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(profiles);
        dest.writeValue(count);
        dest.writeValue(email_exists);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isEmail_exists() {
        return email_exists;
    }

    public void setEmail_exists(boolean email_exists) {
        this.email_exists = email_exists;
    }
}