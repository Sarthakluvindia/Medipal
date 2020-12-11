package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Prediction_Third extends AppCompatActivity {
    Button back;
    String symps, temp;
    TextView disease1, disease2, disease3, symptom1, symptom2, symptom3, percent1, percent2, percent3;
    ProgressBar progressBar1, progressBar2, progressBar3;
    String[] pred_diseases;
    int probab1, probab2, probab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction__third);
        disease1 = (TextView)findViewById(R.id.disease1);
        disease2 = (TextView)findViewById(R.id.disease2);
        disease3 = (TextView)findViewById(R.id.disease3);
        symptom1 = (TextView)findViewById(R.id.symptom1);
        symptom2 = (TextView)findViewById(R.id.symptom2);
        symptom3 = (TextView)findViewById(R.id.symptom3);
        percent1 = (TextView)findViewById(R.id.percent1);
        percent2 = (TextView)findViewById(R.id.percent2);
        percent3 = (TextView)findViewById(R.id.percent3);
        progressBar1 = (ProgressBar)findViewById(R.id.progress1);
        progressBar2 = (ProgressBar)findViewById(R.id.progress2);
        progressBar3 = (ProgressBar)findViewById(R.id.progress3);

        back = (Button) findViewById(R.id.pred_three_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (String s : Prediction_Second.sel_symp)
        {
            if (s != null) {
                symps += s + ", ";
            }
        }
        PredictionRequirements predictionRequirements = new PredictionRequirements();
        temp = predictionRequirements.disease();

        pred_diseases = temp.split(",");

        if (!pred_diseases[0].equals("Match Not Found!")){
            probab1 = predictionRequirements.predictProbability(1);
            probab2 = predictionRequirements.predictProbability(2);
            probab3 = predictionRequirements.predictProbability(3);
        }
        else {
            probab1 = 0;
            probab2 = 0;
            probab3 = 0;
        }

        disease1.setText(pred_diseases[0]);
        disease2.setText(pred_diseases[1]);
        disease3.setText(pred_diseases[2]);
        symptom1.setText(symps.substring(4));
        symptom2.setText(symps.substring(4));
        symptom3.setText(symps.substring(4));
        percent1.setText(String.valueOf(probab1));
        percent2.setText(String.valueOf(probab2));
        percent3.setText(String.valueOf(probab3));
        progressBar1.setProgress(probab1);
        progressBar2.setProgress(probab2);
        progressBar3.setProgress(probab3);
    }
}
