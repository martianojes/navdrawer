package com.example.jessymartiano.navdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * this activity sets splashscreen before the first activity
 */
public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;
    static Activity ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ((TextView) findViewById(R.id.loadingTV)).setText(getIntent().getStringExtra("text").toString());
        ctx = this;
        ;

    }
    public void setSplashScreenText(String text){
        ((TextView)  ctx.findViewById(R.id.loadingTV)).setText(text);
    }

    public static void hideSplashScreen(){
        ctx.finish();
    }
}
