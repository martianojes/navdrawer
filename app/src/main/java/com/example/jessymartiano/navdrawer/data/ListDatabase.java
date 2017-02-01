package com.example.jessymartiano.navdrawer.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.jessymartiano.navdrawer.MainActivity;
import com.example.jessymartiano.navdrawer.backend.AcademyContract;
import com.example.jessymartiano.navdrawer.backend.DB_manager;
import com.example.jessymartiano.navdrawer.entities.Activity;
import com.example.jessymartiano.navdrawer.entities.Business;
import com.example.jessymartiano.navdrawer.entities.User;
import com.example.jessymartiano.navdrawer.entities.enumActivities;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.jessymartiano.navdrawer.data.Tools.getActivityListFromCursor;
import static com.example.jessymartiano.navdrawer.data.Tools.getBusinessListFromCursor;


/**
 * Created by Jessy on 2017-01-15.
 * The Database used in this app
 */

public class ListDatabase implements DB_manager {
    static ArrayList<Activity> activityList;
    static ArrayList<Business> businessList;

    ContentResolver resolver;

    public ListDatabase(){
        resolver = MainActivity.ctx.getContentResolver();
    }


    /**
     * get BusinessList with ContentResolver
     * @return
     */
    @Override
    public ArrayList<Business> getAsyncListBusiness() {
        Cursor cursor = resolver.query(AcademyContract.Business.BUSINESS_URI, null, null, null, null);
        ArrayList<Business> list = getBusinessListFromCursor(cursor);
        return list;
    }


    /**
     * get Attractionlist with ContentResolver
     * @return
     */
    @Override
    public ArrayList<Activity> getAsyncListActivity() {
        Cursor cursor = resolver.query(AcademyContract.Activity.ACTIVITY_URI, null, null, null, null);
        ArrayList<Activity> list = getActivityListFromCursor(cursor);
        return list;
    }


    public void setUpDatabase() {
       activityList = getAsyncListActivity();
       businessList = getAsyncListBusiness();
    }




}
