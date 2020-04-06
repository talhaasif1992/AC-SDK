package com.augmentcare.patient.notifications;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.PowerManager;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.RemoteMessage.NotificationObject;
import com.augmentcare.patient.RemoteMessage.RemoteNotificationResponseModel;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.activities.VideoConsultationActivity;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import io.intercom.android.sdk.push.IntercomPushClient;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;
import static com.augmentcare.patient.notifications.NotificationHelper.STOP_CHANNEL_ID;
import static com.blankj.utilcode.util.Utils.runOnUiThread;

public class ACFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "ACMessagingService";
    private final IntercomPushClient intercomPushClient = new IntercomPushClient();
    int notification_size=0;
    public static final String CHANNEL_ID = "Cannel_id";





    @Override
    public void onNewToken(@NonNull String newToken) {
        Log.d(TAG, TAG + " Refreshed token: " + newToken);
        Log.wtf("firebaseToken", newToken + "");
        intercomPushClient.sendTokenToIntercom(getApplication(), newToken);
        PrefsHelper.setFirebaseToken(newToken);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {

        newWay2(remoteMessage);

        PrefsHelper.setNotificationCount(PrefsHelper.getNotificationCount()+1);




    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void newWay2(@NotNull RemoteMessage remoteMessage) {
        //  String notificationStr = String.valueOf(remoteMessage.getData());
        String notificationStr = StringUtils.null2Length0(remoteMessage.getData().get("data"));

        Map message = remoteMessage.getData();

        if (intercomPushClient.isIntercomPush(message)) {
            intercomPushClient.handlePush(getApplication(), message);
        }

        LogUtils.d("Notifications Message",message);

        if (PrefsHelper.isLoggedIn()) {
            try {
                JSONObject jsonObject = new JSONObject(message);

                if (jsonObject.has("notification"))
                {
                    if (jsonObject.getJSONObject("notification").has("notification_type")) {
                        if (jsonObject.getJSONObject("notification").getString("notification_type").equals("private_message")) {
                            try {
                                JSONObject notifationObject = jsonObject.getJSONObject("notification").getJSONObject("notification_object");
                                JSONObject notification = jsonObject.getJSONObject("notification");

                                NotificationHelper.sendNotification(this, "New Message",
                                        notifationObject.getString("first_name") + " " +
                                                notifationObject.getString("last_name") + " sent you a private message",
                                        notification.toString(), 1);
                            } catch (Exception ignored) {
                            }
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").equals("slot_confirmation")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 2);

                            Intent intent = new Intent(getApplicationContext().getPackageName() + ".APPOINTMEN_APPROVED");
                            intent.putExtra("data", jsonObject.getJSONObject("notification").toString());
                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").equals("slot_request")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 2);

                            Intent intent = new Intent(getApplicationContext().getPackageName() + ".APPOINTMEN_APPROVED");
                            intent.putExtra("data", jsonObject.getJSONObject("notification").toString());
                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").contains("reminder")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 2);
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").equals("slot_reminder")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 2);
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").equals("lab_reports_available")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 7);
                        } else if (jsonObject.getJSONObject("notification").getString("notification_type").equals("prescription_data")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 10);

                            Log.wtf("prescription", "prescription");
                        } else {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getJSONObject("notification").getString("notify_text"),
                                    jsonObject.getJSONObject("notification").toString(), 5);
                        }
                    } else if ((jsonObject.has("title") && jsonObject.getString("title").equalsIgnoreCase("Incoming Call")) ||
                            jsonObject.getJSONObject("notification").getString("event_type").equals("accept_call")) {
                        if (!VideoConsultationActivity.isAlive) {
                            JSONObject obj = jsonObject.getJSONObject("notification");
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    jsonObject.getString("message"), jsonObject.getJSONObject("notification").toString(), 6);
                            Intent intent = new Intent(this, VideoConsultationActivity.class);
                            intent.putExtra("type", "incoming");
                            intent.putExtra("data", obj.toString());
                            intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_SINGLE_TOP);
//                            startActivity(intent);
                            ActivityUtils.startActivity(intent);

                        }
                    }
                } else if (jsonObject.has("data")) {
                    JSONObject dataJsonObj = new JSONObject();
                    try {
                        dataJsonObj = jsonObject.getJSONObject("data");
                    } catch (JSONException e) {
                        dataJsonObj = new JSONObject(jsonObject.get("data").toString());
                    }
                    if (dataJsonObj.has("notification_type")) {
                        if (dataJsonObj.getString("notification_type").equals("private_message")) {
                            try {
                                NotificationHelper.sendNotification(this, "New Message",
                                        dataJsonObj.getString("first_name") + " " +
                                                dataJsonObj.getString("last_name") + " sent you a private message",
                                        dataJsonObj.toString(), 1);
                            } catch (Exception ignored) {
                            }
                        } else if (dataJsonObj.getString("notification_type").equals("slot_confirmation")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 2);

                            Intent intent = new Intent(getApplicationContext().getPackageName() + ".APPOINTMEN_APPROVED");
                            intent.putExtra("data", dataJsonObj.toString());
                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                        } else if (dataJsonObj.getString("notification_type").equals("slot_request")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 2);

                            Intent intent = new Intent(getApplicationContext().getPackageName() + ".APPOINTMEN_APPROVED");
                            intent.putExtra("data", dataJsonObj.toString());
                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                        } else if (dataJsonObj.getJSONObject("notification").getString("notification_type")
                                .equals("prescription_data")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 10);
                        } else if (dataJsonObj.getString("notification_type").contains("reminder")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 2);
                        } else if (dataJsonObj.getString("notification_type").equals("slot_reminder")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 2);
                        } else if (dataJsonObj.getString("notification_type").equals("lab_reports_available")) {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 7);
                        } else {
                            NotificationHelper.sendNotification(this, jsonObject.getString("title"),
                                    dataJsonObj.getString("notify_text"),
                                    dataJsonObj.toString(), 5);
                        }
                    } else if ((jsonObject.has("title") && jsonObject.getString("title").equalsIgnoreCase("Incoming Call"))) {
                        try {
                            if (dataJsonObj.has("notification_time")) {
                                if (!VideoConsultationActivity.isAlive) {
//                                    NotificationHelper.sendNotification(this, jsonObject.getString("title"),
//                                            jsonObject.getString("message"), dataJsonObj.toString(), 6);

                                    Intent intent = new Intent(this, VideoConsultationActivity.class);
                                    intent.putExtra(Constants.KEY_TYPE, Constants.KEY_TYPE_INCOMING);
                                    intent.putExtra(Constants.KEY_DATA, dataJsonObj.toString());
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    // startActivity(intent);
                                    ActivityUtils.startActivity(intent);
                                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                        showNotification(getApplicationContext(), jsonObject.getString("title"), jsonObject.getString("message"));
                                    }

                                }
                            }
                        } catch (Exception ignored) {

                            LogUtils.d("Notifications Catch", ignored);

                        }
                    }

                }

                if (jsonObject.has("notification_type") && jsonObject.getString("notification_type")
                        .equalsIgnoreCase("call reminder")) {
                    try {
                        jsonObject.getJSONObject("notification_object").put("slot_id",
                                jsonObject.getJSONObject("notification_object").getString("id"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    NotificationHelper.sendNotification(this, "AppointmentAdapter Reminder",
                            jsonObject.getString("notify_text"), jsonObject.toString(), 3);
                }

                if (jsonObject.has("notification_type") && jsonObject.getString("notification_type")
                        .equalsIgnoreCase("app_updated")) {
                    JSONObject upateApp = jsonObject.getJSONObject("notification_object");
                    PrefsHelper.get(this).putBoolean(Constants.KEY_FORCE_UPDATE, upateApp.getBoolean("enforced"));
                    PrefsHelper.get(this).putInt(Constants.KEY_VERSION, upateApp.getInt("versionCode"));
                    PrefsHelper.get(this).putString(Constants.KEY_MESSAGE, upateApp.getString("message"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (remoteMessage.getNotification() != null) {
            String notificationString;
            notificationString = GsonUtils.toJson(remoteMessage.getData());
            NotificationHelper.sendMarketinngNotification(this, remoteMessage.getNotification(), notificationString);
        }
    }

    public static void showNotification(Context context,String title,String content) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            NotificationChannel stopServiceChannel = new NotificationChannel(
                    STOP_CHANNEL_ID,
                    "ac_channel_consults",
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(stopServiceChannel);
            }

            Intent wakeupIntent = new Intent(context, VideoConsultationActivity.class);
            wakeupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent wakeupPendingIntent = PendingIntent.getActivity(context, 0, wakeupIntent, PendingIntent.FLAG_UPDATE_CURRENT);


            PowerManager powerManager = (PowerManager) context.getSystemService(POWER_SERVICE);
            PowerManager.WakeLock wakeLock = null;
            if (powerManager != null) {
                wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK
                                | PowerManager.ACQUIRE_CAUSES_WAKEUP
                                | PowerManager.ON_AFTER_RELEASE,
                        "MyApp::" + TAG);
            }
            if (wakeLock != null) {
                wakeLock.acquire(10000);
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, STOP_CHANNEL_ID)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setContentTitle(title)
//                    .setContentText(content)
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                    .setCategory(NotificationCompat.CATEGORY_CALL)
                    .setFullScreenIntent(wakeupPendingIntent, true);

            Notification alarmNotification = notificationBuilder.build();

            if (notificationManager != null) {
                notificationManager.notify(0, alarmNotification);
                notificationManager.cancelAll();
            }

            if (wakeLock != null) {
                wakeLock.release();
            }
        }
        else {
            Intent wakeIntent = new Intent(context, VideoConsultationActivity.class);
            wakeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(wakeIntent);
        }
    }


}