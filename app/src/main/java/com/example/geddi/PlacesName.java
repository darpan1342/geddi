package com.example.geddi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PlacesName extends AsyncTask<Void,Void,Void>{
        double longitude;
        double latitude;
        URL url;
        String res="";
        String t="";
        PlacesName(double longitude,double latitude)
        {
            this.longitude=longitude;
            this.latitude=latitude;
        }

        /*public  String name() {
            String t = "";
            try {
                JSONObject req1 = new JSONObject(res);
                JSONArray result = req1.getJSONArray("results");
                for (int i = 0; i < result.length(); i++) {
                    JSONObject current = result.getJSONObject(i);
                    String s = current.getString("name");
                    t = t + " " + s;
                }
                return t;
            } catch (JSONException e) {
                String h = "Error1";
                Log.e("Placename", "parsing", e);
                return h;
            }
        }*/

    @Override
    protected Void doInBackground(Void... voids) {
            String link = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+latitude+","+longitude+"&radius=5000&key=AIzaSyDNCuwXUgnWQ2zopS2Hy4hkHgOx20Q13MQ";

        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream= httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
                line=bufferedReader.readLine();
                res=res+line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        HomePage.t.setText(res);

    }
}




