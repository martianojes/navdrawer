package com.example.jessymartiano.navdrawer.data;

import android.content.ContentValues;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;
import com.example.jessymartiano.navdrawer.entities.Activity;
import com.example.jessymartiano.navdrawer.entities.Business;
import com.example.jessymartiano.navdrawer.entities.User;
import com.example.jessymartiano.navdrawer.entities.enumActivities;


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
}
