package com.augmentcare.patient.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.activities.ChatActivity;
import com.augmentcare.patient.activities.VideoConsultationActivity;
import com.augmentcare.patient.notifications.NotificationHelper;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.PrefsHelper;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class AppSocket {
    private static final String EVENT_KEY = "key";
    private static final String EVENT_UPDATE_STATE = "update_state";
    private static final String EVENT_GET_MESSAGE = "get_message";

    private static final String EVENT_UPDATE_NOTIFS = "update_notificaions";
    private static final String EVENT_PING = "ping";
    private static final String EVENT_PRESCRIPTION = "prescription_data";
    private static final String EVENT_CONNECT = "connect";
    private static final String EVENT_UPDATE_ONILNE_USERS = "update_online_users";
    private static final String EVENT_RECEIVE_CALL_RESPONSE = "recieve_call_response";
    public static final String EVENT_SEND_CALL_RESPONSE = "send_call_response";
    private static final String EVENT_REMOTE_CALL_END = "remote_end_call_event_from_node";
    private static final String EVENT_ACCEPT_CALL = "accept_call";
    private static final String EVENT_START_CALL = "start_call";
    private static final String EVENT_APPOINTMENT = "appointment";
    public static final String EVENT_EMIT_EVENT = "emit_event";
    private static final String EVENT_SYNC_CONSULTATION = "sync_consultations_data";
    public static final String EVENT_RECEIVE_PRESCRIPTION = "recieve_prescription";

    public static final String SOCKET_CONNECTION_CHANGED = ".SocketConnetionChange";
    public static final String SOCKET_STATUS = "Status";
    public static final String SOCKET_STATUS_CONNECTED = "StatusConnected";
    public static final String SOCKET_STATUS_DISCONNECTED = "StatusDisconnected";
    public static final String SOCKET_CALL_RESPONSE = ".SocketCallResponse";
    public static final String SOCKET_CALL_END = ".SocketCallEnd";
    public static final String SOCKET_PRESCRIPTION = ".SocketPresccription";
    public static final String SOCKET_APPOINTMENT_APPROVED = ".APPOINTMEN_APPROVED";

    public static final String TAG = "AppSocket";
    private static AppSocket ourInstance = new AppSocket();
    private Context context;
    private boolean isConnected;

    public static synchronized AppSocket getInstance(Context context) {
        if (ourInstance != null) {
            ourInstance.context = context;
            return ourInstance;
        } else {
            ourInstance = new AppSocket();
            ourInstance.context = context;
            return ourInstance;
        }
    }

    private AppSocket() {
    }

    private com.github.nkzawa.socketio.client.Socket mSocket = null;

    public com.github.nkzawa.socketio.client.Socket getSocket() {
        if (mSocket == null) {
            try {
                IO.Options opts = new IO.Options();
                opts.forceNew = true;
                opts.timeout = 20000;

                mSocket = IO.socket(BuildConfig.SOCKET_URL, opts);
            } catch (URISyntaxException ignored) {
            }

            mSocket.on(EVENT_KEY, onKey);
            mSocket.on(EVENT_GET_MESSAGE, onNewMessage);
            mSocket.on(EVENT_UPDATE_ONILNE_USERS, onUpdateOnlineUsers);
            mSocket.on(EVENT_RECEIVE_CALL_RESPONSE, onReceiveCall);
            mSocket.on(EVENT_ACCEPT_CALL, onAcceptCall);
            mSocket.on(com.github.nkzawa.socketio.client.Socket.EVENT_CONNECT, onConnected);
            mSocket.on(com.github.nkzawa.socketio.client.Socket.EVENT_DISCONNECT, onDisconnected);
            mSocket.on(EVENT_START_CALL, onStartCall);
            mSocket.on(EVENT_REMOTE_CALL_END, onCallEndedFromOther);
            mSocket.on(EVENT_PRESCRIPTION, onPrescriptionChanged);
            mSocket.on(EVENT_SYNC_CONSULTATION, onSyncConsultation);
            mSocket.on(EVENT_UPDATE_NOTIFS, onUpdateNotifications);
            mSocket.on(EVENT_EMIT_EVENT, onEmitEvent);
            mSocket.on(EVENT_UPDATE_NOTIFS, getOnUpdateNotifications);
        }
        return mSocket;
    }

    public void onPause() {

    }

    public void onStop() {
        if (mSocket != null) {
            mSocket.off(com.github.nkzawa.socketio.client.Socket.EVENT_CONNECT, onConnected);
            mSocket.off(com.github.nkzawa.socketio.client.Socket.EVENT_DISCONNECT, onDisconnected);
            mSocket.off(EVENT_KEY, onKey);
            mSocket.off(EVENT_GET_MESSAGE, onNewMessage);
            mSocket.off(EVENT_UPDATE_ONILNE_USERS, onUpdateOnlineUsers);
            mSocket.off(EVENT_RECEIVE_CALL_RESPONSE, onReceiveCall);
            mSocket.off(EVENT_ACCEPT_CALL, onAcceptCall);
            mSocket.off(EVENT_START_CALL, onStartCall);
            mSocket.off(EVENT_REMOTE_CALL_END, onCallEndedFromOther);
            mSocket.off(EVENT_PRESCRIPTION, onPrescriptionChanged);
            mSocket.off(EVENT_SYNC_CONSULTATION, onSyncConsultation);
            mSocket.off(EVENT_UPDATE_NOTIFS, onUpdateNotifications);
            mSocket.on(EVENT_EMIT_EVENT, onEmitEvent);
            mSocket.off(EVENT_UPDATE_NOTIFS, getOnUpdateNotifications);
            mSocket.disconnect();
            mSocket = null;
        }
    }

    public void onResume() {
        if (mSocket != null) {
            mSocket.connect();
        } else {
            getSocket().connect();
        }
    }

    private Emitter.Listener getOnUpdateNotifications = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            try {
                JsonObject object = (JsonObject) args[0];
                if (object.has("notify_type")) {
                    if (object.get("notify_type").equals("slot_request")) {
                        Intent intent = new Intent(context.getPackageName() + EVENT_UPDATE_NOTIFS);
                        intent.putExtra(Constants.KEY_TYPE, "emit_event");
                        intent.putExtra(Constants.KEY_DATA, object.toString());
                        LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
                        Log.wtf("UpdateSocketEvent", "" + object);
                    }
                }
            } catch (Exception ignored) {
            }

            Log.d("onEmitEvent", "onEmitEvent" + args.toString());
        }
    };

    private Emitter.Listener onEmitEvent = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            try {
                JsonObject object = (JsonObject) args[0];
                if (object.has("notify_type")) {
                    if (object.get("notify_type").equals("slot_request")) {
                        Intent intent = new Intent(context.getPackageName() + EVENT_UPDATE_NOTIFS);
                        intent.putExtra(Constants.KEY_DATA, object.toString());
                        LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
                        Log.wtf("UpdateSocketEvent", "" + object);
                    }
                }
            } catch (Exception ignored) {
            }

            Log.d("onEmitEvent", "onEmitEvent" + args.toString());
        }
    };

    private Emitter.Listener onPrescriptionChanged = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            //JsonObject object = (JsonObject) args[0];
            Log.d("onPrescriptionChanged", "onPrescriptionChanged" + args.toString());
        }
    };

    private Emitter.Listener onUpdateNotifications = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            try {
                JSONObject object = (JSONObject) args[0];
                Log.wtf("UpdateSocketEvent", "" + object);

                if (object.has("notify_type")) {
                    if (object.getString("notify_type").equalsIgnoreCase("prescription_data")) {
                        Intent intent = new Intent(context.getPackageName() + SOCKET_PRESCRIPTION);
                        intent.putExtra(Constants.KEY_DATA, object.toString());
                        LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
                    } else if (object.getString("notify_type").equalsIgnoreCase("slot_request")) {
                        Intent intent = new Intent(context.getPackageName() + EVENT_UPDATE_NOTIFS);
                        intent.putExtra(Constants.KEY_DATA, object.toString());
                        LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Log.d("onReceivePrescription", "onReceivePrescription" + Arrays.toString(args));
        }
    };

    private Emitter.Listener onSyncConsultation = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            try {
                JsonObject object = (JsonObject) args[0];
                Log.d("onSyncConsultation", "onSyncConsultation" + args.toString());
                Intent intent = new Intent(context.getPackageName() + SOCKET_PRESCRIPTION);
                intent.putExtra(Constants.KEY_DATA, object.toString());
                LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private Emitter.Listener onStartCall = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            //JsonObject object = (JsonObject) args[0];
            Log.d("onStartCall", "onStartCall" + args.toString());
        }
    };

    private Emitter.Listener onCallEndedFromOther = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            JSONObject object = (JSONObject) args[0];
            Intent intent = new Intent(context.getPackageName() + SOCKET_CALL_END);
            intent.putExtra(Constants.KEY_DATA, object.toString());
            LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);

        }
    };

    private Emitter.Listener onConnected = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            setConnected(true);
            if (context != null) {
                Intent intent = new Intent(context.getPackageName() + SOCKET_CONNECTION_CHANGED);
                intent.putExtra(SOCKET_STATUS, SOCKET_STATUS_CONNECTED);
                LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
            }
        }
    };

    private Emitter.Listener onDisconnected = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            setConnected(false);
            updateStateCount = 0;
            try {
                if (mSocket != null) {
                    mSocket.connect();
                }
            } catch (Exception ignored) {
            }

            Intent intent = new Intent(context.getPackageName() + SOCKET_CONNECTION_CHANGED);
            intent.putExtra(SOCKET_STATUS, SOCKET_STATUS_DISCONNECTED);
            LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
        }
    };

    private Emitter.Listener onUpdateOnlineUsers = new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            JSONObject object = (JSONObject) args[0];
            if (object.has("keys")) {
                try {
                    HashMap<String, String> map = new HashMap<>();
                    JSONArray keys = object.getJSONArray("keys");

                    for (int i = 0; i < keys.length(); i++) {
                        if (keys.getJSONObject(i).has("key")) {
                            map.put(keys.getJSONObject(i).getString("key"), keys.getJSONObject(i).getString("user_type"));
                        }
                    }
                    MyApp.get().setOnlineUsers(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Log.d("AppSocket", "AppSocket onUpdateOnlineUsers");
        }
    };

    private int updateStateCount = 0;
    private Emitter.Listener onKey = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d(TAG, TAG + "  onKey");
            if (PrefsHelper.get(context).contains(Constants.KEY_CHANNEL)) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    JSONObject objectStatus = new JSONObject();
                    try {
                        jsonObject.put("key", PrefsHelper.get(context).getString(Constants.KEY_CHANNEL, ""));
                        jsonObject.put("update_type", "update_user_type");
                        jsonObject.put("user_type", "patient");
                        objectStatus.put("key", PrefsHelper.get(context).getString(Constants.KEY_CHANNEL, ""));
                        objectStatus.put("update_type", "key");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    mSocket.emit("update_state", objectStatus);
                    mSocket.emit("update_state", jsonObject);
                    updateStateCount++;
                } catch (Exception ignored) {
                }
            }

        }
    };

    private Emitter.Listener onAcceptCall = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            if (PrefsHelper.getLoggedInUser() != null && !VideoConsultationActivity.isAlive) {
                JSONObject obj = (JSONObject) args[0];
                Intent intent = new Intent(context, VideoConsultationActivity.class);
                intent.putExtra(Constants.KEY_TYPE, Constants.KEY_TYPE_INCOMING);
                intent.putExtra(Constants.KEY_DATA, obj.toString());
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);

                try {
                    String contentMsg = "Dr. " + obj.getJSONObject("caller_info").getString("first_name") + " " +
                            obj.getJSONObject("caller_info").getString("last_name") + " calling for consultation";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private Emitter.Listener onReceiveCall = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Object obj = args[0];
            Intent intent = new Intent(context.getPackageName() + SOCKET_CALL_RESPONSE);
            intent.putExtra(Constants.KEY_DATA, obj.toString());
            LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
        }
    };

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            JSONObject obj = (JSONObject) args[0];
            try {
                if (obj.has("event_type") && obj.getString("event_type").equals("get_message")) {
                    if (ChatActivity.gloabalchatID != null && ChatActivity.gloabalchatID.equals(obj.getJSONObject("notification_object")
                            .getString("chat_id"))) {
                        Intent intent = new Intent(context.getPackageName() + Constants.INTENT_MESSAGE);
                        intent.putExtra(Constants.KEY_DATA, obj.toString());
                        LocalBroadcastManager.getInstance(MyApp.get()).sendBroadcast(intent);
                    } else {
                        JSONObject notifationObject = obj.getJSONObject("notification_object");
                        NotificationHelper.sendNotification(context, "New Message", notifationObject.getString("first_name") +
                                " " + notifationObject.getString("last_name") + " sent you a private message", obj.toString(), 1);
                    }
                }
            } catch (Exception ignored) {
            }
        }
    };

    private Emitter.Listener onEndCall = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Object obj = args[0];
        }
    };

    private Emitter.Listener onSendCallResponse = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Object obj = args[0];
        }
    };

    public boolean isConnected() {
        return isConnected;
    }

    private void setConnected(boolean connected) {
        isConnected = connected;
    }
}
