package com.augmentcare.patient.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.model.doctorDetails.DoctorDetail;
import com.augmentcare.patient.model.instantDoctorModel.InstantDoctor;
import com.augmentcare.patient.model.Policy;
import com.augmentcare.patient.model.SickNotesInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.tozny.crypto.android.AesCbcWithIntegrity;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrefsHelper {
    private static final String KEY_PREFS = "prefs";
    private static PrefsHelper ourInstance;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    //secret keys used for enc and dec
    private AesCbcWithIntegrity.SecretKeys keys;

    //the salt used for enc and dec
    private String salt = "AC8978765698";

    public static PrefsHelper get(Context context) {
        if (ourInstance == null) {
            ourInstance = new PrefsHelper(context,KEY_PREFS);
        }
        return ourInstance;
    }
    public static PrefsHelper get(Context context,String prefKEY) {
        return new PrefsHelper(context,prefKEY);
    }

    private PrefsHelper(Context context,String prefsKEY) {
        preferences = context.getSharedPreferences(prefsKEY, 0);
        editor = preferences.edit();
        try {
            /*final String key = generateAesKeyName(context);
            this.keys = AesCbcWithIntegrity.generateKey();
            this.salt = getDeviceSerialNumber(context);*/
            final byte[] saltBytes = getSalt(context).getBytes();
            keys = AesCbcWithIntegrity.generateKeyFromPassword(salt, saltBytes);

            if (keys == null) {
                throw new GeneralSecurityException("Problem generating Key From Password");
            }
        } catch (GeneralSecurityException e) {
            //throw new IllegalStateException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //migration to secure preferences
        if (preferences.contains(Constants.KEY_IS_LOGIN)) {
            HashMap<String, Object> objectHashMap = (HashMap<String, Object>) preferences.getAll();
            Iterator it = objectHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, ?> pair = (Map.Entry) it.next();

                if (pair.getValue() instanceof String) {
                    putString(pair.getKey(), (String) pair.getValue());
                }
                if (pair.getValue() instanceof Integer) {
                    putInt(pair.getKey(), (Integer) pair.getValue());
                }
                if (pair.getValue() instanceof Boolean) {
                    putBoolean(pair.getKey(), (Boolean) pair.getValue());
                }
                if (pair.getValue() instanceof Long) {
                    putLong(pair.getKey(), (Long) pair.getValue());
                }
                if (pair.getValue() instanceof Float) {
                    putFloat(pair.getKey(), (Float) pair.getValue());
                }
                it.remove();
                editor.remove(pair.getKey());
            }
            editor.commit();
        }
    }

    @SuppressLint("HardwareIds")
    private static String getDeviceSerialNumber(Context context) {
        // We're using the Reflection API because Build.SERIAL is only available
        // since API Level 9 (Gingerbread, Android 2.3).
        try {
            String deviceSerial = (String) Build.class.getField("SERIAL").get(
                    null);
            if (deviceSerial != null && deviceSerial.isEmpty()) {
                return Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
            } else {
                return deviceSerial;
            }
        } catch (Exception ignored) {
            // Fall back  to Android_ID
            return Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        }
    }



    private String generateAesKeyName(Context context) throws GeneralSecurityException {
        final String password = context.getPackageName();
        final byte[] salt = getSalt(context).getBytes();
        AesCbcWithIntegrity.SecretKeys generatedKeyName = AesCbcWithIntegrity.generateKeyFromPassword(password, salt);

        return hashPrefKey(generatedKeyName.toString());
    }

    private String getSalt(Context context) {
        if (salt.isEmpty()) {
            return getDeviceSerialNumber(context);
        } else {
            return this.salt;
        }
    }

    private String encrypt(String cleartext) {
        if (cleartext != null && cleartext.isEmpty()) {
            return cleartext;
        }
        try {
            return AesCbcWithIntegrity.encrypt(cleartext, keys).toString();
        } catch (GeneralSecurityException e) {

            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


    public String getString(String key, String defaultValue) {
        final String encryptedValue = preferences.getString(hashPrefKey(key), "");
        String decryptedValue = decrypt(encryptedValue);
        if (encryptedValue != null && decryptedValue != null) {
            return decryptedValue;
        } else {
            return defaultValue;
        }
    }

    public int getInt(String key, int defaultValue) {

        if (preferences.contains(hashPrefKey(key))) {
            return Integer.valueOf(decrypt(preferences.getString(hashPrefKey(key), String.valueOf(defaultValue))));
        } else {
            return defaultValue;
        }
    }

    public boolean contains(String key) {
        return preferences.contains(hashPrefKey(key));
    }

    public float getFloat(String key, float defaultValue) {
        if (preferences.contains(hashPrefKey(key))) {
            return Float.valueOf(decrypt(preferences.getString(hashPrefKey(key), String.valueOf(defaultValue))));
        } else {
            return defaultValue;
        }
    }

    public float getLong(String key, long defaultValue) {
        if (preferences.contains(hashPrefKey(key))) {
            return Long.valueOf(decrypt(preferences.getString(hashPrefKey(key), String.valueOf(defaultValue))));
        } else {
            return defaultValue;
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (preferences.contains(hashPrefKey(key))) {
            return Boolean.valueOf(decrypt(preferences.getString(hashPrefKey(key), String.valueOf(defaultValue))));
        } else {
            return defaultValue;
        }
    }

    public boolean getBoolean(String key) {
        if (preferences.contains(hashPrefKey(key))) {
            return preferences.getBoolean(key, true);
        } else {
            return true;
        }
    }

    private String decrypt(final String ciphertext) {
        if (ciphertext != null && ciphertext.isEmpty()) {
            return ciphertext;
        }
        try {
            AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = new AesCbcWithIntegrity.CipherTextIvMac(ciphertext);

            return AesCbcWithIntegrity.decryptString(cipherTextIvMac, keys);
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    private PrefsHelper() {
    }

    /*public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public float getFloat(String key, float defaultValue) {
        return preferences.getFloat(key, defaultValue);
    }

    public float getLong(String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);

    }
    public void remove(String key){
        editor.remove(key);
    }
    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public boolean contains(String key) {
        return preferences.contains(key);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }*/

    public void putInt(String key, int value) {
        editor.putString(hashPrefKey(key),
                encrypt(Integer.toString(value)));
        editor.commit();
    }


    public void putLong(String key, long value) {
        editor.putString(hashPrefKey(key), encrypt(Long.toString(value)));
        editor.commit();
    }


    public void putFloat(String key, float value) {
        editor.putString(hashPrefKey(key), encrypt(Float.toString(value)));
        editor.commit();
    }


    public void putBoolean(String key, boolean value) {
        editor.putString(hashPrefKey(key), encrypt(Boolean.toString(value)));
        editor.commit();
    }

    public void putBoolean(String key, boolean value, String type) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putString(String key, String value) {
        editor.putString(hashPrefKey(key), encrypt(value));
        editor.commit();
    }

    public void remove(String key) {
        try {
            editor.remove(hashPrefKey(key));
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String hashPrefKey(String prefKey) {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = prefKey.getBytes(StandardCharsets.UTF_8);
            digest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(digest.digest(), AesCbcWithIntegrity.BASE64_FLAGS);
        } catch (NoSuchAlgorithmException e) {

        }
        return null;
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    public Map<String, ?> getAll() {
        return preferences.getAll();
    }


    /////////////////////////// APP Specific Prefs Functions /////////////////

    public static void setLoggedInUser(UserLogin user){
        if(user == null){
            PrefsHelper.get(MyApp.get()).remove(Constants.KEY_LOGGED_IN_USER);
            return;
        }
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_LOGGED_IN_USER,GsonUtils.toJson(user));
    }

    public static UserLogin getLoggedInUser() {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.KEY_LOGGED_IN_USER, "");
        return GsonUtils.getGson().fromJson(uInfo, UserLogin.class);
    }
    public static UserDataLogin getUserInfo() {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.KEY_USER_DATA, "");
        return GsonUtils.getGson().fromJson(uInfo, UserDataLogin.class);
    }

    public static DoctorDetail getDoctorDetail() {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.EXPLORE_PROFILE_DATA, "");
        return GsonUtils.getGson().fromJson(uInfo, DoctorDetail.class);
    }

    public static InstantDoctor getInstantDoctor() {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.INSTANT_PROFILE_DATA, "");
        return GsonUtils.getGson().fromJson(uInfo, InstantDoctor.class);
    }

    public static SickNotesInfo getSickNotes() {
        String uInfo = PrefsHelper.get(MyApp.get()).getString(Constants.KEY_SICK_INFO, "");
        return GsonUtils.getGson().fromJson(uInfo, SickNotesInfo.class);
    }

    public static void setUserInfo(UserDataLogin info) {
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_USER_DATA, GsonUtils.getGson().toJson(info));
    }

    public static ArrayList<Policy> getPolicies() {
        if(PrefsHelper.get(MyApp.get()).contains(Constants.KEY_POLICY)) {
            Type listType = new TypeToken<ArrayList<Policy>>() {
            }.getType();
            if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_POLICY)) {

                try {
                    Policy singlePolicy = GsonUtils.fromJson(PrefsHelper.get(MyApp.get()).getString(Constants.KEY_POLICY, ""),Policy.class);
                    ArrayList<Policy> list = new ArrayList<>();
                    list.add(singlePolicy);
                    return list;
                } catch (Exception e) {
                }
                return GsonUtils.getGson().fromJson(PrefsHelper.get(MyApp.get()).getString(Constants.KEY_POLICY, ""),
                        listType);
            }
        }
        return new ArrayList<>();
    }

    public static boolean haveUnlimitedPolicy() {
        boolean isUnlimited = false;
        if (getPolicies() != null) {
            for (Policy policy : getPolicies()) {
                if (policy.isIs_unlimited()) {
                    return true;
                }
            }
        }
        return isUnlimited;
    }



    public static int getVersionCodeBeforeAppUpdate(){
        int islogin = 0;
        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_CURRENT_VERSION)) {
            islogin = PrefsHelper.get(MyApp.get()).getInt(Constants.KEY_CURRENT_VERSION, islogin);
        }
        return islogin;
    }

    public static void setLastVersionCode(int code){
        PrefsHelper.get(MyApp.get()).putInt(Constants.KEY_CURRENT_VERSION, code);
    }
    public static void setRemeberMe(boolean remeberMe){
        PrefsHelper.get(MyApp.get()).putBoolean(Constants.KEY_REMEBER_ME, remeberMe);
    }

    public static boolean isRememberMe(){
        boolean rememberMe = true;
        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_REMEBER_ME)) {
            rememberMe = PrefsHelper.get(MyApp.get()).getBoolean(Constants.KEY_REMEBER_ME, true);
        }
        return rememberMe;
    }

    public static boolean isLoggedIn() {
        boolean islogin = false;
        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_IS_LOGIN)) {
            islogin = PrefsHelper.get(MyApp.get()).getBoolean(Constants.KEY_IS_LOGIN, false);
        }
        return islogin;
    }

    public static boolean isOnPlan() {
        boolean onPlan = false;
        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_IS_ON_PLAN)) {
            onPlan = PrefsHelper.get(MyApp.get()).getBoolean(Constants.KEY_IS_ON_PLAN, false);
        }
        return onPlan;
    }

    public static String getUserPlan() {
        String userplan = "";
        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_GET_USER_PLAN)) {
            userplan = PrefsHelper.get(MyApp.get()).getString(Constants.KEY_GET_USER_PLAN, "");
        }
        return userplan;
    }
    public static void setUserPlan(String planid) {
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_GET_USER_PLAN, planid);
    }

    public static void setOnPlan(Boolean b) {
        PrefsHelper.get(MyApp.get()).putBoolean(Constants.KEY_IS_ON_PLAN, b);

    }

    public static boolean isDependent() {
        boolean onPlan = false;

        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_IS_DEPENDENT)) {
            onPlan = PrefsHelper.get(MyApp.get()).getBoolean(Constants.KEY_IS_DEPENDENT, false);
        }
        return onPlan;
    }

    public static boolean isFromOrganization() {
        boolean KEY_FROM_ORGANIZATION = false;

        if (PrefsHelper.get(MyApp.get()).contains(Constants.KEY_FROM_ORGANIZATION)) {
            KEY_FROM_ORGANIZATION = PrefsHelper.get(MyApp.get()).getBoolean(Constants.KEY_FROM_ORGANIZATION, false);
        }
        return KEY_FROM_ORGANIZATION;
    }

    public static String getAccessTokenFromSP(){
        return PrefsHelper.get(MyApp.get()).getString(Constants.KEY_ACCESS_TOKEN, "");
    }

    public static int getNotificationCount(){
        return PrefsHelper.get(MyApp.get()).getInt("Notification_count", 0);
    }
    public static void setNotificationCount(int notificationCount){
        PrefsHelper.get(MyApp.get()).putInt("Notification_count",notificationCount);
    }

    public static int getAppointmentCount(){
        return PrefsHelper.get(MyApp.get()).getInt("Appointment_count", 0);
    }
    public static void setAppointmentCount(int appointmentCount){
        PrefsHelper.get(MyApp.get()).putInt("Appointment_count",appointmentCount);
    }
    public static void setAccessTokenSP(String accessTokenSP){
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_ACCESS_TOKEN,accessTokenSP);
    }
    public static String getUIDFromSP(){
        return PrefsHelper.get(MyApp.get()).getString(Constants.KEY_UID, "");
    }
    public static void setUIDSP(String UID){
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_UID,UID);
    }
    public static String getClientFromSP(){
        return PrefsHelper.get(MyApp.get()).getString(Constants.KEY_CLIENT, "");
    }
    public static void setClientSP(String UID){
        PrefsHelper.get(MyApp.get()).putString(Constants.KEY_CLIENT,UID);
    }

    public static void setFirebaseToken(String token){
        PrefsHelper.get(MyApp.get(),"firebase_prefs").putString(Constants.KEY_TOKEN,token);
    }
    public static String getFirebaseToken(){
        return PrefsHelper.get(MyApp.get(),"firebase_prefs").getString(Constants.KEY_TOKEN,"");
    }
}