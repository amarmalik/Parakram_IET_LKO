package com.example.amazingami.parakram;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Adapter_RoboList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public Adapter_RoboList(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.row_robo_list, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row_robo_list, null, true);
       // TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView img=(ImageView)rowView.findViewById(R.id.ibtn_robo) ;
       // ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        //txtTitle.setText(web[position]);

        img.setBackgroundResource(imageId[position]);
        return rowView;
    }
}