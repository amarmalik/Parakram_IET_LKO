package com.example.amazingami.parakram;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.amazingami.parakram.ResideMenu.ResideMenu;
import com.example.amazingami.parakram.ResideMenu.ResideMenuItem;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private ResideMenu resideMenu;
    private ResideMenuItem home,event,notification,schedule,gallery,team,sponser,aboutus,contactus,links,developer;
    TextView txttitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     txttitle=(TextView)findViewById(R.id.txttitle);
        mContext = this;
        setUpMenu();
       // com.isoftinctechnology.linkonnect.GCMIntentService.getGenerateNotification2(MainActivity.this,"Test notification");
        if( savedInstanceState == null )
            changeFragment2(new Home());

    }


    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.drawerimage);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
//  private ResideMenuItem home,event,notification,schedule,gallery,team,sponser,aboutus,contactus,links,developer;

        home = new ResideMenuItem(this, R.drawable.arrowicon, "Home");
        event = new ResideMenuItem(this, R.drawable.arrowicon, "Event");

        notification = new ResideMenuItem(this, R.drawable.arrowicon, "Notification");
        schedule = new ResideMenuItem(this, R.drawable.arrowicon,  "Schedule");
        gallery = new ResideMenuItem(this, R.drawable.arrowicon, "Gallery");

        team = new ResideMenuItem(this, R.drawable.arrowicon, "Team");

        sponser = new ResideMenuItem(this, R.drawable.arrowicon, "Sponsor");
        aboutus = new ResideMenuItem(this, R.drawable.arrowicon, "About us");
        contactus = new ResideMenuItem(this, R.drawable.arrowicon, "Contact us");
        links = new ResideMenuItem(this, R.drawable.arrowicon, "Links");
        developer = new ResideMenuItem(this, R.drawable.arrowicon, "Developer");

        home.setOnClickListener(this);
        event.setOnClickListener(this);
        schedule.setOnClickListener(this);
        notification.setOnClickListener(this);
        gallery.setOnClickListener(this);
        team.setOnClickListener(this);
        sponser.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        contactus.setOnClickListener(this);
        links.setOnClickListener(this);
        developer.setOnClickListener(this);



        resideMenu.addMenuItem(home, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(event, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(schedule, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(notification, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(gallery, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(team, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(sponser, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(aboutus, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(contactus, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(links, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(developer, ResideMenu.DIRECTION_LEFT);

        findViewById(R.id.imgmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
     /*
		 *  Start GCM integration
		 */



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
      if (view == home){

            changeFragment(new Home());
        }
        else if (view == event){
            changeFragment(new EventCompetition());


        }
        else if (view == notification){
            changeFragment(new Fragment_News());

        }
        else if (view == schedule){
            changeFragment(new Schedule());
        }
        else if (view == team){
            changeFragment(new Fragment_Team_List());

        }
        else if (view == sponser){
            changeFragment(new Fragment_Sponsors());

        }else if (view == aboutus){

            changeFragment(new FragmentAboutus());


        }else if (view == contactus){
            changeFragment(new Fragment_Contactus());

        }
        else if (view == links){
            changeFragment(new Fragment_Contactus());

        }else if (view == developer){
            changeFragment(new Fragment_Devloper());

        }
        else if (view == gallery){
            Intent intent = new Intent(MainActivity.this, Activity_Gallery.class);
            //intent.putExtra("loginby", "Guest");
            startActivity(intent);
        }



        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
               // Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
           // Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );
        transaction.addToBackStack(null);

        transaction.commit();
    }


    private void changeFragment2(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

        Fragment newCustomFragment = targetFragment;
        transaction.replace(R.id.main_fragment, newCustomFragment );

        transaction.commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }









}

