package com.example.amazingami.parakram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Register extends Fragment {
TextView tvregs,tvlogged;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_reg, parent, false);
        TextView txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        txttile.setText("Register");
        tvregs=(TextView) vi.findViewById(R.id.tvregs);
        tvlogged=(TextView) vi.findViewById(R.id.tvlogged);
        tvregs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ietparakram.in/signup.html"));
                startActivity(browserIntent);
            }});

        tvlogged.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ietparakram.in/login.html"));
                startActivity(browserIntent);
            }});
        return vi;
    }
}