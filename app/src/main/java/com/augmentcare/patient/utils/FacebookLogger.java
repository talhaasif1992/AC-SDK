package com.augmentcare.patient.utils;

import android.os.Bundle;

import com.augmentcare.patient.MyApp;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

public class FacebookLogger {

    public static void logAddedToCartEvent(String contentData, String contentId, String contentType, String currency, double price) {
        AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT, contentData);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency);
        logger.logEvent(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, price, params);
    }

    public static void logCompleteRegistrationEvent(String eventType, String status, String currency, String contentName, String value, String Signup_type) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.VALUE, value);
            params.putString(Constants.STATUS, status);
            params.putString(Constants.STATUS, status);
            params.putString(Constants.SIGNUP_TYPE, Signup_type);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {

        }
    }

    public static void logLeadEvent(String eventType, String contentCategory, String contentName, String currency, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {
        }
    }

    public static void logInitiateCheckoutEvent(String eventType, String contentCategory, String contentId, String content, String currency,
                                         String numberItems, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.NUMBER_ITEMS, numberItems);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {

        }
    }

    public static void logAddToWishlistEvent(String eventType, String currency, String contentName, String contentCategory, String contentId,
                                      String content, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {
        }
    }

    public static void logAddToCartEvent(String eventType, String contentId, String contentName, String contentType, String content,
                                  String currency, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.CONTENT_TYPE, contentType);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {

        }
    }

    public static void logAddPaymentInfoEvent(String eventType, String currency, String contentCategory, String contentId, String content, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {
        }
    }

    public static void logEventSchedule(String eventType, String contentId, String contentType, String specialization, String booking_time) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.ID_appointment, contentId);
            params.putString(Constants.BOOK_APPOINTMENT, contentType);
            params.putString(Constants.BOOKING_TIME, booking_time);
            params.putString(Constants.SPECAILIZATION, specialization);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {
        }
    }

    public static void logEventContact(String eventType, String contentId) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_ID, contentId);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {

        }
    }

    public static void startTrail100(String eventType, String currency, String predicted_ltv, String value, String discountprice) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.PREDICTED_LTV, predicted_ltv);
            params.putString(Constants.VALUE, value);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.DISCOUNT_AMOUNT, discountprice);
            params.putString(Constants.PLAN_FULL_AMOUNT, value);
            logger.logEvent(eventType, Integer.parseInt(value), params);
        } catch (Exception e) {
        }
    }

    public static void startTrailSubscribe(String eventType, String currency, String predicted_ltv, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.PREDICTED_LTV, predicted_ltv);
            params.putString(Constants.VALUE, value);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.PLAN_FULL_AMOUNT, value);
            logger.logEvent(eventType, Integer.parseInt(value), params);
        } catch (Exception e) {

        }
    }

    public static void logPurchaseEvent(String eventType, String contentId, String contentName, String contentType, String content,
                                 String numberItems, String value, String currency) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.CONTENT_TYPE, contentType);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.NUMBER_ITEMS, numberItems);
            params.putString(Constants.VALUE, value);
            params.putString(Constants.CURRENCY, currency);
            logger.logEvent(eventType, Integer.parseInt(value), params);
        } catch (Exception e) {

        }
    }

    public static void logSearchEvent(String eventType, String contentCategory, String contentId, String content, String currency,
                               String searchString, String value) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_ID, contentId);
            params.putString(Constants.CONTENT, content);
            params.putString(Constants.CURRENCY, currency);
            params.putString(Constants.SEARCH_STRING, searchString);
            params.putString(Constants.VALUE, value);
            logger.logEvent(eventType, Integer.parseInt(value), params);
        } catch (Exception e) {
        }
    }

    public static void viewControllerLogEvent(String contentCategory, String contentName, String eventType, String value, String currency) {
        try {
            AppEventsLogger logger = AppEventsLogger.newLogger(MyApp.get());
            Bundle params = new Bundle();
            params.putString(Constants.CONTENT_CATEGORY, contentCategory);
            params.putString(Constants.CONTENT_NAME, contentName);
            params.putString(Constants.EVENT_TYPE, "ViewContent");
            params.putString(Constants.VALUE, value);
            params.putString(Constants.CURRENCY, currency);
            logger.logEvent(eventType, 0, params);
        } catch (Exception e) {
        }
    }
}
