package com.example.ugdmedipal.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.ugdmedipal.R;
import com.example.ugdmedipal.YouTubeCredentials;
import com.example.ugdmedipal.model.PostVideoItem;
import com.example.ugdmedipal.model.TimelineItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PostVideoViewHolder extends BaseViewHolder {

    Context context;
    private TextView txtTime;
    private ImageView imgUser;
    private YouTubePlayerView videoView;
    private FloatingActionButton play;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    public PostVideoViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTime = itemView.findViewById(R.id.post_video_time);
        imgUser = itemView.findViewById(R.id.post_video_img);
        videoView = itemView.findViewById(R.id.post_video_placeholder);
        play = itemView.findViewById(R.id.floatingActionButton);
    }

    @Override
    void setData(TimelineItem item) {

        final PostVideoItem postVideoItem = item.getPostVideoItem();
        txtTime.setText(postVideoItem.getTime());
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                String videopath = postVideoItem.getVideoURL();
                youTubePlayer.loadVideo(videopath);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.initialize(YouTubeCredentials.getApiKey(),onInitializedListener);
            }
        });
        Glide.with(super.itemView.getContext()).load(postVideoItem.getUserImg()).into(imgUser);
    }
}
