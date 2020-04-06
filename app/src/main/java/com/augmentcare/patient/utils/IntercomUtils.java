package com.augmentcare.patient.utils;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.base.BaseActivity;
import com.blankj.utilcode.util.ActivityUtils;

import java.util.HashMap;
import java.util.Map;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UnreadConversationCountListener;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.identity.Registration;

public class IntercomUtils {

    public static void initSDK(){
        try {
            Intercom.initialize(MyApp.get(), BuildConfig.INTERCOME_API_KAY, BuildConfig.INTERCOME_APP_ID);
            BaseActivity baseActivity =  (BaseActivity) ActivityUtils.getTopActivity();
            if (PrefsHelper.isLoggedIn() && baseActivity != null && baseActivity.userData != null && baseActivity.userData.getUserId() >= 0) {
                Registration registration = Registration.create().withUserId("" + baseActivity.userData.getUserId());
                Intercom.client().registerIdentifiedUser(registration);
                if (baseActivity.userData.getAndroidhmc() != null && !baseActivity.userData.getAndroidhmc().isEmpty())
                    Intercom.client().setUserHash(baseActivity.userData.getAndroidhmc());

                UserAttributes userAttributes = new UserAttributes.Builder()
                        .withName((baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName()))
                        .withEmail(baseActivity.userData.getEmail())
                        .withCustomAttribute("Phone", baseActivity.userData.getPhone())
                        .build();

                Intercom.client().updateUser(userAttributes);
            } else {
                /* Since we aren't logged in, we are an unidentified user.
                 * Let's register. */
                Intercom.client().registerUnidentifiedUser();
            }

            Intercom.client().addUnreadConversationCountListener(new UnreadConversationCountListener() {
                @Override
                public void onCountUpdate(int i) {
                    if (i > 0) {
                        MyApp.SHOW_INTERCOM = true;
                        Intercom.client().setLauncherVisibility(Intercom.VISIBLE);
                    } else {
                        MyApp.SHOW_INTERCOM = false;
                        Intercom.client().setLauncherVisibility(Intercom.GONE);
                    }
                }
            });
            Intercom.client().setLauncherVisibility(Intercom.GONE);
            Intercom.client().handlePushMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void intercomLeadEvent(String contentCategory, String contentName, String currency, String value) {
        try {
            Map<String, Object> eventData = new HashMap<>();
            eventData.put("content_category", contentCategory);
            eventData.put("content_name", contentName);
            eventData.put("currency", currency);
            eventData.put("value", value);
            Intercom.client().logEvent("lead", eventData);
        } catch (Exception ignored) {
        }
    }

    public static void intercomAppointmentSuccessEvent(String appointmentTime, String appointmentId) {
        try {
            Map<String, Object> eventData = new HashMap<>();
            eventData.put("appointment_time", appointmentTime);
            eventData.put("appointment_id", appointmentId);
            Intercom.client().logEvent("id_appointment_success", eventData);
        } catch (Exception ignored) {
        }
    }

    public static void intercomEvent(String userId, String eventType) {
        try {
            Map<String, Object> eventData = new HashMap<>();
            eventData.put("user_id", userId);
            Intercom.client().logEvent(eventType, eventData);
        } catch (Exception ignored) {
        }
    }

    public static void registerUserOnIntercom(String firstName, String lastName, String email, String phone) {
        try {
            UserAttributes userAttributes = new UserAttributes.Builder().withName((firstName + " " + lastName)).withEmail(email).withPhone(phone).build();
            Intercom.client().updateUser(userAttributes);
        } catch (Exception ignored) {
        }
    }


}
