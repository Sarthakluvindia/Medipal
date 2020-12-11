package com.example.ugdmedipal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DrugDictionary extends AppCompatActivity {
    Button back;
    LinearLayout drug;
    AutoCompleteTextView edtv;
    View child;
    TextView brand_name, company, price, packaging, type, uses, comp, alcohol, pregnancy, lactation, driving, kidney, liver, work, howtouse, sideeffects;
    DrugInfoReader drugInfoReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_dictionary);

        drugInfoReader = new DrugInfoReader();
        back = (Button)findViewById(R.id.dd_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        drug = (LinearLayout)findViewById(R.id.drug);
        edtv = (AutoCompleteTextView)findViewById(R.id.dd_edtv);
        final ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.drug_dictionary));
        edtv.setAdapter(adapter);
        edtv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drug.removeAllViews();
                child = getLayoutInflater().inflate(R.layout.activity_drug_data,null);
                List drug_data = drugReader(adapter.getItem(position).toString());
                brand_name = (TextView)child.findViewById(R.id.brand_name);
                brand_name.setText(drugInfoReader.getBrandName());
                company = (TextView)child.findViewById(R.id.company_name);
                company.setText(drugInfoReader.getCompanyName());
                price = (TextView)child.findViewById(R.id.price);
                price.setText(drugInfoReader.getPrice());
                packaging = (TextView)child.findViewById(R.id.packaging);
                packaging.setText(drugInfoReader.getPackaging());
                type = (TextView)child.findViewById(R.id.type);
                type.setText(drugInfoReader.getType());
                uses = (TextView)child.findViewById(R.id.uses);
                uses.setText(drugInfoReader.getUse());
                comp = (TextView)child.findViewById(R.id.composition);
                comp.setText(drugInfoReader.getComposition());
                alcohol = (TextView)child.findViewById(R.id.alcohol);
                alcohol.setText(drugInfoReader.getAlcoholInteraction());
                pregnancy = (TextView)child.findViewById(R.id.pregnancy);
                pregnancy.setText(drugInfoReader.getPregnancyInteraction());
                lactation = (TextView)child.findViewById(R.id.lactation);
                lactation.setText(drugInfoReader.getLactoseInteraction());
                driving = (TextView)child.findViewById(R.id.driving);
                driving.setText(drugInfoReader.getDrivingInteraction());
                kidney = (TextView)child.findViewById(R.id.kidney);
                kidney.setText(drugInfoReader.getKidneyInteraction());
                liver = (TextView)child.findViewById(R.id.liver);
                liver.setText(drugInfoReader.getLiverInteraction());
                work = (TextView)child.findViewById(R.id.howitworks);
                work.setText(drugInfoReader.getHowItWorks());
                howtouse = (TextView)child.findViewById(R.id.howtouse);
                howtouse.setText(drugInfoReader.getHowToUse());
                sideeffects = (TextView)child.findViewById(R.id.sideeffects);
                sideeffects.setText(drugInfoReader.getSideEffects());
                drug.addView(child);
            }
        });
    }
    private List<DrugInfoReader> drugData = new ArrayList<>();
    private List drugReader(String drug_name) {
        InputStream inputStream = getResources().openRawResource(R.raw.drugdict);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line = "";
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",");
                if (tokens[1].equals(drug_name)){
                    drugInfoReader.setId(Integer.parseInt(tokens[0]));
                    drugInfoReader.setBrandName(tokens[1]);
                    drugInfoReader.setCompanyName(tokens[2]);
                    drugInfoReader.setPrice(tokens[3]);
                    drugInfoReader.setPackaging(tokens[4]);
                    drugInfoReader.setType(tokens[5]);
                    drugInfoReader.setUse(tokens[6]);
                    drugInfoReader.setComposition(tokens[7]);
                    drugInfoReader.setAlcoholInteraction(tokens[8]);
                    drugInfoReader.setPregnancyInteraction(tokens[9]);
                    drugInfoReader.setLactoseInteraction(tokens[10]);
                    drugInfoReader.setDrivingInteraction(tokens[11]);
                    drugInfoReader.setKidneyInteraction(tokens[12]);
                    drugInfoReader.setLiverInteraction(tokens[13]);
                    drugInfoReader.setSideEffects(tokens[14]);
                    drugInfoReader.setHowItWorks(tokens[15]);
                    drugInfoReader.setHowToUse(tokens[16]);
                    drugInfoReader.setPrescriptionRequired(tokens[17]);
                    drugInfoReader.setOccurrence(Integer.parseInt(tokens[18]));
                    drugData.add(drugInfoReader);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return drugData;
    }
}
