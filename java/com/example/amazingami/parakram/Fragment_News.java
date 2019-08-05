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

public class Fragment_News extends Fragment {
TextView tvnoti;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_news, parent, false);
        TextView txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        tvnoti=(TextView)vi.findViewById(R.id.tvnoti);
        txttile.setText("News-Feed");
        tvnoti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ietparakram.in/index.html#events"));
                startActivity(browserIntent);
            }});
        return vi;
    }
}