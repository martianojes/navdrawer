package com.example.jessymartiano.navdrawer.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jessymartiano.navdrawer.backend.DBManagerFactory;
import com.example.jessymartiano.navdrawer.backend.DB_manager;
import com.example.jessymartiano.navdrawer.backend.Delegate;
import com.example.jessymartiano.navdrawer.controller.MainActivity;

/**
 * Created by Super Jessy on 26/01/2017.
 */


public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Log.d("my service" , "onReceive");
        MainActivity.setUpDatabase(new Delegate() {
            @Override
            public void Do() {

            }
        });


        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
