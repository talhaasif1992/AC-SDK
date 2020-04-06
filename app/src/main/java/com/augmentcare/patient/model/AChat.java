package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar Ul Zaman on 06/09/2017.
 */

public class AChat implements Parcelable{
    private String user_role_id;

    private ANotification notification_object;

    private String doctor_role_id;

    private String save;

    private String role_id;

    private String socket_event;

    private String isDoctor;

    private String chat_text;

    private String doctor_id;

    private String notify_type;

    private String type;

    private String patient_role_id;

    private String id;

    private String chat_id;
    @SerializedName("SenderInfo")
    private UserDataLogin senderInfo;

    private String sender;

    private String notify;

    private String read;

    private String appendMessage;

    private String chat_message;

    private String user_id;

    private String patient_id;

    private String key;
    private boolean isSaved;
    public AChat(){}

    protected AChat(Parcel in) {
        user_role_id = in.readString();
        doctor_role_id = in.readString();
        save = in.readString();
        role_id = in.readString();
        socket_event = in.readString();
        isDoctor = in.readString();
        chat_text = in.readString();
        doctor_id = in.readString();
        notify_type = in.readString();
        type = in.readString();
        patient_role_id = in.readString();
        id = in.readString();
        chat_id = in.readString();
        senderInfo = in.readParcelable(UserInfo.class.getClassLoader());
        sender = in.readString();
        notify = in.readString();
        read = in.readString();
        appendMessage = in.readString();
        chat_message = in.readString();
        user_id = in.readString();
        patient_id = in.readString();
        key = in.readString();
        isSaved = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_role_id);
        dest.writeString(doctor_role_id);
        dest.writeString(save);
        dest.writeString(role_id);
        dest.writeString(socket_event);
        dest.writeString(isDoctor);
        dest.writeString(chat_text);
        dest.writeString(doctor_id);
        dest.writeString(notify_type);
        dest.writeString(type);
        dest.writeString(patient_role_id);
        dest.writeString(id);
        dest.writeString(chat_id);
        dest.writeParcelable(senderInfo, flags);
        dest.writeString(sender);
        dest.writeString(notify);
        dest.writeString(read);
        dest.writeString(appendMessage);
        dest.writeString(chat_message);
        dest.writeString(user_id);
        dest.writeString(patient_id);
        dest.writeString(key);
        dest.writeByte((byte) (isSaved ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AChat> CREATOR = new Creator<AChat>() {
        @Override
        public AChat createFromParcel(Parcel in) {
            return new AChat(in);
        }

        @Override
        public AChat[] newArray(int size) {
            return new AChat[size];
        }
    };

    public String getUser_role_id ()
    {
        return user_role_id;
    }

    public void setUser_role_id (String user_role_id)
    {
        this.user_role_id = user_role_id;
    }

    public ANotification getNotification_object ()
    {
        return notification_object;
    }

    public void setNotification_object (ANotification notification_object)
    {
        this.notification_object = notification_object;
    }

    public String getDoctor_role_id ()
    {
        return doctor_role_id;
    }

    public void setDoctor_role_id (String doctor_role_id)
    {
        this.doctor_role_id = doctor_role_id;
    }

    public String getSave ()
    {
        return save;
    }

    public void setSave (String save)
    {
        this.save = save;
    }

    public String getRole_id ()
    {
        return role_id;
    }

    public void setRole_id (String role_id)
    {
        this.role_id = role_id;
    }

    public String getSocket_event ()
    {
        return socket_event;
    }

    public void setSocket_event (String socket_event)
    {
        this.socket_event = socket_event;
    }

    public String getIsDoctor ()
    {
        return isDoctor;
    }

    public void setIsDoctor (String isDoctor)
    {
        this.isDoctor = isDoctor;
    }

    public String getChat_text ()
    {
        return chat_text;
    }

    public void setChat_text (String chat_text)
    {
        this.chat_text = chat_text;
    }

    public String getDoctor_id ()
    {
        return doctor_id;
    }

    public void setDoctor_id (String doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public String getNotify_type ()
    {
        return notify_type;
    }

    public void setNotify_type (String notify_type)
    {
        this.notify_type = notify_type;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPatient_role_id ()
    {
        return patient_role_id;
    }

    public void setPatient_role_id (String patient_role_id)
    {
        this.patient_role_id = patient_role_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getChat_id ()
    {
        return chat_id;
    }

    public void setChat_id (String chat_id)
    {
        this.chat_id = chat_id;
    }

    public UserDataLogin getSenderInfo ()
    {
        return senderInfo;
    }

    public void setSenderInfo (UserDataLogin senderInfo)
    {
        this.senderInfo = senderInfo;
    }

    public String getSender ()
    {
        return sender;
    }

    public void setSender (String sender)
    {
        this.sender = sender;
    }

    public String getNotify ()
    {
        return notify;
    }

    public void setNotify (String notify)
    {
        this.notify = notify;
    }

    public String getRead ()
    {
        return read;
    }

    public void setRead (String read)
    {
        this.read = read;
    }

    public String getAppendMessage ()
    {
        return appendMessage;
    }

    public void setAppendMessage (String appendMessage)
    {
        this.appendMessage = appendMessage;
    }

    public String getChat_message ()
    {
        return chat_message;
    }

    public void setChat_message (String chat_message)
    {
        this.chat_message = chat_message;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getPatient_id ()
    {
        return patient_id;
    }

    public void setPatient_id (String patient_id)
    {
        this.patient_id = patient_id;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
