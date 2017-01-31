package com.example.jessymartiano.navdrawer.entities;

/**
 * Created by jessymartiano on 30/11/2016.
 */

public enum enumActivities {
    Hotel("Hotel"),
    Travel("Travel"),
    Entertainment("Entertainment"),
    Airline("Airline");

    private String friendlyName;

    private enumActivities(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override public String toString(){
        return friendlyName;
    }
}

