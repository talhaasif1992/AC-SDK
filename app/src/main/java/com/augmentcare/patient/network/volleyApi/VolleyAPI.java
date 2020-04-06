package com.augmentcare.patient.network.volleyApi;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

public class VolleyAPI {

    private static final String TAG = "VolleyAPI";

    private FragmentInteractionListener mListener;
    private HashMap<Integer, Request<JsonObject>> requestHashMap = new HashMap<>();
    private HashMap<Integer, JsonObject> responseHashMap = new HashMap<>();
    private HashMap<Integer, WebResponseListner> listenerHashMap = new HashMap<>();
    public static final int TYPE_LOGIN = 100;
    public static final int TYPE_SIGNUP = 102;
    public static final int TYPE_RESET_PASS = 103;
    public static final int TYPE_FIND_DOCTORS = 104;
    public static final int TYPE_ALL_CONSULTATIONS = 105;
    public static final int TYPE_TOK_BOX_SESSION = 106;
    public static final int TYPE_GET_CHAT_ID = 107;
    public static final int TYPE_GET_CHAT_LINES = 108;
    public static final int TYPE_ADD_CHAT_LINE = 109;
    public static final int TYPE_CONSULTATION_DETAIL = 110;
    public static final int TYPE_UPDATE_CONSULTATION_STATUS = 111;
    public static final int TYPE_GET_VACATIONS = 112;
    public static final int TYPE_GET_DOCTOR_SLOTS = 113;
    public static final int TYPE_GET_SLOT_DURATION = 114;
    public static final int TYPE_ADD_HEALTH_POINT = 115;
    public static final int TYPE_ADD_NOTE = 116;
    public static final int TYPE_ADD_APPOINTMENT = 117;
    public static final int TYPE_GET_CHAT_DATA = 118;
    public static final int TYPE_SAVE_NOTIFICATION = 119;
    public static final int TYPE_MAKE_PAYMENT = 120;
    public static final int TYPE_APPROVED_CONSULTATIONS = 121;
    public static final int TYPE_COMPLETED_CONSULTATIONS = 122;
    public static final int TYPE_FIND_CONTACTS = 123;
    public static final int TYPE_PENDING_CONSULTATIONS = 124;
    public static final int TYPE_CREATE_OTP = 125;
    public static final int TYPE_VERIFY_OTP = 126;
    public static final int TYPE_GOOGLE_AUTH = 127;
    public static final int TYPE_VERSION_CHECK = 128;
    public static final int TYPE_ORDER_DETAILS = 130;
    public static final int TYPE_GET_ALL_AREAS = 131;
    public static final int TYPE_CREATE_ORDER = 132;
    public static final int TYPE_AUTHENTICATE_OE = 133;
    public static final int TYPE_ADD_ADDRESS = 134;
    public static final int TYPE_GET_ADDRESSES = 135;
    public static final int TYPE_UPDATE_ADDRESS = 136;
    public static final int TYPE_FINALIZE_ORDER = 137;
    public static final int TYPE_GET_ROLE_ID = 138;
    public static final int TYPE_UPDATE_SLOT = 141;
    public static final int TYPE_GET_CHANNEL_KEY = 142;
    public static final int TYPE_VERSION_CHECK_DOCTOR = 144;
    public static final int TYPE_UPDATE_PROFILE = 145;
    public static final int TYPE_UPLOAD_PROFILE_PIC = 146;
    public static final int TYPE_USER_INFO = 147;
    public static final int TYPE_ALL_DEPENDENT = 149;
    public static final int TYPE_COVERED_DEPENDENTS = 151;
    public static final int TYPE_ADD_DEPENDENT = 152;
    public static final int TYPE_GET_ALL_NOTIFICATIONS = 153;
    public static final int TYPE_GET_EMPLOYEE_STATS = 154;
    public static final int TYPE_GET_EMPLOYEE_POLICY = 155;
    public static final int TYPE_SWITCH_ACCOUNT = 156;
    public static final int TYPE_SWITCH_TO_PRIMARY = 157;
    public static final int TYPE_GET_DOCTORS = 158;
    public static final int TYPE_CORPORATE_PAYMENT = 159;
    public static final int TYPE_SHOW_ORGANIZATION = 160;
    public static final int TYPE_ELIGIBILITY_CHECK = 161;
    public static final int TYPE_RESET_NOTIFICATION_COUNT = 162;
    public static final int TYPE_DOCTOR_INFO_FROM_USER = 163;
    public static final int TYPE_PAY_AND_CREATE_SLOT = 164;
    public static final int TYPE_REFRESH_TOKEN = 166;
    public static final int TYPE_CHECK_FEATURES = 167;
    public static final int TYPE_ALL_DOCTORS = 168;
    public static final int TYPE_LAB_TESTS = 169;
    public static final int TYPE_LAB_TEST_ORDERS = 170;
    public static final int TYPE_CHECK_LABS = 171;
    public static final int TYPE_ORDER_AND_PAY = 172;
    public static final int TYPE_LAB_ORDER_DETAIL = 173;
    public static final int TYPE_PAY_BY_INSURANCE = 174;
    public static final int TYPE_ARE_YOU_DOCTOR = 176;
    public static final int TYPE_SUBSCRIPTION_PLANS = 177;
    public static final int TYPE_SUBSCRIPTION_PURCHASE_PLAN = 178;
    public static final int TYPE_LAB_REORDER = 179;
    public static final int TYPE_INSTANT_APPOINTMENT_SLOTS = 180;
    public static final int TYPE_BOOK_INSTANT_APPOINTMENT = 181;
    public static final int TYPE_INSTANT_APPOINTMEN_DOCTOR_INFO = 182;
    public static final int TYPE_GET_USER_CURRENT_PLAN = 183;
    public static final int TYPE_CANCEL_USER_CURRENT_PLAN = 184;
    public static final int TYPE_CODE_SIGN_UP_VERIFY_EMPLOYE = 185;
    public static final int TYPE_CODE_SIGN_UP_SET_EMPLOY_PASSWORD = 186;
    public static final int TYPE_VERIFY_COUPON_CODE = 187;
    public static final int TYPE_GET_USER_CLAIMS = 188;
    public static final int TYPE_GET_CLAIM_DETAIL = 189;
    public static final int TYPE_CLAIM_SEND_MESSAGE = 190;
    public static final int TYPE_CREATE_CLAIM = 191;
    public static final int TYPE_GET_ORDER = 192;
    public static final int TYPE_ORDER_ITEM = 193;
    public static final int TYPE_ORDER_ITEM_REMOVE = 194;
    public static final int TYPE_GET_ADDRESS = 195;
    public static final int TYPE_GET_ALL_CITIES = 196;
    public static final int TYPE_SIGN_OUT = 197;
    public static final int TYPE_GET_CART_DETAILS = 198;
    public static final int TYPE_REMOVE_ORDER_ITEM = 199;
    public static final int TYPE_OFFLINE_COUNTER = 200;
    public static final int TYPE_ADD_CARD = 201;
    public static final int TYPE_GET_CARDS = 202;
    public static final int TYPE_CHECKOUT_LABS = 203;
    public static final int TYPE_GET_PRESCRIBED_LABS = 204;
    public static final int TYPE_CONSULTATION_RATING = 205;
    public static final int TYPE_DELETE_CARD = 206;
    public static final int TYPE_DELETE_ADDRESS = 207;
    public static final int TYPE_GET_CONSULTATION_APPOINTMENTS = 208;
    public static final int TYPE_GET_DOCTOR_PROFILE_DETAILS = 209;
    public static final int TYPE_GET_MEDICINE_LIST = 210;
    public static final int TYPE_GET_EXPLORE_DOCTOR = 211;
    public static final int TYPE_GET_EXPLORE_FILTER_DOCTOR = 212;
    public static final int TYPE_UPDATE_MEDICINE_QUANTITY = 213;
    public static final int TYPE_GET_DOCTOR_SLOT = 214;
    public static final int TYPE_GET_TIME = 215;
    public static final int TYPE_APPLY_COUPON = 216;
    public static final int TYPE_MEDICINE_CATEGORY = 217;
    public static final int TYPE_ADD_DEPENDENTS = 219;
    public static final int TYPE_UPDATE_DEPENDENTS = 220;
    public static final int TYPE_DELETE_DEPENDENTS = 221;
    public static final int TYPE_UPLOAD_CLAIMS_IMAGE = 222;
    public static final int TYPE_GET_UPLOADED_PRESCRIPTIONS = 223;
    public static final int TYPE_GET_PRESCRIBED_MEDICINE = 224;
    public static final int TYPE_ORDER_PRESCRIBED_MEDICINE = 225;
    public static final int TYPE_CHANGE_PASSWORD = 226;
    public static final int TYPE_VERIFY_CODE = 227;
    public static final int TYPE_GET_UPLOAD_LABS_REPORTS = 228;
    public static final int TYPE_UPLOAD_LABS_REPORTS = 229;
    public static final int TYPE_DELETE_LABS_REPORTS = 230;
    public static final int TYPE_UPDATE_LABS_REPORTS = 231;
    public static final int TYPE_RESET_PASS_BY_PHONE = 232;
    public static final int TYPE_GET_PROFILE_BY_PHONE = 233;
    public static final int TYPE_GET_CREDIT_CARD_BIN_NUMBERS = 234;
    public static final int TYPE_SET_PART_OF_PROJECT = 235;
    private Gson gson = new GsonBuilder().create();

    public VolleyAPI() {
    }



    public VolleyAPI withListner(FragmentInteractionListener listner){
        this.mListener = listner;
        return this;
    }

    private void processHeaders(String gotHeaders) {
        HashMap<String, String> headers = gson.fromJson(gotHeaders, HashMap.class);
        String accessToken = null;
        String expiry = null;
        String uid = null;
        String client = null;

        if (headers.containsKey(Constants.KEY_ACCESS_TOKEN) || headers.containsKey(Constants.KEY_ACCESS_TOKEN_UP)) {
            if (headers.containsKey(Constants.KEY_ACCESS_TOKEN)) {
                accessToken = headers.get(Constants.KEY_ACCESS_TOKEN);
            }

            if (headers.containsKey(Constants.KEY_EXPIRY)) {
                expiry = headers.get(Constants.KEY_EXPIRY);
            }

            if (headers.containsKey(Constants.KEY_UID)) {
                uid = headers.get(Constants.KEY_UID);
            }

            if (headers.containsKey(Constants.KEY_CLIENT)) {
                client = headers.get(Constants.KEY_CLIENT);
            }

            if (headers.containsKey(Constants.KEY_ACCESS_TOKEN_UP)) {
                accessToken = headers.get(Constants.KEY_ACCESS_TOKEN_UP);
            }

            if (headers.containsKey(Constants.KEY_EXPIRY_UP)) {
                expiry = headers.get(Constants.KEY_EXPIRY_UP);
            }

            if (headers.containsKey(Constants.KEY_UID_UP)) {
                uid = headers.get(Constants.KEY_UID_UP);
            }

            if (headers.containsKey(Constants.KEY_CLIENT_UP)) {
                client = headers.get(Constants.KEY_CLIENT_UP);
            }

            RequestFactory.setHeaders(accessToken, expiry, uid, client);

            PrefsHelper.setAccessTokenSP(StringUtils.null2Length0(accessToken));
            PrefsHelper.setClientSP(StringUtils.null2Length0(client));
            PrefsHelper.setUIDSP(StringUtils.null2Length0(uid));

            try {
                PrefsHelper.get(Utils.getApp()).putString("headers", gotHeaders);
            } catch (Exception e) {
            }
        }
    }

    public void addRequest(final Context context, final int type, JsonObject requestBody, final WebResponseListner responseListner) {
        if (requestHashMap == null)
            requestHashMap = new HashMap<>();

        if (PrefsHelper.get(context).contains("headers")) {
            processHeaders(PrefsHelper.get(context).getString("headers", ""));
        }

        if (!requestHashMap.containsKey(type)) {
            Request<JsonObject> gsonRequest = null;

            final Response.Listener listener = (Response.Listener<JsonObject>) response -> {
                try {
                    Log.d(TAG, TAG + "  " + response);

                    if (response.has("headers")) {
                        processHeaders(response.get("headers").getAsJsonObject().toString());
                    }

                    if (type == VolleyAPI.TYPE_REFRESH_TOKEN) {
                        Iterator<Request<JsonObject>> iterator = requestHashMap.values().iterator();
                        if (iterator.hasNext()) {
                            if ((int) iterator.next().getTag() != type)
                                RequestHandler.getInstance(context).addToRequestQueue(iterator.next());
                        }
                    }

                    if (mListener != null) {
                        if (listenerHashMap.get(type) != null) {
                            listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_OK, response);
                            listenerHashMap.remove(type);
                        }
                    } else {
                        responseHashMap.put(type, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, TAG + "  " + error);
                    String body;
                    //get status code here
                    if (error.networkResponse != null) {
                        String statusCode = String.valueOf(error.networkResponse.statusCode);
                        //get response body and parse with appropriate encoding
                        if (error.networkResponse.data != null) {
                            String token;
                            body = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JsonParser parser = new JsonParser();
                            JsonObject resp = null;
                            try {
                                resp = parser.parse(body).getAsJsonObject();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //mListener.onWebResponseListner(type, HttpURLConnection.HTTP_OK, parser.parse(body).getAsJsonObject());
                            if (error.networkResponse.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED && type == TYPE_REFRESH_TOKEN) {
                                listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_UNAUTHORIZED, new JsonObject());
                            }
                            if (error.networkResponse.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED && type != TYPE_REFRESH_TOKEN) {
                                JsonObject emptyObject = new JsonObject();
                                Response.Listener authListner = new Response.Listener<JsonObject>() {
                                    @Override
                                    public void onResponse(JsonObject response) {
                                        if (response != null) {
                                            if (response.has("headers") && response.get("headers").getAsJsonObject().has(Constants.KEY_ACCESS_TOKEN)) {
                                                processHeaders(response.get("headers").getAsJsonObject().toString());
                                                Iterator<Request<JsonObject>> iterator = requestHashMap.values().iterator();
                                                if (iterator.hasNext()) {
                                                    if ((int) iterator.next().getTag() != type)
                                                        RequestHandler.getInstance(context).addToRequestQueue(iterator.next());
                                                }
                                            } else {
                                                listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_UNAUTHORIZED, new JsonObject());
                                            }
                                        } else {
                                            listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_UNAUTHORIZED, new JsonObject());
                                        }
                                    }
                                };
                                Request<JsonObject> authRequest = RequestFactory.refreshToken(emptyObject, authListner, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_UNAUTHORIZED, new JsonObject());
                                    }
                                });
                                authRequest.setTag(VolleyAPI.TYPE_REFRESH_TOKEN);
                                //listenerHashMap.put(VolleyAPI.TYPE_REFRESH_TOKEN, listener1);
                                RequestHandler.getInstance(context).addToRequestQueue(authRequest);
                            } else {
                                if (mListener != null) {
                                    try {
                                        if (error.networkResponse.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                                            if (resp == null) {
                                                resp = new JsonObject();
                                            }
                                            listenerHashMap.get(type).onWebResponseListner(type, error.networkResponse.statusCode, resp);
                                        } else {
                                            listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_OK, resp);
                                        }
                                        listenerHashMap.remove(type);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    responseHashMap.put(type, resp);
                                }
                            }
                        }
                    } else {
                        try {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("error", "Other");
                            if (mListener != null) {
                                listenerHashMap.get(type).onWebResponseListner(type, HttpURLConnection.HTTP_INTERNAL_ERROR, jsonObject);
                                listenerHashMap.remove(type);
                            } else {
                                responseHashMap.put(type, jsonObject);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            switch (type) {
                case TYPE_LOGIN: {
                    gsonRequest = RequestFactory.getLoginRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_RESET_PASS: {
                    gsonRequest = RequestFactory.getResetPasswordRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_SIGNUP: {
                    gsonRequest = RequestFactory.getSignupRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_FIND_DOCTORS: {
                    gsonRequest = RequestFactory.getDoctorsRequest(listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_DOCTORS: {
                    gsonRequest = RequestFactory.getDoctorsByUserRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_ALL_CONSULTATIONS: {
                    gsonRequest = RequestFactory.getConsultationsRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_TOK_BOX_SESSION: {
                    gsonRequest = RequestFactory.getTokBoxObject(requestBody, listener, errorListener);

                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_CHAT_ID: {
                    gsonRequest = RequestFactory.getChatID(requestBody, listener, errorListener);

                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_CHAT_LINES: {
                    gsonRequest = RequestFactory.getChatLines(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_CHAT_LINE: {
                    gsonRequest = RequestFactory.addChatLine(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_CONSULTATION_DETAIL: {
                    gsonRequest = RequestFactory.getConsultationDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_UPDATE_CONSULTATION_STATUS: {
                    gsonRequest = RequestFactory.updateConsultationStatus(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_VACATIONS: {
                    gsonRequest = RequestFactory.getVacations(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_DOCTOR_SLOTS: {
                    gsonRequest = RequestFactory.getDoctorTimeSlots(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_SLOT_DURATION: {
                    gsonRequest = RequestFactory.getSlotDuration(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_HEALTH_POINT: {
                    gsonRequest = RequestFactory.addHealthPoint(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_NOTE: {
                    gsonRequest = RequestFactory.addNotes(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_APPOINTMENT: {
                    gsonRequest = RequestFactory.addAppointment(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_CHAT_DATA: {
                    gsonRequest = RequestFactory.getChatData(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_SAVE_NOTIFICATION: {
                    gsonRequest = RequestFactory.saveNotification(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_MAKE_PAYMENT: {
                    gsonRequest = RequestFactory.makePayment(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_APPROVED_CONSULTATIONS: {
                    gsonRequest = RequestFactory.getApprovedSlotsRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_COMPLETED_CONSULTATIONS: {
                    gsonRequest = RequestFactory.getCompletedSlotsRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_PENDING_CONSULTATIONS: {
                    gsonRequest = RequestFactory.getPendingSlotsRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_FIND_CONTACTS: {
                    gsonRequest = RequestFactory.getContactsRequest(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_CREATE_OTP: {
                    gsonRequest = RequestFactory.createOTP(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_VERIFY_OTP: {
                    gsonRequest = RequestFactory.verifyOTP(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_SET_PART_OF_PROJECT: {
                    gsonRequest = RequestFactory.setPartOfProject(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_GOOGLE_AUTH: {
                    gsonRequest = RequestFactory.googleAuth(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_VERSION_CHECK: {
                    gsonRequest = RequestFactory.versionCheck(null, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_VERSION_CHECK_DOCTOR: {
                    gsonRequest = RequestFactory.versionCheckDoctor(null, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ORDER_DETAILS: {
                    gsonRequest = RequestFactory.getOrderDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_ALL_AREAS: {
                    gsonRequest = RequestFactory.getAllAreas(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_CREATE_ORDER: {
                    gsonRequest = RequestFactory.getCreateOrder(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_AUTHENTICATE_OE: {
                    gsonRequest = RequestFactory.getAuthenticateOE(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_ADDRESS: {
                    gsonRequest = RequestFactory.addAddress(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_ADDRESSES: {
                    gsonRequest = RequestFactory.getAddresses(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
//                case TYPE_UPDATE_ADDRESS: {
//                    gsonRequest = RequestFactory.getAddresses(requestBody, listener, errorListener);
//                    gsonRequest.setTag(type);
//                    listenerHashMap.put(type, responseListner);
//                    RequestHandler.get(context).addToRequestQueue(gsonRequest);
//                }
//                break;
                case TYPE_FINALIZE_ORDER: {
                    gsonRequest = RequestFactory.getFinalizeOrder(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_ROLE_ID: {
                    gsonRequest = RequestFactory.getRoleID(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_UPDATE_SLOT: {
                    gsonRequest = RequestFactory.updateSlot(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_CHANNEL_KEY: {
                    gsonRequest = RequestFactory.getChannelKey(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_UPDATE_PROFILE: {
                    gsonRequest = RequestFactory.updateProfile(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_UPLOAD_PROFILE_PIC: {
                    gsonRequest = RequestFactory.uploadProfilePic(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_USER_INFO: {
                    gsonRequest = RequestFactory.userInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ALL_DEPENDENT: {
                    gsonRequest = RequestFactory.getAllDependents(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_COVERED_DEPENDENTS: {
                    gsonRequest = RequestFactory.getAllCoveredDependents(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ADD_DEPENDENT: {
                    gsonRequest = RequestFactory.addDependent(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_EMPLOYEE_STATS: {
                    gsonRequest = RequestFactory.getEmployeeStats(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_EMPLOYEE_POLICY: {
                    gsonRequest = RequestFactory.getEmployeePolicy(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_GET_ALL_NOTIFICATIONS: {
                    gsonRequest = RequestFactory.getNotifications(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_SWITCH_ACCOUNT: {
                    gsonRequest = RequestFactory.switchAccount(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_SWITCH_TO_PRIMARY: {
                    gsonRequest = RequestFactory.switchToPrimary(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_CORPORATE_PAYMENT: {
                    gsonRequest = RequestFactory.corporatePayment(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_SHOW_ORGANIZATION: {
                    gsonRequest = RequestFactory.showOrganization(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_ELIGIBILITY_CHECK: {
                    gsonRequest = RequestFactory.elligibilityCheck(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_RESET_NOTIFICATION_COUNT: {
                    gsonRequest = RequestFactory.resetNotificationCounter(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_DOCTOR_INFO_FROM_USER: {
                    gsonRequest = RequestFactory.getDoctorInfoFromUserName(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_PAY_AND_CREATE_SLOT: {
                    gsonRequest = RequestFactory.makePaymentAndCreateSlot(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_REFRESH_TOKEN: {
                    gsonRequest = RequestFactory.refreshToken(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_CHECK_FEATURES: {
                    gsonRequest = RequestFactory.checkAppFeatures(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }

                case TYPE_GET_PROFILE_BY_PHONE: {
                    gsonRequest = RequestFactory.getProfileByPhone(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_GET_CREDIT_CARD_BIN_NUMBERS: {
                    gsonRequest = RequestFactory.getCreditCardBinNumbers(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;

                case TYPE_RESET_PASS_BY_PHONE: {
                    gsonRequest = RequestFactory.resetPasswordByPhone(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                case TYPE_ALL_DOCTORS: {
                    gsonRequest = RequestFactory.getAllDoctors(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_LAB_TESTS: {
                    gsonRequest = RequestFactory.getLabTests(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_LAB_TEST_ORDERS: {
                    gsonRequest = RequestFactory.getLabTestOrders(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                }
                break;
                case TYPE_CHECK_LABS:
                    gsonRequest = RequestFactory.checkLabs(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ORDER_AND_PAY:
                    gsonRequest = RequestFactory.orderAndPay(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_LAB_ORDER_DETAIL:
                    gsonRequest = RequestFactory.labOrderDetail(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_PAY_BY_INSURANCE:
                    gsonRequest = RequestFactory.payByInsurance(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_ARE_YOU_DOCTOR:
                    gsonRequest = RequestFactory.areYouDoctor(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_SUBSCRIPTION_PLANS:
                    gsonRequest = RequestFactory.subscriptionPlans(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_SUBSCRIPTION_PURCHASE_PLAN:
                    gsonRequest = RequestFactory.purchasePlan(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_USER_CURRENT_PLAN:
                    gsonRequest = RequestFactory.getUserCurrentPlans(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CANCEL_USER_CURRENT_PLAN:
                    gsonRequest = RequestFactory.cancelPlan(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_LAB_REORDER:
                    gsonRequest = RequestFactory.labReorder(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_INSTANT_APPOINTMENT_SLOTS:
                    gsonRequest = RequestFactory.checkInstantSlots2(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_BOOK_INSTANT_APPOINTMENT:
                    gsonRequest = RequestFactory.bookInstantSlot(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_INSTANT_APPOINTMEN_DOCTOR_INFO:
                    gsonRequest = RequestFactory.instantDoctorInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CODE_SIGN_UP_VERIFY_EMPLOYE:
                    gsonRequest = RequestFactory.codeSignUpVerifyEMploye(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CODE_SIGN_UP_SET_EMPLOY_PASSWORD:
                    gsonRequest = RequestFactory.codeSignUpSetEmployePassword(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_VERIFY_COUPON_CODE:
                    gsonRequest = RequestFactory.verifyCouponCode(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_VERIFY_CODE:
                    gsonRequest = RequestFactory.verifyCode(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_USER_CLAIMS:
                    gsonRequest = RequestFactory.getUserClaims(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_CLAIM_DETAIL:
                    gsonRequest = RequestFactory.getClaimDetail(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CLAIM_SEND_MESSAGE:
                    gsonRequest = RequestFactory.sendMessageToClaim(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CREATE_CLAIM:
                    gsonRequest = RequestFactory.createClaim(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_ORDER:
                    gsonRequest = RequestFactory.getPatientOrderDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_ADDRESS:
                    gsonRequest = RequestFactory.getUserAddress(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_CART_DETAILS:
                    gsonRequest = RequestFactory.getCartDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_ALL_CITIES:
                    gsonRequest = RequestFactory.getAllCities(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ORDER_ITEM:
                    gsonRequest = RequestFactory.getPatientOrderItem(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ORDER_ITEM_REMOVE:
                    gsonRequest = RequestFactory.getPatientOrderItemRemove(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_SIGN_OUT:
                    String firebaseToken = PrefsHelper.getFirebaseToken();
                    gsonRequest = RequestFactory.signOut(firebaseToken,requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_REMOVE_ORDER_ITEM:
                    gsonRequest = RequestFactory.getPatientOrderItemDelete(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_OFFLINE_COUNTER:
                    gsonRequest = RequestFactory.getOfflineCounterDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ADD_CARD:
                    gsonRequest = RequestFactory.getPaymentInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_CARDS:
                    gsonRequest = RequestFactory.getPatientCards(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CHECKOUT_LABS:
                    gsonRequest = RequestFactory.getCheckoutLabData(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_PRESCRIBED_LABS:
                    gsonRequest = RequestFactory.getPrescribedLabs(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CONSULTATION_RATING:
                    gsonRequest = RequestFactory.getConsultationRatingInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_DELETE_CARD:
                    gsonRequest = RequestFactory.getDeleteCardInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_DELETE_ADDRESS:
                    gsonRequest = RequestFactory.getDeleteAddressInfo(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_UPDATE_ADDRESS:
                    gsonRequest = RequestFactory.getPatientAddressUpdate(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_GET_CONSULTATION_APPOINTMENTS:
                    gsonRequest = RequestFactory.getConsultationsAppointments(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_GET_DOCTOR_PROFILE_DETAILS:
                    gsonRequest = RequestFactory.getDoctorProfileDetails(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;

                case TYPE_GET_MEDICINE_LIST:
                    gsonRequest = RequestFactory.getMedicineItems(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_EXPLORE_DOCTOR:
                    gsonRequest = RequestFactory.getExploreDoctor(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_EXPLORE_FILTER_DOCTOR:
                    gsonRequest = RequestFactory.getExploreFilterDoctor(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_UPDATE_MEDICINE_QUANTITY:
                    gsonRequest = RequestFactory.getMedicineQuantity(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_DOCTOR_SLOT:
                    gsonRequest = RequestFactory.getDoctorSlots(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_TIME:
                    gsonRequest = RequestFactory.getExploreDoctorSlots(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_APPLY_COUPON:
                    gsonRequest = RequestFactory.getApplyCoupon(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_MEDICINE_CATEGORY:
                    gsonRequest = RequestFactory.getMedicineCategory(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ADD_DEPENDENTS:
                    gsonRequest = RequestFactory.createDependent(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_UPDATE_DEPENDENTS:
                    gsonRequest = RequestFactory.updateDependent(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_DELETE_DEPENDENTS:
                    gsonRequest = RequestFactory.deleteDependent(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_UPLOAD_CLAIMS_IMAGE:
                    gsonRequest = RequestFactory.uploadClaimImage(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_UPLOADED_PRESCRIPTIONS:
                    gsonRequest = RequestFactory.getUploadedPrescriptions(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_PRESCRIBED_MEDICINE:
                    gsonRequest = RequestFactory.getPrescribedMedicine(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_ORDER_PRESCRIBED_MEDICINE:
                    gsonRequest = RequestFactory.orderPrescribedMedicine(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_CHANGE_PASSWORD:
                    gsonRequest = RequestFactory.changePassword(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_GET_UPLOAD_LABS_REPORTS:
                    gsonRequest = RequestFactory.getUploadLabReports(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_UPLOAD_LABS_REPORTS:
                    gsonRequest = RequestFactory.uploadLabReports(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_DELETE_LABS_REPORTS:
                    gsonRequest = RequestFactory.deleteUploadLabReports(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
                case TYPE_UPDATE_LABS_REPORTS:
                    gsonRequest = RequestFactory.updateUploadLabReports(requestBody, listener, errorListener);
                    gsonRequest.setTag(type);
                    listenerHashMap.put(type, responseListner);
                    RequestHandler.getInstance(context).addToRequestQueue(gsonRequest);
                    break;
            }
        }
    }

    public void removeRequest(int tag) {
        requestHashMap.remove(tag);
        responseHashMap.remove(tag);
        listenerHashMap.remove(tag);
    }

    public void updateListener(int type, WebResponseListner gotListener) {
        if (listenerHashMap.containsKey(type)) {
            listenerHashMap.remove(type);
            listenerHashMap.put(type, gotListener);
        }
    }

    public interface WebResponseListner {
        void onWebResponseListner(int tag, int statusCode, JsonObject response);
    }

    public interface FragmentInteractionListener {
        void onFragmentInteraction(int what);

        void onFragmentInteraction(int what, Bundle bundle);
    }

}
