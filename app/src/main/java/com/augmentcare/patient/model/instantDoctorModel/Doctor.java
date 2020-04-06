
package com.augmentcare.patient.model.instantDoctorModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doctor {

    @SerializedName("docter")
    @Expose
    private Docter docter;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("specializations")
    @Expose
    private List<Specialization> specializations = null;

    public Docter getDocter() {
        return docter;
    }

    public void setDocter(Docter docter) {
        this.docter = docter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

}
