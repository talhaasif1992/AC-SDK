package com.augmentcare.patient.model;

public class UploadPrescriptionModel {
    String name;
    String save_prescription;
    String url;
    String file_name;
    String file_content_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSave_prescription() {
        return save_prescription;
    }

    public void setSave_prescription(String save_prescription) {
        this.save_prescription = save_prescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_content_type() {
        return file_content_type;
    }

    public void setFile_content_type(String file_content_type) {
        this.file_content_type = file_content_type;
    }
}
