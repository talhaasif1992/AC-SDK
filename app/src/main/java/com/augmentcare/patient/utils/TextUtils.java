package com.augmentcare.patient.utils;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.augmentcare.patient.model.TimeSlot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TextUtils {
    public static boolean validateEmail(String email) {
        //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        boolean isValid = true;
        isValid = email.trim().matches(emailPattern);
        //isValid = EmailValidator.get().isValid(email);
        return isValid;
    }

    public static JsonObject convertToJsonObject(Object object) {
        JsonObject convertedJsonObject = null;
        if (object != null) {
            Gson gson = new GsonBuilder().create();
            String jsonStr = gson.toJson(object);
            JsonParser parser = new JsonParser();
            convertedJsonObject = parser.parse(jsonStr).getAsJsonObject();
        }
        return convertedJsonObject;
    }

    public static boolean validatePhone(String phone) {
        String phonePattern = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        boolean isValid = phone.trim().matches(phonePattern);
        return isValid;
    }

    public static String formatTime24(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatTime24GMT(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatTime12GMT(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatTime(Date date)
    {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatTimeFileAClaim(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatTimeRange(TimeSlot slot) {
        String formattedDate = "";
        Date startTime = TextUtils.parseTime(slot.getStart_time());
        Date endTime = TextUtils.parseTime(slot.getEnd_time());

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(startTime) + "   -   " + formatter.format(endTime);


        return formattedDate;
    }


    public static String formatDateConsultDetails(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat(" dd, yyyy");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDate(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDOBProfile(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM  yyyy");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDOB(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDOBWithDash(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDOBWithDashFileAClaim(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatCurrency(Context context, long value) {
        String formattedString = "";
        Locale locale = new Locale("en", "US");
        locale = getCurrentLocale(context);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        formattedString = formatter.format(value);
        return formattedString;
    }

    public static String formatCurrency(Context context, double value) {
        String formattedString = "";
        Locale locale = new Locale("en", "US");
        locale = getCurrentLocale(context);
        DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        formattedString = formatter.format(value);
        return formattedString;
    }

    public static String formatNumber2X(Context context, int value) {
        String formattedString = "";
        Locale locale = new Locale("en", "US");
        locale = getCurrentLocale(context);
        DecimalFormat formatter = new DecimalFormat("##");
        formattedString = formatter.format(value);
        return formattedString;
    }


    public static Locale getCurrentLocale(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return context.getResources().getConfiguration().getLocales().get(0);
        } else {
            //noinspection deprecation
            return context.getResources().getConfiguration().locale;
        }
    }

    public static boolean isDigitOnly(String inputString) {
        return android.text.TextUtils.isDigitsOnly(inputString);
    }

    public static String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case Calendar.SUNDAY:
                day = "Sunday";
                break;
            case Calendar.MONDAY:
                day = "Monday";
                break;
            case Calendar.TUESDAY:
                day = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                day = "Wednesday";
                break;
            case Calendar.THURSDAY:
                day = "Thursday";
                break;
            case Calendar.FRIDAY:
                day = "Friday";
                break;
            case Calendar.SATURDAY:
                day = "Saturday";
                break;
        }
        return day;
    }

    public static Date parseTimeWIthoutSSSLastSeconds(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss'Z'yyyy-MM-dd'T'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDateTimeStringWIthoutSSSLastSeconds(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(date);
    }

    public static String getDateTimeString(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(date);
    }

    public static Date parseTime(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;

        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return date;
    }

    public static Date parseTimeLocal(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;

        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return date;
    }

    public static Date parseDate(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseDOB(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseDateSpecial(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseDateAndTime(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }
    public static Date parseDate(String dateString,String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseDateAndTimeDDMMYYY(String dateString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try
        {
            date = sdf.parse(dateString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDateAndTime(Date date)
    {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDateAndTimeForFileAClaim(Date date) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy , hh:mm a");
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDateWithFormat(Date date, String format) {
        String formattedDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        //formatter.setTimeZone(TimeZone.getDefault());
        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String formatDateRelative(Date date, String format) {
        String formattedDate = "";

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        //formatter.setTimeZone(TimeZone.getDefault());

        formattedDate = formatter.format(date);
        return formattedDate;
    }

    public static String getDateDifferenceString(Date currentDate, Date futureDate)
    {
        String differenceDateAndTime = "";
        try
        {
            long diff = futureDate.getTime() - currentDate.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if (diffDays > 0) {
                if (diffDays > 1) {
                    differenceDateAndTime = differenceDateAndTime + diffDays + " Days ";
                } else {
                    differenceDateAndTime = differenceDateAndTime + diffDays + " Day  ";
                }
            }

            if (diffHours > 0) {
                if (diffHours > 1) {
                    differenceDateAndTime = differenceDateAndTime + diffHours + " Hours ";
                } else {
                    differenceDateAndTime = differenceDateAndTime + diffHours + " Hour ";
                }
            }


            if (diffMinutes > 0) {
                if (diffMinutes > 1) {
                    differenceDateAndTime = differenceDateAndTime + diffMinutes + " Minutes ";
                } else {
                    differenceDateAndTime = differenceDateAndTime + diffMinutes + " Minute ";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return differenceDateAndTime;
    }

    public static long getDateDifferenceHours(Date currentDate, Date futureDate) {
        long differnece = 0;
        try {
            long diff = futureDate.getTime() - currentDate.getTime();

            //long diffSeconds = diff / 1000 % 60;
            //long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            //long diffDays = diff / (24 * 60 * 60 * 1000);

            differnece = diffHours;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differnece;
    }

    /**
     * @param currentDate
     * @param futureDate
     * @return
     */
    public static long getDateDifferenceMinutes(Date currentDate, Date futureDate) {
        long differnece = 0;
        try {
            long diff = futureDate.getTime() - currentDate.getTime();

            //long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            //long diffHours = diff / (60 * 60 * 1000) % 24;
            //long diffDays = diff / (24 * 60 * 60 * 1000);

            differnece = diffMinutes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differnece;
    }

    /**
     * @param currentDate
     * @param futureDate
     * @return
     */
    public static long getDateDifferenceSeconds(Date currentDate, Date futureDate) {
        long differnece = 0;
        try {
            long diff = futureDate.getTime() - currentDate.getTime();

            long diffSeconds = diff / 1000 % 60;
            //long diffMinutes = diff / (60 * 1000) % 60;
            //long diffHours = diff / (60 * 60 * 1000) % 24;
            //long diffDays = diff / (24 * 60 * 60 * 1000);

            differnece = diffSeconds;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differnece;
    }
    /**
     * @param currentDate
     * @param futureDate
     * @return
     */
    public static long getDateDifferenceDays(Date currentDate, Date futureDate) {
        long differnece = 0;
        try {
            long diff = futureDate.getTime() - currentDate.getTime();

//            long diffSeconds = diff / 1000 % 60;
            //long diffMinutes = diff / (60 * 1000) % 60;
            //long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            differnece = diffDays;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differnece;
    }

    /**
     * @param currentDate
     * @param futureDate
     * @return
     */
    public static long getDateDifferenceMilliseconds(Date currentDate, Date futureDate) {
        long differnece = 0;
        try {
            long diff = futureDate.getTime() - currentDate.getTime();
            differnece = diff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differnece;
    }

    /**
     * @param password
     * @return
     */
    public static boolean validatePassword(String password) {
        return password.length() >= 4;
    }

    /**
     * @param value
     * @return
     */
    public static String getValueWithZero(int value) {
        String fValue = "";
        if (value < 9) {
            fValue = "0" + value;
        } else {
            fValue = "" + value;
        }
        return fValue;
    }


    /**
     * Hide the screen soft keyboard
     *
     * @param view View that attached with the soft keyboard e.g EditText etc
     */
    public static void hideSoftKeyboard(View view, Context context) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param context
     */
    public static void showSoftKeyboard(Context context) {
        try {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).
                    toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String incrementDate(String sourceDate)
    {
        String destDate = null;

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(sourceDate)); // parsed date and setting to calendar

            calendar.add(Calendar.DATE, 1);  // number of days to add
            destDate = sdf.format(calendar.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return destDate;
    }

    public static String decrementDate(String sourceDate)
    {
        String destDate = null;

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(sourceDate)); // parsed date and setting to calendar

            calendar.add(Calendar.DATE, -1);  // number of days to add
            destDate = sdf.format(calendar.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return destDate;
    }
}