package com.example.devoprakesh.trackingapp;

public class UserData {

    String name;
    String phonenumber;

    public UserData(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
