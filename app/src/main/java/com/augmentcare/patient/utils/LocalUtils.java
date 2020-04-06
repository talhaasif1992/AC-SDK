package com.augmentcare.patient.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.model.APreference;
import com.augmentcare.patient.model.ASlot;
import com.augmentcare.patient.model.ChatLine;
import com.augmentcare.patient.model.Condition;
import com.augmentcare.patient.model.ConsultationItem;
import com.augmentcare.patient.model.Doctor;
import com.augmentcare.patient.model.DoctorItem;
import com.augmentcare.patient.model.Specialization;
import com.augmentcare.patient.model.TimeItem;
import com.augmentcare.patient.model.TimeSlot;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.DoctorDetail;
import com.augmentcare.patient.network.restApi.apimodels.DoctorInfoLimited;
import com.augmentcare.patient.network.restApi.apimodels.RolesName;
import com.augmentcare.patient.network.restApi.apimodels.Slot;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.JsonObject;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by Qamar Ul Zaman on 20/09/2017.
 * Utility related to AugmentCare App
 */

public class LocalUtils {

    public static final int TYPE_ALL = 0;
    public static final int TYPE_PENDING = 1;
    public static final int TYPE_COMPLETED = 2;
    public static final int TYPE_APPROVED = 3;
    public static final int TYPE_ONGOING = 4;

    public static final String CONSULT_STATUS_PENDING = "pending";
    public static final String CONSULT_STATUS_REJECTED = "rejected";
    public static final String CONSULT_STATUS_EXPIRED = "expired";
    public static final String CONSULT_STATUS_APPROVED = "approved";
    public static final String CONSULT_STATUS_COMPLETED = "completed";
    public static final String CONSULT_STATUS_ONGOING = "in_progress";
    public static final String CONSULT_STATUS_INCOMPLETE = "incomplete";
    public static final String CONSULT_STATUS_ACCEPTED = "accepted";


    public static void processAPIError(Throwable e) {
        BaseActivity baseActivity = null;
        try {
            baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
            baseActivity.stopLoader();
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        if (e != null) {
            LogUtils.e(e);
            if (e.getMessage() == null) {
              //  Toasty.error(Utils.getApp(), "Unable to send request try again...", Toast.LENGTH_LONG, false).show();
                return;
            }
            if (e.getMessage().contains("503") || e.getMessage().contains("500") || e.getMessage().contains("502")) {
                Toasty.error(Utils.getApp(), "Try again server is busy right now...", Toast.LENGTH_LONG, false).show();

            } else if (e.getMessage().contains("401")) {
                if (baseActivity != null) {
                    baseActivity.refreshTokenAPIRequest();
                }
            } else if (!e.getMessage().contains(BuildConfig.SOCKET_URL.replaceAll("(http\\:\\/\\/)|(https\\:\\/\\/)", ""))) {
                Toasty.error(Utils.getApp(), e.getMessage(), Toast.LENGTH_LONG, false).show();
                return;
            } else if (e.getMessage().contains("Route Not Found")) {
                Toasty.error(Utils.getApp(), "API request not found on server...", Toast.LENGTH_LONG, false).show();
                return;
            }
           // Toasty.error(Utils.getApp(), "Unable to send request try again...", Toast.LENGTH_LONG, false).show();
        }

    }

    public static boolean isThisUserType(String compareType){
        UserLogin userLogin = PrefsHelper.getLoggedInUser();
        if(userLogin != null && userLogin.getRolesName().size() > 0){
            for (RolesName rolesName : userLogin.getRolesName()) {
                if(compareType.equalsIgnoreCase(rolesName.getName())){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isThisUserType(UserLogin userLogin,String compareType){
        if(userLogin != null && userLogin.getRolesName().size() > 0){
            for (RolesName rolesName : userLogin.getRolesName()) {
                if(compareType.equalsIgnoreCase(rolesName.getName())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param title
     * @param message
     */
    public static void showSimpleDialog(Activity activity, String title, String message, int iconResID, Runnable onOk, Runnable onCancel) {
        try {
            AlertDialog.Builder simsimInAppDialog = new AlertDialog.Builder(activity);
            simsimInAppDialog.setTitle(title);
            simsimInAppDialog.setMessage(message);
            simsimInAppDialog.setIcon(iconResID);
            simsimInAppDialog.setCancelable(false);
            simsimInAppDialog.setPositiveButton("OK",
                    (dialog, which) -> {
                        if (onOk != null)
                            onOk.run();
                    });
            simsimInAppDialog.setNegativeButton("Cancel",
                    (dialog, which) -> {
                        if (onCancel != null)
                            onCancel.run();
                    }
            );
            try {
                if (simsimInAppDialog != null) {
                    simsimInAppDialog.show();
                }
            } catch (Exception ignored) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void setUIforKeyboard(View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager) Utils.getApp().getSystemService(Activity.INPUT_METHOD_SERVICE);
        /*if (view instanceof TextView) {
            ((TextView) view).setTypeface(MyApp.font);
        } else if (view instanceof EditText) {
            ((EditText) view).setTypeface(MyApp.font);
        } else if (view instanceof Button) {
            ((Button) view).setTypeface(MyApp.font);
        }*/

        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
//                    if (requestedView != null) { // in case of edit Dialog
//                        requestedView.requestFocusFromTouch();
//                    }
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setUIforKeyboard(innerView);
            }
        }
    }

    public static <T> T getOr(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static void adjustFontScale(Configuration configuration) {
        try {
            if (configuration.fontScale > 1.30) {

                configuration.fontScale = (float) 1;
                DisplayMetrics metrics = MyApp.get().getResources().getDisplayMetrics();
                WindowManager wm = (WindowManager) MyApp.get().getSystemService(WINDOW_SERVICE);

                wm.getDefaultDisplay().getMetrics(metrics);
                metrics.scaledDensity = configuration.fontScale * metrics.density;

                MyApp.get().getResources().updateConfiguration(configuration, metrics);

            }
        } catch (Exception e) {
        }
    }

    private static boolean isDoctorApp() {
        return MyApp.get().getPackageName().contains("doctor");
    }


    public static String setConsultationStatus(Slot item) {
        String status = "VOID";
        boolean expired = false;

        if (item.getDay() != null && item.getEndTime() != null) {
            String endTimeStr = item.getDay() + "T" + item.getEndTime().split("T")[1];
            Date endTime = TextUtils.parseTime(endTimeStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            Date date = Calendar.getInstance().getTime();

            if (endTime.before(date)) {
                expired = true;
            }

        }
        if (item.getDay() != null && item.getStartTime() != null) {
            String startTimeStr = item.getDay() + "T" + item.getStartTime().split("T")[1];
            String endTimeStr = item.getDay() + "T" + item.getEndTime().split("T")[1];
            Date startDateTime = TextUtils.parseTime(startTimeStr);
            item.setStartDateTime(startDateTime);
            item.setEndDateTime(TextUtils.parseTime(endTimeStr));
        } else {
            Log.d("setConsultationStatus", "setConsultationStatus " + item.getDay() + " " + item.getStartTime());
        }

        if (item.getStatus()) {
            if (item.getStartTime() != null) {

                if (isInComplete(item)) {
                    item.setStatusString(CONSULT_STATUS_INCOMPLETE);
                    return CONSULT_STATUS_INCOMPLETE;
                }
                if (item.getCompleted()) {
                    item.setStatusString(CONSULT_STATUS_COMPLETED);
                    return CONSULT_STATUS_COMPLETED;
                } else {
                    if (expired) {
                        if (isDoctorApp()) {
                            item.setStatusString(CONSULT_STATUS_ACCEPTED);
                            return CONSULT_STATUS_ACCEPTED;
                        }
                        item.setStatusString(CONSULT_STATUS_APPROVED);
                        return CONSULT_STATUS_APPROVED;

                    } else {

                        if (isOngoing(item)) {
                            item.setStatusString(CONSULT_STATUS_ONGOING);
                            return CONSULT_STATUS_ONGOING;
                        }

                        //for doctor's app
                        if (isDoctorApp()) {
                            item.setStatusString(CONSULT_STATUS_ACCEPTED);
                            return CONSULT_STATUS_ACCEPTED;
                        }
                        item.setStatusString(CONSULT_STATUS_APPROVED);
                        return CONSULT_STATUS_APPROVED;

                    }
                }
            }
        } else if (item.getRejected()) {
            item.setStatusString(item.getRejectedBy());
            return item.getRejectedBy();
        } else {
            if (expired) {
                item.setStatusString(CONSULT_STATUS_EXPIRED);
                return CONSULT_STATUS_EXPIRED;

            } else {
                item.setStatusString(CONSULT_STATUS_PENDING);
                return CONSULT_STATUS_PENDING;

            }
        }
        //item.setStatusString(status);

        return status;
    }

    public static ArrayList<DoctorDetail> filterDoctorsBySpeciality(ArrayList<DoctorDetail> doctors, String speciality) {
        ArrayList<DoctorDetail> filteredDoctors = new ArrayList<>();
        for (DoctorDetail doctor : doctors) {
            if (doctor.getSpecializations() != null && doctor.getSpecializations().size() > 0) {
                for (com.augmentcare.patient.network.restApi.apimodels.Specialization specialization : doctor.getSpecializations()) {
                    if (specialization.getName().equalsIgnoreCase(speciality)) {
                        filteredDoctors.add(doctor);
                    }
                }
            }
        }
        return filteredDoctors;
    }

    public static ArrayList<DoctorInfoLimited> filterDoctorItemsBySpeciality(ArrayList<DoctorInfoLimited> doctors, String speciality) {
        ArrayList<DoctorInfoLimited> filteredDoctors = new ArrayList<>();
        for (DoctorInfoLimited doctor : doctors) {
            if (doctor.getSpecialization() != null && doctor.getSpecialization().size() > 0) {
                for (String specialization : doctor.getSpecialization()) {
                    if (specialization.equalsIgnoreCase(speciality)) {
                        filteredDoctors.add(doctor);
                    }
                }
            }
        }
        return filteredDoctors;
    }

    public static ArrayList<DoctorItem> filterDoctorItemByCityAndOrganization(ArrayList<DoctorItem> doctors, String city, boolean isFree) {
        ArrayList<DoctorItem> filteredDoctors = new ArrayList<>();
        for (DoctorItem doctor : doctors) {
            if (city.isEmpty()) {
                if (doctor.getIs_free() == isFree) {
                    if (!filteredDoctors.contains(doctor))
                        filteredDoctors.add(doctor);
                }
            } else if (doctor.getCities() != null && doctor.getCities().length > 0) {
                for (String specialization : doctor.getCities()) {
                    if (specialization.contains(city) && doctor.getIs_free() == isFree) {
                        if (!filteredDoctors.contains(doctor))
                            filteredDoctors.add(doctor);
                        break;
                    }
                }
            }
        }
        return filteredDoctors;
    }

    public static ArrayList<Doctor> filterDoctorsByCondition(ArrayList<Doctor> doctors, String condition) {
        ArrayList<Doctor> filteredDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecializations() != null && doctor.getSpecializations().size() > 0) {
                for (Specialization specialization : doctor.getSpecializations()) {
                    if (specialization.getConditions_treated() != null && specialization.getConditions_treated().toString().contains(condition)) {
                        filteredDoctors.add(doctor);
                    }
                }
            }
        }
        return filteredDoctors;
    }

    public static ArrayList<DoctorItem> filterDoctorItemsByCondition(ArrayList<DoctorItem> doctors, String condition) {
        ArrayList<DoctorItem> filteredDoctors = new ArrayList<>();
        for (DoctorItem doctor : doctors) {
            if (doctor.getSpecialization_cond() != null && doctor.getSpecialization_cond().size() > 0) {
                for (String specialization : doctor.getSpecialization_cond()) {
                    if (specialization.contains(condition)) {
                        if (!filteredDoctors.contains(doctor))
                            filteredDoctors.add(doctor);
                    }

                }
            }
        }
        return filteredDoctors;
    }

    public static ArrayList<Doctor> searchDoctor(ArrayList<Doctor> doctors, String query) {
        ArrayList<Doctor> gotList = new ArrayList<>();
        String searchText = query.toLowerCase();
        for (Doctor doctor : doctors) {
            if (doctor.getDocterInfo().getName() != null && doctor.getDocterInfo().getName().toLowerCase().contains(searchText)) {
                gotList.add(doctor);
            } else if (doctor.getSpecializations() != null) {
                if (doctor.getSpecializations().toString().toLowerCase().contains(searchText)) {
                    gotList.add(doctor);

                } else {
                    for (Specialization specialization : doctor.getSpecializations()) {
                        if (specialization.getConditions_treated() != null && specialization.getConditions_treated().toString().toLowerCase().contains(searchText)) {
                            gotList.add(doctor);
                        }
                    }
                }
            }
        }
        return gotList;
    }

    public static ArrayList<DoctorItem> searchDoctorItems(ArrayList<DoctorItem> doctors, String query) {
        ArrayList<DoctorItem> gotList = new ArrayList<>();
        String searchText = query.toLowerCase();
        for (DoctorItem doctor : doctors) {
            if (doctor.getName() != null && doctor.getName().toLowerCase().contains(searchText)) {
                gotList.add(doctor);
            } else if (doctor.getSpecializations() != null) {
                if (doctor.getSpecializations().toString().toLowerCase().contains(searchText)) {
                    gotList.add(doctor);

                } else {
                    for (String specialization : doctor.getSpecializations()) {
                        if (specialization != null && specialization.toLowerCase().contains(searchText)) {
                            gotList.add(doctor);
                        }
                    }
                }
            }
        }
        return gotList;
    }

    public static ArrayList<String> getSpecialitiesFromDoctors(ArrayList<Doctor> doctors) {
        ArrayList<String> specialities = new ArrayList<>();
        if (doctors == null)
            return specialities;
        for (Doctor doctor : doctors) {
            for (Specialization spec : doctor.getSpecializations()) {
                if (!specialities.contains(spec.getName()))
                    specialities.add(spec.getName());
                Log.d("getSpecialities", "getSpecialitiesFromDoctors " + spec.getConditions_treated());
            }
        }
        return specialities;
    }


    public static ArrayList<String> getSpecialitiesFromDoctorItems(ArrayList<DoctorItem> doctors) {
        ArrayList<String> specialities = new ArrayList<>();
        if (doctors == null)
            return specialities;
        for (DoctorItem doctor : doctors) {
            for (String spec : doctor.getSpecializations()) {
                if (!specialities.contains(spec))
                    specialities.add(spec);
            }
        }
        return specialities;
    }

    public static ArrayList<String> getCitiesFromDoctorItems(ArrayList<DoctorItem> doctors) {
        ArrayList<String> specialities = new ArrayList<>();
        if (doctors == null)
            return specialities;
        for (DoctorItem doctor : doctors) {
            for (String spec : doctor.getCities()) {
                if (!specialities.contains(spec))
                    specialities.add(spec);
            }
        }
        return specialities;
    }


    public static ArrayList<String> getConditionsFromDoctors(ArrayList<Doctor> doctors) {
        ArrayList<String> conditions = new ArrayList<>();
        if (doctors == null)
            return conditions;
        for (Doctor doctor : doctors) {
            for (Specialization spec : doctor.getSpecializations()) {
                if (spec.getConditions_treated() != null && spec.getConditions_treated().size() > 0) {
                    for (Condition condition : spec.getConditions_treated()) {
                        if (!conditions.contains(condition.getName()))
                            conditions.add(condition.getName());
                    }
                }
            }
        }
        return conditions;
    }

    public static ArrayList<String> getConditionsFromDoctorItems(ArrayList<DoctorItem> doctors) {
        ArrayList<String> conditions = new ArrayList<>();
        if (doctors == null)
            return conditions;
        for (DoctorItem doctor : doctors) {
            for (String spec : doctor.getSpecialization_cond()) {
                if (spec != null) {

                    if (!conditions.contains(spec))
                        conditions.add(spec);

                }
            }
        }
        return conditions;
    }

    public static ArrayList<ConsultationItem> filterConsultationByStatus(ArrayList<ConsultationItem> consults, int type) {
        ArrayList<ConsultationItem> filteredItems = new ArrayList<>();
        if (type == TYPE_PENDING) {
            for (ConsultationItem item : consults) {
                if (item.getSlot().getStatusString().equals(CONSULT_STATUS_PENDING) || item.getSlot().getStatusString().equals(CONSULT_STATUS_EXPIRED) || item.getSlot().getStatusString().equals(CONSULT_STATUS_REJECTED)) {
                    filteredItems.add(item);
                }
            }
        }
        if (type == TYPE_APPROVED) {
            for (ConsultationItem item : consults) {
                if (item.getSlot().getStatusString().equals(CONSULT_STATUS_APPROVED)) {
                    filteredItems.add(item);
                }
            }
        }
        if (type == TYPE_COMPLETED) {
            for (ConsultationItem item : consults) {
                if (item.getSlot().getStatusString().equals(CONSULT_STATUS_COMPLETED)) {
                    filteredItems.add(item);
                }
            }
        }
        if (type == TYPE_ONGOING) {
            for (ConsultationItem item : consults) {
                if (item.getSlot().getStatusString().equals(CONSULT_STATUS_ONGOING)) {
                    filteredItems.add(item);
                }
            }
        }

        return filteredItems;
    }

    /*
    * var isOnGoing = function(slot){
		var currTime=new moment();
		var endTime_0 = new moment(slot.end_time).format('HH:mm:ss');
		var endTime = new moment(endTime_0,'HH:mm:ss');
		var startTime_0 = new moment(slot.start_time).format('HH:mm:ss');
		var startTime = new moment(startTime_0,'HH:mm:ss');
		var slotDay=new moment(slot.day,'YYYY-MM-DD');
		var currDay_0=new moment(new Date()).format('YYYY-MM-DD');
		var currDay=new moment(currDay_0,'YYYY-MM-DD');
		if(slotDay.isSame(currDay)){
			if(currTime.isAfter(startTime) && currTime.isBefore(endTime)){
				return true;
			}
		}
		return false;
	};
    * */

    private static boolean isOngoing(Slot slot) {
        Date currTime = Calendar.getInstance().getTime();
        String endTimeStr = slot.getDay() + "T" + slot.getEndTime().split("T")[1];
        String startTimeStr = slot.getDay() + "T" + slot.getStartTime().split("T")[1];
        Date startTime = TextUtils.parseTime(startTimeStr);
        Date endTime = TextUtils.parseTime(endTimeStr);
        Date day = TextUtils.parseDate(slot.getDay());
        if (currTime.getDay() == day.getDay() && currTime.getMonth() == day.getMonth() && currTime.getYear() == day.getYear()) {
            return currTime.after(startTime) && currTime.before(endTime);
        }
        return false;
    }

    private static boolean isInComplete(Slot slot) {
        Date startTime = TextUtils.parseTime(slot.getStartTime());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, startTime.getYear());
        calendar.set(Calendar.MONTH, startTime.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, startTime.getDay());
        Date currentTime = Calendar.getInstance().getTime();
        Date day = TextUtils.parseDate(slot.getDay());

        String endTimeStr = slot.getDay() + "T" + slot.getEndTime().split("T")[1];
        Date endTimeNew = TextUtils.parseTime(endTimeStr);
        if (TextUtils.formatDate(new Date()).equals(TextUtils.formatDate(day))) {
            return currentTime.after(endTimeNew) && !slot.getCompleted();

        }
        return false;

    }

    public static void shareAppWithFriends(Context context) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hello, I am using AugmentCare to book doctor appointments and order medicines\n Get the app here: https://play.google.com/store/apps/details?id=" + context.getPackageName());
        context.startActivity(Intent.createChooser(sharingIntent, "Share Using"));
    }

    public static void shareDocotorWithFriends(Context context, Doctor doctor) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        /*I found Dr Khalid Maqbool on AugmentCare. You can book appointment here: https://www.augmentcare.com/doctors-test/3831425cd3-dr-Qamar-Zaman*/
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I found " + doctor.getDocterInfo().getName() + " on AugmentCare. You can book appointment here:\n  https://www.augmentcare.com/d/" + (doctor.getDocterInfo().getDoctorUid() + "-" + ("dr-" + doctor.getUserInfo().getFirstName().trim()).toLowerCase()));
        context.startActivity(Intent.createChooser(sharingIntent, "Share Doctor Profile"));
    }

    public static void addDependents(Context context, List<Dependent> dependents, ViewGroup lytFamilyMember, View.OnClickListener listener) {
        if (dependents != null && dependents.size() > 0)
            for (Dependent dep : dependents) {
                View depView = LayoutInflater.from(context).inflate(R.layout.item_dependent, null);
                TextView txtName = depView.findViewById(R.id.txtName);
                TextView txtRelation = depView.findViewById(R.id.txtRelation);
                ImageView ivThumb = depView.findViewById(R.id.ivThumb);
                txtName.setText(dep.getName());
                txtRelation.setText(dep.getRelationWithPrimary());
                depView.setTag(dep);
                lytFamilyMember.addView(depView);
                depView.setOnClickListener(listener);
            }
        if (!PrefsHelper.get(context).getBoolean(Constants.KEY_IS_DEPENDENT, false)) {
            View depView = LayoutInflater.from(context).inflate(R.layout.item_dependent, null);
            TextView txtName = depView.findViewById(R.id.txtName);
            txtName.setText("Add Member");
            CircularImageView ivThumb = depView.findViewById(R.id.ivThumb);
            ivThumb.setBorderWidth(0);
            ivThumb.setImageResource(R.drawable.ic_add_member);
            depView.setTag("new");
            depView.setOnClickListener(listener);
            lytFamilyMember.addView(depView);
        }
    }

    public static ChatLine parseChatLine(String messageJson) {
        ChatLine chatLine = null;
        try {
            JSONObject jsonObject = new JSONObject(messageJson);
            JSONObject notifObject = jsonObject.getJSONObject("notification_object");
            chatLine = new ChatLine();
            chatLine.setMessage_type(notifObject.getString("type"));
            chatLine.setSaved(true);
            chatLine.setChat_text(notifObject.getString("chat_text"));
            chatLine.setUser_role_id(jsonObject.getString("user_role_id"));
            //chatLine.setUser_role_id(""+gotDoctor.getDocterRoles().getId()+"");
            chatLine.setChat_id(jsonObject.getString("id"));
            chatLine.setCreated_at(TextUtils.getDateTimeString(Calendar.getInstance().getTime()));
            return chatLine;
        } catch (Exception e) {

        }
        return chatLine;
    }

    private static boolean isExpired(ASlot slot) {
        Date startTime = TextUtils.parseTime(slot.getStartTime());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, startTime.getYear());
        calendar.set(Calendar.MONTH, startTime.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, startTime.getDay());
        Date currentTime = calendar.getTime();
        Date day = TextUtils.parseDate(slot.getDay());
        Date endTime = TextUtils.parseTime(slot.getEndTime());

        if (TextUtils.formatDate(currentTime).equals(TextUtils.formatDate(day))) {
            return currentTime.after(endTime);
        }
        return false;
    }

    public static JsonObject getCorporatePaymentObject(Doctor doctor, Date date, TimeItem timeItem, TimeSlot timeSlot) {
        JsonObject corpObject = new JsonObject();
        BaseActivity baseActivity = (BaseActivity) ActivityUtils.getTopActivity();

        corpObject.addProperty("user_id", baseActivity.userData.getUserId());
        corpObject.addProperty("consultation_with", doctor.getDocterInfo().getName());
        if (doctor.getSpecializations() != null && doctor.getSpecializations().size() > 0)
            corpObject.addProperty("speciality", doctor.getSpecializations().get(0).getName());
        corpObject.addProperty("patient_firstName", baseActivity.userData.getFirstName());
        corpObject.addProperty("day", TextUtils.formatDateWithFormat(date, "yyyy-MM-dd"));
        corpObject.addProperty("start_time", TextUtils.formatTime24GMT(timeItem.getStartTime()));
        corpObject.addProperty("amount", doctor.isFree() ? 0 : doctor.getDocterInfo().getConsultationRate());
        corpObject.addProperty("transaction_type", "consultation");
        corpObject.addProperty("user_role_id", MyApp.get().getRole().getId());

        // corpObject.addProperty("organization_id", MyApp.get().getOrganization().getId());
        //corpObject.addProperty("organizationId", MyApp.get().getOrganization().getId());
        corpObject.addProperty("is_unlimited", doctor.isFree());
        corpObject.addProperty("docter_id", doctor.getDocterInfo().getId());
        corpObject.addProperty("doctor_id", doctor.getUserInfo().getUserId());

        corpObject.addProperty("booked_from_platform", "android");
        corpObject.addProperty("booked_by_user_id", baseActivity.userData.getUserId());
        if (timeSlot.getMedical_practice_id() == null) {
            corpObject.addProperty("name", "Online");
        }
        //new fields
        corpObject.addProperty("date", TextUtils.formatDateWithFormat(date, "yyyy-MM-dd"));
        corpObject.addProperty("available", true);
        corpObject.addProperty("status", false);
        corpObject.addProperty("offline_location", timeSlot.getOffline_location());

        corpObject.addProperty("end_time", TextUtils.formatTime24GMT(timeItem.getEndTime()));
        corpObject.addProperty("patient_firstName", baseActivity.userData.getFirstName());
        corpObject.addProperty("patient_lastName", baseActivity.userData.getLastName());
        if (timeSlot.getDoctor_sitting_id() != null)
            corpObject.addProperty("doctor_sitting_id", timeSlot.getDoctor_sitting_id());
        if (timeSlot.getMedical_practice_id() != null)
            corpObject.addProperty("medical_practice_id", timeSlot.getMedical_practice_id());
        Calendar calendar = Calendar.getInstance();
        //calendar.set(Calendar.DAY_OF_WEEK,days.indexOf(currentDay)+1);
        calendar.set(Calendar.HOUR_OF_DAY, timeItem.getStartTime().getHours());
        calendar.set(Calendar.MINUTE, timeItem.getStartTime().getMinutes());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        corpObject.addProperty("date_time", TextUtils.getDateTimeString(calendar.getTime()));
        return corpObject;
    }

    public static void notifyUser(Context context, Doctor doctor) {
        JSONObject updateNotifications = new JSONObject();
        try {
            updateNotifications.put("key", doctor.getUserChannel());
            if (doctor.getDocterRoles() != null)
                updateNotifications.put("user_role_id", doctor.getDocterRoles().getId());
            updateNotifications.put("notify_type", "slot_request");
            //JSONObject notifobj = new JSONObject(response.get("notification").getAsJsonObject().get("notification_object").getAsJsonObject().toString());
            //updateNotifications.put("notification_object", notifobj);
            //updateNotifications.put("notification_counter", response.get("notification_counter").getAsJsonObject().get("offline_counter").getAsInt());
            updateNotifications.put("event_type", "update_notificaions");
            AppSocket.getInstance(MyApp.get()).getSocket().emit("emit_event", updateNotifications);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkDoctorPreference(Doctor doctor, String key) {
        boolean preferenceValue = true;
        if (doctor.getPreferences() != null && doctor.getPreferences().size() > 0) {
            for (APreference preference : doctor.getPreferences()) {
                if (preference.getPreference_name() != null && preference.getPreference_name().contains(key)) {
                    if (Boolean.valueOf(preference.getPreference_value())) {
                        preferenceValue = false;
                    }
                }

            }
        }
        return preferenceValue;
    }

    //////////////////////////////// Generic Utils ///////////

    /**
     * @param capString
     * @return
     */
    public static String getCapitalizedString(String capString) {
        String result = "";
        try {
            if (capString == null || capString.equalsIgnoreCase("") || capString.isEmpty()) {
                return "";
            }

            StringBuffer capBuffer = new StringBuffer();
            Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
            while (capMatcher.find()) {
                capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
            }
            result = capMatcher.appendTail(capBuffer).toString();
        } catch (Exception e) {
            return capString;
        }
        return result;
    }

    /**
     * @param data String data to capitalize first character
     * @return Returns the given data with first character is capital
     */
    public static String firstLetterCapsAndRestSmall(String data) {
        String outPut = data;
        try {
            String firstLetter = data.substring(0, 1).toUpperCase();
            String restLetters = data.substring(1).toLowerCase();
            outPut = firstLetter + restLetters;
        } catch (Exception e) {
            return outPut;
        }
        return outPut;
    }


    ///////////////////////////////// Local Utils ////////////////////////////

    public static Observable<String> getFirebaseToken() {
        MyApp.firebaseTokenIDFix();
        return
                Observable.create((ObservableOnSubscribe<String>) emitter -> {
                    String tokenPref = "";
                    while (StringUtils.isEmpty(tokenPref)) {
                        try {
                            tokenPref = PrefsHelper.getFirebaseToken();
                            if (!StringUtils.isEmpty(tokenPref)) {
                                emitter.onNext(tokenPref);
                                emitter.onComplete();
                                break;
                            }
                        } catch (Exception e) {
                            emitter.onError(e);
                            break;
                        }
                    }
                })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

    }

}
