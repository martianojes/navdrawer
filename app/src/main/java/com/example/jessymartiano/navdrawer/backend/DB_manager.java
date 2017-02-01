package com.example.jessymartiano.navdrawer.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.jessymartiano.navdrawer.entities.Activity;
import com.example.jessymartiano.navdrawer.entities.Business;

import java.util.ArrayList;

/**
 * Created by David on 01/12/2016.
 */

public interface DB_manager {


    ArrayList<Business> getAsyncListBusiness();
    ArrayList<Activity> getAsyncListActivity();

    void setUpDatabase();


}
