package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicineDosage extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener  {
    EditText disease;
    Spinner noofmed;
    LinearLayout llt;
    View child;
    Button addmed,select;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_dosage);

        databaseReference = FirebaseDatabase.getInstance().getReference("Medicine");

        disease = (EditText)findViewById(R.id.med_disease);
        noofmed = (Spinner)findViewById(R.id.noofmed);
        ArrayAdapter noofmed_arr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.no_of_med));
        noofmed_arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noofmed.setAdapter(noofmed_arr);
        noofmed.setOnItemSelectedListener(this);

        llt = (LinearLayout)findViewById(R.id.med_llt);
        addmed = (Button)findViewById(R.id.add_med);
        addmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MedicineDosage.this,"Medicine Added",Toast.LENGTH_LONG).show();
                Notification();
                String id = databaseReference.push().getKey();
                Medicine medicine = new Medicine(id,disease.getText().toString());
                databaseReference.child(id).setValue(medicine);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        llt.removeAllViews();
        for (int i=0; i<position+1; i++){
            child = getLayoutInflater().inflate(R.layout.med_rep,null);
            child.setId(i);

            EditText qty = (EditText)child.findViewById(R.id.med_rep_name);
            qty.setId(i);

            Spinner type = (Spinner)child.findViewById(R.id.med_rep_type_spinner);
            type.setId(i);
            ArrayAdapter med_type = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.med_type));
            med_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            type.setAdapter(med_type);

            select = (Button)child.findViewById(R.id.select_time_med_freq);
            select.setId(i);
            select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogFragment timePicker = new TimePickerFragment();
                    timePicker.show(getSupportFragmentManager(),"time picker");
                }
            });

            EditText dosage = (EditText)child.findViewById(R.id.dosage_med_freq);
            dosage.setId(i);

            llt.addView(child);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        select.setBackgroundColor(Color.rgb(255,255,255));
        select.setText(hourOfDay+":"+minute);
    }

    private void Notification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel1 = new NotificationChannel("1","Medicine", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager1 = getSystemService(NotificationManager.class);
            manager1.createNotificationChannel(notificationChannel1);

            NotificationChannel notificationChannel2 = new NotificationChannel("2","Channel 2", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager2 = getSystemService(NotificationManager.class);
            manager2.createNotificationChannel(notificationChannel2);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.medicine_color))
                .setSmallIcon(R.drawable.medicine_color)
                .setContentTitle("Time to take medicine")
                .setContentText("It's 7 A.M take your medicine.")
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1,builder.build());
    }
}
