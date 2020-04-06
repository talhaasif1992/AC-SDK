package com.augmentcare.patient.activities;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.TokBoxObj;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.network.restApi.apirequests.TokBoxSessionRequest;
import com.augmentcare.patient.notifications.NotificationHelper;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opentok.android.BaseVideoRenderer;
import com.opentok.android.Connection;
import com.opentok.android.OpentokError;
import com.opentok.android.Publisher;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;
import com.opentok.android.SubscriberKit;

import org.json.JSONObject;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class VideoConsultationActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks, Session.SessionListener,
        PublisherKit.PublisherListener, SubscriberKit.SubscriberListener {

    private static final String TAG = VideoConsultationActivity.class.getSimpleName();

    ////////////// Views ////////////////////
    private View spaceBwAcceptDecline;
    private FrameLayout flMyVideo;
    private FrameLayout flCallerVideo;
    private FrameLayout lytPicContainer;
    private View lytControls;
    private TextView txtName;
    private TextView tvIncomingCallTag;
    private TextView tvIncomingCallName;
    private TextView tvConnecting;
    private ImageView btnEndCall;
    private ImageView btnAcceptCall;
    private AppCompatImageView ivIncomingCall;
    private ImageButton btnMuteAudio;
    private ImageButton btnMuteVideo;
    private ImageButton btnSwitchCamera;
    private ImageButton btnRejectCall;
    private View lytMuteButtons;
    private LinearLayout mTitleLinearLayout;
    ////////////////////////////////////////

    private static final int MIC_AND_CAMERA_PERMISSION = 123;
    private TokBoxObj tokBoxObject;
    private Session session;
    private Subscriber subscriber;
    private ConsultationDetails consultation;
    private JsonObject incomingCallObject;
    private UserLogin loggedInUser;
    private CountDownTimer countDownTimer;
    public static boolean isAlive = false;
    private boolean isPlayedTune = false;
    private boolean isToStartCall;
    private boolean isCallAccepted;
    private MediaPlayer mediaPlayer;
    private Publisher publisher;
    private JSONObject answerCallObject;
    private String[] PERMISSIONS_VIDEO;
    private KeyguardManager.KeyguardLock keyguardLock;

    private LinearLayout lytVideoHeader;
    private TextView tvDoctorName;
    private ImageView ivDipper;
    private TextView tvTimer;
    private int counter = 0;
    private int seconds = 0, minutes = 0;
    private CountDownTimer actualCallCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_video_cons);

        isAlive = true;

        initializeViews();
        initializeClickListeners();
        initializeData();
    }

    private void initializeViews() {
        lytPicContainer = findViewById(R.id.lytPicContainer);
        flMyVideo = findViewById(R.id.lytMyVideo);
        btnSwitchCamera = findViewById(R.id.btnSwitchCamera);
        flCallerVideo = findViewById(R.id.lytOngoingVideo);
        btnEndCall = findViewById(R.id.fabEndCall);
        btnAcceptCall = findViewById(R.id.fabAnswerCall);
        spaceBwAcceptDecline = findViewById(R.id.spaceBwAcceptDecline);
        txtName = findViewById(R.id.txtName);
        tvIncomingCallTag = findViewById(R.id.lableincomingcall);
        tvIncomingCallName = findViewById(R.id.doctor_name_textview);
        tvDoctorName = findViewById(R.id.tv_doctor_name);
        tvConnecting = findViewById(R.id.txtConnecting);
        ivIncomingCall = findViewById(R.id.ivProfileImage);
        lytControls = findViewById(R.id.lytControls);
        btnMuteAudio = findViewById(R.id.btnMuteAudio);
        btnMuteVideo = findViewById(R.id.btnMuteVideo);
        btnRejectCall = findViewById(R.id.btnCancelVideoCall);
        lytMuteButtons = findViewById(R.id.lytMuteButtons);
        mTitleLinearLayout = findViewById(R.id.title_layout);
        lytVideoHeader = findViewById(R.id.lyt_video_header);
        tvTimer = findViewById(R.id.tv_timer);
        ivDipper = findViewById(R.id.iv_dipper);
    }

    private void initializeClickListeners() {
        btnMuteAudio.setOnClickListener(v -> btnMuteAudioOnClick());
        btnMuteVideo.setOnClickListener(v -> btnMuteVideoOnClick());
        btnRejectCall.setOnClickListener(v -> btnRejectCallOnClick());
        btnEndCall.setOnClickListener(v -> btnEndCallOnClick());
        btnAcceptCall.setOnClickListener(v -> btnAcceptCallOnClick());
        btnSwitchCamera.setOnClickListener(v -> btnSwitchCameraOnClick());

    }

    private void firebaseEvent(String type) {
        try {
            if (userData.getId() != null && !userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent(type, userData.getId());
        } catch (Exception ignored) {
        }
    }

    private void btnSwitchCameraOnClick() {
        try {
            publisher.cycleCamera();
        } catch (Exception ignored) {
        }
    }

    private void btnAcceptCallOnClick() {
        stopRingTone();
        lytControls.setBackgroundResource(android.R.color.transparent);
        txtName.setVisibility(View.INVISIBLE);
        btnRejectCall.setVisibility(View.GONE);
        spaceBwAcceptDecline.setVisibility(View.GONE);
        mTitleLinearLayout.setVisibility(View.GONE);
        btnAcceptCall.setVisibility(View.GONE);
        tvIncomingCallTag.setVisibility(View.GONE);
        tvConnecting.setVisibility(View.VISIBLE);
        btnEndCall.setVisibility(View.VISIBLE);
        btnMuteVideo.setVisibility(View.VISIBLE);
        btnMuteAudio.setVisibility(View.VISIBLE);
        flCallerVideo.setVisibility(View.VISIBLE);
        flMyVideo.setVisibility(View.VISIBLE);

        isCallAccepted = true;

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        JSONObject answerCallObject = new JSONObject();
        try {
            answerCallObject.put("key", incomingCallObject.get("key").getAsString());
            answerCallObject.put("response", "accepted");

            String docName = "Dr. " + incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString() +
                    " " + incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString();

            tvIncomingCallName.setText(docName + " is Calling...");
            tvDoctorName.setText(docName);
            isToStartCall = true;
            AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);

            tokBoxTokenAPI(
                    new TokBoxSessionRequest()
                            .withDoctorRoleId(incomingCallObject.get("doctor_role_id").getAsLong())
                            .withPatientRoleId(incomingCallObject.get("patient_role_id").getAsLong())
                            .withSlotId(incomingCallObject.get("slot_id").getAsInt())
                            .withUid(userData.getUid())
//                            .withCallInfo(getUserInfo())
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnEndCallOnClick() {
        stopRingTone();

        if (actualCallCounter != null) {
            actualCallCounter.cancel();
            actualCallCounter = null;
        }

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        try {
            NotificationHelper.dismissNotification(getApplicationContext(), 6);
        } catch (Exception e) {
        }

        answerCallObject = new JSONObject();

        try {
            if (getIntent().getStringExtra("type").equals("incoming")) {
                if (isCallAccepted) {
                    answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                    answerCallObject.put("type", "reset");
                    AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                    disconnectCall();
                    finishAndRemoveTask();
                } else {
                    answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                    answerCallObject.put("response", "rejected");
                    AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                    disconnectCall();
                    finishAndRemoveTask();
                }
            } else {
                if (isCallAccepted) {
                    answerCallObject.put("key", consultation.getChannelKey());
                    answerCallObject.put("type", "reset");
                    AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                    disconnectCall();
                    finishAndRemoveTask();
                } else {
                    answerCallObject.put("key", consultation.getChannelKey());
                    answerCallObject.put("response", "rejected");
                    AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                    disconnectCall();
                    finishAndRemoveTask();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnMuteVideoOnClick() {
        firebaseEvent("video_camera_turned_off");
        try {
            publisher.setPublishVideo(!publisher.getPublishVideo());
            if (publisher.getPublishVideo()) {
                btnMuteVideo.getDrawable().setAlpha(255);
            } else {
                btnMuteVideo.getDrawable().setAlpha(30);
            }
        } catch (Exception e) {
        }
    }


    private void btnRejectCallOnClick() {
        try {
            stopRingTone();

            if (actualCallCounter != null) {
                actualCallCounter.cancel();
                actualCallCounter = null;
            }

            if (countDownTimer != null) {
                countDownTimer.cancel();
            }

            try {
                NotificationHelper.dismissNotification(getApplicationContext(), 6);

            } catch (Exception ignored) {
            }

            answerCallObject = new JSONObject();

            try {
                if (getIntent().getStringExtra("type").equals("incoming")) {

                    if (isCallAccepted) {
                        answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                        answerCallObject.put("type", "reset");
                        AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit("remote_end_call_event_emit_from_chat",
                                answerCallObject);
                        disconnectCall();
                        finishAndRemoveTask();
                    } else {
                        answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                        answerCallObject.put("response", "rejected");
                        AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                        disconnectCall();
                        finishAndRemoveTask();
                    }
                } else {
                    if (isCallAccepted) {
                        answerCallObject.put("key", consultation.getChannelKey());
                        answerCallObject.put("type", "reset");
                        AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                        disconnectCall();
                        finishAndRemoveTask();
                    } else {
                        answerCallObject.put("key", consultation.getChannelKey());
                        answerCallObject.put("response", "rejected");
                        AppSocket.getInstance(VideoConsultationActivity.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                        disconnectCall();
                        finishAndRemoveTask();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ignored) {
        }

        mTitleLinearLayout.setVisibility(View.GONE);
        firebaseEvent("video_call_rejected");
    }

    private void btnMuteAudioOnClick() {

        try {
            publisher.setPublishAudio(!publisher.getPublishAudio());
            if (publisher.getPublishAudio()) {
                btnMuteAudio.getDrawable().setAlpha(255);
            } else {
                btnMuteAudio.getDrawable().setAlpha(30);
            }
        } catch (Exception ignored) {
        }
    }

    private void initializeData() {
        if (!AppSocket.getInstance(this).isConnected()) {
            AppSocket.getInstance(this).getSocket().connect();
        }

        loggedInUser = PrefsHelper.getLoggedInUser();
        tokBoxObject = getIntent().getParcelableExtra("tbObject");
        consultation = getIntent().getParcelableExtra("consultation_detail");

        if(loggedInUser==null)
        {
            Toasty.error(getApplicationContext(),"Please Login Again to accept call",Toasty.LENGTH_LONG).show();
        }

        initializeWakeScreen();
        //initializeTimer();
        initializeIncomingCall();
    }

    private void initializeIncomingCall() {
        if (getIntent()!=null && getIntent().getStringExtra("type").equals("incoming")) {
            String str = getIntent().getStringExtra("data");
            incomingCallObject = new Gson().fromJson(str, JsonObject.class);

            if (incomingCallObject != null) {
                String docName = "Dr. " + incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString() +
                        " " + incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString();

                tvIncomingCallName.setText(docName + " is Calling...");
                tvDoctorName.setText(docName);

                Glide.with(this).load(incomingCallObject.get("caller_info").getAsJsonObject().get("photo").getAsString())
                        .apply(RequestOptions.circleCropTransform()).into(ivIncomingCall);
            }
        } else {
            Glide.with(this).load(userData.getPhone()).apply(RequestOptions.circleCropTransform()).into(ivIncomingCall);
            txtName.setVisibility(View.INVISIBLE);
            btnAcceptCall.setVisibility(View.GONE);
            spaceBwAcceptDecline.setVisibility(View.GONE);
            btnRejectCall.setVisibility(View.GONE);
            AppSocket.getInstance(this).getSocket().emit("start_call", getOutgoingCallObject(consultation));
        }

        if (incomingCallObject != null) {
            tokBoxTokenAPI(
                    new TokBoxSessionRequest()
                            .withDoctorRoleId(incomingCallObject.get("doctor_role_id").getAsLong())
                            .withPatientRoleId(incomingCallObject.get("patient_role_id").getAsLong())
                            .withSlotId(incomingCallObject.get("slot_id").getAsInt())
                            .withUid(userData.getUid())
                            .withUserLoginChannel(loggedInUser.getChannel())
                            .withCallInfo(userData)
            );
        }
    }

    private void tokBoxTokenAPI(TokBoxSessionRequest request) {
        getDisposer().add(
                RXAPI.getTokBoxVideoSession(request).subscribe(tokBoxObj -> {
                    tokBoxObject = tokBoxObj;


                    if (isToStartCall) {
                        flMyVideo.setVisibility(View.VISIBLE);
                        initOpenTokCalling(tokBoxObject);

                    }
                }, e -> {
                    LocalUtils.processAPIError(e);
//                    finish();
                    finishAffinity();
                })
        );
    }

    private void initOpenTokCalling(TokBoxObj tokBoxObject) {
        if (tokBoxObject != null) {
            initializeSession(tokBoxObject.api, tokBoxObject.session_id, tokBoxObject.token);
        }
       // refreshCalling();

        stopRingTone();
    }

//    private void refreshCalling(){
//        isPlayedTune = false;
//
//        if (session != null) {
//            session.onPause();
//        }
//
//
//        stopRingTone();
//
//        try {
//            LocalBroadcastManager.getInstance(this).unregisterReceiver(mConnectionListener);
//            LocalBroadcastManager.getInstance(this).unregisterReceiver(mCallResponseReceiver);
//            LocalBroadcastManager.getInstance(this).unregisterReceiver(mCallEndReceiver);
//        } catch (Exception e) {
//        }
//
//        try {
//            if (!isPlayedTune && getIntent().getStringExtra("type").equals("incoming")
//                    && (mediaPlayer != null && !mediaPlayer.isPlaying()) || mediaPlayer == null) {
//                ringTone();
//                isPlayedTune = true;
//            }
//        } catch (Exception e) {
//        }
//
//        if (session != null) {
//            session.onResume();
//        }
//
//        isAlive = true;
//        mConnectionListener = new ConnectionChangeListener();
//        mCallResponseReceiver = new CallResponseReceiver();
//        mCallEndReceiver = new CallEndReceiver();
//        IntentFilter sockConnectivityFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CONNECTION_CHANGED);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mConnectionListener, sockConnectivityFilter);
//        IntentFilter socketCallresposnFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_RESPONSE);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mCallResponseReceiver, socketCallresposnFilter);
//        IntentFilter callEndIntent = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_END);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mCallEndReceiver, callEndIntent);
//
//    }

    private void initializeTimer() {
        countDownTimer = new CountDownTimer(30_000, 1_000) {
            public void onTick(long millisUntilFinished) {
                Log.wtf("countdown", "countdownCall");
            }

            public void onFinish() {
                String docName = "Dr. " + incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString() +
                        " " + incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString();

                NotificationHelper.sendNotification(VideoConsultationActivity.this, "Missed Call Alert! ",
                        "You have missed a scheduled call with " + docName + ".", incomingCallObject.toString(), 11);
                disconnectCall();

                GenApiLogger.fireSegmentAndIntercomVideoConsultationEvent(loggedInUser);
                finish();

            }
        }.start();
    }

//    private void startCalltimer() {
//        if (actualCallCounter != null) {
//            actualCallCounter.cancel();
//            actualCallCounter = null;
//        }
//
//        long totalMinutesAvailable = 5;
//        actualCallCounter = new CountDownTimer(totalMinutesAvailable * 60_000, 1_000) {
//            @Override
//            public void onTick(long l) {
//
//                long diffSeconds = l / 1000 % 60;
//                long diffMinutes = l / (60 * 1000) % 60;
//                String mins = diffMinutes > 9 ? "" + diffMinutes : "0" + diffMinutes;
//                String secs = diffSeconds > 9 ? "" + diffSeconds : "0" + diffSeconds;
//
//                tvTimer.setText(MessageFormat.format("{0}:{1}", mins, secs));
//
//                if ((totalMinutesAvailable - diffMinutes) <= 5) {
//                    if (diffSeconds % 2 == 0) {
//                        tvTimer.setTextColor(Color.WHITE);
//                    } else {
//                        tvTimer.setTextColor(Color.RED);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFinish() {
//            }
//        }.start();
//    }

    private void timer(){
        new CountDownTimer(20 * 60_000,1_000){
            @Override
            public void onTick(long l){
                if(counter==60){
                    minutes++;
                    counter=0;
                    if(minutes < 10){
                        tvTimer.setText("0"+minutes+" : 00");
                    }
                    else{
                        tvTimer.setText(minutes+" : 00");
                    }
                }
                else if(counter < 60 && minutes < 10){
                    if(counter < 10){
                        tvTimer.setText("0"+minutes+" : 0"+counter);
                    }
                    else{
                        tvTimer.setText("0"+minutes+" : "+counter);
                    }
                }
                else if(counter < 60){
                    if(counter < 10){
                        tvTimer.setText(minutes+" : 0"+counter);
                    }
                    else{
                        tvTimer.setText(minutes+" : "+counter);
                    }
                }
                //TODO have to change counter time
                if(minutes >= 5){
                    if(counter%2==0){
                        ivDipper.setVisibility(View.GONE);
                        tvTimer.setTextColor(Color.WHITE);
                    }
                    else{
                        ivDipper.setVisibility(View.VISIBLE);
                        tvTimer.setTextColor(Color.RED);
                    }
                }
                counter++;
            }

            @Override
            public void onFinish(){
            }
        }.start();
    }
    private void disconnectCall() {
        try {
            session.disconnect();
        } catch (Exception ignored) {}
    }

    private void restartApp() {
        try {
            finishAffinity();
            Intent newIntent = new Intent(getApplicationContext(),HomeScreenActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(newIntent);
        } catch (Exception ignored) {
        }
    }

    private void initializeWakeScreen() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
            if(keyguardManager != null)
                keyguardManager.requestDismissKeyguard(this,null);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        } else {
            // These flags ensure that the activity can be launched when the screen is locked.
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        }

        PERMISSIONS_VIDEO = new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.DISABLE_KEYGUARD
        };
        if (EasyPermissions.hasPermissions(this, PERMISSIONS_VIDEO)) {
            initWakeLockAfterPerm();
        } else {
            EasyPermissions.requestPermissions(this, "Please provide listed permissions to consult with doctor",
                    MIC_AND_CAMERA_PERMISSION, PERMISSIONS_VIDEO);
        }


//        try {
//            Window win = getWindow();
//            win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
//            win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        } catch (Exception ignored) {
//        }
    }

    //锁屏、唤醒相关
    private PowerManager powerManager;
    private PowerManager.WakeLock wakeLock;

    private void wakeAndUnlock(boolean b) {
        if (b) {
            //获取电源管理器对象
            powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
            //获取PowerManager.WakeLock对象，后面的参数|表示同时传入两个值，最后的是调试用的Tag
            wakeLock = powerManager.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_BRIGHT_WAKE_LOCK, TAG);

            // 屏幕解锁
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("unLock");

            keyguardLock.reenableKeyguard();
            keyguardLock.disableKeyguard(); // 解锁

            //点亮屏幕
            wakeLock.acquire();
        } else {
            //释放wakeLock，关灯
            wakeLock.release();
        }
    }

    private void initWakeLockAfterPerm() {
        wakeAndUnlock(true);
    }


    private void initializeSession(String apiKey, String sessionId, String token) {

        session = new Session.Builder(this, apiKey, sessionId).build();
        session.setSessionListener(this);
        session.connect(token);
    }

    private JSONObject getOutgoingCallObject(ConsultationDetails consultationDetail) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("event_type", "accept_call");
            jsonObject.put("uid", loggedInUser.getUserData().getEmail());
            jsonObject.put("slot_id", consultationDetail.getSlot().getId());
            jsonObject.put("doctor_role_id", consultationDetail.getUserRoleId());
//            jsonObject.put("patient_role_id", ACApplication.INSTANCE.getRole().getId());
            jsonObject.put("key", consultationDetail.getChannelKey());
            jsonObject.put("caller_info", new JSONObject(new Gson().toJson(loggedInUser.getUserData())));

        } catch (Exception e) {
        }

        return jsonObject;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {


            if (!isPlayedTune && getIntent().getStringExtra("type").equals("incoming")
                    && (mediaPlayer != null && !mediaPlayer.isPlaying()) || mediaPlayer == null) {
                ringTone();
                isPlayedTune = true;
            }
//
        super.onResume();
//
        if (session != null) {
            session.onResume();
        }


        isAlive = true;
        mConnectionListener = new ConnectionChangeListener();
        mCallResponseReceiver = new CallResponseReceiver();
        mCallEndReceiver = new CallEndReceiver();
        IntentFilter sockConnectivityFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CONNECTION_CHANGED);
        LocalBroadcastManager.getInstance(this).registerReceiver(mConnectionListener, sockConnectivityFilter);
        IntentFilter socketCallresposnFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_RESPONSE);
        LocalBroadcastManager.getInstance(this).registerReceiver(mCallResponseReceiver, socketCallresposnFilter);
        IntentFilter callEndIntent = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_END);
        LocalBroadcastManager.getInstance(this).registerReceiver(mCallEndReceiver, callEndIntent);

        }

    @Override
    protected void onPause() {
        super.onPause();
        isPlayedTune = false;

        if (session != null) {
            session.onPause();
        }

        stopRingTone();

        try {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(mConnectionListener);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(mCallResponseReceiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(mCallEndReceiver);
        } catch (Exception e) {
        }

        isAlive = false;
    }

    private void stopRingTone() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    private void ringTone() {
        try {
            Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this, alert);
            final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            if (audioManager.getStreamVolume(AudioManager.STREAM_RING) != 0) {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
                mediaPlayer.setLooping(true);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void onStop() {
        try {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            wakeAndUnlock(false);
        } catch (Exception e) {
        }

        super.onStop();
    }

    ConnectionChangeListener mConnectionListener;

    public class ConnectionChangeListener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getStringExtra(AppSocket.SOCKET_STATUS).equals(AppSocket.SOCKET_STATUS_DISCONNECTED)) {
            } else {
            }
        }
    }

    CallResponseReceiver mCallResponseReceiver;

    public class CallResponseReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject jsonObject = new JSONObject(Objects.requireNonNull(intent.getStringExtra("data")));
                String response = jsonObject.getString("response");
                Log.d("VideoScreen", "VideoScreen " + jsonObject.toString());

                if (response.equals("rejected")) {
                    String userType = "Doctor";

                    if (getPackageName().contains("patient"))
                        userType = "Doctor";
                    else
                        userType = "Patient";

                    Toasty.error(VideoConsultationActivity.this,
                            String.format("Oops! the %s rejected your call. Maybe they are a little busy!? Please try again after a few seconds. ",
                                    userType),
                            Toast.LENGTH_SHORT, false).show();

                    disconnectCall();
                   finishAndRemoveTask();
                }

                if (response.equals("accepted")) {
                    initOpenTokCalling(tokBoxObject);
                    Toast.makeText(getApplicationContext(),"initOpenTokCalling123",Toast.LENGTH_LONG).show();

                    isCallAccepted = true;

                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    CallEndReceiver mCallEndReceiver;

    public class CallEndReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject jsonObject = new JSONObject(Objects.requireNonNull(intent.getStringExtra("data")));
                if (jsonObject.has("reason")) {
                    if (jsonObject.getString("reason").equals("reset")) {
                        Toasty.success(VideoConsultationActivity.this,
                                "The doctor has ended the call. Everything's OK otherwise! Do give feedback for the doctor. Make them happy. ",
                                Toast.LENGTH_LONG, false).show();
                        disconnectCall();
                        finishAndRemoveTask();
                    } else {
                        Toasty.success(VideoConsultationActivity.this,
                                "The doctor has ended the call. Everything's OK otherwise! Do give feedback for the doctor. Make them happy. ",
                                Toast.LENGTH_LONG, false).show();
                        disconnectCall();
                        finishAndRemoveTask();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        initWakeLockAfterPerm();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle(getString(R.string.title_settings_dialog))
                    .setRationale(getString(R.string.rationale_ask_again))
                    .setPositiveButton("OK")
                    .setNegativeButton("CANCEL")
                    .setRequestCode(MIC_AND_CAMERA_PERMISSION)
                    .build()
                    .show();
        }
    }

    @Override
    public void onStreamCreated(PublisherKit publisherKit, Stream stream) {
    }

    @Override
    public void onStreamDestroyed(PublisherKit publisherKit, Stream stream) {

    }

    @Override
    public void onError(PublisherKit publisherKit, OpentokError opentokError) {

    }

    @Override
    public void onConnected(Session session) {
        lytControls.setBackgroundResource(android.R.color.transparent);
        txtName.setVisibility(View.INVISIBLE);
        btnAcceptCall.setVisibility(View.GONE);
        spaceBwAcceptDecline.setVisibility(View.GONE);
        btnRejectCall.setVisibility(View.GONE);
        btnEndCall.setVisibility(View.VISIBLE);
        btnMuteAudio.setVisibility(View.VISIBLE);
        btnMuteVideo.setVisibility(View.VISIBLE);
        flMyVideo.setVisibility(View.VISIBLE);

        publisher = new Publisher.Builder(this).build();
        publisher.getRenderer().setStyle(BaseVideoRenderer.STYLE_VIDEO_SCALE, BaseVideoRenderer.STYLE_VIDEO_FILL);
        publisher.setPublisherListener(this);
        flMyVideo.addView(publisher.getView());
        session.publish(publisher);

        if (publisher.getView() instanceof GLSurfaceView) {

            ((GLSurfaceView) publisher.getView()).setZOrderOnTop(true);
        }
    }

    @Override
    public void onDisconnected(Session session) {
        lytMuteButtons.setVisibility(View.GONE);
        btnMuteAudio.setVisibility(View.GONE);
        btnMuteVideo.setVisibility(View.GONE);

    }

    @Override
    public void onStreamReceived(Session session, Stream stream) {

        if (subscriber == null) {

            subscriber = new Subscriber.Builder(this, stream).build();
            subscriber.getRenderer().setStyle(BaseVideoRenderer.STYLE_VIDEO_SCALE, BaseVideoRenderer.STYLE_VIDEO_FILL);
            this.session.subscribe(subscriber);
            flCallerVideo.setVisibility(View.VISIBLE);
            flCallerVideo.addView(subscriber.getView());
            initializeTimer();

        }

        lytVideoHeader.setVisibility(View.VISIBLE);
        lytMuteButtons.setVisibility(View.VISIBLE);
        mTitleLinearLayout.setVisibility(View.GONE);
        tvIncomingCallTag.setVisibility(View.GONE);
        ivIncomingCall.setVisibility(View.GONE);
        tvConnecting.setVisibility(View.GONE);
        lytPicContainer.setVisibility(View.GONE);
        btnEndCall.setVisibility(View.VISIBLE);
        stopRingTone();
//        startCalltimer();
        timer();
    }

    @Override
    public void onStreamDropped(Session session, Stream stream) {
        if (subscriber != null) {
            subscriber = null;
            flCallerVideo.removeAllViews();
        }
    }

    @Override
    public void onError(Session session, OpentokError opentokError) {
        session.connect(tokBoxObject.token);
        showSnack("Please wait! Initializing video . . .", false, 2);
    }

    @Override
    public void onConnected(SubscriberKit subscriberKit) {
    }

    @Override
    public void onDisconnected(SubscriberKit subscriberKit) {

    }

    @Override
    public void onError(SubscriberKit subscriberKit, OpentokError opentokError) {
        session.connect(tokBoxObject.token);
        showSnack("Please wait! Initializing video . . .", false, 2);
    }



}