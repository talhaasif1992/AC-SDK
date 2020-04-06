package com.augmentcare.patient.utils;

import android.content.Context;
import android.os.Bundle;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.base.BaseActivity;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Qamar Ul Zama on 29/11/2017.
 */

public class AnalyticsUtils {

    public static void signupClick(Context context) {
        FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNUP_CLICK, new Bundle());
    }

    public static void signupSuccess(Context context) {
        Bundle bundle = new Bundle();
        //bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(baseActivity.userData.getUserId()));
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNUP_SUCCESS, bundle);

    }

    public static void signupFail(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNUP_FAIL, new Bundle());
    }

    public static void profileSetup(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.PROFILE_SETUP, new Bundle());
    }

    public static void profileSetupMe(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.PROFILE_SETUP, new Bundle());
    }

    public static void signinClick(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNIN_CLICK, new Bundle());
    }

    public static void signinSuccess(Context context) {
        Bundle bundle = new Bundle();
        BaseActivity baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
        try {
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(baseActivity.userData.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNIN_SUCCESS, bundle);
    }

    public static void signinFail(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SIGNIN_FAIL, new Bundle());
    }

    public static void searchClick(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEARCH_CLICK, constructBundle());
    }

    public static void searchByName(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEARCH_BY_NAME, constructBundle());
    }


    public static void searchResults(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIEW_SEARCH_RESULT, constructBundle());
    }

    public static void searchResultsFail(Context context) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIEW_SEARCH_RESULT_FAIL, constructBundle());
    }

    public static void specialityClick(Context context, String specility) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SPECIALITY_CLICK, constructBundle(specility));
    }

    public static void conditionClick(Context context, String condition) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.CONDITION_CLICK, constructBundle(condition));
    }

    public static void appointmentClick(Context context, String appointment) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.APPOINTMENT_CLICK, constructBundle(appointment));
    }

    public static void appointmentDetails(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIEW_APPOINTMENT_DETAIL, constructBundle(apptDetail));
    }

    public static void appointmentAddVital(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.APPOINTMENT_ADD_VITAL, constructBundle(apptDetail));
    }

    public static void appointmentDetailsStartConsultClick(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.APPOINTMENT_START_CONSULT_CLICK, constructBundle(apptDetail));
    }

    public static void appointmentVideoConsultScreen(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.APPOINTMENT_VIDEO_SCREEN, constructBundle(apptDetail));
    }

    public static void appointmentVideoConsultStart(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIDEO_CALL_START, constructBundle(apptDetail));
    }

    public static void appointmentVideoConsultDrop(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIDEO_CALL_DROPPED, constructBundle(apptDetail));
    }

    public static void itemClick(Context context, String name) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIEW_ITEM_CLICK, constructBundle(name));
    }

    public static void viewItem(Context context, String name) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.VIEW_ITEM, constructBundle(name));
    }

    public static void askQuestionClick(Context context, String name) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ASK_QUESTION_CLICK, constructBundle(name));
    }

    public static void chatScreen(Context context, String name) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.CHAT_SCREEN, constructBundle(name));
    }

    public static void sendMessageClick(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEND_MESSAGE_CLICK, constructBundle(content));
    }

    public static void sendMessageSuccess(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEND_MESSAGE_SUCCESS, constructBundle(content));
    }

    public static void sendMessageFial(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEND_MESSAGE_FAIL, constructBundle(content));
    }

    public static void sendMessageNotificationSuccess(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEND_NOTIFICATION_SUCCESS, constructBundle(content));
    }

    public static void sendMessageNotificationFial(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.SEND_NOTIFICATION_SUCCESS, constructBundle(content));
    }

    public static void sendAppointmentNotificationSuccess(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_NOTIFICATION_SUCCESS, constructBundle(content));
    }

    public static void sendAppointmentNotificationFail(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_NOTIFICATION_FAIL, constructBundle(content));
    }

    public static void appointmentCompleted(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.APPOINTMENT_COMPLETED, constructBundle(content));
    }

    public static void bookAppointmentClick(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.BOOK_APPOINTMENT_CLICK, constructBundle(content));
    }

    public static void bookAppointmentScreen(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_SCREEN, constructBundle(content));
    }

    public static void bookAppointmentDayClick(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_DAY_SELECTED, constructBundle(content));
    }

    public static void bookAppointmentLocationClick(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_LOCATION_SELECTED, constructBundle(content));
    }

    public static void bookAppointmentTimeClick(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_TIME_SELECTED, constructBundle(content));
    }

    public static void bookAppointmentPaymentMethod(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_PAYMENT_METHOD, constructBundle(content));
    }

    public static void bookPaymentClick(Context context, String doctorId, String amount) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_PAY_CLICK, constructBundle(doctorId, amount));
    }

    public static void bookPaymentSuccess(Context context, String doctorId, String amount) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_PAYMENT_SUCCESS, constructBundle(doctorId, amount));
    }

    public static void bookPaymentFail(Context context, String doctorId, String amount) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_PAYMENT_FAIL, constructBundle(doctorId, amount));
    }

    public static void bookingSuccess(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_BOOKING_SUCCESS, constructBundle(content));
    }

    public static void bookingFail(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_BOOKING_FAIL, constructBundle(content));
    }

    public static void bookingNotificationSuccess(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_NOTIFICATION_SUCCESS, constructBundle(content));
    }

    public static void bookingNotificationFail(Context context, String content) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.ADD_APPOINTMENT_NOTIFICATION_FAIL, constructBundle(content));
    }

    public static void googleSigninClick(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.GOOGLE_SIGNIN_CLICK, constructBundle(apptDetail));
    }

    public static void googleSigninSuccess(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.GOOGLE_SIGNIN_SUCCESS, constructBundle(apptDetail));
    }

    public static void googleSigninFail(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.GOOGLE_SIGNIN_FAIL, constructBundle(apptDetail));
    }

    public static void tutorialSkip(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.TUTORIAL_SKIP, constructBundle(apptDetail));
    }

    public static void tutorialStart(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.TUTORIAL_START, constructBundle(apptDetail));
    }

    public static void careScreen(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.CARE_SCREEN, constructBundle(apptDetail));
    }

    public static void myCareScreen(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.MY_CARE_SCREEN, constructBundle(apptDetail));
    }

    public static void tutorialPage(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.TUTORIAL_SCREEN, constructBundle(apptDetail));
    }

    public static void findDoctor(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.FIND_DOCTOR, constructBundle(apptDetail));
    }

    public static void myDoctor(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.MY_DOCTOR, constructBundle(apptDetail));
    }

    public static void labs(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.LABS, constructBundle(apptDetail));
    }

    public static void pharmacy(Context context, String apptDetail) {
        if (!BuildConfig.DEBUG)
            FirebaseAnalytics.getInstance(context).logEvent(FirebaseEvents.PHARMACY, constructBundle(apptDetail));
    }

    public static void logEvent(Context context, String eventName, String extra) {
        if (!BuildConfig.DEBUG)
            if (eventName != null) {
                if (extra != null)
                    FirebaseAnalytics.getInstance(context).logEvent(eventName, constructBundle(extra));
                else
                    FirebaseAnalytics.getInstance(context).logEvent(eventName, constructBundle());
            }
    }

    private static Bundle constructBundle() {
        Bundle bundle = new Bundle();
        try {
            BaseActivity baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
            //bundle.putString(FirebaseAnalytics.Param.CREATIVE_NAME, baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
            if (baseActivity.userData != null)
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(baseActivity.userData.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }

    private static Bundle constructBundle(String content) {
        Bundle bundle = new Bundle();
        try {
            BaseActivity baseActivity = (BaseActivity) ActivityUtils.getTopActivity();

            //bundle.putString(FirebaseAnalytics.Param.CREATIVE_NAME, baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
            bundle.putString(FirebaseAnalytics.Param.CONTENT, content);
            //bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
            if (baseActivity.userData != null)
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(baseActivity.userData.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }

    private static Bundle constructBundle(String doctorId, String amount) {
        Bundle bundle = new Bundle();
        try {
            BaseActivity baseActivity = (BaseActivity) ActivityUtils.getTopActivity();

            // bundle.putString(FirebaseAnalytics.Param.CREATIVE_NAME, baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
            bundle.putString("amount", amount);
            bundle.putString("doctor_id", doctorId);
            //bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName());
            if (baseActivity.userData != null)
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(baseActivity.userData.getUserId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }
}
