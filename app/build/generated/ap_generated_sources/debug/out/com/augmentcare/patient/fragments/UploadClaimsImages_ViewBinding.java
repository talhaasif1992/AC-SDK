// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UploadClaimsImages_ViewBinding implements Unbinder {
  private UploadClaimsImages target;

  @UiThread
  public UploadClaimsImages_ViewBinding(UploadClaimsImages target, View source) {
    this.target = target;

    target.mUploadedImagesRecyclerView = Utils.findRequiredViewAsType(source, R.id.uploaded_images_recyclerview, "field 'mUploadedImagesRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UploadClaimsImages target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUploadedImagesRecyclerView = null;
  }
}
