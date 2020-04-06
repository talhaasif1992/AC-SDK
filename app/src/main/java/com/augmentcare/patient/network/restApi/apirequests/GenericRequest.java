package com.augmentcare.patient.network.restApi.apirequests;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.network.restApi.apimodels.UserPlans.UserPlans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class GenericRequest implements Parcelable {

    @SerializedName("appointment_time")
    @Expose
    private String appointmentTime;
    @SerializedName("dependent_id")
    @Expose
    private String dependentID;
    @SerializedName("order_id")
    @Expose
    private String orderID;
    @SerializedName("doctor_id")
    @Expose
    private int doctorId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("quantity_pack")
    @Expose
    private String quantityPack;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tests")
    @Expose
    private List<Integer> tests = new ArrayList<Integer>();
    @SerializedName("uploaded_files")
    @Expose
    private List<String> listOfString = new ArrayList<String>();
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("slot_status")
    @Expose
    private String slotStatus;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("user_plans")
    @Expose
    private UserPlans userplan;

//    @SerializedName("user_role_id")
//    @Expose
//    private int userRoleId;


    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("user_role_id")
    @Expose
    private int userRoleID;
    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("part_of_project")
    @Expose
    private String part_of_project;

    @SerializedName("user_plan_id")
    @Expose
    private int user_plan_id;


    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("password_confirmation")
    @Expose
    private String passwordConfirmation;

    public final static Parcelable.Creator<GenericRequest> CREATOR = new Creator<GenericRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GenericRequest createFromParcel(Parcel in) {
            return new GenericRequest(in);
        }

        public GenericRequest[] newArray(int size) {
            return (new GenericRequest[size]);
        }

    };

    protected GenericRequest(Parcel in) {
        in.readList(this.tests, (java.lang.Integer.class.getClassLoader()));
        this.area = ((String) in.readValue((String.class.getClassLoader())));
        this.dependentID = ((String) in.readValue((String.class.getClassLoader())));
        this.orderID = ((String) in.readValue((String.class.getClassLoader())));
        this.appointmentTime = ((String) in.readValue((String.class.getClassLoader())));
        this.doctorId = ((int) in.readValue((int.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.quantityPack = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.listOfString, (String.class.getClassLoader()));
        this.slotStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.page = ((int) in.readValue((int.class.getClassLoader())));
        this.perPage = ((int) in.readValue((int.class.getClassLoader())));
        this.userRoleID = ((int) in.readValue((int.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.passwordConfirmation = ((String) in.readValue((String.class.getClassLoader())));
        this.userplan = ((UserPlans) in.readValue((UserPlans.class.getClassLoader())));
        this.part_of_project = ((String) in.readValue((String.class.getClassLoader())));
        this.user_plan_id = ((int) in.readValue((String.class.getClassLoader())));

    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(tests);
        dest.writeValue(area);
        dest.writeValue(dependentID);
        dest.writeValue(orderID);
        dest.writeValue(appointmentTime);
        dest.writeValue(doctorId);
        dest.writeValue(id);
        dest.writeValue(quantityPack);
        dest.writeValue(type);
        dest.writeList(listOfString);
        dest.writeValue(slotStatus);
        dest.writeValue(page);
        dest.writeValue(perPage);
        dest.writeValue(userRoleID);
        dest.writeValue(token);
        dest.writeValue(password);
        dest.writeValue(passwordConfirmation);
        dest.writeValue(user_plan_id);
    }

    public int getUserRoleId() {
        return userRoleID;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleID = userRoleId;
    }

    public int getUser_plan_id() {
        return user_plan_id;
    }

    public void setUser_plan_id(int user_plan_id) {
        this.user_plan_id = user_plan_id;
    }

    public GenericRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenericRequest withPassword(String password){
        this.password = password;
        return this;
    }
    public GenericRequest withUserPlanId(int user_plan_id){
        this.user_plan_id = user_plan_id;
        return this;
    }

    public UserPlans getUserplan() {
        return userplan;
    }

    public void setUserplan(UserPlans userplan) {
        this.userplan = userplan;
    }

    public GenericRequest withUserplan(UserPlans userplan){
        this.userplan = userplan;
        return this;
    }

    public String getPart_of_project() {
        return part_of_project;
    }

    public void setPart_of_project(String part_of_project) {
        this.part_of_project = part_of_project;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    public GenericRequest withPasswordConfirmation(String passwordConfirmation){
        this.passwordConfirmation = passwordConfirmation;
        return this;
    }

    public GenericRequest withPart_of_project(String part_of_project){
        this.part_of_project = part_of_project;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public GenericRequest withToken(String token){
        this.token = token;
        return this;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    public GenericRequest withSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
        return this;
    }
    public GenericRequest withUserRoleId(int userRoleId) {
        this.userRoleID = userRoleId;
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public GenericRequest withPage(int page) {
        this.page = page;
        return this;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public GenericRequest withPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public List<String> getListOfStrings() {
        return listOfString;
    }

    public void setListOfStrings(List<String> listOfString) {
        this.listOfString = listOfString;
    }

    public GenericRequest withListOfStrings(List<String> listOfString) {
        this.listOfString = listOfString;
        return this;
    }
    public List<Integer> getTests() {
        return tests;
    }

    public void setTests(List<Integer> tests) {
        this.tests = tests;
    }

    public GenericRequest withTests(List<Integer> tests) {
        this.tests = tests;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public GenericRequest withArea(String area) {
        this.area = area;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenericRequest withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getQuantityPack() {
        return quantityPack;
    }

    public void setQuantityPack(String quantityPack) {
        this.quantityPack = quantityPack;
    }

    public GenericRequest withQuantityPack(String quantityPack) {
        this.quantityPack = quantityPack;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GenericRequest withType(String type) {
        this.type = type;
        return this;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public GenericRequest withAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
        return this;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public GenericRequest withDoctorId(int doctorId) {
        this.doctorId = doctorId;
        return this;
    }
    public String getDependentID() {
        return dependentID;
    }

    public void setDependentID(String dependentID) {
        this.dependentID = dependentID;
    }

    public GenericRequest withDependentID(String dependentID) {
        this.dependentID = dependentID;
        return this;
    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public GenericRequest withOrderID(String orderID) {
        this.orderID = orderID;
        return this;
    }
    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public GenericRequest withUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
        return this;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tests", tests)
                .append("dependentID", dependentID)
                .append("orderID", orderID)
                .append("area", area)
                .append("id", id)
                .append("quantityPack", quantityPack)
                .append("type", type)
                .append("appointmentTime", appointmentTime)
                .append("doctorId", doctorId)
                .toString();
    }



    public int describeContents() {
        return 0;
    }

}