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

public class Fragment_Contactus extends Fragment {
TextView tvfb,tvgmail,tvweb,tvmobilecall;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_contact, parent, false);
        tvfb=(TextView)vi.findViewById(R.id.tvfb);
        tvgmail=(TextView)vi.findViewById(R.id.tvgmail);
        tvweb=(TextView)vi.findViewById(R.id.tvweb);
        TextView txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        txttile.setText("ContactUs And Links");

        tvfb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ietparakram/"));
                startActivity(browserIntent);
            }});
        tvgmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvgmail.setText(Html.fromHtml("<a href=\"mailto:info@ietparakram.in\">Send Feedback</a>"));
                tvgmail.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });

        tvweb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ietparakram.in/index.html"));
                startActivity(browserIntent);
            }});
        return vi;
        }
}