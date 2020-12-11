package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Prediction_Second extends AppCompatActivity implements View.OnClickListener {
    LinearLayout llt;
    Button back, btn1, btn2, next;
    View child;
    int arg = 0;
    String temp_headache = "", temp_fever = "", temp_cough = "", temp_nose = "", temp_pain = "", temp_chest = "", temp_throat = "";
    public static ArrayList<String> sel_symp = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction__second);
        llt = (LinearLayout) findViewById(R.id.pred_button_id);
        if (Prediction.h == 1){
            temp_headache = "headache";
            sel_symp.add("headache");
        }
        if (Prediction.f == 1){
            temp_fever = "fever";
            sel_symp.add("fever");
        }
        if (Prediction.co == 1){
            temp_cough = "cough";
            sel_symp.add("cough");
        }
        if (Prediction.n == 1){
            temp_nose = "stuffy nose";
            sel_symp.add("stuffy nose");
        }
        if (Prediction.p == 1){
            temp_pain = "pain abdominal";
            sel_symp.add("pain abdominal");
        }
        if (Prediction.ch == 1){
            temp_chest = "pain chest";
            sel_symp.add("pain chest");
        }
        if (Prediction.t == 1){
            temp_throat = "sore throat";
            sel_symp.add("sore throat");
        }

        String symp[] = getResources().getStringArray(R.array.symptoms);
        llt.removeAllViews();
        for (int i=0, j=1; i<symp.length && j<symp.length; i+= 2, j+= 2) {
            if (symp[i].equals(temp_headache) || symp[i].equals(temp_fever) || symp[i].equals(temp_cough) || symp[i].equals(temp_nose) || symp[i].equals(temp_pain) || symp[i].equals(temp_chest) || symp[i].equals(temp_throat) || symp[j].equals(temp_headache) || symp[j].equals(temp_fever) || symp[j].equals(temp_cough) || symp[j].equals(temp_nose) || symp[j].equals(temp_chest) || symp[j].equals(temp_pain) || symp[j].equals(temp_throat)){
            }else {
                child = getLayoutInflater().inflate(R.layout.pred_button, null);
                child.setId(i);
                btn1 = (Button) child.findViewById(R.id.btn_left);
                btn2 = (Button) child.findViewById(R.id.btn_right);
                btn1.setId(i);
                btn1.setText(symp[i]);
                btn1.setOnClickListener(this);
                btn2.setId(j);
                btn2.setText(symp[j]);
                btn2.setOnClickListener(this);
                llt.addView(child);
            }
        }

        back = (Button) findViewById(R.id.pred_two_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next = (Button) findViewById(R.id.pred_two_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Prediction_Second.this,Prediction_Third.class));
            }
        });
    }
    @Override
    public void onClick(View v) {
        String symp[] = getResources().getStringArray(R.array.symptoms);
        for (int i=0;i<symp.length;i++){
            if (v.getId() == i){
                arg++;
                if (arg == 1){
                    v.setBackgroundColor(Color.rgb(245,206,113));
                    v.setPressed(true);
                    sel_symp.add(symp[i]);
                }
                else if (arg == 2){
                    v.setBackgroundColor(Color.rgb(255,255,255));
                    v.setPressed(false);
                    sel_symp.remove(symp[i]);
                }
                else {
                    arg = 0;
                }
            }
        }
    }
}
