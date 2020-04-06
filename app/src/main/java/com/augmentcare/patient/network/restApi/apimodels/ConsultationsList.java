package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ConsultationsList implements Parcelable {

    @SerializedName("data")
    @Expose
    private List<Consultation> data = new ArrayList<Consultation>();
    @SerializedName("total_records")
    @Expose
    private Integer totalRecords;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<ConsultationsList> CREATOR = new Creator<ConsultationsList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ConsultationsList createFromParcel(Parcel in) {
            return new ConsultationsList(in);
        }

        public ConsultationsList[] newArray(int size) {
            return (new ConsultationsList[size]);
        }

    };

    protected ConsultationsList(Parcel in) {
        in.readList(this.data, (Consultation.class.getClassLoader()));
        this.totalRecords = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public ConsultationsList() {
    }

    public List<Consultation> getData() {
        return data;
    }

    public void setData(List<Consultation> data) {
        this.data = data;
    }

    public ConsultationsList withData(List<Consultation> data) {
        this.data = data;
        return this;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public ConsultationsList withTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ConsultationsList withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public ConsultationsList withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ConsultationsList withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("totalRecords", totalRecords).append("totalPages", totalPages).append("currentPage", currentPage).append("success", success).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(totalRecords);
        dest.writeValue(totalPages);
        dest.writeValue(currentPage);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}