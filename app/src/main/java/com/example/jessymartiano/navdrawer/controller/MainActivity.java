package com.example.jessymartiano.navdrawer.controller;


import android.content.Context;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.FrameLayout;

import com.example.jessymartiano.navdrawer.R;
import com.example.jessymartiano.navdrawer.backend.DBManagerFactory;
import com.example.jessymartiano.navdrawer.backend.DB_manager;
import com.example.jessymartiano.navdrawer.backend.Delegate;
import com.example.jessymartiano.navdrawer.backend.PublicObjects;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static DB_manager db;
    SearchView searchView;

    public static Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PublicObjects.start = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchView = (SearchView) findViewById(R.id.searchView);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(this);
        final View view = factory.inflate(R.layout.sample, null);
        alertadd.setView(view);
        alertadd.setTitle("Start");
        alertadd.setMessage("To Start Click on this Icon");
        alertadd.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {

            }
        });

        alertadd.show();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onQueryTextSubmit(String query) {
                Fragment current = getSupportFragmentManager().findFragmentByTag("buss");
                if (PublicObjects.BussFrag != null) {
                    //found it business
                    if (current != null) {
                        //resetting the list
                        //PublicObjects.BussFrag.updateView();
                        PublicObjects.BussFrag.clearFilter();
                        PublicObjects.BussFrag.Filter(query.toString());
                        return true;
                    }
                }
                if (PublicObjects.ActivityFrag != null) {
                     current = getSupportFragmentManager().findFragmentByTag("att");
                    if (current.getId() == PublicObjects.ActivityFrag.getId()) {
                        //resetting the list
                        //PublicObjects.ActivityFrag.updateView();
                        PublicObjects.ActivityFrag.clearFilter();
                        PublicObjects.ActivityFrag.Filter(query.toString());
                        return true;
                    }
                }
                Snackbar.make(searchView, "Please Select a category from the Notification Drawer", Snackbar.LENGTH_LONG);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    if (PublicObjects.currentFrag == PublicObjects.BussFrag && PublicObjects.BussFrag != null)
                        PublicObjects.BussFrag.clearFilter();
                    if (PublicObjects.currentFrag == PublicObjects.ActivityFrag && PublicObjects.ActivityFrag != null)
                        PublicObjects.ActivityFrag.clearFilter();
                }
                return true;
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ctx = this;
        db = DBManagerFactory.getManager();
        setUpDatabase(new Delegate() {
            @Override
            public void Do() {

            }
        });
    }

    /**
     * set up the database, call the contentresolver
     * @param func
     */
    public static void setUpDatabase(final Delegate func) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                db.setUpDatabase();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                func.Do();
            }
        }.execute();
    }

    /**
     * when the database is update by an account
     * the ui is refreshed
     */
    public static void updateDatabase() {
        setUpDatabase(new Delegate() {
            @Override
            public void Do() {
                updateUI();
            }
        });
    }

    /**
     * the fragment are refreshed
     */
    public static void updateUI() {
        android.support.v4.app.Fragment current = PublicObjects.currentFrag;
        //found it bussiness
        if (current != null && current == PublicObjects.BussFrag) {
            PublicObjects.BussFrag.updateView();
            return;
        }
        //activity
        if (current != null && current == PublicObjects.ActivityFrag) {
            PublicObjects.ActivityFrag.updateView();
            return;
        }

    }




    //region Navigation Drawer
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_container);

        try {
            if (id == R.id.nav_Business) {
                //open business fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, PublicObjects.getBusinessFragment(), "buss").commit();
                PublicObjects.currentFrag = PublicObjects.BussFrag;
            } else if (id == R.id.nav_activity) {
                //open activity fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, PublicObjects.getActivityFragment(), "att").commit();
                PublicObjects.currentFrag = PublicObjects.ActivityFrag;
            } else if (id == R.id.nav_exit) {
                finish();
            }
        } catch (Exception e) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion


}
