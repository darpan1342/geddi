package com.example.geddi;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

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
import java.util.ArrayList;

public class PlacesName extends AsyncTask<Void,Void,Void>{
        double longitude;
        double latitude;
        URL url;
        String res="";
        String []t1;
        String []t2;
        ArrayList<Info> infoArrayList;
        PlacesName(double longitude,double latitude)
        {
            this.longitude=longitude;
            this.latitude=latitude;
        }

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
        try {
            JSONObject req1 = new JSONObject(res);
            JSONArray result = req1.getJSONArray("results");
            t1= new String[result.length()];
            t2=new String[result.length()];
            for (int i = 0; i < result.length(); i++) {
                JSONObject current = result.getJSONObject(i);
                String y="";
                try {
                    JSONArray Image = current.getJSONArray("photos");
                    JSONObject Imgref= Image.getJSONObject(0);
                     y= Imgref.getString("photo_reference");

                }
                catch(JSONException e){
                    y="";
                }
                String s = current.getString("name");
                t1[i] = s;
                t2[i]=y;

            }
        } catch (JSONException e) {
            String h = "Error1";
            Log.e("Placename", "parsing", e);
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        infoArrayList= new ArrayList<>();
        for(int i=0;i<t1.length;i++)
        {
            if(!t2[i].equals(""))
            infoArrayList.add(new Info(t1[i],t2[i]));
        }
        InfoPlace infoPlace= new InfoPlace(HomePage.avc,infoArrayList);
        HomePage.listView.setAdapter(infoPlace);
    }
}




