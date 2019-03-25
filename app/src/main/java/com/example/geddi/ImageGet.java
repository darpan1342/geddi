package com.example.geddi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageGet extends AsyncTask<Void,Void,Void> {
    String link;
    Bitmap image=null;
    ImageGet(String str)
    {
        link=str;
        link="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+str+"&key=AIzaSyDNCuwXUgnWQ2zopS2Hy4hkHgOx20Q13MQ";
    }
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            InputStream in = new URL(link).openStream();
            image= BitmapFactory.decodeStream(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        InfoPlace.i.setImageBitmap(image);
    }
}
