package com.example.amazingami.parakram;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityRoboDetails extends AppCompatActivity {
AppBarLayout app_bar;
    CollapsingToolbarLayout toolbar_layout;
    TextView txtdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtdetails=(TextView)findViewById(R.id.txtdetails);
        app_bar=(AppBarLayout)findViewById(R.id.app_bar);
        toolbar_layout=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        txtdetails.setText(Helper.selecteddetails);
        toolbar.setTitle(Helper.selectedtitle);
        toolbar_layout.setBackgroundResource(Helper.selectedimage);


    }
}
