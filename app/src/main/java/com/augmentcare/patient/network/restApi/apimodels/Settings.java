package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.model.doctorDetails.VitalsAdditional;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Settings implements Parcelable
{

    @SerializedName("print")
    @Expose
    private Print print;
    @SerializedName("vitals_additional")
    @Expose
    private List<VitalsAdditional> vitalsAdditional = new ArrayList<VitalsAdditional>();
    @SerializedName("default_vitals_to_hide")
    @Expose
    private List<String> defaultVitalsToHide = new ArrayList<String>();
    @SerializedName("notes_hidden")
    @Expose
    private List<String> notesHidden;
//    @SerializedName("custom_fields")
//    @Expose
//    private List<CustomField> customFields = new ArrayList<CustomField>();
    @SerializedName("pdf_template")
    @Expose
    private String pdfTemplate;
    @SerializedName("not_print_default_header")
    @Expose
    private boolean notPrintDefaultHeader;
    @SerializedName("prescription_header")
    @Expose
    private String prescriptionHeader;
    @SerializedName("prescription_footer")
    @Expose
    private String prescriptionFooter;
    @SerializedName("pdf_font")
    @Expose
    private PdfFont pdfFont;
    public final static Parcelable.Creator<Settings> CREATOR = new Creator<Settings>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        public Settings[] newArray(int size) {
            return (new Settings[size]);
        }

    }
            ;

    protected Settings(Parcel in) {
        this.print = ((Print) in.readValue((Print.class.getClassLoader())));
        in.readList(this.vitalsAdditional, (VitalsAdditional.class.getClassLoader()));
        in.readList(this.defaultVitalsToHide, (java.lang.String.class.getClassLoader()));
        in.readList(this.notesHidden, (String.class.getClassLoader()));
//        in.readList(this.customFields, (com.augmentcare.patient.network.restApi.apimodels.CustomField.class.getClassLoader()));
        this.pdfTemplate = ((String) in.readValue((String.class.getClassLoader())));
        this.notPrintDefaultHeader = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.prescriptionHeader = ((String) in.readValue((String.class.getClassLoader())));
        this.prescriptionFooter = ((String) in.readValue((String.class.getClassLoader())));
        this.pdfFont = ((PdfFont) in.readValue((PdfFont.class.getClassLoader())));
    }

    public Settings() {
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public Settings withPrint(Print print) {
        this.print = print;
        return this;
    }

    public List<VitalsAdditional> getVitalsAdditional() {
        return vitalsAdditional;
    }

    public void setVitalsAdditional(List<VitalsAdditional> vitalsAdditional) {
        this.vitalsAdditional = vitalsAdditional;
    }

    public Settings withVitalsAdditional(List<VitalsAdditional> vitalsAdditional) {
        this.vitalsAdditional = vitalsAdditional;
        return this;
    }

    public List<String> getDefaultVitalsToHide() {
        return defaultVitalsToHide;
    }

    public void setDefaultVitalsToHide(List<String> defaultVitalsToHide) {
        this.defaultVitalsToHide = defaultVitalsToHide;
    }

    public Settings withDefaultVitalsToHide(List<String> defaultVitalsToHide) {
        this.defaultVitalsToHide = defaultVitalsToHide;
        return this;
    }

    public List<String> getNotesHidden() {
        return notesHidden;
    }

    public void setNotesHidden(List<String> notesHidden) {
        this.notesHidden = notesHidden;
    }

    public Settings withNotesHidden(List<String> notesHidden) {
        this.notesHidden = notesHidden;
        return this;
    }

//    public List<CustomField> getCustomFields() {
//        return customFields;
//    }
//
//    public void setCustomFields(List<CustomField> customFields) {
//        this.customFields = customFields;
//    }
//
//    public Settings withCustomFields(List<CustomField> customFields) {
//        this.customFields = customFields;
//        return this;
//    }

    public String getPdfTemplate() {
        return pdfTemplate;
    }

    public void setPdfTemplate(String pdfTemplate) {
        this.pdfTemplate = pdfTemplate;
    }

    public Settings withPdfTemplate(String pdfTemplate) {
        this.pdfTemplate = pdfTemplate;
        return this;
    }

    public boolean isNotPrintDefaultHeader() {
        return notPrintDefaultHeader;
    }

    public void setNotPrintDefaultHeader(boolean notPrintDefaultHeader) {
        this.notPrintDefaultHeader = notPrintDefaultHeader;
    }

    public Settings withNotPrintDefaultHeader(boolean notPrintDefaultHeader) {
        this.notPrintDefaultHeader = notPrintDefaultHeader;
        return this;
    }

    public String getPrescriptionHeader() {
        return prescriptionHeader;
    }

    public void setPrescriptionHeader(String prescriptionHeader) {
        this.prescriptionHeader = prescriptionHeader;
    }

    public Settings withPrescriptionHeader(String prescriptionHeader) {
        this.prescriptionHeader = prescriptionHeader;
        return this;
    }

    public String getPrescriptionFooter() {
        return prescriptionFooter;
    }

    public void setPrescriptionFooter(String prescriptionFooter) {
        this.prescriptionFooter = prescriptionFooter;
    }

    public Settings withPrescriptionFooter(String prescriptionFooter) {
        this.prescriptionFooter = prescriptionFooter;
        return this;
    }

    public PdfFont getPdfFont() {
        return pdfFont;
    }

    public void setPdfFont(PdfFont pdfFont) {
        this.pdfFont = pdfFont;
    }

    public Settings withPdfFont(PdfFont pdfFont) {
        this.pdfFont = pdfFont;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("print", print)
                .append("vitalsAdditional", vitalsAdditional)
                .append("defaultVitalsToHide", defaultVitalsToHide)
                .append("notesHidden", notesHidden)
//                .append("customFields", customFields)
                .append("pdfTemplate", pdfTemplate).append("notPrintDefaultHeader", notPrintDefaultHeader).append("prescriptionHeader", prescriptionHeader).append("prescriptionFooter", prescriptionFooter).append("pdfFont", pdfFont).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(print);
        dest.writeList(vitalsAdditional);
        dest.writeList(defaultVitalsToHide);
        dest.writeValue(notesHidden);
//        dest.writeList(customFields);
        dest.writeValue(pdfTemplate);
        dest.writeValue(notPrintDefaultHeader);
        dest.writeValue(prescriptionHeader);
        dest.writeValue(prescriptionFooter);
        dest.writeValue(pdfFont);
    }

    public int describeContents() {
        return 0;
    }

}