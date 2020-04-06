
package com.augmentcare.patient.model.doctorDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Complications {

    @SerializedName("checkboxes")
    @Expose
    private Boolean checkboxes;
    @SerializedName("options")
    @Expose
    private List<String> options = null;

    public Boolean getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(Boolean checkboxes) {
        this.checkboxes = checkboxes;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

}
