package com.augmentcare.patient.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.ChatActivity;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.activities.VideoConsultationActivity;
import com.augmentcare.patient.fragments.SplashFragment;
import com.augmentcare.patient.utils.Constants;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class NotificationHandler {
    public static void sendNotification(Context context, String title, String content, String data, int type) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel;
        JSONObject dataJson = null;

        try {
            if (!data.isEmpty())
                dataJson = new JSONObject(data);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (!VideoConsultationActivity.isAlive) {
//                                    NotificationHelper.sendNotification(this, jsonObject.getString("title"),
//                                            jsonObject.getString("message"), dataJsonObj.toString(), 6);

                Intent intent = new Intent(context, VideoConsultationActivity.class);
                intent.putExtra(com.augmentcare.patient.utils.Constants.KEY_TYPE, com.augmentcare.patient.utils.Constants.KEY_TYPE_INCOMING);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                                   startActivity(intent);
                ActivityUtils.startActivity(intent);
            }
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

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setColor(context.getResources().getColor(R.color.colorPrimary));
        }

        if (type == 1) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            Intent resultIntent = new Intent(context, ChatActivity.class);
            resultIntent.putExtra("isFromNotification", true);
            resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_DATA, data);
            stackBuilder.addParentStack(ChatActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
            mBuilder.setContentIntent(resultPendingIntent);
            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        }
//        else if (type == 2) {
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            Intent resultIntent = new Intent(context, ConsultationPrescriptionActivity.class);
//            resultIntent.putExtra("isFromNotification", true);
//            resultIntent.putExtra(Constants.KEY_DATA, data.toString());
//            try {
//                assert dataJson != null;
//                if (dataJson.has("notification_object")) {
//                    myType = dataJson.getJSONObject("notification_object").getInt("slot_id");
//                }
//            } catch (Exception ignored) {
//            }
//
//            stackBuilder.addParentStack(ConsultationPrescriptionActivity.class);
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
//            mBuilder.setContentIntent(resultPendingIntent);
//            assert mNotificationManager != null;
//            mNotificationManager.cancelAll();
//        }
//        else if (type == 3) {
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            Intent resultIntent = new Intent(context, ConsultationPrescriptionActivity.class);
//            resultIntent.putExtra("isFromNotification", true);
//            resultIntent.putExtra(Constants.KEY_DATA, data.toString());
//            stackBuilder.addParentStack(ConsultationPrescriptionActivity.class);
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
//            mBuilder.setContentIntent(resultPendingIntent);
//            assert mNotificationManager != null;
//            mNotificationManager.cancelAll();
//        }
        else if (type == 4) {
            try {
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                Intent resultIntent = new Intent(context, VideoConsultationActivity.class);
                resultIntent.putExtra("isFromNotification", true);
                resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_DATA, data.toString());
                resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_TYPE, com.augmentcare.patient.utils.Constants.KEY_TYPE_INCOMING);
                resultIntent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_SINGLE_TOP);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
                mBuilder.setContentIntent(resultPendingIntent);
                assert mNotificationManager != null;
                mNotificationManager.cancelAll();
            } catch (Exception ignored) {
            }
        } else if (type == 5) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            Intent resultIntent = new Intent(context, HomeScreenActivity.class);
            resultIntent.putExtra("isFromNotification", true);
            resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_DATA, data.toString());
            stackBuilder.addParentStack(HomeScreenActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
            mBuilder.setContentIntent(resultPendingIntent);
            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        } else if (type == 6) {
            try {
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                Intent resultIntent = new Intent(context, VideoConsultationActivity.class);
                resultIntent.putExtra("isFromNotification", true);
                resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_TYPE, com.augmentcare.patient.utils.Constants.KEY_TYPE_INCOMING);
                resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_DATA, data.toString());
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                stackBuilder.addParentStack(VideoConsultationActivity.class);
                myType = 6;
                mBuilder.setAutoCancel(false);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
                mBuilder.setContentIntent(resultPendingIntent);
                assert mNotificationManager != null;
                mNotificationManager.cancelAll();
            } catch (Exception ignored) {
            }
        }
//        else if (type == 7) {
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            Intent resultIntent = new Intent(context, OrderLabActivity.class);
//            resultIntent.putExtra("isFromNotification", true);
//            resultIntent.putExtra(Constants.KEY_DATA, data.toString());
//            stackBuilder.addParentStack(OrderLabActivity.class);
//            myType = 7;
//            mBuilder.setAutoCancel(false);
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
//            mBuilder.setContentIntent(resultPendingIntent);
//            assert mNotificationManager != null;
//            mNotificationManager.cancelAll();
//        }
        else if (type == 8) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            Intent resultIntent = new Intent(context, SplashFragment.class);
            myType = 8;
            mBuilder.setAutoCancel(false);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
            mBuilder.setContentIntent(resultPendingIntent);
            assert mNotificationManager != null;
            mNotificationManager.cancelAll();
        }
//        else if (type == 10) {
//            firebaseEvent("appointment_completed");
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            Intent resultIntent = new Intent(context, ConsultationPrescriptionActivity.class);
//            resultIntent.putExtra("isFromNotification", true);
//            resultIntent.putExtra(Constants.KEY_DATA, data.toString());
//            stackBuilder.addParentStack(ConsultationPrescriptionActivity.class);
//            myType = 10;
//            mBuilder.setAutoCancel(false);
//            assert mNotificationManager != null;
//            mNotificationManager.cancelAll();
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
//            mBuilder.setContentIntent(resultPendingIntent);
//            mNotificationManager.cancelAll();
//        }
        else if (type == 11) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            Intent resultIntent = new Intent(context, SplashFragment.class);
            resultIntent.putExtra("isFromNotification", true);
            resultIntent.putExtra("missed_call_notification", true);
            myType = 11;
            mBuilder.setAutoCancel(false);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, 0);
            mBuilder.setContentIntent(resultPendingIntent);
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
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setColor(context.getResources().getColor(R.color.colorBlueButtonSelected));
        }

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        Intent resultIntent = new Intent(context, HomeScreenActivity.class);
        resultIntent.putExtra(com.augmentcare.patient.utils.Constants.KEY_DATA, data);
        stackBuilder.addParentStack(HomeScreenActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, PendingIntent.FLAG_ONE_SHOT);
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
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert mNotificationManager != null;
        mNotificationManager.cancelAll();
    }

}