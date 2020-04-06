package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LabsAvailabilityResponse implements Parcelable
{

@SerializedName("success")
@Expose
private Boolean success;
@SerializedName("results")
@Expose
private LabAvailResult results;
public final static Parcelable.Creator<LabsAvailabilityResponse> CREATOR = new Creator<LabsAvailabilityResponse>() {


@SuppressWarnings({
"unchecked"
})
public LabsAvailabilityResponse createFromParcel(Parcel in) {
return new LabsAvailabilityResponse(in);
}

public LabsAvailabilityResponse[] newArray(int size) {
return (new LabsAvailabilityResponse[size]);
}

}
;

protected LabsAvailabilityResponse(Parcel in) {
this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
this.results = ((LabAvailResult) in.readValue((LabAvailResult.class.getClassLoader())));
}

public LabsAvailabilityResponse() {
}

public Boolean getSuccess() {
return success;
}

public void setSuccess(Boolean success) {
this.success = success;
}

public LabsAvailabilityResponse withSuccess(Boolean success) {
this.success = success;
return this;
}

public LabAvailResult getResults() {
return results;
}

public void setResults(LabAvailResult results) {
this.results = results;
}

public LabsAvailabilityResponse withResults(LabAvailResult results) {
this.results = results;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("success", success).append("results", results).toString();
}

public void writeToParcel(Parcel dest, int flags) {
dest.writeValue(success);
dest.writeValue(results);
}

public int describeContents() {
return 0;
}

}