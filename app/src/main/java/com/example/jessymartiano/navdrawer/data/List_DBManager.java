package com.example.jessymartiano.navdrawer.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.jessymartiano.navdrawer.backend.DB_manager;
import com.example.jessymartiano.navdrawer.entities.Activity;
import com.example.jessymartiano.navdrawer.entities.Business;
import com.example.jessymartiano.navdrawer.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 01/12/2016.
 */

public class List_DBManager implements DB_manager {

    static List<Activity> activityList;
    static List<Business> businessList;
    static List<User> userList;

    boolean isUpdate = false;

    static {
        activityList = new ArrayList<>();
        businessList = new ArrayList<>();
        userList = new ArrayList<>();
    }

    @Override
    public boolean checkUser(ContentValues values) {
        User user = Tools.ContentValuesToUser(values);
        for (User item : userList) {
            if (item.getId() == user.getId() && item.getPassword().equals(user.getPassword()))
                return true;
        }

        return false;
    }

    @Override
    public long addActivity(ContentValues values) {
        Activity activity = Tools.ContentValuesToActivity(values);
        activityList.add(activity);
        return activity.getId();
    }

    @Override
    public long addBusiness(ContentValues values) {
        Business business = Tools.ContentValuesToBusiness(values);
        businessList.add(business);
        return business.getId();
    }

    @Override
    public long addUser(ContentValues values) {
        User user = Tools.ContentValuesToUser(values);
        userList.add(user);
        return user.getId();
    }

    @Override
    public boolean removeActivity(long id) {
        Activity activityToRemove = null;
        for (Activity item : activityList)
            if (item.getId() == id) {
                activityToRemove = item;
                break;
            }
        return activityList.remove(activityToRemove);
    }

    @Override
    public boolean removeBusiness(long id) {
        Business businessToRemove = null;
        for (Business item : businessList)
            if (item.getId() == id) {
                businessToRemove = item;
                break;
            }
        return businessList.remove(businessToRemove);
    }

    @Override
    public boolean removeUser(long id) {
        User userToRemove = null;
        for (User item : userList)
            if (item.getId() == id) {
                userToRemove = item;
                break;
            }
        return userList.remove(userToRemove);
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

        if (isUpdate) {
            isUpdate = false;
            return true;
        }

        return false;


    }
}