package com.augmentcare.patient.utils;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.blankj.utilcode.util.Utils;
import com.segment.analytics.Analytics;
import com.segment.analytics.Options;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.android.integrations.intercom.IntercomIntegration;

import java.util.HashMap;
import java.util.Map;

public class SegmentAPIUtils {
    public static void init_API() {
        try {
            // Create an analytics client with the given context and Segment write key.
            Analytics analytics = new Analytics.Builder(MyApp.get(), Utils.getApp().getString(R.string.segment_api_key))
                    .trackApplicationLifecycleEvents() // Enable this to record certain application events automatically!
                    .recordScreenViews() // Enable this to record screen views automatically!
                    .use(IntercomIntegration.FACTORY)
                    .build();

// Set the initialized instance as a globally accessible instance.
            Analytics.setSingletonInstance(analytics);
        } catch (Exception e) {
        }
    }

    public static void logCompleteRegistrationEvent(String eventType, String status, String currency, String contentName, String value, String Signup_type) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.VALUE, value)
                                    .putValue(Constants.STATUS, status)
                                    .putValue(Constants.STATUS, status)
                                    .putValue(Constants.SIGNUP_TYPE, Signup_type)
                    );
        } catch (Exception e) {
        }
    }

    public static void logLeadEvent(String eventType, String contentCategory, String contentName, String currency, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logInitiateCheckoutEvent(String eventType, String contentCategory, String contentId, String content, String currency,
                                                String numberItems, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.NUMBER_ITEMS, numberItems)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logAddToWishlistEvent(String eventType, String currency, String contentName, String contentCategory, String contentId,
                                             String content, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logAddToCartEvent(String eventType, String contentId, String contentName, String contentType, String content,
                                         String currency, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.CONTENT_TYPE, contentType)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logAddPaymentInfoEvent(String eventType, String currency, String contentCategory, String contentId, String content, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logEventSchedule(String eventType, String contentId, String contentType, String specialization, String booking_time) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.ID_appointment, contentId)
                                    .putValue(Constants.BOOK_APPOINTMENT, contentType)
                                    .putValue(Constants.BOOKING_TIME, booking_time)
                                    .putValue(Constants.SPECAILIZATION, specialization)
                    );
        } catch (Exception e) {
        }

    }

    public static void logEventContact(String eventType, String contentId) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_ID, contentId)
                    );
        } catch (Exception e) {
        }
    }

    public static void startTrail100(String eventType, String currency, String predicted_ltv, String value, String discountprice) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.PREDICTED_LTV, predicted_ltv)
                                    .putValue(Constants.VALUE, value)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.DISCOUNT_AMOUNT, discountprice)
                                    .putValue(Constants.PLAN_FULL_AMOUNT, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void startTrailSubscribe(String eventType, String currency, String predicted_ltv, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.PREDICTED_LTV, predicted_ltv)
                                    .putValue(Constants.VALUE, value)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.PLAN_FULL_AMOUNT, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void logPurchaseEvent(String eventType, String contentId, String contentName, String contentType, String content,
                                        String numberItems, String value, String currency) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.CONTENT_TYPE, contentType)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.NUMBER_ITEMS, numberItems)
                                    .putValue(Constants.VALUE, value)
                                    .putValue(Constants.CURRENCY, currency)
                    );
        } catch (Exception e) {
        }

    }

    public static void logSearchEvent(String eventType, String contentCategory, String contentId, String content, String currency,
                                      String searchString, String value) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_ID, contentId)
                                    .putValue(Constants.CONTENT, content)
                                    .putValue(Constants.CURRENCY, currency)
                                    .putValue(Constants.SEARCH_STRING, searchString)
                                    .putValue(Constants.VALUE, value)
                    );
        } catch (Exception e) {
        }

    }

    public static void viewControllerLogEvent(String contentCategory, String contentName, String eventType, String value, String currency) {

        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue(Constants.CONTENT_CATEGORY, contentCategory)
                                    .putValue(Constants.CONTENT_NAME, contentName)
                                    .putValue(Constants.EVENT_TYPE, "ViewContent")
                                    .putValue(Constants.VALUE, value)
                                    .putValue(Constants.CURRENCY, currency)
                    );
        } catch (Exception e) {
        }

    }

    public static void intercomLeadEvent(String contentCategory, String contentName, String currency, String value) {

        try {
            Analytics.with(MyApp.get())
                    .track(
                            "lead",
                            new Properties()
                                    .putValue("content_category", contentCategory)
                                    .putValue("content_name", contentName)
                                    .putValue("currency", currency)
                                    .putValue("value", value)
                    );
        } catch (Exception e) {
        }

    }

    public static void intercomAppointmentSuccessEvent(String appointmentTime, String appointmentId) {
        try {
            Analytics.with(MyApp.get())
                    .track(
                            "id_appointment_success",
                            new Properties()
                                    .putValue("appointment_time", appointmentTime)
                                    .putValue("appointment_id", appointmentId)
                    );
        } catch (Exception e) {
            
        }

    }

    public static void intercomEvent(String userId, String eventType) {

        try {
            Analytics.with(MyApp.get())
                    .track(
                            eventType,
                            new Properties()
                                    .putValue("user_id", userId)
                    );
        } catch (Exception e) {
            
        }
    }

    public static void registerUserOnIntercom(String firstName, String lastName, String email, String phone) {
        try {
            Analytics.with(MyApp.get())
                    .identify(
                            new Traits()
                                    .putFirstName(firstName)
                                    .putLastName(lastName)
                                    .putEmail(email)
                                    .putPhone(phone)
                    );
        } catch (Exception e) {
            
        }

    }

    public static void registerIdentifiedUserIntercom(String userID,String userHash){
        try {
            Traits traits = new Traits();
            Map<String, Object> intercomOptions = new HashMap<>();
            intercomOptions.put("userHash", userHash);
            Options options = new Options().setIntegrationOptions("Intercom", intercomOptions);
            Analytics.with(MyApp.get()).identify(userID, traits, options);
        } catch (Exception e) {
            
        }
    }
}
