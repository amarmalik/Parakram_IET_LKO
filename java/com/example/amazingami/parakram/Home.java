package com.example.amazingami.parakram;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Home extends Fragment {
Button evnt1,btnsch,btnnews,btnprize,btnreg,btngal,btnteam,btnabout,btncontact,btnspon,btndev;

    ViewFlipper flipper;
    TextView txttile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.activity_home, parent, false);
        flipper = (ViewFlipper) vi.findViewById(R.id.flipper1);
        flipper.startFlipping();
        txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        txttile.setText("Home");
        evnt1 = (Button) vi.findViewById(R.id.evnt1);
        btnsch= (Button) vi.findViewById(R.id.btnsch);
        btnnews= (Button) vi.findViewById(R.id.btnnews);
        btnprize= (Button) vi.findViewById(R.id.btnprize);
        btnreg= (Button) vi.findViewById(R.id.btnreg);
        btngal= (Button) vi.findViewById(R.id.btngal);
        btnteam= (Button) vi.findViewById(R.id.btnteam);
        btnabout= (Button) vi.findViewById(R.id.btnabout);
        btncontact= (Button) vi.findViewById(R.id.btncontact);
        btnspon= (Button) vi.findViewById(R.id.btnspon);
        btndev= (Button) vi.findViewById(R.id.btndev);


evnt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Fragment fragment=new EventCompetition();
        changeFragment(fragment);
    }
});


        btnsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Schedule();
                changeFragment(fragment);


            }
        });

        btnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_News();
                changeFragment(fragment);


            }
        });

        btnprize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Prize();
                changeFragment(fragment);


            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Register();
                changeFragment(fragment);


            }
        });
        btngal.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),Activity_Gallery.class);
                    startActivity(intent);
                }});


        btnteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Team_List();
                changeFragment(fragment);


            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new FragmentAboutus();
                changeFragment(fragment);


            }
        });
        btnspon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Sponsors();
                changeFragment(fragment);


            }
        });
        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Contactus();
                changeFragment(fragment);


            }
        });
        btndev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new Fragment_Devloper();
                changeFragment(fragment);


            }
        });






        return vi;

    }


/*
    private void changeFragment(Fragment targetFragment){
          FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);

        transaction.commit();
    }

*/

    private void changeFragment(Fragment targetFragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);

        transaction.commit();
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
