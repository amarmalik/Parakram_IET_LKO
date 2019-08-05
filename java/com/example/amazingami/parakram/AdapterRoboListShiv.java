package com.example.amazingami.parakram;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AdapterRoboListShiv extends BaseAdapter{

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    private int m_nlayoutID = 0;
    String selectedbookingid="";
    int img[];

    public AdapterRoboListShiv(Activity a, ArrayList<HashMap<String, String>> d, int listRow,int images[]) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_nlayoutID = listRow;
        img=images;
    }
    
    @Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {

		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(m_nlayoutID, null);


        ImageView ibtn_robo=(ImageView)vi.findViewById(R.id.ibtn_robo);
        TextView txttile = (TextView) vi.findViewById(R.id.txttile);

		HashMap<String, String> fragValue = new HashMap<String, String>();
        fragValue = data.get(position);

        txttile.setText(fragValue.get("title"));
        ibtn_robo.setBackgroundResource(img[position]);


        return vi;
	}

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


}