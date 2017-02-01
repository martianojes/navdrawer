package com.example.jessymartiano.navdrawer.backend;

import android.support.v4.app.Fragment;

import com.example.jessymartiano.navdrawer.ListFragmentActivity;
import com.example.jessymartiano.navdrawer.ListFragmentBusiness;
import com.example.jessymartiano.navdrawer.MainActivity;

/**
 * Created by David on 28/01/2017.
 * this class is being used to get the current instance of my fragment
 */

public class PublicObjects {
    /**
     *
     */
    public static MainActivity start = null;
    public static ListFragmentActivity AttFrag = null;
    public static ListFragmentBusiness BussFrag = null;
    public static Fragment currentFrag = null;

    public static ListFragmentActivity getActivityFragment(){
        if(AttFrag == null)
            AttFrag = new ListFragmentActivity();
        return AttFrag;
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
