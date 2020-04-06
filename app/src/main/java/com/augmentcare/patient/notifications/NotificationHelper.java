package com.augmentcare.patient.notifications;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.renderscript.RenderScript;

import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.NavDeepLinkBuilder;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.ChatActivity;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.activities.VideoConsultationActivity;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.fragments.AppointmentDetailsFragmentArgs;
import com.augmentcare.patient.network.restApi.apimodels.NotificationInternal;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.GenApiLogger;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

import static android.content.Context.KEYGUARD_SERVICE;
import static android.content.Context.POWER_SERVICE;
import static com.augmentcare.patient.notifications.Constants.EXTRA_IS_FROM_NOTIFICATIONS;
import static com.augmentcare.patient.notifications.Constants.EXTRA_MISSED_CALL_NOTIFICATIONS;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_CHAT_ACTIVITY_OPEN;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_CONSULTATION_PRESCRIPTION;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_CONSULTATION_APPOINTMENT_COMPLETE;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_HOME_SCREEN;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_ORDER_LAB;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_SPLASH;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_SPLASH_MISSED_CALL;
import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_VIDEO_CONSULTATION;

public class NotificationHelper {
    private static BaseActivity baseActivity;
    private static NotificationInternal notificationInternal;
    private static final String TAG = "ACMessagingService";

    public static final String STOP_CHANNEL_ID = "ac_channel_consults";

    public static void sendNotification(Context context, String title, String content, String data, int type) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel;
        JSONObject dataJson = null;


        try {
            if (!data.isEmpty()) {
                dataJson = new JSONObject(data);
                Gson gson = new Gson();
                notificationInternal = gson.fromJson(String.valueOf(dataJson), NotificationInternal.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int myType = type;
        String CHANNEL_ID = "ac_channel_consults";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "Consultations and Messages", NotificationManager.IMPORTANCE_HIGH);
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setAutoCancel(true)
                        .setChannelId(CHANNEL_ID)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(content))
                        .setSound(soundUri)
                        .setContentText(content);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setColor(context.getResources().getColor(R.color.colorPrimary));
        }

        if (type == NOTIFICATION_CHAT_ACTIVITY_OPEN) {
//            Bundle b = new Bundle();
//            b.putBoolean(EXTRA_IS_FROM_NOTIFICATIONS, true);
//            b.putString(Constants.KEY_DATA, data);
//
//            PendingIntent pendingIntent =
//                    new NavDeepLinkBuilder(context)
//                            .setComponentName(HomeScreenActivity.class)
//                            .setGraph(R.navigation.main_navigation)
//                            .setDestination(R.id.chatActivity)
//                            .setArguments(b)
//                            .createPendingIntent();
//
//            mBuilder.setContentIntent(pendingIntent);
//
//            assert mNotificationManager != null;
//            mNotificationManager.cancelAll();


            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            Intent resultIntent = new Intent(context, ChatActivity.class);
            resultIntent.putExtra("isFromNotification", true);
            resultIntent.putExtra(Constants.KEY_DATA, data.toString());
            stackBuilder.addParentStack(ChatActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
            mBuilder.setContentIntent(resultPendingIntent);
            assert mNotificationManager != null;
            mNotificationManager.cancelAll();

        } else if (type == NOTIFICATION_CONSULTATION_PRESCRIPTION) {
            try {
                assert dataJson != null;
                myType = notificationInternal.getNotificationObject().getSlotId();
            } catch (Exception ignored) {
            }

            AppointmentDetailsFragmentArgs args = new AppointmentDetailsFragmentArgs.Builder(myType).build();

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setGraph(R.navigation.main_navigation)
                            .setDestination(R.id.appointmentDetailsFragment)
                            .setArguments(args.toBundle())
                            .createPendingIntent();

            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();

        } else if (type == NOTIFICATION_OPEN_HOME_SCREEN) {
            Bundle b = new Bundle();

            b.putBoolean(EXTRA_IS_FROM_NOTIFICATIONS, true);
            b.putString(Constants.KEY_DATA, data);

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setComponentName(HomeScreenActivity.class)
                            .setGraph(R.navigation.main_navigation)
                            .setDestination(R.id.appointmentDetailsFragment)
                            .setArguments(b)
                            .createPendingIntent();

            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();


        } else if (type == NOTIFICATION_OPEN_VIDEO_CONSULTATION) {
            try {
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                Intent resultIntent = new Intent(context, VideoConsultationActivity.class);
                resultIntent.putExtra(EXTRA_IS_FROM_NOTIFICATIONS, true);
                resultIntent.putExtra(Constants.KEY_TYPE, Constants.KEY_TYPE_INCOMING);
                resultIntent.putExtra(Constants.KEY_DATA, data);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                stackBuilder.addParentStack(HomeScreenActivity.class);
                myType = NOTIFICATION_OPEN_VIDEO_CONSULTATION;
                mBuilder.setAutoCancel(false);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
                mBuilder.setContentIntent(resultPendingIntent);
                assert mNotificationManager != null;
                mNotificationManager.cancelAll();


            } catch (Exception ignored) {
            }
        } else if (type == NOTIFICATION_OPEN_ORDER_LAB) {

            myType = NOTIFICATION_OPEN_ORDER_LAB;
            mBuilder.setAutoCancel(false);

            Bundle b = new Bundle();

            b.putBoolean(EXTRA_IS_FROM_NOTIFICATIONS, true);
            b.putString(Constants.KEY_DATA, data);

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setComponentName(HomeScreenActivity.class)
                            .setGraph(R.navigation.main_navigation)
                            //    .setDestination(R.id.orderLabActivity)
                            .setArguments(b)
                            .createPendingIntent();
            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        } else if (type == NOTIFICATION_OPEN_SPLASH) {
            myType = NOTIFICATION_OPEN_SPLASH;
            mBuilder.setAutoCancel(false);

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setComponentName(HomeScreenActivity.class)
                            .setGraph(R.navigation.main_navigation)
                            .setDestination(R.id.splashFragment)
                            .createPendingIntent();

            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        } else if (type == NOTIFICATION_OPEN_CONSULTATION_APPOINTMENT_COMPLETE) {
            baseActivity = (BaseActivity) ActivityUtils.getTopActivity();
            if(baseActivity != null)
                firebaseEvent(baseActivity,"appointment_completed");
            myType = NOTIFICATION_OPEN_CONSULTATION_APPOINTMENT_COMPLETE;

            Bundle b = new Bundle();

            b.putBoolean(EXTRA_IS_FROM_NOTIFICATIONS, true);
            b.putString(Constants.KEY_DATA, data);

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setComponentName(HomeScreenActivity.class)
                            .setGraph(R.navigation.main_navigation)
                            .setArguments(b)
                            //    .setDestination(R.id.consultationDetailFragment)
                            .createPendingIntent();

            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        } else if (type == NOTIFICATION_OPEN_SPLASH_MISSED_CALL) {
            myType = NOTIFICATION_OPEN_SPLASH_MISSED_CALL;
            mBuilder.setAutoCancel(false);

            Bundle b = new Bundle();

            b.putBoolean(EXTRA_IS_FROM_NOTIFICATIONS, true);
            b.putBoolean(EXTRA_MISSED_CALL_NOTIFICATIONS, true);

            PendingIntent pendingIntent =
                    new NavDeepLinkBuilder(context)
                            .setComponentName(HomeScreenActivity.class)
                            .setGraph(R.navigation.main_navigation)
                            .setArguments(b)
                            .setDestination(R.id.splashFragment)
                            .createPendingIntent();

            mBuilder.setContentIntent(pendingIntent);

            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        }

        try {
            Notification notification = mBuilder.build();
            assert mNotificationManager != null;
            mNotificationManager.notify(myType, mBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sendMarketinngNotification(Context context, RemoteMessage.Notification remoteNotification, String data) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        JSONObject dataJson = null;

        try {
            dataJson = new JSONObject(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String CHANNEL_ID = "ac_news_and_marketing";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "News and Marketing", NotificationManager.IMPORTANCE_HIGH);
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(remoteNotification.getTitle())
                .setAutoCancel(true)
                .setChannelId(CHANNEL_ID)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteNotification.getBody()))
                .setSound(soundUri)
                .setContentText(remoteNotification.getBody());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setColor(context.getResources().getColor(R.color.colorBlueButtonSelected));
        }

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        Intent resultIntent = new Intent(context, HomeScreenActivity.class);
        resultIntent.putExtra(Constants.KEY_DATA, data);
        stackBuilder.addParentStack(HomeScreenActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, PendingIntent.FLAG_ONE_SHOT);
        mBuilder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        mBuilder.setContentIntent(resultPendingIntent);

        try {
            Notification notification = mBuilder.build();
            assert mNotificationManager != null;
            mNotificationManager.notify(100, mBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert mNotificationManager != null;
        mNotificationManager.cancelAll();
    }

    public static void dismissNotification(Context context, int notifId) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert mNotificationManager != null;
        mNotificationManager.cancel(notifId);
    }

    public static void dismissNotificationAll(Context context) {
        try {
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void firebaseEvent(BaseActivity baseActivity,String type) {
        GenApiLogger.fireGenericNotificationEvent(baseActivity,type);

    }
}
