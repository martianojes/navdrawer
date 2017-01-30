package com.example.jessymartiano.navdrawer.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;
import com.example.jessymartiano.navdrawer.entities.Activity;
import com.example.jessymartiano.navdrawer.entities.Business;
import com.example.jessymartiano.navdrawer.entities.User;
import com.example.jessymartiano.navdrawer.entities.enumActivities;

import java.util.ArrayList;


/**
 * Created by David on 01/12/2016.
 */

public class Tools {
    public static Activity ContentValuesToActivity (ContentValues contentValues){

        Activity activity = new Activity();

        activity.setId(contentValues.getAsInteger(AcademyContract.Activity.ACTIVITY_ID));
        activity.setType(enumActivities.valueOf(contentValues.getAsString(AcademyContract.Activity.ACTIVITY_TYPE)));
        activity.setCountry(contentValues.getAsString(AcademyContract.Activity.ACTIVITY_COUNTRY));
        activity.setPrice(contentValues.getAsFloat(AcademyContract.Activity.ACTIVITY_PRICE));
        activity.setBeginning(contentValues.getAsString(AcademyContract.Activity.ACTIVITY_BEGIN));
        activity.setEnd(contentValues.getAsString(AcademyContract.Activity.ACTIVITY_END));
        activity.setExplanation(contentValues.getAsString(AcademyContract.Activity.ACTIVITY_EXPLANATION));
        return activity;
    }

    public static ContentValues ActivityToContentValues (Activity activity){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AcademyContract.Activity.ACTIVITY_ID, activity.getId());
        contentValues.put(AcademyContract.Activity.ACTIVITY_TYPE, activity.getType().toString());
        contentValues.put(AcademyContract.Activity.ACTIVITY_COUNTRY, activity.getCountry());
        contentValues.put(AcademyContract.Activity.ACTIVITY_PRICE, activity.getPrice());
        contentValues.put(AcademyContract.Activity.ACTIVITY_BEGIN, activity.getBeginning().toString());
        contentValues.put(AcademyContract.Activity.ACTIVITY_END, activity.getEnd().toString());
        contentValues.put(AcademyContract.Activity.ACTIVITY_EXPLANATION, activity.getExplanation());
        return contentValues;
    }
    public static Business ContentValuesToBusiness (ContentValues contentValues){
        Business business = new Business();
        business.setId(contentValues.getAsInteger(AcademyContract.Business.BUSINESS_ID));
        business.setName(contentValues.getAsString(AcademyContract.Business.BUSINESS_NAME));
        business.setCountry(contentValues.getAsString(AcademyContract.Business.BUSINESS_COUNTRY));
        business.setStreet(contentValues.getAsString(AcademyContract.Business.BUSINESS_STREET));
        business.setPhone(contentValues.getAsString(AcademyContract.Business.BUSINESS_PHONE));
        business.setMail(contentValues.getAsString(AcademyContract.Business.BUSINESS_MAIL));
        business.setWebsite(contentValues.getAsString(AcademyContract.Business.BUSINESS_WEBSITE));
        return business;
    }

    public static ContentValues BusinessToContentValues (Business business){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AcademyContract.Business.BUSINESS_ID, business.getId());
        contentValues.put(AcademyContract.Business.BUSINESS_NAME, business.getName());
        contentValues.put(AcademyContract.Business.BUSINESS_COUNTRY, business.getCountry());
        contentValues.put(AcademyContract.Business.BUSINESS_STREET, business.getStreet());
        contentValues.put(AcademyContract.Business.BUSINESS_PHONE, business.getPhone());
        contentValues.put(AcademyContract.Business.BUSINESS_MAIL, business.getMail());
        contentValues.put(AcademyContract.Business.BUSINESS_WEBSITE, business.getWebsite());
        return contentValues;
    }

    public static User ContentValuesToUser (ContentValues contentValues){
        User user = new User();
        user.setId(contentValues.getAsInteger(AcademyContract.User.USER_ID));
        user.setUsername(contentValues.getAsString(AcademyContract.User.USER_USERNAME));
        user.setPassword(contentValues.getAsString(AcademyContract.User.USER_PASSWORD));
        return user;
    }

    public static ContentValues UserToContentValues (User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(AcademyContract.User.USER_ID, user.getId());
        contentValues.put(AcademyContract.User.USER_USERNAME, user.getUsername());
        contentValues.put(AcademyContract.User.USER_PASSWORD, user.getPassword());
        return contentValues;
    }

    /**
     * transfer contentresolvers answer from Cursor into Arraylist
     * @param list
     * @return
     */
    public static ArrayList<Activity> getActivityListFromCursor(Cursor list) {
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
    public static ArrayList<Business> getBusinessListFromCursor(Cursor list) {
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
}
