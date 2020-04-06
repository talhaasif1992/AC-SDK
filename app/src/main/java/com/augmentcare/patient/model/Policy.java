package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 24/12/2017.
 */

public class Policy implements Parcelable{
    private String created_by;

    private String id;

    private String updated_at;

    private String organization_id;

    private String name;

    private String op_allowance;

    private String created_at;
    private boolean is_unlimited;
    private String is_pharmacy_allowed;
    private String start_date;
    private String end_date;

    protected Policy(Parcel in) {
        created_by = in.readString();
        id = in.readString();
        updated_at = in.readString();
        organization_id = in.readString();
        name = in.readString();
        op_allowance = in.readString();
        created_at = in.readString();
        is_unlimited = in.readByte() != 0;
        is_pharmacy_allowed = in.readString();
        start_date = in.readString();
        end_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created_by);
        dest.writeString(id);
        dest.writeString(updated_at);
        dest.writeString(organization_id);
        dest.writeString(name);
        dest.writeString(op_allowance);
        dest.writeString(created_at);
        dest.writeByte((byte) (is_unlimited ? 1 : 0));
        dest.writeString(is_pharmacy_allowed);
        dest.writeString(start_date);
        dest.writeString(end_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Policy> CREATOR = new Creator<Policy>() {
        @Override
        public Policy createFromParcel(Parcel in) {
            return new Policy(in);
        }

        @Override
        public Policy[] newArray(int size) {
            return new Policy[size];
        }
    };

    public boolean isIs_unlimited() {
        return is_unlimited;
    }

    public void setIs_unlimited(boolean is_unlimited) {
        this.is_unlimited = is_unlimited;
    }

    public String getIs_pharmacy_allowed() {
        return is_pharmacy_allowed;
    }

    public void setIs_pharmacy_allowed(String is_pharmacy_allowed) {
        this.is_pharmacy_allowed = is_pharmacy_allowed;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOp_allowance() {
        return op_allowance;
    }

    public void setOp_allowance(String op_allowance) {
        this.op_allowance = op_allowance;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
