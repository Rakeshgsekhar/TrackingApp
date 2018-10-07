package com.example.devoprakesh.trackingapp;

public class UserData {

    String name;
    Long phonenumber;

    public UserData(String name, Long phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
