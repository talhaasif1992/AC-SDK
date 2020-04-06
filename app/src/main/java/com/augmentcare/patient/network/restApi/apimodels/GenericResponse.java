package com.augmentcare.patient.network.restApi.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.network.restApi.apimodels.UserCurrentPlan.UserPlans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class GenericResponse implements Parcelable {

    @SerializedName("tests")
    @Expose
    private List<LabTest> labTests = new ArrayList<LabTest>();
    @SerializedName("results")
    @Expose
    private List<String> results = new ArrayList<String>();
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("doctors")
    @Expose
    private List<DoctorInfoLimited> doctorInfoLimitedList;
    @SerializedName("doctor_info")
    @Expose
    private DoctorDetail doctorProfile;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    @SerializedName("payment")
    @Expose
    private Payment payment;

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("user_plans")
    @Expose
    private UserPlans user_plans;


    @SerializedName("html")
    @Expose
    private String html;


    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("list")
    @Expose
    private List<String> list = new ArrayList<String>();
    public final static Parcelable.Creator<GenericResponse> CREATOR = new Creator<GenericResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GenericResponse createFromParcel(Parcel in) {
            return new GenericResponse(in);
        }

        public GenericResponse[] newArray(int size) {
            return (new GenericResponse[size]);
        }

    };

    protected GenericResponse(Parcel in) {
        in.readList(this.labTests, (java.lang.String.class.getClassLoader()));
        in.readList(this.results, (java.lang.String.class.getClassLoader()));
        this.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.html = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorProfile = ((DoctorDetail) in.readValue((DoctorDetail.class.getClassLoader())));
        this.userInfo = ((UserInfo) in.readValue((UserInfo.class.getClassLoader())));
        this.payment = ((Payment) in.readValue((Payment.class.getClassLoader())));
        this.user_plans = ((UserPlans) in.readValue((UserPlans.class.getClassLoader())));
        in.readList(this.list, (java.lang.String.class.getClassLoader()));
        in.readList(this.doctorInfoLimitedList, (DoctorInfoLimited.class.getClassLoader()));
        in.readList(this.doctorInfoLimitedList, (DoctorInfoLimited.class.getClassLoader()));
    }

    public GenericResponse() {
    }

    public List<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
    }

    public GenericResponse withLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
        return this;
    }
    public List<DoctorInfoLimited> getDoctorInfoLimitedList() {
        return doctorInfoLimitedList;
    }

    public void setDoctorInfoLimitedList(List<DoctorInfoLimited> doctorInfoLimitedList) {
        this.doctorInfoLimitedList = doctorInfoLimitedList;
    }

    public GenericResponse withDoctorInfoLimitedList(List<DoctorInfoLimited> doctorInfoLimitedList) {
        this.doctorInfoLimitedList = doctorInfoLimitedList;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public GenericResponse withResults(List<String> results) {
        this.results = results;
        return this;
    }
    public GenericResponse withMessage(String message) {
        this.message = message;
        return this;
    }
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public GenericResponse withUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

 public GenericResponse withPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public DoctorDetail getDoctorDetail() {
        return doctorProfile;
    }

    public void setDoctorDetail(DoctorDetail doctorProfile) {
        this.doctorProfile = doctorProfile;
    }

    public GenericResponse withDoctorDetail(DoctorDetail doctorProfile) {
        this.doctorProfile = doctorProfile;
        return this;
    }
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public GenericResponse withOrder(Integer order) {
        this.order = order;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public GenericResponse withSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public GenericResponse withHtml(String html) {
        this.html = html;
        return this;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public GenericResponse withList(List<String> list) {
        this.list = list;
        return this;
    }

    public UserPlans getUser_plans() {
        return user_plans;
    }

    public void setUser_plans(UserPlans user_plans) {
        this.user_plans = user_plans;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("labTests", labTests).append("results", results).append("order", order).append("success", success).append("html", html).append("list", list).append("doctorInfoLimitedList", doctorInfoLimitedList).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(labTests);
        dest.writeList(results);
        dest.writeValue(order);
        dest.writeValue(success);
        dest.writeValue(html);
        dest.writeList(list);
        dest.writeList(doctorInfoLimitedList);
    }

    public int describeContents() {
        return 0;
    }

}