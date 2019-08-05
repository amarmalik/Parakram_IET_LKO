package com.example.amazingami.parakram;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeRecycler extends Fragment {
RecyclerView recylerview;
    ViewFlipper flipper;
    private GridLayoutManager lLayout;
    RecyclerViewAdapterarea rcAdapter;
ArrayList<HashMap<String,String>>contentlist;
    String arrtitels[]={"EVENTS","SCHEDULE","NEWS FEEDS","PRIZE","REGISTER","GALLERY","TEAM","SPONSORS","ABOUT US","CONTACT US","DEVELOPER"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.activity_homerecyler, parent, false);
        flipper = (ViewFlipper) vi.findViewById(R.id.flipper1);
        flipper.startFlipping();
        recylerview = (RecyclerView) vi.findViewById(R.id.recylerview);

        lLayout = new GridLayoutManager(getActivity(), 2);
contentlist=new ArrayList<HashMap<String, String>>();
        contentlist=getData();
        rcAdapter = new RecyclerViewAdapterarea(getActivity(), contentlist);

        recylerview.setLayoutManager(lLayout);
        recylerview.setAdapter(rcAdapter);

        lLayout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 10) {
                    return 2;
                } else {
                    return 1;
                }

            }
        });


        recylerview.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click



                        // remove all views from Recycler View
                        recylerview.setAdapter(null);

                    }
                })
        );




        return vi;

    }


    public ArrayList<HashMap<String,String>> getData()
    {
        ArrayList alist=new ArrayList<HashMap<String,String>>();
        for(int i=0;i<arrtitels.length;i++)
        {
            HashMap<String,String>map=new HashMap<String,String>();
            map.put(Helper.Key_title,arrtitels[i]);
            alist.add(map);
        }
        return  alist;
    }



    @Override
    public void onResume() {
        if(flipper!=null)
        {
            flipper.startFlipping();

        }
        super.onResume();
    }
}
