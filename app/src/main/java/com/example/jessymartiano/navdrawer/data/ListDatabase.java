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
    static ArrayList<User> userList;

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




    @Override
    public long addActivity(ContentValues values) {
        return 0;
    }

    @Override
    public long addBusiness(ContentValues values) {
        return 0;
    }

    @Override
    public long addUser(ContentValues values) {
        return 0;
    }

    @Override
    public boolean checkUser(ContentValues values) {
        return false;
    }

    @Override
    public boolean removeActivity(long id) {
        return false;
    }

    @Override
    public boolean removeBusiness(long id) {
        return false;
    }

    @Override
    public boolean removeUser(long id) {
        return false;
    }

    @Override
    public boolean updateActivity(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateBusiness(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateUser(long id, ContentValues values) {
        return false;
    }

    @Override
    public Cursor getActivities() {
        return null;
    }

    @Override
    public Cursor getBusinesses() {
        return null;
    }

    @Override
    public Cursor getUsers() {
        return null;
    }

    @Override
    public Cursor getActivitiesBusiness() {
        return null;
    }

    @Override
    public boolean isUpdate() {
        return false;
    }
}
