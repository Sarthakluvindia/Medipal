package com.example.ugdmedipal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dell on 2/10/2018.
 */

class DataParser {
    public List<HashMap<String, String>> parse(String jsonData) {
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        try {
            Log.d("Places", "parse");
            jsonObject = new JSONObject((String) jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            Log.d("Disease", "parse error");
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jsonArray) {
        int placesCount = jsonArray.length();
        List<HashMap<String, String>> placesList = new ArrayList<>();
        HashMap<String, String> diseaseMap = null;
        Log.d("Disease", "getPlaces");

        for (int i = 0; i < placesCount; i++) {
            try {
                diseaseMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(diseaseMap);
                Log.d("Places", "Adding places");

            } catch (JSONException e) {
                Log.d("Places", "Error in Adding places");
                e.printStackTrace();
            }
        }
        return placesList;
    }

    private HashMap<String, String> getPlace(JSONObject diseasePlaceJson) {
        HashMap<String, String> diseasediseaseMap = new HashMap<String, String>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        Log.d("getPlace", "Entered");

        try {
            if (!diseasePlaceJson.isNull("name")) {
                placeName = diseasePlaceJson.getString("name");
            }
            if (!diseasePlaceJson.isNull("vicinity")) {
                vicinity = diseasePlaceJson.getString("vicinity");
            }
            latitude = diseasePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = diseasePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = diseasePlaceJson.getString("reference");
            diseasediseaseMap.put("place_name", placeName);
            diseasediseaseMap.put("vicinity", vicinity);
            diseasediseaseMap.put("lat", latitude);
            diseasediseaseMap.put("lng", longitude);
            diseasediseaseMap.put("reference", reference);
            Log.d("getPlace", "Putting Places");
        } catch (JSONException e) {
            Log.d("getPlace", "Error");
            e.printStackTrace();
        }
        return diseasediseaseMap;
    }
}
