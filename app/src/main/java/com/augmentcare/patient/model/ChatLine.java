package com.augmentcare.patient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Qamar Ul Zaman on 06/09/2017.
 */

public class ChatLine implements Parcelable{
    private String user_role_id;

    private String chat_id;

    private String id;

    private String updated_at;

    private String chat_text;

    private String created_at;

    private String message_type;
    private boolean isSaved;

    public ChatLine(){}
    protected ChatLine(Parcel in) {
        user_role_id = in.readString();
        chat_id = in.readString();
        id = in.readString();
        updated_at = in.readString();
        chat_text = in.readString();
        created_at = in.readString();
        message_type = in.readString();
        isSaved = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_role_id);
        dest.writeString(chat_id);
        dest.writeString(id);
        dest.writeString(updated_at);
        dest.writeString(chat_text);
        dest.writeString(created_at);
        dest.writeString(message_type);
        dest.writeByte((byte) (isSaved ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChatLine> CREATOR = new Creator<ChatLine>() {
        @Override
        public ChatLine createFromParcel(Parcel in) {
            return new ChatLine(in);
        }

        @Override
        public ChatLine[] newArray(int size) {
            return new ChatLine[size];
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

    public String getChat_id ()
    {
        return chat_id;
    }

    public void setChat_id (String chat_id)
    {
        this.chat_id = chat_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getChat_text ()
    {
        return chat_text;
    }

    public void setChat_text (String chat_text)
    {
        this.chat_text = chat_text;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getMessage_type ()
    {
        return message_type;
    }

    public void setMessage_type (String message_type)
    {
        this.message_type = message_type;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
