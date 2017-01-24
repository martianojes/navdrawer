package com.example.jessymartiano.navdrawer;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.SimpleCursorAdapter;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;

import static com.example.jessymartiano.navdrawer.R.layout.list_row;

/**
 * Created by jessymartiano on 19/01/2017.
 */

public class ActivityList extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setListAdapter();
        final SimpleCursorAdapter adapter = new SimpleCursorAdapter
                (
                         this,
                        list_row,
                        null,
                        new String[]{AcademyContract.Activity.ACTIVITY_TYPE, AcademyContract.Activity.ACTIVITY_ID},
                        new int[]{R.id.typeActivity, R.id.country}
                );

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected Cursor doInBackground(Void... params) {
                Cursor cursor = getContentResolver().query(AcademyContract.Activity.ACTIVITY_URI, null, null, null, null);
                return cursor;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                adapter.changeCursor(cursor);
            }
        }.execute();
        this.setListAdapter(adapter);

    }

    ;
}
