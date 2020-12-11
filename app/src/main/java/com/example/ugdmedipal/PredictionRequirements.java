package com.example.ugdmedipal;

import java.util.ArrayList;
import java.util.Random;

public class PredictionRequirements {

    ArrayList<String> temp = Prediction_Second.sel_symp;
    public static String pred_disease = "";
    public static int probab1, probab2, probab3;

    public String disease(){
        if (case1(temp) != null){
            pred_disease = case1(temp);
            return case1(temp);
        }
        if (case2(temp) != null){
            pred_disease = case2(temp);
            return case2(temp);
        }
        if (case3(temp) != null){
            pred_disease = case3(temp);
            return case3(temp);
        }
        if (case4(temp) != null){
            pred_disease = case4(temp);
            return case4(temp);
        }
        if (case5(temp) != null){
            pred_disease = case5(temp);
            return case5(temp);
        }
        if (case6(temp) != null){
            pred_disease = case6(temp);
            return case6(temp);
        }
        if (case7(temp) != null){
            pred_disease = case7(temp);
            return case7(temp);
        }
        if (case8(temp) != null){
            pred_disease = case8(temp);
            return case8(temp);
        }
        if (case9(temp) != null){
            pred_disease = case9(temp);
            return case9(temp);
        }
        if (case10(temp) != null){
            pred_disease = case10(temp);
            return case10(temp);
        }
        return caseDefault(temp);
    }

    public int predictProbability(int i){
        if (i == 1) {
            //Number between 65-87
            probab1 = (int) (Math.random() * 22) + 65;
            return probab1;
        }
        if (i == 2) {
            //Number between 40-58
            probab2 = (int) (Math.random() * 18) + 40;
            return probab2;
        }
        if (i == 3) {
            //Number between 10-20
            probab3 = (int) (Math.random() * 10) + 10;
            return probab3;
        }
        return 0;
    }

    public String case1(ArrayList<String> temp){
        if (temp.contains("vomiting") && temp.contains("nausea") && temp.contains("pain chest") && temp.contains("shortness of breath") && temp.contains("asthenia")){
            return "Diabetes,Pneumonia,Infection";
        }
        return null;
    }
    public String case2(ArrayList<String> temp){
        if (temp.contains("headache") && temp.contains("fever") && temp.contains("cough") && temp.contains("nausea") && temp.contains("vomiting")){
            return "Pneumonia,Infection,Diarrehea";
        }
        return null;
    }
    public String case3(ArrayList<String> temp){
        if (temp.contains("headache") && temp.contains("fever") && temp.contains("dizziness") && temp.contains("nausea") && temp.contains("vomiting")){
            return "Pneumonia,Infection,Diarrehea";
        }
        return null;
    }
    public String case4(ArrayList<String> temp){
        if (temp.contains("cough") && temp.contains("shortness of breath") && temp.contains("pain chest") && temp.contains("wheezing")){
            return "Asthma,Myocardinal Infarction,Dementia";
        }
        return null;
    }
    public String case5(ArrayList<String> temp){
        if (temp.contains("fever") && temp.contains("erythema") && temp.contains("chill") && temp.contains("diarrhea") && temp.contains("pain") && temp.contains("cough") && temp.contains("swelling")){
            return "Infection,Pneumonia,Diarrhea";
        }
        return null;
    }
    public String case6(ArrayList<String> temp){
        if (temp.contains("pain") && temp.contains("pain chest") && temp.contains("nausea") && temp.contains("asthenia") && temp.contains("pain abdominal") && temp.contains("constipation")){
            if (temp.contains("pain chest") && temp.contains("nausea") && temp.contains("pain abdominal") && temp.contains("constipation")){
                return "Gastroesophageal Reflux Disease,Diverticulitis,Carcinoma";
            }
        }
        return null;
    }
    public String case7(ArrayList<String> temp){
        if (temp.contains("fever") && temp.contains("erythema") && temp.contains("diarrhea") && temp.contains("pain") && temp.contains("cough") && temp.contains("swelling")){
            return "Infection,Pneumonia,Diarrhea";
        }
        return null;
    }
    public String case8(ArrayList<String> temp){
        if (temp.contains("fever") && temp.contains("diarrhea") && temp.contains("pain") && temp.contains("cough") && temp.contains("swelling")){
            return "Pneumonia,Infection,Diarrhea";
        }
        return null;
    }
    public String case9(ArrayList<String> temp){
        if (temp.contains("vomiting") && temp.contains("nausea") && temp.contains("pain chest") && temp.contains("shortness of breath")){
            return "Diabetes,Pneumonia,Infection";
        }
        return null;
    }
    public String case10(ArrayList<String> temp){
        if (temp.contains("headache") && temp.contains("nausea") && temp.contains("pain chest") && temp.contains("fever")){
            return "Pneumonia,Asthma,Anemia";
        }
        return null;
    }
    public String caseDefault(ArrayList<String> temp){
        return "Match Not Found!,Match Not Found!,Match Not Found!";
    }
}
