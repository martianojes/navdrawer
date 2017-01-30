package com.example.jessymartiano.navdrawer.entities;

import com.example.jessymartiano.navdrawer.backend.AcademyContract;

import java.io.Serializable;

/**
 * Created by David on 30/11/2016.
 */

public class Business {


    public Business(int id, String name, String country, String street, String phone, String mail, String website) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.street = street;
        this.phone = phone;
        this.mail = mail;
        this.website = website;
    }

    public Business() {
    }

    public static String[] getColumns(){
        return new String[]{AcademyContract.Business.BUSINESS_ID,AcademyContract.Business.BUSINESS_NAME,
                AcademyContract.Business.BUSINESS_STREET,AcademyContract.Business.BUSINESS_MAIL,
                AcademyContract.Business.BUSINESS_WEBSITE, AcademyContract.Business.BUSINESS_PHONE};
    }

    public String getValue(String Col) throws Exception {
        switch (Col){
            case AcademyContract.Business.BUSINESS_ID:
                return String.valueOf(getId());
            case AcademyContract.Business.BUSINESS_STREET:
                return getStreet();
            case AcademyContract.Business.BUSINESS_MAIL:
                return getMail();
            case AcademyContract.Business.BUSINESS_NAME:
                return getName();
            case AcademyContract.Business.BUSINESS_WEBSITE:
                return getWebsite();
            case AcademyContract.Business.BUSINESS_PHONE:
                return getPhone();
            default:
                throw new Exception("Column doesn't Exist");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private int id;
    private String name;
    private String country;
    private String street;
    private String phone;
    private String mail;
    private String website;
}
