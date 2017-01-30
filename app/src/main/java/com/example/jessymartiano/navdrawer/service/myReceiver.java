package com.example.jessymartiano.navdrawer.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.jessymartiano.navdrawer.backend.DBManagerFactory;
import com.example.jessymartiano.navdrawer.backend.DB_manager;

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
        DB_manager db = DBManagerFactory.getManager();
        db.setUpDatabase();
        Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
