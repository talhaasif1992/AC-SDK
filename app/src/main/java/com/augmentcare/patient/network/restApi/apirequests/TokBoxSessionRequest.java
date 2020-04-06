package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TokBoxSessionRequest implements Parcelable {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("key")
    @Expose
    private String userLoginChannel;
    @SerializedName("doctor_role_id")
    @Expose
    private long doctorRoleId;
    @SerializedName("patient_role_id")
    @Expose
    private long patientRoleId;
    @SerializedName("slot_id")
    @Expose
    private long slotId;
    @SerializedName("call_info")
    @Expose
    private UserDataLogin callInfo;

    public final static Parcelable.Creator<TokBoxSessionRequest> CREATOR = new Creator<TokBoxSessionRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TokBoxSessionRequest createFromParcel(Parcel in) {
            return new TokBoxSessionRequest(in);
        }

        public TokBoxSessionRequest[] newArray(int size) {
            return (new TokBoxSessionRequest[size]);
        }

    };

    protected TokBoxSessionRequest(Parcel in) {
        this.uid = ((String) in.readValue((String.class.getClassLoader())));
        this.userLoginChannel = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorRoleId = ((int) in.readValue((int.class.getClassLoader())));
        this.patientRoleId = ((int) in.readValue((int.class.getClassLoader())));
        this.slotId = ((int) in.readValue((int.class.getClassLoader())));
    }

    public TokBoxSessionRequest() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public TokBoxSessionRequest withUid(String uid) {
        this.uid = uid;
        return this;
    }
    public String getUserLoginChannel() {
        return userLoginChannel;
    }

    public void setUserLoginChannel(String userLoginChannel) {
        this.userLoginChannel = userLoginChannel;
    }

    public TokBoxSessionRequest withUserLoginChannel(String userLoginChannel) {
        this.userLoginChannel = userLoginChannel;
        return this;
    }

    public UserDataLogin getCallInfo() {
        return callInfo;
    }

    public void setCallInfo(UserDataLogin callInfo) {
        this.callInfo = callInfo;
    }

    public TokBoxSessionRequest withCallInfo(UserDataLogin callInfo) {
        this.callInfo = callInfo;
        return this;
    }

    public long getDoctorRoleId() {
        return doctorRoleId;
    }

    public void setDoctorRoleId(long doctorRoleId) {
        this.doctorRoleId = doctorRoleId;
    }

    public TokBoxSessionRequest withDoctorRoleId(long doctorRoleId) {
        this.doctorRoleId = doctorRoleId;
        return this;
    }

    public long getPatientRoleId() {
        return patientRoleId;
    }

    public void setPatientRoleId(long patientRoleId) {
        this.patientRoleId = patientRoleId;
    }

    public TokBoxSessionRequest withPatientRoleId(long patientRoleId) {
        this.patientRoleId = patientRoleId;
        return this;
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public TokBoxSessionRequest withSlotId(int slotId) {
        this.slotId = slotId;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("uid", uid).append("doctorRoleId", doctorRoleId).append("patientRoleId", patientRoleId).append("slotId", slotId).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(uid);
        dest.writeValue(doctorRoleId);
        dest.writeValue(patientRoleId);
        dest.writeValue(slotId);
    }

    public int describeContents() {
        return 0;
    }

}