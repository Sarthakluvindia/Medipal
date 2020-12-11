package com.example.ugdmedipal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView nav;
    ViewPager viewPager;
    FirebaseAuth auth;
    GoogleApiClient mGoogleApiClient;
    String personName,personEmail,personId;
    Uri personPhoto;
    Button nav_menu, setting;
    DrawerLayout mDrawer;
    CardView pred, preg, vacc, hist, dict, doc, ambul, medic;
    DatabaseReference reference;
    String bg,h,w,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        nav.setItemIconTintList(null);

        /*reference = FirebaseDatabase.getInstance().getReference().child("Registered User");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("name").getValue().toString();
                bg = dataSnapshot.child("bg").getValue().toString();
                h = dataSnapshot.child("height").getValue().toString();
                w = dataSnapshot.child("weight").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        setting = (Button)findViewById(R.id.cp_nav_set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MoreServices.class));
            }
        });

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerClass(), 2000, 4000);

        pred = (CardView)findViewById(R.id.card_pred);
        pred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Prediction.class));
            }
        });

        preg = (CardView)findViewById(R.id.card_preg);
        preg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Pregnancy.class));
            }
        });

        vacc = (CardView)findViewById(R.id.card_vacc);
        vacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Vaccination.class));
            }
        });

        hist = (CardView)findViewById(R.id.card_hist);
        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MedicalHistory.class));
            }
        });

        dict = (CardView)findViewById(R.id.card_dict);
        dict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DrugDictionary.class));
            }
        });

        doc = (CardView)findViewById(R.id.card_doc);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DoctorAppointment.class));
            }
        });

        ambul = (CardView)findViewById(R.id.card_ambul);
        ambul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AmbulanceService.class));
            }
        });

        medic = (CardView)findViewById(R.id.card_medic);
        medic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MedicineDosage.class));
            }
        });
        auth=FirebaseAuth.getInstance();
        mDrawer=(DrawerLayout)findViewById(R.id.drawerlayout);
        nav_menu=(Button)findViewById(R.id.cp_nav_menu);
        nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(Gravity.LEFT);
            }
        });

        //Google Data Intake
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if (acct != null) {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            personId = acct.getId();
            personPhoto = acct.getPhotoUrl();
        }
        TextView txtProfileName = (TextView) nav.getHeaderView(0).findViewById(R.id.user_name);
        txtProfileName.setText(personName);
        ImageView img=(ImageView)nav.getHeaderView(0).findViewById(R.id.imageView);
        Picasso.with(MainActivity
                .this)
                .load(personPhoto).placeholder(R.drawable.ic_account_circle_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(img);
        /*TextView txtBloodGroup = (TextView)nav.getHeaderView(0).findViewById(R.id.nav_bg);
        if (txtBloodGroup.equals("")){
            txtBloodGroup.setText("A+");
        }else {
            txtBloodGroup.setText(bg);
        }
        TextView txtHeight = (TextView)nav.getHeaderView(0).findViewById(R.id.nav_height);
        if (txtHeight.equals("")){
            txtHeight.setText("172 cm");
        }else {
            txtBloodGroup.setText(h + "cm");
        }
        TextView txtWeight = (TextView)nav.getHeaderView(0).findViewById(R.id.nav_weight);
        if (txtWeight.equals("")){
            txtWeight.setText("52 kg");
        }else {
            txtWeight.setText(w);
        }*/
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.nav_predict) {
            startActivity(new Intent(MainActivity.this,MainActivity.class));
        }
        if (item.getItemId()==R.id.nav_preg) {
            startActivity(new Intent(MainActivity.this,Pregnancy.class));
        }
        if (item.getItemId()==R.id.nav_child) {
            startActivity(new Intent(MainActivity.this,Vaccination.class));
        }
        if (item.getItemId()==R.id.nav_history) {
            startActivity(new Intent(MainActivity.this,MedicalHistory.class));
        }
        if (item.getItemId()==R.id.nav_dict) {
            startActivity(new Intent(MainActivity.this,DrugDictionary.class));
        }
        if (item.getItemId()==R.id.nav_medic){
            startActivity(new Intent(MainActivity.this,MedicineDosage.class));
        }
        if (item.getItemId()==R.id.nav_doc) {
            startActivity(new Intent(MainActivity.this,DoctorAppointment.class));
        }
        if (item.getItemId()==R.id.nav_ambul) {
            startActivity(new Intent(MainActivity.this,AmbulanceService.class));
        }
        if(item.getItemId()==R.id.sign_out){
            auth.signOut();
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            // ...
                            Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(i);
                        }
                    });
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            Toast.makeText(MainActivity.this,"Signed Out from the Account",Toast.LENGTH_SHORT);
        }
        if(item.getItemId()==R.id.delete){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                    Toast.makeText(MainActivity.this, "Your profile is deleted :( Create a account now!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                            Toast.makeText(MainActivity.this,"Revoked Access from your Google Account :( Do come back soon.",Toast.LENGTH_SHORT);
                        }
                    });
        }
        return false;
    }
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }
    public class MyTimerClass extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
