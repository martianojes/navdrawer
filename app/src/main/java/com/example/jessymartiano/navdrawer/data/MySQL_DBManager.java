package com.example.jessymartiano.navdrawer.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;

import com.example.jessymartiano.navdrawer.backend.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by mailo on 15/12/2016.
 */

public class MySQL_DBManager implements DB_manager {

    private final String UserName="martiano";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/";


    private boolean updateFlag = false;


    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }
    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }

    @Override
    public long addUser(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addUser.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addUser:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addUser Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addActivity(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addActivity.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addActivity:\n" +result);
            return id;
        } catch (IOException e) {
            printLog("addActivity:\n" +e);
        }
        return -1;
    }

    @Override
    public long addBusiness(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addBusiness.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addBusiness:\n" +result);
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public Cursor getUsers() {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]
                    {
                            AcademyContract.User.USER_ID,
                            AcademyContract.User.USER_USERNAME,
                            AcademyContract.User.USER_PASSWORD,
                    });
            String str = PHPtools.GET(WEB_URL + "/users.php");
            JSONArray array = new JSONObject(str).getJSONArray("users");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getInt(AcademyContract.User.USER_ID),
                        jsonObject.getString(AcademyContract.User.USER_USERNAME),
                        jsonObject.getString(AcademyContract.User.USER_PASSWORD)
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cursor getActivities() {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]
                    {
                            AcademyContract.Activity.ACTIVITY_ID,
                            AcademyContract.Activity.ACTIVITY_TYPE,
                            AcademyContract.Activity.ACTIVITY_COUNTRY,
                            AcademyContract.Activity.ACTIVITY_BEGIN,
                            AcademyContract.Activity.ACTIVITY_END,
                            AcademyContract.Activity.ACTIVITY_PRICE,
                            AcademyContract.Activity.ACTIVITY_EXPLANATION
                    });
            String str = PHPtools.GET(WEB_URL + "/activities.php");
            JSONArray array = new JSONObject(str).getJSONArray("activities");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getInt(AcademyContract.Activity.ACTIVITY_ID),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_TYPE),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_COUNTRY),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_BEGIN),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_END),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_PRICE),
                        jsonObject.getString(AcademyContract.Activity.ACTIVITY_EXPLANATION)
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cursor getBusinesses() {
        String[] columns = new String[]
                {
                        AcademyContract.Business.BUSINESS_ID,
                        AcademyContract.Business.BUSINESS_NAME,
                        AcademyContract.Business.BUSINESS_COUNTRY,
                        AcademyContract.Business.BUSINESS_STREET,
                        AcademyContract.Business.BUSINESS_PHONE,
                        AcademyContract.Business.BUSINESS_MAIL,
                        AcademyContract.Business.BUSINESS_WEBSITE

                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);
        try {
            String str = PHPtools.GET(WEB_URL + "/business.php");
            JSONArray array = new JSONObject(str).getJSONArray("business");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getInt(AcademyContract.Business.BUSINESS_ID),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_NAME),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_COUNTRY),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_STREET),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_PHONE),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_MAIL),
                        jsonObject.getString(AcademyContract.Business.BUSINESS_WEBSITE)
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public Cursor getActivitiesBusiness(){
        return null;
    }

    @Override
    public boolean removeUser(long id) {
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
    public boolean updateBusiness(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean checkUser(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/getUser.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addActivitiesBusiness:\n" +result);
            return true;
        } catch (IOException e) {
            printLog("addActivitiesBusiness:\n" +e);
        }
        return false;
    }

    @Override
    public boolean updateActivity(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateUser(long id, ContentValues values) {
        return false;
    }


    private void SetUpdate()
    {
        updateFlag = true;
    }

    @Override
    public boolean isUpdate() {
        if(updateFlag)
        {
            updateFlag=false;
            return  true;
        }

        return  false;
    }


}