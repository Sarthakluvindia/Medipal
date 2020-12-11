package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Prediction extends AppCompatActivity {
    Button back, next;
    CheckBox headache, fever, cough, nose, pain, chest, throat, others;
    public static int h=0, f=0, co=0, n=0, p=0, ch=0, t=0, o=0;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        headache = (CheckBox)findViewById(R.id.check_headache);
        fever = (CheckBox)findViewById(R.id.check_fever);
        cough = (CheckBox)findViewById(R.id.check_cough);
        nose = (CheckBox)findViewById(R.id.check_nose);
        pain = (CheckBox)findViewById(R.id.check_pain);
        chest = (CheckBox)findViewById(R.id.check_chest);
        throat = (CheckBox)findViewById(R.id.check_throat);
        others = (CheckBox)findViewById(R.id.check_others);

        back = (Button)findViewById(R.id.pred_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next = (Button)findViewById(R.id.pred_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(headache.isChecked()){
                    h = 1;
                }
                if(fever.isChecked()){
                    f = 1;
                }
                if(cough.isChecked()){
                    co = 1;
                }
                if(nose.isChecked()){
                    n = 1;
                }
                if(pain.isChecked()){
                    p = 1;
                }
                if(chest.isChecked()){
                    ch = 1;
                }
                if(throat.isChecked()){
                    t = 1;
                }
                if(others.isChecked()){
                    o = 1;
                }
                startActivity(new Intent(Prediction.this,Prediction_Second.class));
            }
        });
    }
}
