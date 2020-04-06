// Generated code from Butter Knife. Do not modify!
package com.augmentcare.patient.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.augmentcare.patient.R;
import com.google.android.youtube.player.YouTubePlayerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoPlayerFragment_ViewBinding implements Unbinder {
  private VideoPlayerFragment target;

  @UiThread
  public VideoPlayerFragment_ViewBinding(VideoPlayerFragment target, View source) {
    this.target = target;

    target.youtubePlayer = Utils.findRequiredViewAsType(source, R.id.youtubePlayer, "field 'youtubePlayer'", YouTubePlayerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VideoPlayerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.youtubePlayer = null;
  }
}
