// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.activities;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ViewClaimImageActivity_ViewBinding implements Unbinder {
  private ViewClaimImageActivity target;

  @UiThread
  public ViewClaimImageActivity_ViewBinding(ViewClaimImageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ViewClaimImageActivity_ViewBinding(ViewClaimImageActivity target, View source) {
    this.target = target;

    target.mUploadClaimImageView = Utils.findRequiredViewAsType(source, R.id.upload_images, "field 'mUploadClaimImageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewClaimImageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUploadClaimImageView = null;
  }
}
