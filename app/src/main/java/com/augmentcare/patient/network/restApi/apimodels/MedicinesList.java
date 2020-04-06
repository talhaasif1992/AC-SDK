package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class MedicinesList implements Parcelable {

    @SerializedName("medicines")
    @Expose
    private List<Medicine> medicines = new ArrayList<Medicine>();
    @SerializedName("total_records")
    @Expose
    private Integer totalRecords;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("errors")
    @Expose
    private List<String> errors = new ArrayList<String>();
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<MedicinesList> CREATOR = new Creator<MedicinesList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MedicinesList createFromParcel(Parcel in) {
            return new MedicinesList(in);
        }

        public MedicinesList[] newArray(int size) {
            return (new MedicinesList[size]);
        }

    };

    protected MedicinesList(Parcel in) {
        in.readList(this.medicines, (com.augmentcare.patient.network.restApi.apimodels.Medicine.class.getClassLoader()));
        this.totalRecords = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.errors, (java.lang.String.class.getClassLoader()));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public MedicinesList() {
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public MedicinesList withMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
        return this;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public MedicinesList withTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public MedicinesList withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public MedicinesList withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public MedicinesList withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public MedicinesList withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("medicines", medicines).append("totalRecords", totalRecords).append("totalPages", totalPages).append("currentPage", currentPage).append("errors", errors).append("success", success).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(medicines);
        dest.writeValue(totalRecords);
        dest.writeValue(totalPages);
        dest.writeValue(currentPage);
        dest.writeList(errors);
        dest.writeValue(success);
    }

    public int describeContents() {
        return 0;
    }

}