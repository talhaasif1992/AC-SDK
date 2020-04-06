
package com.augmentcare.patient.model.doctorDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("print")
    @Expose
    private Print print;
    @SerializedName("vitals_additional")
    @Expose
    private List<VitalsAdditional> vitalsAdditional = null;
    @SerializedName("default_vitals_to_hide")
    @Expose
    private List<String> defaultVitalsToHide = null;
    @SerializedName("notes_hidden")
    @Expose
    private List<String> notesHidden = null;
    @SerializedName("complications")
    @Expose
    private Complications complications;
    @SerializedName("hide_upper_portion")
    @Expose
    private Boolean hideUpperPortion;
    @SerializedName("show_four_diagnosis_box")
    @Expose
    private Boolean showFourDiagnosisBox;

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public List<VitalsAdditional> getVitalsAdditional() {
        return vitalsAdditional;
    }

    public void setVitalsAdditional(List<VitalsAdditional> vitalsAdditional) {
        this.vitalsAdditional = vitalsAdditional;
    }

    public List<String> getDefaultVitalsToHide() {
        return defaultVitalsToHide;
    }

    public void setDefaultVitalsToHide(List<String> defaultVitalsToHide) {
        this.defaultVitalsToHide = defaultVitalsToHide;
    }

    public List<String> getNotesHidden() {
        return notesHidden;
    }

    public void setNotesHidden(List<String> notesHidden) {
        this.notesHidden = notesHidden;
    }

    public Complications getComplications() {
        return complications;
    }

    public void setComplications(Complications complications) {
        this.complications = complications;
    }

    public Boolean getHideUpperPortion() {
        return hideUpperPortion;
    }

    public void setHideUpperPortion(Boolean hideUpperPortion) {
        this.hideUpperPortion = hideUpperPortion;
    }

    public Boolean getShowFourDiagnosisBox() {
        return showFourDiagnosisBox;
    }

    public void setShowFourDiagnosisBox(Boolean showFourDiagnosisBox) {
        this.showFourDiagnosisBox = showFourDiagnosisBox;
    }

}
