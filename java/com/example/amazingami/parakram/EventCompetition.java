package com.example.amazingami.parakram;

import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EventCompetition extends Fragment {
    Fragment fragment;
    Button ev1,ev2,ev3,ev4,ev5,ev6,ev7,ev8,ev9,ev10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.activity_event_competition, parent, false);
        Button ev1 = (Button) vi.findViewById(R.id.ev1);
        Button ev2 = (Button) vi.findViewById(R.id.ev2);
        Button ev3 = (Button) vi.findViewById(R.id.ev3);
        Button ev4 = (Button) vi.findViewById(R.id.ev4);
        Button ev5 = (Button) vi.findViewById(R.id.ev5);
        Button ev6 = (Button) vi.findViewById(R.id.ev6);
        Button ev7 = (Button) vi.findViewById(R.id.ev7);
        Button ev8 = (Button) vi.findViewById(R.id.ev8);
        Button ev9 = (Button) vi.findViewById(R.id.ev9);
        Button ev10 = (Button) vi.findViewById(R.id.ev10);
        TextView  txttile=(TextView)getActivity().findViewById(R.id.txttitle);
        txttile.setText("Events");


        ev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarcs();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });

        ev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarchem();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarcivil();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarelec();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarelex();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarmech();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });

        ev7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarrobotic();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarcosmos();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });

        ev9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmar();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });


        ev10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentRoboListAmarmba();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
                changeFragment(fragment);

            }
        });
        return vi;
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