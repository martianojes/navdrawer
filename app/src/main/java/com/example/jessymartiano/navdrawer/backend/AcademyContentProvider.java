package com.example.jessymartiano.navdrawer.backend;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class AcademyContentProvider extends ContentProvider {
    public AcademyContentProvider() {
    }

    DB_manager manager = DBManagerFactory.getManager();
    final String TAG = "academyContent";

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "delete" + uri.toString());

        String listName = uri.getLastPathSegment();
        long id = ContentUris.parseId(uri);
        switch (listName) {
            case "activity":
                if (manager.removeActivity(id))
                    return 1;
                break;

            case "business":
                if (manager.removeBusiness(id))
                    return 1;
                break;

            case "user":
                if(manager.removeUser(id))
                    return 1;
                break;
        }
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType" + uri.toString());
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG, "insert " + uri.toString());

        String listName = uri.getLastPathSegment();
        long id = -1;
        switch (listName) {
            case "activity":
                id = manager.addActivity(values);
                return ContentUris.withAppendedId(uri, id);


            case "business":
                id = manager.addBusiness(values);
                return ContentUris.withAppendedId(uri, id);

            case "user":
                id = manager.addUser(values);
                return ContentUris.withAppendedId(uri, id);

        }
        return null;
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate");

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "query" + uri.toString());

        String listName = uri.getLastPathSegment();
        // String s = AcademyContract.Student.STUDENT_URI.getLastPathSegment();
        switch (listName) {
            case "activity":
                return manager.getActivities();//

            case "business":
                return manager.getBusinesses();//

            case "activityBusiness":
                return manager.getActivitiesBusiness();//


        }
        return null;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.d(TAG, "update" + uri.toString());

        String listName = uri.getLastPathSegment();
        long id = ContentUris.parseId(uri);
        int indexToUpdate = -1;
        switch (listName) {
            case "activity":
                if (manager.updateActivity(id, values))
                    return 1;
                break;

            case "business":
                if (manager.updateBusiness(id, values))
                    return 1;
                break;

            case "user":
                if (manager.updateUser(id, values))
                    return 1;
                break;
        }

        return 0;
    }
}
