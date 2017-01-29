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

public class Activity implements Serializable {
    private enumActivities type;
    private String country;
    private String beginning;
    private String end;
    private float price;
    private String explanation;
    private int id;
    private int businessid;


    public Activity(){

    }

    public static String[] getColumns(){
        return new String[]{AcademyContract.Activity.ACTIVITY_TYPE,AcademyContract.Activity.ACTIVITY_COUNTRY,
                AcademyContract.Activity.ACTIVITY_BEGIN,AcademyContract.Activity.ACTIVITY_END,
                AcademyContract.Activity.ACTIVITY_PRICE,AcademyContract.Activity.ACTIVITY_EXPLANATION,
                AcademyContract.Activity.ACTIVITY_BUSINESS_ID,AcademyContract.Activity.ACTIVITY_ID};
    }

    public String getValue(String Col) throws Exception {
        switch (Col){
            case AcademyContract.Activity.ACTIVITY_BUSINESS_ID:
                return String.valueOf(getBusinessid());
            case AcademyContract.Activity.ACTIVITY_TYPE:
                return getType().toString();
            case AcademyContract.Activity.ACTIVITY_COUNTRY:
                return getCountry();
            case AcademyContract.Activity.ACTIVITY_BEGIN:
                return getBeginning();
            case AcademyContract.Activity.ACTIVITY_END:
                return getEnd();
            case AcademyContract.Activity.ACTIVITY_PRICE:
                return String.valueOf(getPrice());
            case AcademyContract.Activity.ACTIVITY_EXPLANATION:
                return getExplanation();
            case AcademyContract.Activity.ACTIVITY_ID:
                return String.valueOf(getId());
            default:
                throw new Exception("Error ! Column doesn't Exist");
        }
    }

    public Activity(enumActivities type, String country, String beginning, String end, float price, String explanation, int id , int businessid) {
        this.type = type;
        this.country = country;
        this.beginning = beginning;
        this.end = end;
        this.price = price;
        this.explanation = explanation;
        this.id = id;
        this.businessid=businessid;
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
