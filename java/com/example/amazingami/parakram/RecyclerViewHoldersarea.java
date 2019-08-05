package com.example.amazingami.parakram;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class RecyclerViewHoldersarea extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView evnt1;

    public RecyclerViewHoldersarea(View itemView) {
        super(itemView);
       // itemView.setOnClickListener(this);
        evnt1 = (TextView)itemView.findViewById(R.id.evnt1);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        //changeFragment(new Gallery_Fragment(),view.getContext());
    }




}