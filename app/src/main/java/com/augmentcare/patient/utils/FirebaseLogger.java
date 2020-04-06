package com.augmentcare.patient.utils;

import android.os.Bundle;

import com.augmentcare.patient.MyApp;
import com.google.firebase.analytics.FirebaseAnalytics;

public class FirebaseLogger {

    public static void viewFirebaseLogEvent(String eventType, String userId) {
        try {
            FirebaseAnalytics mFirebaseAnalytics;
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(MyApp.get());
            Bundle params = new Bundle();
            params.putString(FirebaseAnalytics.Param.ITEM_ID, userId);
            mFirebaseAnalytics.logEvent(eventType, params);
        } catch (Exception e) {
        }
    }

    public static void firebaseUserPropertyEvent(String eventType, String userId) {
        try {
            FirebaseAnalytics mFirebaseAnalytics;
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(MyApp.get());
            mFirebaseAnalytics.setUserProperty(eventType, userId);
        } catch (Exception e) {
        }
    }
}
