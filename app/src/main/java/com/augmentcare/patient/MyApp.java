package com.augmentcare.patient;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.RatingBar;

import androidx.multidex.MultiDexApplication;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.augmentcare.patient.model.Role;
import com.augmentcare.patient.network.restApi.apimodels.Organization;
import com.augmentcare.patient.utils.AdjustSDKUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.IntercomUtils;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.SegmentAPIUtils;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.plugins.RxJavaPlugins;

public class MyApp extends MultiDexApplication {
    private static boolean APP_CONNECTED = true;
    private static Gson mGson;
    private ArrayList<Role> roles;
    private ArrayList<String> creditCardBinNumbers;
    private Role role;
    public static boolean isReloadConsultations;
    public static int screenIndex = -1;
    public static boolean SHOW_INTERCOM;
    private static final String PROPERTY_ID = "UA-111612067-1";
    public static final Handler HANDLER = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);

        SegmentAPIUtils.init_API();

        FirebaseApp.initializeApp(this);

        firebaseRemoteConfigFix();

        if(BuildConfig.DEBUG) {
            setupCrashLytics(); // listen to crashes
        }

        AdjustSDKUtils.initSDK(this);

        try {
            AppEventsLogger.activateApp(this);
            isReloadConsultations = false;
            if (!PrefsHelper.get(this).getBoolean(Constants.KEY_IS_LOGIN, false)) {
                PrefsHelper.get(this).clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        IntercomUtils.initSDK();

        LocalUtils.adjustFontScale(getResources().getConfiguration());

        rxJavaShittyErrorsFix();

        firebaseTokenIDFix();
    }



    /**
     * Enum used to identify the tracker that needs to be used for tracking.
     *
     * A single tracker is usually enough for most purposes. In case you do need multiple trackers,
     * storing them all in Application object helps ensure that they are created only once per
     * application instance.
     */
    public enum TrackerName {
        APP_TRACKER, // Tracker used only in this app.
        GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg: roll-up tracking.
        ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a company.
    }

    HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

    public MyApp() {
        super();
    }



    public static void firebaseTokenIDFix(){
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCanceledListener(() -> { })
                .addOnFailureListener(e -> { })
                .addOnCompleteListener(
                        idResult -> {
                            if(!idResult.isSuccessful() || idResult.getResult() == null){
                                return;
                            }
                            String token = "";
                            token = idResult.getResult().getToken();
                            PrefsHelper.setFirebaseToken(token);
                        }
                );
    }

    private void rxJavaShittyErrorsFix(){
        RxJavaPlugins.setErrorHandler(e -> {
            if (e instanceof UndeliverableException) {
                e = e.getCause();
            }
            if ((e instanceof IOException) || (e instanceof SocketException)) {
                // fine, irrelevant network problem or API that throws on cancellation
                return;
            }
            if (e instanceof InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return;
            }
            if ((e instanceof NullPointerException) || (e instanceof IllegalArgumentException)) {
                // that's likely a bug in the application
                Thread.UncaughtExceptionHandler handler =  Thread.currentThread().getUncaughtExceptionHandler();
                if(handler != null){
                    handler.uncaughtException(Thread.currentThread(), e);
                }
                return;
            }
            if (e instanceof IllegalStateException) {
                // that's a bug in RxJava or in a custom operator
                Thread.UncaughtExceptionHandler handler =  Thread.currentThread().getUncaughtExceptionHandler();
                if(handler != null){
                    handler.uncaughtException(Thread.currentThread(), e);
                }
            }
//            Log.warning("Undeliverable exception received, not sure what to do", e);
        });
    }

    private void firebaseRemoteConfigFix(){
        FirebaseRemoteConfig mFirebaseRemoteConfig = null;
        try {
            mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

            long cacheExpiration = 3600; // 1 hour in seconds.

            if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
                cacheExpiration = 0;
            }

            mFirebaseRemoteConfig.fetch(cacheExpiration);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void SET_IS_CONNECTED(boolean connected) {
        APP_CONNECTED = connected;
    }

    public static boolean GET_IS_CONNECTED() {
        return APP_CONNECTED;
    }

    public static MyApp get() {
        return (MyApp) Utils.getApp();
    }

    public void nullifyUser() {
        roles = null;
        role = null;
    }


    public ArrayList<String> getCreditCardBinNumbers() {
        return creditCardBinNumbers;
    }

    public void setCreditCardBinNumbers(ArrayList<String> creditCardBinNumbers) {
        this.creditCardBinNumbers = creditCardBinNumbers;
    }

    public boolean isDoctorApp() {
        return getApplicationContext().getPackageName().contains("doctor");
    }

    public synchronized void setOnlineUsers(HashMap<String, String> maps) {
        onlineUsers = maps;
    }

    HashMap<String, String> onlineUsers;

    public synchronized boolean isUserOnline(String key) {
        if (onlineUsers != null) {
            return onlineUsers.containsKey(key);
        }
        return false;
    }

    public Organization getOrganization() {
        String organizationJson = PrefsHelper.get(this).getString(Constants.KEY_ORGANIZATION, "");

        if (!organizationJson.isEmpty())
            return GsonUtils.getGson().fromJson(organizationJson, Organization.class);
        return null;
    }

    public void setOrganization(Organization organization) {
        if(organization != null)
            PrefsHelper.get(this).putString(Constants.KEY_ORGANIZATION, GsonUtils.toJson(organization));
    }

    public void adjustEvent(String eventType) {
        AdjustEvent adjustEvent = new AdjustEvent(eventType);
//        adjustEvent.addCallbackParameter("user_id", userId);
        Adjust.trackEvent(adjustEvent);
    }

    public Role getRole() {
        if (roles == null) {
            roles = new ArrayList<>();
            String uInfo = PrefsHelper.get(this).getString(Constants.KEY_ROLES, "");
            Role[] rolesArr = GsonUtils.getGson().fromJson(uInfo, Role[].class);
            for (int i = 0; i < rolesArr.length; i++) {
                if (getPackageName().contains("doctor")) {
                    if (rolesArr[i].getRoleId().equals("2")) {
                        role = rolesArr[i];
                    }
                }
                if (getPackageName().contains("patient")) {
                    if (rolesArr[i].getRoleId().equals("3")) {
                        role = rolesArr[i];
                    }
                }
                roles.add(rolesArr[i]);
            }
        }
        return role;
    }

    public synchronized Tracker getTracker() {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        return analytics.newTracker("UA-111612067-1");
    }

//    public synchronized Tracker getTracker(TrackerName trackerId) {
//        if (!mTrackers.containsKey(trackerId)) {
//
//            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
//            Tracker t = (trackerId == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID)
//                    : (trackerId == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker)
//                    : analytics.newTracker(R.xml.ecommerce_tracker);
//            mTrackers.put(trackerId, t);
//
//        }
//        return mTrackers.get(trackerId);
//    }


    public void navigate() {
        try {
            String deepLink = PrefsHelper.get(this).getString(Constants.DEEP_LINK, "");

            if (!PrefsHelper.get(this).getString(Constants.DEEP_LINK, "").isEmpty()) {
                if (deepLink != null && deepLink.contains("plans")) {
                    if (PrefsHelper.isOnPlan()) {
                        {
//                            Intent currentPlan = new Intent(this, MyCurrentPlanActivity.class);
//                            startActivity(currentPlan);
                        }
                    } else {
//                        Intent planIntent = new Intent(this, PlanSelectionActivity.class);
//                        planIntent.putExtra("alertdialogShowFlag", "notShow");
//                        startActivity(planIntent);
                    }
                } else if (deepLink != null && deepLink.contains("instant-doctor")) {
                    // #TODO open Instant doctor fragment
//                    Intent intent = new Intent(this, _InstantAppointmentActivity.class);
//                    startActivity(intent);
                } else if (deepLink != null && deepLink.contains("labs")) {
//                    Intent intent = new Intent(this, OrderLabActivity.class);
//                    startActivity(intent);
                } else if (deepLink != null && deepLink.contains("explore-doctor")) {
//                    Intent intent = new Intent(this, FindDoctorActivity.class);
//                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void computeRating(RatingBar ratingBar, float rating) {
        try {
            String[] strValues = String.valueOf(rating).split("\\.");
            float val1 = Float.parseFloat(strValues[0]); // 2.0
            float val2 = Float.parseFloat(strValues[1]); // 0.75
            float compareRating = (val2 / 100);

            if (compareRating > 0.05 || compareRating < 0.3) {
                ratingBar.setStepSize(Float.parseFloat("0.3"));
                ratingBar.setRating(rating);
            } else {
                ratingBar.setStepSize(Float.parseFloat("0.01"));
                ratingBar.setRating(rating);
            }
        } catch (Exception ignored) {
        }
    }

    private void setupCrashLytics() {

//        // #TODO uncomment it
//        Crashlytics crashlyticsKit = new Crashlytics.Builder()
//                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
//                .build();
//
//        // Initialize Fabric with the debug-disabled crashlytics.
//        Fabric.with(this, crashlyticsKit);


        FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();
        crashlytics.log("my message");
// To log a message to a crash report, use the following syntax:
        crashlytics.log("E/TAG: my message");


        String folderPath = Environment.getExternalStorageDirectory() + "/AugmentCare/Crashes/";

        // text file generate crash
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .callback(new PermissionUtils.SimpleCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onGranted() {
                        CrashUtils.init(new File(folderPath, "crash_reports"));
                    }

                    @Override
                    public void onDenied() {
                    }
                }).request();

    }

    public static Gson getGson() {
        if (mGson == null) {
            mGson = new GsonBuilder().create();
        }
        return mGson;
    }


}