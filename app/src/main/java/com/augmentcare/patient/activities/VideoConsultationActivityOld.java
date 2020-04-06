package com.augmentcare.patient.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
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

import androidx.appcompat.widget.AppCompatImageView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.navigation.NavController;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.restApi.apimodels.ConsultationDetails;
import com.augmentcare.patient.network.restApi.apimodels.TokBoxObj;
import com.augmentcare.patient.network.restApi.apirequests.TokBoxSessionRequest;
import com.augmentcare.patient.notifications.NotificationHelper;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonObject;
import com.opentok.android.BaseVideoRenderer;
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

import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.AppSettingsDialog;

import static com.augmentcare.patient.notifications.Constants.NOTIFICATION_OPEN_VIDEO_CONSULTATION;

public class VideoConsultationActivityOld extends BaseActivity implements Session.SessionListener,
        PublisherKit.PublisherListener, SubscriberKit.SubscriberListener
{
    private static final String LOG_TAG = VideoConsultationActivityOld.class.getSimpleName();
    private static final int RC_SETTINGS_SCREEN_PERM = 123;
    private static final int RC_VIDEO_APP_PERM = 124;
    private Session mSession;
    private Publisher mPublisher;
    private Subscriber mSubscriber;
    private View spaceBwAcceptDecline;
    private FrameLayout mPublisherViewContainer;
    private FrameLayout mSubscriberViewContainer;
    private FrameLayout lytPicContainer;
    private View lytControls;
    TextView txtName, lableincomingcall, mDoctorNameTextView, mConnectingTextView;
    TokBoxObj tokBoxObject;
    ImageView fabEndCall;
    ImageView fabAnswerCall;
    AppCompatImageView ivProfileImage;

    private View progressContent;
    private ConsultationDetails consultation;
    JsonObject incomingCallObject;
    private boolean isToStartCall;
    private boolean isCallAccepted;
    CountDownTimer countDownTimer;
    private boolean isPlayedTune = false;
    public static boolean isAlive = false;
    private ImageButton btnMuteAudio;
    private ImageButton btnMuteVideo, btnSwitchCamera, btnCancelVideoCall;
    private View lytMuteButtons;
    MediaPlayer mMediaPlayer;
    JSONObject answerCallObject;
    LinearLayout mTitleLinearLayout;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_video_cons);

//        navController = Navigation.findNavController(this,R.id.nav_host_fragment);

        lytPicContainer = findViewById(R.id.lytPicContainer);
        mPublisherViewContainer = findViewById(R.id.lytMyVideo);
        btnSwitchCamera = findViewById(R.id.btnSwitchCamera);
        mSubscriberViewContainer = findViewById(R.id.lytOngoingVideo);
        fabEndCall = findViewById(R.id.fabEndCall);
        fabAnswerCall = findViewById(R.id.fabAnswerCall);
        spaceBwAcceptDecline = findViewById(R.id.spaceBwAcceptDecline);
        txtName = findViewById(R.id.txtName);
        lableincomingcall = findViewById(R.id.lableincomingcall);
        mDoctorNameTextView = findViewById(R.id.doctor_name_textview);
        mConnectingTextView = findViewById(R.id.txtConnecting);
        ivProfileImage = findViewById(R.id.ivProfileImage);
        progressContent = findViewById(R.id.progressContent);
        lytControls = findViewById(R.id.lytControls);
        btnMuteAudio = findViewById(R.id.btnMuteAudio);
        btnMuteVideo = findViewById(R.id.btnMuteVideo);
        btnCancelVideoCall = findViewById(R.id.btnCancelVideoCall);
        lytMuteButtons = findViewById(R.id.lytMuteButtons);
        mTitleLinearLayout = findViewById(R.id.title_layout);
        lytMuteButtons.setVisibility(View.GONE);

        firebaseEvent("video_call_screen");
        tokBoxObject = getIntent().getParcelableExtra(Constants.KEY_TOK_BOX_OBJECT);
        consultation = getIntent().getParcelableExtra(Constants.KEY_CONSULTATION_DETAIL);

        try {
            PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
            PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyApp::MyWakelockTag");
            Window win = getWindow();
            win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } catch (Exception e) {
        }

        AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().connect();

        btnSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mPublisher.cycleCamera();
                } catch (Exception ignored) {
                }
            }
        });

        countDownTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                Log.wtf("countdown", "countdownCall");
            }

            public void onFinish() {
                String docName = "Dr. " + incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString() +
                        " " + incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString();

                NotificationHelper.sendNotification(VideoConsultationActivityOld.this, "Missed Call Alert! ", "You have missed a scheduled call with " + docName + ".", incomingCallObject.toString(), 11);
                finishAndOpenHome();
                disconnectCall();

//                if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING))
//                {
//                    NotificationHelper.dismissNotification(getApplicationContext(), 6);
//                }
//                else
//                {
//                    String user = "Doctor";
//                    String message = getString(R.string.respondent_did_not_answer);
//
//                    if (getPackageName().contains("patient"))
//                        user = "Doctor";
//                    else
//                        user = "Patient";
//
//                    Toasty.error(VideoConsultationActivityOld.this,String.format(message, user), Toast.LENGTH_LONG, false).show();
//                }

                GenApiLogger.fireSegmentAndIntercomVideoConsultationEvent(userData);


            }
        }.start();

        btnMuteAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPublisher.setPublishAudio(!mPublisher.getPublishAudio());

                    if (mPublisher.getPublishAudio()) {
                        btnMuteAudio.getDrawable().setAlpha(255);
                    } else {
                        btnMuteAudio.getDrawable().setAlpha(30);
                    }
                } catch (Exception ignored) {
                }
            }
        });

        btnCancelVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    stopRingTone();
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }

                    try {
                        NotificationHelper.dismissNotification(getApplicationContext(), NOTIFICATION_OPEN_VIDEO_CONSULTATION);

                        if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)) {
                            AnalyticsUtils.appointmentVideoConsultDrop(VideoConsultationActivityOld.this, "incoming");
                        } else {
                            AnalyticsUtils.appointmentVideoConsultDrop(VideoConsultationActivityOld.this, "outgoing");
                        }
                    } catch (Exception ignored) {
                    }
                    answerCallObject = new JSONObject();

                    try {
                        if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)) {

                            if (isCallAccepted) {
                                answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                                answerCallObject.put("type", "reset");
                                AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit("remote_end_call_event_emit_from_chat",
                                        answerCallObject);
                                disconnectCall();
                                finishAndOpenHome();
                            } else {
                                answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                                answerCallObject.put("response", "rejected");
                                AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                                disconnectCall();
                                finishAndOpenHome();
                            }
                        } else {
                            if (isCallAccepted) {
                                answerCallObject.put("key", consultation.getChannelKey());
                                answerCallObject.put("type", "reset");
                                AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                                disconnectCall();
                                finishAndOpenHome();
                            } else {
                                answerCallObject.put("key", consultation.getChannelKey());
                                answerCallObject.put("response", "rejected");
                                AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                                disconnectCall();
                                finishAndOpenHome();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mTitleLinearLayout.setVisibility(View.GONE);
                    firebaseEvent("video_call_rejected");

                    try {
                        finishAndOpenHome();
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    } catch (Exception e) {
                    }
                } catch (Exception ignored) {
                }
            }
        });

        btnMuteVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firebaseEvent("video_camera_turned_off");
                    mPublisher.setPublishVideo(!mPublisher.getPublishVideo());
                    if (mPublisher.getPublishVideo()) {
                        btnMuteVideo.getDrawable().setAlpha(255);
                    } else {
                        btnMuteVideo.getDrawable().setAlpha(30);
                    }
                } catch (Exception e) {
                }
            }
        });

        if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)) {
            String str = getIntent().getStringExtra(Constants.KEY_DATA);
            incomingCallObject = GsonUtils.getGson().fromJson(str, JsonObject.class);

            if (incomingCallObject != null) {
                String docName = "Dr. " + incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString() +
                        " " + incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString();

                mDoctorNameTextView.setText(docName);
                Glide.with(this)
                        .load(incomingCallObject.get("caller_info").getAsJsonObject().get("photo").getAsString())
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .apply(RequestOptions.circleCropTransform())
                        .into(ivProfileImage);
            }

            try {
                AnalyticsUtils.appointmentVideoConsultScreen(VideoConsultationActivityOld.this, "incoming");
            }
            catch(Exception e){ e.printStackTrace(); }
        }
        else {
            Glide.with(this)
                    .load(userData.getPhoto())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfileImage);

            fabAnswerCall.setVisibility(View.GONE);
            spaceBwAcceptDecline.setVisibility(View.GONE);
            AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit("start_call", getOutgoingCallObject(consultation));

            tokBoxTokenAPI();

            try {
                AnalyticsUtils.appointmentVideoConsultScreen(VideoConsultationActivityOld.this, "outgoing");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        fabEndCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRingTone();
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }

                try {
                    NotificationHelper.dismissNotification(getApplicationContext(), NOTIFICATION_OPEN_VIDEO_CONSULTATION);

                    if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)) {
                        AnalyticsUtils.appointmentVideoConsultDrop(VideoConsultationActivityOld.this, "incoming");
                    } else {
                        AnalyticsUtils.appointmentVideoConsultDrop(VideoConsultationActivityOld.this, "outgoing");
                    }
                } catch (Exception e) {
                }

                answerCallObject = new JSONObject();

                try {
                    if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)) {
                        if (isCallAccepted) {
                            answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                            answerCallObject.put("type", "reset");
                            AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                            disconnectCall();
                            finishAndOpenHome();
                        } else {
                            answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                            answerCallObject.put("response", "rejected");
                            AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                            disconnectCall();
                            finishAndOpenHome();
                        }
                    } else {
                        if (isCallAccepted) {
                            answerCallObject.put("key", consultation.getChannelKey());
                            answerCallObject.put("type", "reset");
                            AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit("remote_end_call_event_emit_from_chat", answerCallObject);
                            disconnectCall();
                            finishAndOpenHome();
                        } else {
                            answerCallObject.put("key", consultation.getChannelKey());
                            answerCallObject.put("response", "rejected");
                            AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                            disconnectCall();
                            finishAndOpenHome();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                firebaseEvent("video_call_rejected");

                try {
                    navController.navigate(R.id.dashboardFragment);

                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                } catch (Exception e) {
                }
            }
        });

        fabAnswerCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRingTone();
                mPublisherViewContainer.setVisibility(View.VISIBLE);
                mSubscriberViewContainer.setVisibility(View.VISIBLE);
                fabEndCall.setVisibility(View.GONE);
                setControlsVisibility(false);
                isCallAccepted = true;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }

                JSONObject answerCallObject = new JSONObject();
                try {
                    answerCallObject.put("key", incomingCallObject.get("key").getAsString());
                    answerCallObject.put("response", "accepted");
                    GenApiLogger.fireIncomingVideoCall();


                    lableincomingcall.setText("Connecting...");
                    btnCancelVideoCall.setVisibility(View.VISIBLE);
                    lytMuteButtons.setVisibility(View.VISIBLE);
                    mDoctorNameTextView.setText(MessageFormat.format("Dr. {0} {1}", incomingCallObject.get("caller_info").getAsJsonObject().get("first_name").getAsString(), incomingCallObject.get("caller_info").getAsJsonObject().get("last_name").getAsString()));
                    Log.d(LOG_TAG, LOG_TAG + "  isConnected=" + AppSocket.getInstance(getApplicationContext()).isConnected());
                    AppSocket.getInstance(VideoConsultationActivityOld.this).getSocket().emit(AppSocket.EVENT_SEND_CALL_RESPONSE, answerCallObject);
                    mPublisherViewContainer.setVisibility(View.VISIBLE);

                    tokBoxTokenAPI();

                    {
                        progressContent.setVisibility(View.VISIBLE);
                        fabAnswerCall.setEnabled(false);
                        isToStartCall = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                firebaseEvent("video_call_accept");
            }
        });
    }

    private void tokBoxTokenAPI() {
        getDisposer().add(
                RXAPI.getTokBoxVideoSession(
                        new TokBoxSessionRequest()
                                .withDoctorRoleId(incomingCallObject.get("doctor_role_id").getAsLong())
                                .withPatientRoleId(incomingCallObject.get("patient_role_id").getAsLong())
                                .withSlotId(incomingCallObject.get("slot_id").getAsInt())
                                .withUid(userData.getUid())
                                .withCallInfo(userData)
                ).subscribe(tokBoxObj -> {
                    tokBoxObject = tokBoxObj;

                    if (isToStartCall) {
                        mPublisherViewContainer.setVisibility(View.VISIBLE);
                        progressContent.setVisibility(View.GONE);
                        initializeTokBoxCall();
                    }
                }, e -> {
                    LocalUtils.processAPIError(e);
                    finishAndOpenHome();
                })
        );
    }


    private JSONObject getOutgoingCallObject(ConsultationDetails consultationDetail) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("event_type", "accept_call");
            jsonObject.put("uid", userData.getEmail());
            jsonObject.put("slot_id", consultationDetail.getSlot().getId());
            jsonObject.put("doctor_role_id", consultationDetail.getUserRoleId());
            jsonObject.put("patient_role_id", MyApp.get().getRole().getId());
            jsonObject.put("key", consultationDetail.getChannelKey());
            jsonObject.put("caller_info", new JSONObject(PrefsHelper.get(this).getString(Constants.KEY_USER_DATA, "")));

        } catch (Exception e) {

        }

        GenApiLogger.fireIncomingVideoCall();

        return jsonObject;
    }

    private void setControlsVisibility(boolean visibility) {
        if (!visibility) {
            lytControls.setBackgroundResource(android.R.color.transparent);
            txtName.setVisibility(View.INVISIBLE);
            fabAnswerCall.setVisibility(View.GONE);
            spaceBwAcceptDecline.setVisibility(View.GONE);
        } else {
            lytControls.setBackgroundResource(R.color.black_overlay);
            lytPicContainer.setVisibility(View.VISIBLE);
            txtName.setVisibility(View.VISIBLE);
            lableincomingcall.setVisibility(View.VISIBLE);
            fabAnswerCall.setVisibility(View.VISIBLE);
            spaceBwAcceptDecline.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "onPause");
        super.onPause();
        isPlayedTune = false;

        if (mSession != null) {
            mSession.onPause();
        }
        stopRingTone();

        try {
            LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).unregisterReceiver(mConnectionListener);
            LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).unregisterReceiver(mCallResponseReceiver);
            LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).unregisterReceiver(mCallEndReceiver);
        } catch (Exception e) {
        }

        if (isFinishing()) {
            disconnectCall();
        }

        isAlive = false;
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "onResume isPlayedTune=" + isPlayedTune + "  mMediaPlayer=" + (mMediaPlayer == null));
        if (!isPlayedTune && getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING)
                && (mMediaPlayer != null && !mMediaPlayer.isPlaying()) || mMediaPlayer == null) {
            ringTone();
            isPlayedTune = true;
        }

        super.onResume();

        if (mSession != null) {
            mSession.onResume();
        }

        isAlive = true;
        mConnectionListener = new ConnectionChangeListener();
        mCallResponseReceiver = new CallResponseReceiver();
        mCallEndReceiver = new CallEndReceiver();
        IntentFilter sockConnectivityFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CONNECTION_CHANGED);
        LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).registerReceiver(mConnectionListener, sockConnectivityFilter);
        IntentFilter socketCallresposnFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_RESPONSE);
        LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).registerReceiver(mCallResponseReceiver, socketCallresposnFilter);
        IntentFilter callEndIntent = new IntentFilter(getPackageName() + AppSocket.SOCKET_CALL_END);
        LocalBroadcastManager.getInstance(VideoConsultationActivityOld.this).registerReceiver(mCallEndReceiver, callEndIntent);
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
                JSONObject jsonObject = new JSONObject(intent.getStringExtra(Constants.KEY_DATA));
                String response = jsonObject.getString("response");
                Log.d("VideoScreen", "VideoScreen " + jsonObject.toString());

                if (response != null && response.equals("rejected")) {
                    String userType = "Doctor";

                    if (getPackageName().contains("patient"))
                        userType = "Doctor";
                    else
                        userType = "Patient";

                    Toasty.error(VideoConsultationActivityOld.this,
                            String.format(getString(R.string.respondent_rejected), userType),
                            Toast.LENGTH_LONG, false).show();
                    disconnectCall();
                    finishAndOpenHome();
                }

                if (response != null && response.equals("accepted")) {
                    initializeTokBoxCall();
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
                JSONObject jsonObject = new JSONObject(intent.getStringExtra(Constants.KEY_DATA));
                if (jsonObject.has("reason")) {
                    if (jsonObject.getString("reason").equals("reset")) {
                        Toasty.error(VideoConsultationActivityOld.this, getString(R.string.caller_dropped_call), Toast.LENGTH_LONG, false).show();
                        disconnectCall();
                        finishAndOpenHome();
                    } else {
                        Toasty.error(VideoConsultationActivityOld.this, getString(R.string.caller_dropped_call), Toast.LENGTH_LONG, false).show();
                        disconnectCall();
                        finishAndOpenHome();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void disconnectCall() {
        try {
            mSession.disconnect();
        } catch (Exception e) {
        }
    }

    private void initializeTokBoxCall() {
        PermissionUtils.permission(PermissionConstants.MICROPHONE,PermissionConstants.CAMERA)
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {
                        initializeSession(tokBoxObject.api, tokBoxObject.session_id, tokBoxObject.token);
                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                        if(permissionsDeniedForever.size() > 0 || permissionsDenied.size() > 0){
                            new AppSettingsDialog.Builder(VideoConsultationActivityOld.this)
                                    .setTitle(getString(R.string.title_settings_dialog))
                                    .setRationale(getString(R.string.rationale_ask_again))
                                    .setPositiveButton("OK")
                                    .setNegativeButton("CANCEL")
                                    .setRequestCode(RC_SETTINGS_SCREEN_PERM)
                                    .build()
                                    .show();
                        }
                    }
                }).request();

    }

    private void initializeSession(String apiKey, String sessionId, String token) {

        mSession = new Session.Builder(VideoConsultationActivityOld.this, apiKey, sessionId).build();
        mSession.setSessionListener(this);
        mSession.connect(token);
    }
    /* Session Listener methods */

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onConnected(Session session) {
        setControlsVisibility(false);
        fabEndCall.setEnabled(true);
        fabEndCall.setVisibility(View.GONE);
        btnCancelVideoCall.setVisibility(View.VISIBLE);
        lytMuteButtons.setVisibility(View.VISIBLE);
        mTitleLinearLayout.setVisibility(View.VISIBLE);
        mPublisher = new Publisher.Builder(VideoConsultationActivityOld.this).build();
        mPublisher.getRenderer().setStyle(BaseVideoRenderer.STYLE_VIDEO_SCALE, BaseVideoRenderer.STYLE_VIDEO_FILL);
        mPublisher.setPublisherListener(this);
        mPublisherViewContainer.addView(mPublisher.getView());
        mSession.publish(mPublisher);

        if (mPublisher.getView() instanceof GLSurfaceView) {
            ((GLSurfaceView) mPublisher.getView()).setZOrderOnTop(true);
        }

        lytControls.setBackgroundResource(android.R.color.transparent);
    }

    @Override
    public void onDisconnected(Session session) {
        lytMuteButtons.setVisibility(View.GONE);
        mSession = null;
    }

    @Override
    public void onStreamReceived(Session session, Stream stream) {
        if (mSubscriber == null) {
            mSubscriber = new Subscriber.Builder(VideoConsultationActivityOld.this, stream).build();
            mSubscriber.getRenderer().setStyle(BaseVideoRenderer.STYLE_VIDEO_SCALE, BaseVideoRenderer.STYLE_VIDEO_FILL);
            mSession.subscribe(mSubscriber);
            mSubscriberViewContainer.addView(mSubscriber.getView());
        }

        mTitleLinearLayout.setVisibility(View.VISIBLE);
        btnSwitchCamera.setVisibility(View.VISIBLE);
        btnSwitchCamera.bringToFront();

        lableincomingcall.setVisibility(View.GONE);
        lytPicContainer.setVisibility(View.GONE);
        mConnectingTextView.setVisibility(View.GONE);
        fabEndCall.setEnabled(true);
        stopRingTone();
    }

    @Override
    public void onStreamDropped(Session session, Stream stream) {
        if (mSubscriber != null) {
            mSubscriber = null;
            mSubscriberViewContainer.removeAllViews();
        }
    }

    @Override
    public void onError(Session session, OpentokError opentokError) {
        showOpenTokError(opentokError);
    }

    /* Publisher Listener methods */

    @Override
    public void onStreamCreated(PublisherKit publisherKit, Stream stream) {
        Log.d(LOG_TAG, "onStreamCreated: Publisher Stream Created. Own stream " + stream.getStreamId());

    }

    @Override
    public void onStreamDestroyed(PublisherKit publisherKit, Stream stream) {
        Log.d(LOG_TAG, "onStreamDestroyed: Publisher Stream Destroyed. Own stream " + stream.getStreamId());
    }

    @Override
    public void onError(PublisherKit publisherKit, OpentokError opentokError) {
        Log.e(LOG_TAG, "onError Publisher: " + opentokError.getErrorDomain() + " : " +
                opentokError.getErrorCode() + " - " + opentokError.getMessage());
        showOpenTokError(opentokError);
    }

    private void ringTone() {
        try {
            Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(this, alert);
            final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            if (audioManager.getStreamVolume(AudioManager.STREAM_RING) != 0) {
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
                mMediaPlayer.setLooping(true);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            }
        } catch (Exception e) {
        }
    }

    private void stopRingTone() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onConnected(SubscriberKit subscriberKit) {
        Log.d(LOG_TAG, "onConnected: Subscriber connected. Stream: " + subscriberKit.getStream().getStreamId());
        progressContent.setVisibility(View.GONE);
    }

    @Override
    public void onDisconnected(SubscriberKit subscriberKit) {
        Log.d(LOG_TAG, "onDisconnected: Subscriber disconnected. Stream: " + subscriberKit.getStream().getStreamId());
        progressContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError(SubscriberKit subscriberKit, OpentokError opentokError) {
        Log.e(LOG_TAG, "onError Session: " + opentokError.getErrorDomain() + " : " + opentokError.getErrorCode() + " - " + opentokError.getMessage());
        showOpenTokError(opentokError);
    }

    private void showOpenTokError(OpentokError opentokError) {
        mSession.connect(tokBoxObject.token);
        progressContent.setVisibility(View.VISIBLE);
    }

//    @Override
//    public void onWebResponseListner(int tag, int statusCode, JsonObject response) {
//        if (statusCode == HttpURLConnection.HTTP_OK) {
//            if (tag == VolleyAPI.TYPE_UPDATE_CONSULTATION_STATUS) {
//                initializeTokBoxCall();
//                try {
//                    if (getIntent().getStringExtra(Constants.KEY_TYPE).equals(Constants.KEY_TYPE_INCOMING))
//                        AnalyticsUtils.appointmentVideoConsultStart(this, "incoming");
//                    else
//                        AnalyticsUtils.appointmentVideoConsultStart(this, "outgoing");
//                } catch (Exception e) {
//                }
//
//                fabAnswerCall.setVisibility(View.GONE);
//            }
//
//        }
//    }


    @Override
    protected void onStop() {
        try {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } catch (Exception e) {
        }

        super.onStop();
    }

//    @Override
//    public void finish() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            super.finishAndRemoveTask();
//        } else {
//            super.finish();
//        }
//    }

    private void finishAndOpenHome() {
        ActivityUtils.startActivity(HomeScreenActivity.class);
    }

    private void firebaseEvent(String type) {
        GenApiLogger.fireGenericVideoCallEvent(type,userData);

    }
}