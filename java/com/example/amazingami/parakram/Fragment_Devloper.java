package com.example.amazingami.parakram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Devloper extends Fragment {
TextView tvmymailid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_dev, parent, false);
        TextView txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        tvmymailid=(TextView)vi.findViewById(R.id.tvmymailid);
        txttile.setText("Developer");

        tvmymailid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvmymailid.setText(Html.fromHtml("<a href=\"mailto:amarmalik715@gmail.com\">Send Feedback</a>"));
                tvmymailid.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });
        return vi;
    }
}