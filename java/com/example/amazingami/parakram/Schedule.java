package com.example.amazingami.parakram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Schedule extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_sch, parent, false);
        Button ev1 = (Button) vi.findViewById(R.id.ev1);
        TextView txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        txttile.setText("Schedule");

        return vi;
    }
}