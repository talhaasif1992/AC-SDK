// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.augmentcare.patient.customviews.AppointmentsHistoryView;
import com.mikhaellopez.circularimageview.CircularImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DashboardFragment_ViewBinding implements Unbinder {
  private DashboardFragment target;

  @UiThread
  public DashboardFragment_ViewBinding(DashboardFragment target, View source) {
    this.target = target;

    target.txtName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'txtName'", TextView.class);
    target.ivUserPic = Utils.findRequiredViewAsType(source, R.id.ivUserPic, "field 'ivUserPic'", CircularImageView.class);
    target.profilePicIV = Utils.findRequiredViewAsType(source, R.id.profilePicIV, "field 'profilePicIV'", CircleImageView.class);
    target.lytInstantDoctor = Utils.findRequiredView(source, R.id.layout_lytInstantDoctor, "field 'lytInstantDoctor'");
    target.lytDoctors = Utils.findRequiredView(source, R.id.layout_lytDoctors, "field 'lytDoctors'");
    target.lytLabs = Utils.findRequiredView(source, R.id.lytLabs, "field 'lytLabs'");
    target.lytMedicines = Utils.findRequiredView(source, R.id.lytMedicines, "field 'lytMedicines'");
    target.ahv = Utils.findRequiredViewAsType(source, R.id.ahv_upcomming, "field 'ahv'", AppointmentsHistoryView.class);
    target.rootOfXML = Utils.findRequiredViewAsType(source, R.id.rootView, "field 'rootOfXML'", FrameLayout.class);
    target.toolbarHomeWithPic = Utils.findRequiredViewAsType(source, R.id.toolbar_home, "field 'toolbarHomeWithPic'", Toolbar.class);
    target.homeToolbarTitle = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'homeToolbarTitle'", TextView.class);
    target.badgeInstant = Utils.findRequiredViewAsType(source, R.id.badge_instantAppointment, "field 'badgeInstant'", TextView.class);
    target.badgeFindDoctor = Utils.findRequiredViewAsType(source, R.id.badge_findADoctor, "field 'badgeFindDoctor'", TextView.class);
    target.chatIcon = Utils.findRequiredViewAsType(source, R.id.chatIcon, "field 'chatIcon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DashboardFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtName = null;
    target.ivUserPic = null;
    target.profilePicIV = null;
    target.lytInstantDoctor = null;
    target.lytDoctors = null;
    target.lytLabs = null;
    target.lytMedicines = null;
    target.ahv = null;
    target.rootOfXML = null;
    target.toolbarHomeWithPic = null;
    target.homeToolbarTitle = null;
    target.badgeInstant = null;
    target.badgeFindDoctor = null;
    target.chatIcon = null;
  }
}
