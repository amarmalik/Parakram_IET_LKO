package com.example.amazingami.parakram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;


public class Adapter_TeamList extends ArrayAdapter<String> {
LinearLayout lltlist;
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public Adapter_TeamList(Activity context,
                            String[] web, Integer[] imageId) {
        super(context, R.layout.row_team_list, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row_team_list, null, true);
        lltlist=(LinearLayout)rowView.findViewById(R.id.lltlist);

       TextView tvname = (TextView) rowView.findViewById(R.id.tvname);
        ImageView img=(ImageView)rowView.findViewById(R.id.imgpic) ;
       // TextView txtweb=(TextView)rowView.findViewById(R.id.tvname);
       // ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        //txtTitle.setText(web[position]);
        //txtweb.setText(web[position]);
        tvname.setText(web[position]);
        img.setBackgroundResource(imageId[position]);
        return rowView;
    }

}