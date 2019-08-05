package com.example.amazingami.parakram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Activity_Frontpage extends Activity {


    final int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(Activity_Frontpage.this, MainActivity.class);
                intent.putExtra("loginby", "Guest");
                startActivity(intent);
                finish();

            }
        }, splash_time);

    }
}
