package com.augmentcare.patient.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.adapters.ChatRecyclerListAdapter;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.AChat;
import com.augmentcare.patient.model.ChatLine;
import com.augmentcare.patient.model.Doctor;
import com.augmentcare.patient.model.Patient;
import com.augmentcare.patient.network.AppSocket;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.intercom.android.sdk.Intercom;

import static com.augmentcare.patient.notifications.Constants.EXTRA_IS_FROM_NOTIFICATIONS;


public class ChatActivity extends BaseActivity implements VolleyAPI.WebResponseListner, VolleyAPI.FragmentInteractionListener, View.OnClickListener, OnRecyclerItemClickListener<ChatLine> {
    public static final String TAG = "ChatActivity";

    private String chatId;
    private String chat_Id;
    @BindView(R.id.recylerViewChat)
    RecyclerView recylerViewChat;
    @BindView(R.id.btnSend)
    View btnSend;
    @BindView(R.id.btnAttachment)
    View btnAttachment;
    @BindView(R.id.etxtMessage)
    AppCompatEditText etxtMessage;
    @BindView(R.id.progressContent)
    ProgressBar progressContent;
    @BindView(R.id.txtCurrentMessage)
    TextView txtCurrentMessage;
    @BindView(R.id.linearLayout)
    View controlsContainer;
    ArrayList<ChatLine> chatMessages;
    ChatRecyclerListAdapter mAdapter;
    private Doctor gotDoctor;
    private Patient gotPatient;
    MessageReceiver mMessageReceiver;
    ConnectionReceiver mConnectionReceiver;
    private String otherUserChannelKey;
    private String doctorRoleId;
    private String patientRoleId;
    private String doctorId;
    private String patientId;
    public static String gloabalchatID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        VOLLEYAPI.withListner(this);

        if (getIntent().hasExtra(Constants.KEY_DOCTOR))
            gotDoctor = getIntent().getParcelableExtra(Constants.KEY_DOCTOR);
        if (getIntent().hasExtra(Constants.KEY_PATIENT))
            gotPatient = getIntent().getParcelableExtra(Constants.KEY_PATIENT);
        recylerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recylerViewChat.setHasFixedSize(false);
        mMessageReceiver = new MessageReceiver();
        mConnectionReceiver = new ConnectionReceiver();
        chatMessages = new ArrayList<>();
        mAdapter = new ChatRecyclerListAdapter(chatMessages, userData.getFirstName(), "Other", this);
        recylerViewChat.setAdapter(mAdapter);
        progressContent.setVisibility(View.VISIBLE);

        if (!getIntent().hasExtra(EXTRA_IS_FROM_NOTIFICATIONS))
        {
            JsonObject jsonObject = new JsonObject();
            if (getPackageName().contains("patient"))
            {
                jsonObject.addProperty("doctor_role_id", gotDoctor.getDocterInfo().getUserRoleId());
                jsonObject.addProperty("patient_role_id", MyApp.get().getRole().getId());
                doctorId = gotDoctor.getUserInfo().getUserId() + "";
                otherUserChannelKey = gotDoctor.getUserChannel();
                doctorRoleId = gotDoctor.getDocterInfo().getUserRoleId() + "";
                VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_ID, jsonObject, this);
                if(getSupportActionBar()!=null) {
                    getSupportActionBar().setTitle(gotDoctor.getUserInfo().getFirstName() + " " + gotDoctor.getUserInfo().getLastName());
                }
                mAdapter.setOtherName(gotDoctor.getUserInfo().getFirstName() + " " + gotDoctor.getUserInfo().getLastName());
                try {
                    AnalyticsUtils.chatScreen(this, "" + gotDoctor.getUserInfo().getUserId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //jsonObject.addProperty( "patient_role_id", gotPatient.getUser_info().getUserId());
                //jsonObject.addProperty("doctor_role_id", MyApp.get().getRole().getId());
                jsonObject.addProperty("role_id", "3");
                jsonObject.addProperty("user_id", gotPatient.getUser_info().getUserId());
                doctorId = userData.getUserId() + "";
                otherUserChannelKey = gotPatient.getUserChannel();

                doctorRoleId = MyApp.get().getRole().getRoleId();
                VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_ROLE_ID, jsonObject, this);
                if(getSupportActionBar()!=null) {
                    getSupportActionBar().setTitle(gotPatient.getUser_info().getFirst_name() + " " + gotPatient.getUser_info().getLast_name());
                }
                mAdapter.setOtherName(gotPatient.getUser_info().getFirst_name() + " " + gotPatient.getUser_info().getLast_name());
            }


        } else if (getIntent().hasExtra(EXTRA_IS_FROM_NOTIFICATIONS)) {


            if (getPackageName().contains("patient")) {
                //JsonObject object = GsonUtils.getGson().fromJson(getIntent().getStringExtra(Constants.KEY_DATA),JsonObject.class);
                JsonObject notification = GsonUtils.getGson().fromJson(getIntent().getStringExtra(Constants.KEY_DATA), JsonObject.class);
                JsonObject notificationObject = notification.getAsJsonObject("notification_object");
                chat_Id = notificationObject.get("chat_id").getAsString();
                if(getSupportActionBar()!=null) {
                    getSupportActionBar().setTitle(notificationObject.get("first_name").getAsString() + " " + notificationObject.get("last_name").getAsString());
                }
                mAdapter.setOtherName(notificationObject.get("first_name").getAsString() + " " + notificationObject.get("last_name").getAsString());

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("chat_id", notificationObject.get("chat_id").getAsString());
                gloabalchatID = notificationObject.get("chat_id").getAsString();
                VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_DATA, jsonObject, this);
            } else {
                JsonObject notification = GsonUtils.getGson().fromJson(getIntent().getStringExtra(Constants.KEY_DATA), JsonObject.class);
                JsonObject notificationObject = notification.getAsJsonObject("notification_object");
                chat_Id = notificationObject.get("chat_id").getAsString();
                getSupportActionBar().setTitle(notificationObject.get("first_name").getAsString() + " " + notificationObject.get("last_name").getAsString());
                mAdapter.setOtherName(notificationObject.get("first_name").getAsString() + " " + notificationObject.get("last_name").getAsString());

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("chat_id", notificationObject.get("chat_id").getAsString());
                gloabalchatID = notificationObject.get("chat_id").getAsString();
                VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_DATA, jsonObject, this);
            }

        }

        btnSend.setOnClickListener(this);


     if(getSupportActionBar()!=null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }

        if (!AppSocket.getInstance(MyApp.get()).isConnected()) {
            controlsContainer.setBackgroundResource(R.color.colorYellow);
        } else {
            controlsContainer.setBackground(null);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.action_help) {
            Intercom.client().displayConversationsList();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (chat_Id != null) {
            gloabalchatID = chat_Id;
        }
        IntentFilter filter = new IntentFilter(getPackageName() + Constants.INTENT_MESSAGE);
        LocalBroadcastManager.getInstance(MyApp.get()).registerReceiver(mMessageReceiver, filter);
        IntentFilter sockConnectivityFilter = new IntentFilter(getPackageName() + AppSocket.SOCKET_CONNECTION_CHANGED);
        LocalBroadcastManager.getInstance(MyApp.get()).registerReceiver(mConnectionReceiver, sockConnectivityFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onWebResponseListner(int tag, int statusCode, JsonObject response) {
        if (statusCode == HttpURLConnection.HTTP_OK) {
            if (tag == VolleyAPI.TYPE_GET_CHAT_ID) {
                if (response.has("chat_object")) {
                    chatId = response.getAsJsonObject("chat_object").get("id").getAsString();
                    chat_Id = response.getAsJsonObject("chat_object").get("chat_id").getAsString();
                    gloabalchatID = chat_Id;
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("chat_id", chatId);
                    VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_LINES, jsonObject, this);
                }
            }
            if (tag == VolleyAPI.TYPE_GET_ROLE_ID) {
                if (response.has("user_role_id")) {
                    JsonArray arr = response.get("user_role_id").getAsJsonArray();
                    if (arr.size() > 0) {
                        String user_role_id = arr.get(0).getAsJsonObject().get("id").getAsString();
                        patientRoleId = user_role_id;
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("patient_role_id", user_role_id);
                        jsonObject.addProperty("doctor_role_id", MyApp.get().getRole().getId());
                        VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_ID, jsonObject, this);
                    }
                }
            }
            if (tag == VolleyAPI.TYPE_GET_CHAT_LINES) {
                if (response.has(Constants.KEY_SUCCESS) && response.get(Constants.KEY_SUCCESS).getAsBoolean()) {
                    progressContent.setVisibility(View.GONE);
                    ArrayList<ChatLine> gotChatLines;
                    Type listType = new TypeToken<ArrayList<ChatLine>>() {
                    }.getType();
                    gotChatLines = GsonUtils.getGson().fromJson(response.getAsJsonArray("chat_lines"), listType);
                    chatMessages.addAll(gotChatLines);
                    if (gotChatLines.size() == 0) {
                        Toasty.info(this, getString(R.string.no_chat_messages), Toast.LENGTH_LONG, false).show();
                        MyApp.isReloadConsultations = true;
                    }

                    mAdapter.notifyDataSetChanged();
                    scrollToEnd();
                } else {
                    Toasty.error(this, R.string.error_no_data, Toast.LENGTH_LONG, false).show();
                }
            }
            if (tag == VolleyAPI.TYPE_ADD_CHAT_LINE) {
                if (response.has(Constants.KEY_SUCCESS) && response.get(Constants.KEY_SUCCESS).getAsBoolean()) {
                    AnalyticsUtils.sendMessageSuccess(this, "");
                } else {
                    AnalyticsUtils.sendMessageFial(this, "");
                }
            }
            if (tag == VolleyAPI.TYPE_GET_CHAT_DATA) {
                if (getPackageName().contains("patient")) {
                    otherUserChannelKey = response.get("doctor_channel_key").getAsString();
                } else {
                    otherUserChannelKey = response.get("patient_channel_key").getAsString();
                }

                chatId = response.getAsJsonObject("chat_object").get("id").getAsString();
                doctorRoleId = response.getAsJsonObject("chat_object").get("doctor_role_id").getAsString();
                patientRoleId = response.getAsJsonObject("chat_object").get("patient_role_id").getAsString();
                patientId = response.getAsJsonObject("patient_info").get("user_id").getAsString();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("chat_id", chatId);
                doctorId = response.getAsJsonObject("doctor_info").get("user_id").getAsString();
                VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_GET_CHAT_LINES, jsonObject, this);
            }
        } else {
            Toasty.warning(this, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }

    }

    private void scrollToEnd() {
        recylerViewChat.post(new Runnable() {
            @Override
            public void run() {
                recylerViewChat.scrollToPosition(chatMessages.size() - 1);
            }
        });
    }

    @Override
    public void onFragmentInteraction(int what) {

    }

    @Override
    public void onFragmentInteraction(int what, Bundle bundle) {

    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String messageJson = intent.getStringExtra(Constants.KEY_DATA);
            ChatLine parsedChatLine = LocalUtils.parseChatLine(messageJson);

            if (getPackageName().contains("patient")) {
                parsedChatLine.setUser_role_id(doctorRoleId);
            } else
                parsedChatLine.setUser_role_id(patientRoleId);

            if (parsedChatLine != null) {
                chatMessages.add(parsedChatLine);
                mAdapter.notifyItemInserted(mAdapter.getItemCount());
                scrollToEnd();
            }
            /*try {
                JSONObject jsonObject = new JSONObject(messageJson);
                JSONObject notifObject =jsonObject.getJSONObject("notification_object");
                ChatLine chatLine = new ChatLine();
                chatLine.setMessage_type(notifObject.getString("type"));
                chatLine.setSaved(true);
                chatLine.setChat_text(notifObject.getString("chat_text"));
                chatLine.setUser_role_id(jsonObject.getString("user_role_id"));
                chatLine.setUser_role_id(""+gotDoctor.getDocterRoles().getId()+"");
                chatLine.setChat_id(jsonObject.getString("id"));

            } catch (Exception e) {
            }*/
        }
    }

    public class ConnectionReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String status = intent.getStringExtra(AppSocket.SOCKET_STATUS);
            if (status.equals(AppSocket.SOCKET_STATUS_CONNECTED)) {
                controlsContainer.setBackgroundResource(android.R.color.transparent);
            } else {
                controlsContainer.setBackgroundResource(R.color.colorYellow);
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                if (!AppSocket.getInstance(MyApp.get()).isConnected()) {

                    return;
                }
                if (!etxtMessage.getText().toString().trim().isEmpty()) {
                    AnalyticsUtils.sendMessageClick(this, "");
                    AChat chatObj = getChatObjectFromString(etxtMessage.getText().toString().trim());
                    JsonObject jsonObject = TextUtils.convertToJsonObject(chatObj);
                    ChatLine chatLine = getChatLine(etxtMessage.getText().toString().trim(), 0);
                    chatMessages.add(chatLine);
                    mAdapter.notifyItemInserted(chatMessages.size());
                    recylerViewChat.scrollBy(0, 500);
                    VOLLEYAPI.addRequest(this, VolleyAPI.TYPE_ADD_CHAT_LINE, jsonObject, this);

                    JSONObject chatObjectForSocket = new JSONObject();
                    try {
                        chatObjectForSocket.put("key", otherUserChannelKey);
                        chatObjectForSocket.put("notification_counter", "-1");
                        chatObjectForSocket.put("event_type", "get_message");
                        chatObjectForSocket.put("socket_event", "send_message");
                        if (getPackageName().contains("pateint")) {
                            chatObjectForSocket.put("user_role_id", doctorRoleId);
                        } else {
                            chatObjectForSocket.put("user_role_id", patientRoleId);
                        }
                        chatObjectForSocket.put("notify_type", "private_message");
                        chatObjectForSocket.put("id", chat_Id);
                        JSONObject notifObject = new JSONObject();
                        notifObject.put("chat_id", chat_Id);
                        notifObject.put("first_name", userData.getFirstName());
                        notifObject.put("last_name", userData.getLastName());
                        notifObject.put("type", "text");
                        notifObject.put("chat_text", etxtMessage.getText().toString().trim());
                        notifObject.put("model_type", "private_message");
                        chatObjectForSocket.put("notification_object", notifObject);
                        AppSocket.getInstance(MyApp.get()).getSocket().emit(AppSocket.EVENT_EMIT_EVENT, chatObjectForSocket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    etxtMessage.setText("");
                }
                break;
            case R.id.btnAttachment:

                break;
        }
    }

    private AChat getChatObjectFromString(String text) {
        AChat chatObj = new AChat();
        chatObj.setChat_id(chat_Id);
        chatObj.setType("text");
        chatObj.setSave("false");
        chatObj.setChat_message(text);
        chatObj.setChat_text(text);
        chatObj.setSender(userData.getFirstName());
        chatObj.setSenderInfo(userData);

        if (getPackageName().contains("patient")) {
            chatObj.setIsDoctor("false");
            if (gotDoctor != null) {
                chatObj.setUser_id(gotDoctor.getUserInfo().getUserId() + "");
                chatObj.setDoctor_id(gotDoctor.getUserInfo().getUserId() + "");
            }

            if (doctorId != null) {
                chatObj.setUser_id(doctorId);
                chatObj.setDoctor_id(doctorId);
            }
            chatObj.setRole_id("2");
            //chatObj.setDoctor_role_id(gotDoctor.getDocterInfo().getUserRoleId()+"");
            chatObj.setDoctor_role_id(doctorRoleId);
            chatObj.setPatient_id(userData.getUserId() + "");
            chatObj.setPatient_role_id(MyApp.get().getRole().getId() + "");
            chatObj.setUser_role_id(MyApp.get().getRole().getId() + "");

            chatObj.setKey(otherUserChannelKey);
        }
        if (getPackageName().contains("doctor")) {
            chatObj.setIsDoctor("true");
            chatObj.setPatient_role_id(patientRoleId);
            if (gotPatient != null) {
                chatObj.setPatient_id(gotPatient.getUser_info().getUserId() + "");
            } else if (patientId != null) {
                chatObj.setUser_id(patientId);
                chatObj.setPatient_id(patientId);
            }

            if (doctorId != null) {
                //chatObj.setUser_id(doctorId);
                chatObj.setDoctor_id(doctorId);
            }
            chatObj.setRole_id("3");
            //chatObj.setDoctor_role_id(gotDoctor.getDocterInfo().getUserRoleId()+"");
            chatObj.setDoctor_role_id(MyApp.get().getRole().getId() + "");
            chatObj.setUser_role_id(MyApp.get().getRole().getId() + "");
            chatObj.setKey(otherUserChannelKey);
        }
        return chatObj;
    }

    @Override
    protected void onPause() {
        super.onPause();
        gloabalchatID = null;
        LocalBroadcastManager.getInstance(MyApp.get()).unregisterReceiver(mMessageReceiver);
        LocalBroadcastManager.getInstance(MyApp.get()).unregisterReceiver(mConnectionReceiver);
    }

    private ChatLine getChatLine(String chatText, int type) {
        ChatLine chatLine = new ChatLine();
        chatLine.setChat_text(chatText);
        chatLine.setChat_id(chatId);
        chatLine.setUser_role_id(MyApp.get().getRole().getId() + "");
        chatLine.setSaved(false);
        chatLine.setCreated_at(TextUtils.getDateTimeString(Calendar.getInstance().getTime()));
        if (type == 0)
            chatLine.setMessage_type("text");
        else
            chatLine.setMessage_type("attachment");
        return chatLine;
    }

    @Override
    public void onItemClick(ChatLine type, int position) {

    }
}
