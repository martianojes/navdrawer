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
    private ArrayList<Business> getAsyncListBusiness() {
        Cursor cursor = resolver.query(AcademyContract.Business.BUSINESS_URI, null, null, null, null);
        ArrayList<Business> list = getBusinessListFromCursor(cursor);
        return list;
    }


    /**
     * get Attractionlist with ContentResolver
     * @return
     */
    private ArrayList<Activity> getAsyncListActivity() {
        Cursor cursor = resolver.query(AcademyContract.Activity.ACTIVITY_URI, null, null, null, null);
        ArrayList<Activity> list = getActivityListFromCursor(cursor);
        return list;
    }

    /*@Override
    public ArrayList<Business> getBusinessList(String Country) {
        ArrayList<Business> list = businessList;
        ArrayList<Business> toReturn = new ArrayList<>();
        for (Business att:list) {
            if(att.getBusinessAddress().getCountry().equals(Country))
                toReturn.add(att);
        }
        return toReturn;
    }

    @Override
    public ArrayList<Attraction> getAttractionList(Business business) {
        ArrayList<Attraction> list = attractionList;
        ArrayList<Attraction> toReturn = new ArrayList<>();
        for (Attraction att:list) {
            if(att.getBusinessID().equals(business.getBusinessID()))
                toReturn.add(att);
        }
        return toReturn;
    }*/

    public void setUpDatabase() {
        activityList = getAsyncListActivity();
        businessList = getAsyncListBusiness();
    }

    /**
     * transfer contentresolvers answer from Cursor into Arraylist
     * @param list
     * @return
     */
    private ArrayList<Activity> getActivityListFromCursor(Cursor list) {
        ArrayList<Activity> toReturn = new ArrayList<>();
        try {
            Cursor ab = list;
            enumActivities type;
            String country;
            String beginning;
            String end;
            float price;
            String explanation;
            int id;
            int businessId;

            for(ab.moveToFirst(); !ab.isAfterLast(); ab.moveToNext()) {
                // The Cursor is now set to the right position
                id = ab.getInt(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_ID));
                type = enumActivities.valueOf(ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_TYPE)));
                country = ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_COUNTRY));
                beginning = ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_BEGIN));
                end = ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_END));
                price = Float.parseFloat(ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_PRICE)));
                explanation = ab.getString(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_EXPLANATION));
                businessId = ab.getInt(ab.getColumnIndex(AcademyContract.Activity.ACTIVITY_BUSINESS_ID));
                toReturn.add(new Activity(type,country,beginning,end,price,explanation,id,businessId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }
    /**
     * transfer contentresolvers answer from Cursor into Arraylist
     * @param list
     * @return
     */
    public ArrayList<Business> getBusinessListFromCursor(Cursor list) {
        ArrayList<Business> toReturn = new ArrayList<>();

        try {
            Cursor ab = list;
            int id;
            String name;
            String country;
            String street;
            String phone;
            String mail;
            String website;

            for(ab.moveToFirst(); !ab.isAfterLast(); ab.moveToNext()) {
                // The Cursor is now set to the right position
                id = ab.getInt(ab.getColumnIndex(AcademyContract.Business.BUSINESS_ID));
                name = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_NAME));
                country = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_COUNTRY));
                street = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_STREET));
                phone = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_PHONE));
                mail = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_MAIL));
                website = ab.getString(ab.getColumnIndex(AcademyContract.Business.BUSINESS_WEBSITE));
                toReturn.add(new Business(id,name,country,street,phone,mail,website));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
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
