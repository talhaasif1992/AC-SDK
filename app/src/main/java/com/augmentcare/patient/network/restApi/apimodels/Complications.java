
package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Complications implements Parcelable
{

    @SerializedName("checkboxes")
    @Expose
    private String checkboxes;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    public final static Creator<Complications> CREATOR = new Creator<Complications>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Complications createFromParcel(Parcel in) {
            return new Complications(in);
        }

        public Complications[] newArray(int size) {
            return (new Complications[size]);
        }

    }
    ;

    protected Complications(Parcel in) {
        this.checkboxes = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.options, (String.class.getClassLoader()));
    }

    public Complications() {
    }

    public String getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(String checkboxes) {
        this.checkboxes = checkboxes;
    }

    public Complications withCheckboxes(String checkboxes) {
        this.checkboxes = checkboxes;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Complications withOptions(List<String> options) {
        this.options = options;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("checkboxes", checkboxes).append("options", options).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(checkboxes);
        dest.writeList(options);
    }

    public int describeContents() {
        return  0;
    }

}
