package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.ugdmedipal.Adapter.TimelineAdapter;
import com.example.ugdmedipal.model.TimelineItem;
import com.example.ugdmedipal.utils.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.List;

public class Vaccination extends YouTubeBaseActivity {
    private RecyclerView timelineView;
    private TimelineAdapter adapter;
    private List<TimelineItem> mdata;
    private VideoView videoView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);
        initiateView();
        getListData();
        setupAdapter();
    }
    private void setFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void setupAdapter() {
        adapter = new TimelineAdapter(this,mdata);
        timelineView.setAdapter(adapter);
    }

    private void getListData() {
        mdata = DataSource.getTimelineData();
    }

    private void initiateView() {
        timelineView = findViewById(R.id.timeline);
        timelineView.setLayoutManager(new LinearLayoutManager(this));
    }
}
