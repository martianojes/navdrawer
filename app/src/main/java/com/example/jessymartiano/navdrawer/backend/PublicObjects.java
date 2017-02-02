package com.example.jessymartiano.navdrawer.backend;

import android.support.v4.app.Fragment;

import com.example.jessymartiano.navdrawer.controller.ListFragmentActivity;
import com.example.jessymartiano.navdrawer.controller.ListFragmentBusiness;
import com.example.jessymartiano.navdrawer.controller.MainActivity;

/**
 * Created by David on 28/01/2017.
 * this class is being used to get the current instance of my fragment
 */

public class PublicObjects {
    /**
     *
     */
    public static MainActivity start = null;
    public static ListFragmentActivity ActivityFrag = null;
    public static ListFragmentBusiness BussFrag = null;
    public static Fragment currentFrag = null;

    public static ListFragmentActivity getActivityFragment(){
        if(ActivityFrag == null)
            ActivityFrag = new ListFragmentActivity();
        return ActivityFrag;
    }
    public static ListFragmentBusiness getBusinessFragment(){
        if(BussFrag == null)
            BussFrag = new ListFragmentBusiness();
        return BussFrag;
    }
    public static Fragment getCurrentFrag(){
        return currentFrag;
    }
}
