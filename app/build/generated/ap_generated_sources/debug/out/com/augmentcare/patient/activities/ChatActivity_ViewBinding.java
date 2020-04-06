// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChatActivity_ViewBinding implements Unbinder {
  private ChatActivity target;

  @UiThread
  public ChatActivity_ViewBinding(ChatActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChatActivity_ViewBinding(ChatActivity target, View source) {
    this.target = target;

    target.recylerViewChat = Utils.findRequiredViewAsType(source, R.id.recylerViewChat, "field 'recylerViewChat'", RecyclerView.class);
    target.btnSend = Utils.findRequiredView(source, R.id.btnSend, "field 'btnSend'");
    target.btnAttachment = Utils.findRequiredView(source, R.id.btnAttachment, "field 'btnAttachment'");
    target.etxtMessage = Utils.findRequiredViewAsType(source, R.id.etxtMessage, "field 'etxtMessage'", AppCompatEditText.class);
    target.progressContent = Utils.findRequiredViewAsType(source, R.id.progressContent, "field 'progressContent'", ProgressBar.class);
    target.txtCurrentMessage = Utils.findRequiredViewAsType(source, R.id.txtCurrentMessage, "field 'txtCurrentMessage'", TextView.class);
    target.controlsContainer = Utils.findRequiredView(source, R.id.linearLayout, "field 'controlsContainer'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ChatActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recylerViewChat = null;
    target.btnSend = null;
    target.btnAttachment = null;
    target.etxtMessage = null;
    target.progressContent = null;
    target.txtCurrentMessage = null;
    target.controlsContainer = null;
  }
}
