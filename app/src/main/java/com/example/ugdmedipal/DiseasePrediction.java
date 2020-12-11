package com.example.ugdmedipal;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.request.Request;
import com.google.android.gms.common.api.Response;
import com.google.firebase.database.DatabaseReference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class DiseasePrediction {
    JSONObject response;
    String strq;
    
    public void diseaseAPI(String predict_array){
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final String url = "http://192.168.43.100:3630/diagnose";
        String method = "POST";
        String tag_string_req = "disease_to_predict";

        JSONObject user_det = new JSONObject();
        try {
            user_det.put("url", predict_array);

        } catch (JSONException e) {
            e.printStackTrace();
        }
            Log.d("JSON RESPONSE", "Request Response: " + response.toString());

            try {
                String bot_reply = response.getString("response");
                Log.d("bot_reply", bot_reply);
                bot_reply = bot_reply.replace("1", "");
                bot_reply = bot_reply.replace("2", "");
                bot_reply = bot_reply.replace("3", "");
                Log.d("bot_reply", bot_reply);

                try{
                    JSONArray items = new JSONArray(bot_reply);
                    for(int i = 0; i< items.length(); i++){
                        JSONObject js = (JSONObject) items.get(i);
                    }
//                        addMessage(new TextMessage("Would you like to know more about this disease?", "rx", getCurrentTimeStamp()));
//                        init();
//                        if(rep!=null && rep.equals("positive")){
                            for(int i = 0; i< items.length(); i++) {
                                JSONObject js = (JSONObject) items.get(i);
                            }
//                                addMessage(new TextMessage("Treatment Info::\n"+js.getString("treatment_info"), "rx", getCurrentTimeStamp()));
                    //}
                    //}else{
                    //addMessage(new TextMessage("Click on the hospital button to locate the nearest hospitals.", "rx", getCurrentTimeStamp()));
                    //}
                }catch(JSONException e) {

                    JSONObject items = new JSONObject(bot_reply);
                    //addMessage(new TextMessage("DISEASE\n" + items.getString("disease_name"), "rx", getCurrentTimeStamp()));
                    //addMessage(new TextMessage("Would you like to know more about this disease?", "rx", getCurrentTimeStamp()));
                    //EditText usernameEditText = (EditText) findViewById(R.id.userInputEditText);
                    //String info = usernameEditText.getText().toString();
                        while(bot_reply.matches("")){

                       };
//                        if(rep!=null && rep.equals("positive")){
                    //addMessage(new TextMessage("TREATMENT\n" + items.getString("treatment_info"), "rx", getCurrentTimeStamp()));
//                        }else{
                    //addMessage(new TextMessage("Click on the hospital button to locate the nearest hospitals.", "rx", getCurrentTimeStamp()));
//                        }



                }

            } catch (JSONException e) {
                // JSON error
                e.printStackTrace();
            }

        }

    /*strq.setRetryPolicy(new DiseasePrediction(
            20000,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    // Adding request to request queue
    DatabaseReference.getInstance();*/
    }

