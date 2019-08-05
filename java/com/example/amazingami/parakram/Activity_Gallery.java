package com.example.amazingami.parakram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Activity_Gallery extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String API_KEY = "AIzaSyAmFIsJ_MsZL773rMRZ_LyNDYDy8_pMDKU";
    Button btnrefresh;
    TextView txttile;
    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String VIDEO_ID = "41CeGWO5LaI";
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // attaching layout xml
        setContentView(R.layout.activity_gallery);
        // Initializing YouTube player view
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, Activity_Gallery.this);

    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        youTubePlayerView.initialize(API_KEY, Activity_Gallery.this);
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (null == player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

}