package com.augmentcare.patient.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoPlayerFragment extends BaseFragment implements YouTubePlayer.OnInitializedListener {


    public VideoPlayerFragment() {
        // Required empty public constructor
    }
    @BindView(R.id.youtubePlayer)
    YouTubePlayerView youtubePlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_player, container, false);
        ButterKnife.bind(this, view);
        youtubePlayer.initialize("", this );
        return view;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.d("VIDEOPLAYER", "VIDEOPLAYER SUCCESS");
        youTubePlayer.cueVideo("avP5d16wEp0");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.d("VIDEOPLAYER", "VIDEOPLAYER FIALURE");
    }
}
