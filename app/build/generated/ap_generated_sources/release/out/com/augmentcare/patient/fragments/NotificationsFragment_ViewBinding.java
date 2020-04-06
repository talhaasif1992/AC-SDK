// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationsFragment_ViewBinding implements Unbinder {
  private NotificationsFragment target;

  @UiThread
  public NotificationsFragment_ViewBinding(NotificationsFragment target, View source) {
    this.target = target;

    target.recylerViewNotifications = Utils.findRequiredViewAsType(source, R.id.recylerViewNotifications, "field 'recylerViewNotifications'", RecyclerView.class);
    target.btnClose = Utils.findRequiredView(source, R.id.btnClose, "field 'btnClose'");
    target.txtCount = Utils.findRequiredViewAsType(source, R.id.txtCount, "field 'txtCount'", TextView.class);
    target.txtNoNotifications = Utils.findRequiredViewAsType(source, R.id.txtNoNotifications, "field 'txtNoNotifications'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recylerViewNotifications = null;
    target.btnClose = null;
    target.txtCount = null;
    target.txtNoNotifications = null;
  }
}
