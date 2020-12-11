package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreServices extends AppCompatActivity {
    Button drugdict,vacc,preg,ambul,doctor,history,medic,about,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_services);

        back = (Button)findViewById(R.id.ms_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vacc = (Button)findViewById(R.id.vacc);
        vacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,Vaccination.class));
            }
        });
        drugdict = (Button)findViewById(R.id.drugdict);
        drugdict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,DrugDictionary.class));
            }
        });
        preg = (Button)findViewById(R.id.preg);
        preg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,Pregnancy.class));
            }
        });
        ambul = (Button)findViewById(R.id.ambul);
        ambul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,AmbulanceService.class));
            }
        });
        doctor = (Button)findViewById(R.id.doctor);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,DoctorAppointment.class));
            }
        });
        history = (Button)findViewById(R.id.medicalhistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,MedicalHistory.class));
            }
        });
        medic = (Button)findViewById(R.id.curr_medic);
        medic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,MedicineDosage.class));
            }
        });
        about = (Button)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreServices.this,AboutUs.class));
            }
        });
    }
}
