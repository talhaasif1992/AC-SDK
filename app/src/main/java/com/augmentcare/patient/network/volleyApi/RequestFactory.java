package com.augmentcare.patient.network.volleyApi;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RequestFactory
{
    public static String BASE_URL = BuildConfig.URL;
    public static String BASE_URL_LIVE = "https://dev.augmentcare.com";
    private static String LOGIN = "/api/v1/auth/sign_in"; // done
    private static String SIGNUP = "/api/v1/auth"; // done
    private static String PASSWORD = "/api/v1/auth/password"; // done
    private static String VERIFY_OTP = "/api/v1/verify_and_confirm"; // done
    private static String CREATE_OTP = "/api/v1/create_code"; // done
    private static String GOOGLE_AUTH = "/api/v1/google_signin"; // done
    private static String VERSION_CHECK = "/api/v1/app_version_check"; //done
    private static String VERSION_CHECK_DOCTOR = "/api/v1/doc_version_check"; //done
    private static String CHECK_FEATURES = "/api/v1//mobile_app_features"; //done
    private static String FORGOT_PASSWORD_GET_PROFILE_BY_PHONE = "/api/v1/users/get_profiles_by_phone"; //done
    private static String CREDIT_CARD_BIN_NUMBERS_API_PATH = "/api/v1/site_settings/get_bin_numbers?partner_name=alfalah"; // done //GET
    private static String RESET_PASSWORD_BY_PHONE = "/api/v1/verify_otp_code_and_set_passwrod"; // done

    //TIME Slots
    private static String UPDATE_TIME_SLOT = "/api/v1/request_slot/update_slot_v2"; //done //POST
    private static String CREATE_TIME_SLOT = "/api/v1/request_slot/create_slot"; //done //POST
    private static String PAY_AND_CREAT_SLOT = "/api/v1/payments/create_payment_and_book_slot"; // done //POST

    //private static String INSTANT_APPOINTMENTS_SLOTS       =   "/api/v1/doctors/instant_doctor?appointment_time="; //POST
    private static String INSTANT_APPOINTMENTS_SLOTS = "/api/v1/doctors/instant_doctor2?appointment_time="; // done //POST
    private static String BOOK_INSTANT_SLOT = "/api/v1/request_slot/book_instant_appointment"; // done //POST
    private static String INSTANT_DOCTOR_INFO = "/api/v1/doctors/instant_doctor_info?appointment_time="; // done //POST
    private static String GET_TIME_SLOT = "/api/v1/request_slot"; //GET ,?slot_id=1

    //GET DOCTOR SLOTS
    private static String GET_DOCTOR_TIME_SLOT = "/api/v1/doctor_slots/available_slots"; // done //GET ,?slot_id=1
    private static String GET_DOCTOR_TIME_WEEKLY_SLOT = "/api/v1/doctor_slots/weekly_slots"; // done //GET ,?slot_id=1

    //APPLY COUPON
    private static String GET_COUPON_CODE = "/api/v1/carts/apply_coupon"; // done //GET ,?slot_id=1

    //Consultations
    private static String GET_ALL_PATIENT_SLOTS = "/api/v1/consultations/getAllPatientSlots"; // done //POST
    private static String ADD_HEALTH_POINT = "/api/v1/health_points/add_new"; // done //POST
    private static String ADD_NOTE = "/api/v1/chat/add_chat_session"; //done //POST

    private static String GET_PEDNING_PATIENT_SLOTS = "/api/v1/consultations/getPendingPatientSlots"; //done //POST
    private static String GET_APPROVED_PATIENT_SLOTS = "/api/v1/consultations/getApprovedPatientSlots"; //done //POST
//    private static String GET_COMPLETED_DOCTOR_SLOTS = "/api/v1/consultations/getCompletedDoctorSlots";//POST
    private static String GET_COMPLETED_PATIENT_SLOTS = "/api/v1/consultations/getCompletedPatientSlots"; //done //POST
    private static String GET_CONSULTATION_DETAILS = "/api/v1/consultations/getConsultationDetails";// done //POST
//    private static String GET_SLOT_OBJECT = "/api/v1/consultations/getSlotObject"; //GET

    private static String GET_DOCTOR_TIME_SLOTS = "/api/v1/doctor_slots"; // done //GET
    private static String GET_ORDER_DETAILS = "/api/v1/order_details/"; // done //GET
    private static String GET_ALL_AREAS = "/api/v1/areas/all"; // done //GET
    private static String CREATE_ORDER = "/api/v1/create_order"; // done //POST
    private static String AUTHENTICATE_OE = "/api/v1/authenticate_oe"; // done //POST

    private static String FINALIZE_ORDER = "/api/v1/finalize_order"; // done //POST
    private static String ADDRESS = "/api/v1/user_addresses"; // done //POST
    private static String REFRESH_TOKEN = "/api/v1/refresh_token"; // done //POST
    private static String SIGN_OUT = "/api/v1/auth/sign_out"; // done //POST
    private static String GET_CONSULTATION = "/api/v1/consultations/get_consultations"; // done //POST
    private static String GET_DOCTOR_PROFILE_DATA = "/api/v1/doctors/get_doctor_profile"; // done //GET
    private static String GET_MEDICINE = "/api/v1/medicines_catalogs"; // done //GET
    private static String UPDATE_MEDICINE_QUANTITY = "/api/v1/carts/update_quantity"; // done //GET
    private static String GET_EXPLORE_DOCTOR = "/api/v1/doctors/list_doctors"; // done //GET
    private static String GET_EXPLORE_FILTER_DOCTOR = "/api/v1/specializations/list_all_dropdown_options"; // done  //GET
    //verify_employee_code,  set_employee_password
    private static String CODE_SIGN_UP_VERIFY_EMPLOYE = "/api/v1/verify_employee_code?code="; // done //GET
    private static String CODE_SIGN_UP_SET_EMPLOY_PASSWORD = "/api/v1/users/set_employee_password"; // done //POST
    //Labs and Pharmacies
    private static String LAB_TESTS = "/api/v1/lab_tests"; // done //POST
    private static String LAB_TEST_ORDERS = "/api/v1/users/%s/orders/lab"; // done // //POST
    private static String LAB_CHECK_LABS = "/api/v1/check_labs"; // done //POST
    private static String ORDER_AND_PAY = "/api/v1/orders/pay_and_order"; // done//POST
    private static String LAB_ORDER_DETAIL = "/api/v1/test_reports?id="; // done //POST
    private static String LAB_REORDER = "/api/v1/orders/re_order?id="; // done //POST
    //Uploads
    public static String UPLOAD_PIC = "/s3_upload?path=profile/images&user_id="; // done //POST
    //Uploads Claim Images
    public static String UPLOAD_CLAIMS_IMAGE = "/api/v1/claims/attach_files"; // done //POST
    // CLAIMS Related
    private static String GET_USER_CLAIMS = "/api/v1/claims?"; // done // user_id=1218 //GET
    private static String GET_CLAIMS_DETAIL = "/api/v1/claims/";  // done // claim_id //GET
    private static String CREATE_CLAIM = "/api/v1/claims"; // done  //POST
    private static String CLAIM_SEND_MESSAGE = "/api/v1/claims/message"; // done  // POST
    //Dependents
    private static String ALL_DEPENDENTS = "/api/v1/all_dependents_type"; // done //GET
    private static String ALL_COVERED_DEPENDENTS = "/api/v1/employees/all_covered_dependents?"; // done //GET, URL Query organization_id=1&user_id=11114
    private static String DEPENDENTS = "/api/v1/users/get_dependents?"; // done //GET, URL Query,user_id=11114
    private static String ADD_DEPENDENT = "/api/v1/users/add_dependents"; // done //POST, {"dependent_type":0,"first_name":"my","last_name":"Mother","dob":"27-11-1969","user_id":11114,"organization_id":1}
    private static String SWITCH_ACCOUNT = "/api/v1/users/switch_account"; //POST , {“user_id”:11118,“dependent_uid”:“aff40f1ade45”}
    private static String SWITCH_TO_PRIMARY = "/api/v1/users/switch_to_primary"; //POST {“user_id”:11118}
    //Corporate
    private static String GET_EMPLOYEE_STATS = "/api/v1/get_employee_stats?"; //GET
    private static String GET_EMPLOYEE_POLICY = "/api/v1/employees/get_policy_detail?"; //GET
    private static String CORPORATE_PAYMENT = "/api/v1/payments/corporate_payment"; //GET
    private static String SHOW_ORGANIZATION = "/api/v1/users/show_organization_option"; //GET
    private static String CHECK_ELIGIBILITY = "/api/v1/employees/eligibilty_check"; //GET
    private static String CORPORATE_PAY_CREAT_SLOT = "/api/v1/payments/corporate_payment_and_book_slot"; //POST
    private static String PAY_BY_INSURANCE = "/api/v1/payments/ice_verification"; //POST
    //Subscription Plans
    private static String SUBSCRIPTION_PLANS = "/api/v1/user_plans"; //GET
    private static String GET_USER_CURRENT_PLANS = "/api/v1/user_plans/get_user_current_plan"; //GET
    private static String SUBSCRIPTION_PAY_AND_PURCHASE = "/api/v1/subscription/payandpurchase"; //POST
    private static String CANCEL_USER_CURRENT_PLAN = "/api/v1/user_plans/cancel_subscription"; //POST
    //Doctors
    private static String GET_DOCTOR_INFO_FROM_USER_ID = "/api/v1/doctors/get_doctor_info_from_user_id"; //POST
    private static String GET_DOCTOR_INFO_FROM_USER_NAME = "/api/v1/docetors/get_doctor_info_from_user_nam"; //POST
    private static String GET_DOCTOR = "/api/v1/doctors/get_docter";//POST
    private static String GET_DOCTOR_PROFILE = "/api/v1/doctors/get_docter_profile"; //POST
    private static String GET_DOCTOR_SLOT_DURATION = "/api/v1/doctors/get_docter_slot_duration";  //GET
    private static String GET_DOCTOR_VACATIONS = "/api/v1/doctors/get_doctor_vacations"; //GET
    private static String GET_FEATURED_DOCTORS = "/api/v1/doctors/featured_doctors"; //GET
    private static String ARE_YOU_DOCTOR = "/api/v1/users/are_you_doctor"; //POST
    //Doctors
    private static String FIND_CONTACTS = "/api/v1/users/find_contacts";//POST
    private static String FIND_DOCTORS = "/api/v1/users/find_doctors"; //GET
    private static String SET_PART_OF_PROJECT = "/api/v1/users/update_user_part_of_project"; //POST
    private static String GET_DOCTORS = "/api/v1/users/get_doctors"; //GET
    private static String GET_ALL_DOCTORS = "/api/v1/users/get_all_doctors"; //GET
    private static String UPDATE_USER_INFORMATION = "/api/v1/users/update_user_information"; //done //PUT
    private static String GET_USER_INFO_FROM_ROLE_ID = "/api/v1/users/get_user_info_from_role_id";// POST
    //Video
    private static String GET_VIDEO_CHAT_SESSION = "/api/v1/chat/session";
    private static String UPDATE_CONSULTATION_STATUS = "/api/v1/consultations/updateStatus";
    //Get Offline Counter
    private static String GET_OFFLINE_COUNTER = "/api/v1/notifications/offline_counter";
    //Address Cities
    private static String GET_ALL_CITIES = "/api/v1/cities/all";
    //Dependents
    private static String GET_ALL_DEPENDENTS = "/api/v1/dependants"; // GET (Amaan)
    private static String UPDATE_DEPENDENTS = "/api/v1/dependants/"; //POST (Amaan)

    //Chat
    private static String GET_CHAT_ID = "/api/v1/chat/get_chat_id"; // GET (Amaan)
    private static String GET_CHAT_LINES = "/api/v1/chat/get_chat_lines"; // GET (Amaan)
    private static String ADD_CHAT_LINE = "/api/v1/chat/add_chat_lines"; // POST (Amaan)
    private static String GET_CHAT_DATA = "/api/v1/chat/get_chat_data"; // GET (Amaan)
    private static String GET_ROLE_ID = "/api/v1/users/get_role_id"; // GET (Amaan)
    // Patient All orders
    private static String GET_USER_ADDRESS = "/api/v1/user_addresses"; // GET (Amaan)
    private static String GET_PATIENT_ALL_ORDERS = "/api/v1/orders/patient_all_orders"; // METHOD NOT DEFINED
    private static String PATIENT_ORDER_ITEM = "/api/v1/carts/add_order_item"; // POST (Amaan)
    private static String PATIENT_CARDS = "/api/v1/user_cards";
    private static String PATIENT_ORDER_ITEM_REMOVE = "/api/v1/carts/remove_order_item"; // DELETE (Amaan)
    private static String CART_DETAILS = "/api/v1/carts/cart_details"; // GET (Amaan)
    private static String PAYMENT_INFO = "/api/v1/user_cards";
    private static String CHECKOUT_LABS = "/api/v1/carts/checkout"; // POST (Amaan)
    private static String PRESCRIBED_LABS = "/api/v1/lab_tests/prescribed_tests"; // GET (Amaan)
    private static String DELETE_CARD = "/api/v1/user_cards/"; //POST
    private static String DELETE_ADDRESS = "/api/v1/user_addresses/"; //POST
    private static String UPDATE_ADDRESS = "/api/v1/user_addresses/"; //POST
    //Notifications
    private static String GET_NOTIFICATIONS = "/api/v1/notifications/get_notifications";  // GET (Amaan)
    private static String SAVE_NOTIFICATION = "/api/v1/notifications/save_notification";  // POST (Amaan)
    private static String RESET_NOTIFICATION_COUNT = "/api/v1/notifications/reset_counter"; // POST (Amaan)
    private static String GET_CHANNEL_KEY = "/api/v1/users/get_channel_key"; // GET (Amaan)
    private static String MAKE_PAYMENT = "/api/v1/payments"; //POST (Amaan)
    private static String VERIFY_COUPON_CODE = "/api/v1/user_plans/coupon_verify";  // POST

    //Consultation Rating
    private static String CONSULTATION_RATING = "/api/v1/consultations/add_update_rating";  // POST
    //Consultation Rating
    private static String GET_MEDICINE_CATEGORY = "/api/v1/medicines_catalogs";  // POST

    // Uploaded Prescription List
    private static String GET_UPLOADED_PRESCRIPTIONS = "/api/v1/user_prescriptions/list_prescriptions";  // GET
    // Upload Labs
    private static String UPLOADED_LABS = "/api/v1/user_uploaded_reports";  // GET
    // Get Uploaded Labs List
    private static String GET_UPLOADED_LABS = "/api/v1/user_uploaded_reports";  // GET
    // Delete Uploaded Labs List
    private static String DELETE_UPLOADED_LABS = "/api/v1/user_uploaded_reports/";  // GET
    // Update Uploaded Labs List
    private static String UPDATE_UPLOADED_LABS = "/api/v1/user_uploaded_reports/";  // POST

    // Prescribed Medicine
    private static String GET_PRESCRIBED_MEDICINE = "/api/v1/medicines_catalogs/prescribed_medicines"; // GET
    private static String ORDER_PRESCRIBED_MEDICINE = "/api/v1/carts/build_meds_cart"; // POST (PENDING)

    //headers related
    private static String KEY_ACCEPT = "Accept";
    private static String TYPE_JSON_TEXT = "application/json, text/plain, */*";
    private static String KEY_CONTENT_TYPE = "Content-Type";
    private static String KEY_ACCEPT_TOKEN = "accept-token";
    private static String KEY_AUTHORIZATION = "Authorization";
    private static String TYPE_JSON = "application/json";
    private static String TYPE_MULTIPART = "multipart/form-data";


    public static String accessToken = "";
    public static String tokenExpiry = "";
    public static String uid = "";
    public static String client = "";

    public static synchronized void setHeaders(String token, String expiry, String uid, String clt) {
        accessToken = token;
        tokenExpiry = expiry;
        RequestFactory.uid = uid;
        client = clt;
    }

    public static boolean hasToken() {
        return accessToken != null;
    }

    public static Request<JsonObject> getLoginRequest(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        setHeaders(null, null, null, null);
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + LOGIN, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> refreshToken(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + REFRESH_TOKEN, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> googleAuth(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        setHeaders(null, null, null, null);
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GOOGLE_AUTH, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getSignupRequest(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        setHeaders(null, null, null, null);
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SIGNUP, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> verifyOTP(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + VERIFY_OTP, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> createOTP(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CREATE_OTP, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getResetPasswordRequest(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener) {
        Log.wtf("BASE_URL", BASE_URL_LIVE + PASSWORD + "");
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BuildConfig.SOCKET_URL + PASSWORD, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> setPartOfProject(JsonObject object, Response.Listener successListener, Response.ErrorListener errorListener)
    {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SET_PART_OF_PROJECT, JsonObject.class, object, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorsRequest(Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + FIND_DOCTORS, JsonObject.class, null, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorsByUserRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTORS + "?user_id=" + jsonObject.get("id").getAsString(), JsonObject.class, null, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAllDoctors(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + GET_ALL_DOCTORS;
        if (jsonObject.has("id"))
            url = url + "?user_id=" + jsonObject.get("id").getAsString();
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, url, JsonObject.class, null, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getContactsRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + FIND_CONTACTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getConsultationsRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_ALL_PATIENT_SLOTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getApprovedSlotsRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_APPROVED_PATIENT_SLOTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getCompletedSlotsRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_COMPLETED_PATIENT_SLOTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPendingSlotsRequest(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_PEDNING_PATIENT_SLOTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getConsultationDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CONSULTATION_DETAILS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }


    public static Request<JsonObject> getOrderDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_ORDER_DETAILS + jsonObject.get("id").getAsString(), JsonObject.class, null, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAllAreas(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String type = jsonObject.get("type").getAsString();
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_ALL_AREAS + "?type=" + type, JsonObject.class, null, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getCreateOrder(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CREATE_ORDER, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAuthenticateOE(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + AUTHENTICATE_OE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getFinalizeOrder(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + FINALIZE_ORDER, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addAddress(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ADDRESS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> updateAddress(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.PATCH, BASE_URL + ADDRESS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAddresses(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + ADDRESS + "?user_id=" + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> updateConsultationStatus(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPDATE_CONSULTATION_STATUS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addHealthPoint(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ADD_HEALTH_POINT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addNotes(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ADD_NOTE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addAppointment(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CREATE_TIME_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getTokBoxObject(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_VIDEO_CHAT_SESSION, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getRoleID(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_ROLE_ID, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getChatID(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CHAT_ID, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getChatLines(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CHAT_LINES, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addChatLine(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ADD_CHAT_LINE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getChatData(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CHAT_DATA, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> saveNotification(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SAVE_NOTIFICATION, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> resetNotificationCounter(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + RESET_NOTIFICATION_COUNT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getChannelKey(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CHANNEL_KEY, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> makePayment(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + MAKE_PAYMENT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }


    public static Request<JsonObject> verifyCouponCode(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET,
                BASE_URL + VERIFY_COUPON_CODE + "?coupon_code=" + jsonObject.get("coupon_code").getAsString() + "&plan_id=" + jsonObject.get("plan_id").getAsLong(),
                JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> verifyCode(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET,
                BASE_URL + VERIFY_COUPON_CODE + "?coupon_code=" + jsonObject.get("coupon_code").getAsString() + "&plan_id=" + jsonObject.get("plan_id").getAsString(),
                JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getUserClaims(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_USER_CLAIMS + "user_id=" + jsonObject.get("user_id").getAsString(),
                JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getClaimDetail(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_CLAIMS_DETAIL + jsonObject.get("claim_id").getAsString(),
                JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> createClaim(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CREATE_CLAIM, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> sendMessageToClaim(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CLAIM_SEND_MESSAGE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> makePaymentAndCreateSlot(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PAY_AND_CREAT_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> makeCorporatePaymentAndCreateSlot(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PAY_AND_CREAT_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> payByInsurance(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PAY_BY_INSURANCE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> checkInstantSlots(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + INSTANT_APPOINTMENTS_SLOTS + jsonObject.get("value").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> checkInstantSlots2(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + INSTANT_APPOINTMENTS_SLOTS + jsonObject.get("value").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> bookInstantSlot(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + BOOK_INSTANT_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> signOut(String firebaseToken,JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + SIGN_OUT + "?device_id=" + firebaseToken, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> instantDoctorInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + INSTANT_DOCTOR_INFO + jsonObject.get("time").getAsString() + "&doctor_id=" + jsonObject.get("doctor_id").getAsString();
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> subscriptionPlans(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + SUBSCRIPTION_PLANS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getUserCurrentPlans(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_USER_CURRENT_PLANS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> purchasePlan(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SUBSCRIPTION_PLANS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> cancelPlan(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CANCEL_USER_CURRENT_PLAN, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getVacations(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_VACATIONS + "?" + "user_id=" + jsonObject.get("user_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorTimeSlots(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_TIME_SLOTS + "?" + "user_id=" + jsonObject.get("user_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getSlotDuration(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_SLOT_DURATION + "?" + "user_id=" + jsonObject.get("user_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorInfoFromUserName(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_DOCTOR_INFO_FROM_USER_NAME, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> areYouDoctor(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ARE_YOU_DOCTOR, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> updateSlot(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPDATE_TIME_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> versionCheck(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + VERSION_CHECK, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> versionCheckDoctor(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + VERSION_CHECK_DOCTOR, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> checkAppFeatures(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CHECK_FEATURES, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getProfileByPhone(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + FORGOT_PASSWORD_GET_PROFILE_BY_PHONE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getCreditCardBinNumbers(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + CREDIT_CARD_BIN_NUMBERS_API_PATH, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> resetPasswordByPhone(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + RESET_PASSWORD_BY_PHONE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }


    public static Request<JsonObject> updateProfile(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPDATE_USER_INFORMATION, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> uploadProfilePic(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        MultipartRequest request = new MultipartRequest<JsonObject>(Request.Method.POST, BASE_URL + UPLOAD_PIC + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject.get("path").getAsString(), getStandardFileHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> userInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_USER_INFO_FROM_ROLE_ID, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAllDependents(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + ALL_DEPENDENTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAllCoveredDependents(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + ALL_COVERED_DEPENDENTS + "user_id=" + jsonObject.get("id").getAsString();
        if (jsonObject.has("organization_id"))
            url = url + "&organization_id=" + jsonObject.get("organization_id").getAsString();
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDependents(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = BASE_URL + DEPENDENTS + "user_id=" + jsonObject.get("id").getAsString();
        if (jsonObject.has("organization_id"))
            url = url + "&organization_id=" + jsonObject.get("organization_id").getAsString();
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> addDependent(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ADD_DEPENDENT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getNotifications(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_NOTIFICATIONS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getEmployeeStats(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_EMPLOYEE_STATS + "user_id=" + jsonObject.get("id").getAsString() + (jsonObject.has("organization_id") ? ("&organization_id=" + jsonObject.get("organization_id").getAsString()) : ""), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getEmployeePolicy(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_EMPLOYEE_POLICY + "user_id=" + jsonObject.get("id").getAsString() + (jsonObject.has("organization_id") ? ("&organization_id=" + jsonObject.get("organization_id").getAsString()) : ""), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> corporatePayment(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CORPORATE_PAY_CREAT_SLOT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> showOrganization(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + SHOW_ORGANIZATION + "?user_id=" + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> elligibilityCheck(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + CHECK_ELIGIBILITY + "?user_id=" + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> switchAccount(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SWITCH_ACCOUNT, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> switchToPrimary(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + SWITCH_TO_PRIMARY, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getLabTests(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + LAB_TESTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getLabTestOrders(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = String.format(LAB_TEST_ORDERS, jsonObject.get("id").getAsString());
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> checkLabs(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + LAB_CHECK_LABS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> orderAndPay(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ORDER_AND_PAY, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> labOrderDetail(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + LAB_ORDER_DETAIL + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> labReorder(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + LAB_REORDER + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getLabReports(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_PATIENT_ALL_ORDERS + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientOrderDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_PATIENT_ALL_ORDERS + "?order_type=" + jsonObject.get("type").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getUserAddress(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_USER_ADDRESS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getAllCities(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_ALL_CITIES + "?type=" + jsonObject.get("type").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getCartDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + CART_DETAILS + "?type=" + jsonObject.get("type").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getOfflineCounterDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_OFFLINE_COUNTER, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientOrderItem(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PATIENT_ORDER_ITEM, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientCards(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + PATIENT_CARDS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPrescribedLabs(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + PRESCRIBED_LABS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPaymentInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PAYMENT_INFO, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getConsultationRatingInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CONSULTATION_RATING, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDeleteCardInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + DELETE_CARD + jsonObject.get("card_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDeleteAddressInfo(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + DELETE_ADDRESS + jsonObject.get("address_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getCheckoutLabData(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CHECKOUT_LABS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientOrderItemRemove(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + PATIENT_ORDER_ITEM_REMOVE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientAddressUpdate(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.PATCH, BASE_URL + UPDATE_ADDRESS + jsonObject.get("address_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPatientOrderItemDelete(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + PATIENT_ORDER_ITEM_REMOVE + "?order_item_id=" + jsonObject.get("order_item_id").getAsString() + "&type=" + jsonObject.get("type").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> codeSignUpVerifyEMploye(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + CODE_SIGN_UP_VERIFY_EMPLOYE + jsonObject.get("code").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> codeSignUpSetEmployePassword(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + CODE_SIGN_UP_SET_EMPLOY_PASSWORD, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getConsultationsAppointments(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_CONSULTATION, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorProfileDetails(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_PROFILE_DATA + "?user_id=" + jsonObject.get("user_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getMedicineItems(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = "";
        if (jsonObject.get("med_for").isJsonNull() && jsonObject.get("med_for").getAsString().isEmpty()) {
            url = GET_MEDICINE + "?query=" + jsonObject.get("query").getAsString() + "&page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString();
        } else {
            url = GET_MEDICINE + "?query=" + jsonObject.get("query").getAsString() + "&page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&med_for=" + jsonObject.get("med_for").getAsString();
        }
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getMedicineQuantity(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPDATE_MEDICINE_QUANTITY, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getExploreDoctor(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        String url = "";
        String page = jsonObject.get("page").getAsString();
        String perPage = jsonObject.get("per_page").getAsString();
        String search = jsonObject.get("search").getAsString();
        String name = jsonObject.get("name").getAsString();
        String filters = jsonObject.get("filters").getAsString();
        String gender = jsonObject.get("gender").getAsString();
        String feeMin = jsonObject.get("fee_min").getAsString();
        String feeMax = jsonObject.get("fee_max").getAsString();
        String hospitalId = jsonObject.get("hospital_id").getAsString();
        String cityId = jsonObject.get("city_id").getAsString();
        String specializationId = jsonObject.get("speaclization_id").getAsString();
        String review = jsonObject.get("reviews").getAsString();
        String rating = jsonObject.get("rating").getAsString();
        String experienceMin = jsonObject.get("experience_min").getAsString();
        String experienceMax = jsonObject.get("experience_max").getAsString();
        String distanceMin = jsonObject.get("distance_min").getAsString();
        String distanceMax = jsonObject.get("distance_max").getAsString();

        url = GET_EXPLORE_DOCTOR + "?page=" + page + "&per_page=" + perPage + "&search=" + search
                + "&name=" + name + "&filters=" + filters + "&gender=" + gender + "&fee_min=" + feeMin + "&fee_max=" + feeMax
                + "&hospital_id=" + hospitalId + "&city_id=" + cityId + "&specialization=" + specializationId + "&review=" + review
                + "&rating=" + rating + "&experienceMin=" + experienceMin +"&experienceMax=" + experienceMax
                +"&distanceMin=" + distanceMin +"&distanceMax=" + distanceMax;

//        if (jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString();
//        } else if (jsonObject.get("filters").getAsString().isEmpty() && !jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("search").getAsString().equals("true")) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&search=" + jsonObject.get("search").getAsString() + "&name=" + jsonObject.get("name").getAsString();
//        } else if (!jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("filter").getAsString().equals("true") && !jsonObject.get("gender").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&filters=" + jsonObject.get("filters").getAsString() + "&gender=" + jsonObject.get("gender").getAsString();
//        } else if (!jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("filter").getAsString().equals("true") && !jsonObject.get("fee_min").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&filters=" + jsonObject.get("filters").getAsString() + "&fee_min=" + jsonObject.get("fee_min").getAsString() + "&fee_max=" + jsonObject.get("fee_max").getAsString();
//        } else if (!jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("filter").getAsString().equals("true") && !jsonObject.get("hospital_id").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&filters=" + jsonObject.get("filters").getAsString() + "&hospital_id=" + jsonObject.get("hospital_id").getAsString();
//        } else if (!jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("filter").getAsString().equals("true") && !jsonObject.get("city_id").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&filters=" + jsonObject.get("filters").getAsString() + "&city_id=" + jsonObject.get("city_id").getAsString();
//        } else if (!jsonObject.get("filters").getAsString().isEmpty() && jsonObject.get("search").getAsString().isEmpty() && jsonObject.get("filter").getAsString().equals("true") && !jsonObject.get("speaclization_id").getAsString().isEmpty()) {
//            url = GET_EXPLORE_DOCTOR + "?page=" + jsonObject.get("page").getAsString() + "&per_page=" + jsonObject.get("per_page").getAsString() + "&filters=" + jsonObject.get("filters").getAsString() + "&specialization=" + jsonObject.get("speaclization_id").getAsString();
//        }
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + url, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getExploreFilterDoctor(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_EXPLORE_FILTER_DOCTOR, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDoctorSlots(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_TIME_SLOT + "?date=" + jsonObject.get("date").getAsString() + "&doctor_id=" + jsonObject.get("doctor_id").getAsString() + "&type=" + jsonObject.get("type").getAsString() + "&medical_practice_id=" + jsonObject.get("medical_practice_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getExploreDoctorSlots(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_DOCTOR_TIME_WEEKLY_SLOT + "?doctor_id=" + jsonObject.get("doctor_id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getApplyCoupon(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_COUPON_CODE + "?coupon=" + jsonObject.get("coupon").getAsString() + "&type" + jsonObject.get("type").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getMedicineCategory(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_MEDICINE_CATEGORY + "?med_for=" + jsonObject.get("med_for").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getDependent(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_ALL_DEPENDENTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> createDependent(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + GET_ALL_DEPENDENTS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> updateDependent(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.PUT, BASE_URL + UPDATE_DEPENDENTS + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> deleteDependent(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + UPDATE_DEPENDENTS + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> uploadClaimImage(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPLOAD_CLAIMS_IMAGE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getUploadedPrescriptions(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_UPLOADED_PRESCRIPTIONS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getPrescribedMedicine(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_PRESCRIBED_MEDICINE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> orderPrescribedMedicine(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + ORDER_PRESCRIBED_MEDICINE, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> changePassword(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.PUT, BASE_URL + SIGNUP, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> uploadLabReports(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.POST, BASE_URL + UPLOADED_LABS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> getUploadLabReports(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.GET, BASE_URL + GET_UPLOADED_LABS, JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> deleteUploadLabReports(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.DELETE, BASE_URL + DELETE_UPLOADED_LABS + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Request<JsonObject> updateUploadLabReports(JsonObject jsonObject, Response.Listener successListener, Response.ErrorListener errorListener) {
        GsonRequest request = new GsonRequest<JsonObject>(Request.Method.PUT, BASE_URL + UPDATE_UPLOADED_LABS + jsonObject.get("id").getAsString(), JsonObject.class, jsonObject, getStandardHeaders(), successListener, errorListener);
        return request;
    }

    public static Map<String, String> getStandardHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(KEY_ACCEPT, TYPE_JSON);
        params.put(KEY_CONTENT_TYPE, TYPE_JSON);
        if (accessToken != null) {
            params.put(Constants.KEY_ACCESS_TOKEN, accessToken);
        }
        if (uid != null) {
            params.put(Constants.KEY_UID, uid);

        }
        if (tokenExpiry != null) {
            params.put(Constants.KEY_EXPIRY, tokenExpiry);

        }
        if (client != null) {
            params.put(Constants.KEY_CLIENT, client);
            params.put("token-type", "Bearer");
        }
        return params;
    }

    public static Map<String, String> getStandardFileHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(KEY_ACCEPT, TYPE_JSON);
        params.put(KEY_CONTENT_TYPE, "multipart/form-data");
        return params;
    }

    private static RetryPolicy getStandardRetryPolicy() {
        RetryPolicy retryPolicy = null;
        retryPolicy = new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 30000; //one minute
            }

            @Override
            public int getCurrentRetryCount() {
                return 2;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        };

        return retryPolicy;
    }

    public static class GsonRequest<T> extends Request<T> {
        private final Gson gson = new Gson();
        private final Class<T> clazz;
        private final Map<String, String> headers;
        private Response.Listener<T> listener;
        private final JsonObject gsonbody;

        /**
         * Make a request and return a parsed object from JSON.
         *
         * @param method  Method/Type of request
         * @param url     URL of the request to make
         * @param clazz   Relevant class object, for Gson's reflection
         * @param headers Map of request headers
         * @see com.android.volley.Request.Method
         */
        public GsonRequest(int method, String url, Class<T> clazz, JsonObject body, Map<String, String> headers,
                           Response.Listener<T> listener, Response.ErrorListener errorListener) {
            super(method, url, errorListener);
            this.clazz = clazz;
            this.headers = headers;
            this.gsonbody = body;
            this.listener = listener;
            setRetryPolicy(new DefaultRetryPolicy(20 * DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 0));
        }

        @Override
        public byte[] getBody() throws AuthFailureError {
            return gsonbody.toString().getBytes();
        }

        public void setListener(Response.Listener<T> listener) {
            this.listener = listener;
        }

        public Response.Listener<T> getListener() {
            return this.listener;
        }

        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            return headers != null ? headers : super.getHeaders();
        }

        @Override
        protected void deliverResponse(T response) {
            listener.onResponse(response);
        }

        @Override
        protected VolleyError parseNetworkError(VolleyError volleyError) {
            return super.parseNetworkError(volleyError);
        }

        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse response) {
            try {

                String json = new String(
                        response.data,
                        HttpHeaderParser.parseCharset(response.headers));
                T respJson = gson.fromJson(json, clazz);
                if (respJson instanceof JsonObject) {
                    if (response.headers != null) {
                        ((JsonObject) respJson).add("headers", gson.toJsonTree(response.headers));
                    }
                }
                return Response.success(
                        respJson,
                        HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            } catch (JsonSyntaxException e) {
                return Response.error(new ParseError(e));
            }
        }
    }

    public static class MultipartRequest<T> extends Request<T> {
        private final Gson gson = new Gson();
        private final Class<T> clazz;
        private final Map<String, String> headers;
        private Response.Listener<T> listener;
        private final String mFile;
        private final MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        HttpEntity entity = new MultipartEntity();

        /**
         * Make a request and return a parsed object from JSON.
         *
         * @param method  Method/Type of request
         * @param url     URL of the request to make
         * @param clazz   Relevant class object, for Gson's reflection
         * @param headers Map of request headers
         * @see com.android.volley.Request.Method
         */
        public MultipartRequest(int method, String url, Class<T> clazz, String file, Map<String, String> headers,
                                Response.Listener<T> listener, Response.ErrorListener errorListener) {
            super(method, url, errorListener);
            this.clazz = clazz;
            this.headers = headers;
            this.mFile = file;
            this.listener = listener;
            entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            File fileOnDisk = null;
            try {
                fileOnDisk = new File(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ContentType contentType = ContentType.create("image/png");
            entityBuilder.addBinaryBody("file", fileOnDisk, contentType, fileOnDisk.getName());
            entity = entityBuilder.build();
            setRetryPolicy(new DefaultRetryPolicy(60 * DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 0));

        }

        @Override
        public byte[] getBody() throws AuthFailureError {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            try {
                entity.writeTo(bos);
            } catch (IOException e) {
                VolleyLog.e("IOException writing to ByteArrayOutputStream");
            }
            return bos.toByteArray();
        }

        public void setListener(Response.Listener<T> listener) {
            this.listener = listener;
        }

        public Response.Listener<T> getListener() {
            return this.listener;
        }

        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            return headers != null ? headers : super.getHeaders();
        }

        @Override
        protected void deliverResponse(T response) {
            listener.onResponse(response);
        }

        @Override
        protected VolleyError parseNetworkError(VolleyError volleyError) {
            return super.parseNetworkError(volleyError);
        }

        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse response) {
            try {

                String json = new String(
                        response.data,
                        HttpHeaderParser.parseCharset(response.headers));
                T respJson = gson.fromJson(json, clazz);
                if (respJson instanceof JsonObject) {
                    if (response.headers != null) {
                        ((JsonObject) respJson).add("headers", gson.toJsonTree(response.headers));
                    }
                }
                return Response.success(
                        respJson,
                        HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            } catch (JsonSyntaxException e) {
                return Response.error(new ParseError(e));
            }
        }
    }
}