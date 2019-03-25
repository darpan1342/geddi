package com.example.geddi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoPlace extends ArrayAdapter<Info> {
    public  static ImageView i;
    public InfoPlace(Activity context, ArrayList<Info> infoArrayList) {
        super(context,0,infoArrayList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Info current=getItem(position);
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.place_name_list,parent,false);
        }
        TextView t = (TextView)listItemView.findViewById(R.id.name);
        i = (ImageView)listItemView.findViewById(R.id.image);
        t.setText(current.getName());
        ImageGet imageGet=new ImageGet(current.getRef());
        imageGet.execute();
        return listItemView;
    }
}
