package com.example.amazingami.parakram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import static com.example.amazingami.parakram.R.id.drawer_layout;
import static com.example.amazingami.parakram.R.id.fragment_navigation_drawer;
import static com.example.amazingami.parakram.R.id.txttitle;

public class FragmentEvent extends Fragment {
Button ev1,ev2,ev3,ev4,ev5,ev6,ev7,ev8,ev9,ev10,ev11;
TextView txttitle;

    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi= inflater.inflate(R.layout.activity_event_competition, parent, false);

ev1=(Button)vi.findViewById(R.id.ev1);
        ev2=(Button)vi.findViewById(R.id.ev2);
        ev3=(Button)vi.findViewById(R.id.ev3);
        ev4=(Button)vi.findViewById(R.id.ev4);
        ev5=(Button)vi.findViewById(R.id.ev5);
        ev6=(Button)vi.findViewById(R.id.ev6);
        ev7=(Button)vi.findViewById(R.id.ev7);
        ev8=(Button)vi.findViewById(R.id.ev8);
        ev9=(Button)vi.findViewById(R.id.ev9);
       // ev10=(Button)vi.findViewById(R.id.ev10);
        //ev11=(Button)vi.findViewById(R.id.ev11);

        ev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Schedule();
                changeFragment(fragment);


            }
        });  ev1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Home.class);
                startActivity(intent);
            }});

        ev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new FragmentEvent();
                changeFragment(fragment);


            }
        });   ev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new FragmentAboutus();
                changeFragment(fragment);


            }
        });  ev5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Gallery.class);
                startActivity(intent);
            }});
        ev6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Fragment_Team_List();
                changeFragment(fragment);


            }
        });   ev7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Fragment_Sponsors();
                changeFragment(fragment);


            }
        });   ev8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new FragmentAboutus();
                changeFragment(fragment);


            }
        });   ev9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Fragment_Contactus();
                changeFragment(fragment);


            }
        });
        ev10.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        fragment=new Fragment_Contactus();
        changeFragment(fragment);


    }
});
        ev11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new Fragment_Devloper();
                changeFragment(fragment);


            }
        });



return  vi;
    }





    private void changeFragment(Fragment targetFragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
