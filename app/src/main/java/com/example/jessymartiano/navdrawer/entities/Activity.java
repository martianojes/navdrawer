package com.example.jessymartiano.navdrawer.entities;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by jessymartiano on 30/11/2016.
 */

public class Activity {
    private enumActivities type;
    private String country;
    private String beginning;
    private String end;
    private float price;
    private String explanation;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    private int businessid;


    public Activity(){

    }

    public Activity(enumActivities type, String country, String beginning, String end, float price, String explanation, int id , int businessid, String name) {
        this.type = type;
        this.country = country;
        this.beginning = beginning;
        this.end = end;
        this.price = price;
        this.explanation = explanation;
        this.id = id;
        this.businessid=businessid;
        this.name = name;
    }


    public enumActivities getType() {
        return type;
    }

    public void setType(enumActivities type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getBusinessid() {
        return businessid;
    }

    public void setBusinessid(int businessid) {
        this.businessid = businessid;
    }
}
