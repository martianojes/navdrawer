package com.example.jessymartiano.navdrawer.entities;

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
