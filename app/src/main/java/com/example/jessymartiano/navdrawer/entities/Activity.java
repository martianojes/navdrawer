package com.example.jessymartiano.navdrawer.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by jessymartiano on 30/11/2016.
 */

public class Activity {
    private enumActivities type;
    private String country;
    private Date beginning;
    private Date end;
    private float price;
    private String explanation;
    private int id;


    public Activity(){

    }

    public Activity(enumActivities type, String country, Date beginning, Date end, float price, String explanation, int id) {
        this.type = type;
        this.country = country;
        this.beginning = beginning;
        this.end = end;
        this.price = price;
        this.explanation = explanation;
        this.id = id;
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

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public void setBeginning(String beginning) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(beginning);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setEnd(String end) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(end);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
}
