package com.augmentcare.patient.utils;

import android.content.Context;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;
import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.R;

public class AdjustSDKUtils {

    public static void initSDK(Context context) {
        try {
            String appToken = context.getString(R.string.adjust_sdk_app_token);
            String environment = BuildConfig.ADJUST_SDK_ENVIRONMENT;
            AdjustConfig config = new AdjustConfig(context, appToken, environment, true);
            config.setLogLevel(LogLevel.VERBOSE);
            Adjust.onCreate(config);
        } catch (Exception e) {
        }
    }

    public static void adjustRevenueEvent(String eventType, double generatedRevenue) {
        AdjustEvent adjustEvent = new AdjustEvent(eventType);
        adjustEvent.setRevenue(generatedRevenue, "PKR");
        Adjust.trackEvent(adjustEvent);
    }

}
