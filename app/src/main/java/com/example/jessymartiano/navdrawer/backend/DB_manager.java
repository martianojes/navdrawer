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

    long addActivity(ContentValues values);
    long addBusiness(ContentValues values);
    long addUser(ContentValues values);

    boolean checkUser(ContentValues values);

    boolean removeActivity(long id);
    boolean removeBusiness(long id);
    boolean removeUser(long id);

    boolean updateActivity(long id, ContentValues values);
    boolean updateBusiness(long id, ContentValues values);
    boolean updateUser(long id, ContentValues values);

    Cursor getActivities();
    Cursor getBusinesses();
    Cursor getUsers();
    Cursor getActivitiesBusiness();
    ArrayList<Business> getAsyncListBusiness();
    ArrayList<Activity> getAsyncListActivity();

    void setUpDatabase();
    boolean isUpdate();


}
