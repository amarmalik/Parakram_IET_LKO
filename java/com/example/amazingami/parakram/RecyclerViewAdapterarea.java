package com.example.amazingami.parakram;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapterarea extends RecyclerView.Adapter<RecyclerViewHoldersarea> {

    //private List<ItemObject> itemList;

    private Context context;
    ArrayList<HashMap<String,String>> data;

    public RecyclerViewAdapterarea(Context context, ArrayList<HashMap<String, String>> data) {
       // this.itemList = itemList;
        this.context = context;
        this.data=data;

    }

    @Override
    public RecyclerViewHoldersarea onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowhomerecycler, null);
        RecyclerViewHoldersarea rcv = new RecyclerViewHoldersarea(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHoldersarea holder, int position) {
        HashMap<String, String> fragValue = new HashMap<String, String>();
        fragValue = data.get(position);
        holder.evnt1.setText(fragValue.get(Helper.Key_title));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
