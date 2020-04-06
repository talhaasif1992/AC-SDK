package com.augmentcare.patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Prescribed {
    public List<PrescribedModel> getHits() {
        return hits;
    }

    public void setHits(List<PrescribedModel> hits) {
        this.hits = hits;
    }

    @SerializedName("hits")
    @Expose
    List<PrescribedModel> hits;

}
