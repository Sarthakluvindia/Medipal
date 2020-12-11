package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        im=(ImageView)findViewById(R.id.icon_splash);
        Animation anim= AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.splashscreen);
        im.startAnimation(anim);
        final Intent in=new Intent(AnimationActivity.this,LoginActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (Exception e){

                }
                finally {
                    startActivity(in);
                    finish();
                }
            }
        };
        timer.start();
    }
}
