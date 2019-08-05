package com.example.amazingami.parakram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class Fragment_Callpop extends Fragment {
Button btncalll,btnsms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi= inflater.inflate(R.layout.fragment_callpop, parent, false);
        btncalll=(Button)vi.findViewById(R.id.btncalll);
        btnsms=(Button)vi.findViewById(R.id.btnsms);
        btncalll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("8052425430"));
                startActivity(callIntent);
            }});
    return vi;
    }



}
